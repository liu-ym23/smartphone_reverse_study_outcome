package hm7;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lhm7/f;", "", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "taskGlobalId", "Ljava/lang/String;", "getTaskGlobalId", "()Ljava/lang/String;", "", "timerTaskProgress", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "timerTaskToken", "c", "luckydog-task_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("task_global_id")
    private final String taskGlobalId;

    @SerializedName("timer_task_progress")
    private final Integer timerTaskProgress;

    @SerializedName("task_token")
    private final String timerTaskToken;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L19:
        return true;
    L5:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (this.expireTime != r101.expireTime) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L18;
        if (Intrinsics.areEqual(this.taskGlobalId, r101.taskGlobalId) == false) goto L18;
        if (Intrinsics.areEqual(this.timerTaskProgress, r101.timerTaskProgress) == false) goto L18;
        if (Intrinsics.areEqual(this.timerTaskToken, r101.timerTaskToken) == false) goto L18;
    L9:
        r102 = false;
    L18:
        return false;
    }

    public final int hashCode() {
        long r100 = this.expireTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.taskGlobalId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Integer r106 = this.timerTaskProgress;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.timerTaskToken;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "TimerTaskCacheModel(expireTime=" + this.expireTime + ", taskGlobalId=" + this.taskGlobalId + ", timerTaskProgress=" + this.timerTaskProgress + ", timerTaskToken=" + this.timerTaskToken + ")";
    }

    public final long a() {
        return this.expireTime;
    }

    public final Integer b() {
        return this.timerTaskProgress;
    }

    public final String c() {
        return this.timerTaskToken;
    }

    public f(long r100, String r101, Integer r102, String r103) {
        this.expireTime = r100;
        this.taskGlobalId = r101;
        this.timerTaskProgress = r102;
        this.timerTaskToken = r103;
    }
}
