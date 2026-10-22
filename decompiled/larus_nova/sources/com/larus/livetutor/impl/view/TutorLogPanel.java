package com.larus.livetutor.impl.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.livetutor.impl.rtc.LogEntity;
import com.larus.livetutor.impl.rtc.LogStatus;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0017\u0018\u00002\u00020\u0001:\u0003\u001f !B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006\""}, d2 = {"Lcom/larus/livetutor/impl/view/TutorLogPanel;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "rvBoard", "Landroidx/recyclerview/widget/RecyclerView;", "dataList", "", "Lcom/larus/livetutor/impl/rtc/LogEntity;", "adapter", "Lcom/larus/livetutor/impl/view/TutorLogPanel$LogAdapter;", "lastItemView", "Landroid/view/View;", "needAutoScroll", "", "isUserScrolling", "scrollChangeListener", "com/larus/livetutor/impl/view/TutorLogPanel$scrollChangeListener$1", "Lcom/larus/livetutor/impl/view/TutorLogPanel$scrollChangeListener$1;", "appendLog", "", "log", "scrollRVToBottom", "delay", "", "LogAdapter", "LogViewHolder", "SpacesItemDecoration", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TutorLogPanel extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f356784g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f356785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LogEntity> f356786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f356787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f356788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f356789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f356790f;

    public static final class a extends RecyclerView.Adapter<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<LogEntity> f356791a;

        /* JADX INFO: renamed from: com.larus.livetutor.impl.view.TutorLogPanel$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4416a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f356792a = null;

            static {
                int[] r100 = new int[LogStatus.values().length];
                r100[LogStatus.Normal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[LogStatus.Success.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[LogStatus.Error.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f356792a = r100;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f356791a.size();
        }

        public a(List<LogEntity> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f356791a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            b r102 = (b) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            LogEntity r103 = (LogEntity) ListProtector.get(this.f356791a, r101);
            SpannableString r104 = new SpannableString(r103.getMsg());
            LogStatus r105 = r103.getStatus();
            int r106 = C4416a.f356792a[r105.ordinal()];
            if (r106 != 1) goto L5;
            int r107 = -1;
        L13:
            r104.setSpan(new ForegroundColorSpan(r107), 0, r103.getMsg().length(), 33);
            r102.f356793a.setText(r104);
            return;
        L5:
            if (r106 != 2) goto L7;
            r107 = FakePickerAvatarCreator.GREEN;
            goto L13
        L7:
            if (r106 != 3) goto L10;
            r107 = -65536;
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.tutor_log_item, r100, false);
            Intrinsics.checkNotNull(r102);
            return new b(r102);
        }
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f356793a;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f356793a = (TextView) r100.findViewById(R.id.content);
        }
    }

    public static final class c extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f356794a;

        public c(int r100) {
            this.f356794a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            if (r102.getChildAdapterPosition(r101) <= 0) goto L5;
            int r104 = this.f356794a;
        L6:
            r100.top = r104;
            return;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public TutorLogPanel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TutorLogPanel(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.larus.livetutor.impl.view.i2] */
    public final void a(LogEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "log");
        ((ArrayList) this.f356786b).add(r100);
        this.f356787c.notifyItemInserted(((ArrayList) this.f356786b).size() - 1);
        if (this.f356789e == false) goto L6;
        final ?? r101 = new i2(this);
        postDelayed(new j2(r101), 20);
        return;
    }

    public TutorLogPanel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ArrayList r103 = new ArrayList();
        this.f356786b = r103;
        a r104 = new a(r103);
        this.f356787c = r104;
        this.f356789e = true;
        RecyclerView.OnScrollListener r105 = new TutorLogPanel$scrollChangeListener$1(this);
        FrameLayout.inflate(r100, R.layout.tutor_log_panel_layout, this);
        RecyclerView r106 = (RecyclerView) findViewById(R.id.rv_board);
        this.f356785a = r106;
        if (r106 == null) goto L5;
        r106.setLayoutManager(new LinearLayoutManager(r100, 1, false));
        r106.setAdapter(r104);
        r106.addItemDecoration(new c(i5.r0()));
    L5:
        if (r106 == null) goto L8;
        r106.setItemAnimator(null);
        r106.addOnScrollListener(r105);
        return;
    }

    public /* synthetic */ TutorLogPanel(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
