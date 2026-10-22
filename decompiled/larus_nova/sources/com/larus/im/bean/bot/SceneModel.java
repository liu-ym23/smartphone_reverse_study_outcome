package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.tencent.open.SocialConstants;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 o2\u00060\u0001j\u0002`\u0002:\u0002noB¥\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016B\u009d\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\b\u0010Q\u001a\u00020\u0006H\u0016J\t\u0010R\u001a\u00020\u0004HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00104J\t\u0010Y\u001a\u00020\u0004HÆ\u0003J\t\u0010Z\u001a\u00020\u0004HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010]\u001a\u00020\fHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J¬\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\f2\b\u0010c\u001a\u0004\u0018\u00010dHÖ\u0003J\t\u0010e\u001a\u00020\u0004HÖ\u0001J%\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u00002\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020lH\u0001¢\u0006\u0002\bmR$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R&\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R&\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R&\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R(\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00107\u0012\u0004\b2\u0010\u001c\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R$\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R&\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u0010\u001c\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R&\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010\u001c\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R$\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u0010\u001c\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bI\u0010\u001c\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010\u001c\u001a\u0004\bO\u0010F\"\u0004\bP\u0010H¨\u0006p"}, d2 = {"Lcom/larus/im/bean/bot/SceneModel;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "id", "", "name", "", SocialConstants.PARAM_APP_DESC, "key", "iconDefault", "iconSelected", "useOriginalIcon", "", "listenWaitingTime", "triggerContinueInterval", "speakerId", "iconShowOutSide", "enableSubtitle", "callInstructionModel", "Lcom/larus/im/bean/bot/CallInstructionModel;", "notTriggerHello", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IILjava/lang/String;Ljava/lang/String;ZLcom/larus/im/bean/bot/CallInstructionModel;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IILjava/lang/String;Ljava/lang/String;ZLcom/larus/im/bean/bot/CallInstructionModel;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()I", "setId", "(I)V", "getName$annotations", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDesc$annotations", "getDesc", "setDesc", "getKey$annotations", "getKey", "setKey", "getIconDefault$annotations", "getIconDefault", "setIconDefault", "getIconSelected$annotations", "getIconSelected", "setIconSelected", "getUseOriginalIcon$annotations", "getUseOriginalIcon", "()Ljava/lang/Boolean;", "setUseOriginalIcon", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getListenWaitingTime$annotations", "getListenWaitingTime", "setListenWaitingTime", "getTriggerContinueInterval$annotations", "getTriggerContinueInterval", "setTriggerContinueInterval", "getSpeakerId$annotations", "getSpeakerId", "setSpeakerId", "getIconShowOutSide$annotations", "getIconShowOutSide", "setIconShowOutSide", "getEnableSubtitle$annotations", "getEnableSubtitle", "()Z", "setEnableSubtitle", "(Z)V", "getCallInstructionModel$annotations", "getCallInstructionModel", "()Lcom/larus/im/bean/bot/CallInstructionModel;", "setCallInstructionModel", "(Lcom/larus/im/bean/bot/CallInstructionModel;)V", "getNotTriggerHello$annotations", "getNotTriggerHello", "setNotTriggerHello", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IILjava/lang/String;Ljava/lang/String;ZLcom/larus/im/bean/bot/CallInstructionModel;Z)Lcom/larus/im/bean/bot/SceneModel;", "equals", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SceneModel implements java.io.Serializable {
    public static final b Companion = null;
    private CallInstructionModel callInstructionModel;
    private String desc;
    private boolean enableSubtitle;
    private String iconDefault;
    private String iconSelected;
    private String iconShowOutSide;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f346486id;
    private String key;
    private int listenWaitingTime;
    private String name;
    private boolean notTriggerHello;
    private String speakerId;
    private int triggerContinueInterval;
    private Boolean useOriginalIcon;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SceneModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346487a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346488b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346488b;
        }

        static {
            a r100 = new a();
            f346487a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.SceneModel", r100, 14);
            r101.j("id", true);
            r101.j("model_name", true);
            r101.j("model_desc", true);
            r101.j("model_key", true);
            r101.j("model_icon_default", true);
            r101.j("model_icon_selected", true);
            r101.j("use_original_icon", true);
            r101.j("listen_waiting_time", true);
            r101.j("trigger_time_interval", true);
            r101.j("specified_speaker", true);
            r101.j("model_icon_show", true);
            r101.j("enable_default_subtitle", true);
            r101.j("call_instruction_model", true);
            r101.j("not_trigger_hello", true);
            f346488b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            v2 r101 = v2.f520790a;
            i r102 = i.f520705a;
            return new d[]{r100, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), r100, r100, kuc.a.d(r101), kuc.a.d(r101), r102, kuc.a.d(CallInstructionModel.a.f346455a), r102};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346488b;
            c r101 = r310.beginStructure(r100);
            int r110 = 9;
            int r111 = 10;
            if (r101.decodeSequentially() == false) goto L5;
            int r102 = r101.decodeIntElement(r100, 0);
            v2 r103 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 3, r103, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 4, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            Boolean r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 6, i.f520705a, null);
            int r107 = r101.decodeIntElement(r100, 7);
            int r108 = r101.decodeIntElement(r100, 8);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 9, r103, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 10, r103, null);
            boolean r116 = r101.decodeBooleanElement(r100, 11);
            CallInstructionModel r210 = (CallInstructionModel) r101.decodeNullableSerializableElement(r100, 12, CallInstructionModel.a.f346455a, null);
            String r211 = r109;
            boolean r212 = r101.decodeBooleanElement(r100, 13);
            Boolean r117 = r106;
            int r118 = r107;
            int r213 = r108;
            String r214 = r115;
            boolean r215 = r116;
            String r119 = r113;
            String r120 = r114;
            String r121 = r112;
            int r122 = r102;
            int r123 = 16383;
            String r124 = r104;
            String r125 = r105;
        L36:
            r101.endStructure(r100);
            return new SceneModel(r123, r122, r121, r119, r124, r120, r125, r117, r118, r213, r214, r211, r215, r210, r212, null);
        L5:
            int r126 = 13;
            String r127 = null;
            String r128 = null;
            CallInstructionModel r129 = null;
            String r130 = null;
            String r131 = null;
            Boolean r132 = null;
            String r133 = null;
            String r134 = null;
            String r216 = null;
            int r135 = 0;
            int r136 = 0;
            boolean r217 = false;
            int r218 = 0;
            int r219 = 0;
            boolean r220 = false;
            boolean r221 = true;
        L6:
            if (r221 == false) goto L35;
            int r137 = r101.decodeElementIndex(r100);
            switch(r137) {
                case -1: goto L34;
                case 0: goto L32;
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L27;
                case 4: goto L25;
                case 5: goto L23;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r137);
        L34:
            r126 = 13;
            r110 = 9;
            r221 = false;
            goto L6
        L11:
            r217 = r101.decodeBooleanElement(r100, r126);
            r136 = r136 | 8192;
        L16:
            r216 = r216;
        L33:
            r216 = r216;
            r134 = r134;
            r126 = 13;
            r110 = 9;
            r111 = 10;
            goto L6
        L13:
            r129 = (CallInstructionModel) r101.decodeNullableSerializableElement(r100, 12, CallInstructionModel.a.f346455a, r129);
            r136 = r136 | 4096;
            goto L16
        L14:
            r220 = r101.decodeBooleanElement(r100, 11);
            r136 = r136 | 2048;
            goto L16
        L15:
            r131 = (String) r101.decodeNullableSerializableElement(r100, r111, v2.f520790a, r131);
            r136 = r136 | 1024;
            goto L16
        L18:
            r130 = (String) r101.decodeNullableSerializableElement(r100, r110, v2.f520790a, r130);
            int r138 = r136 | 512;
        L24:
            r216 = r216;
        L26:
            r136 = r138;
            goto L33
        L19:
            r219 = r101.decodeIntElement(r100, 8);
            r138 = r136 | 256;
            goto L24
        L20:
            r218 = r101.decodeIntElement(r100, 7);
            r138 = r136 | 128;
            goto L24
        L21:
            r132 = (Boolean) r101.decodeNullableSerializableElement(r100, 6, i.f520705a, r132);
            r138 = r136 | 64;
            goto L24
        L23:
            r216 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r216);
            r138 = r136 | 32;
            goto L24
        L25:
            r216 = r216;
            r133 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r133);
            r138 = r136 | 16;
            goto L26
        L27:
            r128 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r128);
            int r139 = r136 | 8;
        L28:
            String r140 = r134;
        L31:
            r134 = r140;
            r136 = r139;
            goto L33
        L29:
            r127 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r127);
            r139 = r136 | 4;
            goto L28
        L30:
            r216 = r216;
            int r141 = r136 | 2;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r134);
            r139 = r141;
            goto L31
        L32:
            r134 = r134;
            r216 = r216;
            r135 = r101.decodeIntElement(r100, 0);
            r136 = r136 | 1;
            goto L33
        L35:
            String r142 = r134;
            r119 = r127;
            r214 = r130;
            r123 = r136;
            r125 = r216;
            r211 = r131;
            r117 = r132;
            r120 = r133;
            r212 = r217;
            r118 = r218;
            r213 = r219;
            r215 = r220;
            r122 = r135;
            r124 = r128;
            r210 = r129;
            r121 = r142;
            goto L36
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SceneModel r102 = (SceneModel) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346488b;
            muc.d r104 = r100.beginStructure(r103);
            SceneModel.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SceneModel> serializer() {
            return a.f346487a;
        }
    }

    public SceneModel() {
        this(0, null, null, null, null, null, null, 0, 0, null, null, false, null, false, 16383, null);
    }

    public static /* synthetic */ SceneModel copy$default(SceneModel r110, int r111, String r112, String r113, String r114, String r210, String r211, Boolean r212, int r213, int r214, String r215, String r216, boolean r217, CallInstructionModel r218, boolean r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        int r100 = r110.f346486id;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r310 & 4) == 0) goto L13;
        String r102 = r110.desc;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = r110.key;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.iconDefault;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.iconSelected;
    L27:
        if ((r310 & 64) == 0) goto L29;
        Boolean r106 = r110.useOriginalIcon;
    L31:
        if ((r310 & 128) == 0) goto L33;
        int r107 = r110.listenWaitingTime;
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r115 = r110.triggerContinueInterval;
    L39:
        if ((r310 & 512) == 0) goto L41;
        String r116 = r110.speakerId;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        String r117 = r110.iconShowOutSide;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        boolean r118 = r110.enableSubtitle;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        CallInstructionModel r119 = r110.callInstructionModel;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        boolean r108 = r110.notTriggerHello;
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

    @SerialName("model_desc")
    public static /* synthetic */ void getDesc$annotations() {
    }

    @SerialName("enable_default_subtitle")
    public static /* synthetic */ void getEnableSubtitle$annotations() {
    }

    @SerialName("model_icon_default")
    public static /* synthetic */ void getIconDefault$annotations() {
    }

    @SerialName("model_icon_selected")
    public static /* synthetic */ void getIconSelected$annotations() {
    }

    @SerialName("model_icon_show")
    public static /* synthetic */ void getIconShowOutSide$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("model_key")
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName("listen_waiting_time")
    public static /* synthetic */ void getListenWaitingTime$annotations() {
    }

    @SerialName("model_name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("not_trigger_hello")
    public static /* synthetic */ void getNotTriggerHello$annotations() {
    }

    @SerialName("specified_speaker")
    public static /* synthetic */ void getSpeakerId$annotations() {
    }

    @SerialName("trigger_time_interval")
    public static /* synthetic */ void getTriggerContinueInterval$annotations() {
    }

    @SerialName("use_original_icon")
    public static /* synthetic */ void getUseOriginalIcon$annotations() {
    }

    public final int component1() {
        return this.f346486id;
    }

    public final String component10() {
        return this.speakerId;
    }

    public final String component11() {
        return this.iconShowOutSide;
    }

    public final boolean component12() {
        return this.enableSubtitle;
    }

    public final CallInstructionModel component13() {
        return this.callInstructionModel;
    }

    public final boolean component14() {
        return this.notTriggerHello;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.key;
    }

    public final String component5() {
        return this.iconDefault;
    }

    public final String component6() {
        return this.iconSelected;
    }

    public final Boolean component7() {
        return this.useOriginalIcon;
    }

    public final int component8() {
        return this.listenWaitingTime;
    }

    public final int component9() {
        return this.triggerContinueInterval;
    }

    public final SceneModel copy(int r110, String r111, String r112, String r210, String r211, String r212, Boolean r213, int r214, int r215, String r216, String r217, boolean r218, CallInstructionModel r219, boolean r310) {
        return new SceneModel(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SceneModel) == true) goto L8;
        return false;
    L8:
        SceneModel r101 = (SceneModel) r100;
        if (this.f346486id == r101.f346486id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconDefault, r101.iconDefault) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconSelected, r101.iconSelected) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.useOriginalIcon, r101.useOriginalIcon) == true) goto L30;
        return false;
    L30:
        if (this.listenWaitingTime == r101.listenWaitingTime) goto L33;
        return false;
    L33:
        if (this.triggerContinueInterval == r101.triggerContinueInterval) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.speakerId, r101.speakerId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.iconShowOutSide, r101.iconShowOutSide) == true) goto L42;
        return false;
    L42:
        if (this.enableSubtitle == r101.enableSubtitle) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.callInstructionModel, r101.callInstructionModel) == true) goto L48;
        return false;
    L48:
        if (this.notTriggerHello == r101.notTriggerHello) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r100 = this.f346486id * 31;
        String r101 = this.name;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.desc;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.key;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.iconDefault;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.iconSelected;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.useOriginalIcon;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (((((r116 + r118) * 31) + this.listenWaitingTime) * 31) + this.triggerContinueInterval) * 31;
        String r120 = this.speakerId;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.iconShowOutSide;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        int r126 = 1231;
        if (this.enableSubtitle == false) goto L37;
        int r127 = 1231;
    L38:
        int r128 = (r125 + r127) * 31;
        CallInstructionModel r129 = this.callInstructionModel;
        if (r129 == null) goto L42;
        r102 = r129.hashCode();
    L42:
        int r130 = (r128 + r102) * 31;
        if (this.notTriggerHello == true) goto L47;
        r126 = 1237;
    L47:
        return r130 + r126;
    L37:
        r127 = 1237;
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
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

    static {
        Companion = new b();
    }

    public String toString() {
        return "id:" + this.f346486id + ", name:" + this.name + ", desc:" + this.desc + ", key:" + this.key + ", listenWaitingTime:" + this.listenWaitingTime + ", triggerContinueInterval:" + this.triggerContinueInterval + ", speakerId:" + this.speakerId;
    }

    public final CallInstructionModel getCallInstructionModel() {
        return this.callInstructionModel;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getEnableSubtitle() {
        return this.enableSubtitle;
    }

    public final String getIconDefault() {
        return this.iconDefault;
    }

    public final String getIconSelected() {
        return this.iconSelected;
    }

    public final String getIconShowOutSide() {
        return this.iconShowOutSide;
    }

    public final int getId() {
        return this.f346486id;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getListenWaitingTime() {
        return this.listenWaitingTime;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNotTriggerHello() {
        return this.notTriggerHello;
    }

    public final String getSpeakerId() {
        return this.speakerId;
    }

    public final int getTriggerContinueInterval() {
        return this.triggerContinueInterval;
    }

    public final Boolean getUseOriginalIcon() {
        return this.useOriginalIcon;
    }

    public final void setCallInstructionModel(CallInstructionModel r100) {
        this.callInstructionModel = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setEnableSubtitle(boolean r100) {
        this.enableSubtitle = r100;
    }

    public final void setIconDefault(String r100) {
        this.iconDefault = r100;
    }

    public final void setIconSelected(String r100) {
        this.iconSelected = r100;
    }

    public final void setIconShowOutSide(String r100) {
        this.iconShowOutSide = r100;
    }

    public final void setId(int r100) {
        this.f346486id = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setListenWaitingTime(int r100) {
        this.listenWaitingTime = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setNotTriggerHello(boolean r100) {
        this.notTriggerHello = r100;
    }

    public final void setSpeakerId(String r100) {
        this.speakerId = r100;
    }

    public final void setTriggerContinueInterval(int r100) {
        this.triggerContinueInterval = r100;
    }

    public final void setUseOriginalIcon(Boolean r100) {
        this.useOriginalIcon = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(SceneModel r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.f346486id);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.name);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.desc);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.key);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.iconDefault);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.iconSelected);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, i.f520705a, r100.useOriginalIcon);
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
        r101.encodeIntElement(r102, 8, r100.triggerContinueInterval);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r113 = true;
    L90:
        if (r113 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, v2.f520790a, r100.speakerId);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r114 = true;
    L99:
        if (r114 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, v2.f520790a, r100.iconShowOutSide);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        boolean r115 = true;
    L108:
        if (r115 == false) goto L111;
        r101.encodeBooleanElement(r102, 11, r100.enableSubtitle);
    L111:
        if (r101.shouldEncodeElementDefault(r102, 12) == false) goto L114;
    L112:
        boolean r116 = true;
    L117:
        if (r116 == false) goto L120;
        r101.encodeNullableSerializableElement(r102, 12, CallInstructionModel.a.f346455a, r100.callInstructionModel);
    L120:
        if (r101.shouldEncodeElementDefault(r102, 13) == false) goto L123;
    L121:
        r103 = true;
    L125:
        if (r103 == false) goto L128;
        r101.encodeBooleanElement(r102, 13, r100.notTriggerHello);
        return;
    L128:
        return;
    L123:
        if (r100.notTriggerHello == false) goto L125;
    L114:
        if (r100.callInstructionModel != null) goto L112;
        r116 = false;
        goto L117
    L105:
        if (r100.enableSubtitle == true) goto L103;
        r115 = false;
        goto L108
    L96:
        if (r100.iconShowOutSide != null) goto L94;
        r114 = false;
        goto L99
    L87:
        if (r100.speakerId != null) goto L85;
        r113 = false;
        goto L90
    L78:
        if (r100.triggerContinueInterval != 0) goto L76;
        r112 = false;
        goto L81
    L69:
        if (r100.listenWaitingTime != 0) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.useOriginalIcon != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.iconSelected != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.iconDefault != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.key != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.desc != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.name != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.f346486id != 0) goto L4;
        r104 = false;
        goto L9
    }

    public SceneModel(int r100, String r101, String r102, String r103, String r104, String r105, Boolean r106, int r107, int r108, String r110, String r111, boolean r112, CallInstructionModel r113, boolean r114) {
        this.f346486id = r100;
        this.name = r101;
        this.desc = r102;
        this.key = r103;
        this.iconDefault = r104;
        this.iconSelected = r105;
        this.useOriginalIcon = r106;
        this.listenWaitingTime = r107;
        this.triggerContinueInterval = r108;
        this.speakerId = r110;
        this.iconShowOutSide = r111;
        this.enableSubtitle = r112;
        this.callInstructionModel = r113;
        this.notTriggerHello = r114;
    }

    public SceneModel(int r100, int r101, String r102, String r103, String r110, String r111, String r112, Boolean r113, int r114, int r115, String r116, String r117, boolean r118, CallInstructionModel r119, boolean r210, q2 r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346488b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f346486id = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.name = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.desc = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.key = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.iconDefault = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.iconSelected = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.useOriginalIcon = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.listenWaitingTime = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.triggerContinueInterval = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.speakerId = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.iconShowOutSide = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.enableSubtitle = false;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.callInstructionModel = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.notTriggerHello = false;
        return;
    L59:
        this.notTriggerHello = r210;
        return;
    L55:
        this.callInstructionModel = r119;
        goto L57
    L51:
        this.enableSubtitle = r118;
        goto L53
    L47:
        this.iconShowOutSide = r117;
        goto L49
    L43:
        this.speakerId = r116;
        goto L45
    L39:
        this.triggerContinueInterval = r115;
        goto L41
    L35:
        this.listenWaitingTime = r114;
        goto L37
    L31:
        this.useOriginalIcon = r113;
        goto L33
    L27:
        this.iconSelected = r112;
        goto L29
    L23:
        this.iconDefault = r111;
        goto L25
    L19:
        this.key = r110;
        goto L21
    L15:
        this.desc = r103;
        goto L17
    L11:
        this.name = r102;
        goto L13
    L7:
        this.f346486id = r101;
        goto L9
    }

    public /* synthetic */ SceneModel(int r110, String r111, String r112, String r210, String r211, String r212, Boolean r213, int r214, int r215, String r216, String r217, boolean r218, CallInstructionModel r219, boolean r310, int r311, DefaultConstructorMarker r312) {
        boolean r100 = false;
        if ((r311 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        CallInstructionModel r102 = null;
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
        Boolean r108 = null;
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
        r102 = r219;
    L55:
        if ((r311 & 8192) != 0) goto L58;
        r100 = r310;
    L58:
        this(r101, r103, r104, r105, r106, r107, r108, r113, r114, r115, r116, r117, r102, r100);
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
