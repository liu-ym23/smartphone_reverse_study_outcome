package com.larus.home.impl.chat.multi_tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u0015H\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/home/impl/chat/multi_tab/ChatMultiTabConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "isDragEvent", "", "Ljava/lang/Boolean;", "touchSlop", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "isPagerEnabled", "setPagerEnabled", "", "enable", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMultiTabConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f344197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f344198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f344199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f344200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewPager2 f344201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f344202f;

    public static final class a {
    }

    static {
    }

    public ChatMultiTabConstraintLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatMultiTabConstraintLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = getChildAt(0);
        if ((r100 instanceof ViewPager2) == false) goto L5;
        ViewPager2 r101 = (ViewPager2) r100;
    L6:
        this.f344201e = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f344202f == false) goto L5;
        int r101 = r100.getAction();
        boolean r102 = true;
        if (r101 == 0) goto L31;
        if (r101 != 1) goto L10;
    L27:
        ViewPager2 r103 = this.f344201e;
        if (r103 == null) goto L30;
        r103.setUserInputEnabled(true);
    L30:
        this.f344199c = null;
        FLogger.f375446a.d("ChatMultiTabConstraintLayout", "action up/cancel");
    L36:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r101 != 2) goto L12;
        float r104 = Math.abs(r100.getX() - this.f344197a);
        float r105 = Math.abs(r100.getY() - this.f344198b);
        FLogger r106 = FLogger.f375446a;
        r106.d("ChatMultiTabConstraintLayout", "action move, dx = " + r104 + ", dy = " + r105 + ", touchSlop = " + this.f344200d);
        int r107 = this.f344200d;
        if (r104 >= r107) goto L19;
        if (r105 < r107) goto L36;
    L19:
        if (this.f344199c != null) goto L36;
        StringBuilder r108 = new StringBuilder("dx * 0.364 = ");
        float r109 = r104 * 0.364f;
        r108.append(r109);
        r108.append(", dy = ");
        r108.append(r105);
        r106.d("ChatMultiTabConstraintLayout", r108.toString());
        if (r109 > r105) goto L24;
        r102 = false;
    L24:
        Boolean r110 = Boolean.valueOf(r102);
        this.f344199c = r110;
        ViewPager2 r111 = this.f344201e;
        if (r111 == null) goto L36;
        r111.setUserInputEnabled(Intrinsics.areEqual(r110, Boolean.TRUE));
        goto L36
    L12:
        if (r101 == 3) goto L27;
    L31:
        this.f344197a = r100.getX();
        this.f344198b = r100.getY();
        ViewPager2 r112 = this.f344201e;
        if (r112 == null) goto L34;
        r112.setUserInputEnabled(true);
    L34:
        this.f344199c = null;
        FLogger.f375446a.d("ChatMultiTabConstraintLayout", "action down");
        goto L36
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setPagerEnabled(boolean r100) {
        this.f344202f = r100;
    }

    public ChatMultiTabConstraintLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f344200d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f344202f = true;
    }

    public /* synthetic */ ChatMultiTabConstraintLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
