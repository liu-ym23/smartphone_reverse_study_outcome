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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageResponse;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "success", "", "oldMessageId", "", "newMessageId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSuccess$annotations", "()V", "getOldMessageId$annotations", "getNewMessageId$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniChangeRegenMessageResponse implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String newMessageId;
    public final String oldMessageId;
    public final boolean success;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniChangeRegenMessageResponse;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniChangeRegenMessageResponse> serializer() {
            return OmniChangeRegenMessageResponse$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniChangeRegenMessageResponse() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ OmniChangeRegenMessageResponse copy$default(OmniChangeRegenMessageResponse r100, boolean r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.success;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.oldMessageId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.newMessageId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("new_message_id")
    public static /* synthetic */ void getNewMessageId$annotations() {
    }

    @SerialName("old_message_id")
    public static /* synthetic */ void getOldMessageId$annotations() {
    }

    @SerialName("success")
    public static /* synthetic */ void getSuccess$annotations() {
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.oldMessageId;
    }

    public final String component3() {
        return this.newMessageId;
    }

    public final OmniChangeRegenMessageResponse copy(boolean r100, String r101, String r102) {
        return new OmniChangeRegenMessageResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniChangeRegenMessageResponse) == true) goto L8;
        return false;
    L8:
        OmniChangeRegenMessageResponse r101 = (OmniChangeRegenMessageResponse) r100;
        if (this.success == r101.success) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.oldMessageId, r101.oldMessageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.newMessageId, r101.newMessageId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.success == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.oldMessageId;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.newMessageId;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniChangeRegenMessageResponse(success=" + this.success + ", oldMessageId=" + this.oldMessageId + ", newMessageId=" + this.newMessageId + ')';
    }

    public OmniChangeRegenMessageResponse(boolean r100, String r101, String r102) {
        this.success = r100;
        this.oldMessageId = r101;
        this.newMessageId = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniChangeRegenMessageResponse r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.success);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.oldMessageId);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.newMessageId);
        return;
    L29:
        return;
    L24:
        if (r100.newMessageId == null) goto L26;
    L15:
        if (r100.oldMessageId != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.success == true) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniChangeRegenMessageResponse(int r100, boolean r101, String r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniChangeRegenMessageResponse$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.success = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.oldMessageId = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.newMessageId = null;
        return;
    L15:
        this.newMessageId = r103;
        return;
    L11:
        this.oldMessageId = r102;
        goto L13
    L7:
        this.success = r101;
        goto L9
    }

    public /* synthetic */ OmniChangeRegenMessageResponse(boolean r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
