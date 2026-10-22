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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements g.b {
    public final List<ue5.b> a;
    public final HandlerC0075a b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.cipher.a$a, reason: collision with other inner class name */
    public final class HandlerC0075a extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r6) {
            int r0 = r6.what;
            if (r0 != 1) goto L5;
            byte[] r7 = (byte[]) r6.obj;
            this.a.getClass();
            PushCipherChangeEventRequest r8 = (PushCipherChangeEventRequest) PushCipherChangeEventRequest.ADAPTER.decode(r7);     // Catch: Exception -> L23
        L25:
            a r1 = this.a;
            r1.getClass();
            if (r8 != null) goto L28;
            tt5.a.d("CipherChangeEventLister", "dispatch: data is null");
            return;
        L28:
            tt5.a.h("CipherChangeEventLister", "dispatch:" + r8);
            Iterator r9 = r8.events.iterator();
        L30:
            if (r9.hasNext() == false) goto L57;
            PushCipherChangeEventRequest.CipherChangedEvent r2 = (PushCipherChangeEventRequest.CipherChangedEvent) r9.next();
            if (r2 == null) goto L30;
            if (r2.business != CipherKeyBusiness.CCM) goto L30;
            tt5.a.h("CipherChangeEventLister", "dispatch:" + ((ArrayList) r1.a).size() + ":" + r1.a);
            Iterator r10 = ((ArrayList) r1.a).iterator();
        L38:
            if (r10.hasNext() == false) goto L58;
            ((ue5.b) r10.next()).a();
            goto L38
        L58:
            return;
        L57:
            return;
        L23:
            e = move-exception;
            tt5.a.e("CipherChangeEventLister", "parse: ", e, false);
            r8 = null;
            goto L25
        L5:
            if (r0 != 2) goto L7;
            ue5.b r11 = (ue5.b) r6.obj;
            tt5.a.h("CipherChangeEventLister", "MSG_REGISTER_CALLBACK " + r11);
            if (r11 != null) goto L18;
            return;
        L18:
            if (((ArrayList) this.a.a).contains(r11) == true) goto L53;
            ((ArrayList) this.a.a).add(r11);
            return;
        L53:
            return;
        L7:
            if (r0 != 3) goto L9;
            ue5.b r12 = (ue5.b) r6.obj;
            tt5.a.h("CipherChangeEventLister", "MSG_UNREGISTER_CALLBACK " + r12);
            if (r12 == null) goto L50;
            ((ArrayList) this.a.a).remove(r12);
            return;
        L50:
            return;
        L9:
            if (r0 != 4) goto L56;
            ((ArrayList) this.a.a).clear();
            return;
        }

        public HandlerC0075a(a r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public a() {
        this.a = new ArrayList();
        this.b = new HandlerC0075a(this, CoreThreadPool.getSerialTaskHandler().getLooper());
    }

    public final void a(byte[] r3) {
        tt5.a.b("CipherChangeEventLister", "onPush");
        HandlerC0075a r0 = this.b;
        r0.getClass();
        r0.sendMessage(Message.obtain(r0, 1, r3));
    }
}
