package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.o3;
import de9.p3;
import java.util.List;
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
import nuc.a1;
import nuc.b2;
import nuc.f;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002)*BE\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u000eHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0013R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0013¨\u0006+"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBatchGetConversationRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationIdList", "", "", "forcePull", "", "forceReplaceLocal", "ext", "", "<init>", "(Ljava/util/List;ZZLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationIdList$annotations", "()V", "getForcePull$annotations", "getForceReplaceLocal$annotations", "getExt$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBatchGetConversationRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final List<String> conversationIdList;
    public final Map<String, String> ext;
    public final boolean forcePull;
    public final boolean forceReplaceLocal;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBatchGetConversationRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBatchGetConversationRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBatchGetConversationRequest> serializer() {
            return OmniBatchGetConversationRequest$$serializer.INSTANCE;
        }
    }

    public OmniBatchGetConversationRequest() {
        this(null, false, false, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new f(v2.f520790a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniBatchGetConversationRequest copy$default(OmniBatchGetConversationRequest r100, List r101, boolean r102, boolean r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.conversationIdList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.forcePull;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.forceReplaceLocal;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("conversation_id_list")
    public static /* synthetic */ void getConversationIdList$annotations() {
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("force_pull")
    public static /* synthetic */ void getForcePull$annotations() {
    }

    @SerialName("force_replace_local")
    public static /* synthetic */ void getForceReplaceLocal$annotations() {
    }

    public final List<String> component1() {
        return this.conversationIdList;
    }

    public final boolean component2() {
        return this.forcePull;
    }

    public final boolean component3() {
        return this.forceReplaceLocal;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final OmniBatchGetConversationRequest copy(List<String> r100, boolean r101, boolean r102, Map<String, String> r103) {
        return new OmniBatchGetConversationRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBatchGetConversationRequest) == true) goto L8;
        return false;
    L8:
        OmniBatchGetConversationRequest r101 = (OmniBatchGetConversationRequest) r100;
        if (Intrinsics.areEqual(this.conversationIdList, r101.conversationIdList) == true) goto L12;
        return false;
    L12:
        if (this.forcePull == r101.forcePull) goto L15;
        return false;
    L15:
        if (this.forceReplaceLocal == r101.forceReplaceLocal) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.conversationIdList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.forcePull == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.forceReplaceLocal == true) goto L14;
        r104 = 1237;
    L14:
        int r107 = (r106 + r104) * 31;
        Map<String, String> r108 = this.ext;
        if (r108 == null) goto L19;
        r101 = r108.hashCode();
    L19:
        return r107 + r101;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniBatchGetConversationRequest(conversationIdList=" + this.conversationIdList + ", forcePull=" + this.forcePull + ", forceReplaceLocal=" + this.forceReplaceLocal + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{LazyKt.lazy(r100, new o3()), null, null, LazyKt.lazy(r100, new p3())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBatchGetConversationRequest r100, muc.d r101, luc.f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.conversationIdList);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.forcePull);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.forceReplaceLocal);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r104 = true;
    L35:
        if (r104 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, r103[3].getValue(), r100.ext);
        return;
    L38:
        return;
    L33:
        if (r100.ext == null) goto L35;
    L24:
        if (r100.forceReplaceLocal == true) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.forcePull == true) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.conversationIdList != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniBatchGetConversationRequest(List<String> r100, boolean r101, boolean r102, Map<String, String> r103) {
        this.conversationIdList = r100;
        this.forcePull = r101;
        this.forceReplaceLocal = r102;
        this.ext = r103;
    }

    public /* synthetic */ OmniBatchGetConversationRequest(int r100, List r101, boolean r102, boolean r103, Map r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBatchGetConversationRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationIdList = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.forcePull = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.forceReplaceLocal = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.ext = null;
        return;
    L19:
        this.ext = r104;
        return;
    L15:
        this.forceReplaceLocal = r103;
        goto L17
    L11:
        this.forcePull = r102;
        goto L13
    L7:
        this.conversationIdList = r101;
        goto L9
    }

    public /* synthetic */ OmniBatchGetConversationRequest(List r100, boolean r101, boolean r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
