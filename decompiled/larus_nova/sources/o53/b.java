package o53;

import com.bytedance.android.ec.core.utils.a2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f522096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f522097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f522098c;

    static {
        f522096a = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE;
        f522097b = "-1";
        f522098c = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE;
    }

    public static boolean a() {
        if (Intrinsics.areEqual(f522096a, com.bytedance.android.ec.core.event.a.VALUE_MIX_COMMENT) == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(f522096a, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE) == true) goto L12;
        if (Intrinsics.areEqual(f522096a, com.bytedance.android.ec.core.event.a.VALUE_SHOP_SAME_COMMENT) == true) goto L12;
        if (Intrinsics.areEqual(f522096a, "selected_comment") == true) goto L12;
        return false;
    }

    public static void b(int r100, int r101, String r102) {
        if (r101 != 0) goto L5;
        if (r100 != 0) goto L12;
        String r103 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE;
    L13:
        f522096a = r103;
        if (r102 == null) goto L19;
        String r104 = a2.d(r102);
        if (r104 == null) goto L19;
        f522096a = r104;
    L19:
        if (Intrinsics.areEqual(f522096a, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE) == false) goto L26;
        if (r101 != 2) goto L22;
    L25:
        f522097b = "1";
    L27:
        if (r100 != 0) goto L29;
        f522098c = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE;
        return;
    L29:
        f522098c = com.bytedance.android.ec.core.event.a.VALUE_SHOP_MODULE;
        return;
    L22:
        if (r101 == 3) goto L25;
        f522097b = "0";
        goto L27
    L26:
        f522097b = "-1";
        goto L27
    L12:
        r103 = com.bytedance.android.ec.core.event.a.VALUE_SHOP_MODULE;
        goto L13
    L5:
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L8;
        r103 = "selected_comment";
        goto L13
    L8:
        r103 = com.bytedance.android.ec.core.event.a.VALUE_MIX_COMMENT;
        goto L13
    L9:
        r103 = com.bytedance.android.ec.core.event.a.VALUE_SHOP_SAME_COMMENT;
        goto L13
    }
}
