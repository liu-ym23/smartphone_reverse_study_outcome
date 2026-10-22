package ph7;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lph7/c;", "", "", "silenceEnable", "Z", "f", "()Z", "", "silenceThreshold", "J", ce.f26391f, "()J", "multiProcessEnable", "e", "foregroundUseBroadcast", "d", "canUseRunningAppProcesses", "c", "backgroundTolerableDuration", "b", "Lph7/e;", "strictBackgroundScene", "Lph7/e;", "getStrictBackgroundScene", "()Lph7/e;", "Lph7/a;", "coldLaunchScene", "Lph7/a;", "getColdLaunchScene", "()Lph7/a;", "Lph7/b;", "hotLaunchScene", "Lph7/b;", "getHotLaunchScene", "()Lph7/b;", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("background_tolerable_duration")
    private final long backgroundTolerableDuration;

    @SerializedName("use_running_app_processes")
    private final boolean canUseRunningAppProcesses;

    @SerializedName("cold_launch_scene")
    private final a coldLaunchScene;

    @SerializedName("foreground_use_broadcast")
    private final boolean foregroundUseBroadcast;

    @SerializedName("hot_launch_scene")
    private final b hotLaunchScene;

    @SerializedName("multi_process_enable")
    private final boolean multiProcessEnable;

    @SerializedName("silent_scene_enable")
    private final boolean silenceEnable;

    @SerializedName("silent_scene_threshold")
    private final long silenceThreshold;

    @SerializedName("strict_background_scene")
    private final e strictBackgroundScene;

    public c() {
        this(false, 600000, false, false, true, 0, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L24;
        c r101 = (c) r100;
        if (this.silenceEnable == r101.silenceEnable) goto L8;
        return false;
    L8:
        if (this.silenceThreshold == r101.silenceThreshold) goto L10;
        return false;
    L10:
        if (this.multiProcessEnable == r101.multiProcessEnable) goto L12;
        return false;
    L12:
        if (this.foregroundUseBroadcast == r101.foregroundUseBroadcast) goto L14;
        return false;
    L14:
        if (this.canUseRunningAppProcesses == r101.canUseRunningAppProcesses) goto L16;
        return false;
    L16:
        if (this.backgroundTolerableDuration == r101.backgroundTolerableDuration) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.strictBackgroundScene, r101.strictBackgroundScene) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.coldLaunchScene, r101.coldLaunchScene) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.hotLaunchScene, r101.hotLaunchScene) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public final int hashCode() {
        boolean r100 = this.silenceEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.silenceThreshold;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        boolean r105 = this.multiProcessEnable;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.foregroundUseBroadcast;
        ?? r109 = r108;
        if (r108 == false) goto L11;
        r109 = 1;
    L11:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.canUseRunningAppProcesses;
        if (r111 == true) goto L15;
        r101 = r111;
    L15:
        int r112 = (r110 + r101) * 31;
        long r113 = this.backgroundTolerableDuration;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        e r115 = this.strictBackgroundScene;
        int r116 = 0;
        if (r115 == null) goto L18;
        int r117 = r115.hashCode();
    L19:
        int r118 = (r114 + r117) * 31;
        a r119 = this.coldLaunchScene;
        if (r119 == null) goto L22;
        int r120 = r119.hashCode();
    L23:
        int r121 = (r118 + r120) * 31;
        b r122 = this.hotLaunchScene;
        if (r122 == null) goto L27;
        r116 = r122.hashCode();
    L27:
        return r121 + r116;
    L22:
        r120 = 0;
        goto L23
    L18:
        r117 = 0;
        goto L19
    }

    public final String toString() {
        return "SenseConfig(silenceEnable=" + this.silenceEnable + ", silenceThreshold=" + this.silenceThreshold + ", multiProcessEnable=" + this.multiProcessEnable + ", foregroundUseBroadcast=" + this.foregroundUseBroadcast + ", canUseRunningAppProcesses=" + this.canUseRunningAppProcesses + ", backgroundTolerableDuration=" + this.backgroundTolerableDuration + ", strictBackgroundScene=" + this.strictBackgroundScene + ", coldLaunchScene=" + this.coldLaunchScene + ", hotLaunchScene=" + this.hotLaunchScene + ")";
    }

    public final long b() {
        return this.backgroundTolerableDuration;
    }

    public final boolean c() {
        return this.canUseRunningAppProcesses;
    }

    public final boolean d() {
        return this.foregroundUseBroadcast;
    }

    public final boolean e() {
        return this.multiProcessEnable;
    }

    public final boolean f() {
        return this.silenceEnable;
    }

    public final long g() {
        return this.silenceThreshold;
    }

    public static c a(c r110, boolean r111) {
        return new c(r111, r110.silenceThreshold, r110.multiProcessEnable, r110.foregroundUseBroadcast, r110.canUseRunningAppProcesses, r110.backgroundTolerableDuration, r110.strictBackgroundScene, r110.coldLaunchScene, r110.hotLaunchScene);
    }

    public c(boolean r100, long r101, boolean r102, boolean r103, boolean r104, long r105, e r106, a r110, b r111) {
        this.silenceEnable = r100;
        this.silenceThreshold = r101;
        this.multiProcessEnable = r102;
        this.foregroundUseBroadcast = r103;
        this.canUseRunningAppProcesses = r104;
        this.backgroundTolerableDuration = r105;
        this.strictBackgroundScene = r106;
        this.coldLaunchScene = r110;
        this.hotLaunchScene = r111;
    }
}
