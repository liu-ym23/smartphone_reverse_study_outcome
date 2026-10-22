package com.bytedance.helios.api.consumer;

import android.util.Pair;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b6\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0018\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010:\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0017\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010\fHÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\fHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003JÈ\u0001\u0010E\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010'\"\u0004\b(\u0010)R&\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018¨\u0006L"}, d2 = {"Lcom/bytedance/helios/api/consumer/ControlExtra;", "", "parameters", "", "returnType", "", "interceptResult", "Landroid/util/Pair;", "", "apiInfo", "controlConfig", "eventRuleNames", "", "hitControlConfigs", "ruleModels", "isFromSysCalls", "result", "thisOrClass", "extra", "", "([Ljava/lang/Object;Ljava/lang/String;Landroid/util/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;ZLjava/lang/Object;Ljava/lang/Object;Ljava/util/Map;)V", "getApiInfo", "()Ljava/lang/Object;", "setApiInfo", "(Ljava/lang/Object;)V", "getControlConfig", "setControlConfig", "getEventRuleNames", "()Ljava/util/Set;", "setEventRuleNames", "(Ljava/util/Set;)V", "getExtra", "()Ljava/util/Map;", "getHitControlConfigs", "setHitControlConfigs", "getInterceptResult", "()Landroid/util/Pair;", "setInterceptResult", "(Landroid/util/Pair;)V", "()Z", "setFromSysCalls", "(Z)V", "getParameters", "()[Ljava/lang/Object;", "setParameters", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getResult", "setResult", "getReturnType", "()Ljava/lang/String;", "setReturnType", "(Ljava/lang/String;)V", "getRuleModels", "setRuleModels", "getThisOrClass", "setThisOrClass", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "([Ljava/lang/Object;Ljava/lang/String;Landroid/util/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;ZLjava/lang/Object;Ljava/lang/Object;Ljava/util/Map;)Lcom/bytedance/helios/api/consumer/ControlExtra;", "equals", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 1, 16})
public final class ControlExtra {
    private Object apiInfo;
    private Object controlConfig;
    private Set<String> eventRuleNames;
    private final transient Map<String, Object> extra;
    private Set<Object> hitControlConfigs;
    private Pair<Boolean, Object> interceptResult;
    private boolean isFromSysCalls;
    private transient Object[] parameters;
    private transient Object result;
    private String returnType;
    private Set<Object> ruleModels;
    private transient Object thisOrClass;

    public ControlExtra() {
        this(null, null, null, null, null, null, null, null, false, null, null, null, UnixStat.PERM_MASK, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ControlExtra copy$default(ControlExtra r110, Object[] r111, String r112, Pair r113, Object r114, Object r115, Set r116, Set r210, Set r211, boolean r212, Object r213, Object r214, Map r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        Object[] r100 = r110.parameters;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.returnType;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Pair r102 = r110.interceptResult;
    L15:
        if ((r216 & 8) == 0) goto L17;
        Object r103 = r110.apiInfo;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Object r104 = r110.controlConfig;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Set r105 = r110.eventRuleNames;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Set r106 = r110.hitControlConfigs;
    L31:
        if ((r216 & 128) == 0) goto L33;
        Set r107 = r110.ruleModels;
    L35:
        if ((r216 & 256) == 0) goto L37;
        boolean r117 = r110.isFromSysCalls;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Object r118 = r110.result;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        Object r119 = r110.thisOrClass;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r108 = r110.extra;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Object[] component1() {
        return this.parameters;
    }

    public final Object component10() {
        return this.result;
    }

    public final Object component11() {
        return this.thisOrClass;
    }

    public final Map<String, Object> component12() {
        return this.extra;
    }

    public final String component2() {
        return this.returnType;
    }

    public final Pair<Boolean, Object> component3() {
        return this.interceptResult;
    }

    public final Object component4() {
        return this.apiInfo;
    }

    public final Object component5() {
        return this.controlConfig;
    }

    public final Set<String> component6() {
        return this.eventRuleNames;
    }

    public final Set<Object> component7() {
        return this.hitControlConfigs;
    }

    public final Set<Object> component8() {
        return this.ruleModels;
    }

    public final boolean component9() {
        return this.isFromSysCalls;
    }

    public final ControlExtra copy(Object[] r110, String r111, Pair<Boolean, Object> r112, Object r113, Object r114, Set<String> r210, Set<Object> r211, Set<Object> r212, boolean r213, Object r214, Object r215, Map<String, Object> r216) {
        return new ControlExtra(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ControlExtra) == false) goto L30;
        ControlExtra r101 = (ControlExtra) r100;
        if (Intrinsics.areEqual(this.parameters, r101.parameters) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.returnType, r101.returnType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.interceptResult, r101.interceptResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.apiInfo, r101.apiInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.controlConfig, r101.controlConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.eventRuleNames, r101.eventRuleNames) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hitControlConfigs, r101.hitControlConfigs) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ruleModels, r101.ruleModels) == true) goto L22;
        return false;
    L22:
        if (this.isFromSysCalls == r101.isFromSysCalls) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.result, r101.result) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.thisOrClass, r101.thisOrClass) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v40 */
    public int hashCode() {
        Object[] r100 = this.parameters;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        String r104 = this.returnType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Pair<Boolean, Object> r107 = this.interceptResult;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.apiInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Object r113 = this.controlConfig;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Set<String> r116 = this.eventRuleNames;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Set<Object> r119 = this.hitControlConfigs;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Set<Object> r122 = this.ruleModels;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.isFromSysCalls;
        ?? r126 = r125;
        if (r125 == false) goto L37;
        r126 = 1;
    L37:
        int r127 = (r124 + r126) * 31;
        Object r128 = this.result;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        Object r131 = this.thisOrClass;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        Map<String, Object> r134 = this.extra;
        if (r134 == null) goto L49;
        r101 = r134.hashCode();
    L49:
        return r133 + r101;
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ControlExtra(parameters=" + Arrays.toString(this.parameters) + ", returnType=" + this.returnType + ", interceptResult=" + this.interceptResult + ", apiInfo=" + this.apiInfo + ", controlConfig=" + this.controlConfig + ", eventRuleNames=" + this.eventRuleNames + ", hitControlConfigs=" + this.hitControlConfigs + ", ruleModels=" + this.ruleModels + ", isFromSysCalls=" + this.isFromSysCalls + ", result=" + this.result + ", thisOrClass=" + this.thisOrClass + ", extra=" + this.extra + ")";
    }

    public final Object getApiInfo() {
        return this.apiInfo;
    }

    public final Object getControlConfig() {
        return this.controlConfig;
    }

    public final Set<String> getEventRuleNames() {
        return this.eventRuleNames;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final Set<Object> getHitControlConfigs() {
        return this.hitControlConfigs;
    }

    public final Pair<Boolean, Object> getInterceptResult() {
        return this.interceptResult;
    }

    public final Object[] getParameters() {
        return this.parameters;
    }

    public final Object getResult() {
        return this.result;
    }

    public final String getReturnType() {
        return this.returnType;
    }

    public final Set<Object> getRuleModels() {
        return this.ruleModels;
    }

    public final Object getThisOrClass() {
        return this.thisOrClass;
    }

    public final boolean isFromSysCalls() {
        return this.isFromSysCalls;
    }

    public final void setApiInfo(Object r100) {
        this.apiInfo = r100;
    }

    public final void setControlConfig(Object r100) {
        this.controlConfig = r100;
    }

    public final void setEventRuleNames(Set<String> r100) {
        this.eventRuleNames = r100;
    }

    public final void setFromSysCalls(boolean r100) {
        this.isFromSysCalls = r100;
    }

    public final void setHitControlConfigs(Set<Object> r100) {
        this.hitControlConfigs = r100;
    }

    public final void setInterceptResult(Pair<Boolean, Object> r100) {
        this.interceptResult = r100;
    }

    public final void setParameters(Object[] r100) {
        this.parameters = r100;
    }

    public final void setResult(Object r100) {
        this.result = r100;
    }

    public final void setReturnType(String r100) {
        this.returnType = r100;
    }

    public final void setRuleModels(Set<Object> r100) {
        this.ruleModels = r100;
    }

    public final void setThisOrClass(Object r100) {
        this.thisOrClass = r100;
    }

    public ControlExtra(Object[] r100, String r101, Pair<Boolean, Object> r102, Object r103, Object r104, Set<String> r105, Set<Object> r106, Set<Object> r107, boolean r108, Object r110, Object r111, Map<String, Object> r112) {
        this.parameters = r100;
        this.returnType = r101;
        this.interceptResult = r102;
        this.apiInfo = r103;
        this.controlConfig = r104;
        this.eventRuleNames = r105;
        this.hitControlConfigs = r106;
        this.ruleModels = r107;
        this.isFromSysCalls = r108;
        this.result = r110;
        this.thisOrClass = r111;
        this.extra = r112;
    }

    public /* synthetic */ ControlExtra(Object[] r110, String r111, Pair r112, Object r113, Object r114, Set r115, Set r210, Set r211, boolean r212, Object r213, Object r214, Map r215, int r216, DefaultConstructorMarker r217) {
        Object r100 = null;
        if ((r216 & 1) == 0) goto L5;
        Object[] r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        Pair r103 = new Pair(Boolean.FALSE, null);
    L15:
        if ((r216 & 8) == 0) goto L17;
        Object r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        Object r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Set r106 = new LinkedHashSet();
    L27:
        if ((r216 & 64) == 0) goto L29;
        Set r107 = new LinkedHashSet();
    L31:
        if ((r216 & 128) == 0) goto L33;
        Set r108 = new LinkedHashSet();
    L35:
        if ((r216 & 256) == 0) goto L37;
        boolean r116 = false;
    L39:
        if ((r216 & 512) == 0) goto L41;
        Object r117 = null;
    L43:
        if ((r216 & 1024) != 0) goto L47;
        r100 = r214;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Map r109 = new LinkedHashMap();
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r100, r109);
        return;
    L49:
        r109 = r215;
        goto L50
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
}
