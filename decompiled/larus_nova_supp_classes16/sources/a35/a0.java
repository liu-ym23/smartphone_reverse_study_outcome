package a35;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0 extends Handler {
    public final /* synthetic */ y a;

    @Override // android.os.Handler
    public final void handleMessage(Message r7) {
        if (r7.what != 1) goto L19;
        if (this.a.d == true) goto L19;
        String r0 = d25.d.e;
        List<String> r1 = d25.d.c;
        y r3 = this.a;
        if (r3.r == true) goto L9;
    L17:
        com.bytedance.ee.util.ui.m.a(new z());
        tt5.a.h("SyncOfflineDataManager", "MSG_HANDLE_SYNC_DOC  size: " + this.a.g.size() + "   appIsVisible: " + ((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a() + "   mIsConnected: " + this.a.r);
    L23:
        super.handleMessage(r7);
        return;
    L9:
        if (r3.g.isEmpty() == true) goto L17;
        if (((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a() == false) goto L17;
        y r4 = this.a;     // Catch: Exception -> L15
        y.b(r4, r0, r1, (OfflineDoc) ListProtector.get(r4.g, 0));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        this.a.d = false;
        tt5.a.f("SyncOfflineDataManager", e, false);
    L19:
        if (r7.what != 2) goto L23;
        tt5.a.h("SyncOfflineDataManager", "MSG_RETRY  mUploadOfflineDocList: " + this.a.g.size() + "   mNeedSyncTokens: " + ((CopyOnWriteArrayList) this.a.j).size());
        if (((CopyOnWriteArrayList) this.a.j).size() <= 0) goto L23;
        y.c(this.a);
        goto L23
    }

    public a0(y r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
