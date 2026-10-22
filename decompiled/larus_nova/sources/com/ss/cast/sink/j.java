package com.ss.cast.sink;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.DeviceInfoManager;
import com.byted.cast.common.DialSinkReceiver;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.Logger;
import com.byted.cast.common.PreferenceUtils;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.api.IAppCommonDataListener;
import com.byted.cast.common.api.IBindSdkInfoListener;
import com.byted.cast.common.api.ICastSink;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.multiple.IMultipleActiveControl;
import com.byted.cast.common.api.multiple.IMultipleLoader;
import com.byted.cast.common.async.ConcurrentSubject;
import com.byted.cast.common.async.Observer;
import com.byted.cast.common.auth.ICastAuth;
import com.byted.cast.common.bean.SinkDeviceInfo;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.ConfigManager;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.network.NetworkManager;
import com.byted.cast.common.network.NetworkMonitor;
import com.byted.cast.common.pin.QRPinNetWork;
import com.byted.cast.common.sink.CallbackServerInfo;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.ClientInfo;
import com.byted.cast.common.sink.IPreemptListener;
import com.byted.cast.common.sink.IServer;
import com.byted.cast.common.sink.IServerListener;
import com.byted.cast.common.sink.ServerInfo;
import com.byted.cast.common.sink.ServiceInfo;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.cast.sink.api.ByteCastSink$1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class j {
    public final Object A;
    public boolean B;
    public boolean C;
    public ScheduledExecutorService D;
    public final String E;
    public volatile boolean F;
    public NetworkMonitor G;
    public final ContextManager.CastContext H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.ss.cast.sink.a f456447J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICastSink f456448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICastSink f456449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ICastSink f456450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ICastSink f456451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ICastSink f456452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ICastSink f456453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ICastSink f456454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IServer f456455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, ICastSink> f456456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, IMultipleLoader> f456457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, IMultipleActiveControl> f456458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, CastInfo> f456459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f456460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile int f456461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile AtomicInteger f456462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f456463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ICastAuth f456464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<String> f456465r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Context f456466s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Config f456467t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public IServerListener f456468u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ByteCastSinkImpl$11 f456469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile boolean f456470w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<IBindSdkInfoListener> f456471x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, CallbackServerInfo> f456472y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ConcurrentSubject<CallbackServerInfo> f456473z;

    public class a implements Observer<CallbackServerInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f456474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f456475b;

        public a(j r100) {
            this.f456475b = r100;
            this.f456474a = false;
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2(CallbackServerInfo r100) {
            Logger.d("ByteCastSinkImpl", "call: serviceId:" + r100.serviceId + ", serverInfo:" + r100.serverInfo);
            Logger.i("ByteCastSinkImpl", "call: mCachedService.size():" + ((HashMap) this.f456475b.f456472y).size() + ", castSinkMap.size():" + ((ConcurrentHashMap) this.f456475b.f456456i).size());
            ServerInfo r101 = r100.serverInfo;
            r101.appendPortInfo(this.f456475b.f456472y);
            Logger.i("ByteCastSinkImpl", "will notify onStart");
            this.f456475b.getClass();
            IServerListener r102 = this.f456475b.f456468u;
            if (r102 == null) goto L5;
            r102.onStart(r100.serviceId, r101);
        L5:
            ContextManager.getMonitor(this.f456475b.H).sendSinkEvent(CastMonitor.BYTECAST_START_SERVER_SUCCESS, String.valueOf(r100.serviceId));
            if (((HashMap) this.f456475b.f456472y).size() != ((ConcurrentHashMap) this.f456475b.f456456i).size()) goto L16;
            this.f456474a = true;
            ((HashMap) this.f456475b.f456472y).clear();
            ConcurrentSubject<CallbackServerInfo> r103 = this.f456475b.f456473z;
            if (r103 == null) goto L11;
            r103.dispose();
            this.f456475b.f456473z.clearObservers();
        L11:
            if (this.f456475b.f456448a != null) goto L13;
            return;
        L13:
            if (TextUtils.isEmpty(DialSinkReceiver.sourceAddress) == true) goto L18;
            DialSinkReceiver.post();
            return;
        L18:
            return;
        }

        @Override // com.byted.cast.common.async.Observer
        public final void exception(Exception r100) {
            if (this.f456474a == true) goto L5;
            return;
        L5:
            if ((r100 instanceof TimeoutException) == false) goto L9;
            Logger.d("ByteCastSinkImpl", "timeout, startServer success, so no need handle it.");
            return;
        }

        @Override // com.byted.cast.common.async.Observer
        public /* bridge */ /* synthetic */ void call(CallbackServerInfo r100) {
            call2(r100);
        }
    }

    public class b implements IPreemptListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f456476a;

        @Override // com.byted.cast.common.sink.IPreemptListener
        public final /* synthetic */ void onPreempt(ClientInfo r100) {
            IPreemptListener.CC.$default$onPreempt(this, r100);
        }

        public b(j r100) {
            this.f456476a = r100;
        }

        @Override // com.byted.cast.common.sink.IPreemptListener
        public final void onPreempt(String r110, ClientInfo r111) {
            monitor-enter(this);
            TeaEventTrack.getInstance().trackSinkReceiverPreempt(r110, "start");     // Catch: Throwable -> L56
            if (r111 != null) goto L6;
        L53:
            Logger.w("ByteCastSinkImpl", "clientInfo is empty");     // Catch: Throwable -> L56
            monitor-exit(this);     // Catch: Throwable -> L56
            return;
        L6:
            if (TextUtils.isEmpty(r111.f33715ip) == false) goto L11;
            if (TextUtils.isEmpty(r111.clientID) == true) goto L53;
        L11:
            if (TextUtils.isEmpty(r111.f33715ip) == false) goto L14;
            TextUtils.isEmpty(r111.clientID);     // Catch: Throwable -> L56
        L14:
            this.f456476a.getClass();     // Catch: Throwable -> L56
            if (this.f456476a.f456461n != 1) goto L51;
            j r100 = this.f456476a;     // Catch: Throwable -> L56
            r100.getClass();     // Catch: Throwable -> L56
            Logger.i("ByteCastSinkImpl", "remoteClientInfo");     // Catch: Throwable -> L56
            Logger.d("ByteCastSinkImpl", "removeClientInfo, clientInfo: " + r111);     // Catch: Throwable -> L56
            boolean r101 = false;
            if (TextUtils.equals("ByteLink", r110) == false) goto L19;
            Logger.w("ByteCastSinkImpl", "ByteLink does not support preempt");     // Catch: Throwable -> L56
            boolean r102 = false;
        L34:
            Logger.i("ByteCastSinkImpl", "addClientInfo, notify allow execute: " + r110);     // Catch: Throwable -> L56
            Logger.d("ByteCastSinkImpl", "addClientInfo, clientInfo: " + r111);     // Catch: Throwable -> L56
            ICastSink r103 = (ICastSink) ((ConcurrentHashMap) r100.f456456i).get(r110);     // Catch: Throwable -> L56
            if (r103 == null) goto L37;
            r101 = r103.notifyPreempt(true, r111);     // Catch: Throwable -> L56
        L37:
            if (r101 == false) goto L39;
            TeaEventTrack.getInstance().trackSinkReceiverPreempt(r110, "success");     // Catch: Throwable -> L56
        L41:
            if (TextUtils.equals("ByteLink", r110) == true) goto L49;
            if (r101 == false) goto L46;
            if (r102 == true) goto L46;
            r100.f456462o.incrementAndGet();     // Catch: Throwable -> L56
        L46:
            if (r101 == true) goto L49;
            if (r102 == false) goto L49;
            r100.f456462o.decrementAndGet();     // Catch: Throwable -> L56
        L49:
            monitor-exit(this);     // Catch: Throwable -> L56
            return;
        L39:
            TeaEventTrack.getInstance().trackSinkReceiverPreempt(r110, "failure");     // Catch: Throwable -> L56
            goto L41
        L19:
            Iterator r104 = ((ConcurrentHashMap) r100.f456456i).keySet().iterator();     // Catch: Throwable -> L56
            r102 = false;
        L21:
            if (r104.hasNext() == false) goto L34;
            String r105 = (String) r104.next();     // Catch: Throwable -> L56
            ICastSink r106 = (ICastSink) ((ConcurrentHashMap) r100.f456456i).get(r105);     // Catch: Throwable -> L56
            Logger.i("ByteCastSinkImpl", "notify not allow execute:" + r105);     // Catch: Throwable -> L56
            if (r106 == null) goto L21;
            if (TextUtils.equals("ByteLink", r110) == false) goto L30;
            if (TextUtils.equals(r110, r105) == true) goto L30;
            r106.notifyPreempt(false, r111);     // Catch: Throwable -> L56
        L30:
            if (TextUtils.equals("ByteLink", r110) == true) goto L21;
            if (r106.notifyPreempt(false, r111) == false) goto L21;
            r102 = true;
            goto L21
        L51:
            this.f456476a.getClass();     // Catch: Throwable -> L56
            throw null;     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            throw th;
        }
    }

    public final void c() {
        if (this.f456448a == null) goto L8;
        if (this.f456465r.contains("BDLink") == true) goto L8;
        ((HashMap) this.f456458k).remove("BDLink");
        this.f456448a.destroy();
        this.f456448a = null;
    L8:
        if (this.f456450c == null) goto L13;
        if (this.f456465r.contains("BDAirPlay") == true) goto L13;
        ((HashMap) this.f456458k).remove("BDAirPlay");
        this.f456450c.destroy();
        this.f456450c = null;
    L13:
        if (this.f456449b == null) goto L18;
        if (this.f456465r.contains("BDDLNA") == true) goto L18;
        ((HashMap) this.f456458k).remove("BDDLNA");
        this.f456449b.destroy();
        this.f456449b = null;
    L18:
        if (this.f456451d == null) goto L23;
        if (this.f456465r.contains("ByteLink") == true) goto L23;
        ((HashMap) this.f456458k).remove("ByteLink");
        this.f456451d.destroy();
        this.f456451d = null;
    L23:
        if (this.f456452e == null) goto L32;
        if (this.f456465r.contains("LeLink") == true) goto L27;
    L30:
        ((HashMap) this.f456458k).remove("LeLink");
        this.f456452e.destroy();
        this.f456452e = null;
        goto L32
    L27:
        if (TextUtils.isEmpty(this.f456467t.getLelinkAppId()) == false) goto L30;
        if (TextUtils.isEmpty(this.f456467t.getLelinkAppSecret()) == false) goto L30;
    L32:
        if (this.f456453f == null) goto L37;
        if (this.f456465r.contains("BDCloud") == true) goto L37;
        ((HashMap) this.f456458k).remove("BDCloud");
        this.f456453f.destroy();
        this.f456453f = null;
    L37:
        if (this.f456454g != null) goto L39;
        return;
    L39:
        if (this.f456465r.contains("ChromeCast") == true) goto L43;
        ((HashMap) this.f456458k).remove("ChromeCast");
        this.f456454g.destroy();
        this.f456454g = null;
        return;
    }

    public final void d() {
        Object r100 = this.A;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f456473z != null) goto L8;
        k();     // Catch: Throwable -> L12
    L8:
        if (this.f456473z.getObserverSize() != 0) goto L10;
        this.f456473z.setTimeout(20, TimeUnit.SECONDS).addObserver(new a(this));     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    public final void f() {
        JSONObject r100 = new JSONObject();
        r100.put(Constants.SINK_LINK_VERSION_KEY, "7.30.1.12");     // Catch: JSONException -> L20
        r100.put(Constants.SINK_BDLINK_VERSION_KEY, "7.30.1.12");     // Catch: JSONException -> L20
        r100.put(Constants.SINK_BDDLNA_VERSION_KEY, "7.30.1.12");     // Catch: JSONException -> L20
        ICastSink r101 = this.f456451d;     // Catch: JSONException -> L20
        if (r101 == null) goto L6;
        r100.put(Constants.SINK_BYTELINK_VERSION_KEY, r101.getVersion());     // Catch: JSONException -> L20
    L6:
        ICastSink r102 = this.f456450c;     // Catch: JSONException -> L20
        if (r102 == null) goto L9;
        r100.put(Constants.SINK_AIRPLAY_VERSION_KEY, r102.getVersion());     // Catch: JSONException -> L20
    L9:
        ICastSink r103 = this.f456452e;     // Catch: JSONException -> L20
        if (r103 == null) goto L12;
        r100.put(Constants.SINK_LELINK_VERSION_KEY, r103.getVersion());     // Catch: JSONException -> L20
    L12:
        ICastSink r104 = this.f456453f;     // Catch: JSONException -> L20
        if (r104 == null) goto L16;
        r100.put("com.ss.cast:sink-bdcloud", r104.getVersion());     // Catch: JSONException -> L20
    L16:
        ICastSink r105 = this.f456454g;     // Catch: JSONException -> L20
        if (r105 == null) goto L22;
        r100.put("com.ss.cast:sink-bdcloud", r105.getVersion());     // Catch: JSONException -> L20
    L22:
        Logger.i("ByteCastSinkImpl", "protocols version:" + r100.toString());
        ContextManager.getMonitor(this.H).sendSinkEvent(CastMonitor.BYTECAST_SINK_GET_PROTOCOLS_VERSION, r100.toString());
        r100.toString();
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public final void h() {
        StringBuffer r100 = new StringBuffer();
        if (this.f456465r != null) goto L6;
        this.f456465r = new CopyOnWriteArrayList();
    L6:
        if (this.f456465r.size() <= 0) goto L68;
        Iterator<String> r101 = this.f456465r.iterator();
    L9:
        if (r101.hasNext() == false) goto L67;
        String r102 = r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        r102.getClass();
        byte r110 = -1;
        switch(r102.hashCode()) {
            case -2023507661: goto L41;
            case -1803213502: goto L37;
            case -108862212: goto L33;
            case 457686803: goto L29;
            case 483315961: goto L25;
            case 1954424701: goto L21;
            case 1954691932: goto L17;
            default: goto L44;
        };
    L44:
        switch(r110) {
            case 0: goto L64;
            case 1: goto L62;
            case 2: goto L58;
            case 3: goto L55;
            case 4: goto L52;
            case 5: goto L49;
            case 6: goto L46;
            default: goto L9;
        };
    L46:
        ICastSink r103 = this.f456448a;
        if (r103 == null) goto L9;
        ((ConcurrentHashMap) this.f456456i).put("BDLink", r103);
        r100.append("BDLink,");
        goto L9
    L49:
        ICastSink r104 = this.f456449b;
        if (r104 == null) goto L9;
        ((ConcurrentHashMap) this.f456456i).put("BDDLNA", r104);
        r100.append("BDDLNA,");
        goto L9
    L52:
        ICastSink r105 = this.f456454g;
        if (r105 == null) goto L9;
        ((ConcurrentHashMap) this.f456456i).put("ChromeCast", r105);
        r100.append("ChromeCast,");
        goto L9
    L55:
        ICastSink r106 = this.f456453f;
        if (r106 == null) goto L9;
        ((ConcurrentHashMap) this.f456456i).put("BDCloud", r106);
        r100.append("BDCloud,");
        goto L9
    L58:
        ICastSink r107 = this.f456450c;
        if (r107 == null) goto L9;
        ((ConcurrentHashMap) this.f456456i).put("BDAirPlay", r107);
        r100.append("BDAirPlay,");
        goto L9
    L62:
        if (this.f456451d == null) goto L9;
        Logger.i("ByteCastSinkImpl", "castSinkMap put BYTELINK");
        ((ConcurrentHashMap) this.f456456i).put("ByteLink", this.f456451d);
        r100.append("ByteLink,");
        goto L9
    L64:
        ICastSink r108 = this.f456452e;
        if (r108 == null) goto L9;
        ((ConcurrentHashMap) this.f456456i).put("LeLink", r108);
        r100.append("LeLink,");
        goto L9
    L17:
        if (r102.equals("BDLink") == false) goto L44;
        r110 = 6;
        goto L44
    L21:
        if (r102.equals("BDDLNA") == false) goto L44;
        r110 = 5;
        goto L44
    L25:
        if (r102.equals("ChromeCast") == false) goto L44;
        r110 = 4;
        goto L44
    L29:
        if (r102.equals("BDCloud") == false) goto L44;
        r110 = 3;
        goto L44
    L33:
        if (r102.equals("BDAirPlay") == false) goto L44;
        r110 = 2;
        goto L44
    L37:
        if (r102.equals("ByteLink") == false) goto L44;
        r110 = 1;
        goto L44
    L41:
        if (r102.equals("LeLink") == false) goto L44;
        r110 = 0;
        goto L44
    L12:
        Logger.w("ByteCastSinkImpl", "castSinkMap:handleModulePriorityImpl protocol empty, protocols:" + this.f456465r);
        goto L9
    L67:
        ContextManager.getMonitor(this.H).setProtocols(this.f456465r.toString());
    L68:
        IServer r109 = this.f456455h;
        if (r109 == null) goto L71;
        r109.addProtocols(this.f456465r);
    L71:
        int r111 = r100.length();
        if (r111 <= 0) goto L74;
        r100 = new StringBuffer(r100.substring(0, r111 - 1));
    L74:
        Logger.i("ByteCastSinkImpl", "protocols enabled:" + r100);
    }

    public final void k() {
        Object r100 = this.A;
        monitor-enter(r100);
        this.f456473z = new ConcurrentSubject();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.cast.sink.a] */
    public j(ContextManager.CastContext r110) {
        ConcurrentHashMap r111 = new ConcurrentHashMap();
        this.f456456i = r111;
        HashMap r112 = new HashMap();
        this.f456457j = r112;
        HashMap r113 = new HashMap();
        this.f456458k = r113;
        this.f456459l = new HashMap();
        this.f456460m = new l();
        this.f456461n = 1;
        this.f456462o = new AtomicInteger(0);
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        b r114 = new b(this);
        this.f456463p = r114;
        this.f456465r = new CopyOnWriteArrayList();
        this.f456470w = false;
        this.f456471x = new ArrayList();
        this.f456472y = new HashMap();
        this.A = new Object();
        this.B = false;
        this.E = "0";
        this.F = false;
        this.I = null;
        this.f456447J = new com.ss.cast.sink.a(this);
        new QRPinNetWork();
        this.H = r110;
        ContextManager.getConfigManager(r110);
        ICastSink r100 = (ICastSink) a("com.byted.link.sink.impl.BDLinkSinkWrapper").newInstance();     // Catch: Throwable -> L46
        this.f456448a = r100;     // Catch: Throwable -> L46
        r100.setPreemptListener(r114);     // Catch: Throwable -> L46
        r111.put("BDLink", this.f456448a);     // Catch: Throwable -> L46
        r112.put("BDLink", this.f456448a.getMultipleLoader());     // Catch: Throwable -> L46
        r113.put("BDLink", this.f456448a.getMultipleActiveControl());     // Catch: Throwable -> L46
        Logger.i("ByteCastSinkImpl", "BDLinkSinkWrapper:" + this.f456448a);     // Catch: Throwable -> L46
    L51:
        ICastSink r101 = (ICastSink) a("com.byted.dlna.sink.impl.BDDLNASinkWrapper").newInstance();     // Catch: Throwable -> L47
        this.f456449b = r101;     // Catch: Throwable -> L47
        r101.setPreemptListener(this.f456463p);     // Catch: Throwable -> L47
        ((ConcurrentHashMap) this.f456456i).put("BDDLNA", this.f456449b);     // Catch: Throwable -> L47
        ((HashMap) this.f456457j).put("BDDLNA", this.f456449b.getMultipleLoader());     // Catch: Throwable -> L47
        ((HashMap) this.f456458k).put("BDDLNA", this.f456449b.getMultipleActiveControl());     // Catch: Throwable -> L47
        Logger.i("ByteCastSinkImpl", "BDDLNASinkWrapper:" + this.f456449b);     // Catch: Throwable -> L47
    L59:
        a("com.hpplay.sdk.sink.api.LelinkCast");     // Catch: Throwable -> L48
        ICastSink r102 = (ICastSink) a("com.ss.lelink.sink.LelinkSinkWrapper").newInstance();     // Catch: Throwable -> L48
        this.f456452e = r102;     // Catch: Throwable -> L48
        r102.setPreemptListener(this.f456463p);     // Catch: Throwable -> L48
        ((ConcurrentHashMap) this.f456456i).put("LeLink", this.f456452e);     // Catch: Throwable -> L48
        ((HashMap) this.f456457j).put("LeLink", this.f456452e.getMultipleLoader());     // Catch: Throwable -> L48
        ((HashMap) this.f456458k).put("LeLink", this.f456452e.getMultipleActiveControl());     // Catch: Throwable -> L48
    L53:
        ICastSink r103 = (ICastSink) a("com.byted.airplay.BDAirPlaySinkWrapper").newInstance();     // Catch: Throwable -> L49
        this.f456450c = r103;     // Catch: Throwable -> L49
        r103.setPreemptListener(this.f456463p);     // Catch: Throwable -> L49
        ((ConcurrentHashMap) this.f456456i).put("BDAirPlay", this.f456450c);     // Catch: Throwable -> L49
        ((HashMap) this.f456457j).put("BDAirPlay", this.f456450c.getMultipleLoader());     // Catch: Throwable -> L49
        ((HashMap) this.f456458k).put("BDAirPlay", this.f456450c.getMultipleActiveControl());     // Catch: Throwable -> L49
    L63:
        ICastSink r104 = (ICastSink) a("com.byted.cast.sink.api.BytelinkSinkWrapper").newInstance();     // Catch: Throwable -> L50
        this.f456451d = r104;     // Catch: Throwable -> L50
        r104.setPreemptListener(this.f456463p);     // Catch: Throwable -> L50
        ((ConcurrentHashMap) this.f456456i).put("ByteLink", this.f456451d);     // Catch: Throwable -> L50
        Logger.i("ByteCastSinkImpl", "castSinkMap put BYTELINK");     // Catch: Throwable -> L50
        ((HashMap) this.f456457j).put("ByteLink", this.f456451d.getMultipleLoader());     // Catch: Throwable -> L50
        ((HashMap) this.f456458k).put("ByteLink", this.f456451d.getMultipleActiveControl());     // Catch: Throwable -> L50
    L61:
        ICastSink r105 = (ICastSink) a("com.byted.cloud.sink.impl.BDCloudSinkWrapper").newInstance();     // Catch: Throwable -> L13
        this.f456453f = r105;     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        r105.addCastIdListener(this.f456447J);     // Catch: Throwable -> L13
    L11:
        this.f456453f.setPreemptListener(this.f456463p);     // Catch: Throwable -> L13
        ((ConcurrentHashMap) this.f456456i).put("BDCloud", this.f456453f);     // Catch: Throwable -> L13
        ((HashMap) this.f456457j).put("BDCloud", this.f456453f.getMultipleLoader());     // Catch: Throwable -> L13
        ((HashMap) this.f456458k).put("BDCloud", this.f456453f.getMultipleActiveControl());     // Catch: Throwable -> L13
    L55:
        ICastSink r106 = (ICastSink) a("com.ss.chromecast.sink.impl.ChromeCastSinkWrapper").newInstance();     // Catch: Throwable -> L17
        this.f456454g = r106;     // Catch: Throwable -> L17
        r106.setPreemptListener(this.f456463p);     // Catch: Throwable -> L17
        ((ConcurrentHashMap) this.f456456i).put("ChromeCast", this.f456454g);     // Catch: Throwable -> L17
        ((HashMap) this.f456457j).put("ChromeCast", this.f456454g.getMultipleLoader());     // Catch: Throwable -> L17
        ((HashMap) this.f456458k).put("ChromeCast", this.f456454g.getMultipleActiveControl());     // Catch: Throwable -> L17
    L65:
        IServer r107 = (IServer) a("com.ss.cast.discovery.ServerProxy").getConstructor(new Class[]{ICastSink.class, ICastSink.class}).newInstance(new Object[]{this.f456448a, this.f456451d});     // Catch: Throwable -> L21
        this.f456455h = r107;     // Catch: Throwable -> L21
        CastLogger.getInstance().d("ByteCastSinkImpl", "mServerProxy is " + r107);     // Catch: Throwable -> L21
    L23:
        StringBuilder r108 = new StringBuilder("There is ");
        if (this.f456448a == null) goto L27;
        r108.append("BDLink ");
    L27:
        if (this.f456449b == null) goto L30;
        r108.append("BDDLNA ");
    L30:
        if (this.f456451d == null) goto L33;
        r108.append("ByteLink ");
    L33:
        if (this.f456450c == null) goto L36;
        r108.append("BDAirPlay ");
    L36:
        if (this.f456452e == null) goto L39;
        r108.append("LeLink ");
    L39:
        if (this.f456453f == null) goto L42;
        r108.append("BDCloud ");
    L42:
        if (this.f456454g == null) goto L44;
        r108.append("ChromeCast ");
    L44:
        r108.append("in the system.");
        Logger.i("ByteCastSinkImpl", r108.toString());
        return;
    L21:
        th = move-exception;
        CastLogger.getInstance().d("ByteCastSinkImpl", "mServerProxy reflect exception " + th);
    L17:
        th = move-exception;
        th.getMessage();
    L13:
        th = move-exception;
        th.getMessage();
        goto L55
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public final void e(Context r100) {
        SinkDeviceInfo r101 = new SinkDeviceInfo();
        r101.name = this.f456467t.getServiceName();
        r101.version = "7.30.1.12";
        r101.deviceId = this.f456467t.getDeviceId();
        r101.appId = this.f456467t.getAppId();
        r101.userId = this.f456467t.getUserId();
        r101.sessionId = TeaEventTrack.getInstance().sessionID;
        r101.castId = this.I;
        r101.isSupportPlayList = true;
        ICastSink r102 = this.f456448a;
        if (r102 == null) goto L10;
        ServiceInfo r103 = r102.getServiceInfo();
        if (r103 == null) goto L10;
        int r104 = r103.port;
        if (r104 > 0) goto L9;
        r104 = Constants.BDLINK_DEFAULT_PORT;
    L9:
        r101.port = r104;
        r101.f33707ip = r103.f33716ip;
    L10:
        ICastSink r105 = this.f456451d;
        if (r105 == null) goto L18;
        ServiceInfo r106 = r105.getServiceInfo();
        Logger.d("ByteCastSinkImpl", "requestQRPingInfo  bytelinkSink.getServiceInfo():" + r106);
        if (r106 == null) goto L18;
        int r107 = r106.portMirror;
        if (r107 > 0) goto L17;
        r107 = 3230;
    L17:
        r101.portMirror = r107;
    L18:
        DeviceInfoManager.getInstance().saveLocalSinkDeviceInfo(r100, r101);
    }

    public final void g(Config r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = r100.isEnableDebug();
        Logger.i("ByteCastSinkImpl", "Is debug open? " + r101);
        Constants.isDebugMode = r101;
        Logger.setEnable(r101);
        String r102 = r100.getLocalProtocols();
        if (TextUtils.isEmpty(r102) == true) goto L19;
        Logger.i("ByteCastSinkImpl", "parseProtocols: " + r102);
        if (this.f456465r != null) goto L9;
        this.f456465r = new CopyOnWriteArrayList();
    L9:
        ((CopyOnWriteArrayList) this.f456465r).clear();
        if (TextUtils.isEmpty(r102) == true) goto L19;
        String[] r103 = r102.split(",");
        if (r103 == null) goto L19;
        if (r103.length < 1) goto L19;
        ((CopyOnWriteArrayList) this.f456465r).addAll(Arrays.asList(r103));
        Logger.i("ByteCastSinkImpl", "parseProtocols: protocols: " + this.f456465r);
    L19:
        if (r100.isInitialModeBind() == true) goto L48;
        ILogger r104 = r100.getLogger();
        if (r104 == null) goto L24;
        Logger.setLogger(r104);
    L24:
        IAppCommonDataListener r105 = r100.getCommonDataListener();
        if (r105 == null) goto L29;
        ContextManager.getMonitor(this.H).setAppCommonDataListener(r105);
        TeaEventTrack.getInstance().setAppCommonDataListener(r105);
    L29:
        if (this.f456470w == false) goto L31;
        return;
    L31:
        if (r100.getBindSdkInfoListeners() != null) goto L33;
        return;
    L33:
        if (r100.getBindSdkInfoListeners().size() <= 0) goto L51;
        Iterator<IBindSdkInfoListener> r106 = r100.getBindSdkInfoListeners().iterator();
    L36:
        if (r106.hasNext() == false) goto L41;
        IBindSdkInfoListener r107 = r106.next();
        if (r107 == null) goto L36;
        ((ArrayList) this.f456471x).add(new f(this, r107));
        goto L36
    L41:
        this.f456470w = true;
        return;
    L51:
        return;
    }

    public final void b(Config r100, ByteCastSink$1 r101) {
        Logger.i("ByteCastSinkImpl", "authByLicense: projectId: " + r100.getProjectId());
        if (this.f456464q != null) goto L5;
        this.f456464q = ContextManager.getAuthManager(this.H);
    L5:
        this.f456464q.init(r100.getProjectId());
        this.f456464q.verifyLicense(r100.getLicensePath(), new i(this, r101));
    }

    public final void l(Context r100, ByteCastSink$1 r101) {
        Logger.i("ByteCastSinkImpl", "setAuthByLocalOption");
        c();
        h();
        Logger.i("ByteCastSinkImpl", "set protocols by local protocols: " + this.f456465r);
        ContextManager.getMonitor(this.H).sendSinkEvent(CastMonitor.BYTECAST_SINK_AUTH_LOCAL, "pkg:" + r100.getPackageName() + ",protocols:" + this.f456465r);
        this.C = true;
        this.f456460m.execute(new g(this, r101));
    }

    public final synchronized void i(Context r110, final Config r111, ByteCastSink$1 r112) {
        monitor-enter(this);
        Constants.attachAppContext(r110);     // Catch: Throwable -> L38
        this.f456466s = r110;     // Catch: Throwable -> L38
        if (r111 != null) goto L9;
        r112.onError(IInitListener.ERROR_CODE_EMPTY_CONFIG, IInitListener.ERROR_MSG_EMPTY_CONFIG);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L9:
        CastLogger.getInstance().i("ByteCastSinkImpl", "init: deviceId: " + r111.getDeviceId() + ", originDeviceId: " + r111.getOriginDeviceId() + ", sinkVersion: 7.30.1.12");     // Catch: Throwable -> L38
        ConfigManager.getInstance().init(r111);     // Catch: Throwable -> L38
        ContextManager.getConfigManager(this.H).init(r111);     // Catch: Throwable -> L38
        ContextManager.getMonitor(null).initSessionID(r111.getDeviceId(), r111.getAppId(), r111.getProjectId(), Constants.ROLE_SINK);     // Catch: Throwable -> L38
        ContextManager.getMonitor(null).init(r110, r111.getDeviceId(), r111.getMonitor());     // Catch: Throwable -> L38
        TeaEventTrack.getInstance().initSessionID(r111.getProjectId());     // Catch: Throwable -> L38
        ContextManager.getMonitor(null).sendByteCastAuthEvent("start", -1);     // Catch: Throwable -> L38
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_AUTH, new Map[]{new ByteCastSinkImpl$1(this)});     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r111.getProjectId()) == false) goto L14;
        r112.onError(IInitListener.ERROR_CODE_INVALID_PARAMS, IInitListener.ERROR_MSG_INVALID_PARAMS);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L14:
        NetworkManager.start(Constants.sAppContext, this.H);     // Catch: Throwable -> L38
        g(r111);     // Catch: Throwable -> L38
        if (TextUtils.equals(this.E, "1") == true) goto L17;
    L19:
        this.f456467t = r111;     // Catch: Throwable -> L38
        new QRPinNetWork(r111.getNetAdapter());     // Catch: Throwable -> L38
        d();     // Catch: Throwable -> L38
        j(r110, r111, r112);     // Catch: Throwable -> L38
        ((ConcurrentHashMap) this.f456456i).clear();     // Catch: Throwable -> L38
        if (r111.isInitialModeBind() == false) goto L22;
        Logger.i("ByteCastSinkImpl", "local verify");     // Catch: Throwable -> L38
        l(r110, r112);     // Catch: Throwable -> L38
    L25:
        IServer r113 = this.f456455h;     // Catch: Throwable -> L38
        if (r113 == null) goto L29;
        r113.init(r110, r111);     // Catch: Throwable -> L38
    L29:
        if (this.G != null) goto L31;
        this.G = new NetworkMonitor(this.H, 1, 300, new k());     // Catch: Throwable -> L38
    L31:
        this.G.start();     // Catch: Throwable -> L38
        e(this.f456466s);     // Catch: Throwable -> L38
        if (this.C == false) goto L35;
        Logger.d("ByteCastSinkImpl", "requestQRPingInfo ");     // Catch: Throwable -> L38
    L35:
        f();     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L22:
        Logger.i("ByteCastSinkImpl", "license verify");     // Catch: Throwable -> L38
        b(r111, r112);     // Catch: Throwable -> L38
        Logger.i("ByteCastSinkImpl", "pullRemoteConfig: isByteUserToB=" + PreferenceUtils.isByteUserToB());     // Catch: Throwable -> L38
        if (PreferenceUtils.isByteUserToB() == false) goto L25;
        Dispatcher.getInstance().enqueue(new c(this, r111));     // Catch: Throwable -> L38
        goto L25
    L17:
        if (this.D != null) goto L19;
        ScheduledExecutorService r100 = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("ByteCastSinkImpl"));     // Catch: Throwable -> L38
        this.D = r100;     // Catch: Throwable -> L38
        r100.scheduleAtFixedRate(new com.ss.cast.sink.b(), 0, 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    public final void j(Context r100, Config r101, ByteCastSink$1 r102) {
        String r103 = r101.getLocalProtocols();
        if (TextUtils.isEmpty(r103) == false) goto L5;
        return;
    L5:
        if (this.f456448a == null) goto L10;
        if (r103.contains("BDLink") == false) goto L10;
        this.f456448a.init(r100, r101, r102);
    L10:
        if (this.f456450c == null) goto L15;
        if (r103.contains("BDAirPlay") == false) goto L15;
        this.f456450c.init(r100, r101, r102);
    L15:
        if (this.f456449b == null) goto L20;
        if (r103.contains("BDDLNA") == false) goto L20;
        this.f456449b.init(r100, r101, r102);
    L20:
        if (this.f456451d == null) goto L25;
        if (r103.contains("ByteLink") == false) goto L25;
        this.f456451d.init(r100, r101, r102);
    L25:
        if (this.f456452e == null) goto L34;
        if (r103.contains("LeLink") == false) goto L34;
        if (TextUtils.isEmpty(r101.getLelinkAppId()) == true) goto L34;
        if (TextUtils.isEmpty(r101.getLelinkAppSecret()) == true) goto L34;
        this.f456452e.init(r100, r101, r102);
    L34:
        if (this.f456453f == null) goto L39;
        if (r103.contains("BDCloud") == false) goto L39;
        this.f456453f.init(r100, r101, r102);
    L39:
        if (this.f456454g != null) goto L41;
        return;
    L41:
        if (r103.contains("ChromeCast") == false) goto L46;
        this.f456454g.init(r100, r101, r102);
        return;
    }
}
