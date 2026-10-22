package com.ss.android.lark.framework.assembly.rust.bridge;

import android.app.Application;
import com.bytedance.lark.office_sdk_im_android.OfficeSdkHostSetting;
import com.ss.android.lark.log.Log;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements OfficeSdkHostSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f425691a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkHostSetting
    public final boolean getIsLegacyPcSidePanelImFeatureOpened() {
        return false;
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkHostSetting
    public final boolean getIsImFeatureOpenedByHostManual() {
        Boolean r100 = null;
        qtb.b r101 = (qtb.b) k.a(this.f425691a, qtb.b.class);     // Catch: Throwable -> L5
    L7:
        if (r101 == null) goto L9;
        r100 = Boolean.valueOf(r101.getIsImFeatureOpenedByHostManual());
    L9:
        Log.i("OfficeSdkHostSettingProviderImpl", "getIsImFeatureOpenedByHostManual result: " + r100);
        if (r100 != null) goto L16;
        return false;
    L16:
        return r100.booleanValue();
    L5:
        th = move-exception;
        Log.e("OfficeSdkHostSettingProviderImpl", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        r101 = null;
        goto L7
    }

    public b(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f425691a = r100;
    }
}
