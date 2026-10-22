package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/taskmanager/a;", "", "", LocationMonitorConst.IDENTIFIER, "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "", "expiredTime", "J", "b", "()J", "Ltk7/a;", "actionTaskModel", "Ltk7/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ltk7/a;", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("action_model")
    private final tk7.a actionTaskModel;

    @SerializedName("expired_time")
    private final long expiredTime;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private final String identifier;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == false) goto L16;
        if (this.expiredTime != r101.expiredTime) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        if (Intrinsics.areEqual(this.actionTaskModel, r101.actionTaskModel) == false) goto L16;
    L11:
        r102 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.identifier;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.expiredTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        tk7.a r105 = this.actionTaskModel;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CacheTaskModel(identifier=" + this.identifier + ", expiredTime=" + this.expiredTime + ", actionTaskModel=" + this.actionTaskModel + ")";
    }

    public final tk7.a a() {
        return this.actionTaskModel;
    }

    public final long b() {
        return this.expiredTime;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public a(String r100, long r101, tk7.a r102) {
        this.identifier = r100;
        this.expiredTime = r101;
        this.actionTaskModel = r102;
    }
}
