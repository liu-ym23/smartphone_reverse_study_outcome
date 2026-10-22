package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e0 extends com.bytedance.ies.argus.strategy.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f245737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f245738c;

    public final String e() {
        Object r100 = ((LinkedHashMap) this.f246155a).get("seclink_scene");
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r100;
    }

    public final String f() {
        Object r100 = ((LinkedHashMap) this.f246155a).get("url");
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r100;
    }

    public e0() {
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Lazy r101 = ArgusGsonUtils.f246245a;
        return ArgusGsonUtils.a(this.f246155a);
    }

    public final void g(com.bytedance.ies.argus.bean.e r100) {
        Integer r101 = r100.f246019a;
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.intValue());
        this.f246155a.put("seclink_mode", r102);
        return;
    }
}
