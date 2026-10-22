package ra2;

import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfrontMsgView f536819a;

    public f(ConfrontMsgView r100) {
        this.f536819a = r100;
    }

    public final void a() {
        ConfrontMsgView r100 = this.f536819a;
        r100.getClass();
        PriorityBlockingQueue<g3> r101 = b.f536812a;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L6:
        PriorityBlockingQueue<g3> r103 = b.f536813b;
        if (r103 != null) goto L9;
    L11:
        r102 = false;
    L12:
        if (r102 == false) goto L29;
        PriorityBlockingQueue<g3> r104 = b.f536812a;
        g3 r105 = null;
        if (r104 == null) goto L16;
        g3 r106 = r104.poll();
    L17:
        if (r106 == null) goto L21;
        b.f536814c = r106;
        GroupMsgView r107 = r100.f140061b;
        if (r107 == null) goto L21;
        r107.g(Long.valueOf(r106.getCount()), m.a.a(r100));
    L21:
        PriorityBlockingQueue<g3> r108 = b.f536813b;
        if (r108 == null) goto L24;
        r105 = r108.poll();
    L24:
        if (r105 == null) goto L28;
        b.f536815d = r105;
        GroupMsgView r109 = r100.f140062c;
        if (r109 == null) goto L28;
        r109.g(Long.valueOf(r105.getCount()), m.a.a(r100));
    L28:
        r100.b();
        goto L29
    L16:
        r106 = null;
    L29:
        ConfrontMsgView r110 = this.f536819a;
        r110.postDelayed(r110.f140069j, r110.f140079t);
        return;
    L9:
        if ((!r103.isEmpty()) != true) goto L11;
    L5:
        if ((!r101.isEmpty()) == true) goto L12;
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
