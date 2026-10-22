package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadad.api.download.AdDownloadModel;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVReplyBeginEvent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "modelType", "", "isModelProactiveSpeak", "", "linkState", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getModelType$annotations", "()V", "isModelProactiveSpeak$annotations", "getLinkState$annotations", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_av_release", "$serializer", "Companion", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OMNIAVReplyBeginEvent implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean isModelProactiveSpeak;
    public final String linkState;
    public final String modelType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OMNIAVReplyBeginEvent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OMNIAVReplyBeginEvent;", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OMNIAVReplyBeginEvent> serializer() {
            return OMNIAVReplyBeginEvent$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OMNIAVReplyBeginEvent() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ OMNIAVReplyBeginEvent copy$default(OMNIAVReplyBeginEvent r100, String r101, boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.modelType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isModelProactiveSpeak;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.linkState;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("link_state")
    public static /* synthetic */ void getLinkState$annotations() {
    }

    @SerialName(AdDownloadModel.JsonKey.MODEL_TYPE)
    public static /* synthetic */ void getModelType$annotations() {
    }

    @SerialName("is_model_proactive_speak")
    public static /* synthetic */ void isModelProactiveSpeak$annotations() {
    }

    public final String component1() {
        return this.modelType;
    }

    public final boolean component2() {
        return this.isModelProactiveSpeak;
    }

    public final String component3() {
        return this.linkState;
    }

    public final OMNIAVReplyBeginEvent copy(String r100, boolean r101, String r102) {
        return new OMNIAVReplyBeginEvent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OMNIAVReplyBeginEvent) == true) goto L8;
        return false;
    L8:
        OMNIAVReplyBeginEvent r101 = (OMNIAVReplyBeginEvent) r100;
        if (Intrinsics.areEqual(this.modelType, r101.modelType) == true) goto L12;
        return false;
    L12:
        if (this.isModelProactiveSpeak == r101.isModelProactiveSpeak) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.linkState, r101.linkState) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.modelType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.isModelProactiveSpeak == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.linkState;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OMNIAVReplyBeginEvent(modelType=" + this.modelType + ", isModelProactiveSpeak=" + this.isModelProactiveSpeak + ", linkState=" + this.linkState + ')';
    }

    public OMNIAVReplyBeginEvent(String r100, boolean r101, String r102) {
        this.modelType = r100;
        this.isModelProactiveSpeak = r101;
        this.linkState = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_av_release(OMNIAVReplyBeginEvent r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.modelType);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.isModelProactiveSpeak);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.linkState);
        return;
    L29:
        return;
    L24:
        if (r100.linkState == null) goto L26;
    L15:
        if (r100.isModelProactiveSpeak == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.modelType != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OMNIAVReplyBeginEvent(int r100, String r101, boolean r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OMNIAVReplyBeginEvent$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.modelType = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.isModelProactiveSpeak = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.linkState = null;
        return;
    L15:
        this.linkState = r103;
        return;
    L11:
        this.isModelProactiveSpeak = r102;
        goto L13
    L7:
        this.modelType = r101;
        goto L9
    }

    public /* synthetic */ OMNIAVReplyBeginEvent(String r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
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
