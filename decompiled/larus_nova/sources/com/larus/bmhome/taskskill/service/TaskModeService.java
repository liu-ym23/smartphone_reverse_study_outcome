package com.larus.bmhome.taskskill.service;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/taskskill/service/TaskModeService;", "", "createPcDeviceListProviderInterface", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "needUpgrade", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "remoteControlEnable", "shouldUseMfaForDeviceAuthorization", "authorizeDevice", "targetDeviceId", "", "authTicket", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEnableControlPermission", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TaskModeService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f314424a = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/taskskill/service/TaskModeService$Companion;", "Lcom/larus/bmhome/taskskill/service/TaskModeService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/bmhome/taskskill/service/TaskModeService;", "impl$delegate", "Lkotlin/Lazy;", "createPcDeviceListProviderInterface", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "needUpgrade", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "remoteControlEnable", "shouldUseMfaForDeviceAuthorization", "authorizeDevice", "targetDeviceId", "", "authTicket", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEnableControlPermission", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements TaskModeService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f314425b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<TaskModeService> f314426c = null;

        public static final class a implements d {
            public a() {
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final bs8.e b() {
                return null;
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final void c(PcDevice r100) {
                Intrinsics.checkNotNullParameter(r100, "device");
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final void e() {
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final void f() {
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final MutableLiveData<bs8.e> d() {
                return new MutableLiveData();
            }

            @Override // com.larus.bmhome.taskskill.service.d
            public final Object a(Continuation<? super bs8.f> r100) {
                return new bs8.f(null, false);
            }
        }

        private Companion() {
        }

        static {
            f314425b = new Companion();
            f314426c = LazyKt.lazy(new v());
        }

        public static TaskModeService g() {
            return f314426c.getValue();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final boolean a() {
            TaskModeService r100 = g();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.a();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final boolean b() {
            TaskModeService r100 = g();
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.b();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final d d() {
            TaskModeService r100 = g();
            if (r100 == null) goto L7;
            d r101 = r100.d();
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new a();
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final void e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "targetDeviceId");
            TaskModeService r101 = g();
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final boolean f(PcDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            TaskModeService r101 = g();
            if (r101 != null) goto L7;
            return false;
        L7:
            return r101.f(r100);
        }

        @Override // com.larus.bmhome.taskskill.service.TaskModeService
        public final Object c(String r100, String r101, Continuation<? super Boolean> r102) {
            if ((r102 instanceof TaskModeService$Companion$authorizeDevice$1) == false) goto L7;
            TaskModeService$Companion$authorizeDevice$1 r103 = (TaskModeService$Companion$authorizeDevice$1) r102;
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
        L19:
            boolean r108 = ((Boolean) r105).booleanValue();
        L22:
            return Boxing.boxBoolean(r108);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r105);
            TaskModeService r109 = g();
            if (r109 == null) goto L20;
            r103.label = 1;
            r105 = r109.c(r100, r101, r103);
            if (r105 != r106) goto L19;
            return r106;
        L20:
            r108 = false;
        L7:
            r103 = new TaskModeService$Companion$authorizeDevice$1(this, r102);
            goto L8
        }
    }

    static {
        f314424a = Companion.f314425b;
    }

    boolean a();

    boolean b();

    Object c(String r100, String r101, Continuation<? super Boolean> r102);

    d d();

    void e(String r100);

    boolean f(PcDevice r100);
}
