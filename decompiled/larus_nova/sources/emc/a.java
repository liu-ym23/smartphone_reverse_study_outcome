package emc;

import android.os.Message;
import android.util.SparseArray;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import com.ss.ugc.live.sdk.msg.utils.LoggerUtils;
import com.ss.ugc.live.sdk.msg.utils.f;
import com.ss.ugc.live.sdk.msg.utils.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import vlc.e;
import vlc.l;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements wlc.c, i.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f473112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f473113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<c> f473114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f473115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<Set<wlc.b>> f473116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, Set<wlc.b>> f473117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f473118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f473119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InterfaceC5793a f473120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vlc.c f473121j;

    /* JADX INFO: renamed from: emc.a$a, reason: collision with other inner class name */
    public interface InterfaceC5793a {
        void a(IStreamMessage r100);

        void b(IStreamMessage r100);

        void c(IStreamMessage r100, long r101, long r102);
    }

    @Override // wlc.c
    public final void release() {
        i r100 = this.f473112a;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
    L5:
        vlc.d r101 = this.f473113b;
        if (r101 == null) goto L8;
        r101.removeMessageListener(this);
    L8:
        b r102 = this.f473115d;
        if (r102 == null) goto L11;
        r102.interrupt();
    L11:
        this.f473116e.clear();
        this.f473117f.clear();
        this.f473114c.clear();
        this.f473118g = 0;
    }

    public a(vlc.d r100) {
        this.f473114c = new d();
        this.f473116e = new SparseArray();
        this.f473117f = new HashMap();
        this.f473118g = 0;
        this.f473119h = 0;
        this.f473112a = new i(this);
        this.f473113b = r100;
        Lazy r101 = LoggerUtils.f458447a;
        if ((r100 instanceof e) == true) goto L5;
        r100 = null;
    L5:
        e r102 = (e) r100;
        if (r102 == null) goto L12;
        amc.e r103 = r102.q();
        if (r103 == null) goto L12;
        vlc.c r104 = r103.getLogger();
        if (r104 == null) goto L12;
    L13:
        this.f473121j = r104;
        return;
    L12:
        r104 = (vlc.c) LoggerUtils.f458447a.getValue();
        goto L13
    }

    public final void a(IStreamMessage r100) {
        InterfaceC5793a r101 = this.f473120i;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        Set<wlc.b> r102 = this.f473116e.get(r100.getIntType());
        if (r102 != null) goto L8;
    L13:
        Set<wlc.b> r103 = this.f473117f.get(r100.getMessageMethod());
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.isEmpty() == true) goto L24;
        Iterator<wlc.b> r104 = r103.iterator();
    L19:
        if (r104.hasNext() == false) goto L25;
        r104.next().Rk(r100);
        goto L19
    L25:
        return;
    L24:
        return;
    L8:
        if (r102.isEmpty() == true) goto L13;
        Iterator<wlc.b> r105 = r102.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r105.next().Rk(r100);
        goto L11
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.i.a
    public final void handleMsg(Message r100) {
        if (r100.what != 7968) goto L8;
        Object r101 = r100.obj;
        if ((r101 instanceof IStreamMessage) == false) goto L9;
        a((IStreamMessage) r101);
        return;
    L9:
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        if ((r110 instanceof IStreamMessage) == true) goto L5;
        return;
    L5:
        if (this.f473115d != null) goto L7;
        b r100 = new b(this.f473114c, this.f473112a);
        this.f473115d = r100;
        ThreadMethodProxy.start(r100);
    L7:
        IStreamMessage r111 = (IStreamMessage) r110;
        if (r111 != null) goto L11;
        return;
    L11:
        if (r111.ignoreCondition() == false) goto L15;
        InterfaceC5793a r101 = this.f473120i;
        if (r101 == null) goto L39;
        r101.b(r111);
        return;
    L39:
        return;
    L15:
        InterfaceC5793a r102 = this.f473120i;
        if (r102 == null) goto L19;
        r102.c(r111, this.f473118g, this.f473119h);
    L19:
        if (r111.isStreamMessage() == true) goto L22;
        a(r111);
        return;
    L22:
        if ((r111 instanceof wlc.a) == false) goto L30;
        Iterator<IStreamMessage> r112 = ((wlc.a) r111).getStreamMessageList().iterator();
    L25:
        if (r112.hasNext() == false) goto L43;
        IStreamMessage r103 = r112.next();
        if (r103.getProcessAtSeiTs() > 0) goto L28;
        this.f473114c.a(new c(r103, this.f473118g, this.f473121j));
        goto L25
    L28:
        this.f473114c.a(new c(r103, this.f473118g, r103.getProcessAtSeiTs(), this.f473121j));
        goto L25
    L43:
        return;
    L30:
        c r104 = new c(r111, this.f473118g, this.f473121j);
        r104.f473127d = this.f473119h;
        this.f473114c.a(r104);
    }

    @Override // wlc.c
    public final void updateStreamDelay(long r100) {
        this.f473119h = r100;
        if (r100 <= 0) goto L5;
        this.f473118g = f.a() - r100;
    L5:
        this.f473121j.log("MessageStreamManager", "update stream delay: " + this.f473118g + " sei: " + this.f473119h);
        Object r101 = this.f473114c.iterator();
    L6:
        d.a r102 = (d.a) r101;
        if (r102.hasNext() == false) goto L9;
        c r103 = (c) r102.next();
        r103.f473126c = this.f473118g;
        r103.f473127d = this.f473119h;
        goto L6
    }

    @Override // wlc.c
    public final void addMessageListener(int r100, wlc.b r101) {
        if (r101 == null) goto L11;
        vlc.d r102 = this.f473113b;
        if (r102 == null) goto L6;
        r102.addMessageListener(r100, this);
    L6:
        Set<wlc.b> r103 = this.f473116e.get(r100);
        if (r103 != null) goto L9;
        r103 = new CopyOnWriteArraySet();
        this.f473116e.put(r100, r103);
    L9:
        r103.add(r101);
        return;
    }

    @Override // wlc.c
    public final void removeMessageListener(int r100, wlc.b r101) {
        if (r101 == null) goto L12;
        vlc.d r102 = this.f473113b;
        if (r102 == null) goto L6;
        r102.removeMessageListener(r100, this);
    L6:
        Set<wlc.b> r103 = this.f473116e.get(r100);
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.isEmpty() == true) goto L14;
        r103.remove(r101);
        return;
    L14:
        return;
    }

    @Override // wlc.c
    public final void addMessageListener(String r100, wlc.b r101) {
        if (r101 == null) goto L11;
        vlc.d r102 = this.f473113b;
        if (r102 == null) goto L6;
        r102.addMessageListener(r100, this);
    L6:
        Set<wlc.b> r103 = this.f473117f.get(r100);
        if (r103 != null) goto L9;
        r103 = new CopyOnWriteArraySet();
        this.f473117f.put(r100, r103);
    L9:
        r103.add(r101);
        return;
    }

    @Override // wlc.c
    public final void removeMessageListener(String r100, wlc.b r101) {
        if (r101 == null) goto L12;
        vlc.d r102 = this.f473113b;
        if (r102 == null) goto L6;
        r102.removeMessageListener(r100, this);
    L6:
        Set<wlc.b> r103 = this.f473117f.get(r100);
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.isEmpty() == true) goto L14;
        r103.remove(r101);
        return;
    L14:
        return;
    }
}
