package com.bytedance.ee.bear.middleground.drive.cipher;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.lark.pb.basic.v1.CipherKeyBusiness;
import com.bytedance.lark.pb.basic.v1.PushCipherChangeEventRequest;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ue5.b> f232403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerC3322a f232404b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.cipher.a$a, reason: collision with other inner class name */
    public final class HandlerC3322a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f232405a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            byte[] r102 = (byte[]) r100.obj;
            this.f232405a.getClass();
            PushCipherChangeEventRequest r103 = PushCipherChangeEventRequest.ADAPTER.decode(r102);     // Catch: Exception -> L23
        L25:
            a r104 = this.f232405a;
            r104.getClass();
            if (r103 != null) goto L28;
            tt5.a.d("CipherChangeEventLister", "dispatch: data is null");
            return;
        L28:
            tt5.a.h("CipherChangeEventLister", "dispatch:" + r103);
            Iterator<PushCipherChangeEventRequest.CipherChangedEvent> r105 = r103.events.iterator();
        L30:
            if (r105.hasNext() == false) goto L57;
            PushCipherChangeEventRequest.CipherChangedEvent r106 = r105.next();
            if (r106 == null) goto L30;
            if (r106.business != CipherKeyBusiness.CCM) goto L30;
            tt5.a.h("CipherChangeEventLister", "dispatch:" + ((ArrayList) r104.f232403a).size() + ":" + r104.f232403a);
            Iterator r107 = ((ArrayList) r104.f232403a).iterator();
        L38:
            if (r107.hasNext() == false) goto L58;
            ((ue5.b) r107.next()).a();
            goto L38
        L58:
            return;
        L57:
            return;
        L23:
            e = move-exception;
            tt5.a.e("CipherChangeEventLister", "parse: ", e, false);
            r103 = null;
            goto L25
        L5:
            if (r101 != 2) goto L7;
            ue5.b r108 = (ue5.b) r100.obj;
            tt5.a.h("CipherChangeEventLister", "MSG_REGISTER_CALLBACK " + r108);
            if (r108 != null) goto L18;
            return;
        L18:
            if (((ArrayList) this.f232405a.f232403a).contains(r108) == true) goto L53;
            ((ArrayList) this.f232405a.f232403a).add(r108);
            return;
        L53:
            return;
        L7:
            if (r101 != 3) goto L9;
            ue5.b r109 = (ue5.b) r100.obj;
            tt5.a.h("CipherChangeEventLister", "MSG_UNREGISTER_CALLBACK " + r109);
            if (r109 == null) goto L50;
            ((ArrayList) this.f232405a.f232403a).remove(r109);
            return;
        L50:
            return;
        L9:
            if (r101 != 4) goto L56;
            ((ArrayList) this.f232405a.f232403a).clear();
            return;
        }

        public HandlerC3322a(a r100, Looper r101) {
            this.f232405a = r100;
            super(r101);
        }
    }

    public a() {
        this.f232403a = new ArrayList();
        this.f232404b = new HandlerC3322a(this, CoreThreadPool.getSerialTaskHandler().getLooper());
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        tt5.a.b("CipherChangeEventLister", "onPush");
        HandlerC3322a r101 = this.f232404b;
        r101.getClass();
        r101.sendMessage(Message.obtain(r101, 1, r100));
    }
}
