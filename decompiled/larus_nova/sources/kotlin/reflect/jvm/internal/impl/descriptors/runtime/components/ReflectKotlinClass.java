package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = null;
    private final KotlinClassHeader classHeader;
    private final Class<?> klass;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r100) {
            this();
        }

        public final ReflectKotlinClass create(Class<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "klass");
            ReadKotlinClassHeaderAnnotationVisitor r101 = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(r100, r101);
            KotlinClassHeader r102 = r101.createHeaderWithDefaultMetadataVersion();
            DefaultConstructorMarker r103 = null;
            if (r102 != null) goto L6;
            return null;
        L6:
            return new ReflectKotlinClass(r100, r102, r103);
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectKotlinClass(Class r100, KotlinClassHeader r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public String getLocation() {
        return StringsKt.replace$default(this.klass.getName(), '.', '/', false, 4, null) + ".class";
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    public final Class<?> getKlass() {
        return this.klass;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ReflectKotlinClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) r100).klass) == false) goto L7;
        return true;
    }

    private ReflectKotlinClass(Class<?> r100, KotlinClassHeader r101) {
        this.klass = r100;
        this.classHeader = r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, r100);
    }
}
