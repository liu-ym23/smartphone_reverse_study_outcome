package y36;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class o extends i<List<? extends String>> {

    public static final class a {
    }

    static {
    }

    @Override // t36.c
    public final String a() {
        StringBuilder r100 = new StringBuilder();
        List r101 = (List) this.f565862b;
        if (r101 == null) goto L9;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        r100.append((String) r102.next());
        r100.append(',');
    L9:
        return r100.toString();
    }

    public o(List<String> r100) {
        super(r100);
    }

    @Override // y36.i
    public final List<? extends String> d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "string");
        ArrayList r100 = new ArrayList();
        Iterator r111 = StringsKt.split$default(r110, new char[]{','}, false, 0, 6, null).iterator();
    L4:
        if (r111.hasNext() == false) goto L11;
        String r101 = (String) r111.next();
        if (r101.length() <= 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
        r100.add(r101);
        goto L4
    L8:
        r102 = false;
        goto L9
    L11:
        return r100;
    }

    public o(t36.d r100, String r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, r102);
    }
}
