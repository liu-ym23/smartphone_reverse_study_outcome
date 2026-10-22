package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    private final Object[] values;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public List<ReflectJavaAnnotationArgument> getElements() {
        Object[] r100 = this.values;
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Object r104 = r100[r103];
        ReflectJavaAnnotationArgument.Factory r105 = ReflectJavaAnnotationArgument.Factory;
        Intrinsics.checkNotNull(r104);
        r101.add(r105.create(r104, null));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public ReflectJavaArrayAnnotationArgument(Name r100, Object[] r101) {
        Intrinsics.checkNotNullParameter(r101, "values");
        super(r100, null);
        this.values = r101;
    }
}
