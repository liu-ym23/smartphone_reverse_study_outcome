package com.larus.bmhome.chat.list.cell.text;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.layout.item.p;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import dc8.c;
import dg8.d;
import ei9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import xc8.b;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0001\u0012\b&\u0018\u0000 C*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u0001CB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000eJ!\u0010\"\u001a\u0004\u0018\u0001H#\"\u0004\b\u0001\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%¢\u0006\u0002\u0010&J%\u0010'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010*J%\u0010+\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010*J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u000eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u000e\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u000203J*\u00104\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00102\u001a\u0002032\u000e\u00107\u001a\n\u0018\u000108j\u0004\u0018\u0001`9H\u0016J%\u0010:\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0006\u0012\u0004\u0018\u00010=0;2\b\u0010>\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010?J%\u0010@\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010AJ\n\u0010B\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006D"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "STATE", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/text/context/external/ICalculateVisibleAbility;", "<init>", "()V", "isFullyVisible", "", "()Z", "setFullyVisible", "(Z)V", "componentList", "", "Lcom/larus/bmhome/chat/cell/text/components/BaseComponent;", "box", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "boxChangedListener", "com/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell$boxChangedListener$1", "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell$boxChangedListener$1;", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "internalOnCreateBoxView", "Lcom/larus/bmhome/chat/layout/item/BaseCompositeBox;", "onViewCreated", "", "view", "attachComponent", "baseComponent", "getTargetComponent", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "onBindView", "state", "position", "(Landroid/view/View;Lcom/larus/bmhome/chat/cell/BaseMessageCellState;I)V", "bindComponent", "calculateInsertIndex", "waitAttachComponent", "onViewDetachedFromWindow", "onViewAttachedToWindow", "onViewRecycled", "notifyItemShow", "message", "Lcom/larus/im/bean/message/Message;", "calculateComponentVisible", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "Lcom/larus/bmhome/chat/list/base/MessageAdapter;", "appendPerfMonitorParams", "", "", "", "data", "(Lcom/larus/bmhome/chat/cell/BaseMessageCellState;)Ljava/util/Map;", "shouldBindCell", "(Landroid/view/View;Lcom/larus/bmhome/chat/cell/BaseMessageCellState;I)Z", "mainViewBox", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseCompositeTextCell<STATE extends xc8.b> extends BaseMessageListCell<STATE> implements tg8.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f305994i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f305995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<bd8.b> f305996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f305997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f305998h;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCompositeTextCell<STATE> f305999a;

        public b(BaseCompositeTextCell<STATE> r100) {
            this.f305999a = r100;
        }

        @Override // com.larus.bmhome.chat.layout.item.p
        public final void b(boolean r100) {
            Iterator<T> r101 = this.f305999a.f305996f.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((bd8.b) r101.next()).F(r100);
            goto L4
        }

        @Override // com.larus.bmhome.chat.layout.item.p
        public final void c(Integer r100) {
            Iterator r101 = ((ArrayList) this.f305999a.f305996f).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((bd8.b) r101.next()).D();
            goto L4
        }

        @Override // com.larus.bmhome.chat.layout.item.p
        public final void a(boolean r100, boolean r101) {
            Iterator r102 = ((ArrayList) this.f305999a.f305996f).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((bd8.b) r102.next()).E();
            goto L4
        }
    }

    static {
    }

    public abstract g t(Context r100, int r101);

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public void onViewAttachedToWindow() {
        Iterator r100 = ((ArrayList) this.f305996f).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((bd8.b) r100.next()).z();
        goto L4
    L6:
        q0 r101 = lf8.a.b(this);
        String r102 = null;
        if (r101 == null) goto L9;
        MessageAdapter r103 = r101.F7();
    L11:
        if ((r103 instanceof c) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L25;
        STATE r104 = this.f297618d;
        if (r104 == null) goto L20;
        Message r105 = r104.getMessage();
        if (r105 == null) goto L20;
        r102 = r105.getMessageId();
    L20:
        if (r102 != null) goto L22;
        r102 = "";
    L22:
        r103.u1(r102, this);
        return;
    L25:
        return;
    L9:
        r103 = null;
        goto L11
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewDetachedFromWindow() {
        Iterator r100 = ((ArrayList) this.f305996f).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((bd8.b) r100.next()).B();
        goto L4
    L6:
        q0 r101 = lf8.a.b(this);
        String r102 = null;
        if (r101 == null) goto L9;
        MessageAdapter r103 = r101.F7();
    L11:
        if ((r103 instanceof c) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L25;
        STATE r104 = this.f297618d;
        if (r104 == null) goto L20;
        Message r105 = r104.getMessage();
        if (r105 == null) goto L20;
        r102 = r105.getMessageId();
    L20:
        if (r102 != null) goto L22;
        r102 = "";
    L22:
        r103.S(r102, this);
        return;
    L25:
        return;
    L9:
        r103 = null;
        goto L11
    }

    public BaseCompositeTextCell() {
        this.f305996f = new ArrayList();
        this.f305998h = new b(this);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public void onViewRecycled() {
        q0 r100 = lf8.a.b(this);
        String r101 = null;
        if (r100 == null) goto L5;
        MessageAdapter r102 = r100.F7();
    L7:
        if ((r102 instanceof c) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L19;
        STATE r103 = this.f297618d;
        if (r103 == null) goto L16;
        Message r104 = r103.getMessage();
        if (r104 == null) goto L16;
        r101 = r104.getMessageId();
    L16:
        if (r101 != null) goto L18;
        r101 = "";
    L18:
        r102.N1(r101, this);
    L19:
        Iterator r105 = ((ArrayList) this.f305996f).iterator();
    L21:
        if (r105.hasNext() == false) goto L23;
        ((bd8.b) r105.next()).C();
        goto L21
    L23:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final i h() {
        return this.f305997g;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final Map appendPerfMonitorParams(f r100) {
        xc8.b r101 = (xc8.b) r100;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = ((ArrayList) this.f305996f).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.putAll(((bd8.b) r103.next()).u());
        goto L4
    L6:
        STATE r104 = this.f297618d;
        if ((r104 instanceof com.larus.bmhome.chat.list.cell.text.cells.base.a) == false) goto L9;
        com.larus.bmhome.chat.list.cell.text.cells.base.a r105 = (com.larus.bmhome.chat.list.cell.text.cells.base.a) r104;
    L10:
        if (r105 == null) goto L12;
        r102.put("cell_component_type", r105.i().f306021a);
    L12:
        return r102;
    L9:
        r105 = null;
        goto L10
    }

    public final void o(bd8.b r100) {
        Intrinsics.checkNotNullParameter(r100, "baseComponent");
        ((ArrayList) this.f305996f).add(r100);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        Iterator r101 = ((ArrayList) this.f305996f).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((bd8.b) r101.next()).A();
        goto L4
    }

    public final int r(bd8.b r100) {
        final int r101 = r100.f18690b;
        long r102 = System.currentTimeMillis();
        Integer r103 = (Integer) SequencesKt.maxOrNull(SequencesKt.map(SequencesKt.filter(SequencesKt.flatMapIterable(SequencesKt.filter(CollectionsKt.asSequence(this.f305996f), new dg8.a(r101)), new dg8.b()), new dg8.c()), new d()));
        FLogger.f375446a.d("BaseCompositeTextCell", "calculateInsertIndex= " + r103 + "===waitAttachComponent:" + r100 + ": " + (System.currentTimeMillis() - r102));
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.intValue() + 1;
    }

    public final <T> T s(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Iterator r101 = ((ArrayList) this.f305996f).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (r100.isInstance((bd8.b) r102) == false) goto L4;
    L9:
        bd8.b r103 = (bd8.b) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        return r100.cast(r103);
    L8:
        r102 = null;
        goto L9
    }

    @Override // tg8.b
    public final boolean c(t1a.b r100, Message r101, q0 r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        List<bd8.b> r103 = this.f305996f;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L18;
        if (((bd8.b) r104.next()).G(r101) == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (r103.isEmpty() == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        g r103 = t(r100, r102);
        r103.setBoxChangedListener(this.f305998h);
        this.f305997g = r103;
        Iterator r104 = ((ArrayList) this.f305996f).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        bd8.b r105 = (bd8.b) r104.next();
        q0 r106 = lf8.a.b(this);
        Fragment r107 = lf8.a.d(this);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r105.f18691c = r107;
        r105.f18694f = this;
        r105.f18692d = r103;
        r105.f18693e = r106;
        r105.f18695g = r100;
        if (r105.f18689a == true) goto L4;
        if (r105.f18698j == true) goto L4;
        r105.y(r(r105));
        goto L4
    L10:
        return r103;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public /* bridge */ /* synthetic */ void onBindView(View r100, f r101, int r102) {
        u(r100, (xc8.b) r101, r102);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature, com.larus.list.arch.IFlowListCell
    public /* bridge */ /* synthetic */ boolean shouldBindCell(View r100, f r101, int r102) {
        return w(r100, (xc8.b) r101, r102);
    }

    public void u(View r100, STATE r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (com.larus.im.bean.message.a.w0(r101.getMessage()) == true) goto L10;
        if (r101.getMessage().getMessageStatusLocal() != 11) goto L7;
    L8:
        FLogger.f375446a.i("BaseCompositeTextCell", "onBindView, pos:" + r102 + ", msgId:" + r101.getMessage().getMessageId() + ", cvsId:" + r101.getMessage().getConversationId() + ", state:" + r101.getClass().getSimpleName() + ", cell:" + getClass().getSimpleName());
        goto L10
    L7:
        if (r101.getMessage().getMessageStatusLocal() == 21) goto L8;
    L10:
        if ((r101 instanceof com.larus.bmhome.chat.list.cell.text.cells.base.a) == false) goto L15;
        Iterator r103 = ((ArrayList) this.f305996f).iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((bd8.b) r103.next()).f18696h = ((com.larus.bmhome.chat.list.cell.text.cells.base.a) r101).i();
    L15:
        MessageAdapter r104 = null;
        if (lf8.a.b(this) != null) goto L28;
        Iterator r105 = ((ArrayList) this.f305996f).iterator();
    L19:
        if (r105.hasNext() == false) goto L75;
        bd8.b r106 = (bd8.b) r105.next();
        if (r106.f18698j == true) goto L22;
        if (r106.f18689a == false) goto L19;
        if (r106.G(r101.getMessage()) == false) goto L19;
        r106.y(r(r106));
        r106.w(r101.getMessage(), r102, null);
        goto L19
    L22:
        r106.w(r101.getMessage(), r102, null);
        goto L19
    L75:
        return;
    L28:
        q0 r107 = lf8.a.b(this);
        if (r107 == null) goto L31;
        MessageAdapter r108 = r107.F7();
    L33:
        if ((r108 instanceof c) == false) goto L35;
        r104 = r108;
    L35:
        if (r104 == null) goto L52;
        String r109 = r101.getMessage().getMessageId();
        if (r109 != null) goto L39;
        r109 = "";
    L39:
        ec8.b r110 = r104.I1(r109, this, r101, this.f305996f);
        if (r110 == null) goto L74;
        Iterator r111 = ((ArrayList) this.f305996f).iterator();
    L43:
        if (r111.hasNext() == false) goto L76;
        bd8.b r112 = (bd8.b) r111.next();
        if (r112.f18698j == true) goto L46;
        if (r112.f18689a == false) goto L43;
        if (r112.G(r101.getMessage()) == false) goto L43;
        r112.y(r(r112));
        r112.w(r101.getMessage(), r102, r110);
        goto L43
    L46:
        r112.w(r101.getMessage(), r102, r110);
        goto L43
    L76:
        return;
    L74:
        return;
    L52:
        return;
    L31:
        r108 = null;
        goto L33
    }

    public boolean w(View r100, STATE r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "state");
        List<bd8.b> r103 = this.f305996f;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator r104 = ((ArrayList) r103).iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        if (((bd8.b) r104.next()).H(r101) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (((ArrayList) r103).isEmpty() == false) goto L7;
        goto L7
    }
}
