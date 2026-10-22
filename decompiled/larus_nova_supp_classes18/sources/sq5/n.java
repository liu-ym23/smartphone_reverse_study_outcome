package sq5;

import android.os.Bundle;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.util.io.FileUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public static final SpaceSelectorBean a(Bundle r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "title");
        if (r5 == null) goto L6;
        String r2 = r5.getString("src_origin_token");
        if (r2 == null) goto L6;
    L7:
        if (r5 == null) goto L12;
        String r0 = r5.getString("title");
        if (r0 == null) goto L12;
        r6 = r0;
    L12:
        if (r5 == null) goto L14;
        Integer r7 = Integer.valueOf(r5.getInt("src_obj_type"));
    L15:
        SpaceSelectorBean r1 = new SpaceSelectorBean();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r1.b = r2;
        if (r7 == null) goto L18;
        int r4 = r7.intValue();
    L19:
        r1.a = r4;
        r1.j = false;
        r1.g = true;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r1.f = r6;
        if (r7 != null) goto L23;
    L25:
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r1.e = "";
    L26:
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r1.n = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r1.m = "";
        return r1;
    L23:
        if (r7.intValue() != 12) goto L25;
        String r8 = FileUtils.C(r6);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r1.e = r8;
        goto L26
    L18:
        r4 = 0;
        goto L19
    L14:
        r7 = null;
    L6:
        r2 = "";
        goto L7
    }
}
