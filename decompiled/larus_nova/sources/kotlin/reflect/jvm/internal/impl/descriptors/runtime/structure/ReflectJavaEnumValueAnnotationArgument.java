package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {
    private final Enum<?> value;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public Name getEntryName() {
        return Name.identifier(this.value.name());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public ClassId getEnumClassId() {
        Class<?> r100 = this.value.getClass();
        if (r100.isEnum() == true) goto L6;
        r100 = r100.getEnclosingClass();
    L6:
        Intrinsics.checkNotNull(r100);
        return ReflectClassUtilKt.getClassId(r100);
    }

    public ReflectJavaEnumValueAnnotationArgument(Name r100, Enum<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        super(r100, null);
        this.value = r101;
    }
}
