package com.bytedance.ies.xelement.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxEditTextView;", "Lcom/bytedance/ies/xelement/input/LynxEditText;", "Lcom/bytedance/ies/xelement/input/LynxEditTextView$a;", "onSelectionChangeListener", "Lcom/bytedance/ies/xelement/input/LynxEditTextView$a;", "getOnSelectionChangeListener", "()Lcom/bytedance/ies/xelement/input/LynxEditTextView$a;", "setOnSelectionChangeListener", "(Lcom/bytedance/ies/xelement/input/LynxEditTextView$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-input_release"}, k = 1, mv = {1, 6, 0})
public final class LynxEditTextView extends LynxEditText {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f250059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f250060i;

    public interface a {
    }

    public final a getOnSelectionChangeListener() {
        return null;
    }

    @Override // com.bytedance.ies.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.bytedance.ies.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.bytedance.ies.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.bytedance.ies.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.bytedance.ies.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    public final void setOnSelectionChangeListener(a r100) {
    }

    @Override // com.bytedance.ies.xelement.input.LynxEditText, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
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
        this.f250059h = r100.getY();
        this.f250060i = getScrollY();
    L30:
        return super.onTouchEvent(r100);
    L11:
        if (r101 != 1) goto L13;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f250059h = 0.0f;
        Math.abs(getScrollY() - this.f250060i);
        goto L30
    L13:
        if (r101 == 2) goto L19;
        if (r101 != 3) goto L30;
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f250059h = 0.0f;
        Math.abs(getScrollY() - this.f250060i);
        goto L30
    L19:
        if (canScrollVertically(1) == true) goto L23;
        if (r100.getY() >= this.f250059h) goto L23;
    L26:
        getParent().requestDisallowInterceptTouchEvent(false);
    L23:
        if (canScrollVertically(-1) == true) goto L30;
        if (r100.getY() <= this.f250059h) goto L30;
    L7:
        return super.onTouchEvent(null);
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
    }

    public LynxEditTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        new LinkedHashMap();
        super(r100, r101, r102);
    }
}
