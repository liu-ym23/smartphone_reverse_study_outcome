package ni9;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements ILogProtocol {
    public a() {
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void destroy() {
        ALog.destroy();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void flush() {
        ALog.flush();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void forceLogSharding() {
        ALog.forceLogSharding();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void release() {
        ALog.release();
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void changeLevel(int r100) {
        ALog.changeLevel(r100);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void d(String r100, String r101) {
        ALog.d(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void e(String r100, String r101) {
        ALog.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void i(String r100, String r101) {
        ALog.i(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void v(String r100, String r101) {
        ALog.v(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void w(String r100, String r101) {
        ALog.w(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void e(String r100, Throwable r101) {
        ALog.e(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void w(String r100, Throwable r101) {
        ALog.w(r100, r101);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void bundle(int r100, String r101, Bundle r102) {
        ALog.bundle(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void e(String r100, String r101, Throwable r102) {
        ALog.e(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void header(int r100, String r101, String r102) {
        ALog.header(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void intent(int r100, String r101, Intent r102) {
        ALog.intent(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void json(int r100, String r101, String r102) {
        ALog.json(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void stacktrace(int r100, String r101, StackTraceElement[] r102) {
        ALog.stacktrace(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void thread(int r100, String r101, Thread r102) {
        ALog.thread(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void throwable(int r100, String r101, Throwable r102) {
        ALog.throwable(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void w(String r100, String r101, Throwable r102) {
        ALog.w(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.saas.middleware.alog.ILogProtocol
    public final void throwable(int r100, String r101, String r102, Throwable r103) {
        ALog.throwable(r100, r101, r103);
    }
}
