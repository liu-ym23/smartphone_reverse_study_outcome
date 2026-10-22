package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaClassFinder {

    public static final class Request {
        private final ClassId classId;
        private final JavaClass outerClass;
        private final byte[] previouslyFoundClassFileContent;

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Request) == true) goto L8;
            return false;
        L8:
            Request r101 = (Request) r100;
            if (Intrinsics.areEqual(this.classId, r101.classId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.previouslyFoundClassFileContent, r101.previouslyFoundClassFileContent) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.outerClass, r101.outerClass) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = this.classId.hashCode() * 31;
            byte[] r101 = this.previouslyFoundClassFileContent;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            JavaClass r105 = this.outerClass;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = Arrays.hashCode(r101);
            goto L6
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public Request(ClassId r100, byte[] r101, JavaClass r102) {
            Intrinsics.checkNotNullParameter(r100, "classId");
            this.classId = r100;
            this.previouslyFoundClassFileContent = r101;
            this.outerClass = r102;
        }

        public /* synthetic */ Request(ClassId r100, byte[] r101, JavaClass r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this(r100, r101, r102);
        }
    }

    JavaClass findClass(Request r100);

    JavaPackage findPackage(FqName r100, boolean r101);

    Set<String> knownClassNamesInPackage(FqName r100);
}
