package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0007\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/larus/bmhome/rc/ResourceSignUrlDataV2;", "", "statusCode", "", "message", "", "mainUrl", "isEncrypted", "", "decryptionKey", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getStatusCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getMainUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDecryptionKey", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/bmhome/rc/ResourceSignUrlDataV2;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceSignUrlDataV2 {

    @SerializedName("decryption_key")
    private final String decryptionKey;

    @SerializedName("is_encrypted")
    private final Boolean isEncrypted;

    @SerializedName("main_url")
    private final String mainUrl;

    @SerializedName("message")
    private final String message;

    @SerializedName("status_code")
    private final Integer statusCode;

    public ResourceSignUrlDataV2() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResourceSignUrlDataV2 copy$default(ResourceSignUrlDataV2 r100, Integer r101, String r102, String r103, Boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.statusCode;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.message;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.mainUrl;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isEncrypted;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.decryptionKey;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.statusCode;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.mainUrl;
    }

    public final Boolean component4() {
        return this.isEncrypted;
    }

    public final String component5() {
        return this.decryptionKey;
    }

    public final ResourceSignUrlDataV2 copy(Integer r100, String r101, String r110, Boolean r111, String r112) {
        return new ResourceSignUrlDataV2(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceSignUrlDataV2) == true) goto L8;
        return false;
    L8:
        ResourceSignUrlDataV2 r101 = (ResourceSignUrlDataV2) r100;
        if (Intrinsics.areEqual(this.statusCode, r101.statusCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainUrl, r101.mainUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isEncrypted, r101.isEncrypted) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.decryptionKey, r101.decryptionKey) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.statusCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.message;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mainUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isEncrypted;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.decryptionKey;
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
        return "ResourceSignUrlDataV2(statusCode=" + this.statusCode + ", message=" + this.message + ", mainUrl=" + this.mainUrl + ", isEncrypted=" + this.isEncrypted + ", decryptionKey=" + this.decryptionKey + ')';
    }

    public final String getDecryptionKey() {
        return this.decryptionKey;
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public final Boolean isEncrypted() {
        return this.isEncrypted;
    }

    public ResourceSignUrlDataV2(Integer r100, String r101, String r102, Boolean r103, String r104) {
        this.statusCode = r100;
        this.message = r101;
        this.mainUrl = r102;
        this.isEncrypted = r103;
        this.decryptionKey = r104;
    }

    public /* synthetic */ ResourceSignUrlDataV2(Integer r100, String r101, String r102, Boolean r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        String r106 = null;
        if ((r105 & 2) == 0) goto L8;
        String r111 = null;
    L10:
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) == 0) goto L16;
        r103 = Boolean.FALSE;
    L16:
        Boolean r108 = r103;
        if ((r105 & 16) != 0) goto L20;
        r106 = r104;
    L20:
        this(r100, r111, r107, r108, r106);
        return;
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
