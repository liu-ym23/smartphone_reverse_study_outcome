package com.larus.account.saas.security.risk;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/larus/account/saas/security/risk/l;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "content", "getContent", "", "action", "Ljava/lang/Integer;", "getAction", "()Ljava/lang/Integer;", "h5Url", "getH5Url", "toast", "getToast", "successToast", "getSuccessToast", "failToast", "getFailToast", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class l {

    @SerializedName("action")
    private final Integer action;

    @SerializedName("content")
    private final String content;

    @SerializedName("failToast")
    private final String failToast;

    @SerializedName("h5_url")
    private final String h5Url;

    @SerializedName("successToast")
    private final String successToast;

    @SerializedName("title")
    private final String title;

    @SerializedName("toast")
    private final String toast;

    public l() {
        this.title = "";
        this.content = "";
        this.action = 3;
        this.h5Url = "";
        this.toast = "";
        this.successToast = "";
        this.failToast = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h5Url, r101.h5Url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.successToast, r101.successToast) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.failToast, r101.failToast) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.action;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.h5Url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.toast;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.successToast;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.failToast;
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
        return "NetworkRiskInfoResponse(title=" + this.title + ", content=" + this.content + ", action=" + this.action + ", h5Url=" + this.h5Url + ", toast=" + this.toast + ", successToast=" + this.successToast + ", failToast=" + this.failToast + ')';
    }

    public final e48.b a() {
        String r100 = this.title;
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        String r102 = this.content;
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        Integer r104 = this.action;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        String r106 = this.h5Url;
        if (r106 != null) goto L17;
        String r107 = "";
    L18:
        String r108 = this.toast;
        if (r108 != null) goto L21;
        String r109 = "";
    L22:
        String r110 = this.successToast;
        if (r110 != null) goto L25;
        String r111 = "";
    L26:
        String r112 = this.failToast;
        if (r112 != null) goto L29;
        String r113 = "";
    L31:
        return new e48.b(r101, r103, r105, r107, r109, r111, r113);
    L29:
        r113 = r112;
        goto L31
    L25:
        r111 = r110;
        goto L26
    L21:
        r109 = r108;
        goto L22
    L17:
        r107 = r106;
        goto L18
    L13:
        r105 = 3;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }
}
