package com.bytedance.dora.annotation;

import android.text.TextUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ProductNameType extends Enum<ProductNameType> {
    public static final ProductNameType DORA_E = null;
    public static final ProductNameType DORA_G = null;
    public static final ProductNameType DORA_G2 = null;
    public static final ProductNameType DORA_G_AIR = null;
    public static final ProductNameType DORA_G_PIN = null;
    public static final ProductNameType DORA_LITE = null;
    public static final ProductNameType DORA_LORY_B = null;
    public static final ProductNameType H_DOLPHIN = null;
    public static final ProductNameType H_FREE_BUDS_PRO_5 = null;
    public static final ProductNameType H_FREE_CLIP_2 = null;
    public static final ProductNameType H_FREE_CLIP_2_HE = null;
    public static final ProductNameType H_GUITAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, String> f204371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, String> f204372b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Integer> f204373c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ ProductNameType[] f204374d = null;
    public final int deviceType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f204375id;
    public final String name;
    public final int vendorID;

    public static boolean isDoraGSeriesType(int r100) {
        if (r100 != 16) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 17) goto L12;
        if (r100 == 18) goto L12;
        if (r100 == 19) goto L12;
        return false;
    }

    static {
        ProductNameType r100 = new ProductNameType("DORA_LITE", 0, 1, 1, 0, DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME);
        DORA_LITE = r100;
        ProductNameType r101 = new ProductNameType("DORA_E", 1, 1, 2, 2, "DoraE");
        DORA_E = r101;
        ProductNameType r102 = new ProductNameType("DORA_G", 2, 1, 16, 16, "DoraG");
        DORA_G = r102;
        ProductNameType r103 = new ProductNameType("DORA_G2", 3, 1, 17, 17, "DoraG2");
        DORA_G2 = r103;
        ProductNameType r104 = new ProductNameType("DORA_G_AIR", 4, 1, 18, 18, "DoraGAir");
        DORA_G_AIR = r104;
        ProductNameType r105 = new ProductNameType("DORA_G_PIN", 5, 1, 19, 19, "DoraGPin");
        DORA_G_PIN = r105;
        ProductNameType r106 = new ProductNameType("DORA_LORY_B", 6, 1, 32, 32, "LoryB");
        DORA_LORY_B = r106;
        ProductNameType r107 = new ProductNameType("H_FREE_CLIP_2", 7, 4096, 1048578, 3, "HUAWEI FreeClip 2");
        H_FREE_CLIP_2 = r107;
        ProductNameType r108 = new ProductNameType("H_FREE_BUDS_PRO_5", 8, 4096, 50, 50, "HUAWEI FreeBuds Pro 5");
        H_FREE_BUDS_PRO_5 = r108;
        ProductNameType r110 = new ProductNameType("H_FREE_CLIP_2_HE", 9, 4096, 51, 51, "HUAWEI FreeClip 2 HE");
        H_FREE_CLIP_2_HE = r110;
        ProductNameType r109 = new ProductNameType("H_GUITAR", 10, 4096, 52, 52, "HUAWEI FreeBuds 7");
        H_GUITAR = r109;
        ProductNameType r111 = new ProductNameType("H_DOLPHIN", 11, 4096, 53, 53, "HUAWEI FreeBuds Neo");
        H_DOLPHIN = r111;
        f204374d = new ProductNameType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r109, r111};
        HashMap<Integer, String> r112 = new HashMap();
        f204371a = r112;
        r112.put(0, "VWkAjHuAlm");
        r112.put(Integer.valueOf(r100.f204375id), "VWkAjHuAlm");
        r112.put(Integer.valueOf(r101.f204375id), "HqxgWPsgLv");
        r112.put(Integer.valueOf(r102.f204375id), "Wd4coUDTJ8zmVZ0T");
        r112.put(Integer.valueOf(r103.f204375id), "8WXv2rMtrmQ6QeJd");
        r112.put(Integer.valueOf(r106.f204375id), "SxVgMUdnw1fWGArs");
        r112.put(Integer.valueOf(r107.f204375id), "MGdLITXH7b6Y2Yx5");
        r112.put(Integer.valueOf(r108.f204375id), "MGdLITXH7b6Y2Yx5");
        r112.put(Integer.valueOf(r110.f204375id), "MGdLITXH7b6Y2Yx5");
        r112.put(Integer.valueOf(r109.f204375id), "MGdLITXH7b6Y2Yx5");
        r112.put(Integer.valueOf(r111.f204375id), "MGdLITXH7b6Y2Yx5");
        HashMap<String, Integer> r113 = new HashMap();
        f204373c = r113;
        r113.put("000167", Integer.valueOf(r107.f204375id));
        r113.put("BTFT0027-000167", Integer.valueOf(r107.f204375id));
        r113.put("00016B", Integer.valueOf(r108.f204375id));
        r113.put("00016D", Integer.valueOf(r108.f204375id));
        r113.put("000173", Integer.valueOf(r110.f204375id));
        r113.put("000174", Integer.valueOf(r109.f204375id));
        r113.put("000175", Integer.valueOf(r111.f204375id));
        HashMap<String, String> r114 = new HashMap();
        f204372b = r114;
        r114.put("000167", "HUAWEI FreeClip 2");
        r114.put("BTFT0027-000167", "HUAWEI FreeClip 2");
        r114.put("00016B", "HUAWEI FreeBuds Pro 5");
        r114.put("00016D", "HUAWEI FreeBuds Pro 5");
        r114.put("000173", "HUAWEI FreeClip 2 HE");
        r114.put("000174", "HUAWEI FreeBuds 7");
        r114.put("000175", "HUAWEI FreeBuds Neo");
    }

    public static ProductNameType[] values() {
        return (ProductNameType[]) f204374d.clone();
    }

    public String getAppKey() {
        return getAppKey(this.f204375id);
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getId() {
        return this.f204375id;
    }

    public String getName() {
        return this.name;
    }

    public static ProductNameType fromDeviceType(int r100) {
        if (r100 != 0) goto L6;
        return DORA_LITE;
    L6:
        if (2 != r100) goto L10;
        return DORA_E;
    L10:
        if (16 != r100) goto L14;
        return DORA_G;
    L14:
        if (17 != r100) goto L18;
        return DORA_G2;
    L18:
        if (18 != r100) goto L22;
        return DORA_G_AIR;
    L22:
        if (19 != r100) goto L26;
        return DORA_G_PIN;
    L26:
        if (32 != r100) goto L30;
        return DORA_LORY_B;
    L30:
        return DORA_LITE;
    }

    public static ProductNameType fromProductId(int r100) {
        ProductNameType r101 = DORA_LITE;
        if (r100 != r101.getId()) goto L5;
        return r101;
    L5:
        ProductNameType r102 = DORA_E;
        if (r100 != r102.getId()) goto L8;
        return r102;
    L8:
        ProductNameType r103 = DORA_G;
        if (r100 != r103.getId()) goto L11;
        return r103;
    L11:
        ProductNameType r104 = DORA_G2;
        if (r100 != r104.getId()) goto L14;
        return r104;
    L14:
        ProductNameType r105 = DORA_G_AIR;
        if (r100 != r105.getId()) goto L17;
        return r105;
    L17:
        ProductNameType r106 = DORA_G_PIN;
        if (r100 != r106.getId()) goto L20;
        return r106;
    L20:
        ProductNameType r107 = DORA_LORY_B;
        if (r100 != r107.getId()) goto L23;
        return r107;
    L23:
        return r101;
    }

    public static String getAppKey(int r100) {
        String r101 = f204371a.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static String getDeviceName(String r100) {
        return f204372b.get(r100);
    }

    public static int getDeviceTypeByProductId(int r100) {
        ProductNameType r101 = fromProductId(r100);
        if (r101 != null) goto L6;
        return -1;
    L6:
        return r101.getDeviceType();
    }

    public static int getLegacyRouteDeviceType(int r100) {
        if (isDoraGSeriesType(r100) == false) goto L6;
        return 16;
    L6:
        return r100;
    }

    public static ProductNameType getProduct(int r100) {
        ProductNameType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ProductNameType r104 = r101[r103];
        if (r104.f204375id == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        if (r100 == 0) goto L10;
        return null;
    L10:
        return DORA_LITE;
    }

    public static int getProductIDByModelID(String r100) {
        Integer r101 = f204373c.get(r100);
        if (r101 != null) goto L6;
        return -1;
    L6:
        return r101.intValue();
    }

    public static List<ProductNameType> getProducts(int r100) {
        ArrayList r101 = new ArrayList();
        ProductNameType[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        ProductNameType r105 = r102[r104];
        if (r105.vendorID != r100) goto L7;
        r101.add(r105);
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r101;
    }

    public static boolean isDoraGSeriesProduct(int r100) {
        if (r100 != DORA_G.getId()) goto L5;
    L12:
        return true;
    L5:
        if (r100 == DORA_G2.getId()) goto L12;
        if (r100 == DORA_G_AIR.getId()) goto L12;
        if (r100 == DORA_G_PIN.getId()) goto L12;
        return false;
    }

    public static ProductNameType valueOf(String r100) {
        return (ProductNameType) a.a(ProductNameType.class, r100);
    }

    public static ProductNameType getProduct(int r100, int r101) {
        ProductNameType[] r102 = values();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        ProductNameType r105 = r102[r104];
        if (r105.vendorID != r100) goto L9;
        if (r105.f204375id != r101) goto L9;
        return r105;
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        if (r101 != 0) goto L14;
        if (r100 == 0) goto L13;
        return null;
    L13:
        return DORA_LITE;
    L14:
        return null;
    }

    public static boolean setAppKey(int r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        f204371a.put(Integer.valueOf(r100), r101);
        return true;
    }

    public static boolean setDeviceName(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        f204372b.put(r100, r101);
        return true;
    L11:
        return false;
    }

    public static boolean setProductID(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        f204373c.put(r100, Integer.valueOf(r101));
        return true;
    }

    public ProductNameType(String r100, int r101, int r102, int r103, int r104, String r105) {
        super(r100, r101);
        this.vendorID = r102;
        this.f204375id = r103;
        this.name = r105;
        this.deviceType = r104;
    }
}
