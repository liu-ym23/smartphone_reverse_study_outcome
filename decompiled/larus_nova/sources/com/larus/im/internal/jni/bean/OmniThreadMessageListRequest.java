package com.larus.im.internal.jni.bean;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import de9.lb;
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
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eBG\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003J=\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniThreadMessageListRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "threadId", "", "direction", "Lcom/larus/im/internal/jni/bean/OmniThreadMessageDirection;", "anchorIndex", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "disableRecoverChunk", "", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniThreadMessageDirection;JIZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/jni/bean/OmniThreadMessageDirection;JIZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThreadId$annotations", "()V", "getDirection$annotations", "getAnchorIndex$annotations", "getLimit$annotations", "getDisableRecoverChunk$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniThreadMessageListRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final long anchorIndex;
    public final OmniThreadMessageDirection direction;
    public final boolean disableRecoverChunk;
    public final int limit;
    public final String threadId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniThreadMessageListRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniThreadMessageListRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniThreadMessageListRequest> serializer() {
            return OmniThreadMessageListRequest$$serializer.INSTANCE;
        }
    }

    public OmniThreadMessageListRequest() {
        this(null, null, 0, 0, false, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniThreadMessageDirection.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ OmniThreadMessageListRequest copy$default(OmniThreadMessageListRequest r100, String r101, OmniThreadMessageDirection r102, long r103, int r104, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.threadId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.direction;
    L8:
        OmniThreadMessageDirection r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.anchorIndex;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.limit;
    L14:
        int r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.disableRecoverChunk;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("anchor_index")
    public static /* synthetic */ void getAnchorIndex$annotations() {
    }

    @SerialName("direction")
    public static /* synthetic */ void getDirection$annotations() {
    }

    @SerialName("disable_recover_chunk")
    public static /* synthetic */ void getDisableRecoverChunk$annotations() {
    }

    @SerialName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    public static /* synthetic */ void getLimit$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    public final String component1() {
        return this.threadId;
    }

    public final OmniThreadMessageDirection component2() {
        return this.direction;
    }

    public final long component3() {
        return this.anchorIndex;
    }

    public final int component4() {
        return this.limit;
    }

    public final boolean component5() {
        return this.disableRecoverChunk;
    }

    public final OmniThreadMessageListRequest copy(String r100, OmniThreadMessageDirection r110, long r111, int r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "direction");
        return new OmniThreadMessageListRequest(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniThreadMessageListRequest) == true) goto L8;
        return false;
    L8:
        OmniThreadMessageListRequest r101 = (OmniThreadMessageListRequest) r100;
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L12;
        return false;
    L12:
        if (this.direction == r101.direction) goto L15;
        return false;
    L15:
        if (this.anchorIndex == r101.anchorIndex) goto L18;
        return false;
    L18:
        if (this.limit == r101.limit) goto L21;
        return false;
    L21:
        if (this.disableRecoverChunk == r101.disableRecoverChunk) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.threadId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.direction.hashCode()) * 31;
        long r103 = this.anchorIndex;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.limit) * 31;
        if (this.disableRecoverChunk == false) goto L9;
        int r105 = 1231;
    L11:
        return r104 + r105;
    L9:
        r105 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniThreadMessageListRequest(threadId=" + this.threadId + ", direction=" + this.direction + ", anchorIndex=" + this.anchorIndex + ", limit=" + this.limit + ", disableRecoverChunk=" + this.disableRecoverChunk + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new lb()), null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniThreadMessageListRequest r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.threadId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeSerializableElement(r110, 1, r102[1].getValue(), r100.direction);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.anchorIndex);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeIntElement(r110, 3, r100.limit);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeBooleanElement(r110, 4, r100.disableRecoverChunk);
        return;
    L47:
        return;
    L42:
        if (r100.disableRecoverChunk == false) goto L44;
    L33:
        if (r100.limit != 0) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.anchorIndex != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.direction != OmniThreadMessageDirection.UN_KNOW) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.threadId != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniThreadMessageListRequest(String r100, OmniThreadMessageDirection r101, long r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "direction");
        this.threadId = r100;
        this.direction = r101;
        this.anchorIndex = r102;
        this.limit = r103;
        this.disableRecoverChunk = r104;
    }

    public /* synthetic */ OmniThreadMessageListRequest(int r100, String r101, OmniThreadMessageDirection r102, long r103, int r104, boolean r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniThreadMessageListRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.threadId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.direction = OmniThreadMessageDirection.UN_KNOW;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.anchorIndex = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.limit = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.disableRecoverChunk = false;
        return;
    L23:
        this.disableRecoverChunk = r105;
        return;
    L19:
        this.limit = r104;
        goto L21
    L15:
        this.anchorIndex = r103;
        goto L17
    L11:
        this.direction = r102;
        goto L13
    L7:
        this.threadId = r101;
        goto L9
    }

    public /* synthetic */ OmniThreadMessageListRequest(String r100, OmniThreadMessageDirection r101, long r102, int r103, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = OmniThreadMessageDirection.UN_KNOW;
    L8:
        OmniThreadMessageDirection r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        long r104 = r102;
        if ((r111 & 8) == 0) goto L14;
        int r105 = 0;
    L16:
        if ((r111 & 16) == 0) goto L18;
        boolean r106 = false;
    L19:
        this(r100, r113, r104, r105, r106);
        return;
    L18:
        r106 = r110;
        goto L19
    L14:
        r105 = r103;
        goto L16
    }
}
