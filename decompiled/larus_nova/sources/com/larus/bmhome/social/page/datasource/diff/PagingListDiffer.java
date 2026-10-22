package com.larus.bmhome.social.page.datasource.diff;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class PagingListDiffer<DATA> extends b<DATA, h<DATA>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile List<? extends DATA> f314014d;

    public abstract Object e(List<? extends DATA> r100, Continuation<? super Unit> r101);

    public Object f(h<DATA> r100, Continuation<? super Unit> r101) {
        return g(this, r100, r101);
    }

    public abstract Object h(List<? extends DATA> r100, Continuation<? super Unit> r101);

    public abstract Object i(Continuation r100);

    public abstract Object insert(int r100, List<? extends DATA> r101, Continuation<? super Unit> r102);

    public abstract Object k(Continuation r100);

    public abstract Object update(int r100, List<? extends DATA> r101, Continuation<? super Unit> r102);

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(List<? extends DATA> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f314014d = r100;
        if (Intrinsics.areEqual(this.f314014d, r100) == true) goto L6;
        d(r100);
        return;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r100, Continuation r101) {
        return f((h) r100, r101);
    }

    public static /* synthetic */ <DATA> Object g(PagingListDiffer<DATA> r100, h<DATA> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof PagingListDiffer$collectEvent$1) == false) goto L7;
        PagingListDiffer$collectEvent$1 r103 = (PagingListDiffer$collectEvent$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r103.label) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r105);
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r105);
    L63:
        return Unit.INSTANCE;
    L15:
        ResultKt.throwOnFailure(r105);
    L56:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r105);
    L49:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r105);
    L42:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r105);
    L35:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r105);
    L28:
        return Unit.INSTANCE;
    L20:
        r101 = (h) r103.L$1;
        r100 = (PagingListDiffer) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        ((h.e) r101).getClass();
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        if (r100.k(r103) != r106) goto L28;
        return r106;
    L21:
        ResultKt.throwOnFailure(r105);
        if ((r101 instanceof h.e) == false) goto L30;
        ((h.e) r101).getClass();
        goto L24
    L30:
        if ((r101 instanceof h.a) == false) goto L37;
        ((h.a) r101).getClass();
        r103.label = 3;
        if (r100.e(null, r103) != r106) goto L35;
        return r106;
    L37:
        if ((r101 instanceof h.d) == false) goto L44;
        ((h.d) r101).getClass();
        r103.label = 4;
        if (r100.h(null, r103) != r106) goto L42;
        return r106;
    L44:
        if ((r101 instanceof h.c) == false) goto L51;
        ((h.c) r101).getClass();
        r103.label = 5;
        if (r100.insert(0, null, r103) != r106) goto L49;
        return r106;
    L51:
        if ((r101 instanceof h.g) == false) goto L58;
        ((h.g) r101).getClass();
        r103.label = 6;
        if (r100.update(0, null, r103) != r106) goto L56;
        return r106;
    L58:
        if ((r101 instanceof h.f) == false) goto L65;
        ((h.f) r101).getClass();
        r103.label = 7;
        if (r100.i(r103) != r106) goto L63;
        return r106;
    L65:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r103 = new PagingListDiffer$collectEvent$1(r100, r102);
        goto L8
    }
}
