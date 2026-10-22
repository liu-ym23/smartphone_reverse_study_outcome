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

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Notification> f235131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveData<List<Notification>> f235132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f235133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<com.bytedance.ee.bear.notification.c, s45.c.a> f235134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dk5.e f235135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f235136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f235137g;

    public class a implements com.bytedance.ee.bear.notification.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f235138a;

        public a(o r100) {
            this.f235138a = r100;
        }
    }

    public class b implements dk5.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f235139a;

        public b(o r100) {
            this.f235139a = r100;
        }

        public final void a(Notification r100, boolean r101) {
            tt5.a.h("NotificationViewModel", "onNotificationChange: " + r100 + ", isClose: " + r101);
            if (this.f235139a.f235133c.contains(r100.getId()) == false) goto L6;
            tt5.a.b("NotificationViewModel", "result " + r100 + " has closed but unsync, ignore it");
            return;
        L6:
            if (r101 == false) goto L8;
            dk5.e r102 = this.f235139a.f235135e;
            String r103 = r100.getId();
            r102.getClass();
            fo5.d.b().scheduleDirect(new dk5.i(r102, r103));
            return;
        L8:
            dk5.e r104 = this.f235139a.f235135e;
            r104.getClass();
            fo5.d.b().scheduleDirect(new dk5.j(r104, r100));
        }
    }

    public class c implements com.bytedance.ee.bear.notification.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f235140a;

        public c(o r100) {
            this.f235140a = r100;
        }
    }

    public class d implements Observer<List<Notification>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f235141a;

        public d(o r100) {
            this.f235141a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(List<Notification> r110) {
            List<Notification> r111 = r110;
            if (r111 == null) goto L13;
            o r100 = this.f235141a;
            Notification r101 = r100.f235131a.getValue();
            if (r101 != null) goto L7;
        L9:
            this.f235141a.getClass();
            Collections.sort(r111, new l());
            tt5.a.b("NotificationViewModel", "notificationDatabase: onChanged, notificationResults = " + r111);
            Iterator<Notification> r112 = r111.iterator();
        L11:
            if (r112.hasNext() == false) goto L15;
            Notification r102 = r112.next();
            o r103 = this.f235141a;
            r103.getClass();
            tt5.a.b("NotificationViewModel", "sendStartMessage: " + r102 + ", delay = " + (((r102.getStart_time() * 1000) - System.currentTimeMillis()) / 1000));
            Message r104 = Message.obtain(r103.f235136f, 0);
            r104.obj = r102;
            r103.f235136f.sendMessageDelayed(r104, (r102.getStart_time() * 1000) - System.currentTimeMillis());
            o r105 = this.f235141a;
            r105.getClass();
            tt5.a.b("NotificationViewModel", "sendEndMessage: " + r102 + ", delay = " + (((r102.getEnd_time() * 1000) - System.currentTimeMillis()) / 1000));
            Message r106 = Message.obtain(r105.f235136f, 1);
            r106.obj = r102;
            r105.f235136f.sendMessageDelayed(r106, (r102.getEnd_time() * 1000) - System.currentTimeMillis());
            goto L11
        L15:
            return;
        L7:
            if (r111.contains(r101) == true) goto L9;
            tt5.a.b("NotificationViewModel", "hideOfflineNotificationIfNeed: current notification is offline, dismiss it");
            r100.f235131a.postValue(null);
            goto L9
        }
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f235142a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            Notification r102 = null;
            if (r101 != 0) goto L5;
            Notification r103 = (Notification) r100.obj;
            o r104 = this.f235142a;
            r104.getClass();
            tt5.a.b("NotificationViewModel", "handleMessageStart: " + r103);
            LiveData<List<Notification>> r105 = r104.f235132b;
            if (r105 == null) goto L13;
            List<Notification> r106 = r105.getValue();
        L14:
            if (r106 == null) goto L32;
            Iterator<Notification> r107 = r104.f235132b.getValue().iterator();
        L18:
            if (r107.hasNext() == false) goto L22;
            Notification r108 = r107.next();
            if (TextUtils.equals(r108.getId(), r103.getId()) == false) goto L18;
            r102 = r108;
        L22:
            if (r102 == null) goto L30;
            tt5.a.h("NotificationViewModel", "handleMessageStart: show last version notification");
            r104.f235131a.postValue(r103);
            return;
        L30:
            return;
        L32:
            return;
        L13:
            r106 = null;
            goto L14
        L5:
            if (r101 != 1) goto L31;
            Notification r109 = (Notification) r100.obj;
            o r110 = this.f235142a;
            r110.getClass();
            tt5.a.b("NotificationViewModel", "handleMessageEnd: " + r109);
            if (r109.equals(r110.f235131a.getValue()) == false) goto L28;
            dk5.e r111 = r110.f235135e;
            String r112 = r109.getId();
            r111.getClass();
            fo5.d.b().scheduleDirect(new dk5.i(r111, r112));
            r110.f235131a.postValue(null);
            return;
        L28:
            return;
        }

        public e(o r100, Looper r101) {
            this.f235142a = r100;
            super(r101);
        }
    }

    public final void a() {
        ck5.i r100 = this.f235135e.f469004b;
        r100.getClass();
        ck5.b r101 = r100.a().c();     // Catch: Exception -> L5
        long r102 = System.currentTimeMillis() / 1000;     // Catch: Exception -> L5
        ck5.h r103 = (ck5.h) r101;     // Catch: Exception -> L5
        r103.getClass();     // Catch: Exception -> L5
        RoomSQLiteQuery r104 = RoomSQLiteQuery.acquire("SELECT * FROM Notification WHERE end_time> ? and close = 0", 1);     // Catch: Exception -> L5
        r104.bindLong(1, r102);     // Catch: Exception -> L5
        LiveData<List<Notification>> r105 = r103.f24037a.getInvalidationTracker().createLiveData(new String[]{"Notification"}, false, new ck5.g(r103, r104));     // Catch: Exception -> L5
    L7:
        this.f235132b = r105;
        com.bytedance.ee.util.ui.m.a(new k(this));
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
        r105 = new MediatorLiveData();
        goto L7
    }

    public o() {
        this.f235131a = new MutableLiveData();
        this.f235133c = new CopyOnWriteArrayList();
        HashMap r100 = new HashMap();
        this.f235134d = r100;
        a r101 = new a(this);
        this.f235137g = new d(this);
        this.f235136f = new e(this, Looper.getMainLooper());
        dk5.e r102 = new dk5.e();
        this.f235135e = r102;
        b r103 = new b(this);
        dk5.c r104 = new dk5.c(r102.f469003a, r103);
        r102.f469006d = r104;
        r102.f469005c.b(r104);
        c r105 = new c(this);
        ((h0) org.koin.java.a.a(h0.class)).Pe(new n(r105));
        s45.c r106 = (s45.c) org.koin.java.a.a(s45.c.class);
        s45.c.a r107 = (s45.c.a) r100.remove(r101);
        if (r107 == null) goto L5;
        r106.o4(r107);
    L5:
        m r108 = new m(r101);
        r106.b1(r108);
        r100.put(r101, r108);
    }
}
