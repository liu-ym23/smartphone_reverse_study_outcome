package com.obric.assistant.component;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.internal.ChatSender;
import com.obric.assistant.upload.IObricUploadService;
import com.obric.assistant.upload.Scene;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010\u0015R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/component/ObricCameraAutoSendComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "<init>", "()V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "sendingRequestId", "", "onResume", "", "tryConsumeCameraAutoSend", "sendPayload", WsConstants.KEY_PAYLOAD, "Lcom/obric/assistant/camera/CameraAutoSendPayload;", "(Lcom/obric/assistant/camera/CameraAutoSendPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitSendDependenciesReady", "Lcom/obric/assistant/chat/api/ISenderApi;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCameraAutoSendComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f387982o = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f387983m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f387984n;

    public static final class a {
    }

    public static final class b implements Function0<de8.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f387985a;

        public b(AttachReceiver r100) {
            this.f387985a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [de8.c, t1a.c] */
        @Override // kotlin.jvm.functions.Function0
        public final de8.c invoke() {
            AttachReceiver r100 = this.f387985a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        de8.c r100 = (de8.c) this.f387983m.getValue();
        if (r100 == null) goto L23;
        Bundle r101 = r100.f468086b;
        if (r101 == null) goto L26;
        String r102 = r101.getString("camera_auto_send_request_id");
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        if (r102.length() != 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(this.f387984n, r102) == true) goto L27;
        r101.remove("camera_auto_send_request_id");
        ica.a r104 = ica.b.b(r102);
        if (r104 != null) goto L21;
        FLogger.f375446a.w("ObricCameraAutoSend", "payload missing requestId=".concat(r102));
        return;
    L21:
        this.f387984n = r102;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricCameraAutoSendComponent$tryConsumeCameraAutoSend$1(this, r104, null), 3, null);
        return;
    L27:
        return;
    L13:
        r103 = false;
        goto L14
    L26:
        return;
    }

    public ObricCameraAutoSendComponent() {
        this.f387983m = LazyKt.lazy(new b(this));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:27:0x006d). Please report as a decompilation issue!!! */
    public final Object h3(Continuation<? super com.obric.assistant.chat.api.c> r100) {
        if ((r100 instanceof ObricCameraAutoSendComponent$waitSendDependenciesReady$1) == false) goto L7;
        ObricCameraAutoSendComponent$waitSendDependenciesReady$1 r101 = (ObricCameraAutoSendComponent$waitSendDependenciesReady$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r101.I$1;
        int r107 = r101.I$0;
        ResultKt.throwOnFailure(r103);
    L27:
        r106 = r106 + 1;
    L15:
        ChatSender r108 = null;
        if (r106 >= r107) goto L28;
        IObricChatService.f386556a.getClass();
        IObricChatService r109 = IObricChatService.a.a();
        if (r109 == null) goto L20;
        r108 = r109.getSender();
    L20:
        IObricUploadService.f393545a.getClass();
        IObricUploadService r110 = IObricUploadService.a.a();
        if (r108 == null) goto L24;
        if (r110 == null) goto L24;
        return r108;
    L24:
        r101.I$0 = r107;
        r101.I$1 = r106;
        r101.label = 1;
        if (DelayKt.delay(150, r101) != r104) goto L27;
        return r104;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r106 = 0;
        r107 = 20;
    L7:
        r101 = new ObricCameraAutoSendComponent$waitSendDependenciesReady$1(this, r100);
        goto L8
    }

    public static final Object Y2(ObricCameraAutoSendComponent r110, ica.a r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ObricCameraAutoSendComponent$sendPayload$1) == false) goto L7;
        ObricCameraAutoSendComponent$sendPayload$1 r100 = (ObricCameraAutoSendComponent$sendPayload$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        ica.a r105 = (ica.a) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L14
    L23:
        com.obric.assistant.chat.api.c r106 = (com.obric.assistant.chat.api.c) r102;     // Catch: CancellationException -> L14
        if (r106 != null) goto L26;
        FLogger.f375446a.w("ObricCameraAutoSend", "send dependencies timeout requestId=" + r105.f489265a);
        r105.a();
        r110.f387984n = null;
        return Unit.INSTANCE;
    L26:
        PolarisFileWrapper r113 = new PolarisFileWrapper(r105.f489267c);
        if (r113.exists() == true) goto L42;
        FLogger.f375446a.w("ObricCameraAutoSend", "image file missing requestId=" + r105.f489265a);
        r105.a();
        r110.f387984n = null;
        return Unit.INSTANCE;
    L42:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L31
        r106.a(r105.f489266b, "camera_auto_send", MapsKt.mapOf(TuplesKt.to("caller_package", r105.f489268d)), r113, Scene.SCREEN_SEMANTIC, new f(r105, r110), null);     // Catch: Throwable -> L31
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L37;
        FLogger.f375446a.e("ObricCameraAutoSend", "send exception requestId=" + r105.f489265a, r109);
        r105.a();
        r110.f387984n = null;
    L37:
        return Unit.INSTANCE;
    L31:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        e = e;
    L40:
        FLogger.f375446a.w("ObricCameraAutoSend", "send cancelled requestId=" + r105.f489265a);
        r105.a();
        r110.f387984n = null;
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r111;     // Catch: CancellationException -> L38
        r100.label = 1;     // Catch: CancellationException -> L38
        r102 = r110.h3(r100);     // Catch: CancellationException -> L38
        if (r102 == r103) goto L50;
        r105 = r111;
        goto L23
    L50:
        return r103;
    L38:
        e = e;
        r105 = r111;
    L7:
        r100 = new ObricCameraAutoSendComponent$sendPayload$1(r110, r112);
        goto L8
    }
}
