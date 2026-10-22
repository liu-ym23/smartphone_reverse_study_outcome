package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.OverrideUIMoreItemFactory;
import com.bytedance.ee.util.info.AppInfoUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class EditionDocMoreProvider extends BaseMoreProvider {
    public final DocumentPluginHost m;
    public final wj5.a n;
    public final c25.b o;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new EditionDocMoreProvider$buildMoreItems$1(this));
    }

    private final FragmentActivity getActivity() {
        return f().getHostFragment().getActivity();
    }

    public final void d() {
        super/*com.bytedance.ee.bear.more.protocol3.extension.v*/.d();
        k(this.n);
    }

    public static final /* synthetic */ FragmentActivity m(EditionDocMoreProvider r0) {
        return r0.getActivity();
    }

    public EditionDocMoreProvider(DocumentPluginHost r2, wj5.a r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "moreInfoBehavior");
        this.m = r2;
        this.n = r3;
        this.o = new c25.b();
    }

    public final void a(sj5.b r4, com.bytedance.ee.bear.more.protocol3.l r5) {
        OverrideUIMoreItemFactory r6 = com.bytedance.ee.bear.more.view3.d.a;
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r6, "uiItemFactory");
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        tt5.a.h("EditionDocMoreProvider", "shouldUseDoubaoStyle, enable=" + r0);
        if (r0 == false) goto L13;
        r6 = new OverrideUIMoreItemFactory(new com.bytedance.ee.bear.more.protocol3.panel.e(), EditionDocMoreProvider$attachToHost$effectiveFactory$1.INSTANCE);
        ItemUIStyle r1 = ItemUIStyle.DOUBAO;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r6.d = r1;
    L13:
        super/*com.bytedance.ee.bear.more.protocol3.h*/.a(r4, r6);
        return;
    L5:
        if (CCMOfficeSDKAssembleFG.b() == false) goto L9;
        if (com.bytedance.ee.bear.more.protocol3.panel.y.a == false) goto L9;
        r0 = true;
        goto L10
    }
}
