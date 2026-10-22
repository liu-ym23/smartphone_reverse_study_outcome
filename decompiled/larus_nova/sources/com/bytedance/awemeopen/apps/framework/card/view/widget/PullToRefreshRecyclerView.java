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
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class PullToRefreshRecyclerView extends FrameLayout implements Handler.Callback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f193927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f193928k = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AosFixedHorizontalRecyclerView f193929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f193930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f193931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f193932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f193933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f193934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f193935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f193936h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f193937i;

    public interface a {
    }

    public void setOnPullToBottomListener(a r100) {
    }

    public final void a() {
        if (this.f193933e == true) goto L5;
        b();
        return;
    L5:
        if ((SystemClock.uptimeMillis() - f193927j) > 1000) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L10;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
        this.f193935g.removeMessages(1);
        this.f193935g.sendEmptyMessageDelayed(1, 280);
    L18:
        this.f193933e = false;
        return;
    L15:
        if (NetworkUtils.b(getContext()) == true) goto L17;
        b();
        goto L18
    L17:
        this.f193935g.removeMessages(1);
        this.f193935g.sendEmptyMessageDelayed(1, 280);
        goto L18
    L10:
        f193927j = SystemClock.uptimeMillis();
        r101 = false;
        goto L12
    L7:
        r100 = false;
        goto L8
    }

    public final void b() {
        AosFixedHorizontalRecyclerView r100 = this.f193929a;
        RecyclerView.ViewHolder r101 = r100.findViewHolderForAdapterPosition(r100.getAdapter().getItemCount() - 1);
        if ((r101 instanceof EmptyFootViewHolder) == false) goto L8;
        final EmptyFootViewHolder r102 = (EmptyFootViewHolder) r101;
        final View r103 = this.f193937i;
        View r104 = r102.f193915d;
        if (r104 == null) goto L9;
        r102.f193913b.setText(r104.getResources().getString(R.string.aos_video_card_left_move_tips));
        final LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r102.f193915d.getLayoutParams();
        final LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r102.f193914c.getLayoutParams();
        final LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r102.f193916e.getLayoutParams();
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{r105.width, 0.0f});
        r108.addUpdateListener(new dy3.a(r102, r105, r106, r107, r103));
        r108.setInterpolator(new AccelerateInterpolator());
        r108.setDuration(300);
        r108.start();
        return;
    L9:
        return;
    }

    static {
        f193928k = n0.a(y54.a.a(), 64.0f);
    }

    public AosFixedHorizontalRecyclerView getRecyclerView() {
        return this.f193929a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public PullToRefreshRecyclerView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L6;
    L18:
        return super.dispatchTouchEvent(r100);
    L20:
        return false;
    L6:
        if (r101 != 2) goto L18;
        if (Math.abs((int) (r100.getRawX() - this.f193930b)) < Math.abs((int) (r100.getRawY() - this.f193931c))) goto L11;
    L13:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L18
    L11:
        if (this.f193932d == true) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L18
    L14:
        this.f193930b = (int) r100.getRawX();
        this.f193931c = (int) r100.getRawY();
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L18
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what == 1) goto L10;
    L8:
        return true;
    L10:
        AosFixedHorizontalRecyclerView r101 = this.f193929a;     // Catch: Throwable -> L9
        RecyclerView.ViewHolder r102 = r101.findViewHolderForAdapterPosition(r101.getAdapter().getItemCount() - 1);     // Catch: Throwable -> L9
        if ((r102 instanceof EmptyFootViewHolder) == false) goto L8;
        ((EmptyFootViewHolder) r102).T3(this.f193937i);     // Catch: Throwable -> L9
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        AosFixedHorizontalRecyclerView r101 = this.f193929a;
        if (r101 == null) goto L32;
        if (r101.getChildCount() == 0) goto L32;
        int r102 = r100.getAction();
        if (r102 != 0) goto L10;
        this.f193930b = r100.getRawX();
        this.f193931c = r100.getRawY();
    L34:
        return super.onInterceptTouchEvent(r100);
    L36:
        return false;
    L10:
        if (r102 != 2) goto L34;
        int r103 = (int) (r100.getRawX() - this.f193930b);
        int r104 = (int) (r100.getRawY() - this.f193931c);
        if (Math.abs(r103) >= Math.abs(r104)) goto L15;
        a();
        goto L34
    L15:
        RecyclerView.LayoutManager r105 = this.f193929a.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L18;
        int r106 = ((LinearLayoutManager) r105).findLastCompletelyVisibleItemPosition();
    L19:
        if (r103 < 0) goto L21;
        this.f193932d = false;
        goto L34
    L21:
        if (r106 == (this.f193929a.getAdapter().getItemCount() - 1)) goto L23;
    L26:
        this.f193932d = false;
        goto L34
    L23:
        if (this.f193936h == true) goto L26;
        this.f193932d = true;
        return true;
    L18:
        r106 = -1;
    L32:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        AosFixedHorizontalRecyclerView r100 = this.f193929a;
        if (r100 == null) goto L48;
        if (r100.getChildCount() == 0) goto L48;
        int r101 = r110.getAction();
        if (r101 != 0) goto L10;
        this.f193930b = r110.getRawX();
        this.f193931c = r110.getRawY();
    L46:
        return true;
    L10:
        if (r101 == 1) goto L43;
        if (r101 != 2) goto L46;
        if (this.f193932d == false) goto L46;
        int r111 = (int) (r110.getRawX() - this.f193930b);
        if (r111 >= 0) goto L50;
        AosFixedHorizontalRecyclerView r102 = this.f193929a;
        RecyclerView.ViewHolder r103 = r102.findViewHolderForAdapterPosition(r102.getAdapter().getItemCount() - 1);
        if ((r103 instanceof EmptyFootViewHolder) == false) goto L46;
        EmptyFootViewHolder r104 = (EmptyFootViewHolder) r103;
        View r105 = this.f193937i;
        r104.f193912a.setMoveSpace(r111);
        int r106 = Math.abs(r111);
        View r107 = r104.f193914c;
        if (r107 == null) goto L27;
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107.getLayoutParams();
        int r109 = (int) (r106 / 8.0f);
        r108.width = r109;
        int r112 = r109 + 0;
        r104.f193914c.setLayoutParams(r108);
    L28:
        View r113 = r104.f193915d;
        if (r113 == null) goto L31;
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r113.getLayoutParams();
        int r115 = (int) (r106 / 4.0f);
        r114.width = r115;
        r112 = r112 + r115;
        r104.f193915d.setLayoutParams(r114);
    L31:
        if (r105 == null) goto L34;
        r105.scrollTo(r112, r105.getScrollY());
    L34:
        if (Math.abs(r111) <= f193928k) goto L41;
        r104.f193913b.setText(getResources().getString(R.string.aos_video_card_left_move_tips_release));
        this.f193933e = true;
        if (this.f193934f == true) goto L46;
        this.f193934f = true;
        TextView r116 = r104.f193913b;
        if (r116 == null) goto L40;
        AnimatorSet r117 = new AnimatorSet();
        ObjectAnimator r118 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.05f});
        r118.setDuration(200);
        ObjectAnimator r119 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.05f});
        r119.setDuration(200);
        ObjectAnimator r120 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.05f, 1.0f});
        r120.setDuration(200);
        ObjectAnimator r121 = ObjectAnimator.ofFloat(r116, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.05f, 1.0f});
        r121.setDuration(200);
        r117.play(r118).with(r119);
        r117.play(r120).with(r121);
        r117.play(r118).before(r120);
        r117.start();
    L40:
        r104.f193913b.performHapticFeedback(0, 2);
        goto L46
    L41:
        this.f193934f = false;
        r104.f193913b.setText(getResources().getString(R.string.aos_video_card_left_move_tips));
        this.f193933e = false;
        goto L46
    L27:
        r112 = 0;
        goto L28
    L50:
        AosFixedHorizontalRecyclerView r122 = this.f193929a;     // Catch: Throwable -> L49
        RecyclerView.ViewHolder r123 = r122.findViewHolderForAdapterPosition(r122.getAdapter().getItemCount() - 1);     // Catch: Throwable -> L49
        if ((r123 instanceof EmptyFootViewHolder) == false) goto L46;
        ((EmptyFootViewHolder) r123).T3(this.f193937i);     // Catch: Throwable -> L49
        goto L46
    L43:
        if (this.f193932d == false) goto L46;
        a();
        this.f193932d = false;
    L48:
        return super.onTouchEvent(r110);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        if (r100 == true) goto L6;
        this.f193935g.removeMessages(1);
        this.f193935g.sendEmptyMessageDelayed(1, 280);
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
    }

    public void setIsLoadingMore(boolean r100) {
        this.f193936h = r100;
    }

    public void setLayoutManager(RecyclerView.LayoutManager r100) {
        this.f193929a.setLayoutManager(r100);
    }

    public PullToRefreshRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public PullToRefreshRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193936h = false;
        LayoutInflater.from(getContext()).inflate(R.layout.aos_feed_video_card_horizotal_root, this);
        View r103 = findViewById(R.id.list_root);
        this.f193937i = r103;
        this.f193929a = (AosFixedHorizontalRecyclerView) r103.findViewById(R.id.content_list);
        this.f193935g = new Handler(Looper.getMainLooper(), this);
    }
}
