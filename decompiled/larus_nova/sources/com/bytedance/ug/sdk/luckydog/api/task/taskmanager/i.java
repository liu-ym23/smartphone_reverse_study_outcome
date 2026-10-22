package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/taskmanager/i;", "", "", "isEnable", "I", "c", "()I", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "gidList", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "Lcom/bytedance/ug/sdk/luckydog/api/task/taskmanager/h;", "eventConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class i {

    @SerializedName("event_config")
    private final ArrayList<h> eventConfig;

    @SerializedName("global_task_id_list")
    private final ArrayList<String> gidList;

    @SerializedName(MapMonitorConst.IS_ENABLE)
    private final int isEnable;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (this.isEnable != r101.isEnable) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L16;
        if (Intrinsics.areEqual(this.gidList, r101.gidList) == false) goto L16;
        if (Intrinsics.areEqual(this.eventConfig, r101.eventConfig) == false) goto L16;
    L9:
        r102 = false;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.isEnable * 31;
        ArrayList<String> r101 = this.gidList;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        ArrayList<h> r105 = this.eventConfig;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "TaskFullPathConfig(isEnable=" + this.isEnable + ", gidList=" + this.gidList + ", eventConfig=" + this.eventConfig + ")";
    }

    public final ArrayList<h> a() {
        return this.eventConfig;
    }

    public final ArrayList<String> b() {
        return this.gidList;
    }

    public final int c() {
        return this.isEnable;
    }
}
