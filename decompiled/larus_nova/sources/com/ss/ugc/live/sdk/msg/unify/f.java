package com.ss.ugc.live.sdk.msg.unify;

import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWConnectionInfo;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWDownlinkPacket;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventType;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchRequest;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWUplinkPacket;
import com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState;
import com.ss.ugc.live.sdk.msg.utils.MainTaskScheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONObject;
import vlc.n;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements com.ss.ugc.live.sdk.msg.utils.d, com.ss.ugc.live.sdk.msg.utils.i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.unify.network.a f458388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.utils.i f458389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.utils.i f458390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f458391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f458392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f458393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f458394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f458395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f458396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.utils.j f458397j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l f458398k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.unify.b f458399l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.utils.task.c f458400m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final kmc.d f458401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final gmc.a f458402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final UnifyWSState f458403p;

    public static final class a {
    }

    public final class b implements com.ss.ugc.live.sdk.msg.unify.network.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f458404a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f458405a;

            public a(b r100) {
                this.f458405a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r100 = ((ArrayList) this.f458405a.f458404a.f458399l.b()).iterator();     // Catch: Throwable -> L9
            L4:
                if (r100.hasNext() == false) goto L21;
                n r101 = ((com.ss.ugc.live.sdk.msg.unify.c) r100.next()).f458357b;     // Catch: Throwable -> L9
                if (r101 == null) goto L4;
                r101.a();     // Catch: Throwable -> L9
                goto L4
            L21:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.ss.ugc.live.sdk.msg.unify.f$b$b, reason: collision with other inner class name */
        public static final class RunnableC5495b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f458406a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f458407b;

            public RunnableC5495b(b r100, String r101) {
                this.f458406a = r100;
                this.f458407b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r100 = ((ArrayList) this.f458406a.f458404a.f458399l.b()).iterator();     // Catch: Throwable -> L9
            L4:
                if (r100.hasNext() == false) goto L21;
                n r101 = ((com.ss.ugc.live.sdk.msg.unify.c) r100.next()).f458357b;     // Catch: Throwable -> L9
                if (r101 == null) goto L4;
                r101.b(this.f458407b);     // Catch: Throwable -> L9
                goto L4
            L21:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f458408a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ tlc.f f458409b;

            public c(b r100, tlc.f r101) {
                this.f458408a = r100;
                this.f458409b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator r100 = ((ArrayList) this.f458408a.f458404a.f458399l.b()).iterator();     // Catch: Throwable -> L9
            L4:
                if (r100.hasNext() == false) goto L21;
                n r101 = ((com.ss.ugc.live.sdk.msg.unify.c) r100.next()).f458357b;     // Catch: Throwable -> L9
                if (r101 == null) goto L4;
                r101.d(this.f458409b);     // Catch: Throwable -> L9
                goto L4
            L21:
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.d
        public final void a() {
            com.ss.ugc.live.sdk.msg.utils.a.c(this.f458404a.f458401n, "on ws connected");
            if (this.f458404a.f458399l.d() == true) goto L5;
            this.f458404a.f458389b.removeMessages(103);
        L5:
            this.f458404a.c();
            this.f458404a.h();
            this.f458404a.k();
            MainTaskScheduler.a(new a(this));
        }

        public b(f r100) {
            this.f458404a = r100;
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.d
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            com.ss.ugc.live.sdk.msg.utils.a.c(this.f458404a.f458401n, "on ws disconnected, reason: " + r100);
            Iterator<Map.Entry<Long, com.ss.ugc.live.sdk.msg.unify.c>> r101 = this.f458404a.f458399l.f458317a.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().getValue().f458358c.d(com.ss.ugc.live.sdk.msg.unify.c.a.C5490a.f458364a);
            goto L4
        L6:
            this.f458404a.f458398k.f458430a.clear();
            f r102 = this.f458404a;
            if (r102.f458389b.hasMessages(107) == false) goto L9;
            r102.f458389b.removeMessages(107);
        L9:
            this.f458404a.c();
            f r103 = this.f458404a;
            r103.g(r103.a());
            MainTaskScheduler.a(new RunnableC5495b(this, r100));
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.network.d
        public final void d(tlc.f r100) {
            Intrinsics.checkNotNullParameter(r100, "payloadItem");
            MainTaskScheduler.a(new c(this, r100));
            if (Intrinsics.areEqual(r100.f546762c, PayloadItemType.PAYLOAD_TYPE_UMGW.getType()) == false) goto L7;
            Message r101 = this.f458404a.f458389b.obtainMessage(106, r100);
            if (r101 == null) goto L9;
            r101.sendToTarget();
            return;
        L9:
            return;
        L7:
            com.ss.ugc.live.sdk.msg.utils.a.c(this.f458404a.f458401n, "drop ws message due to payload type: " + r100.f546762c);
        }
    }

    static {
    }

    public final long a() {
        long r100 = this.f458391d;
        if (r100 > 0) goto L7;
        r100 = 1000;
    L7:
        if (this.f458396i > 0) goto L9;
        return 0;
    L9:
        return Math.min(r100, Math.max(0, System.currentTimeMillis() - this.f458396i));
    }

    public final void c() {
        if (this.f458389b.hasMessages(108) == false) goto L6;
        this.f458389b.removeMessages(108);
        return;
    }

    public final Map<String, String> f() {
        HashMap r100 = new HashMap();
        r100.put("resp_content_type", "protobuf");
        if (this.f458393f.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.put("umgw_global_ext", this.f458393f);
    L8:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final void h() {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "trigger heartbeat timer");
        if (this.f458389b.hasMessages(107) == false) goto L5;
        this.f458389b.removeMessages(107);
    L5:
        Message r100 = this.f458389b.obtainMessage(107);
        this.f458389b.sendMessageDelayed(r100, this.f458392e * 1000);
    }

    public final void k() {
        if (this.f458389b.hasMessages(110) == false) goto L5;
        this.f458389b.removeMessages(110);
    L5:
        this.f458389b.sendEmptyMessage(110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(com.ss.ugc.live.sdk.msg.utils.k r110) {
        Intrinsics.checkNotNullParameter(r110, "whatResult");
        mmc.c r100 = r110.f458483a;
        if ((r100 instanceof jmc.a) == false) goto L49;
        k();
        jmc.a r101 = (jmc.a) r110.f458483a;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r111 = r110.f458484b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, "result");
        if ((r111 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L40;
        hmc.a r112 = (hmc.a) ((com.ss.ugc.live.sdk.msg.utils.g.c) r111).f458479b;
        this.f458394g = false;
        this.f458395h = 0;
        UMGWFetchResponse r102 = r112.f486056b;
        UMGWConnectionInfo r103 = r102.connection_info;
        long r104 = 1000;
        if (r103 == null) goto L11;
        Long r105 = r103.fetch_interval;
        if (r105 == null) goto L11;
        long r106 = r105.longValue();
    L12:
        this.f458391d = r106;
        UMGWConnectionInfo r107 = r102.connection_info;
        if (r107 == null) goto L17;
        Long r108 = r107.heartbeat_duration;
        if (r108 == null) goto L17;
        long r109 = r108.longValue();
    L18:
        this.f458392e = Math.max(r109 / ((long) 1000), 10);
        String r113 = r102.umgw_global_ext;
        if (r113 == null) goto L22;
        this.f458393f = r113;
    L22:
        if (Intrinsics.areEqual(this.f458403p.f458434d.b(), UnifyWSState.c.b.f458444a) == false) goto L24;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "onUnifyHttpFetchSuccess, ws is connecting, umgw_global_ext: " + this.f458393f + ", logId: " + com.ss.ugc.live.sdk.msg.utils.c.c(r112.f486055a));
        e(r112.f486057c, false);
        j("2");
        return;
    L24:
        if (r103 == null) goto L35;
        Integer r114 = r103.fetch_type;
        if (r114 == null) goto L35;
        if (r114.intValue() != 1) goto L35;
        if (TextUtils.isEmpty(r103.wss_url) == true) goto L35;
        if (this.f458403p.e() == true) goto L35;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "onUnifyHttpFetchSuccess, use ws, umgw_global_ext: " + this.f458393f + ", logId: " + com.ss.ugc.live.sdk.msg.utils.c.c(r112.f486055a));
        e(r112.f486057c, false);
        this.f458389b.obtainMessage(104, r102).sendToTarget();
        return;
    L35:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "onUnifyHttpFetchSuccess, use http, redetermine, umgw_global_ext: " + this.f458393f + ", logId: " + com.ss.ugc.live.sdk.msg.utils.c.c(r112.f486055a));
        e(r112.f486057c, false);
        long r115 = this.f458391d;
        if (r115 <= 0) goto L38;
        r104 = r115;
    L38:
        g(r104);
        return;
    L17:
        r109 = 0;
    L11:
        r106 = 1000;
        goto L12
    L40:
        if ((r111 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L47;
        E r116 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r111).f458478b;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "onUnifyHttpFetchError: " + r116.getMessage());
        this.f458394g = false;
        int r117 = this.f458395h + 1;
        this.f458395h = r117;
        if (r117 <= 3) goto L44;
        long r118 = 5000;
    L45:
        g(r118);
        return;
    L44:
        r118 = 1000 * ((long) r117);
        goto L45
    L47:
        throw new NoWhenBranchMatchedException();
    L49:
        if ((r100 instanceof jmc.d) == false) goto L133;
        com.ss.ugc.live.sdk.msg.utils.g<?, Throwable> r119 = r110.f458484b;
        ((jmc.d) r100).getClass();
        Intrinsics.checkNotNullParameter(r119, "result");
        if ((r119 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L121;
        hmc.b r120 = (hmc.b) ((com.ss.ugc.live.sdk.msg.utils.g.c) r119).f458479b;
        tlc.f r121 = r120.f486058a;
        int r122 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        Long r123 = null;
        if (r121 == null) goto L66;
        List<com.ss.ugc.live.sdk.msg.network.d> r124 = r121.f546765f;
        if (r124 == null) goto L66;
        Iterator<T> r125 = r124.iterator();
    L58:
        if (r125.hasNext() == false) goto L62;
        Object r126 = r125.next();
        if (StringsKt.equals("umgw_global_ext", ((com.ss.ugc.live.sdk.msg.network.d) r126).f458296a, true) == false) goto L58;
    L63:
        com.ss.ugc.live.sdk.msg.network.d r127 = (com.ss.ugc.live.sdk.msg.network.d) r126;
        if (r127 == null) goto L66;
        String r128 = r127.f458297b;
    L67:
        if (r128 == null) goto L69;
        this.f458393f = r128;
    L69:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "on unify ws message decode: [event_type: " + r120.f486060c.event_type + ", umgw_global_ext: " + this.f458393f + ']');
        UMGWEventType r129 = r120.f486060c.event_type;
        if (r129 == null) goto L143;
        int r130 = g.f458410a[r129.ordinal()];
        if (r130 != 1) goto L75;
        k r131 = this.f458398k.f458430a.get(Long.valueOf(r120.f486060c.unique_id.longValue()));
        if (r131 == null) goto L81;
        UMGWUplinkPacket r132 = r131.f458428b;
    L82:
        if (r132 == null) goto L135;
        k r133 = this.f458398k.f458430a.get(Long.valueOf(r132.unique_id.longValue()));
        if (r133 == null) goto L88;
        Runnable r134 = r133.f458429c;
        if (r134 == null) goto L88;
        this.f458389b.removeCallbacks(r134);
    L88:
        l r135 = this.f458398k;
        r135.getClass();
        Intrinsics.checkNotNullParameter(r132, "uplinkPacket");
        r135.f458430a.remove(r132.unique_id);
        UMGWEventType r136 = r132.event_type;
        if (r136 != UMGWEventType.UPLINK_REGISTER) goto L107;
        UMGWDownlinkPacket r137 = r120.f486060c;
        UMGWEventData r138 = r137.event_data;
        if (r138 != null) goto L93;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "on register business packet error due to event data is null");
        return;
    L93:
        c r139 = this.f458399l.c(r138.token.longValue());
        if (r139 == null) goto L137;
        JSONObject r140 = new JSONObject();
        r140.put("service", r139.g());
        r140.put(com.alipay.sdk.m.p.e.f25671s, r139.e());
        JSONObject r141 = new JSONObject();
        r141.put("use_time", String.valueOf(System.currentTimeMillis() - r131.f458427a));
        JSONObject r142 = new JSONObject();
        Iterator r143 = ((ArrayList) r139.f()).iterator();
    L97:
        if (r143.hasNext() == false) goto L99;
        UMGWCustomData r144 = (UMGWCustomData) r143.next();
        r142.put(r144.key, r144.value);
        goto L97
    L99:
        Long r145 = r137.status_code;
        if (r145 != null) goto L103;
    L105:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "register business failed due to " + r137.status_code + " -- " + r137.status_message + " : " + r139.a());
        r140.put("is_success", false);
        r140.put("status_message", r137.status_message);
        this.f458401n.e("ttlive_im_unified_channel_biz_register", r140, r141, r142);
        r139.f458358c.d(new c.a.e(r137.unique_id.longValue()));
        return;
    L103:
        if (r145.longValue() != 0) goto L105;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "register business success: " + r139.a());
        r140.put("is_success", true);
        r140.put("status_message", "success");
        this.f458401n.e("ttlive_im_unified_channel_biz_register", r140, r141, r142);
        r139.f458358c.d(new c.a.f(r137.unique_id.longValue()));
        return;
    L137:
        return;
    L107:
        if (r136 != UMGWEventType.UPLINK_UNREGISTER) goto L140;
        UMGWDownlinkPacket r146 = r120.f486060c;
        kmc.d r147 = this.f458401n;
        StringBuilder r148 = new StringBuilder("unregister business success: [service: ");
        UMGWEventData r149 = r146.event_data;
        if (r149 == null) goto L111;
        Integer r150 = r149.service;
    L112:
        r148.append(r150);
        r148.append(", method: ");
        UMGWEventData r151 = r146.event_data;
        if (r151 == null) goto L115;
        Integer r152 = r151.method;
    L116:
        r148.append(r152);
        r148.append(", token: ");
        UMGWEventData r153 = r146.event_data;
        if (r153 == null) goto L119;
        r123 = r153.token;
    L119:
        r148.append(r123);
        r148.append(']');
        com.ss.ugc.live.sdk.msg.utils.a.c(r147, r148.toString());
        return;
    L115:
        r152 = null;
        goto L116
    L111:
        r150 = null;
        goto L112
    L140:
        return;
    L135:
        return;
    L81:
        r132 = null;
        goto L82
    L75:
        if (r130 != 2) goto L144;
        e(CollectionsKt.listOf(r120), true);
        return;
    L144:
        return;
    L143:
        return;
    L62:
        r126 = null;
    L66:
        r128 = null;
        goto L67
    L121:
        if ((r119 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L124;
        E r154 = ((com.ss.ugc.live.sdk.msg.utils.g.b) r119).f458478b;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "ws unify message decode failed due to " + r154.getMessage());
        return;
    L124:
        throw new NoWhenBranchMatchedException();
    }

    public final void d(String r100) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "disconnect ws due to ".concat(r100));
        UnifyWSState r101 = this.f458403p;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reason");
        r101.f458433c = null;
        com.ss.ugc.live.sdk.msg.unify.network.b r102 = r101.f458432b;
        if (r102 == null) goto L5;
        r102.disconnect();
    L5:
        r101.f458432b = null;
        r101.f458434d.d(new UnifyWSState.a.c(r100));
    }

    public final void g(long r100) {
        if (this.f458403p.e() == false) goto L8;
        if (this.f458399l.d() == true) goto L8;
        return;
    L8:
        if (this.f458389b.hasMessages(103) == false) goto L10;
        return;
    L10:
        c();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "redetermineFetchStrategy, delay: " + r100);
        this.f458389b.sendMessageDelayed(this.f458389b.obtainMessage(103, "1"), r100);
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.i.a
    public final void handleMsg(Message r210) {
        if (r210 == null) goto L136;
        boolean r100 = false;
        String r110 = null;
        switch(r210.what) {
            case 101: goto L112;
            case 102: goto L149;
            case 103: goto L76;
            case 104: goto L63;
            case 105: goto L58;
            case 106: goto L53;
            case 107: goto L46;
            case 108: goto L42;
            case 109: goto L149;
            case 110: goto L15;
            case 111: goto L149;
            case 112: goto L7;
            default: goto L149;
        };
    L7:
        Object r101 = r210.obj;
        if (r101 == null) goto L14;
        c r102 = (c) r101;
        if (this.f458403p.e() == false) goto L150;
        long r211 = Long.valueOf(kmc.b.f504129a.incrementAndGet()).longValue();
        UMGWUplinkPacket r103 = new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r211)).event_type(UMGWEventType.UPLINK_UNREGISTER).event_data(new UMGWEventData.Builder().token(Long.valueOf(r102.f458359d)).service(Integer.valueOf(r102.g())).method(Integer.valueOf(r102.e())).params(r102.f()).build()).build();
        tlc.f r104 = new tlc.f(r102.g(), r102.e(), PayloadItemType.PAYLOAD_TYPE_UMGW.getType(), "pb", UMGWUplinkPacket.ADAPTER.encode(r103), CollectionsKt.emptyList(), r211, r211);
        this.f458398k.a(r103, r102, null);
        this.f458403p.f(r104);
        return;
    L150:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.unify.UnifyMessageBridge");
    L15:
        Collection<c> r105 = this.f458399l.f458317a.values();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L17:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        c r109 = (c) r108;
        if (Intrinsics.areEqual(r109.h(), c.d.f.f458376a) == false) goto L21;
    L26:
        boolean r111 = true;
    L27:
        if (r111 == false) goto L17;
        r106.add(r108);
        goto L17
    L21:
        if (Intrinsics.areEqual(r109.h(), c.d.C5493c.f458373a) == true) goto L26;
        if (Intrinsics.areEqual(r109.h(), c.d.a.f458371a) == true) goto L26;
        r111 = false;
        goto L27
    L30:
        if (r106.isEmpty() == false) goto L33;
        return;
    L33:
        if (this.f458403p.e() == false) goto L39;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "try register business, ws connected");
        Iterator r112 = r106.iterator();
    L36:
        if (r112.hasNext() == false) goto L154;
        c r113 = (c) r112.next();
        long r114 = Long.valueOf(kmc.b.f504129a.incrementAndGet()).longValue();
        UMGWUplinkPacket r115 = new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r114)).event_type(UMGWEventType.UPLINK_REGISTER).event_data(new UMGWEventData.Builder().token(Long.valueOf(r113.f458359d)).service(Integer.valueOf(r113.g())).method(Integer.valueOf(r113.e())).params(r113.f()).build()).build();
        tlc.f r116 = new tlc.f(r113.g(), r113.e(), PayloadItemType.PAYLOAD_TYPE_UMGW.getType(), "pb", UMGWUplinkPacket.ADAPTER.encode(r115), CollectionsKt.emptyList(), r114, r114);
        h r117 = new h(r113, this);
        this.f458398k.a(r115, r113, r117);
        this.f458403p.f(r116);
        r113.f458358c.d(new c.a.C5491c(r114));
        this.f458389b.postDelayed(r117, 2000);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "start ws register: " + r113.a());
        goto L36
    L154:
        return;
    L39:
        if (Intrinsics.areEqual(this.f458403p.f458434d.b(), UnifyWSState.c.b.f458444a) == true) goto L138;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "try register business, ws is not connecting with disconnected");
        g(a());
        return;
    L138:
        return;
    L53:
        Object r118 = r210.obj;
        if (r118 == null) goto L57;
        jmc.e r119 = new jmc.e(this.f458399l);
        this.f458400m.b(r119, (tlc.f) r118, this.f458397j);
        return;
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.PayloadItem");
    L58:
        Object r120 = r210.obj;
        if (r120 == null) goto L62;
        d((String) r120);
        return;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L63:
        Object r121 = r210.obj;
        if (r121 == null) goto L75;
        UMGWConnectionInfo r122 = ((UMGWFetchResponse) r121).connection_info;
        if (r122 == null) goto L70;
        String r123 = r122.wss_url;
        if (r123 == null) goto L70;
    L71:
        if (r122 == null) goto L73;
        r110 = r122.wss_url_v2;
    L73:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "connect ws, url: ".concat(r123));
        HashMap r124 = new HashMap();
        r124.putAll(f());
        r124.putAll(this.f458402o.a());
        this.f458403p.c(r123, r124, new b(this), r110);
        i(3000);
        j("2");
        return;
    L70:
        r123 = "";
        goto L71
    L75:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse");
    L76:
        Object r125 = r210.obj;
        if (r125 == null) goto L111;
        String r126 = (String) r125;
        if (this.f458394g == false) goto L82;
        return;
    L82:
        if (this.f458399l.f458317a.isEmpty() == false) goto L84;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "current no business register");
        return;
    L84:
        Collection<c> r127 = this.f458399l.f458317a.values();
        ArrayList r128 = new ArrayList();
        Iterator<T> r129 = r127.iterator();
    L86:
        if (r129.hasNext() == false) goto L99;
        Object r130 = r129.next();
        c r131 = (c) r130;
        if (Intrinsics.areEqual(r131.h(), c.d.C5493c.f458373a) == false) goto L90;
    L95:
        boolean r132 = true;
    L96:
        if (r132 == false) goto L86;
        r128.add(r130);
        goto L86
    L90:
        if (Intrinsics.areEqual(r131.h(), c.d.a.f458371a) == true) goto L95;
        if (Intrinsics.areEqual(r131.h(), c.d.f.f458376a) == true) goto L95;
        r132 = false;
        goto L96
    L99:
        if (r128.isEmpty() == false) goto L101;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "no need fallback to http business, ws connect: " + this.f458403p.e());
        return;
    L101:
        HashMap r133 = new HashMap();
        r133.put("fetch_rule", r126);
        r133.putAll(this.f458402o.a());
        r133.putAll(f());
        ArrayList r134 = new ArrayList();
        Iterator r135 = r128.iterator();
    L103:
        if (r135.hasNext() == false) goto L105;
        c r136 = (c) r135.next();
        ArrayList r137 = new ArrayList();
        r137.addAll(r136.f());
        r137.addAll(r136.b());
        r134.add(new UMGWEventData.Builder().service(Integer.valueOf(r136.g())).method(Integer.valueOf(r136.e())).token(Long.valueOf(r136.f458359d)).params(r137).build());
        goto L103
    L105:
        kmc.d r138 = this.f458401n;
        StringBuilder r139 = new StringBuilder("fetch message with rule ");
        r139.append(r126);
        r139.append(", business list: ");
        ArrayList r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, 10));
        Iterator r141 = r128.iterator();
    L107:
        if (r141.hasNext() == false) goto L109;
        r140.add(((c) r141.next()).a());
        goto L107
    L109:
        r139.append(TextUtils.join(",", r140));
        com.ss.ugc.live.sdk.msg.utils.a.c(r138, r139.toString());
        UMGWFetchRequest r142 = new UMGWFetchRequest.Builder().event_data(r134).build();
        com.ss.ugc.live.sdk.msg.network.f.a r143 = new com.ss.ugc.live.sdk.msg.network.f.a();
        r143.f458310a.f458299b = this.f458402o.e().toString();
        com.ss.ugc.live.sdk.msg.network.f.a r144 = r143.query(r133);
        byte[] r145 = UMGWFetchRequest.ADAPTER.encode(r142);
        com.ss.ugc.live.sdk.msg.network.f r146 = r144.f458310a;
        r146.f458302e = r145;
        r146.f458304g = "application/x-protobuf";
        com.ss.ugc.live.sdk.msg.network.f r147 = r144.a();
        this.f458394g = true;
        this.f458400m.b(new jmc.b(this.f458399l, this.f458388a), r147, this.f458397j);
        this.f458396i = System.currentTimeMillis();
        return;
    L111:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L112:
        String r148 = this.f458402o.g().toString();
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "direct connect ws, url: " + r148);
        if (r148.length() != 0) goto L115;
        r100 = true;
    L115:
        if (r100 == false) goto L117;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "direct ws url is empty");
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "fallback to determine message fetch strategy");
        g(a());
        return;
    L117:
        HashMap r149 = new HashMap();
        r149.putAll(f());
        r149.putAll(this.f458402o.a());
        b r150 = new b(this);
        UnifyWSState r151 = this.f458403p;
        Uri r152 = this.f458402o.f();
        if (r152 == null) goto L120;
        r110 = r152.toString();
    L120:
        r151.c(r148, r149, r150, r110);
        i(3000);
        return;
    L149:
        return;
    L42:
        if (Intrinsics.areEqual(this.f458403p.f458434d.b(), UnifyWSState.c.b.f458444a) == false) goto L44;
        d("ws connect timeout");
    L44:
        g(a());
        return;
    L46:
        if (this.f458403p.e() == false) goto L152;
        long r153 = Long.valueOf(kmc.b.f504129a.incrementAndGet()).longValue();
        System.currentTimeMillis();
        List<c> r154 = this.f458399l.b();
        ArrayList r155 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r154, 10));
        Iterator r156 = ((ArrayList) r154).iterator();
    L50:
        if (r156.hasNext() == false) goto L52;
        r155.add(Long.valueOf(((c) r156.next()).f458359d));
        goto L50
    L52:
        String r157 = TextUtils.join(",", r155);
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "send heartbeat packet: seqId is " + r153 + ", registered_token_list: " + r157);
        this.f458403p.f(new tlc.f(1, 1, PayloadItemType.PAYLOAD_TYPE_UMGW.getType(), "pb", UMGWUplinkPacket.ADAPTER.encode(new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r153)).event_type(UMGWEventType.UPLINK_HB).event_data(new UMGWEventData.Builder().service(1).method(1).token(0L).params(CollectionsKt.listOf(new UMGWCustomData("registered_token_list", r157))).build()).build()), new ArrayList(), r153, r153));
        h();
        return;
    L152:
        return;
    }

    public final void i(long r100) {
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "trigger ws fallback timer");
        c();
        Message r101 = this.f458389b.obtainMessage(108);
        this.f458389b.sendMessageDelayed(r101, Math.max(1000, 3000));
    }

    public final void j(String r100) {
        if (this.f458403p.e() == false) goto L8;
        if (this.f458399l.d() == true) goto L8;
        return;
    L8:
        if (this.f458389b.hasMessages(103) == false) goto L10;
        return;
    L10:
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "start next fetch with rule 2");
        long r101 = this.f458391d;
        if (r101 > 0) goto L14;
        r101 = 1000;
    L14:
        Message r102 = this.f458389b.obtainMessage(103, "2");
        this.f458389b.sendMessageDelayed(r102, r101);
    }

    public final void e(List<hmc.b> r210, boolean r211) {
        List<hmc.b> r100 = r210;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        Iterator<T> r103 = r210.iterator();
    L13:
        if (r103.hasNext() == false) goto L75;
        hmc.b r104 = (hmc.b) r103.next();
        UMGWEventData r105 = r104.f486060c.event_data;
        if (r105 == null) goto L74;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "on packet dispatch: [service: " + r105.service + ", method: " + r105.method + ", token: " + r105.token + ']');
        c r106 = this.f458399l.c(r105.token.longValue());
        if (r106 == null) goto L74;
        if (r211 == false) goto L20;
        boolean r107 = Intrinsics.areEqual(r106.h(), c.d.C5494d.f458374a);
    L21:
        String r108 = null;
        if (r107 == true) goto L25;
        r106 = null;
    L25:
        if (r106 == null) goto L74;
        r106.f458361f.c().b(r104.f486059b);
        Intrinsics.checkNotNullParameter(r104, "packet");
        Iterator<imc.c> r109 = r106.f458356a.iterator();
    L28:
        if (r109.hasNext() == false) goto L30;
        r109.next().a(r104);
        goto L28
    L30:
        if (r211 == false) goto L74;
        if (this.f458403p.e() == false) goto L74;
        UMGWEventData r110 = r104.f486060c.event_data;
        if (r110 == null) goto L74;
        long r111 = Long.valueOf(kmc.b.f504129a.incrementAndGet()).longValue();
        c r112 = this.f458399l.c(r110.token.longValue());
        if (r112 == null) goto L39;
        List<UMGWCustomData> r113 = r112.b();
    L40:
        ArrayList r114 = new ArrayList();
        r114.addAll(r113);
        UMGWDownlinkPacket r115 = r104.f486060c;
        int r116 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        if (r115 == null) goto L56;
        UMGWEventData r117 = r115.event_data;
        if (r117 == null) goto L56;
        List<UMGWCustomData> r118 = r117.params;
        if (r118 == null) goto L56;
        Iterator<T> r119 = r118.iterator();
    L48:
        if (r119.hasNext() == false) goto L52;
        Object r120 = r119.next();
        if (StringsKt.equals("biz_seq_id", ((UMGWCustomData) r120).key, r101) == false) goto L48;
    L53:
        UMGWCustomData r121 = (UMGWCustomData) r120;
        if (r121 == null) goto L56;
        r108 = r121.value;
        goto L56
    L52:
        r120 = null;
    L56:
        if (r108 == null) goto L58;
        r114.add(new UMGWCustomData("biz_seq_id", r108));
    L58:
        String r122 = r104.a();
        if (r122 == null) goto L61;
        r114.add(new UMGWCustomData("biz_log_id", r122));
    L61:
        c r123 = this.f458399l.c(r110.token.longValue());
        if (r123 == null) goto L66;
        byte[] r124 = r123.f458361f.a();
        ByteString r125 = ByteString.of(Arrays.copyOf(r124, r124.length));
        if (r125 == null) goto L66;
    L67:
        UMGWEventData r126 = new UMGWEventData.Builder().token(r110.token).service(r110.service).method(r110.method).params(r114).payload(r125).build();
        UMGWUplinkPacket r127 = new UMGWUplinkPacket.Builder().unique_id(Long.valueOf(r111)).event_type(UMGWEventType.UPLINK_ACK).event_data(r126).build();
        int r128 = r110.service.intValue();
        int r129 = r110.method.intValue();
        String r130 = PayloadItemType.PAYLOAD_TYPE_UMGW.getType();
        byte[] r131 = UMGWUplinkPacket.ADAPTER.encode(r127);
        List r132 = CollectionsKt.emptyList();
        tlc.f r133 = r104.f486058a;
        if (r133 == null) goto L70;
        long r134 = r133.f546766g;
    L71:
        if (r133 == null) goto L73;
        r111 = r133.f546767h;
    L73:
        this.f458403p.f(new tlc.f(r128, r129, r130, "pb", r131, r132, r134, r111));
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f458401n, "send ws ack: [service: " + r126.service + ", method: " + r126.method + ", token: " + r126.token + "], log_id: " + r104.a() + ", internal_ext: " + com.ss.ugc.live.sdk.msg.utils.c.b(r114));
        goto L74
    L70:
        r134 = r111;
    L66:
        r125 = ByteString.EMPTY;
        goto L67
    L39:
        r113 = CollectionsKt.emptyList();
        goto L40
    L20:
        r107 = true;
    L74:
        r101 = true;
        goto L13
    L75:
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public f(Looper r100, com.ss.ugc.live.sdk.msg.unify.b r101, com.ss.ugc.live.sdk.msg.utils.task.c r102, kmc.d r103, gmc.a r104, UnifyWSState r105) {
        Intrinsics.checkNotNullParameter(r100, "coreQueueLooper");
        Intrinsics.checkNotNullParameter(r101, "unifyLinkManager");
        Intrinsics.checkNotNullParameter(r102, "taskScheduler");
        Intrinsics.checkNotNullParameter(r103, "unifyTracer");
        Intrinsics.checkNotNullParameter(r104, "unifyMessageConfig");
        Intrinsics.checkNotNullParameter(r105, "wsState");
        this.f458399l = r101;
        this.f458400m = r102;
        this.f458401n = r103;
        this.f458402o = r104;
        this.f458403p = r105;
        this.f458388a = r104.c();
        this.f458389b = new com.ss.ugc.live.sdk.msg.utils.i(r100, this);
        this.f458390c = new com.ss.ugc.live.sdk.msg.utils.i(r100, this);
        this.f458391d = 1000;
        this.f458392e = 10;
        this.f458393f = "";
        this.f458397j = new com.ss.ugc.live.sdk.msg.utils.j(this);
        this.f458398k = new l();
    }
}
