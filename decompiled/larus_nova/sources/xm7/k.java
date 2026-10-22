package xm7;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006¨\u0006,"}, d2 = {"Lxm7/k;", "", "", "counterUniqueKey", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "expireState", "Z", "f", "()Z", ce.f26396k, "(Z)V", "", "expireAt", "J", "e", "()J", "", "targetCount", "I", RXScreenCaptureService.KEY_INDEX, "()I", "ackedCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ce.f26395j, "(I)V", "reachTarget", "h", "countActionType", "b", "Lxm7/a;", "countTimerConfig", "Lxm7/a;", "c", "()Lxm7/a;", "Lxm7/l;", "pendantConfig", "Lxm7/l;", ce.f26391f, "()Lxm7/l;", "extra", "getExtra", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class k {

    @SerializedName("acked_count")
    private int ackedCount;

    @SerializedName("count_action_type")
    private final String countActionType;

    @SerializedName("count_timer_config")
    private final a countTimerConfig;

    @SerializedName("counter_unique_key")
    private final String counterUniqueKey;

    @SerializedName("expire_at")
    private final long expireAt;

    @SerializedName("expire_state")
    private boolean expireState;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("count_pendant_config")
    private final l pendantConfig;

    @SerializedName("reach_target")
    private final boolean reachTarget;

    @SerializedName("target_count")
    private final int targetCount;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L43:
        return true;
    L5:
        if ((r100 instanceof k) == false) goto L42;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.counterUniqueKey, r101.counterUniqueKey) == false) goto L42;
        if (this.expireState != r101.expireState) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L42;
        if (this.expireAt != r101.expireAt) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L42;
        if (this.targetCount != r101.targetCount) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L42;
        if (this.ackedCount != r101.ackedCount) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L42;
        if (this.reachTarget != r101.reachTarget) goto L31;
        boolean r106 = true;
    L32:
        if (r106 == false) goto L42;
        if (Intrinsics.areEqual(this.countActionType, r101.countActionType) == false) goto L42;
        if (Intrinsics.areEqual(this.countTimerConfig, r101.countTimerConfig) == false) goto L42;
        if (Intrinsics.areEqual(this.pendantConfig, r101.pendantConfig) == false) goto L42;
        if (Intrinsics.areEqual(this.extra, r101.extra) == false) goto L42;
    L31:
        r106 = false;
        goto L32
    L26:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L42:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.counterUniqueKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.expireState;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        long r107 = this.expireAt;
        int r108 = (((((((r103 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.targetCount) * 31) + this.ackedCount) * 31;
        boolean r109 = this.reachTarget;
        if (r109 == true) goto L13;
        r105 = r109;
    L13:
        int r110 = (r108 + r105) * 31;
        String r111 = this.countActionType;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        a r114 = this.countTimerConfig;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        l r117 = this.pendantConfig;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        String r120 = this.extra;
        if (r120 == null) goto L29;
        r101 = r120.hashCode();
    L29:
        return r119 + r101;
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LuckyCounterData(counterUniqueKey=" + this.counterUniqueKey + ", expireState=" + this.expireState + ", expireAt=" + this.expireAt + ", targetCount=" + this.targetCount + ", ackedCount=" + this.ackedCount + ", reachTarget=" + this.reachTarget + ", countActionType=" + this.countActionType + ", countTimerConfig=" + this.countTimerConfig + ", pendantConfig=" + this.pendantConfig + ", extra=" + this.extra + ")";
    }

    public final int a() {
        return this.ackedCount;
    }

    public final String b() {
        return this.countActionType;
    }

    public final a c() {
        return this.countTimerConfig;
    }

    public final String d() {
        return this.counterUniqueKey;
    }

    public final long e() {
        return this.expireAt;
    }

    public final boolean f() {
        return this.expireState;
    }

    public final l g() {
        return this.pendantConfig;
    }

    public final boolean h() {
        return this.reachTarget;
    }

    public final int i() {
        return this.targetCount;
    }

    public final void j(int r100) {
        this.ackedCount = r100;
    }

    public final void k(boolean r100) {
        this.expireState = r100;
    }
}
