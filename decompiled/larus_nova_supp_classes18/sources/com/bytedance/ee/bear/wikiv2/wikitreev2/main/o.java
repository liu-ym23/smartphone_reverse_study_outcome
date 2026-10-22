package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.mt.protector.impl.UriProtector;
import iq5.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public static void c(a r5) {
        WikiSelectorBean r0 = new WikiSelectorBean();
        r0.d = r5.c;
        r0.e = r5.d;
        r0.a = r5.e;
        r0.b = r5.g;
        r0.c = r5.f;
        r0.l = r5.h;
        r0.f = r5.i;
        r0.i = r5.j;
        r0.j = r5.k;
        r0.g = r5.l;
        r0.k = r5.m;
        r0.n = r5.p;
        r0.o = r5.r;
        SelectorConfig r1 = new SelectorConfig();
        r1.c(SelectorType.WIKI_MAKE_COPY_TO);
        r1.d = true;
        r1.b(r5.getContext().getString(2131889808));
        r1.c = r5.q;
        int r2 = r5.n;
        r1.g = r2;
        td5.f r3 = new td5.f();
        r3.e = Integer.valueOf(r2);
        r3.g = r5.o;
        Fragment r4 = r5.a;
        if (r4 != null) goto L5;
    L7:
        y.a(null, r1, r3, null, r0);
        return;
    L5:
        if (r4.getActivity() == null) goto L7;
        y.b(r5.a, r1, r3, null, r0);
    }

    public static void d(b r5) {
        WikiSelectorBean r0 = new WikiSelectorBean();
        r0.a = r5.c;
        r0.d = r5.e;
        r0.f = r5.d;
        r0.p = r5.h;
        r0.h = r5.f;
        r0.g = r5.g;
        r0.n = r5.k;
        r0.o = r5.l;
        r0.i = r5.m;
        r0.j = r5.n;
        SelectorConfig r1 = new SelectorConfig();
        r1.c(SelectorType.WIKI_MOVE_TO);
        r1.d = true;
        r1.b(r5.getContext().getString(2131889814));
        int r2 = r5.i;
        r1.g = r2;
        td5.f r3 = new td5.f();
        r3.e = Integer.valueOf(r2);
        r3.g = r5.j;
        Fragment r4 = r5.a;
        if (r4 != null) goto L5;
    L7:
        y.a(null, r1, r3, null, r0);
        return;
    L5:
        if (r4.getActivity() == null) goto L7;
        y.b(r5.a, r1, r3, null, r0);
    }

    public static void e(d r5) {
        WikiSelectorBean r0 = new WikiSelectorBean();
        r0.d = r5.c;
        r0.e = r5.d;
        r0.l = r5.e;
        r0.i = r5.f;
        r0.j = r5.g;
        r0.g = r5.h;
        r0.n = r5.k;
        r0.o = r5.l;
        SelectorConfig r1 = new SelectorConfig();
        r1.c(SelectorType.WIKI_SHORTCUT_TO);
        r1.d = true;
        r1.b(r5.getContext().getString(2131889790));
        r1.g = r5.i;
        qc5.a.j();
        r1.a(SelectorScope.ALL);
        td5.f r2 = new td5.f();
        r2.e = Integer.valueOf(r5.i);
        r2.g = r5.j;
        Fragment r3 = r5.a;
        if (r3 != null) goto L5;
    L7:
        y.a(null, r1, r2, null, r0);
        return;
    L5:
        if (r3.getActivity() == null) goto L7;
        y.b(r5.a, r1, r2, null, r0);
    }

    public static String[] g(Intent r5) {
        if (r5 == null) goto L11;
        String r0 = r5.getStringExtra("src_token");
        String r1 = r5.getStringExtra("space_id");
        String r2 = r5.getStringExtra("dest_token");
        String r6 = r5.getStringExtra("space_name");
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (TextUtils.isEmpty(r2) == true) goto L11;
        return new String[]{r0, r1, r2, r6};
    L11:
        tt5.a.h("Wiki_WikiNavigator", "parseShortcutToResult, return null. ");
        return null;
    }

    public static void f(Fragment r2, Bundle r3) {
        td5.f r0 = new td5.f();
        r0.e = Integer.valueOf(DocUserPermission.USER_PERM_FULL_ACCESS);
        r0.g = r3;
        if (r2 != null) goto L5;
    L7:
        y.a(null, null, r0, null, null);
        return;
    L5:
        if (r2.getActivity() == null) goto L7;
        int r1 = y.a;
        Intrinsics.checkNotNullParameter(r2, "fragment");
        y.b(r2, null, r0, null, null);
    }

    public static void a(String r7, String r8, String r9, Bundle r10, Boolean r11) {
        b(r7, r8, r9, r10, r11, null, null);
    }

    public static void b(String r6, String r7, String r8, Bundle r9, Boolean r10, Fragment r11, String r12) {
        if (r6 == null) goto L5;
        if (r7 == null) goto L5;
        if (r8 == null) goto L5;
    L6:
        if (r9 == null) goto L8;
        String r0 = r9.getString("ccm_open_type");
    L9:
        if (r9 != null) goto L11;
    L13:
        String r1 = "pages";
    L14:
        String r13 = s45.p.a().J8(sbb.e.n.getType(), r8, r1, r0);
        if (yp5.c.h() == true) goto L17;
    L19:
        RouteBean r14 = new WikiRouteBean(null, -1, null, r6, r7);
        r14.n = r9;
        r14.o = r10.booleanValue();
        if (r11 == null) goto L22;
        r14.a(r11);
    L22:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r13, r14);
        return;
    L17:
        if (TextUtils.isEmpty(r12) == true) goto L19;
        r13 = UriProtector.parse(r13).buildUpon().appendQueryParameter("visible_space_id", r12).build().toString();
        goto L19
    L11:
        if (r9.getString("extra_from") == null) goto L13;
        r1 = r9.getString("extra_from");
        goto L14
    L8:
        r0 = "";
    L5:
        tt5.a.d("Wiki_WikiNavigator", "navigateToDetailPage failed ---- param contains null");
        goto L6
    }
}
