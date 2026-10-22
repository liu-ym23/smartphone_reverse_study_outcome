package d80;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f467382a = 0;

    static {
    }

    public static Object a(LinkedHashMap r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getNextKeyAfterKey");
        Iterator r102 = r100.keySet().iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r104 = r102.next();
        if (r103 == true) goto L7;
        if (Intrinsics.areEqual(r104, r101) == false) goto L4;
        r103 = true;
        goto L4
    L7:
        return r104;
    L11:
        return null;
    }
}
