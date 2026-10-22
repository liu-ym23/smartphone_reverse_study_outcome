package d93;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001:\u0003./0R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000e\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012¨\u00061"}, d2 = {"Ld93/f;", "", "", "version", "I", "getVersion", "()I", "setVersion", "(I)V", "type", "getType", "setType", "", "bizName", "Ljava/lang/String;", "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "ruleName", "getRuleName", "setRuleName", "Ld93/f$a;", "ruleV1", "Ld93/f$a;", "getRuleV1", "()Ld93/f$a;", "setRuleV1", "(Ld93/f$a;)V", "Ld93/f$b;", "ruleV2", "Ld93/f$b;", "getRuleV2", "()Ld93/f$b;", "setRuleV2", "(Ld93/f$b;)V", "Ld93/f$c;", "ruleV3", "Ld93/f$c;", "getRuleV3", "()Ld93/f$c;", "setRuleV3", "(Ld93/f$c;)V", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName(MapMonitorConst.BIZ_NAME)
    private String bizName;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("rule_name")
    private String ruleName;

    @SerializedName("rule_v1")
    private a ruleV1;

    @SerializedName("rule_v2")
    private b ruleV2;

    @SerializedName("rule_v3")
    private c ruleV3;

    @SerializedName("type")
    private int type;

    @SerializedName("version")
    private int version;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Ld93/f$a;", "", "", "triggerEvent", "Ljava/lang/String;", "getTriggerEvent", "()Ljava/lang/String;", "setTriggerEvent", "(Ljava/lang/String;)V", "triggerAction", "getTriggerAction", "setTriggerAction", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("trigger_action")
        private String triggerAction;

        @SerializedName("trigger_event")
        private String triggerEvent;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.triggerEvent, r101.triggerEvent) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.triggerAction, r101.triggerAction) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.triggerEvent;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.triggerAction;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "RuleV1(triggerEvent=" + this.triggerEvent + ", triggerAction=" + this.triggerAction + ")";
        }

        public a() {
            this.triggerEvent = null;
            this.triggerAction = null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ld93/f$b;", "", "Ld93/b;", "triggerEvent", "Ld93/b;", "getTriggerEvent", "()Ld93/b;", "setTriggerEvent", "(Ld93/b;)V", "Lc93/a;", "triggerAction", "Lc93/a;", "getTriggerAction", "()Lc93/a;", "setTriggerAction", "(Lc93/a;)V", "Lc93/b;", "scheduler", "Lc93/b;", "getScheduler", "()Lc93/b;", "setScheduler", "(Lc93/b;)V", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("scheduler")
        private c93.b scheduler;

        @SerializedName("trigger_action")
        private c93.a triggerAction;

        @SerializedName("trigger_event")
        private d93.b triggerEvent;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.triggerEvent, r101.triggerEvent) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.triggerAction, r101.triggerAction) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.scheduler, r101.scheduler) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            d93.b r100 = this.triggerEvent;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            c93.a r104 = this.triggerAction;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            c93.b r107 = this.scheduler;
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
            return "RuleV2(triggerEvent=" + this.triggerEvent + ", triggerAction=" + this.triggerAction + ", scheduler=" + this.scheduler + ")";
        }

        public b() {
            this.triggerEvent = null;
            this.triggerAction = null;
            this.scheduler = null;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR*\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Ld93/f$c;", "", "", "Ld93/b;", "eventDefine", "Ljava/util/List;", "getEventDefine", "()Ljava/util/List;", "setEventDefine", "(Ljava/util/List;)V", "Ld93/e;", "within", "Ld93/e;", "getWithin", "()Ld93/e;", "setWithin", "(Ld93/e;)V", "Lc93/a;", "decision", "Lc93/a;", "getDecision", "()Lc93/a;", "setDecision", "(Lc93/a;)V", "Lc93/b;", "scheduler", "Lc93/b;", "getScheduler", "()Lc93/b;", "setScheduler", "(Lc93/b;)V", "Ld93/a;", "decisionParamsPattern", "getDecisionParamsPattern", "setDecisionParamsPattern", "Ld93/d;", "eventPatternList", "getEventPatternList", "setEventPatternList", "", "instantMatch", "Z", "getInstantMatch", "()Z", "setInstantMatch", "(Z)V", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("decision")
        private c93.a decision;

        @SerializedName("decision_params_pattern")
        private List<d93.a> decisionParamsPattern;

        @SerializedName("event_define")
        private List<d93.b> eventDefine;

        @SerializedName("event_pattern_list")
        private List<d> eventPatternList;

        @SerializedName("instant_match")
        private boolean instantMatch;

        @SerializedName("scheduler")
        private c93.b scheduler;

        @SerializedName("within")
        private e within;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L20;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.eventDefine, r101.eventDefine) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.within, r101.within) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.decision, r101.decision) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.scheduler, r101.scheduler) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.decisionParamsPattern, r101.decisionParamsPattern) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.eventPatternList, r101.eventPatternList) == true) goto L18;
            return false;
        L18:
            if (this.instantMatch == r101.instantMatch) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            List<d93.b> r100 = this.eventDefine;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            e r104 = this.within;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            c93.a r107 = this.decision;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            c93.b r110 = this.scheduler;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            List<d93.a> r113 = this.decisionParamsPattern;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            List<d> r116 = this.eventPatternList;
            if (r116 == null) goto L25;
            r101 = r116.hashCode();
        L25:
            int r117 = (r115 + r101) * 31;
            boolean r118 = this.instantMatch;
            ?? r119 = r118;
            if (r118 == false) goto L29;
            r119 = 1;
        L29:
            return r117 + r119;
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

        public final String toString() {
            return "RuleV3(eventDefine=" + this.eventDefine + ", within=" + this.within + ", decision=" + this.decision + ", scheduler=" + this.scheduler + ", decisionParamsPattern=" + this.decisionParamsPattern + ", eventPatternList=" + this.eventPatternList + ", instantMatch=" + this.instantMatch + ")";
        }

        public c() {
            this.eventDefine = null;
            this.within = null;
            this.decision = null;
            this.scheduler = null;
            this.decisionParamsPattern = null;
            this.eventPatternList = null;
            this.instantMatch = true;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L22;
        f r101 = (f) r100;
        if (this.version == r101.version) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bizName, r101.bizName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ruleName, r101.ruleName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ruleV1, r101.ruleV1) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ruleV2, r101.ruleV2) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ruleV3, r101.ruleV3) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.version * 31) + this.type) * 31;
        String r101 = this.bizName;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.ruleName;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        a r108 = this.ruleV1;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        b r111 = this.ruleV2;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        c r114 = this.ruleV3;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.desc;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
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
        return "EventProcessRuleDsl(version=" + this.version + ", type=" + this.type + ", bizName=" + this.bizName + ", ruleName=" + this.ruleName + ", ruleV1=" + this.ruleV1 + ", ruleV2=" + this.ruleV2 + ", ruleV3=" + this.ruleV3 + ", desc=" + this.desc + ")";
    }

    public f() {
        this.version = 0;
        this.type = 0;
        this.bizName = null;
        this.ruleName = null;
        this.ruleV1 = null;
        this.ruleV2 = null;
        this.ruleV3 = null;
        this.desc = null;
    }

    public final int getType() {
        return this.type;
    }
}
