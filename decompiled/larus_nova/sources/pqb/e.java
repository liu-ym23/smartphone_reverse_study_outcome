package pqb;

import android.text.TextUtils;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.lark.log.LogLevel;
import com.ss.ttm.player.MediaPlayer;
import com.suite.lark.component.logger.dynamic.DynamicLogFilterProvider;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends com.ss.android.lark.log.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f530322a;

    public static final class a {
    }

    static {
    }

    public e(com.ss.android.lark.log.f r100) {
        Intrinsics.checkNotNullParameter(r100, "logConfig");
        b.a r101 = b.f530315a;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "logConfig");     // Catch: Throwable -> L24
        if (b.f530316b == null) goto L8;
        monitor-exit(r101);
        return;
    L8:
        b.f530316b = new b();     // Catch: Throwable -> L24
        b.f530317c = r100;     // Catch: Throwable -> L24
        if (r100.f431395k == true) goto L12;
        monitor-exit(r101);
        return;
    L12:
        boolean r102 = r100.f431388d;     // Catch: Throwable -> L24
        if (r102 == true) goto L18;
        int r103 = c.f530319b;     // Catch: Throwable -> L24
        c r104 = c.b.f530321a;     // Catch: Throwable -> L24
        r104.getClass();     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r100, "logConfig");     // Catch: Throwable -> L24
        if (r104.f530320a == true) goto L18;
        Lazy r105 = DynamicLogFilterProvider.f460158a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r100, "logConfig");     // Catch: Throwable -> L24
        r104.f530320a = true;     // Catch: Throwable -> L24
    L18:
        String r106 = d.a(r100);     // Catch: Throwable -> L24
        ALogConfig.b r107 = new ALogConfig.b(r100.f431385a);     // Catch: Throwable -> L24
        r107.f406444d = r106;     // Catch: Throwable -> L24
        r107.f406442b = MediaPlayer.MEDIA_INFO_SOCKET_CONNECTRED;     // Catch: Throwable -> L24
        r107.f406443c = 2097152;     // Catch: Throwable -> L24
        r107.f406445e = true;     // Catch: Throwable -> L24
        r107.f406446f = true;     // Catch: Throwable -> L24
        r107.f406447g = true;     // Catch: Throwable -> L24
        ALogConfig r108 = r107.a();     // Catch: Throwable -> L24
        ALog.setDebug(r102);     // Catch: Throwable -> L24
        if (r100.f431386b != 4) goto L21;
        ALog.setILogCacheCallback(pqb.a.f530314a);     // Catch: Throwable -> L24
    L21:
        ALog.init(r108);     // Catch: Throwable -> L24
        monitor-exit(r101);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void d(String r100, String r101) {
        b.a r102 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.a(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void e(String r100, String r101) {
        b.a r102 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.b(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void i(String r100, String r101) {
        b.a r102 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.d(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void v(String r100, String r101) {
        b.a r102 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.f(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void w(String r100, String r101) {
        b.a r102 = b.f530315a;
        if (b.f530316b != null) goto L5;
        return;
    L5:
        if (b.c(r100, r101, 5) == false) goto L9;
        ALog.w(b.e(r100), r101);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void wtf(String r100, String r101) {
        b.a r102 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.b(r100, r101);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void a(String r100, String r101, String r102) {
        String r103 = "msg: " + r101 + ", jsonContent: " + r102;
        b.a r104 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.d(r100, r103);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void c(String r100, String r101, String r102) {
        String r103 = "msg: " + r101 + ", xmlContent: " + r102;
        b.a r104 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.d(r100, r103);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void d(String r100, String r101, Throwable r102) {
        String r103 = "msg: " + r101 + ", tr: " + r102;
        b.a r104 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.a(r100, r103);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void e(String r100, String r101, Throwable r102) {
        b.a r103 = b.f530315a;
        if (b.f530316b != null) goto L5;
        return;
    L5:
        if (b.c(r100, r101, 6) == false) goto L9;
        ALog.e(b.e(r100), r101, r102);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void i(String r100, String r101, Throwable r102) {
        String r103 = "msg: " + r101 + ", tr: " + r102;
        b.a r104 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.d(r100, r103);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void v(String r100, String r101, Throwable r102) {
        String r103 = "msg: " + r101 + ", tr: " + r102;
        b.a r104 = b.f530315a;
        if (b.f530316b == null) goto L6;
        b.f(r100, r103);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void w(String r100, String r101, Throwable r102) {
        b.a r103 = b.f530315a;
        if (b.f530316b != null) goto L5;
        return;
    L5:
        if (b.c(r100, r101, 5) == false) goto L9;
        ALog.w(b.e(r100), r101, r102);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void wtf(String r100, String r101, Throwable r102) {
        b.a r103 = b.f530315a;
        if (b.f530316b != null) goto L5;
        return;
    L5:
        if (b.c(r100, r101, 6) == false) goto L9;
        ALog.e(b.e(r100), r101, r102);
        return;
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void b(int r100, String r101, String[] r102, String r103, Map<String, String> r104) {
        if (r102 != null) goto L4;
        String r105 = "";
    L5:
        String r106 = "logId: " + r101 + ", msg: " + r103 + ", extras: ";
        if (r104 == null) goto L12;
        Iterator<Map.Entry<String, String>> r107 = r104.entrySet().iterator();
    L9:
        if (r107.hasNext() == false) goto L12;
        Map.Entry<String, String> r108 = r107.next();
        r106 = r106 + ' ' + r108.getKey() + ": " + r108.getValue();
    L12:
        if (r100 != LogLevel.VERBOSE.getNumber()) goto L17;
        b.a r109 = b.f530315a;
        if (b.f530316b == null) goto L40;
        b.f(r105, r106);
        return;
    L40:
        return;
    L17:
        if (r100 != LogLevel.DEBUG.getNumber()) goto L22;
        b.a r110 = b.f530315a;
        if (b.f530316b == null) goto L42;
        b.a(r105, r106);
        return;
    L42:
        return;
    L22:
        if (r100 != LogLevel.INFO.getNumber()) goto L27;
        b.a r111 = b.f530315a;
        if (b.f530316b == null) goto L44;
        b.d(r105, r106);
        return;
    L44:
        return;
    L27:
        if (r100 != LogLevel.WARN.getNumber()) goto L34;
        b.a r112 = b.f530315a;
        if (b.f530316b != null) goto L31;
        return;
    L31:
        if (b.c(r105, r106, 5) == false) goto L47;
        ALog.w(b.e(r105), r106);
        return;
    L47:
        return;
    L34:
        if (r100 != LogLevel.ERROR.getNumber()) goto L49;
        b.a r113 = b.f530315a;
        if (b.f530316b == null) goto L50;
        b.b(r105, r106);
        return;
    L50:
        return;
    L49:
        return;
    L4:
        r105 = TextUtils.join(",", r102);
        goto L5
    }
}
