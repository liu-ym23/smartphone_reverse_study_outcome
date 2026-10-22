package com.suite.lark.platform.component.cta;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final void a(Activity r100, LifecycleOwner r101, String r110, String r111, String r112, String r113, goc.a r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r110, "featureKey");
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r113, "checkpointUserId");
        b r102 = new b(r110, r111, r112, r113);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r101), null, null, new CTADialogPresenter$fetchStuckSpotAndShowDialog$1(r102, r114, r100, null), 3, null);
    }

    public static /* synthetic */ void b(Activity r100, LifecycleOwner r110, String r111, String r112, String r113, String r114, int r115) {
        if ((r115 & 16) == 0) goto L5;
        String r101 = "0";
    L7:
        if ((r115 & 32) == 0) goto L9;
        String r102 = "0";
    L10:
        a(r100, r110, r111, r112, r101, r102, null);
        return;
    L9:
        r102 = r114;
        goto L10
    L5:
        r101 = r113;
        goto L7
    }
}
