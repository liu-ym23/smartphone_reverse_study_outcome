package com.bytedance.rts.foundation;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, JSEventListener.ACTION_RESOLVE, "Lkotlin/Function1;", "reject", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RTSPromiseKt$async$1 extends Lambda implements Function2<Function1<Object, ? extends Unit>, Function1<? super Object, ? extends Unit>, Unit> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $block;

    public static final class a implements Continuation<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EmptyCoroutineContext f267566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Object, Unit> f267567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Object, Unit> f267568c;

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f267566a;
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object r100) {
            Function1<Object, Unit> r101 = this.f267567b;
            if (Result.m9456isSuccessimpl(r100) == false) goto L5;
            r101.invoke(r100);
        L5:
            Function1<Object, Unit> r102 = this.f267568c;
            Throwable r103 = Result.m9452exceptionOrNullimpl(r100);
            if (r103 == null) goto L9;
            r102.invoke(r103);
            return;
        }

        public a(Function1<Object, Unit> r100, Function1<Object, Unit> r101) {
            this.f267567b = r100;
            this.f267568c = r101;
            this.f267566a = EmptyCoroutineContext.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RTSPromiseKt$async$1(Function1<? super Continuation<Object>, ? extends Object> r100) {
        this.$block = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Function1<Object, Unit> r100, Function1<Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r101, "reject");
        ContinuationKt.startCoroutine(this.$block, new a(r100, r101));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Function1<Object, ? extends Unit> r100, Function1<? super Object, ? extends Unit> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
