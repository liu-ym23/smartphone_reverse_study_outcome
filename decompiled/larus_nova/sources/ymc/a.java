package ymc;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.common.api.FirewallError;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.liveplayer.h;
import com.ss.videoarch.liveplayer.log.LiveError;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile long f568399j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f568400k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f568401l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f568402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f568403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f568404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Future f568405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f568406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f568407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile d f568408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f568409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f568410i;

    /* JADX INFO: renamed from: ymc.a$a, reason: collision with other inner class name */
    public class RunnableC8358a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f568411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f568412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f568413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f568414d;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_videoarch_liveplayer_network_DnsHelper$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_videoarch_liveplayer_network_DnsHelper$1__run$___twin___() {
            if (this.f568411a == false) goto L5;
            a.access$000(this.f568414d, this.f568412b);
            return;
        L5:
            a.access$100(this.f568414d, this.f568412b, this.f568413c);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_videoarch_liveplayer_network_DnsHelper$1_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC8358a r100) {
            r100.com_ss_videoarch_liveplayer_network_DnsHelper$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC8358a(a r100, boolean r101, String r102, List r103) {
            this.f568414d = r100;
            this.f568411a = r101;
            this.f568412b = r102;
            this.f568413c = r103;
        }
    }

    public class b implements ymc.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f568415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f568416b;

        @Override // ymc.e.a
        public void onCompletion(JSONObject r100) {
            JSONArray r101 = r100.optJSONArray("ips");
            if (r101 != null) goto L5;
        L14:
            HashMap r102 = new HashMap();
            r102.put("host", this.f568415a);
            LiveError r103 = new LiveError(LiveError.EMPTY, "http dns response ip empty", r102);
            a.access$200(this.f568416b, true, this.f568415a, null, r103, true);
            return;
        L5:
            if (r101.length() == 0) goto L14;
            String r104 = JSONArrayProtectorUtils.getString(r101, 0);     // Catch: Exception -> L10
        L9:
            String r105 = r104;
            a.access$200(this.f568416b, true, this.f568415a, r105, null, true);
            return;
        L10:
            e = move-exception;
            com.ss.videoarch.liveplayer.log.c.d("DnsHelper", e.toString());
            r104 = null;
            goto L9
        }

        @Override // ymc.e.a
        public void onError(LiveError r100) {
            a.access$200(this.f568416b, true, this.f568415a, null, r100, true);
        }

        public b(a r100, String r101) {
            this.f568416b = r100;
            this.f568415a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f568417a;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_videoarch_liveplayer_network_DnsHelper$3_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_videoarch_liveplayer_network_DnsHelper$3__run$___twin___() {
            InetAddress r100 = InetAddress.getByName("whoami.akamai.net");     // Catch: UnknownHostException -> L7
            if (r100 == null) goto L10;
            this.f568417a.f568410i = r100.getHostAddress();     // Catch: UnknownHostException -> L7
            a.access$302(SystemClock.elapsedRealtime());     // Catch: UnknownHostException -> L7
            com.ss.videoarch.liveplayer.log.c.d("DnsHelper", "update dns server ip:" + this.f568417a.f568410i);     // Catch: UnknownHostException -> L7
            return;
        L10:
            return;
        }

        public c(a r100) {
            this.f568417a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_videoarch_liveplayer_network_DnsHelper$3_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_ss_videoarch_liveplayer_network_DnsHelper$3__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface d {
        void onParseComplete(String r100, String r101, LiveError r102, boolean r103);
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f568418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f568419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f568420c;

        public e(int r100, int r101, int r102) {
            this.f568418a = r100;
            this.f568419b = r101;
            this.f568420c = r102;
        }
    }

    public void cancel() {
        this.f568408g = null;
        Future r100 = this.f568405d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDone() == true) goto L9;
        this.f568405d.cancel(true);
        this.f568405d = null;
        return;
    }

    static {
        f568400k = PatternProtector.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f568401l = PatternProtector.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public String getDNSServerIP() {
        updateDNSServerIP();
        return this.f568410i;
    }

    public void updateDNSServerIP() {
        if ((SystemClock.elapsedRealtime() - f568399j) >= 300000) goto L5;
        return;
    L5:
        ExecutorService r100 = this.f568402a;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.isShutdown() == false) goto L11;
        return;
    L11:
        this.f568402a.submit(new c(this));
    }

    public static /* synthetic */ long access$302(long r100) {
        f568399j = r100;
        return r100;
    }

    private void doHttpDns(String r100) {
        String r101 = getURL(r100);
        ymc.e.doRequest(this.f568403b, r101, this.f568407f, new b(this, r100));
    }

    private String getURL(String r100) {
        return String.format("https://%s/q?host=%s", new Object[]{this.f568407f, r100});
    }

    private static e getURLHostIndex(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() == 0) goto L35;
        int r101 = r100.indexOf("://") + 3;
        int r102 = r100.length();
        int r103 = r101;
        int r104 = -1;
    L7:
        if (r101 >= r102) goto L22;
        char r105 = r100.charAt(r101);
        if (r105 == '#') goto L22;
        if (r105 == '/') goto L22;
        if (r105 != ':') goto L15;
        r104 = r101;
    L21:
        r101 = r101 + 1;
        goto L7
    L15:
        if (r105 == '?') goto L22;
        if (r105 != '@') goto L21;
        r103 = r101 + 1;
    L22:
        if (r104 != (-1)) goto L25;
        r104 = r101;
    L25:
        return new e(r103, r104, r101);
    L35:
        return null;
    }

    public static String getUrlHost(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() == 0) goto L10;
        e r101 = getURLHostIndex(r100);
        return r100.substring(r101.f568418a, r101.f568419b);
    L10:
        return null;
    }

    public static boolean isIP(String r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.length() < 7) goto L14;
        if (r100.length() > 15) goto L14;
        if ("".equals(r100) == true) goto L14;
        return PatternProtector.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(r100).find();
    }

    public void setNetworkClient(h r100) {
        this.f568403b = r100;
    }

    public static /* synthetic */ void access$000(a r100, String r101) {
        r100.doHttpDns(r101);
    }

    private void doLocalDns(String r110, List<String> r111) {
        InetAddress[] r100 = InetAddress.getAllByName(r110);     // Catch: UnknownHostException -> L22
        if (r100 != null) goto L6;
    L13:
        InetAddress r101 = null;
    L14:
        if (r101 != null) goto L17;
        notifyParseComplete(false, r110, null, new LiveError(-100010, "", null), true);
        return;
    L17:
        String r102 = r101.getHostAddress();
        if ((r101 instanceof Inet6Address) == false) goto L20;
        r102 = String.format("[%s]", new Object[]{r102});
    L20:
        notifyParseComplete(false, r110, r102, r111, null, true);
        return;
    L6:
        if (r100.length <= 0) goto L13;
        r101 = r100[0];     // Catch: UnknownHostException -> L22
        int r103 = r100.length;     // Catch: UnknownHostException -> L22
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L14;
        String r105 = r100[r104].getHostAddress();     // Catch: UnknownHostException -> L22
        if (r111 == null) goto L12;
        r111.add(r105);     // Catch: UnknownHostException -> L22
    L12:
        r104 = r104 + 1;
    L22:
        e = move-exception;
        com.ss.videoarch.liveplayer.log.c.e("DnsHelper", "UnknownHostException :" + e);
        HashMap r106 = new HashMap();
        r106.put("reason", "Unknown host name");
        r106.put("host", r110);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e.toString());
        notifyParseComplete(false, r110, null, new LiveError(-100010, "Unknown Host", r106), true);
    }

    private static e getURLIpHostIndex(String r100, boolean r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() == 0) goto L41;
        int r102 = r100.indexOf("://") + 3;
        int r103 = r100.length();
        int r104 = r102;
        int r105 = -1;
    L7:
        if (r102 >= r103) goto L27;
        char r106 = r100.charAt(r102);
        if (r106 == '#') goto L27;
        if (r106 == '/') goto L27;
        if (r106 != ':') goto L15;
        if (r101 == false) goto L25;
    L24:
        if (r101 == true) goto L25;
    L26:
        r102 = r102 + 1;
    L25:
        r105 = r102;
        goto L26
    L15:
        if (r106 == ']') goto L24;
        if (r106 == '?') goto L27;
        if (r106 != '@') goto L26;
        r104 = r102 + 1;
    L27:
        if (r105 != (-1)) goto L30;
        r105 = r102;
    L30:
        return new e(r104, r105, r102);
    L41:
        return null;
    }

    public static boolean isValidIPv4Addr(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        com.ss.videoarch.liveplayer.log.c.i("DnsHelper", "IP address is null");
        return false;
    L6:
        if (r101 == true) goto L8;
        Pattern r102 = PatternProtector.compile("(([0-9])|([1-9]\\d)|(([1]\\d{2})|(([2][0-4]\\d)|([2][5][0-5]))))(.(([0-9])|([1-9]\\d)|(([1]\\d{2})|(([2][0-4]\\d)|([2][5][0-5]))))){3}");
        return r102.matcher(Normalizer.normalize(r100, Normalizer.Form.NFKC)).matches();
    L12:
        return false;
    L8:
        return r100.contains(".");
    }

    public static boolean isValidIpv6Addr(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        com.ss.videoarch.liveplayer.log.c.d("DnsHelper", "IP address is null");
        return false;
    L6:
        if (r101 == true) goto L8;
        String r102 = Normalizer.normalize(r100, Normalizer.Form.NFKC);
        if (f568400k.matcher(r102).matches() == true) goto L14;
        if (f568401l.matcher(r102).matches() == true) goto L14;
        return false;
    L14:
        return true;
    L20:
        return false;
    L8:
        return r100.contains(":");
    }

    public void configure(boolean r100, String r101) {
        if (r100 == true) goto L4;
    L10:
        boolean r102 = false;
    L11:
        this.f568406e = r102;
        this.f568407f = r101;
        com.ss.videoarch.liveplayer.log.c.i("DnsHelper", this.f568406e + this.f568407f);
        return;
    L4:
        if (this.f568403b == null) goto L10;
        if (TextUtils.isEmpty(r101) == true) goto L10;
        if (r101.equals("null") == true) goto L10;
        r102 = true;
        goto L11
    }

    public a(Context r100, ExecutorService r101, h r102) {
        this.f568406e = false;
        this.f568407f = null;
        this.f568409h = FirewallError.FIREWALL_OK;
        this.f568404c = r100;
        this.f568402a = r101;
        this.f568403b = r102;
    }

    public static /* synthetic */ void access$100(a r100, String r101, List r102) {
        r100.doLocalDns(r101, r102);
    }

    public static String hostToIPUrl(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L23;
        e r103 = getURLHostIndex(r100);
        boolean r104 = r100.startsWith("http");
        boolean r105 = isValidIpv6Addr(r101, r102);
        if (r102 == false) goto L12;
        if (r105 == true) goto L10;
    L14:
        String r106 = r100.substring(0, r103.f568418a) + r101;
        int r107 = r103.f568419b;
        if (r103.f568420c == (-1)) goto L17;
        r106 = r106 + r100.substring(r103.f568419b, r103.f568420c);
        r107 = r103.f568420c;
    L17:
        if (r104 == true) goto L20;
        r106 = r106 + HTTP.URL_DEFAULT + getUrlHost(r100);
    L20:
        return r106 + r100.substring(r107);
    L10:
        if (r101.contains("[") == true) goto L14;
        r101 = String.format("[%s]", new Object[]{r101});
        goto L14
    L12:
        if (r105 == false) goto L14;
        r101 = String.format("[%s]", new Object[]{r101});
        goto L14
    L23:
        return null;
    }

    public static String ipToHostUrl(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        e r103 = getURLIpHostIndex(r100, r102);
        r100.startsWith("http");
        String r104 = r100.substring(0, r103.f568418a) + r101;
        int r105 = r103.f568419b;
        if (r103.f568420c == (-1)) goto L10;
        r104 = r104 + r100.substring(r103.f568419b, r103.f568420c);
        r105 = r103.f568420c;
    L10:
        return r104 + r100.substring(r105);
    L13:
        return null;
    }

    public void parseDns(String r110, List<String> r111, d r112) {
        if (TextUtils.isEmpty(r110) == true) goto L41;
        if (r112 != null) goto L7;
        return;
    L7:
        if (this.f568402a == null) goto L40;
        boolean r100 = this.f568406e;
        cancel();
        this.f568408g = r112;
        NetworkInfo r113 = ymc.d.getNetworkInfo(this.f568404c);
        if (r113 != null) goto L11;
    L13:
        int r114 = -1;
    L14:
        int r101 = ymc.b.getInstance().getCurNetType();
        boolean r102 = true;
        if (r114 == (-1)) goto L19;
        if (r114 != r101) goto L20;
        r102 = false;
    L20:
        if (r102 == false) goto L22;
        ymc.b.getInstance().clear();
        ymc.b.getInstance().setCurNetType(r114);
    L22:
        ymc.b.a r115 = ymc.b.getInstance().get(r110);
        if (r115 == null) goto L35;
        if ((System.currentTimeMillis() - r115.f568427b) > this.f568409h) goto L35;
        if (r115.f568428c == true) goto L35;
        r111.addAll(ymc.b.getInstance().gets(r110));     // Catch: Exception -> L30
    L32:
        notifyParseComplete(this.f568406e, r110, r115.f568426a, null, false);
        return;
    L30:
        e = move-exception;
        com.ss.videoarch.liveplayer.log.c.e("DnsHelper", e.toString());
    L35:
        if (this.f568402a.isShutdown() == true) goto L37;
        this.f568405d = this.f568402a.submit(new RunnableC8358a(this, r100, r110, r111));
        return;
    L37:
        notifyParseComplete(false, r110, null, null, false);
        return;
    L19:
        com.ss.videoarch.liveplayer.log.c.d("DnsHelper", "start: NetWork may have some problems");
        goto L20
    L11:
        if (r113.isAvailable() == false) goto L13;
        r114 = r113.getType();
        goto L14
    L40:
        throw new IllegalStateException("mExecutor should not be null");
    }

    private void notifyParseComplete(boolean r100, String r101, String r110, LiveError r111, boolean r112) {
        notifyParseComplete(r100, r101, r110, null, r111, r112);
    }

    public static /* synthetic */ void access$200(a r100, boolean r101, String r102, String r103, LiveError r104, boolean r105) {
        r100.notifyParseComplete(r101, r102, r103, r104, r105);
    }

    private void notifyParseComplete(boolean r100, String r101, String r102, List<String> r103, LiveError r104, boolean r105) {
        if (this.f568406e != r100) goto L12;
        d r106 = this.f568408g;
        if (r106 == null) goto L13;
        if (r105 == false) goto L10;
        if (r102 == null) goto L10;
        ymc.b.a r107 = new ymc.b.a();
        r107.f568427b = System.currentTimeMillis();
        r107.f568426a = r102;
        r107.f568428c = false;
        ymc.b.getInstance().put(r101, r107);
        ymc.b.getInstance().puts(r101, r103);
    L10:
        r106.onParseComplete(r101, r102, r104, r105);
        return;
    L13:
        return;
    }
}
