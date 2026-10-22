package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h extends com.bytedance.sdk.xbridge.cn.websocket.utils.a implements BdpWsClient.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f270285g = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BdpWsClient f270286f;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.a
    public final void i() {
        BdpWsClient r100 = this.f270286f;     // Catch: Throwable -> L7
        if (r100 == null) goto L6;
        ((b) r100).f270275a.stopConnection();     // Catch: Throwable -> L7
    L6:
        d(false);
        return;
    L7:
        id7.c.a("Task.ttnet:stopConnection error");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        d(false);
        throw th;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.a
    public final void h() {
        BdpWsClient r100 = this.f270286f;
        if (r100 == null) goto L50;
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        JSONObject r103 = this.f270271b.f270283b;
        boolean r104 = true;
        if (r103 == null) goto L21;
        Iterator<String> r105 = r103.keys();
    L8:
        if (r105.hasNext() == false) goto L21;
        String r106 = r105.next();
        if (r106.length() != 0) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == true) goto L8;
        Object r108 = r103.opt(r106);
        if (r108 == null) goto L19;
        String r109 = r108.toString();
        if (r109 == null) goto L19;
    L20:
        r102.put(r106, r109);
    L19:
        r109 = "";
        goto L20
    L12:
        r107 = false;
    L21:
        JSONArray r110 = this.f270271b.f270284c;
        if (r110 == null) goto L35;
        int r111 = r110.length();
        StringBuilder r112 = new StringBuilder();
        int r113 = 0;
    L24:
        if (r113 >= r111) goto L29;
        r112.append(r110.optString(r113));
        if (r113 == (r111 - 1)) goto L28;
        r112.append(",");
    L28:
        r113 = r113 + 1;
        goto L24
    L29:
        String r114 = r112.toString();
        if (r114.length() > 0) goto L33;
        r104 = false;
    L33:
        if (r104 == false) goto L35;
        r102.put("Sec-WebSocket-Protocol", r114);
    L35:
        List<String> r115 = CollectionsKt.listOf(this.f270271b.f270282a);
        b r116 = (b) r100;
        if (r115 != null) goto L38;
        return;
    L38:
        if (r115.isEmpty() == true) goto L52;
        r116.f270275a.openConnection(r101, r102, r115, false, false);
        return;
    L52:
        return;
    }

    public final boolean j() {
        BdpWsClient r100 = this.f270286f;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L17;
        monitor-enter(this);
        int r102 = this.f270273d;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r102 != 1) goto L20;
        return true;
    L20:
        return false;
    L14:
        th = move-exception;
        throw th;
    L17:
        return false;
    L5:
        if (((b) r100).f270275a.isConnected() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.c
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (j() == false) goto L8;
        BdpWsClient r101 = this.f270286f;
        if (r101 == null) goto L7;
        b r102 = (b) r101;
        r102.a(r100.getBytes(StandardCharsets.UTF_8), 1);
    L7:
        return null;
    L8:
        return "the socket is disconnected";
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.c
    public final String sendMessage(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "byteData");
        if (j() == false) goto L8;
        BdpWsClient r101 = this.f270286f;
        if (r101 == null) goto L7;
        ((b) r101).a(r100, 2);
    L7:
        return null;
    L8:
        return "the socket is disconnected";
    }

    public h(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestTask");
        super(r100, r101);
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient.a
    public final void onMessage(byte[] r100, int r101) {
        if (1 != r101) goto L10;
        if (r100 == null) goto L6;
        String r102 = new String(r100, StandardCharsets.UTF_8);
    L7:
        Intrinsics.checkNotNullParameter(r102, "msg");
        k r103 = this.f270272c;
        if (r103 == null) goto L16;
        r103.onMessage(r102);
        return;
    L16:
        return;
    L6:
        r102 = "";
        goto L7
    L10:
        if (r100 != null) goto L12;
        r100 = new byte[0];
    L12:
        Intrinsics.checkNotNullParameter(r100, "msg");
        k r104 = this.f270272c;
        if (r104 == null) goto L18;
        r104.onMessage(r100);
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.BdpWsClient.a
    public final void c(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "url");
        boolean r103 = true;
        if (r100 != 2) goto L5;
        if (r102 != null) goto L22;
    L25:
        if (r103 == false) goto L29;
        Intrinsics.checkNotNullParameter(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN, "reason");
        k r104 = this.f270272c;
        if (r104 == null) goto L36;
        r104.onFailed(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        return;
    L36:
        return;
    L29:
        Intrinsics.checkNotNullParameter(r102, "reason");
        k r105 = this.f270272c;
        if (r105 == null) goto L38;
        r105.onFailed(r102);
        return;
    L38:
        return;
    L22:
        if (r102.length() == 0) goto L25;
        r103 = false;
        goto L25
    L5:
        if (r100 != 3) goto L7;
        d(true);
        return;
    L7:
        if (r100 != 4) goto L39;
        k r106 = this.f270272c;
        if (r106 == null) goto L12;
        r106.onConnected();
    L12:
        monitor-enter(this);
        this.f270273d = 1;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
