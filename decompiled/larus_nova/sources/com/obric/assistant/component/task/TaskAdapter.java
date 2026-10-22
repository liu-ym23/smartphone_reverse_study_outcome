package com.obric.assistant.component.task;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.task.TaskStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0011\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0013\u001a\u00020\fJ\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/component/task/TaskAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/assistant/component/task/TaskAdapter$TaskViewHolder;", "<init>", "()V", "tasks", "", "Lcom/obric/assistant/task/TaskEntry;", "openViewHolders", "", "onItemClickListener", "Lkotlin/Function0;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "submitList", "newTasks", "resetAllItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "TaskViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<com.obric.assistant.task.b> f388804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TaskViewHolder> f388805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f388806c;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0019J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/component/task/TaskAdapter$TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/obric/assistant/component/task/TaskAdapter;Landroid/view/View;)V", "clContent", "tvSwipeAction", "Landroid/widget/TextView;", "vDivider", "tvTitle", "tvDesc", "ivIcon", "Landroid/widget/ImageView;", "pbLoading", "Landroid/widget/ProgressBar;", "ivDone", "tvStatusText", "currentTranslationX", "", "bind", "", "task", "Lcom/obric/assistant/task/TaskEntry;", "isLastItem", "", "resetSwipe", "animate", "setupBouncyGesture", "setupSwipeGesture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TaskViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ int f388807l = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f388808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f388809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f388810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f388811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f388812e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f388813f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ProgressBar f388814g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ImageView f388815h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final TextView f388816i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f388817j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ TaskAdapter f388818k;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f388819a = null;

            static {
                int[] r100 = new int[TaskStatus.values().length];
                r100[TaskStatus.PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[TaskStatus.COMPLETED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[TaskStatus.QUEUEING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f388819a = r100;
            }
        }

        public final void T3() {
            this.f388808a.animate().translationX(0.0f).setDuration(250).start();
            this.f388809b.animate().translationX(0.0f).setDuration(250).start();
            this.f388810c.animate().translationX(0.0f).setDuration(250).start();
            this.f388817j = 0.0f;
            ((ArrayList) this.f388818k.f388805b).remove(this);
        }

        public TaskViewHolder(TaskAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f388818k = r100;
            super(r101);
            this.f388808a = r101.findViewById(R.id.cl_content);
            this.f388809b = (TextView) r101.findViewById(R.id.tv_swipe_action);
            this.f388810c = r101.findViewById(R.id.v_divider);
            this.f388811d = (TextView) r101.findViewById(R.id.tv_title);
            this.f388812e = (TextView) r101.findViewById(R.id.tv_desc);
            this.f388813f = (ImageView) r101.findViewById(R.id.iv_icon);
            this.f388814g = (ProgressBar) r101.findViewById(R.id.pb_loading);
            this.f388815h = (ImageView) r101.findViewById(R.id.iv_done);
            this.f388816i = (TextView) r101.findViewById(R.id.tv_status_text);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f388804a.size();
    }

    public TaskAdapter() {
        this.f388804a = CollectionsKt.emptyList();
        this.f388805b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        final TaskViewHolder r100 = (TaskViewHolder) r110;
        Intrinsics.checkNotNullParameter(r100, "holder");
        final com.obric.assistant.task.b r112 = (com.obric.assistant.task.b) ListProtector.get(this.f388804a, r111);
        if (r111 != (this.f388804a.size() - 1)) goto L5;
        boolean r101 = true;
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r112, "task");
        r100.f388811d.setText(r112.f393376c);
        r100.f388812e.setText(r112.f393377d);
        Drawable r102 = r112.f393379f;
        if (r102 != null) goto L10;
        r102 = r112.f393378e;
    L10:
        if (r102 == null) goto L12;
        r100.f388813f.setImageDrawable(r102);
        r100.f388813f.setVisibility(0);
    L13:
        r100.f388814g.setVisibility(8);
        r100.f388815h.setVisibility(8);
        r100.f388816i.setVisibility(8);
        int r103 = TaskViewHolder.a.f388819a[r112.f393380g.ordinal()];
        if (r103 != 1) goto L16;
        r100.f388814g.setVisibility(0);
        if (r112.f393381h < 0) goto L30;
        r100.f388814g.setIndeterminate(false);
        r100.f388814g.setProgressDrawable(ContextCompat.getDrawable(r100.itemView.getContext(), R.drawable.obric_circular_progress_determinate));
        r100.f388814g.setMax(100);
        r100.f388814g.setProgress(r112.f393381h);
    L31:
        View r104 = r100.f388810c;
        if (r101 == false) goto L34;
        int r105 = 8;
    L35:
        r104.setVisibility(r105);
        r100.f388808a.setTranslationX(0.0f);
        r100.f388809b.setTranslationX(0.0f);
        r100.f388810c.setTranslationX(0.0f);
        r100.f388817j = 0.0f;
        ((ArrayList) r100.f388818k.f388805b).remove(r100);
        r100.f388808a.setOnClickListener(null);
        if (r112.f393388o == null) goto L38;
        r100.f388809b.setText(r112.f393387n);
        r100.f388809b.setVisibility(0);
        r100.f388809b.setOnClickListener(new f(r112, r100));
        r100.f388809b.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r106 = r100.f388809b.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        final float r108 = -((r100.f388809b.getMeasuredWidth() + r107.getMarginStart()) + r107.getMarginEnd());
        final Ref.FloatRef r109 = new Ref.FloatRef();
        final Ref.FloatRef r113 = new Ref.FloatRef();
        final Ref.BooleanRef r114 = new Ref.BooleanRef();
        Resources r115 = r100.itemView.getContext().getResources();
        float r116 = WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density;
        final float r117 = 48 * r116;
        final float r118 = 10 * r116;
        final int r119 = ViewConfiguration.get(r100.itemView.getContext()).getScaledTouchSlop();
        View r120 = r100.f388808a;
        final TaskAdapter r121 = r100.f388818k;
        r120.setOnTouchListener(new h(r109, r113, r114, r100, r119, r108, r118, r121, r112, r117, r118));
        return;
    L38:
        r100.f388809b.setVisibility(8);
        r100.f388808a.setOnClickListener(null);
        final Ref.FloatRef r122 = new Ref.FloatRef();
        final Ref.FloatRef r123 = new Ref.FloatRef();
        final Ref.BooleanRef r124 = new Ref.BooleanRef();
        Resources r125 = r100.itemView.getContext().getResources();
        final float r126 = 10 * WindowDisplayMetricsOverride.apply(r125, r125.getDisplayMetrics()).density;
        final int r127 = ViewConfiguration.get(r100.itemView.getContext()).getScaledTouchSlop();
        View r128 = r100.f388808a;
        final TaskAdapter r129 = r100.f388818k;
        r128.setOnTouchListener(new g(r122, r123, r124, r100, r127, r126, r112, r129));
        return;
    L34:
        r105 = 0;
        goto L35
    L30:
        r100.f388814g.setIndeterminate(true);
        r100.f388814g.setIndeterminateTintList(ColorStateList.valueOf(ColorProtector.parseColor("#3D7EFF")));
        goto L31
    L16:
        if (r103 == 2) goto L23;
        if (r103 != 3) goto L21;
        r100.f388816i.setVisibility(0);
        r100.f388816i.setText(r112.f393383j);
        goto L31
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        if (r112.f393389p == false) goto L25;
        int r130 = R.drawable.obric_ic_task_completed_success;
    L26:
        r100.f388815h.setImageDrawable(ContextCompat.getDrawable(r100.itemView.getContext(), r130));
        r100.f388815h.setVisibility(0);
        goto L31
    L25:
        r130 = R.drawable.obric_ic_task_completed_failed;
        goto L26
    L12:
        r100.f388813f.setVisibility(8);
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.obric_item_task_row, r100, false);
        Intrinsics.checkNotNull(r102);
        return new TaskViewHolder(this, r102);
    }
}
