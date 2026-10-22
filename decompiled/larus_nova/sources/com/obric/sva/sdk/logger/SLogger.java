package com.obric.sva.sdk.logger;

import com.bytedance.crash.dumper.Scraps;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J,\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00122\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/obric/sva/sdk/logger/SLogger;", "Lcom/obric/sva/sdk/logger/ILogger;", "<init>", "()V", "spiImpl", "Lcom/obric/sva/sdk/logger/LoggerImpl;", "getSpiImpl", "()Lcom/obric/sva/sdk/logger/LoggerImpl;", "spiImpl$delegate", "Lkotlin/Lazy;", "outputAll", "", "getOutputAll", "()Z", "outputAll$delegate", "getImpl", "isDebug", "getDirPath", "", BaseSwitches.V, "", "tag", "msg", "d", RXScreenCaptureService.KEY_INDEX, "tr", "", "w", "e", "s", "category", "Lcom/obric/sva/sdk/logger/SpecialCategory;", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "flush", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SLogger implements ILogger {
    public static final SLogger INSTANCE = null;
    private static final Lazy outputAll$delegate = null;
    private static final Lazy spiImpl$delegate = null;

    private SLogger() {
    }

    public static /* synthetic */ LoggerImpl a() {
        return spiImpl_delegate$lambda$0();
    }

    public static /* synthetic */ boolean b() {
        return outputAll_delegate$lambda$1();
    }

    private static final boolean outputAll_delegate$lambda$1() {
        return false;
    }

    static {
        INSTANCE = new SLogger();
        spiImpl$delegate = LazyKt.lazy(new c());
        outputAll$delegate = LazyKt.lazy(new d());
    }

    private final boolean getOutputAll() {
        return ((Boolean) outputAll$delegate.getValue()).booleanValue();
    }

    private final LoggerImpl getSpiImpl() {
        return (LoggerImpl) spiImpl$delegate.getValue();
    }

    private static final LoggerImpl spiImpl_delegate$lambda$0() {
        return new LoggerImpl();
    }

    private final LoggerImpl getImpl() {
        return getSpiImpl();
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void flush() {
        getImpl().flush();
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public String getDirPath() {
        return getImpl().getDirPath();
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public boolean isDebug() {
        return getImpl().isDebug();
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().d(r100, r101);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.d(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().e(r100, r101);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.e(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().i(r100, r101);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.i(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void special(String r100, SpecialCategory r101) {
        ILogger.DefaultImpls.special(this, r100, r101);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void uploadAllLog(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        getImpl().uploadAllLog(r100, r101);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().v(r100, r101);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.v(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().w(r100, r101);
        if (getOutputAll() == false) goto L10;
        SystemLogger r102 = SystemLogger.INSTANCE;
        if (r101 == null) goto L7;
        String r103 = r101.getMessage();
    L8:
        r102.w(r100, r103);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().w(r100, r101);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.w(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().e(r100, r101, r102);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.e(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void i(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().i(r100, r101, r102);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.i(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void s(String r100, String r101, SpecialCategory r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "category");
        getImpl().i(r100, r101);
        if (getOutputAll() == false) goto L5;
        SystemLogger.INSTANCE.i(r100, r101);
    L5:
        special(r101, r102);
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        getImpl().w(r100, r101, r102);
        if (getOutputAll() == false) goto L6;
        SystemLogger.INSTANCE.w(r100, r101);
        return;
    }

    @Override // com.obric.sva.sdk.logger.ILogger
    public void s(String r100, String r101, Throwable r102, SpecialCategory r103) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r103, "category");
        getImpl().i(r100, r101, r102);
        if (getOutputAll() == false) goto L5;
        SystemLogger.INSTANCE.i(r100, r101);
    L5:
        special(r101, r103);
    }
}
