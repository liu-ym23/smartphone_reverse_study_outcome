package com.ss.videoarch.strategy.dataCenter.config;

import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.utils.JNINamespace;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class PlatformDataFetcher {
    static final String TAG = "PlatformDataFetcher";
    private IAppInfoBundle mAppInfoBundle;

    public static class PlatformDataFetcherInstance {
        private static final PlatformDataFetcher mInstance = null;

        private PlatformDataFetcherInstance() {
        }

        static {
            mInstance = new PlatformDataFetcher();
        }

        public static /* synthetic */ PlatformDataFetcher access$000() {
            return mInstance;
        }
    }

    public PlatformDataFetcher() {
        this.mAppInfoBundle = null;
    }

    public static PlatformDataFetcher getInstance() {
        return PlatformDataFetcherInstance.access$000();
    }

    public static void init(IAppInfoBundle r100) {
        getInstance().mAppInfoBundle = r100;
    }

    private <T> T getDolphinSettings(String r100, T r101) {
        IAppInfoBundle r102 = this.mAppInfoBundle;
        if (r102 != null) goto L5;
        return r101;
    L5:
        T r103 = (T) r102.getAppInfoForKey(r100, r101);
        Objects.toString(r103);
        return r103;
    }

    public int GetDolphinSettings_int(String r100, int r101) {
        return ((Integer) getDolphinSettings(r100, Integer.valueOf(r101))).intValue();
    }

    public String GetDolphinSettings_string(String r100, String r101) {
        return (String) getDolphinSettings(r100, r101);
    }
}
