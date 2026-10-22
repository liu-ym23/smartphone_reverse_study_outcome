package com.larus.audio.call.record;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f289570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f289571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f289572l;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final void release() {
        Handler r100 = this.f289571k;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        this.f289572l = true;
        this.f289570j.quit();
        this.f289571k = null;
        super.release();
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final void stopRecord() {
        Handler r100 = this.f289571k;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        super.stopRecord();
    }

    public e(boolean r100) {
        super(null, -1, r100);
        this.f289570j = new PthreadHandlerThreadV2("audio_record_operator_thread");
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final boolean start(final Function1<? super Exception, Unit> r100) {
        Runnable r101 = new d(this, r100);
        Thread r102 = null;
        if (ThreadMethodProxy.isAlive(this.f289570j) == false) goto L5;
        PthreadHandlerThreadV2 r103 = this.f289570j;
    L6:
        Handler r104 = this.f289571k;
        if (r104 != null) goto L13;
        if (r103 == null) goto L12;
        Looper r105 = r103.getLooper();
        if (r105 == null) goto L12;
        r104 = new Handler(r105);
    L12:
        r104 = null;
    L13:
        if (r104 != null) goto L15;
    L25:
        r101.run();
        return true;
    L15:
        if (this.f289572l == true) goto L25;
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r103 == null) goto L22;
        Looper r107 = r103.getLooper();
        if (r107 == null) goto L22;
        r102 = ThreadMethodProxy.getLooperThread(r107);
    L22:
        if (Intrinsics.areEqual(r106, r102) == true) goto L25;
        r104.post(r101);
        return true;
    L5:
        r103 = null;
        goto L6
    }

    public static void i(e r100, Function1 r101) {
        super.start(r101);
    }

    @Override // com.larus.audio.call.record.f, v68.a
    public final void d(v58.a r100, Function2<? super r58.d, ? super byte[], Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onAudioDataReceived");
        if (this.f289572l == false) goto L5;
    L7:
        Handler r102 = null;
        if (ThreadMethodProxy.isAlive(this.f289570j) == false) goto L10;
        PthreadHandlerThreadV2 r103 = this.f289570j;
    L11:
        if (r103 == null) goto L13;
        r102 = new Handler(r103.getLooper());
    L13:
        this.f289571k = r102;
        super.d(r100, r101);
        return;
    L10:
        r103 = null;
        goto L11
    L5:
        if (ThreadMethodProxy.isAlive(this.f289570j) == true) goto L7;
        ThreadMethodProxy.start(this.f289570j);
        goto L7
    }
}
