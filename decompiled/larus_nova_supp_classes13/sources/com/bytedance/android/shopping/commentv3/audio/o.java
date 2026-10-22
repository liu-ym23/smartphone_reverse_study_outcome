package com.bytedance.android.shopping.commentv3.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements l {
    public final /* synthetic */ n a;
    public final /* synthetic */ String b;
    public final /* synthetic */ n.a c;

    @Override // com.bytedance.android.shopping.commentv3.audio.l
    public final void onCompletion() {
        f.a.a(this.a, this.b, StopReason.PLAY_COMPLETE, null, null, 12);
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.l
    public final void onPrepared() {
        dm.a.a("CommentAudioPlayer").i("prepared, sliceId: " + this.b);
        h r0 = this.a.f;
        if (r0 == null) goto L5;
        r0.i();
    L5:
        this.c.b();
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.l
    public final void onError(int r8, String r9) {
        dm.a.a("CommentAudioPlayer").i("error, sliceId: " + this.b + ", code: " + r8 + ", msg: " + r9);
        this.c.a(r8, r9);
        f.a.a(this.a, this.b, StopReason.PLAY_ERROR, null, null, 12);
    }

    public o(n r1, String r2, n.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
