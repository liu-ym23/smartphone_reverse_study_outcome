package q48;

import android.content.Intent;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.ss.alog.middleware.ALogService;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a extends ALogService {
    public static final C0012a a = null;

    /* JADX INFO: renamed from: q48.a$a, reason: collision with other inner class name */
    public static final class C0012a {
        public C0012a() {
        }
    }

    static {
        a = new C0012a();
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void bundle(int r1, String r2, Bundle r3) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void changeLevel(int r1) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void destroy() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void flush() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void forceLogSharding() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void header(int r1, String r2, String r3) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void init() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void init(String r1) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void intent(int r1, String r2, Intent r3) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void json(int r1, String r2, String r3) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void release() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void statcktrace(int r1, String r2, StackTraceElement[] r3) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void thread(int r1, String r2, Thread r3) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void throwable(int r1, String r2, Throwable r3) {
    }

    public a() {
    }

    public static final /* synthetic */ ALogService a() {
        return ALogService.sInstance;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void d(String r2, String r3) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.d(r2, r3);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r3, Throwable r4) {
        FLogger r0 = FLogger.a;
        if (r3 != null) goto L5;
        r3 = "ALogServiceImpl";
    L5:
        r0.e(r3, XmlPullParser.NO_NAMESPACE, r4);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void i(String r2, String r3) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.i(r2, r3);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void v(String r2, String r3) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.v(r2, r3);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r2, String r3) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.w(r2, r3);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r2, String r3) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.e(r2, r3);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r2, Throwable r3) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.w(r2, r3);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r2, String r3, Throwable r4) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.e(r2, r3, r4);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r2, String r3, Throwable r4) {
        FLogger r0 = FLogger.a;
        if (r2 != null) goto L5;
        r2 = "ALogServiceImpl";
    L5:
        r0.w(r2, r3, r4);
    }
}
