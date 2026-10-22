package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public static final Factory Factory = null;
    private final Name name;

    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r100) {
            this();
        }

        public final ReflectJavaAnnotationArgument create(Object r100, Name r101) {
            Intrinsics.checkNotNullParameter(r100, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r100.getClass()) == false) goto L6;
            return new ReflectJavaEnumValueAnnotationArgument(r101, (Enum) r100);
        L6:
            if ((r100 instanceof Annotation) == false) goto L9;
            return new ReflectJavaAnnotationAsAnnotationArgument(r101, (Annotation) r100);
        L9:
            if ((r100 instanceof Object[]) == false) goto L12;
            return new ReflectJavaArrayAnnotationArgument(r101, (Object[]) r100);
        L12:
            if ((r100 instanceof Class) == false) goto L15;
            return new ReflectJavaClassObjectAnnotationArgument(r101, (Class) r100);
        L15:
            return new ReflectJavaLiteralAnnotationArgument(r101, r100);
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public Name getName() {
        return this.name;
    }

    private ReflectJavaAnnotationArgument(Name r100) {
        this.name = r100;
    }
}
