package com.bytedance.ee.bear.basesdk.apisupport;

import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@RemoteService
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/apisupport/ISdkManisService;", "Lee/android/framework/manis/interfaces/IHookInterface;", "checkAndInit", "", "basesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISdkManisService extends IHookInterface {
    void checkAndInit();
}
