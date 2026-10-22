package com.ss.android.lark.screenprotect.screenshot;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.screenprotect.screenshot.ShareScreenshotUtil$clear$1", f = "ShareScreenshotUtil.kt", i = {0}, l = {113}, m = "invokeSuspend", n = {"scContext"}, s = {"L$0"})
public final class ShareScreenshotUtil$clear$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $lkEventId;
    Object L$0;
    int label;

    public ShareScreenshotUtil$clear$1(int r100, Continuation<? super ShareScreenshotUtil$clear$1> r101) {
        this.$lkEventId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ShareScreenshotUtil$clear$1(this.$lkEventId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ShareScreenshotUtil$clear$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ShareScreenshotUtil.b r103 = (ShareScreenshotUtil.b) this.L$0;
        ResultKt.throwOnFailure(r100);
    L21:
        ShareScreenshotUtil.b r104 = r103;
    L22:
        SoftReference<Bitmap> r105 = r104.f439811b;
        Bitmap r106 = r105.get();
        if (r106 == null) goto L25;
        r106.recycle();
    L25:
        r105.clear();
        r104.f439810a = null;
        r104.f439812c = null;
    L26:
        ShareScreenshotUtil r107 = ShareScreenshotUtil.f439806a;
        ShareScreenshotUtil.f439807b.remove(Boxing.boxInt(this.$lkEventId));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ShareScreenshotUtil r108 = ShareScreenshotUtil.f439806a;
        Map<Integer, ShareScreenshotUtil.b> r109 = ShareScreenshotUtil.f439807b;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        r104 = (ShareScreenshotUtil.b) r110.get(Boxing.boxInt(this.$lkEventId));
        if (r104 == null) goto L26;
        String r111 = r104.f439813d;
        if (r111 == null) goto L22;
        if (r111.length() <= 0) goto L15;
        boolean r112 = true;
    L16:
        if (r112 == false) goto L22;
        this.L$0 = r104;
        this.label = 1;
        if (ShareScreenshotUtil.a(r108, r111, this) != r101) goto L20;
        return r101;
    L20:
        r103 = r104;
        goto L21
    L15:
        r112 = false;
        goto L16
    }
}
