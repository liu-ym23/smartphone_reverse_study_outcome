package com.bytedance.ee.bear.bitable.card.view.stage.step;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageDataStepLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "<init>", "(Landroid/content/Context;IZ)V", "checkLayoutParams", "lp", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageDataStepLayoutManager extends LinearLayoutManager {
    public StageDataStepLayoutManager(Context r100) {
        super(r100, 0, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams r100) {
        int r101 = (getWidth() - (UIHelper.dp2px(16.0f) * 2)) / 3;
        if (r101 <= 0) goto L8;
        if (r100 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r100).width = r101;
        return true;
    L10:
        return true;
    L8:
        return false;
    }
}
