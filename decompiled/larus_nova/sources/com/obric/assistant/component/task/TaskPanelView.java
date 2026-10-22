package com.obric.assistant.component.task;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.task.TaskStatus;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001UB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010E\u001a\u00020/H\u0002J\b\u0010F\u001a\u00020/H\u0002J\b\u0010G\u001a\u00020/H\u0002J\u0014\u0010H\u001a\u00020/2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020807J\b\u0010J\u001a\u00020/H\u0002J\u0016\u0010K\u001a\u00020/2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\u000e\u0010L\u001a\u00020/2\u0006\u0010M\u001a\u000205J\u0006\u0010N\u001a\u000205J\u0010\u0010R\u001a\u00020/2\u0006\u0010S\u001a\u00020?H\u0016J\b\u0010T\u001a\u00020/H\u0003R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b&\u0010\u0019R\u001b\u0010(\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\r\u001a\u0004\b)\u0010\u0019R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010O\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010B\"\u0004\bQ\u0010D¨\u0006V"}, d2 = {"Lcom/obric/assistant/component/task/TaskPanelView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rootContainer", "Landroid/view/View;", "getRootContainer", "()Landroid/view/View;", "rootContainer$delegate", "Lkotlin/Lazy;", "collapsedLayout", "getCollapsedLayout", "collapsedLayout$delegate", "expandedRecyclerView", "Lcom/obric/assistant/component/task/TaskPanelRecyclerView;", "getExpandedRecyclerView", "()Lcom/obric/assistant/component/task/TaskPanelRecyclerView;", "expandedRecyclerView$delegate", "ivCollapsedIcon", "Landroid/widget/ImageView;", "getIvCollapsedIcon", "()Landroid/widget/ImageView;", "ivCollapsedIcon$delegate", "tvCollapsedTitle", "Landroid/widget/TextView;", "getTvCollapsedTitle", "()Landroid/widget/TextView;", "tvCollapsedTitle$delegate", "pbCollapsedLoading", "Landroid/widget/ProgressBar;", "getPbCollapsedLoading", "()Landroid/widget/ProgressBar;", "pbCollapsedLoading$delegate", "ivCollapsedDone", "getIvCollapsedDone", "ivCollapsedDone$delegate", "ivExpandArrow", "getIvExpandArrow", "ivExpandArrow$delegate", "adapter", "Lcom/obric/assistant/component/task/TaskAdapter;", "onPanelClickListener", "Lkotlin/Function0;", "", "getOnPanelClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnPanelClickListener", "(Lkotlin/jvm/functions/Function0;)V", "currentState", "Lcom/obric/assistant/component/task/TaskPanelView$State;", "currentTasks", "", "Lcom/obric/assistant/task/TaskEntry;", "currentDisplayedTask", "bottomFadeView", "fadingViewHeight", "", "fadingThreshold", "value", "", "panelCornerRadius", "getPanelCornerRadius", "()F", "setPanelCornerRadius", "(F)V", "handleCollapsedLayoutClick", "setupRecyclerView", "createBottomFadeView", "updateData", "tasks", "updateFadeViewOffset", "updateCollapsedUI", "setMode", "state", "getCurrentState", "zeroThreshold", "getZeroThreshold", "setZeroThreshold", "setAlpha", "alpha", "setupPressEffects", "State", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskPanelView extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f388825s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f388826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f388827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f388828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f388829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f388830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f388831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f388832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f388833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TaskAdapter f388834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f388835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public State f388836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<com.obric.assistant.task.b> f388837l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.obric.assistant.task.b f388838m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f388839n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f388840o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f388841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f388842q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f388843r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/component/task/TaskPanelView$State;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSED", "EXPANDED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COLLAPSED = null;
        public static final State EXPANDED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f388844a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f388845b = null;

        public static EnumEntries<State> getEntries() {
            return f388845b;
        }

        static {
            State r100 = new State("COLLAPSED", 0);
            COLLAPSED = r100;
            State r101 = new State("EXPANDED", 1);
            EXPANDED = r101;
            State[] r102 = {r100, r101};
            f388844a = r102;
            f388845b = EnumEntriesKt.enumEntries(r102);
        }

        public static State[] values() {
            return (State[]) f388844a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskPanelView f388846a;

        public a(TaskPanelView r100) {
            this.f388846a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f388846a.getPanelCornerRadius());
        }
    }

    private final View getCollapsedLayout() {
        return (View) this.f388827b.getValue();
    }

    private final TaskPanelRecyclerView getExpandedRecyclerView() {
        return (TaskPanelRecyclerView) this.f388828c.getValue();
    }

    private final ImageView getIvCollapsedDone() {
        return (ImageView) this.f388832g.getValue();
    }

    private final ImageView getIvCollapsedIcon() {
        return (ImageView) this.f388829d.getValue();
    }

    private final ImageView getIvExpandArrow() {
        return (ImageView) this.f388833h.getValue();
    }

    private final ProgressBar getPbCollapsedLoading() {
        return (ProgressBar) this.f388831f.getValue();
    }

    private final View getRootContainer() {
        return (View) this.f388826a.getValue();
    }

    private final TextView getTvCollapsedTitle() {
        return (TextView) this.f388830e.getValue();
    }

    public final void c() {
        View r100 = null;
        if (this.f388836k == State.EXPANDED) goto L10;
        View r101 = this.f388839n;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L8:
        r100.setVisibility(8);
        return;
    L7:
        r100 = r101;
        goto L8
    L10:
        int r102 = getExpandedRecyclerView().computeVerticalScrollRange();
        float r103 = (r102 - getExpandedRecyclerView().computeVerticalScrollOffset()) - getExpandedRecyclerView().computeVerticalScrollExtent();
        float r104 = this.f388840o;
        float r105 = this.f388841p;
        float r106 = 0.0f;
        if (r103 <= 0.0f) goto L24;
        View r107 = this.f388839n;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
        r107 = null;
    L15:
        r107.setVisibility(0);
        if (r103 >= r105) goto L19;
        r106 = r104 - ((r103 / r105) * r104);
    L19:
        View r108 = this.f388839n;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L23:
        r100.setTranslationY(r106);
        return;
    L22:
        r100 = r108;
        goto L23
    L24:
        View r109 = this.f388839n;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
        r109 = null;
    L27:
        r109.setVisibility(4);
        View r110 = this.f388839n;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L31:
        r100.setTranslationY(r104);
        return;
    L30:
        r100 = r110;
        goto L31
    }

    public final State getCurrentState() {
        return this.f388836k;
    }

    public final Function0<Unit> getOnPanelClickListener() {
        return this.f388835j;
    }

    public final float getPanelCornerRadius() {
        return this.f388842q;
    }

    public final float getZeroThreshold() {
        return this.f388843r;
    }

    public TaskPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void b(List<com.obric.assistant.task.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "tasks");
        this.f388837l = r110;
        TaskAdapter r100 = this.f388834i;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "newTasks");
        r100.f388804a = r110;
        r100.notifyDataSetChanged();
        getPbCollapsedLoading().setVisibility(8);
        getIvCollapsedDone().setVisibility(8);
        getIvExpandArrow().setVisibility(8);
        getIvCollapsedIcon().setVisibility(0);
        Object r101 = null;
        this.f388838m = null;
        if ((!r110.isEmpty()) == true) goto L5;
        return;
    L5:
        if (r110.size() != 1) goto L21;
        com.obric.assistant.task.b r111 = (com.obric.assistant.task.b) CollectionsKt.first(r110);
        this.f388838m = r111;
        getTvCollapsedTitle().setText(r111.f393375b);
        if (r111.f393378e == null) goto L9;
        getIvCollapsedIcon().setImageDrawable(r111.f393378e);
    L9:
        TaskStatus r102 = r111.f393380g;
        if (r102 != TaskStatus.COMPLETED) goto L17;
        if (r111.f393389p == false) goto L14;
        int r112 = R.drawable.obric_ic_task_completed_success;
    L15:
        getIvCollapsedDone().setImageDrawable(ContextCompat.getDrawable(getContext(), r112));
        getIvCollapsedDone().setVisibility(0);
        return;
    L14:
        r112 = R.drawable.obric_ic_task_completed_failed;
        goto L15
    L17:
        if (r102 == TaskStatus.PROGRESS) goto L19;
        return;
    L19:
        if (r111.f393382i == true) goto L57;
        getPbCollapsedLoading().setVisibility(0);
        getPbCollapsedLoading().setProgress(r111.f393381h);
        return;
    L57:
        return;
    L21:
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r110.iterator();
    L23:
        if (r104.hasNext() == false) goto L27;
        Object r105 = r104.next();
        if (((com.obric.assistant.task.b) r105).f393384k == false) goto L23;
        r103.add(r105);
        goto L23
    L27:
        Iterator r106 = r103.iterator();
        if (r106.hasNext() == false) goto L39;
        r101 = r106.next();
        if (r106.hasNext() == false) goto L39;
        long r107 = ((com.obric.assistant.task.b) r101).f393390q;
    L34:
        Object r108 = r106.next();
        long r109 = ((com.obric.assistant.task.b) r108).f393390q;
        if (r107 >= r109) goto L38;
        r101 = r108;
        r107 = r109;
    L38:
        if (r106.hasNext() == true) goto L34;
    L39:
        com.obric.assistant.task.b r113 = (com.obric.assistant.task.b) r101;
        if (r113 == null) goto L44;
        this.f388838m = r113;
        getTvCollapsedTitle().setText(r113.f393375b);
        if (r113.f393378e == null) goto L45;
        getIvCollapsedIcon().setImageDrawable(r113.f393378e);
    L45:
        getIvExpandArrow().setVisibility(0);
        return;
    L44:
        getTvCollapsedTitle().setText(AppHost.f326268a.getApplication().getString(R.string.obric_task_center_title, new Object[]{Integer.valueOf(r110.size())}));
        getIvCollapsedIcon().setVisibility(8);
        goto L45
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        float r101 = 0.0f;
        float r102 = RangesKt.coerceIn(r100, 0.0f, 1.0f);
        float r103 = this.f388843r;
        if (r102 <= r103) goto L6;
        r101 = (r102 - r103) / (1.0f - r103);
    L6:
        super.setAlpha(r101);
    }

    public final void setMode(State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f388836k = r100;
        View r101 = null;
        boolean r102 = false;
        if (r100 != State.EXPANDED) goto L16;
        getCollapsedLayout().setVisibility(8);
        getExpandedRecyclerView().setVisibility(0);
        View r103 = this.f388839n;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
        r103 = null;
    L8:
        if (r103.getVisibility() != 8) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L21;
        View r104 = this.f388839n;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L15:
        r101.setVisibility(4);
        goto L21
    L14:
        r101 = r104;
    L21:
        c();
        return;
    L16:
        getCollapsedLayout().setVisibility(0);
        getExpandedRecyclerView().setVisibility(8);
        View r105 = this.f388839n;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bottomFadeView");
    L20:
        r101.setVisibility(8);
        goto L21
    L19:
        r101 = r105;
        goto L20
    }

    public final void setOnPanelClickListener(Function0<Unit> r100) {
        this.f388835j = r100;
    }

    public final void setPanelCornerRadius(float r100) {
        this.f388842q = r100;
        Drawable r101 = getBackground();
        if ((r101 instanceof GradientDrawable) == false) goto L5;
        GradientDrawable r102 = (GradientDrawable) r101;
    L6:
        if (r102 == null) goto L8;
        r102.setCornerRadius(r100);
    L8:
        invalidateOutline();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setZeroThreshold(float r100) {
        this.f388843r = r100;
    }

    public TaskPanelView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        this.f388826a = LazyKt.lazy(new s(this));
        this.f388827b = LazyKt.lazy(new y(this));
        this.f388828c = LazyKt.lazy(new z(this));
        this.f388829d = LazyKt.lazy(new a0(this));
        this.f388830e = LazyKt.lazy(new b0(this));
        this.f388831f = LazyKt.lazy(new c0(this));
        this.f388832g = LazyKt.lazy(new d0(this));
        this.f388833h = LazyKt.lazy(new e0(this));
        TaskAdapter r100 = new TaskAdapter();
        r100.f388806c = new f0(this);
        this.f388834i = r100;
        this.f388836k = State.COLLAPSED;
        this.f388837l = CollectionsKt.emptyList();
        int r101 = c7.b(59);
        this.f388840o = r101;
        this.f388841p = c7.b(12);
        this.f388842q = j19.c.c(100);
        boolean r102 = true;
        LayoutInflater.from(r110).inflate(R.layout.obric_layout_task_panel, this, true);
        View r103 = new View(getContext());
        int r104 = -1;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, r101);
        r105.gravity = 80;
        r103.setLayoutParams(r105);
        Drawable r106 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, ContextCompat.getColor(r103.getContext(), R.color.obric_task_center_panel_bg)});
        r103.setClickable(false);
        r103.setBackground(r106);
        r103.setVisibility(8);
        this.f388839n = r103;
        addView(r103);
        TaskPanelRecyclerView r107 = getExpandedRecyclerView();
        final Context r108 = getContext();
        r107.setLayoutManager(new TaskPanelView$setupRecyclerView$1(this, r108));
        getExpandedRecyclerView().setAdapter(r100);
        getExpandedRecyclerView().addOnScrollListener(new TaskPanelView$setupRecyclerView$2(this));
        getIvExpandArrow().setOnClickListener(new t(this));
        getCollapsedLayout().setOnClickListener(new x(this));
        getRootContainer().setClickable(true);
        Drawable r109 = ContextCompat.getDrawable(r110, R.drawable.obric_task_panel_bg);
        final GradientDrawable r112 = null;
        if (r109 == null) goto L5;
        Drawable r113 = r109.mutate();
    L7:
        if ((r113 instanceof GradientDrawable) == false) goto L9;
        Drawable r114 = (GradientDrawable) r113;
    L10:
        setElevation(c7.b(6));
        setBackground(r114);
        setClipToOutline(true);
        setOutlineProvider(new a(this));
        final SpringAnimation r115 = new SpringAnimation(this, DynamicAnimation.SCALE_X);
        final SpringAnimation r116 = new SpringAnimation(this, DynamicAnimation.SCALE_Y);
        Drawable r117 = getIvExpandArrow().getBackground();
        if (r117 == null) goto L13;
        Drawable r118 = r117.mutate();
    L15:
        if ((r118 instanceof GradientDrawable) == false) goto L17;
        r112 = (GradientDrawable) r118;
    L17:
        if (r112 == null) goto L21;
        ColorStateList r119 = r112.getColor();
        if (r119 == null) goto L21;
        int r120 = r119.getDefaultColor();
    L22:
        final int r121 = r120;
        if ((getResources().getConfiguration().uiMode & 48) == 32) goto L26;
        r102 = false;
    L26:
        if (r102 == true) goto L29;
        r104 = -16777216;
    L29:
        if (r102 == false) goto L31;
        float r122 = 0.15f;
    L32:
        final int r123 = ColorUtils.blendARGB(r121, r104, r122);
        getIvExpandArrow().setOnTouchListener(new u(r112, r123, r121, this, r115, r116));
        getCollapsedLayout().setOnTouchListener(new v(this, r115, r116));
        this.f388843r = 0.5f;
        return;
    L31:
        r122 = 0.1f;
    L21:
        r120 = ColorProtector.parseColor("#F7F7F7");
        goto L22
    L13:
        r118 = null;
        goto L15
    L9:
        r114 = null;
        goto L10
    L5:
        r113 = null;
        goto L7
    }

    public static final void a(TaskPanelView r100, SpringAnimation r101, SpringAnimation r102, boolean r103) {
        if (r100.f388836k == State.COLLAPSED) goto L5;
        return;
    L5:
        r100.setPivotX(r100.getWidth() / 2.0f);
        r100.setPivotY(r100.getHeight() / 2.0f);
        if (r103 == false) goto L8;
        SpringForce r104 = new SpringForce(0.9f);
        r104.setDampingRatio(1.0f);
        r104.setStiffness(80.0f);
        r101.setSpring(r104);
        SpringForce r105 = new SpringForce(0.9f);
        r105.setDampingRatio(1.0f);
        r105.setStiffness(80.0f);
        r102.setSpring(r105);
    L9:
        r101.start();
        r102.start();
        return;
    L8:
        SpringForce r106 = new SpringForce(1.0f);
        r106.setDampingRatio(0.7f);
        r106.setStiffness(438.0f);
        r101.setSpring(r106);
        SpringForce r107 = new SpringForce(1.0f);
        r107.setDampingRatio(0.7f);
        r107.setStiffness(438.0f);
        r102.setSpring(r107);
        goto L9
    }
}
