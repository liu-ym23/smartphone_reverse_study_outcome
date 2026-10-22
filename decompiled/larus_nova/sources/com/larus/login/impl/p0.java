package com.larus.login.impl;

import android.content.Context;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f358189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f358190b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f358191c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f358192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f358193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f358194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f358195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f358196e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f358192a, r101.f358192a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f358193b, r101.f358193b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f358194c, r101.f358194c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f358195d, r101.f358195d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f358196e, r101.f358196e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f358192a.hashCode() * 31;
            String r101 = this.f358193b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((((r100 + r103) * 31) + this.f358194c.hashCode()) * 31) + this.f358195d.hashCode()) * 31;
            String r105 = this.f358196e;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CountryData(englishName=" + this.f358192a + ", chineseName=" + this.f358193b + ", countryCode=" + this.f358194c + ", phoneCode=" + this.f358195d + ", pinyin=" + this.f358196e + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "englishName");
            Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_COUNTRY_CODE);
            Intrinsics.checkNotNullParameter(r103, "phoneCode");
            this.f358192a = r100;
            this.f358193b = r101;
            this.f358194c = r102;
            this.f358195d = r103;
            this.f358196e = r104;
        }
    }

    public p0() {
    }

    static {
        f358189a = new p0();
        f358190b = SetsKt.setOf(new String[]{"HK", "MO", "TW"});
        f358191c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new m0());
    }

    public static boolean b(Locale r100) {
        if (Intrinsics.areEqual(r100.getLanguage(), Locale.CHINESE.getLanguage()) == true) goto L6;
        return false;
    L6:
        if (StringsKt.equals(r100.getScript(), "Hant", true) == false) goto L8;
    L9:
        return true;
    L8:
        if (f358190b.contains(r100.getCountry().toUpperCase(Locale.ROOT)) == true) goto L9;
        return false;
    }

    public static JSONArray a(Locale r110, Context r111) {
        Intrinsics.checkNotNullParameter(r110, "locale");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r0.f358205b.contains(r110.getLanguage()) == true) goto L6;
        r110 = r0.f358204a;
    L6:
        JSONArray r100 = new JSONArray();
        Iterator r101 = ((List) f358191c.getValue()).iterator();
    L8:
        if (r101.hasNext() == false) goto L73;
        a r102 = (a) r101.next();
        JSONObject r103 = new JSONObject();
        f358189a.getClass();
        AppHost.Companion r104 = AppHost.f326268a;
        boolean r105 = false;
        if (r104.isOversea() == false) goto L12;
    L21:
        String r106 = new Locale("", r102.f358194c).getDisplayCountry(r110);
        Intrinsics.checkNotNull(r106);
        if (StringsKt.isBlank(r106) == false) goto L24;
    L25:
        r105 = true;
    L26:
        if (r105 == false) goto L29;
        r106 = null;
    L29:
        if (r106 != null) goto L32;
        r106 = r102.f358192a;
    L32:
        if (r104.isOversea() == false) goto L34;
    L52:
        String r107 = r102.f358194c.toUpperCase(Locale.ROOT);
        int r112 = r107.hashCode();
        if (r112 == 2307) goto L66;
        if (r112 == 2466) goto L62;
        if (r112 == 2691) goto L58;
    L67:
        String r108 = r106;
    L69:
        r103.put("country_name", r108);
        r103.put("country_code", r102.f358194c);
        r103.put("phone_code", r102.f358195d);
        String r109 = r102.f358196e;
        if (r109 == null) goto L72;
        r103.put("pin_yin", r109);
    L72:
        r100.put(r103);
        goto L8
    L58:
        if (r107.equals("TW") == false) goto L67;
        r108 = r111.getString(R.string.larus_regionPick_TaiwanCN);
        goto L69
    L62:
        if (r107.equals("MO") == false) goto L67;
        r108 = r111.getString(R.string.larus_regionPick_MacaoCN);
        goto L69
    L66:
        if (r107.equals("HK") == false) goto L67;
        r108 = r111.getString(R.string.larus_regionPick_HKCN);
        goto L69
    L34:
        if (b(r110) == false) goto L52;
        String r113 = r111.getString(R.string.larus_language_china_traditional);
        String r114 = r102.f358194c.toUpperCase(Locale.ROOT);
        int r115 = r114.hashCode();
        if (r115 == 2307) goto L49;
        if (r115 == 2466) goto L45;
        if (r115 != 2691) goto L67;
        if (r114.equals("TW") == false) goto L67;
        r108 = r113 + r111.getString(R.string.larus_language_taiwan_traditional);
        goto L69
    L45:
        if (r114.equals("MO") == false) goto L67;
        r108 = r113 + r111.getString(R.string.larus_language_macao_traditional);
        goto L69
    L49:
        if (r114.equals("HK") == false) goto L67;
        r108 = r113 + r111.getString(R.string.larus_language_hongkong_traditional);
        goto L69
    L24:
        if (StringsKt.equals(r106, r102.f358194c, true) == false) goto L26;
    L12:
        if (Intrinsics.areEqual(r110.getLanguage(), Locale.CHINESE.getLanguage()) == true) goto L14;
    L16:
        boolean r116 = false;
    L17:
        if (r116 == false) goto L21;
        r108 = r102.f358193b;
        if (r108 != null) goto L69;
        r108 = r102.f358192a;
        goto L69
    L14:
        if (b(r110) == true) goto L16;
        r116 = true;
        goto L17
    L73:
        return r100;
    }
}
