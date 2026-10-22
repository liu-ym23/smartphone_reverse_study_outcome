package h31;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f483683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f483684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f483685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f483686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f483687e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (this.f483683a == r101.f483683a) goto L8;
        return false;
    L8:
        if (this.f483684b == r101.f483684b) goto L10;
        return false;
    L10:
        if (this.f483685c == r101.f483685c) goto L12;
        return false;
    L12:
        if (this.f483686d == r101.f483686d) goto L14;
        return false;
    L14:
        if (this.f483687e == r101.f483687e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        long r100 = this.f483683a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f483684b) * 31;
        boolean r102 = this.f483685c;
        ?? r103 = 1;
        ?? r104 = r102;
        if (r102 == false) goto L5;
        r104 = 1;
    L5:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f483686d;
        if (r106 == true) goto L10;
        r103 = r106;
    L10:
        return ((r105 + r103) * 31) + this.f483687e;
    }

    public final String toString() {
        return "InviteData(battleId=" + this.f483683a + ", inviteType=" + this.f483684b + ", afterPunish=" + this.f483685c + ", isOnceMore=" + this.f483686d + ", multiPkMode=" + this.f483687e + ")";
    }

    public e(long r100, @ILinkMicBattleInviteMessage.MultiInviteType int r101, boolean r102, boolean r103, int r104) {
        this.f483683a = r100;
        this.f483684b = r101;
        this.f483685c = r102;
        this.f483686d = r103;
        this.f483687e = r104;
    }
}
