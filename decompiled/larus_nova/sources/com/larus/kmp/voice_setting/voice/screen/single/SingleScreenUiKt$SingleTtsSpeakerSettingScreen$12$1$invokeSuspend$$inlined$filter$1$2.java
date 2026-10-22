package com.larus.kmp.voice_setting.voice.screen.single;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes30.dex */
public final class SingleScreenUiKt$SingleTtsSpeakerSettingScreen$12$1$invokeSuspend$$inlined$filter$1$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f354826a;

    /* JADX INFO: renamed from: com.larus.kmp.voice_setting.voice.screen.single.SingleScreenUiKt$SingleTtsSpeakerSettingScreen$12$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.kmp.voice_setting.voice.screen.single.SingleScreenUiKt$SingleTtsSpeakerSettingScreen$12$1$invokeSuspend$$inlined$filter$1$2", f = "SingleScreenUi.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleScreenUiKt$SingleTtsSpeakerSettingScreen$12$1$invokeSuspend$$inlined$filter$1$2 this$0;

        public AnonymousClass1(SingleScreenUiKt$SingleTtsSpeakerSettingScreen$12$1$invokeSuspend$$inlined$filter$1$2 r100, Continuation r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public SingleScreenUiKt$SingleTtsSpeakerSettingScreen$12$1$invokeSuspend$$inlined$filter$1$2(FlowCollector r100) {
        this.f354826a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
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
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FlowCollector r107 = this.f354826a;
        if ((!((List) r100).isEmpty()) == false) goto L20;
        r102.label = 1;
        if (r107.emit(r100, r102) != r105) goto L20;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
