package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.SelectItemView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0003BCDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bH\u0002J\b\u0010?\u001a\u00020#H\u0002J\b\u0010@\u001a\u00020:H\u0002J\b\u0010A\u001a\u00020#H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "descriptionFromXml", "Landroid/widget/TextView;", "getDescriptionFromXml", "()Landroid/widget/TextView;", "setDescriptionFromXml", "(Landroid/widget/TextView;)V", "deleteCurrentOnlyFromXml", "Lcom/bytedance/ee/bear/widgets/SelectItemView;", "getDeleteCurrentOnlyFromXml", "()Lcom/bytedance/ee/bear/widgets/SelectItemView;", "setDeleteCurrentOnlyFromXml", "(Lcom/bytedance/ee/bear/widgets/SelectItemView;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "deleteWithSubFromXml", "getDeleteWithSubFromXml", "setDeleteWithSubFromXml", "cancelFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getCancelFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setCancelFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "confirmFromXml", "getConfirmFromXml", "setConfirmFromXml", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ParamsViewModel;", "getParams", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ParamsViewModel;", "params$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "bindView", "bindListener", "setSettingClick", "menuId", "", "setItemStyleEnable", "enable", "", MapController.ITEM_LAYER_TAG, "setConfirmClick", "getSelectSetting", WidgetCostModule.TYPE_ON_START, "ParamsViewModel", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiDeleteConfirmDialog extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f242439o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f242440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SelectItemView f242441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseTitleBar f242442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SelectItemView f242443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public UDButton f242444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UDButton f242445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f242446n;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ParamsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "delegate", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ViewDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ViewDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ViewDelegate;)V", "nodePerm", "Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "getNodePerm", "()Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;", "setNodePerm", "(Lcom/bytedance/ee/bear/contract/route/parcelable/WikNodePerm;)V", "isMyLib", "", "()Z", "setMyLib", "(Z)V", "spaceName", "", "getSpaceName", "()Ljava/lang/String;", "setSpaceName", "(Ljava/lang/String;)V", "clear", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParamsViewModel extends ViewModel {
        private b delegate;
        private boolean isMyLib;
        private WikNodePerm nodePerm;
        private String spaceName;

        public final void clear() {
            this.delegate = null;
            this.nodePerm = null;
            this.isMyLib = false;
            this.spaceName = null;
        }

        public ParamsViewModel() {
        }

        public final b getDelegate() {
            return this.delegate;
        }

        public final WikNodePerm getNodePerm() {
            return this.nodePerm;
        }

        public final String getSpaceName() {
            return this.spaceName;
        }

        public final boolean isMyLib() {
            return this.isMyLib;
        }

        public final void setDelegate(b r100) {
            this.delegate = r100;
        }

        public final void setMyLib(boolean r100) {
            this.isMyLib = r100;
        }

        public final void setNodePerm(WikNodePerm r100) {
            this.nodePerm = r100;
        }

        public final void setSpaceName(String r100) {
            this.spaceName = r100;
        }
    }

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void onCancel();
    }

    static {
    }

    public final UDButton Z90() {
        View r100 = this.f242445m;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.confirm);
    L8:
        this.f242445m = (UDButton) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (UDButton) r100;
    }

    public final SelectItemView aa0() {
        View r100 = this.f242441i;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.deleteCurrentOnly);
    L8:
        this.f242441i = (SelectItemView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SelectItemView) r100;
    }

    public final SelectItemView ba0() {
        View r100 = this.f242443k;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.deleteWithSub);
    L8:
        this.f242443k = (SelectItemView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SelectItemView) r100;
    }

    public final ParamsViewModel ca0() {
        return (ParamsViewModel) this.f242446n.getValue();
    }

    public WikiDeleteConfirmDialog() {
        this.f242446n = LazyKt.lazy(new WikiDeleteConfirmDialog$params$2(this));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f242440h = null;
        this.f242441i = null;
        this.f242442j = null;
        this.f242443k = null;
        this.f242444l = null;
        this.f242445m = null;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L13;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L14;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -2;
        r102.softInputMode = 16;
        r102.gravity = 80;
        r101.setAttributes(r102);
        r101.setDimAmount(0.2f);
        r101.setWindowAnimations(R.style.ActionSheetAnimation);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        zo5.b r103 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r104 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L11:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.FrameLayout");
        r103.p((FrameLayout) r104);
        return;
    L14:
        return;
    }

    public final void da0(int r100) {
        if (r100 != (-1)) goto L6;
        aa0().setSelected(false);
        ba0().setSelected(false);
        Z90().setEnabled(false);
        return;
    L6:
        if (r100 != R.id.deleteCurrentOnly) goto L9;
        aa0().setSelected(true);
        ba0().setSelected(false);
        Z90().setEnabled(true);
        return;
    L9:
        if (r100 != R.id.deleteWithSub) goto L14;
        aa0().setSelected(false);
        ba0().setSelected(true);
        Z90().setEnabled(true);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        da0(-1);
        ParamsViewModel r102 = ca0();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        int r105 = WikiDialogs.f242249n;
        ParamsViewModel r106 = ca0();
        View r107 = null;
        if (r106 == null) goto L11;
        String r108 = r106.getSpaceName();
    L12:
        String r109 = WikiDialogs.a.a(r104, r108, getContext());
        View r110 = this.f242440h;
        if (r110 != null) goto L19;
        View r111 = getView();
        if (r111 == null) goto L17;
        r110 = r111.findViewById(R.id.description);
    L18:
        this.f242440h = (TextView) r110;
        goto L19
    L17:
        r110 = null;
    L19:
        TextView r112 = (TextView) r110;
        if (r112 == null) goto L22;
        r112.setText(r109);
    L22:
        ParamsViewModel r113 = ca0();
        if (r113 == null) goto L29;
        WikNodePerm r114 = r113.getNodePerm();
        if (r114 == null) goto L29;
        if (r114.show_single_delete != true) goto L29;
        r103 = true;
    L29:
        SelectItemView r115 = aa0();
        Context r116 = getContext();
        if (r116 == null) goto L36;
        UDCheckBox r117 = r115.getCheckBox();
        Resources r118 = r116.getResources();
        if (r103 == false) goto L34;
        int r119 = R.color.text_title;
    L35:
        r115.setTextColor(r118.getColor(r119));
        r117.setEnabled(r103);
        goto L36
    L34:
        r119 = R.color.text_disable;
    L36:
        View r120 = this.f242442j;
        if (r120 != null) goto L43;
        View r121 = getView();
        if (r121 == null) goto L41;
        r120 = r121.findViewById(R.id.titleBar);
    L42:
        this.f242442j = (BaseTitleBar) r120;
        goto L43
    L41:
        r120 = null;
    L43:
        ((BaseTitleBar) r120).setLeftClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.a(this));
        aa0().setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.b(this));
        ba0().setOnClickListener(new c(this));
        View r122 = this.f242444l;
        if (r122 != null) goto L49;
        View r123 = getView();
        if (r123 == null) goto L48;
        r107 = r123.findViewById(R.id.cancel);
    L48:
        this.f242444l = (UDButton) r107;
        r122 = r107;
    L49:
        ((UDButton) r122).setOnClickListener(new d(this));
        Z90().setOnClickListener(new e(this));
        return;
    L11:
        r108 = null;
        goto L12
    L5:
        if (r102.isMyLib() != true) goto L7;
        r104 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_tree_del_confirm_dialog, r101, false);
    }
}
