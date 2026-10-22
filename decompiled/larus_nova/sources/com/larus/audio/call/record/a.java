package com.larus.audio.call.record;

import com.larus.audio.call.aec.w;
import com.larus.im.service.audio.AvAecType;
import com.larus.im.service.audio.n;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements v68.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f289559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super r58.d, ? super byte[], Unit> f289560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f289561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f289562d;

    /* JADX INFO: renamed from: com.larus.audio.call.record.a$a, reason: collision with other inner class name */
    public static final class C3966a {
    }

    public static final class b implements com.larus.im.service.audio.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f289563a;

        public b(a r100) {
            this.f289563a = r100;
        }

        @Override // com.larus.im.service.audio.g
        public final void a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            m r101 = this.f289563a.f289559a;
            if (r101 == null) goto L8;
            Function1<byte[], Unit> r102 = r101.f289606a;
            if (r102 == null) goto L9;
            r102.invoke(r100);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // v68.a
    public final void b(int r100) {
    }

    @Override // v68.a
    public final void c(long r100, Long r101) {
    }

    @Override // v68.a
    public final void e(Function0<Unit> r100) {
    }

    @Override // v68.a
    public final void f(Function2<? super String, ? super Long, Unit> r100) {
    }

    @Override // v68.a
    public final void g(Function2<? super Boolean, ? super String, Unit> r100) {
    }

    @Override // v68.a
    public final w h() {
        return null;
    }

    @Override // v68.a
    public final void release() {
        com.larus.audio.call.util.e.f289645a.i("AVInnerRecordAdapter", "release");
        this.f289560b = null;
        if (CoroutineScopeKt.isActive(this.f289561c) == false) goto L5;
        CoroutineScopeKt.cancel$default(this.f289561c, null, 1, null);
    L5:
        this.f289562d.release();
    }

    @Override // v68.a
    public final void stopRecord() {
        com.larus.audio.call.util.e.f289645a.i("AVInnerRecordAdapter", "stopRecord");
        this.f289562d.stopCapture();
    }

    @Override // v68.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // v68.a
    public final void setBluetoothForceToMedia(boolean r100) {
        this.f289562d.setBluetoothForceToMedia(r100);
    }

    @Override // v68.a
    public final boolean start(Function1<? super Exception, Unit> r100) {
        com.larus.audio.call.util.e.f289645a.i("AVInnerRecordAdapter", "start");
        this.f289562d.startCapture();
        return true;
    }

    @Override // v68.a
    public final void d(v58.a r100, Function2<? super r58.d, ? super byte[], Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onAudioDataReceived");
        com.larus.audio.call.util.e.f289645a.i("AVInnerRecordAdapter", "init");
        this.f289560b = r101;
        n r102 = this.f289562d;
        if ((r102 instanceof com.larus.im.service.audio.f) == false) goto L5;
        ((com.larus.im.service.audio.f) r102).a(new b(this));
    L5:
        this.f289562d.setup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.larus.audio.call.record.AVInnerRecordAdapter$linkAudioRecorder$1] */
    public a(id9.d r100, AvAecType r101, final Function0 r102, int r103, m r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = 1;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "aecType");
        Intrinsics.checkNotNullParameter(r102, "appendExtra");
        this.f289559a = r104;
        this.f289561c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(new com.larus.audio.call.record.b(CoroutineExceptionHandler.Key)));
        this.f289562d = r100.c(r103, r101, new AVInnerRecordAdapter$linkAudioRecorder$1(this, r102));
    }
}
