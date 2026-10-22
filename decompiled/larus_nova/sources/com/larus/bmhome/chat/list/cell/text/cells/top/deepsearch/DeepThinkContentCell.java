package com.larus.bmhome.chat.list.cell.text.cells.top.deepsearch;

import android.content.Context;
import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.slot.BaseMessageSlotCell;
import com.larus.bmhome.chat.cell.slot.MessageInboxRightRetrySlotCell;
import com.larus.bmhome.chat.layout.item.CompositeBoxType;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import hg8.b;
import hg8.c;
import hg8.d;
import hg8.e;
import hg8.g;
import hg8.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0#H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010%J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001dH\u0016J\u001e\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020!0 0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u001dH\u0016J \u0010/\u001a\u0002002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001dH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkContentCell;", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/DeepThinkContentCellState;", "Lcom/larus/bmhome/chat/list/cell/text/cells/top/deepsearch/IDeepThinkCutCell;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/CompositedTextBox;", "deepSearchContentComponent", "Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/DeepSearchContentComponent;", "getDeepSearchContentComponent", "()Lcom/larus/bmhome/chat/list/cell/text/components/top/searchheader/components/DeepSearchContentComponent;", "deepSearchContentComponent$delegate", "Lkotlin/Lazy;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "boxType", "", "getMessageSlotCells", "", "Lcom/larus/bmhome/chat/cell/slot/BaseMessageSlotCell;", "Lcom/larus/list/arch/IFlowListCellState;", "default", "", "getColor", "()Ljava/lang/Integer;", "onBindView", "", "view", "Landroid/view/View;", "state", "position", "getAllSlotCells", "updateVisible", RemoteMessageConst.Notification.VISIBILITY, "shouldBindCell", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeepThinkContentCell extends BaseCompositeTextCell<g> implements z {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f306053m = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f306054j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f306055k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f306056l;

    public static final class a {
    }

    static {
    }

    @Override // hg8.z
    public final void j() {
    }

    public DeepThinkContentCell() {
        this.f306054j = LazyKt.lazy(new hg8.a());
        this.f306055k = LazyKt.lazy(new b(this));
        this.f306056l = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final List<BaseMessageSlotCell<? extends f>> f(int r100) {
        return CollectionsKt.emptyList();
    }

    @Override // hg8.z
    public final void i(int r100) {
        ((l) this.f306054j.getValue()).i(r100);
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
        CollectionsKt.removeAll(r101, new d());
        de8.c r106 = (de8.c) this.f306056l.getValue();
        if (r106 == null) goto L16;
        Integer r107 = r106.m();
    L17:
        if (r107 != null) goto L19;
        CollectionsKt.removeAll(r101, new e());
        CollectionsKt.removeAll(r101, new hg8.f());
        goto L19
    L16:
        r107 = null;
    L19:
        return r101;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell
    public final com.larus.bmhome.chat.layout.item.g t(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        o((l) this.f306054j.getValue());
        de8.c r102 = (de8.c) this.f306056l.getValue();
        if (r102 == null) goto L5;
        Integer r103 = r102.m();
    L6:
        t r104 = new t(r100);
        r104.setImmerseBgColor(r103);
        ChatParam r105 = (ChatParam) this.f306055k.getValue();
        if (r105 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        r104.setUseSubscribedColor(r106);
        r104.setBoxType(r101);
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
        g r103 = (g) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.u(r100, r103, r102);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell, com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final boolean shouldBindCell(View r100, f r101, int r102) {
        g r103 = (g) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        ((l) this.f306054j.getValue()).H(r103);
        return true;
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell
    public final void u(View r100, xc8.b r101, int r102) {
        g r103 = (g) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.u(r100, r103, r102);
    }

    @Override // com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell
    public final boolean w(View r100, xc8.b r101, int r102) {
        g r103 = (g) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        ((l) this.f306054j.getValue()).H(r103);
        return true;
    }
}
