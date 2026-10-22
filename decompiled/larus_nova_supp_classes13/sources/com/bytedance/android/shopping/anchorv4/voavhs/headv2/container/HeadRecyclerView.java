package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.widget.d;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.c;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer.BgDecorLayer;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/HeadRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/shopping/anchorv3/widget/d;", "Landroidx/recyclerview/widget/PagerSnapHelper;", "c", "Landroidx/recyclerview/widget/PagerSnapHelper;", "getPagerSnapHelper", "()Landroidx/recyclerview/widget/PagerSnapHelper;", "setPagerSnapHelper", "(Landroidx/recyclerview/widget/PagerSnapHelper;)V", "pagerSnapHelper", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ability/s;", "k", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ability/s;", "getHeadAbility", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ability/s;", "headAbility", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadRecyclerView extends RecyclerView implements d {
    public boolean a;
    public float b;
    public PagerSnapHelper c;
    public final int d;
    public boolean e;
    public boolean f;
    public float g;
    public float h;
    public BgDecorLayer i;
    public Boolean j;
    public final s k;
    public final b l;

    public static final class a implements Runnable {
        public final /* synthetic */ HeadRecyclerView a;

        public a(HeadRecyclerView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PagerSnapHelper r0 = this.a.getPagerSnapHelper();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.attachToRecyclerView(this.a);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final s getHeadAbility() {
        return this.k;
    }

    public final PagerSnapHelper getPagerSnapHelper() {
        return this.c;
    }

    public final boolean b(MotionEvent r3) {
        if (this.f == false) goto L11;
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getAction() == 2) goto L8;
        return false;
    L8:
        if (r(r3) == false) goto L15;
        return true;
    L15:
        return false;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        Integer r0 = null;
        if (r8 == null) goto L5;
        Integer r1 = Integer.valueOf(r8.getAction());
    L7:
        if (r1 != null) goto L10;
    L12:
        if (r1 != null) goto L15;
    L34:
        if (r1 != null) goto L37;
    L46:
        if (r1 != null) goto L49;
    L68:
        if (this.e == false) goto L70;
    L71:
        return true;
    L70:
        if (super/*android.view.ViewGroup*/.dispatchTouchEvent(r8) == true) goto L71;
        return false;
    L49:
        if (r1.intValue() != 0) goto L68;
        this.f = true;
        this.e = false;
        this.a = false;
        this.b = r8.getX();
        if (this.k.isExpanded() == true) goto L53;
        Integer r2 = getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L59;
        r0 = r2;
    L59:
        LinearLayoutManager r3 = (LinearLayoutManager) r0;
        if (r3 == null) goto L62;
        int r4 = r3.findLastCompletelyVisibleItemPosition();
    L63:
        if (r4 < 0) goto L68;
        RecyclerView.Adapter r5 = getAdapter();
        if (r5 == null) goto L68;
        r5.getItemCount();
        goto L68
    L62:
        r4 = -1;
        goto L63
    L53:
        if (t(true) == false) goto L68;
        this.a = true;
        goto L68
    L37:
        if (r1.intValue() != 2) goto L46;
        if (this.a == false) goto L68;
        if ((this.b - r8.getX()) <= this.d) goto L68;
        if (this.e == true) goto L45;
        requestDisallowInterceptTouchEvent(true);
    L45:
        this.e = true;
        goto L68
    L15:
        if (r1.intValue() != 3) goto L34;
    L16:
        this.f = false;
        if (this.k.isExpanded() == false) goto L68;
        if (this.a == false) goto L68;
        if (this.e == false) goto L68;
        if (r8.getX() >= this.b) goto L68;
        this.k.eh().u();
        RecyclerView.Adapter r6 = getAdapter();
        if (r6 == null) goto L68;
        Integer r7 = Integer.valueOf(r6.getItemCount());
        if (r7.intValue() < 2) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L32;
        r0 = r7;
    L32:
        if (r0 == null) goto L68;
        int r10 = r0.intValue();
        post(new a(this));
        scrollToPosition(r10 - 2);
        goto L68
    L29:
        r9 = false;
        goto L30
    L10:
        if (r1.intValue() != 1) goto L12;
    L5:
        r1 = null;
        goto L7
    }

    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "c");
        super.onDraw(r2);
        BgDecorLayer r0 = this.i;
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        if (r6 == null) goto L12;
        if (r6.getAction() != 2) goto L12;
        if (this.j != null) goto L12;
        if (Math.abs(this.b - r6.getX()) <= this.d) goto L12;
        this.j = Boolean.TRUE;
    L12:
        if (Intrinsics.areEqual(this.j, Boolean.TRUE) == false) goto L15;
        this.j = Boolean.FALSE;
        return false;
    L15:
        boolean r1 = super.onInterceptTouchEvent(r6);
        if (r6 == null) goto L18;
        Integer r3 = Integer.valueOf(r6.getAction());
    L19:
        if (r3 != null) goto L22;
    L24:
        if (r3 != null) goto L27;
    L33:
        return r1;
    L27:
        if (r3.intValue() != 2) goto L33;
        if (getScrollState() == 1) goto L33;
        if (r(r6) == false) goto L33;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L33
    L22:
        if (r3.intValue() != 0) goto L24;
        this.j = null;
        this.g = r6.getX();
        this.h = r6.getY();
        goto L33
    L18:
        r3 = null;
        goto L19
    }

    public final boolean r(MotionEvent r8) {
        if (Math.abs(this.h - r8.getY()) >= (((double) Math.abs(this.g - r8.getX())) * 1.2d)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setPagerSnapHelper(PagerSnapHelper r1) {
        this.c = r1;
    }

    public final boolean t(boolean r3) {
        RecyclerView.LayoutManager r0 = getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == true) goto L5;
        r0 = null;
    L5:
        LinearLayoutManager r1 = (LinearLayoutManager) r0;
        if (r1 == null) goto L10;
        if (r3 == false) goto L9;
        int r4 = r1.findLastCompletelyVisibleItemPosition();
    L11:
        if (r4 < 0) goto L17;
        RecyclerView.Adapter r2 = getAdapter();
        if (r2 == null) goto L17;
        if (r2.getItemViewType(r4) != 1) goto L17;
        return true;
    L17:
        return false;
    L9:
        r4 = r1.findLastVisibleItemPosition();
        goto L11
    L10:
        r4 = -1;
        goto L11
    }

    public final void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        int r1 = View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
        if (h.a() == false) goto L30;
        b r13 = this.l;
        Integer r2 = r13.h;
        if (r2 != null) goto L8;
    L9:
        boolean r3 = true;
    L11:
        r13.h = Integer.valueOf(r12);
        if (r13.j.eI() == false) goto L18;
        c r4 = r13.b;
        if (r4 == null) goto L18;
        Integer r5 = r4.e;
        if (r5 == null) goto L18;
        int r14 = r5.intValue();
    L28:
        r11 = View.MeasureSpec.makeMeasureSpec(r14, 1073741824);
    L35:
        super.onMeasure(r1, r11);
        return;
    L18:
        Integer r6 = r13.c;
        if (r6 != null) goto L21;
        int r7 = r13.j.bz();
        r13.d = r7;
        int r15 = (int) b.k(r13, r7, null, null, null, 14);
        r13.c = Integer.valueOf(r15);
        r6 = Integer.valueOf(r15);
    L27:
        r13.c = r6;
        r14 = r6.intValue();
        goto L28
    L21:
        if (r3 == false) goto L27;
        int r8 = r13.d;
        View r9 = r13.f;
        if (r9 == null) goto L25;
        float r16 = r9.getX();
    L26:
        r6 = Integer.valueOf(r13.a(r8, r16, Integer.valueOf(r12)));
        goto L27
    L25:
        r16 = 0.0f;
        goto L26
    L8:
        if (r12 != r2.intValue()) goto L9;
        r3 = false;
        goto L11
    L30:
        if (this.k.i() == false) goto L33;
        r11 = View.MeasureSpec.makeMeasureSpec((int) ((r12 / 3) * 4.0f), 1073741824);
        goto L35
    L33:
        if (this.l.o() == true) goto L35;
        r11 = View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeadRecyclerView(Context r2, s r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        Intrinsics.checkNotNullParameter(r4, "sizeHelper");
        super(r2);
        this.k = r3;
        this.l = r4;
        this.d = ViewConfiguration.get(r2).getScaledTouchSlop();
        setOverScrollMode(2);
        setItemAnimator(null);
    }
}
