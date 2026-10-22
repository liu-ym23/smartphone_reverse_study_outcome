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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00060\u0001j\u0002`\u0002:\u0002FGB£\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016B\u009b\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\t\u0010*\u001a\u00020\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u00020\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¥\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\t\u0010=\u001a\u00020\u0006HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001cR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001cR\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001cR\u0016\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b'\u0010\u001cR\u0016\u0010\u0012\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001c¨\u0006H"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniCallSceneModel;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "id", "", "modelName", "", "modelDesc", "modelKey", "modelIconDefault", "modelIconSelected", "useOriginalIcon", "", "listenWaitingTime", "triggerTimeInterval", "specifiedSpeaker", "modelIconShow", "enableDefaultSubtitle", "notTriggerHello", "callInstructionModel", "Lcom/larus/im/internal/jni/bean/OmniCallInstructionModel;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;ZZLcom/larus/im/internal/jni/bean/OmniCallInstructionModel;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;ZZLcom/larus/im/internal/jni/bean/OmniCallInstructionModel;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getModelName$annotations", "getModelDesc$annotations", "getModelKey$annotations", "getModelIconDefault$annotations", "getModelIconSelected$annotations", "getUseOriginalIcon$annotations", "getListenWaitingTime$annotations", "getTriggerTimeInterval$annotations", "getSpecifiedSpeaker$annotations", "getModelIconShow$annotations", "getEnableDefaultSubtitle$annotations", "getNotTriggerHello$annotations", "getCallInstructionModel$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniCallSceneModel implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OmniCallInstructionModel callInstructionModel;
    public final boolean enableDefaultSubtitle;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f348652id;
    public final int listenWaitingTime;
    public final String modelDesc;
    public final String modelIconDefault;
    public final String modelIconSelected;
    public final String modelIconShow;
    public final String modelKey;
    public final String modelName;
    public final boolean notTriggerHello;
    public final String specifiedSpeaker;
    public final int triggerTimeInterval;
    public final boolean useOriginalIcon;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniCallSceneModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniCallSceneModel;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniCallSceneModel> serializer() {
            return OmniCallSceneModel$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniCallSceneModel() {
        this(0, null, null, null, null, null, false, 0, 0, null, null, false, false, null, 16383, null);
    }

    public static /* synthetic */ OmniCallSceneModel copy$default(OmniCallSceneModel r110, int r111, String r112, String r113, String r114, String r210, String r211, boolean r212, int r213, int r214, String r215, String r216, boolean r217, boolean r218, OmniCallInstructionModel r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        int r100 = r110.f348652id;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.modelName;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.modelDesc;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.modelKey;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.modelIconDefault;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.modelIconSelected;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r106 = r110.useOriginalIcon;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r107 = r110.listenWaitingTime;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = r110.triggerTimeInterval;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.specifiedSpeaker;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.modelIconShow;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        boolean r118 = r110.enableDefaultSubtitle;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        boolean r119 = r110.notTriggerHello;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        OmniCallInstructionModel r108 = r110.callInstructionModel;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("call_instruction_model")
    public static /* synthetic */ void getCallInstructionModel$annotations() {
    }

    @SerialName("enable_default_subtitle")
    public static /* synthetic */ void getEnableDefaultSubtitle$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("listen_waiting_time")
    public static /* synthetic */ void getListenWaitingTime$annotations() {
    }

    @SerialName("model_desc")
    public static /* synthetic */ void getModelDesc$annotations() {
    }

    @SerialName("model_icon_default")
    public static /* synthetic */ void getModelIconDefault$annotations() {
    }

    @SerialName("model_icon_selected")
    public static /* synthetic */ void getModelIconSelected$annotations() {
    }

    @SerialName("model_icon_show")
    public static /* synthetic */ void getModelIconShow$annotations() {
    }

    @SerialName("model_key")
    public static /* synthetic */ void getModelKey$annotations() {
    }

    @SerialName("model_name")
    public static /* synthetic */ void getModelName$annotations() {
    }

    @SerialName("not_trigger_hello")
    public static /* synthetic */ void getNotTriggerHello$annotations() {
    }

    @SerialName("specified_speaker")
    public static /* synthetic */ void getSpecifiedSpeaker$annotations() {
    }

    @SerialName("trigger_time_interval")
    public static /* synthetic */ void getTriggerTimeInterval$annotations() {
    }

    @SerialName("use_original_icon")
    public static /* synthetic */ void getUseOriginalIcon$annotations() {
    }

    public final int component1() {
        return this.f348652id;
    }

    public final String component10() {
        return this.specifiedSpeaker;
    }

    public final String component11() {
        return this.modelIconShow;
    }

    public final boolean component12() {
        return this.enableDefaultSubtitle;
    }

    public final boolean component13() {
        return this.notTriggerHello;
    }

    public final OmniCallInstructionModel component14() {
        return this.callInstructionModel;
    }

    public final String component2() {
        return this.modelName;
    }

    public final String component3() {
        return this.modelDesc;
    }

    public final String component4() {
        return this.modelKey;
    }

    public final String component5() {
        return this.modelIconDefault;
    }

    public final String component6() {
        return this.modelIconSelected;
    }

    public final boolean component7() {
        return this.useOriginalIcon;
    }

    public final int component8() {
        return this.listenWaitingTime;
    }

    public final int component9() {
        return this.triggerTimeInterval;
    }

    public final OmniCallSceneModel copy(int r110, String r111, String r112, String r210, String r211, String r212, boolean r213, int r214, int r215, String r216, String r217, boolean r218, boolean r219, OmniCallInstructionModel r310) {
        return new OmniCallSceneModel(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniCallSceneModel) == true) goto L8;
        return false;
    L8:
        OmniCallSceneModel r101 = (OmniCallSceneModel) r100;
        if (this.f348652id == r101.f348652id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.modelName, r101.modelName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelDesc, r101.modelDesc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.modelKey, r101.modelKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.modelIconDefault, r101.modelIconDefault) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.modelIconSelected, r101.modelIconSelected) == true) goto L27;
        return false;
    L27:
        if (this.useOriginalIcon == r101.useOriginalIcon) goto L30;
        return false;
    L30:
        if (this.listenWaitingTime == r101.listenWaitingTime) goto L33;
        return false;
    L33:
        if (this.triggerTimeInterval == r101.triggerTimeInterval) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.specifiedSpeaker, r101.specifiedSpeaker) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.modelIconShow, r101.modelIconShow) == true) goto L42;
        return false;
    L42:
        if (this.enableDefaultSubtitle == r101.enableDefaultSubtitle) goto L45;
        return false;
    L45:
        if (this.notTriggerHello == r101.notTriggerHello) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.callInstructionModel, r101.callInstructionModel) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r100 = this.f348652id * 31;
        String r101 = this.modelName;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.modelDesc;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.modelKey;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.modelIconDefault;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.modelIconSelected;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        int r117 = 1231;
        if (this.useOriginalIcon == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (((((r116 + r118) * 31) + this.listenWaitingTime) * 31) + this.triggerTimeInterval) * 31;
        String r120 = this.specifiedSpeaker;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.modelIconShow;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        if (this.enableDefaultSubtitle == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (r125 + r126) * 31;
        if (this.notTriggerHello == true) goto L42;
        r117 = 1237;
    L42:
        int r128 = (r127 + r117) * 31;
        OmniCallInstructionModel r129 = this.callInstructionModel;
        if (r129 == null) goto L47;
        r102 = r129.hashCode();
    L47:
        return r128 + r102;
    L37:
        r126 = 1237;
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = 1237;
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniCallSceneModel(id=" + this.f348652id + ", modelName=" + this.modelName + ", modelDesc=" + this.modelDesc + ", modelKey=" + this.modelKey + ", modelIconDefault=" + this.modelIconDefault + ", modelIconSelected=" + this.modelIconSelected + ", useOriginalIcon=" + this.useOriginalIcon + ", listenWaitingTime=" + this.listenWaitingTime + ", triggerTimeInterval=" + this.triggerTimeInterval + ", specifiedSpeaker=" + this.specifiedSpeaker + ", modelIconShow=" + this.modelIconShow + ", enableDefaultSubtitle=" + this.enableDefaultSubtitle + ", notTriggerHello=" + this.notTriggerHello + ", callInstructionModel=" + this.callInstructionModel + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniCallSceneModel r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.f348652id);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.modelName);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.modelDesc);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.modelKey);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.modelIconDefault);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.modelIconSelected);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeBooleanElement(r102, 6, r100.useOriginalIcon);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeIntElement(r102, 7, r100.listenWaitingTime);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r112 = true;
    L81:
        if (r112 == false) goto L84;
        r101.encodeIntElement(r102, 8, r100.triggerTimeInterval);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.specifiedSpeaker);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.modelIconShow);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeBooleanElement(r102, 11, r100.enableDefaultSubtitle);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeBooleanElement(r102, 12, r100.notTriggerHello);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        r103 = true;
    L125:
        if (r103 == false) goto L128;
        r101.encodeNullableSerializableElement(r102, 13, OmniCallInstructionModel$$serializer.INSTANCE, r100.callInstructionModel);
        return;
    L128:
        return;
    L123:
        if (r100.callInstructionModel == null) goto L125;
    L114:
        if (r100.notTriggerHello == true) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.enableDefaultSubtitle == true) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.modelIconShow != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.specifiedSpeaker != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.triggerTimeInterval != 0) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.listenWaitingTime != 0) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.useOriginalIcon == true) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.modelIconSelected != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.modelIconDefault != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.modelKey != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.modelDesc != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.modelName != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.f348652id != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OmniCallSceneModel(int r100, String r101, String r102, String r103, String r104, String r105, boolean r106, int r107, int r108, String r110, String r111, boolean r112, boolean r113, OmniCallInstructionModel r114) {
        this.f348652id = r100;
        this.modelName = r101;
        this.modelDesc = r102;
        this.modelKey = r103;
        this.modelIconDefault = r104;
        this.modelIconSelected = r105;
        this.useOriginalIcon = r106;
        this.listenWaitingTime = r107;
        this.triggerTimeInterval = r108;
        this.specifiedSpeaker = r110;
        this.modelIconShow = r111;
        this.enableDefaultSubtitle = r112;
        this.notTriggerHello = r113;
        this.callInstructionModel = r114;
    }

    public /* synthetic */ OmniCallSceneModel(int r100, int r101, String r102, String r103, String r110, String r111, String r112, boolean r113, int r114, int r115, String r116, String r117, boolean r118, boolean r119, OmniCallInstructionModel r210, q2 r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniCallSceneModel$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f348652id = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.modelName = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.modelDesc = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.modelKey = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.modelIconDefault = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.modelIconSelected = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.useOriginalIcon = false;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.listenWaitingTime = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.triggerTimeInterval = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.specifiedSpeaker = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.modelIconShow = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.enableDefaultSubtitle = false;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.notTriggerHello = false;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.callInstructionModel = null;
        return;
    L59:
        this.callInstructionModel = r210;
        return;
    L55:
        this.notTriggerHello = r119;
        goto L57
    L51:
        this.enableDefaultSubtitle = r118;
        goto L53
    L47:
        this.modelIconShow = r117;
        goto L49
    L43:
        this.specifiedSpeaker = r116;
        goto L45
    L39:
        this.triggerTimeInterval = r115;
        goto L41
    L35:
        this.listenWaitingTime = r114;
        goto L37
    L31:
        this.useOriginalIcon = r113;
        goto L33
    L27:
        this.modelIconSelected = r112;
        goto L29
    L23:
        this.modelIconDefault = r111;
        goto L25
    L19:
        this.modelKey = r110;
        goto L21
    L15:
        this.modelDesc = r103;
        goto L17
    L11:
        this.modelName = r102;
        goto L13
    L7:
        this.f348652id = r101;
        goto L9
    }

    public /* synthetic */ OmniCallSceneModel(int r110, String r111, String r112, String r210, String r211, String r212, boolean r213, int r214, int r215, String r216, String r217, boolean r218, boolean r219, OmniCallInstructionModel r310, int r311, DefaultConstructorMarker r312) {
        boolean r100 = false;
        if ((r311 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        OmniCallInstructionModel r102 = null;
        if ((r311 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r311 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r311 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r311 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r311 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r311 & 64) == 0) goto L29;
        boolean r108 = false;
    L31:
        if ((r311 & 128) == 0) goto L33;
        int r113 = 0;
    L35:
        if ((r311 & 256) == 0) goto L37;
        int r114 = 0;
    L39:
        if ((r311 & 512) == 0) goto L41;
        String r115 = null;
    L43:
        if ((r311 & 1024) == 0) goto L45;
        String r116 = null;
    L47:
        if ((r311 & 2048) == 0) goto L49;
        boolean r117 = false;
    L51:
        if ((r311 & 4096) != 0) goto L55;
        r100 = r219;
    L55:
        if ((r311 & 8192) != 0) goto L58;
        r102 = r310;
    L58:
        this(r101, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r100, r102);
        return;
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r113 = r214;
        goto L35
    L29:
        r108 = r213;
        goto L31
    L25:
        r107 = r212;
        goto L27
    L21:
        r106 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
