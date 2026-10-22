package ova;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.apm.ApmAgent;
import com.bytedance.i18n.claymore.PluginServiceLoader;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.applink.AppLinkConfigV3;
import com.ss.android.lark.applink.AppLinkPathSetting;
import com.ss.android.lark.applink.AppLinkSource;
import com.ss.android.lark.applink.Hosts;
import com.ss.android.lark.applink.ipc.AppLinkProxy;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import dagger.hilt.EntryPoints;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Singleton
public final class f implements pva.c, o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f526943h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f526944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ova.b f526945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ova.d> f526946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ova.d> f526947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Map<String, ova.d>> f526948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AppLink f526949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f526950g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f526951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f526952b;

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.makeToast(this.f526951a, this.f526952b).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100, String r101) {
            this.f526951a = r100;
            this.f526952b = r101;
        }
    }

    public class b implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ova.a f526953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f526954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f526955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f526956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f526957e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f526958f;

        @Override // io.reactivex.functions.Consumer
        public final void accept(String r110) throws Exception {
            String r111 = r110;
            Log.d("AppLinkInstance", "onSuccess = " + r111);
            if (TextUtils.isEmpty(r111) == false) goto L18;
            new qva.a(qva.b.f534928c).b(this.f526956d, System.currentTimeMillis() - this.f526957e, this.f526955c).setErrorMessage("response is empty").flush();
            this.f526958f.B(this.f526954b, this.f526956d, this.f526955c, this.f526953a);
            f.d(this.f526958f, this.f526953a, "10006", "resp null2 ");
            return;
        L18:
            JSONObject r100 = new JSONObject(r111);     // Catch: Exception -> L13
            int r101 = r100.optInt("code", -1);     // Catch: Exception -> L13
            if (r101 == 0) goto L8;
            new qva.a(qva.b.f534928c).b(this.f526956d, System.currentTimeMillis() - this.f526957e, this.f526955c).setErrorCode(String.valueOf(r101)).setErrorMessage("run in exception case ").flush();     // Catch: Exception -> L13
            Log.w("AppLinkInstance", "run in exception case " + r101);     // Catch: Exception -> L13
            f.d(this.f526958f, this.f526953a, "10004", "resp error " + r111);     // Catch: Exception -> L13
            this.f526958f.B(this.f526954b, this.f526956d, this.f526955c, this.f526953a);     // Catch: Exception -> L13
        L17:
            return;
        L8:
            String r102 = JSONObjectProtectorUtils.getJSONObject(r100, "data").optString("link", "");     // Catch: Exception -> L13
            if (TextUtils.isEmpty(r102) == true) goto L11;
            Uri r112 = UriProtector.parse(r102);     // Catch: Exception -> L13
            this.f526953a.f526940d = r112.getPath();     // Catch: Exception -> L13
            this.f526958f.B(this.f526954b, r102, this.f526955c, this.f526953a);     // Catch: Exception -> L13
            f.c(this.f526958f, this.f526953a);     // Catch: Exception -> L13
            goto L17
        L11:
            Log.e("AppLinkInstance", "resp error " + r111);     // Catch: Exception -> L13
            f.d(this.f526958f, this.f526953a, "10003", "resp null " + r111);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            f.d(this.f526958f, this.f526953a, "10005", "resp Exception " + e.toString());
        }

        public b(f r100, ova.a r101, Context r102, int r103, String r104, long r105) {
            this.f526958f = r100;
            this.f526953a = r101;
            this.f526954b = r102;
            this.f526955c = r103;
            this.f526956d = r104;
            this.f526957e = r105;
        }
    }

    public class c implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f526959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f526960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f526961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ova.a f526962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f526963e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f526964f;

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            Throwable r101 = r100;
            Log.w("AppLinkInstance", "onError = " + r101);
            if ((r101.getCause() instanceof TimeoutException) == false) goto L5;
            new qva.a(qva.b.f534927b).b(this.f526959a, System.currentTimeMillis() - this.f526960b, this.f526961c).setError(r101).flush();
        L6:
            f.d(this.f526964f, this.f526962d, "10007", r101.toString());
            this.f526964f.B(this.f526963e, this.f526959a, this.f526961c, this.f526962d);
            return;
        L5:
            new qva.a(qva.b.f534928c).b(this.f526959a, System.currentTimeMillis() - this.f526960b, this.f526961c).setError(r101).flush();
            goto L6
        }

        public c(f r100, String r101, long r102, int r103, ova.a r104, Context r105) {
            this.f526964f = r100;
            this.f526959a = r101;
            this.f526960b = r102;
            this.f526961c = r103;
            this.f526962d = r104;
            this.f526963e = r105;
        }
    }

    public class d implements ObservableOnSubscribe<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendHttpRequest.Builder f526965a;

        public class a implements SdkSender.IParser<String> {
            public a() {
            }

            @Override // com.ss.android.lark.sdk.SdkSender.IParser
            public final String parse(byte[] r100) throws IOException {
                SendHttpResponse r101 = SendHttpResponse.ADAPTER.decode(r100);
                Log.d("AppLinkInstance", "body = " + r101.json_body);
                return r101.json_body;
            }
        }

        public d(SendHttpRequest.Builder r100) {
            this.f526965a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<String> r100) throws Exception {
            SdkSender.d r101 = SdkSender.syncSendMayError(Command.SEND_HTTP, this.f526965a, new a());
            if (r101.f439868b == null) goto L5;
            Log.i("AppLinkInstance", "result error is: " + r101.f439868b);
            r100.onError(r101.f439868b);
        L6:
            r100.onComplete();
            return;
        L5:
            r100.onNext((String) r101.f439867a);
            goto L6
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f526966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f526967b;

        public e(String r100) {
            this.f526966a = true;
            this.f526967b = r100;
        }

        public e(boolean r100) {
            this.f526966a = r100;
        }
    }

    static {
        f526943h = 2000;
    }

    public static void E() {
        opb.e r100 = opb.e.a.f524824a;
        opb.b r101 = r100.f524819d;
        jpb.a r102 = (jpb.a) ((ConcurrentHashMap) r100.b()).get(LarkSettingModuleDependency.KEY_SHORTLINK);
        r101.getClass();
        String r103 = LarkSettingModuleDependency.KEY_SHORTLINK.concat("_v1");
        if (r102 != null) goto L5;
    L8:
        String r104 = spb.a.b().getString(r103, "");
    L15:
        q r105 = new q(JSONObjectProtectorUtils.getLong(new JSONObject(r104), "net_timeout"));     // Catch: Exception -> L11
    L13:
        f526943h = r105.f526974a;
        Log.i("AppLinkInstance", "setShortLinkTimeout: " + f526943h);
        return;
    L11:
        e = move-exception;
        Log.e("Applink-ShortLinkConfig", "Applink config parse error", e);
        r105 = new q(500);
        goto L13
    L5:
        if (r102.f500011a == true) goto L8;
        r104 = spb.a.a().getString(r103, "");
        goto L15
    }

    public static f m() {
        return (f) ((ova.c) EntryPoints.get(LarkContext.getApplication(), ova.c.class)).b();
    }

    public static boolean s() {
        return LarkAppContext.inst().buildConfig().isMempopeApp();
    }

    public static boolean q(Uri r110) {
        if (r110 != null) goto L5;
        Log.i("AppLinkInstance", "isAppLink uri is null");
    L98:
        boolean r100 = false;
    L100:
        if (r100 == false) goto L102;
        return true;
    L102:
        if (r(r110) == true) goto L129;
        return false;
    L129:
        return true;
    L5:
        String r101 = r110.getScheme();
        if (rva.a.b(r101, true) == true) goto L8;
        Log.i("AppLinkInstance", "not app-link schema:" + r101);
        goto L98
    L8:
        String r102 = r110.getHost();
        if (r102 != null) goto L11;
        Log.i("AppLinkInstance", "link host is null");
        goto L98
    L11:
        Log.i("AppLinkInstance", "host ".concat(r102));
        Unit r103 = null;
        if (s() == false) goto L54;
        Set<String> r111 = h.f526968a;
        ArrayList r112 = new ArrayList();
        AppLinkPathSetting r113 = (AppLinkPathSetting) SettingManager.getInstance().get(AppLinkPathSetting.class);     // Catch: Exception -> L28
        if (r113 == null) goto L26;
        Hosts r114 = r113.b();     // Catch: Exception -> L28
        if (r114 == null) goto L26;
        List<String> r115 = r114.getReg_exp();     // Catch: Exception -> L28
        if (r115 == null) goto L25;
        Iterator<T> r104 = r115.iterator();     // Catch: Exception -> L28
    L22:
        if (r104.hasNext() == false) goto L24;
        r112.add((String) r104.next());     // Catch: Exception -> L28
        goto L22
    L24:
        r103 = Unit.INSTANCE;     // Catch: Exception -> L28
    L25:
        if (r103 == null) goto L26;
    L31:
        if (CollectionUtils.isEmpty(r112) == true) goto L41;
        Iterator r105 = r112.iterator();
    L34:
        if (r105.hasNext() == false) goto L42;
        String r106 = (String) r105.next();
        Log.i("AppLinkInstance", "memPope regex, " + r106);     // Catch: PatternSyntaxException -> L40
        if (Pattern.matches(r106, r110.getHost()) == false) goto L34;
        Log.i("AppLinkInstance", "memPope regex, " + r106 + "match " + r110.getHost());     // Catch: PatternSyntaxException -> L40
        boolean r107 = true;
    L43:
        boolean r108 = !r107;
        if ("mempope".equals(r110.getHost()) == true) goto L46;
    L48:
        boolean r109 = false;
    L49:
        Log.i("AppLinkInstance", "is No domain host," + r109);
        if ((r108 & (!r109)) == false) goto L91;
        if (r102.startsWith("mempope.") == true) goto L91;
        Log.i("AppLinkInstance", "mempope host not starts with applink.");
    L91:
        if ("https".equals(r110.getScheme()) == true) goto L93;
    L95:
        boolean r116 = false;
    L96:
        if (r116 == false) goto L99;
        Log.i("AppLinkInstance", "not app-link for support");
        goto L98
    L99:
        r100 = true;
        goto L100
    L93:
        if (UriProtector.getQueryParameter(r110, "applink_ex") == null) goto L95;
        r116 = true;
        goto L96
    L46:
        if (rva.a.b(r110.getScheme(), false) == false) goto L48;
        r109 = true;
    L40:
        Log.e("AppLinkInstance", "memPope regex exception, " + r106 + ", " + r110.getHost());
    L42:
        r107 = false;
        goto L43
    L41:
        Log.e("AppLinkInstance", "setting host regex empty");
    L26:
        Log.e("AppLinkSetting", "getPath null");     // Catch: Exception -> L28
    L28:
        e = move-exception;
        Log.e("AppLinkSetting", "json parse exception: ", e);
        goto L31
    L54:
        Set<String> r117 = h.f526968a;
        ArrayList r118 = new ArrayList();
        AppLinkPathSetting r119 = (AppLinkPathSetting) SettingManager.getInstance().get(AppLinkPathSetting.class);     // Catch: Exception -> L69
        if (r119 == null) goto L67;
        Hosts r120 = r119.a();     // Catch: Exception -> L69
        if (r120 == null) goto L67;
        List<String> r121 = r120.getReg_exp();     // Catch: Exception -> L69
        if (r121 == null) goto L66;
        Iterator<T> r122 = r121.iterator();     // Catch: Exception -> L69
    L63:
        if (r122.hasNext() == false) goto L65;
        r118.add((String) r122.next());     // Catch: Exception -> L69
        goto L63
    L65:
        r103 = Unit.INSTANCE;     // Catch: Exception -> L69
    L66:
        if (r103 == null) goto L67;
    L72:
        if (r118.isEmpty() == true) goto L82;
        Iterator r123 = r118.iterator();
    L75:
        if (r123.hasNext() == false) goto L83;
        String r124 = (String) r123.next();
        Log.i("AppLinkInstance", "regex, " + r124);     // Catch: PatternSyntaxException -> L81
        if (Pattern.matches(r124, r110.getHost()) == false) goto L75;
        Log.i("AppLinkInstance", "regex, " + r124 + "match " + r110.getHost());     // Catch: PatternSyntaxException -> L81
        boolean r125 = true;
    L84:
        if (r125 == true) goto L91;
        if (t(r110) == true) goto L91;
        if (r102.startsWith("applink.") == true) goto L91;
        Log.i("AppLinkInstance", "host not starts with applink.");
    L81:
        Log.e("AppLinkInstance", "regex exception, " + r124 + ", " + r110.getHost());
    L83:
        r125 = false;
        goto L84
    L82:
        Log.e("AppLinkInstance", "setting host regex empty");
    L67:
        Log.e("AppLinkSetting", "getPath null");     // Catch: Exception -> L69
    L69:
        e = move-exception;
        Log.e("AppLinkSetting", "json parse exception: ", e);
        goto L72
    }

    public static boolean r(Uri r110) {
        if (s() == true) goto L62;
        int r100 = l.f526973a;
        Intrinsics.checkNotNullParameter(r110, "uri");
        Log.i("ApplinkV3", "isAppLinkV3 " + r110.getHost());
        if (idb.f.a().isCurrentEnable("openplatform.applink.v3") == true) goto L8;
        Log.e("ApplinkV3", "isAppLinkV3 fg not enabled");
    L58:
        boolean r101 = false;
    L59:
        if (r101 == false) goto L63;
        return true;
    L63:
        return false;
    L8:
        if (r110.isOpaque() == true) goto L58;
        if ("https".equals(r110.getScheme()) == true) goto L13;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L18;
        Log.i("ApplinkV3", "not app-link for support");
        goto L58
    L18:
        AppLinkConfigV3 r103 = (AppLinkConfigV3) SettingManager.getInstance().get(AppLinkConfigV3.class);
        if (r103 == null) goto L21;
        List<String> r104 = r103.b();
    L22:
        if (r104 != null) goto L24;
        Log.e("ApplinkV3", "setting hosts null");
        goto L58
    L24:
        Log.i("ApplinkV3", "settings hosts " + CollectionsKt.joinToString$default(r104, ",", null, null, 0, null, null, 62, null));
        if (r104.contains(r110.getHost()) == false) goto L58;
        Log.i("ApplinkV3", "is applink host, path is " + r110.getPath());
        AppLinkConfigV3 r105 = (AppLinkConfigV3) SettingManager.getInstance().get(AppLinkConfigV3.class);
        if (r105 == null) goto L57;
        List<String> r106 = r105.c();
        if (r106 != null) goto L31;
    L34:
        boolean r107 = true;
    L35:
        if (r107 == true) goto L57;
        List<String> r108 = r105.c();
        List<String> r109 = r105.d();
        List<String> r111 = r108;
        if (r111 != null) goto L40;
    L43:
        boolean r112 = true;
    L44:
        if (r112 == false) goto L46;
        Log.e("ApplinkV3", "paths is null");
        goto L58
    L46:
        Log.i("ApplinkV3", "settings paths " + CollectionsKt.joinToString$default(r108, ",", null, null, 0, null, null, 62, null));
        List<String> r113 = r110.getPathSegments();
        Intrinsics.checkNotNull(r113);
        if ((!r113.isEmpty()) == false) goto L56;
        String r114 = HTTP.URL_DEFAULT + ((String) ListProtector.get(r113, 0));
        if (r108.contains(r114) == true) goto L54;
        if (r109 != null) goto L53;
    L55:
        Log.e("ApplinkV3", "paths not contains root path");
        goto L58
    L53:
        if (r109.contains(r114) == false) goto L55;
    L54:
        r101 = true;
        goto L59
    L56:
        Log.e("ApplinkV3", "uri paths is null");
        goto L58
    L40:
        if (r111.isEmpty() == true) goto L43;
        r112 = false;
        goto L44
    L31:
        if (r106.isEmpty() == true) goto L34;
        r107 = false;
    L57:
        Log.e("ApplinkV3", "config is null");
        goto L58
    L21:
        r104 = null;
        goto L22
    L13:
        if (UriProtector.getQueryParameter(r110, "applink_ex") == null) goto L15;
        r102 = true;
        goto L16
    L62:
        return false;
    }

    public static boolean t(Uri r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L9:
        Log.i("AppLinkInstance", "is No domain host," + r101);
        return r101;
    L5:
        if ("applink".equals(r100.getHost()) == false) goto L9;
        if (rva.a.b(r100.getScheme(), false) == false) goto L9;
        r101 = true;
        goto L9
    }

    public static boolean u(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == true) goto L16;
        Uri r102 = UriProtector.parse(r100);
        if (q(r102) == true) goto L19;
        Log.i("AppLinkInstance", "isShortLink uri is not applink");
    L17:
        Log.w("AppLinkInstance", "isShortLink = " + r101);
        return r101;
    L19:
        String r103 = r102.getPath();     // Catch: Exception -> L13
        if (r103.length() <= 1) goto L17;
        String r104 = r103.replaceFirst(HTTP.URL_DEFAULT, "");     // Catch: Exception -> L13
        if (r104.endsWith(HTTP.URL_DEFAULT) == false) goto L11;
        r104 = r104.substring(0, r104.length() - 1);     // Catch: Exception -> L13
    L11:
        r101 = Pattern.matches("^[A-Za-z0-9]+$", r104);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        Log.w("AppLinkInstance", "shortLink error " + e);
        goto L17
    L16:
        Log.i("AppLinkInstance", "shortlink fg is closed or url is empty");
        goto L17
    }

    @Override // pva.c
    public final void b(UserSession r100) {
        Map<String, Map<String, ova.d>> r101 = this.f526948e;
        HashMap r102 = (HashMap) r101;
        r102.remove(r100.f438138b);
    }

    public final AppLink l(AppLink r100) {
        String r101 = r100.f408912a;
        int r102 = r100.f408913b;
        UserSession r103 = this.f526944a.f();
        String r104 = r100.f408915d;
        Bundle r105 = r100.f408916e;
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r103, "userSession");
        return new AppLink(r101, r102, r103, r104, r105);
    }

    @Inject
    public f(com.ss.android.lark.passportc.api.j r100, ova.b r101) {
        this.f526948e = new HashMap();
        this.f526944a = r100;
        this.f526945b = r101;
        this.f526946c = new HashMap();
        String r102 = "";
        String r103 = ApkUtil.getAppVersionName(LarkContext.getApplication());     // Catch: Exception -> L11
        if (r103 != null) goto L31;
    L7:
        Log.i("AppLinkInstance", "AppVersionName is null");     // Catch: Exception -> L9
    L15:
        this.f526950g = r102;
        E();
        monitor-enter(this);
        HashMap r104 = new HashMap();     // Catch: Throwable -> L28
        Iterator r105 = PluginServiceLoader.loadAll(pva.b.class);     // Catch: Throwable -> L28
    L19:
        if (r105.hasNext() == false) goto L21;
        pva.b r106 = (pva.b) r105.next();     // Catch: Throwable -> L28
        Map<String, ova.d> r107 = r106.a(LarkContext.getApplication());     // Catch: Throwable -> L28
        r104.putAll(r107);     // Catch: Throwable -> L28
        Log.i("AppLinkInstance", "AppLinkInstance registerHandlers <" + r106 + ">, " + r107);     // Catch: Throwable -> L28
        goto L19
    L21:
        this.f526946c = r104;     // Catch: Throwable -> L28
        Iterator r108 = r104.entrySet().iterator();     // Catch: Throwable -> L28
    L22:
        if (r108.hasNext() == false) goto L26;
        Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Throwable -> L28
        if (p((String) r109.getKey(), (ova.d) r109.getValue()) == false) goto L22;
    L26:
        monitor-exit(this);
        return;
    L28:
        th = move-exception;
        throw th;
    L9:
        Exception e100 = e;
    L13:
        Log.e("AppLinkInstance", e100.toString());
    L14:
        r102 = r103;
        goto L15
    L31:
        if (r103.length() > 0) goto L14;
    L11:
        e = move-exception;
        e100 = e;
        r103 = "";
        goto L13
    }

    public static void D(String r100, JSONObject r101) {
        ApmAgent.monitorEvent(r100, new JSONObject(r101.toString()), new JSONObject(), new JSONObject());     // Catch: Exception -> L4
    L6:
        Statistics.sendEvent(r100, r101);
        return;
    L4:
        e = move-exception;
        Log.e("AppLinkInstance", "error: " + e);
        goto L6
    }

    public static void c(f r100, ova.a r101) {
        r100.getClass();
        long r102 = System.currentTimeMillis() - r101.f526937a;
        OPMonitor r103 = new OPMonitor("applink_short_to_long_dev").setResultTypeSuccess().setDuration(r102).reportPlatform(4);
        if (TextUtils.isEmpty(r101.f526939c) == true) goto L6;
        r103.addCategoryValue("path", r101.f526939c);
    L6:
        if (TextUtils.isEmpty(r101.f526940d) == true) goto L8;
        r103.addCategoryValue("long_path", r101.f526940d);
    L8:
        r103.flush();
    }

    public static boolean j(String r100, String r101) {
        if (s() == false) goto L35;
        if (r101 == null) goto L30;
        Set<String> r102 = h.f526969b;
        if (r102 != null) goto L20;
        AppLinkPathSetting r103 = (AppLinkPathSetting) SettingManager.getInstance().get(AppLinkPathSetting.class);
        if (r103 == null) goto L18;
        List<String> r104 = r103.c();
        if (r104 == null) goto L18;
        HashSet r105 = new HashSet();
        Iterator r106 = CollectionsKt.filterNotNull(r104).iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        r105.add((String) r106.next());
        goto L15
    L17:
        h.f526969b = r105;
    L19:
        r102 = h.f526969b;
    L18:
        Log.e("AppLinkSetting", "getPath null");
    L20:
        if (r102 == null) goto L31;
        String r107 = r101.concat(HTTP.URL_DEFAULT);
        if (r102.contains(r101) == false) goto L24;
    L32:
        boolean r108 = true;
    L33:
        if (r108 == true) goto L69;
    L65:
        return true;
    L69:
        return false;
    L24:
        if (r102.contains(r107) == true) goto L32;
        if (l.a(UriProtector.parse(r100)) == true) goto L32;
        Log.i("PathCheck", "mempope not in path:".concat(r101));
        goto L30
    L31:
        Log.e("PathCheck", "mempope setting not paths data");
    L30:
        r108 = false;
        goto L33
    L35:
        if (r101 == null) goto L61;
        Set<String> r109 = h.f526968a;
        if (r109 != null) goto L51;
        AppLinkPathSetting r110 = (AppLinkPathSetting) SettingManager.getInstance().get(AppLinkPathSetting.class);
        if (r110 == null) goto L49;
        List<String> r111 = r110.d();
        if (r111 == null) goto L49;
        HashSet r112 = new HashSet();
        Iterator r113 = CollectionsKt.filterNotNull(r111).iterator();
    L46:
        if (r113.hasNext() == false) goto L48;
        r112.add((String) r113.next());
        goto L46
    L48:
        h.f526968a = r112;
    L50:
        r109 = h.f526968a;
    L49:
        Log.e("AppLinkSetting", "getPath null");
    L51:
        if (r109 == null) goto L62;
        String r114 = r101.concat(HTTP.URL_DEFAULT);
        if (r109.contains(r101) == false) goto L55;
    L63:
        boolean r115 = true;
    L64:
        if (r115 == false) goto L65;
        return false;
    L55:
        if (r109.contains(r114) == true) goto L63;
        if (l.a(UriProtector.parse(r100)) == true) goto L63;
        Log.i("PathCheck", "not in path:".concat(r101));
        new qva.a(qva.b.f534933h).addCategoryValue("url", r100).addCategoryValue("config_msg", "path not right").flush();
        goto L61
    L62:
        Log.e("PathCheck", "setting not paths data");
    L61:
        r115 = false;
        goto L64
    }

    public static boolean k(Context r100, Uri r101) {
        String r102 = UriProtector.getQueryParameter(r101, "sec_user_id");
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return true;
    L5:
        xzb.a r103 = (xzb.a) ApiUtils.getApi(xzb.a.class);
        if (r103 == null) goto L8;
        String r104 = r103.getUserId();
    L10:
        if (TextUtils.isEmpty(r104) == false) goto L12;
        Log.i("AppLinkInstance", "currentUserId is null");
        return false;
    L12:
        if (com.larksuite.framework.utils.s.a(r104.getBytes()).equals(r102) == true) goto L15;
        Log.i("AppLinkInstance", "current userId/userId in applink do not match");
        String r105 = UIHelper.getString(R.string.Lark_App_Name);
        ThreadUtils.runOnUIThread(new a(r100, r100.getString(R.string.OpenPlatform_AppLink_Check_UserID_FeatureToast).replace("{APP_DISPLAY_NAME}", r105)));
        return false;
    L15:
        return true;
    L8:
        Log.d("AppLinkInstance", "iPassportApi is null");
        r104 = null;
        goto L10
    }

    public static void v(Uri r100, String r101) {
        String r102 = UriProtector.getQueryParameter(r100, "appId");     // Catch: Exception -> L5
    L7:
        new OPMonitor("applink_start_handle").addCategoryValue("path", r100.getPath()).addCategoryValue("appId", r102).addCategoryValue("applink_trace_id", r101).reportPlatform(6).flush();
        return;
    L5:
        e = move-exception;
        Log.e("AppLinkInstance", e.getMessage());
        r102 = "";
        goto L7
    }

    public final synchronized boolean h(Context r100, Uri r101) {
        monitor-enter(this);
        if (r101 != null) goto L9;
        Log.i("AppLinkInstance", "canOpenExternal uri null");     // Catch: Throwable -> L15
        monitor-exit(this);
        return false;
    L9:
        if (q(r101) == true) goto L12;
        monitor-exit(this);
        return false;
    L12:
        e r102 = f(r100, r101.toString(), 1, true);     // Catch: Throwable -> L15
        String r103 = gyb.a.a().getTracingID();     // Catch: Throwable -> L15
        ova.a r104 = new ova.a(System.currentTimeMillis(), r101.getPath(), r103);     // Catch: Throwable -> L15
        w(r102.f526966a, r101.toString(), r102.f526967b, r104);     // Catch: Throwable -> L15
        boolean r105 = r102.f526966a;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r105;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean p(String r100, ova.d r101) {
        monitor-enter(this);
        AppLink r102 = this.f526949f;     // Catch: Throwable -> L14
        if (r102 != null) goto L6;
    L11:
        monitor-exit(this);
        return false;
    L6:
        if (TextUtils.equals(r100, UriProtector.parse(r102.f408912a).getPath()) == false) goto L11;
        r101.a(null, l(this.f526949f));     // Catch: Throwable -> L14
        this.f526949f = null;     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void x(Context r100, Uri r101) {
        monitor-enter(this);
        if (r101 != null) goto L8;
        new qva.a(qva.b.f534926a).flush();     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L8:
        if (q(r101) == true) goto L13;
        Log.i("AppLinkInstance", "openExternalWithLoginInfo uri is not AppLink");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L13:
        if (k(r100, r101) == true) goto L17;
        Log.i("AppLinkInstance", "openExternalWithLoginInfo check sec_user_id failed");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L17:
        String r102 = gyb.a.a().getTracingID();     // Catch: Throwable -> L38
        ova.a r103 = new ova.a(System.currentTimeMillis(), r101.getPath(), r102);     // Catch: Throwable -> L38
        String r104 = r101.toString();     // Catch: Throwable -> L38
        if (idb.f.a().isCurrentEnable("openplatform.applink.disable_short_link_trim") == true) goto L21;
        r104 = StringsKt.trimEnd(r104, new ova.e());     // Catch: Throwable -> L38
    L21:
        if (u(r104) == false) goto L26;
        o(r100, r104, 1, r103);     // Catch: Throwable -> L38
        Log.w("AppLinkInstance", "openExternal is shortLink");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L26:
        if (r(r101) == false) goto L30;
        Log.w("AppLinkInstance", "openExternal is isApplinkV3");     // Catch: Throwable -> L38
        n(r100, r101, 1, r103, new Bundle());     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L30:
        Log.i("AppLinkInstance", "openExternalWithLoginInfo uri is not shortLink");     // Catch: Throwable -> L38
        v(r101, r102);     // Catch: Throwable -> L38
        e r105 = f(r100, r101.toString(), 1, false);     // Catch: Throwable -> L38
        if (r105.f526966a == true) goto L35;
        Log.i("AppLinkInstance", "openExternalWithLoginInfo result of openResult is false");     // Catch: Throwable -> L38
        w(false, r101.toString(), r105.f526967b, r103);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L35:
        y(r100, r101.toString(), 1);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L38:
        th = move-exception;
        throw th;
    }

    public static JSONObject e(String r110, String r111, ova.a r112) {
        JSONObject r100 = new JSONObject();
        String r101 = AppLinkSource.f408917a[1];
        if (r110 == null) goto L5;
        Uri r113 = UriProtector.parse(r110);
        String r102 = r113.getScheme();
        String r103 = r113.getHost();
        String r104 = r113.getPath();
        String r105 = UriProtector.getQueryParameter(r113, "appId");
        String r114 = UriProtector.getQueryParameter(r113, "op_tracking");
    L6:
        long r106 = System.currentTimeMillis() - r112.f526937a;
        r100.put("scheme", r102);     // Catch: JSONException -> L22
        r100.put("host", r103);     // Catch: JSONException -> L22
        r100.put("path", r104);     // Catch: JSONException -> L22
        r100.put("from", r101);     // Catch: JSONException -> L22
        r100.put("type", r111);     // Catch: JSONException -> L22
        r100.put("duration", r106);     // Catch: JSONException -> L22
        if (r112.f526938b == false) goto L16;
        if (TextUtils.isEmpty(r112.f526939c) == true) goto L13;
        r100.put("path", r112.f526939c);     // Catch: JSONException -> L22
    L13:
        if (TextUtils.isEmpty(r112.f526940d) == true) goto L16;
        r100.put("long_path", r112.f526940d);     // Catch: JSONException -> L22
    L16:
        if (TextUtils.isEmpty(r105) == true) goto L19;
        r100.put("appId", r105);     // Catch: JSONException -> L22
    L19:
        if (TextUtils.isEmpty(r114) == true) goto L21;
        r100.put("op_tracking", r114);     // Catch: JSONException -> L22
    L21:
        return r100;
    L5:
        r102 = null;
        r114 = null;
        r103 = null;
        r104 = null;
        r105 = null;
        goto L6
    }

    public final synchronized void A(Context r100, String r110, int r111) {
        monitor-enter(this);
        Uri r101 = UriProtector.parse(r110);     // Catch: Throwable -> L25
        if (q(r101) == true) goto L9;
        Log.i("AppLinkInstance", "openInternal uri is not AppLink");     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L9:
        String r102 = gyb.a.a().getTracingID();     // Catch: Throwable -> L25
        ova.a r103 = new ova.a(System.currentTimeMillis(), r101.getPath(), r102);     // Catch: Throwable -> L25
        String r104 = r101.toString();     // Catch: Throwable -> L25
        if (idb.f.a().isCurrentEnable("openplatform.applink.disable_short_link_trim") == true) goto L13;
        r104 = StringsKt.trimEnd(r104, new ova.e());     // Catch: Throwable -> L25
    L13:
        if (u(r104) == false) goto L18;
        Log.i("AppLinkInstance", "openInternal uri is shortLink");     // Catch: Throwable -> L25
        o(r100, r104, r111, r103);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L18:
        if (r(r101) == false) goto L22;
        Log.i("AppLinkInstance", "openInternal uri is handleLinkV3");     // Catch: Throwable -> L25
        n(r100, r101, r111, r103, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        Log.i("AppLinkInstance", "openInternal uri is not shortLink");     // Catch: Throwable -> L25
        B(r100, r110, r111, r103);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // pva.c
    public final void a(UserSession r100, boolean r101, pva.a r102) {
        Boolean r103 = Boolean.valueOf(r101);
        Map<String, ova.d> r104 = r102.b();
        monitor-enter(this);
        Map<String, Map<String, ova.d>> r105 = this.f526948e;     // Catch: Throwable -> L23
        HashMap r106 = (HashMap) r105;     // Catch: Throwable -> L23
        r106.put(r100.f438138b, r104);     // Catch: Throwable -> L23
        if (r103.booleanValue() == false) goto L16;
        Map<String, ova.d> r107 = this.f526947d;     // Catch: Throwable -> L23
        if (r107 == null) goto L12;
        Iterator<String> r108 = r107.keySet().iterator();     // Catch: Throwable -> L23
    L10:
        if (r108.hasNext() == false) goto L12;
        String r109 = r108.next();     // Catch: Throwable -> L23
        ((HashMap) this.f526946c).remove(r109);     // Catch: Throwable -> L23
    L12:
        this.f526947d = r104;     // Catch: Throwable -> L23
        Iterator<String> r110 = r104.keySet().iterator();     // Catch: Throwable -> L23
    L14:
        if (r110.hasNext() == false) goto L16;
        String r111 = r110.next();     // Catch: Throwable -> L23
        Map<String, ova.d> r112 = this.f526946c;     // Catch: Throwable -> L23
        HashMap r113 = (HashMap) r112;     // Catch: Throwable -> L23
        r113.put(r111, this.f526947d.get(r111));     // Catch: Throwable -> L23
    L16:
        Iterator r114 = ((HashMap) this.f526946c).entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r114.hasNext() == false) goto L21;
        Map.Entry r115 = (Map.Entry) r114.next();     // Catch: Throwable -> L23
        if (p((String) r115.getKey(), (ova.d) r115.getValue()) == false) goto L17;
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean i(Context r100, String r101, int r102) {
        monitor-enter(this);
        boolean r103 = f(r100, r101, r102, true).f526966a;     // Catch: Throwable -> L7
        monitor-exit(this);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void y(Context r100, String r101, int r102) {
        monitor-enter(this);
        z(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void z(Context r100, String r101, int r102) {
        monitor-enter(this);
        A(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static void d(f r100, ova.a r101, String r102, String r103) {
        r100.getClass();
        long r104 = System.currentTimeMillis() - r101.f526937a;
        OPMonitor r105 = new OPMonitor("applink_short_to_long_dev").setResultTypeFail().setDuration(r104).setErrorCode(r102).setErrorMessage(r103).reportPlatform(4);
        if (TextUtils.isEmpty(r101.f526939c) == true) goto L5;
        r105.addCategoryValue("path", r101.f526939c);
    L5:
        r105.flush();
    }

    public static void w(boolean r100, String r101, String r102, ova.a r103) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (q(UriProtector.parse(r101)) == true) goto L7;
        return;
    L7:
        if (r100 == false) goto L10;
        if (r102 != null) goto L10;
        D("applink_click", e(r101, r102, r103));
        return;
    L10:
        D("applink_invalid_click", e(r101, r102, r103));
    }

    public final synchronized void B(Context r100, String r101, int r102, ova.a r110) {
        monitor-enter(this);
        C(r100, r101, r102, r110, null);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized e f(Context r100, String r101, int r102, boolean r103) {
        monitor-enter(this);
        e r104 = g(r100, r101, r102, r103);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r104;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized e g(Context r210, String r211, int r212, boolean r213) {
        monitor-enter(this);
        if (r211 != null) goto L9;
        Log.i("AppLinkInstance", "canOpen url is null");     // Catch: Throwable -> L66
        e r100 = new e(false);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r100;
    L9:
        Uri r101 = UriProtector.parse(r211);     // Catch: Throwable -> L66
        if (q(r101) == true) goto L15;
        Log.i("AppLinkInstance", "canOpen uri is not applink");     // Catch: Throwable -> L66
        e r102 = new e(false);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r102;
    L15:
        if (r(r101) == false) goto L17;
        String r103 = l.b(UriProtector.parse(r211)).toString();     // Catch: Throwable -> L66
        String r110 = r103;
        Uri r111 = UriProtector.parse(r103);     // Catch: Throwable -> L66
    L19:
        if (idb.f.a().isCurrentEnable("open_platform.applink.open_fix") == false) goto L23;
        e r104 = new e(true);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r104;
    L23:
        boolean r105 = i.b(r111, this.f526950g);     // Catch: Throwable -> L66
        Log.i("AppLinkInstance", "versionOk : " + r105);     // Catch: Throwable -> L66
        String r106 = UriProtector.getQueryParameter(r111, "op_tracking");     // Catch: Throwable -> L66
        if (r105 == true) goto L33;
        Log.i("AppLinkInstance", "version is not ok");     // Catch: Throwable -> L66
        if (r213 == false) goto L30;
        e r107 = new e("versionUnavailable");     // Catch: Throwable -> L66
        monitor-exit(this);
        return r107;
    L30:
        Log.i("AppLinkInstance", "can not open support page and open support web in checking version");     // Catch: Throwable -> L66
        i.a(r210, r111, this.f526950g);     // Catch: Throwable -> L66
        new qva.a(qva.b.f534929d).a(r110, r212, false, r106).addCategoryValue("version_name", this.f526950g).flush();     // Catch: Throwable -> L66
        e r108 = new e(false);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r108;
    L33:
        String r109 = r111.getPath();     // Catch: Throwable -> L66
        Log.i("AppLinkInstance", "path : " + r109 + " isMemPope:" + s());     // Catch: Throwable -> L66
        if (j(r110, r109) == false) goto L43;
        Log.i("AppLinkInstance", "check path error:" + r110);     // Catch: Throwable -> L66
        if (r213 == false) goto L40;
        e r112 = new e("noInWhiteList");     // Catch: Throwable -> L66
        monitor-exit(this);
        return r112;
    L40:
        Log.i("AppLinkInstance", "can not open support page and open support web in checking path");     // Catch: Throwable -> L66
        new qva.a(qva.b.f534930e).a(r110, r212, false, r106).flush();     // Catch: Throwable -> L66
        i.a(r210, r111, this.f526950g);     // Catch: Throwable -> L66
        e r113 = new e(false);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r113;
    L43:
        ova.d r114 = (ova.d) ((HashMap) this.f526946c).get(r109);     // Catch: Throwable -> L66
        String r115 = gyb.a.a().getTracingID();     // Catch: Throwable -> L66
        UserSession r116 = this.f526944a.f();     // Catch: Throwable -> L66
        Intrinsics.checkNotNullParameter(r110, "url");     // Catch: Throwable -> L66
        Intrinsics.checkNotNullParameter(r116, "userSession");     // Catch: Throwable -> L66
        Uri r117 = r111;
        AppLink r118 = new AppLink(r110, r212, r116, r115, null);     // Catch: Throwable -> L66
        if (r114 == null) goto L51;
        boolean r119 = r114.b(r210, r118);     // Catch: Throwable -> L66
        if (r119 == true) goto L48;
        new qva.a(qva.b.f534931f).a(r110, r212, r213, null).flush();     // Catch: Throwable -> L66
    L48:
        Log.i("AppLinkInstance", "canOpen enter fix:" + r119);     // Catch: Throwable -> L66
        e r120 = new e(true);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r120;
    L51:
        Log.i("AppLinkInstance", "no handler for path: " + r109);     // Catch: Throwable -> L66
        if (r212 != 1) goto L54;
        boolean r121 = true;
    L55:
        if (r121 == false) goto L59;
        this.f526949f = r118;     // Catch: Throwable -> L66
        e r122 = new e(false);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r122;
    L59:
        if (r213 == false) goto L63;
        e r123 = new e("noHandler");     // Catch: Throwable -> L66
        monitor-exit(this);
        return r123;
    L63:
        Log.i("AppLinkInstance", "cannot open support page and open support web when np handler");     // Catch: Throwable -> L66
        i.a(r210, r117, this.f526950g);     // Catch: Throwable -> L66
        new qva.a(qva.b.f534932g).a(r110, r212, false, r106).flush();     // Catch: Throwable -> L66
        e r124 = new e(false);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r124;
    L54:
        r121 = false;
        goto L55
    L17:
        r110 = r211;
        r111 = r101;
    L66:
        th = move-exception;
        throw th;
    }

    public final void o(Context r110, String r111, int r112, ova.a r113) {
        SendHttpRequest.Builder r100 = new SendHttpRequest.Builder();
        E();
        String r101 = jcb.b.c().a("open");
        Log.i("AppLinkInstance", "host");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        Uri.Builder r102 = new Uri.Builder();
        r102.scheme("https");
        r102.authority(r101);
        r102.path("/open-apis/applink/longlink/v1/get");
        r102.appendQueryParameter("shortLink", r111);
        r102.appendQueryParameter("businessTag", "shortApplink");
        String r103 = r102.toString();
    L6:
        Log.i("AppLinkInstance", "constructUrl = " + r103);
        SendHttpRequest.Builder r104 = r100.url(r103).method(SendHttpRequest.Method.GET);
        Log.d("AppLinkInstance", "begin shortLink to longLink request");
        r113.f526938b = true;
        long r114 = System.currentTimeMillis();
        Observable.create(new d(r104)).timeout(f526943h, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(new b(this, r113, r110, r112, r111, r114), new c(this, r111, r114, r112, r113, r110));
        return;
    L5:
        r103 = "";
        goto L6
    }

    public final synchronized boolean C(Context r110, String r111, int r112, ova.a r210, Bundle r211) {
        monitor-enter(this);
        Uri r100 = UriProtector.parse(r111);     // Catch: Throwable -> L74
        if (r210 != null) goto L7;
        Log.i("AppLinkInstance", "openRealForResult linkContext null");     // Catch: Throwable -> L74
        ova.a r113 = new ova.a(System.currentTimeMillis(), r100.getPath(), gyb.a.a().getTracingID());     // Catch: Throwable -> L74
    L9:
        if (r113.f526938b == true) goto L12;
        if (r112 != 1) goto L12;
    L16:
        e r101 = f(r110, r111, r112, false);     // Catch: Throwable -> L74
        w(r101.f526966a, r111, r101.f526967b, r113);     // Catch: Throwable -> L74
        if (r101.f526966a == true) goto L21;
        Log.i("AppLinkInstance", "openRealForResult result of openResult is false");     // Catch: Throwable -> L74
        monitor-exit(this);
        return false;
    L21:
        String r102 = r100.getPath();     // Catch: Throwable -> L74
        if (r(r100) == false) goto L28;
        List<String> r103 = r100.getPathSegments();     // Catch: Throwable -> L74
        if (r103 == null) goto L28;
        if (r103.size() <= 0) goto L28;
        r102 = HTTP.URL_DEFAULT + ((String) ListProtector.get(r103, 0));     // Catch: Throwable -> L74
    L28:
        String r114 = r102;
        if (idb.f.a().isCurrentEnable("open_platform.applink.open_fix") == true) goto L31;
    L40:
        UserSession r104 = r113.f526942f;     // Catch: Throwable -> L74
        if (r104 == null) goto L45;
        Map r105 = (Map) ((HashMap) this.f526948e).get(r104.f438138b);     // Catch: Throwable -> L74
        if (r105 == null) goto L45;
        ova.d r106 = (ova.d) r105.get(r114);     // Catch: Throwable -> L74
    L46:
        if (r106 != null) goto L48;
        r106 = (ova.d) ((HashMap) this.f526946c).get(r114);     // Catch: Throwable -> L74
    L48:
        ova.d r115 = r106;
        if (r104 != null) goto L52;
        r104 = this.f526944a.f();     // Catch: Throwable -> L74
    L52:
        AppLink r116 = new AppLink(r111, r112, r104, r113.f526941e, r211);     // Catch: Throwable -> L74
        if (r115 == null) goto L67;
        v(r100, r113.f526941e);     // Catch: Throwable -> L74
        if ((r115 instanceof com.ss.android.lark.flow.group.e) == true) goto L57;
    L63:
        boolean r107 = r115.a(r110, r116);     // Catch: Throwable -> L74
        monitor-exit(this);
        return r107;
    L57:
        if (z.e(r110) == true) goto L63;
        jrc.b.a.f500175a.getClass();     // Catch: Throwable -> L74
        AppLinkProxy r108 = (AppLinkProxy) jrc.b.a(r110, AppLinkProxy.class);     // Catch: Throwable -> L74
        if (r108 == null) goto L61;
        r108.handle(r114, r116);     // Catch: Throwable -> L74
    L61:
        monitor-exit(this);
    L70:
        return true;
    L67:
        if (idb.f.a().isCurrentEnable("open_platform.applink.open_fix") == false) goto L71;
        i.a(r110, r100, this.f526950g);     // Catch: Throwable -> L74
        monitor-exit(this);
        goto L70
    L71:
        Log.i("AppLinkInstance", "no handler for path: " + r114);     // Catch: Throwable -> L74
        monitor-exit(this);
        return false;
    L45:
        r106 = null;
        goto L46
    L31:
        if (i.b(r100, this.f526950g) == true) goto L36;
        i.a(r110, r100, this.f526950g);     // Catch: Throwable -> L74
        monitor-exit(this);
        goto L70
    L36:
        if (j(r111, r114) == false) goto L40;
        i.a(r110, r100, this.f526950g);     // Catch: Throwable -> L74
        monitor-exit(this);
    L12:
        if (k(r110, r100) == true) goto L16;
        Log.i("AppLinkInstance", "openRealForResult check sec_user_id failed");     // Catch: Throwable -> L74
        monitor-exit(this);
        return false;
    L7:
        r113 = r210;
    L74:
        th = move-exception;
        throw th;
    }

    public final void n(Context r100, Uri r110, int r111, ova.a r112, Bundle r113) {
        Uri r114 = l.b(r110);
        Log.d("AppLinkInstance", "handleLinkV3 targetLink: " + r114);
        C(r100, r114.toString(), r111, r112, r113);
    }
}
