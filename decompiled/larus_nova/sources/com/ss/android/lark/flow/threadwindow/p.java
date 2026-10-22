package com.ss.android.lark.flow.threadwindow;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowThreadWindowMsgSender f424250a;

    public p(FlowThreadWindowMsgSender r100) {
        this.f424250a = r100;
    }

    public final void a() {
        final FlowThreadWindowMsgSender r100 = this.f424250a;
        r100.f424206l = false;
        FlowThreadWindowMsgSender.c r101 = r100.f424204j;
        ArrayList r102 = new ArrayList(r100.f424205k);
        r100.f424204j = null;
        ((ArrayList) r100.f424205k).clear();
        if (r101 == null) goto L5;
        FlowThreadWindowMsgSender.c r103 = r101;
        final List r104 = r102;
    L38:
        if (r103 != null) goto L41;
        Log.w("FlowThreadWindowMsgSender", "flush blocked: no root-capable item");
        r100.f424202h.a();
        return;
    L41:
        if (r104.isEmpty() == false) goto L43;
        Log.i("FlowThreadWindowMsgSender", "[MessageBatch] flush single topic, type=" + r103.getType() + ", isLastInBatch=true");
        r100.z(r103, System.currentTimeMillis(), true, new FlowThreadWindowMsgSender$flush$2(r100));
        return;
    L43:
        final long r105 = System.currentTimeMillis();
        Log.i("FlowThreadWindowMsgSender", "[MessageBatch] flush topic batch, rootType=" + r103.getType() + ", replyCount=" + r104.size() + ", queueId=" + r105 + ", rootIsLastInBatch=false");
        r100.z(r103, r105, false, new FlowThreadWindowMsgSender$sendRootThenReplies$1(r100, r104, r105));
        return;
    L5:
        Iterator r106 = r102.iterator();
        int r107 = 0;
    L7:
        if (r106.hasNext() == false) goto L20;
        FlowThreadWindowMsgSender.c r108 = (FlowThreadWindowMsgSender.c) r106.next();
        if (r108.getType() != FlowThreadWindowMsgSender.MsgType.IMAGE) goto L11;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == true) goto L21;
        r107 = r107 + 1;
    L21:
        if (r107 < 0) goto L36;
        FlowThreadWindowMsgSender.c r110 = (FlowThreadWindowMsgSender.c) ListProtector.get(r102, r107);
        ArrayList r111 = new ArrayList();
        Iterator r112 = r102.iterator();
        int r113 = 0;
    L24:
        if (r112.hasNext() == false) goto L35;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        FlowThreadWindowMsgSender.c r116 = (FlowThreadWindowMsgSender.c) r114;
        if (r113 == r107) goto L31;
        boolean r117 = true;
    L32:
        if (r117 == false) goto L34;
        r111.add(r114);
    L34:
        r113 = r115;
        goto L24
    L31:
        r117 = false;
        goto L32
    L35:
        r103 = r110;
        r104 = r111;
        goto L38
    L36:
        r103 = null;
        r104 = CollectionsKt.emptyList();
        goto L38
    L11:
        if (r108.getType() == FlowThreadWindowMsgSender.MsgType.FILE) goto L16;
        if (r108.getType() == FlowThreadWindowMsgSender.MsgType.VIDEO) goto L16;
        r109 = false;
        goto L17
    L20:
        r107 = -1;
        goto L21
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
