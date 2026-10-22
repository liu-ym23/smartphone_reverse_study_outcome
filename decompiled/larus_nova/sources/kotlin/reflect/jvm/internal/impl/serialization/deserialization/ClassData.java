package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;

/* JADX INFO: loaded from: classes5.dex */
public final class ClassData {
    private final ProtoBuf.Class classProto;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;
    private final SourceElement sourceElement;

    public final NameResolver component1() {
        return this.nameResolver;
    }

    public final ProtoBuf.Class component2() {
        return this.classProto;
    }

    public final BinaryVersion component3() {
        return this.metadataVersion;
    }

    public final SourceElement component4() {
        return this.sourceElement;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClassData) == true) goto L8;
        return false;
    L8:
        ClassData r101 = (ClassData) r100;
        if (Intrinsics.areEqual(this.nameResolver, r101.nameResolver) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.classProto, r101.classProto) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.metadataVersion, r101.metadataVersion) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sourceElement, r101.sourceElement) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.nameResolver.hashCode() * 31) + this.classProto.hashCode()) * 31) + this.metadataVersion.hashCode()) * 31) + this.sourceElement.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.nameResolver + ", classProto=" + this.classProto + ", metadataVersion=" + this.metadataVersion + ", sourceElement=" + this.sourceElement + ')';
    }

    public ClassData(NameResolver r100, ProtoBuf.Class r101, BinaryVersion r102, SourceElement r103) {
        Intrinsics.checkNotNullParameter(r100, "nameResolver");
        Intrinsics.checkNotNullParameter(r101, "classProto");
        Intrinsics.checkNotNullParameter(r102, "metadataVersion");
        Intrinsics.checkNotNullParameter(r103, "sourceElement");
        this.nameResolver = r100;
        this.classProto = r101;
        this.metadataVersion = r102;
        this.sourceElement = r103;
    }
}
