package lwc;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.error.DefinitionParameterException;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static final a a(Object... r100) {
        Intrinsics.checkNotNullParameter(r100, "parameters");
        if (r100.length > 5) goto L7;
        return new a(ArraysKt.toMutableList(r100));
    L7:
        throw new DefinitionParameterException("Can't build DefinitionParameters for more than 5 arguments");
    }
}
