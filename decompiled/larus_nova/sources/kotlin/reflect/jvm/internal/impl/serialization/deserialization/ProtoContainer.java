package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ProtoContainer {
    private final NameResolver nameResolver;
    private final SourceElement source;
    private final TypeTable typeTable;

    public static final class Class extends ProtoContainer {
        private final ClassId classId;
        private final ProtoBuf.Class classProto;
        private final boolean isData;
        private final boolean isInner;
        private final ProtoBuf.Class.Kind kind;
        private final Class outerClass;

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.classId.asSingleFqName();
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public final ProtoBuf.Class getClassProto() {
            return this.classProto;
        }

        public final ProtoBuf.Class.Kind getKind() {
            return this.kind;
        }

        public final Class getOuterClass() {
            return this.outerClass;
        }

        public final boolean isInner() {
            return this.isInner;
        }

        public Class(ProtoBuf.Class r100, NameResolver r101, TypeTable r102, SourceElement r103, Class r104) {
            Intrinsics.checkNotNullParameter(r100, "classProto");
            Intrinsics.checkNotNullParameter(r101, "nameResolver");
            Intrinsics.checkNotNullParameter(r102, "typeTable");
            super(r101, r102, r103, null);
            this.classProto = r100;
            this.outerClass = r104;
            this.classId = NameResolverUtilKt.getClassId(r101, r100.getFqName());
            ProtoBuf.Class.Kind r105 = Flags.CLASS_KIND.get(r100.getFlags());
            if (r105 != null) goto L5;
            r105 = ProtoBuf.Class.Kind.CLASS;
        L5:
            this.kind = r105;
            this.isInner = Flags.IS_INNER.get(r100.getFlags()).booleanValue();
            this.isData = Flags.IS_DATA.get(r100.getFlags()).booleanValue();
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class Package extends ProtoContainer {
        private final FqName fqName;

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer
        public FqName debugFqName() {
            return this.fqName;
        }

        public Package(FqName r100, NameResolver r101, TypeTable r102, SourceElement r103) {
            Intrinsics.checkNotNullParameter(r100, "fqName");
            Intrinsics.checkNotNullParameter(r101, "nameResolver");
            Intrinsics.checkNotNullParameter(r102, "typeTable");
            super(r101, r102, r103, null);
            this.fqName = r100;
        }
    }

    public /* synthetic */ ProtoContainer(NameResolver r100, TypeTable r101, SourceElement r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public abstract FqName debugFqName();

    public String toString() {
        return getClass().getSimpleName() + ": " + debugFqName();
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final SourceElement getSource() {
        return this.source;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    private ProtoContainer(NameResolver r100, TypeTable r101, SourceElement r102) {
        this.nameResolver = r100;
        this.typeTable = r101;
        this.source = r102;
    }
}
