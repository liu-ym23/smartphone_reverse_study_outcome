package com.ss.ugc.live.sdk.msg.unify.business;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnifyLiveMessageDispatcher f458351a;

    @Override // android.os.Handler
    public final void handleMessage(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "msg");
        UnifyLiveMessageDispatcher r100 = this.f458351a;
        r100.getClass();
        int r101 = 1;
        switch(r110.what) {
            case 201: goto L71;
            case 202: goto L12;
            case 203: goto L5;
            default: goto L131;
        };
    L5:
        Object r111 = r110.obj;
        if (r111 == null) goto L11;
        tlc.d r112 = (tlc.d) r111;
        r112.setEnqueueDispatchTime(System.currentTimeMillis());
        ((ArrayList) r100.f458318a).add(r112);
        if (((ArrayList) r100.f458318a).size() <= 0) goto L98;
        r100.n(true, 0);
        return;
    L98:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L12:
        int r102 = ((ArrayList) r100.f458318a).size();
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "before dispatch, message queue size is " + ((ArrayList) r100.f458318a).size());
        Object r113 = r110.obj;
        if (r113 == null) goto L70;
        int r114 = ((Integer) r113).intValue();
        if (r114 > 0) goto L18;
        r114 = r100.f458325h;
    L18:
        if (r102 <= r114) goto L21;
        r102 = r114;
    L21:
        ArrayList r115 = new ArrayList(((ArrayList) r100.f458318a).subList(0, r102));
        int r103 = Math.min(r100.f458330m.a(r115, r100), r115.size());
        ((ArrayList) r100.f458318a).subList(0, r103).clear();
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "expect dispatch size: " + r115.size() + ", actual dispatch size: " + r103);
        int r104 = r115.size() - r103;
        if (r104 <= 0) goto L24;
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "schedule next dispatch immediately due to dispatch not enough");
        r100.n(false, r104);
        return;
    L24:
        boolean r105 = !r100.f458326i.isEmpty();
        if (r105 == false) goto L66;
        if (r105 == false) goto L42;
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r116 = r115.iterator();
    L29:
        if (r116.hasNext() == false) goto L38;
        Object r107 = r116.next();
        String r108 = ((tlc.d) r107).getMessageMethod();
        if (r108 != null) goto L34;
        r108 = "unknow";
    L34:
        Object r109 = r106.get(r108);
        if (r109 != null) goto L37;
        r109 = new ArrayList();
        r106.put(r108, r109);
    L37:
        ((List) r109).add(r107);
        goto L29
    L38:
        Map r117 = new LinkedHashMap(MapsKt.mapCapacity(r106.size()));
        Iterator r118 = r106.entrySet().iterator();
    L40:
        if (r118.hasNext() == false) goto L43;
        Map.Entry r119 = (Map.Entry) r118.next();
        r117.put(r119.getKey(), Integer.valueOf(((List) r119.getValue()).size()));
    L43:
        Iterator<T> r120 = r100.f458326i.iterator();
    L45:
        if (r120.hasNext() == false) goto L66;
        com.ss.ugc.live.sdk.msg.dispatch.a r121 = (com.ss.ugc.live.sdk.msg.dispatch.a) r120.next();
        Integer r122 = (Integer) r117.get(r121.f458268a);
        if (r122 == null) goto L49;
        int r123 = r122.intValue();
    L50:
        int r124 = r121.f458269b;
        if (r123 < r124) goto L52;
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "no need to dispatch ensure, method: " + r121.f458268a + ", expect count per dispatch: " + r121.f458269b + ", current dispatch count: " + r123);
        goto L45
    L52:
        int r125 = r124 - r123;
        ArrayList r126 = new ArrayList();
        Iterator r127 = ((ArrayList) r100.f458318a).iterator();
    L54:
        if (r127.hasNext() == false) goto L59;
        tlc.d r128 = (tlc.d) r127.next();
        if (TextUtils.equals(r121.f458268a, r128.getMessageMethod()) == false) goto L54;
        r126.add(r128);
        r127.remove();
        if (r126.size() < r125) goto L54;
    L59:
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "trigger dispatch ensure, method: " + r121.f458268a + ", expect count per dispatch: " + r121.f458269b + ", find in queue: " + r126.size());
        if ((!r126.isEmpty()) == false) goto L45;
        Iterator r129 = r126.iterator();
    L63:
        if (r129.hasNext() == false) goto L45;
        r100.onMessage((tlc.d) r129.next());
        goto L63
    L49:
        r123 = 0;
        goto L50
    L42:
        r117 = MapsKt.emptyMap();
    L66:
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "after dispatch, message queue size is " + ((ArrayList) r100.f458318a).size());
        if (((ArrayList) r100.f458318a).size() <= 0) goto L128;
        r100.n(true, 0);
        return;
    L128:
        return;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L71:
        Object r130 = r110.obj;
        if (r130 == null) goto L97;
        List r131 = (List) r130;
        r100.f458331n.f458270a += (long) r131.size();
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "main thread receive message list, size is " + r131.size());
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "add message list to message queue, size is " + r131.size());
        Iterator r132 = r131.iterator();
    L75:
        if (r132.hasNext() == false) goto L89;
        tlc.d r133 = (tlc.d) r132.next();
        long r134 = r133.getDelayDispatchMs();
        if (r134 > 0) goto L78;
        bmc.a r135 = r100.f458334q.get(r133.getMessageMethod());
        if (r135 == null) goto L83;
        r135.x40();
    L84:
        boolean r136 = true;
    L86:
        if (r136 == true) goto L87;
        r133.setEnqueueDispatchTime(System.currentTimeMillis());
        ((ArrayList) r100.f458318a).add(r133);
        goto L75
    L87:
        r100.onMessage(r133);
        goto L75
    L83:
        if (com.ss.ugc.live.sdk.msg.utils.a.b(r133) == true) goto L84;
        r136 = false;
        goto L86
    L78:
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "delay dispatch message: " + r133.getMessageMethod() + ", delay time: " + r134);
        r100.f458333p.sendMessageDelayed(r100.f458333p.obtainMessage(203, r133), r134);
        goto L75
    L89:
        int r137 = ((ArrayList) r100.f458318a).size();
        long r138 = Math.min(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME, r100.f458329l);
        long r139 = r100.f458328k;
        if (r138 >= r139) goto L92;
        r138 = r139;
    L92:
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "message queue size: " + ((ArrayList) r100.f458318a).size() + ", total dispatch time: " + r138);
        int r140 = (int) ((r138 + ((long) 100)) / r100.f458328k);
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "expect dispatch count: " + r140);
        if ((r137 / r140) < 1) goto L95;
        r101 = (r137 + (r140 / 2)) / r140;
    L95:
        r100.f458325h = r101;
        com.ss.ugc.live.sdk.msg.utils.a.a(r100.f458337t, "next time dispatch size: " + r100.f458325h);
        r100.n(false, 0);
        return;
    L97:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.ss.ugc.live.sdk.message.data.IMessage>");
    }

    public c(UnifyLiveMessageDispatcher r100, Looper r101) {
        this.f458351a = r100;
        super(r101);
    }
}
