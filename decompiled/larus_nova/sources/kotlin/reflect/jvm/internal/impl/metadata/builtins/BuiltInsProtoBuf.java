package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;

/* JADX INFO: loaded from: classes5.dex */
public final class BuiltInsProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> classAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> compileTimeValue = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> constructorAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> enumEntryAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> functionAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageFqName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> parameterAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertyGetterAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> propertySetterAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = null;

    static {
        packageFqName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 151, WireFormat.FieldType.INT32, Integer.class);
        ProtoBuf.Class r100 = ProtoBuf.Class.getDefaultInstance();
        ProtoBuf.Annotation r101 = ProtoBuf.Annotation.getDefaultInstance();
        WireFormat.FieldType r102 = WireFormat.FieldType.MESSAGE;
        classAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(r100, r101, null, 150, r102, false, ProtoBuf.Annotation.class);
        constructorAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Constructor.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
        functionAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
        propertyAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
        propertyGetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 152, r102, false, ProtoBuf.Annotation.class);
        propertySetterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 153, r102, false, ProtoBuf.Annotation.class);
        compileTimeValue = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), ProtoBuf.Annotation.Argument.Value.getDefaultInstance(), null, 151, r102, ProtoBuf.Annotation.Argument.Value.class);
        enumEntryAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.EnumEntry.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
        parameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.ValueParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 150, r102, false, ProtoBuf.Annotation.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
        r100.add(packageFqName);
        r100.add(classAnnotation);
        r100.add(constructorAnnotation);
        r100.add(functionAnnotation);
        r100.add(propertyAnnotation);
        r100.add(propertyGetterAnnotation);
        r100.add(propertySetterAnnotation);
        r100.add(compileTimeValue);
        r100.add(enumEntryAnnotation);
        r100.add(parameterAnnotation);
        r100.add(typeAnnotation);
        r100.add(typeParameterAnnotation);
    }
}
