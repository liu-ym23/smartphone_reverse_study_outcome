package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KotlinTypeRefiner extends AbstractTypeRefiner {

    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor findClassAcrossModuleDependencies(ClassId r100) {
            Intrinsics.checkNotNullParameter(r100, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForModule(ModuleDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public boolean isRefinementNeededForTypeConstructor(TypeConstructor r100) {
            Intrinsics.checkNotNullParameter(r100, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public ClassDescriptor refineDescriptor(DeclarationDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "descriptor");
            return null;
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public /* bridge */ /* synthetic */ ClassifierDescriptor refineDescriptor(DeclarationDescriptor r100) {
            return refineDescriptor(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public Collection<KotlinType> refineSupertypes(ClassDescriptor r100) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            return r100.getTypeConstructor().mo10733getSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public KotlinType refineType(KotlinTypeMarker r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return (KotlinType) r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
        public /* bridge */ /* synthetic */ KotlinTypeMarker refineType(KotlinTypeMarker r100) {
            return refineType(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner
        public <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r100, Function0<? extends S> r101) {
            Intrinsics.checkNotNullParameter(r100, "classDescriptor");
            Intrinsics.checkNotNullParameter(r101, "compute");
            return r101.invoke();
        }
    }

    public abstract ClassDescriptor findClassAcrossModuleDependencies(ClassId r100);

    public abstract <S extends MemberScope> S getOrPutScopeForClass(ClassDescriptor r100, Function0<? extends S> r101);

    public abstract boolean isRefinementNeededForModule(ModuleDescriptor r100);

    public abstract boolean isRefinementNeededForTypeConstructor(TypeConstructor r100);

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor r100);

    public abstract Collection<KotlinType> refineSupertypes(ClassDescriptor r100);

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner
    public abstract KotlinType refineType(KotlinTypeMarker r100);

    public KotlinTypeRefiner() {
    }
}
