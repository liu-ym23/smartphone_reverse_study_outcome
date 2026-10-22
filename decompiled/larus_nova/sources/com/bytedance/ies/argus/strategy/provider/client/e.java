package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements yd7.j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f246220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f246221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f246222e;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f246218a, r101.f246218a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246219b, r101.f246219b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246220c, r101.f246220c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246221d, r101.f246221d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246222e, r101.f246222e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f246218a.hashCode() * 31) + this.f246219b.hashCode()) * 31) + this.f246220c.hashCode()) * 31) + this.f246221d.hashCode()) * 31) + this.f246222e.hashCode();
    }

    public final String toString() {
        return "ArgusXBridgeBeanXUploadImagesToImageXAuthConfigImpl(accessKeyId=" + this.f246218a + ", secretAccessKey=" + this.f246219b + ", sessionToken=" + this.f246220c + ", serviceId=" + this.f246221d + ", hostName=" + this.f246222e + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        JSONUtilsKt.d(r100, "accessKeyId", this.f246218a);
        JSONUtilsKt.d(r100, "secretAccessKey", this.f246219b);
        JSONUtilsKt.d(r100, "sessionToken", this.f246220c);
        JSONUtilsKt.d(r100, "serviceId", this.f246221d);
        JSONUtilsKt.d(r100, "hostName", this.f246222e);
        return r100;
    }

    @Override // yd7.j.b
    public final String getAccessKeyId() {
        return this.f246218a;
    }

    @Override // yd7.j.b
    public final String getHostName() {
        return this.f246222e;
    }

    @Override // yd7.j.b
    public final String getSecretAccessKey() {
        return this.f246219b;
    }

    @Override // yd7.j.b
    public final String getServiceId() {
        return this.f246221d;
    }

    @Override // yd7.j.b
    public final String getSessionToken() {
        return this.f246220c;
    }

    public e(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "accessKeyId");
        Intrinsics.checkNotNullParameter(r101, "secretAccessKey");
        Intrinsics.checkNotNullParameter(r102, "sessionToken");
        Intrinsics.checkNotNullParameter(r103, "serviceId");
        Intrinsics.checkNotNullParameter("imagex.bytedanceapi.com", "hostName");
        this.f246218a = r100;
        this.f246219b = r101;
        this.f246220c = r102;
        this.f246221d = r103;
        this.f246222e = "imagex.bytedanceapi.com";
    }
}
