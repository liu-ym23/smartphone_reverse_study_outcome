package com.obric.assistant.chat.component.interaction;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.IManualHalfDuplexModeService;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import va8.a0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0002EFB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J$\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001d2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0+H\u0002J\u0010\u0010,\u001a\u0004\u0018\u00010#H\u0082@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u0004\u0018\u00010/H\u0082@¢\u0006\u0002\u0010-J\u0012\u00100\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010#H\u0016J\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020#H\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\b\u00105\u001a\u00020\u001fH\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u00103\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001dH\u0002J\u0012\u00109\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u001dH\u0002J\u001e\u0010:\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010#H\u0002J\n\u0010<\u001a\u0004\u0018\u00010\u001dH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010=\u001a\u00020#8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020#8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0015\u0010B\u001a\u00020!8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/obric/assistant/chat/component/interaction/TouchSpeakerEventComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/audio/ITouchSpeakEventAbility;", "<init>", "()V", "manualHalfDuplexModeService", "Lcom/obric/assistant/audio/service/IManualHalfDuplexModeService;", "getManualHalfDuplexModeService", "()Lcom/obric/assistant/audio/service/IManualHalfDuplexModeService;", "manualHalfDuplexModeService$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "conversationCoreAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationCoreAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationCoreAbility$delegate", "attemptLock", "", "activeAttempt", "Lcom/obric/assistant/chat/component/interaction/TouchSpeakerEventComponent$TouchSpeakAttempt;", "start", "", "isRadio", "", "sessionId", "", "sourceType", "", "onStarted", "onCaptureEnd", "handleBotOperations", MapMonitorConst.ATTEMPT, "onBotAvailable", "Lkotlin/Function1;", "fetchBotIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeBotModel", "Lcom/larus/im/bean/bot/BotModel;", "stop", "stopBotId", "onSuccess", "text", "onCanceled", "onFailed", "onStreamResult", "endAsr", "dispatchAsrStartIfReady", "endVoiceCapture", "stopMode", "fallbackBotId", "takeActiveAttempt", "botId", "getBotId", "()Ljava/lang/String;", "conversationId", "getConversationId", "hasAttachment", "getHasAttachment", "()Z", "Companion", "TouchSpeakAttempt", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchSpeakerEventComponent extends ComponentFeature implements maa.h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f386848n = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f386849h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f386850i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f386851j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f386852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f386853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f386854m;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f386855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f386856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f386857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f386858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f386859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f386860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f386861g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Job f386862h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f386863i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f386864j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f386865k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f386855a, r101.f386855a) == true) goto L12;
            return false;
        L12:
            if (this.f386856b == r101.f386856b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386857c, r101.f386857c) == true) goto L18;
            return false;
        L18:
            if (this.f386858d == r101.f386858d) goto L21;
            return false;
        L21:
            if (this.f386859e == r101.f386859e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f386860f, r101.f386860f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f386861g, r101.f386861g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f386862h, r101.f386862h) == true) goto L33;
            return false;
        L33:
            if (this.f386863i == r101.f386863i) goto L36;
            return false;
        L36:
            if (this.f386864j == r101.f386864j) goto L39;
            return false;
        L39:
            if (this.f386865k == r101.f386865k) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f386855a.hashCode() * 31) + this.f386856b) * 31) + this.f386857c.hashCode()) * 31;
            int r101 = 1231;
            if (this.f386858d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f386859e == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            String r106 = this.f386860f;
            int r107 = 0;
            if (r106 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r105 + r108) * 31;
            String r110 = this.f386861g;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Job r113 = this.f386862h;
            if (r113 == null) goto L22;
            r107 = r113.hashCode();
        L22:
            int r114 = (r112 + r107) * 31;
            if (this.f386863i == false) goto L25;
            int r115 = 1231;
        L26:
            int r116 = (r114 + r115) * 31;
            if (this.f386864j == false) goto L29;
            int r117 = 1231;
        L30:
            int r118 = (r116 + r117) * 31;
            if (this.f386865k == true) goto L35;
            r101 = 1237;
        L35:
            return r118 + r101;
        L29:
            r117 = 1237;
            goto L30
        L25:
            r115 = 1237;
            goto L26
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r106.hashCode();
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "TouchSpeakAttempt(captureSessionId=" + this.f386855a + ", sourceType=" + this.f386856b + ", conversationId=" + this.f386857c + ", hasAttachment=" + this.f386858d + ", isRadio=" + this.f386859e + ", resolvedBotId=" + this.f386860f + ", modeSessionId=" + this.f386861g + ", resolveBotJob=" + this.f386862h + ", captureStarted=" + this.f386863i + ", asrStarted=" + this.f386864j + ", asrStartDispatched=" + this.f386865k + ')';
        }

        public b(String r100, int r101, String r102, boolean r103, boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "captureSessionId");
            Intrinsics.checkNotNullParameter(r102, "conversationId");
            this.f386855a = r100;
            this.f386856b = r101;
            this.f386857c = r102;
            this.f386858d = r103;
            this.f386859e = r104;
            this.f386860f = null;
            this.f386861g = null;
            this.f386862h = null;
            this.f386863i = false;
            this.f386864j = false;
            this.f386865k = false;
        }
    }

    public static final class c implements Function0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386866a;

        public c(AttachReceiver r100) {
            this.f386866a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            AttachReceiver r100 = this.f386866a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class d implements Function0<g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386867a;

        public d(AttachReceiver r100) {
            this.f386867a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.g1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final g1 invoke() {
            AttachReceiver r100 = this.f386867a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class e implements Function0<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386868a;

        public e(AttachReceiver r100) {
            this.f386868a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.a0] */
        @Override // kotlin.jvm.functions.Function0
        public final a0 invoke() {
            AttachReceiver r100 = this.f386868a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(a0.class));
        }
    }

    static {
    }

    @Override // maa.h
    public final void EO() {
    }

    public final b X2() {
        Object r100 = this.f386853l;
        monitor-enter(r100);
        b r101 = this.f386854m;     // Catch: Throwable -> L14
        if (r101 == null) goto L11;
        this.f386854m = null;     // Catch: Throwable -> L14
        Job r102 = r101.f386862h;     // Catch: Throwable -> L14
        if (r102 == null) goto L9;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);     // Catch: Throwable -> L14
    L9:
        r101.f386862h = null;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);
        return r101;
    L11:
        r101 = null;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // maa.h
    public final void onCanceled() {
        FLogger r100 = FLogger.f375446a;
        y r101 = u0();
        if (r101 == null) goto L5;
        String r102 = r101.getBotId();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100.i("TouchSpeakerEventComponent", "onCanceled ".concat(r102));
        b r103 = X2();
        N2(r103);
        U2(r103, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // maa.h
    public final void onFailed() {
        FLogger r100 = FLogger.f375446a;
        y r101 = u0();
        if (r101 == null) goto L5;
        String r102 = r101.getBotId();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100.i("TouchSpeakerEventComponent", "onFailed ".concat(r102));
        b r103 = X2();
        N2(r103);
        U2(r103, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // maa.h
    public final void onStarted() {
        FLogger r100 = FLogger.f375446a;
        y r101 = u0();
        if (r101 == null) goto L5;
        String r102 = r101.getBotId();
    L6:
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r100.i("TouchSpeakerEventComponent", "onStarted ".concat(r102));
        Object r103 = this.f386853l;
        monitor-enter(r103);
        b r104 = this.f386854m;     // Catch: Throwable -> L18
        if (r104 != null) goto L15;
        monitor-exit(r103);
        return;
    L15:
        r104.f386864j = true;     // Catch: Throwable -> L18
        L2(r104);     // Catch: Throwable -> L18
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r103);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        r102 = null;
        goto L6
    }

    public final y u0() {
        return (y) this.f386850i.getValue();
    }

    public TouchSpeakerEventComponent() {
        this.f386849h = LazyKt.lazy(new h());
        this.f386850i = LazyKt.lazy(new c(this));
        this.f386851j = LazyKt.lazy(new d(this));
        this.f386852k = LazyKt.lazy(new e(this));
        this.f386853l = new Object();
    }

    public static void N2(b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        VoiceCaptureStateProducerDelegate.f392947b.d(r100.f386857c, VoiceCaptureScene.TOUCH_SPEAK, r100.f386855a, Integer.valueOf(r100.f386856b));
    }

    public final void L2(b r100) {
        if (r100.f386863i == true) goto L5;
        return;
    L5:
        if (r100.f386864j == true) goto L7;
        return;
    L7:
        if (r100.f386865k == true) goto L16;
        r100.f386865k = true;
        VoiceCaptureStateProducerDelegate.f392947b.c(r100.f386857c, VoiceCaptureScene.TOUCH_SPEAK, r100.f386855a, Integer.valueOf(r100.f386856b));
        String r101 = r100.f386860f;
        if (r101 == null) goto L15;
        ((IManualHalfDuplexModeService) this.f386849h.getValue()).d(r101);
        return;
    L15:
        return;
    }

    @Override // maa.h
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        FLogger r101 = FLogger.f375446a;
        y r102 = u0();
        if (r102 == null) goto L5;
        String r103 = r102.getBotId();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101.i("TouchSpeakerEventComponent", "onSuccess ".concat(r103));
        b r104 = X2();
        if (r104 != null) goto L11;
        return;
    L11:
        VoiceCaptureStateProducerDelegate.f392947b.e(r104.f386857c, VoiceCaptureScene.TOUCH_SPEAK, r104.f386855a, Integer.valueOf(r104.f386856b));
        N2(r104);
        String r105 = r104.f386861g;
        if (r105 == null) goto L15;
        ((IManualHalfDuplexModeService) this.f386849h.getValue()).a(r105, r100);
        return;
    L15:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // maa.h
    public final void stop(String r100) {
        FLogger.f375446a.i("TouchSpeakerEventComponent", "touchSpeakerStop");
        b r101 = X2();
        N2(r101);
        U2(r101, r100);
    }

    public static final Object F2(TouchSpeakerEventComponent r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof TouchSpeakerEventComponent$fetchBotIfNeeded$1) == false) goto L7;
        TouchSpeakerEventComponent$fetchBotIfNeeded$1 r102 = (TouchSpeakerEventComponent$fetchBotIfNeeded$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L31:
        BotModel r107 = (BotModel) r104;
        if (r107 == null) goto L34;
        String r108 = r107.getBotId();
    L35:
        FLogger.f375446a.i("TouchSpeakerEventComponent", "Fetched botId: " + r108);
        return r108;
    L34:
        r108 = null;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        a0 r109 = (a0) r100.f386852k.getValue();
        if (r109 == null) goto L22;
        BotModel r110 = r109.j0();
        if (r110 == null) goto L22;
        String r111 = r110.getBotId();
        if (r111 == null) goto L22;
        return r111;
    L22:
        r102.label = 1;
        kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r112.C();
        y r113 = r100.u0();
        if (r113 != null) goto L25;
        r112.resumeWith(Result.m9449constructorimpl(null));
    L26:
        r104 = r112.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L29:
        if (r104 != r105) goto L31;
        return r105;
    L25:
        l r114 = new l(r113, r112);
        r113.ll(j.f386875a, r114);
        r112.i(new k(r113, r114));
    L7:
        r102 = new TouchSpeakerEventComponent$fetchBotIfNeeded$1(r100, r101);
        goto L8
    }

    public final void P2(b r100, i r110) {
        a0 r101 = (a0) this.f386852k.getValue();
        if (r101 == null) goto L7;
        BotModel r102 = r101.j0();
        if (r102 == null) goto L7;
        String r103 = r102.getBotId();
    L8:
        if (r103 == null) goto L10;
        r110.invoke(r103);
        return;
    L10:
        Job r111 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new TouchSpeakerEventComponent$handleBotOperations$job$1(this, r110, null), 3, null);
        Object r104 = this.f386853l;
        monitor-enter(r104);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (this.f386854m != r100) goto L15;
        r100.f386862h = r111;     // Catch: Throwable -> L19
    L16:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r104);
        return;
    L15:
        Job.DefaultImpls.cancel$default(r111, null, 1, null);     // Catch: Throwable -> L19
    L7:
        r103 = null;
        goto L8
    }

    public final void U2(b r100, String r101) {
        if (r100 == null) goto L4;
        String r102 = r100.f386861g;
    L5:
        if (r102 == null) goto L7;
        ((IManualHalfDuplexModeService) this.f386849h.getValue()).b(r102);
        return;
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L17;
        ((IManualHalfDuplexModeService) this.f386849h.getValue()).stop(r101);
        return;
    L17:
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L13
    L4:
        r102 = null;
        goto L5
    }

    @Override // maa.h
    public final void UA(boolean r110, String r111, int r112) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("start botId:");
        y r102 = u0();
        if (r102 == null) goto L5;
        String r103 = r102.getBotId();
    L6:
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101.append(r103);
        r101.append(" conversationId:");
        y r104 = u0();
        if (r104 == null) goto L11;
        String r105 = r104.Y1();
    L12:
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r101.append(r105);
        r101.append(" hasAttachment:");
        g1 r106 = (g1) this.f386851j.getValue();
        if (r106 == null) goto L21;
        List<UplinkFileEntity> r107 = r106.q1();
        if (r107 == null) goto L21;
        if ((!r107.isEmpty()) != true) goto L21;
        boolean r108 = true;
    L22:
        r101.append(r108);
        r101.append(", enterFrom:");
        r101.append(r110);
        r101.append(", sourceType:");
        r101.append(r112);
        r100.i("TouchSpeakerEventComponent", r101.toString());
        if (r111 != null) goto L25;
        String r109 = UUID.randomUUID().toString();
    L26:
        y r113 = u0();
        if (r113 == null) goto L29;
        String r114 = r113.Y1();
    L30:
        if (r114 != null) goto L32;
        r114 = "";
    L32:
        String r115 = r114;
        g1 r116 = (g1) this.f386851j.getValue();
        if (r116 == null) goto L39;
        List<UplinkFileEntity> r117 = r116.q1();
        if (r117 == null) goto L39;
        if ((!r117.isEmpty()) != true) goto L39;
        boolean r118 = true;
    L40:
        b r119 = new b(r109, r112, r115, r118, r110);
        Object r120 = this.f386853l;
        monitor-enter(r120);
        b r121 = this.f386854m;     // Catch: Throwable -> L51
        if (r121 == null) goto L47;
        Job r122 = r121.f386862h;     // Catch: Throwable -> L51
        if (r122 == null) goto L47;
        Job.DefaultImpls.cancel$default(r122, null, 1, null);     // Catch: Throwable -> L51
    L47:
        this.f386854m = r119;     // Catch: Throwable -> L51
        monitor-exit(r120);
        N2(r121);
        U2(r121, null);
        P2(r119, new i(this, r119));
        return;
    L51:
        th = move-exception;
        throw th;
    L39:
        r118 = false;
        goto L40
    L29:
        r114 = null;
        goto L30
    L25:
        r109 = r111;
    L21:
        r108 = false;
        goto L22
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
