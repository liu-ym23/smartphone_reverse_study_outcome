package ed9;

import com.heytap.mcssdk.constant.b;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f472233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472236d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f472233a == r101.f472233a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472234b, r101.f472234b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f472235c, r101.f472235c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f472236d, r101.f472236d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f472233a * 31) + this.f472234b.hashCode()) * 31) + this.f472235c.hashCode()) * 31) + this.f472236d.hashCode();
    }

    public final String toString() {
        return "FrontierConfig(productId=" + this.f472233a + ", appKey=" + this.f472234b + ", did=" + this.f472235c + ", url=" + this.f472236d + ')';
    }

    public final boolean a() {
        boolean r100 = true;
        if (this.f472233a > 0) goto L5;
    L20:
        boolean r101 = false;
    L21:
        if (r101 == true) goto L48;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("Not connectable now. ");
        String r104 = "";
        if (this.f472233a > 0) goto L47;
        StringBuilder r105 = new StringBuilder("productId=");
        r105.append(this.f472233a);
        r105.append(". ");
        if (this.f472234b.length() <= 0) goto L28;
        boolean r106 = true;
    L29:
        if (r106 == true) goto L46;
        StringBuilder r107 = new StringBuilder("appKey empty. ");
        if (this.f472235c.length() <= 0) goto L34;
        boolean r108 = true;
    L35:
        if (r108 == true) goto L45;
        StringBuilder r109 = new StringBuilder("did=");
        r109.append(this.f472235c);
        r109.append(". ");
        if (this.f472236d.length() > 0) goto L41;
        r100 = false;
    L41:
        if (r100 == true) goto L44;
        r104 = "url=" + this.f472236d;
    L44:
        r109.append(r104);
        r104 = r109.toString();
    L45:
        r107.append(r104);
        r104 = r107.toString();
        goto L46
    L34:
        r108 = false;
    L46:
        r105.append(r104);
        r104 = r105.toString();
        goto L47
    L28:
        r106 = false;
    L47:
        r103.append(r104);
        r102.d("FrontierConfig", r103.toString());
    L48:
        return r101;
    L5:
        if (this.f472234b.length() <= 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == false) goto L20;
        if (this.f472235c.length() <= 0) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == false) goto L20;
        if (this.f472236d.length() <= 0) goto L17;
        boolean r112 = true;
    L18:
        if (r112 == false) goto L20;
        r101 = true;
        goto L21
    L17:
        r112 = false;
        goto L18
    L12:
        r111 = false;
        goto L13
    L7:
        r110 = false;
        goto L8
    }

    public a(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, b.f276376z);
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f472233a = r100;
        this.f472234b = r101;
        this.f472235c = r102;
        this.f472236d = r103;
    }
}
