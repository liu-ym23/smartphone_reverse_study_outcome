package iq5;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 {
    static {
    }

    @JvmStatic
    public static final void a(Bundle r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "action");
        if (r8 == null) goto L5;
        SpaceSelectorBean r10 = (SpaceSelectorBean) r8.getParcelable("extra_space_bean");
    L6:
        HashMap r2 = new HashMap();
        String r3 = "";
        if (r10 == null) goto L10;
        String r4 = r10.m;
        if (r4 == null) goto L10;
    L11:
        r2.put("source", r4);
        if (r10 == null) goto L15;
        String r5 = r10.n;
        if (r5 == null) goto L15;
    L16:
        r2.put("module", r5);
        r2.put("action", r9);
        if (r10 == null) goto L19;
        int r6 = r10.a;
    L20:
        r2.put("file_type", sbb.e.c(r6));
        if (r10 == null) goto L23;
        String r7 = r10.b;
    L24:
        r2.put("file_id", du5.b.g(r7));
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r1.v("click_addto_operation", r2);
        if (TextUtils.equals(r9, "click_search_result") == false) goto L27;
    L28:
        if (r10 == null) goto L33;
        String r11 = r10.n;
        if (r11 == null) goto L33;
        r3 = r11;
    L33:
        Intrinsics.checkNotNullParameter(r1, "analyticService");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r9, "action");
        HashMap r12 = new HashMap();
        r12.put("source", r3);
        r12.put("action", r9);
        r1.v("click_search_filter_folder_operation", r12);
        return;
    L27:
        if (TextUtils.equals(r9, "click_recent_folder") == true) goto L28;
        return;
    L23:
        r7 = null;
        goto L24
    L19:
        r6 = sbb.e.e.b;
    L15:
        r5 = "";
    L10:
        r4 = "";
        goto L11
    L5:
        r10 = null;
        goto L6
    }
}
