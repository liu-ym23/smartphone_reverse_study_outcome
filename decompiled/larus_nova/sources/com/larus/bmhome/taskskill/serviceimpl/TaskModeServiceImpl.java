package com.larus.bmhome.taskskill.serviceimpl;

import com.larus.bmhome.taskskill.PcDeviceListProvider;
import com.larus.bmhome.taskskill.l2;
import com.larus.bmhome.taskskill.m2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.network.PcDeviceRepository;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.bmhome.taskskill.service.d;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandRequest;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.platform.service.n0;
import com.larus.platform.service.o;
import com.larus.platform.service.p1;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/taskskill/serviceimpl/TaskModeServiceImpl;", "Lcom/larus/bmhome/taskskill/service/TaskModeService;", "<init>", "()V", "createPcDeviceListProviderInterface", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "needUpgrade", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "authorizeDevice", "targetDeviceId", "", "authTicket", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteControlEnable", "shouldUseMfaForDeviceAuthorization", "requestEnableControlPermission", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskModeServiceImpl implements TaskModeService {

    public static final class a {
    }

    public static final class b implements IIMCallback<OmniDispatchCommandResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f314506a;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        public b(String r100) {
            this.f314506a = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.e("TaskModeServiceImpl", "[requestEnableControlPermission] failed, deviceId=" + this.f314506a + ", code=" + r100.getCode() + ", msg=" + r100.getTips());
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(OmniDispatchCommandResponse r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            FLogger.f375446a.i("TaskModeServiceImpl", "[requestEnableControlPermission] success, deviceId=" + this.f314506a);
        }
    }

    static {
    }

    public TaskModeServiceImpl() {
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final boolean b() {
        if (n0.f365775a.b() == false) goto L5;
    L7:
        return false;
    L5:
        if (p1.f365785a.i() == false) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final d d() {
        return new PcDeviceListProvider();
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final boolean a() {
        return l2.c();
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final void e(String r110) {
        Intrinsics.checkNotNullParameter(r110, "targetDeviceId");
        GetAllDevicesRepo r100 = GetAllDevicesRepo.f330842a;
        Integer r101 = GetAllDevicesRepo.c(r110);
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        com.larus.im.d.b().sendDispatchCommand(new OmniDispatchCommandRequest(r110, r102, new DispatchCommandPayload(DispatchCommand.DEVICE_ENABLE_CONTROL_REQUEST, UUID.randomUUID().toString(), null, null, o.f365780a.getDeviceId(), null, 0, null, null, TTVideoEngineInterface.PLAYER_OPTION_USE_FALLBACK_API, null)), new b(r110));
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final boolean f(PcDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        return m2.a(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.TaskModeService
    public final Object c(String r100, String r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof TaskModeServiceImpl$authorizeDevice$1) == false) goto L7;
        TaskModeServiceImpl$authorizeDevice$1 r103 = (TaskModeServiceImpl$authorizeDevice$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L18:
        return Boxing.boxBoolean(Result.m9456isSuccessimpl(r108));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        PcDeviceRepository r109 = PcDeviceRepository.f314355a;
        r103.label = 1;
        r108 = r109.a(r100, r101, r103);
        if (r108 != r106) goto L18;
        return r106;
    L7:
        r103 = new TaskModeServiceImpl$authorizeDevice$1(this, r102);
        goto L8
    }
}
