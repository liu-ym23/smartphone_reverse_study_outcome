package ra2;

import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupMsgView f536824a;

    public k(GroupMsgView r100) {
        this.f536824a = r100;
    }

    public final void a() {
        GroupMsgView r100 = this.f536824a;
        int r101 = r100.f140101v;
        AnimatedDrawable2 r102 = r100.f140098s;
        if (r102 == null) goto L5;
        int r103 = r102.getFrameCount() - 1;
    L6:
        if (r101 >= r103) goto L8;
        this.f536824a.f140101v++;
    L9:
        GroupMsgView r104 = this.f536824a;
        AnimatedDrawable2 r105 = r104.f140098s;
        if (r105 == null) goto L12;
        r105.jumpToFrame(r104.f140101v);
    L12:
        GroupMsgView r106 = this.f536824a;
        r106.postDelayed(r106.f140100u, r106.f140099t);
        return;
    L8:
        this.f536824a.f140101v = 0;
        goto L9
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
