package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* JADX INFO: loaded from: classes42.dex */
public final class DescriptorResolverUtils {
    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 18) goto L5;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r100 == 18) goto L9;
        int r102 = 3;
    L10:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L12;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L12;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L13;
            default: goto L12;
        };
    L12:
        r103[0] = "name";
    L21:
        if (r100 == 18) goto L23;
        r103[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
    L24:
        switch(r100) {
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L29;
            case 19: goto L26;
            case 20: goto L26;
            default: goto L25;
        };
    L25:
        r103[2] = "resolveOverridesForNonStaticMembers";
        goto L29
    L26:
        r103[2] = "getAnnotationParameterByName";
        goto L29
    L27:
        r103[2] = "resolveOverrides";
        goto L29
    L28:
        r103[2] = "resolveOverridesForStaticMembers";
    L29:
        String r104 = String.format(r101, r103);
        if (r100 == 18) goto L33;
        throw new IllegalArgumentException(r104);
    L33:
        throw new IllegalStateException(r104);
    L23:
        r103[1] = "resolveOverrides";
        goto L24
    L13:
        r103[0] = "annotationClass";
        goto L21
    L14:
        r103[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        goto L21
    L15:
        r103[0] = "overridingUtil";
        goto L21
    L16:
        r103[0] = "errorReporter";
        goto L21
    L17:
        r103[0] = "classDescriptor";
        goto L21
    L18:
        r103[0] = "membersFromCurrent";
        goto L21
    L19:
        r103[0] = "membersFromSupertypes";
        goto L21
    L9:
        r102 = 2;
        goto L10
    L5:
        r101 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static ValueParameterDescriptor getAnnotationParameterByName(Name r100, ClassDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(19);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(20);
    L6:
        Collection<ClassConstructorDescriptor> r102 = r101.getConstructors();
        if (r102.size() == 1) goto L9;
        return null;
    L9:
        Iterator<ValueParameterDescriptor> r103 = r102.iterator().next().getValueParameters().iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        ValueParameterDescriptor r104 = r103.next();
        if (r104.getName().equals(r100) == false) goto L11;
        return r104;
    L15:
        return null;
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(Name r100, Collection<D> r101, Collection<D> r110, ClassDescriptor r111, ErrorReporter r112, OverridingUtil r113) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r110 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r111 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r112 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r113 != null) goto L15;
        $$$reportNull$$$0(5);
    L15:
        return resolveOverrides(r100, r101, r110, r111, r112, r113, false);
    }

    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(Name r100, Collection<D> r101, Collection<D> r110, ClassDescriptor r111, ErrorReporter r112, OverridingUtil r113) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r110 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r111 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        if (r112 != null) goto L12;
        $$$reportNull$$$0(10);
    L12:
        if (r113 != null) goto L15;
        $$$reportNull$$$0(11);
    L15:
        return resolveOverrides(r100, r101, r110, r111, r112, r113, true);
    }

    private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(Name r100, Collection<D> r101, Collection<D> r102, ClassDescriptor r110, final ErrorReporter r111, OverridingUtil r112, final boolean r113) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r110 != null) goto L10;
        $$$reportNull$$$0(15);
    L10:
        if (r111 != null) goto L12;
        $$$reportNull$$$0(16);
    L12:
        if (r112 != null) goto L14;
        $$$reportNull$$$0(17);
    L14:
        final LinkedHashSet r103 = new LinkedHashSet();
        r112.generateOverridesInFunctionGroup(r100, r101, r102, r110, new AnonymousClass1(r111, r103, r113));
        return r103;
    }
}
