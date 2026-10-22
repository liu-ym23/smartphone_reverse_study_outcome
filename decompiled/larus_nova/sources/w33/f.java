package w33;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f<DATA> extends e<DATA> {
    public f(DATA r100) {
        super(r100);
    }

    public static boolean b(Object r100) {
        if ((r100 instanceof Integer) == false) goto L5;
    L20:
        return false;
    L5:
        if ((r100 instanceof Boolean) == true) goto L20;
        if ((r100 instanceof Long) == true) goto L20;
        if ((r100 instanceof Double) == true) goto L20;
        if ((r100 instanceof Float) == true) goto L20;
        if ((r100 instanceof Short) == true) goto L20;
        if ((r100 instanceof Byte) == true) goto L20;
        if ((r100 instanceof Character) == true) goto L20;
        return true;
    }

    public final void c(DATA r100) {
        DATA r101 = this.f558140a;
        this.f558140a = r100;
        if (b(r101) == false) goto L5;
    L10:
        if (r101 == r100) goto L18;
    L12:
        Iterator r102 = ((ArrayList) this.f558141b).iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        ((c) r102.next()).onChanged(this.f558140a);
        goto L14
    L19:
        return;
    L18:
        return;
    L5:
        if (b(r100) == true) goto L10;
        if (Intrinsics.areEqual(r101, r100) == false) goto L12;
    }
}
