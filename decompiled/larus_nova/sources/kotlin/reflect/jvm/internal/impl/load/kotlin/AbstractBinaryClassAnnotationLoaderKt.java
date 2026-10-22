package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;

/* JADX INFO: loaded from: classes42.dex */
public final class AbstractBinaryClassAnnotationLoaderKt {
    public static final MemberSignature getPropertySignature(ProtoBuf.Property r100, NameResolver r101, TypeTable r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        Intrinsics.checkNotNullParameter(r102, "typeTable");
        JvmProtoBuf.JvmPropertySignature r106 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r100, JvmProtoBuf.propertySignature);
        if (r106 != null) goto L5;
        return null;
    L5:
        if (r103 == false) goto L11;
        JvmMemberSignature.Field r107 = JvmProtoBufUtil.INSTANCE.getJvmFieldSignature(r100, r101, r102, r105);
        if (r107 != null) goto L10;
        return null;
    L10:
        return MemberSignature.Companion.fromJvmMemberSignature(r107);
    L11:
        if (r104 == true) goto L13;
    L16:
        return null;
    L13:
        if (r106.hasSyntheticMethod() == false) goto L16;
        return MemberSignature.Companion.fromMethod(r101, r106.getSyntheticMethod());
    }

    public static /* synthetic */ MemberSignature getPropertySignature$default(ProtoBuf.Property r100, NameResolver r101, TypeTable r102, boolean r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 8) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r113 & 16) == 0) goto L9;
        boolean r104 = false;
    L11:
        if ((r113 & 32) == 0) goto L13;
        boolean r105 = true;
    L15:
        return getPropertySignature(r100, r101, r102, r103, r104, r105);
    L13:
        r105 = r112;
        goto L15
    L9:
        r104 = r111;
        goto L11
    L5:
        r103 = r110;
        goto L7
    }
}
