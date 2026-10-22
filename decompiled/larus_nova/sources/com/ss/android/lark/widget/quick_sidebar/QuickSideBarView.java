package com.ss.android.lark.widget.quick_sidebar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.mention.base.impl.atselector.view.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u00029:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0014J\u0018\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020&2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u0012J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u00105\u001a\u00020&2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u00107\u001a\u00020&2\b\u00108\u001a\u0004\u0018\u00010#R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/widget/quick_sidebar/QuickSideBarView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/ss/android/lark/widget/quick_sidebar/listener/OnQuickSideBarTouchListener;", "getListener", "()Lcom/ss/android/lark/widget/quick_sidebar/listener/OnQuickSideBarTouchListener;", "setListener", "(Lcom/ss/android/lark/widget/quick_sidebar/listener/OnQuickSideBarTouchListener;)V", "mLetters", "", "", "mLetterDrawables", "", "Landroid/graphics/drawable/Drawable;", "mChoose", "mPaint", "Landroid/graphics/Paint;", "mTextSize", "", "mTextSizeChoose", "mTextColor", "mTextColorChoose", "mWidth", "mHeight", "mItemHeight", "mItemStartY", "mLetterMapper", "Lcom/ss/android/lark/widget/quick_sidebar/QuickSideBarView$LetterMapper;", "mSelectedLetter", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setOnQuickSideBarTouchListener", "setSelectedLetter", "letter", "getLetters", "setLetters", "letters", "setLetterMapper", "mapper", "LetterMapper", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickSideBarView extends View {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f448086o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f448087p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ydc.a f448088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f448089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Drawable> f448090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f448091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f448092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f448093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f448094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f448095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f448096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f448097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f448098k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f448099l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f448100m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f448101n;

    public static final class a {
    }

    public interface b {
    }

    public QuickSideBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public QuickSideBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setLetterMapper(b r100) {
    }

    static {
        f448086o = new int[]{R.attr.state_checked};
        f448087p = new int[0];
    }

    public final List<String> getLetters() {
        return this.f448089b;
    }

    public final ydc.a getListener() {
        return this.f448088a;
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = r110.getAction();
        float r101 = r110.getY();
        int r102 = this.f448091d;
        int r103 = (int) ((r101 - this.f448100m) / this.f448099l);
        if (r100 != 1) goto L8;
        this.f448091d = -1;
        ydc.a r111 = this.f448088a;
        if (r111 == null) goto L7;
        ((j) r111).b(false);
    L7:
        invalidate();
    L28:
        return true;
    L8:
        if (r102 == r103) goto L19;
        if (r103 >= 0) goto L11;
    L17:
        invalidate();
        goto L19
    L11:
        if (r103 >= this.f448089b.size()) goto L17;
        this.f448091d = r103;
        if (this.f448088a == null) goto L17;
        Rect r104 = new Rect();
        this.f448092e.getTextBounds((String) ListProtector.get(this.f448089b, this.f448091d), 0, ((String) ListProtector.get(this.f448089b, this.f448091d)).length(), r104);
        float r105 = this.f448099l;
        float r106 = ((this.f448091d * r105) + ((int) (((double) (r105 - r104.height())) * 0.5d))) + this.f448100m;
        ydc.a r107 = this.f448088a;
        if (r107 == null) goto L17;
        ((j) r107).a((String) ListProtector.get(this.f448089b, r103), r106);
    L19:
        if (r110.getAction() != 3) goto L24;
        ydc.a r112 = this.f448088a;
        if (r112 == null) goto L28;
        ((j) r112).b(false);
        goto L28
    L24:
        if (r110.getAction() != 0) goto L28;
        ydc.a r113 = this.f448088a;
        if (r113 == null) goto L28;
        ((j) r113).b(true);
        goto L28
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = this.f448089b.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L25;
        this.f448092e.setColor(this.f448095h);
        this.f448092e.setAntiAlias(true);
        this.f448092e.setTextSize(this.f448093f);
        this.f448092e.setTypeface(Typeface.DEFAULT);
        if (r101 >= this.f448090c.size()) goto L7;
        Drawable r102 = (Drawable) ListProtector.get(this.f448090c, r101);
    L8:
        if (r102 == null) goto L10;
        r102.setState(f448087p);
    L10:
        boolean r103 = TextUtils.equals((CharSequence) ListProtector.get(this.f448089b, r101), this.f448101n);
        int[] r104 = f448086o;
        if (r103 == false) goto L16;
        this.f448092e.setColor(this.f448096i);
        if (r102 == null) goto L16;
        r102.setState(r104);
    L16:
        if (r101 != this.f448091d) goto L21;
        this.f448092e.setColor(this.f448096i);
        this.f448092e.setFakeBoldText(true);
        this.f448092e.setTypeface(Typeface.DEFAULT_BOLD);
        this.f448092e.setTextSize(this.f448094g);
        if (r102 == null) goto L21;
        r102.setState(r104);
    L21:
        if (r102 == null) goto L23;
        r102.getBounds().offsetTo((int) ((int) (((double) (this.f448097j - r102.getBounds().width())) * 0.5d)), (int) ((this.f448099l * r101) + this.f448100m));
        r102.draw(r110);
    L24:
        this.f448092e.reset();
        r101 = r101 + 1;
        goto L3
    L23:
        Rect r105 = new Rect();
        this.f448092e.getTextBounds((String) ListProtector.get(this.f448089b, r101), 0, ((String) ListProtector.get(this.f448089b, r101)).length(), r105);
        Paint.FontMetrics r106 = this.f448092e.getFontMetrics();
        float r107 = (int) (((double) (this.f448097j - r105.width())) * 0.5d);
        float r108 = this.f448099l;
        r110.drawText((String) ListProtector.get(this.f448089b, r101), r107, (((r101 * r108) + ((int) (((double) (r108 - r105.height())) * 0.5d))) + this.f448100m) + (r105.height() - r106.descent), this.f448092e);
        goto L24
    L7:
        r102 = null;
        goto L8
    }

    public final void setLetters(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "letters");
        this.f448089b = r100;
        this.f448100m = (this.f448098k - (r100.size() * this.f448099l)) / 2;
        this.f448090c = new ArrayList();
        invalidate();
    }

    public final void setListener(ydc.a r100) {
        this.f448088a = r100;
    }

    public final void setOnQuickSideBarTouchListener(ydc.a r100) {
        this.f448088a = r100;
    }

    public final void setSelectedLetter(String r100) {
        this.f448101n = r100;
        invalidate();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f448098k = getMeasuredHeight();
        this.f448097j = getMeasuredWidth();
        this.f448100m = (this.f448098k - (this.f448089b.size() * this.f448099l)) / 2;
    }

    public QuickSideBarView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f448089b = new ArrayList();
        this.f448090c = new ArrayList();
        this.f448091d = -1;
        this.f448092e = new Paint();
        ArrayList r103 = new ArrayList();
        CollectionsKt.addAll(r103, r100.getResources().getStringArray(com.larus.nova.R.array.quickSideBarLetters));
        this.f448089b = r103;
        this.f448095h = UIUtils.getColor(r100, R.color.black);
        this.f448096i = UIUtils.getColor(r100, R.color.black);
        this.f448093f = r100.getResources().getDimensionPixelSize(com.larus.nova.R.dimen.textSize_quicksidebar);
        this.f448094g = r100.getResources().getDimensionPixelSize(com.larus.nova.R.dimen.textSize_quicksidebar_choose);
        this.f448099l = r100.getResources().getDimension(com.larus.nova.R.dimen.height_quicksidebaritem);
        if (r101 == null) goto L6;
        TypedArray r104 = getContext().obtainStyledAttributes(r101, new int[]{com.larus.nova.R.attr.sidebarBackgroundColor, com.larus.nova.R.attr.sidebarItemHeight, com.larus.nova.R.attr.sidebarTextColor, com.larus.nova.R.attr.sidebarTextColorChoose, com.larus.nova.R.attr.sidebarTextSize, com.larus.nova.R.attr.sidebarTextSizeChoose});
        this.f448095h = r104.getColor(2, this.f448095h);
        this.f448096i = r104.getColor(3, this.f448096i);
        this.f448093f = r104.getDimension(4, this.f448093f);
        this.f448094g = r104.getDimension(5, this.f448094g);
        this.f448099l = r104.getDimension(1, this.f448099l);
        r104.recycle();
        return;
    }

    public /* synthetic */ QuickSideBarView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
