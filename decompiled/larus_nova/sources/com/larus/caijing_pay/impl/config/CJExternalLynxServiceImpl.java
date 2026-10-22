package com.larus.caijing_pay.impl.config;

import android.content.Context;
import android.net.Uri;
import com.android.ttcjpaysdk.base.adapter.ICJExternalLynxCardAdapter;
import com.android.ttcjpaysdk.base.service.ICJExternalLynxCardCallback;
import com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalLynxService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJExternalLynxServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/container/old_container/CJExternalLynxService;", "<init>", "()V", "createHybridCard", "Lcom/android/ttcjpaysdk/base/adapter/ICJExternalLynxCardAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJExternalLynxCardCallback;", "isForceUseAnnieXCard", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJExternalLynxServiceImpl implements CJExternalLynxService {
    public CJExternalLynxServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalLynxService
    public ICJExternalLynxCardAdapter createHybridCard(Context r100, Uri r101, ICJExternalLynxCardCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return null;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.container.old_container.CJExternalLynxService
    public boolean isForceUseAnnieXCard() {
        return true;
    }
}
