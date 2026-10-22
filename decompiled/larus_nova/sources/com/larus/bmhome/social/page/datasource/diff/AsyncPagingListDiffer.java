package com.larus.bmhome.social.page.datasource.diff;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class AsyncPagingListDiffer<DATA> extends PagingListDiffer<DATA> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f314004e = 0;

    public static final class a {
    }

    public static final class b<DATA> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f314005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f314006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f314007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<DATA> f314008d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f314005a == r101.f314005a) goto L12;
            return false;
        L12:
            if (this.f314006b == r101.f314006b) goto L15;
            return false;
        L15:
            if (this.f314007c == r101.f314007c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f314008d, r101.f314008d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f314005a * 31) + this.f314006b) * 31) + this.f314007c) * 31) + this.f314008d.hashCode();
        }

        public final String toString() {
            return "Op(opCode=" + this.f314005a + ", start=" + this.f314006b + ", itemCount=" + this.f314007c + ", source=" + this.f314008d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(int r100, int r101, int r102, List<? extends DATA> r103) {
            Intrinsics.checkNotNullParameter(r103, "source");
            this.f314005a = r100;
            this.f314006b = r101;
            this.f314007c = r102;
            this.f314008d = r103;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.b
    public final List<DATA> c() {
        return com.larus.utils.h.d(this.f314014d);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object i(Continuation r100) {
        l(new b(3, 0, 0, CollectionsKt.emptyList()), r100);
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object k(Continuation r100) {
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer, com.larus.bmhome.social.page.datasource.diff.b
    public final /* bridge */ /* synthetic */ Object b(com.larus.bmhome.social.page.datasource.event.a r100, Continuation r101) {
        return f((h) r100, r101);
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object e(List<? extends DATA> r100, Continuation<? super Unit> r101) {
        this.f314014d.size();
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object f(h<DATA> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AsyncPagingListDiffer$collectEvent$1) == false) goto L7;
        AsyncPagingListDiffer$collectEvent$1 r102 = (AsyncPagingListDiffer$collectEvent$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (h) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L19:
        r102.L$0 = null;
        r102.label = 2;
        if (PagingListDiffer.g(this, r100, r102) != r105) goto L23;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        AsyncPagingListDiffer$collectEvent$2 r107 = new AsyncPagingListDiffer$collectEvent$2(this, null);
        r102.L$0 = r100;
        r102.label = 1;
        if (CoroutineExtKt.a(EmptyCoroutineContext.INSTANCE, r107, r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new AsyncPagingListDiffer$collectEvent$1(this, r101);
        goto L8
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public final Object h(List<? extends DATA> r100, Continuation<? super Unit> r101) {
        throw null;
    }

    public final void l(b r100, Continuation r101) {
        if ((r101 instanceof AsyncPagingListDiffer$dispatchOp$1) == false) goto L7;
        AsyncPagingListDiffer$dispatchOp$1 r102 = (AsyncPagingListDiffer$dispatchOp$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L12;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r102.L$1;
        b r107 = (b) r102.L$0;
        ResultKt.throwOnFailure(r104);
        throw null;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.L$1 = null;
        r102.label = 1;
        throw null;
    L7:
        r102 = new AsyncPagingListDiffer$dispatchOp$1(this, r101);
        goto L8
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object insert(int r100, List<? extends DATA> r101, Continuation<? super Unit> r102) {
        l(new b(1, r100, r101.size(), r101), r102);
        throw null;
    }

    @Override // com.larus.bmhome.social.page.datasource.diff.PagingListDiffer
    public Object update(int r100, List<? extends DATA> r101, Continuation<? super Unit> r102) {
        l(new b(2, r100, r101.size(), r101), r102);
        throw null;
    }
}
