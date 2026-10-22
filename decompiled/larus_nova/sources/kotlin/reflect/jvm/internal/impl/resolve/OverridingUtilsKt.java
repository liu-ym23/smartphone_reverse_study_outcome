package kotlin.reflect.jvm.internal.impl.resolve;

import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* JADX INFO: loaded from: classes42.dex */
public final class OverridingUtilsKt {
    public static /* synthetic */ Unit accessor$OverridingUtilsKt$lambda1(SmartSet r100, Object r101) {
        return selectMostSpecificInEachOverridableGroup$lambda$2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> r100, Function1<? super H, ? extends CallableDescriptor> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "descriptorByHandle");
        if (r100.size() > 1) goto L5;
        return r100;
    L5:
        LinkedList r102 = new LinkedList(r100);
        SmartSet r103 = SmartSet.Companion.create();
    L7:
        if ((!r102.isEmpty()) == false) goto L23;
        Object r104 = CollectionsKt.first(r102);
        final SmartSet r105 = SmartSet.Companion.create();
        Collection r106 = OverridingUtil.extractMembersOverridableInBothWays(r104, r102, r101, new OverridingUtilsKt$$Lambda$1(r105));
        if (r106.size() != 1) goto L13;
        if (r105.isEmpty() == false) goto L13;
        r103.add(CollectionsKt.single(r106));
    L13:
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r107 = (Object) OverridingUtil.selectMostSpecificMember(r106, r101);
        CallableDescriptor r108 = r101.invoke(r107);
        Iterator r109 = r106.iterator();
    L15:
        if (r109.hasNext() == false) goto L20;
        DeepThinkTopHeaderComponent$runCollapseAnimation$2 r110 = (Object) r109.next();
        Intrinsics.checkNotNull(r110);
        if (OverridingUtil.isMoreSpecific(r108, r101.invoke(r110)) == true) goto L15;
        r105.add(r110);
        goto L15
    L20:
        if ((!r105.isEmpty()) == false) goto L22;
        r103.addAll(r105);
    L22:
        r103.add(r107);
        goto L7
    L23:
        return r103;
    }

    private static final Unit selectMostSpecificInEachOverridableGroup$lambda$2(SmartSet r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$conflictedHandles");
        Intrinsics.checkNotNull(r101);
        r100.add(r101);
        return Unit.INSTANCE;
    }
}
