package com.ss.videoarch.strategy.strategy.networkStrategy;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class LSPreconnTask implements Runnable {
    static final String TAG = "LiveStrategyManager";
    private String mDomain;
    private LSPreconnTaskHandler mHandler;
    private String mHost;
    private boolean mIsQuic;
    private String mPath;
    private int mPort;

    public interface LSPreconnTaskHandler {
        void callback(String r100, String r101, int r102);
    }

    private native int nativeConnect(String r100, String r101, int r102, String r103, boolean r104);

    @Override // java.lang.Runnable
    public void run() {
        com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnTask__run$___twin___() {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return;
    L5:
        int r100 = nativeConnect(this.mDomain, this.mHost, this.mPort, this.mPath, this.mIsQuic);
        LSPreconnTaskHandler r101 = this.mHandler;
        if (r101 == null) goto L9;
        r101.callback(this.mDomain, this.mHost, r100);
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnTask_com_larus_apm_impl_protector_RunnableLancet_run(LSPreconnTask r100) {
        r100.com_ss_videoarch_strategy_strategy_networkStrategy_LSPreconnTask__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public LSPreconnTask(LSPreconnTaskHandler r100, String r101, String r102, int r103, String r104, boolean r105) {
        this.mDomain = r101;
        this.mHost = r102;
        this.mPath = r104;
        this.mPort = r103;
        this.mIsQuic = r105;
        this.mHandler = r100;
    }
}
