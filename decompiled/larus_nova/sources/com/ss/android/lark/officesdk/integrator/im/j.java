package com.ss.android.lark.officesdk.integrator.im;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.utils.ApiUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j extends com.ss.android.lark.appcontext.applifecycle.a {
    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public j() {
    }

    @Override // com.ss.android.lark.appcontext.applifecycle.a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        UrlPreviewApi r101 = (UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class);
        if (r101 == null) goto L6;
        r101.clearAllUrlCache();
        return;
    }
}
