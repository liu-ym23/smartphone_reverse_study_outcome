package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: classes5.dex */
public interface KotlinJvmBinaryClass {

    public interface AnnotationArgumentVisitor {
        void visit(Name r100, Object r101);

        AnnotationArgumentVisitor visitAnnotation(Name r100, ClassId r101);

        AnnotationArrayArgumentVisitor visitArray(Name r100);

        void visitClassLiteral(Name r100, ClassLiteralValue r101);

        void visitEnd();

        void visitEnum(Name r100, ClassId r101, Name r102);
    }

    public interface AnnotationArrayArgumentVisitor {
        void visit(Object r100);

        AnnotationArgumentVisitor visitAnnotation(ClassId r100);

        void visitClassLiteral(ClassLiteralValue r100);

        void visitEnd();

        void visitEnum(ClassId r100, Name r101);
    }

    public interface AnnotationVisitor {
        AnnotationArgumentVisitor visitAnnotation(ClassId r100, SourceElement r101);

        void visitEnd();
    }

    /* JADX INFO: loaded from: classes42.dex */
    public interface MemberVisitor {
        AnnotationVisitor visitField(Name r100, String r101, Object r102);

        MethodAnnotationVisitor visitMethod(Name r100, String r101);
    }

    /* JADX INFO: loaded from: classes42.dex */
    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        AnnotationArgumentVisitor visitParameterAnnotation(int r100, ClassId r101, SourceElement r102);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(AnnotationVisitor r100, byte[] r101);

    void visitMembers(MemberVisitor r100, byte[] r101);
}
