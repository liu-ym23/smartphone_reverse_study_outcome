package com.ss.android.ugc.live.async_pre_layout_view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/live/async_pre_layout_view/widget/PreLayoutView;", "Landroid/view/View;", "", "getText", "", "enable", "", "setEnableInterceptForClickSpan", "Landroid/text/Layout;", "getLayout", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "async_pre_layout_view_release"}, k = 1, mv = {1, 4, 0})
public class PreLayoutView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f454374a;

    public PreLayoutView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PreLayoutView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final CharSequence getText() {
        return null;
    }

    public final Layout getLayout() {
        return null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        if (r100 == null) goto L5;
        r100.save();
        r100.restore();
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f454374a == false) goto L5;
        return false;
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setEnableInterceptForClickSpan(boolean r100) {
        this.f454374a = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    public PreLayoutView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f454374a = true;
    }

    public /* synthetic */ PreLayoutView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
