package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Landroid/content/Context;", "p2", "Lkotlin/Function2;", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FlashController$showFlashPanel$1$localFlash$1 extends FunctionReferenceImpl implements Function2<Context, Function2<? super String, ? super String, ? extends Unit>, Unit> {
    public FlashController$showFlashPanel$1$localFlash$1(FlashController r8) {
        super(2, r8, FlashController.class, "getScreenshotSquare", "getScreenshotSquare(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", 0);
    }

    public final void invoke(Context r2, Function2<? super String, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "p2");
        ((FlashController) ((CallableReference) this).receiver).H(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Context) r1, (Function2) r2);
        return Unit.INSTANCE;
    }
}
