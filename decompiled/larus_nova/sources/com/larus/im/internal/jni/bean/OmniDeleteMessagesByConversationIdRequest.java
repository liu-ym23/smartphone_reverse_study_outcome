package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDeleteMessagesByConversationIdRequest;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "conversationId", "", "messageIdMatcher", "includeServer", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConversationId$annotations", "()V", "getMessageIdMatcher$annotations", "getIncludeServer$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniDeleteMessagesByConversationIdRequest implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String conversationId;
    public final boolean includeServer;
    public final String messageIdMatcher;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniDeleteMessagesByConversationIdRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniDeleteMessagesByConversationIdRequest;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniDeleteMessagesByConversationIdRequest> serializer() {
            return OmniDeleteMessagesByConversationIdRequest$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniDeleteMessagesByConversationIdRequest() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ OmniDeleteMessagesByConversationIdRequest copy$default(OmniDeleteMessagesByConversationIdRequest r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.messageIdMatcher;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.includeServer;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("conversation_id")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @SerialName("include_server")
    public static /* synthetic */ void getIncludeServer$annotations() {
    }

    @SerialName("message_id_matcher")
    public static /* synthetic */ void getMessageIdMatcher$annotations() {
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.messageIdMatcher;
    }

    public final boolean component3() {
        return this.includeServer;
    }

    public final OmniDeleteMessagesByConversationIdRequest copy(String r100, String r101, boolean r102) {
        return new OmniDeleteMessagesByConversationIdRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniDeleteMessagesByConversationIdRequest) == true) goto L8;
        return false;
    L8:
        OmniDeleteMessagesByConversationIdRequest r101 = (OmniDeleteMessagesByConversationIdRequest) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageIdMatcher, r101.messageIdMatcher) == true) goto L15;
        return false;
    L15:
        if (this.includeServer == r101.includeServer) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.messageIdMatcher;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.includeServer == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniDeleteMessagesByConversationIdRequest(conversationId=" + this.conversationId + ", messageIdMatcher=" + this.messageIdMatcher + ", includeServer=" + this.includeServer + ')';
    }

    public OmniDeleteMessagesByConversationIdRequest(String r100, String r101, boolean r102) {
        this.conversationId = r100;
        this.messageIdMatcher = r101;
        this.includeServer = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniDeleteMessagesByConversationIdRequest r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.conversationId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.messageIdMatcher);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeBooleanElement(r102, 2, r100.includeServer);
        return;
    L29:
        return;
    L24:
        if (r100.includeServer == false) goto L26;
    L15:
        if (r100.messageIdMatcher != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.conversationId != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniDeleteMessagesByConversationIdRequest(int r100, String r101, String r102, boolean r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniDeleteMessagesByConversationIdRequest$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.conversationId = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.messageIdMatcher = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.includeServer = false;
        return;
    L15:
        this.includeServer = r103;
        return;
    L11:
        this.messageIdMatcher = r102;
        goto L13
    L7:
        this.conversationId = r101;
        goto L9
    }

    public /* synthetic */ OmniDeleteMessagesByConversationIdRequest(String r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
