package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes5.dex */
public final class KotlinClassFinderKt {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r100, JavaClass r101, JvmMetadataVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "javaClass");
        Intrinsics.checkNotNullParameter(r102, "jvmMetadataVersion");
        KotlinClassFinder.Result r103 = r100.findKotlinClassOrContent(r101, r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder r100, ClassId r101, JvmMetadataVersion r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "classId");
        Intrinsics.checkNotNullParameter(r102, "jvmMetadataVersion");
        KotlinClassFinder.Result r103 = r100.findKotlinClassOrContent(r101, r102);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.toKotlinJvmBinaryClass();
    }
}
