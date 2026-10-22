package com.larus.im.internal.database.delegate;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.DbIndexDaoSource$createCompositeIndex$2", f = "DbIndexDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DbIndexDaoSource$createCompositeIndex$2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<String> $columns;
    final /* synthetic */ String $indexName;
    final /* synthetic */ String $tableName;
    int label;

    public DbIndexDaoSource$createCompositeIndex$2(String r100, String r101, List<String> r102, Continuation<? super DbIndexDaoSource$createCompositeIndex$2> r103) {
        this.$indexName = r100;
        this.$tableName = r101;
        this.$columns = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new DbIndexDaoSource$createCompositeIndex$2(this.$indexName, this.$tableName, this.$columns, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((DbIndexDaoSource$createCompositeIndex$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = DbIndexDaoSource.f347924b;
        return Boxing.boxBoolean(DbIndexDaoSource.a.a().createCompositeIndex(this.$indexName, this.$tableName, this.$columns));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
