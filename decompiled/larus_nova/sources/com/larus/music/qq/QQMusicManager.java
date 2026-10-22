package com.larus.music.qq;

import android.app.Application;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.music.qq.data.QQMusicSong;
import com.larus.music.qq.data.QQPlayStatus;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import com.tencent.qqmusic.third.api.contract.Events;
import com.tencent.qqmusic.third.api.contract.IQQMusicApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class QQMusicManager implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QQMusicManager f359498a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f359499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f359500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData<IQQMusicApi> f359501d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Observer<IQQMusicApi> f359502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Function2<? super Integer, ? super Integer, Unit> f359503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Job f359504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<com.larus.music.qq.a> f359505h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f359506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.larus.media.model.a f359507j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f359508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static QQMusicSong f359509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static QQPlayStatus f359510m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f359511n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final QQMusicManager$eventListener$1 f359512o = null;

    public static final class a implements e78.c {
        public a() {
        }

        @Override // e78.c
        public final void a() {
        }

        @Override // e78.c
        public final void c() {
        }

        @Override // e78.c
        public final void d() {
        }

        @Override // e78.c
        public final String getBizScene() {
            return GlobalAudioSceneEnum.QQ_MUSIC;
        }

        @Override // e78.c
        public final String getScene() {
            return GlobalAudioSceneEnum.QQ_MUSIC;
        }

        @Override // e78.c
        public final boolean stop() {
            QQMusicManager.f359506i = false;
            QQMusicManager r100 = QQMusicManager.f359498a;
            QQMusicManager.d(new x0());
            return true;
        }

        @Override // e78.c
        public final boolean b() {
            QQMusicManager r100 = QQMusicManager.f359498a;
            String r101 = null;
            int r102 = QQMusicApiUtils.f359493a.c("skipToNext", QQMusicManager.f359501d.getValue(), null, null);
            if (r102 != 0) goto L5;
            boolean r103 = true;
        L6:
            FLogger r104 = FLogger.f375446a;
            StringBuilder r105 = new StringBuilder("GlobalAudioParticipant playNext triggered, result: ");
            r105.append(r103);
            r105.append(", code:");
            r105.append(r102);
            r105.append(", title: ");
            QQMusicSong r106 = QQMusicManager.f359509l;
            if (r106 == null) goto L9;
            String r107 = r106.getTitle();
        L10:
            r105.append(r107);
            r105.append(", id: ");
            QQMusicSong r108 = QQMusicManager.f359509l;
            if (r108 == null) goto L13;
            r101 = r108.getId();
        L13:
            r105.append(r101);
            r104.i("QQMusicManager", r105.toString());
            return r103;
        L9:
            r107 = null;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // e78.c
        public final boolean e() {
            QQMusicManager r100 = QQMusicManager.f359498a;
            String r101 = null;
            int r102 = QQMusicApiUtils.f359493a.c("skipToPrevious", QQMusicManager.f359501d.getValue(), null, null);
            if (r102 != 0) goto L5;
            boolean r103 = true;
        L6:
            FLogger r104 = FLogger.f375446a;
            StringBuilder r105 = new StringBuilder("GlobalAudioParticipant playPrevious triggered, result: ");
            r105.append(r103);
            r105.append(", code:");
            r105.append(r102);
            r105.append(", title: ");
            QQMusicSong r106 = QQMusicManager.f359509l;
            if (r106 == null) goto L9;
            String r107 = r106.getTitle();
        L10:
            r105.append(r107);
            r105.append(", id: ");
            QQMusicSong r108 = QQMusicManager.f359509l;
            if (r108 == null) goto L13;
            r101 = r108.getId();
        L13:
            r105.append(r101);
            r104.i("QQMusicManager", r105.toString());
            return r103;
        L9:
            r107 = null;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // e78.c
        public final boolean pause() {
            QQMusicManager r100 = QQMusicManager.f359498a;
            QQMusicManager.d(new w0());
            Lazy r101 = MediaResourceManager.f358950a;
            MediaResourceManager.a(QQMusicManager.f359507j);
            return true;
        }

        @Override // e78.c
        public final boolean play() {
            QQMusicManager r100 = QQMusicManager.f359498a;
            Function2 r101 = new v0();
            Intrinsics.checkNotNullParameter(r101, "callback");
            Lazy r102 = MediaResourceManager.f358950a;
            MediaResourceManager.m(QQMusicManager.f359507j, new n0(r101), new o0(), 0, 8);
            return true;
        }

        @Override // e78.c
        public final GlobalAudioStateEnum getState() {
            return QQMusicManager.a();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359513a = null;

        static {
            int[] r100 = new int[QQMusicBizErrorCode.values().length];
            r100[QQMusicBizErrorCode.NOT_LOGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[QQMusicBizErrorCode.AUTH_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            int[] r101 = new int[QQPlayStatus.values().length];
            r101[QQPlayStatus.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r101[QQPlayStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L19:
            r101[QQPlayStatus.PLAYING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f359513a = r101;
        }
    }

    public static final class c extends d1<Integer> {
        public c(g0 r100) {
            super(r100);
        }
    }

    public static final class d implements com.larus.media.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f359514a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f359515a = null;

            static {
                int[] r100 = new int[MediaResourceManager.FlowAudioBroadcastEvent.values().length];
                r100[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyBegin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f359515a = r100;
            }
        }

        public d() {
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            Map<String, com.larus.media.o0.a> r101 = com.larus.media.o0.f359131a;
            return com.larus.media.o0.a("music", r100.getScene());
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            com.larus.media.v.a.d(r100);
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            if (com.larus.media.o.a() == false) goto L18;
            MediaResourceManager.FlowAudioBroadcastEvent r101 = r100.f358959c;
            if (r101 != null) goto L7;
            int r102 = -1;
        L9:
            if (r102 != 1) goto L11;
            FLogger.f375446a.i("QQMusicManager_APIUtils", "event asrWaitReplyBegin , msgId: " + r100.f358958b);
            QQMusicManager.f359506i = true;
            return;
        L11:
            if (r102 == 2) goto L13;
            QQMusicManager.f359506i = false;
            return;
        L13:
            FLogger.f375446a.i("QQMusicManager_APIUtils", "event asrWaitReplyEnd , msgId: " + r100.f358958b);
            if (QQMusicManager.f359506i == false) goto L20;
            QQMusicManager.f359506i = false;
            QQMusicManager r103 = QQMusicManager.f359498a;
            QQMusicManager.f(new b1());
            return;
        L20:
            return;
        L7:
            r102 = a.f359515a[r101.ordinal()];
            goto L9
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            com.larus.media.v.a.f(r100, r101);
            if (this.f359514a == false) goto L8;
            FLogger.f375446a.i("QQMusicManager_APIUtils", "audio focus onMediaResume and resume. applicant:" + r100 + ", volumeFactor: " + r101);
            this.f359514a = false;
            if (QQMusicManager.f359506i == true) goto L9;
            com.larus.utils.t0.a(new a1());
            return;
        L9:
            return;
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            com.larus.media.v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, float r101) {
            com.larus.media.v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, lk9.g r101) {
            com.larus.media.v.a.e(r100, r101);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return com.larus.media.v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            IFlowSdkDepend r103 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r103 == null) goto L7;
            com.larus.home.impl.sdk.s r104 = r103.s0();
            if (r104 == null) goto L7;
            Integer r105 = r104.h();
        L8:
            Map<String, com.larus.media.o0.a> r106 = com.larus.media.o0.f359131a;
            boolean r107 = true;
            if (com.larus.media.o0.c("music", r101.getScene()) == true) goto L21;
            String r108 = r101.getScene();
            Intrinsics.checkNotNullParameter(r108, "scene");
            if (Intrinsics.areEqual(r108, MediaScene.DORA) == false) goto L17;
            if (r105 == null) goto L17;
            if (r105.intValue() != 2) goto L17;
            boolean r109 = true;
        L18:
            if (r109 == true) goto L21;
            r107 = false;
        L17:
            r109 = false;
        L21:
            this.f359514a = r107;
            QQMusicManager r110 = QQMusicManager.f359498a;
            QQMusicManager.d(new z0());
            if (r107 == false) goto L25;
            return MediaOccupyStrategy.PAUSE;
        L25:
            return MediaOccupyStrategy.INTERRUPT;
        L7:
            r105 = null;
            goto L8
        }
    }

    public QQMusicManager() {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.music.qq.QQMusicManager$eventListener$1] */
    static {
        f359498a = new QQMusicManager();
        f359501d = new MutableLiveData(null);
        f359505h = new ArrayList();
        f359507j = new com.larus.media.model.a(null, "music", true, 0, 2, false, 0, false, false, 0, false, new d(), DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR);
        f359510m = QQPlayStatus.STOPPED;
        f359511n = new a();
        QQMusicApiUtils.f359495c = new d0();
        f359512o = new QQMusicManager$eventListener$1();
    }

    public static final GlobalAudioStateEnum a() {
        QQPlayStatus r100 = f359510m;
        int r101 = b.f359513a[r100.ordinal()];
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L15;
        if (r101 == 3) goto L14;
        return GlobalAudioStateEnum.NONE;
    L14:
        return GlobalAudioStateEnum.PLAYING;
    L15:
        return GlobalAudioStateEnum.PAUSED;
    L12:
        return GlobalAudioStateEnum.STOPPED;
    }

    public static void d(final Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f359506i = false;
        QQMusicApiUtils r101 = QQMusicApiUtils.f359493a;
        IQQMusicApi r102 = f359501d.getValue();
        Intrinsics.checkNotNullParameter(r100, "callback");
        QQMusicApiUtils.d(r102, "pauseMusic", null, true, new t(r100));
    }

    public static void e(IQQMusicApi r100) {
        FLogger.f375446a.d("QQMusicManager", "registerListener: qqMusicApi.value：" + r100);
        if (r100 == null) goto L9;
        ArrayList r101 = CollectionsKt.arrayListOf(new String[]{Events.API_EVENT_PLAY_SONG_CHANGED});     // Catch: Throwable -> L6
        QQMusicManager$eventListener$1 r102 = f359512o;     // Catch: Throwable -> L6
        r100.registerEventListener(r101, r102);     // Catch: Throwable -> L6
        r100.registerEventListener(CollectionsKt.arrayListOf(new String[]{Events.API_EVENT_PLAY_STATE_CHANGED}), r102);     // Catch: Throwable -> L6
        r100.registerEventListener(CollectionsKt.arrayListOf(new String[]{Events.API_EVENT_SONG_FAVORITE_STATE_CHANGED}), r102);     // Catch: Throwable -> L6
        r100.registerEventListener(CollectionsKt.arrayListOf(new String[]{Events.API_EVENT_LOGIN_STATE_CHANGED}), r102);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void f(final Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        QQMusicApiUtils.f359493a.c("resumeMusic", f359501d.getValue(), null, new q0(r100));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.music.qq.g0] */
    public final void b(final Function2<? super QQMusicBizErrorCode, ? super Integer, Unit> r110) {
        c r111 = new c(new g0(r110));
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("startQQMusicProcess: qqMusicApi.value：");
        MutableLiveData<IQQMusicApi> r102 = f359501d;
        r101.append(r102.getValue());
        r101.append("---");
        r101.append(r111.f359523b);
        r100.d("QQMusicManager", r101.toString());
        boolean r103 = true;
        if (r102.getValue() != null) goto L5;
        Application r104 = AppHost.f326268a.getApplication();
        if (r104 != null) goto L13;
    L28:
        r103 = false;
    L29:
        if (r103 == true) goto L31;
        FLogger.f375446a.d("QQMusicManager", "startQQMusicProcess: not install qq cilent");
        r111.a(-1);
        return;
    L31:
        QQMusicApiUtils r105 = QQMusicApiUtils.f359493a;
        boolean r106 = QQMusicApiUtils.a(this);
        FLogger r107 = FLogger.f375446a;
        r107.d("QQMusicManager", "startQQMusicProcess: bindQQMusicApiService----bindResult：" + r106 + "---" + r111.f359523b);
        if (r106 == true) goto L34;
        r107.d("QQMusicManager", "startQQMusicProcess: ");
        AppHost.Companion r108 = AppHost.f326268a;
        String r109 = r108.getApplication().getPackageName();
        int r112 = b0.f359518a;
        Application r113 = r108.getApplication();
        Intrinsics.checkNotNull(r109);
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r109, "packageName");
        Intrinsics.checkNotNullParameter("2000000595", "appId");
        CommonCmd.startQQMusicProcess(r113, r109, "2000000595");
        f359508k = 0;
        i(r111);
    L34:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new QQMusicManager$addObserver$1(r111, null), 2, null);
        return;
    L13:
        if (TextUtils.isEmpty("com.tencent.qqmusic") == true) goto L28;
        PackageInfo r114 = r104.getPackageManager().getPackageInfo("com.tencent.qqmusic", 0);     // Catch: Exception -> L24
        if (r114 == null) goto L28;
        ApplicationInfo r115 = r114.applicationInfo;     // Catch: Exception -> L24
        if (r115 == null) goto L20;
        Boolean r116 = Boolean.valueOf(r115.enabled);     // Catch: Exception -> L24
    L21:
        if (r116 == null) goto L25;
        boolean r117 = r116.booleanValue();     // Catch: Exception -> L24
    L26:
        if (r117 == false) goto L28;
    L25:
        r117 = false;
        goto L26
    L20:
        r116 = null;
        goto L21
    L5:
        if (f359499b == true) goto L7;
    L9:
        r111.a(0);
        return;
    L7:
        if (f359500c == false) goto L9;
        e(r102.getValue());
        r111.a(1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.music.qq.m0, java.lang.Object] */
    public final void g(boolean r110) {
        MutableLiveData<IQQMusicApi> r100 = f359501d;
        e(r100.getValue());
        FLogger.f375446a.d("QQMusicManager", "setAuthorizationResult: " + r110 + "---" + f359503f);
        if (f359503f != null) goto L6;
        return;
    L6:
        if (r100.getValue() != null) goto L8;
        return;
    L8:
        Job r101 = f359504g;
        if (r101 == null) goto L11;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L11:
        if (r110 == false) goto L20;
        Job r111 = f359504g;
        if (r111 == null) goto L16;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
    L16:
        if (f359503f == null) goto L19;
        f359504g = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new QQMusicManager$startDelayTimeTask$1(20000, null), 3, null);
    L19:
        QQMusicApiUtils r112 = QQMusicApiUtils.f359493a;
        IQQMusicApi r113 = r100.getValue();
        final ?? r102 = new m0();
        Intrinsics.checkNotNullParameter(r102, "callback");
        QQMusicApiUtils.d(r113, "getLoginState", null, true, new w(r102));
        return;
    L20:
        c(this, -2);
    }

    public final void h(boolean r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("login result: ");
        r102.append(r100);
        r102.append("---waitReturnCallback:");
        r102.append(f359503f);
        r102.append("---qqMusicApi:");
        MutableLiveData<IQQMusicApi> r103 = f359501d;
        r102.append(r103.getValue());
        r101.d("QQMusicManager", r102.toString());
        if (f359503f != null) goto L6;
        return;
    L6:
        if (r103.getValue() != null) goto L8;
        return;
    L8:
        if (r100 == false) goto L10;
        c(this, 0);
        return;
    L10:
        c(this, -2);
    }

    public final void i(final d1<Integer> r100) {
        QQMusicApiUtils r101 = QQMusicApiUtils.f359493a;
        boolean r102 = QQMusicApiUtils.a(this);
        FLogger.f375446a.d("QQMusicManager", "tryBindQQMusicApiServiceRecursively bindRet：" + r102 + " currentRetryBindServiceTime:" + f359508k);
        int r103 = f359508k + 1;
        f359508k = r103;
        if (r103 >= 2) goto L6;
        if (r102 == true) goto L8;
        new Handler(Looper.getMainLooper()).postDelayed(new j0(r100), 2000);
        return;
    L8:
        return;
    L6:
        r100.a(-2);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        f359500c = false;
        f359499b = false;
        f359501d.postValue(null);
        List<com.larus.music.qq.a> r101 = f359505h;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((com.larus.music.qq.a) r102.next()).b(f359509l, QQPlayStatus.STOPPED);
        goto L6
    L10:
        return;
    }

    public static void c(QQMusicManager r100, int r101) {
        r100.getClass();
        Job r102 = f359504g;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        Function2<? super Integer, ? super Integer, Unit> r103 = f359503f;
        if (r103 == null) goto L8;
        r103.invoke(Integer.valueOf(r101), null);
    L8:
        f359503f = null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        FLogger.f375446a.d("QQMusicManager", "onServiceConnected: p1:" + r101);
        IQQMusicApi r102 = IQQMusicApi.Stub.asInterface(r101);
        f359501d.postValue(r102);
        int r103 = b0.f359518a;
        CommonCmd.init("phone");
        e(r102);
    }
}
