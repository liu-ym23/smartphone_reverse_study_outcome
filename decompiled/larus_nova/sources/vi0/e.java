package vi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import jc1.k;
import rj0.l;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f555010a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f555011a;

        public a(e r100) {
            this.f555011a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            ALogger.i("MultiLinkRoomUtils", "leaveMultiLinkRoom, linkPlayerState onChanged: " + ((Integer) r100));
            if (hd0.c.f().h() == true) goto L6;
            ALogger.i("MultiLinkRoomUtils", "leaveMultiLinkRoom success");
            MainThreadPostUtils.c(new d(this), 1000);
            hd0.c.f().e(c.f555008a);
            c.f555008a = null;
            return;
        }
    }

    public e(com.bytedance.android.live.liveinteract.revenue.guestlink.f r100) {
        this.f555010a = r100;
    }

    public final void a() {
        boolean r100 = hd0.c.f().h();
        ALogger.i("MultiLinkRoomUtils", "leaveMultiLinkRoom, isGuest: " + r100);
        if (r100 == false) goto L14;
        c.f555008a = new a(this);
        hd0.c.f().c(c.f555008a);
        int r101 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
        if (v.a(r101, 32) == false) goto L10;
        l.f537955n2.getClass();
        l r102 = l.a.a();
        if (r102 == null) goto L18;
        l.b.d(r102, 205, false, false, 8);
        return;
    L18:
        return;
    L10:
        if (v.a(r101, 8) == false) goto L20;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r103 = IVoiceChatGuestService.a.a();
        if (r103 == null) goto L21;
        IVoiceChatGuestService.b.b(r103, 205, false, false, false, 16);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        c.a r104 = this.f555010a;
        if (r104 == null) goto L23;
        r104.a();
        return;
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
