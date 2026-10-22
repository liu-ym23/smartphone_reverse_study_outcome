package lsc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class r implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j> f510620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<j> f510621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<j> f510622c;

    public r(List<j> r100) {
        this.f510620a = r100;
        this.f510621b = new ArrayList(r100.size());
        this.f510622c = new HashSet(3);
    }

    public final void a(j r100) {
        if (((ArrayList) this.f510621b).contains(r100) == false) goto L5;
        return;
    L5:
        if (((HashSet) this.f510622c).contains(r100) == true) goto L13;
        ((HashSet) this.f510622c).add(r100);
        r100.j(this);
        ((HashSet) this.f510622c).remove(r100);
        if (((ArrayList) this.f510621b).contains(r100) == false) goto L9;
        return;
    L9:
        if (msc.o.class.isAssignableFrom(r100.getClass()) == false) goto L11;
        ListProtector.add(this.f510621b, 0, r100);
        return;
    L11:
        ((ArrayList) this.f510621b).add(r100);
        return;
    L13:
        throw new IllegalStateException("Cyclic dependency chain found: " + this.f510622c);
    }

    public final <P extends j> P c(Class<P> r100) {
        P r101 = (P) b(this.f510621b, r100);
        if (r101 != null) goto L9;
        r101 = (P) b(this.f510620a, r100);
        if (r101 == null) goto L8;
        a(r101);
        goto L9
    L8:
        throw new IllegalStateException("Requested plugin is not added: " + r100.getName() + ", plugins: " + this.f510620a);
    L9:
        return r101;
    }

    public static <P extends j> P b(List<j> r100, Class<P> r101) {
        Iterator<j> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        P r103 = (P) r102.next();
        if (r101.isAssignableFrom(r103.getClass()) == false) goto L4;
        return r103;
    L8:
        return null;
    }
}
