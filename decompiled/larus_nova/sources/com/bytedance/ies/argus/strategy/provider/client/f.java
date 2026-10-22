package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements yd7.j.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yd7.j.b f246223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yd7.j.f f246224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f246225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yd7.j.c f246226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f246227e;

    public f() {
        throw null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f246223a, r101.f246223a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246224b, r101.f246224b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246225c, r101.f246225c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246226d, r101.f246226d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246227e, r101.f246227e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246223a.hashCode() * 31;
        yd7.j.f r101 = this.f246224b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f246225c.hashCode()) * 31;
        yd7.j.c r105 = this.f246226d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f246227e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ArgusXUploadImagesToImageXParamModelImpl(authConfig=" + this.f246223a + ", uploadConfig=" + this.f246224b + ", filePaths=" + this.f246225c + ", encryptionConfig=" + this.f246226d + ", mainNetworkType=" + this.f246227e + ')';
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
    public final JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        JSONUtilsKt.d(r100, "authConfig", this.f246223a.toJSON());
        JSONUtilsKt.d(r100, "filePaths", this.f246225c);
        return r100;
    }

    @Override // yd7.j.g
    public final yd7.j.b getAuthConfig() {
        return this.f246223a;
    }

    @Override // yd7.j.g
    public final yd7.j.c getEncryptionConfig() {
        return this.f246226d;
    }

    @Override // yd7.j.g
    public final List<String> getFilePaths() {
        return this.f246225c;
    }

    @Override // yd7.j.g
    public final String getMainNetworkType() {
        return this.f246227e;
    }

    @Override // yd7.j.g
    public final yd7.j.f getUploadConfig() {
        return this.f246224b;
    }

    @Override // yd7.j.g
    public final void setMainNetworkType(String r100) {
        this.f246227e = r100;
    }

    public f(e r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "authConfig");
        Intrinsics.checkNotNullParameter(r101, "filePaths");
        this.f246223a = r100;
        this.f246224b = null;
        this.f246225c = r101;
        this.f246226d = null;
        this.f246227e = TrafficMetrics.FRPM_TTNET;
    }
}
