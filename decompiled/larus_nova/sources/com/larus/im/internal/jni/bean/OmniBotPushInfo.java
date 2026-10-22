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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002%&B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotPushInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "messagePush", "", "showMessagePush", "confirmInfo", "Lcom/larus/im/internal/jni/bean/OmniBotPushConfirmInfo;", "<init>", "(ZZLcom/larus/im/internal/jni/bean/OmniBotPushConfirmInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLcom/larus/im/internal/jni/bean/OmniBotPushConfirmInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMessagePush$annotations", "()V", "getShowMessagePush$annotations", "getConfirmInfo$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotPushInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OmniBotPushConfirmInfo confirmInfo;
    public final boolean messagePush;
    public final boolean showMessagePush;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotPushInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotPushInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotPushInfo> serializer() {
            return OmniBotPushInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniBotPushInfo() {
        this(false, false, null, 7, null);
    }

    public static /* synthetic */ OmniBotPushInfo copy$default(OmniBotPushInfo r100, boolean r101, boolean r102, OmniBotPushConfirmInfo r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.messagePush;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.showMessagePush;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.confirmInfo;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("confirm_info")
    public static /* synthetic */ void getConfirmInfo$annotations() {
    }

    @SerialName("message_push")
    public static /* synthetic */ void getMessagePush$annotations() {
    }

    @SerialName("show_message_push")
    public static /* synthetic */ void getShowMessagePush$annotations() {
    }

    public final boolean component1() {
        return this.messagePush;
    }

    public final boolean component2() {
        return this.showMessagePush;
    }

    public final OmniBotPushConfirmInfo component3() {
        return this.confirmInfo;
    }

    public final OmniBotPushInfo copy(boolean r100, boolean r101, OmniBotPushConfirmInfo r102) {
        return new OmniBotPushInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotPushInfo) == true) goto L8;
        return false;
    L8:
        OmniBotPushInfo r101 = (OmniBotPushInfo) r100;
        if (this.messagePush == r101.messagePush) goto L12;
        return false;
    L12:
        if (this.showMessagePush == r101.showMessagePush) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.confirmInfo, r101.confirmInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.messagePush == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.showMessagePush == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        OmniBotPushConfirmInfo r104 = this.confirmInfo;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniBotPushInfo(messagePush=" + this.messagePush + ", showMessagePush=" + this.showMessagePush + ", confirmInfo=" + this.confirmInfo + ')';
    }

    public OmniBotPushInfo(boolean r100, boolean r101, OmniBotPushConfirmInfo r102) {
        this.messagePush = r100;
        this.showMessagePush = r101;
        this.confirmInfo = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotPushInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.messagePush);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.showMessagePush);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, OmniBotPushConfirmInfo$$serializer.INSTANCE, r100.confirmInfo);
        return;
    L29:
        return;
    L24:
        if (r100.confirmInfo == null) goto L26;
    L15:
        if (r100.showMessagePush == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.messagePush == true) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniBotPushInfo(int r100, boolean r101, boolean r102, OmniBotPushConfirmInfo r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotPushInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.messagePush = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.showMessagePush = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.confirmInfo = null;
        return;
    L15:
        this.confirmInfo = r103;
        return;
    L11:
        this.showMessagePush = r102;
        goto L13
    L7:
        this.messagePush = r101;
        goto L9
    }

    public /* synthetic */ OmniBotPushInfo(boolean r100, boolean r101, OmniBotPushConfirmInfo r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
