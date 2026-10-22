package dagger.internal;

import dagger.MembersInjector;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final class MembersInjectors {

    public static final enum NoOpMembersInjector extends Enum<NoOpMembersInjector> implements MembersInjector<Object> {
        private static final /* synthetic */ NoOpMembersInjector[] $VALUES = null;
        public static final NoOpMembersInjector INSTANCE = null;

        private static /* synthetic */ NoOpMembersInjector[] $values() {
            return new NoOpMembersInjector[]{INSTANCE};
        }

        static {
            INSTANCE = new NoOpMembersInjector("INSTANCE", 0);
            $VALUES = $values();
        }

        public static NoOpMembersInjector[] values() {
            return (NoOpMembersInjector[]) $VALUES.clone();
        }

        public static NoOpMembersInjector valueOf(String r100) {
            return (NoOpMembersInjector) a.a(NoOpMembersInjector.class, r100);
        }

        @Override // dagger.MembersInjector
        public void injectMembers(Object r100) {
            Preconditions.checkNotNull(r100, "Cannot inject members into a null reference");
        }

        private NoOpMembersInjector(String r100, int r101) {
            super(r100, r101);
        }
    }

    private MembersInjectors() {
    }

    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }
}
