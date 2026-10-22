package com.larus.im.bean.message;

import com.byted.cast.common.auth.AuthConstants;
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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import yc9.j;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00060\u0001j\u0002`\u0002:\u000212B;\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rBG\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u0010#\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e¨\u00063"}, d2 = {"Lcom/larus/im/bean/message/ConversationInitOption;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "independentSites", "", "", "needAckConversation", "", "subSceneNotify", "Lcom/larus/im/bean/message/SubSceneNotify;", "projectId", "", "<init>", "(Ljava/util/List;ZLcom/larus/im/bean/message/SubSceneNotify;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLcom/larus/im/bean/message/SubSceneNotify;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIndependentSites$annotations", "()V", "getIndependentSites", "()Ljava/util/List;", "getNeedAckConversation$annotations", "getNeedAckConversation", "()Z", "getSubSceneNotify$annotations", "getSubSceneNotify", "()Lcom/larus/im/bean/message/SubSceneNotify;", "getProjectId$annotations", "getProjectId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ConversationInitOption implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<Integer> independentSites;
    private final boolean needAckConversation;
    private final String projectId;
    private final SubSceneNotify subSceneNotify;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ConversationInitOption> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346612a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346613b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346613b;
        }

        static {
            a r100 = new a();
            f346612a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ConversationInitOption", r100, 4);
            r101.j("independent_sites", true);
            r101.j("need_ack_conversation", true);
            r101.j("sub_scene_notify", true);
            r101.j(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, true);
            f346613b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d((d) ConversationInitOption.access$get$childSerializers$cp()[0].getValue()), i.f520705a, kuc.a.d(SubSceneNotify.a.f346719a), kuc.a.d(v2.f520790a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346613b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy[] r102 = ConversationInitOption.access$get$childSerializers$cp();
            if (r101.decodeSequentially() == false) goto L5;
            List r103 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), null);
            boolean r104 = r101.decodeBooleanElement(r100, 1);
            List r110 = r103;
            boolean r111 = r104;
            SubSceneNotify r112 = (SubSceneNotify) r101.decodeNullableSerializableElement(r100, 2, SubSceneNotify.a.f346719a, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, null);
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new ConversationInitOption(r114, r110, r111, r112, r113, null);
        L5:
            List r105 = null;
            SubSceneNotify r115 = null;
            String r116 = null;
            boolean r106 = false;
            int r107 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r105 = (List) r101.decodeNullableSerializableElement(r100, 0, (juc.c) r102[0].getValue(), r105);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r106 = r101.decodeBooleanElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r115 = (SubSceneNotify) r101.decodeNullableSerializableElement(r100, 2, SubSceneNotify.a.f346719a, r115);
            r107 = r107 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r116);
            r107 = r107 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r111 = r106;
            r114 = r107;
            r110 = r105;
            r112 = r115;
            r113 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ConversationInitOption r102 = (ConversationInitOption) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346613b;
            muc.d r104 = r100.beginStructure(r103);
            ConversationInitOption.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ConversationInitOption> serializer() {
            return a.f346612a;
        }
    }

    public ConversationInitOption() {
        this(null, false, null, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(w0.f520792a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConversationInitOption copy$default(ConversationInitOption r100, List r101, boolean r102, SubSceneNotify r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.independentSites;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.needAckConversation;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.subSceneNotify;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.projectId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("independent_sites")
    public static /* synthetic */ void getIndependentSites$annotations() {
    }

    @SerialName("need_ack_conversation")
    public static /* synthetic */ void getNeedAckConversation$annotations() {
    }

    @SerialName(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID)
    public static /* synthetic */ void getProjectId$annotations() {
    }

    @SerialName("sub_scene_notify")
    public static /* synthetic */ void getSubSceneNotify$annotations() {
    }

    public final List<Integer> component1() {
        return this.independentSites;
    }

    public final boolean component2() {
        return this.needAckConversation;
    }

    public final SubSceneNotify component3() {
        return this.subSceneNotify;
    }

    public final String component4() {
        return this.projectId;
    }

    public final ConversationInitOption copy(List<Integer> r100, boolean r101, SubSceneNotify r102, String r103) {
        return new ConversationInitOption(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationInitOption) == true) goto L8;
        return false;
    L8:
        ConversationInitOption r101 = (ConversationInitOption) r100;
        if (Intrinsics.areEqual(this.independentSites, r101.independentSites) == true) goto L12;
        return false;
    L12:
        if (this.needAckConversation == r101.needAckConversation) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.subSceneNotify, r101.subSceneNotify) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.projectId, r101.projectId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<Integer> r100 = this.independentSites;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.needAckConversation == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        SubSceneNotify r106 = this.subSceneNotify;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.projectId;
        if (r109 == null) goto L19;
        r101 = r109.hashCode();
    L19:
        return r108 + r101;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ConversationInitOption(independentSites=" + this.independentSites + ", needAckConversation=" + this.needAckConversation + ", subSceneNotify=" + this.subSceneNotify + ", projectId=" + this.projectId + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new j()), null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<Integer> getIndependentSites() {
        return this.independentSites;
    }

    public final boolean getNeedAckConversation() {
        return this.needAckConversation;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final SubSceneNotify getSubSceneNotify() {
        return this.subSceneNotify;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(ConversationInitOption r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.independentSites);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.needAckConversation);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, SubSceneNotify.a.f346719a, r100.subSceneNotify);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r104 = true;
    L35:
        if (r104 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.projectId);
        return;
    L38:
        return;
    L33:
        if (r100.projectId == null) goto L35;
    L24:
        if (r100.subSceneNotify != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.needAckConversation != true) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.independentSites != null) goto L4;
        r105 = false;
        goto L9
    }

    public ConversationInitOption(List<Integer> r100, boolean r101, SubSceneNotify r102, String r103) {
        this.independentSites = r100;
        this.needAckConversation = r101;
        this.subSceneNotify = r102;
        this.projectId = r103;
    }

    public ConversationInitOption(int r100, List r101, boolean r102, SubSceneNotify r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346613b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.independentSites = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.needAckConversation = true;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.subSceneNotify = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.projectId = null;
        return;
    L19:
        this.projectId = r104;
        return;
    L15:
        this.subSceneNotify = r103;
        goto L17
    L11:
        this.needAckConversation = r102;
        goto L13
    L7:
        this.independentSites = r101;
        goto L9
    }

    public /* synthetic */ ConversationInitOption(List r100, boolean r101, SubSceneNotify r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
