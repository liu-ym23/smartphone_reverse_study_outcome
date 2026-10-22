package com.bytedance.ies.xbridge.base.runtime.depend;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend;", "", "", "containerId", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend$a;", "listener", "", "registerMemoryWaringListener", "unRegisterMemoryWaringListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostMemoryWaringDepend {

    public interface a {
    }

    void registerMemoryWaringListener(String r100, a r101);

    void unRegisterMemoryWaringListener(String r100);
}
