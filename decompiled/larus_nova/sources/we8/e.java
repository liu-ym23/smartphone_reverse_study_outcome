package we8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f559400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f559401b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f559402c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f559403d;

    static {
        Lazy r100 = LazyKt.lazy(new b());
        f559400a = r100;
        FontLevel r101 = FontLevel.EXTRA_SMALL;
        FontLevel r102 = FontLevel.STANDARD;
        FontLevel r103 = FontLevel.SUPER_EXTRA_LARGE;
        f559401b = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(r101.getValue()), 14), TuplesKt.to(Integer.valueOf(FontLevel.SMALL.getValue()), 15), TuplesKt.to(Integer.valueOf(r102.getValue()), 17), TuplesKt.to(Integer.valueOf(FontLevel.LARGE.getValue()), 19), TuplesKt.to(Integer.valueOf(FontLevel.EXTRA_LARGE.getValue()), 21), TuplesKt.to(Integer.valueOf(r103.getValue()), 26)});
        f559402c = LazyKt.lazy(new c());
        f559403d = r102.getValue();
        ir9.c r104 = z2.f365865a.getFontSizeAllowConfig();
        if (r104 == null) goto L14;
        int r105 = ((Keva) r100.getValue()).getInt("font_size_level", Integer.MIN_VALUE);
        if (r104.a() == true) goto L10;
        if (r105 != r101.getValue()) goto L10;
    L13:
        ((Keva) r100.getValue()).storeInt("font_size_level", r102.getValue());
    L10:
        if (r104.b() == true) goto L14;
        if (r105 == r103.getValue()) goto L13;
    L14:
        int r106 = ((Keva) r100.getValue()).getInt("font_size_level", Integer.MIN_VALUE);
        if (r106 >= r101.getValue()) goto L17;
        int r107 = r102.getValue();
    L18:
        f559403d = r107;
        FLogger r108 = FLogger.f375446a;
        r108.i("FontAdjustManager", "updateFontLevel, localLevel: " + r106 + ", _innerCurrentFontLevel: " + f559403d);
        final String r109 = f.a(f559403d);
        r108.i("FontAdjustManager", "setAppLogFontSizeHeader: ".concat(r109));
        t0.a(new d(r109));
        return;
    L17:
        r107 = r106;
        goto L18
    }

    public static int a(boolean r100) {
        if (r100 == false) goto L5;
        return 0;
    L5:
        return b(f559403d);
    }

    public static int b(int r100) {
        Integer r101 = d(r100);
        Integer r102 = f559401b.get(Integer.valueOf(FontLevel.STANDARD.getValue()));
        if (r101 == null) goto L11;
        if (r102 == null) goto L11;
        if (AppHost.f326268a.isDebug() == false) goto L10;
        FLogger.f375446a.i("FontAdjustManager", "getFontSizeDiff,targetSize(" + r100 + ':' + r101 + ") - standardSize(" + r102 + ") diff: " + (r101.intValue() - r102.intValue()));
    L10:
        return r101.intValue() - r102.intValue();
    L11:
        FLogger.f375446a.e("FontAdjustManager", "getFontSizeDiff, level: " + r100 + ", targetSize: " + r101 + ", standardSize: " + r102);
        return 0;
    }

    public static Integer d(int r100) {
        Integer r101 = (Integer) ((Map) f559402c.getValue()).get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        return f559401b.get(Integer.valueOf(r100));
    }

    public static int c(int r100, int r101) {
        Integer r102 = d(r100);
        if (r101 != FontLevel.STANDARD.getValue()) goto L5;
        Integer r103 = f559401b.get(Integer.valueOf(r101));
    L7:
        if (r102 == null) goto L12;
        if (r103 == null) goto L12;
        FLogger.f375446a.i("FontAdjustManager", "getFontSizeDiff, level(" + r100 + ':' + r102 + ") - preLevel(" + r101 + ':' + r103 + ") diff: " + (r102.intValue() - r103.intValue()));
        return r102.intValue() - r103.intValue();
    L12:
        FLogger.f375446a.i("FontAdjustManager", "getFontSizeDiff, level: " + r100 + ", preLevel: " + r101 + ", targetSize: " + r102 + ", preSize: " + r103);
        return 0;
    L5:
        r103 = d(r101);
        goto L7
    }
}
