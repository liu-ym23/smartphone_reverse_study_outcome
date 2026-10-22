package com.bytedance.ee.bear.block.jira;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002J\u0012\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "jiraViewModel", "Lcom/bytedance/ee/bear/block/jira/JiraViewModel;", "dragView", "Lcom/bytedance/ee/bear/facade/common/widget/DragView;", "dragViewContainer", "Landroid/view/View;", "jiraActionRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "jiraActionAdapter", "Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter;", "jiraTitleBar", "jiraTitle", "Landroid/widget/TextView;", "jiraDesc", "minHeight", "", "midHeight", "maxHeight", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initDragView", "bindView", "jiraActionData", "Lcom/bytedance/ee/bear/block/jira/JiraActionData;", "updateDragViewHeight", "Companion", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraActionFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f216572p = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JiraViewModel f216573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.facade.common.widget.d f216574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f216575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f216576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JiraActionAdapter f216577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f216578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f216579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f216580o;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JiraActionFragment f216581a;

        public b(JiraActionFragment r100) {
            this.f216581a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JiraActionData r101 = (JiraActionData) r100;
            JiraActionFragment r102 = this.f216581a;
            int r103 = JiraActionFragment.f216572p;
            View r104 = r102.getView();
            JiraActionData.ActionSheetItem[] r105 = null;
            if (r104 == null) goto L8;
            if (r101 == null) goto L6;
            String r106 = r101.getId();
        L7:
            View r107 = r104.findViewWithTag(r106);
        L9:
            r102.f216578m = r107;
            if (r107 == null) goto L24;
            r107.setVisibility(0);
            TextView r108 = (TextView) r107.findViewWithTag("title");
            if (r108 == null) goto L17;
            if (r101 == null) goto L15;
            String r109 = r101.getTitle();
        L16:
            r108.setText(r109);
            goto L17
        L15:
            r109 = null;
        L17:
            TextView r110 = (TextView) r107.findViewWithTag(SocialConstants.PARAM_APP_DESC);
            if (r110 == null) goto L24;
            if (r101 == null) goto L21;
            String r111 = r101.getDesc();
        L22:
            r110.setText(r111);
            goto L24
        L21:
            r111 = null;
        L24:
            if (r102.f216577l == null) goto L33;
            if (r101 == null) goto L27;
            r105 = r101.getActions();
        L27:
            if (r105 == null) goto L33;
            JiraActionAdapter r112 = r102.f216577l;
            if (r112 == null) goto L34;
            JiraActionData.ActionSheetItem[] r113 = r101.getActions();
            if (r113 == null) goto L34;
            Intrinsics.checkNotNullParameter(r113, "data");
            r112.f216563a = r113;
            r112.notifyDataSetChanged();
        L34:
            r102.Z90();
            return;
        L33:
            tt5.a.d("JiraActionFragment", "bindView : jiraActionAdapter == null or jiraActionData.actions != null");
            goto L34
        L6:
            r106 = null;
            goto L7
        L8:
            r107 = null;
            goto L9
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JiraActionFragment f216582c;

        public c(JiraActionFragment r100) {
            this.f216582c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            JiraViewModel r101 = this.f216582c.f216573h;
            JiraViewModel r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r101 = null;
        L5:
            r101.setActive(false);
            JiraViewModel r103 = this.f216582c.f216573h;
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L9:
            r102.callback("Cancel");
            return;
        L8:
            r102 = r103;
            goto L9
        }
    }

    public static final class d implements JiraActionAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JiraActionFragment f216583a;

        public d(JiraActionFragment r100) {
            this.f216583a = r100;
        }

        @Override // com.bytedance.ee.bear.block.jira.JiraActionAdapter.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            JiraViewModel r101 = this.f216583a.f216573h;
            JiraViewModel r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r101 = null;
        L5:
            r101.callback(r100);
            JiraViewModel r103 = this.f216583a.f216573h;
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L9:
            r102.setActive(false);
            return;
        L8:
            r102 = r103;
            goto L9
        }
    }

    static {
    }

    public final void Z90() {
        View r100 = this.f216575j;
        com.bytedance.ee.bear.facade.common.widget.d r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragViewContainer");
        r100 = null;
    L5:
        r100.measure(0, 0);
        View r102 = this.f216575j;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragViewContainer");
        r102 = null;
    L8:
        float r103 = Math.min(r102.getMeasuredHeight(), this.f216579n);
        com.bytedance.ee.bear.facade.common.widget.d r104 = this.f216574i;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
    L12:
        r101.l(r103);
        return;
    L11:
        r101 = r104;
        goto L12
    }

    public JiraActionFragment() {
        this.f216580o = n.t() * 0.85f;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        JiraViewModel r100 = this.f216573h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r100 = null;
    L5:
        r100.setActive(false);
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
        r101.windowAnimations = R.style.ActionSheetWindowStyle;
    L12:
        if (r101 == null) goto L14;
        r101.y = k.e(getContext());
    L14:
        if (r102 == null) goto L16;
        r102.setAttributes(r101);
    L16:
        if (r102 == null) goto L18;
        r102.setLayout(-1, -1);
    L18:
        if (r102 == null) goto L21;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L21:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        this.f216580o = n.t() * 0.85f;
        com.bytedance.ee.bear.facade.common.widget.d r101 = this.f216574i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
        r101 = null;
    L5:
        r101.m(0.0f, this.f216579n, this.f216580o);
        Z90();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        JiraViewModel r101 = (JiraViewModel) q.a(this, JiraViewModel.class);
        this.f216573h = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r101 = null;
    L5:
        r101.getJiraActionData().observe(this, new b(this));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.setOnClickListener(new c(this));
        this.f216575j = r100.findViewById(R.id.jira_action_drag_view);
        this.f216576k = (RecyclerView) r100.findViewById(R.id.rv_jira_action);
        FragmentActivity r102 = getActivity();
        com.bytedance.ee.bear.facade.common.widget.d r103 = null;
        if (r102 == null) goto L20;
        RecyclerView r104 = this.f216576k;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("jiraActionRecyclerView");
        r104 = null;
    L7:
        r104.setLayoutManager(new LinearLayoutManager(r102));
        this.f216577l = new JiraActionAdapter(r102);
        JiraViewModel r105 = this.f216573h;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r105 = null;
    L10:
        JiraActionData r106 = r105.getJiraActionData().getValue();
        if (r106 == null) goto L17;
        JiraActionData.ActionSheetItem[] r107 = r106.getActions();
        if (r107 == null) goto L17;
        JiraActionAdapter r108 = this.f216577l;
        if (r108 == null) goto L17;
        Intrinsics.checkNotNullParameter(r107, "data");
        r108.f216563a = r107;
        r108.notifyDataSetChanged();
    L17:
        JiraActionAdapter r109 = this.f216577l;
        if (r109 == null) goto L20;
        d r110 = new d(this);
        Intrinsics.checkNotNullParameter(r110, "itemClickListener");
        r109.f216566d = r110;
    L20:
        RecyclerView r111 = this.f216576k;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("jiraActionRecyclerView");
        r111 = null;
    L23:
        r111.setAdapter(this.f216577l);
        this.f216579n = getResources().getDimension(R.dimen.jira_action_panel_height);
        Context r112 = getContext();
        View r113 = this.f216575j;
        if (r113 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dragViewContainer");
        View r114 = null;
    L27:
        com.bytedance.ee.bear.facade.common.widget.d r115 = new com.bytedance.ee.bear.facade.common.widget.d(r112, r114, 0.0f, this.f216579n, this.f216580o);
        this.f216574i = r115;
        View r116 = getView();
        if (r116 == null) goto L30;
        View r117 = r116.findViewById(R.id.jira_action_top_bar);
    L31:
        r115.i(r117);
        com.bytedance.ee.bear.facade.common.widget.d r118 = this.f216574i;
        if (r118 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
    L35:
        r103.f226593h = new com.bytedance.ee.bear.block.jira.b(this);
        return;
    L34:
        r103 = r118;
        goto L35
    L30:
        r117 = null;
        goto L31
    L26:
        r114 = r113;
        goto L27
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.jira_action_fragment, r101, false);
    }
}
