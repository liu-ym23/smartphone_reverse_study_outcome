package p52;

import com.bytedance.android.live.base.model.message.b4;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.r;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f527766a = 0;

    static {
    }

    public static String a(r r100) {
        String r101 = String.valueOf(r100.getType());
        String r102 = r100.getLabelText();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return r101 + "_" + r102;
    }

    public static String b(List r100) {
        List r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return null;
    L12:
        Iterator r103 = r100.iterator();
        String r104 = "";
    L14:
        if (r103.hasNext() == false) goto L22;
        r r105 = (r) r103.next();
        if (r104.length() != 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == true) goto L20;
        r104 = r104 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + a(r105);
        goto L14
    L20:
        r104 = r104 + a(r105);
        goto L14
    L18:
        r106 = false;
        goto L19
    L22:
        return r104;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean c(b4 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r100, "message");
        List<r> r102 = r100.G1();
        Object r103 = null;
        if (r102 == null) goto L14;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (((r) r105).getType() != r101) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L6;
        r103 = r105;
        goto L13
    L10:
        r106 = false;
    L13:
        r103 = (r) r103;
    L14:
        if (r103 == null) goto L22;
        return true;
    L22:
        return false;
    }
}
