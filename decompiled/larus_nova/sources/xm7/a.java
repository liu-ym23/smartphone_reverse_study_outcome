package xm7;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0016"}, d2 = {"Lxm7/a;", "", "", "targetTsEachCount", "I", "b", "()I", "", "", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "timerRules", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "timerScenes", "e", "timerSceneRules", "d", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<String> actions;

    @SerializedName("target_ts_each_count")
    private final int targetTsEachCount;

    @SerializedName("timer_rules")
    private final Map<String, List<String>> timerRules;

    @SerializedName("timer_scene_rules")
    private final Map<String, List<String>> timerSceneRules;

    @SerializedName("timer_scenes")
    private final List<String> timerScenes;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L21:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L20;
        a r101 = (a) r100;
        if (this.targetTsEachCount != r101.targetTsEachCount) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L20;
        if (Intrinsics.areEqual(this.actions, r101.actions) == false) goto L20;
        if (Intrinsics.areEqual(this.timerRules, r101.timerRules) == false) goto L20;
        if (Intrinsics.areEqual(this.timerScenes, r101.timerScenes) == false) goto L20;
        if (Intrinsics.areEqual(this.timerSceneRules, r101.timerSceneRules) == false) goto L20;
    L9:
        r102 = false;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.targetTsEachCount * 31;
        List<String> r101 = this.actions;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, List<String>> r105 = this.timerRules;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        List<String> r108 = this.timerScenes;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, List<String>> r111 = this.timerSceneRules;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CountTimerConfig(targetTsEachCount=" + this.targetTsEachCount + ", actions=" + this.actions + ", timerRules=" + this.timerRules + ", timerScenes=" + this.timerScenes + ", timerSceneRules=" + this.timerSceneRules + ")";
    }

    public final List<String> a() {
        return this.actions;
    }

    public final int b() {
        return this.targetTsEachCount;
    }

    public final Map<String, List<String>> c() {
        return this.timerRules;
    }

    public final Map<String, List<String>> d() {
        return this.timerSceneRules;
    }

    public final List<String> e() {
        return this.timerScenes;
    }
}
