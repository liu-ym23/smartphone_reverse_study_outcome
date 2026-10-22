package com.bytedance.dux.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0006"}, d2 = {"Lcom/bytedance/dux/selection/DuxMultiSelectionPanelView;", "Lcom/bytedance/dux/selection/DuxSelectionPanelView;", "", "", "getSelectedItems", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxMultiSelectionPanelView extends DuxSelectionPanelView {

    public interface a {
    }

    public DuxMultiSelectionPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 30);
    }

    public DuxMultiSelectionPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 28);
    }

    public DuxMultiSelectionPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 24);
    }

    @Override // com.bytedance.dux.selection.DuxSelectionPanelView
    public final boolean c() {
        return true;
    }

    public final List<Integer> getSelectedItems() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = getItemViews().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DuxSelectionPanelItemView) r103).R5() == false) goto L11;
        r100.add(Integer.valueOf(r102));
    L11:
        r102 = r104;
        goto L4
    L12:
        return r100;
    }

    @Override // com.bytedance.dux.selection.DuxSelectionPanelView
    public final void b() {
        if (getItemViews().size() <= 6) goto L5;
        Resources r100 = Resources.getSystem();
        setScrollViewHeight(MathKt.roundToInt(TypedValue.applyDimension(1, 336, WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()))));
        return;
    L5:
        setScrollViewHeight(-2);
    }

    public DuxMultiSelectionPanelView(Context r100, AttributeSet r101, int r102, int r110) {
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
