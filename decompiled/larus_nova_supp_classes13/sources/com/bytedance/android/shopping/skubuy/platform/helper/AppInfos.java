package com.bytedance.android.shopping.skubuy.platform.helper;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/helper/AppInfos;", "", "", "appName", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "", "bType", "I", "getBType", "()I", "aid", "getAid", "Companion", "a", "NewsLite", "NewsArticle", "VideoArticle", "LiveStream", "Aweme", "Automobile", "Wechat", "Flash", "Super", "Merchant", "AwemeLite", "Pangle", "Changting", "ZhuXiaoBang", "Unknown", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AppInfos extends Enum<AppInfos> {
    public static final AppInfos Automobile = null;
    public static final AppInfos Aweme = null;
    public static final AppInfos AwemeLite = null;
    public static final AppInfos Changting = null;
    public static final a Companion = null;
    public static final AppInfos Flash = null;
    public static final AppInfos LiveStream = null;
    public static final AppInfos Merchant = null;
    public static final AppInfos NewsArticle = null;
    public static final AppInfos NewsLite = null;
    public static final AppInfos Pangle = null;
    public static final AppInfos Super = null;
    public static final AppInfos Unknown = null;
    public static final AppInfos VideoArticle = null;
    public static final AppInfos Wechat = null;
    public static final AppInfos ZhuXiaoBang = null;
    public static final /* synthetic */ AppInfos[] a = null;
    private final int aid;
    private final String appName;
    private final int bType;

    public static AppInfos valueOf(String r1) {
        return (AppInfos) r27.a.a(AppInfos.class, r1);
    }

    public static AppInfos[] values() {
        return (AppInfos[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.shopping.skubuy.platform.helper.AppInfos$a] */
    static {
        AppInfos r7 = new AppInfos("NewsLite", 0, "NewsLite", 7, 35);
        NewsLite = r7;
        AppInfos r1 = new AppInfos("NewsArticle", 1, "NewsArticle", 3, 13);
        NewsArticle = r1;
        AppInfos r2 = new AppInfos("VideoArticle", 2, "VideoArticle", 4, 32);
        VideoArticle = r2;
        AppInfos r3 = new AppInfos("LiveStream", 3, "LiveStream", 1, 1112);
        LiveStream = r3;
        AppInfos r4 = new AppInfos("Aweme", 4, "Aweme", 2, 1128);
        Aweme = r4;
        AppInfos r5 = new AppInfos("Automobile", 5, "automobile", 8, 36);
        Automobile = r5;
        AppInfos r6 = new AppInfos("Wechat", 6, "wechat", 5, 0);
        Wechat = r6;
        AppInfos r8 = new AppInfos("Flash", 7, "flash", 6, 0);
        Flash = r8;
        AppInfos r9 = new AppInfos("Super", 8, "super", 9, 1319);
        Super = r9;
        AppInfos r10 = new AppInfos("Merchant", 9, "merchant", 0, 3102);
        Merchant = r10;
        AppInfos r11 = new AppInfos("AwemeLite", 10, "aweme_lite", 11, 2329);
        AwemeLite = r11;
        AppInfos r12 = new AppInfos("Pangle", 11, "pangle", 29, 1371);
        Pangle = r12;
        AppInfos r13 = new AppInfos("Changting", 12, "changting", 29, 3040);
        Changting = r13;
        AppInfos r14 = new AppInfos("ZhuXiaoBang", 13, "zhuxiaobang", 29, 1398);
        ZhuXiaoBang = r14;
        AppInfos r15 = new AppInfos("Unknown", 14, "UNKNOWN", 0, 0);
        Unknown = r15;
        a = new AppInfos[]{r7, r1, r2, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15};
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

    public AppInfos(String r1, int r2, String r3, int r4, int r5) {
        super(r1, r2);
        this.appName = r3;
        this.bType = r4;
        this.aid = r5;
    }
}
