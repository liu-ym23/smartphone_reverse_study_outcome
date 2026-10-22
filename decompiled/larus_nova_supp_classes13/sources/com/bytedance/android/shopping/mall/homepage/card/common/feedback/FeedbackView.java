package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'B\u001d\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b&\u0010*B%\b\u0016\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b&\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010#\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\"\u0010\n¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "scale", "", "setViewScale", "Landroid/widget/ImageView;", "a", "Lkotlin/Lazy;", "getFeedbackClose", "()Landroid/widget/ImageView;", "feedbackClose", "b", "getFeedbackBackImage", "feedbackBackImage", "Landroid/widget/TextView;", "c", "getFeedbackBackText", "()Landroid/widget/TextView;", "feedbackBackText", "Landroid/widget/LinearLayout;", "d", "getFeedbackContainer", "()Landroid/widget/LinearLayout;", "feedbackContainer", "Landroid/view/View;", "e", "getFeedbackFindSimilarBg", "()Landroid/view/View;", "feedbackFindSimilarBg", "f", "getFeedbackFindSimilarText", "feedbackFindSimilarText", "g", "getFeedbackFindSimilarImage", "feedbackFindSimilarImage", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedbackView extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Boolean h;
    public float i;
    public int j;
    public FeedbackModel k;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FeedbackModel a;

        public b(FeedbackModel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FeedbackModel a;

        public c(FeedbackModel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.c.invoke();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ FeedbackData.Item a;
        public final /* synthetic */ View b;
        public final /* synthetic */ FeedbackModel c;

        public d(FeedbackData.Item r1, View r2, FeedbackModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.c.a.invoke(this.a);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ FeedbackView a;
        public final /* synthetic */ FeedbackModel b;

        public e(FeedbackView r1, FeedbackModel r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            this.b.e.invoke();
            FeedbackView r4 = this.a;
            FeedbackModel r0 = this.b;
            int r1 = FeedbackView.l;
            r4.c6(r0);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ FeedbackData.Item a;
        public final /* synthetic */ View b;
        public final /* synthetic */ FeedbackModel c;

        public f(FeedbackData.Item r1, View r2, FeedbackModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.c.a.invoke(this.a);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ FeedbackView a;
        public final /* synthetic */ FeedbackModel b;

        public g(FeedbackView r1, FeedbackModel r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            FeedbackView r4 = this.a;
            FeedbackModel r0 = this.b;
            int r1 = FeedbackView.l;
            r4.b6(r0);
            this.b.d.invoke();
        }
    }

    private final ImageView getFeedbackBackImage() {
        return (ImageView) this.b.getValue();
    }

    private final TextView getFeedbackBackText() {
        return (TextView) this.c.getValue();
    }

    private final ImageView getFeedbackClose() {
        return (ImageView) this.a.getValue();
    }

    private final LinearLayout getFeedbackContainer() {
        return (LinearLayout) this.d.getValue();
    }

    private final View getFeedbackFindSimilarBg() {
        return (View) this.e.getValue();
    }

    private final ImageView getFeedbackFindSimilarImage() {
        return (ImageView) this.g.getValue();
    }

    private final TextView getFeedbackFindSimilarText() {
        return (TextView) this.f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinearLayout.LayoutParams R5() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, (int) UIUtils.dip2Px(getContext(), 0.5f));
        r0.topMargin = (int) UIUtils.dip2Px(getContext(), 8.0f * this.i);
        return r0;
    }

    public final void U5() {
        this.h = Boolean.TRUE;
        Lazy r0 = BigFontAdapter.a;
        BigFontAdapter.e(getFeedbackClose(), 6);
        BigFontAdapter.e(getFeedbackBackImage(), 6);
        BigFontAdapter.d(getFeedbackBackText());
        BigFontAdapter.e(getFeedbackFindSimilarImage(), 6);
        BigFontAdapter.d(getFeedbackFindSimilarText());
    }

    public final void Y5() {
        getFeedbackFindSimilarBg().setVisibility(8);
        getFeedbackFindSimilarText().setVisibility(8);
        getFeedbackFindSimilarImage().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackView(Context r3) {
        super(r3);
        this.a = LazyKt.lazy(new FeedbackView$feedbackClose$2(this));
        this.b = LazyKt.lazy(new FeedbackView$feedbackBackImage$2(this));
        this.c = LazyKt.lazy(new FeedbackView$feedbackBackText$2(this));
        this.d = LazyKt.lazy(new FeedbackView$feedbackContainer$2(this));
        this.e = LazyKt.lazy(new FeedbackView$feedbackFindSimilarBg$2(this));
        this.f = LazyKt.lazy(new FeedbackView$feedbackFindSimilarText$2(this));
        this.g = LazyKt.lazy(new FeedbackView$feedbackFindSimilarImage$2(this));
        this.i = 1.0f;
        this.j = 1;
        LayoutInflater.from(getContext()).inflate(2131564673, this, true);
        setBackgroundColor(ColorProtector.parseColor("#BF000000"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinearLayout.LayoutParams S5(boolean r4) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        if (r4 == true) goto L5;
        r0.topMargin = (int) UIUtils.dip2Px(getContext(), 8.0f * this.i);
    L5:
        return r0;
    }

    public final float V5(float r3) {
        if (Intrinsics.areEqual(this.h, Boolean.TRUE) == false) goto L6;
        Lazy r0 = BigFontAdapter.a;
        return BigFontAdapter.a().getScale() * r3;
    L6:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b6(FeedbackModel r10) {
        this.j = 1;
        getFeedbackBackImage().setVisibility(8);
        getFeedbackBackText().setVisibility(8);
        LinearLayout r1 = getFeedbackContainer();
        r1.removeAllViews();
        Iterator<T> r2 = r10.f.iterator();
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L17;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        FeedbackModel.a r7 = (FeedbackModel.a) r5;
        View r8 = T5(r7, true);
        FeedbackData.Item r9 = r7.a;
        if (r9 == null) goto L11;
        r8.setOnClickListener(new d(r9, r8, r10));
    L11:
        Unit r11 = Unit.INSTANCE;
        if (r4 != 0) goto L14;
        boolean r12 = true;
    L15:
        r1.addView(r8, S5(r12));
        View r13 = new View(getContext());
        r13.setBackgroundColor(ColorProtector.parseColor("#14FFFFFF"));
        r1.addView(r13, R5());
        r4 = r6;
        goto L4
    L14:
        r12 = false;
        goto L15
    L17:
        if (r10.h == false) goto L20;
        LinearLayout r3 = new LinearLayout(getContext());
        ToolsKt.y(r3, r10.i + " 按钮");
        r3.setOrientation(0);
        r3.setGravity(16);
        ImageView r14 = new ImageView(r3.getContext());
        r14.setImageResource(2131248013);
        ToolsKt.b(r14);
        Unit r15 = Unit.INSTANCE;
        r3.addView(r14, (int) V5(UIUtils.dip2Px(r3.getContext(), this.i * 20.0f)), (int) V5(UIUtils.dip2Px(r3.getContext(), this.i * 20.0f)));
        TextView r16 = new TextView(r3.getContext());
        r16.setText(r10.i);
        r16.setTextSize(1, V5(this.i * 13.0f));
        r16.setTextColor(ColorProtector.parseColor("#E5FFFFFF"));
        r16.setMaxLines(1);
        r16.setMaxWidth(b0.c(Float.valueOf(this.i * 105.0f)));
        ToolsKt.b(r16);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.leftMargin = (int) UIUtils.dip2Px(r3.getContext(), this.i * 6.0f);
        r3.addView(r16, r0);
        ImageView r17 = new ImageView(r3.getContext());
        r17.setImageResource(2131248010);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams((int) V5(UIUtils.dip2Px(r3.getContext(), this.i * 12.0f)), (int) V5(UIUtils.dip2Px(r3.getContext(), this.i * 12.0f)));
        r18.leftMargin = (int) UIUtils.dip2Px(r3.getContext(), this.i * 2.0f);
        r3.addView(r17, r18);
        getFeedbackContainer().addView(r3, S5(false));
        r3.setOnClickListener(new e(this, r10));
    L20:
        if (r10.j == false) goto L22;
        getFeedbackFindSimilarBg().setVisibility(0);
        getFeedbackFindSimilarText().setVisibility(0);
        getFeedbackFindSimilarImage().setVisibility(0);
        return;
    L22:
        Y5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c6(FeedbackModel r9) {
        this.j = 2;
        LinearLayout r0 = getFeedbackContainer();
        r0.removeAllViews();
        Iterator<T> r1 = r9.g.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L16;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        FeedbackModel.a r6 = (FeedbackModel.a) r4;
        View r7 = T5(r6, false);
        FeedbackData.Item r8 = r6.a;
        if (r8 == null) goto L11;
        r7.setOnClickListener(new f(r8, r7, r9));
    L11:
        Unit r10 = Unit.INSTANCE;
        if (r3 != 0) goto L14;
        boolean r11 = true;
    L15:
        r0.addView(r7, S5(r11));
        View r12 = new View(getContext());
        r12.setBackgroundColor(ColorProtector.parseColor("#14FFFFFF"));
        r0.addView(r12, R5());
        r3 = r5;
        goto L4
    L14:
        r11 = false;
        goto L15
    L16:
        getFeedbackBackImage().setVisibility(0);
        getFeedbackBackText().setVisibility(0);
        g r2 = new g(this, r9);
        getFeedbackBackImage().setOnClickListener(r2);
        getFeedbackBackText().setOnClickListener(r2);
        Y5();
    }

    public final void i6(float r23) {
        ToolsKt.A(getFeedbackClose(), r23, null, Integer.valueOf(b0.c(28)), Integer.valueOf(b0.c(28)), null, null, null, null, false, null, 1010);
        int r11 = (int) (b0.c(8) * r23);
        getFeedbackClose().setPadding(r11, r11, r11, r11);
        ToolsKt.A(getFeedbackBackImage(), r23, null, Integer.valueOf(b0.c(20)), Integer.valueOf(b0.c(28)), null, null, null, null, false, null, 1010);
        getFeedbackBackImage().setPadding(r11, r11, 0, r11);
        ToolsKt.A(getFeedbackBackText(), r23, null, null, Integer.valueOf(b0.c(28)), Integer.valueOf(b0.c(4)), null, null, null, false, null, 998);
        getFeedbackBackText().setTextSize(1, 13 * r23);
        ToolsKt.A(getFeedbackContainer(), r23, null, null, null, Integer.valueOf(b0.c(8)), null, Integer.valueOf(b0.c(8)), null, false, null, 942);
    }

    public final void setViewScale(float r3) {
        this.i = r3;
        i6(r3);
        FeedbackModel r4 = this.k;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.j != 1) goto L7;
        b6(r4);
        return;
    L7:
        c6(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = LazyKt.lazy(new FeedbackView$feedbackClose$2(this));
        this.b = LazyKt.lazy(new FeedbackView$feedbackBackImage$2(this));
        this.c = LazyKt.lazy(new FeedbackView$feedbackBackText$2(this));
        this.d = LazyKt.lazy(new FeedbackView$feedbackContainer$2(this));
        this.e = LazyKt.lazy(new FeedbackView$feedbackFindSimilarBg$2(this));
        this.f = LazyKt.lazy(new FeedbackView$feedbackFindSimilarText$2(this));
        this.g = LazyKt.lazy(new FeedbackView$feedbackFindSimilarImage$2(this));
        this.i = 1.0f;
        this.j = 1;
        LayoutInflater.from(getContext()).inflate(2131564673, this, true);
        setBackgroundColor(ColorProtector.parseColor("#BF000000"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View T5(FeedbackModel.a r6, boolean r7) {
        LinearLayout r0 = new LinearLayout(getContext());
        ToolsKt.y(r0, r6.c + " 按钮");
        r0.setOrientation(0);
        if (r7 == false) goto L5;
        int r1 = 16;
    L6:
        r0.setGravity(r1);
        if (r7 == false) goto L12;
        View r8 = new SimpleDraweeView(r0.getContext());
        if (d0.b(r8, r6.b, "ec_na_mall", "ec_na_mall_feedback") == true) goto L11;
        r8.setImageURI(r6.b);
    L11:
        ToolsKt.b(r8);
        Unit r2 = Unit.INSTANCE;
        r0.addView(r8, (int) V5(UIUtils.dip2Px(r0.getContext(), this.i * 20.0f)), (int) V5(UIUtils.dip2Px(r0.getContext(), 20.0f * this.i)));
    L12:
        TextView r9 = new TextView(r0.getContext());
        r9.setText(r6.c);
        r9.setTextSize(1, V5(13.0f * this.i));
        r9.setTextColor(ColorProtector.parseColor("#E5FFFFFF"));
        r9.setEllipsize(TextUtils.TruncateAt.END);
        r9.setMaxLines(1);
        ToolsKt.b(r9);
        Unit r10 = Unit.INSTANCE;
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -2);
        r11.leftMargin = (int) UIUtils.dip2Px(r0.getContext(), 6.0f * this.i);
        r0.addView(r9, r11);
        return r0;
    L5:
        r1 = 17;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5(FeedbackModel r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "feedbackModel");
        this.k = r3;
        this.i = r4;
        setOnClickListener(a.a);
        b6(r3);
        getFeedbackClose().setOnClickListener(new b(r3));
        if (r3.j == true) goto L5;
        Y5();
    L6:
        i6(r4);
        return;
    L5:
        getFeedbackFindSimilarBg().setVisibility(0);
        getFeedbackFindSimilarText().setVisibility(0);
        getFeedbackFindSimilarImage().setVisibility(0);
        c r0 = new c(r3);
        getFeedbackFindSimilarBg().setOnClickListener(r0);
        getFeedbackFindSimilarText().setOnClickListener(r0);
        getFeedbackFindSimilarImage().setOnClickListener(r0);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = LazyKt.lazy(new FeedbackView$feedbackClose$2(this));
        this.b = LazyKt.lazy(new FeedbackView$feedbackBackImage$2(this));
        this.c = LazyKt.lazy(new FeedbackView$feedbackBackText$2(this));
        this.d = LazyKt.lazy(new FeedbackView$feedbackContainer$2(this));
        this.e = LazyKt.lazy(new FeedbackView$feedbackFindSimilarBg$2(this));
        this.f = LazyKt.lazy(new FeedbackView$feedbackFindSimilarText$2(this));
        this.g = LazyKt.lazy(new FeedbackView$feedbackFindSimilarImage$2(this));
        this.i = 1.0f;
        this.j = 1;
        LayoutInflater.from(getContext()).inflate(2131564673, this, true);
        setBackgroundColor(ColorProtector.parseColor("#BF000000"));
    }
}
