package kotlin.reflect.jvm.internal.impl.descriptors;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = null;
    public static final DescriptorVisibility DEFAULT_VISIBILITY = null;
    public static final ReceiverValue FALSE_IF_PROTECTED = null;
    public static final DescriptorVisibility INHERITED = null;
    public static final DescriptorVisibility INTERNAL = null;
    public static final DescriptorVisibility INVISIBLE_FAKE = null;
    public static final Set<DescriptorVisibility> INVISIBLE_FROM_OTHER_MODULES = null;
    private static final ReceiverValue IRRELEVANT_RECEIVER = null;
    public static final DescriptorVisibility LOCAL = null;
    private static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER = null;
    private static final Map<DescriptorVisibility, Integer> ORDERED_VISIBILITIES = null;
    public static final DescriptorVisibility PRIVATE = null;
    public static final DescriptorVisibility PRIVATE_TO_THIS = null;
    public static final DescriptorVisibility PROTECTED = null;
    public static final DescriptorVisibility PUBLIC = null;
    public static final DescriptorVisibility UNKNOWN = null;
    private static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = null;

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        if (r100 == 16) goto L5;
        String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r100 == 16) goto L9;
        int r102 = 3;
    L10:
        Object[] r103 = new Object[r102];
        if (r100 == 1) goto L23;
        if (r100 == 3) goto L23;
        if (r100 == 5) goto L23;
        if (r100 == 7) goto L23;
        switch(r100) {
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L20;
            case 16: goto L19;
            default: goto L18;
        };
    L18:
        r103[0] = "what";
    L25:
        if (r100 == 16) goto L27;
        r103[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
    L28:
        switch(r100) {
            case 2: goto L37;
            case 3: goto L37;
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L38;
            default: goto L29;
        };
    L29:
        r103[2] = "isVisible";
        goto L38
    L30:
        r103[2] = "toDescriptorVisibility";
        goto L38
    L31:
        r103[2] = "isPrivate";
        goto L38
    L32:
        r103[2] = "compare";
        goto L38
    L33:
        r103[2] = "compareLocal";
        goto L38
    L34:
        r103[2] = "findInvisibleMember";
        goto L38
    L35:
        r103[2] = "inSameFile";
        goto L38
    L36:
        r103[2] = "isVisibleWithAnyReceiver";
        goto L38
    L37:
        r103[2] = "isVisibleIgnoringReceiver";
    L38:
        String r104 = String.format(r101, r103);
        if (r100 == 16) goto L42;
        throw new IllegalArgumentException(r104);
    L42:
        throw new IllegalStateException(r104);
    L27:
        r103[1] = "toDescriptorVisibility";
        goto L28
    L19:
        r103[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        goto L25
    L20:
        r103[0] = RemoteMessageConst.Notification.VISIBILITY;
        goto L25
    L21:
        r103[0] = "second";
        goto L25
    L22:
        r103[0] = SoloKtvContext.SOLO_PAGE_FIRST;
    L23:
        r103[0] = "from";
        goto L25
    L9:
        r102 = 2;
        goto L10
    L5:
        r101 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    static {
        final Visibilities.Private r100 = Visibilities.Private.INSTANCE;
        DelegatedDescriptorVisibility r101 = new AnonymousClass1(r100);
        PRIVATE = r101;
        final Visibilities.PrivateToThis r102 = Visibilities.PrivateToThis.INSTANCE;
        DelegatedDescriptorVisibility r103 = new AnonymousClass2(r102);
        PRIVATE_TO_THIS = r103;
        final Visibilities.Protected r104 = Visibilities.Protected.INSTANCE;
        DelegatedDescriptorVisibility r105 = new AnonymousClass3(r104);
        PROTECTED = r105;
        final Visibilities.Internal r106 = Visibilities.Internal.INSTANCE;
        DelegatedDescriptorVisibility r107 = new AnonymousClass4(r106);
        INTERNAL = r107;
        final Visibilities.Public r108 = Visibilities.Public.INSTANCE;
        DelegatedDescriptorVisibility r109 = new AnonymousClass5(r108);
        PUBLIC = r109;
        final Visibilities.Local r110 = Visibilities.Local.INSTANCE;
        DelegatedDescriptorVisibility r111 = new AnonymousClass6(r110);
        LOCAL = r111;
        final Visibilities.Inherited r112 = Visibilities.Inherited.INSTANCE;
        DelegatedDescriptorVisibility r113 = new AnonymousClass7(r112);
        INHERITED = r113;
        final Visibilities.InvisibleFake r114 = Visibilities.InvisibleFake.INSTANCE;
        DelegatedDescriptorVisibility r115 = new AnonymousClass8(r114);
        INVISIBLE_FAKE = r115;
        final Visibilities.Unknown r116 = Visibilities.Unknown.INSTANCE;
        DelegatedDescriptorVisibility r117 = new AnonymousClass9(r116);
        UNKNOWN = r117;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf(new DescriptorVisibility[]{r101, r103, r107, r111}));
        HashMap r118 = CollectionsKt.newHashMapWithExpectedSize(4);
        r118.put(r103, 0);
        r118.put(r101, 0);
        r118.put(r107, 1);
        r118.put(r105, 1);
        r118.put(r109, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(r118);
        DEFAULT_VISIBILITY = r109;
        IRRELEVANT_RECEIVER = new AnonymousClass10();
        ALWAYS_SUITABLE_RECEIVER = new AnonymousClass11();
        FALSE_IF_PROTECTED = new AnonymousClass12();
        Iterator r119 = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        if (r119.hasNext() == false) goto L5;
        ModuleVisibilityHelper r120 = (ModuleVisibilityHelper) r119.next();
    L6:
        MODULE_VISIBILITY_HELPER = r120;
        visibilitiesMapping = new HashMap();
        recordVisibilityMapping(r101);
        recordVisibilityMapping(r103);
        recordVisibilityMapping(r105);
        recordVisibilityMapping(r107);
        recordVisibilityMapping(r109);
        recordVisibilityMapping(r111);
        recordVisibilityMapping(r113);
        recordVisibilityMapping(r115);
        recordVisibilityMapping(r117);
        return;
    L5:
        r120 = ModuleVisibilityHelper.EMPTY.INSTANCE;
        goto L6
    }

    public static /* synthetic */ ReceiverValue access$000() {
        return IRRELEVANT_RECEIVER;
    }

    public static /* synthetic */ ModuleVisibilityHelper access$100() {
        return MODULE_VISIBILITY_HELPER;
    }

    public static boolean isPrivate(DescriptorVisibility r100) {
        if (r100 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        if (r100 != PRIVATE) goto L7;
    L10:
        return true;
    L7:
        if (r100 == PRIVATE_TO_THIS) goto L10;
        return false;
    }

    private static void recordVisibilityMapping(DescriptorVisibility r100) {
        visibilitiesMapping.put(r100.getDelegate(), r100);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility r100) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        DescriptorVisibility r101 = visibilitiesMapping.get(r100);
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalArgumentException("Inapplicable visibility: " + r100);
    }

    public static Integer compare(DescriptorVisibility r100, DescriptorVisibility r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        Integer r102 = r100.compareTo(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        Integer r103 = r101.compareTo(r100);
        if (r103 != null) goto L12;
        return null;
    L12:
        return Integer.valueOf(-r103.intValue());
    }

    public static boolean inSameFile(DeclarationDescriptor r100, DeclarationDescriptor r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        SourceFile r102 = DescriptorUtils.getContainingSourceFile(r101);
        if (r102 != SourceFile.NO_SOURCE_FILE) goto L9;
        return false;
    L9:
        return r102.equals(DescriptorUtils.getContainingSourceFile(r100));
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility r100, DeclarationDescriptor r101, boolean r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        if (r101 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        if (findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, r100, r101, r102) != null) goto L9;
        return true;
    L9:
        return false;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue r100, DeclarationDescriptorWithVisibility r101, DeclarationDescriptor r102, boolean r103) {
        if (r101 != null) goto L4;
        $$$reportNull$$$0(8);
    L4:
        if (r102 != null) goto L6;
        $$$reportNull$$$0(9);
    L6:
        DeclarationDescriptorWithVisibility r104 = (DeclarationDescriptorWithVisibility) r101.getOriginal();
    L7:
        if (r104 == null) goto L15;
        if (r104.getVisibility() == LOCAL) goto L15;
        if (r104.getVisibility().isVisible(r100, r104, r102, r103) == false) goto L12;
        r104 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(r104, DeclarationDescriptorWithVisibility.class);
        goto L7
    L12:
        return r104;
    L15:
        if ((r101 instanceof TypeAliasConstructorDescriptor) == false) goto L19;
        DeclarationDescriptorWithVisibility r105 = findInvisibleMember(r100, ((TypeAliasConstructorDescriptor) r101).getUnderlyingConstructorDescriptor(), r102, r103);
        if (r105 == null) goto L24;
        return r105;
    L24:
        return null;
    L19:
        return null;
    }
}
