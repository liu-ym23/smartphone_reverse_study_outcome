package onb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ResultCode;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements g.c, Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f524421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f524422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f524423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f524424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f524425e;

    @Override // onb.g.c
    public final void a() {
        rnb.c.c("RNBridge->JSCall", "hashCode: " + hashCode() + "->connected");
        this.f524421a.f524429d.submit(new h(this));
    }

    public final void c() {
        this.f524425e.removeMessages(2);
        this.f524425e.removeMessages(1);
        this.f524425e.removeMessages(4);
        this.f524425e.removeMessages(3);
        this.f524421a.f524426a.f(this);
    }

    @Override // onb.g.c
    public final void disconnect() {
        rnb.c.c("RNBridge->JSCall", "hashCode: " + hashCode() + "->disconnect");
        c();
        j r100 = this.f524424d;
        if (r100 == null) goto L6;
        r100.onError(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_NETWORK_ERROR, (String) ((HashMap) m.f524437a).get(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_NETWORK_ERROR));
        return;
    }

    @Override // onb.g.c
    public final void b(b r100) {
        if (TextUtils.equals(this.f524422b.a(), r100.a()) == false) goto L6;
        this.f524423c = r100;
        this.f524425e.sendEmptyMessage(4);
        return;
    }

    public final void d(j r100) {
        this.f524424d = r100;
        rnb.c.c("RNBridge->JSCall", "hashCode: " + hashCode() + "->startCall");
        this.f524425e.sendEmptyMessage(3);
        this.f524421a.f524426a.c(this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        boolean r102 = true;
        if (r101 == 1) goto L29;
        if (r101 != 2) goto L7;
        c();
        j r103 = this.f524424d;
        if (r103 == null) goto L36;
        r103.onError(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_NO_PERMISSION, (String) ((HashMap) m.f524437a).get(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_NO_PERMISSION));
    L36:
        return false;
    L7:
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L11;
        rnb.c.a("RNBridge->JSCall", "error type:" + r100.what);
        goto L36
    L11:
        c();
        if (this.f524424d == null) goto L36;
        rnb.c.a("RNBridge->JSCall", "hashCode: " + hashCode() + "->received bridge data");
        this.f524424d.a(this.f524423c);
        goto L36
    L15:
        if (this.f524421a.f524426a.f524409b.get() != 3) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        this.f524421a.f524429d.submit(new h(this));
        goto L36
    L20:
        rnb.c.a("RNBridge->JSCall", "hashCode: " + hashCode() + "->waitting connected");
        Handler r105 = this.f524425e;
        long r106 = this.f524422b.f524404a;
        if (r106 != (-1)) goto L24;
        r106 = this.f524421a.f524427b;
    L24:
        r105.sendEmptyMessageDelayed(1, r106);
        goto L36
    L17:
        r104 = false;
        goto L18
    L29:
        if (this.f524421a.f524426a.f524409b.get() == 3) goto L32;
        r102 = false;
    L32:
        if (r102 == true) goto L36;
        c();
        j r107 = this.f524424d;
        if (r107 == null) goto L36;
        r107.onError(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_TIMEOUT, (String) ((HashMap) m.f524437a).get(DocFeed$Value$ResultCode.PULL_DATA_NETWORK_TIMEOUT));
        goto L36
    }

    public i(k r100, vl5.h r101) {
        this.f524425e = new Handler(Looper.getMainLooper(), this);
        this.f524421a = r100;
        this.f524422b = r101;
        boolean r102 = true;
        if (r100.f524426a.f524409b.get() == 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L12;
        g r103 = r100.f524426a;
        r103.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L10;
        r103.d();
        return;
    L10:
        r103.f524412e.post(new e(r103));
        return;
    }
}
