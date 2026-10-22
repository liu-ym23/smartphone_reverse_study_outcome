package com.larus.im.bean.message.block;

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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import zc9.y;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eBQ\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003JN\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001c\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Lcom/larus/im/bean/message/block/InteractionAskBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "clarifyId", "", "status", "", "questions", "", "Lcom/larus/im/bean/message/block/InteractionAskQuestion;", "thinkingContent", "Lcom/larus/im/bean/message/block/InteractionAskContent;", "quickReplyScene", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/block/InteractionAskContent;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/block/InteractionAskContent;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClarifyId$annotations", "()V", "getClarifyId", "()Ljava/lang/String;", "getStatus$annotations", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuestions$annotations", "getQuestions", "()Ljava/util/List;", "getThinkingContent$annotations", "getThinkingContent", "()Lcom/larus/im/bean/message/block/InteractionAskContent;", "getQuickReplyScene$annotations", "getQuickReplyScene", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/im/bean/message/block/InteractionAskContent;I)Lcom/larus/im/bean/message/block/InteractionAskBlock;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class InteractionAskBlock implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private final String clarifyId;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<InteractionAskQuestion> questions;
    private final int quickReplyScene;
    private final Integer status;
    private final InteractionAskContent thinkingContent;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<InteractionAskBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346900a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346901b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346901b;
        }

        static {
            a r100 = new a();
            f346900a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.InteractionAskBlock", r100, 5);
            r101.j("clarify_id", true);
            r101.j("status", true);
            r101.j("questions", true);
            r101.j("thinking_content", true);
            r101.j("quick_reply_scene", true);
            f346901b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = InteractionAskBlock.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(v2.f520790a), kuc.a.d(r101), kuc.a.d((d) r100[2].getValue()), kuc.a.d(InteractionAskContent.a.f346902a), r101};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346901b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = InteractionAskBlock.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, null);
            List r105 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), null);
            List r211 = r105;
            String r110 = r103;
            InteractionAskContent r212 = (InteractionAskContent) r101.decodeNullableSerializableElement(r100, 3, InteractionAskContent.a.f346902a, null);
            int r213 = r101.decodeIntElement(r100, 4);
            Integer r111 = r104;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new InteractionAskBlock(r112, r110, r111, r211, r212, r213, null);
        L5:
            String r113 = null;
            Integer r114 = null;
            List r115 = null;
            InteractionAskContent r116 = null;
            int r106 = 0;
            int r107 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L24;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 == 0) goto L21;
            if (r118 == 1) goto L19;
            if (r118 == 2) goto L18;
            if (r118 == 3) goto L17;
            if (r118 != 4) goto L16;
            r106 = r101.decodeIntElement(r100, 4);
            int r108 = r107 | 16;
        L20:
            r107 = r108;
            goto L6
        L16:
            throw new UnknownFieldException(r118);
        L17:
            r116 = (InteractionAskContent) r101.decodeNullableSerializableElement(r100, 3, InteractionAskContent.a.f346902a, r116);
            r108 = r107 | 8;
            goto L20
        L18:
            r115 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), r115);
            r108 = r107 | 4;
            goto L20
        L19:
            r114 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r114);
            r108 = r107 | 2;
            goto L20
        L21:
            r107 = r107 | 1;
            r113 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r113);
            goto L6
        L24:
            r213 = r106;
            r112 = r107;
            r110 = r113;
            r111 = r114;
            r211 = r115;
            r212 = r116;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            InteractionAskBlock r102 = (InteractionAskBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346901b;
            muc.d r104 = r100.beginStructure(r103);
            InteractionAskBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<InteractionAskBlock> serializer() {
            return a.f346900a;
        }
    }

    public InteractionAskBlock() {
        this(null, null, null, null, 0, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(InteractionAskQuestion.a.f346908a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InteractionAskBlock copy$default(InteractionAskBlock r100, String r101, Integer r102, List r103, InteractionAskContent r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.clarifyId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.status;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.questions;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.thinkingContent;
    L14:
        InteractionAskContent r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.quickReplyScene;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("clarify_id")
    public static /* synthetic */ void getClarifyId$annotations() {
    }

    @SerialName("questions")
    public static /* synthetic */ void getQuestions$annotations() {
    }

    @SerialName("quick_reply_scene")
    public static /* synthetic */ void getQuickReplyScene$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("thinking_content")
    public static /* synthetic */ void getThinkingContent$annotations() {
    }

    public final String component1() {
        return this.clarifyId;
    }

    public final Integer component2() {
        return this.status;
    }

    public final List<InteractionAskQuestion> component3() {
        return this.questions;
    }

    public final InteractionAskContent component4() {
        return this.thinkingContent;
    }

    public final int component5() {
        return this.quickReplyScene;
    }

    public final InteractionAskBlock copy(String r100, Integer r101, List<InteractionAskQuestion> r110, InteractionAskContent r111, int r112) {
        return new InteractionAskBlock(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InteractionAskBlock) == true) goto L8;
        return false;
    L8:
        InteractionAskBlock r101 = (InteractionAskBlock) r100;
        if (Intrinsics.areEqual(this.clarifyId, r101.clarifyId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.questions, r101.questions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.thinkingContent, r101.thinkingContent) == true) goto L21;
        return false;
    L21:
        if (this.quickReplyScene == r101.quickReplyScene) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.clarifyId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.status;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<InteractionAskQuestion> r107 = this.questions;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        InteractionAskContent r110 = this.thinkingContent;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.quickReplyScene;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "InteractionAskBlock(clarifyId=" + this.clarifyId + ", status=" + this.status + ", questions=" + this.questions + ", thinkingContent=" + this.thinkingContent + ", quickReplyScene=" + this.quickReplyScene + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new y()), null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final String getClarifyId() {
        return this.clarifyId;
    }

    public final List<InteractionAskQuestion> getQuestions() {
        return this.questions;
    }

    public final int getQuickReplyScene() {
        return this.quickReplyScene;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final InteractionAskContent getThinkingContent() {
        return this.thinkingContent;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(InteractionAskBlock r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.clarifyId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.status);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, r103[2].getValue(), r100.questions);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, InteractionAskContent.a.f346902a, r100.thinkingContent);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r104 = true;
    L44:
        if (r104 == false) goto L47;
        r101.encodeIntElement(r102, 4, r100.quickReplyScene);
        return;
    L47:
        return;
    L42:
        if (r100.quickReplyScene == 0) goto L44;
    L33:
        if (r100.thinkingContent != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.questions != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.status != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.clarifyId != null) goto L4;
        r105 = false;
        goto L9
    }

    public InteractionAskBlock(String r100, Integer r101, List<InteractionAskQuestion> r102, InteractionAskContent r103, int r104) {
        this.clarifyId = r100;
        this.status = r101;
        this.questions = r102;
        this.thinkingContent = r103;
        this.quickReplyScene = r104;
    }

    public InteractionAskBlock(int r100, String r101, Integer r102, List r103, InteractionAskContent r104, int r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346901b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.clarifyId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.status = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.questions = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.thinkingContent = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.quickReplyScene = 0;
        return;
    L23:
        this.quickReplyScene = r105;
        return;
    L19:
        this.thinkingContent = r104;
        goto L21
    L15:
        this.questions = r103;
        goto L17
    L11:
        this.status = r102;
        goto L13
    L7:
        this.clarifyId = r101;
        goto L9
    }

    public /* synthetic */ InteractionAskBlock(String r100, Integer r101, List r102, InteractionAskContent r103, int r104, int r105, DefaultConstructorMarker r110) {
        InteractionAskContent r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        Integer r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        List r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 0;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
