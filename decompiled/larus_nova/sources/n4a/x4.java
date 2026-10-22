package n4a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Xml;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes32.dex */
public final class x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f517924a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f517925b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f517926c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f517927d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f517928e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f517929f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f517930g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f517931h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f517932i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IBinder f517933j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f517934k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f517935l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f517936m = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f517937n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f517938o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f517939p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f517940q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f517941r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f517942s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f517943t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f517944u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f517945v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f517946w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f517947x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f517948y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile d f517949z;

    public class a extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f517950b;

        public a(Context r100) {
            this.f517950b = r100;
        }

        @Override // n4a.l1
        public final void a() {
            Map<String, String> r100 = ((h) x4.f517928e).c();     // Catch: Throwable -> L9
            c r101 = x4.f517928e;     // Catch: Throwable -> L9
            h r102 = (h) r101;     // Catch: Throwable -> L9
            String r103 = r102.b(x4.q(this.f517950b));     // Catch: Throwable -> L9
            if (TextUtils.isEmpty(r103) == false) goto L5;
            return;
        L5:
            com.loc.c.c();     // Catch: Throwable -> L9
            c r104 = x4.f517928e;     // Catch: Throwable -> L9
            byte[] r105 = r103.getBytes();     // Catch: Throwable -> L9
            ((h) r104).getClass();     // Catch: Throwable -> L9
            l0 r106 = com.loc.c.a(new com.loc.b(r105, r100));     // Catch: Throwable -> L9
            c r107 = x4.f517928e;     // Catch: Throwable -> L9
            h r108 = (h) r107;     // Catch: Throwable -> L9
            String r109 = r108.a(this.f517950b, new String(r106.f517453a));     // Catch: Throwable -> L9
            if (TextUtils.isEmpty(r109) == true) goto L12;
            x4.f517925b = r109;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    public class b extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f517951b;

        public b(Context r100) {
            this.f517951b = r100;
        }

        @Override // n4a.l1
        public final void a() {
            x4.y(this.f517951b);
            x4.f517934k = true;
        }
    }

    public interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static a f517952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static ConnectivityManager f517953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static NetworkRequest f517954c;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r100, Intent r101) {
                if (f5.o("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(r101.getAction()) == false) goto L6;
                x4.v();
                return;
            }
        }

        public class b extends ConnectivityManager.NetworkCallback {
            public b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r100) {
                super.onAvailable(r100);
                x4.v();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r100) {
                super.onLost(r100);
                x4.v();
            }
        }

        public d() {
        }

        public static void a(Context r110) {
            if (Build.VERSION.SDK_INT >= 24) goto L40;
            if (r110 != null) goto L6;
            return;
        L6:
            if (f517952a != null) goto L58;
            f517952a = new a();
            IntentFilter r100 = new IntentFilter();
            r100.addAction(f5.o("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
            a r101 = f517952a;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L49;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L49:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r101, r100);
            return;
        L38:
            throw e;
        L11:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L24;
            int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r100, 0, null, null, 2, r110).result;     // Catch: Exception -> L33
            if (r102 != 1) goto L17;
            r110.registerReceiver(r101, r100);     // Catch: Exception -> L33
            return;
        L17:
            if (r102 != 2) goto L19;
            new Intent();     // Catch: Exception -> L33
            return;
        L19:
            if (r102 == 3) goto L50;
            r110.registerReceiver(r101, r100);     // Catch: Exception -> L33
            return;
        L50:
            return;
        L24:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r110.registerReceiver(r101, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L27:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
        L31:
            r110.registerReceiver(r101, r100);     // Catch: Exception -> L33
            return;
        L29:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r110, r101, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
            return;
        L58:
            return;
        L40:
            if (x4.m(r110, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L42;
            return;
        L42:
            if (r110 != null) goto L44;
            return;
        L44:
            if (f517953b != null) goto L60;
            ConnectivityManager r111 = (ConnectivityManager) r110.getSystemService("connectivity");
            f517953b = r111;
            if (r111 == null) goto L61;
            f517954c = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
            b r112 = new b();
            f517953b.registerNetworkCallback(f517954c, r112);
            return;
        L61:
            return;
        }
    }

    public static class e implements ServiceConnection {
        public e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            x4.f517933j = r101;
        }
    }

    public static String a(Context r100) {
        if (TextUtils.isEmpty(f517939p) == false) goto L5;
        String r101 = y.k(r100, "open_common", "a1");     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L9;
        f517939p = AppletNaviThirdApp.AMAP + UUID.randomUUID().toString().replace("_", "").toLowerCase();     // Catch: Throwable -> L12
        SharedPreferences.Editor r102 = y.b(r100, "open_common");     // Catch: Throwable -> L12
        y.g(r102, "a1", f5.k(f517939p));     // Catch: Throwable -> L12
        y.e(r102);     // Catch: Throwable -> L12
    L11:
        return f517939p;
    L9:
        f517939p = f5.o(r101);     // Catch: Throwable -> L12
        goto L11
    L13:
        return f517939p;
    L5:
        return f517939p;
    }

    public static synchronized void i(Context r100) {
        monitor-enter(x4.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f517949z != null) goto L10;
        if (r100 != null) goto L9;
        monitor-exit(x4.class);
        return;
    L9:
        f517949z = new d();     // Catch: Throwable -> L12
        d.a(r100.getApplicationContext());     // Catch: Throwable -> L12
    L10:
        monitor-exit(x4.class);
    }

    public static String k(Context r110, int r111) {
        Intent r100 = new Intent();     // Catch: Throwable -> L47
        if (r111 == 2) goto L11;
        if (r111 == 4) goto L10;
        if (r111 == 5) goto L9;
        f517931h = true;     // Catch: Throwable -> L47
        return f517930g;
    L9:
        r100.setClassName(f5.o("YY29tLmhleXRhcC5vcGVuaWQ"), f5.o("SY29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl"));     // Catch: Throwable -> L47
        r100.setAction(f5.o("EYWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ"));     // Catch: Throwable -> L47
    L12:
        e r101 = new e();     // Catch: Throwable -> L47
        if (r110.bindService(r100, r101, 1) == false) goto L46;
        int r102 = 0;
    L16:
        if (r102 >= 100) goto L44;
        if (TextUtils.isEmpty(f517930g) == false) goto L44;
        r102 = r102 + 1;     // Catch: Throwable -> L47
        if (f517933j == null) goto L43;
        Parcel r103 = Parcel.obtain();     // Catch: Throwable -> L47
        Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L47
        if (r111 == 2) goto L29;
        if (r111 == 4) goto L27;
        if (r111 == 5) goto L26;
        boolean r105 = false;
    L32:
        if (r105 == true) goto L52;
    L34:
        r104.recycle();     // Catch: Throwable -> L47
        r103.recycle();     // Catch: Throwable -> L47
        goto L43
    L52:
        g(f517933j, r103, r104);     // Catch: Throwable -> L36
        r104.readException();     // Catch: Throwable -> L36
        f517930g = r104.readString();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        n.a(th, "oac", String.valueOf(r111));     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r104.recycle();     // Catch: Throwable -> L47
        r103.recycle();     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L26:
        r103.writeInterfaceToken(f5.o("KY29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA"));     // Catch: Throwable -> L36
        r103.writeString(r110.getPackageName());     // Catch: Throwable -> L36
        r103.writeString(x(r110));     // Catch: Throwable -> L36
        r103.writeString(f5.o("IT1VJRA"));     // Catch: Throwable -> L36
    L31:
        r105 = true;
        goto L32
    L27:
        String r106 = "UY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuSURldmljZUlkU2VydmljZQ";
    L30:
        r103.writeInterfaceToken(f5.o(r106));     // Catch: Throwable -> L36
        goto L31
    L29:
        r106 = "UY29tLnVvZGlzLm9wZW5kZXZpY2UuYWlkbC5PcGVuRGV2aWNlSWRlbnRpZmllclNlcnZpY2U";
    L43:
        Thread.sleep(15);     // Catch: Throwable -> L47
    L44:
        r110.unbindService(r101);     // Catch: Throwable -> L47
        f517933j = null;     // Catch: Throwable -> L47
    L46:
        return f517930g;
    L10:
        r100.setClassName(f5.o("WY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2U"), f5.o("QY29tLnNhbXN1bmcuYW5kcm9pZC5kZXZpY2VpZHNlcnZpY2UuRGV2aWNlSWRTZXJ2aWNl"));     // Catch: Throwable -> L47
        goto L12
    L11:
        r100.setAction(f5.o("WY29tLnVvZGlzLm9wZW5kZXZpY2UuT1BFTklEU19TRVJWSUNF"));     // Catch: Throwable -> L47
        r100.setPackage(f5.o("UY29tLmh1YXdlaS5od2lk"));     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        n.a(th, "oa", String.valueOf(r111));
        f517931h = true;
        return f517930g;
    }

    public static void l(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static boolean m(Context r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.checkCallingOrSelfPermission(r101) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int r(Context r100) {
        return c(r100);
    L4:
        return -1;
    }

    public static String u(Context r100) {
        String r101 = "";
        if (TextUtils.isEmpty("") == false) goto L7;
        String r102 = j(r100);     // Catch: Throwable -> L24
    L25:
        if (TextUtils.isEmpty(r102) == false) goto L12;
        r102 = q(r100);     // Catch: Throwable -> L22
    L12:
        if (TextUtils.isEmpty(r102) == false) goto L14;
        r102 = p(r100);     // Catch: Throwable -> L22
    L14:
        if (TextUtils.isEmpty(r102) == true) goto L19;
        r101 = r102;
    L19:
        if (TextUtils.isEmpty(r101) == false) goto L29;
        return a(r100);
    L29:
        return r101;
    L23:
        return r102;
    L7:
        r102 = "";
    L31:
        return "";
    }

    public static void v() {
        f517945v = -1;
        f517946w = false;
        f517947x = -1;
        f517948y = false;
        f517943t = "";
        f517944u = false;
        f517936m = "";
        f517937n = false;
    }

    public static String w(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getExternalCacheDir().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");     // Catch: Throwable -> L32
        XmlPullParser r102 = Xml.newPullParser();     // Catch: Throwable -> L32
        int r103 = r102.getEventType();     // Catch: Throwable -> L32
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L32
        r102.setInput(r104, XML.CHARSET_UTF8);     // Catch: Throwable -> L39
        boolean r105 = false;
    L5:
        if (1 != r103) goto L7;
    L46:
        r104.close();     // Catch: Throwable -> L38
        return "";
    L57:
        return "";
    L7:
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L11;
        r105 = false;
    L28:
        r103 = r102.next();     // Catch: Throwable -> L39
        goto L5
    L11:
        if (r103 != 4) goto L28;
        if (r105 == false) goto L28;
        String r106 = r102.getText();     // Catch: Throwable -> L39
        r104.close();     // Catch: Throwable -> L37
    L16:
        return r106;
    L19:
        if (r102.getAttributeCount() <= 0) goto L28;
        int r107 = r102.getAttributeCount();     // Catch: Throwable -> L39
        int r108 = 0;
    L21:
        if (r108 >= r107) goto L28;
        String r109 = r102.getAttributeValue(r108);     // Catch: Throwable -> L39
        if ("UTDID2".equals(r109) == false) goto L25;
    L26:
        r105 = true;
    L27:
        r108 = r108 + 1;     // Catch: Throwable -> L39
        goto L21
    L25:
        if ("UTDID".equals(r109) == false) goto L27;
    L33:
        if (r104 != null) goto L46;
        return "";
    L32:
        r104 = null;
        goto L33
    }

    public static String x(Context r100) {
    L14:
        return "";
    L3:
        if (TextUtils.isEmpty(f517932i) == false) goto L5;
        Signature[] r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64).signatures;     // Catch: Throwable -> L14
        int r102 = 0;
        byte[] r103 = r101[0].toByteArray();     // Catch: Throwable -> L14
        byte[] r104 = MessageDigest.getInstance(f5.o("IU0hBMQ")).digest(r103);     // Catch: Throwable -> L14
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L14
    L8:
        if (r102 >= r104.length) goto L10;
        r105.append(Integer.toHexString((r104[r102] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: Throwable -> L14
        r102 = r102 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r106 = r105.toString();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r106) == true) goto L13;
        f517932i = r106;     // Catch: Throwable -> L14
    L13:
        return r106;
    L5:
        return f517932i;
    }

    public static String b(Context r100) {
        if (f517944u == true) goto L5;
        i(r100);
        TelephonyManager r101 = (TelephonyManager) r100.getSystemService("phone");
        if (r101 == null) goto L9;
        String r102 = r101.getSimOperatorName();
        f517943t = r102;
        if (TextUtils.isEmpty(r102) == false) goto L13;
        f517943t = r101.getNetworkOperatorName();
    L13:
        f517944u = true;
        return f517943t;
    L9:
        return f517943t;
    L5:
        return f517943t;
    }

    public static int c(Context r100) {
        if (f517946w == true) goto L5;
        i(r100);
        if (r100 == null) goto L22;
        if (m(r100, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L22;
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 == null) goto L14;
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 != null) goto L19;
        f517946w = true;
        return f517945v;
    L19:
        int r103 = r102.getType();
        f517945v = r103;
        f517946w = true;
        return r103;
    L14:
        return f517945v;
    L22:
        return f517945v;
    L5:
        return f517945v;
    }

    public static int d(Context r100) {
        if (f517948y == true) goto L5;
        i(r100);
        if (m(r100, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == false) goto L9;
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 == null) goto L13;
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 == null) goto L20;
        if (r102.isAvailable() == false) goto L20;
        f517947x = r102.getSubtype();
        f517948y = true;
    L20:
        return f517947x;
    L13:
        return f517947x;
    L9:
        return f517947x;
    L5:
        return f517947x;
    }

    public static String e(Context r100) {
        if (f517926c == true) goto L29;
        return "";
    L29:
        String r101 = f(r100);     // Catch: Throwable -> L8
    L27:
    L16:
        r101 = null;
    L18:
        if (TextUtils.isEmpty(r101) == false) goto L25;
        f517926c = false;
        return "";
    L25:
        byte[] r102 = f5.o("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");     // Catch: Throwable -> L23
        byte[] r103 = y4.e(r101);     // Catch: Throwable -> L23
        return new String(y4.c(f5.o("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), r103, r102), "UTF-8");
    L23:
        f517926c = false;
        return "";
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L18;
        if (r100 != null) goto L14;
        r101 = "";
        goto L18
    L14:
        r101 = r100.getSharedPreferences(f5.o("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(b5.a(f5.o("RYW1hcF9kZXZpY2VfYWRpdQ")), "");     // Catch: Throwable -> L16
    L8:
        r101 = "";
        goto L27
    }

    public static String f(Context r100) {
        String r101 = b5.a(f5.o("LYW1hcF9kZXZpY2VfYWRpdQ"));
        ByteArrayOutputStream r102 = null;
        File r103 = r100.getExternalCacheDir();     // Catch: Exception -> L48
        if (r103 != null) goto L6;
        r103 = r100.getCacheDir();     // Catch: Exception -> L48
    L6:
        if (r103 == null) goto L9;
        String r104 = r103.getAbsolutePath();     // Catch: Exception -> L48
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return "";
    L13:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104 + File.separator + f5.o("KYmFja3Vwcw"), f5.o("MLmFkaXU"));
        if (r105.exists() == true) goto L16;
    L46:
        return "";
    L16:
        if (r105.canRead() == false) goto L46;
        if (r105.length() != 0) goto L53;
        r105.delete();
        return "";
    L53:
        RandomAccessFile r106 = new RandomAccessFile(r105, "r");     // Catch: Throwable -> L43
        byte[] r107 = new byte[1024];     // Catch: Throwable -> L47
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();     // Catch: Throwable -> L47
    L51:
        int r109 = r106.read(r107);     // Catch: Throwable -> L42
        if (r109 == (-1)) goto L28;
        r108.write(r107, 0, r109);     // Catch: Throwable -> L42
        goto L51
    L28:
        String r110 = new String(r108.toByteArray(), "UTF-8");     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r110) == false) goto L31;
    L41:
        l(r108);
    L45:
        l(r106);
        goto L46
    L31:
        if (r110.contains(f5.o("SIw")) == false) goto L41;
        String[] r111 = r110.split(f5.o("SIw"));     // Catch: Throwable -> L42
        if (r111 == null) goto L41;
        if (r111.length != 2) goto L41;
        if (TextUtils.equals(r101, r111[0]) == false) goto L41;
        String r112 = r111[1];     // Catch: Throwable -> L42
        l(r108);
        l(r106);
        return r112;
    L42:
        r102 = r108;
    L44:
        l(r102);
    L43:
        r106 = null;
    L9:
        r104 = null;
        goto L11
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class h(String r100) throws ClassNotFoundException {
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

    public static String j(Context r100) {
        if (TextUtils.isEmpty(f517925b) == false) goto L6;
        if (r100 != null) goto L9;
        return "";
    L9:
        String r101 = e(r100);     // Catch: Throwable -> L21
        f517925b = r101;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r101) == true) goto L14;
        return f517925b;
    L14:
        if (f517928e != null) goto L17;
        return "";
    L17:
        if (f517929f == false) goto L19;
        return "";
    L19:
        f517929f = true;     // Catch: Throwable -> L21
        k1.f517430d.b(new a(r100));     // Catch: Throwable -> L21
        goto L20
    L6:
        return f517925b;
    L20:
        return "";
    }

    public static String o(ContentResolver r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, "mqBRboGZkQPcAkyk"};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = Settings.System.getString(r110, "mqBRboGZkQPcAkyk");
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r113, r111, true);
        return r113;
    }

    public static String p(Context r100) {
        if (f517931h == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(f517930g) == true) goto L11;
        return f517930g;
    L11:
        if (f517934k == false) goto L15;
        return f517930g;
    L15:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L17;
        k1.f517430d.b(new b(r100));     // Catch: Throwable -> L21
        goto L20
    L17:
        f517934k = true;     // Catch: Throwable -> L21
        return y(r100);
    L20:
        return f517930g;
    }

    public static String q(Context r100) {
        if (f517935l == false) goto L47;
        String r101 = f517924a;
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101;
    L47:
        String r102 = f517924a;     // Catch: Throwable -> L39
        if (r102 == null) goto L16;
        if ("".equals(r102) == true) goto L16;
        return f517924a;
    L16:
        if (m(r100, f5.o("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT")) == false) goto L19;
        f517924a = o(r100.getContentResolver());     // Catch: Throwable -> L39
    L19:
        if (TextUtils.isEmpty(f517924a) == true) goto L43;
        f517935l = true;     // Catch: Throwable -> L39
        return f517924a;
    L43:
        String r103 = y.k(r100, "Alvin2", "UTDID2");     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r103) == false) goto L41;
        r103 = y.k(r100, "Alvin2", "UTDID");     // Catch: Throwable -> L27
    L41:
        f517924a = r103;     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r103) == true) goto L45;
        f517935l = true;     // Catch: Throwable -> L40
        return f517924a;
    L45:
        f517924a = w(r100);     // Catch: Throwable -> L34
        f517935l = true;     // Catch: Throwable -> L34
    L35:
        String r104 = f517924a;
        if (r104 != null) goto L38;
        return "";
    L38:
        return r104;
    L27:
        r103 = "";
        goto L41
    }

    public static NetworkInfo s(Context r100) {
        if (m(r100, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L5;
        return null;
    L5:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getActiveNetworkInfo();
    }

    public static String t(Context r100) {
    L14:
        return "";
    L4:
        if (m(r100, f5.o("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) == true) goto L6;
        return "";
    L6:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L14
        if (r101 != null) goto L9;
        return "";
    L9:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L14
        if (r102 != null) goto L12;
        return "";
    L12:
        return r102.getTypeName();
    }

    public static String y(Context r100) {
        String r101 = f5.o("IeGlhb21p");
        String r102 = Build.MANUFACTURER;
        if (r101.equalsIgnoreCase(r102) == true) goto L71;
        String r103 = f5.o("IeGlhb21p");
        String r104 = Build.BRAND;
        if (r103.equalsIgnoreCase(r104) == true) goto L71;
        if (f5.o("IUkVETUk=").equalsIgnoreCase(r102) == true) goto L71;
        if (f5.o("IUkVETUk=").equalsIgnoreCase(r104) == true) goto L71;
        if (f5.o("Idml2bw").equalsIgnoreCase(r102) == false) goto L14;
    L73:
        Cursor r105 = n(r100.getContentResolver(), UriProtector.parse(f5.o("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")));     // Catch: Throwable -> L59
        if (r105 == null) goto L62;
    L50:
        if (r105.moveToNext() == false) goto L57;
        int r106 = r105.getColumnCount();     // Catch: Throwable -> L59
        int r107 = 0;
    L52:
        if (r107 >= r106) goto L50;
        if (f5.o("IdmFsdWU").equals(r105.getColumnName(r107)) == true) goto L55;
        r107 = r107 + 1;     // Catch: Throwable -> L59
        goto L52
    L55:
        f517930g = r105.getString(r107);     // Catch: Throwable -> L59
        goto L50
    L57:
        r105.close();     // Catch: Throwable -> L59
    L62:
        return f517930g;
    L59:
        th = move-exception;
        f517931h = true;
        n.a(th, "oa", DimLocationCheckUtil.VIVO);
        goto L62
    L14:
        if (f5.o("Idml2bw").equalsIgnoreCase(r104) == true) goto L73;
        if (f5.o("IaHVhd2Vp").equalsIgnoreCase(r102) == true) goto L46;
        if (f5.o("IaHVhd2Vp").equalsIgnoreCase(r104) == true) goto L46;
        if (f5.o("ISE9OT1I=").equalsIgnoreCase(r102) == true) goto L46;
        if (f5.o("Mc2Ftc3VuZw").equalsIgnoreCase(r102) == true) goto L44;
        if (f5.o("Mc2Ftc3VuZw").equalsIgnoreCase(r104) == true) goto L44;
        if (f5.o("IT1BQTw").equalsIgnoreCase(r102) == true) goto L42;
        if (f5.o("IT1BQTw").equalsIgnoreCase(r104) == true) goto L42;
        if (f5.o("MT25lUGx1cw").equalsIgnoreCase(r102) == true) goto L42;
        if (f5.o("MT25lUGx1cw").equalsIgnoreCase(r104) == true) goto L42;
        if (f5.o("IUkVBTE1F").equalsIgnoreCase(r104) == true) goto L42;
        f517931h = true;
        return f517930g;
    L42:
        return k(r100, 5);
    L44:
        return k(r100, 4);
    L46:
        return k(r100, 2);
    L71:
        Class r108 = h(f5.o("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));     // Catch: Throwable -> L67
        Object r109 = r108.newInstance();     // Catch: Throwable -> L67
        Object r110 = r108.getMethod(f5.o("MZ2V0T0FJRA"), new Class[]{Context.class}).invoke(r109, new Object[]{r100});     // Catch: Throwable -> L67
        if (r110 == null) goto L70;
        String r111 = (String) r110;     // Catch: Throwable -> L67
        f517930g = r111;     // Catch: Throwable -> L67
        return r111;
    L70:
        return f517930g;
    L67:
        th = move-exception;
        n.a(th, "oa", "xm");
        f517931h = true;
        goto L70
    }

    public static Cursor n(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static void g(IBinder r110, Parcel r111, Parcel r112) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r110.transact(1, r111, r112, 0);
        return;
    L6:
        long r100 = SystemClock.uptimeMillis();
        r110.transact(1, r111, r112, 0);     // Catch: Throwable -> L12
        long r101 = SystemClock.uptimeMillis() - r100;
        if (r101 < 100) goto L22;
        BinderPerformanceReporter.report(r101, r110.getClass().getName(), 1, 0, new Throwable("Slow main-thread Binder transaction"));
        return;
    L22:
        return;
    L12:
        th = move-exception;
        long r102 = SystemClock.uptimeMillis() - r100;
        if (r102 < 100) goto L19;
        if (r110 != null) goto L17;
        String r113 = "";
    L18:
        BinderPerformanceReporter.report(r102, r113, 1, 0, new Throwable("Slow main-thread Binder transaction"));
        goto L19
    L17:
        r113 = r110.getClass().getName();
    L19:
        throw th;
    }
}
