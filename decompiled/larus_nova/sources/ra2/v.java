package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536835a;

    public v(MatchHotMsgView r100) {
        this.f536835a = r100;
    }

    public final void a() {
        MatchHotMsgView r100 = this.f536835a;
        int r101 = r100.f140140v;
        AnimatedDrawable2 r102 = r100.f140136r;
        if (r102 == null) goto L5;
        int r103 = r102.getFrameCount() - 1;
    L6:
        if (r101 >= r103) goto L8;
        this.f536835a.f140140v++;
    L8:
        MatchHotMsgView r104 = this.f536835a;
        AnimatedDrawable2 r105 = r104.f140136r;
        if (r105 == null) goto L11;
        r105.jumpToFrame(r104.f140140v);
    L11:
        MatchHotMsgView r106 = this.f536835a;
        r106.postDelayed(r106.f140134p, r106.f140138t);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
