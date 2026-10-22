package com.larus.extension.aggregate_search_ui.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.list.arch.IFlowListCell;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "STATE", "Lcom/larus/list/arch/IFlowListCellState;", "Lcom/larus/list/arch/IFlowListCell;", "<init>", "()V", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "getParent", "()Landroidx/recyclerview/widget/RecyclerView;", "setParent", "(Landroidx/recyclerview/widget/RecyclerView;)V", WidgetCostModule.TYPE_ON_CREATE, "", "recyclerView", "layoutId", "", "getLayoutId", "()I", "onCreateView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSearchListCell<STATE extends f> implements IFlowListCell<STATE> {
    private RecyclerView parent;

    public BaseSearchListCell() {
    }

    public abstract int getLayoutId();

    @Override // com.larus.list.arch.IFlowListCell
    public abstract /* synthetic */ void onBindView(View r100, STATE r101, int r102);

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewAttachedToWindow() {
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewDetachedFromWindow() {
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewRecycled() {
    }

    public final RecyclerView getParent() {
        return this.parent;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public Map<String, Object> appendPerfMonitorParams(STATE r100) {
        return new LinkedHashMap();
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onCreate(RecyclerView r100) {
        this.parent = r100;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public final void setParent(RecyclerView r100) {
        this.parent = r100;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final View onCreateView(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return LayoutInflater.from(r100).inflate(getLayoutId(), this.parent, false);
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onBindViewInternal(View r100, STATE r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "state");
    }

    @Override // com.larus.list.arch.IFlowListCell
    public boolean shouldBindCell(View r100, STATE r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "state");
        return true;
    }
}
