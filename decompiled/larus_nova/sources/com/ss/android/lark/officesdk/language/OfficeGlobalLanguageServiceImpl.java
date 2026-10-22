package com.ss.android.lark.officesdk.language;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.dtf.face.api.IDTFacade;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSdkLanguageProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class OfficeGlobalLanguageServiceImpl implements apb.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Locale f433390c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Locale f433391d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Locale f433392e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Locale f433393f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Locale f433394g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<Locale> f433395h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final List<Locale> f433396i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f433398b;

    public static final class a {
    }

    @Override // apb.a
    public final boolean a() {
        return true;
    }

    static {
        Locale r100 = new Locale("zh", "CN");
        f433390c = r100;
        Locale r101 = new Locale("zh", "HK");
        f433391d = r101;
        Locale r102 = new Locale("zh", "TW");
        f433392e = r102;
        Locale r103 = new Locale("en", "US");
        f433393f = r103;
        Locale r104 = new Locale("es", "419");
        f433394g = r104;
        f433395h = CollectionsKt.listOf(new Locale[]{r100, r101, r102});
        f433396i = CollectionsKt.listOf(new Locale[]{r103, new Locale("id", "ID"), new Locale("ms", "MY"), new Locale("de", "DE"), new Locale("es", "ES"), new Locale("fr", "FR"), new Locale("it", "IT"), new Locale(GXTemplateKey.GAIAX_PT, "BR"), new Locale("vi", "VN"), new Locale("ru", "RU"), new Locale("th", "TH"), new Locale(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_JA, "JP"), new Locale(IDTFacade.ZIM_EXT_PARAMS_LAN_VAL_KO, "KR"), r100, r101, r102, new Locale(RTLUtil.ARABIA_LANG), new Locale("en", "GB"), r104, new Locale("fil"), new Locale("tr"), new Locale("uz")});
    }

    @Override // apb.a
    public final Locale c() {
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L6;
        return f433393f;
    L6:
        return f433390c;
    }

    @Override // apb.a
    public final Locale e() {
        return ((IOfficeSdkLanguageProvider) this.f433398b.getValue()).getLocale();
    }

    @Override // apb.a
    public final Locale getLanguageSetting() {
        return ((IOfficeSdkLanguageProvider) this.f433398b.getValue()).getLocale();
    }

    @Inject
    public OfficeGlobalLanguageServiceImpl() {
        this.f433397a = LazyKt.lazy(new OfficeGlobalLanguageServiceImpl$isOverseaPackage$2(this));
        this.f433398b = LazyKt.lazy(OfficeGlobalLanguageServiceImpl$languageProvider$2.INSTANCE);
    }

    @Override // apb.a
    public final Locale f() {
        return b(e());
    }

    @Override // apb.a
    public final String g() {
        return d(getLanguageSetting());
    }

    public final Locale b(Locale r100) {
        if (StringsKt.equals("zh", r100.getLanguage(), true) == false) goto L5;
        String r101 = r100.getCountry();
        Locale r102 = Locale.ROOT;
        String r103 = r101.toUpperCase(r102);
        String r104 = r100.getScript().toUpperCase(r102);     // Catch: Throwable -> L58
    L60:
        if (Intrinsics.areEqual(r104, "HANS") == false) goto L64;
        return f433390c;
    L64:
        if (Intrinsics.areEqual(r104, "HANT") == true) goto L66;
        int r105 = r103.hashCode();
        if (r105 == 2155) goto L102;
        if (r105 == 2307) goto L98;
        if (r105 == 2466) goto L94;
        if (r105 == 2476) goto L91;
        if (r105 == 2644) goto L88;
        if (r105 != 2691) goto L123;
        if (r103.equals("TW") == false) goto L123;
        return f433392e;
    L123:
        return f433390c;
    L88:
        if (r103.equals("SG") == false) goto L123;
    L105:
        return f433390c;
    L91:
        if (r103.equals("MY") == true) goto L105;
    L94:
        if (r103.equals("MO") == false) goto L123;
        return f433391d;
    L98:
        if (r103.equals("HK") == false) goto L123;
        return f433391d;
    L102:
        if (r103.equals("CN") == true) goto L105;
    L66:
        if (Intrinsics.areEqual(r103, "TW") == false) goto L69;
        return f433392e;
    L69:
        return f433391d;
    L58:
        r104 = "";
        goto L60
    L5:
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L51;
        String r106 = r100.getLanguage();
        Locale r107 = Locale.ROOT;
        String r108 = r106.toLowerCase(r107);
        String r109 = r100.getCountry().toUpperCase(r107);
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L9;
        List<Locale> r110 = f433396i;
    L10:
        Iterator<T> r111 = r110.iterator();
    L11:
        Object r112 = null;
        if (r111.hasNext() == false) goto L21;
        Object r113 = r111.next();
        Locale r114 = (Locale) r113;
        if (StringsKt.equals(r114.getLanguage(), r108, true) == true) goto L16;
    L18:
        boolean r115 = false;
    L19:
        if (r115 == false) goto L11;
    L22:
        Locale r116 = (Locale) r113;
        if (r116 == null) goto L26;
        return r116;
    L26:
        if (Intrinsics.areEqual("es", r108) == false) goto L29;
        return f433394g;
    L29:
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L31;
        List<Locale> r117 = f433396i;
    L32:
        Iterator<T> r118 = r117.iterator();
    L34:
        if (r118.hasNext() == false) goto L38;
        Object r119 = r118.next();
        if (StringsKt.equals(((Locale) r119).getLanguage(), r108, true) == false) goto L34;
        r112 = r119;
    L38:
        Locale r120 = (Locale) r112;
        if (r120 != null) goto L118;
        StringBuilder r121 = new StringBuilder("unsupported locale ");
        r121.append(r108);
        r121.append('-');
        r121.append(r109);
        r121.append(", fallback to ");
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L44;
        Locale r122 = f433393f;
    L45:
        r121.append(r122);
        Log.i("OfficeLanguageService", r121.toString());
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L48;
        Locale r123 = f433393f;
    L116:
        return r123;
    L48:
        r123 = f433390c;
        goto L116
    L44:
        r122 = f433390c;
        goto L45
    L118:
        return r120;
    L31:
        r117 = f433395h;
        goto L32
    L16:
        if (StringsKt.equals(r114.getCountry(), r109, true) == false) goto L18;
        r115 = true;
        goto L19
    L21:
        r113 = null;
        goto L22
    L9:
        r110 = f433395h;
        goto L10
    L51:
        if (((Boolean) this.f433397a.getValue()).booleanValue() == false) goto L53;
        r123 = f433393f;
        goto L116
    L53:
        r123 = f433390c;
        goto L116
    }

    @Override // apb.a
    public final String d(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        Locale r101 = b(r100);
        String r102 = r101.getCountry();
        Intrinsics.checkNotNull(r102);
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        String r104 = r101.getLanguage();
    L10:
        if (Intrinsics.areEqual("in_ID", r104) == false) goto L12;
        r104 = "id_ID";
    L12:
        Intrinsics.checkNotNull(r104);
        return r104;
    L8:
        r104 = r101.getLanguage() + '_' + r102.toUpperCase(Locale.getDefault());
        goto L10
    L5:
        r103 = false;
        goto L6
    }
}
