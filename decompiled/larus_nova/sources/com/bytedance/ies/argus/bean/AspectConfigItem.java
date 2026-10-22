package com.bytedance.ies.argus.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\n\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem;", "", "", "switch", "I", "c", "()I", "", "async", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "", "Lcom/bytedance/ies/argus/bean/AspectConfigItem$a;", "rawRules", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "StrategyRuleType", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AspectConfigItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f245982a;

    @SerializedName("async")
    private final Boolean async;

    @SerializedName("rules")
    private final Map<String, a> rawRules;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f102switch;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem$StrategyRuleType;", "", "", "str", "Ljava/lang/String;", "getStr", "()Ljava/lang/String;", "CLIENT", "TTM", "UNSET", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum StrategyRuleType extends Enum<StrategyRuleType> {
        public static final StrategyRuleType CLIENT = null;
        public static final StrategyRuleType TTM = null;
        public static final StrategyRuleType UNSET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StrategyRuleType[] f245983a = null;
        private final String str;

        public static StrategyRuleType valueOf(String r100) {
            return (StrategyRuleType) r27.a.a(StrategyRuleType.class, r100);
        }

        public static StrategyRuleType[] values() {
            return (StrategyRuleType[]) f245983a.clone();
        }

        static {
            StrategyRuleType r100 = new StrategyRuleType("CLIENT", 0, "client");
            CLIENT = r100;
            StrategyRuleType r101 = new StrategyRuleType("TTM", 1, "ttm");
            TTM = r101;
            StrategyRuleType r102 = new StrategyRuleType("UNSET", 2, "unset");
            UNSET = r102;
            f245983a = new StrategyRuleType[]{r100, r101, r102};
        }

        public final String getStr() {
            return this.str;
        }

        public StrategyRuleType(String r100, int r101, String r102) {
            super(r100, r101);
            this.str = r102;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/bean/AspectConfigItem$a;", "", "", "version", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "switch", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "f", "(Ljava/lang/Integer;)V", "index", "I", "b", "()I", "ruleType", "c", "", "async", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "report", "getReport", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f245984a;

        @SerializedName("async")
        private final boolean async;

        @SerializedName("index")
        private final int index;

        @SerializedName("report")
        private final boolean report;

        @SerializedName("type")
        private final String ruleType;

        /* JADX INFO: renamed from: switch, reason: not valid java name */
        @SerializedName("switch")
        private Integer f103switch;

        @SerializedName("version")
        private final String version;

        public a() {
            String r100 = StrategyRuleType.UNSET.getStr();
            this.version = null;
            this.f103switch = null;
            this.index = 0;
            this.ruleType = r100;
            this.async = false;
            this.report = false;
        }

        public final boolean a() {
            return this.async;
        }

        public final int b() {
            return this.index;
        }

        public final String c() {
            return this.ruleType;
        }

        public final Integer d() {
            return this.f103switch;
        }

        public final String e() {
            return this.version;
        }

        public final void f(Integer r100) {
            this.f103switch = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AspectConfigItem) == true) goto L8;
        return false;
    L8:
        AspectConfigItem r101 = (AspectConfigItem) r100;
        if (this.f102switch == r101.f102switch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.async, r101.async) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rawRules, r101.rawRules) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f102switch * 31;
        Boolean r101 = this.async;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, a> r105 = this.rawRules;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AspectConfigItem(switch=" + this.f102switch + ", async=" + this.async + ", rawRules=" + this.rawRules + ')';
    }

    public AspectConfigItem() {
        this.f102switch = 2;
        this.async = null;
        this.rawRules = null;
        this.f245982a = CollectionsKt.emptyList();
    }

    public final Boolean a() {
        return this.async;
    }

    public final Map<String, a> b() {
        return this.rawRules;
    }

    public final int c() {
        return this.f102switch;
    }
}
