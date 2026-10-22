package com.bytedance.ee.bear.bitable.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/ClearFocusWrapper;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getFocusView", "Lkotlin/Function0;", "Landroid/view/View;", "getGetFocusView", "()Lkotlin/jvm/functions/Function0;", "setGetFocusView", "(Lkotlin/jvm/functions/Function0;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ClearFocusWrapper extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends View> f209800a;

    public ClearFocusWrapper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ClearFocusWrapper(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<View> getGetFocusView() {
        return this.f209800a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        Function0<? extends View> r100 = this.f209800a;
        if (r100 == null) goto L5;
        View r101 = r100.invoke();
    L6:
        Intrinsics.checkNotNullParameter(r110, "event");
        if (r110.getAction() != 0) goto L26;
        Intrinsics.checkNotNullParameter(r110, "event");
        boolean r102 = false;
        if (r101 != null) goto L11;
    L21:
        if (r102 == false) goto L26;
        if (r101 == null) goto L24;
        r101.clearFocus();
    L24:
        rcb.c.d(r101);
        goto L26
    L11:
        if ((r101 instanceof EditText) == false) goto L21;
        int[] r103 = {0, 0};
        EditText r104 = (EditText) r101;
        r104.getLocationInWindow(r103);
        int r105 = r103[0];
        int r106 = r103[1];
        int r107 = r104.getHeight() + r106;
        int r108 = r104.getWidth() + r105;
        float r109 = r110.getX();
        float r111 = r110.getY();
        if (r109 > r105) goto L15;
    L20:
        r102 = true;
        goto L21
    L15:
        if (r109 >= r108) goto L20;
        if (r111 <= r106) goto L20;
        if (r111 < r107) goto L21;
    L26:
        return super.dispatchTouchEvent(r110);
    L5:
        r101 = null;
        goto L6
    }

    public final void setGetFocusView(Function0<? extends View> r100) {
        this.f209800a = r100;
    }

    public ClearFocusWrapper(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ClearFocusWrapper(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
