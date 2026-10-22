package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* JADX INFO: loaded from: classes42.dex */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = null;
    private static final Lazy<DefaultBuiltIns> Instance$delegate = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final DefaultBuiltIns getInstance() {
            return (DefaultBuiltIns) DefaultBuiltIns.access$getInstance$delegate$cp().getValue();
        }
    }

    public DefaultBuiltIns() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ DefaultBuiltIns accessor$DefaultBuiltIns$lambda0() {
        return Instance_delegate$lambda$0();
    }

    static {
        Companion = new Companion(null);
        Instance$delegate = LazyKt.lazy(DefaultBuiltIns$$Lambda$0.INSTANCE);
    }

    private static final DefaultBuiltIns Instance_delegate$lambda$0() {
        boolean r100 = false;
        return new DefaultBuiltIns(r100, 1, null);
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return Instance$delegate;
    }

    public DefaultBuiltIns(boolean r100) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (r100 == false) goto L6;
        createBuiltInsModule(false);
        return;
    }

    public /* synthetic */ DefaultBuiltIns(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }
}
