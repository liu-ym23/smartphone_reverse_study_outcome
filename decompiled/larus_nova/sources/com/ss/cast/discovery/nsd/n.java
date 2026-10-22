package com.ss.cast.discovery.nsd;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.ICastSink;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.IServerListener;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.sink.IServer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.cast.discovery.mdns.INsdHelper;
import com.ss.cast.discovery.mdns.NsdListener;
import com.ss.cast.discovery.mdns.NsdService;
import com.ss.cast.discovery.mdns.NsdType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class n implements IServer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public INsdHelper f456391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f456392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f456393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f456394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f456395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IServerListener f456396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f456397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f456398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ILibraryLoader f456399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f456400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ICastSink f456401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ICastSink f456402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f456403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f456404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f456405o;

    public class a implements NsdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f456406a;

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdDiscoveryFinished() {
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdServiceFound(NsdService r100) {
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdServiceLost(NsdService r100) {
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdServiceResolved(NsdService r100) {
        }

        public a(n r100) {
            this.f456406a = r100;
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdRegistered(NsdService r100) {
            Logger.i("NsdServer", "onNsdRegistered: " + r100);
            if (r100 != null) goto L5;
            String r101 = "";
        L6:
            Logger.i("NsdServer", "mServiceName is " + this.f456406a.f456394d + ", registerName is " + r101);
            if (TextUtils.isEmpty(this.f456406a.f456394d) == false) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty(r101) == false) goto L11;
            return;
        L11:
            if (TextUtils.equals(this.f456406a.f456394d, r101) == false) goto L13;
            return;
        L13:
            if (r101.startsWith(this.f456406a.f456394d) == false) goto L21;
            n r102 = this.f456406a;
            r102.f456394d = r101;
            ICastSink r103 = r102.f456401k;
            if (r103 == null) goto L22;
            r103.upDateServerName(r101);
            return;
        L22:
            return;
        L21:
            return;
        L5:
            r101 = r100.getName();
            goto L6
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdUnRegistered(NsdService r100) {
            Logger.i("NsdServer", "onNsdUnRegistered: " + r100);
        }

        @Override // com.ss.cast.discovery.mdns.NsdListener
        public final void onNsdError(String r100, int r101, String r102) {
            IServerListener r103 = this.f456406a.f456396f;
            if (r103 == null) goto L6;
            r103.onError(5, 10009, r101);
            return;
        }
    }

    @Override // com.byted.cast.common.sink.IServer
    public final /* synthetic */ void deInit() {
        IServer.CC.$default$deInit(this);
    }

    @Override // com.byted.cast.common.sink.IServer
    public final synchronized void stopServer() {
        monitor-enter(this);
        Logger.i("NsdServer", "stopServer");     // Catch: Throwable -> L6
        this.f456403m.post(new m(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void reStartServer() {
        stopServer();
        startServer(this.f456394d, this.f456397g);
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void addProtocols(List<String> r100) {
        ((ArrayList) this.f456397g).clear();
        ((ArrayList) this.f456397g).addAll(r100);
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void setPrivateChannel(String r100) {
        Logger.i("NsdServer", "setPrivateChannel, privateChannel:" + r100);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.f456393c = String.format(NsdType.PRIVATE, new Object[]{r100});
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void setServerListener(IServerListener r100) {
        this.f456396f = r100;
    }

    public n(ICastSink r100, ICastSink r101) {
        this.f456393c = NsdType.BDLINK;
        this.f456395e = false;
        this.f456397g = new ArrayList();
        this.f456400j = 3230;
        this.f456405o = new a(this);
        this.f456401k = r100;
        this.f456402l = r101;
        this.f456403m = new Handler(Dispatcher.getInstance().getByteCastThreadLooper());
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void init(Context r100, Config r101) {
        this.f456392b = r100;
        if (r101 == null) goto L21;
        this.f456395e = r101.isEnableDebug();
        setPrivateChannel(r101.getPrivateChannel());
        Map<String, String> r102 = r101.getIdentityMap();
        if (r102 != null) goto L7;
    L17:
        String r103 = "";
    L18:
        this.f456404n = r103;
        return;
    L7:
        if (r102.isEmpty() == true) goto L17;
        StringBuilder r104 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r105 = r102.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, String> r106 = r105.next();
        r104.append(r106.getKey());
        r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r104.append(r106.getValue());
        r104.append(',');
        goto L11
    L14:
        if (r104.length() <= 0) goto L16;
        r104.deleteCharAt(r104.length() - 1);
    L16:
        r103 = r104.toString();
        goto L18
    }

    @Override // com.byted.cast.common.sink.IServer
    public final void setOption(int r100, Object... r101) {
        if (r100 != 10093) goto L5;
        Object r102 = r101[0];
        if ((r102 instanceof Integer) == false) goto L16;
        this.f456400j = ((Integer) r102).intValue();
        Logger.i("NsdServer", "OPTION_SOURCE_INVITE_PORT:" + this.f456400j);
        return;
    L16:
        return;
    L5:
        if (r100 != 100041) goto L17;
        Object r103 = r101[0];
        if ((r103 instanceof ILibraryLoader) == false) goto L14;
        this.f456399i = (ILibraryLoader) r103;
        Logger.i("NsdServer", "OPTION_SET_LIBRARY_LOADER:" + this.f456399i);
        return;
    L14:
        return;
    }

    @Override // com.byted.cast.common.sink.IServer
    public final synchronized void startServer(final String r100, final List<String> r101) {
        monitor-enter(this);
        Logger.i("NsdServer", "startServer: " + r100);     // Catch: Throwable -> L7
        this.f456403m.post(new l(this, r100, r101));     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
