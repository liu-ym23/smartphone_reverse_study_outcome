package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements com.bytedance.ee.bear.wikiv2.searchv2.b.a {
    public final /* synthetic */ WikiTreeFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void b() {
        WikiTreeFragment r0 = this.a;
        int r1 = WikiTreeFragment.u;
        ((l) r0.p.getValue()).a();
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void onExitSearch() {
        WikiTreeFragment r0 = this.a;
        WikiSearchPickerView r1 = r0.r;
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        CoordinatorLayout r2 = r0.n;
        if (r2 != null) goto L12;
        View r3 = r0.getView();
        if (r3 == null) goto L10;
        r2 = r3.findViewById(2131393224);
    L11:
        r0.n = (WikiCoverCoordinatorLayout) r2;
        goto L12
    L10:
        r2 = null;
    L12:
        ((WikiCoverCoordinatorLayout) r2).setVisibility(0);
        ((l) this.a.p.getValue()).a();
    }

    public r(WikiTreeFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void a(String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r15, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r16, "spaceId");
        SpaceHomeViewModel r1 = this.a.o;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L5:
        AnalyticConstant.OpenType r2 = AnalyticConstant.OpenType.WIKI_SEARCH;
        String r3 = r2.getType();
        String r10 = r2.getType();
        if (r17 != null) goto L8;
        String r11 = "";
    L9:
        r1.navigation(new c(r3, r15, r16, null, null, null, null, r10, r11, 120), this.a);
        return;
    L8:
        r11 = r17;
        goto L9
    }
}
