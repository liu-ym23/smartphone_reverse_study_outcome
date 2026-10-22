package tg7;

import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements IALogActiveUploadObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f545908a = null;

    static {
        f545908a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.apm.alog.IALogActiveUploadObserver
    public final void flushAlogDataToFile() {
        ALog.syncFlush();
    }
}
