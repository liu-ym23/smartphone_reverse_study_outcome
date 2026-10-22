package com.bytedance.lego.init.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.texturerender.TextureRenderKeys;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes20.dex */
public class InitTaskFullInfo implements Serializable, Comparable<InitTaskFullInfo> {

    @SerializedName("afterPrivacyPopupWindow")
    public boolean afterPrivacyPopupWindow;
    public transient List<String> child;
    public transient List<String> dependencies;

    @SerializedName("dependon")
    public String[] dependon;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("earliestPeriod")
    public InitPeriod earliestPeriod;

    @SerializedName("executePriority")
    public int executePriority;

    @SerializedName("latestPeriod")
    public InitPeriod latestPeriod;

    @SerializedName(TextureRenderKeys.KEY_MODULE_NAME)
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;
    public transient List<String> parent;
    public transient int priority;
    public transient float realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;

    @SerializedName("taskClassName")
    public String taskClassName;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + a(this.runInProcess) + "," + a(this.dependencies) + "," + a(this.child) + "," + a(this.parent);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.realPriority);
        r100.append(",");
        r100.append(this.taskId);
        r100.append(",");
        r100.append(this.mustRunInMainThread);
        r100.append(",[");
        InitPeriod r101 = this.earliestPeriod;
        if (r101 != null) goto L5;
        String r102 = InitPeriod.NONE.name();
    L6:
        r100.append(r102);
        r100.append(",");
        InitPeriod r103 = this.latestPeriod;
        if (r103 != null) goto L9;
        String r104 = InitPeriod.NONE.name();
    L10:
        r100.append(r104);
        r100.append("],");
        String[] r105 = this.dependon;
        if (r105 != null) goto L13;
    L20:
        String r106 = null;
    L21:
        r100.append(r106);
        r100.append(",");
        r100.append(a(this.runInProcess));
        r100.append(",");
        r100.append(this.moduleName);
        return r100.toString();
    L13:
        if (r105.length <= 0) goto L20;
        StringBuilder r107 = new StringBuilder("[");
        r107.append(r105[0]);
        int r108 = 1;
    L17:
        if (r108 >= r105.length) goto L19;
        r107.append("," + r105[r108]);
        r108 = r108 + 1;
        goto L17
    L19:
        r107.append("]");
        r106 = r107.toString();
        goto L21
    L9:
        r104 = r103.name();
        goto L10
    L5:
        r102 = r101.name();
        goto L6
    }

    public InitTaskFullInfo() {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
    }

    public static String a(List r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L15;
        StringBuilder r101 = new StringBuilder("[");
        r101.append((String) ListProtector.get(r100, 0));
        int r102 = 1;
    L8:
        if (r102 >= r100.size()) goto L10;
        r101.append("," + ((String) ListProtector.get(r100, r102)));
        r102 = r102 + 1;
        goto L8
    L10:
        r101.append("]");
        return r101.toString();
    L15:
        return null;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(InitTaskFullInfo r100) {
        float r101 = r100.realPriority - this.realPriority;
        if (r101 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r101 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.taskClassName.compareTo(r100.taskClassName);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(InitTaskFullInfo r100) {
        return compareTo2(r100);
    }

    public InitTaskFullInfo(String r100, Boolean r101, boolean r102, InitPeriod r103, InitPeriod r104, float r105, List<String> r106, List<String> r107, List<String> r110, List<String> r111, String r112) {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
        this.taskId = r100;
        this.mustRunInMainThread = r101.booleanValue();
        this.earliestPeriod = r103;
        this.latestPeriod = r104;
        this.realPriority = r105;
        this.runInProcess = r106;
        this.child = r107;
        this.parent = r110;
        this.dependencies = r111;
        this.taskClassName = r112;
        this.afterPrivacyPopupWindow = r102;
    }
}
