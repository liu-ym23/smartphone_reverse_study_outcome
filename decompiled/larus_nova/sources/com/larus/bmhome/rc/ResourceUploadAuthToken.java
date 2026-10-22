package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.common.spi.security.ObricSecurityServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/rc/ResourceUploadAuthToken;", "", "accessKey", "", "secretKey", "sessionToken", "expiredTime", "currentTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getSecretKey", "getSessionToken", "getExpiredTime", "getCurrentTime", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceUploadAuthToken {

    @SerializedName("access_key")
    private final String accessKey;

    @SerializedName("current_time")
    private final String currentTime;

    @SerializedName("expired_time")
    private final String expiredTime;

    @SerializedName("secret_key")
    private final String secretKey;

    @SerializedName("session_token")
    private final String sessionToken;

    public ResourceUploadAuthToken() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResourceUploadAuthToken copy$default(ResourceUploadAuthToken r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.accessKey;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.secretKey;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.sessionToken;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.expiredTime;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.currentTime;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.accessKey;
    }

    public final String component2() {
        return this.secretKey;
    }

    public final String component3() {
        return this.sessionToken;
    }

    public final String component4() {
        return this.expiredTime;
    }

    public final String component5() {
        return this.currentTime;
    }

    public final ResourceUploadAuthToken copy(String r100, String r101, String r110, String r111, String r112) {
        return new ResourceUploadAuthToken(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceUploadAuthToken) == true) goto L8;
        return false;
    L8:
        ResourceUploadAuthToken r101 = (ResourceUploadAuthToken) r100;
        if (Intrinsics.areEqual(this.accessKey, r101.accessKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secretKey, r101.secretKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sessionToken, r101.sessionToken) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expiredTime, r101.expiredTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.currentTime, r101.currentTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.accessKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.secretKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.sessionToken;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.expiredTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.currentTime;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public String toString() {
        StringBuilder r100 = new StringBuilder("ResourceUploadAuthToken(accessKey=");
        ObricSecurityServiceDelegate r101 = ObricSecurityServiceDelegate.f387847b;
        r100.append(r101.a(this.accessKey));
        r100.append(", secretKey=");
        r100.append(r101.a(this.secretKey));
        r100.append(", sessionToken=");
        r100.append(r101.a(this.sessionToken));
        r100.append(", expiredTime=");
        r100.append(this.expiredTime);
        r100.append(", currentTime=");
        r100.append(this.currentTime);
        r100.append(')');
        return r100.toString();
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }

    public final String getExpiredTime() {
        return this.expiredTime;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public ResourceUploadAuthToken(String r100, String r101, String r102, String r103, String r104) {
        this.accessKey = r100;
        this.secretKey = r101;
        this.sessionToken = r102;
        this.expiredTime = r103;
        this.currentTime = r104;
    }

    public /* synthetic */ ResourceUploadAuthToken(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
