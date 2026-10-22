package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* JADX INFO: loaded from: classes5.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    public static abstract class Result {

        public static final class ClassFileContent extends Result {
            private final byte[] content;

            public final byte[] getContent() {
                return this.content;
            }
        }

        public static final class KotlinClass extends Result {
            private final byte[] byteContent;
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }

            public KotlinClass(KotlinJvmBinaryClass r100, byte[] r101) {
                Intrinsics.checkNotNullParameter(r100, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = r100;
                this.byteContent = r101;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass r100, byte[] r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 2) == 0) goto L5;
                r101 = null;
            L5:
                this(r100, r101);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker r100) {
            this();
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            if ((this instanceof KotlinClass) == false) goto L5;
            KotlinClass r100 = (KotlinClass) this;
        L6:
            if (r100 != null) goto L8;
            return null;
        L8:
            return r100.getKotlinJvmBinaryClass();
        L5:
            r100 = null;
            goto L6
        }
    }

    Result findKotlinClassOrContent(JavaClass r100, JvmMetadataVersion r101);

    Result findKotlinClassOrContent(ClassId r100, JvmMetadataVersion r101);
}
