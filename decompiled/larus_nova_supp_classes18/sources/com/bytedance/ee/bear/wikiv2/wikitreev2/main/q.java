package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.g3;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends WikiTreeCtrlView.d {
    public final /* synthetic */ WikiTreeFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void l() {
        SpaceHomeViewModel r0 = this.a.o;
        SpaceHomeViewModel r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.setReady(this.a.Y90().getSpaceInfo(), this.a.Y90().getSpaceUserPerm());
        this.a.Z90();
        if (this.a.Y90().getCanCreate() == false) goto L9;
        this.a.V90().setVisibility(0);
    L9:
        if (this.a.Y90().getCanShowAi() == false) goto L19;
        SpaceCoverView r1 = this.a.W90();
        SpaceHomeViewModel r3 = this.a.o;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L13:
        r3.getSpaceId();
        SpaceHomeViewModel r4 = this.a.o;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        r2.isGraphDark();
        r1.m.a.b();
        return;
    L16:
        r2 = r4;
        goto L17
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void p() {
        WikiTreeFragment.aa0(this.a, null, -3, 1);
    }

    public q(WikiTreeFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void a(Throwable r4) {
        WikiTreeFragment.aa0(this.a, r4, null, 2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void d(WikiHomePageV2 r15) {
        Intrinsics.checkNotNullParameter(r15, "homePage");
        SpaceHomeViewModel r0 = this.a.o;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        String r3 = AnalyticConstant.OpenType.WIKI_ALL.getType();
        String r4 = r15.wikiToken;
        WikiTreeCtrlView r2 = this.a.Y90();
        if (r2 == null) goto L8;
        String r5 = r2.getSpaceId();
    L9:
        String r7 = r15.title;
        WikiTreeCtrlView r6 = this.a.Y90();
        if (r6 == null) goto L12;
        r1 = r6.getSpaceId();
    L12:
        r0.navigation(new c(r3, r4, r5, null, r7, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.c(r15, r1), null, null, null, 384), this.a);
        return;
    L8:
        r5 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void e(String r16, String r17) {
        Intrinsics.checkNotNullParameter(r16, "newToken");
        Intrinsics.checkNotNullParameter(r17, "uniqueUiId");
        g3.a.a.a(this.a.Y90().c());
        TreeNode r1 = this.a.Y90().g(r16);
        SpaceHomeViewModel r2 = this.a.o;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        SpaceHomeViewModel r12 = null;
    L6:
        String r3 = AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType();
        if (r1 == null) goto L9;
        String r5 = r1.space_id;
    L11:
        if (r1 == null) goto L13;
        String r7 = r1.title;
    L14:
        if (r1 == null) goto L16;
        WikiInfo r9 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r1);
    L17:
        r12.navigation(new c(r3, r16, r5, null, r7, r9, r17, "tab_create", null, 256), this.a);
        return;
    L16:
        r9 = null;
        goto L17
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L11
    L5:
        r12 = r2;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void f(String r16, String r17) {
        Intrinsics.checkNotNullParameter(r16, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r17, "uniqueUiId");
        g3.a.a.a(this.a.Y90().c());
        TreeNode r1 = this.a.Y90().g(r16);
        SpaceHomeViewModel r2 = this.a.o;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        SpaceHomeViewModel r12 = null;
    L6:
        String r3 = AnalyticConstant.OpenType.WIKI_ALL.getType();
        if (r1 == null) goto L9;
        String r5 = r1.space_id;
    L11:
        if (r1 == null) goto L13;
        String r7 = r1.title;
    L14:
        if (r1 == null) goto L16;
        WikiInfo r9 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r1);
    L17:
        r12.navigation(new c(r3, r16, r5, null, r7, r9, r17, null, null, 384), this.a);
        return;
    L16:
        r9 = null;
        goto L17
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L11
    L5:
        r12 = r2;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void g(String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r15, "toSpaceId");
        Intrinsics.checkNotNullParameter(r16, "toToken");
        Intrinsics.checkNotNullParameter(r17, "toSpaceName");
        SpaceHomeViewModel r1 = this.a.o;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        r1.navigation(new c(AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType(), r16, r15, r17, null, null, null, null, null, 496), this.a);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void h(String r4, final String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "toSpaceId");
        Intrinsics.checkNotNullParameter(r5, "movToken");
        Intrinsics.checkNotNullParameter(r6, "focusToken");
        boolean r1 = true;
        boolean r0 = !TextUtils.equals(r4, this.a.Y90().getSpaceId());
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L7:
        r1 = false;
    L8:
        ce5.a r7 = new ce5.a(this.a);
        if (r0 == false) goto L15;
        if (r1 == true) goto L12;
        return;
    L12:
        if (dq5.j.c(r4, r7) == true) goto L17;
        int r2 = zp5.f.a;
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        Intrinsics.checkNotNullParameter(r7, "userComponentAbility");
        Flowable.just("").observeOn(fo5.d.b()).flatMap(new zp5.e(r7, r4)).observeOn(fo5.d.d()).subscribe(new m(r5), new n());
        return;
    L17:
        return;
    L15:
        return;
    L5:
        if (TextUtils.isEmpty(this.a.Y90().getFocusToken()) == false) goto L7;
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void o(String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r15, "toSpaceId");
        Intrinsics.checkNotNullParameter(r16, "toToken");
        Intrinsics.checkNotNullParameter(r17, "toSpaceName");
        SpaceHomeViewModel r1 = this.a.o;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        r1.navigation(new c(AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType(), r16, r15, r17, null, null, null, null, null, 496), this.a);
    }
}
