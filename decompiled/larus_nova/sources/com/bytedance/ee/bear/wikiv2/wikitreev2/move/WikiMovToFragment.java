package com.bytedance.ee.bear.wikiv2.wikitreev2.move;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
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
import com.larus.nova.R;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aJ\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0014J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001aH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/move/WikiMovToFragment;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/create/WikiCreateToFragment;", "<init>", "()V", "moveCommand", "Lcom/bytedance/ee/bear/list/selector/ICommand;", LiveCommonConstants.REASON_ON_DEDTROY, "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "observeApplyMoveState", "initAction", "responseMoveClick", "focusTreeNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "handleMove", "doMove", "showMoveConfirmDialog", "needShowSinglePageOwnerTips", "Lio/reactivex/Flowable;", "", "requestMoveTargetEnable", "focusToken", "", "dispose", "setResultThenFinish", "finishWhenApplySuccess", WikiFolderPushPlugin.WIKI_TOKEN, "oldToken", "getDisableToken", "doFocusChange", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiMovToFragment extends WikiCreateToFragment {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f241594x = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public td5.d f241595w;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f241596a = null;

        static {
            int[] r100 = new int[SelectorType.values().length];
            r100[SelectorType.SPACE_MOVE_TO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SelectorType.WIKI_MOVE_TO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f241596a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiMovToFragment f241597a;

        public c(WikiMovToFragment r100) {
            this.f241597a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            WikiTreeCtrlView r101 = this.f241597a.f241390o;
            if (r101 == null) goto L6;
            TreeNode r102 = r101.getFocusTreeNode();
            if (r102 == null) goto L6;
        L11:
            tt5.a.h("Wiki_WikiMovToFragment", "click confirm, focusToken = " + du5.b.g(r102.wiki_token));
            WikiMovToFragment r103 = this.f241597a;
            int r104 = WikiMovToFragment.f241594x;
            r103.getClass();
            String r105 = r102.wiki_token;
            tt5.a.h("Wiki_WikiMovToFragment", "responseMoveClick()...focusToken = " + du5.b.g(r105));
            qc5.a.j();
            r103.f241387l.clear();
            Toast.showLoading(r103.getContext(), r103.getString(R.string.Doc_Facade_Loading));
            Intrinsics.checkNotNull(r105);
            WikiTreeCtrlView r106 = r103.f241390o;
            if (r106 == null) goto L20;
            TreeNode r107 = r106.g(r105);
            if (r107 == null) goto L20;
            NetService r108 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
            if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.c(r107.wiki_node_type) == false) goto L19;
            Flowable r109 = l0.b(r108).a(new GetRootPermPuller.Params(r103.Y90().getSpaceId())).map(g.f547153a).onErrorReturnItem(Boolean.TRUE);
            Intrinsics.checkNotNull(r109);
        L21:
            r103.f241387l.add(r109.subscribe(new i(r103, r102), new j(r103, r102)));
            return;
        L19:
            r109 = new GetNodePermPuller(r108).d(new GetNodePermPuller.Params(r103.Y90().getSpaceId(), r105)).map(h.f547154a).onErrorReturnItem(Boolean.TRUE);
            Intrinsics.checkNotNull(r109);
        L20:
            r109 = Flowable.just(Boolean.TRUE);
        L6:
            r102 = new TreeNode();
            WikiTreeCtrlView r110 = this.f241597a.f241390o;
            if (r110 == null) goto L9;
            String r111 = r110.getFocusToken();
        L10:
            r102.wiki_token = r111;
            goto L11
        L9:
            r111 = null;
            goto L10
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiMovToFragment f241598a;

        public d(WikiMovToFragment r100) {
            this.f241598a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            WikiTreeCtrlView r101 = this.f241598a.f241390o;
            if (r101 == null) goto L5;
            String r102 = r101.getFocusToken();
        L7:
            if (TextUtils.isEmpty(r102) == true) goto L10;
            Toast.showFailureText(this.f241598a.getContext(), R.string.Doc_Wiki_Move_SelectFather);
            return;
        L10:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void initAction() {
        Button r100 = this.f241392q;
        if (r100 == null) goto L5;
        com.bytedance.ee.bear.wikiv2.wikitreev2.create.b r101 = new com.bytedance.ee.bear.wikiv2.wikitreev2.create.b(this, r100);
    L6:
        this.f241385j = r101;
        if (r101 == null) goto L9;
        r101.f241402c = false;
    L9:
        if (r101 == null) goto L12;
        r101.a(new c(this), new d(this));
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final String Z90() {
        String r100 = Y90().getSrcToken();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("Wiki_WikiMovToFragment", "onDestroy()...");
        this.f241387l.clear();
        td5.d r100 = this.f241595w;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    public WikiMovToFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment
    public final void X90(String r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        super.X90(r100);
        com.bytedance.ee.bear.wikiv2.wikitreev2.create.b r101 = this.f241385j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
    L11:
        boolean r102 = false;
    L12:
        r101.f241402c = r102;
        return;
    L7:
        if (TextUtils.equals(r100, Y90().getSrcToken()) == true) goto L11;
        if (TextUtils.equals(r100, Y90().getSrcParentToken()) == true) goto L11;
        r102 = true;
        goto L12
    }

    public final void ea0(TreeNode r110) {
        String r100 = r110.wiki_token;
        tt5.a.h("Wiki_WikiMovToFragment", "doMove()...focusToken = " + du5.b.g(r100));
        Bundle r101 = getArguments();
        WikNodePerm r102 = null;
        if (r101 == null) goto L5;
        SelectorConfig r103 = (SelectorConfig) r101.getParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG);
    L6:
        if (r103 == null) goto L40;
        WikiTreeCtrlView r104 = this.f241390o;
        if (r104 == null) goto L10;
        Boolean r105 = Boolean.valueOf(r104.n());
    L11:
        WikiTreeCtrlView r106 = this.f241390o;
        if (r106 == null) goto L14;
        String r107 = r106.getRootToken();
    L15:
        boolean r108 = TextUtils.equals(r107, r100);
        WikiTreeCtrlView r109 = this.f241390o;
        if (r109 == null) goto L20;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.WIKI_TOKEN);
        String r111 = r109.getViewModel().getTitle(r100);
        if (r111 != null) goto L21;
        r111 = "";
    L21:
        WikiSelectorBean r112 = new WikiSelectorBean();
        r112.f241131d = r100;
        r112.f241134g = r111;
        r112.f241136i = r110.obj_token;
        r112.f241137j = r110.obj_type;
        r112.f241141n = Intrinsics.areEqual(r105, Boolean.TRUE);
        int r113 = b.f241596a[r103.f229369a.ordinal()];
        if (r113 != 1) goto L24;
        Bundle r114 = getArguments();
        if (r114 == null) goto L37;
        SpaceSelectorBean r115 = (SpaceSelectorBean) r114.getParcelable("extra_space_bean");
    L38:
        com.bytedance.ee.bear.list.move.j r116 = new com.bytedance.ee.bear.list.move.j(getContext(), this, r112, Y90().getSpaceId(), r115, r108);
        this.f241595w = r116;
        r116.execute();
        return;
    L37:
        r115 = null;
        goto L38
    L24:
        if (r113 != 2) goto L42;
        Bundle r117 = getArguments();
        if (r117 == null) goto L29;
        WikiSelectorBean r118 = (WikiSelectorBean) r117.getParcelable("extra_wiki_bean");
    L30:
        StringBuilder r119 = new StringBuilder("doMove()...wikiNodePerm = ");
        if (r118 == null) goto L33;
        r102 = r118.f241143p;
    L33:
        r119.append(r102);
        tt5.a.h("Wiki_WikiMovToFragment", r119.toString());
        x r120 = new x(getContext(), this, Y90(), r112, r118, r103, r108);
        this.f241595w = r120;
        r120.execute();
        return;
    L29:
        r118 = null;
        goto L30
    L42:
        return;
    L20:
        r111 = null;
        goto L21
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    L40:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void ca0(WikiMovToFragment r100, TreeNode r101) {
        r100.getClass();
        tt5.a.h("Wiki_WikiMovToFragment", "handleMove()...focusToken = " + du5.b.g(r101.wiki_token));
        if (f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L5;
        Toast.cancelLoading();
        r100.ea0(r101);
        return;
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        e r102 = e.a.f499003a;
        int r103 = com.bytedance.ee.bear.middleground.permission.b.f233101a;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.wiki.mobile.single_page_owner", false) == true) goto L8;
    L14:
        Flowable r104 = Flowable.just(Boolean.FALSE);
    L15:
        r100.f241387l.add(r104.subscribe(new tq5.c(r100, r101), new tq5.d(r100, r101)));
        return;
    L8:
        if (TextUtils.isEmpty(r100.Y90().getSpaceId()) == true) goto L14;
        if (TextUtils.isEmpty(r100.Y90().getSrcSpaceId()) == true) goto L14;
        if (TextUtils.equals(r100.Y90().getSpaceId(), r100.Y90().getSrcSpaceId()) == true) goto L14;
        NetService r105 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        r104 = Flowable.zip(l0.c(r105).a(new GetSpaceInfoPuller.Params(r100.Y90().getSrcSpaceId())), l0.c(r105).a(new GetSpaceInfoPuller.Params(r100.Y90().getSpaceId())), tq5.e.f547151a).onErrorReturnItem(Boolean.FALSE);
        goto L15
    }

    public static final void da0(WikiMovToFragment r100, TreeNode r101) {
        r100.getClass();
        tt5.a.h("Wiki_WikiMovToFragment", "showMoveConfirmDialog()...focusToken = " + du5.b.g(r101.wiki_token) + ", srcIsLock = " + r100.Y90().getSrcIsLock());
        if (r100.Y90().getSrcIsLock() != 0) goto L13;
        gq5.d.m(r100.Y90().getSpaceId());
        WikiDialogs r102 = r100.f241386k;
        Context r103 = r100.getContext();
        boolean r104 = r100.Y90().getSrcIsShortcut();
        k r105 = new k(r100, r101);
        l r106 = new l(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r105, "confirm");
        Intrinsics.checkNotNullParameter(r106, "cancel");
        r102.c();
        if (r103 == null) goto L15;
        fp5.a r107 = new fp5.a(r103).messageTextColor(R.color.text_title).messageGravity(GravityCompat.START).message(R.string.CreationMobile_Wiki_Permission_OnceRemoved_Placeholder).title(R.string.LarkCCM_Workspace_MoveConfirm_Title_Mob).titleColor(R.color.text_title).titleBold(true);
        if (r104 == true) goto L9;
        String r108 = r103.getString(R.string.LarkCCM_Workspace_MoveConfirmPage_Wiki_Subtitle_Mob);
    L10:
        Intrinsics.checkNotNull(r108);
        r107.b(r108);
        fp5.a r109 = r107.cancelOnTouchOutside(false);
        r109.f478274e = false;
        UDDialog r110 = r109.maskAlpha(0.3f).gravity(17).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Doc_Wiki_Confirm).onClickListener(new n(r105)).textColorRes(R.color.function_danger_fill_default)).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.Doc_Wiki_Cancel).onClickListener(new o(r106)).textColorRes(R.color.text_title)).build();
        r102.f242253d = r110;
        if (r110 == null) goto L16;
        WikiDialogs.b(r110);
        return;
    L16:
        return;
    L9:
        r108 = "";
        goto L10
    L15:
        return;
    L13:
        r100.ea0(r101);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((ApplyMoveViewModel) new ViewModelProvider(this).get(ApplyMoveViewModel.class)).getApplyState().observe(getViewLifecycleOwner(), new tq5.f(this));
    }
}
