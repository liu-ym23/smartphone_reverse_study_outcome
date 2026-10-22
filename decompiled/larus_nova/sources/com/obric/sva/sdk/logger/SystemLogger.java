package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J,\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¨\u0006\u001b"}, d2 = {"Lcom/obric/sva/sdk/logger/SystemLogger;", "Lcom/obric/sva/sdk/logger/ILogger;", "<init>", "()V", "withLogTagPrefix", "", "tag", "d", "", "msg", "e", "tr", "", "getDirPath", RXScreenCaptureService.KEY_INDEX, "isDebug", "", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "flush", BaseSwitches.V, "w", "s", "category", "Lcom/obric/sva/sdk/logger/SpecialCategory;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemLogger implements ILogger {
    public static final SystemLogger INSTANCE = null;

    static {
        INSTANCE = new SystemLogger();
    }

    private SystemLogger() {
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void flush() {
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public String getDirPath() {
        return "";
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void uploadAllLog(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    private final String withLogTagPrefix(String r100) {
        ILogger.Companion r101 = ILogger.Companion;
        if (StringsKt.startsWith$default(r100, r101.getLOG_TAG_PREFIX(), false, 2, null) == false) goto L6;
        return r100;
    L6:
        return r101.getLOG_TAG_PREFIX() + r100;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void special(String r100, SpecialCategory r101) {
        ILogger.DefaultImpls.special(this, r100, r101);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void i(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void s(String r100, String r101, SpecialCategory r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "category");
        withLogTagPrefix(r100);
        special(r101, r102);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        withLogTagPrefix(r100);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void s(String r100, String r101, Throwable r102, SpecialCategory r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r103, "category");
        withLogTagPrefix(r100);
        special(r101, r103);
    }
}
