package du9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/larus/settings/provider/chat/UploadMultiEntityConf;", "", "maxFileSize", "", "maxFileCount", "", "maxImageSize", "maxImageCount", "maxTotalCount", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxFileCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxImageSize", "getMaxImageCount", "getMaxTotalCount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/settings/provider/chat/UploadMultiEntityConf;", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q2 {

    @SerializedName("max_file_cnt")
    private final Integer maxFileCount;

    @SerializedName("max_file_size")
    private final Long maxFileSize;

    @SerializedName("max_image_cnt")
    private final Integer maxImageCount;

    @SerializedName("max_image_size")
    private final Long maxImageSize;

    @SerializedName("max_total_cnt")
    private final Integer maxTotalCount;

    public q2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q2) == true) goto L8;
        return false;
    L8:
        q2 r101 = (q2) r100;
        if (Intrinsics.areEqual(this.maxFileSize, r101.maxFileSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxFileCount, r101.maxFileCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxImageSize, r101.maxImageSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxImageCount, r101.maxImageCount) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxTotalCount, r101.maxTotalCount) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.maxFileSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.maxFileCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.maxImageSize;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.maxImageCount;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.maxTotalCount;
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

    public final String toString() {
        return "UploadMultiEntityConf(maxFileSize=" + this.maxFileSize + ", maxFileCount=" + this.maxFileCount + ", maxImageSize=" + this.maxImageSize + ", maxImageCount=" + this.maxImageCount + ", maxTotalCount=" + this.maxTotalCount + ')';
    }

    public final Integer a() {
        return this.maxFileCount;
    }

    public final Long b() {
        return this.maxFileSize;
    }

    public final Integer c() {
        return this.maxImageCount;
    }

    public final Long d() {
        return this.maxImageSize;
    }

    public final Integer e() {
        return this.maxTotalCount;
    }

    public q2(int r100) {
        this.maxFileSize = Long.valueOf(com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_CHECK_BYTES);
        this.maxFileCount = 50;
        this.maxImageSize = 335544320L;
        this.maxImageCount = 20;
        this.maxTotalCount = 50;
    }
}
