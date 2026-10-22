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
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.independentpanel.IndependentDialogFragment;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetFragment;", "Lcom/bytedance/ee/bear/document/independentpanel/IndependentDialogFragment;", "<init>", "()V", "mViewModel", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetViewModel;", "mAdapter", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetItemAdapter;", "root", "Landroid/widget/FrameLayout;", "panel", "Lcom/bytedance/ee/bear/widgets/panel/CommonActionPanelLayout;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initPanel", "initRecyclerView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateData", "sheetsActionSheetModel", "Lcom/bytedance/ee/bear/sheet/actionsheet/ActionSheetModel;", "getMeasuredHeight", "", "updateDragViewHeight", "exitAnimDuration", "", "getExitAnimDuration", "()J", "setViewModelInactive", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionSheetFragment extends IndependentDialogFragment {
    public static final /* synthetic */ int n = 0;
    public ActionSheetViewModel h;
    public ActionSheetItemAdapter i;
    public FrameLayout j;
    public CommonActionPanelLayout k;
    public RecyclerView l;
    public final long m;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ ActionSheetFragment c;

        public b(ActionSheetFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            ActionSheetViewModel r2 = this.c.h;
            if (r2 == null) goto L6;
            r2.onCancel();
            return;
        }
    }

    static {
    }

    public final void Yf() {
        ActionSheetViewModel r0 = this.h;
        if (r0 == null) goto L6;
        r0.setActive(false);
        return;
    }

    public ActionSheetFragment() {
        this.m = 200;
    }

    public final void aa0() {
        float r0 = n.t();
        Configuration r1 = getResources().getConfiguration();
        int r2 = 0;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        float r4 = 0.8f;
    L11:
        float r5 = r0 * r4;
        CommonActionPanelLayout r6 = this.k;
        if (r6 == null) goto L14;
        r6.measure(0, 0);
    L14:
        CommonActionPanelLayout r7 = this.k;
        if (r7 == null) goto L17;
        r2 = r7.getMeasuredHeight();
    L17:
        float r8 = Math.min(r2, r5);
        CommonActionPanelLayout r9 = this.k;
        if (r9 == null) goto L20;
        r9.l(0.0f, r8, r8);
    L20:
        CommonActionPanelLayout r10 = this.k;
        if (r10 == null) goto L26;
        com.bytedance.ee.bear.facade.common.widget.d r11 = r10.c;
        if (r11 == null) goto L27;
        r11.l(r8);
        return;
    L27:
        return;
    L26:
        return;
    L10:
        r4 = 0.6f;
        goto L11
    L5:
        if (2 != r1.orientation) goto L7;
        r3 = true;
        goto L8
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onStart();
        Dialog r0 = getDialog();
        WindowManager.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        Window r2 = r0.getWindow();
    L6:
        if (r2 == null) goto L8;
        r1 = r2.getAttributes();
    L8:
        if (r1 == null) goto L10;
        r1.gravity = 80;
    L10:
        if (r1 == null) goto L12;
        r1.y = k.e(getContext());
    L12:
        if (r1 == null) goto L14;
        r1.windowAnimations = 2131951621;
    L14:
        if (r2 == null) goto L16;
        r2.setAttributes(r1);
    L16:
        if (r2 == null) goto L19;
        r2.setLayout(-1, -1);
    L19:
        if (r2 == null) goto L22;
        r2.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.sheet.action_sheet_cancelable") == true) goto L25;
        setCancelable(false);
        return;
    L25:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final long q30() {
        return this.m;
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        aa0();
        FrameLayout r5 = this.j;
        if (r5 == null) goto L6;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).detachWatermark(r5);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r5);
        return;
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment*/.onCreate(r2);
        ActionSheetViewModel r3 = (ActionSheetViewModel) q.a(this, ActionSheetViewModel.class);
        this.h = r3;
        if (r3 == null) goto L8;
        MutableLiveData<d> r4 = r3.getSheetsActionSheetModel();
        if (r4 == null) goto L9;
        r4.observe(this, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r2, r3);
        this.j = (FrameLayout) r2.findViewById(2131386212);
        r2.setOnClickListener(new b(this));
        CommonActionPanelLayout r4 = (CommonActionPanelLayout) r2.findViewById(2131386211);
        this.k = r4;
        if (r4 == null) goto L5;
        r4.setOnActionListener(new com.bytedance.ee.bear.sheet.actionsheet.a(this));
    L5:
        RecyclerView r5 = r2.findViewById(2131386210);
        this.l = r5;
        if (r5 == null) goto L8;
        r5.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        ActionSheetItemAdapter r6 = new ActionSheetItemAdapter();
        this.i = r6;
        ActionSheetViewModel r7 = this.h;
        if (r7 == null) goto L13;
        r6.b = new ActionSheetFragment$initRecyclerView$1$1(r7);
        ActionSheetItemAdapter r8 = this.i;
        if (r8 == null) goto L13;
        r8.c = new ActionSheetFragment$initRecyclerView$1$2(r7);
    L13:
        RecyclerView r9 = this.l;
        if (r9 == null) goto L16;
        r9.setAdapter(this.i);
    L16:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(this.j);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564591, r3, false);
    }
}
