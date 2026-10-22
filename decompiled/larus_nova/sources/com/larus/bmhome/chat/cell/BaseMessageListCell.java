package com.larus.bmhome.chat.cell;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageForkRelationSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInBoxBottomRetrySlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxCheckboxSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.cell.slot.MessageOutBoxBottomSourceSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageOutboxCheckboxSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageOutboxRetrySlotCell;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u0004B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001dJ \u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020!H&J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J4\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060)2\u0006\u0010%\u001a\u00020!2\u0014\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u000eH\u0016J(\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0016J0\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020-H\u0016J\u001e\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060)2\u0006\u0010%\u001a\u00020!H\u0016J%\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00028\u00002\u0006\u00106\u001a\u00020!H\u0016¢\u0006\u0002\u00107R\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR@\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u000e2\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u000e@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "STATE", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/ui/arch/component/external/delegate/BaseCellComponentFeature;", "Lcom/larus/bmhome/chat/cell/ISlotCellProvider;", "Lcom/larus/list/arch/IFlowListCellState;", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "<init>", "()V", "value", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "allSlotCells", "getAllSlotCells", "()Ljava/util/List;", "setAllSlotCells", "(Ljava/util/List;)V", "stateData", "getStateData", "()Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "setStateData", "(Lcom/larus/bmhome/chat/cell/BaseMessageCellState;)V", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", WidgetCostModule.TYPE_ON_CREATE, "", "onCreateView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "onSlotViewCreated", "slotView", "onCreateBoxView", "boxType", "mainViewBox", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "getMessageSlotCells", "", "default", "onCellVisibilityChange", "isVisible", "", "isFullyVisible", "lastVisible", "showRatio", "", "ignoreHasFullVisible", "onBindViewInternal", "view", "state", "position", "(Landroid/view/View;Lcom/larus/bmhome/chat/cell/BaseMessageCellState;I)V", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseMessageListCell<STATE extends b> extends BaseCellComponentFeature<STATE> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f297616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<BaseMessageSlotCell<? extends f>> f297617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public STATE f297618d;

    public List<BaseMessageSlotCell<? extends f>> g(int r100, List<BaseMessageSlotCell<? extends f>> r101) {
        Intrinsics.checkNotNullParameter(r101, "default");
        return r101;
    }

    public i h() {
        return null;
    }

    public void k(boolean r100, boolean r101, boolean r102) {
    }

    public abstract View m(Context r100, int r101, int r102);

    public BaseMessageListCell() {
        this.f297617c = new ArrayList();
    }

    public List<BaseMessageSlotCell<? extends f>> f(int r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != (-1)) goto L5;
    L8:
        this.f297617c = r101;
        return g(r100, r101);
    L5:
        if (r100 == 1) goto L7;
        r101.add(new MessageInboxCheckboxSlotCell());
        r101.add(new MessageInBoxBottomRetrySlotCell());
        r101.add(new MessageInboxRightRetrySlotCell());
        r101.add(new MessageForkRelationSlotCell());
        goto L8
    L7:
        r101.add(new MessageOutboxCheckboxSlotCell());
        r101.add(new MessageOutboxRetrySlotCell());
        r101.add(new MessageOutBoxBottomSourceSlotCell());
        r101.add(new MessageForkRelationSlotCell());
        goto L8
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onCreate(RecyclerView r100) {
        this.f297616b = r100;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final View onCreateView(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return m(r100, r101, (r101 % 10) - 1);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onBindViewInternal(View r100, f r101, int r102) {
        STATE r103 = (STATE) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f297618d = r103;
        Integer r104 = null;
        if ((r100 instanceof i) == false) goto L5;
        i r105 = (i) r100;
    L6:
        if (r105 != null) goto L8;
        r105 = h();
    L8:
        if (r105 == null) goto L13;
        int r106 = r105.getResources().getConfiguration().uiMode & 48;
        if (r106 == r105.f304406m) goto L13;
        r105.f304406m = r106;
        r105.f304397d = true;
        r105.setBoxType(r105.getBoxType());
    L13:
        Message r107 = r103.getMessage();
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("in base holder createTime >>> ");
        r109.append(r107.getCreateTime());
        r109.append(", messageId >>> ");
        r109.append(r107.getMessageId());
        r109.append(", conversationId >>> ");
        r109.append(r107.getConversationId());
        r109.append(",msgLength: ");
        String r110 = r107.getContent();
        if (r110 == null) goto L16;
        r104 = Integer.valueOf(r110.length());
    L16:
        r109.append(r104);
        r108.i("BaseBindSourceTest", r109.toString());
        return;
    L5:
        r105 = null;
        goto L6
    }

    public void l(boolean r100, boolean r101, boolean r102, float r103, boolean r104) {
        k(r100, r101, r102);
    }
}
