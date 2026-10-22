package com.bytedance.assem.jedi_vm.store;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "", "p1", "", "Lkotlin/ParameterName;", "name", LynxError.LYNX_THROWABLE, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class RxStore$2 extends FunctionReference implements Function1<Throwable, Unit> {
    public RxStore$2(b r100) {
        super(1, r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "handleError";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "handleError(Ljava/lang/Throwable;)V";
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable r100) {
        ((b) this.receiver).getClass();
    L3:
        if (r100 == null) goto L5;
        Throwable r101 = r100.getCause();
    L6:
        if (r101 == null) goto L8;
        r100 = r100.getCause();
        goto L3
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        throw r100;
    L5:
        r101 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
