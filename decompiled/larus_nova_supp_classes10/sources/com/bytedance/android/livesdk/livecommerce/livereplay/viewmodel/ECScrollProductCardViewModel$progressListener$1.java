package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "progress", "p2", "", "isFromUser", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECScrollProductCardViewModel$progressListener$1 extends FunctionReferenceImpl implements Function2<Long, Boolean, Unit> {
    public ECScrollProductCardViewModel$progressListener$1(ECScrollProductCardViewModel r8) {
        super(2, r8, ECScrollProductCardViewModel.class, "onProgressListener", "onProgressListener(JZ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).longValue(), ((Boolean) r4).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long r2, boolean r4) {
        ECScrollProductCardViewModel.access$onProgressListener((ECScrollProductCardViewModel) ((CallableReference) this).receiver, r2, r4);
    }
}
