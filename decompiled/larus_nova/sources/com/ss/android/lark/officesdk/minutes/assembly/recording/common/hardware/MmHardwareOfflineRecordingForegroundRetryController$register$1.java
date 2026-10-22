package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import android.app.Activity;
import android.os.Bundle;
import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yub.d;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareOfflineRecordingForegroundRetryController$register$1", f = "MmHardwareOfflineRecordingForegroundRetryController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmHardwareOfflineRecordingForegroundRetryController$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController this$0;

    public static final class a implements yub.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController f433676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f433677b;

        @Override // yub.a.b
        public final void onActivityCreated(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // yub.a.b
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // yub.a.b
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // yub.a.b
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // yub.a.b
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // yub.a.b
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            MmHardwareOfflineRecordingForegroundRetryController.a(this.f433676a, this.f433677b, this, "activity_resumed");
        }

        @Override // yub.a.b
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            MmHardwareOfflineRecordingForegroundRetryController.a(this.f433676a, this.f433677b, this, "activity_started");
        }

        public a(MmHardwareOfflineRecordingForegroundRetryController r100, String r101) {
            this.f433676a = r100;
            this.f433677b = r101;
        }
    }

    public MmHardwareOfflineRecordingForegroundRetryController$register$1(MmHardwareOfflineRecordingForegroundRetryController r100, String r101, Continuation<? super MmHardwareOfflineRecordingForegroundRetryController$register$1> r102) {
        this.this$0 = r100;
        this.$recordingId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmHardwareOfflineRecordingForegroundRetryController$register$1(this.this$0, this.$recordingId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmHardwareOfflineRecordingForegroundRetryController$register$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        yub.a.b r101 = (yub.a.b) ((LinkedHashMap) this.this$0.f433674e).get(this.$recordingId);
        if (r101 == null) goto L8;
        MmHardwareOfflineRecordingForegroundRetryController.a(this.this$0, this.$recordingId, r101, "register_again");
        return Unit.INSTANCE;
    L8:
        MmHardwareOfflineRecordingForegroundRetryController r102 = this.this$0;
        String r103 = this.$recordingId;
        a r104 = new a(r102, r103);
        r102.f433674e.put(r103, r104);
        d r105 = d.f569261a;
        Intrinsics.checkNotNullParameter(r104, "observer");
        HashMap<yub.a.b, com.ss.android.lark.appcontext.applifecycle.a> r106 = d.f569262b;
        if (r106.containsKey(r104) == true) goto L12;
        yub.b r107 = new yub.b(r104);
        r106.put(r104, r107);
        int r108 = com.ss.android.lark.appcontext.applifecycle2.api.a.f408875a;
        Intrinsics.checkNotNullParameter(r107, "activityObserver");
        AppLifecycle2.a().b(r107);
    L12:
        lvb.a.e(this.this$0.f433673d, "[register] wait activity foreground, recordingId=" + this.$recordingId);
        MmHardwareOfflineRecordingForegroundRetryController.a(this.this$0, this.$recordingId, r104, "foreground_after_register");
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
