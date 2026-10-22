package com.bytedance.env.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/env/api/b;", "", "Lcom/bytedance/env/api/EnvType;", "env", "Lcom/bytedance/env/api/EnvType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/env/api/EnvType;", "setEnv", "(Lcom/bytedance/env/api/EnvType;)V", "", "lane", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setLane", "(Ljava/lang/String;)V", "", "enabledBOE2", "Z", "getEnabledBOE2", "()Z", "setEnabledBOE2", "(Z)V", "env_platform_api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient HashMap<String, String> f243174a;

    @SerializedName("enabledBOE2")
    private boolean enabledBOE2;

    @SerializedName("env")
    private EnvType env;

    @SerializedName("lane")
    private String lane;

    public b() {
        this(null, null, 15);
    }

    public final String toString() {
        return "EnvConfig(env=" + this.env + ", lane=" + this.lane + ", enabledBOE2=" + this.enabledBOE2 + ", headers=" + this.f243174a + ")";
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final EnvType a() {
        return this.env;
    }

    public final String b() {
        return this.lane;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        Object r101 = null;
    L6:
        b r102 = (b) r101;
        if (r102 == null) goto L27;
        EnvType r103 = this.env;
        if (r103 != EnvType.PRODUCT) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L24;
        if (r103 == r102.env) goto L18;
    L22:
        return false;
    L18:
        if (Intrinsics.areEqual(this.lane, r102.lane) == false) goto L22;
        if (this.enabledBOE2 != r102.enabledBOE2) goto L22;
        return true;
    L24:
        if (r103 != r102.env) goto L22;
        return true;
    L11:
        if (r103 == EnvType.CANARY) goto L13;
        r104 = true;
        goto L14
    L27:
        return super.equals(r100);
    L5:
        r101 = r100;
        goto L6
    }

    public b(EnvType r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = EnvType.PRODUCT;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = "prod";
    L9:
        if ((r102 & 8) == 0) goto L11;
        HashMap<String, String> r103 = new HashMap();
    L12:
        this.env = r100;
        this.lane = r101;
        this.enabledBOE2 = false;
        this.f243174a = r103;
        return;
    L11:
        r103 = null;
        goto L12
    }
}
