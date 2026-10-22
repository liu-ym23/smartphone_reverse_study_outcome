package dv0;

import com.bytedance.android.live.profit.scoreboard.dto.r;
import com.bytedance.android.livesdk.message.model.k7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f470110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f470111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470113d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f470110a, r101.f470110a) == true) goto L8;
        return false;
    L8:
        if (this.f470111b == r101.f470111b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f470112c, r101.f470112c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470113d, r101.f470113d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // dv0.e
    public final k7 getEntranceInfo() {
        return this.f470110a.getEntranceInfo();
    }

    @Override // dv0.e
    public final r getExtra() {
        return this.f470110a.getExtra();
    }

    @Override // dv0.e
    public final String getMiniAppId() {
        return this.f470110a.getMiniAppId();
    }

    @Override // dv0.e
    public final long getRoundId() {
        return this.f470110a.getRoundId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        e r100 = this.f470110a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f470111b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f470112c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f470113d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Invitation(common=" + this.f470110a + ", isAuthRequired=" + this.f470111b + ", authDialogTitle=" + this.f470112c + ", authDialogMessage=" + this.f470113d + ")";
    }

    public f(i r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "common");
        Intrinsics.checkNotNullParameter(r102, "authDialogTitle");
        Intrinsics.checkNotNullParameter(r103, "authDialogMessage");
        this.f470110a = r100;
        this.f470111b = r101;
        this.f470112c = r102;
        this.f470113d = r103;
    }
}
