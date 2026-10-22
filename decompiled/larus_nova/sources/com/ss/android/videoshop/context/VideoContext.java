package com.ss.android.videoshop.context;

import android.R;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import cjc.f;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.videoshop.kits.autopause.VideoScreenStateController;
import com.ss.android.videoshop.log.tracer.LogTracer;
import com.ss.android.videoshop.log.tracer.PathID;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.android.videoshop.mediaview.TextureVideoView;
import com.ss.android.videoshop.mediaview.VideoPatchLayout;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.utils.Error;
import ejc.b;
import fjc.d;
import fjc.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import nic.e;
import nic.i;
import nic.l;
import nic.m;
import nic.o;
import nic.p;
import pic.c;
import vic.a;

/* JADX INFO: loaded from: classes40.dex */
public class VideoContext extends l.a implements i, WeakHandler.IHandler, LifecycleObserver, KeyEvent.Callback, e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static int f455946x = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f455947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f455948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayerHostMediaLayout f455949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimpleMediaView f455950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f455951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f455952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HelperView f455953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<LayerHostMediaLayout> f455954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Lifecycle, pic.a> f455955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<l> f455956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public xic.a f455957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VideoScreenStateController f455958l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final WeakHandler f455959m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f455960n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f455961o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f455962p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f455963q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Window.Callback f455964r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f455965s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TreeSet<Integer> f455966t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final pic.e f455967u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Set<Integer> f455968v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final KeyEvent.DispatcherState f455969w;

    public static final enum Keeper extends Enum<Keeper> implements xic.a.c, VideoScreenStateController.a {
        public static final Keeper KEEPER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Keeper[] f455970a = null;
        private VideoContext currentVideoContext;
        private final BroadcastReceiver netReceiver;
        private NetworkUtils.NetworkType networkType;
        private boolean registerNetReceiver;
        private xic.a videoAudioFocusController;
        private Map<Context, VideoContext> videoContextMap;
        private VideoScreenStateController videoScreenStateController;

        public class a extends BroadcastReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Keeper f455971a;

            public a(Keeper r100) {
                this.f455971a = r100;
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r100, Intent r101) {
                NetworkUtils.NetworkType r102 = NetworkUtils.getNetworkType(r100);
                if (Keeper.access$1400(this.f455971a) == r102) goto L5;
                Keeper.access$1402(this.f455971a, r102);
                boolean r103 = true;
            L6:
                if (r103 == true) goto L8;
                return;
            L8:
                if (Keeper.access$000(this.f455971a) == null) goto L21;
                ajc.b.a("VideoContextKeeper", "onNetWorkChanged networkType:" + r102);
                Keeper.access$000(this.f455971a).x0(new uic.l());
                Iterator r104 = ((ConcurrentHashMap) Keeper.access$000(this.f455971a).f455955i).entrySet().iterator();
            L11:
                if (r104.hasNext() == false) goto L22;
                pic.a r105 = (pic.a) ((Map.Entry) r104.next()).getValue();
                if (r105 == null) goto L11;
                r105.i(r102, Keeper.access$000(this.f455971a), r100, r101);
                goto L11
            L22:
                return;
            L21:
                return;
            L5:
                r103 = false;
                goto L6
            }
        }

        @Override // com.ss.android.videoshop.kits.autopause.VideoScreenStateController.a
        public void onScreenOn() {
        }

        static {
            Keeper r100 = new Keeper();
            KEEPER = r100;
            f455970a = new Keeper[]{r100};
        }

        public Keeper() {
            super("KEEPER", 0);
            this.videoContextMap = new HashMap();
            a r100 = new a(this);
            this.netReceiver = r100;
            if (o.f519408a == null) goto L12;
            Context r101 = o.f519408a;
            if (r101 == null) goto L12;
            if (this.videoAudioFocusController != null) goto L10;
            this.videoAudioFocusController = new xic.a(r101, this);
        L10:
            if (this.videoScreenStateController != null) goto L12;
            this.videoScreenStateController = new VideoScreenStateController(r101, this);
        L12:
            Context r102 = o.f519408a;
            IntentFilter r103 = new IntentFilter();
            r103.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (r102 == null) goto L21;
            INVOKEVIRTUAL_com_ss_android_videoshop_context_VideoContext$Keeper_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r102, r100, r103);     // Catch: Exception -> L16
            this.registerNetReceiver = true;     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public static Keeper[] values() {
            return (Keeper[]) f455970a.clone();
        }

        @Override // com.ss.android.videoshop.kits.autopause.VideoScreenStateController.a
        public void onScreenOff() {
            if (this.currentVideoContext == null) goto L10;
            ajc.b.a("VideoContextKeeper", "onScreenOff");
            Iterator r100 = ((ConcurrentHashMap) this.currentVideoContext.f455955i).entrySet().iterator();
        L6:
            if (r100.hasNext() == false) goto L16;
            m r101 = (m) ((Map.Entry) r100.next()).getValue();
            if (r101 == null) goto L6;
            r101.n(this.currentVideoContext);
            goto L6
        L16:
            return;
        }

        public xic.a getVideoAudioFocusController() {
            return this.videoAudioFocusController;
        }

        public static /* synthetic */ VideoContext access$000(Keeper r100) {
            return r100.currentVideoContext;
        }

        public static NetworkUtils.NetworkType access$100(Keeper r100) {
            Context r101 = o.f519408a;
            if (r100.registerNetReceiver == true) goto L7;
            if (r101 == null) goto L7;
            r100.networkType = NetworkUtils.getNetworkType(r101);
        L7:
            return r100.networkType;
        }

        public static /* synthetic */ NetworkUtils.NetworkType access$1400(Keeper r100) {
            return r100.networkType;
        }

        public static Keeper valueOf(String r100) {
            return (Keeper) r27.a.a(Keeper.class, r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public VideoContext getVideoContext(Context r100) {
            if (o.f519408a != null) goto L7;
            if (r100 == null) goto L7;
            o.f519408a = r100.getApplicationContext();
        L7:
            if (this.registerNetReceiver == true) goto L14;
            Context r101 = o.f519408a;
            IntentFilter r102 = new IntentFilter();
            r102.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (r101 == null) goto L14;
            INVOKEVIRTUAL_com_ss_android_videoshop_context_VideoContext$Keeper_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r101, this.netReceiver, r102);     // Catch: Exception -> L12
            this.registerNetReceiver = true;     // Catch: Exception -> L12
        L12:
            e = move-exception;
            e.printStackTrace();
        L14:
            Activity r103 = d.a(r100);
            if ((r103 instanceof LifecycleOwner) == true) goto L17;
            return null;
        L17:
            if (this.videoContextMap.containsKey(r103) == true) goto L19;
            VideoContext r104 = new VideoContext(r103);
            if (((LifecycleOwner) r103).getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) goto L23;
            this.videoContextMap.put(r103, r104);
        L23:
            return r104;
        L19:
            return this.videoContextMap.get(r103);
        }

        @Override // xic.a.c
        public void onAudioFocusGain(boolean r100) {
            if (this.currentVideoContext == null) goto L10;
            ajc.b.a("VideoContextKeeper", "onAudioFocusGain");
            Iterator r101 = ((ConcurrentHashMap) this.currentVideoContext.f455955i).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L16;
            pic.a r102 = (pic.a) ((Map.Entry) r101.next()).getValue();
            if (r102 == null) goto L6;
            r102.a(this.currentVideoContext, r100);
            goto L6
        L16:
            return;
        }

        @Override // xic.a.c
        public void onAudioFocusLoss(boolean r100) {
            if (this.currentVideoContext == null) goto L10;
            ajc.b.a("VideoContextKeeper", "onAudioFocusLoss");
            Iterator r101 = ((ConcurrentHashMap) this.currentVideoContext.f455955i).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L16;
            pic.a r102 = (pic.a) ((Map.Entry) r101.next()).getValue();
            if (r102 == null) goto L6;
            r102.g(this.currentVideoContext, r100);
            goto L6
        L16:
            return;
        }

        @Override // com.ss.android.videoshop.kits.autopause.VideoScreenStateController.a
        public void onScreenUserPresent(boolean r100) {
            if (this.currentVideoContext == null) goto L10;
            ajc.b.a("VideoContextKeeper", "onScreenUserPresent");
            Iterator r101 = ((ConcurrentHashMap) this.currentVideoContext.f455955i).entrySet().iterator();
        L6:
            if (r101.hasNext() == false) goto L16;
            m r102 = (m) ((Map.Entry) r101.next()).getValue();
            if (r102 == null) goto L6;
            r102.h(this.currentVideoContext);
            goto L6
        L16:
            return;
        }

        public static void access$1200(Keeper r100, VideoContext r101) {
            Context r102 = o.f519408a;
            if (r102 != null) goto L5;
            r100.getClass();
        L11:
            if (r101 == null) goto L17;
            r101.f455957k = r100.videoAudioFocusController;
            r101.f455958l = r100.videoScreenStateController;
            LayerHostMediaLayout r103 = r101.f455949c;
            if (r103 == null) goto L15;
            r103.setTryToInterceptPlay(true);
        L15:
            r100.currentVideoContext = r101;
            return;
        L17:
            return;
        L5:
            if (r100.videoAudioFocusController != null) goto L8;
            r100.videoAudioFocusController = new xic.a(r102, r100);
        L8:
            if (r100.videoScreenStateController != null) goto L11;
            r100.videoScreenStateController = new VideoScreenStateController(r102, r100);
            goto L11
        }

        public static /* synthetic */ NetworkUtils.NetworkType access$1402(Keeper r100, NetworkUtils.NetworkType r101) {
            r100.networkType = r101;
            return r101;
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent INVOKEVIRTUAL_com_ss_android_videoshop_context_VideoContext$Keeper_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L42:
        L36:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
            throw e;
        L40:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (r110 == null) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
            int r103 = r102.result;     // Catch: Exception -> L36
            if (r103 == 1) goto L23;
            if (r103 == 2) goto L21;
            if (r103 == 3) goto L19;
            return r100.registerReceiver(r101, r110);
        L19:
            return r102.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(r101, r110);
        L25:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
            return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
        L29:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
            return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
        L35:
            return r100.registerReceiver(r101, r110);
        }

        public static void access$1300(Keeper r100, Context r101, VideoContext r102) {
            if (r102 == null) goto L6;
            r100.getClass();
            r102.f455957k = null;
            r102.f455958l = null;
            if (r102 != r100.currentVideoContext) goto L6;
            r100.currentVideoContext = null;
        L6:
            r100.videoContextMap.remove(r101);
            Iterator<Context> r103 = r100.videoContextMap.keySet().iterator();
        L8:
            if (r103.hasNext() == false) goto L14;
            Object r104 = (Context) r103.next();
            if ((r104 instanceof LifecycleOwner) == false) goto L8;
            if (((LifecycleOwner) r104).getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L8;
            r103.remove();
            goto L8
        }
    }

    @Override // nic.l.a, nic.b
    public final void O(p r100, tic.a r101, boolean r102, int r103, boolean r104, boolean r105) {
    }

    @Override // nic.l.a, nic.b
    public final void X(p r100, tic.a r101, e r102, boolean r103, int r104, boolean r105, boolean r106) {
    }

    @Override // android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int r100, int r101, KeyEvent r102) {
        return false;
    }

    static {
        new ConcurrentHashMap();
    }

    public final void B0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 == null) goto L12;
        List<VideoPatchLayout> r101 = r100.K;
        if (r101 == null) goto L18;
        Iterator<VideoPatchLayout> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        VideoPatchLayout r103 = r102.next();
        if (r103.V() == false) goto L8;
        ajc.b.a("LayerHostMediaLayout", "pause video patch pause");
        r103.h0();
        goto L8
    L19:
        return;
    L18:
        return;
    }

    public final void E0() {
        pic.e r100 = this.f455967u;
        r100.getClass();
        ajc.b.a("VideoPrepareManager", "releaseAllPreparedVideoControllers context:" + r100.f529435i.getContext().getClass().getSimpleName() + " size:" + ((LinkedList) r100.f529429c).size());     // Catch: Exception -> L17
    L4:
        ((LinkedList) r100.f529429c).clear();
        Iterator r101 = ((HashMap) r100.f529428b).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        TextureVideoView r102 = (TextureVideoView) ((Map.Entry) r101.next()).getValue();
        if (r102 == null) goto L10;
        r102.setSurfaceTextureListener(null);
    L10:
        UIUtils.detachFromParent(r102);
        goto L6
    L11:
        ((HashMap) r100.f529428b).clear();
        Iterator r103 = ((HashMap) r100.f529427a).entrySet().iterator();
    L13:
        if (r103.hasNext() == false) goto L15;
        ((qic.a) ((Map.Entry) r103.next()).getValue()).release();
        goto L13
    L15:
        ((HashMap) r100.f529427a).clear();
    }

    public final void J0() {
        xic.a r100 = this.f455957k;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f564017c.get() != null) goto L14;
        return;
    L14:
        r100.f564016b.abandonAudioFocus(r100);     // Catch: Exception -> L10
    L12:
        r100.f564018d = true;
        r100.f564015a.removeCallbacksAndMessages(null);
        return;
    L10:
        e = move-exception;
        ajc.b.a("VideoAudioFocusController", "returnFocus error");
        e.printStackTrace();
        goto L12
    }

    public final void g0() {
        Activity r100 = d.a(this.f455948b);
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup r101 = (ViewGroup) r100.findViewById(R.id.content);
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = 0;
    L10:
        if (r102 >= r101.getChildCount()) goto L20;
        View r103 = r101.getChildAt(r102);
        if (r103 == null) goto L19;
        if (com.larus.nova.R.id.videoshop_helper_view != r103.getId()) goto L19;
        if ((r103 instanceof HelperView) == false) goto L19;
    L22:
        if (r103 != null) goto L29;
        HelperView r104 = this.f455953g;
        if (r104 != null) goto L26;
        HelperView r105 = new HelperView(this.f455948b);
        this.f455953g = r105;
        r105.setVideoContext(this);
        this.f455953g.setId(com.larus.nova.R.id.videoshop_helper_view);
    L27:
        r101.addView(this.f455953g, new ViewGroup.LayoutParams(1, 1));
        return;
    L26:
        g.a(r104);
        goto L27
    L29:
        if ((r103 instanceof HelperView) == false) goto L31;
        this.f455953g = (HelperView) r103;
        return;
    L31:
        ajc.b.b("VideoContext", "find helpview is illegal type: ".concat(r103.getClass().getSimpleName()));
        g.a(this.f455953g);
        g.a(r103);
        HelperView r106 = new HelperView(this.f455948b);
        this.f455953g = r106;
        r106.setVideoContext(this);
        this.f455953g.setId(com.larus.nova.R.id.videoshop_helper_view);
        r101.addView(this.f455953g, new ViewGroup.LayoutParams(1, 1));
        return;
    L19:
        r102 = r102 + 1;
        goto L10
    L20:
        r103 = null;
        goto L22
    }

    public final boolean isPlaying() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.V();
    }

    public final void j0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.a0() == false) goto L9;
        ajc.b.a("VideoContext", "dismiss surface capture view. post = true");
        this.f455949c.postDelayed(new pic.b(this), f455946x);
        return;
    }

    public final tic.a m0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getPlayEntity();
    }

    public final TTVideoEngine o0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVideoEngine();
    }

    public final p p0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getVideoStateInquirer();
    }

    public final void pause() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 == null) goto L6;
        r100.h0();
        return;
    }

    public final void play() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 == null) goto L6;
        r100.i0();
        return;
    }

    public final boolean s0() {
        if (this.f455947a.f555367f != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean t0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 == null) goto L10;
        qic.a r101 = r100.f456048j;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isPaused() == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean u0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 == null) goto L13;
        qic.a r101 = r100.f456048j;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101.k() == false) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    public final boolean v0() {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.Z() == true) goto L8;
        return false;
    }

    public final void k0() {
        tic.a r100 = m0();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if ((!TextUtils.isEmpty(r100.f546369g)) == false) goto L7;
    L8:
        if (r101 == true) goto L17;
        a r102 = this.f455947a;
        if (r102.f555367f != 0) goto L19;
        VideoContext r103 = r102.f555382u;
        vic.b r104 = new vic.b(r102);
        LayerHostMediaLayout r105 = r103.f455949c;
        if (r105 == null) goto L15;
        r105.o0(r104);
        return;
    L15:
        r104.run();
        return;
    L19:
        return;
    L17:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final void l0() {
        tic.a r100 = m0();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if ((!TextUtils.isEmpty(r100.f546369g)) == false) goto L7;
    L8:
        if (r101 == true) goto L11;
        this.f455947a.e(false, false);
        return;
    L11:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // nic.e
    public Context getContext() {
        return this.f455948b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoContext(Context r100) {
        this.f455959m = new WeakHandler(this);
        this.f455965s = false;
        this.f455967u = new pic.e();
        this.f455968v = new TreeSet();
        this.f455969w = new KeyEvent.DispatcherState();
        this.f455948b = r100;
        a r101 = new a(r100);
        this.f455947a = r101;
        r101.f555379r = 400;
        r101.f555369h = this;
        r101.f555382u = this;
        this.f455955i = new ConcurrentHashMap();
        this.f455956j = new CopyOnWriteArrayList();
        if (this.f455961o > 0) goto L5;
    L6:
        this.f455960n = g.d(r100);
        this.f455961o = g.c(r100);
    L24:
        ((LifecycleOwner) r100).getLifecycle().addObserver(this);     // Catch: Exception -> L9
    L10:
        this.f455966t = new TreeSet();
        this.f455954h = new ArrayList();
        this.f455967u.f529435i = this;
        if (wic.b.f559915b == null) goto L13;
    L22:
        new wic.a(r100, this);
        return;
    L13:
        monitor-enter(wic.b.class);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (wic.b.f559915b != null) goto L17;
        wic.b.f559915b = new wic.b();     // Catch: Throwable -> L19
    L17:
        monitor-exit(wic.b.class);     // Catch: Throwable -> L19
        goto L22
    L5:
        if (this.f455960n > 0) goto L24;
        goto L6
    }

    public static void h0(LayerHostMediaLayout r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.a0() == true) goto L6;
        return;
    L6:
        if (r100.f456048j != null) goto L8;
        return;
    L8:
        if (r100.getSurface() != null) goto L10;
        return;
    L10:
        if (r100.getSurface().isValid() == false) goto L17;
        r100.f456048j.u();
        return;
    }

    public static VideoContext n0(Context r100) {
        return Keeper.KEEPER.getVideoContext(r100);
    }

    public final void D0(l r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (((CopyOnWriteArrayList) this.f455956j).contains(r100) == true) goto L8;
        ((CopyOnWriteArrayList) this.f455956j).add(r100);
        return;
    }

    public final void G0(LayerHostMediaLayout r100) {
        LayerHostMediaLayout r101 = this.f455949c;
        if (r101 != null) goto L5;
    L10:
        this.f455949c = r100;
        ((ArrayList) this.f455954h).remove(r100);
        if (r100 == null) goto L22;
        StringBuilder r102 = new StringBuilder("setLayerHostMediaLayout parent hash:");
        if (r100.getParent() == null) goto L15;
        int r103 = r100.getParent().hashCode();
    L16:
        r102.append(r103);
        r102.append(" entity vid:");
        if (r100.getPlayEntity() == null) goto L19;
        String r104 = r100.getPlayEntity().f546363a;
    L20:
        r102.append(r104);
        ajc.b.c("VideoContext", r102.toString());
        goto L22
    L19:
        r104 = null;
        goto L20
    L15:
        r103 = -1;
    L22:
        if (this.f455950d != null) goto L26;
        if (r100 == null) goto L27;
        this.f455950d = r100.getParentView();
        ajc.b.a("VideoContext", "setLayerHostMediaLayout set simpleMediaView:" + this.f455950d);
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (r101.a0() == false) goto L10;
        LayerHostMediaLayout r105 = this.f455949c;
        if (r105.C != null) goto L9;
        r105.C = new f(r105, Looper.getMainLooper());
    L9:
        r105.C.sendEmptyMessageDelayed(0, 500);
        goto L10
    }

    public final void H0(int r100) {
        a r101 = this.f455947a;
        r101.f555373l = r100;
        if (g.e(r100) == false) goto L5;
    L10:
        boolean r102 = true;
    L11:
        r101.f555372k = r102;
        return;
    L5:
        if (g.f(r100) == true) goto L10;
        if (r100 == 14) goto L10;
        r102 = false;
        goto L11
    }

    public final void I0(SimpleMediaView r100) {
        this.f455950d = r100;
        StringBuilder r101 = new StringBuilder("setSimpleMediaView hash:");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.hashCode());
    L6:
        r101.append(r102);
        ajc.b.c("VideoContext", r101.toString());
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void K0(l r100) {
        if (r100 == null) goto L5;
        ((CopyOnWriteArrayList) this.f455956j).remove(r100);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        int r101 = r100.what;
        if (r101 != 100) goto L8;
        SimpleMediaView r102 = (SimpleMediaView) r100.obj;
        ajc.b.c("VideoContext", "MSG_DISPATCH_DETACH simpleMediaView:" + r102.hashCode());
        nic.a r103 = r102.getAttachListener();
        if (r103 == null) goto L16;
        r103.c(r102);
        return;
    L16:
        return;
    L8:
        if (r101 != 101) goto L13;
        SimpleMediaView r104 = (SimpleMediaView) r100.obj;
        ajc.b.c("VideoContext", "MSG_DISPATCH_ATTACH simpleMediaView:" + r104.hashCode());
        nic.a r105 = r104.getAttachListener();
        if (r105 == null) goto L18;
        r105.b(r104);
        return;
    L18:
        return;
    L13:
        if (r101 != 102) goto L20;
        this.f455967u.a(((SimpleMediaView) r100.obj).getPlayEntity());
        return;
    }

    public final void i0(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getParent() == null) goto L23;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L18;
        return;
    L18:
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L11
        return;
    L11:
        StackTraceElement[] r102 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Exception -> L15
        int r103 = r102.length;     // Catch: Exception -> L15
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L25;
        StackTraceElement r105 = r102[r104];     // Catch: Exception -> L15
        ajc.b.a("VideoContext", "class:" + r105.getClassName() + ", method:" + r105.getMethodName() + ", file:" + r105.getFileName() + ", lineNum:" + r105.getLineNumber());     // Catch: Exception -> L15
        r104 = r104 + 1;
        goto L12
    L25:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onLifeCycleOnCreate(LifecycleOwner r100) {
        ajc.b.c("VideoContext", "onLifeCycleOnCreate owner:".concat(r100.getClass().getSimpleName()));
        g0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onLifeCycleOnDestroy(LifecycleOwner r100) {
        ajc.b.c("VideoContext", "onLifeCycleOnDestroy owner:".concat(r100.getClass().getSimpleName()));
        Lifecycle r101 = r100.getLifecycle();
        Keeper.access$1300(Keeper.KEEPER, this.f455948b, this);
        E0();
        r101.removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onLifeCycleOnPause(LifecycleOwner r100) {
        ajc.b.c("VideoContext", "onLifeCycleOnPause owner:".concat(r100.getClass().getSimpleName()));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onLifeCycleOnResume(LifecycleOwner r100) {
        ajc.b.c("VideoContext", "onLifeCycleOnResume owner:".concat(r100.getClass().getSimpleName()));
        g0();
        if (s0() == false) goto L5;
        this.f455947a.c();
    L5:
        Keeper.access$1200(Keeper.KEEPER, this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onLifeCycleOnStart(LifecycleOwner r100) {
        ajc.b.c("VideoContext", "onLifeCycleOnStart owner:".concat(r100.getClass().getSimpleName()));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onLifeCycleOnStop(LifecycleOwner r100) {
        ajc.b.c("VideoContext", "onLifeCycleOnStop owner:".concat(r100.getClass().getSimpleName()));
        E0();
    }

    public final boolean q0(tic.a r100) {
        LayerHostMediaLayout r101 = this.f455949c;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        if (r100.equals(r101.getPlayEntity()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean r0(View r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.f455950d != r100) goto L6;
        return true;
    }

    public final boolean x0(uic.d r100) {
        LayerHostMediaLayout r101 = this.f455949c;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.Z() == true) goto L7;
        this.f455949c.r0(r100);
        goto L7
    }

    @Override // nic.l.a, nic.h
    public final void B(p r100, tic.a r101) {
        if (s0() == false) goto L5;
        g0();
    L5:
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((l) r102.next()).B(r100, r101);
        goto L7
    }

    public final void C0(Lifecycle r100, m.a r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        Map<Lifecycle, pic.a> r102 = this.f455955i;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r100, new pic.a(r100, r101, this));
        return;
    L8:
        return;
    }

    @Override // nic.l.a, nic.h
    public final void D(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).D(r100, r101);
        goto L4
    }

    public final void F0(int r100, boolean r101) {
        g0();
        if (this.f455953g == null) goto L9;
        if (r101 == false) goto L6;
        ((TreeSet) this.f455968v).add(Integer.valueOf(r100));
    L7:
        this.f455953g.setKeepScreenOn(!((TreeSet) this.f455968v).isEmpty());
        return;
    L6:
        ((TreeSet) this.f455968v).remove(Integer.valueOf(r100));
        goto L7
    }

    @Override // nic.l.a, nic.h
    public final void G(oic.f r100, tic.a r101) {
        a r102 = this.f455947a;
        vic.e r103 = r102.f555362a;
        if (r103.f555399d == false) goto L8;
        vic.e.a r104 = r103.f555397b;
        if (r104 == null) goto L8;
        r104.disable();
        r103.f555399d = false;
    L8:
        r102.f555362a.f555396a.remove(r102);
        J0();
        Iterator r105 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        ((l) r105.next()).G(r100, r101);
        goto L10
    }

    @Override // nic.l.a, nic.h
    public final void I(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).I(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void L(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).L(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.b
    public final void S(boolean r100, int r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).S(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void W(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).W(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void Y(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).Y(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void b(oic.f r100, tic.a r101) {
        b r102 = this.f455962p;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L10:
        if (r103 == false) goto L12;
        J0();
    L12:
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        ((l) r104.next()).b(r100, r101);
        goto L14
    L16:
        return;
    L5:
        if ((r102.f472907i & 4) == 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        r103 = true;
        goto L10
    L7:
        r105 = false;
        goto L8
    }

    @Override // nic.l.a, nic.h
    public final void e0(oic.f r100, tic.a r101) {
        VideoScreenStateController r102 = this.f455958l;
        if (r102 == null) goto L25;
        boolean r103 = true;
        PowerManager r104 = r102.f455976c;     // Catch: Exception -> L10
        if (r104 == null) goto L9;
        if (r104.isInteractive() == false) goto L11;
    L9:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L33;
    L23:
        r103 = false;
    L24:
        r102.f455978e = r103;
        r102.b();
        goto L25
    L33:
        KeyguardManager r106 = r102.f455975b;     // Catch: Throwable -> L19
        if (r106 == null) goto L18;
        if (r106.isKeyguardLocked() == false) goto L18;
    L17:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
    L18:
        r107 = false;
    L19:
        th = move-exception;
        th.printStackTrace();
    L11:
        r105 = false;
    L25:
        g0();
        this.f455947a.k();
        if (s0() == false) goto L28;
        g0();
    L28:
        Iterator r108 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L30:
        if (r108.hasNext() == false) goto L32;
        ((l) r108.next()).e0(r100, r101);
        goto L30
    }

    @Override // nic.l.a, nic.h
    public final void h(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).h(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void o(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).o(r100, r101);
        goto L4
    }

    @Override // android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L6;
        r101.startTracking();
        return true;
    L6:
        LayerHostMediaLayout r102 = this.f455949c;
        if (r102 == null) goto L9;
        r102.r0(new uic.d(308, Integer.valueOf(r100)));
    L9:
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public final boolean onKeyLongPress(int r100, KeyEvent r101) {
        LayerHostMediaLayout r102 = this.f455949c;
        if (r102 == null) goto L7;
        r102.r0(new uic.d(310, Integer.valueOf(r100)));
        return false;
    L7:
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r100, KeyEvent r101) {
        if (s0() == true) goto L5;
    L28:
        return false;
    L5:
        if (r100 == 4) goto L7;
    L25:
        LayerHostMediaLayout r102 = this.f455949c;
        if (r102 == null) goto L28;
        r102.r0(new uic.d(309, Integer.valueOf(r100)));
        goto L28
    L7:
        if (r101.isTracking() == false) goto L25;
        if (r101.isCanceled() == true) goto L25;
        LayerHostMediaLayout r103 = this.f455949c;
        if (r103 == null) goto L13;
        r103.E.b(new uic.d(307));
    L13:
        Iterator r104 = ((ConcurrentHashMap) this.f455955i).entrySet().iterator();
    L14:
        boolean r105 = false;
    L16:
        if (r104.hasNext() == false) goto L23;
        pic.a r106 = (pic.a) ((Map.Entry) r104.next()).getValue();
        if (r106 == null) goto L16;
        if (r105 == false) goto L21;
    L22:
        r105 = true;
        goto L16
    L21:
        if (r106.j(this) == false) goto L14;
    L23:
        if (r105 == false) goto L28;
        return true;
    }

    @Override // nic.l.a, nic.h
    public final void p(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).p(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void s(oic.f r100, tic.a r101) {
        b r102 = this.f455962p;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L10:
        if (r103 == false) goto L12;
        J0();
    L12:
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        ((l) r104.next()).s(r100, r101);
        goto L14
    L16:
        return;
    L5:
        if ((r102.f472907i & 8) == 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L10;
        r103 = true;
        goto L10
    L7:
        r105 = false;
        goto L8
    }

    @Override // nic.l.a, nic.h
    public final void u(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).u(r100, r101);
        goto L4
    }

    public final void w0(Lifecycle r100, uic.d r101) {
        LayerHostMediaLayout r102 = this.f455949c;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.Z() == false) goto L7;
        return;
    L7:
        if (this.f455949c.getObservedLifecycle() != r100) goto L12;
        this.f455949c.r0(r101);
        return;
    }

    @Override // nic.l.a, nic.h
    public final void y(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).y(r100, r101);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void z(oic.f r100, tic.a r101) {
        Iterator r102 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((l) r102.next()).z(r100, r101);
        goto L4
    }

    public final boolean z0(boolean r100, int r101) {
        Iterator r102 = ((ConcurrentHashMap) this.f455955i).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        pic.a r103 = (pic.a) ((Map.Entry) r102.next()).getValue();
        if (r103 == null) goto L4;
        if (r103.e(r100, r101) == false) goto L4;
        return true;
    L10:
        LayerHostMediaLayout r104 = this.f455949c;
        if (r104 != null) goto L13;
        return false;
    L13:
        Iterator r105 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        if (((l) r105.next()).c(r104.getVideoStateInquirer(), r104.getPlayEntity(), r100, r101) == false) goto L15;
        return true;
    L19:
        return false;
    }

    @Override // nic.l.a, nic.h
    public final void F(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).F(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void J(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).J(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void K(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).K(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void Q(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).Q(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void R(oic.f r100, tic.a r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).R(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void c0(oic.f r100, tic.a r101, long r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).c0(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void d(oic.f r100, tic.a r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).d(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void f(oic.f r100, tic.a r101, int r102) {
        b r103 = this.f455962p;
        boolean r104 = false;
        int r105 = 1;
        if (r103 != null) goto L5;
    L10:
        if (r104 == true) goto L12;
    L13:
        xic.a r106 = this.f455957k;
        if (r106 == null) goto L18;
        if (r103 == null) goto L17;
        r105 = r103.f472908j;
    L17:
        r106.b(r105);
    L18:
        Iterator r107 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        ((l) r107.next()).f(r100, r101, r102);
        goto L20
    L22:
        return;
    L12:
        if (r101.f546377o.f472902d == true) goto L18;
    L5:
        if ((r103.f472907i & 2) == 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == false) goto L10;
        r104 = true;
        goto L10
    L7:
        r108 = false;
        goto L8
    }

    @Override // nic.l.a, nic.d
    public final void g(oic.f r100, tic.a r101, String r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).g(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void i(oic.f r100, tic.a r101, VideoEngineInfos r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).i(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void j(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).j(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void k(oic.f r100, tic.a r101, int r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).k(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void v(oic.f r100, tic.a r101, Error r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).v(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void w(oic.f r100, tic.a r101, long r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).w(r100, r101, r102);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void x(oic.f r100, tic.a r101, boolean r102) {
        Iterator r103 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((l) r103.next()).x(r100, r101, r102);
        goto L4
    }

    public final void A0(boolean r110, int r111, boolean r112, boolean r113) {
        LayerHostMediaLayout r100 = this.f455949c;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator r101 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((l) r101.next()).X(r100.getVideoStateInquirer(), r100.getPlayEntity(), this, r110, r111, r112, r113);
        goto L7
    }

    @Override // nic.l.a, nic.d
    public final void M(oic.f r100, tic.a r101, String r102, Error r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).M(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.d
    public final void P(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).P(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.d
    public final void T(oic.f r100, tic.a r101, int r102, String r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).T(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void U(oic.f r100, tic.a r101, Resolution r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).U(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void l(oic.f r100, tic.a r101, Resolution r102, boolean r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).l(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void m(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).m(r100, r101, r102, r103);
        goto L4
    }

    @Override // nic.l.a, nic.h
    public final void q(oic.f r100, tic.a r101, int r102, int r103) {
        Iterator r104 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((l) r104.next()).q(r100, r101, r102, r103);
        goto L4
    }

    public final void y0(boolean r110, int r111, boolean r112, boolean r113) {
        if (this.f455949c != null) goto L5;
        return;
    L5:
        bjc.b r100 = bjc.b.b("OnFullScreen", PathID.ENTER_FULLSCREEN, 6);
        if (r100 == null) goto L8;
        r100.a("info", "full:" + r110 + " targetOrientation:" + r111 + " gravity:" + r112);
        LogTracer.INS.addTrace(m0(), r100);
    L8:
        ajc.b.a("VideoContext", "onFullScreen " + r110 + " gravity:" + r112);
        if (r110 == false) goto L63;
        ViewParent r101 = this.f455949c.getParent();
        if ((r101 instanceof SimpleMediaView) == false) goto L20;
        SimpleMediaView r102 = this.f455950d;
        if (r102 == null) goto L15;
        if (r101 == r102) goto L20;
    L15:
        this.f455950d = (SimpleMediaView) r101;
        StringBuilder r103 = new StringBuilder("onFullScreen SimpleMediaView hash:");
        SimpleMediaView r104 = this.f455950d;
        if (r104 == null) goto L18;
        Object r105 = Integer.valueOf(r104.hashCode());
    L19:
        r103.append(r105);
        ajc.b.a("VideoContext", r103.toString());
        goto L20
    L18:
        r105 = "null simpleMediaView";
    L20:
        Context r106 = this.f455948b;
        if (this.f455951e == null) goto L23;
    L36:
        ViewGroup r107 = this.f455952f;
        if (r107 == null) goto L42;
        View r108 = this.f455952f.getChildAt(r107.getChildCount() - 1);
        FrameLayout r109 = this.f455951e;
        if (r108 == r109) goto L42;
        if (r109 == null) goto L42;
        UIUtils.detachFromParent(r109);
        this.f455952f.addView(this.f455951e, new ViewGroup.LayoutParams(-1, -1));
    L42:
        Activity r114 = d.a(this.f455948b);
        if (r114 == null) goto L57;
        Window.Callback r115 = r114.getWindow().getCallback();
        if (r115 != null) goto L48;
        r115 = r114;
    L48:
        c r116 = this.f455963q;
        if (r116 != null) goto L51;
    L52:
        this.f455964r = r115;
        this.f455963q = new c(this, r115);
    L54:
        if (this.f455963q == null) goto L57;
        r114.getWindow().setCallback(this.f455963q);
        goto L57
    L51:
        if (r115 == r116.f529439a) goto L54;
    L57:
        if (this.f455950d == null) goto L62;
        h0(this.f455949c);
        SimpleMediaView r117 = this.f455950d;
        if (r117.f455992c == null) goto L61;
        r117.removeAllViews();
        r117.f455992c.setParentView(null);
        r117.f455992c = null;
    L61:
        g0();
    L62:
        ajc.b.a("VideoContext", "detachFromParent fullscreen: true");
        h0(this.f455949c);
        i0(this.f455949c);
        this.f455951e.addView(this.f455949c, new ViewGroup.LayoutParams(-1, -1));
        ajc.b.a("VideoContext", "fullScreenRoot addView:" + this.f455951e);
    L86:
        System.currentTimeMillis();
        LayerHostMediaLayout r118 = this.f455949c;
        boolean r119 = this.f455947a.f555368g;
        r118.E.b(new uic.i());
        Iterator r120 = ((CopyOnWriteArrayList) this.f455956j).iterator();
    L88:
        if (r120.hasNext() == false) goto L90;
        ((l) r120.next()).O(this.f455949c.getVideoStateInquirer(), this.f455949c.getPlayEntity(), r110, r111, r112, r113);
        goto L88
    L90:
        Iterator r121 = ((ConcurrentHashMap) this.f455955i).entrySet().iterator();
    L92:
        if (r121.hasNext() == false) goto L96;
        pic.a r122 = (pic.a) ((Map.Entry) r121.next()).getValue();
        if (r122 == null) goto L92;
        r122.k(r110, r111, r112);
        goto L92
    L96:
        return;
    L23:
        if (this.f455952f != null) goto L28;
        Activity r123 = d.a(r106);
        if (r123 == null) goto L36;
        this.f455952f = (ViewGroup) r123.findViewById(R.id.content);
    L28:
        ViewGroup r124 = this.f455952f;
        if (r124 == null) goto L31;
        View r125 = r124.findViewById(com.larus.nova.R.id.videoshop_fullscreen_view);
    L33:
        if ((r125 instanceof FrameLayout) == false) goto L35;
        this.f455951e = (FrameLayout) r125;
        goto L36
    L35:
        FrameLayout r126 = new FrameLayout(r106);
        this.f455951e = r126;
        r126.setId(com.larus.nova.R.id.videoshop_fullscreen_view);
        goto L36
    L31:
        r125 = null;
        goto L33
    L63:
        Window.Callback r127 = this.f455964r;
        if (r127 == null) goto L74;
        c r128 = this.f455963q;
        if (r128 == null) goto L74;
        if (r128.f529439a != r127) goto L74;
        Activity r129 = d.a(this.f455948b);
        if (r129 == null) goto L74;
        r129.getWindow().setCallback(this.f455964r);
    L74:
        if (this.f455961o > 0) goto L76;
    L77:
        this.f455960n = g.d(this.f455948b);
        this.f455961o = g.c(this.f455948b);
    L78:
        this.f455947a.getClass();
        StringBuilder r130 = new StringBuilder("detachFromParent fullscreen: false, parent:");
        LayerHostMediaLayout r131 = this.f455949c;
        if (r131 == null) goto L81;
        Object r132 = r131.getParent();
    L82:
        r130.append(r132);
        ajc.b.a("VideoContext", r130.toString());
        h0(this.f455949c);
        i0(this.f455949c);
        SimpleMediaView r133 = this.f455950d;
        if (r133 == null) goto L85;
        r133.a(this.f455949c);
        ajc.b.a("VideoContext", "simpleMediaView attachLayerHostLayout");
    L85:
        a r134 = this.f455947a;
        r134.f555367f = 0;
        r134.i();
        goto L86
    L81:
        r132 = "null";
        goto L82
    L76:
        if (this.f455960n > 0) goto L78;
        goto L77
    }
}
