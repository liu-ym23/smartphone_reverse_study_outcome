package com.larus.im.internal.jni.bean;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.y2;
import java.util.List;
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
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u0002/0BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBU\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0014¨\u00061"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJobListQuery;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "jobType", "", "status", "anchorCreateTime", "", "anchorJobId", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "jobTypes", "", "<init>", "(IIJLjava/lang/String;ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIJLjava/lang/String;ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getJobType$annotations", "()V", "getStatus$annotations", "getAnchorCreateTime$annotations", "getAnchorJobId$annotations", "getLimit$annotations", "getJobTypes$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniAIJobListQuery implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final long anchorCreateTime;
    public final String anchorJobId;
    public final int jobType;
    public final List<Integer> jobTypes;
    public final int limit;
    public final int status;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJobListQuery$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniAIJobListQuery;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniAIJobListQuery> serializer() {
            return OmniAIJobListQuery$$serializer.INSTANCE;
        }
    }

    public OmniAIJobListQuery() {
        this(0, 0, 0, null, 0, null, 63, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(w0.f520792a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniAIJobListQuery copy$default(OmniAIJobListQuery r100, int r101, int r102, long r103, String r110, int r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.jobType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.status;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.anchorCreateTime;
    L11:
        long r104 = r103;
        if ((r113 & 8) == 0) goto L14;
        r110 = r100.anchorJobId;
    L14:
        String r105 = r110;
        if ((r113 & 16) == 0) goto L17;
        r111 = r100.limit;
    L17:
        int r106 = r111;
        if ((r113 & 32) == 0) goto L20;
        r112 = r100.jobTypes;
    L20:
        int r107 = r101;
        return r100.copy(r107, r115, r104, r105, r106, r112);
    }

    @SerialName("anchor_create_time")
    public static /* synthetic */ void getAnchorCreateTime$annotations() {
    }

    @SerialName("anchor_job_id")
    public static /* synthetic */ void getAnchorJobId$annotations() {
    }

    @SerialName("job_type")
    public static /* synthetic */ void getJobType$annotations() {
    }

    @SerialName("job_types")
    public static /* synthetic */ void getJobTypes$annotations() {
    }

    @SerialName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    public static /* synthetic */ void getLimit$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    public final int component1() {
        return this.jobType;
    }

    public final int component2() {
        return this.status;
    }

    public final long component3() {
        return this.anchorCreateTime;
    }

    public final String component4() {
        return this.anchorJobId;
    }

    public final int component5() {
        return this.limit;
    }

    public final List<Integer> component6() {
        return this.jobTypes;
    }

    public final OmniAIJobListQuery copy(int r110, int r111, long r112, String r113, int r114, List<Integer> r115) {
        return new OmniAIJobListQuery(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAIJobListQuery) == true) goto L8;
        return false;
    L8:
        OmniAIJobListQuery r101 = (OmniAIJobListQuery) r100;
        if (this.jobType == r101.jobType) goto L12;
        return false;
    L12:
        if (this.status == r101.status) goto L15;
        return false;
    L15:
        if (this.anchorCreateTime == r101.anchorCreateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.anchorJobId, r101.anchorJobId) == true) goto L21;
        return false;
    L21:
        if (this.limit == r101.limit) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.jobTypes, r101.jobTypes) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.jobType * 31) + this.status) * 31;
        long r101 = this.anchorCreateTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.anchorJobId;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((r102 + r105) * 31) + this.limit) * 31;
        List<Integer> r107 = this.jobTypes;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return r106 + r104;
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniAIJobListQuery(jobType=" + this.jobType + ", status=" + this.status + ", anchorCreateTime=" + this.anchorCreateTime + ", anchorJobId=" + this.anchorJobId + ", limit=" + this.limit + ", jobTypes=" + this.jobTypes + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new y2())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniAIJobListQuery r100, muc.d r110, luc.f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeIntElement(r111, 0, r100.jobType);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeIntElement(r111, 1, r100.status);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeLongElement(r111, 2, r100.anchorCreateTime);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeNullableSerializableElement(r111, 3, v2.f520790a, r100.anchorJobId);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        boolean r107 = true;
    L45:
        if (r107 == false) goto L48;
        r110.encodeIntElement(r111, 4, r100.limit);
    L48:
        if (r110.shouldEncodeElementDefault(r111, 5) == false) goto L51;
    L49:
        r102 = true;
    L53:
        if (r102 == false) goto L56;
        r110.encodeNullableSerializableElement(r111, 5, r101[5].getValue(), r100.jobTypes);
        return;
    L56:
        return;
    L51:
        if (r100.jobTypes == null) goto L53;
    L42:
        if (r100.limit != 0) goto L40;
        r107 = false;
        goto L45
    L33:
        if (r100.anchorJobId != null) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.anchorCreateTime != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.status != 0) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.jobType != 0) goto L4;
        r103 = false;
        goto L9
    }

    public OmniAIJobListQuery(int r100, int r101, long r102, String r103, int r104, List<Integer> r105) {
        this.jobType = r100;
        this.status = r101;
        this.anchorCreateTime = r102;
        this.anchorJobId = r103;
        this.limit = r104;
        this.jobTypes = r105;
    }

    public /* synthetic */ OmniAIJobListQuery(int r100, int r101, int r102, long r103, String r104, int r105, List r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniAIJobListQuery$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.jobType = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.status = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.anchorCreateTime = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.anchorJobId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.limit = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.jobTypes = null;
        return;
    L27:
        this.jobTypes = r110;
        return;
    L23:
        this.limit = r105;
        goto L25
    L19:
        this.anchorJobId = r104;
        goto L21
    L15:
        this.anchorCreateTime = r103;
        goto L17
    L11:
        this.status = r102;
        goto L13
    L7:
        this.jobType = r101;
        goto L9
    }

    public /* synthetic */ OmniAIJobListQuery(int r100, int r101, long r102, String r110, int r111, List r112, int r113, DefaultConstructorMarker r114) {
        int r103 = 0;
        if ((r113 & 1) == 0) goto L5;
        int r115 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r105 = r102;
        if ((r113 & 8) == 0) goto L16;
        String r106 = null;
    L18:
        if ((r113 & 16) != 0) goto L22;
        r103 = r111;
    L22:
        if ((r113 & 32) == 0) goto L24;
        List r116 = null;
    L25:
        this(r115, r104, r105, r106, r103, r116);
        return;
    L24:
        r116 = r112;
        goto L25
    L16:
        r106 = r110;
        goto L18
    L9:
        r104 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
