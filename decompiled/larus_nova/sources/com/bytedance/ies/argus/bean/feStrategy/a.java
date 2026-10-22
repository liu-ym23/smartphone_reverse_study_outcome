package com.bytedance.ies.argus.bean.feStrategy;

import com.bytedance.ies.argus.bean.ArgusSchemaParamRouteVerifyReason;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.f;
import com.bytedance.ies.argus.util.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0007\u000bR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/bean/feStrategy/a;", "", "", "", "Lcom/bytedance/ies/argus/bean/feStrategy/a$a;", "keyRules", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "Lcom/bytedance/ies/argus/bean/feStrategy/a$b;", "valueConf", "b", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("key_rules")
    private final Map<String, C3515a> keyRules;

    @SerializedName("value_conf")
    private final Map<String, b> valueConf;

    /* JADX INFO: renamed from: com.bytedance.ies.argus.bean.feStrategy.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/bean/feStrategy/a$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "reportOnly", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class C3515a {

        @SerializedName("report")
        private final Boolean reportOnly;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3515a) == true) goto L8;
            return false;
        L8:
            C3515a r101 = (C3515a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.reportOnly, r101.reportOnly) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.reportOnly;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "KeyRule(type=" + this.type + ", reportOnly=" + this.reportOnly + ')';
        }

        public C3515a() {
            this.type = null;
            this.reportOnly = null;
        }

        public final Boolean a() {
            return this.reportOnly;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/argus/bean/feStrategy/a$b;", "", "", "isInnerHost", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "", "", "whitePrefix", "Ljava/util/List;", "b", "()Ljava/util/List;", "whiteHost", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "whiteReg", "c", "blackPrefix", "getBlackPrefix", "blackHost", "getBlackHost", "blackReg", "getBlackReg", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f246023a;

        @SerializedName("black_host")
        private final List<String> blackHost;

        @SerializedName("black_prefix")
        private final List<String> blackPrefix;

        @SerializedName("black_reg")
        private final List<String> blackReg;

        @SerializedName("inner_host")
        private final Integer isInnerHost;

        @SerializedName("white_host")
        private final List<String> whiteHost;

        @SerializedName("white_prefix")
        private final List<String> whitePrefix;

        @SerializedName("white_reg")
        private final List<String> whiteReg;

        /* JADX INFO: renamed from: com.bytedance.ies.argus.bean.feStrategy.a$b$a, reason: collision with other inner class name */
        public static final class C3516a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f246024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArgusSchemaParamRouteVerifyReason f246025b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f246026c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3516a) == true) goto L8;
                return false;
            L8:
                C3516a r101 = (C3516a) r100;
                if (this.f246024a == r101.f246024a) goto L12;
                return false;
            L12:
                if (this.f246025b == r101.f246025b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f246026c, r101.f246026c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                if (this.f246024a == false) goto L5;
                int r100 = 1231;
            L6:
                int r101 = ((r100 * 31) + this.f246025b.hashCode()) * 31;
                String r102 = this.f246026c;
                if (r102 != null) goto L9;
                int r103 = 0;
            L11:
                return r101 + r103;
            L9:
                r103 = r102.hashCode();
                goto L11
            L5:
                r100 = 1237;
                goto L6
            }

            public final String toString() {
                return "ValueVerifyResult(block=" + this.f246024a + ", reasonCode=" + this.f246025b + ", reason=" + this.f246026c + ')';
            }

            public C3516a(boolean r100, ArgusSchemaParamRouteVerifyReason r101, String r102) {
                Intrinsics.checkNotNullParameter(r101, "reasonCode");
                this.f246024a = r100;
                this.f246025b = r101;
                this.f246026c = r102;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.isInnerHost, r101.isInnerHost) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.whitePrefix, r101.whitePrefix) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.whiteHost, r101.whiteHost) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.whiteReg, r101.whiteReg) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.blackPrefix, r101.blackPrefix) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.blackHost, r101.blackHost) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.blackReg, r101.blackReg) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.isInnerHost;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.whitePrefix;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.whiteHost;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            List<String> r110 = this.whiteReg;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            List<String> r113 = this.blackPrefix;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            List<String> r116 = this.blackHost;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            List<String> r119 = this.blackReg;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
        L25:
            r117 = r116.hashCode();
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
            return "TypeConfig(isInnerHost=" + this.isInnerHost + ", whitePrefix=" + this.whitePrefix + ", whiteHost=" + this.whiteHost + ", whiteReg=" + this.whiteReg + ", blackPrefix=" + this.blackPrefix + ", blackHost=" + this.blackHost + ", blackReg=" + this.blackReg + ')';
        }

        public b() {
            this.isInnerHost = null;
            this.whitePrefix = null;
            this.whiteHost = null;
            this.whiteReg = null;
            this.blackPrefix = null;
            this.blackHost = null;
            this.blackReg = null;
            this.f246023a = LazyKt.lazy(new ArgusFeSchemaVerifyConfig$TypeConfig$containWhiteList$2(this));
        }

        public final List<String> a() {
            return this.whiteHost;
        }

        public final List<String> b() {
            return this.whitePrefix;
        }

        public final List<String> c() {
            return this.whiteReg;
        }

        public final Integer d() {
            return this.isInnerHost;
        }

        public final C3516a e(String r110) {
            if (r110 == null) goto L5;
            List<String> r100 = this.blackPrefix;
            if (r100 == null) goto L16;
            Iterator<T> r101 = r100.iterator();
        L10:
            if (r101.hasNext() == false) goto L14;
            Object r102 = r101.next();
            if (StringsKt.startsWith$default(r110, (String) r102, false, 2, null) == false) goto L10;
        L15:
            String r103 = (String) r102;
        L18:
            if (r103 != null) goto L20;
            List<String> r104 = this.blackReg;
            if (r104 == null) goto L31;
            Iterator<T> r105 = r104.iterator();
        L25:
            if (r105.hasNext() == false) goto L29;
            Object r106 = r105.next();
            if (f.a(r110, (String) r106) == false) goto L25;
        L30:
            String r107 = (String) r106;
        L32:
            if (r107 != null) goto L34;
            Ref.ObjectRef r108 = new Ref.ObjectRef();
            Ref.BooleanRef r109 = new Ref.BooleanRef();
            List<String> r111 = this.blackHost;
            if (r111 != null) goto L38;
        L40:
            boolean r112 = false;
        L41:
            if (r112 == false) goto L49;
            String r113 = f(r109, r108, r110);
            if (r113 == null) goto L49;
            int r114 = CommonUtils.f246248a;
            String r115 = CommonUtils.j(r113, this.blackHost);
            if (r115 == null) goto L49;
            return new C3516a(true, ArgusSchemaParamRouteVerifyReason.FAILED_SCHEMA_PARAM_IN_BLACKLIST, "blackHost_".concat(r115));
        L49:
            if (((Boolean) this.f246023a.getValue()).booleanValue() == false) goto L105;
            Integer r116 = this.isInnerHost;
            if (r116 != null) goto L54;
        L61:
            List<String> r117 = this.whitePrefix;
            if (r117 == null) goto L71;
            Iterator<T> r118 = r117.iterator();
        L65:
            if (r118.hasNext() == false) goto L69;
            Object r119 = r118.next();
            if (StringsKt.startsWith$default(r110, (String) r119, false, 2, null) == false) goto L65;
        L70:
            String r120 = (String) r119;
        L72:
            if (r120 != null) goto L74;
            List<String> r121 = this.whiteHost;
            if (r121 != null) goto L78;
        L80:
            boolean r122 = false;
        L81:
            if (r122 == false) goto L88;
            String r123 = f(r109, r108, r110);
            if (r123 == null) goto L88;
            int r124 = CommonUtils.f246248a;
            String r125 = CommonUtils.j(r123, this.whiteHost);
            if (r125 == null) goto L88;
            return new C3516a(false, ArgusSchemaParamRouteVerifyReason.SUCCESS_IN_WHITE_LIST, "whiteHost_".concat(r125));
        L88:
            List<String> r126 = this.whiteReg;
            if (r126 == null) goto L98;
            Iterator<T> r127 = r126.iterator();
        L92:
            if (r127.hasNext() == false) goto L96;
            Object r128 = r127.next();
            if (f.a(r110, (String) r128) == false) goto L92;
        L97:
            String r129 = (String) r128;
        L99:
            if (r129 == null) goto L103;
            return new C3516a(false, ArgusSchemaParamRouteVerifyReason.SUCCESS_IN_WHITE_LIST, "whiteReg_".concat(r129));
        L103:
            return new C3516a(true, ArgusSchemaParamRouteVerifyReason.FAILED_NOT_IN_WHITE_LIST, null);
        L96:
            r128 = null;
            goto L97
        L98:
            r129 = null;
            goto L99
        L78:
            if ((!r121.isEmpty()) != true) goto L80;
            r122 = true;
            goto L81
        L74:
            return new C3516a(false, ArgusSchemaParamRouteVerifyReason.SUCCESS_IN_WHITE_LIST, "whitePrefix_".concat(r120));
        L69:
            r119 = null;
            goto L70
        L71:
            r120 = null;
            goto L72
        L54:
            if (r116.intValue() != 1) goto L61;
            String r130 = f(r109, r108, r110);
            if (r130 == null) goto L61;
            if (g.a(r130) == false) goto L61;
            return new C3516a(false, ArgusSchemaParamRouteVerifyReason.SUCCESS_IS_INNER_HOST, null);
        L105:
            return new C3516a(false, ArgusSchemaParamRouteVerifyReason.SUCCESS_PASS_ALL, null);
        L38:
            if ((!r111.isEmpty()) != true) goto L40;
            r112 = true;
            goto L41
        L34:
            return new C3516a(true, ArgusSchemaParamRouteVerifyReason.FAILED_SCHEMA_PARAM_IN_BLACKLIST, "blackReg_".concat(r107));
        L29:
            r106 = null;
            goto L30
        L31:
            r107 = null;
            goto L32
        L20:
            return new C3516a(true, ArgusSchemaParamRouteVerifyReason.FAILED_SCHEMA_PARAM_IN_BLACKLIST, "blackPrefix_".concat(r103));
        L14:
            r102 = null;
            goto L15
        L16:
            r103 = null;
            goto L18
        L5:
            return new C3516a(false, ArgusSchemaParamRouteVerifyReason.ABNORMAL_SCHEMA_PARAM, "value is null");
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
        public static final String f(Ref.BooleanRef r100, Ref.ObjectRef<String> r101, String r102) {
            if (r100.element == true) goto L8;
            if (r101.element != null) goto L8;
            r101.element = CommonUtils.d(r102);
            r100.element = true;
        L8:
            return r101.element;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.keyRules, r101.keyRules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.valueConf, r101.valueConf) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, C3515a> r100 = this.keyRules;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, b> r104 = this.valueConf;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ArgusFeSchemaVerifyConfig(keyRules=" + this.keyRules + ", valueConf=" + this.valueConf + ')';
    }

    public a() {
        this.keyRules = null;
        this.valueConf = null;
    }

    public final Map<String, C3515a> a() {
        return this.keyRules;
    }

    public final Map<String, b> b() {
        return this.valueConf;
    }
}
