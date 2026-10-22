package com.larus.im.internal.database.slowtask.index;

import be9.c;
import com.larus.im.internal.database.delegate.DbIndexDaoSource;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a extends AbsDBIndexOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f348146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f348147b;

    @Override // com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator
    public final String f() {
        return this.f348147b;
    }

    public a(DbIndexDaoSource r100) {
        Intrinsics.checkNotNullParameter(r100, "indexDAO");
        this.f348146a = r100;
        this.f348147b = "DBIndexOperatorCompat";
    }

    @Override // com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator
    public final Object d(String r100, ContinuationImpl r101) {
        return this.f348146a.e(r100, r101);
    }

    @Override // com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator
    public final Object e(String r100, Continuation<? super List<String>> r101) {
        return this.f348146a.d(r100, r101);
    }

    @Override // com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator
    public final Object g(String r100, Continuation<? super Boolean> r101) {
        return this.f348146a.b(r100, r101);
    }

    @Override // com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator
    public final Object a(String r100, String r101, List<String> r102, Continuation<? super Boolean> r103) {
        return this.f348146a.a(r100, r101, r102, r103);
    }

    @Override // com.larus.im.internal.database.slowtask.index.AbsDBIndexOperator
    public final Object b(String r100, String r101, String r102, Continuation<? super Boolean> r103) {
        return this.f348146a.c(r100, r101, r102, r103);
    }
}
