package p62;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.SecretChatInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f527866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecretChatInfo f527867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f527868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends User> f527869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public User f527870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f527871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends k> f527872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f527873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f527874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f527875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f527876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f527877l;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (this.f527866a == r101.f527866a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527867b, r101.f527867b) == true) goto L10;
        return false;
    L10:
        if (this.f527868c == r101.f527868c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527869d, r101.f527869d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f527870e, r101.f527870e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f527871f, r101.f527871f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527872g, r101.f527872g) == true) goto L20;
        return false;
    L20:
        if (this.f527873h == r101.f527873h) goto L22;
        return false;
    L22:
        if (this.f527874i == r101.f527874i) goto L24;
        return false;
    L24:
        if (this.f527875j == r101.f527875j) goto L26;
        return false;
    L26:
        if (this.f527876k == r101.f527876k) goto L28;
        return false;
    L28:
        if (this.f527877l == r101.f527877l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        boolean r100 = this.f527866a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        SecretChatInfo r104 = this.f527867b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        long r107 = this.f527868c;
        int r108 = (((r103 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        List<? extends User> r109 = this.f527869d;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        User r112 = this.f527870e;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f527871f;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        List<? extends k> r118 = this.f527872g;
        if (r118 == null) goto L24;
        r105 = r118.hashCode();
    L24:
        int r119 = (r117 + r105) * 31;
        long r120 = this.f527873h;
        int r121 = (((r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31) + this.f527874i) * 31;
        long r122 = this.f527875j;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        boolean r124 = this.f527876k;
        ?? r125 = r124;
        if (r124 == false) goto L27;
        r125 = 1;
    L27:
        int r126 = (r123 + r125) * 31;
        boolean r127 = this.f527877l;
        if (r127 == true) goto L32;
        r101 = r127;
    L32:
        return r126 + r101;
    L20:
        r116 = 0;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L12:
        r110 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "ChatChannelTrayInfo(isp2pStatus=" + this.f527866a + ", secretChatInfo=" + this.f527867b + ", channelId=" + this.f527868c + ", topUserList=" + this.f527869d + ", owner=" + this.f527870e + ", channelName=" + this.f527871f + ", channelAvatarThumb=" + this.f527872g + ", memberCount=" + this.f527873h + ", unreadCount=" + this.f527874i + ", lastChangeTimestamp=" + this.f527875j + ", isSelected=" + this.f527876k + ", isShowingReddot=" + this.f527877l + ")";
    }

    public a(boolean r100, SecretChatInfo r101, long r102, List r103, User r104, String r105, List r106, long r110, long r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r103, "topUserList");
        Intrinsics.checkNotNullParameter(r104, "owner");
        Intrinsics.checkNotNullParameter(r105, "channelName");
        this.f527866a = r100;
        this.f527867b = r101;
        this.f527868c = r102;
        this.f527869d = r103;
        this.f527870e = r104;
        this.f527871f = r105;
        this.f527872g = r106;
        this.f527873h = r110;
        this.f527874i = 0;
        this.f527875j = r111;
        this.f527876k = r112;
        this.f527877l = false;
    }
}
