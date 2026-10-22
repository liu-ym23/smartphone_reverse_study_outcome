package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ModuleAwareClassDescriptor implements ClassDescriptor {
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(ClassDescriptor r100, KotlinTypeRefiner r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "kotlinTypeRefiner");
            if ((r100 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r102 = (ModuleAwareClassDescriptor) r100;
        L6:
            if (r102 == null) goto L10;
            MemberScope r103 = r102.getUnsubstitutedMemberScope(r101);
            if (r103 == null) goto L10;
            return r103;
        L10:
            return r100.getUnsubstitutedMemberScope();
        L5:
            r102 = null;
            goto L6
        }

        public final MemberScope getRefinedMemberScopeIfPossible$descriptors(ClassDescriptor r100, TypeSubstitution r101, KotlinTypeRefiner r102) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "typeSubstitution");
            Intrinsics.checkNotNullParameter(r102, "kotlinTypeRefiner");
            if ((r100 instanceof ModuleAwareClassDescriptor) == false) goto L5;
            ModuleAwareClassDescriptor r103 = (ModuleAwareClassDescriptor) r100;
        L6:
            if (r103 == null) goto L10;
            MemberScope r104 = r103.getMemberScope(r101, r102);
            if (r104 == null) goto L10;
            return r104;
        L10:
            return r100.getMemberScope(r101);
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ModuleAwareClassDescriptor() {
    }

    public abstract MemberScope getMemberScope(TypeSubstitution r100, KotlinTypeRefiner r101);

    public abstract MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r100);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }
}
