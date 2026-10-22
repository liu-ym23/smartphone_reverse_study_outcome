package com.larus.dora.impl.alive;

import android.content.IntentSender;
import android.os.Build;
import android.os.PowerManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.util.b0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J,\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J \u0010$\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J2\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/alive/DoraKeepAliveViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_ignoreBatteryOptimizationsStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "ignoreBatteryOptimizationStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getIgnoreBatteryOptimizationStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_keepAliveCdmToggleStateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "get_keepAliveCdmToggleStateFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "keepAliveCdmToggleStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getKeepAliveCdmToggleStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "loadIgnoreBatteryOptimization", "", "loopCheckIgnoreBatteryOptimization", "isIgnoringBatteryOptimizations", "enableOngoingNotification", "enabled", "isOngoingNotificationEnabled", "reportBatteryOptimizeSwitch", "on", "loadCdmState", "manager", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "associator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", "macAddress", "", "sn", "isCdmKeepAliveEnabled", "enableCdm", "enable", "updateKeepAliveCdmStateAndReport", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DoraKeepAliveViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long LOOP_CHECK_DELAY_TIME_MILLIS = 500;
    private static final int LOOP_CHECK_TIMES = 4;
    private static final String TAG = "DoraKeepAliveViewModel";
    private final z0<Boolean> _ignoreBatteryOptimizationsStateFlow;
    private final MutableSharedFlow<Boolean> _keepAliveCdmToggleStateFlow;
    private final i1<Boolean> ignoreBatteryOptimizationStateFlow;
    private final d1<Boolean> keepAliveCdmToggleStateFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements oy8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFlowCompanionDeviceManager f331980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraKeepAliveViewModel f331981b;

        @Override // oy8.c
        public final void a(CharSequence r100) {
            g49.d.d(DoraKeepAliveViewModel.TAG, "CDM onFailure: " + r100);
            DoraKeepAliveViewModel.access$updateKeepAliveCdmStateAndReport(this.f331981b, false);
        }

        @Override // oy8.c
        public final void b(IntentSender r100) {
            Intrinsics.checkNotNullParameter(r100, "intentSender");
            g49.d.d(DoraKeepAliveViewModel.TAG, "CDM onAssociationPending");
        }

        @Override // oy8.c
        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "macAddress");
            g49.d.d(DoraKeepAliveViewModel.TAG, "CDM onAssociationCreated");
            if (this.f331980a.m(r100) == true) goto L5;
            this.f331980a.g(r100);
        L5:
            DoraKeepAliveViewModel.access$updateKeepAliveCdmStateAndReport(this.f331981b, true);
        }

        public b(IFlowCompanionDeviceManager r100, DoraKeepAliveViewModel r101) {
            this.f331980a = r100;
            this.f331981b = r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadCdmState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadCdmState$1", f = "DoraKeepAliveViewModel.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {"state"}, s = {"Z$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ oy8.e $associator;
        final /* synthetic */ String $macAddress;
        final /* synthetic */ IFlowCompanionDeviceManager $manager;
        final /* synthetic */ String $sn;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraKeepAliveViewModel this$0;

        public AnonymousClass1(DoraKeepAliveViewModel r100, IFlowCompanionDeviceManager r101, String r102, String r103, oy8.e r104, Continuation<? super AnonymousClass1> r105) {
            this.this$0 = r100;
            this.$manager = r101;
            this.$macAddress = r102;
            this.$sn = r103;
            this.$associator = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$manager, this.$macAddress, this.$sn, this.$associator, r101);
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
            boolean r103 = this.Z$0;
            ResultKt.throwOnFailure(r100);
        L12:
            if (r103 == true) goto L15;
            this.this$0.enableCdm(true, this.$manager, this.$associator, this.$macAddress, this.$sn);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            boolean r104 = this.this$0.isCdmKeepAliveEnabled(this.$manager, this.$macAddress, this.$sn);
            g49.d.d(DoraKeepAliveViewModel.TAG, "loadCdmState: state=" + r104);
            MutableSharedFlow<Boolean> r105 = this.this$0.get_keepAliveCdmToggleStateFlow();
            Boolean r106 = Boxing.boxBoolean(r104);
            this.Z$0 = r104;
            this.label = 1;
            if (r105.emit(r106, this) != r101) goto L11;
            return r101;
        L11:
            r103 = r104;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadIgnoreBatteryOptimization$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveViewModel$loadIgnoreBatteryOptimization$1", f = "DoraKeepAliveViewModel.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraKeepAliveViewModel this$0;

        public C110701(DoraKeepAliveViewModel r100, Continuation<? super C110701> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110701(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110701) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            boolean r103 = DoraKeepAliveViewModel.access$isIgnoringBatteryOptimizations(this.this$0);
            g49.d.d(DoraKeepAliveViewModel.TAG, "loadIgnoreBatteryOptimization: state=" + r103);
            z0 r104 = DoraKeepAliveViewModel.access$get_ignoreBatteryOptimizationsStateFlow$p(this.this$0);
            Boolean r105 = Boxing.boxBoolean(r103);
            this.label = 1;
            if (r104.emit(r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.alive.DoraKeepAliveViewModel$loopCheckIgnoreBatteryOptimization$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveViewModel$loopCheckIgnoreBatteryOptimization$1", f = "DoraKeepAliveViewModel.kt", i = {0, 0, 1, 1}, l = {51, 52}, m = "invokeSuspend", n = {"it", "state", "it", "state"}, s = {"I$2", "Z$0", "I$2", "Z$0"})
    public static final class C110711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraKeepAliveViewModel this$0;

        public C110711(DoraKeepAliveViewModel r100, Continuation<? super C110711> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110711(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110711) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0091 -> B:20:0x0095). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            boolean r102 = this.Z$0;
            int r103 = this.I$2;
            int r104 = this.I$1;
            int r105 = this.I$0;
            DoraKeepAliveViewModel r106 = (DoraKeepAliveViewModel) this.L$0;
            ResultKt.throwOnFailure(r110);
            DoraKeepAliveViewModel r111 = r106;
            C110711 r107 = this;
        L21:
            if (r103 != 3) goto L23;
            DoraKeepAliveViewModel.access$reportBatteryOptimizeSwitch(r111, r102);
        L23:
            r103 = r104 + 1;
            int r108 = r105;
            C110711 r109 = r107;
        L11:
            if (r103 >= r108) goto L25;
            boolean r112 = DoraKeepAliveViewModel.access$isIgnoringBatteryOptimizations(r111);
            g49.d.d(DoraKeepAliveViewModel.TAG, "loopCheckIgnoreBatteryOptimization: state=" + r112);
            z0 r113 = DoraKeepAliveViewModel.access$get_ignoreBatteryOptimizationsStateFlow$p(r111);
            Boolean r114 = Boxing.boxBoolean(r112);
            r109.L$0 = r111;
            r109.I$0 = r108;
            r109.I$1 = r103;
            r109.I$2 = r103;
            r109.Z$0 = r112;
            r109.label = 1;
            if (r113.emit(r114, r109) != r100) goto L15;
            return r100;
        L15:
            DoraKeepAliveViewModel r115 = r111;
            int r116 = r103;
            r105 = r108;
            r102 = r112;
        L16:
            r109.L$0 = r115;
            r109.I$0 = r105;
            r109.I$1 = r116;
            r109.I$2 = r103;
            r109.Z$0 = r102;
            r109.label = 2;
            if (DelayKt.delay(500, r109) != r100) goto L19;
            return r100;
        L19:
            C110711 r117 = r109;
            r104 = r116;
            r111 = r115;
            r107 = r117;
            goto L21
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r102 = this.Z$0;
            r103 = this.I$2;
            int r118 = this.I$1;
            r105 = this.I$0;
            r115 = (DoraKeepAliveViewModel) this.L$0;
            ResultKt.throwOnFailure(r110);
            r116 = r118;
            r109 = this;
            goto L16
        L10:
            ResultKt.throwOnFailure(r110);
            r111 = this.this$0;
            r108 = 4;
            r103 = 0;
            r109 = this;
            goto L11
        }
    }

    static {
        Companion = new a();
    }

    private final boolean isIgnoringBatteryOptimizations() {
        AppHost.Companion r100 = AppHost.f326268a;
        Object r101 = r100.getApplication().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if ((r101 instanceof PowerManager) == false) goto L5;
        PowerManager r102 = (PowerManager) r101;
    L7:
        if (r102 != null) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return false;
    L12:
        return r102.isIgnoringBatteryOptimizations(r100.getApplication().getPackageName());
    L5:
        r102 = null;
        goto L7
    }

    public final boolean isOngoingNotificationEnabled() {
        b0.f338123a.getClass();
        return b0.j().getBoolean("dora_enable_ongoing_notification", true);
    }

    public DoraKeepAliveViewModel() {
        StateFlowImpl r100 = j1.a(Boolean.FALSE);
        this._ignoreBatteryOptimizationsStateFlow = r100;
        this.ignoreBatteryOptimizationStateFlow = r100;
        MutableSharedFlow<Boolean> r101 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._keepAliveCdmToggleStateFlow = r101;
        this.keepAliveCdmToggleStateFlow = r101;
    }

    public final void loadIgnoreBatteryOptimization() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C110701(this, null), 2, null);
    }

    public final void loopCheckIgnoreBatteryOptimization() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C110711(this, null), 2, null);
    }

    public final i1<Boolean> getIgnoreBatteryOptimizationStateFlow() {
        return this.ignoreBatteryOptimizationStateFlow;
    }

    public final d1<Boolean> getKeepAliveCdmToggleStateFlow() {
        return this.keepAliveCdmToggleStateFlow;
    }

    public final MutableSharedFlow<Boolean> get_keepAliveCdmToggleStateFlow() {
        return this._keepAliveCdmToggleStateFlow;
    }

    public static final /* synthetic */ z0 access$get_ignoreBatteryOptimizationsStateFlow$p(DoraKeepAliveViewModel r100) {
        return r100._ignoreBatteryOptimizationsStateFlow;
    }

    public static final /* synthetic */ boolean access$isIgnoringBatteryOptimizations(DoraKeepAliveViewModel r100) {
        return r100.isIgnoringBatteryOptimizations();
    }

    private final void reportBatteryOptimizeSwitch(boolean r100) {
        j49.b.f497374a.c(2, r100);
        DoraBuryPointManager r101 = DoraBuryPointManager.f331862a;
        if (r100 == false) goto L5;
        String r102 = "on";
    L6:
        DoraBuryPointManager.J(r101, "dm_battery_optimize_switch", MapsKt.mapOf(TuplesKt.to("battery_optimize_switch", r102)), false, 12);
        return;
    L5:
        r102 = "off";
        goto L6
    }

    private final void updateKeepAliveCdmStateAndReport(boolean r100) {
        this._keepAliveCdmToggleStateFlow.tryEmit(Boolean.valueOf(r100));
        j49.b.f497374a.c(1, r100);
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "dm_keep_alive_cdm_switch", MapsKt.mapOf(TuplesKt.to("keep_alive_cdm_switch", j49.b.l(r100))), false, 12);
    }

    public void enableOngoingNotification(boolean r100) {
        b0.f338123a.getClass();
        b0.j().storeBoolean("dora_enable_ongoing_notification", r100);
    }

    public static final /* synthetic */ void access$reportBatteryOptimizeSwitch(DoraKeepAliveViewModel r100, boolean r101) {
        r100.reportBatteryOptimizeSwitch(r101);
    }

    public static final /* synthetic */ void access$updateKeepAliveCdmStateAndReport(DoraKeepAliveViewModel r100, boolean r101) {
        r100.updateKeepAliveCdmStateAndReport(r101);
    }

    public final boolean isCdmKeepAliveEnabled(IFlowCompanionDeviceManager r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "macAddress");
        Intrinsics.checkNotNullParameter(r102, "sn");
        if (r100 == null) goto L5;
        boolean r103 = r100.b(r101);
    L6:
        if (r103 == true) goto L11;
        if (r100 == null) goto L9;
        boolean r104 = r100.c(r102);
    L10:
        if (r104 == true) goto L11;
        return false;
    L9:
        r104 = false;
    L11:
        if (r100 == null) goto L13;
        boolean r105 = r100.m(r101);
    L14:
        if (r105 == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        r105 = false;
        goto L14
    L5:
        r103 = false;
        goto L6
    }

    public void loadCdmState(IFlowCompanionDeviceManager r110, oy8.e r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r112, "macAddress");
        Intrinsics.checkNotNullParameter(r113, "sn");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r110, r112, r113, r111, null), 2, null);
    }

    public final void enableCdm(boolean r100, IFlowCompanionDeviceManager r101, oy8.e r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "macAddress");
        Intrinsics.checkNotNullParameter(r104, "sn");
        if (r101 == null) goto L39;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r100 == true) goto L9;
    L32:
        e = move-exception;
        g49.d.c(TAG, "Error disabling CDM ", e);
        return;
    L25:
        if (r101.m(r103) == false) goto L28;
        r101.d(r103);     // Catch: Exception -> L32
    L28:
        if (r101.b(r103) == false) goto L30;
        r101.a(r103);     // Catch: Exception -> L32
    L30:
        r101.k(r104);     // Catch: Exception -> L32
        updateKeepAliveCdmStateAndReport(false);     // Catch: Exception -> L32
        return;
    L9:
        if (r101.c(r104) == false) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L35;
        r102.a(r103, r104, new b(r101, this));
        return;
    L35:
    L22:
        e = move-exception;
        g49.d.c(TAG, "Start observing failed , maybe re-associate needed?", e);
        updateKeepAliveCdmStateAndReport(false);
        return;
    L18:
        if (r101.m(r103) == true) goto L20;
        r101.g(r103);     // Catch: Exception -> L22
    L20:
        updateKeepAliveCdmStateAndReport(true);     // Catch: Exception -> L22
        return;
    L11:
        if (r101.b(r103) == true) goto L14;
        r105 = false;
        goto L15
    }
}
