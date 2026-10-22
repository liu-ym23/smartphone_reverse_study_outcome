package com.bytedance.ies.argus.strategy.provider.client;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/c;", "", "", "accessKeyId", "Ljava/lang/String;", "getAccessKeyId", "()Ljava/lang/String;", "secretAccessKey", "getSecretAccessKey", "sessionToken", "getSessionToken", "serviceId", "getServiceId", "aesEncryptKey", "b", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f246210a;

    @SerializedName("access_key_id")
    private final String accessKeyId;

    @SerializedName("key")
    private final String aesEncryptKey;

    @SerializedName("expire_time")
    private final Long expireTime;

    @SerializedName("secret_access_key")
    private final String secretAccessKey;

    @SerializedName("service_id")
    private final String serviceId;

    @SerializedName("session_token")
    private final String sessionToken;

    @SerializedName("status")
    private final Integer status;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.accessKeyId, r101.accessKeyId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secretAccessKey, r101.secretAccessKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sessionToken, r101.sessionToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serviceId, r101.serviceId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.aesEncryptKey, r101.aesEncryptKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.expireTime, r101.expireTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.accessKeyId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.secretAccessKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sessionToken;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.serviceId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.aesEncryptKey;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.expireTime;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.status;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ArgusWebDomUploadImageXConfigModel(accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ", serviceId=" + this.serviceId + ", aesEncryptKey=" + this.aesEncryptKey + ", expireTime=" + this.expireTime + ", status=" + this.status + ')';
    }

    public final boolean d() {
        Integer r100 = this.status;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 10002) goto L8;
        return true;
    }

    public c() {
        this.accessKeyId = null;
        this.secretAccessKey = null;
        this.sessionToken = null;
        this.serviceId = null;
        this.aesEncryptKey = null;
        this.expireTime = null;
        this.status = null;
        this.f246210a = LazyKt.lazy(new ArgusWebDomUploadImageXConfigModel$xbridgeAuthConfigImpl$2(this));
    }

    public final String b() {
        return this.aesEncryptKey;
    }

    public final Long c() {
        return this.expireTime;
    }

    public static final e a(c r100) {
        String r101 = r100.accessKeyId;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L34;
        String r104 = r100.sessionToken;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L34;
        String r106 = r100.secretAccessKey;
        if (r106 != null) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L34;
        String r108 = r100.serviceId;
        if (r108 != null) goto L29;
    L30:
        r102 = true;
    L31:
        if (r102 == true) goto L34;
        return new e(r100.accessKeyId, r100.secretAccessKey, r100.sessionToken, r100.serviceId);
    L29:
        if (r108.length() != 0) goto L31;
    L21:
        if (r106.length() == 0) goto L24;
        r107 = false;
        goto L25
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L34:
        return null;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
