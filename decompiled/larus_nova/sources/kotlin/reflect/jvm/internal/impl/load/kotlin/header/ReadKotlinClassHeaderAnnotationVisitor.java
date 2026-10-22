package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: loaded from: classes5.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS = null;
    private static boolean IGNORE_OLD_METADATA;
    private String[] data;
    private int extraInt;
    private String extraString;
    private KotlinClassHeader.Kind headerKind;
    private String[] incompatibleData;
    private int[] metadataVersionArray;
    private String packageName;
    private String[] serializedIrFields;
    private String[] strings;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            Object[] r101 = new Object[3];
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L8;
            if (r100 == 3) goto L7;
            r101[0] = "enumClassId";
        L10:
            r101[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (r100 == 2) goto L15;
            if (r100 == 3) goto L14;
            r101[2] = "visitEnum";
        L17:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
        L14:
            r101[2] = "visitAnnotation";
            goto L17
        L15:
            r101[2] = "visitClassLiteral";
            goto L17
        L7:
            r101[0] = "classId";
            goto L10
        L8:
            r101[0] = "classLiteralValue";
            goto L10
        L9:
            r101[0] = "enumEntryName";
            goto L10
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r100) {
            if (r100 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(ClassLiteralValue r100) {
            if (r100 != null) goto L5;
            $$$reportNull$$$0(2);
            return;
        }

        public abstract void visitEnd(String[] r100);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(ClassId r100, Name r101) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            if (r101 != null) goto L7;
            $$$reportNull$$$0(1);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }

        public CollectStringArrayAnnotationVisitor() {
            this.strings = new ArrayList();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(Object r100) {
            if ((r100 instanceof String) == false) goto L6;
            this.strings.add((String) r100);
            return;
        }
    }

    public class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            Object[] r101 = new Object[3];
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L8;
            if (r100 == 3) goto L7;
            r101[0] = "classLiteralValue";
        L10:
            r101[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L15;
            r101[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
        L15:
            r101[2] = "visitAnnotation";
        L16:
            r101[2] = "visitEnum";
            goto L18
        L7:
            r101[0] = "classId";
            goto L10
        L8:
            r101[0] = "enumEntryName";
            goto L10
        L9:
            r101[0] = "enumClassId";
            goto L10
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r100, ClassId r101) {
            if (r101 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r100, ClassLiteralValue r101) {
            if (r101 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r100, ClassId r101, Name r102) {
            if (r101 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r102 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        private KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r100) {
            this.this$0 = r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r100) {
            if (r100 == null) goto L5;
            String r101 = r100.asString();
        L7:
            if ("d1".equals(r101) == false) goto L11;
            return dataArrayVisitor();
        L11:
            if ("d2".equals(r101) == true) goto L13;
            return null;
        L13:
            return stringsArrayVisitor();
        L5:
            r101 = null;
            goto L7
        }

        public /* synthetic */ KotlinMetadataArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r100, Object r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            String r102 = r100.asString();
            if (ce.f26396k.equals(r102) == false) goto L10;
            if ((r101 instanceof Integer) == false) goto L34;
            ReadKotlinClassHeaderAnnotationVisitor.access$302(this.this$0, KotlinClassHeader.Kind.getById(((Integer) r101).intValue()));
            return;
        L34:
            return;
        L10:
            if (KtvSubElement.MV.equals(r102) == false) goto L15;
            if ((r101 instanceof int[]) == false) goto L36;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r101);
            return;
        L36:
            return;
        L15:
            if ("xs".equals(r102) == false) goto L22;
            if ((r101 instanceof String) == false) goto L38;
            String r103 = (String) r101;
            if (r103.isEmpty() == true) goto L39;
            ReadKotlinClassHeaderAnnotationVisitor.access$502(this.this$0, r103);
            return;
        L39:
            return;
        L38:
            return;
        L22:
            if ("xi".equals(r102) == false) goto L27;
            if ((r101 instanceof Integer) == false) goto L41;
            ReadKotlinClassHeaderAnnotationVisitor.access$602(this.this$0, ((Integer) r101).intValue());
            return;
        L41:
            return;
        L27:
            if ("pn".equals(r102) == true) goto L29;
            return;
        L29:
            if ((r101 instanceof String) == false) goto L44;
            String r104 = (String) r101;
            if (r104.isEmpty() == true) goto L45;
            ReadKotlinClassHeaderAnnotationVisitor.access$702(this.this$0, r104);
            return;
        L45:
            return;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class KotlinSerializedIrArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            Object[] r101 = new Object[3];
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L8;
            if (r100 == 3) goto L7;
            r101[0] = "classLiteralValue";
        L10:
            r101[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L15;
            r101[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
        L15:
            r101[2] = "visitAnnotation";
        L16:
            r101[2] = "visitEnum";
            goto L18
        L7:
            r101[0] = "classId";
            goto L10
        L8:
            r101[0] = "enumEntryName";
            goto L10
        L9:
            r101[0] = "enumClassId";
            goto L10
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r100, Object r101) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r100, ClassId r101) {
            if (r101 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r100, ClassLiteralValue r101) {
            if (r101 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r100, ClassId r101, Name r102) {
            if (r101 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r102 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinSerializedIrArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r100) {
            this.this$0 = r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r100) {
            if (r100 == null) goto L5;
            String r101 = r100.asString();
        L7:
            if ("b".equals(r101) == true) goto L9;
            return null;
        L9:
            return serializedIrArrayVisitor();
        L5:
            r101 = null;
            goto L7
        }

        public /* synthetic */ KotlinSerializedIrArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class OldDeprecatedAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            Object[] r101 = new Object[3];
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L8;
            if (r100 == 3) goto L7;
            r101[0] = "classLiteralValue";
        L10:
            r101[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L15;
            r101[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
        L15:
            r101[2] = "visitAnnotation";
        L16:
            r101[2] = "visitEnum";
            goto L18
        L7:
            r101[0] = "classId";
            goto L10
        L8:
            r101[0] = "enumEntryName";
            goto L10
        L9:
            r101[0] = "enumClassId";
            goto L10
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name r100, ClassId r101) {
            if (r101 != null) goto L6;
            $$$reportNull$$$0(3);
            return null;
        L6:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r100, ClassLiteralValue r101) {
            if (r101 != null) goto L5;
            $$$reportNull$$$0(0);
            return;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r100, ClassId r101, Name r102) {
            if (r101 != null) goto L4;
            $$$reportNull$$$0(1);
        L4:
            if (r102 != null) goto L7;
            $$$reportNull$$$0(2);
            return;
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new AnonymousClass1(this);
        }

        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new AnonymousClass2(this);
        }

        private OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r100) {
            this.this$0 = r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r100) {
            if (r100 == null) goto L5;
            String r101 = r100.asString();
        L7:
            if ("data".equals(r101) == true) goto L17;
            if ("filePartClassNames".equals(r101) == true) goto L17;
            if ("strings".equals(r101) == true) goto L14;
            return null;
        L14:
            return stringsArrayVisitor();
        L17:
            return dataArrayVisitor();
        L5:
            r101 = null;
            goto L7
        }

        public /* synthetic */ OldDeprecatedAnnotationArgumentVisitor(ReadKotlinClassHeaderAnnotationVisitor r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r100, Object r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            String r102 = r100.asString();
            if ("version".equals(r102) == false) goto L10;
            if ((r101 instanceof int[]) == false) goto L17;
            ReadKotlinClassHeaderAnnotationVisitor.access$402(this.this$0, (int[]) r101);
            return;
        L17:
            return;
        L10:
            if ("multifileClassName".equals(r102) == false) goto L19;
            ReadKotlinClassHeaderAnnotationVisitor r103 = this.this$0;
            if ((r101 instanceof String) == false) goto L14;
            String r104 = (String) r101;
        L15:
            ReadKotlinClassHeaderAnnotationVisitor.access$502(r103, r104);
            return;
        L14:
            r104 = null;
            goto L15
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        if (r100 == 1) goto L5;
        r101[0] = "classId";
    L6:
        r101[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        r101[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L5:
        r101[0] = "source";
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }

    static {
        IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));     // Catch: AccessControlException -> L4
    L5:
        HashMap r100 = new HashMap();
        HEADER_KINDS = r100;
        r100.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        r100.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        r100.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        r100.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        r100.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
        return;
    L4:
        IGNORE_OLD_METADATA = false;
        goto L5
    }

    private boolean shouldHaveData() {
        KotlinClassHeader.Kind r100 = this.headerKind;
        if (r100 != KotlinClassHeader.Kind.CLASS) goto L5;
    L10:
        return true;
    L5:
        if (r100 == KotlinClassHeader.Kind.FILE_FACADE) goto L10;
        if (r100 == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) goto L10;
        return false;
    }

    public KotlinClassHeader createHeaderWithDefaultMetadataVersion() {
        return createHeader(JvmMetadataVersion.INSTANCE);
    }

    public ReadKotlinClassHeaderAnnotationVisitor() {
        this.metadataVersionArray = null;
        this.extraString = null;
        this.extraInt = 0;
        this.packageName = null;
        this.data = null;
        this.strings = null;
        this.incompatibleData = null;
        this.headerKind = null;
        this.serializedIrFields = null;
    }

    public KotlinClassHeader createHeader(JvmMetadataVersion r110) {
        byte[] r100 = null;
        if (this.headerKind != null) goto L5;
    L24:
        return null;
    L5:
        if (this.metadataVersionArray == null) goto L24;
        int[] r101 = this.metadataVersionArray;
        if ((this.extraInt & 8) == 0) goto L10;
        boolean r102 = true;
    L11:
        JvmMetadataVersion r103 = new JvmMetadataVersion(r101, r102);
        if (r103.isCompatible(r110) == true) goto L15;
        this.incompatibleData = this.data;
        this.data = null;
    L19:
        String[] r111 = this.serializedIrFields;
        if (r111 == null) goto L22;
        r100 = BitEncoding.decodeBytes(r111);
    L22:
        KotlinClassHeader.Kind r104 = this.headerKind;
        String[] r105 = this.data;
        String[] r106 = this.incompatibleData;
        String[] r107 = this.strings;
        String r108 = this.extraString;
        int r109 = this.extraInt;
        String r112 = this.packageName;
        return new KotlinClassHeader(r104, r103, r105, r106, r107, r108, r109, r112, r100);
    L15:
        if (shouldHaveData() == false) goto L19;
        if (this.data != null) goto L19;
        return null;
    L10:
        r102 = false;
        goto L11
    }

    public static /* synthetic */ String[] access$1002(ReadKotlinClassHeaderAnnotationVisitor r100, String[] r101) {
        r100.serializedIrFields = r101;
        return r101;
    }

    public static /* synthetic */ KotlinClassHeader.Kind access$302(ReadKotlinClassHeaderAnnotationVisitor r100, KotlinClassHeader.Kind r101) {
        r100.headerKind = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$402(ReadKotlinClassHeaderAnnotationVisitor r100, int[] r101) {
        r100.metadataVersionArray = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(ReadKotlinClassHeaderAnnotationVisitor r100, String r101) {
        r100.extraString = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(ReadKotlinClassHeaderAnnotationVisitor r100, int r101) {
        r100.extraInt = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(ReadKotlinClassHeaderAnnotationVisitor r100, String r101) {
        r100.packageName = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$802(ReadKotlinClassHeaderAnnotationVisitor r100, String[] r101) {
        r100.data = r101;
        return r101;
    }

    public static /* synthetic */ String[] access$902(ReadKotlinClassHeaderAnnotationVisitor r100, String[] r101) {
        r100.strings = r101;
        return r101;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r100, SourceElement r101) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        FqName r102 = r100.asSingleFqName();
        AnonymousClass1 r103 = null;
        if (r102.equals(JvmAnnotationNames.METADATA_FQ_NAME) == false) goto L11;
        return new KotlinMetadataArgumentVisitor(this, r103);
    L11:
        if (r102.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME) == false) goto L15;
        return new KotlinSerializedIrArgumentVisitor(this, r103);
    L15:
        if (IGNORE_OLD_METADATA == false) goto L18;
        return null;
    L18:
        if (this.headerKind == null) goto L20;
        return null;
    L20:
        KotlinClassHeader.Kind r104 = HEADER_KINDS.get(r100);
        if (r104 == null) goto L24;
        this.headerKind = r104;
        return new OldDeprecatedAnnotationArgumentVisitor(this, r103);
    L24:
        return null;
    }
}
