package uq5;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiHomePageV2;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import fq5.j;
import fq5.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends WikiTreeCtrlView.d {
    public final /* synthetic */ WikiTreePanelDialog a;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void l() {
        WikiTreePanelDialog r0 = this.a;
        View r1 = r0.o;
        j r2 = null;
        if (r1 != null) goto L9;
        View r3 = r0.getView();
        if (r3 == null) goto L7;
        r1 = r3.findViewById(2131393240);
    L8:
        r0.o = (TextView) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        TextView r4 = (TextView) r1;
        SpaceInfo r5 = this.a.ea0().getSpaceInfo();
        if (r5 == null) goto L14;
        String r6 = r5.getSpaceName();
        if (r6 == null) goto L14;
    L15:
        r4.setText(r6);
        WikiTreePanelDialog r7 = this.a;
        WikiTreePanelDialog._ViewModel r8 = r7.p;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r8 = null;
    L19:
        if (r8.getNeedOnBoarding() == false) goto L49;
        String r9 = r7.ea0().getFocusUid();
        if (TextUtils.isEmpty(r9) == false) goto L23;
        return;
    L23:
        if (r7.getParentFragment() == null) goto L28;
        Fragment r10 = r7.getParentFragment();
        if (r10 == null) goto L27;
        FragmentActivity r11 = r10.getActivity();
    L29:
        if (r11 == null) goto L51;
        m r12 = new m(r11, r7.ea0());
        Dialog r13 = r7.getDialog();
        if (r9 == null) goto L38;
        if (r13 == null) goto L38;
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_wiki_newbie_swipeLeft") == false) goto L37;
        tt5.a.h("WikiTreeSwipeItemOnBoarding", "wiki tree swipe left had already shown, return");
    L47:
        r7.q = r2;
        return;
    L37:
        r2 = new j(r12, r13, r9);
        com.bytedance.ee.util.ui.j.d(r2, 500);
    L38:
        StringBuilder r14 = new StringBuilder(" uid == null ");
        boolean r15 = true;
        if (r9 != null) goto L41;
        boolean r16 = true;
    L42:
        r14.append(r16);
        r14.append(" appCompatDialog == null");
        if (r13 == null) goto L46;
        r15 = false;
    L46:
        r14.append(r15);
        tt5.a.d("WikiTreeSwipeItemOnBoarding", r14.toString());
        goto L47
    L41:
        r16 = false;
        goto L42
    L51:
        return;
    L27:
        r11 = null;
        goto L29
    L28:
        r11 = r7.getActivity();
        goto L29
    L49:
        return;
    L14:
        r6 = "";
        goto L15
    }

    public c(WikiTreePanelDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.WIKI_TOKEN);
        WikiTreePanelDialog r0 = this.a;
        int r1 = WikiTreePanelDialog.w;
        SpaceInfo r2 = r0.ea0().getSpaceInfo();
        if (r2 == null) goto L6;
        String r3 = r2.space_id;
        if (r3 == null) goto L6;
    L7:
        WikiTreeObserver.b.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.b(r3, r5, true));
        return;
    L6:
        r3 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void d(WikiHomePageV2 r15) {
        Intrinsics.checkNotNullParameter(r15, "homePage");
        String r2 = r15.wikiToken;
        if (r2 != null) goto L5;
        return;
    L5:
        WikiTreePanelDialog r0 = this.a;
        String r6 = r15.title;
        WikiTreeCtrlView r1 = r0.ea0();
        if (r1 == null) goto L8;
        String r3 = r1.getSpaceId();
    L9:
        r0.fa0(new a(r2, false, null, null, r6, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.c(r15, r3), false, "", null, null, 1694));
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "delParentToken");
        WikiTreePanelDialog.ba0(this.a);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "delParentToken");
        WikiTreePanelDialog.ba0(this.a);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void q(String r5) {
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.WIKI_TOKEN);
        WikiTreePanelDialog r0 = this.a;
        int r1 = WikiTreePanelDialog.w;
        SpaceInfo r2 = r0.ea0().getSpaceInfo();
        if (r2 == null) goto L6;
        String r3 = r2.space_id;
        if (r3 == null) goto L6;
    L7:
        WikiTreeObserver.b.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.b(r3, r5, false));
        return;
    L6:
        r3 = "";
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void e(String r16, String r17) {
        Intrinsics.checkNotNullParameter(r16, "newToken");
        Intrinsics.checkNotNullParameter(r17, "uniqueUiId");
        TreeNode r1 = this.a.ea0().g(r16);
        WikiTreePanelDialog r13 = this.a;
        if (r1 == null) goto L5;
        WikiInfo r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r1);
    L6:
        r13.fa0(new a(r16, false, null, null, null, r2, false, r17, "tab_create", null, 1214));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void f(String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r18, "uniqueUiId");
        TreeNode r1 = this.a.ea0().g(r17);
        WikiTreePanelDialog r13 = this.a;
        if (r1 == null) goto L5;
        String r7 = r1.title;
    L6:
        if (r1 == null) goto L8;
        WikiInfo r8 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.b(r1);
    L9:
        r13.fa0(new a(r17, false, null, null, r7, r8, false, r18, null, null, 1694));
        return;
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void g(String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, "toSpaceId");
        Intrinsics.checkNotNullParameter(r17, "toToken");
        Intrinsics.checkNotNullParameter(r18, "toSpaceName");
        WikiTreePanelDialog r13 = this.a;
        a r14 = new a(r17, false, r16, r18, null, null, false, null, null, null, 2032);
        int r1 = WikiTreePanelDialog.w;
        r13.fa0(r14);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void h(String r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r19, "toSpaceId");
        Intrinsics.checkNotNullParameter(r20, "movToken");
        Intrinsics.checkNotNullParameter(r21, "focusToken");
        boolean r1 = !TextUtils.equals(r19, this.a.ea0().getSpaceId());
        if (TextUtils.isEmpty(r21) == false) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r1 == false) goto L25;
        if (r2 == false) goto L26;
        WikiTreePanelDialog r12 = this.a;
        r12.getClass();
        r12.fa0(new a(r20, true, r19, "", null, null, true, null, null, null, 1888));
        WikiTreeCtrlView r3 = r12.ea0();
        int r4 = WikiTreeCtrlView.q;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r19, "spaceId");
        if (TextUtils.isEmpty(r19) == true) goto L21;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r5 = r3.getViewModel();
        WikiTreeCtrlView.c r6 = r3.g;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewConfig");
        r6 = null;
    L17:
        if (r6.h == false) goto L19;
        String r7 = r20;
    L20:
        r5.setFocus(r7, "");
        r3.getViewModel().load(r19, r20, "", !r3.m(r20));
        goto L21
    L19:
        r7 = "";
    L21:
        r12.s = r19;
        WikiSearchPickerView r8 = r12.r;
        if (r8 == null) goto L27;
        r8.d(r12, r19);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if (TextUtils.isEmpty(this.a.ea0().getFocusToken()) == false) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void i(String r2, List<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "toSpaceId");
        Intrinsics.checkNotNullParameter(r3, "movTokenList");
        Intrinsics.checkNotNullParameter(r4, "focusToken");
        WikiTreePanelDialog.ba0(this.a);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void k(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "toSpaceId");
        Intrinsics.checkNotNullParameter(r3, "movToken");
        Intrinsics.checkNotNullParameter(r4, "focusToken");
        WikiTreePanelDialog.ba0(this.a);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView.d
    public final void o(String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, "toSpaceId");
        Intrinsics.checkNotNullParameter(r17, "toToken");
        Intrinsics.checkNotNullParameter(r18, "toSpaceName");
        WikiTreePanelDialog r13 = this.a;
        a r14 = new a(r17, false, r16, r18, null, null, false, null, null, null, 2032);
        int r1 = WikiTreePanelDialog.w;
        r13.fa0(r14);
    }
}
