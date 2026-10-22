package q48;

import android.content.Intent;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.ss.alog.middleware.ALogService;

/* JADX INFO: loaded from: classes.dex */
public final class a extends ALogService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C7278a f531677a = null;

    /* JADX INFO: renamed from: q48.a$a, reason: collision with other inner class name */
    public static final class C7278a {
        public C7278a() {
        }
    }

    static {
        f531677a = new C7278a();
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void bundle(int r100, String r101, Bundle r102) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void changeLevel(int r100) {
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
    public final void header(int r100, String r101, String r102) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void init() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void init(String r100) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void intent(int r100, String r101, Intent r102) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void json(int r100, String r101, String r102) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void release() {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void statcktrace(int r100, String r101, StackTraceElement[] r102) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void thread(int r100, String r101, Thread r102) {
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void throwable(int r100, String r101, Throwable r102) {
    }

    public a() {
    }

    public static final /* synthetic */ ALogService a() {
        return ALogService.sInstance;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void d(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.d(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r100, Throwable r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.e(r100, "", r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void i(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.i(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void v(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.v(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.w(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.e(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r100, Throwable r101) {
        FLogger r102 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r102.w(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r100, String r101, Throwable r102) {
        FLogger r103 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r103.e(r100, r101, r102);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r100, String r101, Throwable r102) {
        FLogger r103 = FLogger.f375446a;
        if (r100 != null) goto L5;
        r100 = "ALogServiceImpl";
    L5:
        r103.w(r100, r101, r102);
    }
}
