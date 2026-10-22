package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import de9.cc;
import de9.dc;
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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002)*BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBO\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\rHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0012R$\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0012¨\u0006+"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniUpdateMessageStatusRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "localMessageId", "", "messageId", "messageStatus", "Lcom/larus/im/internal/jni/bean/OmniMessageStatus;", "ext", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniMessageStatus;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/internal/jni/bean/OmniMessageStatus;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLocalMessageId$annotations", "()V", "getMessageId$annotations", "getMessageStatus$annotations", "getExt$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniUpdateMessageStatusRequest implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final Map<String, String> ext;
    public final String localMessageId;
    public final String messageId;
    public final OmniMessageStatus messageStatus;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniUpdateMessageStatusRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniUpdateMessageStatusRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniUpdateMessageStatusRequest> serializer() {
            return OmniUpdateMessageStatusRequest$$serializer.INSTANCE;
        }
    }

    public OmniUpdateMessageStatusRequest() {
        this(null, null, null, null, 15, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return OmniMessageStatus.Companion.serializer();
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OmniUpdateMessageStatusRequest copy$default(OmniUpdateMessageStatusRequest r100, String r101, String r102, OmniMessageStatus r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.localMessageId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.messageId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.messageStatus;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.ext;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("ext")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName("local_message_id")
    public static /* synthetic */ void getLocalMessageId$annotations() {
    }

    @SerialName(MusicAppletPage.KEY_MESSAGE_ID)
    public static /* synthetic */ void getMessageId$annotations() {
    }

    @SerialName("message_status")
    public static /* synthetic */ void getMessageStatus$annotations() {
    }

    public final String component1() {
        return this.localMessageId;
    }

    public final String component2() {
        return this.messageId;
    }

    public final OmniMessageStatus component3() {
        return this.messageStatus;
    }

    public final Map<String, String> component4() {
        return this.ext;
    }

    public final OmniUpdateMessageStatusRequest copy(String r100, String r101, OmniMessageStatus r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r102, "messageStatus");
        return new OmniUpdateMessageStatusRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniUpdateMessageStatusRequest) == true) goto L8;
        return false;
    L8:
        OmniUpdateMessageStatusRequest r101 = (OmniUpdateMessageStatusRequest) r100;
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (this.messageStatus == r101.messageStatus) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.localMessageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.messageStatus.hashCode()) * 31;
        Map<String, String> r107 = this.ext;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniUpdateMessageStatusRequest(localMessageId=" + this.localMessageId + ", messageId=" + this.messageId + ", messageStatus=" + this.messageStatus + ", ext=" + this.ext + ')';
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(r100, new cc()), LazyKt.lazy(r100, new dc())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniUpdateMessageStatusRequest r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.localMessageId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.messageId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeSerializableElement(r102, 2, r103[2].getValue(), r100.messageStatus);
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
        if (r100.messageStatus != OmniMessageStatus.MessageStatus_AVAILABLE) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.messageId != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.localMessageId != null) goto L4;
        r105 = false;
        goto L9
    }

    public OmniUpdateMessageStatusRequest(String r100, String r101, OmniMessageStatus r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r102, "messageStatus");
        this.localMessageId = r100;
        this.messageId = r101;
        this.messageStatus = r102;
        this.ext = r103;
    }

    public /* synthetic */ OmniUpdateMessageStatusRequest(int r100, String r101, String r102, OmniMessageStatus r103, Map r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniUpdateMessageStatusRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.localMessageId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.messageId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.messageStatus = OmniMessageStatus.MessageStatus_AVAILABLE;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.ext = null;
        return;
    L19:
        this.ext = r104;
        return;
    L15:
        this.messageStatus = r103;
        goto L17
    L11:
        this.messageId = r102;
        goto L13
    L7:
        this.localMessageId = r101;
        goto L9
    }

    public /* synthetic */ OmniUpdateMessageStatusRequest(String r100, String r101, OmniMessageStatus r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = OmniMessageStatus.MessageStatus_AVAILABLE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
