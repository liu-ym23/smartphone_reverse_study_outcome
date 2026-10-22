package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.R;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.SelectItemView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 D2\u00020\u0001:\u0003BCDB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bH\u0002J\b\u0010?\u001a\u00020#H\u0002J\b\u0010@\u001a\u00020:H\u0002J\b\u0010A\u001a\u00020#H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006E"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "descriptionFromXml", "Landroid/widget/TextView;", "getDescriptionFromXml", "()Landroid/widget/TextView;", "setDescriptionFromXml", "(Landroid/widget/TextView;)V", "deleteCurrentOnlyFromXml", "Lcom/bytedance/ee/bear/widgets/SelectItemView;", "getDeleteCurrentOnlyFromXml", "()Lcom/bytedance/ee/bear/widgets/SelectItemView;", "setDeleteCurrentOnlyFromXml", "(Lcom/bytedance/ee/bear/widgets/SelectItemView;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "deleteWithSubFromXml", "getDeleteWithSubFromXml", "setDeleteWithSubFromXml", "cancelFromXml", "Lcom/larksuite/component/universe_design/button/UDButton;", "getCancelFromXml", "()Lcom/larksuite/component/universe_design/button/UDButton;", "setCancelFromXml", "(Lcom/larksuite/component/universe_design/button/UDButton;)V", "confirmFromXml", "getConfirmFromXml", "setConfirmFromXml", "clearFromXmlViewCache", "", "onDestroyView", "params", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ParamsViewModel;", "getParams", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/dialog/WikiDeleteConfirmDialog$ParamsViewModel;", "params$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initView", "bindView", "bindListener", "setSettingClick", "menuId", "", "setItemStyleEnable", "enable", "", "item", "setConfirmClick", "getSelectSetting", "onStart", "ParamsViewModel", "ViewDelegate", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiDeleteConfirmDialog extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int o = 0;
    public TextView h;
    public SelectItemView i;
    public BaseTitleBar j;
    public SelectItemView k;
    public UDButton l;
    public UDButton m;
    public final Lazy n;

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

        public final void setDelegate(b r1) {
            this.delegate = r1;
        }

        public final void setMyLib(boolean r1) {
            this.isMyLib = r1;
        }

        public final void setNodePerm(WikNodePerm r1) {
            this.nodePerm = r1;
        }

        public final void setSpaceName(String r1) {
            this.spaceName = r1;
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
        View r0 = this.m;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131367639);
    L8:
        this.m = (UDButton) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (UDButton) r0;
    }

    public final SelectItemView aa0() {
        ConstraintLayout r0 = this.i;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368778);
    L8:
        this.i = (SelectItemView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SelectItemView) r0;
    }

    public final SelectItemView ba0() {
        ConstraintLayout r0 = this.k;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131368781);
    L8:
        this.k = (SelectItemView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SelectItemView) r0;
    }

    public final ParamsViewModel ca0() {
        return (ParamsViewModel) this.n.getValue();
    }

    public WikiDeleteConfirmDialog() {
        this.n = LazyKt.lazy(new WikiDeleteConfirmDialog$params$2(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        zo5.b r3 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r4 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L11:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.FrameLayout");
        r3.p((FrameLayout) r4);
        return;
    L14:
        return;
    }

    public final void da0(int r4) {
        if (r4 != (-1)) goto L6;
        aa0().setSelected(false);
        ba0().setSelected(false);
        Z90().setEnabled(false);
        return;
    L6:
        if (r4 != 2131368778) goto L9;
        aa0().setSelected(true);
        ba0().setSelected(false);
        Z90().setEnabled(true);
        return;
    L9:
        if (r4 != 2131368781) goto L14;
        aa0().setSelected(false);
        ba0().setSelected(true);
        Z90().setEnabled(true);
        return;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r5, r6);
        da0(-1);
        ParamsViewModel r7 = ca0();
        boolean r8 = false;
        if (r7 != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        int r1 = WikiDialogs.n;
        ParamsViewModel r2 = ca0();
        View r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.getSpaceName();
    L12:
        String r10 = WikiDialogs.a.a(r9, r4, getContext());
        View r11 = this.h;
        if (r11 != null) goto L19;
        View r12 = getView();
        if (r12 == null) goto L17;
        r11 = r12.findViewById(2131368849);
    L18:
        this.h = (TextView) r11;
        goto L19
    L17:
        r11 = null;
    L19:
        TextView r13 = (TextView) r11;
        if (r13 == null) goto L22;
        r13.setText(r10);
    L22:
        ParamsViewModel r14 = ca0();
        if (r14 == null) goto L29;
        WikNodePerm r15 = r14.getNodePerm();
        if (r15 == null) goto L29;
        if (r15.show_single_delete != true) goto L29;
        r8 = true;
    L29:
        SelectItemView r16 = aa0();
        Context r0 = getContext();
        if (r0 == null) goto L36;
        UDCheckBox r17 = r16.getCheckBox();
        Resources r18 = r0.getResources();
        if (r8 == false) goto L34;
        int r19 = 2131106622;
    L35:
        r16.setTextColor(r18.getColor(r19));
        r17.setEnabled(r8);
        goto L36
    L34:
        r19 = 2131106610;
    L36:
        View r20 = this.j;
        if (r20 != null) goto L43;
        View r21 = getView();
        if (r21 == null) goto L41;
        r20 = r21.findViewById(2131388775);
    L42:
        this.j = (BaseTitleBar) r20;
        goto L43
    L41:
        r20 = null;
    L43:
        ((BaseTitleBar) r20).setLeftClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.a(this));
        aa0().setOnClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.b(this));
        ba0().setOnClickListener(new c(this));
        View r22 = this.l;
        if (r22 != null) goto L49;
        View r23 = getView();
        if (r23 == null) goto L48;
        r3 = r23.findViewById(2131365114);
    L48:
        this.l = (UDButton) r3;
        r22 = r3;
    L49:
        ((UDButton) r22).setOnClickListener(new d(this));
        Z90().setOnClickListener(new e(this));
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        if (r7.isMyLib() != true) goto L7;
        r9 = true;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131568269, r3, false);
    }
}
