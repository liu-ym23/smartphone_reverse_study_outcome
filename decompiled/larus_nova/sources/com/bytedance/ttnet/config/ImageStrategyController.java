package com.bytedance.ttnet.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.NetworkUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ImageStrategyController implements IImageStrategy {
    private static final String IMAGE_OPT_BLACK_INTERVAL = "image_opt_black_interval";
    private static final String IMAGE_OPT_FAILED_TIMES = "image_opt_failed_times";
    private static final String IMAGE_OPT_LIMIT_COUNT = "image_opt_limit_count";
    private static final String IMAGE_OPT_SWITCH = "image_opt_switch";
    private static final String IMAGE_SP_TABLE = "image_opt_table";
    private static final Object mLock = null;
    private static volatile ImageStrategyController sIns;
    private static volatile SharedPreferences sSP;
    private volatile long mBlackInterval;
    private volatile Context mContext;
    private volatile int mFailedTimes;
    private volatile int mLimitImageNumber;
    private volatile int mSwitch;

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public List<String> getUrlListForUrl(String r100) {
        return null;
    }

    static {
        mLock = new Object();
    }

    private SharedPreferences getSP() {
        if (sSP != null) goto L6;
        sSP = this.mContext.getSharedPreferences(IMAGE_SP_TABLE, 0);
    L6:
        return sSP;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public NetworkUtils.NetworkType getNetWorkType() {
        return NetworkUtils.getNetworkType(this.mContext);
    }

    private void initConfig() {
        SharedPreferences r100 = getSP();     // Catch: Throwable -> L4
        this.mSwitch = r100.getInt(IMAGE_OPT_SWITCH, 0);     // Catch: Throwable -> L4
        this.mBlackInterval = r100.getLong(IMAGE_OPT_BLACK_INTERVAL, 0);     // Catch: Throwable -> L4
        this.mFailedTimes = r100.getInt(IMAGE_OPT_FAILED_TIMES, 0);     // Catch: Throwable -> L4
        this.mLimitImageNumber = r100.getInt(IMAGE_OPT_LIMIT_COUNT, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static ImageStrategyController getInstance() {
        return sIns;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getFailedTimes() {
        return this.mFailedTimes;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public long getHostInBlackInterval() {
        return this.mBlackInterval;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getLimitImageNumbers() {
        return this.mLimitImageNumber;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getSwitch() {
        return this.mSwitch;
    }

    private ImageStrategyController(Context r100) {
        if (r100 == null) goto L5;
        this.mContext = r100.getApplicationContext();
    L5:
        initConfig();
    }

    public static ImageStrategyController Init(Context r100) {
        if (sIns != null) goto L15;
        Object r101 = mLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sIns != null) goto L9;
        sIns = new ImageStrategyController(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return sIns;
    }

    public void updateConfig(JSONObject r110) {
        if (r110 == null) goto L26;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r110.length() <= 0) goto L27;
        int r100 = r110.optInt(IMAGE_OPT_SWITCH, 0);     // Catch: Throwable -> L21
        long r101 = r110.optLong(IMAGE_OPT_BLACK_INTERVAL, 0);     // Catch: Throwable -> L21
        int r102 = r110.optInt(IMAGE_OPT_FAILED_TIMES, 0);     // Catch: Throwable -> L21
        int r111 = r110.optInt(IMAGE_OPT_LIMIT_COUNT, 0);     // Catch: Throwable -> L21
        SharedPreferences.Editor r103 = getSP().edit();     // Catch: Throwable -> L21
        if (r100 == this.mSwitch) goto L11;
        r103.putInt(IMAGE_OPT_SWITCH, r100);     // Catch: Throwable -> L21
    L11:
        if (r101 == this.mBlackInterval) goto L14;
        r103.putLong(IMAGE_OPT_BLACK_INTERVAL, r101);     // Catch: Throwable -> L21
    L14:
        if (r102 == this.mFailedTimes) goto L17;
        r103.putInt(IMAGE_OPT_FAILED_TIMES, r102);     // Catch: Throwable -> L21
    L17:
        if (r111 == this.mLimitImageNumber) goto L19;
        r103.putInt(IMAGE_OPT_LIMIT_COUNT, r111);     // Catch: Throwable -> L21
    L19:
        r103.apply();     // Catch: Throwable -> L21
        this.mSwitch = r100;     // Catch: Throwable -> L21
        this.mBlackInterval = r101;     // Catch: Throwable -> L21
        this.mFailedTimes = r102;     // Catch: Throwable -> L21
        this.mLimitImageNumber = r111;     // Catch: Throwable -> L21
        return;
    L27:
        return;
    }
}
