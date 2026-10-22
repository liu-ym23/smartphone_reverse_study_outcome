package pnb;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.lark.jsruntime.vmsdk.j;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile HandlerC7214b f529991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile a f529992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<d> f529993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<e> f529994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f529995e;

    public final class a extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f529996b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f529997a;

        public a(b r100) {
            this.f529997a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            rnb.c.a("bridge_receive", "ReceiverHandler.handleMessage: 101 " + r100);
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            d r102 = (d) r100.obj;
            if (c.f530001b == false) goto L16;
            rnb.c.a("bridge_receive", "registerDataChangeListener: listener size=" + ((CopyOnWriteArraySet) this.f529997a.f529993c).size());
        L16:
            if (r102 == null) goto L18;
            ((CopyOnWriteArraySet) this.f529997a.f529993c).add(r102);
            return;
        L18:
            rnb.c.d("bridge_receive", "registerDataChangeListener: listener is null");
            return;
        L5:
            if (r101 == 2) goto L7;
            rnb.c.d("bridge_send", "error type:" + r100.what);
            return;
        L7:
            d r103 = (d) r100.obj;
            if (c.f530001b == false) goto L10;
            rnb.c.a("bridge_receive", "unRegisterDataChangeListener: listener size=" + ((CopyOnWriteArraySet) this.f529997a.f529993c).size());
        L10:
            if (r103 == null) goto L12;
            ((CopyOnWriteArraySet) this.f529997a.f529993c).remove(r103);
            return;
        L12:
            rnb.c.d("bridge_receive", "unRegisterDataChangeListener: listener is null");
        }
    }

    /* JADX INFO: renamed from: pnb.b$b, reason: collision with other inner class name */
    public final class HandlerC7214b extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f529998b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f529999a;

        public HandlerC7214b(b r100) {
            this.f529999a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            rnb.c.a("bridge_send", "SenderHandler.handleMessage: 89 " + r100);
            int r101 = r100.what;
            if (r101 != 3) goto L5;
            String r102 = (String) r100.obj;
            if (c.f530000a == false) goto L25;
            rnb.c.a("bridge_send", "requestFromNative:  request=" + r102);
        L25:
            if (this.f529999a.f529994d != null) goto L27;
        L34:
            rnb.c.b("bridge_send", "requestFromNative: mNativeToJsBridge is null ");
            return;
        L27:
            if (TextUtils.isEmpty(r102) == true) goto L34;
            e r103 = this.f529999a.f529994d.get();
            if (r103 == null) goto L32;
            rnb.c.a("bridge_send", "BridgeConnector.requestFromNative: string start send " + System.currentTimeMillis());
            r103.a(r102);
            return;
        L32:
            rnb.c.d("bridge_send", "requestFromNative: bridge is null");
            return;
        L5:
            if (r101 == 5) goto L7;
            rnb.c.d("bridge_send", "error type:" + r100.what);
            return;
        L7:
            String r104 = (String) r100.obj;
            if (c.f530000a == false) goto L11;
            rnb.c.a("bridge_send", "requestFromDocs:  request=" + r104);
        L11:
            if (this.f529999a.f529994d != null) goto L13;
        L19:
            rnb.c.b("bridge_send", "requestFromDocs: mNativeToJsBridge is null ");
            return;
        L13:
            if (TextUtils.isEmpty(r104) == true) goto L19;
            e r105 = this.f529999a.f529994d.get();
            if (r105 == null) goto L18;
            rnb.c.a("bridge_send", "BridgeConnector.requestFromDocs: string start send " + System.currentTimeMillis());
            r105.b(r104);
            return;
        L18:
            rnb.c.d("bridge_send", "requestFromDocs: bridge is null");
        }
    }

    public b(j r100) {
        this.f529993c = new CopyOnWriteArraySet();
    L8:
        e = move-exception;
        rnb.c.f538745a.e("bridge_connector", "init: ", e);
        return;
    L4:
        if (c.f530002c == false) goto L6;
        rnb.c.a("bridge_connector", "init: begin");     // Catch: Exception -> L8
    L6:
        this.f529991a = new HandlerC7214b(this);     // Catch: Exception -> L8
        this.f529992b = new a(this);     // Catch: Exception -> L8
        this.f529995e = new f(r100);     // Catch: Exception -> L8
        this.f529994d = new WeakReference(this.f529995e);     // Catch: Exception -> L8
        r100.f(new pnb.a(this));     // Catch: Exception -> L8
    }
}
