package com.bytedance.awemeopen.apps.framework.framework.viewpager.helper;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.i;
import com.bytedance.awemeopen.bizmodels.user.j;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements j {
    public final /* synthetic */ Activity a;

    public final void onFail(Exception r1) {
    }

    public a(Activity r1) {
        this.a = r1;
    }

    public final void a(i r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Lazy r0 = AosEnterDyPlayerToastHelper.a;
        Activity r1 = this.a;
        String r3 = r2.a;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        AosEnterDyPlayerToastHelper.a(r1, r3);
    }
}
