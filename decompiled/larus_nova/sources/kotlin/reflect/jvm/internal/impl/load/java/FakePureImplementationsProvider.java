package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* JADX INFO: loaded from: classes42.dex */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE = null;
    private static final Map<ClassId, ClassId> pureImplementationsClassIds = null;
    private static final Map<FqName, FqName> pureImplementationsFqNames = null;

    private FakePureImplementationsProvider() {
    }

    static {
        FakePureImplementationsProvider r100 = new FakePureImplementationsProvider();
        INSTANCE = r100;
        LinkedHashMap r101 = new LinkedHashMap();
        pureImplementationsClassIds = r101;
        StandardClassIds r102 = StandardClassIds.INSTANCE;
        r100.implementedWith(r102.getMutableList(), r100.fqNameListOf(new String[]{"java.util.ArrayList", "java.util.LinkedList"}));
        r100.implementedWith(r102.getMutableSet(), r100.fqNameListOf(new String[]{"java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"}));
        r100.implementedWith(r102.getMutableMap(), r100.fqNameListOf(new String[]{"java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"}));
        ClassId.Companion r103 = ClassId.Companion;
        r100.implementedWith(r103.topLevel(new FqName("java.util.function.Function")), r100.fqNameListOf(new String[]{"java.util.function.UnaryOperator"}));
        r100.implementedWith(r103.topLevel(new FqName("java.util.function.BiFunction")), r100.fqNameListOf(new String[]{"java.util.function.BinaryOperator"}));
        ArrayList r104 = new ArrayList(r101.size());
        Iterator r105 = r101.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        ClassId r107 = (ClassId) r106.getKey();
        ClassId r108 = (ClassId) r106.getValue();
        r104.add(TuplesKt.to(r107.asSingleFqName(), r108.asSingleFqName()));
        goto L4
    L6:
        pureImplementationsFqNames = MapsKt.toMap(r104);
    }

    private final List<ClassId> fqNameListOf(String... r100) {
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        String r104 = r100[r103];
        r101.add(ClassId.Companion.topLevel(new FqName(r104)));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public final FqName getPurelyImplementedInterface(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "classFqName");
        return pureImplementationsFqNames.get(r100);
    }

    private final void implementedWith(ClassId r100, List<ClassId> r101) {
        Map<ClassId, ClassId> r102 = pureImplementationsClassIds;
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Object r104 = r103.next();
        ClassId r105 = (ClassId) r104;
        r102.put((ClassId) r104, r100);
        goto L4
    }
}
