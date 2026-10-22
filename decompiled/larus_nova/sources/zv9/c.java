package zv9;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00120\b\u0002\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\bHÆ\u0003J1\u00105\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\fHÆ\u0003J\u0013\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0003J½\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b20\b\u0002\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e2\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000eHÆ\u0001J\u0013\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\bHÖ\u0001J\t\u0010>\u001a\u00020\u000bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RF\u0010\t\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nj\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R(\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R(\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)¨\u0006?"}, d2 = {"Lcom/larus/settings/provider/security/AppOpsConfig;", "", "enable", "", "blackListMode", "needStack", "useNewTag", "maxCacheSize", "", "mockApi2Op", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "serviceBlackSet", "", "serviceClassBlackSet", "serviceWhiteSet", "serviceClassWhiteSet", "<init>", "(ZZZZILjava/util/HashMap;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getBlackListMode", "setBlackListMode", "getNeedStack", "setNeedStack", "getUseNewTag", "setUseNewTag", "getMaxCacheSize", "()I", "setMaxCacheSize", "(I)V", "getMockApi2Op", "()Ljava/util/HashMap;", "setMockApi2Op", "(Ljava/util/HashMap;)V", "getServiceBlackSet", "()Ljava/util/List;", "setServiceBlackSet", "(Ljava/util/List;)V", "getServiceClassBlackSet", "setServiceClassBlackSet", "getServiceWhiteSet", "setServiceWhiteSet", "getServiceClassWhiteSet", "setServiceClassWhiteSet", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("black_list_mode")
    private boolean blackListMode;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("max_cache_size")
    private int maxCacheSize;

    @SerializedName("mock_api_2_op")
    private HashMap<Integer, String> mockApi2Op;

    @SerializedName("need_stack")
    private boolean needStack;

    @SerializedName("service_black_set")
    private List<String> serviceBlackSet;

    @SerializedName("service_class_black_set")
    private List<String> serviceClassBlackSet;

    @SerializedName("service_class_white_set")
    private List<String> serviceClassWhiteSet;

    @SerializedName("service_white_set")
    private List<String> serviceWhiteSet;

    @SerializedName("use_new_tag")
    private boolean useNewTag;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.blackListMode == r101.blackListMode) goto L15;
        return false;
    L15:
        if (this.needStack == r101.needStack) goto L18;
        return false;
    L18:
        if (this.useNewTag == r101.useNewTag) goto L21;
        return false;
    L21:
        if (this.maxCacheSize == r101.maxCacheSize) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mockApi2Op, r101.mockApi2Op) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.serviceBlackSet, r101.serviceBlackSet) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.serviceClassBlackSet, r101.serviceClassBlackSet) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.serviceWhiteSet, r101.serviceWhiteSet) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.serviceClassWhiteSet, r101.serviceClassWhiteSet) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.blackListMode == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.needStack == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.useNewTag == true) goto L18;
        r100 = 1237;
    L18:
        int r107 = (((r106 + r100) * 31) + this.maxCacheSize) * 31;
        HashMap<Integer, String> r108 = this.mockApi2Op;
        int r109 = 0;
        if (r108 != null) goto L21;
        int r110 = 0;
    L22:
        int r111 = (r107 + r110) * 31;
        List<String> r112 = this.serviceBlackSet;
        if (r112 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r111 + r113) * 31;
        List<String> r115 = this.serviceClassBlackSet;
        if (r115 != null) goto L29;
        int r116 = 0;
    L30:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.serviceWhiteSet;
        if (r118 != null) goto L33;
        int r119 = 0;
    L34:
        int r120 = (r117 + r119) * 31;
        List<String> r121 = this.serviceClassWhiteSet;
        if (r121 == null) goto L39;
        r109 = r121.hashCode();
    L39:
        return r120 + r109;
    L33:
        r119 = r118.hashCode();
        goto L34
    L29:
        r116 = r115.hashCode();
        goto L30
    L25:
        r113 = r112.hashCode();
        goto L26
    L21:
        r110 = r108.hashCode();
        goto L22
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppOpsConfig(enable=" + this.enable + ", blackListMode=" + this.blackListMode + ", needStack=" + this.needStack + ", useNewTag=" + this.useNewTag + ", maxCacheSize=" + this.maxCacheSize + ", mockApi2Op=" + this.mockApi2Op + ", serviceBlackSet=" + this.serviceBlackSet + ", serviceClassBlackSet=" + this.serviceClassBlackSet + ", serviceWhiteSet=" + this.serviceWhiteSet + ", serviceClassWhiteSet=" + this.serviceClassWhiteSet + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxCacheSize;
    }

    public final HashMap<Integer, String> c() {
        return this.mockApi2Op;
    }

    public final boolean d() {
        return this.needStack;
    }

    public final List<String> e() {
        return this.serviceBlackSet;
    }

    public final List<String> f() {
        return this.serviceWhiteSet;
    }

    public c(Object r100) {
        HashMap<Integer, String> r101 = new HashMap();
        List<String> r102 = CollectionsKt.emptyList();
        List<String> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.emptyList();
        List<String> r105 = CollectionsKt.emptyList();
        this.enable = false;
        this.blackListMode = false;
        this.needStack = false;
        this.useNewTag = false;
        this.maxCacheSize = 50;
        this.mockApi2Op = r101;
        this.serviceBlackSet = r102;
        this.serviceClassBlackSet = r103;
        this.serviceWhiteSet = r104;
        this.serviceClassWhiteSet = r105;
    }
}
