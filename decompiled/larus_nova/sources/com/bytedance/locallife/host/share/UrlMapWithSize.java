package com.bytedance.locallife.host.share;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/host/share/UrlMapWithSize;", "Ljava/io/Serializable;", "coverUrl200", "", "coverUrl400", "(Ljava/lang/String;Ljava/lang/String;)V", "getCoverUrl200", "()Ljava/lang/String;", "getCoverUrl400", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class UrlMapWithSize implements Serializable {

    @SerializedName("200*200")
    private final String coverUrl200;

    @SerializedName("400*400")
    private final String coverUrl400;

    /* JADX WARN: Multi-variable type inference failed */
    public UrlMapWithSize() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UrlMapWithSize copy$default(UrlMapWithSize r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.coverUrl200;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.coverUrl400;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.coverUrl200;
    }

    public final String component2() {
        return this.coverUrl400;
    }

    public final UrlMapWithSize copy(String r100, String r101) {
        return new UrlMapWithSize(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlMapWithSize) == true) goto L8;
        return false;
    L8:
        UrlMapWithSize r101 = (UrlMapWithSize) r100;
        if (Intrinsics.areEqual(this.coverUrl200, r101.coverUrl200) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coverUrl400, r101.coverUrl400) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.coverUrl200;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.coverUrl400;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UrlMapWithSize(coverUrl200=" + this.coverUrl200 + ", coverUrl400=" + this.coverUrl400 + ')';
    }

    public final String getCoverUrl200() {
        return this.coverUrl200;
    }

    public final String getCoverUrl400() {
        return this.coverUrl400;
    }

    public UrlMapWithSize(String r100, String r101) {
        this.coverUrl200 = r100;
        this.coverUrl400 = r101;
    }

    public /* synthetic */ UrlMapWithSize(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
