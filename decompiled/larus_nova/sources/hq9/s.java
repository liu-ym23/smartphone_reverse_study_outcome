package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/AudioStreamPlayerMechanismConfig;", "", "timeoutProtect", "", "timeoutSec", "timeoutSecPerChunk", "timeoutWrite", "<init>", "(JJJJ)V", "getTimeoutProtect", "()J", "getTimeoutSec", "getTimeoutSecPerChunk", "getTimeoutWrite", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s {

    @SerializedName("timeout_protect")
    private final long timeoutProtect;

    @SerializedName("timeout_sec")
    private final long timeoutSec;

    @SerializedName("timeout_sec_per_chunk")
    private final long timeoutSecPerChunk;

    @SerializedName("timeout_write")
    private final long timeoutWrite;

    public s() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (this.timeoutProtect == r101.timeoutProtect) goto L12;
        return false;
    L12:
        if (this.timeoutSec == r101.timeoutSec) goto L15;
        return false;
    L15:
        if (this.timeoutSecPerChunk == r101.timeoutSecPerChunk) goto L18;
        return false;
    L18:
        if (this.timeoutWrite == r101.timeoutWrite) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.timeoutProtect;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.timeoutSec;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.timeoutSecPerChunk;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.timeoutWrite;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "AudioStreamPlayerMechanismConfig(timeoutProtect=" + this.timeoutProtect + ", timeoutSec=" + this.timeoutSec + ", timeoutSecPerChunk=" + this.timeoutSecPerChunk + ", timeoutWrite=" + this.timeoutWrite + ')';
    }

    public final long a() {
        return this.timeoutProtect;
    }

    public final long b() {
        return this.timeoutSec;
    }

    public final long c() {
        return this.timeoutSecPerChunk;
    }

    public final long d() {
        return this.timeoutWrite;
    }

    public s(int r100) {
        this.timeoutProtect = 180;
        this.timeoutSec = 60;
        this.timeoutSecPerChunk = 60;
        this.timeoutWrite = 60;
    }
}
