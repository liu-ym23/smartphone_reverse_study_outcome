package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.more.protocol3.panel.ItemUIStyle;
import com.bytedance.ee.bear.more.protocol3.panel.OverrideUIMoreItemFactory;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a3;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiTreeMoreProvider extends BaseMoreProvider {
    public static final /* synthetic */ int u = 0;
    public final TreeNode m;
    public WikNodePerm n;
    public SpaceInfo o;
    public final boolean p;
    public final ce5.a q;
    public WikiDialogs.b r;
    public boolean s;
    public BenefitStore t;

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.bear.more.protocol3.j {
        public final boolean e;

        @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
        public final View.OnClickListener a() {
            return null;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.j
        public final int c() {
            return 2131887803;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.j
        public final boolean e() {
            return this.e;
        }

        public b(boolean r1) {
            this.e = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        if (this.m.isShortcut() == false) goto L6;
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new WikiTreeMoreProvider$buildWikiShortcutMoreItems$1(this));
    L6:
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new WikiTreeMoreProvider$buildWikiMoreItems$1(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        ce5.a r0 = this.q;
        if (r0 == null) goto L5;
        BenefitManagerAPI r1 = r0.g;
    L6:
        if (r1 == null) goto L9;
        BenefitStore r2 = r1.n1();
        if (r2 == null) goto L9;
    L10:
        BenefitStore r3 = this.t;
        if (r3 != null) goto L25;
        TreeNode r4 = this.m;
        String r5 = r4.obj_token;
        int r6 = r4.obj_type;
        if (r5 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L24;
        if (r1 == null) goto L24;
        r3 = r1.g7(this.m.obj_token, r6, BenefitManagerAPI.CacheType.TOKEN);
        if (Intrinsics.areEqual(r3.getFrom(), BenefitStore.FROM_MOCK) == true) goto L25;
        this.t = r3;
    L24:
        r3 = new BenefitStore("", new LinkedHashMap(), "", null, false, 24, null);
        goto L25
    L15:
        if (r5.length() == 0) goto L18;
        r7 = false;
    L25:
        l(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.a(this.m, r2, r3, (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)));
        com.bytedance.ee.bear.contract.j.a.a.a().observe(f().getHostFragment(), new g1(this));
        a3 r8 = a3.a;
        String r9 = this.m.space_id;
        r8.getClass();
        Disposable r10 = a3.a(r9).subscribe(new h1(this), new i1(this));
        Intrinsics.checkNotNullParameter(r10, "<this>");
        this.h.add(r10);
        return;
    L9:
        r2 = new BenefitStore("", new LinkedHashMap(), "", null, false, 24, null);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean n(WikiTreeMoreProvider r1) {
        r1.getClass();
        if (yp5.c.i() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.m.isWikiHomePage == false) goto L7;
        return true;
    }

    public static final PermissionResponse m(WikiTreeMoreProvider r4, String r5) {
        r4.getClass();
        TreeNode r6 = r4.m;
        BaseEntity r0 = new BaseEntity(r6.obj_token, sbb.e.d(r6.obj_type), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r0, r5), null);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final void a(sj5.b r4, com.bytedance.ee.bear.more.protocol3.l r5) {
        com.bytedance.ee.bear.more.protocol3.l r6 = com.bytedance.ee.bear.more.view3.d.a;
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r6, "uiItemFactory");
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        tt5.a.h("WikiTreeMoreProvider", "shouldUseDoubaoStyle, enable=" + r0);
        com.bytedance.ee.bear.more.protocol3.l r7 = r6;
        if (r0 == false) goto L13;
        OverrideUIMoreItemFactory r8 = new OverrideUIMoreItemFactory(new com.bytedance.ee.bear.more.protocol3.panel.e(), WikiTreeMoreProvider$attachToHost$effectiveFactory$1.INSTANCE);
        ItemUIStyle r1 = ItemUIStyle.DOUBAO;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r8.d = r1;
        r7 = r8;
    L13:
        super.a(r4, r7);
        return;
    L5:
        if (CCMOfficeSDKAssembleFG.b() == false) goto L9;
        if (com.bytedance.ee.bear.more.protocol3.panel.y.a == false) goto L9;
        r0 = true;
        goto L10
    }

    public WikiTreeMoreProvider(TreeNode r2, WikNodePerm r3, SpaceInfo r4, boolean r5, ce5.a r6) {
        Intrinsics.checkNotNullParameter(r2, "wikiNode");
        Intrinsics.checkNotNullParameter(r3, "wikiPerm");
        Intrinsics.checkNotNullParameter(r4, "spaceInfo");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
    }
}
