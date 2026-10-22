package wia;

import com.obric.capabilitykit.logger.ILogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class z implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f559913a = null;

    static {
        f559913a = new z();
    }

    public z() {
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final boolean isDebug() {
        return false;
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }
}
