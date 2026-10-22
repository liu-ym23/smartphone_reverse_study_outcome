package rx7;

import com.bytedance.geckox.GeckoGlobalConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f539828a = 0;

    static {
    }

    public static GeckoGlobalConfig.ENVType a() {
        int r100 = mx7.c.b().getSharedPreferences("gecko_settings", 0).getInt("gecko_env", 2);
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L11;
        return GeckoGlobalConfig.ENVType.PROD;
    L11:
        return GeckoGlobalConfig.ENVType.DEV;
    L9:
        return GeckoGlobalConfig.ENVType.BOE;
    }
}
