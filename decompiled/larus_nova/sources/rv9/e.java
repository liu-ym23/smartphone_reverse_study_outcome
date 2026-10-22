package rv9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006%"}, d2 = {"Lcom/larus/settings/provider/perf_degrade/ScrollJankDegradeConfig;", "", "enable", "", "targetScenes", "", "", "triggerDelayMs", "", "triggerProbability", "", "triggerRange", "blockDurationMs", "<init>", "(ZLjava/util/List;JIIJ)V", "getEnable", "()Z", "getTargetScenes", "()Ljava/util/List;", "getTriggerDelayMs", "()J", "getTriggerProbability", "()I", "getTriggerRange", "getBlockDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("block_duration_ms")
    private final long blockDurationMs;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("target_scenes")
    private final List<String> targetScenes;

    @SerializedName("trigger_delay_ms")
    private final long triggerDelayMs;

    @SerializedName("trigger_probability")
    private final int triggerProbability;

    @SerializedName("trigger_range")
    private final int triggerRange;

    public static final class a {
    }

    static {
    }

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.targetScenes, r101.targetScenes) == true) goto L15;
        return false;
    L15:
        if (this.triggerDelayMs == r101.triggerDelayMs) goto L18;
        return false;
    L18:
        if (this.triggerProbability == r101.triggerProbability) goto L21;
        return false;
    L21:
        if (this.triggerRange == r101.triggerRange) goto L24;
        return false;
    L24:
        if (this.blockDurationMs == r101.blockDurationMs) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<String> r102 = this.targetScenes;
        if (r102 != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r101 + r103) * 31;
        long r105 = this.triggerDelayMs;
        int r106 = (((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.triggerProbability) * 31) + this.triggerRange) * 31;
        long r107 = this.blockDurationMs;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L9:
        r103 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ScrollJankDegradeConfig(enable=" + this.enable + ", targetScenes=" + this.targetScenes + ", triggerDelayMs=" + this.triggerDelayMs + ", triggerProbability=" + this.triggerProbability + ", triggerRange=" + this.triggerRange + ", blockDurationMs=" + this.blockDurationMs + ')';
    }

    public final long a() {
        return this.blockDurationMs;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.targetScenes;
    }

    public final long d() {
        return this.triggerDelayMs;
    }

    public final int e() {
        return this.triggerProbability;
    }

    public final int f() {
        return this.triggerRange;
    }

    public /* synthetic */ e(int r110) {
        this(false, CollectionsKt.listOf("CHAT_MESSAGE_LIST"), 0, 1, 1000, 50);
    }

    public e(boolean r100, List<String> r101, long r102, int r103, int r104, long r105) {
        this.enable = r100;
        this.targetScenes = r101;
        this.triggerDelayMs = r102;
        this.triggerProbability = r103;
        this.triggerRange = r104;
        this.blockDurationMs = r105;
    }
}
