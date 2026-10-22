package fy;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f479201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f479202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f479203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f479204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f479205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkerKickOutContent.KickOutSource f479206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f479207g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L20;
        g r101 = (g) r100;
        if (this.f479201a == r101.f479201a) goto L8;
        return false;
    L8:
        if (this.f479202b == r101.f479202b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f479203c, r101.f479203c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479204d, r101.f479204d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f479205e, r101.f479205e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f479206f, r101.f479206f) == true) goto L18;
        return false;
    L18:
        if (this.f479207g == r101.f479207g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f479201a * 31;
        long r101 = this.f479202b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f479203c;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f479204d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f479205e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        LinkerKickOutContent.KickOutSource r113 = this.f479206f;
        if (r113 == null) goto L17;
        r104 = r113.hashCode();
    L17:
        long r114 = this.f479207g;
        return ((r112 + r104) * 31) + ((int) (r114 ^ (r114 >>> 32)));
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "KickOutParams(scene=" + this.f479201a + ", channelId=" + this.f479202b + ", toUserId=" + this.f479203c + ", secToUserId=" + this.f479204d + ", reqSrc=" + this.f479205e + ", kickOutSource=" + this.f479206f + ", toRoomId=" + this.f479207g + ")";
    }

    public /* synthetic */ g(long r110, String r111, String r112, String r113, LinkerKickOutContent.KickOutSource r114, int r115) {
        if ((r115 & 32) == 0) goto L5;
        LinkerKickOutContent.KickOutSource r100 = LinkerKickOutContent.KickOutSource.General;
    L6:
        this(17, r110, r111, r112, r113, r100, 0);
        return;
    L5:
        r100 = r114;
        goto L6
    }

    public g(int r100, long r101, String r102, String r103, String r104, LinkerKickOutContent.KickOutSource r105, long r106) {
        Intrinsics.checkNotNullParameter(r104, "reqSrc");
        Intrinsics.checkNotNullParameter(r105, "kickOutSource");
        this.f479201a = r100;
        this.f479202b = r101;
        this.f479203c = r102;
        this.f479204d = r103;
        this.f479205e = r104;
        this.f479206f = r105;
        this.f479207g = r106;
    }
}
