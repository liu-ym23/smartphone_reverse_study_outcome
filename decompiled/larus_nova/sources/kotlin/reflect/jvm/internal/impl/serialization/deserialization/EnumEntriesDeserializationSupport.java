package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: loaded from: classes5.dex */
public interface EnumEntriesDeserializationSupport {

    /* JADX INFO: loaded from: classes42.dex */
    public static final class Default implements EnumEntriesDeserializationSupport {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport
        public Boolean canSynthesizeEnumEntries() {
            return null;
        }
    }

    Boolean canSynthesizeEnumEntries();
}
