package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import de9.t;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 82\u00060\u0001j\u0002`\u0002:\u000278BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003JY\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u000fHÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0019R*\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"¨\u00069"}, d2 = {"Lcom/larus/im/internal/jni/bean/NativeThreadInterruptRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "interruptServer", "", "threadId", "", "lastSendMsgId", "lastSendMsgLocalId", "lastReplyMsgId", "modifyAnswerMap", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInterruptServer$annotations", "()V", "getInterruptServer", "()Z", "getThreadId$annotations", "getThreadId", "()Ljava/lang/String;", "getLastSendMsgId$annotations", "getLastSendMsgId", "getLastSendMsgLocalId$annotations", "getLastSendMsgLocalId", "getLastReplyMsgId$annotations", "getLastReplyMsgId", "getModifyAnswerMap$annotations", "getModifyAnswerMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class NativeThreadInterruptRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    private final boolean interruptServer;
    private final String lastReplyMsgId;
    private final String lastSendMsgId;
    private final String lastSendMsgLocalId;
    private final Map<String, String> modifyAnswerMap;
    private final String threadId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/NativeThreadInterruptRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/NativeThreadInterruptRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<NativeThreadInterruptRequest> serializer() {
            return NativeThreadInterruptRequest$$serializer.INSTANCE;
        }
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NativeThreadInterruptRequest copy$default(NativeThreadInterruptRequest r100, boolean r101, String r102, String r103, String r104, String r105, Map r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.interruptServer;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.threadId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.lastSendMsgId;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.lastSendMsgLocalId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.lastReplyMsgId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.modifyAnswerMap;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("interrupt_server")
    public static /* synthetic */ void getInterruptServer$annotations() {
    }

    @SerialName("last_reply_msg_id")
    public static /* synthetic */ void getLastReplyMsgId$annotations() {
    }

    @SerialName("last_send_msg_id")
    public static /* synthetic */ void getLastSendMsgId$annotations() {
    }

    @SerialName("last_send_msg_local_id")
    public static /* synthetic */ void getLastSendMsgLocalId$annotations() {
    }

    @SerialName("modify_answer_map")
    public static /* synthetic */ void getModifyAnswerMap$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    public final boolean component1() {
        return this.interruptServer;
    }

    public final String component2() {
        return this.threadId;
    }

    public final String component3() {
        return this.lastSendMsgId;
    }

    public final String component4() {
        return this.lastSendMsgLocalId;
    }

    public final String component5() {
        return this.lastReplyMsgId;
    }

    public final Map<String, String> component6() {
        return this.modifyAnswerMap;
    }

    public final NativeThreadInterruptRequest copy(boolean r100, String r110, String r111, String r112, String r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r110, "threadId");
        return new NativeThreadInterruptRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NativeThreadInterruptRequest) == true) goto L8;
        return false;
    L8:
        NativeThreadInterruptRequest r101 = (NativeThreadInterruptRequest) r100;
        if (this.interruptServer == r101.interruptServer) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lastSendMsgId, r101.lastSendMsgId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lastSendMsgLocalId, r101.lastSendMsgLocalId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lastReplyMsgId, r101.lastReplyMsgId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.modifyAnswerMap, r101.modifyAnswerMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.interruptServer == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.threadId.hashCode()) * 31;
        String r102 = this.lastSendMsgId;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.lastSendMsgLocalId;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.lastReplyMsgId;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Map<String, String> r112 = this.modifyAnswerMap;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return r111 + r103;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "NativeThreadInterruptRequest(interruptServer=" + this.interruptServer + ", threadId=" + this.threadId + ", lastSendMsgId=" + this.lastSendMsgId + ", lastSendMsgLocalId=" + this.lastSendMsgLocalId + ", lastReplyMsgId=" + this.lastReplyMsgId + ", modifyAnswerMap=" + this.modifyAnswerMap + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new t())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final boolean getInterruptServer() {
        return this.interruptServer;
    }

    public final String getLastReplyMsgId() {
        return this.lastReplyMsgId;
    }

    public final String getLastSendMsgId() {
        return this.lastSendMsgId;
    }

    public final String getLastSendMsgLocalId() {
        return this.lastSendMsgLocalId;
    }

    public final Map<String, String> getModifyAnswerMap() {
        return this.modifyAnswerMap;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(NativeThreadInterruptRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        r101.encodeBooleanElement(r102, 0, r100.interruptServer);
        r101.encodeStringElement(r102, 1, r100.threadId);
        v2 r104 = v2.f520790a;
        r101.encodeNullableSerializableElement(r102, 2, r104, r100.lastSendMsgId);
        r101.encodeNullableSerializableElement(r102, 3, r104, r100.lastSendMsgLocalId);
        r101.encodeNullableSerializableElement(r102, 4, r104, r100.lastReplyMsgId);
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.modifyAnswerMap);
    }

    public NativeThreadInterruptRequest(boolean r100, String r101, String r102, String r103, String r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r101, "threadId");
        this.interruptServer = r100;
        this.threadId = r101;
        this.lastSendMsgId = r102;
        this.lastSendMsgLocalId = r103;
        this.lastReplyMsgId = r104;
        this.modifyAnswerMap = r105;
    }

    public /* synthetic */ NativeThreadInterruptRequest(int r100, boolean r101, String r102, String r103, String r104, String r105, Map r106, q2 r107) {
        if (63 != (r100 & 63)) goto L6;
        this.interruptServer = r101;
        this.threadId = r102;
        this.lastSendMsgId = r103;
        this.lastSendMsgLocalId = r104;
        this.lastReplyMsgId = r105;
        this.modifyAnswerMap = r106;
        return;
    L6:
        b2.b(r100, 63, NativeThreadInterruptRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    }
}
