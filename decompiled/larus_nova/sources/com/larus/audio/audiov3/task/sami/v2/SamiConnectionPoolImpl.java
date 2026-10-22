package com.larus.audio.audiov3.task.sami.v2;

import com.larus.audio.audiov3.config.ConnectStatusEnum;
import com.larus.audio.audiov3.config.NetworkStatus;
import com.larus.audio.audiov3.connection.ISamiConnectionPool;
import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/audio/audiov3/task/sami/v2/SamiConnectionPoolImpl;", "Lcom/larus/audio/audiov3/connection/ISamiConnectionPool;", "<init>", "()V", "connectionStatus", "Lcom/larus/audio/audiov3/config/ConnectStatusEnum;", "cachedSAMICore", "Lcom/larus/audio/audiov3/task/sami/v2/flow/FlowSamiCore;", "samiInit", "", "cachedSAMICoreInUse", "tryConnect", "", "disconnect", "connectWhenUse", "obtainCacheConnection", "getConnectionStatus", "recycleCacheConnection", "samiCore", "status", "initConnect", "initSamiCoreListener", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SamiConnectionPoolImpl implements ISamiConnectionPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConnectStatusEnum f288540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.audio.audiov3.task.sami.v2.flow.a f288541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f288542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f288543d;

    public static final class a {
    }

    public static final class b implements SAMICoreCallBackListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SamiConnectionPoolImpl f288544a;

        /* JADX INFO: loaded from: classes24.dex */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f288545a = null;

            static {
                int[] r100 = new int[SAMICoreCallBackEventType.values().length];
                r100[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[SAMICoreCallBackEventType.SessionFinished.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f288545a = r100;
            }
        }

        public b(SamiConnectionPoolImpl r100) {
            this.f288544a = r100;
        }

        @Override // com.mammon.audiosdk.SAMICoreCallBackListener
        public final void onMessageReceived(SAMICoreCallBackEventType r100, SAMICoreBlock r101) {
            if (r100 != null) goto L4;
            int r102 = -1;
        L5:
            switch(r102) {
                case 1: goto L21;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L7;
                default: goto L30;
            };
        L7:
            if (r101 == null) goto L16;
            Object r103 = r101.audioData[0];
            if (r103 == null) goto L23;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent");
            SAMICoreWebSocketConnectionEvent r104 = (SAMICoreWebSocketConnectionEvent) r103;
            int r105 = c68.b.f22600a;
            c68.b.b("SamiConnectionPool", "handleWebsocketChanged state: " + r104.state + ", msg: " + r104.textMsg + b0.a(this.f288544a.f288541b));
            if (r104.state != NetworkStatus.WEB_SOCKET_CHANGE_FAIL.getCode()) goto L14;
        L15:
            this.f288544a.f288540a = ConnectStatusEnum.DISABLE;
            return;
        L14:
            if (r104.state == NetworkStatus.WEB_SOCKET_CONNECTION_FAIL.getCode()) goto L15;
            return;
        L23:
            return;
        L16:
            return;
        L17:
            this.f288544a.f288540a = ConnectStatusEnum.ENABLE;
            return;
        L18:
            this.f288544a.f288540a = ConnectStatusEnum.ENABLE;
            return;
        L19:
            this.f288544a.f288540a = ConnectStatusEnum.DISABLE;
            return;
        L20:
            this.f288544a.f288540a = ConnectStatusEnum.DISABLE;
            return;
        L21:
            this.f288544a.f288540a = ConnectStatusEnum.ENABLE;
            return;
        L30:
            return;
        L4:
            r102 = a.f288545a[r100.ordinal()];
            goto L5
        }
    }

    static {
    }

    @Override // com.larus.audio.audiov3.connection.ISamiConnectionPool
    public final synchronized void a() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.f288542c == false) goto L9;
        c68.b.a("SamiConnectionPool", "initCommonConfig repeat");     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L9:
        x58.a r100 = m58.h.f512130a;     // Catch: Throwable -> L22
        if (r100 != null) goto L12;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == true) goto L19;
        c68.b.e("SamiConnectionPool", "initCommonConfig not enable");     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L19:
        com.larus.audio.audiov3.task.sami.v2.flow.a r102 = this.f288541b;     // Catch: Throwable -> L22
        c68.b.a("SamiConnectionPool", "initConnect");     // Catch: Throwable -> L22
        c(r102);     // Catch: Throwable -> L22
        a0 r103 = a0.f288553a;     // Catch: Throwable -> L22
        x58.a r104 = m58.h.f512130a;     // Catch: Throwable -> L22
        r103.getClass();     // Catch: Throwable -> L22
        a0.f(r104, r102, null);     // Catch: Throwable -> L22
        this.f288542c = true;     // Catch: Throwable -> L22
        c68.b.a("SamiConnectionPool", "initCommonConfig" + b0.a(this.f288541b));     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L12:
        if (r100.f562544r != true) goto L14;
        r101 = true;
        goto L15
    }

    public final synchronized void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f288542c == false) goto L9;
        c68.b.a("SamiConnectionPool", "connectWhenUse repeat");     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        com.larus.audio.audiov3.task.sami.v2.flow.a r100 = this.f288541b;     // Catch: Throwable -> L12
        c68.b.a("SamiConnectionPool", "initConnect");     // Catch: Throwable -> L12
        c(r100);     // Catch: Throwable -> L12
        a0 r101 = a0.f288553a;     // Catch: Throwable -> L12
        x58.a r102 = m58.h.f512130a;     // Catch: Throwable -> L12
        r101.getClass();     // Catch: Throwable -> L12
        a0.f(r102, r100, null);     // Catch: Throwable -> L12
        this.f288542c = true;     // Catch: Throwable -> L12
        c68.b.a("SamiConnectionPool", "connectWhenUse" + b0.a(this.f288541b));     // Catch: Throwable -> L12
        monitor-exit(this);
    }

    public final synchronized com.larus.audio.audiov3.task.sami.v2.flow.a d() {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.f288543d == false) goto L9;
        c68.b.d("SamiConnectionPool", "[obtainCacheConnection] cached SAMICore already in use");     // Catch: Throwable -> L40
        monitor-exit(this);
        return null;
    L9:
        x58.a r100 = m58.h.f512130a;     // Catch: Throwable -> L40
        boolean r101 = false;
        if (r100 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
    L21:
        ConnectStatusEnum r103 = this.f288540a;     // Catch: Throwable -> L40
        if (r103 != ConnectStatusEnum.ENABLE) goto L27;
        c68.b.d("SamiConnectionPool", "[obtainCacheConnection] use cached SAMICore");     // Catch: Throwable -> L40
        this.f288543d = true;     // Catch: Throwable -> L40
        com.larus.audio.audiov3.task.sami.v2.flow.a r104 = this.f288541b;     // Catch: Throwable -> L40
        monitor-exit(this);
        return r104;
    L27:
        if (r103 != ConnectStatusEnum.DISABLE) goto L37;
        x58.a r105 = m58.h.f512130a;     // Catch: Throwable -> L40
        if (r105 != null) goto L31;
    L33:
        if (r101 == false) goto L37;
        disconnect();     // Catch: Throwable -> L40
        b();     // Catch: Throwable -> L40
        c68.b.d("SamiConnectionPool", "[obtainCacheConnection] connectWhenUse use cached SAMICore");     // Catch: Throwable -> L40
        this.f288543d = true;     // Catch: Throwable -> L40
        com.larus.audio.audiov3.task.sami.v2.flow.a r106 = this.f288541b;     // Catch: Throwable -> L40
        monitor-exit(this);
        return r106;
    L31:
        if (r105.f562547u != true) goto L33;
        r101 = true;
    L37:
        int r107 = c68.b.f22600a;     // Catch: Throwable -> L40
        c68.b.d("SamiConnectionPool", "[obtainCacheConnection] cached SAMICore cannot use, connection status " + this.f288540a);     // Catch: Throwable -> L40
        monitor-exit(this);
        return null;
    L17:
        if (this.f288542c == true) goto L21;
        b();     // Catch: Throwable -> L40
        c68.b.d("SamiConnectionPool", "[obtainCacheConnection] connectWhenUse use cached SAMICore");     // Catch: Throwable -> L40
        this.f288543d = true;     // Catch: Throwable -> L40
        com.larus.audio.audiov3.task.sami.v2.flow.a r108 = this.f288541b;     // Catch: Throwable -> L40
        monitor-exit(this);
        return r108;
    L12:
        if (r100.f562546t == true) goto L14;
        r102 = true;
        goto L15
    }

    @Override // com.larus.audio.audiov3.connection.ISamiConnectionPool
    public final synchronized void disconnect() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f288542c == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        boolean r100 = this.f288543d;     // Catch: Throwable -> L18
        com.larus.audio.audiov3.task.sami.v2.flow.a r101 = this.f288541b;     // Catch: Throwable -> L18
        this.f288541b = new com.larus.audio.audiov3.task.sami.v2.flow.a();     // Catch: Throwable -> L18
        this.f288542c = false;     // Catch: Throwable -> L18
        this.f288543d = false;     // Catch: Throwable -> L18
        this.f288540a = ConnectStatusEnum.DISABLE;     // Catch: Throwable -> L18
        int r102 = c68.b.f22600a;     // Catch: Throwable -> L18
        c68.b.a("SamiConnectionPool", "disConnectWhenUserLogout" + b0.a(this.f288541b));     // Catch: Throwable -> L18
        if (r100 == false) goto L21;
    L16:
        monitor-exit(this);
        return;
    L21:
        a0.f288553a.getClass();     // Catch: IllegalStateException -> L12 Throwable -> L18
        a0.m(r101);     // Catch: IllegalStateException -> L12 Throwable -> L18
        a0.g(r101);     // Catch: IllegalStateException -> L12 Throwable -> L18
    L12:
        e = move-exception;
        m58.a r103 = m58.h.f512137h;     // Catch: Throwable -> L18
        if (r103 == null) goto L16;
        r103.ensureNotReachHere(e);     // Catch: Throwable -> L18
        goto L16
    }

    public SamiConnectionPoolImpl() {
        this.f288540a = ConnectStatusEnum.DISABLE;
        this.f288541b = new com.larus.audio.audiov3.task.sami.v2.flow.a();
    }

    public final void c(com.larus.audio.audiov3.task.sami.v2.flow.a r100) {
        int r101 = c68.b.f22600a;
        c68.b.a("SamiConnectionPool", "initSamiCoreListener" + b0.a(r100));
        r100.setListener(new b(this));
    }

    public final synchronized void e(com.larus.audio.audiov3.task.sami.v2.flow.a r100, ConnectStatusEnum r101) {
        monitor-enter(this);
        if (r100 == null) goto L8;
        r100.setListener(null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L8:
        if (Intrinsics.areEqual(this.f288541b, r100) == true) goto L12;
        int r102 = c68.b.f22600a;     // Catch: Throwable -> L15
        c68.b.b("SamiConnectionPool", "recycle samiCore is not cacheSAMICore recycle " + b0.a(r100) + ", cached:" + b0.a(this.f288541b));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        this.f288540a = r101;     // Catch: Throwable -> L15
        this.f288543d = false;     // Catch: Throwable -> L15
        c(r100);     // Catch: Throwable -> L15
        int r103 = c68.b.f22600a;     // Catch: Throwable -> L15
        c68.b.a("SamiConnectionPool", "recycle samiCore, status " + r101 + b0.a(this.f288541b));     // Catch: Throwable -> L15
        monitor-exit(this);
    }
}
