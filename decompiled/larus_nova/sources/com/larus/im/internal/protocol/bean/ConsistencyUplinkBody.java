package com.larus.im.internal.protocol.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u0002:\u0002\u001f B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/im/internal/protocol/bean/ConsistencyUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "messageList", "Lcom/larus/im/internal/protocol/bean/MessageListReport;", "<init>", "(Lcom/larus/im/internal/protocol/bean/MessageListReport;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/protocol/bean/MessageListReport;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMessageList$annotations", "()V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ConsistencyUplinkBody implements java.io.Serializable {
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public MessageListReport messageList;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ConsistencyUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349611a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349612b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(MessageListReport.a.f349664a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349612b;
        }

        static {
            a r100 = new a();
            f349611a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.ConsistencyUplinkBody", r100, 1);
            r101.j("message_list", true);
            f349612b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f349612b;
            muc.c r102 = r100.beginStructure(r101);
            int r103 = 1;
            if (r102.decodeSequentially() == false) goto L5;
            MessageListReport r104 = (MessageListReport) r102.decodeNullableSerializableElement(r101, 0, MessageListReport.a.f349664a, null);
        L15:
            r102.endStructure(r101);
            return new ConsistencyUplinkBody(r103, r104, null);
        L5:
            r104 = null;
            int r105 = 0;
        L6:
            if (r103 == 0) goto L14;
            int r106 = r102.decodeElementIndex(r101);
            if (r106 != (-1)) goto L9;
            r103 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = (MessageListReport) r102.decodeNullableSerializableElement(r101, 0, MessageListReport.a.f349664a, r104);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ConsistencyUplinkBody r102 = (ConsistencyUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349612b;
            muc.d r104 = r100.beginStructure(r103);
            ConsistencyUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ConsistencyUplinkBody> serializer() {
            return a.f349611a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConsistencyUplinkBody() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ConsistencyUplinkBody copy$default(ConsistencyUplinkBody r100, MessageListReport r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.messageList;
    L6:
        return r100.copy(r101);
    }

    @SerialName("message_list")
    public static /* synthetic */ void getMessageList$annotations() {
    }

    public final MessageListReport component1() {
        return this.messageList;
    }

    public final ConsistencyUplinkBody copy(MessageListReport r100) {
        return new ConsistencyUplinkBody(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConsistencyUplinkBody) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.messageList, ((ConsistencyUplinkBody) r100).messageList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        MessageListReport r100 = this.messageList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ConsistencyUplinkBody(messageList=" + this.messageList + ')';
    }

    static {
        Companion = new b();
    }

    public ConsistencyUplinkBody(MessageListReport r100) {
        this.messageList = r100;
    }

    public ConsistencyUplinkBody(int r100, MessageListReport r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349612b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.messageList = null;
        return;
    L7:
        this.messageList = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ConsistencyUplinkBody r100, muc.d r101, f r102) {
        boolean r103 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r103 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, MessageListReport.a.f349664a, r100.messageList);
        return;
    L12:
        return;
    L6:
        if (r100.messageList != null) goto L9;
        r103 = false;
        goto L9
    }

    public /* synthetic */ ConsistencyUplinkBody(MessageListReport r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
