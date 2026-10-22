package com.bytedance.ies.xelement.alphavideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.JsonSyntaxException;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import d76.f;
import d76.g;
import d76.h;
import d76.i;
import d76.j;
import d76.k;
import d76.l;
import d76.m;
import d76.n;
import d76.o;
import d76.p;
import d76.q;
import d76.r;
import d76.s;
import d76.t;
import d76.u;
import d76.x;
import d76.y;
import java.io.BufferedReader;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@LynxBehavior(isCreateAsync = false, tagName = {"x-alpha-video"})
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.alphavideo")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0007J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u001a\u0010 \u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\u001a\u0010!\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¨\u0006%"}, d2 = {"Lcom/bytedance/ies/xelement/alphavideo/LynxAlphaVideo;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/ies/xelement/alphavideo/LynxAlphaVideoView;", "", "src", "", "setSrc", "poster", "setPoster", "lastFrame", "setLastFrame", "", "enable", "setAutoPlay", "setKeepLastFrame", "loop", "setLoop", "setFrameHold", "status", "setAndroidIgnoreAttachStatus", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "play", "pause", "seek", "stop", "getDuration", "isPlaying", "release", "resume", "subscribeUpdateEvent", "unsubscribeUpdateEvent", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "x-element-alpha-video_release"}, k = 1, mv = {1, 6, 0})
public final class LynxAlphaVideo extends UISimpleView<LynxAlphaVideoView> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f249700q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PlayerController f249701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<String> f249702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataSource f249703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d76.b f249704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f249705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f249706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f249707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f249708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f249709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f249710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f249711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f249712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Integer> f249713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Integer> f249714n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d76.a f249715o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f249716p;

    public interface a {
        void onFailed();

        void onSuccess(Bitmap r100);
    }

    public static final class b {
    }

    public static final class c extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f249717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f249718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<LynxAlphaVideo> f249719c;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            LLog.i("x-alpha-video", "download resource success, and directUrl is " + this.f249718b);
            LynxAlphaVideo r101 = this.f249719c.get();
            if (r101 == null) goto L6;
            String r102 = r101.getLynxContext().getApplicationContext().getCacheDir().getAbsolutePath() + '/' + this.f249717a.getLastPathSegment();
            String r103 = this.f249718b;
            int r104 = LynxAlphaVideo.f249700q;
            r101.Y(r102, r103);
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            String r102 = "download resource failed, error msg is " + r101;
            LLog.i("x-alpha-video", r102);
            LynxAlphaVideo r103 = this.f249719c.get();
            if (r103 == null) goto L6;
            r103.V(r102, r103.f249709i, -12);
            r103.getLynxContext().reportResourceError(this.f249718b, "video", r102);
            return;
        }

        public c(LynxAlphaVideo r100, Uri r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "uri");
            Intrinsics.checkNotNullParameter(r102, "directUrl");
            this.f249717a = r101;
            this.f249718b = r102;
            this.f249719c = new WeakReference(r100);
        }
    }

    public static final class d extends BaseBitmapDataSubscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f249720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f249721b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> f249722c;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> r100) {
            this.f249720a.onFailed();
            if (r100 == null) goto L5;
            r100.close();
        L5:
            this.f249721b.countDown();
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public final void onNewResultImpl(Bitmap r100) {
            if (this.f249722c.isFinished() == false) goto L6;
            if (r100 == null) goto L6;
            this.f249720a.onSuccess(r100.copy(r100.getConfig(), true));
            this.f249722c.close();
        L6:
            this.f249721b.countDown();
        }

        public d(a r100, CountDownLatch r101, com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> r102) {
            this.f249720a = r100;
            this.f249721b = r101;
            this.f249722c = r102;
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((Number) r100).intValue()), Integer.valueOf(((Number) r101).intValue()));
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        PlayerController r100 = this.f249701a;
        Intrinsics.checkNotNull(r100);
        r100.release();
        PlayerController r101 = this.f249701a;
        Intrinsics.checkNotNull(r101);
        r101.detachAlphaView((ViewGroup) this.mView);
        ((LynxAlphaVideoView) this.mView).setMPoster(null);
        this.f249708h = null;
        ((LynxAlphaVideoView) this.mView).setMLastFrame(null);
        PlayerController r102 = this.f249701a;
        if ((r102 instanceof PlayerController) == true) goto L6;
        r102 = null;
    L6:
        if (r102 == null) goto L8;
        r102.getClass();
        r102.f451075m.setFirstGLFrameListener(null);
    L8:
        PlayerController r103 = this.f249701a;
        if (r103 == null) goto L11;
        r103.f451070h = null;
    L11:
        if (r103 == null) goto L14;
        r103.f451069g = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAttach() {
        super.onAttach();
        if (this.f249712l == false) goto L5;
        return;
    L5:
        PlayerController r100 = this.f249701a;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f249705e == false) goto L12;
        Intrinsics.checkNotNull(r100);
        r100.attachAlphaView((ViewGroup) this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        super.onDetach();
        if (this.f249712l == false) goto L5;
        return;
    L5:
        PlayerController r100 = this.f249701a;
        if (r100 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        r100.detachAlphaView((ViewGroup) this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        PlayerController r100 = this.f249701a;
        Intrinsics.checkNotNull(r100);
        r100.getView().layout(0, 0, getWidth(), getHeight());
    }

    public LynxAlphaVideo(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("live", "businessID");
        this(r100, "live", null);
    }

    public static void O(final LynxAlphaVideo r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        ((LynxAlphaVideoView) r100.mView).post(new f(r100));
        r100.Z("firstframe", r100.U(1, "first frame begin", null));
    }

    public static final /* synthetic */ View R(LynxAlphaVideo r100) {
        return r100.mView;
    }

    public static String T(String r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
        r101.update(r100.getBytes(Charsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L4
        byte[] r102 = r101.digest();     // Catch: NoSuchAlgorithmException -> L4
    L5:
        StringBuilder r103 = new StringBuilder();
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L12;
        String r106 = Integer.toHexString(r102[r105] & UByte.MAX_VALUE);
        if (r106.length() >= 2) goto L10;
        r106 = "0".concat(r106);
    L10:
        r103.append(r106);
        r105 = r105 + 1;
        goto L6
    L12:
        return r103.toString();
    L4:
        r102 = r100.getBytes(Charsets.UTF_8);
        goto L5
    }

    public final DataSource S(String r100) {
        StringBuilder r101 = new StringBuilder();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100 + ComposerHelper.CONFIG_FILE_NAME));
    L35:
        String r103 = r102.readLine();     // Catch: Throwable -> L28
        if (r103 == null) goto L6;
        r101.append(r103);     // Catch: Throwable -> L28
        r101.append("\n");     // Catch: Throwable -> L28
        goto L35
    L6:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r102, null);
        y r105 = (y) GsonProtectorUtils.fromJson(e76.a.f471183a, r101.toString(), y.class);     // Catch: JsonSyntaxException -> L10
    L12:
        if (r105 != null) goto L15;
        V("fileModel is null", this.f249709i, -14);
        return null;
    L15:
        DataSource r106 = new DataSource();
        if (r105.portrait == null) goto L19;
        DataSource.DataInfo r107 = new DataSource.DataInfo(r100 + r105.portrait.path);
        r107.d(r105.portrait.align);
        y.a r108 = r105.portrait;
        r107.f451144j = r108.version;
        r107.f451137c = r108.totalFrame;
        r107.f451140f = r108.videoWidth;
        r107.f451141g = r108.videoHeight;
        r107.f451142h = r108.actualWidth;
        r107.f451143i = r108.actualHeight;
        r107.b(r108.alphaFrame);
        r107.c(r105.portrait.rgbFrame);
        r107.f451145k = r105.portrait.masks;
        r106.c(r107);
    L19:
        if (r105.landscape == null) goto L21;
        DataSource.DataInfo r109 = new DataSource.DataInfo(r100 + r105.landscape.path);
        r109.d(r105.landscape.align);
        y.a r110 = r105.landscape;
        r109.f451144j = r110.version;
        r109.f451137c = r110.totalFrame;
        r109.f451140f = r110.videoWidth;
        r109.f451141g = r110.videoHeight;
        r109.f451142h = r110.actualWidth;
        r109.f451143i = r110.actualHeight;
        r109.b(r110.alphaFrame);
        r109.c(r105.landscape.rgbFrame);
        r109.f451145k = r105.landscape.masks;
        r106.b(r109);
    L21:
        Object r111 = getProps().get("keep-last-frame");
        Boolean r112 = Boolean.TRUE;
        if (Intrinsics.areEqual(r111, r112) == false) goto L25;
        r106.f451130g = false;
    L25:
        if (Intrinsics.areEqual(getProps().get("loop"), r112) == false) goto L27;
        r106.f451127d = true;
    L27:
        return r106;
    L10:
        e = move-exception;
        V("parse config.json failed, error msg is " + e, this.f249709i, -3);
        r105 = null;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public final void W(String r110) {
        LLog.i("x-alpha-video", "legacySetSrc, directUrl is " + r110);     // Catch: Exception -> L41
        if (r110 == null) goto L49;
        Uri r100 = UriProtector.parse(r110);     // Catch: Exception -> L41
        this.f249703c = null;     // Catch: Exception -> L41
        String r101 = r100.getScheme();     // Catch: Exception -> L41
        if (r101 == null) goto L39;
        int r102 = r101.hashCode();     // Catch: Exception -> L41
        if (r102 == 3143036) goto L26;
        if (r102 == 3213448) goto L19;
        if (r102 != 99617003) goto L39;
        if (r101.equals("https") == false) goto L39;
    L22:
        if (StringsKt.endsWith$default((String) ListProtector.get(StringsKt.split$default(r110, new char[]{'?'}, false, 0, 6, null), 0), ".zip", false, 2, null) == false) goto L24;
        Downloader.with(getLynxContext()).url(r110).name(r100.getLastPathSegment()).savePath(getLynxContext().getApplicationContext().getCacheDir().getAbsolutePath()).mainThreadListener(new c(this, r100, r110)).monitorScene("legacy_lynx_alphavideo").download();     // Catch: Exception -> L41
        return;
    L24:
        V("resource type is not support", this.f249709i, -13);     // Catch: Exception -> L41
        return;
    L19:
        if (r101.equals("http") == true) goto L22;
    L26:
        if (r101.equals("file") == false) goto L39;
    L37:
        e = move-exception;
        V("parse config.json failed, resource is " + r110 + ", error msg is " + e, this.f249709i, -3);     // Catch: Exception -> L41
        return;
    L29:
        if (StringsKt.endsWith$default(r110, ".zip", false, 2, null) == false) goto L31;
        String r103 = r100.getPath();     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L37
        String r104 = r100.getPath();     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L37
        Y(r103, r104);     // Catch: Exception -> L37
    L44:
        return;
    L31:
        this.f249703c = S(r100.getPath() + '/');     // Catch: Exception -> L37
        Z("ready", U(1, "load resource success", null));     // Catch: Exception -> L37
        if (this.f249703c == null) goto L44;
        if (this.f249705e == false) goto L44;
        PlayerController r105 = this.f249701a;     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L37
        r105.attachAlphaView((ViewGroup) this.mView);     // Catch: Exception -> L37
        PlayerController r106 = this.f249701a;     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L37
        r106.f(this.f249703c, this.f249711k);     // Catch: Exception -> L37
    L39:
        Y(r110, r110);     // Catch: Exception -> L41
        return;
    L49:
        return;
    L41:
        e = move-exception;
        LLog.e("x-alpha-video", e.toString());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        LynxAlphaVideoView r101 = new LynxAlphaVideoView(r100);
        Configuration r102 = new Configuration();
        Context r103 = null;
        if (r100 == null) goto L5;
        Context r104 = r100.getApplicationContext();
    L6:
        r102.f451007a = r104;
        r102.f451008b = r101;
        r102.f451009c = 1;
        t r105 = new t(this);
        u r106 = new u(this);
    L12:
        e = move-exception;
        V("init CustomPlayerImpl failed and try to use DefaultSystemPlayer, the exception is " + e, this.f249709i, -10);
        this.f249701a = new PlayerController(r102, new DefaultSystemPlayer());
    L14:
        PlayerController r107 = this.f249701a;
        if (r107 == null) goto L17;
        r107.f451070h = r105;
    L17:
        if (r107 == null) goto L20;
        r107.f451069g = r106;
    L20:
        if ((r107 instanceof PlayerController) == false) goto L25;
        if (r107 == null) goto L24;
        IPlayerController.FirstGLFrameListener r108 = new k(this);
        r107.getClass();
        r107.f451075m.setFirstGLFrameListener(r108);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController");
    L25:
        PlayerController r109 = this.f249701a;
        if (r109 == null) goto L28;
        r109.b(new l(this), 5);
    L28:
        return r101;
    L8:
        if (r100 == null) goto L10;
        r103 = r100.getApplicationContext();     // Catch: Exception -> L12
    L10:
        d76.b r110 = new d76.b(r103);     // Catch: Exception -> L12
        this.f249704d = r110;     // Catch: Exception -> L12
        this.f249701a = new PlayerController(r102, r110);     // Catch: Exception -> L12
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "android-ignore-attach-status")
    public final void setAndroidIgnoreAttachStatus(boolean r100) {
        this.f249712l = r100;
        T r101 = this.mView;
        if (r101 == 0) goto L7;
        ((LynxAlphaVideoView) r101).setMIgnoreAttachStatus(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.alphavideo.LynxAlphaVideoView");
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public final void setAutoPlay(boolean r100) {
        this.f249705e = r100;
        T r101 = this.mView;
        if (r101 == 0) goto L7;
        ((LynxAlphaVideoView) r101).setMAutoPlay(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.alphavideo.LynxAlphaVideoView");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (r100 == null) goto L5;
        Set<String> r101 = r100.keySet();
    L6:
        this.f249702b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @LynxProp(defaultBoolean = false, name = "frame-hold")
    public final void setFrameHold(boolean r100) {
        this.f249711k = r100;
    }

    @LynxProp(defaultBoolean = false, name = "keep-last-frame")
    public final void setKeepLastFrame(boolean r100) {
        if (this.f249706f == r100) goto L10;
        DataSource r101 = this.f249703c;
        if (r101 == null) goto L8;
        r101.f451130g = !r100;
    L8:
        this.f249706f = r100;
        return;
    }

    @LynxProp(name = "last-frame")
    public final void setLastFrame(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        e76.e r101 = new e76.e(new m(this, r100));
        r101.c(new n(this));
        r101.b(new o(this, r100));
    }

    @LynxProp(defaultBoolean = false, name = "loop")
    public final void setLoop(boolean r100) {
        DataSource r101 = this.f249703c;
        if (r101 == null) goto L7;
        r101.f451127d = r100;
        return;
    }

    @LynxProp(name = "poster")
    public final void setPoster(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        e76.e r101 = new e76.e(new p(this, r100));
        r101.c(new q(this));
        r101.b(new r(this, r100));
    }

    @LynxProp(name = "src")
    public final void setSrc(final String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        LynxThreadPool.b().execute(new d76.d(this, r100));
    }

    public LynxAlphaVideo(LynxContext r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, "x-alpha_video-flower", r101);
    }

    public static void M(final LynxAlphaVideo r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        String r102 = null;
        r100.f249703c = null;
        r100.f249709i = "";
        boolean r103 = false;
        if (r100.f249707g == false) goto L5;
        String r104 = d7a.a.b(r100.getLynxContext(), r101, false);
    L6:
        final String r105 = URLDecoder.decode(r104, "UTF-8");
        UIThreadUtils.runOnUiThread(new d76.e(r100, r105));
        if (r101 != null) goto L9;
    L10:
        r103 = true;
    L11:
        if (r103 == false) goto L13;
        return;
    L13:
        if (r100.mContext != null) goto L15;
        return;
    L15:
        if (r100.f249716p == true) goto L26;
        ILynxTrailService r106 = (ILynxTrailService) i8a.n.c().a(ILynxTrailService.class);
        if (r106 == null) goto L20;
        r102 = r106.stringValueForTrailKey("enable_motion_ui_report");
    L20:
        if (Intrinsics.areEqual(r102, "true") == false) goto L27;
        r100.f249716p = true;
        LynxEventReporter.onEvent("lynxsdk_motion_ui_event", r100.mContext.getInstanceId(), new j(r101));
        return;
    L27:
        return;
    L26:
        return;
    L9:
        if (r101.length() != 0) goto L11;
    L5:
        r104 = r101;
        goto L6
    }

    public static void N(LynxAlphaVideo r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r101 == null) goto L10;
        LLog.i("x-alpha-video", "non-null last-frame and set done ");
        DataSource r102 = r100.f249703c;
        if (r102 == null) goto L8;
        r102.f451130g = true;
    L8:
        r100.f249708h = r101;
        ((LynxAlphaVideoView) r100.mView).setMLastFrame(r101);
        return;
    }

    public static void P(LynxAlphaVideo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r101 != "success") goto L9;
        r100.Z("ready", r100.U(1, "load resource success", null));
        if (r100.f249703c != null) goto L7;
        return;
    L7:
        if (r100.f249705e == false) goto L12;
        PlayerController r102 = r100.f249701a;
        Intrinsics.checkNotNull(r102);
        r102.attachAlphaView((ViewGroup) r100.mView);
        PlayerController r103 = r100.f249701a;
        Intrinsics.checkNotNull(r103);
        r103.f(r100.f249703c, r100.f249711k);
        return;
    L12:
        return;
    L9:
        r100.V("unknown exception, " + r101, r100.f249709i, -6);
    }

    public static void Q(LynxAlphaVideo r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r101 == null) goto L6;
        LLog.i("x-alpha-video", "non-null poster and set done ");
        ((LynxAlphaVideoView) r100.mView).setMPoster(r101);
        ((LynxAlphaVideoView) r100.mView).setMIsShowPoster(true);
        ((LynxAlphaVideoView) r100.mView).invalidate();
        return;
    }

    public final void X(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ImageRequestBuilder r102 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(getLynxContext(), r100, false)));
        m8a.e.a(r102);
        ImageRequest r103 = r102.build();
        com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> r104 = Fresco.getImagePipeline().fetchDecodedImage(r103, "x-alpha-video");
        if (r104 != null) goto L6;
        r101.onFailed();
        return;
    L6:
        CountDownLatch r105 = new CountDownLatch(1);
        d r106 = new d(r101, r105, r104);
        r104.subscribe(r106, CallerThreadExecutor.getInstance());
    L11:
        r106.onFailure(r104);
        return;
    L8:
        if (r105.await(3, TimeUnit.SECONDS) == true) goto L15;
        r106.onFailure(r104);     // Catch: InterruptedException -> L11
        return;
    }

    public final void Y(final String r100, final String r101) {
        e76.e r102 = new e76.e(new g(r100, r101, this));
        r102.c(new h(this));
        r102.b(new i(this));
    }

    public final void Z(final String r100, final Map<String, Object> r101) {
        LynxThreadPool.b().execute(new s(this, r100, r101));
    }

    @LynxUIMethod
    public final void getDuration(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView != 0) goto L5;
    L10:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L5:
        if (this.f249701a == null) goto L10;
        r102.putBoolean("success", true);     // Catch: Exception -> L8
        PlayerController r103 = this.f249701a;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L8
        int r104 = r103.getDuration();     // Catch: Exception -> L8
        JavaOnlyMap r105 = new JavaOnlyMap();     // Catch: Exception -> L8
        r105.putInt("duration", r104);     // Catch: Exception -> L8
        r102.putMap("data", r105);     // Catch: Exception -> L8
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void isPlaying(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView != 0) goto L5;
    L10:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
        return;
    L5:
        if (this.f249701a == null) goto L10;
        r102.putBoolean("success", true);     // Catch: Exception -> L8
        PlayerController r103 = this.f249701a;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L8
        boolean r104 = r103.isPlaying();     // Catch: Exception -> L8
        JavaOnlyMap r105 = new JavaOnlyMap();     // Catch: Exception -> L8
        r105.putBoolean("isPlaying", r104);     // Catch: Exception -> L8
        r102.putMap("data", r105);     // Catch: Exception -> L8
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void pause(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L10;
        PlayerController r103 = this.f249701a;
        if (r103 == null) goto L10;
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L8
        r103.pause();     // Catch: Exception -> L8
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L10:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void play(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L15;
        PlayerController r103 = this.f249701a;
        if (r103 == null) goto L15;
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L13
        if (r103.isPlaying() == false) goto L9;
    L11:
        r101.invoke(new Object[]{1, r102});     // Catch: Exception -> L13
    L17:
        return;
    L9:
        if (this.f249703c == null) goto L11;
        PlayerController r104 = this.f249701a;     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L13
        r104.attachAlphaView((ViewGroup) this.mView);     // Catch: Exception -> L13
        PlayerController r105 = this.f249701a;     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L13
        r105.f(this.f249703c, this.f249711k);     // Catch: Exception -> L13
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L15:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void release(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putBoolean("success", true);
        r102.putMap("data", new JavaOnlyMap());
        if (this.mView == 0) goto L10;
        PlayerController r103 = this.f249701a;
        if (r103 == null) goto L10;
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L8
        r103.release();     // Catch: Exception -> L8
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L10:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void resume(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putBoolean("success", true);
        r102.putMap("data", new JavaOnlyMap());
        if (this.mView == 0) goto L12;
        PlayerController r103 = this.f249701a;
        if (r103 == null) goto L12;
        Intrinsics.checkNotNull(r103);
        if (r103.isPlaying() == true) goto L12;
        PlayerController r104 = this.f249701a;     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L10
        r104.attachAlphaView((ViewGroup) this.mView);     // Catch: Exception -> L10
        PlayerController r105 = this.f249701a;     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L10
        r105.resume();     // Catch: Exception -> L10
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L12:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void seek(ReadableMap r110, Callback r111) {
        JavaOnlyMap r100 = new JavaOnlyMap();
        if (this.mView != 0) goto L5;
    L33:
        r100.putString("message", "View or player controller is not available");
        if (r111 == null) goto L43;
        r111.invoke(new Object[]{1, r100});
        return;
    L43:
        return;
    L5:
        if (this.f249701a == null) goto L33;
        if (r110 == null) goto L9;
        Integer r112 = Integer.valueOf(r110.getInt("ms"));
    L10:
        if (r112 != null) goto L37;
        r100.putString("message", "Invalid 'ms' parameter");
        if (r111 == null) goto L39;
        r111.invoke(new Object[]{4, r100});
        return;
    L39:
        return;
    L37:
        d76.b r101 = this.f249704d;     // Catch: Exception -> L28
        if (r101 == null) goto L20;
        x r102 = r101.f467250h;     // Catch: Exception -> L28
        if (r102 == null) goto L20;
        r102.setIntOption(515, 1);     // Catch: Exception -> L28
        r101.f467250h.setIntOption(143, 1);     // Catch: Exception -> L28
        r101.f467250h.setIntOption(110, 2000);     // Catch: Exception -> L28
    L20:
        PlayerController r103 = this.f249701a;     // Catch: Exception -> L28
        if (r103 == null) goto L25;
        int r113 = r112.intValue();     // Catch: Exception -> L28
        IMediaPlayer<AbsPlayer<AbsPlayer>> r104 = r103.f451071i;     // Catch: Exception -> L28
        if (r104 == null) goto L25;
        r104.seekTo(r113);     // Catch: Exception -> L28
    L25:
        if (r111 == null) goto L40;
        r111.invoke(new Object[]{0, r100});     // Catch: Exception -> L28
        return;
    L40:
        return;
    L28:
        e = move-exception;
        r100.putString("message", e.getMessage());
        if (r111 == null) goto L41;
        r111.invoke(new Object[]{1, r100});
        return;
    L41:
        return;
    L9:
        r112 = null;
        goto L10
    }

    @LynxUIMethod
    public final void stop(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JavaOnlyMap r102 = new JavaOnlyMap();
        if (this.mView == 0) goto L10;
        PlayerController r103 = this.f249701a;
        if (r103 == null) goto L10;
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L8
        r103.stop();     // Catch: Exception -> L8
        r101.invoke(new Object[]{0, r102});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r102.putString("message:", e.getMessage());
        r101.invoke(new Object[]{1, r102});
        return;
    L10:
        r102.putString("message", "view is not exist");
        r101.invoke(new Object[]{1, r102});
    }

    @LynxUIMethod
    public final void subscribeUpdateEvent(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r102 = r100.getInt("ms");
        LLog.i("x-alpha-video", "subscribeUpdateEvent: " + r102);
        if (((ArrayList) this.f249713m).contains(Integer.valueOf(r102)) == true) goto L9;
        ((ArrayList) this.f249713m).add(Integer.valueOf(r102));
        ArrayList r103 = (ArrayList) this.f249713m;
        if (r103.size() <= 1) goto L7;
        CollectionsKt.sortWith(r103, new e());
    L7:
        if (r101 == null) goto L12;
        r101.invoke(new Object[]{0});
        return;
    L12:
        return;
    L9:
        if (r101 == null) goto L14;
        r101.invoke(new Object[]{1, "already subscribeUpdateEvent with " + r102 + " milliseconds"});
        return;
    }

    @LynxUIMethod
    public final void unsubscribeUpdateEvent(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r102 = r100.getInt("ms");
        if (((ArrayList) this.f249713m).contains(Integer.valueOf(r102)) == false) goto L7;
        ((ArrayList) this.f249713m).remove(Integer.valueOf(r102));
        if (r101 == null) goto L10;
        r101.invoke(new Object[]{0});
        return;
    L10:
        return;
    L7:
        if (r101 == null) goto L12;
        r101.invoke(new Object[]{1, r102 + " milliseconds is not subscribed"});
        return;
    }

    public LynxAlphaVideo(LynxContext r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "businessID");
        super(r100, r102);
        this.f249705e = true;
        this.f249707g = true;
        this.f249709i = "";
        this.f249713m = new ArrayList();
        this.f249714n = new ArrayList();
        this.f249715o = new d76.a(r101);
    }

    public final Map<String, Object> U(int r100, String r101, JavaOnlyMap r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("code", Integer.valueOf(r100));
        r103.put("message", r101);
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r104 = r102.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, Object> r105 = r104.next();
        r103.put(r105.getKey(), r105.getValue());
    L8:
        return r103;
    }

    public final void V(String r100, String r110, int r111) {
        Z("error", U(r111, r100, null));
        d76.a r101 = this.f249715o;
        r101.getClass();
        JSONObject r102 = new JSONObject();
        r102.put("code", String.valueOf(r111));
        r102.put("resource_url", r110);
        r102.put("message", r100);
        JSONObject r103 = new JSONObject();
        r103.put("virtual_aid", r101.f467248a);
        com.bytedance.android.monitorV2.g.e().getClass();
        com.bytedance.android.monitorV2.g.b(r110, "alpha_video_runtime_error", r102, null, null, r103, 2);
        LLog.e("x-alpha-video", r100);
    }
}
