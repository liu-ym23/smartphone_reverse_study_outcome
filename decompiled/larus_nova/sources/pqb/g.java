package pqb;

import android.content.Intent;
import android.os.Bundle;
import com.ss.alog.middleware.ALogService;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends ALogService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530323a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        f530323a = new a();
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

    public g() {
    }

    public static final /* synthetic */ ALogService a() {
        return ALogService.sInstance;
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void d(String r100, String r101) {
        Log.d(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r100, String r101) {
        Log.e(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void i(String r100, String r101) {
        Log.i(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void v(String r100, String r101) {
        Log.v(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r100, String r101) {
        Log.w(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r100, Throwable r101) {
        Log.e(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r100, Throwable r101) {
        Log.w(r100, r101);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void e(String r100, String r101, Throwable r102) {
        Log.e(r100, r101, r102);
    }

    @Override // com.ss.alog.middleware.IALogProtocol
    public final void w(String r100, String r101, Throwable r102) {
        Log.w(r100, r101, r102);
    }
}
