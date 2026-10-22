package com.ss.android.lark.officesdk.minutes.service.fileupload.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J)\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003Jr\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R6\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\b\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/fileupload/network/response/MmFileUploadQuotaResponse;", "Ljava/io/Serializable;", "hasQuota", "", "uploadTokenMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "isAdmin", "noQuotaNotice", "billUrl", "denyType", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/HashMap;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;I)V", "getHasQuota", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUploadTokenMap", "()Ljava/util/HashMap;", "getNoQuotaNotice", "()Ljava/lang/String;", "getBillUrl", "getDenyType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/util/HashMap;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;I)Lcom/ss/android/lark/officesdk/minutes/service/fileupload/network/response/MmFileUploadQuotaResponse;", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmFileUploadQuotaResponse implements Serializable {

    @SerializedName("bill_url")
    private final String billUrl;

    @SerializedName("deny_type")
    private final int denyType;

    @SerializedName("has_quota")
    private final Boolean hasQuota;

    @SerializedName("is_admin")
    private final Boolean isAdmin;

    @SerializedName("no_quota_notice")
    private final String noQuotaNotice;

    @SerializedName("upload_token")
    private final HashMap<String, String> uploadTokenMap;

    public MmFileUploadQuotaResponse() {
        this(null, null, null, null, null, 0, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmFileUploadQuotaResponse copy$default(MmFileUploadQuotaResponse r100, Boolean r101, HashMap r102, Boolean r103, String r104, String r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.hasQuota;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.uploadTokenMap;
    L8:
        HashMap r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.isAdmin;
    L11:
        Boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.noQuotaNotice;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.billUrl;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.denyType;
    L20:
        Boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Boolean component1() {
        return this.hasQuota;
    }

    public final HashMap<String, String> component2() {
        return this.uploadTokenMap;
    }

    public final Boolean component3() {
        return this.isAdmin;
    }

    public final String component4() {
        return this.noQuotaNotice;
    }

    public final String component5() {
        return this.billUrl;
    }

    public final int component6() {
        return this.denyType;
    }

    public final MmFileUploadQuotaResponse copy(Boolean r100, HashMap<String, String> r110, Boolean r111, String r112, String r113, int r114) {
        return new MmFileUploadQuotaResponse(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmFileUploadQuotaResponse) == true) goto L8;
        return false;
    L8:
        MmFileUploadQuotaResponse r101 = (MmFileUploadQuotaResponse) r100;
        if (Intrinsics.areEqual(this.hasQuota, r101.hasQuota) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uploadTokenMap, r101.uploadTokenMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isAdmin, r101.isAdmin) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.noQuotaNotice, r101.noQuotaNotice) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.billUrl, r101.billUrl) == true) goto L24;
        return false;
    L24:
        if (this.denyType == r101.denyType) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.hasQuota;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, String> r104 = this.uploadTokenMap;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isAdmin;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.noQuotaNotice;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.billUrl;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return ((r112 + r101) * 31) + this.denyType;
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
        return "MmFileUploadQuotaResponse(hasQuota=" + this.hasQuota + ", uploadTokenMap=" + this.uploadTokenMap + ", isAdmin=" + this.isAdmin + ", noQuotaNotice=" + this.noQuotaNotice + ", billUrl=" + this.billUrl + ", denyType=" + this.denyType + ')';
    }

    public final String getBillUrl() {
        return this.billUrl;
    }

    public final int getDenyType() {
        return this.denyType;
    }

    public final Boolean getHasQuota() {
        return this.hasQuota;
    }

    public final String getNoQuotaNotice() {
        return this.noQuotaNotice;
    }

    public final HashMap<String, String> getUploadTokenMap() {
        return this.uploadTokenMap;
    }

    public final Boolean isAdmin() {
        return this.isAdmin;
    }

    public MmFileUploadQuotaResponse(Boolean r100, HashMap<String, String> r101, Boolean r102, String r103, String r104, int r105) {
        this.hasQuota = r100;
        this.uploadTokenMap = r101;
        this.isAdmin = r102;
        this.noQuotaNotice = r103;
        this.billUrl = r104;
        this.denyType = r105;
    }

    public /* synthetic */ MmFileUploadQuotaResponse(Boolean r100, HashMap r101, Boolean r102, String r103, String r104, int r110, int r111, DefaultConstructorMarker r112) {
        String r105 = null;
        if ((r111 & 1) == 0) goto L5;
        Boolean r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        HashMap r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        Boolean r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        int r114 = 0;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
