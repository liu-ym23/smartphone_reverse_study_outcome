package com.bytedance.sync.v2;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import hg7.k;
import hg7.l;
import hg7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f270430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f270431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f270432c;

    public class a implements rgc.c.d<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f270433a;

        public a(d r100) {
            this.f270433a = r100;
        }

        @Override // rgc.c.d
        public final void a(Void r100) {
            long r101 = cg7.b.c(this.f270433a.f270430a).b().f() * 1000;
            Message r102 = this.f270433a.f270431b.obtainMessage(102);
            this.f270433a.f270431b.sendMessageDelayed(r102, r101);
        }
    }

    public class b implements com.bytedance.sync.v2.net.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f270434a;

        public b(d r100) {
            this.f270434a = r100;
        }

        @Override // com.bytedance.sync.v2.net.d.a
        public final void M(boolean r100) {
            if (r100 == true) goto L4;
        L6:
            d r101 = this.f270434a;
            r101.getClass();
            if (r100 == false) goto L11;
            r101.f270431b.removeMessages(104);     // Catch: Throwable -> L15
            if (r101.f270431b.hasMessages(103) == true) goto L18;
            Handler r102 = r101.f270431b;     // Catch: Throwable -> L15
            r102.sendMessageDelayed(r102.obtainMessage(103), 1000);     // Catch: Throwable -> L15
        L18:
            return;
        L11:
            r101.f270431b.removeMessages(103);     // Catch: Throwable -> L15
            if (r101.f270431b.hasMessages(104) == true) goto L18;
            Handler r103 = r101.f270431b;     // Catch: Throwable -> L15
            r103.sendMessage(r103.obtainMessage(104));     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            zf7.b.b(Log.getStackTraceString(th));
            return;
        L4:
            if (this.f270434a.f270431b.hasMessages(101) == false) goto L6;
            this.f270434a.f270431b.removeMessages(101);
            Message r104 = this.f270434a.f270431b.obtainMessage(101);
            this.f270434a.f270431b.sendMessage(r104);
            goto L6
        }
    }

    public static void a() {
        ((k) rgc.b.a(k.class)).e0();
        ((hg7.a) rgc.b.a(hg7.a.class)).reset();
        ((hg7.a) rgc.b.a(hg7.a.class)).X();
    }

    public final void b() {
        this.f270432c = new a(this);
        ((yf7.c) rgc.b.a(yf7.c.class)).y(this.f270432c);
        m r100 = (m) rgc.b.a(m.class);
        if (cg7.b.c(this.f270430a).b().n() == true) goto L5;
    L8:
        long r101 = 0;
    L9:
        Message r102 = this.f270431b.obtainMessage(101);
        this.f270431b.sendMessageDelayed(r102, r101);
        return;
    L5:
        if (r100.a() == true) goto L8;
        r101 = cg7.b.c(this.f270430a).b().f() * 1000;
        r100.o0(new b(this));
        goto L9
    }

    public d(Context r100) {
        this.f270430a = r100;
        this.f270431b = new Handler(((yf7.f) rgc.b.a(yf7.f.class)).get(), this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        if (r100.what != 102) goto L6;
        a();
    L6:
        if (r100.what != 101) goto L9;
        a();
    L9:
        if (r100.what != 103) goto L21;
    L18:
        th = move-exception;
        zf7.b.b(Log.getStackTraceString(th));
        goto L21
    L11:
        if (((l) rgc.b.a(l.class)).Y() == 1) goto L14;
        a();     // Catch: Throwable -> L18
    L16:
        ((l) rgc.b.a(l.class)).j0(true);     // Catch: Throwable -> L18
        goto L21
    L14:
        if (((l) rgc.b.a(l.class)).W() == true) goto L16;
        zf7.b.c("long link is online, in order for the server to sense that the long link is online, poll package needs to be sent ");     // Catch: Throwable -> L18
        ((k) rgc.b.a(k.class)).l0(false);     // Catch: Throwable -> L18
    L21:
        if (r100.what == 104) goto L27;
    L26:
        return false;
    L27:
        ((l) rgc.b.a(l.class)).j0(false);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        zf7.b.b(Log.getStackTraceString(th));
        goto L26
    }
}
