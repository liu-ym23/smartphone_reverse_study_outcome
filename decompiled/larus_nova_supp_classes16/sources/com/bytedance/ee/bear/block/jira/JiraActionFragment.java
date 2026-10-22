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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0017H\u0002J\u0012\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/block/jira/JiraActionFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "jiraViewModel", "Lcom/bytedance/ee/bear/block/jira/JiraViewModel;", "dragView", "Lcom/bytedance/ee/bear/facade/common/widget/DragView;", "dragViewContainer", "Landroid/view/View;", "jiraActionRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "jiraActionAdapter", "Lcom/bytedance/ee/bear/block/jira/JiraActionAdapter;", "jiraTitleBar", "jiraTitle", "Landroid/widget/TextView;", "jiraDesc", "minHeight", "", "midHeight", "maxHeight", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initDragView", "bindView", "jiraActionData", "Lcom/bytedance/ee/bear/block/jira/JiraActionData;", "updateDragViewHeight", "Companion", "features-block-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JiraActionFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int p = 0;
    public JiraViewModel h;
    public com.bytedance.ee.bear.facade.common.widget.d i;
    public View j;
    public RecyclerView k;
    public JiraActionAdapter l;
    public View m;
    public float n;
    public float o;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ JiraActionFragment a;

        public b(JiraActionFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            JiraActionData r7 = (JiraActionData) r6;
            JiraActionFragment r0 = this.a;
            int r1 = JiraActionFragment.p;
            View r2 = r0.getView();
            JiraActionData.ActionSheetItem[] r3 = null;
            if (r2 == null) goto L8;
            if (r7 == null) goto L6;
            String r4 = r7.getId();
        L7:
            View r5 = r2.findViewWithTag(r4);
        L9:
            r0.m = r5;
            if (r5 == null) goto L24;
            r5.setVisibility(0);
            TextView r8 = (TextView) r5.findViewWithTag("title");
            if (r8 == null) goto L17;
            if (r7 == null) goto L15;
            String r9 = r7.getTitle();
        L16:
            r8.setText(r9);
            goto L17
        L15:
            r9 = null;
        L17:
            TextView r10 = (TextView) r5.findViewWithTag("desc");
            if (r10 == null) goto L24;
            if (r7 == null) goto L21;
            String r11 = r7.getDesc();
        L22:
            r10.setText(r11);
            goto L24
        L21:
            r11 = null;
        L24:
            if (r0.l == null) goto L33;
            if (r7 == null) goto L27;
            r3 = r7.getActions();
        L27:
            if (r3 == null) goto L33;
            JiraActionAdapter r12 = r0.l;
            if (r12 == null) goto L34;
            JiraActionData.ActionSheetItem[] r13 = r7.getActions();
            if (r13 == null) goto L34;
            Intrinsics.checkNotNullParameter(r13, "data");
            r12.a = r13;
            r12.notifyDataSetChanged();
        L34:
            r0.Z90();
            return;
        L33:
            tt5.a.d("JiraActionFragment", "bindView : jiraActionAdapter == null or jiraActionData.actions != null");
            goto L34
        L6:
            r4 = null;
            goto L7
        L8:
            r5 = null;
            goto L9
        }
    }

    public static final class c extends t {
        public final /* synthetic */ JiraActionFragment c;

        public c(JiraActionFragment r1) {
            this.c = r1;
        }

        public final void a(View r4) {
            JiraViewModel r5 = this.c.h;
            JiraViewModel r0 = null;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r5 = null;
        L5:
            r5.setActive(false);
            JiraViewModel r6 = this.c.h;
            if (r6 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L9:
            r0.callback("Cancel");
            return;
        L8:
            r0 = r6;
            goto L9
        }
    }

    public static final class d implements JiraActionAdapter.b {
        public final /* synthetic */ JiraActionFragment a;

        public d(JiraActionFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.block.jira.JiraActionAdapter.b
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "id");
            JiraViewModel r0 = this.a.h;
            JiraViewModel r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
            r0 = null;
        L5:
            r0.callback(r4);
            JiraViewModel r5 = this.a.h;
            if (r5 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        L9:
            r1.setActive(false);
            return;
        L8:
            r1 = r5;
            goto L9
        }
    }

    static {
    }

    public final void Z90() {
        View r0 = this.j;
        com.bytedance.ee.bear.facade.common.widget.d r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragViewContainer");
        r0 = null;
    L5:
        r0.measure(0, 0);
        View r1 = this.j;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dragViewContainer");
        r1 = null;
    L8:
        float r3 = Math.min(r1.getMeasuredHeight(), this.n);
        com.bytedance.ee.bear.facade.common.widget.d r4 = this.i;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
    L12:
        r2.l(r3);
        return;
    L11:
        r2 = r4;
        goto L12
    }

    public JiraActionFragment() {
        this.o = n.t() * 0.85f;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        JiraViewModel r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r0 = null;
    L5:
        r0.setActive(false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
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
        r1.windowAnimations = 2131951623;
    L12:
        if (r1 == null) goto L14;
        r1.y = k.e(getContext());
    L14:
        if (r2 == null) goto L16;
        r2.setAttributes(r1);
    L16:
        if (r2 == null) goto L18;
        r2.setLayout(-1, -1);
    L18:
        if (r2 == null) goto L21;
        r2.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r4);
        this.o = n.t() * 0.85f;
        com.bytedance.ee.bear.facade.common.widget.d r5 = this.i;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
        r5 = null;
    L5:
        r5.m(0.0f, this.n, this.o);
        Z90();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        JiraViewModel r3 = (JiraViewModel) q.a(this, JiraViewModel.class);
        this.h = r3;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r3 = null;
    L5:
        r3.getJiraActionData().observe(this, new b(this));
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        r8.setOnClickListener(new c(this));
        this.j = r8.findViewById(2131376736);
        this.k = r8.findViewById(2131384970);
        FragmentActivity r10 = getActivity();
        com.bytedance.ee.bear.facade.common.widget.d r0 = null;
        if (r10 == null) goto L20;
        RecyclerView r1 = this.k;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("jiraActionRecyclerView");
        r1 = null;
    L7:
        r1.setLayoutManager(new LinearLayoutManager(r10));
        this.l = new JiraActionAdapter(r10);
        JiraViewModel r11 = this.h;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("jiraViewModel");
        r11 = null;
    L10:
        JiraActionData r12 = (JiraActionData) r11.getJiraActionData().getValue();
        if (r12 == null) goto L17;
        JiraActionData.ActionSheetItem[] r13 = r12.getActions();
        if (r13 == null) goto L17;
        JiraActionAdapter r2 = this.l;
        if (r2 == null) goto L17;
        Intrinsics.checkNotNullParameter(r13, "data");
        r2.a = r13;
        r2.notifyDataSetChanged();
    L17:
        JiraActionAdapter r14 = this.l;
        if (r14 == null) goto L20;
        d r3 = new d(this);
        Intrinsics.checkNotNullParameter(r3, "itemClickListener");
        r14.d = r3;
    L20:
        RecyclerView r16 = this.k;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("jiraActionRecyclerView");
        r16 = null;
    L23:
        r16.setAdapter(this.l);
        this.n = getResources().getDimension(2131166596);
        Context r4 = getContext();
        View r17 = this.j;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dragViewContainer");
        View r5 = null;
    L27:
        com.bytedance.ee.bear.facade.common.widget.d r18 = new com.bytedance.ee.bear.facade.common.widget.d(r4, r5, 0.0f, this.n, this.o);
        this.i = r18;
        View r19 = getView();
        if (r19 == null) goto L30;
        View r20 = r19.findViewById(2131376737);
    L31:
        r18.i(r20);
        com.bytedance.ee.bear.facade.common.widget.d r21 = this.i;
        if (r21 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
    L35:
        r0.h = new com.bytedance.ee.bear.block.jira.b(this);
        return;
    L34:
        r0 = r21;
        goto L35
    L30:
        r20 = null;
        goto L31
    L26:
        r5 = r17;
        goto L27
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561717, r3, false);
    }
}
