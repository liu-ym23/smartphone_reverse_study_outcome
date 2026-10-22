package com.bytedance.android.shopping.buynow.data.remote;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/remote/BuyNowAppInfos;", "", "", "appName", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "", "bType", "I", "getBType", "()I", "aid", "getAid", "Companion", "a", "NewsLite", "NewsArticle", "VideoArticle", "LiveStream", "Aweme", "Automobile", "Wechat", "Flash", "Super", "Merchant", "AwemeLite", "Pangle", "Changting", "ZhuXiaoBang", "Unknown", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowAppInfos extends Enum<BuyNowAppInfos> {
    public static final BuyNowAppInfos Automobile = null;
    public static final BuyNowAppInfos Aweme = null;
    public static final BuyNowAppInfos AwemeLite = null;
    public static final BuyNowAppInfos Changting = null;
    public static final a Companion = null;
    public static final BuyNowAppInfos Flash = null;
    public static final BuyNowAppInfos LiveStream = null;
    public static final BuyNowAppInfos Merchant = null;
    public static final BuyNowAppInfos NewsArticle = null;
    public static final BuyNowAppInfos NewsLite = null;
    public static final BuyNowAppInfos Pangle = null;
    public static final BuyNowAppInfos Super = null;
    public static final BuyNowAppInfos Unknown = null;
    public static final BuyNowAppInfos VideoArticle = null;
    public static final BuyNowAppInfos Wechat = null;
    public static final BuyNowAppInfos ZhuXiaoBang = null;
    public static final /* synthetic */ BuyNowAppInfos[] a = null;
    private final int aid;
    private final String appName;
    private final int bType;

    public static final class a {
        public a() {
        }
    }

    public static BuyNowAppInfos valueOf(String r1) {
        return (BuyNowAppInfos) r27.a.a(BuyNowAppInfos.class, r1);
    }

    public static BuyNowAppInfos[] values() {
        return (BuyNowAppInfos[]) a.clone();
    }

    static {
        BuyNowAppInfos r7 = new BuyNowAppInfos("NewsLite", 0, "NewsLite", 7, 35);
        NewsLite = r7;
        BuyNowAppInfos r1 = new BuyNowAppInfos("NewsArticle", 1, "NewsArticle", 3, 13);
        NewsArticle = r1;
        BuyNowAppInfos r2 = new BuyNowAppInfos("VideoArticle", 2, "VideoArticle", 4, 32);
        VideoArticle = r2;
        BuyNowAppInfos r3 = new BuyNowAppInfos("LiveStream", 3, "LiveStream", 1, 1112);
        LiveStream = r3;
        BuyNowAppInfos r4 = new BuyNowAppInfos("Aweme", 4, "Aweme", 2, 1128);
        Aweme = r4;
        BuyNowAppInfos r5 = new BuyNowAppInfos("Automobile", 5, "automobile", 8, 36);
        Automobile = r5;
        BuyNowAppInfos r6 = new BuyNowAppInfos("Wechat", 6, "wechat", 5, 0);
        Wechat = r6;
        BuyNowAppInfos r8 = new BuyNowAppInfos("Flash", 7, "flash", 6, 0);
        Flash = r8;
        BuyNowAppInfos r9 = new BuyNowAppInfos("Super", 8, "super", 9, 1319);
        Super = r9;
        BuyNowAppInfos r10 = new BuyNowAppInfos("Merchant", 9, "merchant", 0, 3102);
        Merchant = r10;
        BuyNowAppInfos r11 = new BuyNowAppInfos("AwemeLite", 10, "aweme_lite", 11, 2329);
        AwemeLite = r11;
        BuyNowAppInfos r12 = new BuyNowAppInfos("Pangle", 11, "pangle", 29, 1371);
        Pangle = r12;
        BuyNowAppInfos r13 = new BuyNowAppInfos("Changting", 12, "changting", 29, 3040);
        Changting = r13;
        BuyNowAppInfos r14 = new BuyNowAppInfos("ZhuXiaoBang", 13, "zhuxiaobang", 29, 1398);
        ZhuXiaoBang = r14;
        BuyNowAppInfos r15 = new BuyNowAppInfos("Unknown", 14, "UNKNOWN", 0, 0);
        Unknown = r15;
        a = new BuyNowAppInfos[]{r7, r1, r2, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15};
        Companion = new a();
    }

    public final int getAid() {
        return this.aid;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getBType() {
        return this.bType;
    }

    public BuyNowAppInfos(String r1, int r2, String r3, int r4, int r5) {
        super(r1, r2);
        this.appName = r3;
        this.bType = r4;
        this.aid = r5;
    }
}
