package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J²\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\"\u0010\u0014R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b#\u0010\u0014¨\u00067"}, d2 = {"Lcom/larus/platform/model/ImageInstantUploadConfig;", "", "enabled", "", "enableSdkChain", "enableFallbackRegister", "preQueryPath", "", "bizSceneWhiteList", "", "uploadSceneBlackList", "uploadSourceSceneBlackList", "policyFamilyWhiteList", "maxOriginHashFileSize", "", "failOpen", "enableLog", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableSdkChain", "getEnableFallbackRegister", "getPreQueryPath", "()Ljava/lang/String;", "getBizSceneWhiteList", "()Ljava/util/List;", "getUploadSceneBlackList", "getUploadSourceSceneBlackList", "getPolicyFamilyWhiteList", "getMaxOriginHashFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFailOpen", "getEnableLog", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/platform/model/ImageInstantUploadConfig;", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f486782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f486783b = null;

    @SerializedName("biz_scene_whitelist")
    private final List<String> bizSceneWhiteList;

    @SerializedName("enable_fallback_register")
    private final Boolean enableFallbackRegister;

    @SerializedName("enable_log")
    private final Boolean enableLog;

    @SerializedName("enable_sdk_chain")
    private final Boolean enableSdkChain;

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("fail_open")
    private final Boolean failOpen;

    @SerializedName("max_origin_hash_file_size")
    private final Long maxOriginHashFileSize;

    @SerializedName("policy_family_whitelist")
    private final List<String> policyFamilyWhiteList;

    @SerializedName("pre_query_path")
    private final String preQueryPath;

    @SerializedName("upload_scene_blacklist")
    private final List<String> uploadSceneBlackList;

    @SerializedName("upload_source_scene_blacklist")
    private final List<String> uploadSourceSceneBlackList;

    public static final class a {
    }

    public u1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r101 = (u1) r100;
        if (Intrinsics.areEqual(this.enabled, r101.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableSdkChain, r101.enableSdkChain) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableFallbackRegister, r101.enableFallbackRegister) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preQueryPath, r101.preQueryPath) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizSceneWhiteList, r101.bizSceneWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.uploadSceneBlackList, r101.uploadSceneBlackList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.uploadSourceSceneBlackList, r101.uploadSourceSceneBlackList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.policyFamilyWhiteList, r101.policyFamilyWhiteList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxOriginHashFileSize, r101.maxOriginHashFileSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.failOpen, r101.failOpen) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enableLog, r101.enableLog) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enabled;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enableSdkChain;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enableFallbackRegister;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.preQueryPath;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.bizSceneWhiteList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.uploadSceneBlackList;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.uploadSourceSceneBlackList;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<String> r122 = this.policyFamilyWhiteList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.maxOriginHashFileSize;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.failOpen;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.enableLog;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "ImageInstantUploadConfig(enabled=" + this.enabled + ", enableSdkChain=" + this.enableSdkChain + ", enableFallbackRegister=" + this.enableFallbackRegister + ", preQueryPath=" + this.preQueryPath + ", bizSceneWhiteList=" + this.bizSceneWhiteList + ", uploadSceneBlackList=" + this.uploadSceneBlackList + ", uploadSourceSceneBlackList=" + this.uploadSourceSceneBlackList + ", policyFamilyWhiteList=" + this.policyFamilyWhiteList + ", maxOriginHashFileSize=" + this.maxOriginHashFileSize + ", failOpen=" + this.failOpen + ", enableLog=" + this.enableLog + ')';
    }

    static {
        f486782a = CollectionsKt.listOf("CHAT_ATTACHMENT_VIDEO");
        f486783b = CollectionsKt.listOf(new String[]{"shoot", "shoot_ocr"});
    }

    public final List<String> a() {
        return this.bizSceneWhiteList;
    }

    public final Boolean b() {
        return this.enableFallbackRegister;
    }

    public final Boolean c() {
        return this.enableLog;
    }

    public final Boolean d() {
        return this.enableSdkChain;
    }

    public final Boolean e() {
        return this.enabled;
    }

    public final Boolean f() {
        return this.failOpen;
    }

    public final Long g() {
        return this.maxOriginHashFileSize;
    }

    public final List<String> h() {
        return this.policyFamilyWhiteList;
    }

    public final String i() {
        return this.preQueryPath;
    }

    public final List<String> j() {
        return this.uploadSceneBlackList;
    }

    public final List<String> k() {
        return this.uploadSourceSceneBlackList;
    }

    public u1(Object r100) {
        Boolean r101 = Boolean.FALSE;
        List<String> r102 = CollectionsKt.emptyList();
        List<String> r103 = f486782a;
        List<String> r104 = f486783b;
        List<String> r105 = CollectionsKt.emptyList();
        Boolean r106 = Boolean.TRUE;
        this.enabled = r101;
        this.enableSdkChain = r101;
        this.enableFallbackRegister = r101;
        this.preQueryPath = "/alice/resource/pre_check_fast_upload";
        this.bizSceneWhiteList = r102;
        this.uploadSceneBlackList = r103;
        this.uploadSourceSceneBlackList = r104;
        this.policyFamilyWhiteList = r105;
        this.maxOriginHashFileSize = 52428800L;
        this.failOpen = r106;
        this.enableLog = r101;
    }
}
