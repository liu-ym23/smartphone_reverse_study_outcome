package com.bytedance.sdk.xbridge.cn.websocket.utils;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class SocketManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, HashMap<String, ? super c>> f270264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<SocketManager> f270265b = null;

    public static final class a {
    }

    public final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f270266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f270267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f270268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SocketManager f270269d;

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.k
        public final void onConnected() {
            String r100 = this.f270267b;
            Intrinsics.checkNotNullParameter(PTYSocketStateCallback.CONNECTED, "status");
            Intrinsics.checkNotNullParameter(r100, "socketTaskID");
            this.f270268c.a(new f(PTYSocketStateCallback.CONNECTED, r100, "unknow error", null, null));
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.k
        public final void onClosed(boolean r100) {
            String r101 = this.f270267b;
            Intrinsics.checkNotNullParameter(PTYSocketStateCallback.CLOSED, "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            if (r100 == false) goto L5;
            this.f270268c.a(new f(PTYSocketStateCallback.CLOSED, r101, "unknow error", null, null));
        L5:
            SocketManager.a(this.f270269d, this.f270266a, this.f270267b);
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.k
        public final void onFailed(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            String r101 = this.f270267b;
            Intrinsics.checkNotNullParameter("failed", "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            e r102 = this.f270268c;
            Intrinsics.checkNotNullParameter(r100, "message");
            r102.a(new f("failed", r101, r100, null, null));
            SocketManager.a(this.f270269d, this.f270266a, this.f270267b);
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.k
        public final void onMessage(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
            String r101 = this.f270267b;
            Intrinsics.checkNotNullParameter("onMessaged", "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            String r102 = Base64.encodeToString(r100, 0);
            e r103 = this.f270268c;
            Intrinsics.checkNotNullParameter(TTVideoEngineInterface.PLAY_API_KEY_BASE64, "dataType");
            r103.a(new f("onMessaged", r101, "unknow error", r102, TTVideoEngineInterface.PLAY_API_KEY_BASE64));
        }

        @Override // com.bytedance.sdk.xbridge.cn.websocket.utils.k
        public final void onMessage(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            String r101 = this.f270267b;
            Intrinsics.checkNotNullParameter("onMessaged", "status");
            Intrinsics.checkNotNullParameter(r101, "socketTaskID");
            e r102 = this.f270268c;
            Intrinsics.checkNotNullParameter("string", "dataType");
            r102.a(new f("onMessaged", r101, "unknow error", r100, "string"));
        }

        public b(SocketManager r100, String r101, String r102, ef7.c r103) {
            Intrinsics.checkNotNullParameter(r101, "containerID");
            Intrinsics.checkNotNullParameter(r102, "socketTaskID");
            Intrinsics.checkNotNullParameter(r103, "callback");
            this.f270269d = r100;
            this.f270266a = r101;
            this.f270267b = r102;
            this.f270268c = r103;
        }
    }

    public SocketManager() {
    }

    static {
        f270264a = new HashMap();
        f270265b = LazyKt.lazy(SocketManager$Companion$instance$2.INSTANCE);
    }

    public static List b(String r100, String r101) {
        HashMap<String, HashMap<String, ? super c>> r102 = f270264a;
        monitor-enter(r102);
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L33
        if (r101 == null) goto L19;
        HashMap<String, ? super c> r104 = r102.get(r100);     // Catch: Throwable -> L33
        if (r104 == null) goto L17;
        c r105 = r104.get(r101);     // Catch: Throwable -> L33
        if ((r105 instanceof c) == false) goto L11;
        c r106 = r105;     // Catch: Throwable -> L33
    L12:
        if (r106 == null) goto L15;
        r103.add(r106);     // Catch: Throwable -> L33
    L31:
        monitor-exit(r102);
        return r103;
    L15:
        monitor-exit(r102);
        return null;
    L11:
        r106 = null;
        goto L12
    L17:
        monitor-exit(r102);
        return null;
    L19:
        HashMap<String, ? super c> r107 = r102.get(r100);     // Catch: Throwable -> L33
        if (r107 == null) goto L27;
        Iterator<? super c> r108 = r107.values().iterator();     // Catch: Throwable -> L33
    L23:
        if (r108.hasNext() == false) goto L25;
        c r109 = r108.next();     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.websocket.utils.IWebSocketTask");     // Catch: Throwable -> L33
        r103.add(r109);     // Catch: Throwable -> L33
        goto L23
    L25:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L33
    L28:
        if (r110 != null) goto L31;
        monitor-exit(r102);
        return null;
    L27:
        r110 = null;
    L33:
        th = move-exception;
        throw th;
    }

    public static final void a(SocketManager r100, String r101, String r102) {
        r100.getClass();
        HashMap<String, HashMap<String, ? super c>> r103 = f270264a;
        monitor-enter(r103);
        HashMap<String, ? super c> r104 = r103.get(r101);     // Catch: Throwable -> L18
        if (r104 == null) goto L7;
        r104.remove(r102);     // Catch: Throwable -> L18
    L7:
        HashMap<String, ? super c> r105 = r103.get(r101);     // Catch: Throwable -> L18
        if (r105 == null) goto L12;
        boolean r106 = true;
        if (r105.isEmpty() != true) goto L12;
    L13:
        if (r106 == false) goto L15;
        r103.remove(r101);     // Catch: Throwable -> L18
    L15:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r103);
        return;
    L12:
        r106 = false;
    L18:
        th = move-exception;
        throw th;
    }
}
