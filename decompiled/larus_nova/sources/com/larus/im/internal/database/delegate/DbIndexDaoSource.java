package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.dao.DBIndexDAO;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
public final class DbIndexDaoSource implements be9.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f347924b = 0;

    public static final class a {
        public static final DBIndexDAO a() {
            int r100 = DbIndexDaoSource.f347924b;
            com.larus.im.internal.database.b.f347916a.getClass();
            return com.larus.im.internal.database.b.a.b().indexDao();
        }

        public a() {
        }

        public static final Object b(Function1 r100, ContinuationImpl r101) {
            int r102 = DbIndexDaoSource.f347924b;
            com.larus.im.internal.database.b.f347916a.getClass();
            com.larus.im.internal.database.b.a.b();
            return com.larus.im.internal.database.d.a(r100, r101);
        }
    }

    static {
        new a();
    }

    public DbIndexDaoSource() {
    }

    @Override // be9.c
    public final Object b(String r100, Continuation<? super Boolean> r101) {
        return a.b(new DbIndexDaoSource$isIndexExists$2(r100, null), (ContinuationImpl) r101);
    }

    @Override // be9.c
    public final Object d(String r100, Continuation<? super List<String>> r101) {
        return a.b(new DbIndexDaoSource$getIndexesForTable$2(r100, null), (ContinuationImpl) r101);
    }

    @Override // be9.c
    public final Object e(String r100, ContinuationImpl r101) {
        return a.b(new DbIndexDaoSource$dropIndex$2(r100, null), r101);
    }

    @Override // be9.c
    public final Object a(String r100, String r101, List<String> r102, Continuation<? super Boolean> r103) {
        return a.b(new DbIndexDaoSource$createCompositeIndex$2(r100, r101, r102, null), (ContinuationImpl) r103);
    }

    @Override // be9.c
    public final Object c(String r100, String r101, String r102, Continuation<? super Boolean> r103) {
        return a.b(new DbIndexDaoSource$createSingleIndex$2(r100, r101, r102, null), (ContinuationImpl) r103);
    }
}
