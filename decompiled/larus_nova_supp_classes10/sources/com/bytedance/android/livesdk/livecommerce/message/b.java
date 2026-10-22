package com.bytedance.android.livesdk.livecommerce.message;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.room.api.d;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.j;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.ECCartMonitor;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hh2.f;
import hh2.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sg2.e0;
import sg2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends c0 implements td.a, IExternalMessageListener {
    public d c;
    public final List<e0> d;
    public final j e;

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        d r0 = this.c;
        if (r0 == null) goto L6;
        r0.b(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        monitor-enter(this);
        ((ArrayList) this.d).clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void H(ee.b r11) {
        String r0 = String.valueOf(r11.getMsgType());
        String r1 = String.valueOf(r11.getMessageId2());
        xh.b.d r2 = new xh.b.d();
        r2.c(r1);
        if (ECAppInfoService.e.isLocalTest() == false) goto L5;
        ee.b r3 = r11;
    L6:
        r2.a(r3);
        int r4 = 4;
        if (CollectionsKt.listOf(new Integer[]{10, 11, 13, 14}).contains(Integer.valueOf(r11.getMsgType())) == true) goto L10;
        r4 = 2;
    L10:
        xh.c.a("Live").h(null, r0, r2, r4);
        int r5 = ri2.a.a;
        List r6 = r11.getTargetUid();
        List r7 = r11.getSecTargetUid();
        List r8 = r6;
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == false) goto L27;
        List r10 = r7;
        if (r10 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == false) goto L27;
    L52:
        boolean r13 = true;
    L54:
        if (r13 == true) goto L56;
        return;
    L56:
        boolean r14 = ECCartMonitor.a;
        ECCartMonitor.g(r11.getMsgType(), r11.getMessageId2());
        Intrinsics.checkNotNullParameter(r11, "message");
        monitor-enter(this);     // Catch: Exception -> L79
    L76:
        th = move-exception;
        throw th;     // Catch: Exception -> L79
    L59:
        if (((ArrayList) this.d).isEmpty() == false) goto L61;
        List<e0> r15 = this.d;     // Catch: Throwable -> L76
        int r16 = c.a;     // Catch: Throwable -> L76
        ((ArrayList) r15).addAll(c.a(false, A()));     // Catch: Throwable -> L76
    L61:
        ArrayList r17 = (ArrayList) this.d;     // Catch: Throwable -> L76
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L76
    L63:
        if (r18.hasNext() == false) goto L71;
        e0 r19 = (e0) r18.next();     // Catch: Throwable -> L76
        if ((r19 instanceof qi2.a) == true) goto L67;
        r19 = null;
    L67:
        qi2.a r20 = (qi2.a) r19;     // Catch: Throwable -> L76
        if (r20 == null) goto L63;
        r20.c(this.e);     // Catch: Throwable -> L76
        goto L63
    L71:
        if (r17.size() <= 0) goto L74;
        ((e0) ListProtector.get(r17, 0)).a(new f0(r17, 1, r11));     // Catch: Throwable -> L76
    L74:
        monitor-exit(this);     // Catch: Exception -> L79
        return;
    L79:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L21:
        if (r10.isEmpty() == true) goto L24;
        r12 = false;
    L27:
        r r21 = r.a;
        String r22 = r21.getCurrentUserId();
        g r23 = f.a.a;
        if (r23 == null) goto L32;
        Boolean r24 = r23.p();
        if (r24 == null) goto L32;
        boolean r25 = r24.booleanValue();
    L33:
        if (r25 == false) goto L42;
        int r26 = ECContextContainer.b;
        ECContext r27 = ECContextContainer.a.b();
        if (r6 == null) goto L52;
        if (r6.contains(r22) == true) goto L52;
        if (r27 != null) goto L40;
    L53:
        r13 = false;
        goto L54
    L40:
        if (r6.contains(r27.getAnchorId().getValue()) == false) goto L53;
    L42:
        String r28 = r21.f();
        if (TextUtils.isEmpty(r28) == true) goto L48;
        if (r7 == null) goto L48;
        if (r7.contains(r28) == true) goto L52;
    L48:
        if (TextUtils.isEmpty(r22) == true) goto L53;
        if (r6 == null) goto L53;
        if (r6.contains(r22) == false) goto L53;
    L32:
        r25 = false;
        goto L33
    L13:
        if (r8.isEmpty() == true) goto L16;
        r9 = false;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(d r2) {
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
        Intrinsics.checkNotNullParameter(r2, "messageHandler");
        this.c = r2;
        r2.a(1002, this);
    }

    public final void onMessage(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if ((r2 instanceof ce.a) == false) goto L6;
        H(new ee.b((ce.a) r2));
        return;
    }

    public b(RealRoomController$roomResources$1 r2, RealRoomController.d r3) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        Intrinsics.checkNotNullParameter(r3, "roomStateProvider");
        super(r2);
        this.e = r3;
        this.d = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r2) {
        super.c(r1, r2);
        monitor-enter(this);
        ((ArrayList) this.d).clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(ee.a r1, boolean r2) {
        if ((r1 instanceof ee.b) == false) goto L6;
        H((ee.b) r1);
        return;
    }
}
