package e;

import com.obric.eventkit.logger.ILogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470631a = null;

    static {
        f470631a = new a();
    }

    public a() {
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final boolean isDebug() {
        return false;
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    @Override // com.obric.eventkit.logger.ILogger
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }
}
