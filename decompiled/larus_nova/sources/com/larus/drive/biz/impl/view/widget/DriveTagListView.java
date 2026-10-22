package com.larus.drive.biz.impl.view.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p79.b;
import p79.d;
import v19.c;
import v19.i5;
import zp9.u;
import zp9.w;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020#H\u0016J\u0016\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\"\u00101\u001a\u00020 2\u0018\u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eH\u0016J\u0016\u0010!\u001a\u00020 2\f\u00103\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0012\u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001b\u0010\u0014R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010)¨\u00067"}, d2 = {"Lcom/larus/drive/biz/impl/view/widget/DriveTagListView;", "Landroid/widget/HorizontalScrollView;", "Lcom/larus/platform/api/creation/ITabListLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", RootDescription.ROOT_ELEMENT, "Landroid/widget/FrameLayout;", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "indicator", "Landroid/view/View;", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "selectedColor", "", "getSelectedColor", "()I", "selectedColor$delegate", "Lkotlin/Lazy;", "unSelectedColor", "getUnSelectedColor", "unSelectedColor$delegate", "indicatorColor", "getIndicatorColor", "indicatorColor$delegate", "performClick", "Lkotlin/Function2;", "", "", "canScroll", "Lkotlin/Function0;", "", "innerCurrent", "value", "current", "getCurrent", "setCurrent", "(I)V", "select", "index", "scrollable", "bindData", "list", "", "Lcom/larus/platform/api/creation/TabTag;", "onItemClick", "click", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTagListView extends HorizontalScrollView implements u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f341477k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f341478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f341479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f341480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f341481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f341482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f341483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f341484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f341485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Boolean> f341486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f341487j;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f341488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DriveTagListView f341489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f341490c;

        public a(View r100, DriveTagListView r101, boolean r102) {
            this.f341488a = r100;
            this.f341489b = r101;
            this.f341490c = r102;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            if (this.f341488a.getWidth() > 0) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(this.f341488a.getParent(), this.f341489b.f341479b) == false) goto L17;
            int r109 = ((this.f341488a.getLeft() + (this.f341488a.getWidth() / 2)) - (this.f341489b.getWidth() / 2)) + i5.g();
            ViewGroup.LayoutParams r110 = this.f341489b.f341480c.getLayoutParams();
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r110;
            r111.width = this.f341488a.getWidth();
            r111.leftMargin = this.f341488a.getLeft();
            r111.topMargin = this.f341489b.f341479b.getBottom() + i5.j0();
            this.f341489b.f341480c.setLayoutParams(r111);
            if (this.f341490c == true) goto L10;
            this.f341489b.scrollTo(r109, 0);
            return;
        L10:
            ObjectAnimator r112 = this.f341489b.f341481d;
            if (r112 == null) goto L13;
            r112.cancel();
        L13:
            DriveTagListView r113 = this.f341489b;
            ObjectAnimator r114 = ObjectAnimator.ofInt(r113, "scrollX", new int[]{r113.getScrollX(), r109});
            r114.setDuration(200);
            r114.start();
            r113.f341481d = r114;
            return;
        }
    }

    private final int getIndicatorColor() {
        return ((Number) this.f341484g.getValue()).intValue();
    }

    private final int getSelectedColor() {
        return ((Number) this.f341482e.getValue()).intValue();
    }

    private final int getUnSelectedColor() {
        return ((Number) this.f341483f.getValue()).intValue();
    }

    @Override // zp9.u
    public int getCurrent() {
        return this.f341487j;
    }

    public DriveTagListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // zp9.u
    public final void a(Function2<? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        this.f341485h = r100;
    }

    @Override // zp9.u
    public final void c(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
        this.f341486i = r100;
    }

    @Override // zp9.u
    public final void d(List<w> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        this.f341479b.removeAllViews();
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((true ^ ((w) r102).a()) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        Iterator r103 = r100.iterator();
        int r104 = 0;
        final int r105 = 0;
    L10:
        if (r103.hasNext() == false) goto L28;
        Object r106 = r103.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        final w r108 = (w) r106;
        TextView r109 = new TextView(getContext());
        String r111 = r108.f573273b;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r109.setText(r111);
        r109.setTextSize(0, r109.getResources().getDimension(c.b(R.attr.larus_sp_17, null, R.dimen.larus_sp_17)));
        r109.setTypeface(Typeface.DEFAULT, 1);
        r109.setTextColor(getUnSelectedColor());
        r109.setIncludeFontPadding(true);
        r109.setGravity(16);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        if (r105 != 0) goto L21;
        int r113 = i5.q();
    L22:
        r112.setMarginStart(r113);
        if (r105 != (r100.size() - 1)) goto L25;
        int r114 = i5.q();
    L26:
        r112.setMarginEnd(r114);
        r109.setLayoutParams(r112);
        r109.setClickable(true);
        r109.setOnClickListener(new d(this, r105, r108));
        this.f341479b.addView(r109);
        r105 = r107;
        goto L10
    L25:
        r114 = i5.h();
        goto L26
    L21:
        r113 = i5.h();
        goto L22
    L28:
        if ((!r110.isEmpty()) == true) goto L31;
        r104 = 8;
    L31:
        setVisibility(r104);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Function0<Boolean> r101 = this.f341486i;
        if (r101 == null) goto L5;
        boolean r102 = r101.invoke().booleanValue();
    L6:
        if (r102 == true) goto L8;
    L10:
        return false;
    L8:
        if (super.onTouchEvent(r100) == false) goto L10;
        return true;
    L5:
        r102 = true;
        goto L6
    }

    @Override // zp9.u
    public void setCurrent(int r100) {
        if (this.f341487j != r100) goto L5;
        return;
    L5:
        this.f341487j = r100;
        b(getCurrent(), true);
    }

    public DriveTagListView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        FrameLayout r102 = new FrameLayout(r100);
        this.f341478a = r102;
        LinearLayout r103 = new LinearLayout(r100);
        this.f341479b = r103;
        View r104 = new View(r100);
        this.f341480c = r104;
        this.f341482e = LazyKt.lazy(new p79.a(r100));
        this.f341483f = LazyKt.lazy(new b(r100));
        this.f341484g = LazyKt.lazy(new p79.c(r100));
        this.f341487j = -1;
        addView(r102, new FrameLayout.LayoutParams(-1, -2));
        setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.topMargin = i5.c();
        r105.bottomMargin = i5.z();
        r103.setOrientation(0);
        r102.addView(r103, r105);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(0, i5.z());
        r104.setBackgroundColor(getIndicatorColor());
        r102.addView(r104, r106);
    }

    @Override // zp9.u
    public final void b(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f341479b.getChildCount()) goto L44;
        this.f341487j = r100;
        View r102 = ViewGroupKt.get(this.f341479b, r100);
        LinearLayout r103 = this.f341479b;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L19;
        View r106 = r103.getChildAt(r105);
        r106.setSelected(Intrinsics.areEqual(r106, r102));
        if ((r106 instanceof TextView) == false) goto L11;
        TextView r107 = (TextView) r106;
    L12:
        if (r107 == null) goto L17;
        if (Intrinsics.areEqual(r106, r102) == false) goto L16;
        r107.setTextColor(getSelectedColor());
        goto L17
    L16:
        r107.setTextColor(getUnSelectedColor());
    L17:
        r105 = r105 + 1;
        goto L7
    L11:
        r107 = null;
        goto L12
    L19:
        if (isLaidOut() == true) goto L21;
    L34:
        addOnLayoutChangeListener(new a(r102, this, r101));
        return;
    L21:
        if (isLayoutRequested() == true) goto L34;
        if (r102.getWidth() > 0) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r102.getParent(), this.f341479b) == false) goto L45;
        int r108 = ((r102.getLeft() + (r102.getWidth() / 2)) - (getWidth() / 2)) + i5.g();
        ViewGroup.LayoutParams r109 = this.f341480c.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r109;
        r110.width = r102.getWidth();
        r110.leftMargin = r102.getLeft();
        r110.topMargin = this.f341479b.getBottom() + i5.j0();
        this.f341480c.setLayoutParams(r110);
        if (r101 == true) goto L30;
        scrollTo(r108, 0);
        return;
    L30:
        ObjectAnimator r111 = this.f341481d;
        if (r111 == null) goto L33;
        r111.cancel();
    L33:
        ObjectAnimator r112 = ObjectAnimator.ofInt(this, "scrollX", new int[]{getScrollX(), r108});
        r112.setDuration(200);
        r112.start();
        this.f341481d = r112;
        return;
    L45:
        return;
    }
}
