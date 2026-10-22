package sq5;

import android.os.Bundle;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.util.io.FileUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n {
    public static final SpaceSelectorBean a(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "title");
        if (r100 == null) goto L6;
        String r102 = r100.getString("src_origin_token");
        if (r102 == null) goto L6;
    L7:
        if (r100 == null) goto L12;
        String r103 = r100.getString("title");
        if (r103 == null) goto L12;
        r101 = r103;
    L12:
        if (r100 == null) goto L14;
        Integer r104 = Integer.valueOf(r100.getInt("src_obj_type"));
    L15:
        SpaceSelectorBean r105 = new SpaceSelectorBean();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r105.f229386b = r102;
        if (r104 == null) goto L18;
        int r106 = r104.intValue();
    L19:
        r105.f229385a = r106;
        r105.f229394j = false;
        r105.f229391g = true;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f229390f = r101;
        if (r104 != null) goto L23;
    L25:
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r105.f229389e = "";
    L26:
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r105.f229398n = "";
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r105.f229397m = "";
        return r105;
    L23:
        if (r104.intValue() != 12) goto L25;
        String r107 = FileUtils.C(r101);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f229389e = r107;
        goto L26
    L18:
        r106 = 0;
        goto L19
    L14:
        r104 = null;
    L6:
        r102 = "";
        goto L7
    }
}
