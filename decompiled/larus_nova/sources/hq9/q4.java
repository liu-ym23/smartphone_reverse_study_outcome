package hq9;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/platform/model/StreamAsrConfig;", "", "enableAsrTwopass", "", "firstAsrTimeout", "", "finalAsrTimeout", "asrWaveOpt", "extraParams", "Lcom/google/gson/JsonObject;", "<init>", "(ZJJZLcom/google/gson/JsonObject;)V", "getEnableAsrTwopass", "()Z", "getFirstAsrTimeout", "()J", "getFinalAsrTimeout", "getAsrWaveOpt", "getExtraParams", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q4 {

    @SerializedName("asr_wave_opt")
    private final boolean asrWaveOpt;

    @SerializedName("enable_asr_twopass")
    private final boolean enableAsrTwopass;

    @SerializedName("extra_params")
    private final JsonObject extraParams;

    @SerializedName("final_asr_timeout")
    private final long finalAsrTimeout;

    @SerializedName("first_asr_timeout")
    private final long firstAsrTimeout;

    public q4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q4) == true) goto L8;
        return false;
    L8:
        q4 r101 = (q4) r100;
        if (this.enableAsrTwopass == r101.enableAsrTwopass) goto L12;
        return false;
    L12:
        if (this.firstAsrTimeout == r101.firstAsrTimeout) goto L15;
        return false;
    L15:
        if (this.finalAsrTimeout == r101.finalAsrTimeout) goto L18;
        return false;
    L18:
        if (this.asrWaveOpt == r101.asrWaveOpt) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableAsrTwopass == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.firstAsrTimeout;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.finalAsrTimeout;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.asrWaveOpt == true) goto L10;
        r100 = 1237;
    L10:
        int r106 = (r105 + r100) * 31;
        JsonObject r107 = this.extraParams;
        if (r107 != null) goto L13;
        int r108 = 0;
    L15:
        return r106 + r108;
    L13:
        r108 = r107.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "StreamAsrConfig(enableAsrTwopass=" + this.enableAsrTwopass + ", firstAsrTimeout=" + this.firstAsrTimeout + ", finalAsrTimeout=" + this.finalAsrTimeout + ", asrWaveOpt=" + this.asrWaveOpt + ", extraParams=" + this.extraParams + ')';
    }

    public final boolean a() {
        return this.asrWaveOpt;
    }

    public final boolean b() {
        return this.enableAsrTwopass;
    }

    public final JsonObject c() {
        return this.extraParams;
    }

    public final long d() {
        return this.finalAsrTimeout;
    }

    public final long e() {
        return this.firstAsrTimeout;
    }

    public /* synthetic */ q4(int r100) {
        this(false, 300, 1500, true, null);
    }

    public q4(boolean r100, long r101, long r102, boolean r103, JsonObject r104) {
        this.enableAsrTwopass = r100;
        this.firstAsrTimeout = r101;
        this.finalAsrTimeout = r102;
        this.asrWaveOpt = r103;
        this.extraParams = r104;
    }
}
