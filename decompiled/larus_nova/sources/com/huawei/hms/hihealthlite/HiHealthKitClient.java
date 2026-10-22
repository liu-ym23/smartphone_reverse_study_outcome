package com.huawei.hms.hihealthlite;

import android.content.Context;
import com.huawei.hms.healthlite.aabg;

/* JADX INFO: loaded from: classes23.dex */
public class HiHealthKitClient {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private Context f277489aab;

    public static class aab {

        /* JADX INFO: renamed from: aab, reason: collision with root package name */
        public static final HiHealthKitClient f277490aab = null;

        static {
            f277490aab = new HiHealthKitClient();
        }
    }

    public HiHealthKitClient() {
        this.f277489aab = null;
    }

    public static HiHealthKitClient getInstance() {
        return aab.f277490aab;
    }

    public Context getContext() {
        return this.f277489aab;
    }

    public void setContext(Context r100) {
        aabg.aaba("HiHealthKitClient", "entry setContext,sdkVersion=6.15.0.300");
        this.f277489aab = r100.getApplicationContext();
    }
}
