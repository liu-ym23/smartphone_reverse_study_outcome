package com.larus.bmhome.chat.list.cell.widget;

import ah8.c;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.ai.widget.view.WidgetBoxView;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.bmhome.chat.api.r;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.w4;
import com.larus.bmhome.chat.layout.widget.AppletWidget;
import com.larus.bmhome.chat.standarduikit.widget.view.WidgetView;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import ei9.f;
import eo8.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J \u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001cH\u0016J \u0010\"\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%0#2\b\u0010&\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010'\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/widget/WidgetCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/widget/WidgetCellState;", "<init>", "()V", "box", "Lcom/larus/bmhome/chat/layout/item/WidgetBox;", "widgetAssembler", "Lcom/larus/bmhome/chat/standarduikit/widget/assembler/WidgetAssembler;", "dependency", "Lcom/larus/bmhome/chat/standarduikit/widget/WidgetDependencyImpl;", "getDependency", "()Lcom/larus/bmhome/chat/standarduikit/widget/WidgetDependencyImpl;", "dependency$delegate", "Lkotlin/Lazy;", "onCellVisibilityChange", "", "isVisible", "", "isFullyVisible", "lastVisible", "showRatio", "", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "view", "state", "position", "appendPerfMonitorParams", "", "", "", "data", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WidgetCell extends BaseMessageListCell<c> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<View> f306593h = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w4 f306594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public fo8.c f306595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f306596g;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
    }

    static {
        f306593h = new ArrayList();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewRecycled() {
        fo8.c r100 = this.f306595f;
        if (r100 == null) goto L6;
        r100.b().c();
        return;
    }

    public WidgetCell() {
        this.f306596g = LazyKt.lazy(new ah8.a(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final Map appendPerfMonitorParams(f r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Message r102 = ((c) r100).f563233a;
        WidgetRenderDelegate r103 = WidgetRenderDelegate.f297181a;
        String r104 = r102.getMessageId();
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r103.b(r104, r102.getContent()));
        String r106 = r102.getMessageId();
        if (r106 == null) goto L9;
        r105 = r106;
    L9:
        r101.put("item_key", r103.b(r105, r102.getContent()));
        return r101;
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final void k(boolean r100, boolean r101, boolean r102) {
        fo8.c r103 = this.f306595f;
        WidgetView r104 = null;
        if (r103 == null) goto L5;
        WidgetView r105 = r103.b();
    L7:
        if ((r105 instanceof WidgetView) == false) goto L9;
        r104 = r105;
    L9:
        if (r104 == null) goto L26;
        AppletWidget r106 = r104.getAppletWidget();
        if (r106 == null) goto L27;
        r r107 = r106.getWidgetContainer();
        if (r107 == null) goto L28;
        WidgetBoxView r108 = r107.a();
        if (r108 == null) goto L30;
        r r109 = r106.f304744f;
        if (r109 == null) goto L22;
        WidgetBoxView r110 = r109.a();
        if (r110 == null) goto L22;
        boolean r111 = r110.getGlobalVisibleRect(new Rect());
    L23:
        if (r111 == false) goto L29;
        ((ArrayList) f306593h).add(r108);
        return;
    L29:
        return;
    L22:
        r111 = false;
        goto L23
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r105 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        fo8.c r103 = new fo8.c(r100);
        this.f306595f = r103;
        w4 r104 = new w4(r100);
        WidgetView r105 = r103.b();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.larus.bmhome.chat.standarduikit.widget.view.WidgetView");
        r104.setupWidget(r105);
        this.f306594e = r104;
        r104.setBoxType(r102);
        return r104;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, f r110, int r111) {
        c r112 = (c) r110;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r112, "state");
        w4 r101 = this.f306594e;
        boolean r113 = false;
        if (r101 == null) goto L5;
        int r102 = r101.getMaxWidth();
    L6:
        Message r103 = r112.f563233a;
        w4 r104 = this.f306594e;
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        boolean r106 = !r105;
        String r114 = r112.f563233a.getContent();
        if (r114 != null) goto L15;
        r114 = "";
    L15:
        String r107 = r114;
        w4 r115 = this.f306594e;
        if (r115 != null) goto L18;
    L20:
        if (r113 == false) goto L22;
        float r108 = 0.0f;
    L23:
        ho8.a r116 = new ho8.a(r106, r102, r103, r107, r108, true, MapsKt.emptyMap());
        fo8.c r109 = this.f306595f;
        if (r109 == null) goto L27;
        r109.a(r116, (b) this.f306596g.getValue());
        return;
    L27:
        return;
    L22:
        r108 = i5.r0();
        goto L23
    L18:
        if (r115.getBoxType() != 3) goto L20;
        r113 = true;
        goto L20
    L9:
        if (r104.getBoxType() != 3) goto L11;
        r105 = true;
        goto L12
    L5:
        r102 = 0;
        goto L6
    }
}
