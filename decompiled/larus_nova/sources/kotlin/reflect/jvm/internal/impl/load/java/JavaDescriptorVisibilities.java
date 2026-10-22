package kotlin.reflect.jvm.internal.impl.load.java;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* JADX INFO: loaded from: classes42.dex */
public class JavaDescriptorVisibilities {
    public static final DescriptorVisibility PACKAGE_VISIBILITY = null;
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE = null;
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY = null;
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 5) goto L6;
        if (r100 == 6) goto L6;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r100 == 5) goto L11;
        if (r100 == 6) goto L11;
        int r102 = 3;
    L12:
        Object[] r103 = new Object[r102];
        switch(r100) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r103[0] = "what";
    L21:
        if (r100 == 5) goto L24;
        if (r100 == 6) goto L24;
        r103[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
    L25:
        if (r100 == 2) goto L33;
        if (r100 == 3) goto L33;
        if (r100 == 4) goto L32;
        if (r100 == 5) goto L34;
        if (r100 == 6) goto L34;
        r103[2] = "isVisibleForProtectedAndPackage";
    L34:
        String r104 = String.format(r101, r103);
        if (r100 == 5) goto L39;
        if (r100 == 6) goto L39;
        throw new IllegalArgumentException(r104);
    L39:
        throw new IllegalStateException(r104);
    L32:
        r103[2] = "toDescriptorVisibility";
    L33:
        r103[2] = "areInSamePackage";
    L24:
        r103[1] = "toDescriptorVisibility";
        goto L25
    L15:
        r103[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        goto L21
    L16:
        r103[0] = RemoteMessageConst.Notification.VISIBILITY;
        goto L21
    L17:
        r103[0] = "second";
        goto L21
    L18:
        r103[0] = SoloKtvContext.SOLO_PAGE_FIRST;
        goto L21
    L19:
        r103[0] = "from";
    L11:
        r102 = 2;
    L6:
        r101 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static {
        final JavaVisibilities.PackageVisibility r100 = JavaVisibilities.PackageVisibility.INSTANCE;
        DelegatedDescriptorVisibility r101 = new AnonymousClass1(r100);
        PACKAGE_VISIBILITY = r101;
        final JavaVisibilities.ProtectedStaticVisibility r102 = JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        DelegatedDescriptorVisibility r103 = new AnonymousClass2(r102);
        PROTECTED_STATIC_VISIBILITY = r103;
        final JavaVisibilities.ProtectedAndPackage r104 = JavaVisibilities.ProtectedAndPackage.INSTANCE;
        DelegatedDescriptorVisibility r105 = new AnonymousClass3(r104);
        PROTECTED_AND_PACKAGE = r105;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r101);
        recordVisibilityMapping(r103);
        recordVisibilityMapping(r105);
    }

    private static void recordVisibilityMapping(DescriptorVisibility r100) {
        visibilitiesMapping.put(r100.getDelegate(), r100);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        DescriptorVisibility r101 = visibilitiesMapping.get(r100);
        if (r101 != null) goto L10;
        DescriptorVisibility r102 = DescriptorVisibilities.toDescriptorVisibility(r100);
        if (r102 != null) goto L9;
        $$$reportNull$$$0(5);
    L9:
        return r102;
    L10:
        return r101;
    }

    public static /* synthetic */ boolean access$000(DeclarationDescriptor r100, DeclarationDescriptor r101) {
        return areInSamePackage(r100, r101);
    }

    private static boolean areInSamePackage(DeclarationDescriptor r100, DeclarationDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(3);
    L6:
        PackageFragmentDescriptor r102 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r100, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor r103 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(r101, PackageFragmentDescriptor.class, false);
        if (r103 == null) goto L13;
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.getFqName().equals(r103.getFqName()) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public static /* synthetic */ boolean access$100(ReceiverValue r100, DeclarationDescriptorWithVisibility r101, DeclarationDescriptor r102) {
        return isVisibleForProtectedAndPackage(r100, r101, r102);
    }

    private static boolean isVisibleForProtectedAndPackage(ReceiverValue r100, DeclarationDescriptorWithVisibility r101, DeclarationDescriptor r102) {
        if (r101 != null) goto L6;
        $$$reportNull$$$0(0);
    L6:
        if (r102 != null) goto L9;
        $$$reportNull$$$0(1);
    L9:
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(r101), r102) == false) goto L12;
        return true;
    L12:
        return DescriptorVisibilities.PROTECTED.isVisible(r100, r101, r102, false);
    }
}
