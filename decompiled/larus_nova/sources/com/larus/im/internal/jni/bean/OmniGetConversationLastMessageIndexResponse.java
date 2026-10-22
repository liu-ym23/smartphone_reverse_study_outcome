package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00060\u0001j\u0002`\u0002:\u0002\u001f B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetConversationLastMessageIndexResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "lastMessageIndex", "", "<init>", "(J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLastMessageIndex$annotations", "()V", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniGetConversationLastMessageIndexResponse implements java.io.Serializable {
    public static final Companion Companion = null;
    public final long lastMessageIndex;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniGetConversationLastMessageIndexResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniGetConversationLastMessageIndexResponse;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniGetConversationLastMessageIndexResponse> serializer() {
            return OmniGetConversationLastMessageIndexResponse$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniGetConversationLastMessageIndexResponse() {
        long r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ OmniGetConversationLastMessageIndexResponse copy$default(OmniGetConversationLastMessageIndexResponse r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.lastMessageIndex;
    L6:
        return r100.copy(r101);
    }

    @SerialName("last_message_index")
    public static /* synthetic */ void getLastMessageIndex$annotations() {
    }

    public final long component1() {
        return this.lastMessageIndex;
    }

    public final OmniGetConversationLastMessageIndexResponse copy(long r100) {
        return new OmniGetConversationLastMessageIndexResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniGetConversationLastMessageIndexResponse) == true) goto L9;
        return false;
    L9:
        if (this.lastMessageIndex == ((OmniGetConversationLastMessageIndexResponse) r100).lastMessageIndex) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        long r100 = this.lastMessageIndex;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public String toString() {
        return "OmniGetConversationLastMessageIndexResponse(lastMessageIndex=" + this.lastMessageIndex + ')';
    }

    public OmniGetConversationLastMessageIndexResponse(long r100) {
        this.lastMessageIndex = r100;
    }

    public /* synthetic */ OmniGetConversationLastMessageIndexResponse(int r100, long r101, q2 r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniGetConversationLastMessageIndexResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.lastMessageIndex = 0;
        return;
    L7:
        this.lastMessageIndex = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniGetConversationLastMessageIndexResponse r100, muc.d r101, f r102) {
        boolean r103 = true;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L9:
        if (r103 == false) goto L12;
        r101.encodeLongElement(r102, 0, r100.lastMessageIndex);
        return;
    L12:
        return;
    L6:
        if (r100.lastMessageIndex != 0) goto L9;
        r103 = false;
        goto L9
    }

    public /* synthetic */ OmniGetConversationLastMessageIndexResponse(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
