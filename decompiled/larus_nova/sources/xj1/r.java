package xj1;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements as0.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f564084a;

    public r(q r100) {
        this.f564084a = r100;
    }

    @Override // as0.c.a
    public final void a(int r100) {
        q r101 = this.f564084a;
        ILivePlayerClient r102 = ((yj1.a) r101.f526494a).f568057d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        q.z(r101);
        return;
    L7:
        if (r100 != 2) goto L16;
        r102.mute("RoomPlayerBusiness.onPhoneStateChangeListener");
        gs0.c r103 = ((yj1.a) this.f564084a.f526494a).f568056c;
        if (r103 == null) goto L14;
        r103.HI(true);
        return;
    L14:
        return;
    }

    @Override // as0.c.a
    public final void onModeChanged(int r100) {
        q r101 = this.f564084a;
        ILivePlayerClient r102 = ((yj1.a) r101.f526494a).f568057d;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        q.z(r101);
        return;
    L7:
        if (r100 != 1) goto L9;
    L13:
        r102.mute("RoomPlayerBusiness.onModeChanged");
        gs0.c r103 = ((yj1.a) this.f564084a.f526494a).f568056c;
        if (r103 == null) goto L18;
        r103.HI(true);
        return;
    L18:
        return;
    L9:
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L13;
    }
}
