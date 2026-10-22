package com.larus.im.bean.thread;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00060\u0001j\u0002`\u0002:\u000223B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003JA\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\rHÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001b¨\u00064"}, d2 = {"Lcom/larus/im/bean/thread/ThreadData;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "threadId", "", "sourceConversationId", "threadName", "earliestMessageIndex", "", "latestMessageIndex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getThreadId$annotations", "()V", "getThreadId", "()Ljava/lang/String;", "getSourceConversationId$annotations", "getSourceConversationId", "getThreadName$annotations", "getThreadName", "getEarliestMessageIndex$annotations", "getEarliestMessageIndex", "()J", "getLatestMessageIndex$annotations", "getLatestMessageIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "Companion", "$serializer", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ThreadData implements java.io.Serializable {
    private static final b Companion = null;
    private static final long serialVersionUID = 1;
    private final long earliestMessageIndex;
    private final long latestMessageIndex;
    private final String sourceConversationId;
    private final String threadId;
    private final String threadName;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ThreadData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347122a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347123b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            g1 r101 = g1.f520681a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), r101, r101};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347123b;
        }

        static {
            a r100 = new a();
            f347122a = r100;
            g2 r101 = new g2("com.larus.im.bean.thread.ThreadData", r100, 5);
            r101.j(CrashHianalyticsData.THREAD_ID, true);
            r101.j("source_conversation_id", true);
            r101.j("thread_name", true);
            r101.j("earliest_msg_index", true);
            r101.j("latest_msg_index", true);
            f347123b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347123b;
            c r101 = r210.beginStructure(r100);
            int r102 = 2;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            String r211 = r107;
            long r212 = r101.decodeLongElement(r100, 3);
            String r110 = r106;
            String r111 = r105;
            long r213 = r101.decodeLongElement(r100, 4);
            int r112 = 31;
        L26:
            r101.endStructure(r100);
            return new ThreadData(r112, r111, r110, r211, r212, r213, null);
        L5:
            long r108 = 0;
            String r113 = null;
            String r114 = null;
            long r115 = 0;
            int r109 = 0;
            boolean r116 = true;
        L6:
            if (r116 == false) goto L25;
            int r117 = r101.decodeElementIndex(r100);
            if (r117 != (-1)) goto L9;
            r102 = 2;
            r116 = false;
            goto L6
        L9:
            if (r117 == 0) goto L22;
            if (r117 != 1) goto L12;
            r113 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r113);
            r109 = r109 | 2;
        L23:
            r102 = 2;
            goto L6
        L12:
            if (r117 == r102) goto L19;
            if (r117 == 3) goto L18;
            if (r117 != 4) goto L17;
            r115 = r101.decodeLongElement(r100, 4);
            r109 = r109 | 16;
            goto L23
        L17:
            throw new UnknownFieldException(r117);
        L18:
            r108 = r101.decodeLongElement(r100, 3);
            r109 = r109 | 8;
            goto L23
        L19:
            r114 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r114);
            r109 = r109 | 4;
            goto L23
        L22:
            r109 = r109 | 1;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            goto L23
        L25:
            r112 = r109;
            r111 = r103;
            r212 = r108;
            r213 = r115;
            r110 = r113;
            r211 = r114;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ThreadData r102 = (ThreadData) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347123b;
            muc.d r104 = r100.beginStructure(r103);
            ThreadData.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ThreadData> serializer() {
            return a.f347122a;
        }
    }

    public ThreadData() {
        this(null, null, null, 0, 0, 31, null);
    }

    public static /* synthetic */ ThreadData copy$default(ThreadData r100, String r101, String r102, String r103, long r104, long r110, int r111, Object r112) {
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
        r104 = r100.earliestMessageIndex;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.latestMessageIndex;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("earliest_msg_index")
    public static /* synthetic */ void getEarliestMessageIndex$annotations() {
    }

    @SerialName("latest_msg_index")
    public static /* synthetic */ void getLatestMessageIndex$annotations() {
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
        return this.earliestMessageIndex;
    }

    public final long component5() {
        return this.latestMessageIndex;
    }

    public final ThreadData copy(String r110, String r111, String r112, long r113, long r114) {
        return new ThreadData(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThreadData) == true) goto L8;
        return false;
    L8:
        ThreadData r101 = (ThreadData) r100;
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceConversationId, r101.sourceConversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadName, r101.threadName) == true) goto L18;
        return false;
    L18:
        if (this.earliestMessageIndex == r101.earliestMessageIndex) goto L21;
        return false;
    L21:
        if (this.latestMessageIndex == r101.latestMessageIndex) goto L23;
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
        long r109 = this.earliestMessageIndex;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.latestMessageIndex;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ThreadData(threadId=" + this.threadId + ", sourceConversationId=" + this.sourceConversationId + ", threadName=" + this.threadName + ", earliestMessageIndex=" + this.earliestMessageIndex + ", latestMessageIndex=" + this.latestMessageIndex + ')';
    }

    static {
        Companion = new b();
    }

    public final long getEarliestMessageIndex() {
        return this.earliestMessageIndex;
    }

    public final long getLatestMessageIndex() {
        return this.latestMessageIndex;
    }

    public final String getSourceConversationId() {
        return this.sourceConversationId;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(ThreadData r100, muc.d r101, f r110) {
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
        r101.encodeLongElement(r110, 3, r100.earliestMessageIndex);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        r102 = true;
    L44:
        if (r102 == false) goto L47;
        r101.encodeLongElement(r110, 4, r100.latestMessageIndex);
        return;
    L47:
        return;
    L42:
        if (r100.latestMessageIndex == 0) goto L44;
    L33:
        if (r100.earliestMessageIndex != 0) goto L31;
        r106 = false;
        goto L36
    L24:
        if (Intrinsics.areEqual(r100.threadName, "") == false) goto L22;
        r105 = false;
        goto L27
    L15:
        if (Intrinsics.areEqual(r100.sourceConversationId, "") == false) goto L13;
        r104 = false;
        goto L18
    L6:
        if (Intrinsics.areEqual(r100.threadId, "") == false) goto L4;
        r103 = false;
        goto L9
    }

    public ThreadData(String r100, String r101, String r102, long r103, long r104) {
        this.threadId = r100;
        this.sourceConversationId = r101;
        this.threadName = r102;
        this.earliestMessageIndex = r103;
        this.latestMessageIndex = r104;
    }

    public ThreadData(int r100, String r101, String r102, String r103, long r104, long r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347123b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.threadId = "";
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.sourceConversationId = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.threadName = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.earliestMessageIndex = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.latestMessageIndex = 0;
        return;
    L23:
        this.latestMessageIndex = r105;
        return;
    L19:
        this.earliestMessageIndex = r104;
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

    public /* synthetic */ ThreadData(String r100, String r101, String r102, long r103, long r110, int r111, DefaultConstructorMarker r112) {
        String r104 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r105 = "";
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
