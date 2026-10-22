package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.util.ArrayMap;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> {
    public static final Companion Companion = null;
    private static final TypeAttributes Empty = null;

    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.access$getEmpty$cp();
        }

        private Companion() {
        }

        public static final /* synthetic */ Collection access$getIndices(Companion r100) {
            return r100.getIndices();
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "attributes");
            if (r100.isEmpty() == false) goto L6;
            return getEmpty();
        L6:
            return new TypeAttributes(r100, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.TypeRegistry
        public int customComputeIfAbsent(ConcurrentHashMap<String, Integer> r100, String r101, Function1<? super String, Integer> r102) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "key");
            Intrinsics.checkNotNullParameter(r102, "compute");
            Integer r103 = r100.get(r101);
            if (r103 != null) goto L17;
            monitor-enter(r100);
            Integer r104 = r100.get(r101);     // Catch: Throwable -> L13
            if (r104 == null) goto L9;
            int r105 = r104.intValue();     // Catch: Throwable -> L13
        L10:
            monitor-exit(r100);
            return r105;
        L9:
            Integer r106 = r102.invoke(r101);     // Catch: Throwable -> L13
            r100.putIfAbsent(r101, Integer.valueOf(r106.intValue()));     // Catch: Throwable -> L13
            r105 = r106.intValue();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        L17:
            return r103.intValue();
        }
    }

    public /* synthetic */ TypeAttributes(List r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    static {
        Companion = new Companion(null);
        Empty = new TypeAttributes(CollectionsKt.emptyList());
    }

    public static final /* synthetic */ TypeAttributes access$getEmpty$cp() {
        return Empty;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    public TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> r100) {
        Iterator<? extends TypeAttribute<?>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        TypeAttribute<?> r102 = r101.next();
        registerComponent(r102.getKey(), r102);
        goto L4
    }

    public final TypeAttributes add(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r101 = new ArrayList();
        Iterator r102 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        int r103 = ((Number) r102.next()).intValue();
        TypeAttribute<?> r104 = getArrayMap().get(r103);
        TypeAttribute<?> r105 = r100.getArrayMap().get(r103);
        if (r104 != null) goto L15;
        if (r105 == null) goto L14;
        TypeAttribute r106 = r105.add(r104);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r101, r106);
        goto L9
    L14:
        r106 = null;
        goto L16
    L15:
        r106 = r104.add(r105);
        goto L16
    L18:
        return Companion.create(r101);
    L5:
        if (r100.isEmpty() == false) goto L7;
        return this;
    }

    public final boolean contains(TypeAttribute<?> r100) {
        Intrinsics.checkNotNullParameter(r100, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        int r101 = Companion.getId(r100.getKey());
        if (getArrayMap().get(r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final TypeAttributes intersect(TypeAttributes r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (isEmpty() == true) goto L5;
    L7:
        ArrayList r101 = new ArrayList();
        Iterator r102 = Companion.access$getIndices(Companion).iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        int r103 = ((Number) r102.next()).intValue();
        TypeAttribute<?> r104 = getArrayMap().get(r103);
        TypeAttribute<?> r105 = r100.getArrayMap().get(r103);
        if (r104 != null) goto L15;
        if (r105 == null) goto L14;
        TypeAttribute r106 = r105.intersect(r104);
    L16:
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(r101, r106);
        goto L9
    L14:
        r106 = null;
        goto L16
    L15:
        r106 = r104.intersect(r105);
        goto L16
    L18:
        return Companion.create(r101);
    L5:
        if (r100.isEmpty() == false) goto L7;
        return this;
    }

    public final TypeAttributes plus(TypeAttribute<?> r100) {
        Intrinsics.checkNotNullParameter(r100, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        if (contains(r100) == false) goto L6;
        return this;
    L6:
        if (isEmpty() == true) goto L8;
        List<? extends TypeAttribute<?>> r101 = CollectionsKt.plus(CollectionsKt.toList(this), r100);
        return Companion.create(r101);
    L8:
        return new TypeAttributes(r100);
    }

    public final TypeAttributes remove(TypeAttribute<?> r100) {
        Intrinsics.checkNotNullParameter(r100, ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE);
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        ArrayMap<TypeAttribute<?>> r101 = getArrayMap();
        ArrayList r102 = new ArrayList();
        Iterator<TypeAttribute<?>> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        TypeAttribute<?> r104 = r103.next();
        if ((!Intrinsics.areEqual(r104, r100)) == false) goto L7;
        r102.add(r104);
        goto L7
    L12:
        if (r102.size() != getArrayMap().getSize()) goto L15;
        return this;
    L15:
        return Companion.create(r102);
    }

    private TypeAttributes(TypeAttribute<?> r100) {
        this(CollectionsKt.listOf(r100));
    }
}
