package com.larus.apm.impl;

import android.util.EventsUtils;
import com.larus.utils.logger.FLogger;
import com.larus.utils.logger.ILogger;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
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
import org.xmlpull.v1.XmlPullParser;
import q48.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J$\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000eH\u0016J&\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0016J2\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00072 \u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001bH\u0016J6\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0016J\u001a\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006'"}, d2 = {"Lcom/larus/apm/impl/LoggerImpl;", "Lcom/larus/utils/logger/ILogger;", "<init>", "()V", "isDebug", XmlPullParser.NO_NAMESPACE, "getDirPath", XmlPullParser.NO_NAMESPACE, "isInitSuccess", "v", XmlPullParser.NO_NAMESPACE, "tag", "msg", "message", "Lkotlin/Function0;", "d", "i", "w", "tr", XmlPullParser.NO_NAMESPACE, "e", "uploadAllLog", "scene", "unit", "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", XmlPullParser.NO_NAMESPACE, "uploadALog", "startTime", XmlPullParser.NO_NAMESPACE, "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class LoggerImpl implements ILogger {
    public static volatile boolean a;

    public static final class a {
    }

    static {
    }

    public LoggerImpl() {
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean a() {
        boolean r0 = k.a;
        return ALog.isInitSuccess();
    }

    @Override // com.larus.utils.logger.ILogger
    public final String getDirPath() {
        boolean r0 = k.a;
        ALogConfig r1 = ALog.sConfig;
        if (r1 == null) goto L6;
        String r2 = r1.getLogDirPath();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.larus.utils.logger.ILogger
    public final boolean isDebug() {
        boolean r0 = k.a;
        return k.a;
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        k.b(r2, r3);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r14, Function3<? super Boolean, ? super Integer, ? super String, Unit> r15) {
        Intrinsics.checkNotNullParameter(r14, "scene");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r14, "scene");
        k.b("Logger", "uploadALogData: called");
        long r0 = System.currentTimeMillis();
        long r2 = EventsUtils.FEAT_TYPE_SHUT_DOWN;
        k.f(r14, (r0 / r2) - ((long) 10800), System.currentTimeMillis() / r2, null, r15);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void f(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        String r5 = r4.invoke();
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(5, r3, r5, null);
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = XmlPullParser.NO_NAMESPACE;
    L7:
        ALog.w(r3, r5);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void g(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        if (a == false) goto L9;
        boolean r0 = k.a;
        if (3 < k.b) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L9;
        return;
    L7:
        r1 = false;
    L9:
        boolean r2 = k.a;
        k.b(r3, r4.invoke());
    }

    @Override // com.larus.utils.logger.ILogger
    public final void h(String r3, Function0<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        String r5 = r4.invoke();
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(6, r3, r5, null);
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = XmlPullParser.NO_NAMESPACE;
    L7:
        ALog.e(r3, r5);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r2, Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "message");
        k.d(r2, r3.invoke());
    }

    @Override // com.larus.utils.logger.ILogger
    public final void j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Map<String, b> r0 = bu7.a.a;
        if (r3 != null) goto L5;
        r3 = XmlPullParser.NO_NAMESPACE;
    L5:
        bu7.a.b(r3, r2);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void uploadAllLog(String r14, Function1<? super Boolean, Unit> r15) {
        Intrinsics.checkNotNullParameter(r14, "scene");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r14, "scene");
        k.b("Logger", "uploadALogData: called");
        long r0 = System.currentTimeMillis();
        long r2 = EventsUtils.FEAT_TYPE_SHUT_DOWN;
        k.f(r14, (r0 / r2) - ((long) 10800), System.currentTimeMillis() / r2, r15, null);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void v(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(2, r3, r4, null);
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = XmlPullParser.NO_NAMESPACE;
    L7:
        ALog.v(r3, r4);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(5, r3, r4, null);
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = XmlPullParser.NO_NAMESPACE;
    L7:
        ALog.w(r3, r4);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(6, r3, r4, null);
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = XmlPullParser.NO_NAMESPACE;
    L7:
        ALog.e(r3, r4);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        k.d(r2, r3);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(5, r3, null, r4);
        return;
    L5:
        ALog.w(r3, XmlPullParser.NO_NAMESPACE, r4);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void b(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Map<String, b> r0 = bu7.a.a;
        if (r5 != null) goto L5;
        r5 = XmlPullParser.NO_NAMESPACE;
    L5:
        if (r6 != null) goto L7;
        r6 = XmlPullParser.NO_NAMESPACE;
    L7:
        Intrinsics.checkNotNullParameter(r5, "sceneName");
        Intrinsics.checkNotNullParameter(r6, "uniqId");
        Intrinsics.checkNotNullParameter(r4, "extra");
        FLogger.a.i("Performance-infra", bu7.a.a(r5, -1, r4).toString());
        Map<String, b> r7 = bu7.a.a;
        if (r7.size() <= 30) goto L10;
        ((LinkedHashMap) r7).clear();
    L10:
        r7.put(r6, new b(r5, System.currentTimeMillis()));
    }

    @Override // com.larus.utils.logger.ILogger
    public final void c(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "tag");
        Map<String, b> r0 = bu7.a.a;
        if (r9 != null) goto L5;
        r9 = XmlPullParser.NO_NAMESPACE;
    L5:
        if (r10 != null) goto L7;
        r10 = XmlPullParser.NO_NAMESPACE;
    L7:
        Intrinsics.checkNotNullParameter(r9, "sceneName");
        Intrinsics.checkNotNullParameter(r10, "uniqId");
        Intrinsics.checkNotNullParameter(r8, "extra");
        Map<String, b> r1 = bu7.a.a;
        b r2 = (b) ((LinkedHashMap) r1).get(r10);
        FLogger r3 = FLogger.a;
        long r4 = System.currentTimeMillis();
        if (r2 == null) goto L10;
        long r5 = r2.b;
    L11:
        r3.i("Performance-infra", bu7.a.a(r9, r4 - r5, r8).toString());
        r1.remove(r10);
        return;
    L10:
        r5 = -1;
        goto L11
    }

    @Override // com.larus.utils.logger.ILogger
    public final void d(String r2, Throwable r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        k.c(r2, (String) r4.invoke(), r3);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        k.c(r2, r3, r4);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void w(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (k.c == true) goto L5;
        k.a(5, r3, r4, r5);
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = XmlPullParser.NO_NAMESPACE;
    L7:
        ALog.w(r3, r4, r5);
    }

    @Override // com.larus.utils.logger.ILogger
    public final void k(String r10, long r11, long r13, Function1<? super Boolean, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        boolean r1 = k.a;
        Intrinsics.checkNotNullParameter(r10, "scene");
        k.f(r10, r11, r13, r15, null);
    }
}
