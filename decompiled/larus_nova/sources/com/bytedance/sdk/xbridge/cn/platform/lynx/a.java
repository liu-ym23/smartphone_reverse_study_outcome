package com.bytedance.sdk.xbridge.cn.platform.lynx;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends le7.a<ReadableMap> {
    public final ReadableMap M;
    public final String N;
    public final PlatformType O;
    public final ReadableMap P;
    public final String Q;

    /* JADX INFO: renamed from: com.bytedance.sdk.xbridge.cn.platform.lynx.a$a, reason: collision with other inner class name */
    public static final class C3774a {
    }

    static {
    }

    @Override // le7.a
    public final JSONObject a() {
        ReadableMap r100 = this.P;
        JSONObject r101 = null;
        if ((r100 instanceof JavaOnlyMap) == false) goto L5;
        JavaOnlyMap r102 = (JavaOnlyMap) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.toJSONObject();
    L8:
        if (r101 == null) goto L10;
        return r101;
    L10:
        return new JSONObject();
    L5:
        r102 = null;
        goto L6
    }

    @Override // le7.a
    public final ReadableMap b() {
        return this.P;
    }

    @Override // le7.a
    public final PlatformType c() {
        return this.O;
    }

    @Override // le7.a
    public final String d() {
        return this.Q;
    }

    public a(String r100, ReadableMap r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r102, "pageUrl");
        super(r100);
        this.M = r101;
        this.N = r102;
        this.O = PlatformType.LYNX;
        boolean r103 = true;
        if (r101 != null) goto L32;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        e(r101.getString("namespace"));     // Catch: Exception -> L27
    L11:
        if (r101 != null) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L19;
        this.H = r101.getInt("bigIntStrategy", 0);     // Catch: Exception -> L27
    L19:
        if (r101 != null) goto L21;
    L23:
        r103 = false;
    L24:
        if (r103 == false) goto L28;
        r101 = r101.getMap("data");     // Catch: Exception -> L27
    L27:
        r101 = new JavaOnlyMap();
    L28:
        if (r101 != null) goto L30;
        r101 = new JavaOnlyMap();
    L30:
        this.P = r101;
        this.Q = this.N;
        return;
    L21:
        if (r101.hasKey("data") != true) goto L23;
    L13:
        if (r101.hasKey("bigIntStrategy") != true) goto L15;
        r105 = true;
        goto L16
    L32:
        if (r101.hasKey("namespace") != true) goto L7;
        r104 = true;
        goto L8
    }
}
