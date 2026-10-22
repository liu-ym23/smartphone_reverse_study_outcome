package com.bytedance.ee.bear.more.itemv2.mainnav;

import android.view.View;
import com.bytedance.ee.bear.docupgrade.DocUpgradeInfo;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.maintab.export.TabAppType;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends g {
    public static final /* synthetic */ int e = 0;
    public final wb5.d c;
    public boolean d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.itemv2.mainnav.b$b, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0115b implements View.OnClickListener {
        public final /* synthetic */ b a;

        public ViewOnClickListenerC0115b(b r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            final b r1 = this.a;
            r1.getHost().a();
            vqb.a r2 = vqb.b.a();
            wb5.d r3 = r1.c;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r1.d == true) goto L49;
            oj5.c r4 = r1.c();
            String r5 = null;
            if (r4 == null) goto L11;
            DocUpgradeInfo r6 = r4.R();
            if (r6 == null) goto L11;
            Integer r7 = Integer.valueOf(r6.getStatus());
        L12:
            oj5.c r8 = r1.c();
            if (r8 == null) goto L17;
            DocUpgradeInfo r9 = r8.R();
            if (r9 == null) goto L17;
            final String r10 = r9.getRelateToken();
        L19:
            if (r10 != null) goto L22;
            r10 = "";
        L22:
            if (r7 != null) goto L25;
        L39:
            IGetDataCallback<Unit> r11 = new MainNavMoreItem$addFavoriteTab$callback$1();
            wb5.d r12 = r1.c;
            if (r12 == null) goto L52;
            int r13 = com.bytedance.ee.bear.more.itemv2.mainnav.a.a;
            String r14 = r12.b;
            String r15 = r12.d;
            String r16 = r12.c;
            oj5.c r17 = r1.c();
            if (r17 == null) goto L44;
            r5 = r17.f();
        L44:
            Intrinsics.checkNotNullParameter(r14, "appId");
            Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_URL);
            Intrinsics.checkNotNullParameter(r16, "title");
            TabAppInfo.BizType r18 = TabAppInfo.BizType.CCM;
            TabAppType r110 = TabAppType.APP_TYPE_URL;
            TabAppInfo.CustomNavigationAppLogoType r111 = TabAppInfo.CustomNavigationAppLogoType.APP_LOGO_TYPE_CCM_ICON;
            if (r5 != null) goto L47;
            String r112 = "";
        L48:
            r2.addFavoriteTab(new com.ss.android.lark.maintab.export.a(r14, r18, r110, r16, r111, r112, r15, ""), r11, false);
            return;
        L47:
            r112 = r5;
            goto L48
        L52:
            return;
        L25:
            if (r7.intValue() != 2) goto L39;
            oj5.c r20 = r1.c();
            boolean r21 = true;
            if (r20 != null) goto L29;
        L31:
            boolean r22 = false;
        L32:
            if (r22 == false) goto L39;
            if (r10.length() > 0) goto L37;
            r21 = false;
        L37:
            if (r21 == false) goto L39;
            tt5.a.h("MultitaskItem", "docx upgrade from doc, check main nav start");
            vqb.b.a().isExistFavoriteTab(r10, TabAppInfo.BizType.CCM, new MainNavMoreItem$addFavoriteTab$1(r10));
            goto L39
        L29:
            if (r20.getType() != e.o.b) goto L31;
            r22 = true;
        L17:
            r10 = null;
        L11:
            r7 = null;
            goto L12
        L49:
            r2.deleteFavoriteTab(r3.h, r3.g, TabAppInfo.BizType.CCM, new MainNavMoreItem$deleteFavoriteTab$callback$1(r1));
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        tt5.a.h("MultitaskItem", "buildUIItem  start: ");
        return h(new f.w(!this.d), new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false), CollectionsKt.listOf(new d(this)), CollectionsKt.listOf(new c()), new ViewOnClickListenerC0115b(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        tt5.a.h("MultitaskItem", "create  start: ");
        vqb.a r0 = vqb.b.a();
        wb5.d r1 = this.c;
        if (r1 == null) goto L6;
        IGetDataCallback<Boolean> r2 = new MainNavMoreItem$requestIsExist$1$isExistCallback$1(this);
        r0.isExistFavoriteTab(r1.h, r1.g, TabAppInfo.BizType.CCM, r2);
        return;
    }

    public b(wb5.d r1) {
        this.c = r1;
    }
}
