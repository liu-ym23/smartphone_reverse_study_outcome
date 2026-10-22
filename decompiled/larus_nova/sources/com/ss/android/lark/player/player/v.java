package com.ss.android.lark.player.player;

import android.os.Bundle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;

/* JADX INFO: loaded from: classes37.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f438710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataSource f438711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f438712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f438713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f438714e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoEngineInfoListener f438715f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.player.player.b.a f438716g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f438717h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f438718i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f438719j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f438720k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e f438721l;

    public class a implements t.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f438722a;

        public a(v r100) {
            this.f438722a = r100;
        }
    }

    public class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f438723a;

        public b(v r100) {
            this.f438723a = r100;
        }

        @Override // com.ss.android.lark.player.player.n
        public final void a(int r100, Bundle r101) {
            t r102 = this.f438723a.f438712c;
            switch(r100) {
                case -99016: goto L7;
                case -99015: goto L5;
                case -99014: goto L5;
                case -99013: goto L8;
                case -99012: goto L8;
                case -99011: goto L5;
                case -99010: goto L5;
                case -99009: goto L7;
                case -99008: goto L7;
                case -99007: goto L7;
                case -99006: goto L5;
                case -99005: goto L5;
                case -99004: goto L8;
                case -99003: goto L8;
                case -99002: goto L8;
                case -99001: goto L5;
                default: goto L8;
            };
        L5:
            r102.f438704c = true;
            boolean r103 = true;
        L6:
            boolean r104 = false;
        L10:
            if (r102.f438705d == false) goto L16;
            if (r103 == false) goto L14;
            r102.f438703b = true;
            r102.f438707f.removeMessages(1);
            r102.f438707f.sendEmptyMessage(1);
        L14:
            if (r104 == false) goto L16;
            r102.f438703b = false;
            r102.f438707f.removeMessages(1);
        L16:
            n r105 = this.f438723a.f438713d;
            if (r105 == null) goto L20;
            r105.a(r100, r101);
            return;
        L20:
            return;
        L7:
            r102.f438704c = false;
            r103 = false;
            r104 = true;
            goto L10
        L8:
            r102.getClass();
            Log.i("TimerCounterProxy", "unknown event int proxyPlayEvent");
            r103 = false;
            goto L6
        }
    }

    public class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f438724a;

        public c(v r100) {
            this.f438724a = r100;
        }

        @Override // com.ss.android.lark.player.player.m
        public final void h(int r100, Bundle r101) {
            t r102 = this.f438724a.f438712c;
            r102.f438704c = false;
            r102.f438703b = false;
            r102.f438707f.removeMessages(1);
            m r103 = this.f438724a.f438714e;
            if (r103 == null) goto L6;
            r103.h(r100, r101);
            return;
        }
    }

    public class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f438725a;

        public d(v r100) {
            this.f438725a = r100;
        }
    }

    public class e implements VideoEngineInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f438726a;

        public e(v r100) {
            this.f438726a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineInfoListener
        public final void onVideoEngineInfos(VideoEngineInfos r100) {
            VideoEngineInfoListener r101 = this.f438726a.f438715f;
            if (r101 == null) goto L6;
            r101.onVideoEngineInfos(r100);
            return;
        }
    }

    public final boolean f() {
        if (this.f438710a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public v() {
        this.f438717h = new a(this);
        this.f438718i = new b(this);
        this.f438719j = new c(this);
        this.f438720k = new d(this);
        com.ss.android.lark.player.player.b.a r100 = new u(this);
        this.f438721l = new e(this);
        this.f438712c = new t();
        s r101 = new s();
        this.f438710a = r101;
        r101.f438668f = r100;
    }

    public final int a() {
        if (f() == true) goto L5;
        return 0;
    L5:
        return this.f438710a.c();
    }

    public final int b() {
        if (f() == true) goto L5;
        return 0;
    L5:
        return this.f438710a.d();
    }

    public final int c() {
        if (f() == true) goto L5;
        return 0;
    L5:
        return this.f438710a.f438663a;
    }

    public final boolean g() {
        if (f() == false) goto L9;
        s r100 = this.f438710a;
        if (r100.b() == false) goto L9;
        if (r100.f438689g.getIntOption(43) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public final void h() {
        if (f() == false) goto L15;
        s r100 = this.f438710a;
        r100.getClass();
        Log.i("TTEnginePlayer", "pause: " + r100.f438698p);
    L9:
        e = move-exception;
        r100.e(e);
    L11:
        r100.f438691i = 4;
        return;
    L6:
        if (r100.b() == false) goto L11;
        r100.f438689g.pause();     // Catch: Exception -> L9
        r100.n(4);     // Catch: Exception -> L9
        r100.a(-99005, null);     // Catch: Exception -> L9
        goto L11
    }

    public final void d(DataSource r100) {
        if (f() == false) goto L6;
        this.f438710a.i(r100);
        return;
    }

    public final void e(int r100) {
        if (f() == false) goto L6;
        this.f438710a.k(r100);
        return;
    }

    public final void i(int r100) {
        if (f() == false) goto L20;
        s r101 = this.f438710a;
        if (r101.b() == false) goto L21;
        int r102 = r101.f438663a;
        if (r102 != 2) goto L9;
    L18:
        r101.f438689g.seekTo(r100, r101.f438696n);
        Bundle r103 = w0c.a.a();
        r103.putInt("int_data", r100);
        r101.a(-99013, r103);
        return;
    L9:
        if (r102 == 3) goto L18;
        if (r102 == 4) goto L18;
        if (r102 == 6) goto L18;
        if (r102 != 5) goto L22;
        r101.n(2);
        r101.k(r100);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void j(DataSource r100) {
        this.f438711b = r100;
        t r101 = this.f438712c;
        r101.f438706e = this.f438717h;
        s r102 = this.f438710a;
        if (r102 == null) goto L8;
        r102.f438664b = this.f438718i;
        r102.f438665c = this.f438719j;
        r102.f438666d = this.f438720k;
        e r103 = this.f438721l;
        if (r102.b() == false) goto L8;
        r102.f438689g.setVideoEngineInfoListener(r103);
    L8:
        d(r100);
    }

    public final void k(boolean r100) {
        if (f() == false) goto L8;
        s r101 = this.f438710a;
        if (r101.b() == false) goto L9;
        r101.f438689g.setIsMute(r100);
        return;
    L9:
        return;
    }

    public final void l(float r100) {
        if (f() == false) goto L8;
        s r101 = this.f438710a;
        if (r101.b() == false) goto L9;
        PlaybackParams r102 = new PlaybackParams();
        r102.setSpeed(r100);
        r101.f438689g.setPlaybackParams(r102);
        return;
    L9:
        return;
    }

    public final void m(boolean r100) {
        t r101 = this.f438712c;
        r101.f438705d = r100;
        if (r100 == true) goto L5;
        r101.f438703b = false;
        r101.f438707f.removeMessages(1);
        Log.e("TimerCounterProxy", "Timer Stopped");
        return;
    L5:
        r101.f438703b = true;
        r101.f438707f.removeMessages(1);
        r101.f438707f.sendEmptyMessage(1);
        Log.e("TimerCounterProxy", "Timer Started");
    }
}
