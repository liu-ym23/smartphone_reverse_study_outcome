package com.ss.videoarch.liveplayer;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.videoarch.liveplayer.log.LiveError;
import com.ss.videoarch.liveplayer.log.LiveLoggerService;
import com.ss.videoarch.strategy.LiveStrategyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f459601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f459602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p.a f459603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p.b f459604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.videoarch.liveplayer.model.a f459605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveLoggerService f459606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f459607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f459608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ymc.a f459609i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<String> f459610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f459611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f459612l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f459613m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f459614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public anc.a f459615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f459616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f459617q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f459618r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public JSONObject f459619s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Handler f459620t;

    public class a implements ymc.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f459621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f459622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f459623c;

        /* JADX INFO: renamed from: com.ss.videoarch.liveplayer.q$a$a, reason: collision with other inner class name */
        public class RunnableC5514a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LiveError f459624a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f459625b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f459626c;

            @Override // java.lang.Runnable
            public void run() {
                com_ss_videoarch_liveplayer_VLDNSParserImpl$1$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_ss_videoarch_liveplayer_VLDNSParserImpl$1$1__run$___twin___() {
                LiveError r100 = this.f459624a;
                if (r100 == null) goto L10;
                com.ss.videoarch.liveplayer.log.c.i("VLDNSParser DNSError", r100.toString());
                if (q.access$600(this.f459626c.f459623c).f459593h == false) goto L7;
                q.access$000(this.f459626c.f459623c).onSDKDNSError(this.f459624a);
                goto L10
            L7:
                q.access$700(this.f459626c.f459623c).onError(this.f459624a, q.access$600(this.f459626c.f459623c).f459592g);
                a r101 = this.f459626c;
                q r102 = r101.f459623c;
                String r103 = r101.f459622b;
                q.access$500(r102, r103, r103, this.f459625b, r101.f459621a);
                return;
            L10:
                if (q.access$600(this.f459626c.f459623c).f459594i == false) goto L13;
                com.ss.videoarch.liveplayer.log.c.i("VLDNSParser DNSCancel", "cancel");
                a r104 = this.f459626c;
                q r105 = r104.f459623c;
                String r106 = r104.f459622b;
                q.access$500(r105, r106, r106, this.f459625b, r104.f459621a);
                return;
            L13:
                String r107 = this.f459625b;
                String r108 = q.access$200(this.f459626c.f459623c, r107, false);
                if (TextUtils.isEmpty(r108) == false) goto L16;
            L18:
                String r109 = this.f459626c.f459622b;
                String r110 = this.f459625b;
                if (r110 != null) goto L21;
            L24:
                r107 = "none";
            L25:
                q.access$000(this.f459626c.f459623c).onCallPrepare();
                q.access$000(this.f459626c.f459623c).setCdnIp(r107, false);
                q.access$402(this.f459626c.f459623c, r107);
                a r111 = this.f459626c;
                q.access$500(r111.f459623c, r109, r111.f459622b, r107, r111.f459621a);
                return;
            L21:
                if (r110.length() == 0) goto L24;
                q.access$300(this.f459626c.f459623c);
                r109 = ymc.a.hostToIPUrl(this.f459626c.f459622b, r107, false);
                goto L25
            L16:
                if (r108.equals(this.f459625b) == true) goto L18;
                r107 = r108;
                goto L18
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_ss_videoarch_liveplayer_VLDNSParserImpl$1$1_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC5514a r100) {
                r100.com_ss_videoarch_liveplayer_VLDNSParserImpl$1$1__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC5514a(a r100, LiveError r101, String r102) {
                this.f459626c = r100;
                this.f459624a = r101;
                this.f459625b = r102;
            }
        }

        public a(q r100, String r101, String r102) {
            this.f459623c = r100;
            this.f459621a = r101;
            this.f459622b = r102;
        }

        @Override // ymc.a.d
        public void onParseComplete(String r100, String r101, LiveError r102, boolean r103) {
            String r104 = this.f459621a;
            if (r104 == null) goto L27;
            if (r100 != null) goto L6;
            return;
        L6:
            if (r104.equals(r100) == false) goto L29;
            q.access$000(this.f459623c).Na = q.access$100(this.f459623c);
            q.access$000(this.f459623c).onSDKDNSComplete(!r103, false);
            if (r103 == true) goto L25;
            String r105 = q.access$200(this.f459623c, r101, false);
            if (TextUtils.isEmpty(r105) == false) goto L13;
        L15:
            r105 = r101;
        L16:
            String r106 = this.f459622b;
            if (r101 != null) goto L19;
        L22:
            r105 = "none";
        L23:
            q.access$000(this.f459623c).onCallPrepare();
            q.access$000(this.f459623c).setCdnIp(r105, false);
            q.access$402(this.f459623c, r105);
            q.access$500(this.f459623c, r106, this.f459622b, r105, this.f459621a);
            return;
        L19:
            if (r101.length() == 0) goto L22;
            q.access$300(this.f459623c);
            r106 = ymc.a.hostToIPUrl(this.f459622b, r105, false);
            goto L23
        L13:
            if (r105.equals(r101) == true) goto L15;
        L25:
            q.access$800(this.f459623c, new RunnableC5514a(this, r102, r101));
            return;
        L29:
            return;
        }
    }

    public interface b {
        void onDNSParsed(String r100, String r101, String r102, String r103, p.a r104);
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f459627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f459629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f459630d;

        private c(q r100) {
            this.f459627a = null;
            this.f459628b = -1;
            this.f459629c = "none";
            this.f459630d = Boolean.FALSE;
        }

        public /* synthetic */ c(q r100, a r101) {
            this(r100);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com_ss_videoarch_liveplayer_VLDNSParserImpl_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private Boolean enableNodeOptimizerInStrategySDK() {
        p.b r100 = this.f459604d;
        boolean r101 = true;
        if (r100.f459589d == 1) goto L5;
    L7:
        r101 = false;
    L9:
        return Boolean.valueOf(r101);
    L5:
        if (r100.f459590e != 1) goto L7;
        goto L7
    }

    private void mDNSParserDataToLocalVar() {
        p.a r100 = this.f459603c;
        this.f459605e = r100.f459572a;
        this.f459606f = r100.f459573b;
        this.f459607g = r100.f459574c;
        this.f459608h = r100.f459575d;
        this.f459609i = r100.f459576e;
        this.f459610j = r100.f459577f;
        this.f459611k = r100.f459578g;
        this.f459612l = r100.f459579h;
        this.f459613m = r100.f459580i;
        this.f459614n = r100.f459581j;
        this.f459615o = r100.f459582k;
        this.f459616p = r100.f459583l;
        this.f459617q = r100.f459584m;
        this.f459618r = r100.f459585n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.ss.videoarch.liveplayer.q$a] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private void parsePlayDNS() {
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "2. parsePlayDNS:" + this.f459601a);
        this.f459618r = false;
        String r100 = this.f459601a;
        String r101 = ymc.a.getUrlHost(r100);
        this.f459606f.setCdnIp("none", false);
        this.f459606f.Oa = r101;
        this.f459612l = r100;
        if (ymc.a.isIP(r101) == false) goto L5;
    L70:
        handleDnsFreeCase(r100, r101);
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "handleDnsFreeCase");
        return;
    L5:
        if (this.f459604d.f459588c == false) goto L70;
        if (r101 == null) goto L70;
        this.f459615o.setHost(r101);
        if (this.f459604d.f459595j == true) goto L11;
    L63:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "EnableDnsOptimizer: " + this.f459604d.f459595j + ", retry times:" + this.f459615o.getRetryCount());
    L64:
        List<String> r102 = this.f459610j;
        if (r102 != null) goto L67;
        this.f459610j = new ArrayList();
    L68:
        parseDns(r101, r100);
        return;
    L67:
        r102.clear();
        goto L68
    L11:
        if (this.f459615o.getRetryCount() > 3) goto L63;
        ?? r103 = 0;
        ?? r104 = 0;
        r103 = 0;
        c r105 = new c(this, r103);
        p.b r106 = this.f459604d;
        if (r106.f459586a != 1) goto L29;
        if (r106.f459596k == false) goto L29;
        if (r106.f459597l == true) goto L29;
        List<String> r107 = this.f459608h;
        if (r107 == null) goto L29;
        if (r107.isEmpty() == true) goto L29;
        String r108 = checkQuicIpv6Enable((String) ListProtector.get(this.f459608h, 0), true);
        r105.f459627a = r108;
        JSONObject r109 = this.f459619s;
        if (r109 != null) goto L25;
    L27:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "get node optimize backup ip " + r105.f459627a);
    L43:
        if (TextUtils.isEmpty(r105.f459627a) == true) goto L62;
        List<String> r110 = this.f459608h;
        if (r110 != null) goto L47;
    L49:
        this.f459606f.onSDKDNSComplete(false, true);
        String r111 = r105.f459629c;
        if (r111 != null) goto L53;
        r111 = "sdk_previous_dns";
    L53:
        r105.f459629c = r111;
        this.f459606f.setEvaluatorSymbol(r111);
        if (r105.f459630d.booleanValue() == false) goto L56;
        this.f459606f.setRemoteSorted(r105.f459630d.booleanValue());
    L56:
        this.f459606f.setPreconnect(r105.f459628b);
        this.f459606f.onCallPrepare();
        this.f459606f.setCdnIp(r105.f459627a, false);
        String r112 = r105.f459627a;
        this.f459616p = r112;
        ?? r113 = r104;
        if (r104 != 0) goto L60;
        r113 = r100;
    L60:
        onDNSParsed(ymc.a.hostToIPUrl(r113, r112, false), r100, this.f459616p, r101);
        return;
    L47:
        if (r110.contains(r105.f459627a) == false) goto L49;
        this.f459608h.remove(r105.f459627a);
        goto L49
    L62:
        this.f459606f.setPreconnect(r105.f459628b);
        goto L64
    L25:
        if (r109.has(r108) == false) goto L27;
        r105.f459629c = this.f459619s.optString(r105.f459627a);
        this.f459606f.Aa = 1;
    L29:
        if (enableNodeOptimizerInStrategySDK().booleanValue() == true) goto L31;
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "Not enableNodeOptimizerInStrategySDK and dns is null");
    L39:
        this.f459606f.f458949c7 = new ArrayList();
        List<String> r114 = this.f459608h;
        r104 = r103;
        if (r114 == null) goto L43;
        this.f459606f.f458949c7.addAll(r114);
        r104 = r103;
        goto L43
    L31:
        if (this.f459607g.equals("quic") == false) goto L33;
    L34:
        r105.f459627a = getPreconnIp(r101);
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "getPreconnIp: " + r105.f459627a);
        this.f459606f.Sb = TextUtils.isEmpty(r105.f459627a);
    L36:
        if (TextUtils.isEmpty(r105.f459627a) == false) goto L39;
        r103 = handleNodeOptimizer(r101, r105);
        goto L39
    L33:
        if (this.f459607g.equals("h2q") == false) goto L36;
        goto L34
    }

    private void setDNSParserData() {
        p.a r100 = this.f459603c;
        r100.f459572a = this.f459605e;
        r100.f459573b = this.f459606f;
        r100.f459574c = this.f459607g;
        r100.f459575d = this.f459608h;
        r100.f459576e = this.f459609i;
        r100.f459577f = this.f459610j;
        r100.f459578g = this.f459611k;
        r100.f459579h = this.f459612l;
        r100.f459580i = this.f459613m;
        r100.f459581j = this.f459614n;
        r100.f459582k = this.f459615o;
        r100.f459583l = this.f459616p;
        r100.f459584m = this.f459617q;
        r100.f459585n = this.f459618r;
    }

    public q() {
        this.f459601a = null;
        this.f459605e = new com.ss.videoarch.liveplayer.model.a();
        this.f459607g = "tcp";
        this.f459608h = null;
        this.f459610j = null;
        this.f459611k = "none";
        this.f459612l = null;
        this.f459613m = "none";
        this.f459614n = "none";
        this.f459616p = null;
        this.f459617q = "";
        this.f459618r = false;
        this.f459619s = null;
        this.f459620t = new Handler(Looper.myLooper());
    }

    public void com_ss_videoarch_liveplayer_VLDNSParserImpl__run$___twin___() {
        parsePlayDNS();
    }

    public b getCallBack() {
        return this.f459602b;
    }

    public static /* synthetic */ LiveLoggerService access$000(q r100) {
        return r100.f459606f;
    }

    public static /* synthetic */ List access$100(q r100) {
        return r100.f459610j;
    }

    public static /* synthetic */ ymc.a access$300(q r100) {
        return r100.f459609i;
    }

    public static /* synthetic */ p.b access$600(q r100) {
        return r100.f459604d;
    }

    public static /* synthetic */ anc.a access$700(q r100) {
        return r100.f459615o;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_videoarch_liveplayer_VLDNSParserImpl_com_larus_apm_impl_protector_RunnableLancet_run(q r100) {
        r100.com_ss_videoarch_liveplayer_VLDNSParserImpl__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private String getPreconnIp(String r100) {
        return LiveStrategyManager.inst().getPreconnResult(r100);
    }

    private String getfallbackURLFromPreconnResult(JSONObject r110) {
        JSONObject r111 = (JSONObject) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 15, null, r110);
        if (r111 == null) goto L32;
        this.f459606f.Ka = r111.toString();
        Boolean r100 = Boolean.FALSE;
        int r101 = -1;
        if (r111.has("quic_preconn_result") == false) goto L16;
        int r102 = r111.optInt("quic_preconn_result");
        if (r102 != 0) goto L9;
    L17:
        int r103 = -1;
    L19:
        if (r111.has("quic_preconn_count") == false) goto L21;
        int r104 = r111.optInt("quic_preconn_count");
    L23:
        if (r111.has("tcp_preconn_count") == false) goto L25;
        r101 = r111.optInt("tcp_preconn_count");
    L25:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "quicPreconnResult: " + r102 + ",tcpPreconnResult:  " + r103 + ", quicPreconnCount: " + r104 + ", tcpPreconnCount: " + r101);
        if (r100.booleanValue() == true) goto L28;
        return null;
    L28:
        if (this.f459611k.equals("tls") == false) goto L30;
        this.f459607g = "tls";
        String r112 = this.f459612l.replaceAll("httpq", "https");
        this.f459612l = r112;
    L31:
        LiveLoggerService r105 = this.f459606f;
        r105.Ja = 1;
        r105.setProtocolInfo(this.f459613m, this.f459607g, this.f459614n);
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "quic fallback tcp, fallbackURL: " + r112);
        return r112;
    L30:
        this.f459607g = "tcp";
        r112 = this.f459612l.replaceAll("httpq", "http");
        this.f459612l = r112;
        goto L31
    L21:
        r104 = -1;
        goto L23
    L9:
        if (r102 == (-499499)) goto L17;
        if (r111.has("tcp_preconn_result") == false) goto L15;
        r103 = r111.optInt("tcp_preconn_result");
        if (r103 != 0) goto L19;
        r100 = Boolean.TRUE;
        goto L19
    L15:
        r100 = Boolean.TRUE;
        goto L17
    L16:
        r102 = -1;
        goto L17
    L32:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "get quic preconn result null");
        return null;
    }

    private void runOnFrontCurrentThread(Runnable r100) {
        this.f459620t.postAtFrontOfQueue(r100);
    }

    public static /* synthetic */ String access$402(q r100, String r101) {
        r100.f459616p = r101;
        return r101;
    }

    public static /* synthetic */ void access$800(q r100, Runnable r101) {
        r100.runOnFrontCurrentThread(r101);
    }

    private String checkQuicIpv6Enable(String r100, boolean r101) {
        if (this.f459604d.f459591f == 1) goto L5;
        return r100;
    L5:
        if (TextUtils.equals(this.f459607g, "quic") == true) goto L13;
        if (TextUtils.equals(this.f459607g, "quicu") == true) goto L13;
        if (TextUtils.equals(this.f459607g, "h2q") == true) goto L13;
        if (TextUtils.equals(this.f459607g, "h2qu") == true) goto L13;
        return r100;
    L13:
        if (ymc.a.isValidIPv4Addr(r100, false) == true) goto L37;
        if (r101 == false) goto L16;
        List<String> r102 = this.f459608h;
    L17:
        if (r102 != null) goto L19;
    L27:
        String r103 = r100;
    L29:
        if (TextUtils.equals(r103, r100) == false) goto L32;
        return "";
    L32:
        return r103;
    L19:
        if (r102.isEmpty() == true) goto L27;
        Iterator<String> r104 = r102.iterator();
    L22:
        if (r104.hasNext() == false) goto L27;
        r103 = r104.next();
        if (ymc.a.isValidIPv4Addr(r103, false) == true) goto L25;
        r104.remove();
        goto L22
    L25:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "quic not support ipv6: " + r100 + ", fallback ipv4: " + r103);
        goto L29
    L16:
        r102 = this.f459610j;
        goto L17
    L37:
        return r100;
    }

    private void handleDnsFreeCase(String r100, String r101) {
        this.f459606f.onSDKDNSComplete(false, false);
        this.f459606f.onCallPrepare();
        this.f459606f.setCdnIp(r101, false);
        this.f459616p = r101;
        if (TextUtils.isEmpty(this.f459617q) == false) goto L5;
    L7:
        onDNSParsed(r100, r100, null, null);
        return;
    L5:
        if (ymc.a.isIP(r101) == false) goto L7;
        onDNSParsed(r100, r100, null, this.f459617q);
    }

    private String handleNodeOptimizer(String r100, c r110) {
        JSONObject r101 = new JSONObject();
        r101.put("host", r100);     // Catch: JSONException -> L5
        r101.put("stream_session_vv_id", this.f459606f.T2);     // Catch: JSONException -> L5
    L7:
        int r102 = 0;
        JSONObject r103 = (JSONObject) LiveStrategyManager.inst().getConfigAndStrategyByKeyInt(0, 13, null, r101);
        if (r103 == null) goto L36;
        this.f459606f.Pa = r103.toString();
        if (r103.has("Ip") == false) goto L14;
        r110.f459627a = r103.optString("Ip");
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "get ip from strategy sdk, ip: " + r110.f459627a);
        if (r110.f459627a == null) goto L16;
        this.f459606f.Aa = 1;
    L16:
        if (r103.has("RemoteResult") == false) goto L23;
        JSONArray r104 = r103.optJSONArray("RemoteResult");
        if (r104 == null) goto L23;
        this.f459608h = new ArrayList();
    L21:
        if (r102 >= r104.length()) goto L23;
        this.f459608h.add(r104.optString(r102));
        r102 = r102 + 1;
    L23:
        r110.f459627a = checkQuicIpv6Enable(r110.f459627a, true);
        if (r103.has("RequestId") == false) goto L27;
        this.f459606f.Z7 = r103.optString("RequestId");
    L27:
        if (r103.has("EvaluatorSymbol") == false) goto L34;
        JSONObject r105 = r103.optJSONObject("EvaluatorSymbol");
        this.f459619s = r105;
        if (r105 == null) goto L34;
        if (r105.has(r110.f459627a) == false) goto L34;
        r110.f459629c = this.f459619s.optString(r110.f459627a);
    L34:
        if (r103.has("IsRemoteSorted") == false) goto L38;
        r110.f459630d = Boolean.valueOf(r103.optBoolean("IsRemoteSorted"));
    L38:
        if (TextUtils.isEmpty(r110.f459627a) == false) goto L40;
    L51:
        return null;
    L40:
        if (this.f459604d.f459587b != 1) goto L51;
        if (this.f459607g.equals("quic") == false) goto L44;
    L54:
        r101.put(DNSParser.DNS_RESULT_IP, r110.f459627a);     // Catch: JSONException -> L47
    L50:
        return getfallbackURLFromPreconnResult(r101);
    L47:
        e = move-exception;
        e.printStackTrace();
        goto L50
    L44:
        if (this.f459607g.equals("quicu") == false) goto L51;
    L14:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "nodeOptimizerInfos no ip:" + r100);
        goto L16
    L36:
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "null nodeOptimizerInfos:" + r100);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void parseDns(String r100, String r101) {
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "parseDns, host:" + r100 + ", playURL:" + r101);
        this.f459609i.parseDns(r100, this.f459610j, new a(this, r100, r101));
    }

    public void init(p r100, b r101) {
        this.f459603c = r100.getDNSParserData();
        mDNSParserDataToLocalVar();
        this.f459604d = r100.getDnsToggles();
        this.f459602b = r101;
        this.f459601a = r100.getPlayUrl();
    }

    public static /* synthetic */ String access$200(q r100, String r101, boolean r102) {
        return r100.checkQuicIpv6Enable(r101, r102);
    }

    private void onDNSParsed(String r100, String r110, String r111, String r112) {
        if (this.f459602b == null) goto L6;
        com.ss.videoarch.liveplayer.log.c.i("VLDNSParser", "3. callback: " + r111);
        setDNSParserData();
        this.f459602b.onDNSParsed(r100, r110, r111, r112, this.f459603c);
        return;
    }

    public static /* synthetic */ void access$500(q r100, String r101, String r102, String r103, String r104) {
        r100.onDNSParsed(r101, r102, r103, r104);
    }
}
