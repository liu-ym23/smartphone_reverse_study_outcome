package com.obric.assistant.component;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001M\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001sB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020PH\u0016J\b\u0010R\u001a\u00020FH\u0016J\b\u0010S\u001a\u00020FH\u0016J\b\u0010T\u001a\u00020FH\u0016J\b\u0010U\u001a\u00020FH\u0016J\b\u0010V\u001a\u00020FH\u0016J\u0014\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020[H\u0016J\b\u0010]\u001a\u00020[H\u0016J\b\u0010^\u001a\u00020\u0003H\u0016J\u0012\u0010_\u001a\u00020P2\b\u0010`\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010b\u001a\u00020P2\b\u0010`\u001a\u0004\u0018\u00010>2\u0006\u0010\\\u001a\u00020[H\u0016J\u0010\u0010c\u001a\u00020P2\u0006\u0010d\u001a\u00020[H\u0016J\u001e\u0010e\u001a\u00020P2\u0006\u0010f\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020P0iH\u0002J\b\u0010j\u001a\u00020[H\u0002J\b\u0010k\u001a\u00020[H\u0002J#\u0010l\u001a\u0004\u0018\u00010[2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020o0nH\u0016¢\u0006\u0002\u0010pJ\u001e\u0010q\u001a\u00020P2\u0014\u0010m\u001a\u0010\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0016J\b\u0010r\u001a\u00020[H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0016\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010NR\u000e\u0010a\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/obric/assistant/component/OrionChatSpeakerComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/audio/IChatSpeakerExtraAbility;", "Lcom/obric/assistant/ability/audio/ChatSpeakerResCallback;", "<init>", "()V", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "obricSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getObricSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "obricSpecialInputAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatWindowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getChatWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "chatWindowAbility$delegate", "refMessageAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getRefMessageAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "refMessageAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "voiceVisualizerContainer", "Landroid/view/ViewGroup;", "getVoiceVisualizerContainer", "()Landroid/view/ViewGroup;", "canvasInputText", "Landroid/widget/TextView;", "getCanvasInputText", "()Landroid/widget/TextView;", "cancelColor", "", "colors", "", "darkColors", "positions", "", "textWatcher", "com/obric/assistant/component/OrionChatSpeakerComponent$textWatcher$1", "Lcom/obric/assistant/component/OrionChatSpeakerComponent$textWatcher$1;", "onParentViewCreated", "", LiveCommonConstants.REASON_ON_DEDTROY, "getShadowRes", "getNormalRes", "getCancelRes", "getTipsColor", "getTipsCancelColor", "getNormalTips", "", "tips", "isHideTips", "", "toCancel", "enableShowAudioAnim", "getResCallback", "initVisualizer", "visualizerContainer", "isGradientApplied", "onSwitchStatus", "onVisibilityChanged", "isVisible", "delayUpdateAudioVisualizerGradient", "audioVisualizerOpt", "Landroid/view/View;", "gradientFunc", "Lkotlin/Function0;", "isInstructionOpen", "isInstructionEditorShorterThanShadow", "shouldCancel", "xy", "Lkotlin/Pair;", "", "(Lkotlin/Pair;)Ljava/lang/Boolean;", "updateTouchPosition", "isWindowEnable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionChatSpeakerComponent extends ComponentFeature implements maa.f, maa.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f388281x = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f388282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f388283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f388284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f388285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f388286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f388287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f388288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f388289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f388290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f388291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f388292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f388293s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f388294t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float[] f388295u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l f388296v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f388297w;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    public static final class b implements Function0<va8.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388298a;

        public b(AttachReceiver r100) {
            this.f388298a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.o] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.o invoke() {
            AttachReceiver r100 = this.f388298a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class c implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388299a;

        public c(AttachReceiver r100) {
            this.f388299a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f388299a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class d implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388300a;

        public d(AttachReceiver r100) {
            this.f388300a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f388300a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class e implements Function0<laa.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388301a;

        public e(AttachReceiver r100) {
            this.f388301a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.j, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.j invoke() {
            AttachReceiver r100 = this.f388301a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class f implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388302a;

        public f(AttachReceiver r100) {
            this.f388302a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f388302a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388303a;

        public g(AttachReceiver r100) {
            this.f388303a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.g1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.attachment.g1 invoke() {
            AttachReceiver r100 = this.f388303a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.attachment.g1.class));
        }
    }

    public static final class h implements Function0<laa.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388304a;

        public h(AttachReceiver r100) {
            this.f388304a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.m, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.m invoke() {
            AttachReceiver r100 = this.f388304a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.chat.component.bottom.reference.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388305a;

        public i(AttachReceiver r100) {
            this.f388305a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.reference.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.reference.a invoke() {
            AttachReceiver r100 = this.f388305a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.reference.a.class));
        }
    }

    public static final class j implements Function0<maa.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388306a;

        public j(AttachReceiver r100) {
            this.f388306a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [maa.e, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final maa.e invoke() {
            AttachReceiver r100 = this.f388306a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class k implements Function0<laa.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388307a;

        public k(AttachReceiver r100) {
            this.f388307a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.f, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.f invoke() {
            AttachReceiver r100 = this.f388307a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class l implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrionChatSpeakerComponent f388308a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public l(OrionChatSpeakerComponent r100) {
            this.f388308a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            boolean r101 = true;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L20;
            maa.e r103 = (maa.e) this.f388308a.f388289o.getValue();
            if (r103 != null) goto L12;
        L14:
            r101 = false;
        L15:
            if (r101 == false) goto L21;
            FLogger.f375446a.i("OrionChatSpeakerComponent", "onTextChanged: " + r100 + ", close click talk");
            maa.e r104 = (maa.e) this.f388308a.f388289o.getValue();
            if (r104 == null) goto L22;
            maa.e.a.a(r104, null, null, false, 7);
            return;
        L22:
            return;
        L21:
            return;
        L12:
            if (r103.x3() != true) goto L14;
        L20:
            return;
        L5:
            if ((!StringsKt.isBlank(r100)) != true) goto L7;
            r102 = true;
            goto L8
        }
    }

    static {
    }

    @Override // maa.f
    public final maa.b nc() {
        return this;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        va8.o r100 = (va8.o) this.f388291q.getValue();
        TextView r101 = null;
        if (r100 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.a r102 = r100.Uv();
    L6:
        if (r102 == null) goto L8;
        ViewGroup r103 = r102.K();
    L9:
        if (r103 == null) goto L12;
        r103.setBackgroundResource(R.drawable.bg_obric_audio_visualizer);
    L12:
        if (Intrinsics.areEqual(s1a.a.getActivity(this).getClass().getSimpleName(), "CreationCanvasActivity") == false) goto L22;
        va8.o r104 = (va8.o) this.f388291q.getValue();
        if (r104 == null) goto L16;
        com.larus.bmhome.chat.component.bottom.core.a r105 = r104.Uv();
    L17:
        if (r105 == null) goto L19;
        r101 = r105.b();
    L19:
        if (r101 == null) goto L23;
        r101.addTextChangedListener(this.f388296v);
        return;
    L23:
        return;
    L16:
        r105 = null;
        goto L17
    L22:
        return;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final laa.d F2() {
        return (laa.d) this.f388282h.getValue();
    }

    public final boolean z0() {
        com.larus.bmhome.instruction.g r100 = (com.larus.bmhome.instruction.g) this.f388283i.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.z0() != true) goto L7;
        return true;
    }

    public OrionChatSpeakerComponent() {
        this.f388282h = LazyKt.lazy(new c(this));
        this.f388283i = LazyKt.lazy(new d(this));
        this.f388284j = LazyKt.lazy(new e(this));
        this.f388285k = LazyKt.lazy(new f(this));
        this.f388286l = LazyKt.lazy(new g(this));
        this.f388287m = LazyKt.lazy(new h(this));
        this.f388288n = LazyKt.lazy(new i(this));
        this.f388289o = LazyKt.lazy(new j(this));
        this.f388290p = LazyKt.lazy(new k(this));
        this.f388291q = LazyKt.lazy(new b(this));
        this.f388292r = -42663;
        this.f388293s = new int[]{-13146369, -35979, -19867};
        this.f388294t = new int[]{-8282369, -25956, -15222};
        this.f388295u = new float[]{0.38f, 0.74f, 1.0f};
        this.f388296v = new l(this);
    }

    @Override // maa.b
    public final boolean B0() {
        return !iC();
    }

    @Override // maa.b
    public final int T0() {
        boolean r100 = z0();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r101 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388286l.getValue();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        laa.d r104 = F2();
        if (r104 != null) goto L11;
    L13:
        if (r102 == false) goto L19;
        if (r100 == true) goto L18;
        if (r103 == true) goto L18;
        return R.drawable.bg_obric_audio_visualizer;
    L18:
        return R.drawable.bg_obric_audio_visualizer1;
    L19:
        if (r100 == true) goto L23;
        if (r103 == true) goto L23;
        return R.drawable.bg_obric_audio_visualizer_half_window;
    L23:
        return R.drawable.bg_obric_audio_visualizer_half_window1;
    L11:
        if (r104.aF() != true) goto L13;
        r102 = true;
        goto L13
    L5:
        if (r101.isVisible() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // maa.b
    public final int Z1() {
        laa.d r100 = F2();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = z0();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r104 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388286l.getValue();
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        laa.d r106 = F2();
        if (r106 != null) goto L17;
    L19:
        boolean r107 = false;
    L20:
        if (r103 == false) goto L44;
        com.larus.bmhome.instruction.g r108 = (com.larus.bmhome.instruction.g) this.f388283i.getValue();
        if (r108 == null) goto L41;
        ViewGroup r109 = r108.jy();
        if (r109 == null) goto L41;
        Integer r110 = Integer.valueOf(r109.getHeight());
        if (r110.intValue() <= 0) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == true) goto L33;
        r110 = null;
    L33:
        if (r110 == null) goto L35;
        int r112 = r110.intValue();
    L36:
        if (r112 <= 0) goto L41;
        if (r112 >= v19.i5.i()) goto L41;
        boolean r113 = true;
    L42:
        if (r113 == false) goto L44;
        boolean r114 = true;
    L45:
        com.larus.bmhome.chat.component.bottom.reference.a r115 = (com.larus.bmhome.chat.component.bottom.reference.a) this.f388288n.getValue();
        if (r115 != null) goto L48;
    L50:
        boolean r116 = false;
    L51:
        if (r103 == true) goto L54;
        if (r116 == true) goto L54;
        if (r105 == true) goto L54;
    L55:
        if (r102 == false) goto L61;
        if (r101 == false) goto L63;
        if (r114 == true) goto L60;
        return R.drawable.bg_speaker_shadow_obric;
    L60:
        return R.drawable.bg_speaker_shadow_obric_small;
    L63:
        return R.drawable.bg_obric_speaker_shadow;
    L61:
        if (r107 == false) goto L64;
        if (r101 == false) goto L63;
    L64:
        if (r107 == false) goto L68;
        if (r114 == true) goto L67;
        return R.drawable.bg_speaker_shadow_obric_half_window;
    L67:
        return R.drawable.bg_speaker_shadow_obric_half_window_small;
    L68:
        boolean r117 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L71;
        return R.drawable.larus_bg_speaker_shadow_night;
    L71:
        return R.drawable.larus_bg_speaker_shadow;
    L54:
        r101 = true;
        goto L55
    L48:
        if (r115.Qj() != true) goto L50;
        r116 = true;
        goto L51
    L35:
        r112 = r109.getMeasuredHeight();
        goto L36
    L29:
        r111 = false;
    L41:
        r113 = false;
    L44:
        r114 = false;
        goto L45
    L17:
        if (r106.Da() != true) goto L19;
        r107 = true;
        goto L20
    L11:
        if (r104.isVisible() != true) goto L13;
        r105 = true;
        goto L14
    L5:
        if (r100.aF() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // maa.b
    public final int g1() {
        laa.d r100 = F2();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = z0();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r104 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388286l.getValue();
        if (r104 != null) goto L11;
    L13:
        if (r102 == false) goto L18;
        if (r103 == true) goto L18;
        if (r101 == true) goto L18;
        return ColorProtector.parseColor("#B2FFFFFF");
    L18:
        return ContextCompat.getColor(getContext(), R.color.neutral_70);
    L11:
        if (r104.isVisible() != true) goto L13;
        r101 = true;
        goto L13
    L5:
        if (r100.aF() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // maa.f
    public final boolean iC() {
        IAssistantChatWindow r100 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isWindowMode() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // maa.b
    public final int k0() {
        boolean r100 = z0();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r101 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388286l.getValue();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        laa.d r104 = F2();
        if (r104 != null) goto L11;
    L13:
        if (r102 == false) goto L19;
        if (r100 == true) goto L18;
        if (r103 == true) goto L18;
        return R.drawable.bg_obric_audio_visualizer_release;
    L18:
        return R.drawable.bg_obric_audio_visualizer_release1;
    L19:
        if (r100 == true) goto L23;
        if (r103 == true) goto L23;
        return R.drawable.bg_obric_audio_visualizer_release_half_window;
    L23:
        return R.drawable.bg_obric_audio_visualizer_release_half_window1;
    L11:
        if (r104.aF() != true) goto L13;
        r102 = true;
        goto L13
    L5:
        if (r101.isVisible() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        if (Intrinsics.areEqual(s1a.a.getActivity(this).getClass().getSimpleName(), "CreationCanvasActivity") == false) goto L13;
        va8.o r100 = (va8.o) this.f388291q.getValue();
        TextView r101 = null;
        if (r100 == null) goto L7;
        com.larus.bmhome.chat.component.bottom.core.a r102 = r100.Uv();
    L8:
        if (r102 == null) goto L10;
        r101 = r102.b();
    L10:
        if (r101 == null) goto L14;
        r101.removeTextChangedListener(this.f388296v);
        return;
    L14:
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // maa.b
    public final int v0() {
        laa.d r100 = F2();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        boolean r103 = z0();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r104 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388286l.getValue();
        if (r104 != null) goto L11;
    L13:
        if (r102 == false) goto L20;
        if (r103 == true) goto L18;
        if (r101 == true) goto L18;
        String r105 = "#B2FFFFFF";
    L25:
        return ColorProtector.parseColor(r105);
    L18:
        r105 = "#FFFF3B30";
        goto L25
    L20:
        boolean r106 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L24;
        return ContextCompat.getColor(getContext(), R.color.neutral_70);
    L24:
        return ColorProtector.parseColor("#7f060015");
    L11:
        if (r104.isVisible() != true) goto L13;
        r101 = true;
        goto L13
    L5:
        if (r100.aF() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // maa.f
    public final Boolean I4(Pair<Float, Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "xy");
        laa.f r101 = (laa.f) this.f388290p.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.I4(r100);
    }

    @Override // maa.b
    public final void J0(ViewGroup r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getChildCount() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        View r102 = r100.getChildAt(0);
        if ((r102 instanceof AudioVisualizerOpt) == false) goto L12;
        AudioVisualizerOpt r103 = (AudioVisualizerOpt) r102;
    L13:
        if (r103 == null) goto L17;
        r103.setCustomWaveGroupCount(5);
        return;
    L17:
        return;
    L12:
        r103 = null;
        goto L13
    L6:
        r101 = false;
        goto L7
    }

    @Override // maa.b
    public final boolean X0(boolean r100) {
        if (iC() == false) goto L6;
        return true;
    L6:
        if (r100 == true) goto L15;
        laa.j r101 = (laa.j) this.f388284j.getValue();
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        return true;
    L10:
        if (r101.Re() != true) goto L12;
        r102 = true;
    L15:
        return false;
    }

    @Override // maa.b
    public final String Z(String r100) {
        if (Intrinsics.areEqual(ObricInteractDelegate.f392884b.isAiKeyLongPress(), Boolean.TRUE) == true) goto L8;
        if (r100 == null) goto L7;
        return r100;
    L7:
        return getContext().getString(R.string.larus_hold_to_speak_note);
    L8:
        return getContext().getString(R.string.obric_hold_to_speak_note);
    }

    @Override // maa.f
    public final void ga(Pair<Float, Float> r100) {
        if (s1a.a.d(this) == false) goto L8;
        laa.f r101 = (laa.f) this.f388290p.getValue();
        if (r101 == null) goto L9;
        r101.ga(r100);
        return;
    L9:
        return;
    }

    @Override // maa.b
    public final void l(boolean r100) {
        laa.m r101 = (laa.m) this.f388287m.getValue();
        if (r101 == null) goto L6;
        r101.v00(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.obric.assistant.component.z4] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.obric.assistant.component.y4] */
    @Override // maa.b
    public final void r0(ViewGroup r100, boolean r101) {
        laa.m r102 = (laa.m) this.f388287m.getValue();
        if (r102 == null) goto L5;
        r102.N60(r101);
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getChildCount() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return;
    L12:
        View r104 = r100.getChildAt(0);
        if ((r104 instanceof AudioVisualizerOpt) == false) goto L15;
        final AudioVisualizerOpt r105 = (AudioVisualizerOpt) r104;
    L16:
        if (r105 == null) goto L27;
        if (r101 == false) goto L19;
        r105.getPaint().setShader(null);
        r105.getPaint().setColor(this.f388292r);
        return;
    L19:
        ?? r106 = new y4(r105, r105, this);
        if (r105.getWidth() <= 0) goto L23;
        r106.invoke();
        return;
    L23:
        if (this.f388297w == true) goto L30;
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        a5 r108 = new a5(r107, this);
        r107.element = new z4(r105, r106, r108, this);
        r105.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) r107.element);
        r105.addOnAttachStateChangeListener(r108);
        this.f388297w = true;
        return;
    L30:
        return;
    L27:
        return;
    L15:
        r105 = null;
        goto L16
    L9:
        r103 = false;
        goto L10
    }
}
