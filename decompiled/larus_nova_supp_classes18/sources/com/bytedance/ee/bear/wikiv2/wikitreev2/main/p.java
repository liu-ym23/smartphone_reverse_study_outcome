package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.picker.Picker;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements SpaceCoverView.b {
    public final /* synthetic */ WikiTreeFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.main.SpaceCoverView.b
    public final void a() {
        SpaceHomeViewModel r0 = this.a.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.showSpaceDetail();
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.main.SpaceCoverView.b
    public final void p() {
        HashMap r0 = new HashMap();
        r0.put("module", DocumentType.WIKI_NAME);
        r0.put("sub_module", "wiki_pages");
        r0.put("group", DocumentType.WIKI_NAME);
        r0.put("source", "wiki_pages_view");
        r0.put("action", "click_search_item");
        tt5.a.b("WikiReport", "wiki_click_search" + r0);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("wiki_click_search", r0);
        WikiTreeFragment r1 = this.a;
        int r2 = WikiTreeFragment.u;
        CoordinatorLayout r3 = r1.n;
        if (r3 != null) goto L9;
        View r4 = r1.getView();
        if (r4 == null) goto L7;
        r3 = r4.findViewById(2131393224);
    L8:
        r1.n = (WikiCoverCoordinatorLayout) r3;
        goto L9
    L7:
        r3 = null;
    L9:
        ((WikiCoverCoordinatorLayout) r3).setVisibility(8);
        WikiSearchPickerView r5 = r1.r;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
    L12:
        WikiSearchPickerView r6 = r1.r;
        if (r6 == null) goto L21;
        com.bytedance.ee.bear.wikiv2.searchv2.b.a r7 = r6.b;
        if (r7 == null) goto L17;
        r7.b();
    L17:
        Picker r8 = r6.a;
        if (r8 == null) goto L22;
        r8.defaultMode(true);
        return;
    L22:
        return;
    }

    public p(WikiTreeFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.main.SpaceCoverView.b
    public final void b(boolean r3) {
        SpaceHomeViewModel r0 = null;
        if (r3 == false) goto L9;
        SpaceHomeViewModel r4 = this.a.o;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r0.favoriteSpace();
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        SpaceHomeViewModel r5 = this.a.o;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r0.unFavoriteSpace();
        return;
    L12:
        r0 = r5;
        goto L13
    }
}
