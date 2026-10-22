package com.ss.android.lark.widget.photo.preview.video.online;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.player.LarkPlayerUtils;
import com.ss.android.lark.player.widget.VideoView;
import com.ss.android.lark.widget.photo.preview.EnterSource;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import com.ss.android.lark.widget.photo.preview.video.cover.OnlineNetworkStatusCover;
import com.ss.android.lark.widget.photo.preview.video.pip.PipModeProcessor;
import com.ss.android.lark.widget.photopicker.coordinator.PhotoPreviewCoordinator;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class f0 implements com.ss.android.lark.widget.photo.preview.video.online.c, VideoEngineInfoListener, com.ss.android.lark.player.player.m {
    public final OnlineVideoGalleryFuncListViewModel A;
    public final com.ss.android.lark.widget.photo.preview.video.online.f B;
    public final k C;
    public final c D;
    public final d E;
    public final e F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PhotoItem f447320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f447321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f447322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f447323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRequestCreator f447324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoView f447325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.widget.photo.preview.video.online.c.a f447326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vcc.a f447327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public xcc.a f447328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ss.android.lark.widget.photo.preview.video.cover.l f447329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.ss.android.lark.widget.photo.preview.video.cover.q f447330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OnlineNetworkStatusCover f447331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.ss.android.lark.widget.photo.preview.video.cover.m f447332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f447333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f447334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f447335p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f447336q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f447337r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f447338s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f447339t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OperateListener f447340u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public x f447341v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f447342w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f447343x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.ss.android.lark.widget.photo.preview.video.online.a f447344y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Handler f447345z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f447346a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f447347b = null;

        static {
            int[] r100 = new int[EnterSource.values().length];
            f447347b = r100;
            r100[EnterSource.Favorite.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L14:
            f447347b[EnterSource.Mark.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L6:
            int[] r101 = new int[Lifecycle.State.values().length];
            f447346a = r101;
            r101[Lifecycle.State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            f447346a[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class b implements k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f447348a;

        public b(f0 r100) {
            this.f447348a = r100;
        }

        public final void a(boolean r100) {
            if (r100 == false) goto L5;
            int r101 = -16777216;
        L6:
            this.f447348a.f447327h.x(r101);
            if (r100 == true) goto L9;
            this.f447348a.f447327h.v(false);
            return;
        L9:
            if (fdc.a.c(this.f447348a.f447320a) == true) goto L13;
            this.f447348a.f447327h.w(true);
            return;
        L13:
            return;
        L5:
            r101 = 0;
            goto L6
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f447349a;

        @Override // java.lang.Runnable
        public final void run() {
            Log.i("OnlineVideoGalleryView", "resetRunnable requestPause");     // Catch: Throwable -> L6
            vcc.a r100 = this.f447349a.f447327h;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.o();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(f0 r100) {
            this.f447349a = r100;
        }
    }

    public class d implements vcc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f447350a;

        public d(f0 r100) {
            this.f447350a = r100;
        }
    }

    public class e implements com.ss.android.lark.widget.photo.preview.video.pip.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.widget.photo.preview.video.pip.b f447351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f0 f447352b;

        public e(f0 r100) {
            this.f447352b = r100;
            int r101 = com.ss.android.lark.widget.photo.preview.utils.a.f447152a;
            this.f447351a = (com.ss.android.lark.widget.photo.preview.video.pip.b) com.ss.android.lark.widget.photo.preview.utils.a.c(com.ss.android.lark.widget.photo.preview.video.pip.b.class);
        }
    }

    public abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f447353a;

        public abstract String a();

        public f(f0 r100) {
            this.f447353a = r100;
        }
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void c3() {
        com.ss.android.lark.widget.photo.preview.video.cover.m r100 = this.f447332m;
        r100.f447222g.setVisibility(8);
        r100.f447221f.setVisibility(0);
        r100.q(8);
        r100.j(-66018, null);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        if (this.f447342w == false) goto L6;
        s(0);
        return;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f447345z.removeCallbacksAndMessages(null);
        vcc.a r100 = this.f447327h;
        if (r100 == null) goto L5;
        r100.s();
    L5:
        com.ss.android.lark.widget.utils.h r101 = com.ss.android.lark.widget.utils.h.f449084a;
        com.ss.android.lark.widget.utils.h.f449085b = null;
        com.ss.android.lark.widget.utils.h.f449086c = null;
        com.ss.android.lark.widget.utils.h.f449087d = null;
        com.ss.android.lark.widget.utils.h.f449088e = null;
        com.ss.android.lark.widget.utils.h.f449085b = null;
        com.ss.android.lark.widget.utils.h.f449086c = null;
        com.ss.android.lark.widget.utils.h.f449087d = null;
        com.ss.android.lark.widget.utils.h.f449088e = null;
        MediaMutex.f431631r.n(Scene.IM_Video_Play, r101);
        PhotoPreviewCoordinator.from(this.f447323d).unregisterEventHandler(this.C);
        this.f447325f.i();
        OnlineVideoGalleryFuncListViewModel r102 = this.A;
        if (r102 == null) goto L9;
        r102.destroy();
        return;
    }

    public final void finish() {
        vcc.a r100 = this.f447327h;
        if (r100 == null) goto L5;
        r100.B(false, false);
    L5:
        this.f447323d.onBackPressed();
    }

    public final OperateListener k() {
        if (this.f447341v != null) goto L6;
        this.f447341v = new x(this);
    L6:
        return this.f447341v;
    }

    public final void o() {
        if (this.f447334o == false) goto L9;
        int r100 = wcc.a.f559264a;
        String r101 = this.f447320a.getMessageIdentity().getMessageId();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        com.ss.android.lark.widget.photopicker.f.d r102 = com.ss.android.lark.widget.photopicker.f.a();
        new JSONObject().put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        r102.z();
    L7:
        this.f447334o = true;
        return;
    }

    public final void p() {
        this.f447330k.r(true, this.f447320a);
        this.f447327h.E(!this.f447335p);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void pause() {
        boolean r100 = PipModeProcessor.f447396d;
        Log.i("OnlineVideoGalleryView", "pause, inPip: " + r100);
        if (r100 == true) goto L6;
        this.f447333n = false;
        this.f447334o = true;
        this.f447345z.postDelayed(this.D, 50);
        return;
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void resume() {
        Log.i("OnlineVideoGalleryView", "resume");
        this.f447333n = true;
        this.f447345z.removeCallbacks(this.D);
        PhotoPreviewCoordinator.from(this.f447323d).setGalleryDrawableProvider(new w(this));
        if (fdc.a.c(this.f447320a) == false) goto L5;
        p();
        return;
    L5:
        this.f447330k.r(false, this.f447320a);
        if (com.ss.android.lark.widget.photopicker.f.a().t() == false) goto L10;
        com.ss.android.lark.widget.photo.preview.video.online.f r100 = this.B;
        r100.f447318b.generateFuncListItems(r100.f447317a, true);
        return;
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void y() {
        FragmentActivity r100 = this.f447323d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDestroyed() == false) goto L7;
        return;
    L7:
        if (this.f447323d.isFinishing() == true) goto L12;
        this.f447323d.finish();
        return;
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void k2() {
        p();
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void P3(String r100) {
        FileUtils.v(this.f447323d, r100, com.ss.android.lark.widget.photopicker.entity.d.f447523c);
        LKUIToast.show(this.f447323d, R.string.Lark_Legacy_SaveSuccess);
        com.ss.android.lark.widget.photo.preview.video.cover.m r101 = this.f447332m;
        r101.f447222g.setVisibility(8);
        r101.f447221f.setVisibility(0);
        r101.q(8);
        r101.j(-66018, null);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void f4(int r100) {
        com.ss.android.lark.widget.photo.preview.video.cover.m r101 = this.f447332m;
        r101.q(0);
        r101.j(-66017, null);
        r101.f447221f.setVisibility(8);
        r101.f447222g.setVisibility(0);
        r101.f447222g.setProgress(r100);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void i4(float r100) {
        vcc.a r101 = this.f447327h;
        if (r101 == null) goto L6;
        r101.t();
        return;
    }

    @Override // com.ss.ttvideoengine.VideoEngineInfoListener
    public final void onVideoEngineInfos(VideoEngineInfos r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (VideoEngineInfos.USING_MDL_HIT_CACHE_SIZE.equals(r100.getKey()) == false) goto L12;
        String r101 = r100.getUsingMDLPlayTaskKey();
        long r102 = r100.getUsingMDLHitCacheSize();
        Log.i("OnlineVideoGalleryView", "usingKey: " + r101 + ", hitCacheSize: " + r102);
        if (r102 <= 0) goto L8;
        boolean r103 = true;
    L9:
        jdc.d.f498783b = r103;
        return;
    L8:
        r103 = false;
        goto L9
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void p6(boolean r100) {
        if (this.f447320a == null) goto L50;
        final LinkedHashMap r101 = new LinkedHashMap();
        final ArrayList r102 = new ArrayList();
        String r103 = UIUtils.getString(this.f447323d, R.string.Lark_Legacy_SaveVideoMenu);
        boolean r104 = false;
        if (this.f447337r == false) goto L9;
        r102.add(new com.larksuite.component.ui.dialog.h(r103, 0));
        r101.put(r103, new a0(this));
    L9:
        if (this.f447336q == false) goto L11;
        String r105 = UIUtils.getString(this.f447323d, R.string.Lark_Legacy_Copy);
        r102.add(new com.larksuite.component.ui.dialog.h(r105, 0));
        r101.put(r105, new b0(this));
    L11:
        MessageIdentity r106 = this.f447320a.getMessageIdentity();
        if (r106 != null) goto L14;
    L16:
        boolean r107 = false;
    L17:
        if (r100 == true) goto L19;
    L22:
        MessageIdentity r108 = this.f447320a.getMessageIdentity();
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L29:
        if (this.f447340u != null) goto L31;
    L34:
        if (r104 == false) goto L36;
        String r110 = UIUtils.getString(this.f447323d, R.string.Lark_Legacy_JumpToChat);
        r102.add(new com.larksuite.component.ui.dialog.h(r110));
        r101.put(r110, new d0(this));
    L36:
        boolean r111 = com.ss.android.lark.widget.photopicker.f.a().t();
        Log.i("OnlineVideoGalleryView", "isEnableForwardVideo" + r111 + " showForwardBtn:" + this.f447343x);
        if (this.f447343x == false) goto L40;
        if (r111 == false) goto L40;
        String r112 = UIUtils.getString(this.f447323d, R.string.Lark_Legacy_MenuForward);
        r102.add(new com.larksuite.component.ui.dialog.h(r112));
        r101.put(r112, new e0(this));
    L40:
        UDDialog r113 = com.ss.android.lark.widget.utils.d.a(this.f447323d, new ArrayList(r101.keySet()), new y(r102, r101), new z(this));
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L47;
        DialogLancet.handleBlockedDialogShow(r113);
        return;
    L47:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L44:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
        return;
    L31:
        if (this.f447335p == false) goto L34;
        if (r109 == true) goto L34;
        r104 = true;
        goto L34
    L25:
        if (r108.isHideJumpChat() == false) goto L27;
        r109 = true;
        goto L29
    L19:
        if (this.f447338s == false) goto L22;
        if (r107 == true) goto L22;
        String r114 = UIUtils.getString(this.f447323d, R.string.Lark_Legacy_SaveFileToDrive);
        r102.add(new com.larksuite.component.ui.dialog.h(r114));
        r101.put(r114, new c0(this));
        goto L22
    L14:
        if (r106.isHideSaveToDriver() == false) goto L16;
        r107 = true;
        goto L17
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.ss.android.lark.widget.photo.preview.video.online.m] */
    public final void s(final Integer r100) {
        VideoView r101 = this.f447325f;
        if (r101 != null) goto L5;
        return;
    L5:
        com.ss.android.lark.player.player.v r102 = r101.f438748a;
        boolean r103 = false;
        if (r102.f() == false) goto L17;
        com.ss.android.lark.player.player.s r104 = r102.f438710a;
        if (r104.b() == true) goto L10;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L17;
        r103 = true;
        goto L17
    L10:
        if (r104.f438663a == (-1)) goto L14;
        if (r104.f438689g.getPlaybackState() != 1) goto L14;
        r105 = true;
    L17:
        Log.i("OnlineVideoGalleryView", "togglePlayImpl:isPlaying" + r103);
        if (r103 == false) goto L20;
        this.f447327h.o();
        com.ss.android.lark.widget.utils.h r106 = com.ss.android.lark.widget.utils.h.f449084a;
        com.ss.android.lark.widget.utils.h.f449085b = null;
        com.ss.android.lark.widget.utils.h.f449086c = null;
        com.ss.android.lark.widget.utils.h.f449087d = null;
        com.ss.android.lark.widget.utils.h.f449088e = null;
        com.ss.android.lark.widget.utils.h.f449085b = null;
        com.ss.android.lark.widget.utils.h.f449086c = null;
        com.ss.android.lark.widget.utils.h.f449087d = null;
        com.ss.android.lark.widget.utils.h.f449088e = null;
        MediaMutex.f431631r.n(Scene.IM_Video_Play, r106);
        return;
    L20:
        com.ss.android.lark.widget.utils.h.d(this.f447323d, new m(this, r100));
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f447326g = (com.ss.android.lark.widget.photo.preview.video.online.c.a) r100;
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void showToast(String r100) {
        LKUIToast.show(this.f447323d, r100);
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void w7(String r100) {
        com.ss.android.lark.widget.photopicker.f.a().j();
    }

    @Override // com.ss.android.lark.player.player.m
    public final void h(int r210, Bundle r211) {
        boolean r100 = jdc.d.f498782a;
        Log.i("PerfVideoViewMonitor", "videoPlayError, errorCode: " + r210);
        HashMap r101 = new HashMap();
        r101.put("is_seek", Boolean.valueOf(jdc.d.f498782a));
        r101.put("has_video_cache", Boolean.valueOf(jdc.d.f498783b));
        r101.put("video_engine_error", Integer.valueOf(r210));
        HashMap r110 = new HashMap();
        r110.put("video_play_waiting", Long.valueOf(System.currentTimeMillis() - jdc.d.f498784c));
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, com.ss.android.lark.appreciablelib.Scene.Chat, Event.video_play, ErrorType.SDK, ErrorLevel.Fatal, 1, null, "", "", Boolean.TRUE, null, r110, r101, DownloadErrorCode.ERROR_MAX_BYTE_LIMIT, null));
    }

    @Override // com.ss.android.lark.widget.photo.preview.video.online.c
    public final void Y7(DataSource r100, boolean r101, Integer r102) {
        if (fdc.a.c(this.f447320a) == false) goto L7;
        Log.i("OnlineVideoGalleryView", "[playVideo]item is cleaned by admin.");
        return;
    L7:
        if (this.f447327h == null) goto L12;
        if (PhotoPagerFgUtils.b() == true) goto L12;
        this.f447327h.B(true, false);
    L12:
        if (r100.isLocal() == false) goto L14;
    L25:
        this.f447325f.setDataSource(r100);
        this.f447325f.setVideoEngineInfoListener(this);
        this.f447325f.setOnErrorEventListener(this);
        if (this.f447321b == false) goto L28;
        this.f447325f.setMute(true);
    L28:
        if (r101 == true) goto L30;
        return;
    L30:
        if (this.f447327h == null) goto L34;
        VideoView r103 = this.f447325f;
        int r104 = r102.intValue();
        r103.h();
        r103.f438748a.e(r104);
        o();
        return;
    L34:
        return;
    L14:
        if (com.ss.android.lark.widget.photopicker.f.a().E() == true) goto L17;
        LKUIToast.show(this.f447323d, R.string.Lark_Chat_CantPlayVideosDueToAdminSecuritySettings);
        return;
    L17:
        FragmentActivity r105 = this.f447323d;
        int r106 = com.ss.android.lark.widget.photo.preview.video.cover.n.f447227c;
        Intrinsics.checkNotNullParameter(r105, "activity");
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        com.ss.android.lark.widget.photo.preview.video.cover.n r107 = new com.ss.android.lark.widget.photo.preview.video.cover.n(r105, r100);
        View r108 = LayoutInflater.from(r107.f447228a).inflate(R.layout.online_preloading_cover, null);
        r108.setVisibility(8);
        r108.findViewById(R.id.ctrl_close).setOnClickListener(new com.ss.android.lark.widget.photo.preview.video.cover.o(r107));
        r107.f447229b.getShowPreloading().removeObservers(r107.f447228a);
        r107.f447229b.getShowPreloading().observe(r107.f447228a, new com.ss.android.lark.widget.photo.preview.video.cover.p(r108));
        Intrinsics.checkNotNull(r108);
        View r109 = r105.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L22;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r110 = ThreadMethodProxy.currentThread();
        if (r110 == com.larus.home.impl.utils.c.f346341a) goto L22;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");
    L22:
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r109).addView(r108, new ViewGroup.LayoutParams(-1, -1));
        if (LarkPlayerUtils.d() == true) goto L25;
        this.f447325f.d(com.ss.android.lark.widget.photopicker.f.a().getUserId());
        goto L25
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.ss.android.lark.widget.photo.preview.video.online.v] */
    public f0(OnlineVideoGalleryFragment r100, PhotoItem r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, com.ss.android.lark.widget.photo.preview.video.online.a r114, OperateListener r115) {
        this.f447333n = false;
        this.f447334o = true;
        this.f447335p = true;
        this.f447336q = false;
        this.f447337r = true;
        this.f447338s = true;
        this.f447345z = new Handler();
        k r107 = new k(new b(this));
        this.C = r107;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new e(this);
        FragmentActivity r108 = r100.getActivity();
        this.f447323d = r108;
        this.f447324e = ImageLoader.with(r100);
        this.f447320a = r101;
        this.f447321b = r102;
        this.f447335p = r103;
        this.f447337r = r105;
        this.f447336q = r104;
        this.f447338s = r106;
        this.f447339t = r110;
        this.f447322c = r111;
        this.f447340u = r115;
        this.f447342w = r112;
        this.f447343x = r113;
        this.f447344y = r114;
        PhotoPreviewCoordinator.from(r108).registerEventHandler(r107);
        OnlineVideoGalleryFuncListViewModel r109 = new OnlineVideoGalleryFuncListViewModel(r101, k()).showSaveVideo(r105).showSaveToDriver(r106).showCopyVideo(r104).showForward(r113).showJumpToChat(r103);
        this.A = r109;
        this.B = new com.ss.android.lark.widget.photo.preview.video.online.f(r108, r109, new v(this));
    }
}
