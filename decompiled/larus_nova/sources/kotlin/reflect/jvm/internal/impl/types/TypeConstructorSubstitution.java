package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            return createByConstructorsMap$default(this, r100, false, 2, null);
        }

        @JvmStatic
        public final TypeSubstitution create(KotlinType r100) {
            Intrinsics.checkNotNullParameter(r100, "kotlinType");
            return create(r100.getConstructor(), r100.getArguments());
        }

        @JvmStatic
        public final TypeSubstitution create(TypeConstructor r100, List<? extends TypeProjection> r101) {
            Intrinsics.checkNotNullParameter(r100, "typeConstructor");
            Intrinsics.checkNotNullParameter(r101, "arguments");
            List<TypeParameterDescriptor> r102 = r100.getParameters();
            TypeParameterDescriptor r103 = (TypeParameterDescriptor) CollectionsKt.lastOrNull(r102);
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.isCapturedFromOuterDeclaration() != true) goto L7;
        L8:
            if (r104 == false) goto L16;
            List<TypeParameterDescriptor> r105 = r100.getParameters();
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L11:
            if (r107.hasNext() == false) goto L14;
            r106.add(((TypeParameterDescriptor) r107.next()).getTypeConstructor());
            goto L11
        L14:
            return createByConstructorsMap$default(this, MapsKt.toMap(CollectionsKt.zip(r106, r101)), false, 2, null);
        L16:
            return new IndexedParametersSubstitution(r102, r101);
        L7:
            r104 = false;
            goto L8
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(final Map<TypeConstructor, ? extends TypeProjection> r100, final boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(r100, r101);
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion r100, Map r101, boolean r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            return r100.createByConstructorsMap(r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final TypeSubstitution create(TypeConstructor r100, List<? extends TypeProjection> r101) {
        return Companion.create(r100, r101);
    }

    @JvmStatic
    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> r100) {
        return Companion.createByConstructorsMap(r100);
    }

    public abstract TypeProjection get(TypeConstructor r100);

    public TypeConstructorSubstitution() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    /* JADX INFO: renamed from: get */
    public TypeProjection mo10737get(KotlinType r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return get(r100.getConstructor());
    }
}
