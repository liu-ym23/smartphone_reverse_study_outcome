package com.larus.list.arch;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016J%\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\rH&¢\u0006\u0002\u0010\u0013J'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J%\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/larus/list/arch/IFlowListCell;", "STATE", "Lcom/larus/list/arch/IFlowListCellState;", "Landroidx/lifecycle/LifecycleObserver;", WidgetCostModule.TYPE_ON_CREATE, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "onViewCreated", "view", "onBindView", "state", "position", "(Landroid/view/View;Lcom/larus/list/arch/IFlowListCellState;I)V", "appendPerfMonitorParams", "", "", "", "data", "(Lcom/larus/list/arch/IFlowListCellState;)Ljava/util/Map;", "onViewRecycled", "onViewDetachedFromWindow", "onViewAttachedToWindow", "onBindViewInternal", "shouldBindCell", "", "(Landroid/view/View;Lcom/larus/list/arch/IFlowListCellState;I)Z", "list_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowListCell<STATE extends f> extends LifecycleObserver {
    Map<String, Object> appendPerfMonitorParams(STATE r100);

    void onBindView(View r100, STATE r101, int r102);

    void onBindViewInternal(View r100, STATE r101, int r102);

    void onCreate(RecyclerView r100);

    View onCreateView(Context r100, int r101);

    void onViewAttachedToWindow();

    void onViewCreated(View r100);

    void onViewDetachedFromWindow();

    void onViewRecycled();

    boolean shouldBindCell(View r100, STATE r101, int r102);
}
