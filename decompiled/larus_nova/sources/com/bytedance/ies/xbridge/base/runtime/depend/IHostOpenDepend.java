package com.bytedance.ies.xbridge.base.runtime.depend;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J1\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend;", "", "Lg66/c;", "contextProviderFactory", "", "cameraOnly", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$c;", "scanResultCallback", "", "scanCode", "", "accessKey", "channel", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$d;", "updateGeckoCallback", "enableDownloadAutoRetry", "updateGecko", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$d;Z)Lkotlin/Unit;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$b;", "getGeckoInfoCallback", "getGeckoInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$b;)Lkotlin/Unit;", "containerId", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend$a;", "listener", "registerGeckoUpdateListener", "unRegisterGeckoUpdateListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostOpenDepend {

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    Unit getGeckoInfo(String r100, String r101, b r102);

    void registerGeckoUpdateListener(String r100, a r101);

    void scanCode(g66.c r100, boolean r101, c r102);

    void unRegisterGeckoUpdateListener(String r100);

    Unit updateGecko(String r100, String r101, d r102, boolean r103);
}
