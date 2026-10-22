package ip4;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        tt5.a.d("AttachmentCellViewHolder", "can not upload attachment by known source!!");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n() {
    }
}
