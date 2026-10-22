package com.larus.im.internal.jni.bean;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.dypay.api.DyPayConstant;
import de9.a9;
import de9.z8;
import java.util.List;
import java.util.Map;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.a1;
import nuc.b2;
import nuc.f;
import nuc.g1;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 I2\u00060\u0001j\u0002`\u0002:\u0002HIB¯\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0016\u0010\u0017B§\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0016\u0010\u001cJ\t\u0010,\u001a\u00020\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\u0017\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0010HÆ\u0003J\t\u00108\u001a\u00020\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J±\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010;\u001a\u00020\u00102\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u0019HÖ\u0001J\t\u0010?\u001a\u00020\u0006HÖ\u0001J%\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00002\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0001¢\u0006\u0002\bGR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001eR\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001eR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001eR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001eR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001eR$\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u001eR\u0016\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001eR\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u001eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b+\u0010\u001e¨\u0006J"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageQueryRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "containerIdType", "", "containerId", "", "direction", DyPayConstant.KEY_START_TIME, "endTime", "queryTypeFilter", "", "pageToken", "pageSize", "sortDimension", "sortDesc", "", "ext", "", "useCache", "domainPageSize", "domainPageToken", "<init>", "(JLjava/lang/String;JJJLjava/util/List;Ljava/lang/String;JJZLjava/util/Map;ZJLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;JJJLjava/util/List;Ljava/lang/String;JJZLjava/util/Map;ZJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContainerIdType$annotations", "()V", "getContainerId$annotations", "getDirection$annotations", "getStartTime$annotations", "getEndTime$annotations", "getQueryTypeFilter$annotations", "getPageToken$annotations", "getPageSize$annotations", "getSortDimension$annotations", "getSortDesc$annotations", "getExt$annotations", "getUseCache$annotations", "getDomainPageSize$annotations", "getDomainPageToken$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniMessageQueryRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final String containerId;
    public final long containerIdType;
    public final long direction;
    public final long domainPageSize;
    public final String domainPageToken;
    public final long endTime;
    public final Map<String, String> ext;
    public final long pageSize;
    public final String pageToken;
    public final List<Long> queryTypeFilter;
    public final boolean sortDesc;
    public final long sortDimension;
    public final long startTime;
    public final boolean useCache;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniMessageQueryRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniMessageQueryRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniMessageQueryRequest> serializer() {
            return OmniMessageQueryRequest$$serializer.INSTANCE;
        }
    }

    public OmniMessageQueryRequest() {
        this(0, null, 0, 0, 0, null, null, 0, 0, false, null, false, 0, null, 16383, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(g1.f520681a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniMessageQueryRequest copy$default(OmniMessageQueryRequest r110, long r111, String r112, long r210, long r211, long r212, List r213, String r214, long r215, long r310, boolean r311, Map r312, boolean r313, long r314, String r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        long r100 = r110.containerIdType;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.containerId;
    L11:
        if ((r316 & 4) == 0) goto L13;
        long r102 = r110.direction;
    L15:
        if ((r316 & 8) == 0) goto L17;
        long r103 = r110.startTime;
    L19:
        if ((r316 & 16) == 0) goto L21;
        long r104 = r110.endTime;
    L23:
        if ((r316 & 32) == 0) goto L25;
        List r113 = r110.queryTypeFilter;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r114 = r110.pageToken;
    L31:
        if ((r316 & 128) == 0) goto L33;
        long r115 = r110.pageSize;
    L34:
        long r216 = r115;
        if ((r316 & 256) == 0) goto L37;
        long r116 = r110.sortDimension;
    L39:
        if ((r316 & 512) == 0) goto L41;
        boolean r117 = r110.sortDesc;
    L42:
        boolean r318 = r117;
        if ((r316 & 1024) == 0) goto L45;
        Map r118 = r110.ext;
    L46:
        Map r319 = r118;
        if ((r316 & 2048) == 0) goto L49;
        boolean r119 = r110.useCache;
    L50:
        boolean r320 = r119;
        long r321 = r116;
        if ((r316 & 4096) == 0) goto L53;
        long r120 = r110.domainPageSize;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r105 = r110.domainPageToken;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r216, r321, r318, r319, r320, r120, r105);
    L57:
        r105 = r315;
        goto L59
    L53:
        r120 = r314;
        goto L55
    L49:
        r119 = r313;
        goto L50
    L45:
        r118 = r312;
        goto L46
    L41:
        r117 = r311;
        goto L42
    L37:
        r116 = r310;
        goto L39
    L33:
        r115 = r215;
        goto L34
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("container_id")
    public static /* synthetic */ void getContainerId$annotations() {
    }

    @SerialName("container_id_type")
    public static /* synthetic */ void getContainerIdType$annotations() {
    }

    @SerialName("direction")
    public static /* synthetic */ void getDirection$annotations() {
    }

    @SerialName("domain_page_size")
    public static /* synthetic */ void getDomainPageSize$annotations() {
    }

    @SerialName("domain_page_token")
    public static /* synthetic */ void getDomainPageToken$annotations() {
    }

    @SerialName("end_time")
    public static /* synthetic */ void getEndTime$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("page_size")
    public static /* synthetic */ void getPageSize$annotations() {
    }

    @SerialName("page_token")
    public static /* synthetic */ void getPageToken$annotations() {
    }

    @SerialName("query_type_filter")
    public static /* synthetic */ void getQueryTypeFilter$annotations() {
    }

    @SerialName("sort_desc")
    public static /* synthetic */ void getSortDesc$annotations() {
    }

    @SerialName("sort_dimension")
    public static /* synthetic */ void getSortDimension$annotations() {
    }

    @SerialName(ILoadStallMonitor.START_TIME)
    public static /* synthetic */ void getStartTime$annotations() {
    }

    @SerialName("use_cache")
    public static /* synthetic */ void getUseCache$annotations() {
    }

    public final long component1() {
        return this.containerIdType;
    }

    public final boolean component10() {
        return this.sortDesc;
    }

    public final Map<String, String> component11() {
        return this.ext;
    }

    public final boolean component12() {
        return this.useCache;
    }

    public final long component13() {
        return this.domainPageSize;
    }

    public final String component14() {
        return this.domainPageToken;
    }

    public final String component2() {
        return this.containerId;
    }

    public final long component3() {
        return this.direction;
    }

    public final long component4() {
        return this.startTime;
    }

    public final long component5() {
        return this.endTime;
    }

    public final List<Long> component6() {
        return this.queryTypeFilter;
    }

    public final String component7() {
        return this.pageToken;
    }

    public final long component8() {
        return this.pageSize;
    }

    public final long component9() {
        return this.sortDimension;
    }

    public final OmniMessageQueryRequest copy(long r210, String r211, long r212, long r213, long r310, List<Long> r311, String r312, long r313, long r314, boolean r315, Map<String, String> r410, boolean r411, long r412, String r413) {
        return new OmniMessageQueryRequest(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r410, r411, r412, r413);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniMessageQueryRequest) == true) goto L8;
        return false;
    L8:
        OmniMessageQueryRequest r101 = (OmniMessageQueryRequest) r100;
        if (this.containerIdType == r101.containerIdType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.containerId, r101.containerId) == true) goto L15;
        return false;
    L15:
        if (this.direction == r101.direction) goto L18;
        return false;
    L18:
        if (this.startTime == r101.startTime) goto L21;
        return false;
    L21:
        if (this.endTime == r101.endTime) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.queryTypeFilter, r101.queryTypeFilter) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pageToken, r101.pageToken) == true) goto L30;
        return false;
    L30:
        if (this.pageSize == r101.pageSize) goto L33;
        return false;
    L33:
        if (this.sortDimension == r101.sortDimension) goto L36;
        return false;
    L36:
        if (this.sortDesc == r101.sortDesc) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L42;
        return false;
    L42:
        if (this.useCache == r101.useCache) goto L45;
        return false;
    L45:
        if (this.domainPageSize == r101.domainPageSize) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.domainPageToken, r101.domainPageToken) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        long r100 = this.containerIdType;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.containerId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        long r105 = this.direction;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.startTime;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.endTime;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        List<Long> r111 = this.queryTypeFilter;
        if (r111 != null) goto L9;
        int r112 = 0;
    L10:
        int r113 = (r110 + r112) * 31;
        String r114 = this.pageToken;
        if (r114 != null) goto L13;
        int r115 = 0;
    L14:
        long r116 = this.pageSize;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.sortDimension;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        int r120 = 1231;
        if (this.sortDesc == false) goto L17;
        int r121 = 1231;
    L18:
        int r122 = (r119 + r121) * 31;
        Map<String, String> r123 = this.ext;
        if (r123 != null) goto L21;
        int r124 = 0;
    L22:
        int r125 = (r122 + r124) * 31;
        if (this.useCache == true) goto L26;
        r120 = 1237;
    L26:
        int r126 = (r125 + r120) * 31;
        long r127 = this.domainPageSize;
        int r128 = (r126 + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        String r129 = this.domainPageToken;
        if (r129 == null) goto L31;
        r103 = r129.hashCode();
    L31:
        return r128 + r103;
    L21:
        r124 = r123.hashCode();
        goto L22
    L17:
        r121 = 1237;
        goto L18
    L13:
        r115 = r114.hashCode();
        goto L14
    L9:
        r112 = r111.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniMessageQueryRequest(containerIdType=" + this.containerIdType + ", containerId=" + this.containerId + ", direction=" + this.direction + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", queryTypeFilter=" + this.queryTypeFilter + ", pageToken=" + this.pageToken + ", pageSize=" + this.pageSize + ", sortDimension=" + this.sortDimension + ", sortDesc=" + this.sortDesc + ", ext=" + this.ext + ", useCache=" + this.useCache + ", domainPageSize=" + this.domainPageSize + ", domainPageToken=" + this.domainPageToken + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(r100, new z8()), null, null, null, null, LazyKt.lazy(r100, new a9()), null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniMessageQueryRequest r100, muc.d r110, luc.f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeLongElement(r111, 0, r100.containerIdType);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.containerId);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeLongElement(r111, 2, r100.direction);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeLongElement(r111, 3, r100.startTime);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeLongElement(r111, 4, r100.endTime);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        boolean r108 = true;
    L54:
        if (r108 == false) goto L57;
        r110.encodeNullableSerializableElement(r111, 5, r101[5].getValue(), r100.queryTypeFilter);
    L57:
        if (r110.shouldEncodeElementDefault(r111, 6) == false) goto L60;
    L58:
        boolean r109 = true;
    L63:
        if (r109 == false) goto L66;
        r110.encodeNullableSerializableElement(r111, 6, v2.f520790a, r100.pageToken);
    L66:
        if (r110.shouldEncodeElementDefault(r111, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r110.encodeLongElement(r111, 7, r100.pageSize);
    L75:
        if (r110.shouldEncodeElementDefault(r111, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r110.encodeLongElement(r111, 8, r100.sortDimension);
    L84:
        if (r110.shouldEncodeElementDefault(r111, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r110.encodeBooleanElement(r111, 9, r100.sortDesc);
    L93:
        if (r110.shouldEncodeElementDefault(r111, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r110.encodeNullableSerializableElement(r111, 10, r101[10].getValue(), r100.ext);
    L102:
        if (r110.shouldEncodeElementDefault(r111, 11) == false) goto L105;
    L103:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r110.encodeBooleanElement(r111, 11, r100.useCache);
    L111:
        if (r110.shouldEncodeElementDefault(r111, 12) == false) goto L114;
    L112:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r110.encodeLongElement(r111, 12, r100.domainPageSize);
    L120:
        if (r110.shouldEncodeElementDefault(r111, 13) == false) goto L123;
    L121:
        r102 = true;
    L125:
        if (r102 == false) goto L128;
        r110.encodeNullableSerializableElement(r111, 13, v2.f520790a, r100.domainPageToken);
        return;
    L128:
        return;
    L123:
        if (r100.domainPageToken == null) goto L125;
    L114:
        if (r100.domainPageSize != 0) goto L112;
        r117 = false;
        goto L117
    L105:
        if (r100.useCache == true) goto L103;
        r116 = false;
        goto L108
    L96:
        if (r100.ext != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.sortDesc == true) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.sortDimension != 0) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.pageSize != 0) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.pageToken != null) goto L58;
        r109 = false;
        goto L63
    L51:
        if (r100.queryTypeFilter != null) goto L49;
        r108 = false;
        goto L54
    L42:
        if (r100.endTime != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.startTime != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.direction != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.containerId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.containerIdType != 0) goto L4;
        r103 = false;
        goto L9
    }

    public OmniMessageQueryRequest(long r100, String r101, long r102, long r103, long r110, List<Long> r111, String r112, long r113, long r114, boolean r115, Map<String, String> r210, boolean r211, long r212, String r213) {
        this.containerIdType = r100;
        this.containerId = r101;
        this.direction = r102;
        this.startTime = r103;
        this.endTime = r110;
        this.queryTypeFilter = r111;
        this.pageToken = r112;
        this.pageSize = r113;
        this.sortDimension = r114;
        this.sortDesc = r115;
        this.ext = r210;
        this.useCache = r211;
        this.domainPageSize = r212;
        this.domainPageToken = r213;
    }

    public /* synthetic */ OmniMessageQueryRequest(int r110, long r111, String r112, long r113, long r114, long r115, List r210, String r211, long r212, long r213, boolean r214, Map r215, boolean r216, long r217, String r310, q2 r311) {
        if ((r110 & 0) == 0) goto L5;
        b2.b(r110, 0, OmniMessageQueryRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        this.containerIdType = 0;
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.containerId = null;
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.direction = 0;
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.startTime = 0;
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.endTime = 0;
    L25:
        if ((r110 & 32) != 0) goto L27;
        this.queryTypeFilter = null;
    L29:
        if ((r110 & 64) != 0) goto L31;
        this.pageToken = null;
    L33:
        if ((r110 & 128) != 0) goto L35;
        this.pageSize = 0;
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.sortDimension = 0;
    L41:
        if ((r110 & 512) != 0) goto L43;
        this.sortDesc = false;
    L45:
        if ((r110 & 1024) != 0) goto L47;
        this.ext = null;
    L49:
        if ((r110 & 2048) != 0) goto L51;
        this.useCache = false;
    L53:
        if ((r110 & 4096) != 0) goto L55;
        this.domainPageSize = 0;
    L57:
        if ((r110 & 8192) != 0) goto L59;
        this.domainPageToken = null;
        return;
    L59:
        this.domainPageToken = r310;
        return;
    L55:
        this.domainPageSize = r217;
        goto L57
    L51:
        this.useCache = r216;
        goto L53
    L47:
        this.ext = r215;
        goto L49
    L43:
        this.sortDesc = r214;
        goto L45
    L39:
        this.sortDimension = r213;
        goto L41
    L35:
        this.pageSize = r212;
        goto L37
    L31:
        this.pageToken = r211;
        goto L33
    L27:
        this.queryTypeFilter = r210;
        goto L29
    L23:
        this.endTime = r115;
        goto L25
    L19:
        this.startTime = r114;
        goto L21
    L15:
        this.direction = r113;
        goto L17
    L11:
        this.containerId = r112;
        goto L13
    L7:
        this.containerIdType = r111;
        goto L9
    }

    public /* synthetic */ OmniMessageQueryRequest(long r210, String r211, long r212, long r213, long r214, List r310, String r311, long r312, long r313, boolean r314, Map r315, boolean r316, long r410, String r411, int r412, DefaultConstructorMarker r413) {
        if ((r412 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r412 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r412 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r412 & 8) == 0) goto L17;
        long r103 = 0;
    L19:
        if ((r412 & 16) == 0) goto L21;
        long r110 = 0;
    L23:
        if ((r412 & 32) == 0) goto L25;
        List r111 = null;
    L27:
        if ((r412 & 64) == 0) goto L29;
        String r112 = null;
    L31:
        if ((r412 & 128) == 0) goto L33;
        long r113 = 0;
    L35:
        if ((r412 & 256) == 0) goto L37;
        long r104 = 0;
    L38:
        boolean r114 = false;
        if ((r412 & 512) == 0) goto L41;
        boolean r105 = false;
    L42:
        boolean r414 = r105;
        if ((r412 & 1024) == 0) goto L45;
        Map r106 = null;
    L46:
        Map r215 = r106;
        if ((r412 & 2048) != 0) goto L51;
        r114 = r316;
    L51:
        if ((r412 & 4096) == 0) goto L53;
        long r115 = 0;
    L55:
        if ((r412 & 8192) == 0) goto L57;
        String r107 = null;
    L58:
        this(r100, r101, r102, r103, r110, r111, r112, r113, r104, r414, r215, r114, r115, r107);
        return;
    L57:
        r107 = r411;
        goto L58
    L53:
        r115 = r410;
        goto L55
    L45:
        r106 = r315;
        goto L46
    L41:
        r105 = r314;
        goto L42
    L37:
        r104 = r313;
        goto L38
    L33:
        r113 = r312;
        goto L35
    L29:
        r112 = r311;
        goto L31
    L25:
        r111 = r310;
        goto L27
    L21:
        r110 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
