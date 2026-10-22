package qt9;

import com.google.gson.annotations.SerializedName;
import com.vivo.push.PushClientConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0099\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\rHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001bR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016¨\u00065"}, d2 = {"Lcom/larus/settings/provider/MethodConfig;", "", "methodId", "", PushClientConstants.TAG_CLASS_NAME, "methodName", "methodSign", "machineCode", "isCaller", "", "unconditionalGuard", "enableDynamicHook", "guardType", "", "modifyArgs", "", "Lcom/larus/settings/provider/ModifyArg;", "returnType", "returnValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getMethodId", "()Ljava/lang/String;", "getClassName", "getMethodName", "getMethodSign", "getMachineCode", "()Z", "getUnconditionalGuard", "getEnableDynamicHook", "getGuardType", "()I", "getModifyArgs", "()Ljava/util/List;", "getReturnType", "getReturnValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h3 {

    @SerializedName("class_name")
    private final String className;

    @SerializedName("enable_dynamic_hook")
    private final boolean enableDynamicHook;

    @SerializedName("guard_type")
    private final int guardType;

    @SerializedName("is_caller")
    private final boolean isCaller;

    @SerializedName("machine_code")
    private final String machineCode;

    @SerializedName("method_id")
    private final String methodId;

    @SerializedName("method_name")
    private final String methodName;

    @SerializedName("method_sign")
    private final String methodSign;

    @SerializedName("modify_args")
    private final List<i3> modifyArgs;

    @SerializedName("return_type")
    private final String returnType;

    @SerializedName("return_value")
    private final String returnValue;

    @SerializedName("unconditional_guard")
    private final boolean unconditionalGuard;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h3) == true) goto L8;
        return false;
    L8:
        h3 r101 = (h3) r100;
        if (Intrinsics.areEqual(this.methodId, r101.methodId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.className, r101.className) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.methodName, r101.methodName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.methodSign, r101.methodSign) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.machineCode, r101.machineCode) == true) goto L24;
        return false;
    L24:
        if (this.isCaller == r101.isCaller) goto L27;
        return false;
    L27:
        if (this.unconditionalGuard == r101.unconditionalGuard) goto L30;
        return false;
    L30:
        if (this.enableDynamicHook == r101.enableDynamicHook) goto L33;
        return false;
    L33:
        if (this.guardType == r101.guardType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.modifyArgs, r101.modifyArgs) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.returnType, r101.returnType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.returnValue, r101.returnValue) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.methodId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.className;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.methodName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.methodSign;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.machineCode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.isCaller == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.unconditionalGuard == false) goto L29;
        int r119 = 1231;
    L30:
        int r120 = (r118 + r119) * 31;
        if (this.enableDynamicHook == true) goto L34;
        r116 = 1237;
    L34:
        int r121 = (((r120 + r116) * 31) + this.guardType) * 31;
        List<i3> r122 = this.modifyArgs;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        String r125 = this.returnType;
        if (r125 != null) goto L41;
        int r126 = 0;
    L42:
        int r127 = (r124 + r126) * 31;
        String r128 = this.returnValue;
        if (r128 == null) goto L47;
        r101 = r128.hashCode();
    L47:
        return r127 + r101;
    L41:
        r126 = r125.hashCode();
        goto L42
    L37:
        r123 = r122.hashCode();
        goto L38
    L29:
        r119 = 1237;
        goto L30
    L25:
        r117 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MethodConfig(methodId=" + this.methodId + ", className=" + this.className + ", methodName=" + this.methodName + ", methodSign=" + this.methodSign + ", machineCode=" + this.machineCode + ", isCaller=" + this.isCaller + ", unconditionalGuard=" + this.unconditionalGuard + ", enableDynamicHook=" + this.enableDynamicHook + ", guardType=" + this.guardType + ", modifyArgs=" + this.modifyArgs + ", returnType=" + this.returnType + ", returnValue=" + this.returnValue + ')';
    }

    public h3() {
        List<i3> r100 = CollectionsKt.emptyList();
        this.methodId = "-1";
        this.className = "";
        this.methodName = "";
        this.methodSign = "";
        this.machineCode = "";
        this.isCaller = false;
        this.unconditionalGuard = true;
        this.enableDynamicHook = true;
        this.guardType = 0;
        this.modifyArgs = r100;
        this.returnType = "null";
        this.returnValue = "";
    }
}
