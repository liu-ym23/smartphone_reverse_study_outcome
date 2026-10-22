package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class InputAdapter$loop$1 extends BlockingAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ InputAdapter f492119g;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007b -> B:25:0x007e). Please report as a decompilation issue!!! */
    @Override // io.ktor.utils.io.jvm.javaio.BlockingAdapter
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof InputAdapter$loop$1$loop$1) == false) goto L7;
        InputAdapter$loop$1$loop$1 r100 = (InputAdapter$loop$1$loop$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        InputAdapter$loop$1 r104 = (InputAdapter$loop$1) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L25:
        int r112 = ((Number) r111).intValue();
        if (r112 == (-1)) goto L27;
    L17:
        r104.result = r112;
        r100.L$0 = r104;
        r100.L$1 = r104;
        r100.label = 1;
        r111 = BlockingAdapter.a(r104, r100);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L20:
        if (r111 != r102) goto L22;
        return r102;
    L22:
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.ByteArray");
        ByteReadChannel r105 = r104.f492119g.f492115a;
        int r106 = r104.f492108d;
        int r107 = r104.f492109e;
        r100.L$0 = r104;
        r100.L$1 = null;
        r100.label = 2;
        r111 = r105.r((byte[]) r111, r106, r107, r100);
        if (r111 != r102) goto L25;
        return r102;
    L27:
        r104.f492119g.f492116b.complete();
        r104.result = r112;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        BlockingAdapter r108 = (BlockingAdapter) r100.L$1;
        r104 = (InputAdapter$loop$1) r100.L$0;
        ResultKt.throwOnFailure(r111);
        goto L22
    L16:
        ResultKt.throwOnFailure(r111);
        r112 = 0;
        r104 = this;
    L7:
        r100 = new InputAdapter$loop$1$loop$1(this, r110);
        goto L8
    }

    public InputAdapter$loop$1(Job r100, InputAdapter r101) {
        this.f492119g = r101;
        super(r100);
    }
}
