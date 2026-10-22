package com.bytedance.ee.bear.more.itemv2.mainnav;

import android.view.View;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.k;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f234618e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wb5.d f234619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f234620d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.itemv2.mainnav.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3362b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f234621a;

        public ViewOnClickListenerC3362b(b r100) {
            this.f234621a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            final b r100 = this.f234621a;
            r100.getHost().a();
            vqb.a r101 = vqb.b.a();
            wb5.d r102 = r100.f234619c;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r100.f234620d == true) goto L49;
            oj5.c r103 = r100.c();
            String r104 = null;
            if (r103 == null) goto L11;
            DocUpgradeInfo r105 = r103.R();
            if (r105 == null) goto L11;
            Integer r106 = Integer.valueOf(r105.getStatus());
        L12:
            oj5.c r107 = r100.c();
            if (r107 == null) goto L17;
            DocUpgradeInfo r108 = r107.R();
            if (r108 == null) goto L17;
            final String r109 = r108.getRelateToken();
        L19:
            if (r109 != null) goto L22;
            r109 = "";
        L22:
            if (r106 != null) goto L25;
        L39:
            IGetDataCallback<Unit> r111 = new MainNavMoreItem$addFavoriteTab$callback$1();
            wb5.d r112 = r100.f234619c;
            if (r112 == null) goto L52;
            int r113 = com.bytedance.ee.bear.more.itemv2.mainnav.a.f234617a;
            String r114 = r112.f558996b;
            String r115 = r112.f558998d;
            String r116 = r112.f558997c;
            oj5.c r117 = r100.c();
            if (r117 == null) goto L44;
            r104 = r117.f();
        L44:
            Intrinsics.checkNotNullParameter(r114, "appId");
            Intrinsics.checkNotNullParameter(r115, "url");
            Intrinsics.checkNotNullParameter(r116, "title");
            TabAppInfo.BizType r118 = TabAppInfo.BizType.CCM;
            TabAppType r119 = TabAppType.APP_TYPE_URL;
            TabAppInfo.CustomNavigationAppLogoType r120 = TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_CCM_ICON;
            if (r104 != null) goto L47;
            String r121 = "";
        L48:
            r101.addFavoriteTab(new com.ss.android.lark.maintab.export.a(r114, r118, r119, r116, r120, r121, r115, ""), r111, false);
            return;
        L47:
            r121 = r104;
            goto L48
        L52:
            return;
        L25:
            if (r106.intValue() != 2) goto L39;
            oj5.c r122 = r100.c();
            boolean r123 = true;
            if (r122 != null) goto L29;
        L31:
            boolean r124 = false;
        L32:
            if (r124 == false) goto L39;
            if (r109.length() > 0) goto L37;
            r123 = false;
        L37:
            if (r123 == false) goto L39;
            tt5.a.h("MultitaskItem", "docx upgrade from doc, check main nav start");
            vqb.b.a().isExistFavoriteTab(r109, TabAppInfo.BizType.CCM, new MainNavMoreItem$addFavoriteTab$1(r109));
            goto L39
        L29:
            if (r122.getType() != e.f541304o.f541317b) goto L31;
            r124 = true;
        L17:
            r109 = null;
        L11:
            r106 = null;
            goto L12
        L49:
            r101.deleteFavoriteTab(r102.f559002h, r102.f559001g, TabAppInfo.BizType.CCM, new MainNavMoreItem$deleteFavoriteTab$callback$1(r100));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        tt5.a.h("MultitaskItem", "buildUIItem  start: ");
        return h(new f.w(!this.f234620d), new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false), CollectionsKt.listOf(new d(this)), CollectionsKt.listOf(new c()), new ViewOnClickListenerC3362b(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b
    public final void create() {
        tt5.a.h("MultitaskItem", "create  start: ");
        vqb.a r100 = vqb.b.a();
        wb5.d r101 = this.f234619c;
        if (r101 == null) goto L6;
        IGetDataCallback<Boolean> r102 = new MainNavMoreItem$requestIsExist$1$isExistCallback$1(this);
        r100.isExistFavoriteTab(r101.f559002h, r101.f559001g, TabAppInfo.BizType.CCM, r102);
        return;
    }

    public b(wb5.d r100) {
        this.f234619c = r100;
    }
}
