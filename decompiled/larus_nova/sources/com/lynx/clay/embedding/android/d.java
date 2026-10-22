package com.lynx.clay.embedding.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f380642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterEngine f380643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlutterView f380644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f380645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f380646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f380647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f380648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FlutterFunctorView f380649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.lynx.clay.embedding.android.c f380650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f380651j;

    public class a implements s5a.b {
        @Override // s5a.b
        public final void a() {
        }

        @Override // s5a.b
        public final void b() {
        }

        public a() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f380652a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f380652a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r100) {
            this.f380652a = r100;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f380653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RenderMode f380654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f380655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HashMap<String, String> f380656d;

        public c(RenderMode r100, boolean r101, HashMap r102) {
            this.f380653a = false;
            this.f380654b = r100;
            this.f380655c = r101;
            this.f380656d = r102;
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.android.d$d, reason: collision with other inner class name */
    public static class C4545d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<FlutterEngine> f380657a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f380658b;

        static {
            f380657a = new ArrayList();
            f380658b = false;
        }
    }

    public final void a() {
        Context r100 = this.f380642a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f380643b == null) goto L41;
        Object r101 = com.lynx.clay.util.a.f380953a;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L14;
        b r103 = new b(this);
        com.lynx.clay.util.a.a().post(r103);
        return;
    L14:
        Context r104 = r100.getApplicationContext();
        d5a.c r105 = d5a.c.f467088h;
        if (r104 == null) goto L17;
        r100 = r104;
    L17:
        r105.getClass();
        if (r105.f467093e == true) goto L34;
        r105.f467093e = true;
        r100.getApplicationContext().registerComponentCallbacks(r105.f467095g);
        if (r105.f467092d == true) goto L34;
        ActivityManager.RunningAppProcessInfo r106 = new ActivityManager.RunningAppProcessInfo();     // Catch: Exception -> L36
        ActivityManager.getMyMemoryState(r106);     // Catch: Exception -> L36
        int r107 = r106.lastTrimLevel;     // Catch: Exception -> L36
        if (r107 < 80) goto L24;
    L29:
        Integer r108 = 2;     // Catch: Exception -> L36
    L32:
        if (r108 == null) goto L34;
        r105.a(r108.intValue());
        goto L34
    L24:
        if (r107 == 15) goto L29;
        if (r107 < 40) goto L31;
        r108 = 1;     // Catch: Exception -> L36
        goto L32
    L39:
        r108 = null;
    L31:
        r108 = null;
    L34:
        this.f380646e = true;
        return;
    L10:
        r102 = false;
        goto L11
    }

    public final void b() {
        if (this.f380642a == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
    }

    public d(Context r100, RenderMode r101, boolean r102) {
        boolean r103 = false;
        this.f380646e = false;
        this.f380647f = false;
        this.f380648g = 0;
        this.f380650i = new com.lynx.clay.embedding.android.c();
        this.f380651j = new a();
        this.f380642a = r100;
        JSONObject r104 = c5a.b.a().f22526a.b();     // Catch: Exception -> L13
        if (r104 == null) goto L26;
        String r105 = r104.optString("renderMode", DocumentType.DOCX_SYNC_BLOCK_NAME);     // Catch: Exception -> L13
        if ("surface".equalsIgnoreCase(r105) == false) goto L9;
        r101 = RenderMode.surface;     // Catch: Exception -> L13
        goto L26
    L9:
        if (VideoSurfaceTexture.KEY_TEXTURE.equalsIgnoreCase(r105) == false) goto L11;
        r101 = RenderMode.texture;     // Catch: Exception -> L13
        goto L26
    L11:
        r101 = RenderMode.sync;     // Catch: Exception -> L13
    L26:
    L16:
        if (r101 != RenderMode.sync) goto L24;
        FlutterFunctorView r106 = new FlutterFunctorView(r100);
        this.f380649h = r106;
        if (r106.f380559e != (-1)) goto L20;
    L22:
        if (r103 == true) goto L24;
        r101 = RenderMode.texture;
        goto L24
    L20:
        if (r106.f380558d == (-1)) goto L22;
        r103 = true;
    L24:
        this.f380645d = new c(r101, r102, new HashMap());
        return;
    L13:
        e = move-exception;
        c5a.c.f("ClayViewProvider", "Failed to determine render mode from clay settings; keeping fallback.", e);
        goto L16
    }
}
