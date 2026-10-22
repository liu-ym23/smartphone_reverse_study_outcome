package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class MemberScopeKt {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        HashSet r101 = new HashSet();
        Iterator<? extends MemberScope> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Set<Name> r103 = r102.next().getClassifierNames();
        if (r103 == null) goto L7;
        CollectionsKt.addAll(r101, r103);
        goto L4
    L7:
        return null;
    L12:
        return r101;
    }
}
