package com.obric.assistant.common.utils;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2", f = "ActivityUtils.kt", i = {0}, l = {33}, m = "invokeSuspend", n = {"observers"}, s = {"L$0"})
final class ActivityUtilsKt$waitUntilDestroy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $autoFinish;
    final /* synthetic */ long $maxWaitTimeMS;
    final /* synthetic */ List<ComponentActivity> $this_waitUntilDestroy;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.common.utils.ActivityUtilsKt$waitUntilDestroy$2$1", f = "ActivityUtils.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $autoFinish;
        final /* synthetic */ Map<ComponentActivity, DefaultLifecycleObserver> $observers;
        final /* synthetic */ List<ComponentActivity> $this_waitUntilDestroy;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends ComponentActivity> r100, boolean r101, Map<ComponentActivity, DefaultLifecycleObserver> r102, Continuation<? super AnonymousClass1> r103) {
            this.$this_waitUntilDestroy = r100;
            this.$autoFinish = r101;
            this.$observers = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.$this_waitUntilDestroy, this.$autoFinish, this.$observers, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L21:
            return Boxing.boxBoolean(true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r111 = (CoroutineScope) this.L$0;
            List<ComponentActivity> r102 = this.$this_waitUntilDestroy;
            boolean r103 = this.$autoFinish;
            Map<ComponentActivity, DefaultLifecycleObserver> r112 = this.$observers;
            ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L10:
            if (r104.hasNext() == false) goto L17;
            ComponentActivity r105 = (ComponentActivity) r104.next();
            if (r103 == false) goto L16;
            if (r105.isFinishing() == true) goto L16;
            r105.finish();
        L16:
            r113.add(BuildersKt.async$default(r111, null, null, new ActivityUtilsKt$waitUntilDestroy$2$1$1$1(r105, r112, null), 3, null));
            goto L10
        L17:
            this.label = 1;
            if (AwaitKt.a(r113, this) != r100) goto L21;
            return r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityUtilsKt$waitUntilDestroy$2(long r100, List<? extends ComponentActivity> r101, boolean r102, Continuation<? super ActivityUtilsKt$waitUntilDestroy$2> r103) {
        this.$maxWaitTimeMS = r100;
        this.$this_waitUntilDestroy = r101;
        this.$autoFinish = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ActivityUtilsKt$waitUntilDestroy$2(this.$maxWaitTimeMS, this.$this_waitUntilDestroy, this.$autoFinish, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((ActivityUtilsKt$waitUntilDestroy$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Map r103 = (Map) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        Boolean r104 = (Boolean) r100;
        Iterator r105 = r103.entrySet().iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        Map.Entry r106 = (Map.Entry) r105.next();
        ComponentActivity r107 = (ComponentActivity) r106.getKey();
        DefaultLifecycleObserver r108 = (DefaultLifecycleObserver) r106.getValue();
        r107.getLifecycle().removeObserver(r108);
        goto L14
    L16:
        if (r104 != null) goto L18;
        FLogger.f375446a.w("ActivityUtils", "waitUntilDestroy timeout");
    L18:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        LinkedHashMap r109 = new LinkedHashMap();
        long r110 = this.$maxWaitTimeMS;
        AnonymousClass1 r111 = new AnonymousClass1(this.$this_waitUntilDestroy, this.$autoFinish, r109, null);
        this.L$0 = r109;
        this.label = 1;
        Object r112 = TimeoutKt.c(r110, r111, this);
        if (r112 != r101) goto L11;
        return r101;
    L11:
        r103 = r109;
        r100 = r112;
        goto L12
    }
}
