package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J \u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J \u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R9\u0010\u0012\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larus/common_ui/view/CommonSlideRootContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "startX", "startY", "touchSlop", "dismissOffset", "", "actionMoveOffset", "dismissCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "orientation", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function1;", "setDismissCallback", "(Lkotlin/jvm/functions/Function1;)V", "onFinishInflate", "initViewPager2", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onHorizontalActionMove", "endX", "disX", "disY", "onVerticalActionMove", "endY", "onTouchEvent", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonSlideRootContainer extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f328184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f328185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f328186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f328187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f328188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Integer, Unit> f328189f;

    public CommonSlideRootContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonSlideRootContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        int r100 = getChildCount();
        int r101 = 0;
    L4:
        if (r101 >= r100) goto L15;
        View r102 = getChildAt(r101);
        if ((r102 instanceof ViewPager2) == false) goto L13;
        if (r102.getVisibility() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        this.f328184a = (ViewPager2) r102;
        goto L15
    L10:
        r103 = false;
    L13:
        r101 = r101 + 1;
    L15:
        if (this.f328184a != null) goto L52;
        ViewGroup r104 = (ViewGroup) findViewById(R.id.container);
        if (r104 != null) goto L19;
        return;
    L19:
        if (r104.getChildCount() < 1) goto L67;
        View r105 = r104.getChildAt(0);
        if (r105 != null) goto L24;
        return;
    L24:
        if ((r105 instanceof ViewGroup) == false) goto L63;
        ViewGroup r106 = (ViewGroup) r105;
        if (r106.getChildCount() < 1) goto L68;
        View r107 = r106.getChildAt(0);
        if ((r107 instanceof ViewPager2) == false) goto L37;
        if (r107.getVisibility() != 0) goto L33;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L37;
        this.f328184a = (ViewPager2) r107;
        return;
    L33:
        r108 = false;
    L37:
        if ((r107 instanceof ViewGroup) == false) goto L39;
        ViewGroup r109 = (ViewGroup) r107;
    L40:
        if (r109 == null) goto L65;
        int r110 = r109.getChildCount();
        int r111 = 0;
    L42:
        if (r111 >= r110) goto L69;
        View r112 = r109.getChildAt(r111);
        if ((r112 instanceof ViewPager2) == false) goto L51;
        if (r112.getVisibility() != 0) goto L48;
        boolean r113 = true;
    L49:
        if (r113 == false) goto L51;
        this.f328184a = (ViewPager2) r112;
        return;
    L48:
        r113 = false;
    L51:
        r111 = r111 + 1;
        goto L42
    L69:
        return;
    L65:
        return;
    L39:
        r109 = null;
        goto L40
    L68:
        return;
    L63:
        return;
    L67:
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        R5();
    }

    public final Function1<Integer, Unit> getDismissCallback() {
        return this.f328189f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        if (this.f328184a != null) goto L6;
        R5();
    L6:
        if (this.f328184a == null) goto L8;
        int r100 = r110.getAction();
        if (r100 != 0) goto L12;
        this.f328185b = (int) r110.getX();
        this.f328186c = (int) r110.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L156:
        return false;
    L12:
        if (r100 != 2) goto L156;
        ViewPager2 r101 = this.f328184a;
        if (r101 != null) goto L17;
    L19:
        boolean r102 = false;
    L20:
        Integer r103 = null;
        RecyclerView.Adapter r104 = null;
        if (r102 == true) goto L36;
        ViewPager2 r105 = this.f328184a;
        if (r105 == null) goto L25;
        RecyclerView.Adapter r106 = r105.getAdapter();
    L26:
        if (r106 == null) goto L35;
        ViewPager2 r107 = this.f328184a;
        if (r107 == null) goto L32;
        RecyclerView.Adapter r108 = r107.getAdapter();
        if (r108 == null) goto L32;
        int r109 = r108.getItemCount();
    L33:
        if (r109 > 1) goto L35;
    L32:
        r109 = 0;
    L35:
        boolean r111 = false;
    L37:
        int r112 = (int) r110.getX();
        int r113 = (int) r110.getY();
        int r114 = Math.abs(r112 - this.f328185b);
        int r115 = Math.abs(r113 - this.f328186c);
        int r116 = this.f328187d;
        if (r114 >= r116) goto L42;
        if (r115 >= r116) goto L42;
        return super.onInterceptTouchEvent(r110);
    L42:
        if (r114 <= r115) goto L50;
        ViewPager2 r117 = this.f328184a;
        if (r117 != null) goto L46;
    L48:
        boolean r118 = false;
    L49:
        if (r118 == false) goto L50;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
    L60:
        if (r111 == false) goto L78;
        if (r114 <= r115) goto L69;
        ViewPager2 r119 = this.f328184a;
        if (r119 != null) goto L65;
    L67:
        boolean r120 = false;
    L68:
        if (r120 == false) goto L69;
    L77:
        return true;
    L65:
        if (r119.getOrientation() != 0) goto L67;
        r120 = true;
    L69:
        if (r115 <= r114) goto L78;
        ViewPager2 r121 = this.f328184a;
        if (r121 != null) goto L73;
    L75:
        boolean r122 = false;
    L76:
        if (r122 == false) goto L78;
    L73:
        if (r121.getOrientation() != 1) goto L75;
        r122 = true;
    L78:
        ViewPager2 r123 = this.f328184a;
        if (r123 != null) goto L81;
    L83:
        boolean r124 = false;
    L84:
        if (r124 == false) goto L116;
        ViewPager2 r125 = this.f328184a;
        if (r125 == null) goto L88;
        RecyclerView.Adapter r126 = r125.getAdapter();
    L89:
        if (r126 == null) goto L158;
        ViewPager2 r127 = this.f328184a;
        if (r127 == null) goto L94;
        Integer r128 = Integer.valueOf(r127.getCurrentItem());
    L95:
        ViewPager2 r129 = this.f328184a;
        if (r129 == null) goto L98;
        r104 = r129.getAdapter();
    L98:
        Intrinsics.checkNotNull(r104);
        int r130 = r104.getItemCount();
        if (r115 <= r114) goto L114;
        if (r128 != null) goto L103;
    L106:
        int r131 = r130 - 1;
        if (r128 == null) goto L114;
        if (r128.intValue() != r131) goto L114;
        if ((r113 - this.f328186c) >= 0) goto L114;
        return true;
    L103:
        if (r128.intValue() != 0) goto L106;
        if ((r113 - this.f328186c) <= 0) goto L106;
        return true;
    L114:
        return false;
    L94:
        r128 = null;
        goto L95
    L158:
        return true;
    L88:
        r126 = null;
        goto L89
    L116:
        ViewPager2 r132 = this.f328184a;
        if (r132 != null) goto L119;
    L121:
        boolean r133 = false;
    L122:
        if (r133 == false) goto L156;
        ViewPager2 r134 = this.f328184a;
        if (r134 == null) goto L126;
        RecyclerView.Adapter r135 = r134.getAdapter();
    L127:
        if (r135 == null) goto L161;
        if (r114 <= r115) goto L153;
        ViewPager2 r136 = this.f328184a;
        if (r136 == null) goto L133;
        r103 = Integer.valueOf(r136.getCurrentItem());
    L133:
        ViewPager2 r137 = this.f328184a;
        if (r137 == null) goto L138;
        RecyclerView.Adapter r138 = r137.getAdapter();
        if (r138 == null) goto L138;
        int r139 = r138.getItemCount();
    L139:
        if (r103 != null) goto L142;
    L145:
        int r140 = r139 - 1;
        if (r103 == null) goto L153;
        if (r103.intValue() != r140) goto L153;
        if ((r112 - this.f328185b) >= 0) goto L153;
        return true;
    L142:
        if (r103.intValue() != 0) goto L145;
        if ((r112 - this.f328185b) <= 0) goto L145;
        return true;
    L138:
        r139 = 0;
    L153:
        return false;
    L161:
        return true;
    L126:
        r135 = null;
        goto L127
    L119:
        if (r132.getOrientation() != 0) goto L121;
        r133 = true;
        goto L122
    L81:
        if (r123.getOrientation() != 1) goto L83;
        r124 = true;
        goto L84
    L46:
        if (r117.getOrientation() != 0) goto L48;
        r118 = true;
    L50:
        if (r114 >= r115) goto L59;
        ViewPager2 r141 = this.f328184a;
        if (r141 != null) goto L54;
    L56:
        boolean r142 = false;
    L57:
        if (r142 == false) goto L59;
    L54:
        if (r141.getOrientation() != 1) goto L56;
        r142 = true;
    L59:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L60
    L25:
        r106 = null;
    L36:
        r111 = true;
        goto L37
    L17:
        if (r101.isUserInputEnabled() == true) goto L19;
        r102 = true;
        goto L20
    L8:
        return super.onInterceptTouchEvent(r110);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f328184a != null) goto L6;
        R5();
    L6:
        if (this.f328184a != null) goto L10;
        return super.onTouchEvent(r100);
    L10:
        if (r100.getActionMasked() != 2) goto L71;
        float r101 = r100.getX() - this.f328185b;
        float r102 = r100.getY() - this.f328186c;
        if (Math.abs(r101) > this.f328187d) goto L14;
    L23:
        boolean r103 = false;
    L25:
        if (Math.abs(r102) > this.f328187d) goto L27;
    L36:
        boolean r104 = false;
    L37:
        if (r103 == true) goto L40;
        if (r104 == false) goto L71;
    L40:
        if (r101 <= this.f328188e) goto L49;
        ViewPager2 r105 = this.f328184a;
        if (r105 != null) goto L44;
    L46:
        boolean r106 = false;
    L47:
        if (r106 == false) goto L49;
        boolean r107 = true;
    L51:
        if (r102 <= this.f328188e) goto L60;
        ViewPager2 r108 = this.f328184a;
        if (r108 != null) goto L55;
    L57:
        boolean r109 = false;
    L58:
        if (r109 == false) goto L60;
        boolean r110 = true;
    L61:
        if (r107 == false) goto L65;
        Function1<? super Integer, Unit> r111 = this.f328189f;
        if (r111 == null) goto L65;
        r111.invoke(0);
    L65:
        if (r110 == false) goto L69;
        Function1<? super Integer, Unit> r112 = this.f328189f;
        if (r112 == null) goto L69;
        r112.invoke(1);
    L69:
        return true;
    L55:
        if (r108.getOrientation() != 1) goto L57;
        r109 = true;
    L60:
        r110 = false;
        goto L61
    L44:
        if (r105.getOrientation() != 0) goto L46;
        r106 = true;
    L49:
        r107 = false;
        goto L51
    L27:
        if (Math.abs(r102) <= Math.abs(r101)) goto L36;
        ViewPager2 r113 = this.f328184a;
        if (r113 != null) goto L31;
    L33:
        boolean r114 = false;
    L34:
        if (r114 == false) goto L36;
        r104 = true;
        goto L37
    L31:
        if (r113.getOrientation() != 1) goto L33;
        r114 = true;
        goto L34
    L14:
        if (Math.abs(r101) <= Math.abs(r102)) goto L23;
        ViewPager2 r115 = this.f328184a;
        if (r115 != null) goto L18;
    L20:
        boolean r116 = false;
    L21:
        if (r116 == false) goto L23;
        r103 = true;
        goto L25
    L18:
        if (r115.getOrientation() != 0) goto L20;
        r116 = true;
    L71:
        return super.onTouchEvent(r100);
    }

    public final void setDismissCallback(Function1<? super Integer, Unit> r100) {
        this.f328189f = r100;
    }

    public CommonSlideRootContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f328187d = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f328188e = 150.0f;
    }

    public /* synthetic */ CommonSlideRootContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
