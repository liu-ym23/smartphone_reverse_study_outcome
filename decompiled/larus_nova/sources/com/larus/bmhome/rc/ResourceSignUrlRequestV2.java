package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0010\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/rc/ResourceSignUrlRequestV2;", "", "params", "", "Lcom/larus/bmhome/rc/ResourceSignUrlParamV2;", "encrypted", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getParams", "()Ljava/util/List;", "getEncrypted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/bmhome/rc/ResourceSignUrlRequestV2;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResourceSignUrlRequestV2 {

    @SerializedName("encrypted")
    private final Boolean encrypted;

    @SerializedName("params")
    private final List<ResourceSignUrlParamV2> params;

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceSignUrlRequestV2() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResourceSignUrlRequestV2 copy$default(ResourceSignUrlRequestV2 r100, List r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.params;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.encrypted;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<ResourceSignUrlParamV2> component1() {
        return this.params;
    }

    public final Boolean component2() {
        return this.encrypted;
    }

    public final ResourceSignUrlRequestV2 copy(List<ResourceSignUrlParamV2> r100, Boolean r101) {
        return new ResourceSignUrlRequestV2(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResourceSignUrlRequestV2) == true) goto L8;
        return false;
    L8:
        ResourceSignUrlRequestV2 r101 = (ResourceSignUrlRequestV2) r100;
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.encrypted, r101.encrypted) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<ResourceSignUrlParamV2> r100 = this.params;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.encrypted;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceSignUrlRequestV2(params=" + this.params + ", encrypted=" + this.encrypted + ')';
    }

    public final Boolean getEncrypted() {
        return this.encrypted;
    }

    public final List<ResourceSignUrlParamV2> getParams() {
        return this.params;
    }

    public ResourceSignUrlRequestV2(List<ResourceSignUrlParamV2> r100, Boolean r101) {
        this.params = r100;
        this.encrypted = r101;
    }

    public /* synthetic */ ResourceSignUrlRequestV2(List r100, Boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Boolean.TRUE;
    L8:
        this(r100, r101);
    }
}
