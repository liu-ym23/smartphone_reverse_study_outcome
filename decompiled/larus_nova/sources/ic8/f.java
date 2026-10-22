package ic8;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f489190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f489192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f489193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f489194f;

    public f() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f489189a, r101.f489189a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489190b, r101.f489190b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489191c, r101.f489191c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489192d, r101.f489192d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489193e, r101.f489193e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489194f, r101.f489194f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f489189a.hashCode() * 31;
        Message r101 = this.f489190b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f489191c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f489192d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f489193e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        r r114 = this.f489194f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AiEditFunctionParams(url=" + this.f489189a + ", message=" + this.f489190b + ", creationTaskId=" + this.f489191c + ", width=" + this.f489192d + ", height=" + this.f489193e + ", driveInfo=" + this.f489194f + ')';
    }

    public /* synthetic */ f(String r100, Message r101, String r110, Integer r111, Integer r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r100 = "";
    L5:
        String r102 = r100;
        if ((r113 & 2) == 0) goto L8;
        Message r103 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r104 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        Integer r105 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        Integer r106 = null;
    L21:
        this(r102, r103, r104, r105, r106, null);
        return;
    L20:
        r106 = r112;
        goto L21
    L16:
        r105 = r111;
        goto L18
    L12:
        r104 = r110;
        goto L14
    L8:
        r103 = r101;
        goto L10
    }

    public f(String r100, Message r101, String r102, Integer r103, Integer r104, r r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f489189a = r100;
        this.f489190b = r101;
        this.f489191c = r102;
        this.f489192d = r103;
        this.f489193e = r104;
        this.f489194f = r105;
    }
}
