package bx4;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final boolean b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        if (r4 != null) goto L7;
        return false;
    L7:
        return StringsKt.startsWith$default(r4, "fake_", false, 2, null);
    }

    @JvmStatic
    public static final String c(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "suffix");
        if (r2 == true) goto L6;
        r3 = null;
    L6:
        String r0 = "";
        if (r2 == true) goto L10;
        r4 = "";
    L10:
        StringBuilder r5 = new StringBuilder();
        if (r3 == null) goto L16;
        String r6 = OfflineDoc.DASH_DELIMITER.concat(r3);
        if (r6 == null) goto L16;
        r0 = r6;
    L16:
        r5.append(r0);
        r5.append(r4);
        return r5.toString();
    }

    @JvmStatic
    public static final String a(String r3, long r4, boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "ownerType");
        return "fake_" + r3 + c(r6, "w", "") + c(true, String.valueOf(r4), "") + c(r7, "ownerType", r8);
    }
}
