package com.ss.android.lark.audio.recorder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f409125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f409126b;

    @Override // com.ss.android.lark.audio.recorder.i
    public final void onStop() {
        this.f409126b.clear();
    }

    public g(int r100) {
        if (r100 > 0) goto L5;
        ByteBuffer r101 = ByteBuffer.allocateDirect(0);
    L6:
        this.f409126b = r101;
        return;
    L5:
        r101 = ByteBuffer.allocateDirect(r100);
        r101.order(ByteOrder.nativeOrder());
        goto L6
    }

    @Override // com.ss.android.lark.audio.recorder.i
    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioFrameDataContext");
        int r101 = this.f409126b.remaining() - r100.f409105f;
        if (r101 >= 0) goto L5;
        int r102 = -r101;
        int r103 = this.f409126b.remaining();
        byte[] r104 = new byte[r103];
        if (r100.f409100a.hasRemaining() == true) goto L11;
        r100.f409100a.rewind();
    L11:
        r100.f409100a.get(r104, 0, r103);
        this.f409126b.put(r104);
        p r105 = r100.f409101b;
        ByteBuffer r106 = this.f409126b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "pcmData");
        k r107 = r105.f409142h;
        if (r107 == null) goto L14;
        r107.h(r106);
    L14:
        this.f409125a = 0;
        byte[] r108 = new byte[r102];
        this.f409126b.rewind();
        r100.f409100a.get(r108, 0, r102);
        this.f409126b.put(r108);
        this.f409125a += r102;
        return;
    L5:
        if (r100.f409100a.hasRemaining() == true) goto L7;
        r100.f409100a.rewind();
    L7:
        this.f409126b.put(r100.f409100a);
        this.f409125a += r100.f409105f;
    }

    @Override // com.ss.android.lark.audio.recorder.i
    public final void b(a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audioFrameDataContext");
        if (this.f409125a <= 0) goto L12;
        if (r101 == true) goto L6;
    L7:
        this.f409126b.limit(this.f409125a);
        p r102 = r100.f409101b;
        ByteBuffer r103 = this.f409126b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "pcmData");
        k r104 = r102.f409142h;
        if (r104 == null) goto L10;
        r104.h(r103);
    L10:
        this.f409126b.clear();
        this.f409125a = 0;
        return;
    L6:
        if (idb.f.a().isEnable("op_client_api_audio_record_optimization_disable") == true) goto L7;
        return;
    }
}
