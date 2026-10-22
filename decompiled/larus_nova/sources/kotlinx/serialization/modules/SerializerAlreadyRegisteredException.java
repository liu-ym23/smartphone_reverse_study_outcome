package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0010\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u0005\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Lkotlin/IllegalArgumentException;", "Ljava/lang/IllegalArgumentException;", "msg", "", "<init>", "(Ljava/lang/String;)V", "baseClass", "Lkotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SerializerAlreadyRegisteredException extends IllegalArgumentException {
    public SerializerAlreadyRegisteredException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super(r100);
    }

    public SerializerAlreadyRegisteredException(KClass<?> r100, KClass<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "concreteClass");
        this("Serializer for " + r101 + " already registered in the scope of " + r100);
    }
}
