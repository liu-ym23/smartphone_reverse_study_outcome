package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00014BQ\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jc\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0012\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b%\u0010$R\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b&\u0010\u001fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010*R\u001d\u00100\u001a\u0004\u0018\u00010+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYPackageInfo;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "", "component1", "component2", "component3", "", "component4", "component5", "component6", "component7", "", "Lcom/bytedance/pitaya/api/bean/PTYModelInfo;", "component8", "name", "version", "deployment", "taskType", "from", "buildTime", "extraStr", "models", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "getVersion", "getDeployment", "I", "getTaskType", "()I", "getFrom", "getBuildTime", "getExtraStr", "Ljava/util/List;", "getModels", "()Ljava/util/List;", "Lorg/json/JSONObject;", "extra$delegate", "Lkotlin/Lazy;", "getExtra", "()Lorg/json/JSONObject;", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYPackageInfo implements ReflectionCall {
    public static final a Companion = null;
    public static final int PACKAGE_FROM_DEBUG = 0;
    public static final int PACKAGE_FROM_PRE_RELEASE = 1;
    public static final int PACKAGE_FROM_RELEASE = 2;
    public static final int PACKAGE_FROM_UNKNOWN = 3;
    public static final int TASK_TYPE_COUNT = 3;
    public static final int TASK_TYPE_MIN_PYTHON = 2;
    public static final int TASK_TYPE_PYTHON = 1;
    public static final int TASK_TYPE_RESOURCE = 0;
    private final String buildTime;
    private final String deployment;
    private final Lazy extra$delegate;
    private final String extraStr;
    private final int from;
    private final List<PTYModelInfo> models;
    private final String name;
    private final int taskType;
    private final String version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PTYPackageInfo copy$default(PTYPackageInfo r100, String r110, String r111, String r112, int r113, int r114, String r115, String r116, List r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.name;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.version;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.deployment;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.taskType;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.from;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.buildTime;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.extraStr;
    L31:
        if ((r118 & 128) == 0) goto L33;
        List r108 = r100.models;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.version;
    }

    public final String component3() {
        return this.deployment;
    }

    public final int component4() {
        return this.taskType;
    }

    public final int component5() {
        return this.from;
    }

    public final String component6() {
        return this.buildTime;
    }

    public final String component7() {
        return this.extraStr;
    }

    public final List<PTYModelInfo> component8() {
        return this.models;
    }

    public final PTYPackageInfo copy(String r110, String r111, String r112, int r113, int r114, String r115, String r116, List<PTYModelInfo> r117) {
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r111, "version");
        Intrinsics.checkNotNullParameter(r112, "deployment");
        Intrinsics.checkNotNullParameter(r115, "buildTime");
        return new PTYPackageInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYPackageInfo) == true) goto L8;
        return false;
    L8:
        PTYPackageInfo r101 = (PTYPackageInfo) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.deployment, r101.deployment) == true) goto L18;
        return false;
    L18:
        if (this.taskType == r101.taskType) goto L21;
        return false;
    L21:
        if (this.from == r101.from) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buildTime, r101.buildTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.extraStr, r101.extraStr) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.models, r101.models) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.name.hashCode() * 31) + this.version.hashCode()) * 31) + this.deployment.hashCode()) * 31) + this.taskType) * 31) + this.from) * 31) + this.buildTime.hashCode()) * 31;
        String r101 = this.extraStr;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        List<PTYModelInfo> r105 = this.models;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PTYPackageInfo(name=" + this.name + ", version=" + this.version + ", deployment=" + this.deployment + ", taskType=" + this.taskType + ", from=" + this.from + ", buildTime=" + this.buildTime + ", extraStr=" + this.extraStr + ", models=" + this.models + ')';
    }

    public final JSONObject getExtra() {
        return (JSONObject) this.extra$delegate.getValue();
    }

    public final String getBuildTime() {
        return this.buildTime;
    }

    public final String getDeployment() {
        return this.deployment;
    }

    public final String getExtraStr() {
        return this.extraStr;
    }

    public final int getFrom() {
        return this.from;
    }

    public final List<PTYModelInfo> getModels() {
        return this.models;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final String getVersion() {
        return this.version;
    }

    public PTYPackageInfo(String r100, String r101, String r102, int r103, int r104, String r105, String r106, List<PTYModelInfo> r107) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "deployment");
        Intrinsics.checkNotNullParameter(r105, "buildTime");
        this.name = r100;
        this.version = r101;
        this.deployment = r102;
        this.taskType = r103;
        this.from = r104;
        this.buildTime = r105;
        this.extraStr = r106;
        this.models = r107;
        this.extra$delegate = LazyKt.lazy(new PTYPackageInfo$extra$2(this));
    }
}
