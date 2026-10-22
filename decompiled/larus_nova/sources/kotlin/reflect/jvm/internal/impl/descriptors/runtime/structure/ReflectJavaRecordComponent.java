package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaRecordComponent extends ReflectJavaMember implements JavaRecordComponent {
    private final Object recordComponent;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public boolean isVararg() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Member getMember() {
        Method r100 = Java16RecordComponentsLoader.INSTANCE.loadGetAccessor(this.recordComponent);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public JavaType getType() {
        Class<?> r100 = Java16RecordComponentsLoader.INSTANCE.loadGetType(this.recordComponent);
        if (r100 == null) goto L7;
        return new ReflectJavaClassifierType(r100);
    L7:
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    public ReflectJavaRecordComponent(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "recordComponent");
        this.recordComponent = r100;
    }
}
