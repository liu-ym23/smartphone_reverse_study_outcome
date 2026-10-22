package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoTypeTableUtilKt {
    public static final boolean hasReceiver(ProtoBuf.Function r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final boolean hasReceiver(ProtoBuf.Property r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final ProtoBuf.Type abbreviatedType(ProtoBuf.Type r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasAbbreviatedType() == false) goto L6;
        return r100.getAbbreviatedType();
    L6:
        if (r100.hasAbbreviatedTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getAbbreviatedTypeId());
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Class r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        List<ProtoBuf.Type> r102 = r100.getContextReceiverTypeList();
        if ((!r102.isEmpty()) == true) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L11;
        List<Integer> r103 = r100.getContextReceiverTypeIdList();
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Integer r105 = (Integer) r104.next();
        Intrinsics.checkNotNull(r105);
        r102.add(r101.get(r105.intValue()));
    L11:
        return r102;
    }

    public static final ProtoBuf.Type expandedType(ProtoBuf.TypeAlias r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasExpandedType() == false) goto L6;
        return r100.getExpandedType();
    L6:
        if (r100.hasExpandedTypeId() == false) goto L10;
        return r101.get(r100.getExpandedTypeId());
    L10:
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final ProtoBuf.Type flexibleUpperBound(ProtoBuf.Type r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasFlexibleUpperBound() == false) goto L6;
        return r100.getFlexibleUpperBound();
    L6:
        if (r100.hasFlexibleUpperBoundId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getFlexibleUpperBoundId());
    }

    public static final ProtoBuf.Type inlineClassUnderlyingType(ProtoBuf.Class r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasInlineClassUnderlyingType() == false) goto L6;
        return r100.getInlineClassUnderlyingType();
    L6:
        if (r100.hasInlineClassUnderlyingTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getInlineClassUnderlyingTypeId());
    }

    public static final ProtoBuf.Type outerType(ProtoBuf.Type r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasOuterType() == false) goto L6;
        return r100.getOuterType();
    L6:
        if (r100.hasOuterTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getOuterTypeId());
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Function r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasReceiverType() == false) goto L6;
        return r100.getReceiverType();
    L6:
        if (r100.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getReceiverTypeId());
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Function r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasReturnType() == false) goto L6;
        return r100.getReturnType();
    L6:
        if (r100.hasReturnTypeId() == false) goto L10;
        return r101.get(r100.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final List<ProtoBuf.Type> supertypes(ProtoBuf.Class r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        List<ProtoBuf.Type> r102 = r100.getSupertypeList();
        if ((!r102.isEmpty()) == true) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L11;
        List<Integer> r103 = r100.getSupertypeIdList();
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Integer r105 = (Integer) r104.next();
        Intrinsics.checkNotNull(r105);
        r102.add(r101.get(r105.intValue()));
    L11:
        return r102;
    }

    public static final ProtoBuf.Type type(ProtoBuf.ValueParameter r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasType() == false) goto L6;
        return r100.getType();
    L6:
        if (r100.hasTypeId() == false) goto L10;
        return r101.get(r100.getTypeId());
    L10:
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final ProtoBuf.Type underlyingType(ProtoBuf.TypeAlias r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasUnderlyingType() == false) goto L6;
        return r100.getUnderlyingType();
    L6:
        if (r100.hasUnderlyingTypeId() == false) goto L10;
        return r101.get(r100.getUnderlyingTypeId());
    L10:
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<ProtoBuf.Type> upperBounds(ProtoBuf.TypeParameter r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        List<ProtoBuf.Type> r102 = r100.getUpperBoundList();
        if ((!r102.isEmpty()) == true) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L11;
        List<Integer> r103 = r100.getUpperBoundIdList();
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Integer r105 = (Integer) r104.next();
        Intrinsics.checkNotNull(r105);
        r102.add(r101.get(r105.intValue()));
    L11:
        return r102;
    }

    public static final ProtoBuf.Type varargElementType(ProtoBuf.ValueParameter r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasVarargElementType() == false) goto L6;
        return r100.getVarargElementType();
    L6:
        if (r100.hasVarargElementTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getVarargElementTypeId());
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Function r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        List<ProtoBuf.Type> r102 = r100.getContextReceiverTypeList();
        if ((!r102.isEmpty()) == true) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L11;
        List<Integer> r103 = r100.getContextReceiverTypeIdList();
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Integer r105 = (Integer) r104.next();
        Intrinsics.checkNotNull(r105);
        r102.add(r101.get(r105.intValue()));
    L11:
        return r102;
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Property r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasReceiverType() == false) goto L6;
        return r100.getReceiverType();
    L6:
        if (r100.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getReceiverTypeId());
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Property r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasReturnType() == false) goto L6;
        return r100.getReturnType();
    L6:
        if (r100.hasReturnTypeId() == false) goto L10;
        return r101.get(r100.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final ProtoBuf.Type type(ProtoBuf.Type.Argument r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        if (r100.hasType() == false) goto L6;
        return r100.getType();
    L6:
        if (r100.hasTypeId() == true) goto L11;
        return null;
    L11:
        return r101.get(r100.getTypeId());
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Property r100, TypeTable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "typeTable");
        List<ProtoBuf.Type> r102 = r100.getContextReceiverTypeList();
        if ((!r102.isEmpty()) == true) goto L6;
        r102 = null;
    L6:
        if (r102 != null) goto L11;
        List<Integer> r103 = r100.getContextReceiverTypeIdList();
        r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Integer r105 = (Integer) r104.next();
        Intrinsics.checkNotNull(r105);
        r102.add(r101.get(r105.intValue()));
    L11:
        return r102;
    }
}
