package com.bytedance.ies.argus.bean.config;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem;", "", "Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$Mode;", "mode", "Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$Mode;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$Mode;", "Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$RuleType;", "ruleType", "Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$RuleType;", "c", "()Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$RuleType;", "", "", "patterns", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$ContentType;", "verifyContentType", "d", "ContentType", "Mode", "RuleType", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class ContentVerifyRuleItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f246013a;

    @SerializedName("mode")
    private final Mode mode;

    @SerializedName("patterns")
    private final List<String> patterns;

    @SerializedName("type")
    private final RuleType ruleType;

    @SerializedName("contentType")
    private final List<ContentType> verifyContentType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$ContentType;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "RESPONSE", "URL_PAGE", "URL_REQ", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ContentType extends Enum<ContentType> {

        @SerializedName("response")
        public static final ContentType RESPONSE = null;

        @SerializedName("url_page")
        public static final ContentType URL_PAGE = null;

        @SerializedName("url_req")
        public static final ContentType URL_REQ = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentType[] f246014a = null;
        private final String strValue;

        public static ContentType valueOf(String r100) {
            return (ContentType) r27.a.a(ContentType.class, r100);
        }

        public static ContentType[] values() {
            return (ContentType[]) f246014a.clone();
        }

        static {
            ContentType r100 = new ContentType("RESPONSE", 0, "response");
            RESPONSE = r100;
            ContentType r101 = new ContentType("URL_PAGE", 1, "url_page");
            URL_PAGE = r101;
            ContentType r102 = new ContentType("URL_REQ", 2, "url_req");
            URL_REQ = r102;
            f246014a = new ContentType[]{r100, r101, r102};
        }

        public final String getStrValue() {
            return this.strValue;
        }

        public ContentType(String r100, int r101, String r102) {
            super(r100, r101);
            this.strValue = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$Mode;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "BLOCK", "WARN", OpenNetMethod.REPORT, "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Mode extends Enum<Mode> {

        @SerializedName("block")
        public static final Mode BLOCK = null;

        @SerializedName("report")
        public static final Mode REPORT = null;

        @SerializedName("warn")
        public static final Mode WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f246015a = null;
        private final String strValue;

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public static Mode[] values() {
            return (Mode[]) f246015a.clone();
        }

        static {
            Mode r100 = new Mode("BLOCK", 0, "block");
            BLOCK = r100;
            Mode r101 = new Mode("WARN", 1, "warn");
            WARN = r101;
            Mode r102 = new Mode(OpenNetMethod.REPORT, 2, "report");
            REPORT = r102;
            f246015a = new Mode[]{r100, r101, r102};
        }

        public final String getStrValue() {
            return this.strValue;
        }

        public Mode(String r100, int r101, String r102) {
            super(r100, r101);
            this.strValue = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/bean/config/ContentVerifyRuleItem$RuleType;", "", "REG", "STR", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum RuleType extends Enum<RuleType> {

        @SerializedName("reg")
        public static final RuleType REG = null;

        @SerializedName("str")
        public static final RuleType STR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RuleType[] f246016a = null;

        public static RuleType valueOf(String r100) {
            return (RuleType) r27.a.a(RuleType.class, r100);
        }

        public static RuleType[] values() {
            return (RuleType[]) f246016a.clone();
        }

        static {
            RuleType r100 = new RuleType("REG", 0);
            REG = r100;
            RuleType r101 = new RuleType("STR", 1);
            STR = r101;
            f246016a = new RuleType[]{r100, r101};
        }

        public RuleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContentVerifyRuleItem) == true) goto L8;
        return false;
    L8:
        ContentVerifyRuleItem r101 = (ContentVerifyRuleItem) r100;
        if (this.mode == r101.mode) goto L12;
        return false;
    L12:
        if (this.ruleType == r101.ruleType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.patterns, r101.patterns) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.verifyContentType, r101.verifyContentType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Mode r100 = this.mode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        RuleType r104 = this.ruleType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.patterns;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<ContentType> r110 = this.verifyContentType;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ContentVerifyRuleItem(mode=" + this.mode + ", ruleType=" + this.ruleType + ", patterns=" + this.patterns + ", verifyContentType=" + this.verifyContentType + ')';
    }

    public ContentVerifyRuleItem() {
        this.mode = null;
        this.ruleType = null;
        this.patterns = null;
        this.verifyContentType = null;
        this.f246013a = LazyKt.lazy(new ContentVerifyRuleItem$compiledRegPatterns$2(this));
    }

    public final Mode a() {
        return this.mode;
    }

    public final List<String> b() {
        return this.patterns;
    }

    public final RuleType c() {
        return this.ruleType;
    }

    public final List<ContentType> d() {
        return this.verifyContentType;
    }
}
