package com.ss.android.lark.todo.impl.features.detail.at.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.ui.stickyheader.StickyRecyclerHeadersDecoration;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.detail.at.model.TodoAtViewModel;
import com.ss.android.lark.todo.impl.features.detail.at.view.adapter.AtSelectAdapter;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u000234B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0003J\u0014\u0010*\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020(0,J\u0006\u0010-\u001a\u00020(J\u0006\u0010.\u001a\u00020(J\u0012\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020(H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$¨\u00065"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/at/view/TodoAtView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/detail/at/model/TodoAtViewModel;", "largeMargin", "", "dependency", "Lcom/ss/android/lark/todo/impl/features/detail/at/view/TodoAtView$ITodoViewDependency;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/todo/impl/features/detail/at/model/TodoAtViewModel;ZLcom/ss/android/lark/todo/impl/features/detail/at/view/TodoAtView$ITodoViewDependency;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getViewModel", "()Lcom/ss/android/lark/todo/impl/features/detail/at/model/TodoAtViewModel;", "getDependency", "()Lcom/ss/android/lark/todo/impl/features/detail/at/view/TodoAtView$ITodoViewDependency;", "setDependency", "(Lcom/ss/android/lark/todo/impl/features/detail/at/view/TodoAtView$ITodoViewDependency;)V", "mAtResultList", "Landroidx/recyclerview/widget/RecyclerView;", "mBack", "Landroid/view/View;", "mEnterAnim", "Landroid/animation/ValueAnimator;", "mExitAnim", "mAdapter", "Lcom/ss/android/lark/todo/impl/features/detail/at/view/adapter/AtSelectAdapter;", "nameRule", "Lcom/bytedance/lark/pb/contact/v1/GetAnotherNameFormatResponse$FormatRule;", "isPreActive", "()Z", "setPreActive", "(Z)V", "isActive", "setActive", "initAnimator", "", "initView", "show", "callback", "Lkotlin/Function0;", "dismiss", MapMonitorConst.EVENT_DESTROY, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adjustMentionTopMargin", "Companion", "ITodoViewDependency", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoAtView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f442786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TodoAtViewModel f442787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f442788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f442789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclerView f442790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f442791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f442792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f442793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AtSelectAdapter f442794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GetAnotherNameFormatResponse.FormatRule f442795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f442796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f442797l;

    public static final class a {
    }

    public interface b {
        void a(boolean r100);

        void b(String r100, String r101);
    }

    static {
    }

    public final void S5() {
        Log.i("TodoAtView", "dismiss");
        this.f442796k = false;
        this.f442789d.a(false);
        this.f442797l = false;
        if (getVisibility() != 8) goto L5;
        return;
    L5:
        ValueAnimator r100 = this.f442793h;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isRunning() == false) goto L10;
        return;
    L10:
        r100.start();
    }

    public final void R5() {
        UDShadowLayout r100 = (UDShadowLayout) findViewById(R.id.list_container);
        Resources r101 = r100.getContext().getResources();
        if (r101 == null) goto L7;
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        if (r102 == null) goto L7;
        float r103 = r102.heightPixels;
    L8:
        FragmentActivity r104 = this.f442786a.getActivity();
        boolean r105 = false;
        if (r104 == null) goto L11;
        boolean r106 = com.ss.android.lark.base.embedded.b.b(r104);
    L12:
        if (r106 == true) goto L14;
    L19:
        ViewGroup.LayoutParams r107 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        if (r105 == false) goto L23;
        int r109 = (int) (r103 / 6);
    L27:
        r108.topMargin = r109;
        return;
    L23:
        if (this.f442788c == false) goto L25;
        float r110 = 280.0f;
    L26:
        r109 = UIHelper.dp2px(r110);
        goto L27
    L25:
        r110 = 57.0f;
        goto L26
    L14:
        if (r103 != 0.0f) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == true) goto L19;
        r105 = true;
        goto L19
    L16:
        r111 = false;
        goto L17
    L11:
        r106 = false;
    L7:
        r103 = 0.0f;
        goto L8
    }

    public final b getDependency() {
        return this.f442789d;
    }

    public final Fragment getFragment() {
        return this.f442786a;
    }

    public final TodoAtViewModel getViewModel() {
        return this.f442787b;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        R5();
    }

    public final void setActive(boolean r100) {
        this.f442797l = r100;
    }

    public final void setDependency(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f442789d = r100;
    }

    public final void setPreActive(boolean r100) {
        this.f442796k = r100;
    }

    public TodoAtView(Context r100, Fragment r101, TodoAtViewModel r102, boolean r103, com.ss.android.lark.todo.impl.features.detail.at.b r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "dependency");
        super(r100);
        this.f442786a = r101;
        this.f442787b = r102;
        this.f442788c = r103;
        this.f442789d = r104;
        this.f442795j = GetAnotherNameFormatResponse.FormatRule.NAME_FIRST;
        this.f442796k = true;
        LayoutInflater.from(r100).inflate(R.layout.todo_detail_at_float, this, true);
        R5();
        RecyclerView r105 = (RecyclerView) findViewById(R.id.list);
        r105.setLayoutManager(new LinearLayoutManager(r105.getContext(), 1, false));
        zdc.h.b(r105);
        AtSelectAdapter r106 = new AtSelectAdapter(new e(this));
        this.f442794i = r106;
        r105.addItemDecoration(new StickyRecyclerHeadersDecoration(r106));
        r105.setAdapter(this.f442794i);
        this.f442790e = r105;
        View r107 = findViewById(R.id.back);
        r107.setOnTouchListener(new f(this));
        this.f442791f = r107;
        r102.getTodoAtList().observe(r101, new g(this));
        r102.getNameRule().observe(r101, new h(this));
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r108.addUpdateListener(new com.ss.android.lark.todo.impl.features.detail.at.view.a(this, r108));
        r108.addListener(new com.ss.android.lark.todo.impl.features.detail.at.view.b(this));
        this.f442792g = r108;
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(200);
        r109.addUpdateListener(new c(this, r109));
        r109.addListener(new d(this));
        this.f442793h = r109;
    }
}
