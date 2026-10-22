package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public interface ResolutionScope {

    public static final class DefaultImpls {
        public static void recordLookup(ResolutionScope r100, Name r101, LookupLocation r102) {
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "location");
            r100.getContributedFunctions(r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope r100, DescriptorKindFilter r101, Function1 r102, int r103, Object r104) {
            if (r104 != null) goto L12;
            if ((r103 & 1) == 0) goto L7;
            r101 = DescriptorKindFilter.ALL;
        L7:
            if ((r103 & 2) == 0) goto L10;
            r102 = MemberScope.Companion.getALL_NAME_FILTER();
        L10:
            return r100.getContributedDescriptors(r101, r102);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }
    }

    /* JADX INFO: renamed from: getContributedClassifier */
    ClassifierDescriptor mo10734getContributedClassifier(Name r100, LookupLocation r101);

    Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter r100, Function1<? super Name, Boolean> r101);

    Collection<? extends FunctionDescriptor> getContributedFunctions(Name r100, LookupLocation r101);

    /* JADX INFO: renamed from: recordLookup */
    void mo10738recordLookup(Name r100, LookupLocation r101);
}
