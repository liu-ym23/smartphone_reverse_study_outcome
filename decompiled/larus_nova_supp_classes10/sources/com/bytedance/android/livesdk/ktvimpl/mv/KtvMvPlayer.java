package com.bytedance.android.livesdk.ktvimpl.mv;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreLoaderItemCallBackInfo;
import com.ss.ttvideoengine.PreloaderVidItem;
import com.ss.ttvideoengine.PreloaderVidItemListener;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.VideoInfoListener;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvMvPlayer extends com.bytedance.android.livesdk.ktvapi.model.mv.h<KtvMvPlayer> implements com.bytedance.android.live.ktv.common.util.c {
    public static final /* synthetic */ int A = 0;
    public String g;
    public int h;
    public final int i;
    public final boolean j;
    public Function1<? super Integer, Unit> k;
    public Function2<? super Boolean, ? super Long, Unit> l;
    public final String m;
    public Long n;
    public final boolean o;
    public final Function1<? super Integer, Unit> p;
    public final ArrayList<Function1<Integer, Unit>> q;
    public final ArrayList<Function1<com.bytedance.android.livesdk.ktvapi.model.mv.n, Unit>> r;
    public final g s;
    public final b t;
    public final CopyOnWriteArrayList<String> u;
    public final d v;
    public final c w;
    public final Lazy x;
    public Disposable y;
    public final boolean z;

    public static final class a {
    }

    public static final class b extends w {
        public final /* synthetic */ KtvMvPlayer a;

        public b(KtvMvPlayer r1) {
            this.a = r1;
        }

        public final void onError(Error r8) {
            com.bytedance.android.live.ktv.common.util.g.d("onError:" + r8);
            Disposable r0 = this.a.y;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            KtvMvPlayer r1 = this.a;
            String r2 = null;
            r1.g = null;
            IMediaPlayer.OnErrorListener r3 = ((AbsPlayer) r1).e;
            if (r3 == null) goto L18;
            int r4 = 0;
            if (r8 == null) goto L10;
            int r5 = r8.code;
        L11:
            if (r8 == null) goto L13;
            r4 = r8.internalCode;
        L13:
            StringBuilder r6 = new StringBuilder("play error:");
            if (r8 == null) goto L16;
            r2 = r8.description;
        L16:
            r6.append(r2);
            r3.a(r1, r5, r4, r6.toString());
            return;
        L10:
            r5 = 0;
            goto L11
        }

        public final void onPrepare(TTVideoEngine r1) {
            com.bytedance.android.live.ktv.common.util.g.d("onPrepare");
        }

        public final void onPrepared(TTVideoEngine r6) {
            com.bytedance.android.live.ktv.common.util.g.d("onPrepared");
            KtvMvPlayer r0 = this.a;
            IMediaPlayer.OnPreparedListener r1 = ((AbsPlayer) r0).d;
            if (r1 == null) goto L5;
            r1.a(r0);
        L5:
            if (r6 == null) goto L10;
            int r7 = r6.getDuration();
            Iterator<Function1<com.bytedance.android.livesdk.ktvapi.model.mv.n, Unit>> r2 = this.a.r.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            r2.next().invoke(new com.bytedance.android.livesdk.ktvapi.model.mv.n(r7));
            goto L8
        L12:
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onRenderStart(TTVideoEngine r6) {
            Long r0 = this.a.n;
            if (r0 == null) goto L5;
            com.bytedance.android.live.ktv.common.util.g.d("render duration:" + (System.currentTimeMillis() - r0.longValue()));
        L5:
            StringBuilder r1 = new StringBuilder("onRenderStart, vid: ");
            if (r6 == null) goto L8;
            String r7 = r6.getVideoID();
        L9:
            r1.append(r7);
            com.bytedance.android.live.ktv.common.util.g.d(r1.toString());
            KtvMvPlayer r8 = this.a;
            IMediaPlayer.OnFirstFrameListener r2 = ((AbsPlayer) r8).f;
            if (r2 == null) goto L12;
            r2.a(r8);
        L12:
            this.a.t();
            return;
        L8:
            r7 = null;
            goto L9
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onVideoStatusException(int r4) {
            com.bytedance.android.live.ktv.common.util.g.d("onVideoStatusException:" + r4);
            Disposable r0 = this.a.y;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            KtvMvPlayer r1 = this.a;
            r1.g = null;
            IMediaPlayer.OnErrorListener r2 = ((AbsPlayer) r1).e;
            if (r2 == null) goto L9;
            r2.a(r1, r4, r4, "onVideoStatusException");
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onBufferingUpdate(TTVideoEngine r2, int r3) {
            if (r3 != 100) goto L6;
            com.bytedance.android.live.ktv.common.util.g.d("onBufferingUpdate" + r3);
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onFrameDraw(int r3, Map<Object, Object> r4) {
            Function2<? super Boolean, ? super Long, Unit> r5 = this.a.l;
            if (r5 == null) goto L8;
            if (r5 == null) goto L6;
            Unit r6 = (Unit) r5.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        L6:
            this.a.l = null;
            return;
        }

        public final void onPlaybackStateChanged(TTVideoEngine r2, int r3) {
            com.bytedance.android.live.ktv.common.util.g.d("onPlaybackStateChanged:" + r3);
            if (r3 != 0) goto L7;
            KtvMvPlayer r4 = this.a;
            IMediaPlayer.OnCompletionListener r0 = ((AbsPlayer) r4).c;
            if (r0 == null) goto L7;
            r0.a(r4);
        L7:
            Function1<? super Integer, Unit> r5 = this.a.k;
            if (r5 == null) goto L11;
            Unit r6 = (Unit) r5.invoke(Integer.valueOf(r3));
            return;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onVideoURLRouteFailed(Error r1, String r2) {
            this.a.g = null;
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onBufferStart(int r1, int r2, int r3) {
            com.bytedance.android.live.ktv.common.util.g.d("onBufferStart");
        }

        @Override // com.bytedance.android.livesdk.ktvimpl.mv.w
        public final void onFrameAboutToBeRendered(TTVideoEngine r1, int r2, long r3, long r5, Map<Integer, String> r7) {
            Function2<? super Boolean, ? super Long, Unit> r4 = this.a.l;
            if (r4 == null) goto L8;
            if (r4 == null) goto L6;
            Unit r6 = (Unit) r4.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        L6:
            this.a.l = null;
            return;
        }
    }

    public static final class c implements VideoEngineInfoListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void onVideoEngineInfos(VideoEngineInfos r6) {
            if (r6 == null) goto L4;
            String r0 = r6.getKey();
        L6:
            if (Intrinsics.areEqual(r0, "mdlhitcachesize") == false) goto L9;
            com.bytedance.android.live.ktv.common.util.g.d("usingKey: " + r6.getUsingMDLPlayTaskKey() + ",hitCacheSize:" + r6.getUsingMDLHitCacheSize() + ", usingPath:" + r6.getmUsingMDLPlayFilePath());
            return;
        L9:
            return;
        L4:
            r0 = null;
            goto L6
        }
    }

    public static final class d implements VideoInfoListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final boolean onFetchedVideoInfo(VideoModel r1) {
            com.bytedance.android.live.ktv.common.util.g.d(r1.toString());
            return false;
        }
    }

    public static final class e implements IPreLoaderItemCallBackListener {
        public final /* synthetic */ KtvMvPlayer a;
        public final /* synthetic */ u b;
        public final /* synthetic */ IPreLoaderItemCallBackListener c;

        public e(KtvMvPlayer r1, u r2, IPreLoaderItemCallBackListener r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void preloadItemInfo(PreLoaderItemCallBackInfo r4) {
            StringBuilder r0 = new StringBuilder("preload callback key:id:");
            r0.append(this.b.a);
            r0.append("--");
            String r1 = null;
            if (r4 == null) goto L5;
            Integer r2 = Integer.valueOf(r4.getKey());
        L6:
            r0.append(r2);
            com.bytedance.android.live.ktv.common.util.g.d(r0.toString());
            IPreLoaderItemCallBackListener r3 = this.c;
            if (r3 == null) goto L9;
            r3.preloadItemInfo(r4);
        L9:
            if (r4 != null) goto L11;
        L19:
            if (r4 != null) goto L21;
        L26:
            if (r4 != null) goto L28;
            return;
        L28:
            if (r4.getKey() != 3) goto L34;
            com.bytedance.android.live.ktv.common.util.g.d("preload error " + r4.preloadError);
            u r5 = this.b;
            v r6 = r5.d;
            this.a.u.remove(r5.a);
            return;
        L34:
            return;
        L21:
            if (r4.getKey() != 6) goto L26;
            StringBuilder r7 = new StringBuilder("preload info:");
            DataLoaderHelper.DataLoaderTaskProgressInfo r8 = r4.preloadDataInfo;
            if (r8 == null) goto L25;
            r1 = r8.mLocalFilePath;
        L25:
            r7.append(r1);
            com.bytedance.android.live.ktv.common.util.g.d(r7.toString());
            com.bytedance.android.live.ktv.common.util.g.d("preload info,size:" + r4.videoPreloadSize);
            return;
        L11:
            if (r4.getKey() != 2) goto L19;
            String r9 = this.b.a;
            DataLoaderHelper.DataLoaderTaskProgressInfo r10 = r4.preloadDataInfo;
            if (r10 == null) goto L16;
            r1 = r10.mVideoId;
        L16:
            if (Intrinsics.areEqual(r9, r1) == false) goto L18;
            v r11 = this.b.d;
        L18:
            com.bytedance.android.live.ktv.common.util.g.d("preload success:" + this.b.d);
            this.a.u.remove(this.b.a);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class f implements PreloaderVidItemListener {
        public final /* synthetic */ KtvMvPlayer a;
        public final /* synthetic */ u b;
        public final /* synthetic */ IPreLoaderItemCallBackListener c;

        public final void onUsingUrlInfos(List<VideoInfo> r2) {
            if (r2 != null) goto L4;
        L7:
            com.bytedance.android.live.ktv.common.util.g.e("onUsingUrlInfos url is null");
            return;
        L4:
            if (r2.isEmpty() != true) goto L7;
        }

        public final String authString(String r1, int r2) {
            String r3 = this.b.b;
            if (r3 != null) goto L6;
            return "";
        L6:
            return r3;
        }

        public f(KtvMvPlayer r1, u r2, IPreLoaderItemCallBackListener r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final String apiString(Map<String, String> r2, String r3, int r4) {
            KtvMvPlayer r5 = this.a;
            String r6 = this.b.b;
            r5.getClass();
            return String.format("https://open.bytedanceapi.com/?%s", new Object[]{r6});
        }
    }

    public static final class g implements SeekCompletionListener {
        public g() {
        }

        public final void onCompletion(boolean r1) {
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ KtvMvPlayer a;

        public h(KtvMvPlayer r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            KtvMvPlayer r4 = this.a;
            Function1<? super Integer, Unit> r0 = r4.p;
            if (r0 == null) goto L6;
            Unit r5 = (Unit) r0.invoke(Integer.valueOf(r4.o().getCurrentPlaybackTime()));
            return;
        }
    }

    static {
    }

    public final TTVideoEngine o() {
        return (TTVideoEngine) this.x.getValue();
    }

    public final void release() {
        Disposable r0 = this.y;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (KtvSettingHelper.r().booleanValue() == false) goto L8;
        o().setSurfaceHolder(null);
    L8:
        o().setVideoEngineCallback(null);
        o().setDataSource(new k());
        o().release();
        this.q.clear();
        this.r.clear();
        if (this.j == false) goto L14;
        ArrayList r1 = new ArrayList(this.u);
        this.u.clear();
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        TTVideoEngine.cancelPreloadTaskByVideoId((String) r2.next());
        goto L12
    L16:
        return;
    }

    public final void t() {
        Disposable r0 = this.y;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (KtvSettingHelper.z() == true) goto L8;
    L10:
        this.y = du2.a.b(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        return;
    L8:
        if (this.q.isEmpty() == false) goto L10;
    }

    public final int h() {
        return o().getDuration();
    }

    public final boolean isPlaying() {
        if (o().getPlaybackState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String n() {
        return o().getVideoID();
    }

    public final void pause() {
        o().pause();
        Disposable r0 = this.y;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void r() {
        if (n() == null) goto L10;
        if (n().length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L11:
        o().play();
        t();
        return;
    L7:
        r0 = false;
    L10:
        if (o().isPrepared() == true) goto L11;
    }

    public final void start() {
        o().play();
        t();
    }

    public final void stop() {
        o().stop();
    }

    public final void b() {
        o();
    }

    public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.l;
    }

    public final String getTypeName() {
        return this.m;
    }

    public final void j() {
        r();
    }

    public final void i(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.q.remove(r2);
    }

    public final void k(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.q.add(r2);
    }

    public final void l(Function1<? super com.bytedance.android.livesdk.ktvapi.model.mv.n, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.r.add(r2);
    }

    public final void m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vId");
        if (this.u.contains(r2) == true) goto L5;
        return;
    L5:
        if (this.j == false) goto L9;
        com.bytedance.android.live.ktv.common.util.g.d("cancelPreload");
        TTVideoEngine.cancelPreloadTaskByVideoId(r2);
        this.u.remove(r2);
        return;
    }

    public final void q(t r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        com.bytedance.android.live.ktv.common.util.g.d("requestPlay：" + r4);
        String r0 = r4.c;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        o().setDirectURL(r4.a);
    L11:
        this.g = r4.a;
        this.n = Long.valueOf(System.currentTimeMillis());
        o().play();
        return;
    L5:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r0);
        if (r1.exists() == false) goto L13;
    L10:
        o().setDirectUrlUseDataLoader(r4.a, r4.b);
        goto L11
    L13:
        r1.mkdirs();     // Catch: Exception -> L9
    L9:
        com.bytedance.android.live.ktv.common.util.g.e("mkdirs mv file fail");
        goto L10
    }

    public final void s(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        o().setSurfaceHolder(r2);
    }

    public final void seekTo(int r3) {
        o().seekTo(r3, this.s);
    }

    public final void setDataSource(String r2) {
        o().setDirectURL(r2);
    }

    public final void setLooping(boolean r2) {
        o().setLooping(r2);
    }

    public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.l = r1;
    }

    public final void setSurface(Surface r2) {
        o().setSurface(r2);
    }

    public final void u(int r3) {
        com.bytedance.android.live.ktv.common.util.g.d("updateScaleType:" + r3 + "--" + this.h);
        if (this.h == r3) goto L6;
        this.h = r3;
        o().setIntOption(4, r3);
        return;
    }

    public KtvMvPlayer(final Context r5, final HashMap<Integer, Integer> r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.h = 2;
        ReadOnlyProperty r0 = vm2.h.w2;
        KProperty[] r1 = vm2.h.a;
        this.i = ((Number) r0.getValue(null, r1[177(0xb1, float:2.48E-43)])).intValue();
        this.j = ((Boolean) vm2.h.j4.getValue(null, r1[268(0x10c, float:3.76E-43)])).booleanValue();
        this.m = "mv";
        this.o = ((Boolean) vm2.h.k4.getValue(null, r1[269(0x10d, float:3.77E-43)])).booleanValue();
        this.p = new KtvMvPlayer$progressCallback$1(this);
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new g();
        this.t = new b(this);
        this.u = new CopyOnWriteArrayList();
        this.v = d.a;
        this.w = c.a;
        this.x = LazyKt.lazy(new KtvMvPlayer$videoEngine$2(this, r5, r6));
        this.z = ((Boolean) vm2.h.Y1.getValue(null, r1[153(0x99, float:2.14E-43)])).booleanValue();
    }

    public final PreloaderVidItem p(u r9, Long r10, IPreLoaderItemCallBackListener r11) {
        Intrinsics.checkNotNullParameter(r9, "request");
        if (TTVideoEngine.dataLoaderIsRunning() == false) goto L16;
    L7:
        String r2 = r9.a;
        Resolution r3 = Resolution.High;
        if (r10 == null) goto L10;
        long r4 = r10.longValue();
    L11:
        PreloaderVidItem r0 = new PreloaderVidItem(r2, r3, r4, false);
        r0.mApiVersion = 2;
        r0.setCallBackListener(new e(this, r9, r11));
        r0.mListener = new f(this, r9, r11);
        if (r9.d != null) goto L14;
        r9.d = new v(r9.a);
    L14:
        this.u.add(r9.a);
        TTVideoEngine.addTask(r0);
        return r0;
    L10:
        r4 = ((long) this.i) * 1024;
        goto L11
    L16:
        TTVideoEngine.startDataLoader(((AbsPlayer) this).b.getApplicationContext());     // Catch: Exception -> L6
    L6:
        com.bytedance.android.live.ktv.common.util.g.e("checkMDLLaunch fail");
        goto L7
    }
}
