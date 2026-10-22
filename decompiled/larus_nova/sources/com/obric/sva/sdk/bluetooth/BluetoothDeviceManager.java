package com.obric.sva.sdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010,\u001a\u00020-2\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/sva/sdk/bluetooth/BluetoothDeviceManager;", "", "<init>", "()V", "TAG", "", "isReceiverRegistered", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevice", "()Landroid/bluetooth/BluetoothDevice;", "setBluetoothDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "bluetoothDeviceName", "getBluetoothDeviceName", "()Ljava/lang/String;", "setBluetoothDeviceName", "(Ljava/lang/String;)V", "blueConnectState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/sva/sdk/bluetooth/BlueConnectState;", "getBlueConnectState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "stateChangedContext", "Lkotlin/coroutines/CoroutineContext;", "stateChangedScope", "Lkotlinx/coroutines/CoroutineScope;", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "getAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "isBluetoothOn", "()Z", "intentReceiver", "Landroid/content/BroadcastReceiver;", "init", "", "release", "start", "stop", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BluetoothDeviceManager {
    public static final BluetoothDeviceManager INSTANCE = null;
    public static final String TAG = "BluetoothDeviceManager";
    private static final Lazy adapter$delegate = null;
    private static final z0<BlueConnectState> blueConnectState = null;
    private static BluetoothDevice bluetoothDevice;
    private static String bluetoothDeviceName;
    private static Context context;
    private static BroadcastReceiver intentReceiver;
    private static boolean isReceiverRegistered;
    private static final CoroutineContext stateChangedContext = null;
    private static final CoroutineScope stateChangedScope = null;

    /* JADX INFO: renamed from: com.obric.sva.sdk.bluetooth.BluetoothDeviceManager$init$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes34.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.sva.sdk.bluetooth.BluetoothDeviceManager$init$1", f = "BluetoothDeviceManager.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            z0<BlueConnectState> r103 = BluetoothDeviceManager.INSTANCE.getBlueConnectState();
            BlueConnectState r104 = BlueConnectState.CONNECTED;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.bluetooth.BluetoothDeviceManager$init$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.sva.sdk.bluetooth.BluetoothDeviceManager$init$2", f = "BluetoothDeviceManager.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            z0<BlueConnectState> r103 = BluetoothDeviceManager.INSTANCE.getBlueConnectState();
            BlueConnectState r104 = BlueConnectState.DISCONNECTED;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    private BluetoothDeviceManager() {
    }

    public static /* synthetic */ BluetoothAdapter a() {
        return adapter_delegate$lambda$0();
    }

    public final void release() {
        context = null;
    }

    static {
        INSTANCE = new BluetoothDeviceManager();
        bluetoothDeviceName = "";
        blueConnectState = j1.a(BlueConnectState.NA);
        ExecutorCoroutineDispatcher r100 = w1.a(1, "stateChangedContext");
        stateChangedContext = r100;
        stateChangedScope = CoroutineScopeKt.CoroutineScope(r100.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        adapter$delegate = LazyKt.lazy(new a());
        intentReceiver = new BluetoothDeviceManager$intentReceiver$1();
    }

    private final BluetoothAdapter getAdapter() {
        return (BluetoothAdapter) adapter$delegate.getValue();
    }

    public final void start() {
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r100.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        if (isReceiverRegistered == true) goto L16;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        Context r102 = context;     // Catch: Throwable -> L10
        if (r102 == null) goto L7;
        Intent r103 = INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r102, intentReceiver, r100);     // Catch: Throwable -> L10
    L8:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L10
    L12:
        isReceiverRegistered = true;
        return;
    L7:
        r103 = null;
    L10:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void stop() {
        if (isReceiverRegistered == true) goto L14;
    L12:
        isReceiverRegistered = false;
        return;
    L14:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        Context r101 = context;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r101, intentReceiver);     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L10
        goto L12
    L7:
        r102 = null;
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final BluetoothAdapter adapter_delegate$lambda$0() {
        return BluetoothAdapter.getDefaultAdapter();
    }

    public final boolean isBluetoothOn() {
        return getAdapter().isEnabled();
    }

    public static final /* synthetic */ CoroutineScope access$getStateChangedScope$p() {
        return stateChangedScope;
    }

    public final z0<BlueConnectState> getBlueConnectState() {
        return blueConnectState;
    }

    public final BluetoothDevice getBluetoothDevice() {
        return bluetoothDevice;
    }

    public final String getBluetoothDeviceName() {
        return bluetoothDeviceName;
    }

    public final Context getContext() {
        return context;
    }

    public final void init(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        context = r110;
        if (ContextCompat.checkSelfPermission(r110, "android.permission.BLUETOOTH_CONNECT") == 0) goto L5;
        return;
    L5:
        int r111 = getAdapter().getProfileConnectionState(1);
        if (r111 != 0) goto L8;
        BuildersKt.launch$default(stateChangedScope, null, null, new AnonymousClass2(null), 3, null);
        return;
    L8:
        if (r111 != 2) goto L14;
        BuildersKt.launch$default(stateChangedScope, null, null, new AnonymousClass1(null), 3, null);
        return;
    }

    public final void setBluetoothDevice(BluetoothDevice r100) {
        bluetoothDevice = r100;
    }

    public final void setBluetoothDeviceName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        bluetoothDeviceName = r100;
    }

    public final void setContext(Context r100) {
        context = r100;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_sva_sdk_bluetooth_BluetoothDeviceManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
