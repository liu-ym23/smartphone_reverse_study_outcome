package g0;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479450b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479451c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479452d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479453e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479454f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<DecodeHintType, Object> f479455g = null;

    static {
        EnumMap r100 = new EnumMap(DecodeHintType.class);
        f479449a = r100;
        ArrayList r101 = new ArrayList();
        BarcodeFormat r102 = BarcodeFormat.AZTEC;
        r101.add(r102);
        BarcodeFormat r103 = BarcodeFormat.CODABAR;
        r101.add(r103);
        BarcodeFormat r104 = BarcodeFormat.CODE_39;
        r101.add(r104);
        BarcodeFormat r105 = BarcodeFormat.CODE_93;
        r101.add(r105);
        BarcodeFormat r106 = BarcodeFormat.CODE_128;
        r101.add(r106);
        BarcodeFormat r107 = BarcodeFormat.DATA_MATRIX;
        r101.add(r107);
        BarcodeFormat r108 = BarcodeFormat.EAN_8;
        r101.add(r108);
        BarcodeFormat r109 = BarcodeFormat.EAN_13;
        r101.add(r109);
        BarcodeFormat r110 = BarcodeFormat.ITF;
        r101.add(r110);
        BarcodeFormat r111 = BarcodeFormat.MAXICODE;
        r101.add(r111);
        BarcodeFormat r112 = BarcodeFormat.PDF_417;
        r101.add(r112);
        BarcodeFormat r113 = BarcodeFormat.QR_CODE;
        r101.add(r113);
        BarcodeFormat r114 = BarcodeFormat.RSS_14;
        r101.add(r114);
        BarcodeFormat r115 = BarcodeFormat.RSS_EXPANDED;
        r101.add(r115);
        BarcodeFormat r116 = BarcodeFormat.UPC_A;
        r101.add(r116);
        BarcodeFormat r117 = BarcodeFormat.UPC_E;
        r101.add(r117);
        BarcodeFormat r118 = BarcodeFormat.UPC_EAN_EXTENSION;
        r101.add(r118);
        DecodeHintType r119 = DecodeHintType.POSSIBLE_FORMATS;
        r100.put(r119, r101);
        DecodeHintType r120 = DecodeHintType.TRY_HARDER;
        Boolean r121 = Boolean.TRUE;
        r100.put(r120, r121);
        DecodeHintType r122 = DecodeHintType.CHARACTER_SET;
        r100.put(r122, XML.CHARSET_UTF8);
        EnumMap r123 = new EnumMap(DecodeHintType.class);
        f479450b = r123;
        ArrayList r124 = new ArrayList();
        r124.add(r103);
        r124.add(r104);
        r124.add(r105);
        r124.add(r106);
        r124.add(r108);
        r124.add(r109);
        r124.add(r110);
        r124.add(r112);
        r124.add(r114);
        r124.add(r115);
        r124.add(r116);
        r124.add(r117);
        r124.add(r118);
        r123.put(r119, r124);
        r123.put(r120, r121);
        r123.put(r122, XML.CHARSET_UTF8);
        EnumMap r125 = new EnumMap(DecodeHintType.class);
        f479451c = r125;
        ArrayList r126 = new ArrayList();
        r126.add(r102);
        r126.add(r107);
        r126.add(r111);
        r126.add(r113);
        r125.put(r119, r126);
        r125.put(r120, r121);
        r125.put(r122, XML.CHARSET_UTF8);
        EnumMap r127 = new EnumMap(DecodeHintType.class);
        f479452d = r127;
        r127.put(r119, Collections.singletonList(r113));
        r127.put(r120, r121);
        r127.put(r122, XML.CHARSET_UTF8);
        EnumMap r128 = new EnumMap(DecodeHintType.class);
        f479453e = r128;
        r128.put(r119, Collections.singletonList(r106));
        r128.put(r120, r121);
        r128.put(r122, XML.CHARSET_UTF8);
        EnumMap r129 = new EnumMap(DecodeHintType.class);
        f479454f = r129;
        r129.put(r119, Collections.singletonList(r109));
        r129.put(r120, r121);
        r129.put(r122, XML.CHARSET_UTF8);
        EnumMap r130 = new EnumMap(DecodeHintType.class);
        f479455g = r130;
        ArrayList r131 = new ArrayList();
        r131.add(r113);
        r131.add(r116);
        r131.add(r109);
        r131.add(r106);
        r130.put(r119, r131);
        r130.put(r120, r121);
        r130.put(r122, XML.CHARSET_UTF8);
    }
}
