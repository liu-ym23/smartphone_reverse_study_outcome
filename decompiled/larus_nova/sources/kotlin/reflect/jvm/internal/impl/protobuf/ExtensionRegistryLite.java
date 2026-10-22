package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ExtensionRegistryLite {
    private static final ExtensionRegistryLite EMPTY = null;
    private static volatile boolean eagerlyParseMessageSets;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    public static final class ObjectIntPair {
        private final int number;
        private final Object object;

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r101 = (ObjectIntPair) r100;
            if (this.object == r101.object) goto L8;
            return false;
        L8:
            if (this.number != r101.number) goto L12;
            return true;
        L12:
            return false;
        }

        public ObjectIntPair(Object r100, int r101) {
            this.object = r100;
            this.number = r101;
        }
    }

    static {
        EMPTY = new ExtensionRegistryLite(true);
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    private ExtensionRegistryLite(boolean r100) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r100) {
        this.extensionsByNumber.put(new ObjectIntPair(r100.getContainingTypeDefaultInstance(), r100.getNumber()), r100);
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r100, int r101) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r100, r101));
    }
}
