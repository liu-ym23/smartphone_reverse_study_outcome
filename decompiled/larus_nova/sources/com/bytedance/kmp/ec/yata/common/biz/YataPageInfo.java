package com.bytedance.kmp.ec.yata.common.biz;

import aa6.b;
import aa6.c;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.error.d;
import com.bytedance.kmp.ec.yata.common.platform.YataPlatformAtomicLong;
import com.bytedance.kmp.ec.yata.common.platform.h;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashSet;
import com.bytedance.kmp.ec.yata.store.core.l;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b0\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007J\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u0012\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R(\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b#\u0010$\u0012\u0004\b)\u0010\u0012\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R&\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u0010,\u0012\u0004\b/\u0010\u0012\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/kmp/ec/yata/common/platform/YataJavaSerializable;", "", "getLocalProtocolNumber", "", "", "", "addAndGetYataProtocolInfo", "Lcom/bytedance/kmp/ec/yata/common/biz/a;", "addAndGetYataProtocolInfoModel", "", "useFrontier", "Z", "getUseFrontier", "()Z", "disableCompress", "getDisableCompress$annotations", "()V", "initialYataSession", "Ljava/lang/String;", "getInitialYataSession", "()Ljava/lang/String;", "Lcom/bytedance/kmp/ec/yata/common/biz/YataStoreWrapper;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/kmp/ec/yata/common/biz/YataStoreWrapper;", "getStoreWrapper", "()Lcom/bytedance/kmp/ec/yata/common/biz/YataStoreWrapper;", "setStoreWrapper", "(Lcom/bytedance/kmp/ec/yata/common/biz/YataStoreWrapper;)V", "getStoreWrapper$annotations", "storeWrapper", "Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformAtomicLong;", "localProtocolNumber", "Lcom/bytedance/kmp/ec/yata/common/platform/YataPlatformAtomicLong;", "lastQueryOrUplinkProtocolTime", "J", "getLastQueryOrUplinkProtocolTime", "()J", "setLastQueryOrUplinkProtocolTime", "(J)V", "getLastQueryOrUplinkProtocolTime$annotations", "Lcom/bytedance/kmp/ec/yata/common/utils/YataConcurrentHashSet;", "nodeDataChangedSet", "Lcom/bytedance/kmp/ec/yata/common/utils/YataConcurrentHashSet;", "getNodeDataChangedSet", "()Lcom/bytedance/kmp/ec/yata/common/utils/YataConcurrentHashSet;", "getNodeDataChangedSet$annotations", "<init>", "(ZZLjava/lang/String;)V", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
public final class YataPageInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient YataStoreWrapper f251339a;
    private final boolean disableCompress;
    private final String initialYataSession;
    private long lastQueryOrUplinkProtocolTime;
    private final YataPlatformAtomicLong localProtocolNumber;
    private final YataConcurrentHashSet<String> nodeDataChangedSet;
    private final boolean useFrontier;

    public YataPageInfo() {
        this(false, false, null, 7, null);
    }

    public static /* synthetic */ void getLastQueryOrUplinkProtocolTime$annotations() {
    }

    public static /* synthetic */ void getNodeDataChangedSet$annotations() {
    }

    @Deprecated(message = "SDK内部API")
    public static /* synthetic */ void getStoreWrapper$annotations() {
    }

    public final a addAndGetYataProtocolInfoModel() {
        this.localProtocolNumber.addAndGet(1);
        boolean r100 = this.disableCompress;
        YataStoreWrapper r101 = this.f251339a;
        b r102 = null;
        if (r101 == null) goto L43;
        l r103 = r101.r();
        if (r103 == null) goto L43;
        b r104 = r103.a();
        if (r104 == null) goto L43;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Map<?, ?> r105 = c.b(r104);
        if (r105 == null) goto L12;
        Object r106 = r105.get(VideoTools.ERROR_TYPE_COMPRESS);
    L14:
        if ((r106 instanceof Boolean) == false) goto L16;
        Boolean r107 = (Boolean) r106;
    L17:
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Map<?, ?> r108 = c.b(r104);
        if (r108 == null) goto L20;
        Object r109 = r108.get("origin_query_params");
    L22:
        if ((r109 instanceof String) == false) goto L24;
        String r110 = (String) r109;
    L25:
        if (r110 != null) goto L27;
    L30:
        boolean r111 = true;
    L31:
        if (r111 == false) goto L33;
    L35:
        boolean r112 = false;
    L36:
        if (r112 == r100) goto L42;
        YataStoreWrapper r113 = this.f251339a;
        if (r113 == null) goto L42;
        YataErrorManager r114 = r113.f();
        if (r114 == null) goto L42;
        int r115 = com.bytedance.kmp.ec.yata.common.error.c.f251397a;
        d r116 = new d(2209, "EVENT_UPLINK_DISABLE_COMPRESS_ERROR");
        r116.e();
        r116.c("switch_value_not_same");
        r116.d("disable_compress开关配置客户端和服务端不一致");
        r114.c(r116);
    L42:
        r100 = r112;
        goto L43
    L33:
        if (Intrinsics.areEqual(r107, Boolean.FALSE) == false) goto L35;
        r112 = true;
        goto L36
    L27:
        if (StringsKt.isBlank(r110) == true) goto L30;
        r111 = false;
        goto L31
    L24:
        r110 = null;
        goto L25
    L20:
        r109 = null;
        goto L22
    L16:
        r107 = null;
        goto L17
    L12:
        r106 = null;
    L43:
        Map r117 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enable_frontier", Boolean.valueOf(this.useFrontier)), TuplesKt.to("disable_compress", Boolean.valueOf(r100)), TuplesKt.to("yata_session_id", this.initialYataSession), TuplesKt.to("protocol_id", this.initialYataSession + '#' + this.localProtocolNumber.get())});
        LinkedHashMap r118 = new LinkedHashMap();
        YataStoreWrapper r119 = this.f251339a;
        if (r119 == null) goto L48;
        l r120 = r119.r();
        if (r120 == null) goto L48;
        r102 = r120.a();
    L48:
        String r121 = "EMPTY";
        String r122 = "";
        if (r102 != null) goto L51;
        r118.put("base_protocol_id", "");
        r118.put("change_node_list", "EMPTY");
    L60:
        r117.put("protocol_extra", r118);
        return new a(r117, r100);
    L51:
        String r123 = c.a(r102);
        if (r123 == null) goto L55;
        r122 = r123;
    L55:
        r118.put("base_protocol_id", r122);
        Set<String> r124 = this.nodeDataChangedSet.toSet();
        if (r124.isEmpty() == true) goto L59;
        r121 = CollectionsKt.joinToString$default(r124, ",", null, null, 0, null, null, 62, null);
    L59:
        r118.put("change_node_list", r121);
        goto L60
    }

    public final long getLocalProtocolNumber() {
        return this.localProtocolNumber.get();
    }

    @Deprecated(message = "废弃，统一使用addAndGetYataProtocolInfoModel()", replaceWith = @ReplaceWith(expression = "addAndGetYataProtocolInfoModel().map", imports = {}))
    public final Map<String, Object> addAndGetYataProtocolInfo() {
        return addAndGetYataProtocolInfoModel().f251358a;
    }

    public final String getInitialYataSession() {
        return this.initialYataSession;
    }

    public final long getLastQueryOrUplinkProtocolTime() {
        return this.lastQueryOrUplinkProtocolTime;
    }

    public final YataConcurrentHashSet<String> getNodeDataChangedSet() {
        return this.nodeDataChangedSet;
    }

    public final YataStoreWrapper getStoreWrapper() {
        return this.f251339a;
    }

    public final boolean getUseFrontier() {
        return this.useFrontier;
    }

    public final void setLastQueryOrUplinkProtocolTime(long r100) {
        this.lastQueryOrUplinkProtocolTime = r100;
    }

    public final void setStoreWrapper(YataStoreWrapper r100) {
        this.f251339a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public YataPageInfo(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "initialYataSession");
        this.useFrontier = r100;
        this.disableCompress = r101;
        this.initialYataSession = r102;
        this.localProtocolNumber = new YataPlatformAtomicLong(1);
        int r103 = h.f251540a;
        this.lastQueryOrUplinkProtocolTime = System.currentTimeMillis();
        Set r104 = null;
        this.nodeDataChangedSet = new YataConcurrentHashSet(r104, 1, 0 == true ? 1 : 0);
    }

    public YataPageInfo(boolean r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        int r105 = h.f251540a;
        r102 = UUID.randomUUID().toString();
    L11:
        this(r100, r101, r102);
    }
}
