package com.ss.android.lark.widget.span;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.miui.easygo.constant.EasyGoConstant;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes38.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f448714a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f448715b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f448716c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f448717d = null;

    static {
        String r100 = "[" + "A-Za-z0-9\\-\\._~:\\/\\?#\\[\\\\\\]@\\!\\$&'\\(\\)\\*\\+,;=%".replace("\\[", "").replace("\\]", "").replace("\\(", "").replace("\\)", "").replace(",", "").replace(EasyGoConstant.VERSION_SEPARATIVE_SIGN, "") + "]";
        f448714a = r100;
        f448715b = "(http|https|ftp|lark)://" + ("[" + "A-Za-z0-9\\-\\._~:\\/\\?#\\[\\\\\\]@\\!\\$&'\\(\\)\\*\\+,;=%".replace("\\[", "").replace("\\]", "").replace("\\(", "").replace("\\)", "").replace(",", "") + "]") + Marker.ANY_NON_NULL_MARKER + r100 + "(?!" + r100 + ")";
        StringBuilder r101 = new StringBuilder("(?!.*(http|https|ftp|lark)://)[A-Za-z0-9\\-\\._~:\\/\\?#\\[\\\\\\]@\\!\\$&'\\(\\)\\*\\+,;=%]{2,}\\.(");
        String[] r102 = j0.f448696a;
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
    L3:
        String[] r105 = j0.f448696a;
        if (r104 >= r105.length) goto L9;
        if (r103.length() <= 0) goto L8;
        r103.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L8:
        r103.append(r105[r104]);
        r104 = r104 + 1;
        goto L3
    L9:
        r101.append(r103.toString());
        r101.append(")(:[0-9]+)?(/[A-Za-z0-9\\-\\._~:\\/\\?#\\[\\\\\\]@\\!\\$&'\\(\\)\\*\\+,;=%]*");
        String r106 = f448714a;
        r101.append(r106);
        r101.append("|/)?(?!");
        r101.append(r106);
        r101.append(")");
        String r107 = r101.toString();
        StringBuilder r108 = new StringBuilder("(?i)(");
        String r109 = f448715b;
        r108.append(r109);
        r108.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r108.append(r107);
        r108.append(")");
        f448716c = r108.toString();
        f448717d = "(?i)(" + r109 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + ("(?!.*(http|https|ftp|lark)://)[A-Za-z0-9\\-\\._~:\\/\\?#\\[\\\\\\]@\\!\\$&'\\(\\)\\*\\+,;=%]{2,}\\.(((aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(biz|b[abdefghijmnorstvwyz])|(cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(edu|e[cegrstu])|f[ijkmor]|(gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(info|int|i[delmnoqrst])|(jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(name|net|n[acefgilopruz])|(org|om)|(pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))(:[0-9]+)?(/[A-Za-z0-9\\-\\._~:\\/\\?#\\[\\\\\\]@\\!\\$&'\\(\\)\\*\\+,;=%]*" + r106 + "|/)?(?!" + r106 + ")") + ")";
    }
}
