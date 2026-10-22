package h87;

import com.bytedance.push.PushSupporter;
import com.bytedance.push.sync.SyncPushAdapter;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f484226a;

    public a(b r100) {
        this.f484226a = r100;
    }

    @Override // yf7.n
    public final void a(j.a r100) {
        b.b(this.f484226a.f484229b).getClass();
        PushSupporter.pushHandler().handlePassThroughMsg(new String(r100.f567450a), SyncPushAdapter.getSyncPush(), null);     // Catch: Throwable -> L5
        return;
    }
}
