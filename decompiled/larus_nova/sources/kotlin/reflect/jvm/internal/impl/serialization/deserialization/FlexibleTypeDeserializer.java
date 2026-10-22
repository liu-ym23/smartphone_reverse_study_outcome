package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes5.dex */
public interface FlexibleTypeDeserializer {

    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = null;

        static {
            INSTANCE = new ThrowException();
        }

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public KotlinType create(ProtoBuf.Type r100, String r101, SimpleType r102, SimpleType r103) {
            Intrinsics.checkNotNullParameter(r100, "proto");
            Intrinsics.checkNotNullParameter(r101, "flexibleId");
            Intrinsics.checkNotNullParameter(r102, "lowerBound");
            Intrinsics.checkNotNullParameter(r103, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(ProtoBuf.Type r100, String r101, SimpleType r102, SimpleType r103);
}
