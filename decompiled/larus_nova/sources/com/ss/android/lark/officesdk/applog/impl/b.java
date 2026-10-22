package com.ss.android.lark.officesdk.applog.impl;

import android.os.Bundle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements gtb.a {
    public b() {
    }

    @Override // gtb.a
    public final void flush() {
        gtb.a r100 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r100 == null) goto L6;
        r100.flush();
        return;
    }

    @Override // gtb.a
    public final void onEventV3(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        gtb.a r102 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r102 == null) goto L6;
        r102.onEventV3(r100, r101);
        return;
    }

    @Override // gtb.a
    public final void onMiscEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "logType");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        gtb.a r102 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r102 == null) goto L6;
        r102.onMiscEvent(r100, r101);
        return;
    }

    @Override // gtb.a
    public final void onEventV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        gtb.a r102 = (gtb.a) OfficeSDKManager.getHostGlobalService(gtb.a.class);
        if (r102 == null) goto L6;
        r102.onEventV3(r100, r101);
        return;
    }
}
