package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m implements lc0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc0.o f518616a;

    @Override // lc0.c
    public final String a() {
        String r100 = this.f518616a.a();
        if (r100 != null) goto L6;
        return "0";
    L6:
        return r100;
    }

    @Override // lc0.c
    public final long getChannelId() {
        return this.f518616a.getChannelId();
    }

    @Override // lc0.c
    public final long getDuration() {
        return this.f518616a.getDuration();
    }

    @Override // lc0.c
    public final int getInviteType() {
        return this.f518616a.getInviteType();
    }

    @Override // lc0.c
    public final int getMatchType() {
        return this.f518616a.getMatchType();
    }

    @Override // lc0.c
    public final long getPkId() {
        return this.f518616a.getPkId();
    }

    @Override // lc0.c
    public final String u() {
        return this.f518616a.u();
    }

    @Override // lc0.c
    public final am2.l v() {
        kc0.o r100 = this.f518616a;
        Intrinsics.checkNotNullParameter(r100, "$this$getLinkCrossRoomLog");
        am2.l r101 = new am2.l();
        r101.f4293a = r100.getChannelId();
        r101.f4294b = r100.a();
        r101.f4295c = (int) r100.getDuration();
        r101.f4296d = r100.A();
        r101.f4297e = r100.getPkId();
        r101.f4300h = r100.B();
        r101.f4301i = r100.getRequestId();
        r101.a(Boolean.valueOf(r100.isOnceMore()));
        r101.f4298f = r100.getTheme();
        return r101;
    }

    @Override // lc0.c
    public final String w() {
        return this.f518616a.w();
    }

    @Override // lc0.c
    public final String x() {
        return this.f518616a.x();
    }

    @Override // lc0.c
    public final String y() {
        return this.f518616a.y();
    }

    @Override // lc0.c
    public final String z() {
        return this.f518616a.z();
    }

    public m(kc0.o r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518616a = r100;
    }
}
