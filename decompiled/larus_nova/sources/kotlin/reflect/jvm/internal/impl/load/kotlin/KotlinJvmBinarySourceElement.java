package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* JADX INFO: loaded from: classes5.dex */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource {
    private final DeserializedContainerAbiStability abiStability;
    private final KotlinJvmBinaryClass binaryClass;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> incompatibility;
    private final boolean isPreReleaseInvisible;

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    public String getPresentableString() {
        return "Class '" + this.binaryClass.getClassId().asSingleFqName().asString() + '\'';
    }

    public String toString() {
        return "KotlinJvmBinarySourceElement: " + this.binaryClass;
    }

    public final KotlinJvmBinaryClass getBinaryClass() {
        return this.binaryClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        return SourceFile.NO_SOURCE_FILE;
    }

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass r100, IncompatibleVersionErrorData<JvmMetadataVersion> r101, boolean r102, DeserializedContainerAbiStability r103) {
        Intrinsics.checkNotNullParameter(r100, "binaryClass");
        Intrinsics.checkNotNullParameter(r103, "abiStability");
        this.binaryClass = r100;
        this.incompatibility = r101;
        this.isPreReleaseInvisible = r102;
        this.abiStability = r103;
    }
}
