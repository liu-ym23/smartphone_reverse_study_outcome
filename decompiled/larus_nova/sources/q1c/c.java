package q1c;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {
    public static final <T> b<T> a(com.larksuite.rucket.job.base.b<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L6;
        return new b.C7270b(((com.larksuite.rucket.job.base.b.c) r100).f286079b);
    L6:
        if ((r100 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L10;
        return new b.a(((com.larksuite.rucket.job.base.b.C3939b) r100).f286078b);
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
