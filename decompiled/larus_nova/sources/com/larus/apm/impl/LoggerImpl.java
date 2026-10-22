package com.larus.apm.impl;

import com.bytedance.crash.dumper.Scraps;
import com.larus.utils.logger.FLogger;
import com.larus.utils.logger.ILogger;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import eu7.b;
import fp9.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import q48.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0016J2\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00072 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001bH\u0016J6\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0016J\u001a\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006'"}, d2 = {"Lcom/larus/apm/impl/LoggerImpl;", "Lcom/larus/utils/logger/ILogger;", "<init>", "()V", "isDebug", "", "getDirPath", "", "isInitSuccess", BaseSwitches.V, "", "tag", "msg", "message", "Lkotlin/Function0;", "d", RXScreenCaptureService.KEY_INDEX, "w", "tr", "", "e", "uploadAllLog", "scene", Scraps.INNER_UNIT, "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", "", "uploadALog", DyPayConstant.KEY_START_TIME, "", "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoggerImpl implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f286961a;

    public static final class a {
    }

    static {
    }

    public LoggerImpl() {
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean a() {
        boolean r100 = k.f531692a;
        return ALog.isInitSuccess();
    }

    @Override // com.larus.utils.logger.ILogger
    public final String getDirPath() {
        boolean r100 = k.f531692a;
        ALogConfig r101 = ALog.sConfig;
        if (r101 == null) goto L6;
        String r102 = r101.getLogDirPath();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean isDebug() {
        boolean r100 = k.f531692a;
        return k.f531692a;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        k.b(r100, r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r110, Function3<? super Boolean, ? super Integer, ? super String, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        boolean r100 = k.f531692a;
        Intrinsics.checkNotNullParameter(r110, "scene");
        k.b("Logger", "uploadALogData: called");
        long r101 = 1000;
        k.f(r110, (System.currentTimeMillis() / r101) - ((long) 10800), System.currentTimeMillis() / r101, null, r111);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void f(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = r101.invoke();
        boolean r103 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(5, r100, r102, null);
        return;
    L5:
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        ALog.w(r100, r102);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void g(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (f286961a == false) goto L9;
        boolean r102 = k.f531692a;
        if (3 < k.f531693b) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L9;
        return;
    L7:
        r103 = false;
    L9:
        boolean r104 = k.f531692a;
        k.b(r100, r101.invoke());
    }

    @Override // com.larus.utils.logger.ILogger
    public final void h(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        String r102 = r101.invoke();
        boolean r103 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(6, r100, r102, null);
        return;
    L5:
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        ALog.e(r100, r102);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        k.d(r100, r101.invoke());
    }

    @Override // com.larus.utils.logger.ILogger
    public final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Map<String, b> r102 = bu7.a.f20745a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        bu7.a.b(r101, r100);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void uploadAllLog(String r110, Function1<? super Boolean, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        boolean r100 = k.f531692a;
        Intrinsics.checkNotNullParameter(r110, "scene");
        k.b("Logger", "uploadALogData: called");
        long r101 = 1000;
        k.f(r110, (System.currentTimeMillis() / r101) - ((long) 10800), System.currentTimeMillis() / r101, r111, null);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        boolean r102 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(2, r100, r101, null);
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        ALog.v(r100, r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        boolean r102 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(5, r100, r101, null);
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        ALog.w(r100, r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        boolean r102 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(6, r100, r101, null);
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        ALog.e(r100, r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        k.d(r100, r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        boolean r102 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(5, r100, null, r101);
        return;
    L5:
        ALog.w(r100, "", r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Map<String, b> r103 = bu7.a.f20745a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        Intrinsics.checkNotNullParameter(r101, "sceneName");
        Intrinsics.checkNotNullParameter(r102, "uniqId");
        Intrinsics.checkNotNullParameter(r100, "extra");
        FLogger.f375446a.i("Performance-infra", bu7.a.a(r101, -1, r100).toString());
        Map<String, b> r104 = bu7.a.f20745a;
        if (r104.size() <= 30) goto L10;
        ((LinkedHashMap) r104).clear();
    L10:
        r104.put(r102, new b(r101, System.currentTimeMillis()));
    }

    @Override // com.larus.utils.logger.ILogger
    public final void c(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Map<String, b> r102 = bu7.a.f20745a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        if (r110 != null) goto L7;
        r110 = "";
    L7:
        Intrinsics.checkNotNullParameter(r101, "sceneName");
        Intrinsics.checkNotNullParameter(r110, "uniqId");
        Intrinsics.checkNotNullParameter(r100, "extra");
        Map<String, b> r103 = bu7.a.f20745a;
        b r104 = (b) ((LinkedHashMap) r103).get(r110);
        FLogger r105 = FLogger.f375446a;
        long r106 = System.currentTimeMillis();
        if (r104 == null) goto L10;
        long r107 = r104.f474094b;
    L11:
        r105.i("Performance-infra", bu7.a.a(r101, r106 - r107, r100).toString());
        r103.remove(r110);
        return;
    L10:
        r107 = -1;
        goto L11
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r100, Throwable r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        k.c(r100, (String) r102.invoke(), r101);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        k.c(r100, r101, r102);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        boolean r103 = k.f531692a;
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (k.f531694c == true) goto L5;
        k.a(5, r100, r101, r102);
        return;
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        ALog.w(r100, r101, r102);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void k(String r110, long r111, long r112, Function1<? super Boolean, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        boolean r100 = k.f531692a;
        Intrinsics.checkNotNullParameter(r110, "scene");
        k.f(r110, r111, r112, r113, null);
    }
}
