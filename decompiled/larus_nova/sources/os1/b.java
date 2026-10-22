package os1;

import com.bytedance.android.livesdk.config.cv;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.android.livesdkapi.distribution.config.OrientationAction;
import com.bytedance.android.livesdkapi.distribution.config.ServiceAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static c b() {
        return cv.f119981a.getValue();
    }

    static {
    }

    public static boolean a(EXTERNAL_CONFIG_TYPE r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r102 = a.f526493a[r100.ordinal()];
        if (r102 != 1) goto L5;
        d r103 = b().e();
        if (r103 != null) goto L65;
        return false;
    L65:
        if (r103.a() == false) goto L101;
        if (r101 != null) goto L70;
    L87:
        return true;
    L70:
        switch(r101.hashCode()) {
            case -426274807: goto L85;
            case 3744723: goto L82;
            case 114203431: goto L79;
            case 1834031882: goto L76;
            case 2102464948: goto L73;
            default: goto L87;
        };
    L73:
        if (r101.equals(GestureAction.leftScroll) == false) goto L87;
        return r103.b();
    L76:
        if (r101.equals(GestureAction.upDownScroll) == false) goto L87;
        return r103.e();
    L79:
        if (r101.equals(GestureAction.longPress) == false) goto L87;
        return r103.c();
    L82:
        if (r101.equals(GestureAction.zoom) == false) goto L87;
        return r103.f();
    L85:
        if (r101.equals(GestureAction.rightScroll) == false) goto L87;
        return r103.d();
    L101:
        return false;
    L5:
        if (r102 == 2) goto L60;
        if (r102 != 3) goto L9;
        e r104 = b().f();
        if (r104 != null) goto L41;
        return false;
    L41:
        if (r104.c() == false) goto L94;
        if (r101 == null) goto L57;
        int r105 = r101.hashCode();
        if (r105 == (-2035066464)) goto L54;
        if (r105 != (-165568835)) goto L57;
        if (r101.equals(OrientationAction.gravitySensing) == false) goto L57;
        boolean r106 = r104.a();
    L92:
        return r106;
    L54:
        if (r101.equals(OrientationAction.orientationChange) == false) goto L57;
        r106 = r104.b();
    L57:
        return true;
    L94:
        return false;
    L9:
        if (r102 == 4) goto L36;
        if (r102 == 5) goto L13;
        return true;
    L13:
        f r107 = b().g();
        if (r107 != null) goto L17;
        return false;
    L17:
        if (r107.b() == false) goto L91;
        if (r101 == null) goto L33;
        int r108 = r101.hashCode();
        if (r108 == (-1434007100)) goto L30;
        if (r108 != 2123221204) goto L33;
        if (r101.equals(ServiceAction.uvService) == false) goto L33;
        boolean r109 = r107.c();
    L89:
        return r109;
    L30:
        if (r101.equals(ServiceAction.followService) == false) goto L33;
        r109 = r107.a();
    L33:
        return true;
    L91:
        return false;
    L36:
        return b().d();
    L60:
        return b().a();
    }
}
