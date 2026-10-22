package com.larus.bmhome.chat.list.cell.loadmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wf8.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/loadmore/LoadMoreCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/loadmore/LoadMoreCellState;", "<init>", "()V", "onBindView", "", "view", "Landroid/view/View;", "state", "position", "", "onCreateBoxView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "boxType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadMoreCell extends BaseMessageListCell<a> {
    public LoadMoreCell() {
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return LayoutInflater.from(r100).inflate(R.layout.larus_item_message_list_load_more, null);
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, f r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter((a) r101, "state");
    }
}
