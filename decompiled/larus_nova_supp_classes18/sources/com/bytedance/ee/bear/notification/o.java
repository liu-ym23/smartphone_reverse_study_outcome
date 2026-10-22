package com.bytedance.ee.bear.notification;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.notification.bean.Notification;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final MutableLiveData<Notification> a;
    public LiveData<List<Notification>> b;
    public final CopyOnWriteArrayList<String> c;
    public final Map<com.bytedance.ee.bear.notification.c, s45.c.a> d;
    public final dk5.e e;
    public final e f;
    public final d g;

    public class a implements com.bytedance.ee.bear.notification.c {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }
    }

    public class b implements dk5.c.b {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        public final void a(Notification r4, boolean r5) {
            tt5.a.h("NotificationViewModel", "onNotificationChange: " + r4 + ", isClose: " + r5);
            if (this.a.c.contains(r4.getId()) == false) goto L6;
            tt5.a.b("NotificationViewModel", "result " + r4 + " has closed but unsync, ignore it");
            return;
        L6:
            if (r5 == false) goto L8;
            dk5.e r6 = this.a.e;
            String r7 = r4.getId();
            r6.getClass();
            fo5.d.b().scheduleDirect(new dk5.i(r6, r7));
            return;
        L8:
            dk5.e r8 = this.a.e;
            r8.getClass();
            fo5.d.b().scheduleDirect(new dk5.j(r8, r4));
        }
    }

    public class c implements com.bytedance.ee.bear.notification.b {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }
    }

    public class d implements Observer<List<Notification>> {
        public final /* synthetic */ o a;

        public d(o r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            List r13 = (List) r12;
            if (r13 == null) goto L13;
            o r0 = this.a;
            Notification r1 = (Notification) r0.a.getValue();
            if (r1 != null) goto L7;
        L9:
            this.a.getClass();
            Collections.sort(r13, new l());
            tt5.a.b("NotificationViewModel", "notificationDatabase: onChanged, notificationResults = " + r13);
            Iterator r14 = r13.iterator();
        L11:
            if (r14.hasNext() == false) goto L15;
            Notification r2 = (Notification) r14.next();
            o r3 = this.a;
            r3.getClass();
            tt5.a.b("NotificationViewModel", "sendStartMessage: " + r2 + ", delay = " + (((r2.getStart_time() * 1000) - System.currentTimeMillis()) / 1000));
            Message r4 = Message.obtain(r3.f, 0);
            r4.obj = r2;
            r3.f.sendMessageDelayed(r4, (r2.getStart_time() * 1000) - System.currentTimeMillis());
            o r5 = this.a;
            r5.getClass();
            tt5.a.b("NotificationViewModel", "sendEndMessage: " + r2 + ", delay = " + (((r2.getEnd_time() * 1000) - System.currentTimeMillis()) / 1000));
            Message r6 = Message.obtain(r5.f, 1);
            r6.obj = r2;
            r5.f.sendMessageDelayed(r6, (r2.getEnd_time() * 1000) - System.currentTimeMillis());
            goto L11
        L15:
            return;
        L7:
            if (r13.contains(r1) == true) goto L9;
            tt5.a.b("NotificationViewModel", "hideOfflineNotificationIfNeed: current notification is offline, dismiss it");
            r0.a.postValue(null);
            goto L9
        }
    }

    public class e extends Handler {
        public final /* synthetic */ o a;

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            int r0 = r8.what;
            Notification r1 = null;
            if (r0 != 0) goto L5;
            Notification r9 = (Notification) r8.obj;
            o r2 = this.a;
            r2.getClass();
            tt5.a.b("NotificationViewModel", "handleMessageStart: " + r9);
            LiveData<List<Notification>> r3 = r2.b;
            if (r3 == null) goto L13;
            List r4 = (List) r3.getValue();
        L14:
            if (r4 == null) goto L32;
            Iterator r5 = ((List) r2.b.getValue()).iterator();
        L18:
            if (r5.hasNext() == false) goto L22;
            Notification r6 = (Notification) r5.next();
            if (TextUtils.equals(r6.getId(), r9.getId()) == false) goto L18;
            r1 = r6;
        L22:
            if (r1 == null) goto L30;
            tt5.a.h("NotificationViewModel", "handleMessageStart: show last version notification");
            r2.a.postValue(r9);
            return;
        L30:
            return;
        L32:
            return;
        L13:
            r4 = null;
            goto L14
        L5:
            if (r0 != 1) goto L31;
            Notification r10 = (Notification) r8.obj;
            o r7 = this.a;
            r7.getClass();
            tt5.a.b("NotificationViewModel", "handleMessageEnd: " + r10);
            if (r10.equals(r7.a.getValue()) == false) goto L28;
            dk5.e r11 = r7.e;
            String r12 = r10.getId();
            r11.getClass();
            fo5.d.b().scheduleDirect(new dk5.i(r11, r12));
            r7.a.postValue(null);
            return;
        L28:
            return;
        }

        public e(o r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final void a() {
        ck5.i r0 = this.e.b;
        r0.getClass();
        ck5.b r1 = r0.a().c();     // Catch: Exception -> L5
        long r2 = System.currentTimeMillis() / 1000;     // Catch: Exception -> L5
        ck5.h r3 = (ck5.h) r1;     // Catch: Exception -> L5
        r3.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM Notification WHERE end_time> ? and close = 0", 1);     // Catch: Exception -> L5
        r4.bindLong(1, r2);     // Catch: Exception -> L5
        LiveData<List<Notification>> r5 = r3.a.getInvalidationTracker().createLiveData(new String[]{"Notification"}, false, new ck5.g(r3, r4));     // Catch: Exception -> L5
    L7:
        this.b = r5;
        com.bytedance.ee.util.ui.m.a(new k(this));
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r5 = new MediatorLiveData();
        goto L7
    }

    public o() {
        this.a = new MutableLiveData();
        this.c = new CopyOnWriteArrayList();
        HashMap r0 = new HashMap();
        this.d = r0;
        a r1 = new a(this);
        this.g = new d(this);
        this.f = new e(this, Looper.getMainLooper());
        dk5.e r2 = new dk5.e();
        this.e = r2;
        b r3 = new b(this);
        dk5.c r4 = new dk5.c(r2.a, r3);
        r2.d = r4;
        r2.c.b(r4);
        c r5 = new c(this);
        ((h0) org.koin.java.a.a(h0.class)).Pe(new n(r5));
        s45.c r6 = (s45.c) org.koin.java.a.a(s45.c.class);
        s45.c.a r7 = (s45.c.a) r0.remove(r1);
        if (r7 == null) goto L5;
        r6.o4(r7);
    L5:
        m r8 = new m(r1);
        r6.b1(r8);
        r0.put(r1, r8);
    }
}
