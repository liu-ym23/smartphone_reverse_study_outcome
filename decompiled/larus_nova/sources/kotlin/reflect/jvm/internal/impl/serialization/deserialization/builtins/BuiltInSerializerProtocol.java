package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol INSTANCE = null;

    static {
        INSTANCE = new BuiltInSerializerProtocol();
    }

    private BuiltInSerializerProtocol() {
        ExtensionRegistryLite r100 = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(r100);
        super(r100, BuiltInsProtoBuf.packageFqName, BuiltInsProtoBuf.constructorAnnotation, BuiltInsProtoBuf.classAnnotation, BuiltInsProtoBuf.functionAnnotation, null, BuiltInsProtoBuf.propertyAnnotation, BuiltInsProtoBuf.propertyGetterAnnotation, BuiltInsProtoBuf.propertySetterAnnotation, null, null, null, BuiltInsProtoBuf.enumEntryAnnotation, BuiltInsProtoBuf.compileTimeValue, BuiltInsProtoBuf.parameterAnnotation, BuiltInsProtoBuf.typeAnnotation, BuiltInsProtoBuf.typeParameterAnnotation);
    }

    private final String shortName(FqName r100) {
        if (r100.isRoot() == false) goto L6;
        return "default-package";
    L6:
        return r100.shortName().asString();
    }

    public final String getBuiltInsFileName(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return shortName(r100) + ".kotlin_builtins";
    }

    public final String getBuiltInsFilePath(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "fqName");
        return StringsKt.replace$default(r100.asString(), '.', '/', false, 4, null) + '/' + getBuiltInsFileName(r100);
    }
}
