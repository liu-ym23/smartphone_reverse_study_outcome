package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.gc;
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
import luc.f;
import nuc.a1;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBU\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000fHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/PacketMonitorContext;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "logId", "", "replyUniqueKey", "streamEventId", "", "isResume", "", "extra", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLogId$annotations", "()V", "getReplyUniqueKey$annotations", "getStreamEventId$annotations", "isResume$annotations", "getExtra$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class PacketMonitorContext implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final Map<String, String> extra;
    public final boolean isResume;
    public final String logId;
    public final String replyUniqueKey;
    public final long streamEventId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/PacketMonitorContext$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/PacketMonitorContext;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<PacketMonitorContext> serializer() {
            return PacketMonitorContext$$serializer.INSTANCE;
        }
    }

    public PacketMonitorContext() {
        this(null, null, 0, false, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PacketMonitorContext copy$default(PacketMonitorContext r100, String r101, String r102, long r103, boolean r104, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.logId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.replyUniqueKey;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.streamEventId;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isResume;
    L14:
        boolean r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.extra;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("log_id")
    public static /* synthetic */ void getLogId$annotations() {
    }

    @SerialName("reply_unique_key")
    public static /* synthetic */ void getReplyUniqueKey$annotations() {
    }

    @SerialName("stream_event_id")
    public static /* synthetic */ void getStreamEventId$annotations() {
    }

    @SerialName("is_resume")
    public static /* synthetic */ void isResume$annotations() {
    }

    public final String component1() {
        return this.logId;
    }

    public final String component2() {
        return this.replyUniqueKey;
    }

    public final long component3() {
        return this.streamEventId;
    }

    public final boolean component4() {
        return this.isResume;
    }

    public final Map<String, String> component5() {
        return this.extra;
    }

    public final PacketMonitorContext copy(String r100, String r110, long r111, boolean r112, Map<String, String> r113) {
        return new PacketMonitorContext(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PacketMonitorContext) == true) goto L8;
        return false;
    L8:
        PacketMonitorContext r101 = (PacketMonitorContext) r100;
        if (Intrinsics.areEqual(this.logId, r101.logId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyUniqueKey, r101.replyUniqueKey) == true) goto L15;
        return false;
    L15:
        if (this.streamEventId == r101.streamEventId) goto L18;
        return false;
    L18:
        if (this.isResume == r101.isResume) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.logId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.replyUniqueKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.streamEventId;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        if (this.isResume == false) goto L13;
        int r109 = 1231;
    L14:
        int r110 = (r108 + r109) * 31;
        Map<String, String> r111 = this.extra;
        if (r111 == null) goto L19;
        r101 = r111.hashCode();
    L19:
        return r110 + r101;
    L13:
        r109 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PacketMonitorContext(logId=" + this.logId + ", replyUniqueKey=" + this.replyUniqueKey + ", streamEventId=" + this.streamEventId + ", isResume=" + this.isResume + ", extra=" + this.extra + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new gc())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(PacketMonitorContext r100, muc.d r110, f r111) {
        Lazy<d<Object>>[] r101 = $childSerializers;
        boolean r102 = false;
        if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r110.encodeNullableSerializableElement(r111, 0, v2.f520790a, r100.logId);
    L12:
        if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r110.encodeNullableSerializableElement(r111, 1, v2.f520790a, r100.replyUniqueKey);
    L21:
        if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r110.encodeLongElement(r111, 2, r100.streamEventId);
    L30:
        if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r110.encodeBooleanElement(r111, 3, r100.isResume);
    L39:
        if (r110.shouldEncodeElementDefault(r111, 4) == false) goto L42;
    L40:
        r102 = true;
    L44:
        if (r102 == false) goto L47;
        r110.encodeNullableSerializableElement(r111, 4, r101[4].getValue(), r100.extra);
        return;
    L47:
        return;
    L42:
        if (r100.extra == null) goto L44;
    L33:
        if (r100.isResume == true) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.streamEventId != 0) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.replyUniqueKey != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.logId != null) goto L4;
        r103 = false;
        goto L9
    }

    public PacketMonitorContext(String r100, String r101, long r102, boolean r103, Map<String, String> r104) {
        this.logId = r100;
        this.replyUniqueKey = r101;
        this.streamEventId = r102;
        this.isResume = r103;
        this.extra = r104;
    }

    public /* synthetic */ PacketMonitorContext(int r100, String r101, String r102, long r103, boolean r104, Map r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, PacketMonitorContext$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.logId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.replyUniqueKey = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.streamEventId = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.isResume = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.extra = null;
        return;
    L23:
        this.extra = r105;
        return;
    L19:
        this.isResume = r104;
        goto L21
    L15:
        this.streamEventId = r103;
        goto L17
    L11:
        this.replyUniqueKey = r102;
        goto L13
    L7:
        this.logId = r101;
        goto L9
    }

    public /* synthetic */ PacketMonitorContext(String r100, String r101, long r102, boolean r110, Map r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r104 = r102;
        if ((r112 & 8) == 0) goto L16;
        boolean r105 = false;
    L18:
        if ((r112 & 16) == 0) goto L20;
        Map r115 = null;
    L21:
        this(r114, r103, r104, r105, r115);
        return;
    L20:
        r115 = r111;
        goto L21
    L16:
        r105 = r110;
        goto L18
    L9:
        r103 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
