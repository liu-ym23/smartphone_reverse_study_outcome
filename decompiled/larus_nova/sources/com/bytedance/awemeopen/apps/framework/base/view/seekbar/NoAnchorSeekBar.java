package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001;B\u0013\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105B\u001d\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b4\u00108B%\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00109\u001a\u00020\u000b¢\u0006\u0004\b4\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R6\u0010,\u001a\u0016\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00101\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u00100¨\u0006<"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/NoAnchorSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "", "getScale", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/NoAnchorSeekBar$a;", "l", "", "setOnSeekBarChangeListener", "Landroid/graphics/drawable/Drawable;", "thumb", "setThumb", "", "d", "I", "getScaledTouchSlop", "()I", "setScaledTouchSlop", "(I)V", "scaledTouchSlop", "e", "getTriggerCancellationMinHeight", "setTriggerCancellationMinHeight", "triggerCancellationMinHeight", "", "f", "Z", "getEndOutOfArea", "()Z", "endOutOfArea", "Ljava/util/TreeSet;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/a;", ce.f26391f, "Ljava/util/TreeSet;", "getDrawers", "()Ljava/util/TreeSet;", "drawers", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "h", "Lkotlin/jvm/functions/Function2;", "getMapper", "()Lkotlin/jvm/functions/Function2;", "setMapper", "(Lkotlin/jvm/functions/Function2;)V", "mapper", RXScreenCaptureService.KEY_INDEX, "getAnchor", "setAnchor", "(Z)V", "anchor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class NoAnchorSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f193607l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f193608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f193609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f193610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f193612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f193613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TreeSet<com.bytedance.awemeopen.apps.framework.base.view.seekbar.a> f193614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function2<? super MotionEvent, ? super Float, Integer> f193615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f193616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f193617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f193618k;

    public static abstract class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        public abstract void a(SeekBar r100, boolean r101);

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            a(r100, false);
        }
    }

    private final boolean getEndOutOfArea() {
        boolean r100 = this.f193613f;
        this.f193613f = false;
        return r100;
    }

    private final float getScale() {
        int r100 = getMax();
        if (r100 > 0) goto L7;
        return 0.0f;
    L7:
        return getProgress() / r100;
    }

    public final boolean getAnchor() {
        return this.f193616i;
    }

    public final TreeSet<com.bytedance.awemeopen.apps.framework.base.view.seekbar.a> getDrawers() {
        return this.f193614g;
    }

    public final Function2<MotionEvent, Float, Integer> getMapper() {
        return this.f193615h;
    }

    public final int getScaledTouchSlop() {
        return this.f193611d;
    }

    public final int getTriggerCancellationMinHeight() {
        return this.f193612e;
    }

    public NoAnchorSeekBar(Context r100) {
        new LinkedHashMap();
        Intrinsics.checkNotNull(r100);
        super(r100);
        this.f193612e = -1;
        final NoAnchorSeekBar$drawers$1 r101 = NoAnchorSeekBar$drawers$1.INSTANCE;
        this.f193614g = new TreeSet(new e(r101));
        this.f193611d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Float.isNaN(r100.getX()) == false) goto L5;
        return;
    L5:
        if (Float.isNaN(r100.getY()) == true) goto L25;
        float r101 = MathKt.roundToInt(r100.getX());
        float r102 = MathKt.roundToInt(r100.getY());
        Drawable r103 = getBackground();
        if (r103 == null) goto L10;
        r103.setHotspot(r101, r102);
    L10:
        Intrinsics.checkNotNullParameter(r100, "event");
        Function2<? super MotionEvent, ? super Float, Integer> r104 = this.f193615h;
        if (r104 == null) goto L21;
        Integer r105 = Integer.valueOf(r104.invoke(r100, Float.valueOf(this.f193610c)).intValue());
        if (r105.intValue() < 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L19;
        r105 = null;
    L19:
        if (r105 == null) goto L21;
        int r107 = r105.intValue();
    L22:
        setProgress(r107);
        return;
    L15:
        r106 = false;
    L21:
        r107 = MathKt.roundToInt(((this.f193610c / ((getWidth() - getPaddingLeft()) - getPaddingRight())) * getMax()) + getProgress());
        goto L22
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f193614g.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        com.bytedance.awemeopen.apps.framework.base.view.seekbar.a r102 = (com.bytedance.awemeopen.apps.framework.base.view.seekbar.a) r101.next();
        if (r102.a() == false) goto L7;
        r100.save();
        r102.b(r100);
        r100.restore();
        goto L7
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.f193612e <= 0) goto L22;
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L16;
        if (r100 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L22;
    L12:
        if (r100.getActionMasked() != 3) goto L14;
        r102 = true;
    L16:
        int[] r103 = new int[2];
        getLocationOnScreen(r103);
        if (this.f193617j == false) goto L22;
        if ((r103[1] - r100.getRawY()) <= this.f193612e) goto L22;
        this.f193613f = true;
        goto L22
    L6:
        if (r100.getActionMasked() != 1) goto L8;
        r101 = true;
    L22:
        if (this.f193616i == false) goto L26;
        return super.onTouchEvent(r100);
    L26:
        if (isEnabled() == false) goto L66;
        if (r100 == null) goto L66;
        this.f193610c = r100.getX() - this.f193609b;
        int r104 = r100.getAction();
        if (r104 == 0) goto L63;
        if (r104 == 1) goto L57;
        if (r104 == 2) goto L43;
        if (r104 == 3) goto L36;
    L64:
        this.f193609b = r100.getX();
        return true;
    L36:
        if (this.f193617j == false) goto L41;
        this.f193617j = false;
        a r105 = this.f193608a;
        if (r105 == null) goto L40;
        r105.a(this, getEndOutOfArea());
    L40:
        setPressed(false);
    L41:
        invalidate();
        goto L64
    L43:
        if (this.f193617j == false) goto L46;
        a(r100);
        goto L64
    L46:
        if (Math.abs(r100.getX() - this.f193618k) <= this.f193611d) goto L64;
        setPressed(true);
        if (getThumb() == null) goto L50;
        invalidate(getThumb().getBounds());
    L50:
        this.f193617j = true;
        a r106 = this.f193608a;
        if (r106 == null) goto L53;
        r106.onStartTrackingTouch(this);
    L53:
        a(r100);
        if (getParent() == null) goto L64;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L64
    L57:
        if (this.f193617j == false) goto L62;
        a(r100);
        this.f193617j = false;
        a r107 = this.f193608a;
        if (r107 == null) goto L61;
        r107.a(this, getEndOutOfArea());
    L61:
        setPressed(false);
    L62:
        invalidate();
        goto L64
    L63:
        this.f193618k = r100.getX();
    L66:
        return false;
    }

    public final void setAnchor(boolean r100) {
        this.f193616i = r100;
    }

    public final void setMapper(Function2<? super MotionEvent, ? super Float, Integer> r100) {
        this.f193615h = r100;
    }

    public final void setOnSeekBarChangeListener(a r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        super.setOnSeekBarChangeListener(r100);
        this.f193608a = r100;
    }

    public final void setScaledTouchSlop(int r100) {
        this.f193611d = r100;
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable r100) {
        super.setThumb(r100);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        b(getWidth(), getHeight());
        return;
    }

    public final void setTriggerCancellationMinHeight(int r100) {
        this.f193612e = r100;
    }

    public NoAnchorSeekBar(Context r100, AttributeSet r101) {
        new LinkedHashMap();
        Intrinsics.checkNotNull(r100);
        super(r100, r101);
        this.f193612e = -1;
        final NoAnchorSeekBar$drawers$1 r102 = NoAnchorSeekBar$drawers$1.INSTANCE;
        this.f193614g = new TreeSet(new e(r102));
        this.f193611d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void b(int r100, int r101) {
        int r102 = (r101 - getPaddingTop()) - getPaddingBottom();
        Drawable r103 = getProgressDrawable();
        Drawable r104 = getThumb();
        if (r104 == null) goto L5;
        int r105 = r104.getIntrinsicHeight();
    L6:
        if (r105 <= r102) goto L8;
        int r106 = (r102 - r105) / 2;
        int r107 = ((r105 - r102) / 2) + r106;
    L9:
        if (r103 == null) goto L11;
        r103.setBounds(0, r107, (r100 - getPaddingRight()) - getPaddingLeft(), r102 + r107);
    L11:
        if (r104 == null) goto L18;
        getScale();
        int r108 = r104.getIntrinsicHeight();
        if (r106 != Integer.MIN_VALUE) goto L15;
        Rect r109 = r104.getBounds();
        r106 = r109.top;
        int r110 = r109.bottom;
    L16:
        r104.setBounds(r104.getBounds().left, r106, r104.getBounds().right, r110);
        return;
    L15:
        r110 = r108 + r106;
        goto L16
    L18:
        return;
    L8:
        int r111 = (r102 - r102) / 2;
        r106 = ((r102 - r105) / 2) + r111;
        r107 = r111;
        goto L9
    L5:
        r105 = 0;
        goto L6
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r100, Bundle r101) {
        if (r100 == 8192) goto L9;
        if (r100 == 4096) goto L9;
        return super.performAccessibilityAction(r100, r101);
    L9:
        if (isEnabled() == true) goto L12;
        return false;
    L12:
        int r102 = Math.max(1, MathKt.roundToInt(getMax() / 20.0f));
        if (r100 != 8192) goto L16;
        r102 = -r102;
    L16:
        if (this.f193608a == null) goto L18;
        setProgress(getProgress() + r102);
    L18:
        return true;
    }

    public NoAnchorSeekBar(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        Intrinsics.checkNotNull(r100);
        super(r100, r101, r102);
        this.f193612e = -1;
        final NoAnchorSeekBar$drawers$1 r103 = NoAnchorSeekBar$drawers$1.INSTANCE;
        this.f193614g = new TreeSet(new e(r103));
        this.f193611d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        b(r100, r101);
        return;
    }
}
