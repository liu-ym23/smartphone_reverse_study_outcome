package com.bytedance.ee.bear.bitable.card.view.record;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import jq4.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class CellListUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f208639a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager, com.bytedance.ee.bear.bitable.card.view.record.CellListUtils$fixCellListViewCompatible$layoutManager$1] */
    public static i a(final Context r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "cellListView");
        r101.setItemAnimator(null);
        ?? r102 = new CellListUtils$fixCellListViewCompatible$layoutManager$1(r100);
        r101.setLayoutManager(r102);
        return new i(r102);
    }
}
