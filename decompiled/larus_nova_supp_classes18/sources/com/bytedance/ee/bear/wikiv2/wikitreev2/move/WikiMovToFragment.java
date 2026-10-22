package com.bytedance.ee.bear.wikiv2.wikitreev2.move;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRootPermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetSpaceInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.n;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.o;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import idb.f;
import io.reactivex.Flowable;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tq5.g;
import tq5.h;
import tq5.i;
import tq5.j;
import tq5.k;
import tq5.l;
import tq5.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0014J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001aH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/move/WikiMovToFragment;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToFragment;", "<init>", "()V", "moveCommand", "Lcom/bytedance/ee/bear/list/selector/ICommand;", "onDestroy", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "observeApplyMoveState", "initAction", "responseMoveClick", "focusTreeNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "handleMove", "doMove", "showMoveConfirmDialog", "needShowSinglePageOwnerTips", "Lio/reactivex/Flowable;", "", "requestMoveTargetEnable", "focusToken", "", "dispose", "setResultThenFinish", "finishWhenApplySuccess", WikiFolderPushPlugin.WIKI_TOKEN, "oldToken", "getDisableToken", "doFocusChange", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMovToFragment extends WikiCreateToFragment {
    public static final /* synthetic */ int x = 0;
    public td5.d w;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SelectorType.values().length];
            r0[SelectorType.SPACE_MOVE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SelectorType.WIKI_MOVE_TO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ WikiMovToFragment a;

        public c(WikiMovToFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            WikiTreeCtrlView r8 = this.a.o;
            if (r8 == null) goto L6;
            TreeNode r9 = r8.getFocusTreeNode();
            if (r9 == null) goto L6;
        L11:
            tt5.a.h("Wiki_WikiMovToFragment", "click confirm, focusToken = " + du5.b.g(r9.wiki_token));
            WikiMovToFragment r1 = this.a;
            int r3 = WikiMovToFragment.x;
            r1.getClass();
            String r4 = r9.wiki_token;
            tt5.a.h("Wiki_WikiMovToFragment", "responseMoveClick()...focusToken = " + du5.b.g(r4));
            qc5.a.j();
            r1.l.clear();
            Toast.showLoading(r1.getContext(), r1.getString(2131887769));
            Intrinsics.checkNotNull(r4);
            WikiTreeCtrlView r2 = r1.o;
            if (r2 == null) goto L20;
            TreeNode r5 = r2.g(r4);
            if (r5 == null) goto L20;
            NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
            if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.c(r5.wiki_node_type) == false) goto L19;
            Flowable r6 = l0.b(r0).a(new GetRootPermPuller.Params(r1.Y90().getSpaceId())).map(g.a).onErrorReturnItem(Boolean.TRUE);
            Intrinsics.checkNotNull(r6);
        L21:
            r1.l.add(r6.subscribe(new i(r1, r9), new j(r1, r9)));
            return;
        L19:
            r6 = new GetNodePermPuller(r0).d(new GetNodePermPuller.Params(r1.Y90().getSpaceId(), r4)).map(h.a).onErrorReturnItem(Boolean.TRUE);
            Intrinsics.checkNotNull(r6);
        L20:
            r6 = Flowable.just(Boolean.TRUE);
        L6:
            r9 = new TreeNode();
            WikiTreeCtrlView r10 = this.a.o;
            if (r10 == null) goto L9;
            String r11 = r10.getFocusToken();
        L10:
            r9.wiki_token = r11;
            goto L11
        L9:
            r11 = null;
            goto L10
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ WikiMovToFragment a;

        public d(WikiMovToFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            WikiTreeCtrlView r3 = this.a.o;
            if (r3 == null) goto L5;
            String r4 = r3.getFocusToken();
        L7:
            if (TextUtils.isEmpty(r4) == true) goto L10;
            Toast.showFailureText(this.a.getContext(), 2131888335);
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void initAction() {
        Button r0 = this.q;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.wikiv2.wikitreev2.create.b r1 = new com.bytedance.ee.bear.wikiv2.wikitreev2.create.b(this, r0);
    L6:
        this.j = r1;
        if (r1 == null) goto L9;
        r1.c = false;
    L9:
        if (r1 == null) goto L12;
        r1.a(new c(this), new d(this));
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final String Z90() {
        String r0 = Y90().getSrcToken();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("Wiki_WikiMovToFragment", "onDestroy()...");
        this.l.clear();
        td5.d r0 = this.w;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public WikiMovToFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void X90(String r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        super.X90(r3);
        com.bytedance.ee.bear.wikiv2.wikitreev2.create.b r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L11:
        boolean r4 = false;
    L12:
        r0.c = r4;
        return;
    L7:
        if (TextUtils.equals(r3, Y90().getSrcToken()) == true) goto L11;
        if (TextUtils.equals(r3, Y90().getSrcParentToken()) == true) goto L11;
        r4 = true;
        goto L12
    }

    public final void ea0(TreeNode r11) {
        String r1 = r11.wiki_token;
        tt5.a.h("Wiki_WikiMovToFragment", "doMove()...focusToken = " + du5.b.g(r1));
        Bundle r2 = getArguments();
        WikNodePerm r4 = null;
        if (r2 == null) goto L5;
        SelectorConfig r6 = (SelectorConfig) r2.getParcelable("extra_config");
    L6:
        if (r6 == null) goto L40;
        WikiTreeCtrlView r3 = this.o;
        if (r3 == null) goto L10;
        Boolean r5 = Boolean.valueOf(r3.n());
    L11:
        WikiTreeCtrlView r7 = this.o;
        if (r7 == null) goto L14;
        String r8 = r7.getRootToken();
    L15:
        boolean r9 = TextUtils.equals(r8, r1);
        WikiTreeCtrlView r10 = this.o;
        if (r10 == null) goto L20;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, WikiFolderPushPlugin.WIKI_TOKEN);
        String r12 = r10.getViewModel().getTitle(r1);
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        WikiSelectorBean r13 = new WikiSelectorBean();
        r13.d = r1;
        r13.g = r12;
        r13.i = r11.obj_token;
        r13.j = r11.obj_type;
        r13.n = Intrinsics.areEqual(r5, Boolean.TRUE);
        int r0 = b.a[r6.a.ordinal()];
        if (r0 != 1) goto L24;
        Bundle r14 = getArguments();
        if (r14 == null) goto L37;
        SpaceSelectorBean r15 = (SpaceSelectorBean) r14.getParcelable("extra_space_bean");
    L38:
        com.bytedance.ee.bear.list.move.j r16 = new com.bytedance.ee.bear.list.move.j(getContext(), this, r13, Y90().getSpaceId(), r15, r9);
        this.w = r16;
        r16.execute();
        return;
    L37:
        r15 = null;
        goto L38
    L24:
        if (r0 != 2) goto L42;
        Bundle r17 = getArguments();
        if (r17 == null) goto L29;
        WikiSelectorBean r18 = (WikiSelectorBean) r17.getParcelable("extra_wiki_bean");
    L30:
        StringBuilder r19 = new StringBuilder("doMove()...wikiNodePerm = ");
        if (r18 == null) goto L33;
        r4 = r18.p;
    L33:
        r19.append(r4);
        tt5.a.h("Wiki_WikiMovToFragment", r19.toString());
        x r20 = new x(getContext(), this, Y90(), r13, r18, r6, r9);
        this.w = r20;
        r20.execute();
        return;
    L29:
        r18 = null;
        goto L30
    L42:
        return;
    L20:
        r12 = null;
        goto L21
    L14:
        r8 = null;
        goto L15
    L10:
        r5 = null;
        goto L11
    L40:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static final void ca0(WikiMovToFragment r5, TreeNode r6) {
        r5.getClass();
        tt5.a.h("Wiki_WikiMovToFragment", "handleMove()...focusToken = " + du5.b.g(r6.wiki_token));
        if (f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L5;
        Toast.cancelLoading();
        r5.ea0(r6);
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        e r0 = e.a.a;
        int r1 = com.bytedance.ee.bear.middleground.permission.b.a;
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.wiki.mobile.single_page_owner", false) == true) goto L8;
    L14:
        Flowable r2 = Flowable.just(Boolean.FALSE);
    L15:
        r5.l.add(r2.subscribe(new tq5.c(r5, r6), new tq5.d(r5, r6)));
        return;
    L8:
        if (TextUtils.isEmpty(r5.Y90().getSpaceId()) == true) goto L14;
        if (TextUtils.isEmpty(r5.Y90().getSrcSpaceId()) == true) goto L14;
        if (TextUtils.equals(r5.Y90().getSpaceId(), r5.Y90().getSrcSpaceId()) == true) goto L14;
        NetService r3 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        r2 = Flowable.zip(l0.c(r3).a(new GetSpaceInfoPuller.Params(r5.Y90().getSrcSpaceId())), l0.c(r3).a(new GetSpaceInfoPuller.Params(r5.Y90().getSpaceId())), tq5.e.a).onErrorReturnItem(Boolean.FALSE);
        goto L15
    }

    public static final void da0(WikiMovToFragment r6, TreeNode r7) {
        r6.getClass();
        tt5.a.h("Wiki_WikiMovToFragment", "showMoveConfirmDialog()...focusToken = " + du5.b.g(r7.wiki_token) + ", srcIsLock = " + r6.Y90().getSrcIsLock());
        if (r6.Y90().getSrcIsLock() != 0) goto L13;
        gq5.d.m(r6.Y90().getSpaceId());
        WikiDialogs r0 = r6.k;
        Context r1 = r6.getContext();
        boolean r2 = r6.Y90().getSrcIsShortcut();
        k r3 = new k(r6, r7);
        l r8 = new l(r6);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "confirm");
        Intrinsics.checkNotNullParameter(r8, DocFeed$Value$Result.CANCEL);
        r0.c();
        if (r1 == null) goto L15;
        fp5.a r9 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) new fp5.a(r1).messageTextColor(2131106622)).messageGravity(8388611)).message(2131887517)).title(2131889891)).titleColor(2131106622)).titleBold(true);
        if (r2 == true) goto L9;
        String r4 = r1.getString(2131889890);
    L10:
        Intrinsics.checkNotNull(r4);
        r9.b(r4);
        fp5.a r10 = (fp5.a) r9.cancelOnTouchOutside(false);
        r10.e = false;
        UDDialog r11 = ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r10.maskAlpha(0.3f)).gravity(17)).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131888317).onClickListener(new n(r3)).textColorRes(2131102093))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131888316).onClickListener(new o(r8)).textColorRes(2131106622))).build();
        r0.d = r11;
        if (r11 == null) goto L16;
        WikiDialogs.b(r11);
        return;
    L16:
        return;
    L9:
        r4 = "";
        goto L10
    L15:
        return;
    L13:
        r6.ea0(r7);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ((ApplyMoveViewModel) new ViewModelProvider(this).get(ApplyMoveViewModel.class)).getApplyState().observe(getViewLifecycleOwner(), new tq5.f(this));
    }
}
