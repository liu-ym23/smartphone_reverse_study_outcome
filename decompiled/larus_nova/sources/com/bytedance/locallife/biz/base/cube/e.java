package com.bytedance.locallife.biz.base.cube;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements bp6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f256535a = null;

    static {
        f256535a = new e();
    }

    public e() {
    }

    @Override // bp6.a
    public final void d() {
        i r100 = i.f256541a;
    }

    @Override // bp6.a
    public final JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        return HostServiceUtilsKt.f0().a(r100);
    }

    @Override // bp6.a
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("", "defVal");
        Object r101 = HostServiceUtilsKt.i0().i(r100);
        if ((r101 instanceof String) == false) goto L5;
        String r102 = (String) r101;
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // bp6.a
    public final Map<String, Object> c(Map<String, ? extends Object> r100) {
        return HostServiceUtilsKt.M().g();
    }
}
