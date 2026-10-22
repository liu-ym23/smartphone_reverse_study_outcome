package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/provider/NpthAttachDataConfig;", "", "enableNpthLifecycleRecorder", "", "enableNpthLifecycleUpload", "npthLifecycleMaxRecordSize", "", "<init>", "(ZZI)V", "getEnableNpthLifecycleRecorder", "()Z", "getEnableNpthLifecycleUpload", "getNpthLifecycleMaxRecordSize", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o3 {

    @SerializedName("enable_npth_lifecycle_recorder")
    private final boolean enableNpthLifecycleRecorder;

    @SerializedName("enable_npth_lifecycle_upload")
    private final boolean enableNpthLifecycleUpload;

    @SerializedName("npth_lifecycle_max_record_size")
    private final int npthLifecycleMaxRecordSize;

    public o3() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o3) == true) goto L8;
        return false;
    L8:
        o3 r101 = (o3) r100;
        if (this.enableNpthLifecycleRecorder == r101.enableNpthLifecycleRecorder) goto L12;
        return false;
    L12:
        if (this.enableNpthLifecycleUpload == r101.enableNpthLifecycleUpload) goto L15;
        return false;
    L15:
        if (this.npthLifecycleMaxRecordSize == r101.npthLifecycleMaxRecordSize) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableNpthLifecycleRecorder == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableNpthLifecycleUpload == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.npthLifecycleMaxRecordSize;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "NpthAttachDataConfig(enableNpthLifecycleRecorder=" + this.enableNpthLifecycleRecorder + ", enableNpthLifecycleUpload=" + this.enableNpthLifecycleUpload + ", npthLifecycleMaxRecordSize=" + this.npthLifecycleMaxRecordSize + ')';
    }

    public final boolean a() {
        return this.enableNpthLifecycleRecorder;
    }

    public final boolean b() {
        return this.enableNpthLifecycleUpload;
    }

    public final int c() {
        return this.npthLifecycleMaxRecordSize;
    }

    public o3(int r100) {
        this.enableNpthLifecycleRecorder = true;
        this.enableNpthLifecycleUpload = true;
        this.npthLifecycleMaxRecordSize = 100;
    }
}
