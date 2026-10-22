package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fJ3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0017J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¨\u0006 "}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend;", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "bridgeContext", "", "cameraOnly", "autoJump", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$c;", "scanResultCallback", "", "scanCode", "(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;ZLjava/lang/Boolean;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$c;)V", "", "accessKey", "channel", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$d;", "updateGeckoCallback", "enableDownloadAutoRetry", "updateGecko", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$d;Z)Lkotlin/Unit;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$b;", "getGeckoInfoCallback", "getGeckoInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$b;)Lkotlin/Unit;", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend$a;", "listener", "registerGeckoUpdateListener", "unRegisterGeckoUpdateListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostOpenDepend {

    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "this interface is no more use", imports = {}))
    public interface a {
    }

    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "this interface is no more use", imports = {}))
    public interface b {
    }

    public interface c {
    }

    @Deprecated(message = "no more use", replaceWith = @ReplaceWith(expression = "this interface is no more use", imports = {}))
    public interface d {
    }

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    Unit getGeckoInfo(String r100, String r101, b r102);

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    void registerGeckoUpdateListener(IBDXBridgeContext r100, a r101);

    void scanCode(IBDXBridgeContext r100, boolean r101, Boolean r102, c r103);

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    void unRegisterGeckoUpdateListener(IBDXBridgeContext r100);

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    Unit updateGecko(String r100, String r101, d r102, boolean r103);
}
