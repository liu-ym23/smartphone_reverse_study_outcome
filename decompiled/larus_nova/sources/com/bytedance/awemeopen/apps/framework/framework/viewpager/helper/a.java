package com.bytedance.awemeopen.apps.framework.framework.viewpager.helper;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.i;
import com.bytedance.awemeopen.bizmodels.user.j;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f197064a;

    @Override // com.bytedance.awemeopen.bizmodels.user.j
    public final void onFail(Exception r100) {
    }

    public a(Activity r100) {
        this.f197064a = r100;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.j
    public final void a(i r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Lazy r101 = AosEnterDyPlayerToastHelper.f197063a;
        Activity r102 = this.f197064a;
        String r103 = r100.f198231a;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        AosEnterDyPlayerToastHelper.a(r102, r103);
    }
}
