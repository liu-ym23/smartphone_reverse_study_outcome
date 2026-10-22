package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* JADX INFO: loaded from: classes42.dex */
public final class ValueClassUtilKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends SimpleTypeMarker> ValueClassRepresentation<T> loadValueClassRepresentation(ProtoBuf.Class r100, NameResolver r101, TypeTable r102, Function1<? super ProtoBuf.Type, ? extends T> r103, Function1<? super Name, ? extends T> r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        Intrinsics.checkNotNullParameter(r102, "typeTable");
        Intrinsics.checkNotNullParameter(r103, "typeDeserializer");
        Intrinsics.checkNotNullParameter(r104, "typeOfPublicProperty");
        if (r100.getMultiFieldValueClassUnderlyingNameCount() <= 0) goto L26;
        List<Integer> r105 = r100.getMultiFieldValueClassUnderlyingNameList();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        Integer r108 = (Integer) r107.next();
        Intrinsics.checkNotNull(r108);
        r106.add(NameResolverUtilKt.getName(r101, r108.intValue()));
        goto L6
    L8:
        Pair r109 = TuplesKt.to(Integer.valueOf(r100.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(r100.getMultiFieldValueClassUnderlyingTypeCount()));
        if (Intrinsics.areEqual(r109, TuplesKt.to(Integer.valueOf(r106.size()), 0)) == false) goto L15;
        List<Integer> r110 = r100.getMultiFieldValueClassUnderlyingTypeIdList();
        List<ProtoBuf.Type> r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L12:
        if (r112.hasNext() == false) goto L17;
        Integer r113 = (Integer) r112.next();
        Intrinsics.checkNotNull(r113);
        r111.add(r102.get(r113.intValue()));
    L17:
        Intrinsics.checkNotNull(r111);
        List<ProtoBuf.Type> r114 = r111;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r116 = r114.iterator();
    L19:
        if (r116.hasNext() == false) goto L22;
        r115.add(r103.invoke(r116.next()));
        goto L19
    L22:
        return new MultiFieldValueClassRepresentation(CollectionsKt.zip(r106, r115));
    L15:
        if (Intrinsics.areEqual(r109, TuplesKt.to(0, Integer.valueOf(r106.size()))) == false) goto L24;
        r111 = r100.getMultiFieldValueClassUnderlyingTypeList();
        goto L17
    L24:
        throw new IllegalStateException(("class " + NameResolverUtilKt.getName(r101, r100.getFqName()) + " has illegal multi-field value class representation").toString());
    L26:
        if (r100.hasInlineClassUnderlyingPropertyName() == false) goto L37;
        Name r117 = NameResolverUtilKt.getName(r101, r100.getInlineClassUnderlyingPropertyName());
        ProtoBuf.Type r118 = ProtoTypeTableUtilKt.inlineClassUnderlyingType(r100, r102);
        if (r118 == null) goto L31;
        T r119 = r103.invoke(r118);
        if (r119 == null) goto L31;
    L34:
        return new InlineClassRepresentation(r117, r119);
    L31:
        r119 = r104.invoke(r117);
        if (r119 != null) goto L34;
        throw new IllegalStateException(("cannot determine underlying type for value class " + NameResolverUtilKt.getName(r101, r100.getFqName()) + " with property " + r117).toString());
    L37:
        return null;
    }
}
