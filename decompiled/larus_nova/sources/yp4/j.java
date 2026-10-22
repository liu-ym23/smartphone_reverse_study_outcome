package yp4;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.message.wrds.PreviewPromotionSyncData;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.view.widgets.GradientOffsetView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f568713a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f568714a = null;

        static {
            int[] r100 = new int[FieldConfigMetaModel.ProgressColorType.values().length];
            f568714a = r100;
            r100[FieldConfigMetaModel.ProgressColorType.GRADIENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f568714a[FieldConfigMetaModel.ProgressColorType.PURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f568714a[FieldConfigMetaModel.ProgressColorType.MULTI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        HashMap r100 = new HashMap();
        f568713a = r100;
        r100.put(PreviewPromotionSyncData.FANS_RED_PACKET_TYPE_MONEY, "¥");
        r100.put("USD", "$");
        r100.put("EUR", "€");
        r100.put("GBP", "£");
        r100.put("AED", "dh");
        r100.put("AUD", "$");
        r100.put("BRL", "R$");
        r100.put("CAD", "$");
        r100.put("CHF", "CHF");
        r100.put("HKD", "$");
        r100.put("INR", "₹");
        r100.put("IDR", "Rp");
        r100.put("JPY", "¥");
        r100.put("KRW", "₩");
        r100.put("MOP", "MOP$");
        r100.put("MXN", "$");
        r100.put("MYR", "RM");
        r100.put("PHP", "₱");
        r100.put("PLN", "zł");
        r100.put("RUB", "₽");
        r100.put("SGD", "$");
        r100.put("THB", "฿");
        r100.put("TRY", "₺");
        r100.put("TWD", "NT$");
        r100.put("VND", "₫");
    }

    public static int h(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0;
    L6:
        if (k(r100) == false) goto L16;
        String r101 = r100.substring(0, r100.indexOf(37));
        if (TextUtils.isEmpty(r101) == true) goto L23;
        String[] r102 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length == 2) goto L14;
        return 0;
    L14:
        return r102[1].length();
    L23:
        return 0;
    L16:
        if (TextUtils.isEmpty(r100) == true) goto L25;
        String[] r103 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r103.length == 2) goto L22;
        return 0;
    L22:
        return r103[1].length();
    L25:
        return 0;
    }

    public static boolean k(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        return r100.endsWith(GXTemplateKey.GAIAX_PE);
    }

    public static String l(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        if (r100.endsWith(".0") == true) goto L7;
        return r100;
    L7:
        return r100.substring(0, r100.length() - 2);
    }

    public static int m(String r100) {
        return Color.parseColor(r100);
    L4:
        tt5.a.d("ProgressColorUtils", "parse color error:" + r100);
        return ColorProtector.parseColor("#3370FF");
    }

    public static int a(double r100, String[] r101) {
        if (r101 == null) goto L19;
    L16:
        e = move-exception;
        tt5.a.d("ProgressColorUtils", "calDefaultColor exception:" + e.getMessage());
        goto L19
    L4:
        if (r101.length != 1) goto L8;
        return Color.parseColor(r101[0]);
    L8:
        if (BigDecimal.valueOf(r100).compareTo(BigDecimal.valueOf(100)) >= 0) goto L10;
        int r102 = (int) (r100 / (100.0d / ((double) r101.length)));     // Catch: Exception -> L16
        if (r102 <= (r101.length - 1)) goto L15;
        r102 = r102 - 1;     // Catch: Exception -> L16
    L15:
        return Color.parseColor(r101[r102]);
    L10:
        return Color.parseColor(r101[r101.length - 1]);
    L19:
        return ColorProtector.parseColor("#3370FF");
    }

    public static int b(double r100, String[] r110) {
        int r101 = 0;
        if (r110.length != 1) goto L7;
        return Color.parseColor(r110[0]);
    L7:
        if (r110.length <= 1) goto L27;
        BigDecimal r102 = BigDecimal.valueOf(r100);     // Catch: Exception -> L24
        if (r102.compareTo(BigDecimal.ZERO) > 0) goto L13;
        return Color.parseColor(r110[0]);
    L13:
        if (r102.compareTo(BigDecimal.valueOf(100)) >= 0) goto L15;
        double r103 = 100.0d / ((double) (r110.length - 1));     // Catch: Exception -> L24
        int r104 = (int) (r100 / r103);     // Catch: Exception -> L24
        if (r104 < (r110.length - 1)) goto L21;
        r104 = r104 - 1;     // Catch: Exception -> L24
        if (r104 >= 0) goto L21;
    L22:
        double r105 = (r100 - (((double) r101) * r103)) / r103;     // Catch: Exception -> L24
        String r106 = r110[r101];     // Catch: Exception -> L24
        String r111 = r110[r101 + 1];     // Catch: Exception -> L24
        int r107 = Color.parseColor(r106);     // Catch: Exception -> L24
        int r112 = Color.parseColor(r111);     // Catch: Exception -> L24
        int r108 = Color.red(r107);     // Catch: Exception -> L24
        int r109 = Color.green(r107);     // Catch: Exception -> L24
        int r113 = Color.blue(r107);     // Catch: Exception -> L24
        return Color.rgb((int) (((double) r108) + (((double) (Color.red(r112) - r108)) * r105)), (int) (((double) r109) + (((double) (Color.green(r112) - r109)) * r105)), (int) (((double) r113) + (((double) (Color.blue(r112) - r113)) * r105)));
    L21:
        r101 = r104;
        goto L22
    L15:
        return Color.parseColor(r110[r110.length - 1]);
    L27:
        return ColorProtector.parseColor("#3370FF");
    L24:
        e = move-exception;
        tt5.a.d("ProgressColorUtils", "calGradientColor exception:" + e.getMessage());
        goto L27
    }

    public static int c(double r100, FieldConfigMetaModel.CommonColor r101) {
        if (r101 == null) goto L23;
        String r102 = r101.getType();
        if (TextUtils.isEmpty(r102) == true) goto L7;
        FieldConfigMetaModel.ProgressColorType r103 = FieldConfigMetaModel.ProgressColorType.valueOf(r102.toUpperCase());     // Catch: Exception -> L20
        int r104 = a.f568714a[r103.ordinal()];     // Catch: Exception -> L20
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L17;
        if (r104 == 3) goto L17;
        tt5.a.d("ProgressColorUtils", "calColor error type:" + r103);     // Catch: Exception -> L20
        return Color.parseColor("#3370FF");
    L17:
        return a(r100, r101.getColor());
    L19:
        return b(r100, r101.getColor());
    L21:
        return ColorProtector.parseColor("#3370FF");
    L7:
        return ColorProtector.parseColor("#3370FF");
    L23:
        return ColorProtector.parseColor("#3370FF");
    }

    public static String e(String r100, double r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        boolean r102 = k(r100);
        BigDecimal r103 = BigDecimal.valueOf(r101).setScale(h(r100), 4);
        if (r102 == false) goto L11;
        return r103.toPlainString() + GXTemplateKey.GAIAX_PE;
    L11:
        return r103.toPlainString();
    L5:
        return String.valueOf(r101);
    }

    public static String f(double r100, String r110) {
        if (TextUtils.isEmpty(r110) == true) goto L5;
        DecimalFormat r101 = new DecimalFormat();
        int r102 = 0;
        r101.setGroupingUsed(false);
        String r103 = "";
        if (k(r110) == false) goto L9;
        r110 = r110.substring(0, r110.length() - 1);
        String r104 = GXTemplateKey.GAIAX_PE;
    L10:
        Iterator r105 = ((HashMap) f568713a).values().iterator();
    L12:
        if (r105.hasNext() == false) goto L23;
        String r106 = (String) r105.next();
        if (r110.startsWith(r106) == true) goto L15;
        if (r106.length() <= 1) goto L12;
        if (r110.startsWith("\"" + r106 + "\"") == false) goto L12;
        r110 = r110.substring(r106.length() + 2);
    L16:
        r103 = r106;
        goto L23
    L15:
        r110 = r110.substring(r106.length());
    L23:
        if (r110.startsWith("#,##") == false) goto L26;
        r101.setGroupingUsed(true);
        r110 = r110.substring(4);
    L26:
        if (PatternProtector.compile("^(0|0\\.0+)$").matcher(r110).matches() == true) goto L30;
        return String.valueOf(r100);
    L30:
        if (r110.startsWith("0.") == false) goto L32;
        r102 = r110.length() - 2;
    L32:
        r101.setMaximumFractionDigits(r102);
        r101.setMinimumFractionDigits(r102);
        return r103 + r101.format(r100) + r104;
    L9:
        r104 = "";
        goto L10
    L5:
        return String.valueOf(r100);
    }

    public static void i(String[] r110, GradientOffsetView r111) {
        if (r110 == null) goto L27;
        if (r111 == null) goto L27;
        int r100 = r110.length * 2;
        int[] r101 = new int[r100];
        int r102 = r110.length * 2;
        float[] r103 = new float[r102];
        float r104 = (float) (1.0d / ((double) r110.length));
        int r105 = r110.length;
        boolean r106 = false;
        int r107 = 0;
        int r108 = 0;
    L6:
        if (r107 >= r105) goto L12;
        String r109 = r110[r107];
        r101[r108] = m(r109);
        int r112 = r108 + 1;
        r101[r112] = m(r109);
        if (r108 <= 0) goto L10;
        r103[r108] = r103[r108 - 1];
    L11:
        r103[r112] = r103[r108] + r104;
        r108 = r108 + 2;
        r107 = r107 + 1;
        goto L6
    L10:
        r103[r108] = r108 * r104;
        goto L11
    L12:
        if (r100 <= 0) goto L32;
        if (r102 <= 0) goto L33;
        r111.f211721b = r101;
        r111.f211722c = r103;
        if (r111.f211723d != (-1)) goto L17;
    L23:
        if (r106 == false) goto L25;
        r111.a();
        return;
    L25:
        r111.f211727h = true;
        return;
    L17:
        if (r111.f211724e == (-1)) goto L23;
        if (r111.f211725f == (-1)) goto L23;
        if (r111.f211726g == (-1)) goto L23;
        r106 = true;
        goto L23
    L33:
        return;
    L32:
        return;
    L27:
        tt5.a.d("ProgressColorUtils", "handleDefaultCirclePreview error: colors or view empty");
    }

    public static void j(String[] r100, View r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L10;
        GradientDrawable r102 = new GradientDrawable();
        int[] r103 = new int[r100.length];
        int r104 = r100.length;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r103[r106] = m(r100[r105]);
        r105 = r105 + 1;
        r106 = r106 + 1;
        goto L6
    L8:
        r102.setColors(r103);
        r102.setGradientType(0);
        r102.setShape(1);
        r102.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        r101.setBackground(r102);
        return;
    L10:
        tt5.a.d("ProgressColorUtils", "handleGradientColorCirclePreview error: colors or view empty");
    }

    public static String g(double r100, Integer r101, Locale r102) {
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        BigDecimal r104 = BigDecimal.valueOf(r100).setScale(r103, 4);
        if (r102 != null) goto L9;
        r102 = Locale.getDefault();
    L9:
        NumberFormat r105 = NumberFormat.getNumberInstance(r102);
        r105.setGroupingUsed(false);
        r105.setMaximumFractionDigits(r103);
        r105.setMinimumFractionDigits(r103);
        return r105.format(r104);
    L5:
        r103 = r101.intValue();
        goto L6
    }

    public static String d(Integer r100, Integer r101, Double r102, Locale r103) {
        if (r102 == null) goto L10;
        String r104 = g(r102.doubleValue(), r101, r103);
        if (FieldConfigMetaModel.NumberFormatType.PERCENT.getValue() != r100.intValue()) goto L8;
        return r104 + GXTemplateKey.GAIAX_PE;
    L8:
        if (FieldConfigMetaModel.NumberFormatType.NUMBER.getValue() != r100.intValue()) goto L12;
        return r104;
    L12:
        return "";
    L10:
        return "";
    }
}
