package z1a;

import com.larus.utils.logger.FLogger;
import com.ss.android.update.OnUpdateStatusChangedListener;

/* JADX INFO: loaded from: classes31.dex */
public final class j implements OnUpdateStatusChangedListener {
    public j() {
    }

    @Override // yhc.i
    public final void b(boolean r100) {
        FLogger.f375446a.i("update_sdk", "onPrepare pre:" + r100);
    }

    @Override // com.ss.android.update.OnUpdateStatusChangedListener
    public final void c(int r100) {
        FLogger.f375446a.i("update_sdk", "onUpdateStatusChanged status:" + r100);
    }

    @Override // yhc.i
    public final void a(boolean r100, boolean r101) {
        FLogger.f375446a.i("update_sdk", "downloadResult isSuccess:" + r100 + ",pre:" + r101);
    }

    @Override // yhc.i
    public final void e(int r100, boolean r101) {
        FLogger.f375446a.i("update_sdk", "saveDownloadInfo etag:,pre:" + r101);
    }

    @Override // yhc.i
    public final void d(int r100, int r101, boolean r102) {
        FLogger.f375446a.d("update_sdk", "updateProgress byteSoFar:" + r100 + ",contentLength:" + r101 + ",pre:" + r102);
    }
}
