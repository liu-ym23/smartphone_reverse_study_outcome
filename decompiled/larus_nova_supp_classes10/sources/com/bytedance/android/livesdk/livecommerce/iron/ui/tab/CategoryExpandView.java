package com.bytedance.android.livesdk.livecommerce.iron.ui.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryLineaLayoutManager;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryRecyclerView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/tab/CategoryExpandView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "State", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryExpandView extends ConstraintLayout {
    public final View a;
    public final View b;
    public final TextView c;
    public final ConstraintLayout d;
    public final FrameLayout e;
    public State f;
    public Integer g;
    public Pair<Integer, Integer> h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/tab/CategoryExpandView$State;", "", "STATE_COLLAPSED", "STATE_EXPANDED", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State STATE_COLLAPSED = null;
        public static final State STATE_EXPANDED = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("STATE_COLLAPSED", 0);
            STATE_COLLAPSED = r1;
            State r2 = new State("STATE_EXPANDED", 1);
            STATE_EXPANDED = r2;
            a = new State[]{r1, r2};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public CategoryExpandView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CategoryExpandView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean T5() {
        if (this.f != State.STATE_EXPANDED) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryExpandView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = State.STATE_COLLAPSED;
        LayoutInflater.from(r2).inflate(2131564728, this, true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.a = findViewById(2131371881);
        this.b = findViewById(2131371879);
        this.d = findViewById(2131371878);
        this.c = (TextView) findViewById(2131365290);
        this.e = (FrameLayout) findViewById(2131388008);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(CategoryRecyclerView r6, FrameLayout r7, RelativeLayout r8) {
        Intrinsics.checkNotNullParameter(r6, "categoryRecyclerView");
        Intrinsics.checkNotNullParameter(r7, "categoryRecyclerViewContainer");
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.indexOfChild(this) == (-1)) goto L8;
        r8.removeView(this);
    L8:
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(-2, -2);
        r9.gravity = 53;
        Unit r0 = Unit.INSTANCE;
        r7.addView(this, r9);
        this.d.setBackgroundColor(0);
        setBackgroundColor(0);
        this.b.setBackgroundResource(2131234612);
        View r10 = this.b;
        int r2 = UtilityKotlinExtentionsKt.d(16);
        Intrinsics.checkNotNullParameter(r10, "$this$layoutMarginTop");
        ViewGroup.LayoutParams r3 = r10.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = r2;
        r10.setLayoutParams(r3);
    L11:
        this.c.setVisibility(8);
        if (this.e.indexOfChild(r6) == (-1)) goto L14;
        this.e.removeView(r6);
    L14:
        Integer r11 = this.g;
        if (r11 == null) goto L17;
        int r12 = r11.intValue();
    L18:
        r7.addView(r6, r12, new FrameLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(42)));
        this.g = null;
        this.e.setVisibility(8);
        CategoryLineaLayoutManager r13 = new CategoryLineaLayoutManager(getContext());
        r13.setOrientation(0);
        r6.setLayoutManager(r13);
        bi2.a r14 = bi2.a.a;
        int r1 = UtilityKotlinExtentionsKt.d(8);
        int r4 = UtilityKotlinExtentionsKt.d(0);
        r14.getClass();
        RecyclerView.ItemDecoration r15 = bi2.a.b(3, false, true, r1, r4);
        Intrinsics.checkNotNullParameter(r15, "decoration");
        r6.t();
        r6.addItemDecoration(r15);
        Pair<Integer, Integer> r16 = this.h;
        if (r16 == null) goto L35;
        int r5 = ((Number) r16.component1()).intValue();
        int r17 = ((Number) r16.component2()).intValue();
        Intrinsics.checkNotNullParameter(r6, "$this$scrollToPositionWithOffset");
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L30
        RecyclerView.LayoutManager r19 = r6.getLayoutManager();     // Catch: Throwable -> L30
        if ((r19 instanceof LinearLayoutManager) == true) goto L24;
        r19 = null;
    L24:
        LinearLayoutManager r20 = (LinearLayoutManager) r19;     // Catch: Throwable -> L30
        if (r20 == null) goto L27;
        r20.scrollToPositionWithOffset(r5, r17);     // Catch: Throwable -> L30
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L30
    L32:
        Throwable r23 = Result.exceptionOrNull-impl(r22);
        if (r23 == null) goto L35;
        ECExceptionMonitor.e(r23);
        goto L35
    L27:
        r21 = null;
    L30:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        setOnClickListener(null);
        this.f = State.STATE_COLLAPSED;
        return;
    L17:
        r12 = -1;
        goto L18
    }

    public /* synthetic */ CategoryExpandView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void R5(final CategoryRecyclerView r9, final FrameLayout r10, final RelativeLayout r11, final gi2.a r12) {
        Intrinsics.checkNotNullParameter(r9, "categoryRecyclerView");
        Intrinsics.checkNotNullParameter(r10, "categoryRecyclerViewContainer");
        Intrinsics.checkNotNullParameter(r12, "promotionListParams");
        if (r11 != null) goto L5;
        return;
    L5:
        f.c(this.a, null, null, new CategoryExpandView$bind$1(this, r12, r9, r10, r11), 3);
        new v("livesdk_list_tab_more_show", r12).i("c19983.d324484");
    }
}
