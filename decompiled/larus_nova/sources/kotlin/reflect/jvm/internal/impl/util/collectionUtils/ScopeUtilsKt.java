package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes5.dex */
public final class ScopeUtilsKt {
    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> r100) {
        Intrinsics.checkNotNullParameter(r100, ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE);
        SmartList<MemberScope> r101 = new SmartList();
        Iterator<? extends MemberScope> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        MemberScope r103 = r102.next();
        MemberScope r104 = r103;
        if (r104 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        if (r104 == MemberScope.Empty.INSTANCE) goto L10;
        r105 = true;
        goto L11
    L13:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> r100, Collection<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "collection");
        if (r101.isEmpty() == false) goto L5;
        return r100;
    L5:
        if (r100 != 0) goto L8;
        return r101;
    L8:
        if ((r100 instanceof LinkedHashSet) == false) goto L11;
        ((LinkedHashSet) r100).addAll(r101);
        return r100;
    L11:
        LinkedHashSet r102 = new LinkedHashSet(r100);
        r102.addAll(r101);
        return r102;
    }
}
