package com.bytedance.commerce.uikit.roundedlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import gg4.a;
import gg4.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/commerce/uikit/roundedlayout/RoundedLinearLayout;", "Landroid/widget/LinearLayout;", "", "dpValue", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uikit_release"}, k = 1, mv = {1, 4, 0})
public final class RoundedLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f202953a;

    public RoundedLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundedLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        this.f202953a.getClass();
        super.dispatchDraw(r100);
    }

    public final void setRadius(int r100) {
        this.f202953a.a(r100);
    }

    public RoundedLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f202953a = new a(this, r100, r101, r102);
    }

    public /* synthetic */ RoundedLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a r104 = this.f202953a;
        if (r104.f481114a <= 0) goto L6;
        r104.f481115b.setClipToOutline(true);
        r104.f481115b.setOutlineProvider(new b(r104.f481114a, r100, r101));
        return;
    }
}
