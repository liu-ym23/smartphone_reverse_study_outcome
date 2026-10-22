package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY = null;
    public static final JvmProtoBufUtil INSTANCE = null;

    private JvmProtoBufUtil() {
    }

    static {
        INSTANCE = new JvmProtoBufUtil();
        ExtensionRegistryLite r100 = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(r100);
        EXTENSION_REGISTRY = r100;
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property r100) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        return JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION().get(((Number) r100.getExtension(JvmProtoBuf.flags)).intValue()).booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type r100, NameResolver r101) {
        if (r100.hasClassName() == true) goto L7;
        return null;
    L7:
        return ClassMapperLite.mapClass(r101.getQualifiedClassName(r100.getClassName()));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r101, "strings");
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        return new Pair(INSTANCE.readNameResolver(r102, r101), ProtoBuf.Class.parseFrom(r102, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "strings");
        ByteArrayInputStream r102 = new ByteArrayInputStream(BitEncoding.decodeBytes(r100));
        return new Pair(INSTANCE.readNameResolver(r102, r101), ProtoBuf.Function.parseFrom(r102, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream r100, String[] r101) {
        return new JvmNameResolver(JvmProtoBuf.StringTableTypes.parseDelimitedFrom(r100, EXTENSION_REGISTRY), r101);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r101, "strings");
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        return new Pair(INSTANCE.readNameResolver(r102, r101), ProtoBuf.Package.parseFrom(r102, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "strings");
        return readClassDataFrom(BitEncoding.decodeBytes(r100), r101);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "strings");
        return readPackageDataFrom(BitEncoding.decodeBytes(r100), r101);
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor r110, NameResolver r111, TypeTable r112) {
        Intrinsics.checkNotNullParameter(r110, "proto");
        Intrinsics.checkNotNullParameter(r111, "nameResolver");
        Intrinsics.checkNotNullParameter(r112, "typeTable");
        JvmProtoBuf.JvmMethodSignature r100 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r110, JvmProtoBuf.constructorSignature);
        if (r100 != null) goto L5;
    L7:
        String r101 = "<init>";
    L8:
        if (r100 != null) goto L10;
    L12:
        List<ProtoBuf.ValueParameter> r113 = r110.getValueParameterList();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L14:
        if (r114.hasNext() == false) goto L20;
        ProtoBuf.ValueParameter r103 = (ProtoBuf.ValueParameter) r114.next();
        JvmProtoBufUtil r104 = INSTANCE;
        Intrinsics.checkNotNull(r103);
        String r105 = r104.mapTypeDefault(ProtoTypeTableUtilKt.type(r103, r112), r111);
        if (r105 == null) goto L17;
        r102.add(r105);
        goto L14
    L17:
        return null;
    L20:
        String r115 = CollectionsKt.joinToString$default(r102, "", "(", ")V", 0, null, null, 56, null);
    L22:
        return new JvmMemberSignature.Method(r101, r115);
    L10:
        if (r100.hasDesc() == false) goto L12;
        r115 = r111.getString(r100.getDesc());
        goto L22
    L5:
        if (r100.hasName() == false) goto L7;
        r101 = r111.getString(r100.getName());
        goto L8
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function r110, NameResolver r111, TypeTable r210) {
        Intrinsics.checkNotNullParameter(r110, "proto");
        Intrinsics.checkNotNullParameter(r111, "nameResolver");
        Intrinsics.checkNotNullParameter(r210, "typeTable");
        JvmProtoBuf.JvmMethodSignature r100 = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(r110, JvmProtoBuf.methodSignature);
        if (r100 != null) goto L5;
    L7:
        int r101 = r110.getName();
    L8:
        if (r100 != null) goto L10;
    L12:
        List r102 = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(r110, r210));
        List<ProtoBuf.ValueParameter> r103 = r110.getValueParameterList();
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        ProtoBuf.ValueParameter r106 = (ProtoBuf.ValueParameter) r105.next();
        Intrinsics.checkNotNull(r106);
        r104.add(ProtoTypeTableUtilKt.type(r106, r210));
        goto L14
    L16:
        List r107 = CollectionsKt.plus(r102, r104);
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L18:
        if (r109.hasNext() == false) goto L23;
        String r112 = INSTANCE.mapTypeDefault((ProtoBuf.Type) r109.next(), r111);
        if (r112 == null) goto L21;
        r108.add(r112);
        goto L18
    L21:
        return null;
    L23:
        String r113 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r110, r210), r111);
        if (r113 != null) goto L26;
        return null;
    L26:
        String r114 = CollectionsKt.joinToString$default(r108, "", "(", ")", 0, null, null, 56, null) + r113;
    L28:
        return new JvmMemberSignature.Method(r111.getString(r101), r114);
    L10:
        if (r100.hasDesc() == false) goto L12;
        r114 = r111.getString(r100.getDesc());
        goto L28
    L5:
        if (r100.hasName() == false) goto L7;
        r101 = r100.getName();
        goto L8
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property r100, NameResolver r101, TypeTable r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "proto");
        Intrinsics.checkNotNullParameter(r101, "nameResolver");
        Intrinsics.checkNotNullParameter(r102, "typeTable");
        JvmProtoBuf.JvmPropertySignature r104 = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(r100, JvmProtoBuf.propertySignature);
        if (r104 != null) goto L6;
        return null;
    L6:
        if (r104.hasField() == false) goto L8;
        JvmProtoBuf.JvmFieldSignature r105 = r104.getField();
    L9:
        if (r105 != null) goto L12;
        if (r103 == false) goto L12;
        return null;
    L12:
        if (r105 != null) goto L14;
    L16:
        int r106 = r100.getName();
    L17:
        if (r105 != null) goto L19;
    L21:
        String r107 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(r100, r102), r101);
        if (r107 != null) goto L25;
        return null;
    L25:
        return new JvmMemberSignature.Field(r101.getString(r106), r107);
    L19:
        if (r105.hasDesc() == false) goto L21;
        r107 = r101.getString(r105.getDesc());
        goto L25
    L14:
        if (r105.hasName() == false) goto L16;
        r106 = r105.getName();
        goto L17
    L8:
        r105 = null;
        goto L9
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil r100, ProtoBuf.Property r101, NameResolver r102, TypeTable r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r104 = true;
    L6:
        return r100.getJvmFieldSignature(r101, r102, r103, r104);
    }
}
