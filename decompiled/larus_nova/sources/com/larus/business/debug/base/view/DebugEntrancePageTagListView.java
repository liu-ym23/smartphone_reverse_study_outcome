package com.larus.business.debug.base.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewGroupKt;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.business.debug.base.register.EntrancePage;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import cw8.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.c6;
import v19.i5;
import zv8.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u000e\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001b\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\"\u0010\u001f\u001a\u00020\u00142\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/larus/business/debug/base/view/DebugEntrancePageTagListView;", "Landroid/widget/HorizontalScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", KtvSubElement.CONTAINER, "Landroid/widget/LinearLayout;", "textColorStateList", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "clickListener", "com/larus/business/debug/base/view/DebugEntrancePageTagListView$clickListener$1", "Lcom/larus/business/debug/base/view/DebugEntrancePageTagListView$clickListener$1;", "performClick", "Lkotlin/Function2;", "", "", "", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "value", "current", "setCurrent", "(I)V", "bindData", "list", "", "Lcom/larus/business/debug/base/register/EntrancePage;", "onItemClick", "click", "createItemView", "Landroid/widget/TextView;", "data", "select", "index", "setupWithViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebugEntrancePageTagListView extends HorizontalScrollView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f320070g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f320071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f320072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f320073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Integer, ? super String, Unit> f320074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f320075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f320076f;

    public static final class a extends c6 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DebugEntrancePageTagListView f320077c;

        public a(DebugEntrancePageTagListView r100) {
            this.f320077c = r100;
        }

        @Override // v19.c6
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Object r101 = r100.getTag();
            if ((r101 instanceof Integer) == false) goto L5;
            Integer r102 = (Integer) r101;
        L6:
            if (r102 == null) goto L11;
            DebugEntrancePageTagListView r103 = this.f320077c;
            int r104 = r102.intValue();
            DebugEntrancePageTagListView.a(r103, r104);
            Function2<? super Integer, ? super String, Unit> r105 = r103.f320074d;
            if (r105 == null) goto L12;
            r105.invoke(Integer.valueOf(r104), "");
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f320078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DebugEntrancePageTagListView f320079b;

        public b(View r100, DebugEntrancePageTagListView r101) {
            this.f320078a = r100;
            this.f320079b = r101;
        }

        public final void a() {
            int r100 = ((this.f320078a.getLeft() + (this.f320078a.getWidth() / 2)) - (this.f320079b.getWidth() / 2)) + i5.g();
            ObjectAnimator r101 = this.f320079b.f320075e;
            if (r101 == null) goto L5;
            r101.cancel();
        L5:
            DebugEntrancePageTagListView r102 = this.f320079b;
            ObjectAnimator r103 = ObjectAnimator.ofInt(r102, "scrollX", new int[]{r102.getScrollX(), r100});
            r103.setDuration(200);
            r103.start();
            r102.f320075e = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DebugEntrancePageTagListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    private final void setCurrent(int r100) {
        if (this.f320076f != r100) goto L5;
        return;
    L5:
        this.f320076f = r100;
        b(r100);
    }

    public final void b(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= this.f320071a.getChildCount()) goto L21;
        View r101 = ViewGroupKt.get(this.f320071a, r100);
        LinearLayout r102 = this.f320071a;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L15;
        View r105 = r102.getChildAt(r104);
        r105.setSelected(Intrinsics.areEqual(r105, r101));
        if ((r105 instanceof TextView) == false) goto L11;
        TextView r106 = (TextView) r105;
    L12:
        if (r106 == null) goto L14;
        r106.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r105, r101) ? 1 : 0);
    L14:
        r104 = r104 + 1;
        goto L7
    L11:
        r106 = null;
        goto L12
    L15:
        postDelayed(new b(r101, this), 100);
        return;
    }

    public final void setupWithViewPager(final ViewPager r110) {
        int r100 = 0;
        setCurrent(0);
        this.f320074d = new c(r110);
        k.f573760a.getClass();
        List<EntrancePage> r101 = k.f573763d;
        this.f320071a.removeAllViews();
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L10;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r106 = ((EntrancePage) r104).getDes();
        TextView r107 = new TextView(getContext());
        r107.setText(r106);
        r107.setTextSize(1, 16.0f);
        r107.setTextColor(this.f320072b);
        r107.setBackground(AppCompatResources.getDrawable(r107.getContext(), R.drawable.larus_debug_entrance_tab_selector));
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.setMarginStart(i5.e0());
        r108.setMarginEnd(i5.e0());
        r107.setLayoutParams(r108);
        r107.setTag(Integer.valueOf(r103));
        r107.setOnClickListener(this.f320073c);
        r107.setClickable(true);
        this.f320071a.addView(r107);
        r103 = r105;
        goto L4
    L10:
        if ((!r101.isEmpty()) == true) goto L13;
        r100 = 8;
    L13:
        setVisibility(r100);
        b(this.f320076f);
        if (r110 == null) goto L20;
        r110.setOnPageChangeListener(new AnonymousClass2(this));
        return;
    }

    public DebugEntrancePageTagListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LinearLayout r102 = new LinearLayout(r100);
        this.f320071a = r102;
        this.f320072b = AppCompatResources.getColorStateList(r100, R.color.larus_debug_entrance_tag_text_color);
        this.f320073c = new a(this);
        this.f320076f = -1;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -2);
        r103.bottomMargin = i5.c();
        r102.setOrientation(0);
        addView(r102, r103);
        setHorizontalScrollBarEnabled(false);
    }

    public static final /* synthetic */ void a(DebugEntrancePageTagListView r100, int r101) {
        r100.setCurrent(r101);
    }
}
