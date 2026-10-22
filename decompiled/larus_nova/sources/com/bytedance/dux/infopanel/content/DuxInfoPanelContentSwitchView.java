package com.bytedance.dux.infopanel.content;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.duxswitch.DuxSwitch;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/dux/infopanel/content/DuxInfoPanelContentSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Lcom/bytedance/dux/duxswitch/DuxSwitch;", "b", "Lcom/bytedance/dux/duxswitch/DuxSwitch;", "getDuxSwitch", "()Lcom/bytedance/dux/duxswitch/DuxSwitch;", "duxSwitch", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxInfoPanelContentSwitchView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f205241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxSwitch f205242b;

    public DuxInfoPanelContentSwitchView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxInfoPanelContentSwitchView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final DuxSwitch getDuxSwitch() {
        return this.f205242b;
    }

    public final TextView getTvTitle() {
        return this.f205241a;
    }

    public DuxInfoPanelContentSwitchView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_info_panel_content_switch_view, this);
        ViewGroup.MarginLayoutParams r103 = new ViewGroup.MarginLayoutParams(-1, -2);
        float r104 = 16;
        Resources r105 = Resources.getSystem();
        int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        Resources r107 = Resources.getSystem();
        r103.setMargins(0, r106, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))));
        setLayoutParams(r103);
        setBackgroundResource(R.drawable.dux_info_panel_content_switch_view_bg);
        Resources r108 = Resources.getSystem();
        int r109 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics())));
        setPadding(r109, r109, r109, r109);
        this.f205241a = (TextView) findViewById(R.id.tv_title);
        DuxSwitch r110 = (DuxSwitch) findViewById(R.id.dux_switch);
        this.f205242b = r110;
        Resources r111 = Resources.getSystem();
        n.a(r110, MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()))));
    }
}
