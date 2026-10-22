package com.obric.capabilitykit.logger;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wia.z;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0001H\u0002J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0001J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/logger/Logger;", "Lcom/obric/capabilitykit/logger/ILogger;", "()V", "impl", "d", "", "tag", "", "msg", "e", "tr", "", "getImpl", RXScreenCaptureService.KEY_INDEX, "isDebug", "", "normalizeTag", "setLogger", "logger", BaseSwitches.V, "w", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Logger implements ILogger {
    public static final Logger INSTANCE = null;
    private static ILogger impl;

    static {
        INSTANCE = new Logger();
    }

    private Logger() {
    }

    private final ILogger getImpl() {
        ILogger r100 = impl;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return z.f559913a;
    }

    private final String normalizeTag(String r100) {
        return "ac_" + r100;
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().d(normalizeTag(r100), r101);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().e(normalizeTag(r100), r101);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().e(normalizeTag(r100), r101, r102);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().i(normalizeTag(r100), r101);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public boolean isDebug() {
        return getImpl().isDebug();
    }

    public final void setLogger(ILogger r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        impl = r100;
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (isDebug() == true) goto L5;
        return;
    L5:
        getImpl().v(normalizeTag(r100), r101);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().w(normalizeTag(r100), r101);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().w(normalizeTag(r100), r101, r102);
    }

    @Override // com.obric.capabilitykit.logger.ILogger
    public void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().w(normalizeTag(r100), r101);
    }
}
