package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.text.TextUtils;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o extends WikiTreeCtrlView.d {
    public final /* synthetic */ WikiCreateToFragment a;

    public static final class a implements gp5.a.InterfaceC0236a {
        public final /* synthetic */ WikiCreateToFragment a;
        public final /* synthetic */ String b;

        @Override // gp5.a.InterfaceC0236a
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "text");
            tt5.a.h("Wiki_WikiCreateToFragment", "input new name.");
            WikiTreeCtrlView r0 = this.a.o;
            if (r0 == null) goto L6;
            String r1 = this.b;
            Intrinsics.checkNotNullParameter(r1, WikiFolderPushPlugin.WIKI_TOKEN);
            Intrinsics.checkNotNullParameter(r4, "newTitle");
            r0.getViewModel().rename(r1, r4);
            return;
        }

        public a(WikiCreateToFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void l() {
        WikiCreateToFragment r0 = this.a;
        BaseTitleBar r1 = r0.n;
        if (r1 == null) goto L13;
        WikiTreeCtrlView r2 = r0.o;
        if (r2 == null) goto L10;
        SpaceInfo r3 = r2.getSpaceInfo();
        if (r3 == null) goto L10;
        String r4 = r3.getSpaceName();
        if (r4 == null) goto L10;
    L11:
        r1.setTitle(r4);
    L10:
        r4 = "";
    L13:
        if (TextUtils.isEmpty(this.a.Y90().getDocumentToken()) == false) goto L27;
        WikiTreeCtrlView r5 = this.a.o;
        if (r5 == null) goto L17;
        String r6 = r5.getFocusToken();
    L19:
        if (TextUtils.isEmpty(r6) == false) goto L28;
        WikiTreeCtrlView r7 = this.a.o;
        if (r7 == null) goto L29;
        WikiTreeView r8 = r7.getWikiTreeViewFromXml();
        String r9 = r7.getViewModel().getRootToken();
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        r8.k(r9, "");
        return;
    L29:
        return;
    L28:
        return;
    L17:
        r6 = null;
        goto L19
    }

    public o(WikiCreateToFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        this.a.X90(r2);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void e(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "newToken");
        Intrinsics.checkNotNullParameter(r5, "uniqueUiId");
        WikiTreeCtrlView r1 = this.a.o;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "uniqueUiId");
        r1.getWikiTreeViewFromXml().j(r5);
    L5:
        WikiCreateToFragment r6 = this.a;
        r6.k.k(r6.getContext(), "", new a(this.a, r4));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "uniqueUiId");
        super.f(r2, r3);
        WikiTreeCtrlView r0 = this.a.o;
        if (r0 == null) goto L5;
        TreeNode r4 = r0.g(r2);
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.has_child == false) goto L14;
        WikiTreeCtrlView r5 = this.a.o;
        if (r5 == null) goto L15;
        r5.getViewModel().expand(r3);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
