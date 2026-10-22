package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class SpreadBuilder {
    private final ArrayList<Object> list;

    public int size() {
        return this.list.size();
    }

    public SpreadBuilder(int r100) {
        this.list = new ArrayList(r100);
    }

    public void add(Object r100) {
        this.list.add(r100);
    }

    public void addSpread(Object r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Object[]) == false) goto L10;
        Object[] r101 = (Object[]) r100;
        if (r101.length <= 0) goto L24;
        ArrayList<Object> r102 = this.list;
        r102.ensureCapacity(r102.size() + r101.length);
        Collections.addAll(this.list, r101);
        return;
    L24:
        return;
    L10:
        if ((r100 instanceof Collection) == false) goto L13;
        this.list.addAll((Collection) r100);
        return;
    L13:
        if ((r100 instanceof Iterable) == false) goto L19;
        Iterator r103 = ((Iterable) r100).iterator();
    L16:
        if (r103.hasNext() == false) goto L31;
        this.list.add(r103.next());
        goto L16
    L31:
        return;
    L19:
        if ((r100 instanceof Iterator) == false) goto L26;
        Iterator r104 = (Iterator) r100;
    L22:
        if (r104.hasNext() == false) goto L32;
        this.list.add(r104.next());
        goto L22
    L32:
        return;
    L26:
        throw new UnsupportedOperationException("Don't know how to spread " + r100.getClass());
    }

    public Object[] toArray(Object[] r100) {
        return this.list.toArray(r100);
    }
}
