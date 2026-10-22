package ds1;

import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSChorusConcertWidget f469833a;

    public a(VSChorusConcertWidget r100) {
        this.f469833a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PlayerProgressServiceContext r100 = this.f469833a.f119338h;     // Catch: Throwable -> L8
        if (r100 == null) goto L11;
        m<Boolean> r101 = r100.getDisableSeek();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.setValue(Boolean.TRUE);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
