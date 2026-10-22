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
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiTreeMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f242344u = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TreeNode f242345m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WikNodePerm f242346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SpaceInfo f242347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f242348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ce5.a f242349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WikiDialogs.b f242350r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f242351s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public BenefitStore f242352t;

    public static final class a {
    }

    public static final class b extends com.bytedance.ee.bear.more.protocol3.j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f242353e;

        @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
        public final View.OnClickListener a() {
            return null;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.j
        public final int c() {
            return R.string.Doc_Facade_OperateFailedNoPermission;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.j
        public final boolean e() {
            return this.f242353e;
        }

        public b(boolean r100) {
            this.f242353e = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        if (this.f242345m.isShortcut() == false) goto L6;
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new WikiTreeMoreProvider$buildWikiShortcutMoreItems$1(this));
    L6:
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new WikiTreeMoreProvider$buildWikiMoreItems$1(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        ce5.a r100 = this.f242349q;
        if (r100 == null) goto L5;
        BenefitManagerAPI r101 = r100.f23452g;
    L6:
        if (r101 == null) goto L9;
        BenefitStore r102 = r101.n1();
        if (r102 == null) goto L9;
    L10:
        BenefitStore r103 = this.f242352t;
        if (r103 != null) goto L25;
        TreeNode r104 = this.f242345m;
        String r105 = r104.obj_token;
        int r106 = r104.obj_type;
        if (r105 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        if (r107 == true) goto L24;
        if (r101 == null) goto L24;
        r103 = r101.g7(this.f242345m.obj_token, r106, BenefitManagerAPI.CacheType.TOKEN);
        if (Intrinsics.areEqual(r103.getFrom(), BenefitStore.FROM_MOCK) == true) goto L25;
        this.f242352t = r103;
    L24:
        r103 = new BenefitStore("", new LinkedHashMap(), "", null, false, 24, null);
        goto L25
    L15:
        if (r105.length() == 0) goto L18;
        r107 = false;
    L25:
        l(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.a(this.f242345m, r102, r103, (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)));
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(f().getHostFragment(), new g1(this));
        a3 r108 = a3.f241764a;
        String r109 = this.f242345m.space_id;
        r108.getClass();
        Disposable r110 = a3.a(r109).subscribe(new h1(this), new i1(this));
        Intrinsics.checkNotNullParameter(r110, "<this>");
        this.f234893h.add(r110);
        return;
    L9:
        r102 = new BenefitStore("", new LinkedHashMap(), "", null, false, 24, null);
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public static final boolean n(WikiTreeMoreProvider r100) {
        r100.getClass();
        if (yp5.c.i() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f242345m.isWikiHomePage == false) goto L7;
        return true;
    }

    public static final PermissionResponse m(WikiTreeMoreProvider r100, String r101) {
        r100.getClass();
        TreeNode r102 = r100.f242345m;
        BaseEntity r103 = new BaseEntity(r102.obj_token, sbb.e.d(r102.obj_type), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r103, r101), null);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final void a(sj5.b r100, com.bytedance.ee.bear.more.protocol3.l r101) {
        com.bytedance.ee.bear.more.protocol3.l r102 = com.bytedance.ee.bear.more.view3.d.f235024a;
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r102, "uiItemFactory");
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L9:
        boolean r103 = false;
    L10:
        tt5.a.h("WikiTreeMoreProvider", "shouldUseDoubaoStyle, enable=" + r103);
        com.bytedance.ee.bear.more.protocol3.l r104 = r102;
        if (r103 == false) goto L13;
        OverrideUIMoreItemFactory r105 = new OverrideUIMoreItemFactory(new com.bytedance.ee.bear.more.protocol3.panel.e(), WikiTreeMoreProvider$attachToHost$effectiveFactory$1.INSTANCE);
        ItemUIStyle r106 = ItemUIStyle.DOUBAO;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f234922d = r106;
        r104 = r105;
    L13:
        super.a(r100, r104);
        return;
    L5:
        if (CCMOfficeSDKAssembleFG.b() == false) goto L9;
        if (com.bytedance.ee.bear.more.protocol3.panel.y.f235006a == false) goto L9;
        r103 = true;
        goto L10
    }

    public WikiTreeMoreProvider(TreeNode r100, WikNodePerm r101, SpaceInfo r102, boolean r103, ce5.a r104) {
        Intrinsics.checkNotNullParameter(r100, "wikiNode");
        Intrinsics.checkNotNullParameter(r101, "wikiPerm");
        Intrinsics.checkNotNullParameter(r102, "spaceInfo");
        this.f242345m = r100;
        this.f242346n = r101;
        this.f242347o = r102;
        this.f242348p = r103;
        this.f242349q = r104;
    }
}
