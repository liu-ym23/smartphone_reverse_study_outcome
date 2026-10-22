package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Quirks {
    private final List<Quirk> mQuirks;

    public Quirks(List<Quirk> r2) {
        this.mQuirks = new ArrayList(r2);
    }

    public static String toString(Quirks r2) {
        ArrayList r0 = new ArrayList();
        Iterator<Quirk> r3 = r2.mQuirks.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(r3.next().getClass().getSimpleName());
        goto L4
    L6:
        StringBuilder r4 = new StringBuilder();
        Iterator r1 = r0.iterator();
        if (r1.hasNext() == false) goto L12;
    L8:
        r4.append((CharSequence) r1.next());
        if (r1.hasNext() == false) goto L12;
        r4.append(" | ");
    L12:
        return r4.toString();
    }

    public void addQuirkForTesting(Quirk r2) {
        this.mQuirks.add(r2);
    }

    public boolean contains(Class<? extends Quirk> r3) {
        Iterator<Quirk> r0 = this.mQuirks.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r3.isAssignableFrom(r0.next().getClass()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public <T extends Quirk> T get(Class<T> r4) {
        Iterator<Quirk> r0 = this.mQuirks.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        T r1 = (T) r0.next();
        if (r1.getClass() != r4) goto L4;
        return r1;
    L8:
        return null;
    }

    public <T extends Quirk> List<T> getAll(Class<T> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<Quirk> r1 = this.mQuirks.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Quirk r2 = r1.next();
        if (r5.isAssignableFrom(r2.getClass()) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }
}
