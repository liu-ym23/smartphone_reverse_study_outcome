package com.larus.utils.logger;

import com.bytedance.crash.dumper.Scraps;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import f2a.a;
import fp9.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\n\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J&\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00112\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010!H\u0016J2\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00112 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010$H\u0016J6\u0010&\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010!H\u0016J\u001a\u0010*\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010+\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010.\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006/"}, d2 = {"Lcom/larus/utils/logger/FLogger;", "Lcom/larus/utils/logger/ILogger;", "<init>", "()V", "impl", "spiImpl", "getSpiImpl", "()Lcom/larus/utils/logger/ILogger;", "spiImpl$delegate", "Lkotlin/Lazy;", "setLogger", "", "logger", "getImpl", "isDebug", "", "getDirPath", "", "isInitSuccess", BaseSwitches.V, "tag", "msg", "message", "Lkotlin/Function0;", "d", RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", "", "uploadALog", DyPayConstant.KEY_START_TIME, "", "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FLogger implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FLogger f375446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f375447b = null;

    private FLogger() {
    }

    static {
        f375446a = new FLogger();
        f375447b = LazyKt.lazy(new a());
    }

    public static ILogger l() {
        return (ILogger) f375447b.getValue();
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean a() {
        ILogger r100 = l();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.utils.logger.ILogger
    public final String getDirPath() {
        ILogger r100 = l();
        if (r100 == null) goto L6;
        String r101 = r100.getDirPath();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean isDebug() {
        ILogger r100 = l();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isDebug();
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void f(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void g(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void h(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.j(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void uploadAllLog(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.uploadAllLog(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.v(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r100, Function3<? super Boolean, ? super Integer, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.i(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r102 = l();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r103 = l();
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r103 = l();
        if (r103 == null) goto L6;
        r103.c(r100, r101, r102);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r100, Throwable r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        ILogger r103 = l();
        if (r103 == null) goto L6;
        r103.d(r100, r101, r102);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r103 = l();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILogger r103 = l();
        if (r103 == null) goto L6;
        r103.w(r100, r101, r102);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void k(String r100, long r110, long r111, Function1<? super Boolean, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ILogger r101 = l();
        if (r101 == null) goto L6;
        r101.k(r100, r110, r111, r112);
        return;
    }
}
