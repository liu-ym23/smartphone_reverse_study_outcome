package com.larus.dora.dorag.res;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/dora/dorag/res/OcrDataWrapper;", "", "hasText", "", "ocrText", "", "timestamp", "", "<init>", "(ZLjava/lang/String;J)V", "getHasText", "()Z", "getOcrText", "()Ljava/lang/String;", "getTimestamp", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "dorag-res_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class o {

    @SerializedName("hasText")
    private final boolean hasText;

    @SerializedName("ocrText")
    private final String ocrText;

    @SerializedName("timestamp")
    private final long timestamp;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.hasText == r101.hasText) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ocrText, r101.ocrText) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r101.timestamp) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.hasText == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.ocrText;
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r101 + r103) * 31;
        long r105 = this.timestamp;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L9:
        r103 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OcrDataWrapper(hasText=" + this.hasText + ", ocrText=" + this.ocrText + ", timestamp=" + this.timestamp + ')';
    }

    public o() {
        this.hasText = false;
        this.ocrText = "";
        this.timestamp = 0;
    }

    public final boolean a() {
        return this.hasText;
    }

    public final String b() {
        return this.ocrText;
    }

    public final long c() {
        return this.timestamp;
    }
}
