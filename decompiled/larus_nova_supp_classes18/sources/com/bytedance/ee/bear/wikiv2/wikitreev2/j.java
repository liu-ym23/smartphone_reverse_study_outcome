package com.bytedance.ee.bear.wikiv2.wikitreev2;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.route.RouteBean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    static {
    }

    @JvmStatic
    public static final void b(com.bytedance.ee.bear.wikiv2.searchv2.c r3, Bundle r4, int r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r3, "navigationData");
        tt5.a.h("WikiTreeActivityNavigationManager", "navigation open wiki tree activity");
        WikiTreeActivityContract r0 = new WikiTreeActivityContract();
        r0.setSpaceId(r3.a);
        r0.setDocumentName(r3.b);
        r0.setDocumentToken(r3.c);
        if (r4 == null) goto L5;
        r0.setPageMode(r4.getInt("EXTRA_PAGE_MODE", 2));
        r0.setCreateDocumentType(r4.getInt("createDocumentType", sbb.e.g.b));
        r0.setSrcToken(r4.getString("src_token"));
        r0.setSrcObjType(r4.getInt("src_obj_type", -1));
        r0.setSrcParentToken(r4.getString("src_parent_token"));
        r0.setSrcIsLock(r4.getInt("srcIsLock", -1));
        r0.setSrcSpaceId(r4.getString("src_space_id"));
        r0.setSrcTitle(r4.getString("title"));
        r0.setTriggerLocation(r4.getString("trigger_location"));
        r0.setSrcIsShortcut(r4.getBoolean("src_is_shortcut", false));
        r0.setSrcOriginWikiToken(r4.getString("src_origin_token"));
        r0.setSrcOriginSpaceId(r4.getString("src_origin_space_id"));
        r0.setSrcFileSize(r4.getLong("src_file_size", 0));
    L5:
        RouteBean r7 = new RouteBean();
        r7.a(r6);
        r7.q = RouteBean.DestStyle.FLOAT;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/wikiv2/treehome/activity", r7).o(WikiTreeActivityContract.class.getName(), r0).h(r4).k(r5).e();
    }

    @JvmStatic
    public static final void a(Context r2, Bundle r3, int r4, ce5.a r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "userComponentAbility");
        String r7 = dq5.j.a(r5);
        if (r7 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        tt5.a.k("WikiTreeActivityNavigationManager", "libraryId is null");
        return;
    L12:
        b(new com.bytedance.ee.bear.wikiv2.searchv2.c(r7, r2.getString(2131888790), ""), r3, r4, r6);
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
