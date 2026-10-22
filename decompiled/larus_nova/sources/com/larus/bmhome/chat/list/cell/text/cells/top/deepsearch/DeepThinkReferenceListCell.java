package com.larus.bmhome.chat.list.cell.text.cells.top.deepsearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.w;
import com.ss.android.lark.utils.statistics.PerfLog;
import de8.c;
import ei9.f;
import hg8.r;
import hg8.u;
import hg8.v;
import hg8.x;
import hg8.y;
import hg8.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xc8.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0#H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001dH\u0016J\u001e\u0010-\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020'H\u0016J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020\u001dH\u0016J \u00101\u001a\u0002022\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001dH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u00064"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkReferenceListCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkReferenceCellState;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/IDeepThinkCutCell;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "referenceListComponent", "Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/ReferenceListComponent;", "getReferenceListComponent", "()Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/ReferenceListComponent;", "referenceListComponent$delegate", "Lkotlin/Lazy;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getColor", "()Ljava/lang/Integer;", "onViewAttachedToWindow", "", "onBindView", "view", "Landroid/view/View;", "state", "position", "getAllSlotCells", "onViewRecycled", "updateVisible", RemoteMessageConst.Notification.VISIBILITY, "shouldBindCell", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepThinkReferenceListCell extends BaseCompositeTextCell<r> implements z {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f306062n = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t f306063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f306064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f306065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f306066m;

    public static final class a {
    }

    static {
    }

    @Override // hg8.z
    public final void j() {
    }

    public DeepThinkReferenceListCell() {
        this.f306064k = LazyKt.lazy(new hg8.t());
        this.f306065l = LazyKt.lazy(new u(this));
        this.f306066m = LazyKt.lazy(new v(this));
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell, com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewRecycled() {
        super.onViewRecycled();
        t r100 = this.f306063j;
        View r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof View) == false) goto L9;
        r101 = (View) r102;
    L9:
        if (r101 == null) goto L12;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        r103.height = -2;
        r101.setLayoutParams(r103);
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell, com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final List<BaseMessageSlotCell<? extends f>> f(int r100) {
        return CollectionsKt.emptyList();
    }

    @Override // hg8.z
    public final void i(int r100) {
        ((w) this.f306064k.getValue()).i(r100);
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final List<BaseMessageSlotCell<? extends f>> g(int r100, List<BaseMessageSlotCell<? extends f>> r101) {
        Intrinsics.checkNotNullParameter(r101, "default");
        if (r100 == 1) goto L19;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
        boolean r104 = false;
    L6:
        if (r103.hasNext() == false) goto L13;
        Object r105 = r103.next();
        if (r104 == true) goto L9;
        if ((((BaseMessageSlotCell) r105) instanceof MessageInboxRightRetrySlotCell) == true) goto L6;
        r102.add(r105);
        r104 = true;
        goto L6
    L9:
        r102.add(r105);
        goto L6
    L13:
        CollectionsKt.removeAll(r101, new hg8.w());
        c r106 = (c) this.f306066m.getValue();
        if (r106 == null) goto L16;
        Integer r107 = r106.m();
    L17:
        if (r107 != null) goto L19;
        CollectionsKt.removeAll(r101, new x());
        CollectionsKt.removeAll(r101, new y());
        goto L19
    L16:
        r107 = null;
    L19:
        return r101;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell
    public final g t(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        o((w) this.f306064k.getValue());
        c r102 = (c) this.f306066m.getValue();
        if (r102 == null) goto L5;
        Integer r103 = r102.m();
    L6:
        t r104 = new t(r100);
        r104.setImmerseBgColor(r103);
        ChatParam r105 = (ChatParam) this.f306065l.getValue();
        if (r105 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        r104.setUseSubscribedColor(r106);
        r104.setBoxType(r101);
        this.f306063j = r104;
        r104.setUpCompositeBoxType(CompositeBoxType.CompositeMiddleBox);
        r104.f304622z = false;
        r104.f304621y = false;
        r104.setNeedKeepWidthToMaxWidth(true);
        return r104;
    L9:
        if (r105.f296894f != true) goto L11;
        r106 = true;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, f r101, int r102) {
        r r103 = (r) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.u(r100, r103, r102);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell, com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final boolean shouldBindCell(View r100, f r101, int r102) {
        r r103 = (r) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        return ((w) this.f306064k.getValue()).H(r103);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell
    public final void u(View r100, b r101, int r102) {
        r r103 = (r) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.u(r100, r103, r102);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell
    public final boolean w(View r100, b r101, int r102) {
        r r103 = (r) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        return ((w) this.f306064k.getValue()).H(r103);
    }
}
