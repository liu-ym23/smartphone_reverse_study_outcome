package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public class JvmDescriptorTypeWriter<T> {
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType != null) goto L6;
        this.jvmCurrentTypeArrayLevel++;
        return;
    }

    public void writeClass(T r100) {
        Intrinsics.checkNotNullParameter(r100, "objectType");
        writeJvmTypeAsIs(r100);
    }

    public final void writeJvmTypeAsIs(T r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (this.jvmCurrentType == null) goto L5;
        return;
    L5:
        if (this.jvmCurrentTypeArrayLevel <= 0) goto L7;
        r100 = this.jvmTypeFactory.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(r100));
    L7:
        this.jvmCurrentType = r100;
    }

    public void writeTypeVariable(Name r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "type");
        writeJvmTypeAsIs(r101);
    }
}
