package com.larus.bot.impl.common.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import zp9.w;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bot/impl/common/view/CommonTagListView;", "Lcom/larus/bot/impl/common/view/AbsCommonTagListView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scrollAnimator", "Landroid/animation/ObjectAnimator;", "textColorStateList", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "bindData", "", "list", "", "Lcom/larus/platform/api/creation/TabTag;", "createItemView", "Landroid/widget/TextView;", "data", "", "createPlaceHolder", "Landroid/view/View;", "select", "index", "", "scrollable", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonTagListView extends AbsCommonTagListView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObjectAnimator f317702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ColorStateList f317703g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f317704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonTagListView f317705b;

        public a(View r100, CommonTagListView r101) {
            this.f317704a = r100;
            this.f317705b = r101;
        }

        public final void a() {
            int r100 = ((this.f317704a.getLeft() + (this.f317704a.getWidth() / 2)) - (this.f317705b.getWidth() / 2)) + i5.g();
            ObjectAnimator r101 = this.f317705b.f317702f;
            if (r101 == null) goto L5;
            r101.cancel();
        L5:
            CommonTagListView r102 = this.f317705b;
            ObjectAnimator r103 = ObjectAnimator.ofInt(r102, "scrollX", new int[]{r102.getScrollX(), r100});
            r103.setDuration(200);
            r103.start();
            r102.f317702f = r103;
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

    public CommonTagListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // zp9.u
    public final void d(List<w> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        getContainer().removeAllViews();
        Iterator<T> r100 = r110.iterator();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L17;
        Object r103 = r100.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        w r105 = (w) r103;
        if (r105.a() == false) goto L11;
        View r106 = new View(getContext());
        GradientDrawable r107 = new GradientDrawable();
        r107.setCornerRadius(i5.h());
        r107.setColor(ContextCompat.getColor(r106.getContext(), R.color.larus_neutral_transparent_2));
        r106.setBackground(r107);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(i5.q0(), i5.W());
        r108.setMarginStart(i5.e0());
        r108.setMarginEnd(i5.e0());
        r106.setLayoutParams(r108);
    L15:
        r106.setTag(Integer.valueOf(r102));
        r106.setOnClickListener(getClickListener());
        r106.setClickable(!r105.a());
        getContainer().addView(r106);
        r102 = r104;
        goto L4
    L11:
        String r109 = r105.f573273b;
        if (r109 != null) goto L14;
        r109 = "";
    L14:
        TextView r111 = new TextView(getContext());
        r111.setText(r109);
        r111.setTextSize(1, 16.0f);
        r111.setTextColor(this.f317703g);
        r111.setBackground(AppCompatResources.getDrawable(r111.getContext(), R.drawable.larus_ugc_bot_tag_item_bg));
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-2, -2);
        r112.setMarginStart(i5.e0());
        r112.setMarginEnd(i5.e0());
        r111.setLayoutParams(r112);
        r106 = r111;
        goto L15
    L17:
        if ((!r110.isEmpty()) == true) goto L20;
        r101 = 8;
    L20:
        setVisibility(r101);
        b(getCurrent(), true);
    }

    public CommonTagListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f317703g = AppCompatResources.getColorStateList(r100, R.color.larus_bot_tag_text_color);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -2);
        r102.bottomMargin = i5.c();
        getContainer().setOrientation(0);
        addView(getContainer(), r102);
        setHorizontalScrollBarEnabled(false);
    }

    @Override // zp9.u
    public final void b(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 >= getContainer().getChildCount()) goto L21;
        setInnerCurrent(r100);
        View r102 = ViewGroupKt.get(getContainer(), r100);
        LinearLayout r103 = getContainer();
        int r104 = r103.getChildCount();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L15;
        View r106 = r103.getChildAt(r105);
        r106.setSelected(Intrinsics.areEqual(r106, r102));
        if ((r106 instanceof TextView) == false) goto L11;
        TextView r107 = (TextView) r106;
    L12:
        if (r107 == null) goto L14;
        r107.setTypeface(Typeface.DEFAULT, Intrinsics.areEqual(r106, r102) ? 1 : 0);
    L14:
        r105 = r105 + 1;
        goto L7
    L11:
        r107 = null;
        goto L12
    L15:
        postDelayed(new a(r102, this), 100);
        return;
    }
}
