package com.larus.office.experiment;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/larus/office/experiment/HtmlCloudCardPreviewConfig;", "", "enable", "", "serverReadyTimeS", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnable", "()Ljava/lang/String;", "getServerReadyTimeS", "isEnabledForMessage", "", "messageCreateTimeS", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("enable")
    private final String enable;

    @SerializedName("server_ready_time_s")
    private final String serverReadyTimeS;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serverReadyTimeS, r101.serverReadyTimeS) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.serverReadyTimeS;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "HtmlCloudCardPreviewConfig(enable=" + this.enable + ", serverReadyTimeS=" + this.serverReadyTimeS + ')';
    }

    public a(int r100) {
        this.enable = "0";
        this.serverReadyTimeS = null;
    }

    public final boolean a(long r100) {
        String r101 = this.serverReadyTimeS;
        if (r101 == null) goto L22;
        String r102 = StringsKt.trim(r101).toString();
        if (r102 == null) goto L23;
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.longValue() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L25;
        long r105 = r103.longValue();
        if (Intrinsics.areEqual(this.enable, "1") == true) goto L19;
        return false;
    L19:
        if (r100 <= r105) goto L27;
        return true;
    L27:
        return false;
    L25:
        return false;
    L11:
        r104 = false;
        goto L12
    L23:
        return false;
    L22:
        return false;
    }
}
