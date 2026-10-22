package com.larus.utils.logger;

import android.util.EventsUtils;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\n\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017H\u0016J&\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00112\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010!H\u0016J2\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00112 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010$H\u0016J6\u0010&\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010!H\u0016J\u001a\u0010*\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010+\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010.\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006/"}, d2 = {"Lcom/larus/utils/logger/FLogger;", "Lcom/larus/utils/logger/ILogger;", "<init>", "()V", "impl", "spiImpl", "getSpiImpl", "()Lcom/larus/utils/logger/ILogger;", "spiImpl$delegate", "Lkotlin/Lazy;", "setLogger", XmlPullParser.NO_NAMESPACE, "logger", "getImpl", "isDebug", XmlPullParser.NO_NAMESPACE, "getDirPath", XmlPullParser.NO_NAMESPACE, "isInitSuccess", "v", "tag", "msg", "message", "Lkotlin/Function0;", "d", "i", "w", "tr", XmlPullParser.NO_NAMESPACE, "e", "uploadAllLog", "scene", "unit", "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", XmlPullParser.NO_NAMESPACE, "uploadALog", "startTime", XmlPullParser.NO_NAMESPACE, "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class FLogger implements ILogger {
    public static final FLogger a = null;
    public static final Lazy b = null;

    private FLogger() {
    }

    static {
        a = new FLogger();
        b = LazyKt.lazy(new a());
    }

    public static ILogger l() {
        return (ILogger) b.getValue();
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean a() {
        ILogger r0 = l();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.larus.utils.logger.ILogger
    public final String getDirPath() {
        ILogger r0 = l();
        if (r0 == null) goto L6;
        String r1 = r0.getDirPath();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean isDebug() {
        ILogger r0 = l();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDebug();
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void f(String r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void g(String r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void h(String r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.h(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.j(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void uploadAllLog(String r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.uploadAllLog(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.v(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r2, Function3<? super Boolean, ? super Integer, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void b(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.b(r2, r3, r4);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void c(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.c(r2, r3, r4);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r2, Throwable r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.d(r2, r3, r4);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.e(r2, r3, r4);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ILogger r0 = l();
        if (r0 == null) goto L6;
        r0.w(r2, r3, r4);
        return;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void k(String r9, long r10, long r12, Function1<? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        ILogger r1 = l();
        if (r1 == null) goto L6;
        r1.k(r9, r10, r12, r14);
        return;
    }
}
