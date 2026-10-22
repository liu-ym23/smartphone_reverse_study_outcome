package nuc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes42.dex */
public final class c {
    public static final void a(String r100, KClass r101) {
        Intrinsics.checkNotNullParameter(r101, "baseClass");
        String r102 = "in the polymorphic scope of '" + r101.getSimpleName() + '\'';
        if (r100 != null) goto L5;
        String r103 = "Class discriminator was missing and no default serializers were registered " + r102 + '.';
    L7:
        throw new SerializationException(r103);
    L5:
        r103 = "Serializer for subclass '" + r100 + "' is not found " + r102 + ".\nCheck if class with serial name '" + r100 + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + r100 + "' has to be '@Serializable', and the base class '" + r101.getSimpleName() + "' has to be sealed and '@Serializable'.";
        goto L7
    }
}
