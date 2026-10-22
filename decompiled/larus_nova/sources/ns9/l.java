package ns9;

import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachType;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReachType f520394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f520396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f520397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ReachRequestSource f520398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f520399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f520400h;

    public l() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f520393a, r101.f520393a) == true) goto L12;
        return false;
    L12:
        if (this.f520394b == r101.f520394b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520395c, r101.f520395c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520396d, r101.f520396d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520397e, r101.f520397e) == true) goto L24;
        return false;
    L24:
        if (this.f520398f == r101.f520398f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f520399g, r101.f520399g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f520393a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f520394b.hashCode()) * 31) + this.f520395c.hashCode()) * 31;
        String r104 = this.f520396d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f520397e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f520398f.hashCode()) * 31;
        List<Integer> r110 = this.f520399g;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachMeta(pushId=" + this.f520393a + ", type=" + this.f520394b + ", pushScene=" + this.f520395c + ", templateId=" + this.f520396d + ", toastLevel=" + this.f520397e + ", requestSource=" + this.f520398f + ", notificationGroup=" + this.f520399g + ')';
    }

    public final ReachType getType() {
        return this.f520394b;
    }

    public l(String r100, ReachType r101, String r102, String r103, String r104, ReachRequestSource r105, List r106, int r110) {
        String r107 = null;
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r110 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r110 & 32) == 0) goto L15;
        r105 = ReachRequestSource.SERVER_CMD;
    L15:
        if ((r110 & 64) == 0) goto L17;
        r106 = null;
    L17:
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "pushScene");
        Intrinsics.checkNotNullParameter(r105, "requestSource");
        this.f520393a = r100;
        this.f520394b = r101;
        this.f520395c = r102;
        this.f520396d = r103;
        this.f520397e = r104;
        this.f520398f = r105;
        this.f520399g = r106;
        if (r100 != null) goto L20;
    L23:
        r107 = UUID.randomUUID().toString();
    L24:
        this.f520400h = r107;
        return;
    L20:
        if ((!StringsKt.isBlank(r100)) == false) goto L22;
        r107 = r100;
    L22:
        if (r107 != null) goto L24;
        goto L23
    }
}
