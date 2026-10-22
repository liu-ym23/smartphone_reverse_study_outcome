package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final BuiltInsResourceLoader builtInsResourceLoader;
    private final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "classLoader");
        this.classLoader = r100;
        this.builtInsResourceLoader = new BuiltInsResourceLoader();
    }

    private final KotlinClassFinder.Result findKotlinClass(String r100) {
        Class<?> r101 = ReflectJavaClassFinderKt.tryLoadClass(this.classLoader, r100);
        if (r101 == null) goto L8;
        ReflectKotlinClass r102 = ReflectKotlinClass.Factory.create(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new KotlinClassFinder.Result.KotlinClass(r102, null, 2, null);
    L8:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "packageFqName");
        if (r100.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME) == true) goto L7;
        return null;
    L7:
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(r100));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(JavaClass r100, JvmMetadataVersion r101) {
        Intrinsics.checkNotNullParameter(r100, "javaClass");
        Intrinsics.checkNotNullParameter(r101, "jvmMetadataVersion");
        FqName r102 = r100.getFqName();
        if (r102 == null) goto L9;
        String r103 = r102.asString();
        if (r103 != null) goto L8;
        return null;
    L8:
        return findKotlinClass(r103);
    L9:
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    public KotlinClassFinder.Result findKotlinClassOrContent(ClassId r100, JvmMetadataVersion r101) {
        Intrinsics.checkNotNullParameter(r100, "classId");
        Intrinsics.checkNotNullParameter(r101, "jvmMetadataVersion");
        return findKotlinClass(ReflectKotlinClassFinderKt.access$toRuntimeFqName(r100));
    }
}
