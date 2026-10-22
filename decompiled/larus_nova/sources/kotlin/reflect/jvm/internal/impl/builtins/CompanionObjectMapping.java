package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public final class CompanionObjectMapping {
    public static final CompanionObjectMapping INSTANCE = null;
    private static final Set<ClassId> classIds = null;

    private CompanionObjectMapping() {
    }

    static {
        INSTANCE = new CompanionObjectMapping();
        Set<PrimitiveType> r100 = PrimitiveType.NUMBER_TYPES;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(StandardNames.getPrimitiveFqName((PrimitiveType) r102.next()));
        goto L4
    L6:
        List r103 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(r101, StandardNames.FqNames.string.toSafe()), StandardNames.FqNames._boolean.toSafe()), StandardNames.FqNames._enum.toSafe());
        LinkedHashSet r104 = new LinkedHashSet();
        ClassId.Companion r105 = ClassId.Companion;
        Iterator r106 = r103.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r104.add(r105.topLevel((FqName) r106.next()));
        goto L8
    L10:
        classIds = r104;
    }

    public final Set<ClassId> allClassesWithIntrinsicCompanions() {
        return classIds;
    }

    public final Set<ClassId> getClassIds() {
        return classIds;
    }
}
