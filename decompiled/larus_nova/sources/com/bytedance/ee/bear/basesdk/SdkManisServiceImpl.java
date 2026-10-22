package com.bytedance.ee.bear.basesdk;

import android.content.Context;
import com.bytedance.ee.bear.basesdk.apisupport.ISdkClaymoreService;
import com.bytedance.ee.bear.basesdk.apisupport.ISdkManisService;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@RemoteServiceImpl(service = ISdkManisService.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/SdkManisServiceImpl;", "Lcom/bytedance/ee/bear/basesdk/apisupport/ISdkManisService;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "checkAndInit", "", "Companion", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkManisServiceImpl implements ISdkManisService {
    public static final a Companion = null;
    private static final String TAG = "SdkManisServiceImpl";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.ISdkManisService
    public void checkAndInit() {
        ((ISdkClaymoreService) ApiUtils.getApi(ISdkClaymoreService.class)).checkAndInit();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        tt5.a.e(TAG, "call checkAndInit error!", th, false);
    }

    public SdkManisServiceImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
