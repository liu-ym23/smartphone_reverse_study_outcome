package com.lynx.xelement.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/lynx/xelement/input/LynxEditTextView;", "Lcom/lynx/xelement/input/LynxEditText;", "Lcom/lynx/xelement/input/LynxEditTextView$a;", "h", "Lcom/lynx/xelement/input/LynxEditTextView$a;", "getOnSelectionChangeListener", "()Lcom/lynx/xelement/input/LynxEditTextView$a;", "setOnSelectionChangeListener", "(Lcom/lynx/xelement/input/LynxEditTextView$a;)V", "onSelectionChangeListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Input_release"}, k = 1, mv = {1, 6, 0})
public final class LynxEditTextView extends LynxEditText {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f384132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f384133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f384134j;

    public interface a {
        void a(int r100, int r101);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final a getOnSelectionChangeListener() {
        return this.f384132h;
    }

    public LynxEditTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (isFocusable() == true) goto L5;
        return false;
    L5:
        if (r100 == null) goto L7;
        int r101 = r100.getAction();
        if (r101 != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
        r100.getX();
        this.f384133i = r100.getY();
        this.f384134j = getScrollY();
    L30:
        return super.onTouchEvent(r100);
    L11:
        if (r101 != 1) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f384133i = 0.0f;
        Math.abs(getScrollY() - this.f384134j);
        goto L30
    L13:
        if (r101 == 2) goto L19;
        if (r101 != 3) goto L30;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f384133i = 0.0f;
        Math.abs(getScrollY() - this.f384134j);
        goto L30
    L19:
        if (canScrollVertically(1) == true) goto L23;
        if (r100.getY() >= this.f384133i) goto L23;
    L26:
        getParent().requestDisallowInterceptTouchEvent(false);
    L23:
        if (canScrollVertically(-1) == true) goto L30;
        if (r100.getY() <= this.f384133i) goto L30;
    L7:
        return super.onTouchEvent(null);
    }

    public final void setOnSelectionChangeListener(a r100) {
        this.f384132h = r100;
    }

    public LynxEditTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        a r102 = this.f384132h;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public LynxEditTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101, r102);
    }
}
