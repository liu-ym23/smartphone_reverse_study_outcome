package com.ss.android.lark.player.player;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes37.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f438702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f438703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f438704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f438705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f438706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f438707f;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f438708a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 1) goto L28;
            t r101 = this.f438708a;
            if (r101.f438705d == true) goto L8;
            return;
        L8:
            if (r101.f438703b == true) goto L10;
            return;
        L10:
            if (r101.f438704c == false) goto L29;
            b r102 = r101.f438706e;
            if (r102 == null) goto L24;
            v.a r103 = (v.a) r102;
            int r104 = r103.f438722a.a();
            int r105 = r103.f438722a.b();
            v r106 = r103.f438722a;
            if (r106.f() == false) goto L17;
            int r107 = r106.f438710a.f438667e;
        L18:
            if (r105 <= 0) goto L24;
            if (r104 < 0) goto L24;
            Bundle r108 = w0c.a.a();
            r108.putInt("int_arg1", r104);
            r108.putInt("int_arg2", r105);
            r108.putInt("int_arg3", r107);
            n r109 = r103.f438722a.f438713d;
            if (r109 == null) goto L24;
            r109.a(-99019, r108);
            goto L24
        L17:
            r107 = 0;
        L24:
            t r110 = this.f438708a;
            r110.f438707f.removeMessages(1);
            r110.f438707f.sendEmptyMessageDelayed(1, r110.f438702a);
            return;
        L29:
            return;
        }

        public a(t r100, Looper r101) {
            this.f438708a = r100;
            super(r101);
        }
    }

    public interface b {
    }

    public t() {
        this.f438705d = false;
        this.f438707f = new a(this, Looper.getMainLooper());
        this.f438702a = 500;
    }
}
