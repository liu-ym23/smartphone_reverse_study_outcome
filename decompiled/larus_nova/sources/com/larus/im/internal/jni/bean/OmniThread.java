package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import juc.d;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00060\u0001j\u0002`\u0002:\u0002+,B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\rHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0012¨\u0006-"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniThread;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "threadId", "", "sourceConversationId", "threadName", "earliestMsgIndex", "", "latestMsgIndex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThreadId$annotations", "()V", "getSourceConversationId$annotations", "getThreadName$annotations", "getEarliestMsgIndex$annotations", "getLatestMsgIndex$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniThread implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long earliestMsgIndex;
    public final long latestMsgIndex;
    public final String sourceConversationId;
    public final String threadId;
    public final String threadName;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniThread$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniThread;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniThread> serializer() {
            return OmniThread$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniThread() {
        this(null, null, null, 0, 0, 31, null);
    }

    public static /* synthetic */ OmniThread copy$default(OmniThread r100, String r101, String r102, String r103, long r104, long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.threadId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.sourceConversationId;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.threadName;
    L11:
        String r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.earliestMsgIndex;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.latestMsgIndex;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("earliest_msg_index")
    public static /* synthetic */ void getEarliestMsgIndex$annotations() {
    }

    @SerialName("latest_msg_index")
    public static /* synthetic */ void getLatestMsgIndex$annotations() {
    }

    @SerialName("source_conversation_id")
    public static /* synthetic */ void getSourceConversationId$annotations() {
    }

    @SerialName(CrashHianalyticsData.THREAD_ID)
    public static /* synthetic */ void getThreadId$annotations() {
    }

    @SerialName("thread_name")
    public static /* synthetic */ void getThreadName$annotations() {
    }

    public final String component1() {
        return this.threadId;
    }

    public final String component2() {
        return this.sourceConversationId;
    }

    public final String component3() {
        return this.threadName;
    }

    public final long component4() {
        return this.earliestMsgIndex;
    }

    public final long component5() {
        return this.latestMsgIndex;
    }

    public final OmniThread copy(String r110, String r111, String r112, long r113, long r114) {
        return new OmniThread(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniThread) == true) goto L8;
        return false;
    L8:
        OmniThread r101 = (OmniThread) r100;
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceConversationId, r101.sourceConversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadName, r101.threadName) == true) goto L18;
        return false;
    L18:
        if (this.earliestMsgIndex == r101.earliestMsgIndex) goto L21;
        return false;
    L21:
        if (this.latestMsgIndex == r101.latestMsgIndex) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.threadId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.sourceConversationId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.threadName;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        long r109 = this.earliestMsgIndex;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.latestMsgIndex;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniThread(threadId=" + this.threadId + ", sourceConversationId=" + this.sourceConversationId + ", threadName=" + this.threadName + ", earliestMsgIndex=" + this.earliestMsgIndex + ", latestMsgIndex=" + this.latestMsgIndex + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniThread r100, muc.d r101, f r110) {
        boolean r102 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.threadId);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L21;
        r101.encodeNullableSerializableElement(r110, 1, v2.f520790a, r100.sourceConversationId);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r101.encodeNullableSerializableElement(r110, 2, v2.f520790a, r100.threadName);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r101.encodeLongElement(r110, 3, r100.earliestMsgIndex);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        r102 = true;
    L44:
        if (r102 == false) goto L47;
        r101.encodeLongElement(r110, 4, r100.latestMsgIndex);
        return;
    L47:
        return;
    L42:
        if (r100.latestMsgIndex == 0) goto L44;
    L33:
        if (r100.earliestMsgIndex != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (r100.threadName != null) goto L22;
        r105 = false;
        goto L27
    L15:
        if (r100.sourceConversationId != null) goto L13;
        r104 = false;
        goto L18
    L6:
        if (r100.threadId != null) goto L4;
        r103 = false;
        goto L9
    }

    public OmniThread(String r100, String r101, String r102, long r103, long r104) {
        this.threadId = r100;
        this.sourceConversationId = r101;
        this.threadName = r102;
        this.earliestMsgIndex = r103;
        this.latestMsgIndex = r104;
    }

    public /* synthetic */ OmniThread(int r100, String r101, String r102, String r103, long r104, long r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniThread$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.threadId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.sourceConversationId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.threadName = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.earliestMsgIndex = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.latestMsgIndex = 0;
        return;
    L23:
        this.latestMsgIndex = r105;
        return;
    L19:
        this.earliestMsgIndex = r104;
        goto L21
    L15:
        this.threadName = r103;
        goto L17
    L11:
        this.sourceConversationId = r102;
        goto L13
    L7:
        this.threadId = r101;
        goto L9
    }

    public /* synthetic */ OmniThread(String r100, String r101, String r102, long r103, long r110, int r111, DefaultConstructorMarker r112) {
        String r104 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r111 & 4) != 0) goto L15;
        r104 = r102;
    L15:
        if ((r111 & 8) == 0) goto L17;
        long r106 = 0;
    L19:
        if ((r111 & 16) == 0) goto L21;
        long r114 = 0;
    L22:
        this(r113, r105, r104, r106, r114);
        return;
    L21:
        r114 = r110;
        goto L22
    L17:
        r106 = r103;
        goto L19
    L9:
        r105 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
