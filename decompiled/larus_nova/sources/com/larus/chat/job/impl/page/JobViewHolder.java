package com.larus.chat.job.impl.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.chat.job.impl.component.ChatJobLynxItemComponent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005Jj\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00112\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00112\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u0015J\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/chat/job/impl/page/JobViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", KtvSubElement.CONTAINER, "Lcom/larus/chat/job/impl/ui/ChatJobLongPressLayout;", "lynxComponent", "Lcom/larus/chat/job/impl/component/ChatJobLynxItemComponent;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/chat/job/impl/page/ChatJobListItem$Job;", "itemIndex", "", "onTaskClick", "Lkotlin/Function2;", "Lcom/larus/im/bean/job/AIJob;", "onTaskTapObserved", "onTaskLongClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "unbind", MapMonitorConst.EVENT_DESTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JobViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f325138c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fz8.k f325139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ChatJobLynxItemComponent f325140b;

    public final void unbind() {
        this.f325139a.setOnDetectedTap(null);
        this.f325139a.setOnClickListener(null);
        this.f325139a.setOnDetectedLongPress(null);
    }

    public JobViewHolder(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(new fz8.k(r100));
        View r101 = this.itemView;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.chat.job.impl.ui.ChatJobLongPressLayout");
        fz8.k r102 = (fz8.k) r101;
        this.f325139a = r102;
        RecyclerView.LayoutParams r103 = new RecyclerView.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) r103).leftMargin = i5.q();
        ((ViewGroup.MarginLayoutParams) r103).rightMargin = i5.q();
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = i5.h();
        r102.setLayoutParams(r103);
    }
}
