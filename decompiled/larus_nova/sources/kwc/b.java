package kwc;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.DefinitionOverrideException;

/* JADX INFO: loaded from: classes42.dex */
public final class b {
    public static final void a(HashSet<BeanDefinition<?>> r100, BeanDefinition<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bean");
        boolean r102 = r100.add(r101);
        if (r102 == false) goto L5;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        if (r101.f526134g.f526140b == false) goto L15;
        r100.remove(r101);
        r100.add(r101);
        return;
    L15:
        return;
    L5:
        if (r101.f526134g.f526140b == true) goto L9;
        throw new DefinitionOverrideException("Definition '" + r101 + "' try to override existing definition. Please use override option to fix it");
    }
}
