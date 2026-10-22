package com.larus.im.internal.protocol.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u0002:\u0002\u001f B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u001b\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/larus/im/internal/protocol/bean/BatchGetConversationInfoUplinkBody;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class BatchGetConversationInfoUplinkBody implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<String> conversationId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<BatchGetConversationInfoUplinkBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349582a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f349583b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f349583b;
        }

        static {
            a r100 = new a();
            f349582a = r100;
            g2 r101 = new g2("com.larus.im.internal.protocol.bean.BatchGetConversationInfoUplinkBody", r100, 1);
            r101.j("conversation_id", true);
            f349583b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d((d) BatchGetConversationInfoUplinkBody.access$get$childSerializers$cp()[0].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f349583b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy[] r101 = BatchGetConversationInfoUplinkBody.access$get$childSerializers$cp();
            int r102 = 1;
            if (r111.decodeSequentially() == false) goto L5;
            List r103 = (List) r111.decodeNullableSerializableElement(r100, 0, (juc.c) r101[0].getValue(), null);
        L15:
            r111.endStructure(r100);
            return new BatchGetConversationInfoUplinkBody(r102, r103, null);
        L5:
            List r104 = null;
            int r105 = 0;
        L6:
            if (r102 == 0) goto L14;
            int r106 = r111.decodeElementIndex(r100);
            if (r106 != (-1)) goto L9;
            r102 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = (List) r111.decodeNullableSerializableElement(r100, 0, (juc.c) r101[0].getValue(), r104);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r104;
            r102 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            BatchGetConversationInfoUplinkBody r102 = (BatchGetConversationInfoUplinkBody) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f349583b;
            muc.d r104 = r100.beginStructure(r103);
            BatchGetConversationInfoUplinkBody.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<BatchGetConversationInfoUplinkBody> serializer() {
            return a.f349582a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BatchGetConversationInfoUplinkBody() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(v2.f520790a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchGetConversationInfoUplinkBody copy$default(BatchGetConversationInfoUplinkBody r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        return r100.copy(r101);
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    public final List<String> component1() {
        return this.conversationId;
    }

    public final BatchGetConversationInfoUplinkBody copy(List<String> r100) {
        return new BatchGetConversationInfoUplinkBody(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BatchGetConversationInfoUplinkBody) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.conversationId, ((BatchGetConversationInfoUplinkBody) r100).conversationId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.conversationId;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "BatchGetConversationInfoUplinkBody(conversationId=" + this.conversationId + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new af9.d())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public BatchGetConversationInfoUplinkBody(List<String> r100) {
        this.conversationId = r100;
    }

    public BatchGetConversationInfoUplinkBody(int r100, List r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f349583b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
        return;
    L7:
        this.conversationId = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(BatchGetConversationInfoUplinkBody r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.conversationId);
        return;
    L12:
        return;
    L6:
        if (r100.conversationId != null) goto L9;
        r104 = false;
        goto L9
    }

    public /* synthetic */ BatchGetConversationInfoUplinkBody(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
