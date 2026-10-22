package ena;

import com.obric.oui.window.bean.WindowSizeClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WindowSizeClass f473236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f473237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ana.a f473238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Integer> f473239d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList<dna.a> f473240e = null;

    static {
        f473236a = WindowSizeClass.MINUS_ERROR_SIZE;
        f473237b = 1;
        f473238c = new ana.a(0.0f, 0.0f);
        f473239d = new LinkedHashSet();
        f473240e = new ArrayList();
    }

    public static boolean a(Set r100, int r101, Pair r102) {
        if (r100.contains(Integer.valueOf(r101)) == true) goto L24;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(Integer.valueOf((((Number) r104.next()).intValue() - ((Number) r102.getSecond()).intValue()) - ((Number) r102.getFirst()).intValue()));
        goto L6
    L9:
        if (r103.contains(Integer.valueOf(r101)) == true) goto L24;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r106 = r100.iterator();
    L12:
        if (r106.hasNext() == false) goto L15;
        r105.add(Integer.valueOf(((Number) r106.next()).intValue() - ((Number) r102.getSecond()).intValue()));
        goto L12
    L15:
        if (r105.contains(Integer.valueOf(r101)) == true) goto L24;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r108 = r100.iterator();
    L18:
        if (r108.hasNext() == false) goto L21;
        r107.add(Integer.valueOf(((Number) r108.next()).intValue() - ((Number) r102.getFirst()).intValue()));
        goto L18
    L21:
        if (r107.contains(Integer.valueOf(r101)) == true) goto L24;
        return false;
    L24:
        return true;
    }
}
