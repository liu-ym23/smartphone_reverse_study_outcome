package com.ss.android.lark.language.service.impl;

import android.app.LocaleManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.core.storage.CoreStorage;
import com.ss.android.lark.language.loader.BaseLanguageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class GlobalLanguageServiceImpl implements apb.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f431080e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.core.storage.b f431081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f431082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f431083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f431084d;

    public static final class a {
    }

    static {
        f431080e = true;
    }

    @Override // apb.a
    public final Locale e() {
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        if (Build.VERSION.SDK_INT < 33) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        LarkAppContext.Companion.getClass();
        return ((LocaleManager) LarkAppContext.access$getInstance$cp().getContext().getSystemService(LocaleManager.class)).getSystemLocales().get(0);
    L9:
        LocaleListCompat r102 = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        Log.i("GlobalLanguageServiceImpl", r102.toString());
        Locale r103 = r102.get(0);
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        r101 = false;
        goto L6
    }

    @Override // apb.a
    public final Locale getLanguageSetting() {
        com.ss.android.lark.storage.a r100 = CoreStorage.f419520a;
        Intrinsics.checkNotNullParameter("COMMON", "scene");
        com.ss.android.lark.storage.kv.repo.a r101 = LarkKVStorage.g(CoreStorage.f419520a, "COMMON", true);
        String r102 = r101.getString("params_language_locale", "");
        String r103 = r101.getString("params_language_contry", "");
        String r104 = r101.getString("params_language_script", "");
        if (TextUtils.isEmpty(r102) == true) goto L5;
    L7:
        f431080e = false;
        Locale r105 = new Locale.Builder().setLanguage(r102).setRegion(r103).setScript(r104).build();
    L8:
        Locale r106 = b(r105);
        c.a.f431101a.f431100a = r106;
        Locale.setDefault(r106);
        return r106;
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L7;
        f431080e = true;
        r105 = e();
        goto L8
    }

    @Override // apb.a
    public final Locale f() {
        return b(e());
    }

    @Override // apb.a
    public final String g() {
        return d(getLanguageSetting());
    }

    @Override // apb.a
    public final boolean a() {
        return f431080e;
    }

    @Override // apb.a
    public final Locale c() {
        return this.f431082b;
    }

    @Inject
    public GlobalLanguageServiceImpl(com.ss.android.lark.core.storage.b r100) {
        Intrinsics.checkNotNullParameter(r100, "globalCoreStorage");
        this.f431081a = r100;
        this.f431082b = new Locale("en", "US");
        this.f431083c = LazyKt.lazy(new GlobalLanguageServiceImpl$globalCoreRepo$2(this));
        this.f431084d = LazyKt.lazy(new GlobalLanguageServiceImpl$languageLoader$2(this));
    }

    public final Locale b(Locale r110) {
        BaseLanguageLoader r100 = (BaseLanguageLoader) this.f431084d.getValue();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "locale");
        String r101 = r110.getCountry();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        String r103 = r110.getLanguage() + '_' + r110.getCountry();
    L12:
        boolean r104 = Intrinsics.areEqual("zh", r110.getLanguage());
        Log.i("LaunchLocaleWatch", "checkSupportLanguage--->locale tag is " + r103);
        if (((HashMap) r100.f431079e.getValue()).containsKey(r103) == false) goto L15;
        if (r104 == true) goto L15;
        return r110;
    L15:
        Intrinsics.checkNotNull(r103);
        String r111 = r110.getScript();
        Locale r105 = new Locale("en", "US");
        Locale r106 = new Locale("zh", "CN");
        Locale r107 = new Locale("zh", "TW");
        Locale r108 = new Locale("zh", "HK");
        if (r104 == true) goto L18;
        Iterator r112 = ((LinkedHashMap) r100.f431077c.getValue()).keySet().iterator();
    L29:
        if (r112.hasNext() == false) goto L33;
        Locale r109 = (Locale) r112.next();
        if (StringsKt.startsWith$default(r103, r109.getLanguage(), false, 2, null) == false) goto L29;
        Log.i("LaunchLocaleWatch", "degraded locale2NameMap language, result: " + dpb.a.a(r109));
        Intrinsics.checkNotNull(r109);
        return r109;
    L33:
        Log.i("LaunchLocaleWatch", "degraded language, result: " + dpb.a.a(r105));
        return r105;
    L18:
        if (StringsKt.startsWith$default(r103, "zh_TW", false, 2, null) == false) goto L21;
    L25:
        r106 = r107;
    L26:
        Locale r113 = new Locale.Builder().setLanguage(r106.getLanguage()).setRegion(r106.getCountry()).setScript(r111).build();
        Log.i("LaunchLocaleWatch", "degraded chinese language, result: " + dpb.a.a(r113));
        Intrinsics.checkNotNull(r113);
        return r113;
    L21:
        if (StringsKt.startsWith$default(r103, "zh_HK", false, 2, null) == false) goto L24;
        r106 = r108;
        goto L26
    L24:
        if (Intrinsics.areEqual(r111, "Hant") == false) goto L26;
    L11:
        r103 = r110.getLanguage();
        goto L12
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // apb.a
    public final String d(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        String r101 = r100.getLanguage() + '_' + r100.getCountry().toUpperCase(Locale.getDefault());
        if (Intrinsics.areEqual("in_ID", r101) == false) goto L6;
        return "id_ID";
    L6:
        return r101;
    }
}
