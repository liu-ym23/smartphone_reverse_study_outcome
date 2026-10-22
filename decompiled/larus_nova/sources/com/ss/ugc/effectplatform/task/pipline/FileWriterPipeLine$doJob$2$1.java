package com.ss.ugc.effectplatform.task.pipline;

import bytekn.foundation.utils.Transmitter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "progress", "p2", "", "contentLength", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class FileWriterPipeLine$doJob$2$1 extends FunctionReference implements Function2<Integer, Long, Unit> {
    public FileWriterPipeLine$doJob$2$1(b r100) {
        super(2, r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "onProgress";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(b.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "onProgress(IJ)V";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, Long r101) {
        invoke(r100.intValue(), r101.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100, long r101) {
        b r102 = (b) this.receiver;
        int r103 = b.f457900a;
        r102.getClass();
        Transmitter.a(new c(r102, r100, r101));
    }
}
