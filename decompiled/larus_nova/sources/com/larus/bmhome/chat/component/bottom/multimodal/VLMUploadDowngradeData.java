package com.larus.bmhome.chat.component.bottom.multimodal;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/VLMUploadDowngradeData;", "", "vlmResolution", "", "vlmQuality", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getVlmResolution", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVlmQuality", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/component/bottom/multimodal/VLMUploadDowngradeData;", "equals", "", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VLMUploadDowngradeData {

    @SerializedName("vlm_qual")
    private final Integer vlmQuality;

    @SerializedName("vlm_res")
    private final Integer vlmResolution;

    /* JADX WARN: Multi-variable type inference failed */
    public VLMUploadDowngradeData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VLMUploadDowngradeData copy$default(VLMUploadDowngradeData r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.vlmResolution;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.vlmQuality;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.vlmResolution;
    }

    public final Integer component2() {
        return this.vlmQuality;
    }

    public final VLMUploadDowngradeData copy(Integer r100, Integer r101) {
        return new VLMUploadDowngradeData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VLMUploadDowngradeData) == true) goto L8;
        return false;
    L8:
        VLMUploadDowngradeData r101 = (VLMUploadDowngradeData) r100;
        if (Intrinsics.areEqual(this.vlmResolution, r101.vlmResolution) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.vlmQuality, r101.vlmQuality) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.vlmResolution;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.vlmQuality;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "VLMUploadDowngradeData(vlmResolution=" + this.vlmResolution + ", vlmQuality=" + this.vlmQuality + ')';
    }

    public final Integer getVlmQuality() {
        return this.vlmQuality;
    }

    public final Integer getVlmResolution() {
        return this.vlmResolution;
    }

    public VLMUploadDowngradeData(Integer r100, Integer r101) {
        this.vlmResolution = r100;
        this.vlmQuality = r101;
    }

    public /* synthetic */ VLMUploadDowngradeData(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
