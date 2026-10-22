package com.bytedance.locallife.poi.dito.poi.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.dito.utils.o;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/ui/HeaderImageMaskView;", "Landroid/view/View;", "Landroid/graphics/drawable/Drawable;", "getCityImageMask", "", "height", "", "setHalfMaskHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class HeaderImageMaskView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f262539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f262540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f262541c;

    public HeaderImageMaskView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeaderImageMaskView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Drawable getCityImageMask() {
        return o.a(AnonymousClass1.INSTANCE);
    }

    public final void a() {
        this.f262539a = getCityImageMask();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = getMeasuredWidth();
        int r102 = getMeasuredHeight();
        if (r101 <= 0) goto L26;
        if (r102 <= 0) goto L31;
        if (r100 == null) goto L27;
        Drawable r103 = this.f262539a;     // Catch: Exception -> L23
        if (r103 == null) goto L10;
        r103.setBounds(0, 0, r101, r102);     // Catch: Exception -> L23
    L10:
        Drawable r104 = this.f262539a;     // Catch: Exception -> L23
        if (r104 == null) goto L13;
        r104.draw(r100);     // Catch: Exception -> L23
    L13:
        int r105 = this.f262541c;     // Catch: Exception -> L23
        if (r105 <= 0) goto L28;
        if (r102 <= r105) goto L29;
        Drawable r106 = this.f262540b;     // Catch: Exception -> L23
        if (r106 == null) goto L19;
        r106.setBounds(0, r102 - r105, r101, r102);     // Catch: Exception -> L23
    L19:
        Drawable r107 = this.f262540b;     // Catch: Exception -> L23
        if (r107 == null) goto L30;
        r107.draw(r100);     // Catch: Exception -> L23
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L32:
        return;
    L27:
        return;
    L31:
        return;
    }

    public final void setHalfMaskHeight(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (this.f262541c == r100) goto L8;
        this.f262541c = r100;
        return;
    }

    public HeaderImageMaskView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f262541c = (int) UIUtils.dip2Px(r100, 0.0f);
        this.f262539a = ContextCompat.getDrawable(r100, R.drawable.poi_bg_detail_header_mask_gradient_new);
        this.f262540b = ContextCompat.getDrawable(r100, R.drawable.poi_bg_detail_header_half_mask);
    }

    public /* synthetic */ HeaderImageMaskView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
