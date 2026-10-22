package mj1;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.room.b f514138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ik1.c f514139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final yj1.a f514140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wh1.a f514141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj1.a f514142e;

    public b(com.bytedance.android.livesdk.room.b r100) {
        this.f514138a = r100;
        this.f514139b = jk1.a.c(r100);
        this.f514140c = jk1.a.f(r100);
        this.f514141d = jk1.a.e(r100);
        if (r100 != null) goto L5;
        dj1.a r101 = null;
    L6:
        this.f514142e = r101;
        return;
    L5:
        r101 = (dj1.a) r100.b("RoomDataConst_live_room_feed_back_context");
        goto L6
    }
}
