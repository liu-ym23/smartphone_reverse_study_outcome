package com.obric.assistant.cocreationreview;

import com.bytedance.keva.Keva;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes32.dex */
public final class CocreationTaskRunStore {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<Keva> f387135c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Boolean> f387136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Unit> f387137b;

    public static final class a {
    }

    static {
        f387135c = LazyKt.lazy(new r4());
    }

    public CocreationTaskRunStore(int r100) {
        Function1<String, Boolean> r101 = new s4();
        Function1<String, Unit> r102 = new t4();
        Intrinsics.checkNotNullParameter(r101, "readRun");
        Intrinsics.checkNotNullParameter(r102, "writeRun");
        this.f387136a = r101;
        this.f387137b = r102;
    }

    public static final String a(CocreationTaskRunStore r100, String r101, String r102) {
        r100.getClass();
        return r101.length() + ':' + r101 + ':' + r102;
    }

    public final Object b(String r100, List<e4> r101, Continuation<? super Set<String>> r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CocreationTaskRunStore$loadRunIds$2(r100, r101, this, null), r102);
    }
}
