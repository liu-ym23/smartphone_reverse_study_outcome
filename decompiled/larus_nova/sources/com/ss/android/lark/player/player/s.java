package com.ss.android.lark.player.player;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.perf.ResourcePerfMonitor;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.SARChangeListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class s extends b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final boolean f438688r = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TTVideoEngine f438689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.ss.android.lark.player.player.a f438690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f438691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f438692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f438693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f438694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f438695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f438696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DataSource f438697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f438698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f438699q;

    public class a implements VideoEngineListener, SARChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f438700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f438701b;

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onFirstAVSyncFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onRefreshSurface(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
            return VideoEngineListener.CC.$default$onSetSurface(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onSilenceDetected(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onStreamChanged(TTVideoEngine r100, int r101) {
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
            VideoEngineListener.CC.$default$onVideoSecondFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onVideoStatusException(int r100) {
        }

        public a(s r100) {
            this.f438701b = r100;
            this.f438700a = 1.0f;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onCompletion(TTVideoEngine r100) {
            this.f438701b.n(6);
            this.f438701b.f438691i = 6;
            Bundle r101 = w0c.a.a();
            r101.putInt("int_arg1", this.f438701b.d());
            this.f438701b.a(-99016, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onError(Error r100) {
            Log.i("TTEnginePlayer", "Error: " + r100);
            this.f438701b.n(-1);
            this.f438701b.f438691i = -1;
            int r101 = r100.code;
            if (r101 != (-499896)) goto L5;
            int r102 = -88015;
        L9:
            Bundle r103 = w0c.a.a();
            r103.putInt("int_arg1", r100.code);
            r103.putString("string_data", r100.description);
            m r104 = this.f438701b.f438665c;
            if (r104 == null) goto L13;
            r104.h(r102, r103);
            return;
        L13:
            return;
        L5:
            if (r101 == (-499894)) goto L7;
            r102 = -88011;
            goto L9
        L7:
            r102 = -88019;
            goto L9
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPrepare(TTVideoEngine r100) {
            Log.i("TTEnginePlayer", "onPrepare: " + r100.getCurrentPlayPath());
            this.f438701b.a(-99053, null);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPrepared(TTVideoEngine r100) {
            Log.i("TTEnginePlayer", "onPrepared...");
            this.f438701b.n(2);
            this.f438701b.f438692j = r100.getVideoWidth();
            this.f438701b.f438693k = r100.getVideoHeight();
            Bundle r101 = w0c.a.a();
            r101.putInt("int_arg1", this.f438701b.f438692j);
            r101.putInt("int_arg2", this.f438701b.f438693k);
            r101.putInt("int_arg3", this.f438701b.d());
            r101.putInt("int_arg4", this.f438701b.c());
            this.f438701b.a(-99018, r101);
            Log.i("TTEnginePlayer", "mTargetState = " + this.f438701b.f438691i);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onRenderStart(TTVideoEngine r100) {
            s r101 = this.f438701b;
            if (r101.b() == false) goto L5;
            r101.f438689g.setStartTime(0);
        L5:
            this.f438701b.a(-99015, null);
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
            s r102 = this.f438701b;
            r102.f438667e = r101;
            l r103 = r102.f438666d;
            if (r103 == null) goto L6;
            ((v.d) r103).f438725a.getClass();
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
            if (r101 != 1) goto L5;
            Bundle r102 = w0c.a.a();
            this.f438701b.a(-99011, r102);
            return;
        L5:
            if (r101 != 2) goto L11;
            Bundle r103 = w0c.a.a();
            this.f438701b.a(-99010, r103);
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            if (r101 != 1) goto L5;
            this.f438701b.n(3);
            return;
        L5:
            if (r101 != 2) goto L11;
            this.f438701b.n(4);
            return;
        }

        @Override // com.ss.ttvideoengine.SARChangeListener
        public final void onSARChanged(int r100, int r101) {
            if (r101 == 0) goto L6;
            if (r100 == 0) goto L7;
            this.f438700a = r100 / r101;
            return;
        L7:
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineListener
        public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
            float r103 = this.f438700a;
            if (r103 == 1.0f) goto L5;
            float r104 = r101;
            r102 = (int) (r104 / ((r104 / r102) * r103));
        L5:
            b.a r105 = this.f438701b.f438668f;
            if (r105 == null) goto L8;
            r105.a(r101, r102);
        L8:
            s r106 = this.f438701b;
            r106.f438692j = r101;
            r106.f438693k = r102;
            Bundle r107 = w0c.a.a();
            r107.putInt("int_arg1", this.f438701b.f438692j);
            r107.putInt("int_arg2", this.f438701b.f438693k);
            this.f438701b.a(-99017, r107);
        }
    }

    public final boolean b() {
        if (this.f438689g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f() {
        Log.i("TTEnginePlayer", "playWithCheck: " + this.f438698p);
        if (TextUtils.isEmpty(this.f438698p) == true) goto L6;
        this.f438689g.play();
        return;
    }

    public final void g() {
        Log.i("TTEnginePlayer", "reset: " + this.f438698p);
        if (b() == false) goto L5;
        n(0);
        a(-99008, null);
    L5:
        this.f438691i = 0;
    }

    public final void h() {
        Log.i("TTEnginePlayer", "resume: " + this.f438698p);
    L13:
        e = move-exception;
        e(e);
    L15:
        this.f438691i = 3;
        return;
    L4:
        if (b() == false) goto L15;
        int r100 = this.f438663a;     // Catch: Exception -> L13
        if (r100 != 4) goto L8;
    L11:
        f();     // Catch: Exception -> L13
        n(3);     // Catch: Exception -> L13
        a(-99006, null);     // Catch: Exception -> L13
        goto L15
    L8:
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L15;
        goto L11
    }

    public final void l() {
        Log.i("TTEnginePlayer", "stop: " + this.f438698p);
        if (b() == false) goto L13;
        int r100 = this.f438663a;
        if (r100 != 2) goto L7;
    L12:
        this.f438689g.stop();
        n(5);
        a(-99007, null);
        goto L13
    L7:
        if (r100 == 3) goto L12;
        if (r100 == 4) goto L12;
        if (r100 == 6) goto L12;
    L13:
        this.f438691i = 5;
    }

    public final void m() {
        if (this.f438690h != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f438698p) == true) goto L9;
        com.ss.android.lark.player.player.a r100 = this.f438690h;
        String r101 = this.f438698p;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "url");
        r100.f438662a.b(r101);
        return;
    }

    static {
        boolean r100 = true;
        if (IMPlayerSettings.a().getUseCacheFromBiz() == 1) goto L6;
        r100 = false;
    L6:
        f438688r = r100;
    }

    public s() {
        this.f438694l = true;
        k r100 = new k(this);
        this.f438695m = r100;
        this.f438696n = new j(this);
        this.f438698p = "";
        this.f438699q = "";
        com.ss.android.lark.playerconfig.a.b("IM", "");
        TTVideoEngine r101 = com.ss.android.lark.playerconfig.a.a("IM", "", null);
        this.f438689g = r101;
        r101.setVideoEngineCallback(r100);
    }

    public final int c() {
        if (b() == false) goto L14;
        int r100 = this.f438663a;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L13;
        if (r100 == 4) goto L13;
        if (r100 == 6) goto L13;
        return 0;
    L13:
        return this.f438689g.getCurrentPlaybackTime();
    L14:
        return 0;
    }

    public final int d() {
        if (b() == false) goto L11;
        int r100 = this.f438663a;
        if (r100 != (-1)) goto L7;
        return 0;
    L7:
        if (r100 == 1) goto L14;
        if (r100 != 0) goto L10;
        return 0;
    L10:
        return this.f438689g.getDuration();
    L14:
        return 0;
    L11:
        return 0;
    }

    public final void e(Exception r100) {
        Log.e("TTEnginePlayer", "exception in player:" + r100);
        g();
    }

    public final void i(DataSource r100) {
    L21:
        e = move-exception;
        e.printStackTrace();
        n(-1);
        this.f438691i = -1;
        return;
    L3:
        if (b() == true) goto L5;
        com.ss.android.lark.playerconfig.a.b("IM", "");     // Catch: Exception -> L21
        TTVideoEngine r101 = com.ss.android.lark.playerconfig.a.a("IM", "", null);     // Catch: Exception -> L21
        this.f438689g = r101;     // Catch: Exception -> L21
        r101.setVideoEngineCallback(this.f438695m);     // Catch: Exception -> L21
    L9:
        a r102 = new a(this);     // Catch: Exception -> L21
        this.f438689g.setSARChangeListener(r102);     // Catch: Exception -> L21
        this.f438689g.setListener(r102);     // Catch: Exception -> L21
        n(1);     // Catch: Exception -> L21
        String r103 = r100.getData();     // Catch: Exception -> L21
        Uri r104 = r100.getUri();     // Catch: Exception -> L21
        FileDescriptor r105 = r100.getFileDescriptor();     // Catch: Exception -> L21
        if (r103 == null) goto L12;
        j(r100, r103);     // Catch: Exception -> L21
    L19:
        Bundle r106 = w0c.a.a();     // Catch: Exception -> L21
        r106.putSerializable("serializable_data", r100);     // Catch: Exception -> L21
        a(-99001, r106);     // Catch: Exception -> L21
        return;
    L12:
        if (r104 == null) goto L14;
        j(r100, r104.toString());     // Catch: Exception -> L21
        goto L19
    L14:
        if (r105 == null) goto L19;
        com.ss.android.lark.player.player.a r107 = this.f438690h;     // Catch: Exception -> L21
        if (r107 == null) goto L18;
        r107.f438662a.a();     // Catch: Exception -> L21
    L18:
        this.f438689g.setDataSource(r105, r100.getStartPos(), 0);     // Catch: Exception -> L21
        goto L19
    L5:
        l();     // Catch: Exception -> L21
        g();     // Catch: Exception -> L21
        if (b() == false) goto L9;
        this.f438689g.setListener(null);     // Catch: Exception -> L21
        goto L9
    }

    public final void k(int r100) {
        if (b() == false) goto L27;
        if (r100 > 0) goto L6;
    L8:
        Log.i("TTEnginePlayer", "start: " + this.f438698p);
    L21:
        e = move-exception;
        e(e);
    L23:
        this.f438691i = 3;
        return;
    L10:
        if (b() == false) goto L23;
        int r101 = this.f438663a;     // Catch: Exception -> L21
        if (r101 != 2) goto L14;
    L19:
        f();     // Catch: Exception -> L21
        n(3);     // Catch: Exception -> L21
        a(-99004, null);     // Catch: Exception -> L21
        goto L23
    L14:
        if (r101 == 4) goto L19;
        if (r101 == 1) goto L19;
        if (r101 != 6) goto L23;
    L6:
        if (b() == false) goto L8;
        this.f438689g.setStartTime(r100);
        goto L8
    }

    public final void n(int r100) {
        this.f438663a = r100;
        Bundle r101 = w0c.a.a();
        r101.putInt("int_data", r100);
        a(-99031, r101);
        k r102 = this.f438695m;
        r102.getClass();
        if (r100 != (-2)) goto L5;
    L11:
        Log.i("LarkVideoEngineCallback", "remove task");
        r102.f438679b.removeCallbacksAndMessages(null);
    L12:
        if (r100 != (-2)) goto L14;
        ResourcePerfMonitor.VIDEO_PLAY.onEnd();
        return;
    L14:
        if (r100 != 1) goto L20;
        ResourcePerfMonitor.VIDEO_PLAY.onStart();
        return;
    L20:
        return;
    L5:
        if (r100 == (-1)) goto L11;
        if (r100 == 5) goto L11;
        if (r100 == 6) goto L11;
        goto L11
    }

    public final void j(DataSource r100, String r101) {
        Log.i("TTEnginePlayer", "setEngineUrl, dataSource: " + r100.toString() + ", urlLog: " + LarkPlayerUtils.i(r101));
        this.f438697o = r100;
        this.f438698p = r101;
        this.f438699q = r100.getCacheKeyPrefix();
        if (r101.startsWith("http") == true) goto L5;
        this.f438689g.setLocalURL(r101);
    L17:
        m();
        return;
    L5:
        if (f438688r == true) goto L7;
    L9:
        this.f438689g.setDirectURL(r101);
    L10:
        HashMap<String, String> r102 = r100.getExtra();
        if (r102 == null) goto L17;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L14:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, String> r104 = r103.next();
        this.f438689g.setCustomHeader(r104.getKey(), r104.getValue());
        goto L14
    L7:
        if (this.f438694l == false) goto L9;
        this.f438689g.setDirectUrlUseDataLoader(r101, LarkPlayerUtils.b(this.f438699q, this.f438698p));
        goto L10
    }
}
