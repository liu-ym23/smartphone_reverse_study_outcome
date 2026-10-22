package com.bytedance.assem.jedi_vm.store;

import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "S", "", "p1", "", "Lkotlin/ParameterName;", "name", "throwable", "invoke"}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final /* synthetic */ class RxStore$2 extends FunctionReference implements Function1<Throwable, Unit> {
    public RxStore$2(b r2) {
        super(1, r2);
    }

    public final String getName() {
        return "handleError";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(b.class);
    }

    public final String getSignature() {
        return "handleError(Ljava/lang/Throwable;)V";
    }

    public final void invoke(Throwable r2) {
        ((b) ((CallableReference) this).receiver).getClass();
    L3:
        if (r2 == null) goto L5;
        Throwable r0 = r2.getCause();
    L6:
        if (r0 == null) goto L8;
        r2 = r2.getCause();
        goto L3
    L8:
        if (r2 != null) goto L10;
        return;
    L10:
        throw r2;
    L5:
        r0 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
