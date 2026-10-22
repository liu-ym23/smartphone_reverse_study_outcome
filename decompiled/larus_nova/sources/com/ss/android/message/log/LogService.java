package com.ss.android.message.log;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.collection.ArrayUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.utils.f;
import com.ss.android.message.PushThreadHandlerManager;
import org.json.JSONArray;
import rgc.b;
import zfc.a;

/* JADX INFO: loaded from: classes38.dex */
public class LogService extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f449122a;

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f.b("PushLog", "onCreate " + this);
        a.InterfaceC8452a r100 = (a.InterfaceC8452a) b.a(a.InterfaceC8452a.class);     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.Z();     // Catch: Throwable -> L8
    L6:
        this.f449122a = new Messenger(new WeakHandler(PushThreadHandlerManager.inst().getLooper(), this));
    }

    public LogService() {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r110) {
        hfc.a r100 = hfc.a.c(this);     // Catch: Throwable -> L5 Exception -> L7
    L9:
        f.b("PushLog", "handleMsg msg.what = " + r110.what);     // Catch: Throwable -> L5
        int r101 = r110.what;     // Catch: Throwable -> L5
        int r102 = 0;
        if (r101 == 0) goto L24;
        if (r101 != 1) goto L46;
        Messenger r103 = r110.replyTo;     // Catch: Throwable -> L5
        if (r103 == null) goto L47;
        long[] r111 = ((Bundle) r110.obj).getLongArray("event_ids");     // Catch: Throwable -> L5
        if (r111 == null) goto L48;
        f.b("PushLog", "event_ids = " + ArrayUtils.toList(r111));     // Catch: Throwable -> L5
        if (r100 != null) goto L21;
        r103.send(Message.obtain(null, 2));     // Catch: Throwable -> L5
        return;
    L21:
        int r104 = r111.length;     // Catch: Throwable -> L5
    L22:
        if (r102 >= r104) goto L51;
        r100.a(r111[r102]);     // Catch: Throwable -> L5
        r102 = r102 + 1;     // Catch: Throwable -> L5
        goto L22
    L51:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L24:
        Messenger r105 = r110.replyTo;     // Catch: Throwable -> L5
        if (r105 == null) goto L49;
        long r112 = ((Bundle) r110.obj).getLong("start_id", 0);     // Catch: Throwable -> L5
        if (r100 != null) goto L30;
        r105.send(Message.obtain(null, 2));     // Catch: Throwable -> L5
        return;
    L30:
        JSONArray r113 = r100.b(r112);     // Catch: Throwable -> L5
        if (r113 != null) goto L34;
        r105.send(Message.obtain(null, 2));     // Catch: Throwable -> L5
        return;
    L34:
        Message r106 = Message.obtain(null, 0);     // Catch: Throwable -> L5
        Bundle r107 = new Bundle();     // Catch: Throwable -> L5
        r107.putString("events", r113.toString());     // Catch: Throwable -> L5
        if (r113.length() < 5) goto L38;
        r107.putBoolean("has_more", true);     // Catch: Throwable -> L5
    L39:
        f.b("PushLog", "events = " + r107.get("events") + " has_more = " + r107.get("has_more"));     // Catch: Throwable -> L5
        r106.obj = r107;     // Catch: Throwable -> L5
        r105.send(r106);     // Catch: Throwable -> L5
        return;
    L38:
        r107.putBoolean("has_more", false);     // Catch: Throwable -> L5
        goto L39
    L49:
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L5
        r100 = null;
        goto L9
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        f.b("PushLog", "onBind " + this);
        return this.f449122a.getBinder();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent r100) {
        f.b("PushLog", "onUnBind " + this);
        return super.onUnbind(r100);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = super.onStartCommand(r100, r101, r102);
        a.b r104 = a.a();
        if (r104 != null) goto L5;
        return r103;
    L5:
        if (r104.f() == false) goto L9;
        return 2;
    L9:
        return r103;
    }
}
