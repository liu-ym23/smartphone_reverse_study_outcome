package com.larus.voicecall.impl.component.denoise;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/DenoiseReportRes;", "", "denoiseAuthor", "", "denoiseStudyStatus", "<init>", "(II)V", "toString", "", "getAuthStatus", "Lcom/larus/voicecall/impl/component/denoise/VoiceFeatureAuthStatus;", "getDenoiseStatus", "Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("denoise_author")
    private final int denoiseAuthor;

    @SerializedName("denoise_state")
    private final int denoiseStudyStatus;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.denoiseAuthor == r101.denoiseAuthor) goto L12;
        return false;
    L12:
        if (this.denoiseStudyStatus == r101.denoiseStudyStatus) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.denoiseAuthor * 31) + this.denoiseStudyStatus;
    }

    public final String toString() {
        return "denoise_author=" + this.denoiseAuthor + " denoise_state=" + this.denoiseStudyStatus + " getAuthStatus=" + a() + " getDenoiseStatus=" + b();
    }

    public f() {
        this.denoiseAuthor = 0;
        this.denoiseStudyStatus = 0;
    }

    public final VoiceFeatureAuthStatus a() {
        VoiceFeatureAuthStatus[] r100 = VoiceFeatureAuthStatus.values();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        VoiceFeatureAuthStatus r103 = r100[r102];
        if (r103.getValue() != this.denoiseAuthor) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L12;
        r102 = r102 + 1;
    L12:
        if (r103 == null) goto L14;
        return r103;
    L14:
        return VoiceFeatureAuthStatus.UNAUTHORIZED;
    L7:
        r104 = false;
        goto L8
    L11:
        r103 = null;
        goto L12
    }

    public final DenoiseStatusRes b() {
        DenoiseStatusRes[] r100 = DenoiseStatusRes.values();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        DenoiseStatusRes r103 = r100[r102];
        if (r103.getValue() != this.denoiseStudyStatus) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L12;
        r102 = r102 + 1;
    L12:
        if (r103 == null) goto L14;
        return r103;
    L14:
        return DenoiseStatusRes.UNKNOWN;
    L7:
        r104 = false;
        goto L8
    L11:
        r103 = null;
        goto L12
    }
}
