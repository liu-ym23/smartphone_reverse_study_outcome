package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeAttributeTranslators {
    private final List<TypeAttributeTranslator> translators;

    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TypeAttributeTranslators(List<? extends TypeAttributeTranslator> r100) {
        Intrinsics.checkNotNullParameter(r100, "translators");
        this.translators = r100;
    }
}
