package gtc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public abstract class j {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Integer> f482729a;

        public a() {
            this.f482729a = new HashSet(3);
        }
    }

    public static void a(StringBuilder r100, a r101, g.a r102) {
        r100.append("Grammar{id=0x");
        r100.append(Integer.toHexString(System.identityHashCode(r102)));
        r100.append(",name=\"");
        r100.append(r102.name());
        r100.append(Typography.quote);
        Set<Integer> r103 = r101.f482729a;
        HashSet r104 = (HashSet) r103;
        if (r104.contains(Integer.valueOf(System.identityHashCode(r102))) == false) goto L5;
        r100.append(",[...]");
    L14:
        r100.append('}');
        return;
    L5:
        Set<Integer> r105 = r101.f482729a;
        HashSet r106 = (HashSet) r105;
        r106.add(Integer.valueOf(System.identityHashCode(r102)));
        r100.append(",tokens=[");
        Iterator<g.f> r107 = r102.a().iterator();
        boolean r108 = true;
    L7:
        if (r107.hasNext() == false) goto L13;
        g.f r109 = r107.next();
        if (r108 == false) goto L11;
        r108 = false;
    L12:
        c(r100, r101, r109);
        goto L7
    L11:
        r100.append(',');
        goto L12
    L13:
        r100.append(']');
        goto L14
    }

    public static void b(StringBuilder r100, a r101, g.c r102) {
        r100.append("Pattern{id=0x");
        r100.append(Integer.toHexString(System.identityHashCode(r102)));
        Set<Integer> r103 = r101.f482729a;
        HashSet r104 = (HashSet) r103;
        if (r104.contains(Integer.valueOf(System.identityHashCode(r102))) == false) goto L5;
        r100.append(",[...]");
    L17:
        r100.append('}');
        return;
    L5:
        Set<Integer> r105 = r101.f482729a;
        HashSet r106 = (HashSet) r105;
        r106.add(Integer.valueOf(System.identityHashCode(r102)));
        r100.append(",regex=\"");
        r100.append(r102.b());
        r100.append(Typography.quote);
        if (r102.c() == false) goto L9;
        r100.append(",lookbehind=true");
    L9:
        if (r102.a() == false) goto L12;
        r100.append(",greedy=true");
    L12:
        if (r102.alias() == null) goto L14;
        r100.append(",alias=\"");
        r100.append(r102.alias());
        r100.append(Typography.quote);
    L14:
        g.a r107 = r102.d();
        if (r107 == null) goto L17;
        r100.append(",inside=");
        a(r100, r101, r107);
        goto L17
    }

    public static void c(StringBuilder r100, a r101, g.f r102) {
        r100.append("Token{id=0x");
        r100.append(Integer.toHexString(System.identityHashCode(r102)));
        r100.append(",name=\"");
        r100.append(r102.name());
        r100.append(Typography.quote);
        Set<Integer> r103 = r101.f482729a;
        HashSet r104 = (HashSet) r103;
        if (r104.contains(Integer.valueOf(System.identityHashCode(r102))) == false) goto L5;
        r100.append(",[...]");
    L14:
        r100.append('}');
        return;
    L5:
        Set<Integer> r105 = r101.f482729a;
        HashSet r106 = (HashSet) r105;
        r106.add(Integer.valueOf(System.identityHashCode(r102)));
        r100.append(",patterns=[");
        Iterator<g.c> r107 = r102.a().iterator();
        boolean r108 = true;
    L7:
        if (r107.hasNext() == false) goto L13;
        g.c r109 = r107.next();
        if (r108 == false) goto L11;
        r108 = false;
    L12:
        b(r100, r101, r109);
        goto L7
    L11:
        r100.append(',');
        goto L12
    L13:
        r100.append(']');
        goto L14
    }
}
