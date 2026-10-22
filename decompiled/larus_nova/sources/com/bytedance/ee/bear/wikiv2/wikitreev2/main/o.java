package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import iq5.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {
    public static void c(a r100) {
        WikiSelectorBean r101 = new WikiSelectorBean();
        r101.f241131d = r100.f241508c;
        r101.f241132e = r100.f241509d;
        r101.f241128a = r100.f241510e;
        r101.f241129b = r100.f241512g;
        r101.f241130c = r100.f241511f;
        r101.f241139l = r100.f241513h;
        r101.f241133f = r100.f241514i;
        r101.f241136i = r100.f241515j;
        r101.f241137j = r100.f241516k;
        r101.f241134g = r100.f241517l;
        r101.f241138k = r100.f241518m;
        r101.f241141n = r100.f241521p;
        r101.f241142o = r100.f241523r;
        SelectorConfig r102 = new SelectorConfig();
        r102.c(SelectorType.WIKI_MAKE_COPY_TO);
        r102.f229372d = true;
        r102.b(r100.getContext().getString(R.string.LarkCCM_Wiki_MoveACopyTo_Header_Mob));
        r102.f229371c = r100.f241522q;
        int r103 = r100.f241519n;
        r102.f229375g = r103;
        td5.f r104 = new td5.f();
        r104.f545520e = Integer.valueOf(r103);
        r104.f545522g = r100.f241520o;
        Fragment r105 = r100.f241506a;
        if (r105 != null) goto L5;
    L7:
        y.a(null, r102, r104, null, r101);
        return;
    L5:
        if (r105.getActivity() == null) goto L7;
        y.b(r100.f241506a, r102, r104, null, r101);
    }

    public static void d(b r100) {
        WikiSelectorBean r101 = new WikiSelectorBean();
        r101.f241128a = r100.f241526c;
        r101.f241131d = r100.f241528e;
        r101.f241133f = r100.f241527d;
        r101.f241143p = r100.f241531h;
        r101.f241135h = r100.f241529f;
        r101.f241134g = r100.f241530g;
        r101.f241141n = r100.f241534k;
        r101.f241142o = r100.f241535l;
        r101.f241136i = r100.f241536m;
        r101.f241137j = r100.f241537n;
        SelectorConfig r102 = new SelectorConfig();
        r102.c(SelectorType.WIKI_MOVE_TO);
        r102.f229372d = true;
        r102.b(r100.getContext().getString(R.string.LarkCCM_Wiki_MoveTo_Header_Mob));
        int r103 = r100.f241532i;
        r102.f229375g = r103;
        td5.f r104 = new td5.f();
        r104.f545520e = Integer.valueOf(r103);
        r104.f545522g = r100.f241533j;
        Fragment r105 = r100.f241524a;
        if (r105 != null) goto L5;
    L7:
        y.a(null, r102, r104, null, r101);
        return;
    L5:
        if (r105.getActivity() == null) goto L7;
        y.b(r100.f241524a, r102, r104, null, r101);
    }

    public static void e(d r100) {
        WikiSelectorBean r101 = new WikiSelectorBean();
        r101.f241131d = r100.f241549c;
        r101.f241132e = r100.f241550d;
        r101.f241139l = r100.f241551e;
        r101.f241136i = r100.f241552f;
        r101.f241137j = r100.f241553g;
        r101.f241134g = r100.f241554h;
        r101.f241141n = r100.f241557k;
        r101.f241142o = r100.f241558l;
        SelectorConfig r102 = new SelectorConfig();
        r102.c(SelectorType.WIKI_SHORTCUT_TO);
        r102.f229372d = true;
        r102.b(r100.getContext().getString(R.string.LarkCCM_Wiki_AddShortcutTo_Header_Mob));
        r102.f229375g = r100.f241555i;
        qc5.a.j();
        r102.a(SelectorScope.ALL);
        td5.f r103 = new td5.f();
        r103.f545520e = Integer.valueOf(r100.f241555i);
        r103.f545522g = r100.f241556j;
        Fragment r104 = r100.f241547a;
        if (r104 != null) goto L5;
    L7:
        y.a(null, r102, r103, null, r101);
        return;
    L5:
        if (r104.getActivity() == null) goto L7;
        y.b(r100.f241547a, r102, r103, null, r101);
    }

    public static String[] g(Intent r100) {
        if (r100 == null) goto L11;
        String r101 = r100.getStringExtra("src_token");
        String r102 = r100.getStringExtra(DocViewModel.EXTRA_SPACE_ID);
        String r103 = r100.getStringExtra("dest_token");
        String r104 = r100.getStringExtra("space_name");
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (TextUtils.isEmpty(r102) == true) goto L11;
        if (TextUtils.isEmpty(r103) == true) goto L11;
        return new String[]{r101, r102, r103, r104};
    L11:
        tt5.a.h("Wiki_WikiNavigator", "parseShortcutToResult, return null. ");
        return null;
    }

    public static void f(Fragment r100, Bundle r101) {
        td5.f r102 = new td5.f();
        r102.f545520e = 1024;
        r102.f545522g = r101;
        if (r100 != null) goto L5;
    L7:
        y.a(null, null, r102, null, null);
        return;
    L5:
        if (r100.getActivity() == null) goto L7;
        int r103 = y.f495383a;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        y.b(r100, null, r102, null, null);
    }

    public static void a(String r100, String r101, String r102, Bundle r110, Boolean r111) {
        b(r100, r101, r102, r110, r111, null, null);
    }

    public static void b(String r100, String r101, String r102, Bundle r103, Boolean r110, Fragment r111, String r112) {
        if (r100 == null) goto L5;
        if (r101 == null) goto L5;
        if (r102 == null) goto L5;
    L6:
        if (r103 == null) goto L8;
        String r104 = r103.getString("ccm_open_type");
    L9:
        if (r103 != null) goto L11;
    L13:
        String r105 = "pages";
    L14:
        String r106 = s45.p.a().J8(sbb.e.f541303n.getType(), r102, r105, r104);
        if (yp5.c.h() == true) goto L17;
    L19:
        WikiRouteBean r113 = new WikiRouteBean(null, -1, null, r100, r101);
        r113.f236649n = r103;
        r113.f236650o = r110.booleanValue();
        if (r111 == null) goto L22;
        r113.a(r111);
    L22:
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r106, r113);
        return;
    L17:
        if (TextUtils.isEmpty(r112) == true) goto L19;
        r106 = UriProtector.parse(r106).buildUpon().appendQueryParameter("visible_space_id", r112).build().toString();
        goto L19
    L11:
        if (r103.getString("extra_from") == null) goto L13;
        r105 = r103.getString("extra_from");
        goto L14
    L8:
        r104 = "";
    L5:
        tt5.a.d("Wiki_WikiNavigator", "navigateToDetailPage failed ---- param contains null");
        goto L6
    }
}
