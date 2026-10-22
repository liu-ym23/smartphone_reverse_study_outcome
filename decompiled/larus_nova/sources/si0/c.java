package si0;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.broadcastgame.api.xplay.LiveCoreUtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.game.servermixer.XplayRTCManager;
import com.bytedance.android.live.liveinteract.utils.l;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedVideoFrame;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.b1;
import uf2.c1;
import uf2.d0;
import uf2.m1;
import uf2.z;
import zf2.k0;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements si0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ei6.a f542099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f542100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f542101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final si0.a f542102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f542103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f542104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public si0.b.a f542105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f542106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f542107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f542108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.api.xplay.d f542109k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextureView f542110l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m1.b f542111m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d0.b f542112n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public xi6.a f542113o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SurfaceView f542114p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C7612c f542115q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompositeDisposable f542116r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Object f542117s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final XplayRTCManager f542118t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f542119u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MixStreamType f542120v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f542121w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ne0.c f542122x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j1 f542123y;

    public static final class a {
    }

    public static final class b implements d0.b.a {
        public b() {
        }
    }

    /* JADX INFO: renamed from: si0.c$c, reason: collision with other inner class name */
    public static final class C7612c {
        public C7612c() {
        }
    }

    public static final class d implements g10.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f542124a;

        @Override // g10.e
        public final void onInitReqSuccess() {
        }

        @Override // g10.e
        public final void onInitSuccess() {
        }

        public d(c r100) {
            this.f542124a = r100;
        }

        @Override // g10.e
        public final void c(int r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "data");
            if (LinkMicGameContext.Companion.d() == true) goto L5;
            return;
        L5:
            if (r100 != 8) goto L12;
            ALogger.i("XplayController", "onPlayerEvent EVENT_FIRST_FRAME");
            this.f542124a.e();
            c r102 = this.f542124a;
            XplayRTCManager r103 = r102.f542118t;
            com.bytedance.android.live.broadcastgame.api.xplay.d r104 = r102.f542109k;
            if (r104 == null) goto L9;
            String r105 = r104.getRtcExtInfo();
        L10:
            r103.e(r105);
            return;
        L9:
            r105 = null;
            goto L10
        L12:
            if (r100 != 41) goto L25;
            int r106 = r101.optInt("stream_state", 0);
            int r107 = r101.optInt("error_code", 0);
            if (r106 == 0) goto L19;
            ALogger.e("XplayController", "onPlayerEvent EVENT_MERGE_STREAM_RESULT, failed");
            if (v.a() == false) goto L21;
            f2.c("全链路服务端合流：云游戏Pod转推异常", 0);
        L21:
            ALogger.i("XplayController", "onPlayerEvent EVENT_MERGE_STREAM_RESULT, stream_state: " + r106 + ", error_code: " + r107);
            return;
        L19:
            if (v.a() == false) goto L21;
            f2.c("全链路服务端合流：云游戏Pod转推成功", 0);
            goto L21
        }
    }

    public static final class e implements si0.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f542125a;

        @Override // si0.a.b
        public final void a() {
            boolean r100 = ((Boolean) vm2.d.f555960s3.getValue(null, vm2.d.f555776a[224(0xe0, float:3.14E-43)])).booleanValue();
            String r101 = "onDetectFirstMixFrameFailed, mIsMixing: " + this.f542125a.f542101c + ", enableVideoMixerReInit: " + r100 + "mRetryCustomVideoMixerCount: " + this.f542125a.f542103e;
            ALogger.i("XplayController", r101);
            n.a.a(qi0.d.f533091a, true, "onDetectFirstMixFrameFailed", r101, 4);
            c r102 = this.f542125a;
            if (r102.f542103e > 0) goto L5;
            return;
        L5:
            if (r102.f542101c.get() == false) goto L10;
            if (r100 == false) goto L11;
            ALogger.i("XplayController", "onDetectFirstMixFrameFailed -> onReInitVideoMixer");
            c r103 = this.f542125a;
            r103.f542103e--;
            r103.h();
            this.f542125a.i();
            return;
        L11:
            return;
        }

        public e(c r100) {
            this.f542125a = r100;
        }
    }

    public static final class f implements com.bytedance.android.live.liveinteract.revenue.game.servermixer.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f542126a;

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final String a() {
            k0 r100 = this.f542126a.f542118t.f78391e;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f571726a;
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final boolean b() {
            XplayRTCManager r100 = this.f542126a.f542118t;
            if (r100.f78388b == true) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 != true) goto L11;
            return true;
        L11:
            return false;
        L5:
            if (r100.f78391e == null) goto L7;
            r101 = true;
            goto L8
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final m1.b c() {
            c r100 = this.f542126a;
            m1.b r101 = r100.f542111m;
            if (r101 == null) goto L5;
            return r101;
        L5:
            return r100.e();
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final String d() {
            k0 r100 = this.f542126a.f542118t.f78391e;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.f571727b;
        }

        public f(c r100) {
            this.f542126a = r100;
        }
    }

    public static final class g<T> implements Consumer {
        public g(c r100) {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            com.bytedance.android.live.broadcastgame.api.xplay.g r100 = (com.bytedance.android.live.broadcastgame.api.xplay.g) r210;
            if (r100 == null) goto L59;
            Intrinsics.checkNotNullParameter(r100, "$this$toLiveCoreVideoFame");
            c1 r101 = null;
            if (com.bytedance.android.live.broadcastgame.api.xplay.a.b(r100.b()) == false) goto L19;
            IByteRtcVideoFrame r102 = r100.b();
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r103 = ILiveWrappedLivePusher.a.b();
            if (r103 == null) goto L9;
            r103.getRendererCommon();
        L9:
            ILiveWrappedLivePusher r104 = ILiveWrappedLivePusher.a.b();
            if (r104 == null) goto L16;
            int r105 = r102.getWidth();
            int r106 = r102.getHeight();
            Intrinsics.checkNotNullParameter(r102, "$this$isTextureOes");
            if (Intrinsics.areEqual(r102.getPixelFormat(), IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue()) == false) goto L14;
            ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType r107 = ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType.OES;
        L15:
            r101 = r104.newTextureBufferImpl(r105, r106, r107, r102.getTextureId(), null, pi0.b.f529315a, new pi0.c(r102));
            goto L16
        L14:
            r107 = ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType.RGB;
        L16:
            r102.retain();
            ALogger.d("textureToLiveCoreVideoFame", "retain");
            ILiveWrappedLivePusher r108 = ILiveWrappedLivePusher.a.b();
            if (r108 == null) goto L60;
            r108.newVideoFrame(r101, 0, 0);
            return;
        L60:
            return;
        L19:
            ByteBuffer r109 = r100.a();
            int r110 = r100.b().getWidth();
            int r111 = r100.b().getHeight();
            int r112 = (r110 + 1) / 2;
            int r113 = (r110 * r111) + 0;
            int r114 = ((r111 + 1) / 2) * r112;
            int r115 = r113 + r114;
            if (r109 == null) goto L22;
            r109.position(0);
        L22:
            if (r109 == null) goto L24;
            r109.limit(r113);
        L24:
            if (r109 == null) goto L26;
            ByteBuffer r116 = r109.slice();
        L27:
            if (r109 == null) goto L29;
            r109.position(r113);
        L29:
            if (r109 == null) goto L31;
            r109.limit(r115);
        L31:
            if (r109 == null) goto L33;
            ByteBuffer r117 = r109.slice();
        L34:
            if (r109 == null) goto L36;
            r109.position(r115);
        L36:
            if (r109 == null) goto L38;
            r109.limit(r115 + r114);
        L38:
            if (r109 == null) goto L40;
            ByteBuffer r118 = r109.slice();
        L41:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r119 = ILiveWrappedLivePusher.a.b();
            if (r119 == null) goto L45;
            r119.newJavaI420Buffer(r110, r111, r116, r110, r117, r112, r118, r112, 0, null);
        L45:
            if (vm2.d.J0().a() == true) goto L47;
        L53:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r120 = ILiveWrappedLivePusher.a.b();
            if (r120 == null) goto L62;
            r120.newVideoFrame(null, 0, 0);
            return;
        L62:
            return;
        L47:
            if ((System.currentTimeMillis() - pi0.d.f529317a) <= 5000) goto L53;
            pi0.d.f529317a = System.currentTimeMillis();
            PolarisFileWrapper r121 = new PolarisFileWrapper("data/data/com.ss.android.ugc.aweme/files/YuvConverter" + TimeUtils.currentTimeMillis() + ".yuv");
            ALogger.d("dumpYuv", r121.getAbsolutePath());
            FileChannel r122 = new PolarisFileOutputStreamWrapper(r121, false).getChannel();     // Catch: IOException -> L51
            r122.write(null);     // Catch: IOException -> L51
            r122.write(null);     // Catch: IOException -> L51
            r122.write(null);     // Catch: IOException -> L51
            r122.close();     // Catch: IOException -> L51
        L51:
            e = move-exception;
            ALogger.e("dumpYuv", e);
            goto L53
        L40:
            r118 = null;
            goto L41
        L33:
            r117 = null;
            goto L34
        L26:
            r116 = null;
            goto L27
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f542127a;

        public h(c r100) {
            this.f542127a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            m1.b r102 = this.f542127a.e();
            ALogger.i("XplayController", "onLittleWindowSpecChanged, videoMixerDescription: " + r102);
            n.a.a(qi0.d.f533091a, true, "onLittleWindowSpecChanged", "onLittleWindowSpecChanged, videoMixerDescription: " + r102, 4);
            this.f542127a.l();
            xi6.a r103 = this.f542127a.f542113o;
            if (r103 == null) goto L5;
            r103.b();
        L5:
            this.f542127a.f542118t.d();
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f542128a;

        public i(c r100) {
            this.f542128a = r100;
        }

        public final void a() {
            if (v.a() == false) goto L6;
            f2.c("前置客户端合流：开始", 0);
        L6:
            if (vm2.d.J0().g() == false) goto L8;
        L9:
            c r100 = this.f542128a;
            r100.f542114p = new SurfaceView(this.f542128a.f542121w);
            FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(720, 1280);
            r101.gravity = 17;
            SurfaceView r102 = this.f542128a.f542114p;
            if (r102 == null) goto L12;
            r102.setLayoutParams(r101);
        L12:
            c r103 = this.f542128a;
            si0.b.a r104 = r103.f542105g;
            if (r104 == null) goto L17;
            ViewGroup r105 = r104.f542095b;
            if (r105 == null) goto L17;
            r105.addView(r103.f542114p);
        L17:
            c r106 = this.f542128a;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r107 = ILiveWrappedLivePusher.a.b();
            if (r107 == null) goto L20;
            r107.newRenderView(this.f542128a.f542114p);
        L20:
            r106.getClass();
            return;
        L8:
            if (vm2.d.J0().h() == true) goto L9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final m1.b e() {
        com.bytedance.android.live.broadcastgame.api.xplay.d r100 = this.f542109k;
        m1.b r101 = null;
        if (r100 != null) goto L27;
        Rect r102 = null;
    L6:
        if (r100 == null) goto L8;
        Rect r103 = r100.h();     // Catch: Exception -> L21
    L9:
        if (r100 == null) goto L11;
        Rect r104 = r100.i();     // Catch: Exception -> L21
    L12:
        if (r102 == null) goto L16;
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        RectF r110 = new RectF();     // Catch: Exception -> L21
        float r111 = r102.left;     // Catch: Exception -> L21
        float r112 = r104.right;     // Catch: Exception -> L21
        r110.left = r111 / r112;     // Catch: Exception -> L21
        int r113 = r102.top;     // Catch: Exception -> L21
        float r114 = r113 / r104.bottom;     // Catch: Exception -> L21
        r110.top = r114;     // Catch: Exception -> L21
        r110.right = r102.right / r112;     // Catch: Exception -> L21
        r110.bottom = ((r102.bottom - r113) / (r103.bottom - r103.top)) + r114;     // Catch: Exception -> L21
    L17:
        ALogger.i("XplayController", "currentAnchorPreviewVideoMixerDescription, rectLittleWindow: " + r102 + ", rectGameContent: " + r103 + ", rectContainer: " + r104 + ", rectNormalized: " + r110);     // Catch: Exception -> L21
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L21
        ILiveWrappedLivePusher r115 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L21
        if (r115 == null) goto L25;
        r101 = r115.newVideoMixerDescription(r110.left, r110.top, r110.right, r110.bottom, 1, 32);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ALogger.e("XplayController", "currentAnchorPreviewVideoMixerDescription", e);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r105 = ILiveWrappedLivePusher.a.b();
        if (r105 == null) goto L25;
        r101 = r105.newVideoMixerDescription(0.0f, 0.0f, 0.0f, 0.0f, 1, 32);
    L25:
        this.f542111m = r101;
        return r101;
    L16:
        r110 = new RectF();     // Catch: Exception -> L21
        goto L17
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    L27:
        r102 = r100.d();     // Catch: Exception -> L21
        goto L6
    }

    public final void g() {
        ALogger.i("XplayController", "releaseAnchorPreview");
        ei6.a r100 = this.f542099a;
        if (r100 == null) goto L9;
        xi6.c r101 = r100.t();
        if (r101 == null) goto L9;
        com.bytedance.live.livelink.kmp.impl.core.video.b r102 = r101.f();
        if (r102 == null) goto L9;
        r102.f(this.f542112n);
    L9:
        this.f542110l = null;
    }

    public final void h() {
        if (this.f542101c.get() == false) goto L58;
        ALogger.i("XplayController", "releaseMixStream");
        qi0.d r100 = qi0.d.f533091a;
        n.a.a(r100, true, "releaseMixStream", null, 12);
        if (this.f542099a != null) goto L9;
        ALogger.e("XplayController", "releaseMixStream failed, cause: client == null");
        n.a.a(r100, true, "releaseMixStreamFailed", "releaseMixStream failed, cause: client == null", 4);
        return;
    L9:
        if (v.a() == false) goto L11;
        f2.c("前置客户端合流：结束", 0);
    L11:
        Object r101 = this.f542117s;
        monitor-enter(r101);
        k(false);     // Catch: Throwable -> L55
        ei6.a r102 = this.f542099a;     // Catch: Throwable -> L55
        if (r102 == null) goto L20;
        xi6.c r103 = r102.t();     // Catch: Throwable -> L55
        if (r103 == null) goto L20;
        com.bytedance.live.livelink.kmp.impl.core.video.b r104 = r103.f();     // Catch: Throwable -> L55
        if (r104 == null) goto L20;
        r104.g(false);     // Catch: Throwable -> L55
    L20:
        xi6.a r105 = this.f542113o;     // Catch: Throwable -> L55
        if (r105 == null) goto L23;
        r105.d();     // Catch: Throwable -> L55
    L23:
        xi6.a r106 = this.f542113o;     // Catch: Throwable -> L55
        if (r106 == null) goto L26;
        r106.d();     // Catch: Throwable -> L55
    L26:
        xi6.a r107 = this.f542113o;     // Catch: Throwable -> L55
        if (r107 == null) goto L29;
        r107.a(this.f542115q);     // Catch: Throwable -> L55
    L29:
        xi6.a r108 = this.f542113o;     // Catch: Throwable -> L55
        if (r108 == null) goto L32;
        r108.f(false);     // Catch: Throwable -> L55
    L32:
        xi6.a r109 = this.f542113o;     // Catch: Throwable -> L55
        if (r109 == null) goto L35;
        r109.release();     // Catch: Throwable -> L55
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L35:
        monitor-exit(r101);
        this.f542114p = null;
        ei6.a r111 = this.f542099a;
        if (r111 == null) goto L41;
        vi6.a r112 = r111.v();
        if (r112 == null) goto L41;
        r112.f();
    L41:
        j(true);
        if (vm2.d.J0().b() == false) goto L54;
        com.bytedance.android.live.broadcastgame.api.xplay.i r113 = f();
        if (r113 != null) goto L47;
        ALogger.i("XplayController", "restoreLiveCoreParams failed, cause: originalLiveCoreParams is null");
        goto L54
    L47:
        ALogger.i("XplayController", "restoreLiveCoreParams, " + r113);
        n.a.a(r100, true, "restoreLiveCoreParams", "restoreLiveCoreParams, " + r113, 4);
        j<com.bytedance.android.live.pushstream.d> r114 = m.i().getLiveStream();
        if (r114 == null) goto L54;
        com.bytedance.android.live.pushstream.d r115 = r114.getValue();
        if (r115 == null) goto L54;
        d0 r116 = r115.A();
        if (r116 == null) goto L54;
        LiveCoreUtilsKt.b(r116, r113);
    L54:
        si0.a r117 = this.f542102d;
        r117.getClass();
        ALogger.i("CustomVideoMixerDetector", "onReleaseMixStream");
        r117.f542091c.removeCallbacks(r117.f542092d);
        return;
    L55:
        th = move-exception;
        throw th;
    }

    public final void i() {
        this.f542101c.get();
        if (this.f542101c.get() == false) goto L6;
        n.a.a(qi0.d.f533091a, true, "startMixStreamFailed", "mix_frame_failed_cause_is_mixing", 4);
        return;
    L6:
        qi0.a r100 = qi0.a.f533084j;
        LinkMonitorData r101 = LinkMonitorData.StartMixStream;
        HashMap r102 = new HashMap();
        r102.put("xplay_mix_stream_type", 0);
        Unit r103 = Unit.INSTANCE;
        l.a.a(r100, r101, null, null, 0, null, null, null, null, r102, 254);
        si0.a r104 = this.f542102d;
        r104.getClass();
        ALogger.i("CustomVideoMixerDetector", "onStartMixStream");
        r104.f542091c.removeCallbacks(r104.f542092d);
        r104.f542091c.postDelayed(r104.f542092d, r104.f542089a);
        com.bytedance.android.live.broadcastgame.api.xplay.i r105 = new com.bytedance.android.live.broadcastgame.api.xplay.i();
        j<com.bytedance.android.live.pushstream.d> r106 = m.i().getLiveStream();
        if (r106 == null) goto L13;
        com.bytedance.android.live.pushstream.d r107 = r106.getValue();
        if (r107 == null) goto L13;
        d0 r108 = r107.A();
        if (r108 == null) goto L13;
        LiveCoreUtilsKt.a(r108, r105);
        ALogger.i("XplayController", "startMixStream, currentLiveCoreParams: " + r105);
    L13:
        Object r109 = this.f542117s;
        monitor-enter(r109);
        b1 r110 = null;
        if (vm2.d.J0().d() == false) goto L39;
        ei6.a r111 = this.f542099a;     // Catch: Throwable -> L85
        if (r111 == null) goto L24;
        xi6.c r112 = r111.t();     // Catch: Throwable -> L85
        if (r112 == null) goto L24;
        com.bytedance.live.livelink.kmp.impl.core.video.b r113 = r112.f();     // Catch: Throwable -> L85
        if (r113 == null) goto L24;
        com.bytedance.live.livelink.kmp.impl.core.video.i r114 = r113.b();     // Catch: Throwable -> L85
    L25:
        this.f542113o = r114;     // Catch: Throwable -> L85
        ei6.a r115 = this.f542099a;     // Catch: Throwable -> L85
        if (r115 == null) goto L32;
        xi6.c r116 = r115.t();     // Catch: Throwable -> L85
        if (r116 == null) goto L32;
        com.bytedance.live.livelink.kmp.impl.core.video.b r117 = r116.f();     // Catch: Throwable -> L85
        if (r117 == null) goto L32;
        r117.g(true);     // Catch: Throwable -> L85
    L32:
        xi6.a r118 = this.f542113o;     // Catch: Throwable -> L85
        if (r118 == null) goto L35;
        r118.init();     // Catch: Throwable -> L85
    L35:
        xi6.a r119 = this.f542113o;     // Catch: Throwable -> L85
        if (r119 == null) goto L38;
        r119.f(true);     // Catch: Throwable -> L85
    L38:
        n.a.a(qi0.d.f533091a, true, "onCustomVideoFrameMixerInit", "mClient: " + this.f542099a + ", mCustomVideoFrameMixer: " + this.f542113o + ')', 4);     // Catch: Throwable -> L85
    L24:
        r114 = null;
    L39:
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L85
        ILiveWrappedLivePusher r120 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L85
        if (r120 == null) goto L59;
        b1 r121 = r120.newTEBundle();     // Catch: Throwable -> L85
        if (r121 == null) goto L59;
        com.bytedance.android.live.broadcastgame.api.xplay.i r122 = f();     // Catch: Throwable -> L85
        if (r122 == null) goto L48;
        Integer r123 = r122.c();     // Catch: Throwable -> L85
        if (r123 == null) goto L48;
        int r124 = r123.intValue();     // Catch: Throwable -> L85
    L49:
        if (r122 == null) goto L53;
        Integer r125 = r122.a();     // Catch: Throwable -> L85
        if (r125 == null) goto L53;
        int r126 = r125.intValue();     // Catch: Throwable -> L85
    L54:
        r121.b();     // Catch: Throwable -> L85
        r121.b();     // Catch: Throwable -> L85
        if (((Boolean) vm2.d.A4.getValue(null, vm2.d.f555776a[284(0x11c, float:3.98E-43)])).booleanValue() == false) goto L57;
        r121.a();     // Catch: Throwable -> L85
        r121.a();     // Catch: Throwable -> L85
    L58:
        String r127 = "startMixStream, mixerWidth: " + r124 + ", mixerHeight: " + r126 + ", originalLiveCoreParams: " + r122;     // Catch: Throwable -> L85
        ALogger.i("XplayController", r127);     // Catch: Throwable -> L85
        n.a.a(qi0.d.f533091a, true, "startMixStream", r127, 4);     // Catch: Throwable -> L85
        r110 = r121;
        goto L59
    L57:
        r121.a();     // Catch: Throwable -> L85
    L53:
        r126 = 1280;
    L48:
        r124 = 720;
    L59:
        xi6.a r128 = this.f542113o;     // Catch: Throwable -> L85
        if (r128 == null) goto L62;
        r128.e();     // Catch: Throwable -> L85
    L62:
        if (r110 == null) goto L64;
        r110.release();     // Catch: Throwable -> L85
    L64:
        xi6.a r129 = this.f542113o;     // Catch: Throwable -> L85
        if (r129 == null) goto L67;
        e();     // Catch: Throwable -> L85
        r129.g();     // Catch: Throwable -> L85
    L67:
        xi6.a r130 = this.f542113o;     // Catch: Throwable -> L85
        if (r130 == null) goto L73;
        ILiveWrappedLivePusher r131 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L85
        if (r131 == null) goto L72;
        r131.newVideoMixerDescription(0.0f, 0.0f, 1.0f, 1.0f, 0, 32);     // Catch: Throwable -> L85
    L72:
        r130.g();     // Catch: Throwable -> L85
    L73:
        k(true);     // Catch: Throwable -> L85
        monitor-exit(r109);
        xi6.a r132 = this.f542113o;
        if (r132 == null) goto L78;
        r132.c(this.f542115q);
    L78:
        ei6.a r133 = this.f542099a;
        if (r133 == null) goto L83;
        vi6.a r134 = r133.v();
        if (r134 == null) goto L83;
        r134.f();
    L83:
        j(false);
        l();
        MainThreadPostUtils.b(new i(this));
        return;
    L85:
        th = move-exception;
        throw th;
    }

    @Override // si0.b
    public final void onCreate() {
        si0.a r100 = this.f542102d;
        e r101 = new e(this);
        r100.getClass();
        ALogger.i("CustomVideoMixerDetector", "setFirstFrameDetectListener");
        r100.f542090b = r101;
        com.bytedance.android.live.broadcastgame.api.xplay.n r102 = com.bytedance.android.live.broadcastgame.api.xplay.n.f59498b;
        r102.h(this.f542119u);
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.a r103 = com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.f78395a;
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.f78395a = new f(this);
        XplayRTCManager r104 = this.f542118t;
        r104.getClass();
        ALogger.i("XplayRTCManager", WidgetCostModule.TYPE_ON_CREATE);
        r102.h(r104.f78392f);
    }

    @Override // si0.b
    public final void onDestroy() {
        ALogger.i("XplayController", LiveCommonConstants.REASON_ON_DEDTROY);
        if (this.f542104f == false) goto L5;
        n.a.a(qi0.d.f533091a, true, "onXplayControllerDestroy", null, 12);
    L5:
        g();
        h();
        ViewGroup r100 = this.f542106h;
        if (r100 == null) goto L8;
        r100.removeAllViews();
    L8:
        ViewGroup r101 = this.f542106h;
        if (r101 == null) goto L11;
        r101.setVisibility(8);
    L11:
        ViewGroup r102 = this.f542107i;
        if (r102 == null) goto L14;
        r102.removeAllViews();
    L14:
        ViewGroup r103 = this.f542107i;
        if (r103 == null) goto L17;
        r103.setVisibility(8);
    L17:
        this.f542116r.clear();
        si0.a r104 = this.f542102d;
        r104.getClass();
        ALogger.i("CustomVideoMixerDetector", "release");
        r104.f542091c.removeCallbacks(r104.f542092d);
        com.bytedance.android.live.broadcastgame.api.xplay.n r105 = com.bytedance.android.live.broadcastgame.api.xplay.n.f59498b;
        r105.f(this.f542119u);
        this.f542118t.f();
        XplayRTCManager r106 = this.f542118t;
        r106.getClass();
        ALogger.i("XplayRTCManager", LiveCommonConstants.REASON_ON_DEDTROY);
        r105.f(r106.f78392f);
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.f78395a = null;
    }

    public static com.bytedance.android.live.broadcastgame.api.xplay.i f() {
        String r100 = tc0.c.h().f545356m;
        if (r100 == null) goto L9;
        Lazy r101 = LiveCoreUtilsKt.f59435a;
        Intrinsics.checkNotNullParameter(r100, "liveCoreExtInfo");
        JSONObject r102 = new JSONObject(r100).optJSONObject("PushBase");     // Catch: Exception -> L11
        if (r102 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.xplay.i r103 = new com.bytedance.android.live.broadcastgame.api.xplay.i();     // Catch: Exception -> L11
        r103.j(Integer.valueOf(r102.optInt("videoCaptureWidth")));     // Catch: Exception -> L11
        r103.i(Integer.valueOf(r102.optInt("videoCaptureHeight")));     // Catch: Exception -> L11
        r103.f(Integer.valueOf(r102.optInt("cap_adapted_quirks")));     // Catch: Exception -> L11
        r103.g(Integer.valueOf(r102.optInt("cap_adapted_width")));     // Catch: Exception -> L11
        r103.e(Integer.valueOf(r102.optInt("cap_adapted_height")));     // Catch: Exception -> L11
        return r103;
    L9:
        return null;
    }

    public final void l() {
        if (vm2.d.J0().b() == true) goto L5;
        return;
    L5:
        this.f542101c.get();
        if (this.f542101c.get() == true) goto L9;
        ALogger.i("XplayController", "updateLiveCoreParams failed");
        return;
    L9:
        TextureView r100 = this.f542110l;
        if (r100 == null) goto L12;
        r100.getWidth();
    L12:
        TextureView r101 = this.f542110l;
        if (r101 == null) goto L15;
        r101.getHeight();
    L15:
        TextureView r102 = this.f542110l;
        int r103 = 0;
        if (r102 == null) goto L18;
        int r104 = r102.getWidth();
    L19:
        if (r104 <= 0) goto L40;
        TextureView r105 = this.f542110l;
        if (r105 == null) goto L23;
        int r106 = r105.getHeight();
    L24:
        if (r106 <= 0) goto L41;
        j<com.bytedance.android.live.pushstream.d> r107 = m.i().getLiveStream();
        if (r107 == null) goto L42;
        com.bytedance.android.live.pushstream.d r108 = r107.getValue();
        if (r108 == null) goto L43;
        d0 r109 = r108.A();
        if (r109 == null) goto L44;
        com.bytedance.android.live.broadcastgame.api.xplay.i r110 = new com.bytedance.android.live.broadcastgame.api.xplay.i();
        r110.f(1);
        TextureView r111 = this.f542110l;
        if (r111 == null) goto L34;
        int r112 = r111.getWidth();
    L35:
        r110.g(Integer.valueOf(r112));
        TextureView r113 = this.f542110l;
        if (r113 == null) goto L38;
        r103 = r113.getHeight();
    L38:
        r110.e(Integer.valueOf(r103));
        ALogger.i("XplayController", "updateLiveCoreParams, " + r110);
        n.a.a(qi0.d.f533091a, true, "updateLiveCoreParams", "updateLiveCoreParams, " + r110, 4);
        Unit r114 = Unit.INSTANCE;
        LiveCoreUtilsKt.b(r109, r110);
        return;
    L34:
        r112 = 0;
        goto L35
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L23:
        r106 = 0;
        goto L24
    L40:
        return;
    L18:
        r104 = 0;
        goto L19
    }

    @Override // si0.b
    public final void d() {
        g();
    }

    @Override // si0.b
    public final void a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r100, "parentView");
        ALogger.i("XplayController", "showAnchorPreview");
        TextureView r101 = new TextureView(this.f542121w);
        this.f542110l = r101;
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r100.addView(this.f542110l);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r102 = ILiveWrappedLivePusher.a.b();
        if (r102 == null) goto L6;
        r102.newRenderView(this.f542110l);
        return;
    }

    @Override // si0.b
    public final void b(boolean r100) {
        ALogger.i("XplayController", "updateGameState, isGameStart: " + r100);
        if (r100 == false) goto L5;
        return;
    L5:
        if (this.f542104f == false) goto L23;
        f2.c(s1.B(R.string.ttlive_open_game_failed), 0);
        ALogger.i("XplayController", "updateGameState -> stopPlugin");
        qi0.d r101 = qi0.d.f533091a;
        n.a.a(r101, true, "onGameEndStopPlugin", null, 12);
        n.a.a(r101, true, "stopPlugin", "source: multilink game stop", 4);
        ViewGroup r102 = this.f542106h;
        if (r102 == null) goto L9;
        r102.removeAllViews();
    L9:
        ViewGroup r103 = this.f542106h;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
    L12:
        ViewGroup r104 = this.f542107i;
        if (r104 == null) goto L15;
        r104.removeAllViews();
    L15:
        ViewGroup r105 = this.f542107i;
        if (r105 == null) goto L18;
        r105.setVisibility(8);
    L18:
        IMiddlewareInteractGameService r106 = (IMiddlewareInteractGameService) k.f(IMiddlewareInteractGameService.class);
        if (r106 == null) goto L24;
        r106.stopRunningPlugin("multilink game stop");
        return;
    L24:
        return;
    }

    public final void j(boolean r100) {
        if (vm2.d.J0().e() == false) goto L12;
        ALogger.i("XplayController", "updateAnchorLayerVisibility, isVisible: " + r100);
        d0 r101 = this.f542100b;
        if (r101 == null) goto L13;
        z r102 = r101.C();
        if (r102 == null) goto L14;
        z.a r103 = r102.K0();
        if (r103 == null) goto L15;
        r103.a();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void k(boolean r100) {
        n.a.a(qi0.d.f533091a, true, "updateIsMixing", "isMixing: " + r100, 4);
        this.f542101c.set(r100);
        ne0.c r101 = this.f542122x;
        int r102 = ti0.e.f545994a;
        r101.b("is_xplay_mixing", Boolean.valueOf(r100));
    }

    @Override // si0.b
    public final void c(si0.b.a r210, com.bytedance.android.live.broadcastgame.api.xplay.f r211) {
        Intrinsics.checkNotNullParameter(r210, "info");
        ALogger.i("XplayController", "onXplayVisibilityChange, isVisible: " + r210.f542094a);
        qi0.d r100 = qi0.d.f533091a;
        n.a.a(r100, true, "onXplayVisibilityChange", "isVisible: " + r210.f542094a, 4);
        int r101 = 0;
        this.f542104f = false;
        this.f542105g = r210;
        hg6.g r102 = r210.f542098e;
        String r103 = null;
        if (r102 == null) goto L5;
        ei6.a r104 = r102.V0();
    L6:
        this.f542099a = r104;
        hg6.g r105 = r210.f542098e;
        if (r105 == null) goto L13;
        ec6.b r106 = r105.R();
        if (r106 == null) goto L13;
        com.bytedance.android.live.pushstream.d r107 = gc6.b.a(r106);
        if (r107 == null) goto L13;
        d0 r108 = r107.getLiveCore();
    L14:
        this.f542100b = r108;
        this.f542106h = r210.f542095b;
        this.f542107i = r210.f542096c;
        this.f542108j = r210.f542097d;
        if (r211 == null) goto L17;
        com.bytedance.android.live.broadcastgame.api.xplay.d r109 = (com.bytedance.android.live.broadcastgame.api.xplay.d) r211.getService(com.bytedance.android.live.broadcastgame.api.xplay.d.class);
    L18:
        this.f542109k = r109;
        boolean r110 = r210.f542094a;
        if (r109 == null) goto L21;
        ViewGroup r111 = r109.j();
    L22:
        com.bytedance.android.live.broadcastgame.api.xplay.d r112 = this.f542109k;
        if (r112 == null) goto L25;
        ViewGroup r113 = r112.a();
    L26:
        ViewGroup r114 = this.f542106h;
        if (r114 != null) goto L29;
    L154:
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: xplayContainer is null");
        n.a.a(r100, true, "onXplayVisibilityChangeFailed", "xplayContainer is null", 4);
        if (r110 == false) goto L161;
        String r115 = qi0.c.f533088b;
        com.bytedance.android.live.liveinteract.utils.m.a.a(false, "show_xplay_failed_cause_xplay_container_null", 12);
        l.a.a(qi0.a.f533084j, LinkMonitorData.XplayShow, null, null, 1, null, "show_xplay_failed_cause_xplay_container_null", null, null, null, 470);
        return;
    L161:
        return;
    L29:
        if (this.f542107i == null) goto L154;
        if (r111 != null) goto L37;
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: xplayView is null, xplayInstance: " + r211 + ", mXplayExtContainerService: " + this.f542109k);
        n.a.a(r100, true, "onXplayVisibilityChangeFailed", "xplayView is null, xplayInstance: " + r211 + ", mXplayExtContainerService: " + this.f542109k, 4);
        if (r110 == false) goto L158;
        String r116 = qi0.c.f533088b;
        com.bytedance.android.live.liveinteract.utils.m.a.a(false, "show_xplay_failed_cause_xplay_view_null", 12);
        l.a.a(qi0.a.f533084j, LinkMonitorData.XplayShow, null, null, 2, null, "show_xplay_failed_cause_xplay_view_null", null, null, null, 470);
        return;
    L158:
        return;
    L37:
        if (r110 == false) goto L39;
        int r117 = 0;
    L40:
        r114.setVisibility(r117);
        ViewGroup r118 = this.f542107i;
        if (r118 == null) goto L47;
        if (r110 == true) goto L45;
        r101 = 8;
    L45:
        r118.setVisibility(r101);
    L47:
        if (r110 == false) goto L127;
        l.a.a(qi0.a.f533084j, LinkMonitorData.XplayShow, null, null, 0, null, null, null, null, null, 510);
        this.f542103e = ((Number) vm2.d.f555970t3.getValue(null, vm2.d.f555776a[225(0xe1, float:3.15E-43)])).intValue();
        this.f542104f = true;
        n.a.a(r100, true, "showXplayView", null, 12);
        ALogger.d("XplayController", "onXplayVisibilityChange, xplayView.parentView(): " + UtilityKotlinExtentionsKt.p(r111));
        Integer r119 = je0.d.h();
        if (r119 != null) goto L52;
    L54:
        ViewGroup r120 = this.f542106h;
    L56:
        if (UtilityKotlinExtentionsKt.p(r111) != null) goto L58;
    L59:
        ViewGroup r121 = UtilityKotlinExtentionsKt.p(r111);
        if (r121 == null) goto L62;
        r121.removeView(r111);
    L62:
        r111.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r120 == null) goto L65;
        r120.addView(r111);
    L65:
        if (r113 == null) goto L67;
        ViewGroup r122 = UtilityKotlinExtentionsKt.p(r113);
    L69:
        if (Intrinsics.areEqual(r122, this.f542107i) == true) goto L78;
        if (r113 == null) goto L78;
        ViewGroup r123 = UtilityKotlinExtentionsKt.p(r113);
        if (r123 == null) goto L74;
        r123.removeView(r113);
    L74:
        ViewGroup r124 = this.f542107i;
        if (r124 == null) goto L78;
        r124.addView(r113);
    L78:
        if (this.f542099a != null) goto L82;
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: client is null, rtcManager: " + r210.f542098e);
        n.a.a(r100, true, "onXplayVisibilityChangeFailed", "client is null, rtcManager: " + r210.f542098e, 4);
        return;
    L82:
        if (vm2.d.J0().f() == false) goto L96;
        ei6.a r125 = this.f542099a;
        if (r125 == null) goto L88;
        fi6.a r126 = r125.g();
        if (r126 == null) goto L88;
        MixStreamType r127 = r126.U;
    L89:
        this.f542120v = r127;
        ALogger.i("XplayController", "switchToRtcServerMixType, mMixTypeBefore: " + this.f542120v);
        n.a.a(r100, true, "switchToRtcServerMixType", "mMixTypeBefore: " + this.f542120v, 4);
        MixStreamType r128 = this.f542120v;
        MixStreamType r129 = MixStreamType.SERVER_MIX;
        if (r128 == r129) goto L96;
        ALogger.i("XplayController", "switchToRtcServerMixType start");
        ei6.a r130 = this.f542099a;
        if (r130 == null) goto L96;
        ti6.d r131 = r130.p();
        if (r131 == null) goto L96;
        r131.m(r129);
    L88:
        r127 = null;
    L96:
        com.bytedance.android.live.broadcastgame.api.xplay.d r132 = this.f542109k;
        if (r132 == null) goto L103;
        Observable<com.bytedance.android.live.broadcastgame.api.xplay.g> r133 = r132.c();
        if (r133 == null) goto L103;
        Disposable r134 = r133.subscribe(new g(this));
        if (r134 == null) goto L103;
        RxUtilKt.c(r134, this.f542116r);
    L103:
        com.bytedance.android.live.broadcastgame.api.xplay.d r135 = this.f542109k;
        if (r135 == null) goto L110;
        Observable<Unit> r136 = r135.f();
        if (r136 == null) goto L110;
        Disposable r137 = r136.subscribe(new h(this));
        if (r137 == null) goto L110;
        RxUtilKt.c(r137, this.f542116r);
    L110:
        ei6.a r138 = this.f542099a;
        if (r138 == null) goto L117;
        xi6.c r139 = r138.t();
        if (r139 == null) goto L117;
        com.bytedance.live.livelink.kmp.impl.core.video.b r140 = r139.f();
        if (r140 == null) goto L117;
        r140.a(this.f542112n);
    L117:
        com.bytedance.android.live.broadcastgame.api.xplay.d r141 = this.f542109k;
        if (r141 == null) goto L120;
        Boolean r142 = r141.g();
    L122:
        if (Intrinsics.areEqual(r142, Boolean.TRUE) == false) goto L159;
        e();
        XplayRTCManager r143 = this.f542118t;
        com.bytedance.android.live.broadcastgame.api.xplay.d r144 = this.f542109k;
        if (r144 == null) goto L126;
        r103 = r144.getRtcExtInfo();
    L126:
        r143.e(r103);
        return;
    L159:
        return;
    L120:
        r142 = null;
        goto L122
    L67:
        r122 = null;
        goto L69
    L58:
        if (Intrinsics.areEqual(UtilityKotlinExtentionsKt.p(r111), r120) == true) goto L65;
    L52:
        if (r119.intValue() != 15) goto L54;
        r120 = this.f542108j;
        goto L56
    L127:
        n.a.a(r100, true, "removeXplayView", null, 12);
        h();
        ViewGroup r145 = this.f542106h;
        if (r145 == null) goto L130;
        r145.removeAllViews();
    L130:
        ViewGroup r146 = this.f542107i;
        if (r146 == null) goto L134;
        r146.removeAllViews();
    L134:
        if (vm2.d.J0().f() == false) goto L152;
        MixStreamType r147 = this.f542120v;
        if (r147 == null) goto L152;
        ei6.a r148 = this.f542099a;
        if (r148 == null) goto L142;
        fi6.a r149 = r148.g();
        if (r149 == null) goto L142;
        MixStreamType r150 = r149.U;
    L143:
        if (r147 == r150) goto L152;
        ALogger.i("XplayController", "recoverMixType, mMixTypeBefore: " + this.f542120v);
        n.a.a(r100, true, "recoverMixType", "mMixTypeBefore: " + this.f542120v, 4);
        MixStreamType r151 = this.f542120v;
        if (r151 == null) goto L152;
        ei6.a r152 = this.f542099a;
        if (r152 == null) goto L151;
        ti6.d r153 = r152.p();
        if (r153 == null) goto L151;
        r153.m(r151);
    L151:
        this.f542120v = null;
    L142:
        r150 = null;
    L152:
        this.f542109k = null;
        this.f542116r.clear();
        this.f542118t.f();
        return;
    L39:
        r117 = 8;
        goto L40
    L25:
        r113 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
    L13:
        r108 = null;
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    public c(Context r100, ne0.c r101, DataCenter r102, j1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mStore");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "scopeProvider");
        this.f542121w = r100;
        this.f542122x = r101;
        this.f542123y = r103;
        this.f542101c = new AtomicBoolean(false);
        this.f542102d = new si0.a();
        d0.b r104 = null;
        this.f542103e = ((Number) vm2.d.f555970t3.getValue(null, vm2.d.f555776a[225(0xe1, float:3.15E-43)])).intValue();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r105 = ILiveWrappedLivePusher.a.b();
        if (r105 == null) goto L5;
        r104 = r105.newLiveCoreVideoFrameAvailableListener(new b());
    L5:
        this.f542112n = r104;
        this.f542115q = new C7612c();
        this.f542116r = new CompositeDisposable();
        this.f542117s = new Object();
        this.f542118t = new XplayRTCManager(r103);
        this.f542119u = new d(this);
    }
}
