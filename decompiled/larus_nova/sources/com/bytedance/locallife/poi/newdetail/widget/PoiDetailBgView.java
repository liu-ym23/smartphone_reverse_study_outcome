package com.bytedance.locallife.poi.newdetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/PoiDetailBgView;", "Landroid/view/View;", "", "top", "", "setBgTop", "", "switch", "setHeadOptSwitch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailBgView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f263304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f263305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f263306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f263307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f263308e;

    public PoiDetailBgView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiDetailBgView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f263304a != (-1)) goto L5;
        return;
    L5:
        int r101 = getTop();
        int r102 = getBottom();
        if (r101 < 0) goto L17;
        if (r102 <= r101) goto L18;
        int r103 = this.f263304a;
        if (r103 < r101) goto L19;
        if (r103 >= r102) goto L20;
        r100.drawRect(getLeft(), this.f263304a, getRight(), r102, this.f263305b);
        if (this.f263306c == true) goto L14;
        return;
    L14:
        if (this.f263308e <= 0) goto L22;
        r100.drawRect(getLeft(), this.f263304a, getRight(), this.f263304a + this.f263308e, this.f263307d);
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void setBgTop(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (this.f263304a == r100) goto L8;
        this.f263304a = r100;
        invalidate();
        return;
    }

    public final void setHeadOptSwitch(boolean r100) {
        if (this.f263306c == r100) goto L6;
        this.f263306c = r100;
        invalidate();
        return;
    }

    public PoiDetailBgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263304a = -1;
        int r103 = ColorProtector.parseColor("#F3F3F4");
        Paint r104 = new Paint();
        this.f263305b = r104;
        int r105 = ContextCompat.getColor(r100, R.color.POIBgPrimary);
        Paint r106 = new Paint();
        this.f263307d = r106;
        this.f263308e = (int) UIUtils.dip2Px(r100, 12.0f);
        r104.setColor(r103);
        r106.setColor(r105);
    }

    public /* synthetic */ PoiDetailBgView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
