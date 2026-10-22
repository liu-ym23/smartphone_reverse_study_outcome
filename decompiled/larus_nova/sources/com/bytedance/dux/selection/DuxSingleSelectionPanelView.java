package com.bytedance.dux.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dux/selection/DuxSingleSelectionPanelView;", "Lcom/bytedance/dux/selection/DuxSelectionPanelView;", "", "getSelectedItem", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxSingleSelectionPanelView extends DuxSelectionPanelView {

    public interface a {
    }

    public DuxSingleSelectionPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 30);
    }

    public DuxSingleSelectionPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public DuxSingleSelectionPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    @Override // com.bytedance.dux.selection.DuxSelectionPanelView
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.dux.selection.DuxSelectionPanelView
    public final void b() {
        if (getItemViews().size() <= 6) goto L5;
        Resources r100 = Resources.getSystem();
        setScrollViewHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 340, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()))));
        return;
    L5:
        setScrollViewHeight(-2);
    }

    public final int getSelectedItem() {
        Iterator<T> r100 = getItemViews().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L12;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DuxSelectionPanelItemView) r102).R5() == true) goto L10;
        r101 = r103;
        goto L4
    L10:
        return r101;
    L12:
        return -1;
    }

    public DuxSingleSelectionPanelView(Context r100, AttributeSet r101, int r102, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r101 = null;
    L5:
        AttributeSet r103 = r101;
        if ((r110 & 4) == 0) goto L8;
        int r104 = R.style.DuxSelectionPanel;
    L9:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r103, r104, null, false);
        return;
    L8:
        r104 = r102;
        goto L9
    }
}
