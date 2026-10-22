package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class UtilsKt {
    public static final void record(LookupTracker r100, LookupLocation r101, ClassDescriptor r102, Name r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "scopeOwner");
        Intrinsics.checkNotNullParameter(r110, "name");
        if (r100 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r103 = r101.getLocation();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r100.getRequiresPosition() == false) goto L11;
        Position r104 = r103.getPosition();
    L12:
        String r105 = r103.getFilePath();
        r100.record(r105, r104, DescriptorUtils.getFqName(r102).asString(), ScopeKind.CLASSIFIER, r110.asString());
        return;
    L11:
        r104 = Position.Companion.getNO_POSITION();
        goto L12
    }

    public static final void recordPackageLookup(LookupTracker r100, LookupLocation r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "packageFqName");
        Intrinsics.checkNotNullParameter(r110, "name");
        if (r100 != LookupTracker.DO_NOTHING.INSTANCE) goto L5;
        return;
    L5:
        LocationInfo r103 = r101.getLocation();
        if (r103 != null) goto L9;
        return;
    L9:
        if (r100.getRequiresPosition() == false) goto L11;
        Position r104 = r103.getPosition();
    L12:
        String r105 = r103.getFilePath();
        r100.record(r105, r104, r102, ScopeKind.PACKAGE, r110);
        return;
    L11:
        r104 = Position.Companion.getNO_POSITION();
        goto L12
    }

    public static final void record(LookupTracker r100, LookupLocation r101, PackageFragmentDescriptor r102, Name r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "scopeOwner");
        Intrinsics.checkNotNullParameter(r103, "name");
        recordPackageLookup(r100, r101, r102.getFqName().asString(), r103.asString());
    }
}
