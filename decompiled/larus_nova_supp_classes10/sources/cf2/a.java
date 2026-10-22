package cf2;

import af2.b;
import af2.c;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.IBattleBarConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final long a;
    public final String b;
    public final String c;
    public final b d;
    public final IBaseUser e;
    public final IBattleBarConfig f;
    public final String g;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        b r0 = this.d;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        IBaseUser r4 = this.e;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        IBattleBarConfig r7 = this.f;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.g;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleScoreWrapper(battleScore=" + this.d + ", fromUser=" + this.e + ", battleBarConfig=" + this.f + ", fromUserId=" + this.g + ")";
    }

    public a(b r2, IBaseUser r3, IBattleBarConfig r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "battleScore");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = c.b(r2);
        this.b = r2.getScoreText();
        this.c = c.a(r2);
        r2.isHugeRewardPk();
        r2.getNewScoreOpen();
    }
}
