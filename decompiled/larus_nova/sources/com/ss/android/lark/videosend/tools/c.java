package com.ss.android.lark.videosend.tools;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.vesdk.VEListener;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements VEListener.VEApplogListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f445004a = null;

    static {
        f445004a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.vesdk.VEListener.VEApplogListener
    public final void onInternalEventV3(String r100, JSONObject r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r104, "productType");
        AtomicBoolean r105 = f.f445008a;
        Log.i("VeSDKTools", "event: " + r100 + ", params: " + r101 + ", secondAppId: " + r102 + ", secondAppName: " + r103 + ", productType: " + r104 + ", ");
        Statistics.sendEvent(r100, r101);
    }
}
