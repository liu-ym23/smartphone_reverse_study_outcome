package com.bytedance.helios.api.consumer;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/helios/api/consumer/BPEAInfo;", "", "certToken", "", "entryToken", "extra", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCertToken", "()Ljava/lang/String;", "setCertToken", "(Ljava/lang/String;)V", "getEntryToken", "setEntryToken", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 1, 16})
public final class BPEAInfo {
    private String certToken;
    private String entryToken;
    private final Map<String, Object> extra;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BPEAInfo copy$default(BPEAInfo r100, String r101, String r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.certToken;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.entryToken;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.certToken;
    }

    public final String component2() {
        return this.entryToken;
    }

    public final Map<String, Object> component3() {
        return this.extra;
    }

    public final BPEAInfo copy(String r100, String r101, Map<String, Object> r102) {
        return new BPEAInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BPEAInfo) == false) goto L12;
        BPEAInfo r101 = (BPEAInfo) r100;
        if (Intrinsics.areEqual(this.certToken, r101.certToken) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.entryToken, r101.entryToken) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.certToken;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.entryToken;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.extra;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "BPEAInfo(certToken=" + this.certToken + ", entryToken=" + this.entryToken + ", extra=" + this.extra + ")";
    }

    public final String getCertToken() {
        return this.certToken;
    }

    public final String getEntryToken() {
        return this.entryToken;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setCertToken(String r100) {
        this.certToken = r100;
    }

    public final void setEntryToken(String r100) {
        this.entryToken = r100;
    }

    public BPEAInfo(String r100, String r101, Map<String, Object> r102) {
        this.certToken = r100;
        this.entryToken = r101;
        this.extra = r102;
    }

    public /* synthetic */ BPEAInfo(String r100, String r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = new LinkedHashMap();
    L8:
        this(r100, r101, r102);
    }
}
