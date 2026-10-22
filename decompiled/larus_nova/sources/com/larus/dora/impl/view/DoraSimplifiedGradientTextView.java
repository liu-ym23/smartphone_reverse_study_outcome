package com.larus.dora.impl.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/view/DoraSimplifiedGradientTextView;", "Lcom/larus/dora/impl/view/DoraTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "updateGradient", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSimplifiedGradientTextView extends DoraTextView {
    public DoraSimplifiedGradientTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraSimplifiedGradientTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public DoraSimplifiedGradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ DoraSimplifiedGradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        super.onLayout(r100, r110, r111, r112, r113);
        if (r100 == true) goto L5;
        return;
    L5:
        if (getWidth() <= 0) goto L24;
        int[] r101 = {-13146369, -5740801, -35979, -19867};
        CharSequence r102 = getText();
        Float r114 = null;
        if (r102 == null) goto L9;
        String r103 = r102.toString();
    L10:
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        Float r104 = Float.valueOf(getPaint().measureText(r103));
        if (r104.floatValue() <= 0.0f) goto L15;
        boolean r115 = true;
    L16:
        if (r115 == false) goto L18;
        r114 = r104;
    L18:
        if (r114 == null) goto L20;
        float r105 = r114.floatValue();
    L21:
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r105, 0.0f, r101, null, Shader.TileMode.CLAMP));
        invalidate();
        return;
    L20:
        r105 = getWidth();
        goto L21
    L15:
        r115 = false;
        goto L16
    L9:
        r103 = null;
        goto L10
    }
}
