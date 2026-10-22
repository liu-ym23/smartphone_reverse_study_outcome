package jx4;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.debug.BasePreferenceActivity;
import com.bytedance.ee.bear.debug.analytic.AnalyticDebugActivity;
import com.bytedance.ee.bear.debug.doctest.AutoTestActivity;
import com.bytedance.ee.bear.debug.drive.DriveDebugActivity;
import com.bytedance.ee.bear.debug.lynxtools.LynxToolsActivity;
import com.bytedance.ee.bear.debug.net.NetDebugActivity;
import com.bytedance.ee.bear.debug.onboarding.OnBoardingDebugActivity;
import com.bytedance.ee.bear.debug.rntools.RnDebugActivity;
import com.bytedance.ee.bear.debug.webresouce.WebResourceActivity;
import com.bytedance.ee.bear.debug.wiki.WikiDebugActivity;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.util.debug.HeaderAppendHelper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.Request;

/* JADX INFO: loaded from: classes16.dex */
public class t extends jx4.a implements Preference.OnPreferenceChangeListener {
    public final com.bytedance.ee.bear.contract.m A;
    public final com.bytedance.ee.bear.drive.services.w B;
    public final ux4.d C;
    public final com.bytedance.ee.bear.share.b D;
    public final boolean E;
    public Preference F;
    public Preference G;
    public Preference H;
    public Preference I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Context f500833J;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ml5.b f500834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f500836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b0 f500837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f500838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NetService f500839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.ee.bear.route.h f500840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.d f500841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.ee.bear.contract.j f500842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h0 f500843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public mx4.a f500844m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public lx4.j f500845n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CheckBoxPreference f500846o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CheckBoxPreference f500847p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CheckBoxPreference f500848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EditTextPreference f500849r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EditTextPreference f500850s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public EditTextPreference f500851t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public EditTextPreference f500852u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public EditTextPreference f500853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CheckBoxPreference f500854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CheckBoxPreference f500855x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h0 f500856y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final lx4.f f500857z;

    public class a implements tx4.a.InterfaceC7790a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f500858a;

        public a(t r100) {
            this.f500858a = r100;
        }
    }

    public class b implements Consumer<Boolean> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Boolean r100) throws Exception {
            tt5.a.b("GeneralDebugInfo", "accept: login result = " + r100);
        }
    }

    public class c implements Consumer<Throwable> {
        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.l("GeneralDebugInfo", "accept: login error", r100);
        }
    }

    public void e() {
        if (TextUtils.equals(this.f500835d, (CharSequence) this.f500834c.a("login", "input")) == true) goto L9;
        h0 r100 = this.f500856y;
        if (r100 == null) goto L7;
        r100.e5().subscribe(new b(), new c());
    L7:
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
    L9:
        if (TextUtils.equals(this.f500836e, (CharSequence) this.f500834c.a(BenefitStore.FROM_SERVER, "publish")) == true) goto L11;
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
    L11:
        mx4.a r101 = this.f500844m;
        if (r101 == null) goto L15;
        r101.s();
        this.f500844m = null;
        return;
    }

    public void f() {
        b("web_resource", WebResourceActivity.class);
        b("rn_debug_tools", RnDebugActivity.class);
        b("net_tools", NetDebugActivity.class);
        b("lynx_tools", LynxToolsActivity.class);
        b("auto_test_tools", AutoTestActivity.class);
        b("onboarding_tools", OnBoardingDebugActivity.class);
        b("drive_tools", DriveDebugActivity.class);
        b("wiki_tools", WikiDebugActivity.class);
        b("analytic_tools", AnalyticDebugActivity.class);
        Preference r100 = this.f500814a.findPreference("app_version");
        StringBuffer r101 = new StringBuffer("versionName: ");
        r101.append(this.f500837f.getVersionName());
        r101.append("\nversionCode: ");
        r101.append(this.f500837f.getVersionCode());
        r101.append("\nbuildNumber: 0\nbranch: master\nflavor: ");
        String r102 = d("FLAVOR_server");
        String r103 = d("FLAVOR_login");
        if (TextUtils.isEmpty(r102) == false) goto L5;
    L7:
        String r104 = null;
    L8:
        r101.append(r104);
        r101.append("\nhttpChannel: ");
        r101.append(lr5.b.f510405d.toString());
        r101.append("\n");
        byte r105 = 0;
        boolean r106 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm_gray.client.ccm", false);
        HashMap r107 = new HashMap();
        HeaderAppendHelper.a(r107);
        Iterator r108 = r107.entrySet().iterator();
        boolean r109 = false;
    L10:
        if (r108.hasNext() == false) goto L16;
        Map.Entry r110 = (Map.Entry) r108.next();
        if (TextUtils.equals("env", ((String) r110.getKey()).toLowerCase()) == false) goto L10;
        if (TextUtils.equals("pre_release", ((String) r110.getValue()).toLowerCase()) == false) goto L10;
        r109 = true;
        goto L10
    L16:
        if (r106 == false) goto L18;
        String r111 = "Pre (Cause: hit ccm pre fg: ccm_gray.client.ccm)";
    L21:
        r101.append("serverEnv: " + r111 + "\n");
        r100.setSummary(r101.toString());
        CheckBoxPreference r112 = (CheckBoxPreference) this.f500814a.findPreference("sensitive_log_enable");
        if (r112 == null) goto L24;
        r112.setOnPreferenceChangeListener(this);
        r112.setChecked(((Boolean) this.f500834c.a("sensitive_log_enable", Boolean.TRUE)).booleanValue());
        r112.setEnabled(this.E);
    L24:
        CheckBoxPreference r113 = (CheckBoxPreference) this.f500814a.findPreference("preload_docs_sdk_enable");
        if (r113 == null) goto L27;
        r113.setOnPreferenceChangeListener(this);
        r113.setChecked(((Boolean) this.f500834c.a("preload_docs_sdk_enable", Boolean.TRUE)).booleanValue());
        r113.setEnabled(this.E);
    L27:
        CheckBoxPreference r114 = (CheckBoxPreference) this.f500814a.findPreference("docs_jsb_debugger_enable");
        if (r114 == null) goto L30;
        r114.setOnPreferenceChangeListener(this);
        r114.setChecked(((Boolean) this.f500834c.a("docs_jsb_debugger_enable", Boolean.FALSE)).booleanValue());
        r114.setEnabled(this.E);
    L30:
        CheckBoxPreference r115 = (CheckBoxPreference) this.f500814a.findPreference("bitable_loader_chache_toast_enable");
        if (r115 == null) goto L33;
        r115.setOnPreferenceChangeListener(this);
        r115.setChecked(((Boolean) this.f500834c.a("bitable_loader_chache_toast_enable", Boolean.FALSE)).booleanValue());
        r115.setEnabled(this.E);
    L33:
        CheckBoxPreference r116 = (CheckBoxPreference) this.f500814a.findPreference("bitable_show_mock_fg_tips_enable");
        if (r116 == null) goto L36;
        r116.setOnPreferenceChangeListener(this);
        r116.setChecked(((Boolean) this.f500834c.a("bitable_show_mock_fg_tips_enable", Boolean.TRUE)).booleanValue());
        r116.setEnabled(this.E);
    L36:
        this.f500814a.findPreference("bitable_memory_warning_test").setOnPreferenceClickListener(new f(this));
        Preference r117 = this.f500814a.findPreference("bitable_device_level");
        String r118 = this.D.j();
        r118.getClass();
        int r119 = r118.hashCode();
        if (r119 == (-1074341483)) goto L52;
        if (r119 == 107348) goto L48;
        if (r119 == 3202466) goto L44;
    L53:
        r105 = -1;
    L54:
        if (r105 == 0) goto L60;
        if (r105 == 1) goto L59;
        if (r105 == 2) goto L58;
        String r120 = "未知机型";
    L61:
        r117.setSummary(r120);
        CheckBoxPreference r121 = (CheckBoxPreference) this.f500814a.findPreference("screen_protection");
        if (r121 == null) goto L64;
        r121.setOnPreferenceChangeListener(this);
        r121.setChecked(((Boolean) this.f500834c.a("screen_protection", Boolean.TRUE)).booleanValue());
        r121.setEnabled(this.E);
    L64:
        CheckBoxPreference r122 = (CheckBoxPreference) this.f500814a.findPreference("blockCanary");
        if (r122 == null) goto L67;
        r122.setOnPreferenceChangeListener(this);
        r122.setChecked(((Boolean) this.f500834c.a("blockCanary", Boolean.TRUE)).booleanValue());
        r122.setEnabled(this.E);
    L67:
        CheckBoxPreference r123 = (CheckBoxPreference) this.f500814a.findPreference("appDebugConfig");
        if (r123 == null) goto L70;
        r123.setOnPreferenceChangeListener(this);
        r123.setChecked(((Boolean) this.f500834c.a("isDebug", Boolean.FALSE)).booleanValue());
        r123.setEnabled(this.E);
    L70:
        CheckBoxPreference r124 = (CheckBoxPreference) this.f500814a.findPreference("offline_support_change_resource");
        if (r124 == null) goto L73;
        r124.setOnPreferenceChangeListener(this);
        r124.setChecked(((Boolean) this.f500834c.a("offline_support_change_resource", Boolean.FALSE)).booleanValue());
    L73:
        ListPreference r125 = (ListPreference) this.f500814a.findPreference("build_login");
        if (r125 == null) goto L76;
        r125.setOnPreferenceChangeListener(this);
        r125.setSummary(this.f500835d);
        r125.setEnabled(this.E);
    L76:
        CheckBoxPreference r126 = (CheckBoxPreference) this.f500814a.findPreference("database_encrypt");
        if (r126 == null) goto L79;
        r126.setOnPreferenceChangeListener(this);
        r126.setChecked(((Boolean) this.f500834c.a("database_encrypt", Boolean.TRUE)).booleanValue());
        r126.setEnabled(this.E);
    L79:
        this.f500814a.findPreference("fg_preview").setOnPreferenceClickListener(new k(this));
        this.f500814a.findPreference("fg_mock").setOnPreferenceClickListener(new l(this));
        CheckBoxPreference r127 = (CheckBoxPreference) this.f500814a.findPreference("template_v4_ab_test");
        if (r127 == null) goto L82;
        r127.setEnabled(this.E);
        r127.setChecked(((Boolean) this.f500834c.a("template_v4_ab_test", Boolean.FALSE)).booleanValue());
        r127.setOnPreferenceChangeListener(this);
    L82:
        CheckBoxPreference r128 = (CheckBoxPreference) this.f500814a.findPreference("admin_permission_mock");
        if (r128 == null) goto L85;
        r128.setEnabled(this.E);
        r128.setChecked(((Boolean) this.f500834c.a("admin_permission_mock", Boolean.FALSE)).booleanValue());
        r128.setOnPreferenceChangeListener(this);
    L85:
        CheckBoxPreference r129 = (CheckBoxPreference) this.f500814a.findPreference("watermark_enable");
        if (r129 == null) goto L88;
        r129.setEnabled(this.E);
        r129.setChecked(((Boolean) this.f500834c.a("watermark_enable", Boolean.FALSE)).booleanValue());
        r129.setOnPreferenceChangeListener(this);
    L88:
        EditTextPreference r130 = (EditTextPreference) this.f500814a.findPreference("sheet_preload_template");
        if (r130 == null) goto L91;
        r130.setOnPreferenceChangeListener(this);
        r130.setEnabled(this.E);
        r130.setSummary((CharSequence) this.f500834c.a("sheet_preload_template", ""));
    L91:
        EditTextPreference r131 = (EditTextPreference) this.f500814a.findPreference("sheet_template");
        if (r131 == null) goto L102;
        r131.setOnPreferenceChangeListener(this);
        r131.setEnabled(this.E);
        r131.setSummary((CharSequence) this.f500834c.a("sheet_template", ""));
        return;
    L102:
        return;
    L58:
        r120 = "高端机";
        goto L61
    L59:
        r120 = "低端机";
        goto L61
    L60:
        r120 = "中端机";
        goto L61
    L44:
        if (r118.equals("high") == false) goto L53;
        r105 = 2;
        goto L54
    L48:
        if (r118.equals("low") == false) goto L53;
        r105 = 1;
        goto L54
    L52:
        if (r118.equals("middle") == true) goto L54;
    L18:
        if (r109 == false) goto L20;
        r111 = "Pre (Cause: append pre header in debug tools)";
        goto L21
    L20:
        r111 = "online";
        goto L21
    L5:
        if (TextUtils.isEmpty(r103) == true) goto L7;
        r104 = r102 + "-" + r103;
        goto L8
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

    public static String d(String r100) {
        Class r101 = a("com.bytedance.ee.bear.BuildConfig");     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r101 == null) goto L19;
        Field r102 = r101.getField(r100);     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r102 == null) goto L19;
        r102.setAccessible(true);     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        Object r103 = r102.get(null);     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r103 == null) goto L19;
        if ((r103 instanceof String) == false) goto L19;
        return (String) r103;
    L19:
        return null;
    L15:
        e = move-exception;
        tt5.a.m("GeneralDebugInfo", e);
        goto L19
    }

    public final void c(boolean r100) {
        String r101 = (String) this.f500834c.a("save_ip_proxy", "");
        if (r100 == true) goto L5;
    L8:
        this.f500834c.b("ip_proxy", "");
        ml5.b r102 = this.f500834c;
        Boolean r103 = Boolean.TRUE;
        r102.b("renderAccelerate", r103);
        this.f500834c.b("resourceIntercept", r103);
    L9:
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new j(this), 1000);
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        this.f500834c.b("ip_proxy", r101);
        ml5.b r104 = this.f500834c;
        Boolean r105 = Boolean.FALSE;
        r104.b("renderAccelerate", r105);
        this.f500834c.b("resourceIntercept", r105);
        goto L9
    }

    public t(PreferenceScreen r100, Activity r101) {
        super(r100, r101);
        this.f500833J = r101;
        this.f500838g = r101.getApplicationContext();
        ml5.b r102 = new ml5.b("debug_config");
        this.f500834c = r102;
        Intrinsics.checkNotNullParameter("deviceinfo", "name");
        Intrinsics.checkNotNullParameter(ay4.b.b("deviceinfo", true, ay4.b.a("deviceinfo")), "repo");
        new ArrayList();
        this.f500835d = (String) r102.a("login", "input");
        this.f500836e = (String) r102.a(BenefitStore.FROM_SERVER, "publish");
        this.f500837f = (b0) org.koin.java.a.a(b0.class);     // Catch: Exception -> L5
        this.f500839h = (NetService) org.koin.java.a.a(NetService.class);     // Catch: Exception -> L5
        this.f500840i = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);     // Catch: Exception -> L5
        this.f500841j = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: Exception -> L5
        this.f500842k = com.bytedance.ee.bear.contract.j.a.f217090a;     // Catch: Exception -> L5
        this.f500843l = (h0) org.koin.java.a.a(h0.class);     // Catch: Exception -> L5
        this.f500856y = (h0) org.koin.java.a.a(h0.class);     // Catch: Exception -> L5
        this.f500857z = lx4.f.a.f511183a;     // Catch: Exception -> L5
        this.A = (com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class);     // Catch: Exception -> L5
        this.B = (com.bytedance.ee.bear.drive.services.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.services.w.class);     // Catch: Exception -> L5
        this.C = new ux4.d(r101);     // Catch: Exception -> L5
        this.E = ((com.bytedance.ee.bear.contract.z) org.koin.java.a.a(com.bytedance.ee.bear.contract.z.class)).isDebugEnabled(r101);     // Catch: Exception -> L5
        this.D = (com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("GeneralDebugInfo", "KoinJavaComponent error!" + e.getMessage());
    }

    public final <T extends BasePreferenceActivity> void b(String r100, final Class<T> r101) {
        Preference r102 = this.f500814a.findPreference(r100);
        if (r102 == null) goto L6;
        r102.setOnPreferenceClickListener(new i(this, r101));
        return;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference r110, Object r111) {
        String r100 = r110.getKey();
        if ("bitable_show_mock_fg_tips_enable".equals(r100) == false) goto L6;
        this.f500834c.b("bitable_show_mock_fg_tips_enable", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
    L274:
        return true;
    L6:
        if ("docs_jsb_debugger_enable".equals(r100) == false) goto L9;
        this.f500834c.b("docs_jsb_debugger_enable", r111);
        goto L274
    L9:
        if ("bitable_loader_chache_toast_enable".equals(r100) == false) goto L12;
        this.f500834c.b("bitable_loader_chache_toast_enable", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L12:
        if ("rn_debug".equals(r100) == false) goto L15;
        this.f500834c.b("rn_debug", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new m(), 1000);
        goto L274
    L15:
        if ("rn_debug_for_bitable".equals(r100) == false) goto L18;
        this.f500834c.b("rn_debug_for_bitable", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new n(), 1000);
        goto L274
    L18:
        if ("build_login".equals(r100) == false) goto L20;
        this.f500834c.b("login", r111.toString());
        r110.setSummary(r111.toString());
        goto L274
    L20:
        boolean r101 = false;
        if ("blockCanary".equals(r100) == false) goto L38;
        this.f500834c.b("blockCanary", r111);
        boolean r112 = ((Boolean) r111).booleanValue();
        Class r113 = a("com.github.moduth.blockcanary.BlockCanary");     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33 ClassNotFoundException -> L35
        Object r102 = r113.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(r113, new Object[0]);     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33 ClassNotFoundException -> L35
        if (r112 == false) goto L26;
        String r114 = "start";
    L27:
        r113.getMethod(r114, new Class[0]).invoke(r102, new Object[0]);     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33 ClassNotFoundException -> L35
    L26:
        r114 = "stop";
    L35:
        e = move-exception;
        tt5.a.f("GeneralDebugInfo", e, false);
    L31:
        e = move-exception;
        tt5.a.f("GeneralDebugInfo", e, false);
    L33:
        e = move-exception;
        tt5.a.f("GeneralDebugInfo", e, false);
    L29:
        e = move-exception;
        tt5.a.f("GeneralDebugInfo", e, false);
        goto L274
    L38:
        if ("firstRenderNotAccelerate".equals(r100) == false) goto L41;
        this.f500834c.b("firstRenderNotAccelerate", r111);
        goto L274
    L41:
        if ("singleWebView".equals(r100) == false) goto L47;
        this.f500834c.b("singleWebView", r111);
        if (((Boolean) r111).booleanValue() == false) goto L45;
        l7 r115 = y7.f222541j;
        y7.a.f222551a.h("singleWebView");
        goto L274
    L45:
        l7 r116 = y7.f222541j;
        y7.a.f222551a.i("singleWebView");
        goto L274
    L47:
        if ("documentOpenTimeout".equals(r100) == false) goto L57;
        int r117 = CastIntegerProtector.parseInt((String) r111);     // Catch: Exception -> L50
    L51:
        this.f500834c.b("documentOpenTimeout", Integer.valueOf(r117));
        if (r117 >= 0) goto L54;
        String r118 = "";
    L55:
        this.f500853v.setSummary(r118);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L54:
        r118 = r117 + " ms";
    L50:
        tt5.a.h("GeneralDebugInfo", "onPreferenceChange: documentOpenTimeout timeout = " + r111);
        r117 = -1;
        goto L51
    L57:
        if ("enable_statistics".equals(r100) == false) goto L60;
        this.f500834c.b("enable_statistics", r111);
        goto L274
    L60:
        if ("disable_ip_proxy".equals(r100) == false) goto L63;
        this.f500834c.b("disable_ip_proxy", r111);
        c(!((Boolean) r111).booleanValue());
        goto L274
    L63:
        if ("ip_proxy".equals(r100) == false) goto L72;
        String r119 = (String) r111;
        if (TextUtils.isEmpty(r119) == false) goto L67;
    L70:
        this.f500834c.b("save_ip_proxy", r119);
        this.f500851t.setSummary(r119);
        c(!((Boolean) this.f500834c.a("disable_ip_proxy", Boolean.FALSE)).booleanValue());
        goto L274
    L67:
        if (r119.startsWith("http") == true) goto L69;
        r119 = "http://".concat(r119);
    L69:
        String r120 = ((b0) org.koin.java.a.a(b0.class)).g().f216922f.f216929b;
        String r103 = r119.substring(7);
        CookieManager r104 = CookieManager.getInstance();
        r104.setAcceptCookie(true);
        r104.setCookie(r103, "session=" + r120 + ";domain=" + r103 + ";path=/");
        r104.flush();
        goto L70
    L72:
        if ("offline_res_version".equals(r100) == false) goto L78;
        this.f500834c.b(r100, r111);
        this.f500849r.setSummary((CharSequence) r111);
        ux4.d r121 = this.C;
        String r122 = (String) r111;
        if (r121.f551976a == false) goto L76;
        tt5.a.b("DownloadScmPresenter", "download, isDownloading");
        goto L274
    L76:
        r121.f551979d = false;
        ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).f(r121.f551977b, r122, new ux4.c(r121));
        goto L274
    L78:
        if ("folder_token".equals(r100) == false) goto L81;
        this.f500834c.b(r100, r111);
        this.f500850s.setSummary((CharSequence) r111);
        goto L274
    L81:
        if ("http_request_id".equals(r100) == false) goto L84;
        this.f500834c.b(r100, r111);
        this.f500852u.setSummary((CharSequence) r111);
        goto L274
    L84:
        if ("doc_rn_enabled".equals(r100) == false) goto L87;
        tt5.a.b("GeneralDebugInfo", "GeneralDebugInfo.onPreferenceChange: 135 " + r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        this.f500834c.b("doc_rn_enabled", r111);
        goto L274
    L87:
        if (TextUtils.equals("offline_encrypt", r100) == false) goto L90;
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        this.f500834c.b("offline_encrypt", r111);
        goto L274
    L90:
        if (TextUtils.equals("show_cache_toast", r100) == false) goto L93;
        this.f500834c.b("show_cache_toast", r111);
        goto L274
    L93:
        if (TextUtils.equals("show_doc_size_toast", r100) == false) goto L96;
        this.f500834c.b("show_doc_size_toast", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new o(), 1000);
        goto L274
    L96:
        if (TextUtils.equals("ai_roadster_debug", r100) == false) goto L99;
        this.f500834c.b("ai_roadster_debug", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new p(), 1000);
        goto L274
    L99:
        if (TextUtils.equals("appDebugConfig", r100) == false) goto L102;
        this.f500834c.b("isDebug", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L102:
        if (TextUtils.equals("enableFrontendEtTest", r100) == false) goto L105;
        this.f500834c.b("enable_frontend_et_test", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L105:
        if (TextUtils.equals("syncDocs", r100) == false) goto L108;
        this.f500834c.b("syncDocs", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L108:
        if (TextUtils.equals("database_encrypt", r100) == false) goto L111;
        this.f500834c.b("database_encrypt", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L111:
        if (TextUtils.equals("test_switch", r100) == false) goto L123;
        Boolean r123 = (Boolean) r111;
        com.bytedance.ee.bear.contract.l.f217102a = r123;
        if (r123.booleanValue() == true) goto L115;
        mx4.a r124 = this.f500844m;
        if (r124 == null) goto L121;
        r124.s();
    L121:
        this.f500815b.get().getWindow().clearFlags(128);
        goto L274
    L115:
        if (this.f500844m != null) goto L117;
        this.f500844m = new mx4.a(this.f500815b.get(), this.f500840i, this.A, this.B, this);
    L117:
        this.f500844m.r();
        this.f500815b.get().getWindow().addFlags(128);
        goto L274
    L123:
        if ("doc_types".equals(r100) == false) goto L130;
        MultiSelectListPreference r125 = (MultiSelectListPreference) r110;
        CharSequence[] r105 = r125.getEntries();
        ArrayList r106 = new ArrayList();
        Iterator r126 = ((Set) r111).iterator();
    L126:
        if (r126.hasNext() == false) goto L128;
        String r107 = (String) r126.next();
        int r108 = r125.findIndexOfValue(r107);
        tt5.a.b("TAG2", r107 + r105[r108]);
        r106.add(r105[r108].toString());
        goto L126
    L128:
        this.f500844m.q(r106);
        r125.setSummary(r106.toString());
        goto L274
    L130:
        if (TextUtils.equals("wiki_test_switch", r100) == false) goto L142;
        Boolean r127 = (Boolean) r111;
        com.bytedance.ee.bear.contract.l.f217102a = r127;
        if (r127.booleanValue() == true) goto L134;
        lx4.j r128 = this.f500845n;
        if (r128 == null) goto L140;
        r128.r();
    L140:
        this.f500815b.get().getWindow().clearFlags(128);
        goto L274
    L134:
        if (this.f500845n != null) goto L136;
        this.f500845n = new lx4.j(this.f500815b.get(), this.f500839h, this.f500840i, this.f500857z, this.A, this.f500837f, this.f500856y);
    L136:
        this.f500845n.p();
        this.f500815b.get().getWindow().addFlags(128);
        goto L274
    L142:
        if (TextUtils.equals("offline_support_change_resource", r100) == false) goto L145;
        this.f500834c.b(r100, r111);
        goto L274
    L145:
        if (TextUtils.equals("rn_preload", r100) == false) goto L148;
        this.f500834c.b(r100, r111);
        goto L274
    L148:
        if (TextUtils.equals("domain_enable", r100) == false) goto L151;
        this.f500834c.b(r100, r111);
        goto L274
    L151:
        if (TextUtils.equals("ttwebview_enable", r100) == false) goto L159;
        this.f500834c.b(r100, r111);
        if (r111 == Boolean.FALSE) goto L155;
    L157:
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L155:
        if (this.f500855x.isChecked() == false) goto L157;
        this.f500855x.setChecked(false);
        goto L157
    L159:
        if (TextUtils.equals("ttwebview_m62_enable", r100) == false) goto L167;
        this.f500834c.b(r100, r111);
        if (r111 == Boolean.TRUE) goto L163;
    L165:
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L163:
        if (this.f500854w.isChecked() == true) goto L165;
        this.f500854w.setChecked(true);
        goto L165
    L167:
        if (TextUtils.equals("ocr_enable", r100) == false) goto L170;
        this.f500834c.b(r100, r111);
        goto L274
    L170:
        if (TextUtils.equals("rust_net_enable", r100) == false) goto L173;
        this.f500834c.b(r100, r111);
        goto L274
    L173:
        if ("ip_proxy_rust".equals(r100) == false) goto L182;
        String r129 = (String) r111;
        if (TextUtils.isEmpty(r129) == false) goto L177;
    L179:
        this.f500834c.b(r100, r129);
        throw null;
    L177:
        if (r129.startsWith("http") == true) goto L179;
        r129 = "http://".concat(r129);
        goto L179
    L182:
        if (TextUtils.equals("lark_docs_newer_guide_switch", r100) == false) goto L185;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L185:
        if (TextUtils.equals("rn_doze", r100) == false) goto L188;
        this.f500834c.b(r100, r111);
        goto L274
    L188:
        if (TextUtils.equals("tt_video_log_enable", r100) == false) goto L191;
        this.f500834c.b(r100, r111);
        goto L274
    L191:
        if (TextUtils.equals("global_onboarding_enable", r100) == false) goto L194;
        this.f500834c.b(r100, r111);
        goto L274
    L194:
        if (TextUtils.equals("global_onboarding_native_only_enable", r100) == false) goto L197;
        this.f500834c.b(r100, r111);
        goto L274
    L197:
        if (TextUtils.equals("wikitree_collab_enable", r100) == false) goto L199;
    L273:
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new q(), 1000);
        goto L274
    L199:
        if (TextUtils.equals("initGecko", r100) == true) goto L273;
        if (TextUtils.equals("wikitree_show_areaId", r100) == false) goto L205;
        this.f500834c.b(r100, r111);
        goto L274
    L205:
        if (TextUtils.equals("wikitree_show_status", r100) == false) goto L208;
        this.f500834c.b(r100, r111);
        goto L274
    L208:
        if (TextUtils.equals("offline_auto_download_full_res", r100) == false) goto L211;
        this.f500834c.b(r100, r111);
        goto L274
    L211:
        if (TextUtils.equals("enable_debug_res", r100) == false) goto L214;
        this.f500834c.b(r100, r111);
        goto L274
    L214:
        if (TextUtils.equals("offline_disable_specific_res", r100) == false) goto L217;
        this.f500834c.b(r100, r111);
        goto L274
    L217:
        if (TextUtils.equals("header_append_params_enable", r100) == false) goto L228;
        CheckBoxPreference r130 = (CheckBoxPreference) this.f500814a.findPreference("header_append_params_enable_rn");
        if (r130 != null) goto L221;
    L226:
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L221:
        if (this.E == true) goto L223;
    L225:
        r130.setEnabled(r101);
        goto L226
    L223:
        if (((Boolean) r111).booleanValue() == false) goto L225;
        r101 = true;
        goto L225
    L228:
        if (TextUtils.equals("header_append_params_enable_rn", r100) == false) goto L231;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L231:
        if (TextUtils.equals("admin_permission_mock", r100) == false) goto L234;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new r(), 1000);
        goto L274
    L234:
        if (TextUtils.equals("watermark_enable", r100) == false) goto L237;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L237:
        if (TextUtils.equals("sheet_preload_template", r100) == false) goto L239;
    L272:
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L239:
        if (TextUtils.equals("sheet_template", r100) == true) goto L272;
        if (TextUtils.equals("sensitive_log_enable", r100) == false) goto L245;
        this.f500834c.b(r100, r111);
        this.f500834c.b("sensitive_report_enable", r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new s(), 1000);
        goto L274
    L245:
        if (TextUtils.equals("screen_protection", r100) == false) goto L248;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new g(), 1000);
        goto L274
    L248:
        if (TextUtils.equals("net_interceptable", r100) == false) goto L251;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L251:
        if (TextUtils.equals("sensitive_report_enable", r100) == false) goto L254;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        new Handler().postDelayed(new h(), 1000);
        goto L274
    L254:
        if (TextUtils.equals("offline_res_enable_source_map", r100) == false) goto L257;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L257:
        if (TextUtils.equals("preload_docs_sdk_enable", r100) == false) goto L262;
        this.f500834c.b(r100, r111);
        if (Boolean.TRUE.equals(r111) == true) goto L274;
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L262:
        if (TextUtils.equals("roaster_zip_link", r100) == false) goto L265;
        this.f500834c.b(r100, r111);
        int r131 = tx4.a.f547817a;
        String r132 = (String) r111;
        a r133 = new a(this);
        Intrinsics.checkNotNullParameter(r132, "zipUrl");
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).z8(new Request.Builder().url(r132).build(), new tx4.b(r132, r133));
        goto L274
    L265:
        if (TextUtils.equals("disable_preload_document", r100) == false) goto L270;
        this.f500834c.b(r100, r111);
        if (Boolean.TRUE.equals(r111) == true) goto L274;
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    L270:
        if (TextUtils.equals("drive_same_render_emed_on", r100) == false) goto L274;
        this.f500834c.b(r100, r111);
        Toast.showSuccessText(this.f500815b.get(), this.f500815b.get().getString(R.string.Doc_Debug_RestartApp), 1);
        goto L274
    }
}
