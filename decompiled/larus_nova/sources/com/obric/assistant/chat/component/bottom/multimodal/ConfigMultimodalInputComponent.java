package com.obric.assistant.chat.component.bottom.multimodal;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import laa.m;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002042\u0006\u0010?\u001a\u000204H\u0016J\u0018\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020=H\u0016J\b\u0010E\u001a\u00020=H\u0016J\b\u0010F\u001a\u00020=H\u0016J\u0010\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u000202H\u0016J\u0012\u0010I\u001a\u00020/2\b\u0010J\u001a\u0004\u0018\u000102H\u0016J\b\u0010K\u001a\u00020=H\u0002J\b\u0010L\u001a\u00020=H\u0002J\u0010\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u000202H\u0002J\u0010\u0010O\u001a\u00020=2\u0006\u0010N\u001a\u000202H\u0002J\b\u0010P\u001a\u00020=H\u0016J\b\u0010Q\u001a\u00020/H\u0002J\b\u0010R\u001a\u00020=H\u0002J\b\u0010S\u001a\u00020=H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:¨\u0006U"}, d2 = {"Lcom/obric/assistant/chat/component/bottom/multimodal/ConfigMultimodalInputComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/chat/bottom/sub/IObricMultimodalInputAbility;", "<init>", "()V", "chatWindowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getChatWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "chatWindowAbility$delegate", "Lkotlin/Lazy;", "windowExtraViewAbility", "Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "getWindowExtraViewAbility", "()Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "windowExtraViewAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "multimodalPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "getMultimodalPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "multimodalPanelAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "panelItemProcessorRegistered", "", "phoneOperationCameraUiConfigApplied", "pendingLegacyCameraAttemptId", "", "pendingLegacyCameraRetryCount", "", "phoneOperationPanelItemProcessor", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility$PanelItemConfigProcessor;", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "onUpdateBottomMenuHeight", "", "curHeight", "normalHeight", "applyResourceBarItemStyle", "viewType", "itemView", "Landroid/view/View;", "onMultimodalViewCreated", WidgetCostModule.TYPE_ON_START, "onFragmentViewDestroyed", "openPhoneOperationAttachmentCamera", "clickFrom", "openAiKeyCamera", "startupAttemptId", "openPendingAiKeyCameraIfNeeded", "tryOpenPendingAiKeyCamera", "isActiveCameraStartupAttempt", "attemptId", "clearPendingLegacyCameraAttempt", "clearPhoneOperationCameraUiConfig", "openPhoneOperationAttachmentAlbum", "registerPhoneOperationPanelItemProcessor", "unregisterPhoneOperationPanelItemProcessor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfigMultimodalInputComponent extends ComponentFeature implements ada.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f386791v = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f386792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f386793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f386794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f386795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f386796l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f386797m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f386798n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f386799o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f386800p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f386801q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f386802r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f386803s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.obric.assistant.chat.component.bottom.multimodal.a f386804t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f386805u;

    public static final class a {
    }

    public static final class b implements Function0<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386806a;

        public b(AttachReceiver r100) {
            this.f386806a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.m, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final m invoke() {
            AttachReceiver r100 = this.f386806a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(m.class));
        }
    }

    public static final class c implements Function0<xha.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386807a;

        public c(AttachReceiver r100) {
            this.f386807a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, xha.e] */
        @Override // kotlin.jvm.functions.Function0
        public final xha.e invoke() {
            AttachReceiver r100 = this.f386807a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(xha.e.class));
        }
    }

    public static final class d implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386808a;

        public d(AttachReceiver r100) {
            this.f386808a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.multimodal.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.multimodal.g invoke() {
            AttachReceiver r100 = this.f386808a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class e implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386809a;

        public e(AttachReceiver r100) {
            this.f386809a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.multimodal.h, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.multimodal.h invoke() {
            AttachReceiver r100 = this.f386809a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.h.class));
        }
    }

    public static final class f implements Function0<zb8.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386810a;

        public f(AttachReceiver r100) {
            this.f386810a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, zb8.e] */
        @Override // kotlin.jvm.functions.Function0
        public final zb8.e invoke() {
            AttachReceiver r100 = this.f386810a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(zb8.e.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386811a;

        public g(AttachReceiver r100) {
            this.f386811a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f386811a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386812a;

        public h(AttachReceiver r100) {
            this.f386812a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            AttachReceiver r100 = this.f386812a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class i implements Function0<f1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386813a;

        public i(AttachReceiver r100) {
            this.f386813a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.bottommenu.f1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final f1 invoke() {
            AttachReceiver r100 = this.f386813a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(f1.class));
        }
    }

    public static final class j implements Function0<de8.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386814a;

        public j(AttachReceiver r100) {
            this.f386814a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [de8.c, t1a.c] */
        @Override // kotlin.jvm.functions.Function0
        public final de8.c invoke() {
            AttachReceiver r100 = this.f386814a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        String r100 = this.f386802r;
        if (r100 == null) goto L5;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.f392915a, r100, "dropped", "camera_legacy_host_destroyed", null, 24);
        uga.c.a(r100);
    L5:
        this.f386802r = null;
        this.f386803s = 0;
        if (this.f386800p == false) goto L12;
        com.larus.bmhome.chat.component.bottom.multimodal.h r101 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.f386795k.getValue();
        if (r101 == null) goto L11;
        r101.q80(this.f386804t);
    L11:
        this.f386800p = false;
    L12:
        Iy();
    }

    public final void F2() {
        if (this.f386802r == null) goto L5;
        return;
    L5:
        de8.c r100 = (de8.c) this.f386799o.getValue();
        if (r100 != null) goto L8;
        return;
    L8:
        Bundle r101 = r100.f468086b;
        if (r101 == null) goto L28;
        String r102 = r101.getString("obric_startup_attempt_id");
        if (r102 != null) goto L13;
        return;
    L13:
        if ((!StringsKt.isBlank(r102)) == true) goto L16;
        r102 = null;
    L16:
        if (r102 != null) goto L18;
        return;
    L18:
        if (r100.v() == true) goto L20;
        return;
    L20:
        Bundle r103 = r100.f468086b;
        if (r103 == null) goto L24;
        r103.remove("auto_open_plus_camera");
        Unit r104 = Unit.INSTANCE;
    L24:
        if (uga.c.b(r102) == true) goto L26;
        return;
    L26:
        this.f386802r = r102;
        this.f386803s = 0;
        L2();
        return;
    }

    @Override // ada.d
    public final void Iy() {
        if (this.f386801q == true) goto L5;
        return;
    L5:
        zb8.e r100 = (zb8.e) this.f386796l.getValue();
        if (r100 == null) goto L8;
        r100.md(null);
    L8:
        this.f386801q = false;
    }

    public final void L2() {
        String r100 = this.f386802r;
        if (r100 != null) goto L6;
        return;
    L6:
        if (uga.c.b(r100) == true) goto L10;
        this.f386802r = null;
        this.f386803s = 0;
        uga.c.a(r100);
        return;
    L10:
        if (WV(r100) == false) goto L12;
        return;
    L12:
        this.f386803s++;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (this.f386803s >= 15) goto L17;
        if (r101 == null) goto L17;
        SafeExtKt.b(r101, new ConfigMultimodalInputComponent$tryOpenPendingAiKeyCamera$1(this), 100);
        return;
    L17:
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.f392915a, r100, "dropped", "camera_legacy_exact_launch_unavailable", null, 24);
        uga.c.a(r100);
        this.f386802r = null;
        this.f386803s = 0;
        com.larus.bmhome.chat.component.bottom.multimodal.g r102 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f386794j.getValue();
        if (r102 == null) goto L21;
        r102.QS();
        return;
    }

    @Override // ada.d
    public final void ma() {
        if (((f1) this.f386805u.getValue()) != null) goto L5;
        FLogger.f375446a.w("ConfigMultimodalInputComponent", "onMultimodalViewCreated: not found bottomMenuAbility");
    L5:
        FLogger.f375446a.i("ConfigMultimodalInputComponent", "onMultimodalViewCreated");
        f1 r100 = (f1) this.f386805u.getValue();
        if (r100 == null) goto L8;
        r100.aJ();
    L8:
        xha.e r101 = (xha.e) this.f386793i.getValue();
        if (r101 == null) goto L12;
        r101.Cq();
    L12:
        if (this.f386800p == true) goto L18;
        com.larus.bmhome.chat.component.bottom.multimodal.h r102 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.f386795k.getValue();
        if (r102 == null) goto L18;
        r102.xp(this.f386804t);
        r102.d6();
        this.f386800p = true;
    L18:
        F2();
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.chat.component.bottom.multimodal.a] */
    public ConfigMultimodalInputComponent() {
        this.f386792h = LazyKt.lazy(new b(this));
        this.f386793i = LazyKt.lazy(new c(this));
        this.f386794j = LazyKt.lazy(new d(this));
        this.f386795k = LazyKt.lazy(new e(this));
        this.f386796l = LazyKt.lazy(new f(this));
        this.f386797m = LazyKt.lazy(new g(this));
        this.f386798n = LazyKt.lazy(new h(this));
        this.f386799o = LazyKt.lazy(new j(this));
        this.f386804t = new com.obric.assistant.chat.component.bottom.multimodal.a(this);
        this.f386805u = LazyKt.lazy(new i(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStart() {
        F2();
    }

    @Override // ada.d
    public final boolean WV(final String r100) {
        xe8.a r101 = null;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L9:
        if (r100 != null) goto L11;
    L13:
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r102 == null) goto L16;
        r102.x();
    L16:
        final zb8.e r103 = (zb8.e) this.f386796l.getValue();
        if (r103 != null) goto L19;
        return false;
    L19:
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r104 instanceof xe8.a) == false) goto L22;
        r101 = (xe8.a) r104;
    L22:
        if (r101 != null) goto L24;
        return false;
    L24:
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r105 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r105 != null) goto L27;
        return false;
    L27:
        final HashMap r106 = new HashMap();
        r106.put("chat_key", Long.valueOf(r101.getChatUniqueKey()));
        r106.put("click_from", "plus_panel");
        f1 r107 = (f1) this.f386805u.getValue();
        if (r107 == null) goto L32;
        Map<String, Object> r108 = r107.wV();
        if (r108 == null) goto L32;
        r106.putAll(r108);
    L32:
        Object r109 = r106.get("extra_params");
        if ((r109 instanceof JSONObject) == false) goto L36;
        JSONObject r110 = new JSONObject(((JSONObject) r109).toString());
    L39:
        if (r100 == null) goto L41;
        r110.put("obric_startup_attempt_id", r100);
    L41:
        r106.put("extra_params", r110);
        SafeExtKt.b(r105, new com.obric.assistant.chat.component.bottom.multimodal.b(r100, this, r103, r106), 100);
        return true;
    L36:
        if ((r109 instanceof Map) == false) goto L38;
        r110 = new JSONObject((Map) r109);
        goto L39
    L38:
        r110 = new JSONObject();
        goto L39
    L11:
        if (uga.c.b(r100) == true) goto L13;
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    @Override // ada.d
    public final boolean qL(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        if (com.obric.assistant.task.skill.f.d() == true) goto L5;
        return false;
    L5:
        final zb8.e r101 = (zb8.e) this.f386796l.getValue();
        if (r101 != null) goto L8;
        return false;
    L8:
        com.obric.assistant.spi.keyguard.a.b(false, new com.obric.assistant.chat.component.bottom.multimodal.c(this, r100, r101), 3);
        return true;
    }

    @Override // ada.d
    public final void L(int r100, int r101) {
        if (((m) this.f386792h.getValue()) != null) goto L5;
        FLogger.f375446a.w("ConfigMultimodalInputComponent", "onUpdateBottomMenuHeight: not found chatWindowAbility");
    L5:
        if (r101 <= 0) goto L7;
        float r102 = r100 / r101;
    L8:
        m r103 = (m) this.f386792h.getValue();
        if (r103 == null) goto L12;
        r103.L10(r102);
        return;
    L12:
        return;
    L7:
        r102 = 0.0f;
        goto L8
    }

    @Override // ada.d
    public final void gi(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "itemView");
        FLogger.f375446a.i("ConfigMultimodalInputComponent", "applyResourceBarItemStyle: " + r100);
        ImageView r102 = null;
        ViewGroup r103 = null;
        if (r100 != ResourceType.ADD.getValue()) goto L12;
        if ((r101 instanceof ViewGroup) == false) goto L7;
        r103 = (ViewGroup) r101;
    L7:
        if (r103 == null) goto L22;
        View r104 = r103.getChildAt(0);
        if (r104 == null) goto L23;
        r104.setBackgroundResource(R.drawable.bg_obric_window_resource_add);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        if (r100 == ResourceType.CUSTOM.getValue()) goto L25;
        View r105 = r101.findViewById(R.id.file_resource_remove);
        if ((r105 instanceof ImageView) == false) goto L16;
        r102 = (ImageView) r105;
    L16:
        if (r102 == null) goto L26;
        r102.setScaleType(ImageView.ScaleType.CENTER);
        r102.setImageResource(R.drawable.icon_obric_window_resource_bar_item_close);
        ViewGroup.LayoutParams r106 = r102.getLayoutParams();
        if (r106 == null) goto L21;
        r106.width = c7.b(18);
        r106.height = c7.b(18);
        r102.setLayoutParams(r106);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L26:
        return;
    }
}
