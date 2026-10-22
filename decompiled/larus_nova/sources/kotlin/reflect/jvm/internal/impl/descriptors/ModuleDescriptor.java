package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public interface ModuleDescriptor extends DeclarationDescriptor {

    public static final class DefaultImpls {
        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor r100) {
            return null;
        }

        public static <R, D> R accept(ModuleDescriptor r100, DeclarationDescriptorVisitor<R, D> r101, D r102) {
            Intrinsics.checkNotNullParameter(r101, "visitor");
            return r101.visitModuleDeclaration(r100, r102);
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> r100);

    List<ModuleDescriptor> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName r100);

    Collection<FqName> getSubPackagesOf(FqName r100, Function1<? super Name, Boolean> r101);

    boolean shouldSeeInternalsOf(ModuleDescriptor r100);
}
