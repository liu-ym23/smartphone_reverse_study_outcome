package com.ss.android.lark.language.service.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.larksuite.framework.utils.Reflect;
import com.larksuite.framework.utils.b0;
import com.larksuite.framework.utils.x;
import com.larksuite.framework.utils.z;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.LogLevel;
import cpb.d;
import dagger.Lazy;
import e0c.k;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements apb.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f431092f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<zob.b, Object> f431093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LanguageChangeBroadcastReceiver f431094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f431095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<zob.a> f431096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C5119a f431097e;

    /* JADX INFO: renamed from: com.ss.android.lark.language.service.impl.a$a, reason: collision with other inner class name */
    public class C5119a implements Lazy<apb.a> {
        @Override // dagger.Lazy
        public final apb.a get() {
            return (apb.a) k.a(LarkAppContext.inst().getContext(), apb.a.class);
        }

        public C5119a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final apb.b f431098a = null;

        static {
            int r100 = a.f431092f;
            if (Build.VERSION.SDK_INT < 33) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            apb.b r102 = new LanguageSettingServiceApi33();
        L9:
            f431098a = r102;
            return;
        L8:
            r102 = new a();
            goto L9
        L5:
            r101 = false;
            goto L6
        }
    }

    static {
        new Locale("en", "US");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        LocaleList.getDefault();
        return;
    }

    @Override // apb.b
    public final boolean a() {
        return ((apb.a) this.f431097e.get()).a();
    }

    @Override // apb.b
    public final Locale e() {
        return ((apb.a) this.f431097e.get()).e();
    }

    @Override // apb.b
    public final Locale getCacheLanguageSetting() {
        return this.f431095c.a();
    }

    @Override // apb.b
    public final Locale getLanguageSetting() {
        return ((apb.a) this.f431097e.get()).getLanguageSetting();
    }

    public a() {
        this.f431093a = new ConcurrentHashMap();
        this.f431096d = new CopyOnWriteArrayList();
        this.f431097e = new C5119a();
        this.f431095c = c.a.f431101a;
    }

    @Override // apb.b
    public final String b() {
        Locale r100 = getLanguageSetting();
        if (r100 != null) goto L5;
        isGooglePlay();
        return "en";
    L5:
        return r100.getLanguage().toLowerCase();
    }

    @Override // apb.b
    public final Locale g() {
        Locale r100 = getCacheLanguageSetting();
        if (r100 == null) goto L7;
        if (TextUtils.isEmpty(r100.getLanguage()) == true) goto L7;
        return r100;
    L7:
        return ((apb.a) this.f431097e.get()).c();
    }

    @Override // apb.b
    public final boolean isGooglePlay() {
        return LarkAppContext.inst().buildConfig().isUsPackage();
    }

    public static apb.b o() {
        return b.f431098a;
    }

    @Override // apb.b
    public final void c(zob.b r100) {
        LanguageChangeBroadcastReceiver r101 = this.f431094b;
        if (r101 != null) goto L6;
        this.f431093a.put(r100, new Object());
        return;
    L6:
        if (r101.f431086a.contains(r100) == true) goto L11;
        r101.f431086a.add(r100);
        return;
    }

    @Override // apb.b
    public final String d(Locale r100) {
        return ((apb.a) this.f431097e.get()).d(r100);
    }

    @Override // apb.b
    public final void h(Configuration r100) {
        Locale r101 = getLanguageSetting();
        boolean r102 = false;
        if (x.b() == false) goto L5;
        Locale r103 = r100.getLocales().get(0);
    L6:
        Log.i("LaunchLocaleWatch", "scene= isSameWithSetting, context's locale is " + r101 + ", target locale is " + r103);
        if (TextUtils.equals(r103.getLanguage(), r101.getLanguage()) == true) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L14;
    L18:
        r102 = r104;
    L20:
        if (r102 == false) goto L23;
        Log.i("LanguageSettingService", "currentLocale equals configLocale, configLocale: " + r103);
        return;
    L23:
        if (x.b() == false) goto L25;
        r100.setLocale(r101);
    L26:
        Log.i("LanguageSettingService", "changed the locale of newConfig, configLocale: " + r103);
        return;
    L25:
        r100.locale = r101;
        goto L26
    L14:
        if (TextUtils.equals("zh_CN", r101.getLanguage() + "_" + r101.getCountry()) == false) goto L18;
        if (TextUtils.equals(r101.getScript(), r103.getScript()) == true) goto L18;
    L9:
        if (TextUtils.equals(r103.getCountry(), r101.getCountry()) == false) goto L11;
        r104 = true;
        goto L12
    L5:
        r103 = r100.locale;
        goto L6
    }

    @Override // apb.b
    public final Context j(Context r100) {
        Locale r101 = getLanguageSetting();
        if (p(r100, r101) == false) goto L6;
        Log.i("LanguageSettingService", "same locale");
        return r100;
    L6:
        Configuration r102 = new Configuration(r100.getResources().getConfiguration());
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 24) goto L9;
        r102.setLocale(r101);
    L10:
        Resources r104 = r100.getResources();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        r100.getResources().updateConfiguration(r102, r105);
        Context r106 = r100.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r106);
        if (r103 <= 27) goto L14;
        n(r106.getResources(), r100.getResources());
    L14:
        if (p(r106, r101) == false) goto L16;
        return r106;
    L16:
        return r100;
    L9:
        r102.locale = r101;
        goto L10
    }

    @Override // apb.b
    public final void k(zob.b r100) {
        Iterator<Map.Entry<zob.b, Object>> r101 = this.f431093a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().getKey() != r100) goto L4;
        this.f431093a.remove(r100);
    L8:
        LanguageChangeBroadcastReceiver r102 = this.f431094b;
        if (r102 == null) goto L17;
        if (r100 != null) goto L12;
        r102.getClass();
        return;
    L12:
        r102.f431086a.remove(r100);
        return;
    }

    @Override // apb.b
    public final void l(Application r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Locale r101 = getLanguageSetting();
        if (p(r100, r101) == true) goto L19;
        StringBuilder r102 = new StringBuilder("change application's lcoale ");
        int r103 = d.f464734a;
        r102.append(d.a.a(r100));
        r102.append(" to ");
        r102.append(r101);
        Log.i("LaunchLocaleWatch", r102.toString());
        Context r104 = j(r100.getBaseContext());
        new Reflect(r100).i("mBase", r104);
        Iterator<zob.a> r105 = this.f431096d.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        zob.a r106 = r105.next();
        if (r106 == null) goto L8;
        r106.a();
        goto L8
    L12:
        Log.i("LanguageSettingService", "update language setting");
        return;
    }

    public static void n(Resources r100, Resources r101) {
        AssetManager r102 = r100.getAssets();     // Catch: Exception -> L4
        AssetManager r103 = r101.getAssets();     // Catch: Exception -> L4
        Method r104 = b0.b(AssetManager.class, "getApkAssets", new Class[0]);     // Catch: Exception -> L4
        r104.setAccessible(true);     // Catch: Exception -> L4
        Object r105 = r104.invoke(r103, new Object[0]);     // Catch: Exception -> L4
        Method r106 = b0.b(AssetManager.class, "setApkAssets", new Class[]{r105.getClass(), Boolean.TYPE});     // Catch: Exception -> L4
        r106.setAccessible(true);     // Catch: Exception -> L4
        r106.invoke(r102, new Object[]{r105, Boolean.TRUE});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("LanguageSettingService", e.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    @Override // apb.b
    public final void f(Application r210, yob.b r211) {
        int r100 = cpb.c.f464733a;
        Intrinsics.checkNotNullParameter(r210, "application");
        int r101 = d.f464734a;
        d.a.c(LocaleWatchScene.APPLICATION_INIT, r210).a(LogLevel.INFO);
        r210.registerActivityLifecycleCallbacks(new cpb.a(r210));
        r210.registerComponentCallbacks(new cpb.b(r210));
        LanguageChangeBroadcastReceiver r110 = new LanguageChangeBroadcastReceiver();
        IntentFilter r111 = new IntentFilter();
        r111.addAction(r210.getPackageName() + ".language.action.LANGUAGE_BROADCAST");
        if (Build.VERSION.SDK_INT < 33) goto L29;
        String r102 = LanguageChangeBroadcastReceiver.a(r210);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L75:
    L23:
        e = e;
        String r112 = r102;
    L25:
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, r112, null, 4);
    L56:
        this.f431094b = r110;
        if (r110.f431086a.contains(r211) == true) goto L61;
        r110.f431086a.add(r211);
    L61:
        if (this.f431093a.isEmpty() == true) goto L70;
        Iterator<Map.Entry<zob.b, Object>> r103 = this.f431093a.entrySet().iterator();
    L64:
        if (r103.hasNext() == false) goto L69;
        Map.Entry<zob.b, Object> r104 = r103.next();
        LanguageChangeBroadcastReceiver r105 = this.f431094b;
        zob.b r106 = r104.getKey();
        if (r105.f431086a.contains(r106) == true) goto L64;
        r105.f431086a.add(r106);
        goto L64
    L69:
        this.f431093a.clear();
    L70:
        Locale r107 = getLanguageSetting();
        int r108 = d.f464734a;
        Locale r109 = d.a.a(r210);
        int r113 = cpb.c.f464733a;
        cpb.c.a.a(LocaleWatchScene.APPLICATION_INIT, r210, r107, r109);
        m(r210, r107);
        return;
    L28:
        throw e;
    L80:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L19;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L19;
        r112 = r102;
        int r114 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 4, r102, null, 5, r210).result;     // Catch: Exception -> L21
        if (r114 == 1) goto L18;
        if (r114 == 2) goto L17;
        if (r114 == 3) goto L79;
        r210.registerReceiver(r110, r111, r112, null, 4);     // Catch: Exception -> L21
    L79:
        goto L56
    L17:
        new Intent();     // Catch: Exception -> L21
        goto L79
    L18:
        r210.registerReceiver(r110, r111, r112, null, 4);     // Catch: Exception -> L21
    L19:
        r112 = r102;
        r210.registerReceiver(r110, r111, r112, null, 4);     // Catch: Exception -> L21
    L21:
        e = e;
        goto L25
    L29:
        String r115 = LanguageChangeBroadcastReceiver.a(r210);
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L77;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L77:
        String r116 = ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize();     // Catch: Exception -> L51
        if (r116 == 0) goto L47;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L47;
        int r117 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 0, r115, null, 4, r210).result;     // Catch: Exception -> L45
        if (r117 == 1) goto L44;
        if (r117 == 2) goto L43;
        if (r117 == 3) goto L56;
        String r118 = r115;
        r210.registerReceiver(r110, r111, r118, null);     // Catch: Exception -> L49
        r116 = r118;
    L82:
        goto L56
    L43:
        r116 = r115;
        new Intent();     // Catch: Exception -> L49
        goto L82
    L44:
        String r119 = r115;
        r210.registerReceiver(r110, r111, r119, null);     // Catch: Exception -> L49
        r116 = r119;
    L45:
        e = e;
        r116 = r115;
    L53:
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L72;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, r116, null);
        goto L56
    L72:
        throw e;
    L47:
        String r120 = r115;
        r210.registerReceiver(r110, r111, r120, null);     // Catch: Exception -> L49
        r116 = r120;
    L49:
        e = e;
    L51:
        e = e;
        r116 = r115;
        goto L53
    }

    @Override // apb.b
    public final Context i(Context r100, Locale r101) {
        Configuration r102 = new Configuration(r100.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r102.setLocale(r101);
    L6:
        Resources r103 = r100.getResources();
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics());
        r100.getResources().updateConfiguration(r102, r104);
        Context r105 = r100.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r105);
        return r105;
    L5:
        r102.locale = r101;
        goto L6
    }

    @Override // apb.b
    public final boolean m(Application r100, Locale r101) {
        if (p(r100, r101) == true) goto L28;
        Configuration r102 = r100.getResources().getConfiguration();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 24) goto L7;
        Locale r104 = r102.getLocales().get(0);
    L8:
        Configuration r105 = new Configuration(r102);
        if (r103 < 24) goto L11;
        r105.setLocale(r101);
    L12:
        Resources r106 = r100.getResources();
        r100.getResources().updateConfiguration(r105, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()));
        Context r107 = r100.createConfigurationContext(r105);
        NewMiraResourcesManager.getInstance().install(r107);
        if (r103 <= 27) goto L16;
        n(r107.getResources(), r100.getResources());
    L16:
        if (p(r107, r101) == false) goto L24;
        new Reflect(r100).i("mBase", r107);
        Iterator<zob.a> r108 = this.f431096d.iterator();
    L19:
        if (r108.hasNext() == false) goto L24;
        zob.a r109 = r108.next();
        if (r109 == null) goto L19;
        r109.a();
    L24:
        if (z.e(r100) == false) goto L34;
        Intent r110 = new Intent();
        r110.putExtra("KEY_ORIGIN_LOCALE", r104);
        r110.putExtra("KEY_NEW_LOCALE", r101);
        int r111 = LanguageChangeBroadcastReceiver.f431085b;
        r110.setAction(r100.getPackageName() + ".language.action.LANGUAGE_BROADCAST");
        r110.setPackage(r100.getPackageName());
        r100.sendBroadcast(r110, LanguageChangeBroadcastReceiver.a(r100));
        return true;
    L34:
        return true;
    L11:
        r105.locale = r101;
        goto L12
    L7:
        r104 = r102.locale;
        goto L8
    L28:
        return false;
    }

    public final boolean p(Context r100, Locale r101) {
        Locale r102 = r100.getResources().getConfiguration().locale;
        Log.i("LaunchLocaleWatch", "scene= isSameWithSetting, context's locale is " + r102 + ", target locale is " + r101);
        if (TextUtils.equals(r101.getLanguage(), r102.getLanguage()) == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L14:
        return r103;
    L10:
        if (TextUtils.equals("zh_CN", r102.getLanguage() + "_" + r102.getCountry()) == false) goto L14;
        if (TextUtils.equals(r102.getScript(), r101.getScript()) == true) goto L14;
        return false;
    L5:
        if (TextUtils.equals(r101.getCountry(), r102.getCountry()) == false) goto L7;
        r103 = true;
        goto L8
    }
}
