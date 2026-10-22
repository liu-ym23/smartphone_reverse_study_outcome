package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface IoConfig extends ReadableConfig {
    public static final Config.Option<Executor> OPTION_IO_EXECUTOR = null;

    /* JADX INFO: renamed from: androidx.camera.core.internal.IoConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Executor $default$getIoExecutor(IoConfig r1) {
            return (Executor) r1.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
        }

        public static Executor $default$getIoExecutor(IoConfig r1, Executor r2) {
            return (Executor) r1.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, r2);
        }
    }

    public interface Builder<B> {
        B setIoExecutor(Executor r1);
    }

    Executor getIoExecutor();

    Executor getIoExecutor(Executor r1);

    static {
        OPTION_IO_EXECUTOR = Config.Option.create("camerax.core.io.ioExecutor", Executor.class);
    }
}
