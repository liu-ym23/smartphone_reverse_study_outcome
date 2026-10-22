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
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.debug.HeaderAppendHelper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public final Context J;
    public final ml5.b c;
    public final String d;
    public final String e;
    public final b0 f;
    public final Context g;
    public final NetService h;
    public final com.bytedance.ee.bear.route.h i;
    public final com.bytedance.ee.bear.contract.d j;
    public final com.bytedance.ee.bear.contract.j k;
    public final h0 l;
    public mx4.a m;
    public lx4.j n;
    public CheckBoxPreference o;
    public CheckBoxPreference p;
    public CheckBoxPreference q;
    public EditTextPreference r;
    public EditTextPreference s;
    public EditTextPreference t;
    public EditTextPreference u;
    public EditTextPreference v;
    public CheckBoxPreference w;
    public CheckBoxPreference x;
    public final h0 y;
    public final lx4.f z;

    public class a implements tx4.a.InterfaceC0301a {
        public final /* synthetic */ t a;

        public a(t r1) {
            this.a = r1;
        }
    }

    public class b implements Consumer<Boolean> {
        public b() {
        }

        public final void accept(Object r3) throws Exception {
            tt5.a.b("GeneralDebugInfo", "accept: login result = " + ((Boolean) r3));
        }
    }

    public class c implements Consumer<Throwable> {
        public c() {
        }

        public final void accept(Object r3) throws Exception {
            tt5.a.l("GeneralDebugInfo", "accept: login error", (Throwable) r3);
        }
    }

    public void e() {
        if (TextUtils.equals(this.d, (CharSequence) this.c.a("login", "input")) == true) goto L9;
        h0 r0 = this.y;
        if (r0 == null) goto L7;
        r0.e5().subscribe(new b(), new c());
    L7:
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
    L9:
        if (TextUtils.equals(this.e, (CharSequence) this.c.a("server", JSEventListener.ACTION_PUBLISH)) == true) goto L11;
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
    L11:
        mx4.a r1 = this.m;
        if (r1 == null) goto L15;
        r1.s();
        this.m = null;
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
        Preference r0 = this.a.findPreference("app_version");
        StringBuffer r1 = new StringBuffer("versionName: ");
        r1.append(this.f.getVersionName());
        r1.append("\nversionCode: ");
        r1.append(this.f.getVersionCode());
        r1.append("\nbuildNumber: 0\nbranch: master\nflavor: ");
        String r2 = d("FLAVOR_server");
        String r3 = d("FLAVOR_login");
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L7:
        String r4 = null;
    L8:
        r1.append(r4);
        r1.append("\nhttpChannel: ");
        r1.append(lr5.b.d.toString());
        r1.append(DocViewModel.ENTER_CHAR);
        byte r5 = 0;
        boolean r6 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm_gray.client.ccm", false);
        HashMap r7 = new HashMap();
        HeaderAppendHelper.a(r7);
        Iterator r8 = r7.entrySet().iterator();
        boolean r9 = false;
    L10:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r10 = (Map.Entry) r8.next();
        if (TextUtils.equals("env", ((String) r10.getKey()).toLowerCase()) == false) goto L10;
        if (TextUtils.equals("pre_release", ((String) r10.getValue()).toLowerCase()) == false) goto L10;
        r9 = true;
        goto L10
    L16:
        if (r6 == false) goto L18;
        String r11 = "Pre (Cause: hit ccm pre fg: ccm_gray.client.ccm)";
    L21:
        r1.append("serverEnv: " + r11 + DocViewModel.ENTER_CHAR);
        r0.setSummary(r1.toString());
        CheckBoxPreference r12 = (CheckBoxPreference) this.a.findPreference("sensitive_log_enable");
        if (r12 == null) goto L24;
        r12.setOnPreferenceChangeListener(this);
        r12.setChecked(((Boolean) this.c.a("sensitive_log_enable", Boolean.TRUE)).booleanValue());
        r12.setEnabled(this.E);
    L24:
        CheckBoxPreference r13 = (CheckBoxPreference) this.a.findPreference("preload_docs_sdk_enable");
        if (r13 == null) goto L27;
        r13.setOnPreferenceChangeListener(this);
        r13.setChecked(((Boolean) this.c.a("preload_docs_sdk_enable", Boolean.TRUE)).booleanValue());
        r13.setEnabled(this.E);
    L27:
        CheckBoxPreference r14 = (CheckBoxPreference) this.a.findPreference("docs_jsb_debugger_enable");
        if (r14 == null) goto L30;
        r14.setOnPreferenceChangeListener(this);
        r14.setChecked(((Boolean) this.c.a("docs_jsb_debugger_enable", Boolean.FALSE)).booleanValue());
        r14.setEnabled(this.E);
    L30:
        CheckBoxPreference r16 = (CheckBoxPreference) this.a.findPreference("bitable_loader_chache_toast_enable");
        if (r16 == null) goto L33;
        r16.setOnPreferenceChangeListener(this);
        r16.setChecked(((Boolean) this.c.a("bitable_loader_chache_toast_enable", Boolean.FALSE)).booleanValue());
        r16.setEnabled(this.E);
    L33:
        CheckBoxPreference r17 = (CheckBoxPreference) this.a.findPreference("bitable_show_mock_fg_tips_enable");
        if (r17 == null) goto L36;
        r17.setOnPreferenceChangeListener(this);
        r17.setChecked(((Boolean) this.c.a("bitable_show_mock_fg_tips_enable", Boolean.TRUE)).booleanValue());
        r17.setEnabled(this.E);
    L36:
        this.a.findPreference("bitable_memory_warning_test").setOnPreferenceClickListener(new f(this));
        Preference r18 = this.a.findPreference("bitable_device_level");
        String r19 = this.D.j();
        r19.getClass();
        int r20 = r19.hashCode();
        if (r20 == (-1074341483)) goto L52;
        if (r20 == 107348) goto L48;
        if (r20 == 3202466) goto L44;
    L53:
        r5 = -1;
    L54:
        if (r5 == 0) goto L60;
        if (r5 == 1) goto L59;
        if (r5 == 2) goto L58;
        String r21 = "未知机型";
    L61:
        r18.setSummary(r21);
        CheckBoxPreference r22 = (CheckBoxPreference) this.a.findPreference("screen_protection");
        if (r22 == null) goto L64;
        r22.setOnPreferenceChangeListener(this);
        r22.setChecked(((Boolean) this.c.a("screen_protection", Boolean.TRUE)).booleanValue());
        r22.setEnabled(this.E);
    L64:
        CheckBoxPreference r23 = (CheckBoxPreference) this.a.findPreference("blockCanary");
        if (r23 == null) goto L67;
        r23.setOnPreferenceChangeListener(this);
        r23.setChecked(((Boolean) this.c.a("blockCanary", Boolean.TRUE)).booleanValue());
        r23.setEnabled(this.E);
    L67:
        CheckBoxPreference r24 = (CheckBoxPreference) this.a.findPreference("appDebugConfig");
        if (r24 == null) goto L70;
        r24.setOnPreferenceChangeListener(this);
        r24.setChecked(((Boolean) this.c.a("isDebug", Boolean.FALSE)).booleanValue());
        r24.setEnabled(this.E);
    L70:
        CheckBoxPreference r26 = (CheckBoxPreference) this.a.findPreference("offline_support_change_resource");
        if (r26 == null) goto L73;
        r26.setOnPreferenceChangeListener(this);
        r26.setChecked(((Boolean) this.c.a("offline_support_change_resource", Boolean.FALSE)).booleanValue());
    L73:
        ListPreference r27 = (ListPreference) this.a.findPreference("build_login");
        if (r27 == null) goto L76;
        r27.setOnPreferenceChangeListener(this);
        r27.setSummary(this.d);
        r27.setEnabled(this.E);
    L76:
        CheckBoxPreference r28 = (CheckBoxPreference) this.a.findPreference("database_encrypt");
        if (r28 == null) goto L79;
        r28.setOnPreferenceChangeListener(this);
        r28.setChecked(((Boolean) this.c.a("database_encrypt", Boolean.TRUE)).booleanValue());
        r28.setEnabled(this.E);
    L79:
        this.a.findPreference("fg_preview").setOnPreferenceClickListener(new k(this));
        this.a.findPreference("fg_mock").setOnPreferenceClickListener(new l(this));
        CheckBoxPreference r29 = (CheckBoxPreference) this.a.findPreference("template_v4_ab_test");
        if (r29 == null) goto L82;
        r29.setEnabled(this.E);
        r29.setChecked(((Boolean) this.c.a("template_v4_ab_test", Boolean.FALSE)).booleanValue());
        r29.setOnPreferenceChangeListener(this);
    L82:
        CheckBoxPreference r30 = (CheckBoxPreference) this.a.findPreference("admin_permission_mock");
        if (r30 == null) goto L85;
        r30.setEnabled(this.E);
        r30.setChecked(((Boolean) this.c.a("admin_permission_mock", Boolean.FALSE)).booleanValue());
        r30.setOnPreferenceChangeListener(this);
    L85:
        CheckBoxPreference r31 = (CheckBoxPreference) this.a.findPreference("watermark_enable");
        if (r31 == null) goto L88;
        r31.setEnabled(this.E);
        r31.setChecked(((Boolean) this.c.a("watermark_enable", Boolean.FALSE)).booleanValue());
        r31.setOnPreferenceChangeListener(this);
    L88:
        EditTextPreference r32 = (EditTextPreference) this.a.findPreference("sheet_preload_template");
        if (r32 == null) goto L91;
        r32.setOnPreferenceChangeListener(this);
        r32.setEnabled(this.E);
        r32.setSummary((CharSequence) this.c.a("sheet_preload_template", ""));
    L91:
        EditTextPreference r33 = (EditTextPreference) this.a.findPreference("sheet_template");
        if (r33 == null) goto L102;
        r33.setOnPreferenceChangeListener(this);
        r33.setEnabled(this.E);
        r33.setSummary((CharSequence) this.c.a("sheet_template", ""));
        return;
    L102:
        return;
    L58:
        r21 = "高端机";
        goto L61
    L59:
        r21 = "低端机";
        goto L61
    L60:
        r21 = "中端机";
        goto L61
    L44:
        if (r19.equals("high") == false) goto L53;
        r5 = 2;
        goto L54
    L48:
        if (r19.equals("low") == false) goto L53;
        r5 = 1;
        goto L54
    L52:
        if (r19.equals("middle") == true) goto L54;
    L18:
        if (r9 == false) goto L20;
        r11 = "Pre (Cause: append pre header in debug tools)";
        goto L21
    L20:
        r11 = "online";
        goto L21
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L7;
        r4 = r2 + "-" + r3;
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String d(String r2) {
        Class r1 = a("com.bytedance.ee.bear.BuildConfig");     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r1 == null) goto L19;
        Field r3 = r1.getField(r2);     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r3 == null) goto L19;
        r3.setAccessible(true);     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        Object r4 = r3.get(null);     // Catch: IllegalAccessException -> L13 Throwable -> L15 ClassNotFoundException -> L17
        if (r4 == null) goto L19;
        if ((r4 instanceof String) == false) goto L19;
        return (String) r4;
    L19:
        return null;
    L15:
        e = move-exception;
        tt5.a.m("GeneralDebugInfo", e);
        goto L19
    }

    public final void c(boolean r6) {
        String r0 = (String) this.c.a("save_ip_proxy", "");
        if (r6 == true) goto L5;
    L8:
        this.c.b("ip_proxy", "");
        ml5.b r7 = this.c;
        Boolean r1 = Boolean.TRUE;
        r7.b("renderAccelerate", r1);
        this.c.b("resourceIntercept", r1);
    L9:
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new j(this), 1000);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        this.c.b("ip_proxy", r0);
        ml5.b r8 = this.c;
        Boolean r2 = Boolean.FALSE;
        r8.b("renderAccelerate", r2);
        this.c.b("resourceIntercept", r2);
        goto L9
    }

    public t(PreferenceScreen r4, Activity r5) {
        super(r4, r5);
        this.J = r5;
        this.g = r5.getApplicationContext();
        ml5.b r6 = new ml5.b("debug_config");
        this.c = r6;
        Intrinsics.checkNotNullParameter("deviceinfo", "name");
        Intrinsics.checkNotNullParameter(ay4.b.b("deviceinfo", true, ay4.b.a("deviceinfo")), "repo");
        new ArrayList();
        this.d = (String) r6.a("login", "input");
        this.e = (String) r6.a("server", JSEventListener.ACTION_PUBLISH);
        this.f = (b0) org.koin.java.a.a(b0.class);     // Catch: Exception -> L5
        this.h = (NetService) org.koin.java.a.a(NetService.class);     // Catch: Exception -> L5
        this.i = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);     // Catch: Exception -> L5
        this.j = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: Exception -> L5
        this.k = com.bytedance.ee.bear.contract.j.a.a;     // Catch: Exception -> L5
        this.l = (h0) org.koin.java.a.a(h0.class);     // Catch: Exception -> L5
        this.y = (h0) org.koin.java.a.a(h0.class);     // Catch: Exception -> L5
        this.z = lx4.f.a.a;     // Catch: Exception -> L5
        this.A = (com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class);     // Catch: Exception -> L5
        this.B = (com.bytedance.ee.bear.drive.services.w) org.koin.java.a.a(com.bytedance.ee.bear.drive.services.w.class);     // Catch: Exception -> L5
        this.C = new ux4.d(r5);     // Catch: Exception -> L5
        this.E = ((com.bytedance.ee.bear.contract.z) org.koin.java.a.a(com.bytedance.ee.bear.contract.z.class)).isDebugEnabled(r5);     // Catch: Exception -> L5
        this.D = (com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d("GeneralDebugInfo", "KoinJavaComponent error!" + e.getMessage());
    }

    public final <T extends BasePreferenceActivity> void b(String r2, final Class<T> r3) {
        Preference r4 = this.a.findPreference(r2);
        if (r4 == null) goto L6;
        r4.setOnPreferenceClickListener(new i(this, r3));
        return;
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public final boolean onPreferenceChange(Preference r14, Object r16) {
        String r0 = r14.getKey();
        if ("bitable_show_mock_fg_tips_enable".equals(r0) == false) goto L6;
        this.c.b("bitable_show_mock_fg_tips_enable", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
    L274:
        return true;
    L6:
        if ("docs_jsb_debugger_enable".equals(r0) == false) goto L9;
        this.c.b("docs_jsb_debugger_enable", r16);
        goto L274
    L9:
        if ("bitable_loader_chache_toast_enable".equals(r0) == false) goto L12;
        this.c.b("bitable_loader_chache_toast_enable", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L12:
        if ("rn_debug".equals(r0) == false) goto L15;
        this.c.b("rn_debug", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new m(), 1000);
        goto L274
    L15:
        if ("rn_debug_for_bitable".equals(r0) == false) goto L18;
        this.c.b("rn_debug_for_bitable", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new n(), 1000);
        goto L274
    L18:
        if ("build_login".equals(r0) == false) goto L20;
        this.c.b("login", r16.toString());
        r14.setSummary(r16.toString());
        goto L274
    L20:
        boolean r8 = false;
        if ("blockCanary".equals(r0) == false) goto L38;
        this.c.b("blockCanary", r16);
        boolean r17 = ((Boolean) r16).booleanValue();
        Class r18 = a("com.github.moduth.blockcanary.BlockCanary");     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33 ClassNotFoundException -> L35
        Object r1 = r18.getMethod("get", new Class[0]).invoke(r18, new Object[0]);     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33 ClassNotFoundException -> L35
        if (r17 == false) goto L26;
        String r19 = BatterySceneData.OPT_START;
    L27:
        r18.getMethod(r19, new Class[0]).invoke(r1, new Object[0]);     // Catch: InvocationTargetException -> L29 IllegalAccessException -> L31 NoSuchMethodException -> L33 ClassNotFoundException -> L35
    L26:
        r19 = "stop";
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
        if ("firstRenderNotAccelerate".equals(r0) == false) goto L41;
        this.c.b("firstRenderNotAccelerate", r16);
        goto L274
    L41:
        if ("singleWebView".equals(r0) == false) goto L47;
        this.c.b("singleWebView", r16);
        if (((Boolean) r16).booleanValue() == false) goto L45;
        l7 r110 = y7.j;
        y7.a.a.h("singleWebView");
        goto L274
    L45:
        l7 r111 = y7.j;
        y7.a.a.i("singleWebView");
        goto L274
    L47:
        if ("documentOpenTimeout".equals(r0) == false) goto L57;
        int r112 = CastIntegerProtector.parseInt((String) r16);     // Catch: Exception -> L50
    L51:
        this.c.b("documentOpenTimeout", Integer.valueOf(r112));
        if (r112 >= 0) goto L54;
        String r113 = "";
    L55:
        this.v.setSummary(r113);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L54:
        r113 = r112 + " ms";
    L50:
        tt5.a.h("GeneralDebugInfo", "onPreferenceChange: documentOpenTimeout timeout = " + r16);
        r112 = -1;
        goto L51
    L57:
        if ("enable_statistics".equals(r0) == false) goto L60;
        this.c.b("enable_statistics", r16);
        goto L274
    L60:
        if ("disable_ip_proxy".equals(r0) == false) goto L63;
        this.c.b("disable_ip_proxy", r16);
        c(!((Boolean) r16).booleanValue());
        goto L274
    L63:
        if ("ip_proxy".equals(r0) == false) goto L72;
        String r114 = (String) r16;
        if (TextUtils.isEmpty(r114) == false) goto L67;
    L70:
        this.c.b("save_ip_proxy", r114);
        this.t.setSummary(r114);
        c(!((Boolean) this.c.a("disable_ip_proxy", Boolean.FALSE)).booleanValue());
        goto L274
    L67:
        if (r114.startsWith("http") == true) goto L69;
        r114 = "http://".concat(r114);
    L69:
        String r115 = ((b0) org.koin.java.a.a(b0.class)).g().f.b;
        String r2 = r114.substring(7);
        CookieManager r3 = CookieManager.getInstance();
        r3.setAcceptCookie(true);
        r3.setCookie(r2, "session=" + r115 + ";domain=" + r2 + ";path=/");
        r3.flush();
        goto L70
    L72:
        if ("offline_res_version".equals(r0) == false) goto L78;
        this.c.b(r0, r16);
        this.r.setSummary((CharSequence) r16);
        ux4.d r116 = this.C;
        String r117 = (String) r16;
        if (r116.a == false) goto L76;
        tt5.a.b("DownloadScmPresenter", "download, isDownloading");
        goto L274
    L76:
        r116.d = false;
        ((com.bytedance.ee.bear.doc.resupdate.g) org.koin.java.a.a(com.bytedance.ee.bear.doc.resupdate.g.class)).f(r116.b, r117, new ux4.c(r116));
        goto L274
    L78:
        if ("folder_token".equals(r0) == false) goto L81;
        this.c.b(r0, r16);
        this.s.setSummary((CharSequence) r16);
        goto L274
    L81:
        if ("http_request_id".equals(r0) == false) goto L84;
        this.c.b(r0, r16);
        this.u.setSummary((CharSequence) r16);
        goto L274
    L84:
        if ("doc_rn_enabled".equals(r0) == false) goto L87;
        tt5.a.b("GeneralDebugInfo", "GeneralDebugInfo.onPreferenceChange: 135 " + r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        this.c.b("doc_rn_enabled", r16);
        goto L274
    L87:
        if (TextUtils.equals("offline_encrypt", r0) == false) goto L90;
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        this.c.b("offline_encrypt", r16);
        goto L274
    L90:
        if (TextUtils.equals("show_cache_toast", r0) == false) goto L93;
        this.c.b("show_cache_toast", r16);
        goto L274
    L93:
        if (TextUtils.equals("show_doc_size_toast", r0) == false) goto L96;
        this.c.b("show_doc_size_toast", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new o(), 1000);
        goto L274
    L96:
        if (TextUtils.equals("ai_roadster_debug", r0) == false) goto L99;
        this.c.b("ai_roadster_debug", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new p(), 1000);
        goto L274
    L99:
        if (TextUtils.equals("appDebugConfig", r0) == false) goto L102;
        this.c.b("isDebug", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L102:
        if (TextUtils.equals("enableFrontendEtTest", r0) == false) goto L105;
        this.c.b("enable_frontend_et_test", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L105:
        if (TextUtils.equals("syncDocs", r0) == false) goto L108;
        this.c.b("syncDocs", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L108:
        if (TextUtils.equals("database_encrypt", r0) == false) goto L111;
        this.c.b("database_encrypt", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L111:
        if (TextUtils.equals("test_switch", r0) == false) goto L123;
        Boolean r118 = (Boolean) r16;
        com.bytedance.ee.bear.contract.l.a = r118;
        if (r118.booleanValue() == true) goto L115;
        mx4.a r119 = this.m;
        if (r119 == null) goto L121;
        r119.s();
    L121:
        this.b.get().getWindow().clearFlags(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE);
        goto L274
    L115:
        if (this.m != null) goto L117;
        this.m = new mx4.a(this.b.get(), this.i, this.A, this.B, this);
    L117:
        this.m.r();
        this.b.get().getWindow().addFlags(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE);
        goto L274
    L123:
        if ("doc_types".equals(r0) == false) goto L130;
        MultiSelectListPreference r120 = (MultiSelectListPreference) r14;
        CharSequence[] r4 = r120.getEntries();
        ArrayList r5 = new ArrayList();
        Iterator r121 = ((Set) r16).iterator();
    L126:
        if (r121.hasNext() == false) goto L128;
        String r6 = (String) r121.next();
        int r7 = r120.findIndexOfValue(r6);
        tt5.a.b("TAG2", r6 + r4[r7]);
        r5.add(r4[r7].toString());
        goto L126
    L128:
        this.m.q(r5);
        r120.setSummary(r5.toString());
        goto L274
    L130:
        if (TextUtils.equals("wiki_test_switch", r0) == false) goto L142;
        Boolean r122 = (Boolean) r16;
        com.bytedance.ee.bear.contract.l.a = r122;
        if (r122.booleanValue() == true) goto L134;
        lx4.j r123 = this.n;
        if (r123 == null) goto L140;
        r123.r();
    L140:
        this.b.get().getWindow().clearFlags(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE);
        goto L274
    L134:
        if (this.n != null) goto L136;
        this.n = new lx4.j(this.b.get(), this.h, this.i, this.z, this.A, this.f, this.y);
    L136:
        this.n.p();
        this.b.get().getWindow().addFlags(Toast.CUSTOM_TOAST_BOTTOM_MARGIN_VALUE);
        goto L274
    L142:
        if (TextUtils.equals("offline_support_change_resource", r0) == false) goto L145;
        this.c.b(r0, r16);
        goto L274
    L145:
        if (TextUtils.equals("rn_preload", r0) == false) goto L148;
        this.c.b(r0, r16);
        goto L274
    L148:
        if (TextUtils.equals("domain_enable", r0) == false) goto L151;
        this.c.b(r0, r16);
        goto L274
    L151:
        if (TextUtils.equals("ttwebview_enable", r0) == false) goto L159;
        this.c.b(r0, r16);
        if (r16 == Boolean.FALSE) goto L155;
    L157:
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L155:
        if (this.x.isChecked() == false) goto L157;
        this.x.setChecked(false);
        goto L157
    L159:
        if (TextUtils.equals("ttwebview_m62_enable", r0) == false) goto L167;
        this.c.b(r0, r16);
        if (r16 == Boolean.TRUE) goto L163;
    L165:
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L163:
        if (this.w.isChecked() == true) goto L165;
        this.w.setChecked(true);
        goto L165
    L167:
        if (TextUtils.equals("ocr_enable", r0) == false) goto L170;
        this.c.b(r0, r16);
        goto L274
    L170:
        if (TextUtils.equals("rust_net_enable", r0) == false) goto L173;
        this.c.b(r0, r16);
        goto L274
    L173:
        if ("ip_proxy_rust".equals(r0) == false) goto L182;
        String r124 = (String) r16;
        if (TextUtils.isEmpty(r124) == false) goto L177;
    L179:
        this.c.b(r0, r124);
        throw null;
    L177:
        if (r124.startsWith("http") == true) goto L179;
        r124 = "http://".concat(r124);
        goto L179
    L182:
        if (TextUtils.equals("lark_docs_newer_guide_switch", r0) == false) goto L185;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L185:
        if (TextUtils.equals("rn_doze", r0) == false) goto L188;
        this.c.b(r0, r16);
        goto L274
    L188:
        if (TextUtils.equals("tt_video_log_enable", r0) == false) goto L191;
        this.c.b(r0, r16);
        goto L274
    L191:
        if (TextUtils.equals("global_onboarding_enable", r0) == false) goto L194;
        this.c.b(r0, r16);
        goto L274
    L194:
        if (TextUtils.equals("global_onboarding_native_only_enable", r0) == false) goto L197;
        this.c.b(r0, r16);
        goto L274
    L197:
        if (TextUtils.equals("wikitree_collab_enable", r0) == false) goto L199;
    L273:
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new q(), 1000);
        goto L274
    L199:
        if (TextUtils.equals("initGecko", r0) == true) goto L273;
        if (TextUtils.equals("wikitree_show_areaId", r0) == false) goto L205;
        this.c.b(r0, r16);
        goto L274
    L205:
        if (TextUtils.equals("wikitree_show_status", r0) == false) goto L208;
        this.c.b(r0, r16);
        goto L274
    L208:
        if (TextUtils.equals("offline_auto_download_full_res", r0) == false) goto L211;
        this.c.b(r0, r16);
        goto L274
    L211:
        if (TextUtils.equals("enable_debug_res", r0) == false) goto L214;
        this.c.b(r0, r16);
        goto L274
    L214:
        if (TextUtils.equals("offline_disable_specific_res", r0) == false) goto L217;
        this.c.b(r0, r16);
        goto L274
    L217:
        if (TextUtils.equals("header_append_params_enable", r0) == false) goto L228;
        CheckBoxPreference r125 = (CheckBoxPreference) this.a.findPreference("header_append_params_enable_rn");
        if (r125 != null) goto L221;
    L226:
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L221:
        if (this.E == true) goto L223;
    L225:
        r125.setEnabled(r8);
        goto L226
    L223:
        if (((Boolean) r16).booleanValue() == false) goto L225;
        r8 = true;
        goto L225
    L228:
        if (TextUtils.equals("header_append_params_enable_rn", r0) == false) goto L231;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L231:
        if (TextUtils.equals("admin_permission_mock", r0) == false) goto L234;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new r(), 1000);
        goto L274
    L234:
        if (TextUtils.equals("watermark_enable", r0) == false) goto L237;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L237:
        if (TextUtils.equals("sheet_preload_template", r0) == false) goto L239;
    L272:
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L239:
        if (TextUtils.equals("sheet_template", r0) == true) goto L272;
        if (TextUtils.equals("sensitive_log_enable", r0) == false) goto L245;
        this.c.b(r0, r16);
        this.c.b("sensitive_report_enable", r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new s(), 1000);
        goto L274
    L245:
        if (TextUtils.equals("screen_protection", r0) == false) goto L248;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new g(), 1000);
        goto L274
    L248:
        if (TextUtils.equals("net_interceptable", r0) == false) goto L251;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L251:
        if (TextUtils.equals("sensitive_report_enable", r0) == false) goto L254;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        new Handler().postDelayed(new h(), 1000);
        goto L274
    L254:
        if (TextUtils.equals("offline_res_enable_source_map", r0) == false) goto L257;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L257:
        if (TextUtils.equals("preload_docs_sdk_enable", r0) == false) goto L262;
        this.c.b(r0, r16);
        if (Boolean.TRUE.equals(r16) == true) goto L274;
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L262:
        if (TextUtils.equals("roaster_zip_link", r0) == false) goto L265;
        this.c.b(r0, r16);
        int r126 = tx4.a.a;
        String r127 = (String) r16;
        a r128 = new a(this);
        Intrinsics.checkNotNullParameter(r127, "zipUrl");
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).z8(new Request.Builder().url(r127).build(), new tx4.b(r127, r128));
        goto L274
    L265:
        if (TextUtils.equals("disable_preload_document", r0) == false) goto L270;
        this.c.b(r0, r16);
        if (Boolean.TRUE.equals(r16) == true) goto L274;
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    L270:
        if (TextUtils.equals("drive_same_render_emed_on", r0) == false) goto L274;
        this.c.b(r0, r16);
        Toast.showSuccessText(this.b.get(), this.b.get().getString(2131887648), 1);
        goto L274
    }
}
