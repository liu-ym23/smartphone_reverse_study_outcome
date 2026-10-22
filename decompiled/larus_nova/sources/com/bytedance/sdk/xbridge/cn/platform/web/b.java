package com.bytedance.sdk.xbridge.cn.platform.web;

import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.auth.bean.TokenAuthMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends le7.a<JSONObject> {
    public final JSONObject M;
    public final String N;
    public final PlatformType O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public int T;

    public static final class a {
    }

    static {
    }

    @Override // le7.a
    public final JSONObject a() {
        return this.M;
    }

    @Override // le7.a
    public final JSONObject b() {
        return this.M;
    }

    @Override // le7.a
    public final PlatformType c() {
        return this.O;
    }

    @Override // le7.a
    public final String d() {
        return this.N;
    }

    public b(String r100, JSONObject r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "url");
        super(r100);
        this.M = r101;
        this.N = r102;
        int r103 = 0;
        r103 = r101.optInt("bigIntStrategy", 0);     // Catch: Exception -> L6
    L4:
        this.H = r103;
        this.O = PlatformType.WEB;
        this.P = "";
        this.Q = "";
        this.R = "";
        this.S = "";
        this.T = TokenAuthMode.UNSET.getCode();
    }
}
