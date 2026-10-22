package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.util.NetworkUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PullToRefreshRecyclerView extends FrameLayout implements Handler.Callback {
    public static long j;
    public static final float k = 0.0f;
    public AosFixedHorizontalRecyclerView a;
    public float b;
    public float c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Handler g;
    public boolean h;
    public View i;

    public interface a {
    }

    public void setOnPullToBottomListener(a r1) {
    }

    public final void a() {
        if (this.e == true) goto L5;
        b();
        return;
    L5:
        if ((SystemClock.uptimeMillis() - j) > 1000) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        this.g.removeMessages(1);
        this.g.sendEmptyMessageDelayed(1, 280);
    L18:
        this.e = false;
        return;
    L15:
        if (NetworkUtils.b(getContext()) == true) goto L17;
        b();
        goto L18
    L17:
        this.g.removeMessages(1);
        this.g.sendEmptyMessageDelayed(1, 280);
        goto L18
    L10:
        j = SystemClock.uptimeMillis();
        r1 = false;
        goto L12
    L7:
        r0 = false;
        goto L8
    }

    public final void b() {
        AosFixedHorizontalRecyclerView r0 = this.a;
        RecyclerView.ViewHolder r1 = r0.findViewHolderForAdapterPosition(r0.getAdapter().getItemCount() - 1);
        if ((r1 instanceof EmptyFootViewHolder) == false) goto L8;
        final EmptyFootViewHolder r4 = (EmptyFootViewHolder) r1;
        final View r8 = this.i;
        View r2 = r4.d;
        if (r2 == null) goto L9;
        r4.b.setText(r2.getResources().getString(2131894292));
        final LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) r4.d.getLayoutParams();
        final LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r4.c.getLayoutParams();
        final LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r4.e.getLayoutParams();
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{r5.width, 0.0f});
        r3.addUpdateListener(new dy3.a(r4, r5, r6, r7, r8));
        r3.setInterpolator(new AccelerateInterpolator());
        r3.setDuration(300);
        r3.start();
        return;
    L9:
        return;
    }

    static {
        k = n0.a(y54.a.a(), 64.0f);
    }

    public AosFixedHorizontalRecyclerView getRecyclerView() {
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public PullToRefreshRecyclerView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        int r0 = r6.getAction();
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L6;
    L18:
        return super.dispatchTouchEvent(r6);
    L20:
        return false;
    L6:
        if (r0 != 2) goto L18;
        if (Math.abs((int) (r6.getRawX() - this.b)) < Math.abs((int) (r6.getRawY() - this.c))) goto L11;
    L13:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L18
    L11:
        if (this.d == true) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L18
    L14:
        this.b = (int) r6.getRawX();
        this.c = (int) r6.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L18
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r3) {
        if (r3.what == 1) goto L10;
    L8:
        return true;
    L10:
        AosFixedHorizontalRecyclerView r4 = this.a;     // Catch: Throwable -> L9
        RecyclerView.ViewHolder r5 = r4.findViewHolderForAdapterPosition(r4.getAdapter().getItemCount() - 1);     // Catch: Throwable -> L9
        if ((r5 instanceof EmptyFootViewHolder) == false) goto L8;
        ((EmptyFootViewHolder) r5).T3(this.i);     // Catch: Throwable -> L9
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        RecyclerView r0 = this.a;
        if (r0 == null) goto L32;
        if (r0.getChildCount() == 0) goto L32;
        int r1 = r5.getAction();
        if (r1 != 0) goto L10;
        this.b = r5.getRawX();
        this.c = r5.getRawY();
    L34:
        return super.onInterceptTouchEvent(r5);
    L36:
        return false;
    L10:
        if (r1 != 2) goto L34;
        int r2 = (int) (r5.getRawX() - this.b);
        int r3 = (int) (r5.getRawY() - this.c);
        if (Math.abs(r2) >= Math.abs(r3)) goto L15;
        a();
        goto L34
    L15:
        LinearLayoutManager r4 = this.a.getLayoutManager();
        if ((r4 instanceof LinearLayoutManager) == false) goto L18;
        int r6 = r4.findLastCompletelyVisibleItemPosition();
    L19:
        if (r2 < 0) goto L21;
        this.d = false;
        goto L34
    L21:
        if (r6 == (this.a.getAdapter().getItemCount() - 1)) goto L23;
    L26:
        this.d = false;
        goto L34
    L23:
        if (this.h == true) goto L26;
        this.d = true;
        return true;
    L18:
        r6 = -1;
    L32:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        RecyclerView r0 = this.a;
        if (r0 == null) goto L48;
        if (r0.getChildCount() == 0) goto L48;
        int r1 = r13.getAction();
        if (r1 != 0) goto L10;
        this.b = r13.getRawX();
        this.c = r13.getRawY();
    L46:
        return true;
    L10:
        if (r1 == 1) goto L43;
        if (r1 != 2) goto L46;
        if (this.d == false) goto L46;
        int r14 = (int) (r13.getRawX() - this.b);
        if (r14 >= 0) goto L50;
        AosFixedHorizontalRecyclerView r2 = this.a;
        RecyclerView.ViewHolder r3 = r2.findViewHolderForAdapterPosition(r2.getAdapter().getItemCount() - 1);
        if ((r3 instanceof EmptyFootViewHolder) == false) goto L46;
        EmptyFootViewHolder r4 = (EmptyFootViewHolder) r3;
        View r5 = this.i;
        r4.a.setMoveSpace(r14);
        int r6 = Math.abs(r14);
        View r7 = r4.c;
        if (r7 == null) goto L27;
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r7.getLayoutParams();
        int r9 = (int) (r6 / 8.0f);
        r8.width = r9;
        int r10 = r9 + 0;
        r4.c.setLayoutParams(r8);
    L28:
        View r11 = r4.d;
        if (r11 == null) goto L31;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11.getLayoutParams();
        int r15 = (int) (r6 / 4.0f);
        r12.width = r15;
        r10 = r10 + r15;
        r4.d.setLayoutParams(r12);
    L31:
        if (r5 == null) goto L34;
        r5.scrollTo(r10, r5.getScrollY());
    L34:
        if (Math.abs(r14) <= k) goto L41;
        r4.b.setText(getResources().getString(2131894293));
        this.e = true;
        if (this.f == true) goto L46;
        this.f = true;
        TextView r16 = r4.b;
        if (r16 == null) goto L40;
        AnimatorSet r17 = new AnimatorSet();
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r16, "scaleX", new float[]{1.0f, 1.05f});
        r18.setDuration(200);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r16, "scaleY", new float[]{1.0f, 1.05f});
        r19.setDuration(200);
        ObjectAnimator r20 = ObjectAnimator.ofFloat(r16, "scaleX", new float[]{1.05f, 1.0f});
        r20.setDuration(200);
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r16, "scaleY", new float[]{1.05f, 1.0f});
        r110.setDuration(200);
        r17.play(r18).with(r19);
        r17.play(r20).with(r110);
        r17.play(r18).before(r20);
        r17.start();
    L40:
        r4.b.performHapticFeedback(0, 2);
        goto L46
    L41:
        this.f = false;
        r4.b.setText(getResources().getString(2131894292));
        this.e = false;
        goto L46
    L27:
        r10 = 0;
        goto L28
    L50:
        AosFixedHorizontalRecyclerView r111 = this.a;     // Catch: Throwable -> L49
        RecyclerView.ViewHolder r112 = r111.findViewHolderForAdapterPosition(r111.getAdapter().getItemCount() - 1);     // Catch: Throwable -> L49
        if ((r112 instanceof EmptyFootViewHolder) == false) goto L46;
        ((EmptyFootViewHolder) r112).T3(this.i);     // Catch: Throwable -> L49
        goto L46
    L43:
        if (this.d == false) goto L46;
        a();
        this.d = false;
    L48:
        return super.onTouchEvent(r13);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r4) {
        super.onWindowFocusChanged(r4);
        if (r4 == true) goto L6;
        this.g.removeMessages(1);
        this.g.sendEmptyMessageDelayed(1, 280);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
    }

    public void setIsLoadingMore(boolean r1) {
        this.h = r1;
    }

    public void setLayoutManager(RecyclerView.LayoutManager r2) {
        this.a.setLayoutManager(r2);
    }

    public PullToRefreshRecyclerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PullToRefreshRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.h = false;
        LayoutInflater.from(getContext()).inflate(2131558640, this);
        View r4 = findViewById(2131378173);
        this.i = r4;
        this.a = (AosFixedHorizontalRecyclerView) r4.findViewById(2131367834);
        this.g = new Handler(Looper.getMainLooper(), this);
    }
}
