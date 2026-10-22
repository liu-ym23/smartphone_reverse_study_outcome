package com.bytedance.ee.bear.sheet.actionsheet;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.independentpanel.IndependentDialogFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetFragment;", "Lcom/bytedance/ee/bear/document/independentpanel/IndependentDialogFragment;", "<init>", "()V", "mViewModel", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetViewModel;", "mAdapter", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter;", RootDescription.ROOT_ELEMENT, "Landroid/widget/FrameLayout;", "panel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initPanel", "initRecyclerView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateData", "sheetsActionSheetModel", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetModel;", "getMeasuredHeight", "", "updateDragViewHeight", "exitAnimDuration", "", "getExitAnimDuration", "()J", "setViewModelInactive", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetFragment extends IndependentDialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f237280n = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ActionSheetViewModel f237281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ActionSheetItemAdapter f237282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f237283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CommonActionPanelLayout f237284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f237285l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f237286m;

    public static final class a {
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ActionSheetFragment f237287c;

        public b(ActionSheetFragment r100) {
            this.f237287c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            ActionSheetViewModel r101 = this.f237287c.f237281h;
            if (r101 == null) goto L6;
            r101.onCancel();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.independentpanel.IndependentDialogFragment, v15.b
    public final void Yf() {
        ActionSheetViewModel r100 = this.f237281h;
        if (r100 == null) goto L6;
        r100.setActive(false);
        return;
    }

    public ActionSheetFragment() {
        this.f237286m = 200;
    }

    public final void aa0() {
        float r100 = n.t();
        Configuration r101 = getResources().getConfiguration();
        int r102 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        float r104 = 0.8f;
    L11:
        float r105 = r100 * r104;
        CommonActionPanelLayout r106 = this.f237284k;
        if (r106 == null) goto L14;
        r106.measure(0, 0);
    L14:
        CommonActionPanelLayout r107 = this.f237284k;
        if (r107 == null) goto L17;
        r102 = r107.getMeasuredHeight();
    L17:
        float r108 = Math.min(r102, r105);
        CommonActionPanelLayout r109 = this.f237284k;
        if (r109 == null) goto L20;
        r109.l(0.0f, r108, r108);
    L20:
        CommonActionPanelLayout r110 = this.f237284k;
        if (r110 == null) goto L26;
        com.bytedance.ee.bear.facade.common.widget.d r111 = r110.f240267c;
        if (r111 == null) goto L27;
        r111.l(r108);
        return;
    L27:
        return;
    L26:
        return;
    L10:
        r104 = 0.6f;
        goto L11
    L5:
        if (2 != r101.orientation) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        WindowManager.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        Window r102 = r100.getWindow();
    L6:
        if (r102 == null) goto L8;
        r101 = r102.getAttributes();
    L8:
        if (r101 == null) goto L10;
        r101.gravity = 80;
    L10:
        if (r101 == null) goto L12;
        r101.y = k.e(getContext());
    L12:
        if (r101 == null) goto L14;
        r101.windowAnimations = R.style.ActionSheetDialogAnimation;
    L14:
        if (r102 == null) goto L16;
        r102.setAttributes(r101);
    L16:
        if (r102 == null) goto L19;
        r102.setLayout(-1, -1);
    L19:
        if (r102 == null) goto L22;
        r102.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.sheet.action_sheet_cancelable") == true) goto L25;
        setCancelable(false);
        return;
    L25:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.independentpanel.IndependentDialogFragment, v15.b
    public final long q30() {
        return this.f237286m;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        aa0();
        FrameLayout r101 = this.f237283j;
        if (r101 == null) goto L6;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).detachWatermark(r101);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ActionSheetViewModel r101 = (ActionSheetViewModel) q.a(this, ActionSheetViewModel.class);
        this.f237281h = r101;
        if (r101 == null) goto L8;
        MutableLiveData<d> r102 = r101.getSheetsActionSheetModel();
        if (r102 == null) goto L9;
        r102.observe(this, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f237283j = (FrameLayout) r100.findViewById(R.id.sheets_actionsheet_root);
        r100.setOnClickListener(new b(this));
        CommonActionPanelLayout r102 = (CommonActionPanelLayout) r100.findViewById(R.id.sheets_actionsheet_panel);
        this.f237284k = r102;
        if (r102 == null) goto L5;
        r102.setOnActionListener(new com.bytedance.ee.bear.sheet.actionsheet.a(this));
    L5:
        RecyclerView r103 = (RecyclerView) r100.findViewById(R.id.sheets_actionsheet_list);
        this.f237285l = r103;
        if (r103 == null) goto L8;
        r103.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        ActionSheetItemAdapter r104 = new ActionSheetItemAdapter();
        this.f237282i = r104;
        ActionSheetViewModel r105 = this.f237281h;
        if (r105 == null) goto L13;
        r104.f237290b = new ActionSheetFragment$initRecyclerView$1$1(r105);
        ActionSheetItemAdapter r106 = this.f237282i;
        if (r106 == null) goto L13;
        r106.f237291c = new ActionSheetFragment$initRecyclerView$1$2(r105);
    L13:
        RecyclerView r107 = this.f237285l;
        if (r107 == null) goto L16;
        r107.setAdapter(this.f237282i);
    L16:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(this.f237283j);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.sheets_actionsheet_fragment, r101, false);
    }
}
