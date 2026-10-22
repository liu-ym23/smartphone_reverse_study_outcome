package ml1;

import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSInputPanelLayout f514356a;

    public b(VSInputPanelLayout r100) {
        this.f514356a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UtilityKotlinExtentionsKt.h(this.f514356a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
