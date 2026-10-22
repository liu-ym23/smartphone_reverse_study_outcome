package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public interface MemberScope extends ResolutionScope {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Function1<Name, Boolean> ALL_NAME_FILTER = null;

        private Companion() {
        }

        private static final boolean ALL_NAME_FILTER$lambda$0(Name r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return true;
        }

        public static /* synthetic */ boolean accessor$MemberScope$Companion$lambda0(Name r100) {
            return ALL_NAME_FILTER$lambda$0(r100);
        }

        static {
            $$INSTANCE = new Companion();
            ALL_NAME_FILTER = MemberScope$Companion$$Lambda$0.INSTANCE;
        }

        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class DefaultImpls {
        public static void recordLookup(MemberScope r100, Name r101, LookupLocation r102) {
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "location");
            ResolutionScope.DefaultImpls.recordLookup(r100, r101, r102);
        }
    }

    public static final class Empty extends MemberScopeImpl {
        public static final Empty INSTANCE = null;

        static {
            INSTANCE = new Empty();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getClassifierNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            return SetsKt.emptySet();
        }

        private Empty() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Set<Name> getClassifierNames();

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name r100, LookupLocation r101);

    Collection<? extends PropertyDescriptor> getContributedVariables(Name r100, LookupLocation r101);

    Set<Name> getFunctionNames();

    Set<Name> getVariableNames();
}
