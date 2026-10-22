package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006RP\u0010\u000b\u001a8\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u0007j \u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\n\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/task/taskmanager/h;", "", "", "eventName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "matchRule", "Ljava/util/HashMap;", "getMatchRule", "()Ljava/util/HashMap;", "associatedGlobalTaskId", "Ljava/util/ArrayList;", "getAssociatedGlobalTaskId", "()Ljava/util/ArrayList;", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class h {

    @SerializedName("associated_global_task_id")
    private final ArrayList<String> associatedGlobalTaskId;

    @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
    private final String eventName;

    @SerializedName("match_rules")
    private final HashMap<String, ArrayList<String>> matchRule;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.matchRule, r101.matchRule) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.associatedGlobalTaskId, r101.associatedGlobalTaskId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.eventName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashMap<String, ArrayList<String>> r104 = this.matchRule;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.associatedGlobalTaskId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SingleEventConfigModel(eventName=" + this.eventName + ", matchRule=" + this.matchRule + ", associatedGlobalTaskId=" + this.associatedGlobalTaskId + ")";
    }

    public final String a() {
        return this.eventName;
    }
}
