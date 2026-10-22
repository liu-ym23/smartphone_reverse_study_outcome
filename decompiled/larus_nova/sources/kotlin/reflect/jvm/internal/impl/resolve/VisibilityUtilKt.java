package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;

/* JADX INFO: loaded from: classes42.dex */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(Collection<? extends CallableMemberDescriptor> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptors");
        r100.isEmpty();
        Iterator<? extends CallableMemberDescriptor> r101 = r100.iterator();
        CallableMemberDescriptor r102 = null;
    L4:
        if (r101.hasNext() == false) goto L13;
        CallableMemberDescriptor r103 = r101.next();
        if (r102 == null) goto L12;
        Integer r104 = DescriptorVisibilities.compare(r102.getVisibility(), r103.getVisibility());
        if (r104 == null) goto L4;
        if (r104.intValue() >= 0) goto L4;
    L12:
        r102 = r103;
        goto L4
    L13:
        Intrinsics.checkNotNull(r102);
        return r102;
    }
}
