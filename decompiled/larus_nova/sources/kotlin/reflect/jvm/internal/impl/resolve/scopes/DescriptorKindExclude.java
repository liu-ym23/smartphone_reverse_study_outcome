package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DescriptorKindExclude {

    public static final class NonExtensions extends DescriptorKindExclude {
        public static final NonExtensions INSTANCE = null;
        private static final int fullyExcludedDescriptorKinds = 0;

        static {
            INSTANCE = new NonExtensions();
            DescriptorKindFilter.Companion r100 = DescriptorKindFilter.Companion;
            int r101 = r100.getALL_KINDS_MASK();
            int r102 = r100.getFUNCTIONS_MASK();
            fullyExcludedDescriptorKinds = (~(r100.getVARIABLES_MASK() | r102)) & r101;
        }

        private NonExtensions() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
        public int getFullyExcludedDescriptorKinds() {
            return fullyExcludedDescriptorKinds;
        }
    }

    public static final class TopLevelPackages extends DescriptorKindExclude {
        public static final TopLevelPackages INSTANCE = null;

        static {
            INSTANCE = new TopLevelPackages();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }

        private TopLevelPackages() {
        }
    }

    public DescriptorKindExclude() {
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}
