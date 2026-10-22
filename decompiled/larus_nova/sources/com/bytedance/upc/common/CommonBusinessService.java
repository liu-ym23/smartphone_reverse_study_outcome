package com.bytedance.upc.common;

import android.app.Application;
import android.content.Context;
import com.bytedance.upc.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/upc/common/CommonBusinessService;", "Lcom/bytedance/upc/common/ICommonBusinessService;", "Landroid/content/Context;", "getContext", "<init>", "()V", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public final class CommonBusinessService implements ICommonBusinessService {
    public CommonBusinessService() {
    }

    @Override // com.bytedance.upc.common.ICommonBusinessService
    public final a getConfiguration() {
        Application r100 = hp7.a.f486453a;
        a r101 = hp7.a.f486454b;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r101;
    }

    @Override // com.bytedance.upc.common.ICommonBusinessService
    public Context getContext() {
        return hp7.a.f486455c.getContext();
    }
}
