package iq5;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 {
    static {
    }

    @JvmStatic
    public static final void a(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 == null) goto L5;
        SpaceSelectorBean r102 = (SpaceSelectorBean) r100.getParcelable("extra_space_bean");
    L6:
        HashMap r103 = new HashMap();
        String r104 = "";
        if (r102 == null) goto L10;
        String r105 = r102.f229397m;
        if (r105 == null) goto L10;
    L11:
        r103.put("source", r105);
        if (r102 == null) goto L15;
        String r106 = r102.f229398n;
        if (r106 == null) goto L15;
    L16:
        r103.put(EventConstant.Key.MODULE, r106);
        r103.put("action", r101);
        if (r102 == null) goto L19;
        int r107 = r102.f229385a;
    L20:
        r103.put("file_type", sbb.e.c(r107));
        if (r102 == null) goto L23;
        String r108 = r102.f229386b;
    L24:
        r103.put("file_id", du5.b.g(r108));
        com.bytedance.ee.bear.contract.d r109 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        r109.v("click_addto_operation", r103);
        if (TextUtils.equals(r101, "click_search_result") == false) goto L27;
    L28:
        if (r102 == null) goto L33;
        String r110 = r102.f229398n;
        if (r110 == null) goto L33;
        r104 = r110;
    L33:
        Intrinsics.checkNotNullParameter(r109, "analyticService");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "action");
        HashMap r111 = new HashMap();
        r111.put("source", r104);
        r111.put("action", r101);
        r109.v("click_search_filter_folder_operation", r111);
        return;
    L27:
        if (TextUtils.equals(r101, "click_recent_folder") == true) goto L28;
        return;
    L23:
        r108 = null;
        goto L24
    L19:
        r107 = sbb.e.f541294e.f541317b;
    L15:
        r106 = "";
    L10:
        r105 = "";
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
