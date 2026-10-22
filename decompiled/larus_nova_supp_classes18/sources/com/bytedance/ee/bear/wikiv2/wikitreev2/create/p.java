package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements com.bytedance.ee.bear.wikiv2.searchv2.b.a {
    public final /* synthetic */ WikiCreateToFragment a;

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void b() {
        WikiTreeCtrlView r0 = this.a.o;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        WikiCreateToFragment r1 = this.a;
        AppBarLayout r2 = r1.u;
        if (r2 == null) goto L8;
        int r3 = r2.getHeight();
    L9:
        r1.i = r3;
        WikiCreateToFragment.W90(this.a, false);
        return;
    L8:
        r3 = 0;
        goto L9
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void onExitSearch() {
        WikiCreateToFragment.W90(this.a, true);
        WikiTreeCtrlView r0 = this.a.o;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public p(WikiCreateToFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.b.a
    public final void a(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r10, "spaceId");
        WikiCreateToFragment.W90(this.a, true);
        WikiSearchPickerView r1 = this.a.t;
        if (r1 == null) goto L5;
        r1.a();
    L5:
        WikiTreeCtrlView r2 = this.a.o;
        boolean r3 = false;
        if (r2 == null) goto L8;
        r2.setVisibility(0);
    L8:
        WikiTreeCtrlView r4 = this.a.o;
        if (r4 == null) goto L55;
        Intrinsics.checkNotNullParameter(r9, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r10, "targetSpaceId");
        boolean r0 = yp5.c.h();
        if (r0 == true) goto L13;
        r10 = r4.getSpaceId();
        if (r10 != null) goto L24;
    L22:
        r10 = "";
    L24:
        if (TextUtils.isEmpty(r10) == true) goto L53;
        WikiTreeCtrlView.c r5 = r4.g;
        ar5.a r7 = null;
        if (r5 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r5 = null;
    L29:
        if (TextUtils.isEmpty(r5.a) == true) goto L36;
        WikiTreeCtrlView.c r6 = r4.g;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r6 = null;
    L34:
        if (TextUtils.equals(r6.a, r9) == true) goto L53;
    L36:
        if (TextUtils.isEmpty(r4.getFocusToken()) == false) goto L38;
    L40:
        gq5.b.a = null;
        WikiTreeCtrlView.c r8 = r4.g;
        if (r8 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r8 = null;
    L43:
        if (r0 == false) goto L52;
        if (r11 != null) goto L46;
    L47:
        r3 = true;
    L48:
        if (r3 == true) goto L52;
        if (TextUtils.equals(r11, r10) == true) goto L52;
        r7 = new ar5.a(r11, 1, r9, UUID.randomUUID().toString());
        goto L52
    L46:
        if (r11.length() != 0) goto L48;
    L52:
        r8.t = r7;
        r4.getViewModel().setFocus(r9, "");
        r4.getViewModel().load(r10, r9, "", true);
        return;
    L38:
        if (TextUtils.equals(r4.getFocusToken(), r9) == false) goto L40;
    L53:
        tt5.a.k(r4.e, "focusTo, invalid params. return. ");
        return;
    L13:
        if (r10.length() != 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L24;
        r10 = r4.getSpaceId();
        if (r10 != null) goto L24;
    L15:
        r12 = false;
        goto L16
    }
}
