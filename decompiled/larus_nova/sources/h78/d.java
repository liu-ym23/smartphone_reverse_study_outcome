package h78;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f483999a;

    public d(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "prefixCodeList");
        this.f483999a = r100;
    }

    @Override // h78.b
    public final boolean a(String r100) {
        List<String> r101 = this.f483999a;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (StringsKt.startsWith$default(r100, (String) r102.next(), false, 2, null) == false) goto L9;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L21;
        return false;
    L21:
        return true;
    L13:
        r103 = false;
        goto L14
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }
}
