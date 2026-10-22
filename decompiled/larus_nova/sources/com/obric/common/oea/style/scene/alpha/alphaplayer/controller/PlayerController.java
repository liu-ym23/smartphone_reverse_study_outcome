package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oja.e;
import oja.f;
import oja.g;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "Loja/b;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/os/Handler$Callback;", "", "onPause", "onResume", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerController implements oja.b, LifecycleObserver, Handler.Callback {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f396565n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f396566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f396567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qja.c f396568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public tja.a f396569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public pja.b f396570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f396571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PlayerState f396572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public nja.b f396573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f396574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f396575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PthreadHandlerThreadV2 f396576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f396577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f396578m;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerController f396579a;

        public b(PlayerController r100) {
            this.f396579a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nja.b r100 = this.f396579a.f396573h;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerController f396580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ pja.c f396581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScaleType f396582c;

        public c(PlayerController r100, pja.c r101, ScaleType r102) {
            this.f396580a = r100;
            this.f396581b = r101;
            this.f396582c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nja.b r100 = this.f396580a.f396573h;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            int r101 = this.f396581b.f529531a / 2;     // Catch: Throwable -> L6
            r100.c(this.f396582c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerController f396583a;

        public d(PlayerController r100) {
            this.f396583a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nja.b r100 = this.f396583a.f396573h;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.f396571f = false;
        this.f396575j.post(new b(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        e(c(7, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        e(c(4, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        e(c(6, null));
    }

    @Override // oja.a
    public final void resume() {
        e(c(5, null));
    }

    public final void d() {
        pja.c r100 = this.f396568c.getVideoInfo();
        tja.a r101 = this.f396569d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r101.c(r100.f529531a / 2, r100.f529532b);
        tja.a r102 = this.f396569d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L8:
        this.f396575j.post(new c(this, r100, r102.getScaleType()));
    }

    public final void g() {
        PlayerState r100 = this.f396572g;
        int r101 = oja.c.f523598b[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f396568c.start();
        this.f396571f = true;
        this.f396572g = PlayerState.STARTED;
        this.f396575j.post(new d(this));
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f396568c.start();
        this.f396572g = PlayerState.STARTED;
        return;
    L7:
        if (r101 != 3) goto L9;
    L24:
        qja.c r102 = this.f396568c;     // Catch: Exception -> L16
        PlayerState r103 = this.f396572g;     // Catch: Exception -> L16
        if (r103 != PlayerState.NOT_PREPARED) goto L14;
    L18:
        r102.f(this.f396577l);     // Catch: Exception -> L16
        r102.h(this.f396578m);     // Catch: Exception -> L16
        r102.prepareAsync();     // Catch: Exception -> L16
        return;
    L14:
        if (r103 == PlayerState.STOPPED) goto L18;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        b();
        return;
    L9:
        if (r101 == 4) goto L24;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        resume();
    }

    public PlayerController(pja.a r100) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        this.f396572g = PlayerState.NOT_PREPARED;
        this.f396575j = new Handler(Looper.getMainLooper());
        this.f396577l = new g(this);
        this.f396578m = new f(this);
        Context r101 = r100.getContext();
        this.f396566a = r101;
        LifecycleOwner r102 = r100.f529530c;
        this.f396567b = r102;
        AlphaVideoViewType r103 = r100.f529528a;
        this.f396568c = new qja.b();
        r102.getLifecycle().addObserver(this);
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2("alpha-play-thread", 10);
        this.f396576k = r104;
        Intrinsics.checkNotNull(r104);
        ThreadMethodProxy.start(r104);
        PthreadHandlerThreadV2 r105 = this.f396576k;
        Intrinsics.checkNotNull(r105);
        this.f396574i = new Handler(r105.getLooper(), this);
        int r106 = oja.c.f523597a[r103.ordinal()];
        if (r106 != 1) goto L5;
        tja.a r107 = new AlphaVideoGLSurfaceView(r101, null);
    L10:
        this.f396569d = r107;
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r107.setPlayerController(this);
        r107.setVideoRenderer(new rja.b(r107));
        e(c(1, null));
        return;
    L5:
        if (r106 != 2) goto L8;
        r107 = new AlphaVideoGLTextureView(this.f396566a, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // oja.b
    public final void a(Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        e(c(8, r100));
    }

    public final void e(Message r100) {
        PthreadHandlerThreadV2 r101 = this.f396576k;
        if (r101 != null) goto L5;
        return;
    L5:
        if (ThreadMethodProxy.isAlive(r101) == true) goto L7;
        return;
    L7:
        if (r101.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.f396574i != null) goto L11;
        this.f396574i = new Handler(r101.getLooper(), this);
    L11:
        Handler r102 = this.f396574i;
        Intrinsics.checkNotNull(r102);
        r102.sendMessageDelayed(r100, 0);
    }

    public final void f(pja.b r100) {
        this.f396568c.reset();
        PlayerState r101 = PlayerState.NOT_PREPARED;
        this.f396572g = r101;
        int r102 = this.f396566a.getResources().getConfiguration().orientation;
        Intrinsics.throwUninitializedPropertyAccessException("baseDir");
        if (1 != r102) goto L5;
        String r103 = "portPath";
    L6:
        Intrinsics.throwUninitializedPropertyAccessException(r103);
        if (TextUtils.isEmpty("nullnull") == false) goto L9;
    L23:
        b();
        return;
    L9:
        if (new PolarisFileWrapper("nullnull").exists() == false) goto L23;
        this.f396568c.c();
        this.f396568c.d();
        tja.a r104 = this.f396569d;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L15:
        if (r104.a() == false) goto L21;
        qja.c r105 = this.f396568c;
        PlayerState r106 = this.f396572g;
        if (r106 != r101) goto L19;
    L20:
        r105.f(this.f396577l);
        r105.h(this.f396578m);
        r105.prepareAsync();
        return;
    L19:
        if (r106 == PlayerState.STOPPED) goto L20;
        return;
    L21:
        this.f396570e = r100;
        return;
    L5:
        r103 = "landPath";
        goto L6
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        switch(r100.what) {
            case 1: goto L61;
            case 2: goto L46;
            case 3: goto L63;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L29;
            case 7: goto L14;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L60;
        };
    L5:
        this.f396568c.reset();
        this.f396572g = PlayerState.NOT_PREPARED;
        this.f396571f = false;
        goto L60
    L6:
        Object r101 = r100.obj;
        if (r101 == null) goto L13;
        qja.c r102 = this.f396568c;
        r102.setSurface((Surface) r101);
        pja.b r103 = this.f396570e;
        if (r103 == null) goto L11;
        f(r103);
    L11:
        this.f396570e = null;
        goto L60
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");
    L14:
        tja.a r104 = this.f396569d;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L17:
        r104.onPause();
        if (this.f396572g != PlayerState.STARTED) goto L21;
        this.f396568c.pause();
        this.f396572g = PlayerState.PAUSED;
    L21:
        if (this.f396572g != PlayerState.PAUSED) goto L23;
        this.f396568c.stop();
        this.f396572g = PlayerState.STOPPED;
    L23:
        this.f396568c.release();
        tja.a r105 = this.f396569d;
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L26:
        r105.release();
        this.f396572g = PlayerState.RELEASE;
        PthreadHandlerThreadV2 r106 = this.f396576k;
        if (r106 == null) goto L60;
        r106.quit();
        r106.interrupt();
        goto L60
    L29:
        PlayerState r107 = this.f396572g;
        int r108 = oja.c.f523600d[r107.ordinal()];
        if (r108 != 1) goto L32;
    L34:
        this.f396568c.pause();
        this.f396572g = PlayerState.PAUSED;
        goto L60
    L32:
        if (r108 == 2) goto L34;
    L38:
        PlayerState r109 = this.f396572g;
        if (oja.c.f523599c[r109.ordinal()] != 1) goto L60;
        this.f396568c.pause();
        this.f396572g = PlayerState.PAUSED;
        goto L60
    L46:
        Object r110 = r100.obj;
        if (r110 == null) goto L54;
        f((pja.b) r110);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        Log.getStackTraceString(e);
        b();
        goto L60
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
    L60:
        return true;
    L61:
        this.f396568c.b();     // Catch: Exception -> L57
    L59:
        this.f396568c.a();
        this.f396568c.c();
        this.f396568c.g(new oja.d(this));
        this.f396568c.e(new e(this));
    L57:
        e = move-exception;
        qja.b r111 = new qja.b();
        this.f396568c = r111;
        r111.b();
        e.getMessage();
        goto L59
    L63:
        d();     // Catch: Exception -> L44
        this.f396572g = PlayerState.PREPARED;     // Catch: Exception -> L44
        g();     // Catch: Exception -> L44
        Unit r112 = Unit.INSTANCE;     // Catch: Exception -> L44
    L44:
        e = move-exception;
        Log.getStackTraceString(e);
        b();
        Unit r113 = Unit.INSTANCE;
        goto L60
    L36:
        if (this.f396571f == false) goto L60;
        g();
        goto L60
    }

    public static Message c(int r100, Object r101) {
        Message r102 = Message.obtain();
        r102.what = r100;
        r102.obj = r101;
        return r102;
    }
}
