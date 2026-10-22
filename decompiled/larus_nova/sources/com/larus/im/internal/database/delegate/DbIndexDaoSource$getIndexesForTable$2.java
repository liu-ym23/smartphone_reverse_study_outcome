package com.larus.im.internal.database.delegate;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.DbIndexDaoSource$getIndexesForTable$2", f = "DbIndexDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DbIndexDaoSource$getIndexesForTable$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $tableName;
    int label;

    public DbIndexDaoSource$getIndexesForTable$2(String r100, Continuation<? super DbIndexDaoSource$getIndexesForTable$2> r101) {
        this.$tableName = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new DbIndexDaoSource$getIndexesForTable$2(this.$tableName, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends String>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<String>> r100) {
        return ((DbIndexDaoSource$getIndexesForTable$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = DbIndexDaoSource.f347924b;
        return DbIndexDaoSource.a.a().getIndexesForTable(this.$tableName);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
