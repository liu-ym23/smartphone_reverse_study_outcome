package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.lynx.react.bridge.PiperData;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PiperData f269990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ? extends Object> f269991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f269992c;

    public h() {
    }

    public h(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this();
        PiperData r101 = new PiperData(r100, true);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f269990a = r101;
        this.f269991b = r100;
    }

    public h(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        this();
        PiperData r101 = new PiperData(r100, true);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f269990a = r101;
        this.f269992c = r100;
    }
}
