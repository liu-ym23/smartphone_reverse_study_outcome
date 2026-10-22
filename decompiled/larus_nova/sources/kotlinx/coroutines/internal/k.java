package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@JvmInline
public final class k<E> {
    public static final Object a(Object r100, E r101) {
        if (r100 != null) goto L5;
        return r101;
    L5:
        if ((r100 instanceof ArrayList) == false) goto L7;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ((ArrayList) r100).add(r101);
        return r100;
    L7:
        ArrayList r102 = new ArrayList(4);
        r102.add(r100);
        r102.add(r101);
        return r102;
    }
}
