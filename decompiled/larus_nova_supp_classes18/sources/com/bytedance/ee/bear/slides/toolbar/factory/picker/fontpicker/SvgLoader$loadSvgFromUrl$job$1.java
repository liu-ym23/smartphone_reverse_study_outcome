package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker.SvgLoader$loadSvgFromUrl$job$1", f = "SvgLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SvgLoader$loadSvgFromUrl$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $callback;
    final /* synthetic */ AppCompatImageView $imageView;
    final /* synthetic */ String $svgUrl;
    int label;

    public SvgLoader$loadSvgFromUrl$job$1(AppCompatImageView r1, String r2, i r3, Continuation<? super SvgLoader$loadSvgFromUrl$job$1> r4) {
        this.$imageView = r1;
        this.$svgUrl = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SvgLoader$loadSvgFromUrl$job$1(this.$imageView, this.$svgUrl, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r5);
        OkHttpClient r6 = j.a;     // Catch: Exception -> L7 Throwable -> L9
        j.a(this.$imageView, this.$svgUrl, this.$callback);     // Catch: Exception -> L7 Throwable -> L9
    L12:
        j.f.remove(this.$svgUrl);
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        j.f.remove(this.$svgUrl);
        throw th;
    L7:
        e = move-exception;
        OkHttpClient r0 = j.a;     // Catch: Throwable -> L9
        AppCompatImageView r1 = this.$imageView;     // Catch: Throwable -> L9
        String r2 = this.$svgUrl;     // Catch: Throwable -> L9
        com.bytedance.ee.util.ui.m.a(new k(this.$callback, r1, r2, e));     // Catch: Throwable -> L9
        goto L12
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
