package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes42.dex */
public final class TypeAliasExpansion {
    public static final Companion Companion = null;
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TypeAliasExpansion create(TypeAliasExpansion r100, TypeAliasDescriptor r101, List<? extends TypeProjection> r110) {
            Intrinsics.checkNotNullParameter(r101, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(r110, "arguments");
            List<TypeParameterDescriptor> r102 = r101.getTypeConstructor().getParameters();
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L7;
            r103.add(((TypeParameterDescriptor) r104.next()).getOriginal());
            goto L4
        L7:
            return new TypeAliasExpansion(r100, r101, r110, MapsKt.toMap(CollectionsKt.zip(r103, r110)), null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion r100, TypeAliasDescriptor r101, List r102, Map r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final TypeProjection getReplacement(TypeConstructor r100) {
        Intrinsics.checkNotNullParameter(r100, "constructor");
        ClassifierDescriptor r101 = r100.mo10732getDeclarationDescriptor();
        if ((r101 instanceof TypeParameterDescriptor) == true) goto L7;
        return null;
    L7:
        return this.mapping.get(r101);
    }

    public final boolean isRecursion(TypeAliasDescriptor r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if (Intrinsics.areEqual(this.descriptor, r100) == true) goto L9;
        TypeAliasExpansion r101 = this.parent;
        if (r101 == null) goto L7;
        boolean r102 = r101.isRecursion(r100);
    L8:
        if (r102 == true) goto L9;
        return false;
    L7:
        r102 = false;
    L9:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeAliasExpansion(TypeAliasExpansion r100, TypeAliasDescriptor r101, List<? extends TypeProjection> r102, Map<TypeParameterDescriptor, ? extends TypeProjection> r103) {
        this.parent = r100;
        this.descriptor = r101;
        this.arguments = r102;
        this.mapping = r103;
    }
}
