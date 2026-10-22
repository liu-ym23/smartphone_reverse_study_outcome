package qe7;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements IHostThreadPoolExecutorDepend {
    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostThreadPoolExecutorDepend
    public final ExecutorService getNormalThreadExecutor() {
        return TTExecutors.getNormalExecutor();
    }
}
