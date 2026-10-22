package com.vivo.push.b;

/* JADX INFO: loaded from: classes41.dex */
public final class v extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f462265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462266b;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    public v() {
        super(20);
        this.f462265a = -1;
    }

    public final String f() {
        long r100 = this.f462265a;
        if (r100 != (-1)) goto L5;
        return null;
    L5:
        return String.valueOf(r100);
    }

    public final long e() {
        return this.f462265a;
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a("undo_msg_v1", this.f462265a);
        r100.a("undo_msg_type_v1", this.f462266b);
    }

    @Override // com.vivo.push.b.w, com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462265a = r100.b("undo_msg_v1", this.f462265a);
        this.f462266b = r100.b("undo_msg_type_v1", 0);
    }
}
