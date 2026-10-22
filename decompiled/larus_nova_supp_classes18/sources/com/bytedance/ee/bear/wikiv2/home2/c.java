package com.bytedance.ee.bear.wikiv2.home2;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.homepage.title.HomeSubTitleView;
import com.bytedance.ee.bear.list.u0;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceClassification;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceFilterInfo;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpacesResp;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.utils.l0;
import com.ss.android.lark.utils.ContextsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements WikiHomeRecentSpaceView.b {
    public final /* synthetic */ WikiHomeFragment2 a;

    @Override // com.bytedance.ee.bear.wikiv2.home2.WikiHomeRecentSpaceView.b
    public final void L2() {
        WikiHomeRecentSpaceView r0 = this.a.X90();
        if (r0 == null) goto L7;
        com.bytedance.ee.bear.wikiv2.home2.model.l r1 = r0.getData();
        if (r1 == null) goto L7;
        WikiSpacesResp.Origin r2 = r1.c;
    L8:
        boolean r3 = true;
        if (r2 != WikiSpacesResp.Origin.Cache) goto L11;
        boolean r4 = true;
    L12:
        WikiHomeRecentSpaceView r5 = this.a.X90();
        if (r5 == null) goto L24;
        HomeSubTitleView r6 = r5.d;
        if (r6 == null) goto L22;
        ImageView r7 = r6.e;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r7 = null;
    L20:
        if (r7.getVisibility() != 0) goto L22;
    L23:
        Boolean r8 = Boolean.valueOf(r3);
    L25:
        gq5.d.g(r8);
        gq5.b.b(this.a.r, "fill_ui");
        gq5.b.a(this.a.r, 0, null, Boolean.valueOf(r4), 4);
        u0 r9 = this.a.o;
        if (r9 == null) goto L29;
        r9.b(DocumentType.WIKI_NAME);
        return;
    L29:
        return;
    L22:
        r3 = false;
        goto L23
    L24:
        r8 = null;
        goto L25
    L11:
        r4 = false;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.WikiHomeRecentSpaceView.b
    public final void M2() {
        WikiHomeFragment2 r0 = this.a;
        int r1 = WikiHomeFragment2.s;
        r0.Z90().refresh();
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.WikiHomeRecentSpaceView.b
    public final void O2() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == false) goto L29;
        WikiHomeFragment2 r0 = this.a;
        int r1 = WikiHomeFragment2.s;
        cq5.a r2 = (cq5.a) r0.l.getValue();
        Context r3 = this.a.getContext();
        if (r3 == null) goto L9;
        Context r4 = ContextsKt.findActivity(r3);
        if (r4 == null) goto L9;
    L10:
        WikiSpaceFilterInfo r5 = this.a.Z90().getFilterInfo();
        WikiHomeFragment2 r9 = this.a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "filterInfo");
        Intrinsics.checkNotNullParameter(r9, "sourceFragment");
        if (r4 != null) goto L14;
    L25:
        gq5.d.f("filter", "none", Boolean.TRUE, 8);
        return;
    L14:
        if (r5.isEmptyFilterOption() == true) goto L25;
        tt5.a.h("WikiSpaceFilterDialog", "WikiSpaceFilterDialog.show.");
        List<WikiSpaceType> r6 = r5.getFilterOption().getSpaceTypes();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        WikiSpaceType r10 = (WikiSpaceType) r8.next();
        r7.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("spaceTypeId", r10.getSpaceTypeId()), TuplesKt.to("spaceTypeName", r10.getSpaceTypeName())}));
        goto L18
    L20:
        ArrayList r11 = new ArrayList(r7);
        List<WikiSpaceClassification> r12 = r5.getFilterOption().getSpaceClassifications();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        WikiSpaceClassification r15 = (WikiSpaceClassification) r14.next();
        r13.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("spaceClassId", r15.getSpaceClassId()), TuplesKt.to("spaceClassName", r15.getSpaceClassName())}));
        goto L22
    L24:
        HashMap r16 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("spaceTypes", r11), TuplesKt.to("spaceClassifications", new ArrayList(r13))});
        ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).b(r4, "ccm-lynx://lynxview/pages/wiki-classification/template.js", new de5.a(l0.a().toString(), MapsKt.hashMapOf(new Pair[]{TuplesKt.to(FilterData.FilterSheetItem.Id.FILTER_VALUE, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("spaceTypeId", r5.getFilterValue().getSpaceTypeId()), TuplesKt.to("spaceClassId", r5.getFilterValue().getSpaceClassId())})), TuplesKt.to("filterOption", r16), TuplesKt.to("filterDefIdValue", "all")}), new HashMap(), new Bundle(), null, r9, false, 80));
    L9:
        r4 = this.a.getContext();
        goto L10
    }

    public c(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.WikiHomeRecentSpaceView.b
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        WikiHomeFragment2.V90(this.a, r4);
        HomeSubTitleView r5 = this.a.X90().d;
        if (r5 == null) goto L10;
        ImageView r6 = r5.e;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mIvFilter");
        r6 = null;
    L8:
        if (r6.getVisibility() != 0) goto L10;
        boolean r7 = true;
    L11:
        gq5.d.f("workspace", "ccm_wiki_tree_view", Boolean.valueOf(r7), 8);
        return;
    L10:
        r7 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.WikiHomeRecentSpaceView.b
    public final void N2(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        if (r5 == false) goto L5;
        final WikiHomeFragment2 r6 = this.a;
        int r0 = WikiHomeFragment2.s;
        r6.Z90().starWikiSpace(r4, new WikiHomeFragment2$starWikiSpace$1(r6), new WikiHomeFragment2$starWikiSpace$2(r6));
        return;
    L5:
        final WikiHomeFragment2 r7 = this.a;
        int r1 = WikiHomeFragment2.s;
        r7.Z90().unStarWikiSpace(r4, new WikiHomeFragment2$unStarWikiSpace$1(r7), new WikiHomeFragment2$unStarWikiSpace$2(r7));
    }
}
