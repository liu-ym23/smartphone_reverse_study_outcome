package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public interface LookupTracker {

    public static final class DO_NOTHING implements LookupTracker {
        public static final DO_NOTHING INSTANCE = null;

        static {
            INSTANCE = new DO_NOTHING();
        }

        private DO_NOTHING() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public boolean getRequiresPosition() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker
        public void record(String r100, Position r101, String r102, ScopeKind r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            Intrinsics.checkNotNullParameter(r101, "position");
            Intrinsics.checkNotNullParameter(r102, "scopeFqName");
            Intrinsics.checkNotNullParameter(r103, "scopeKind");
            Intrinsics.checkNotNullParameter(r104, "name");
        }
    }

    boolean getRequiresPosition();

    void record(String r100, Position r101, String r102, ScopeKind r103, String r104);
}
