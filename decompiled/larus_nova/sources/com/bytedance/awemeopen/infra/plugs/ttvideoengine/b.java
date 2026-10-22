package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements r64.f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f198916l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Surface f198917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f198918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f198919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f198920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r64.b f198921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f198922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r64.d f198923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f198924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f198925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f198926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f198927k;

    public static final class a {
    }

    static {
    }

    @Override // r64.f
    public final void g() {
    }

    @Override // r64.f
    public final void pause() {
        this.f198925i = 5;
        k().pause();
    }

    @Override // r64.f
    public final void release() {
        this.f198925i = 7;
        k().release();
        this.f198918b = true;
        this.f198921e = null;
        this.f198922f = null;
        this.f198927k = 0;
    }

    @Override // r64.f
    public final void resume() {
        this.f198925i = 4;
        k().play();
    }

    @Override // r64.f
    public final String getPlayId() {
        r64.b r100 = this.f198921e;
        if (r100 == null) goto L6;
        String r101 = r100.f536335b;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // r64.f
    public final boolean h() {
        if (TTVideoEngine.getCacheFileSize(this.f198922f) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final TTVideoEngine k() {
        return (TTVideoEngine) this.f198920d.getValue();
    }

    @Override // r64.f
    public final void stop() {
        r64.d r100 = this.f198923g;
        if (r100 == null) goto L9;
        r64.b r101 = this.f198921e;
        if (r101 == null) goto L7;
        String r102 = r101.f536335b;
    L8:
        r100.c(r102);
        goto L9
    L7:
        r102 = null;
    L9:
        this.f198925i = 6;
        k().stop();
    }

    public b() {
        this.f198918b = true;
        this.f198919c = 1.0f;
        this.f198920d = LazyKt.lazy(new AoTTVideoEnginePlayer$mVideoEngine$2(this));
        this.f198925i = -1;
        this.f198926j = new f(this);
    }

    @Override // r64.f
    public final long getCurrentPosition() {
        return k().getCurrentPlaybackTime();
    }

    @Override // r64.f
    public final long getDuration() {
        return k().getDuration();
    }

    @Override // r64.f
    public final long getWatchDuration() {
        return k().getWatchedDuration();
    }

    @Override // r64.f
    public final boolean isPlaying() {
        if (k().getPlaybackState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // r64.f
    public final int c() {
        return this.f198925i;
    }

    @Override // r64.f
    public final float e() {
        return this.f198919c;
    }

    @Override // r64.f
    public final void getPlayerType() {
    }

    @Override // r64.f
    public final void a(Surface r100) {
        this.f198917a = r100;
        boolean r101 = true;
        this.f198924h = !Intrinsics.areEqual(k().getSurface(), r100);
        StringBuilder r102 = new StringBuilder("setRenderTarget: change: ");
        r102.append(this.f198924h);
        r102.append(", surfaceIsNull:");
        if (r100 == null) goto L6;
        r101 = false;
    L6:
        r102.append(r101);
        r102.append(", ");
        r102.append(r100);
        g.a(r102.toString());
        k().setSurface(r100);
    }

    @Override // r64.f
    public final void d(float r100) {
        TTVideoEngine r101 = k();
        PlaybackParams r102 = new PlaybackParams();
        r102.setSpeed(r100);
        r101.setPlaybackParams(r102);
        this.f198919c = r100;
    }

    @Override // r64.f
    public final void f(r64.b r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        long r100 = r110.f536334a;
        String r101 = "";
        if (this.f198918b == true) goto L12;
        r64.d r102 = this.f198923g;
        if (r102 == null) goto L13;
        r64.b r103 = this.f198921e;
        if (r103 == null) goto L10;
        String r104 = r103.f536335b;
        if (r104 == null) goto L10;
    L11:
        r102.h(r104);
    L10:
        r104 = "";
    L13:
        this.f198921e = r110;
        String r105 = r110.f536338e;
        boolean r106 = true;
        if (r105 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L58;
    L24:
        k().setLooping(r110.f536340g);
        k().setStartTime((int) r100);
        k().setVideoEngineCallback(this.f198926j);
        List<r64.a> r108 = r110.f536336c;
        if (r108 != null) goto L27;
        String r109 = "";
    L44:
        g.a("doPrepare: url=".concat(r101));
        if (TextUtils.isEmpty(r101) == true) goto L47;
        k().setDirectUrlUseDataLoader(r101, r109);
        g.a("doPrepare: call play() ");
        k().play();
        return;
    L47:
        String r111 = r110.f536339f;
        if (r111 == null) goto L62;
        VideoRef r112 = new VideoRef();
        r112.extractFields(new JSONObject(r111));     // Catch: JSONException -> L52
    L54:
        VideoModel r113 = new VideoModel();
        r113.setVideoRef(r112);
        k().setVideoModel(r113);
        k().configResolution(Resolution.ExtremelyHigh);
        g.a("handleVideoModel: call play() ");
        k().play();
        return;
    L52:
        e = move-exception;
        e.toString();
        goto L54
    L62:
        return;
    L27:
        if (r108.isEmpty() == true) goto L60;
        List<String> r114 = ((r64.a) ListProtector.get(r108, 0)).f536333c;
        if (r114 != null) goto L31;
    L33:
        r106 = false;
    L34:
        if (r106 == true) goto L63;
        List<String> r115 = ((r64.a) ListProtector.get(r108, 0)).f536333c;
        if (r115 == null) goto L42;
        String r116 = (String) ListProtector.get(r115, 0);
        if (r116 == null) goto L42;
        r101 = r116;
    L42:
        r109 = ((r64.a) ListProtector.get(r108, 0)).f536332b;
        this.f198922f = r109;
        goto L44
    L63:
        return;
    L31:
        if (r114.isEmpty() != true) goto L33;
    L60:
        return;
    L58:
        JsonObject r117 = new JsonParser().parse(r110.f536338e).getAsJsonObject();     // Catch: Exception -> L23
        float r118 = r117.get("loudness").getAsFloat();     // Catch: Exception -> L23
        float r119 = r117.get("peak").getAsFloat();     // Catch: Exception -> L23
        k().setFloatOption(345, r118);     // Catch: Exception -> L23
        k().setFloatOption(346, r119);     // Catch: Exception -> L23
        TTVideoEngine r120 = k();     // Catch: Exception -> L23
        int r121 = j64.b.f497514a;     // Catch: Exception -> L23
        r120.setFloatOption(344, ((AoHostService) j64.b.a(AoHostService.class)).b());     // Catch: Exception -> L23
        goto L24
    L16:
        if (r105.length() == 0) goto L19;
        r107 = false;
        goto L20
    L12:
        this.f198918b = false;
        goto L13
    }

    @Override // r64.f
    public final void i(r64.b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        k().setIntOption(100, 1);
        int r101 = this.f198927k;
        if (r101 >= 3) goto L6;
        this.f198927k = r101 + 1;
        g.a("count=" + this.f198927k + ", preRender: " + r100.f536335b);
        return;
    }

    @Override // r64.f
    public final void j(com.bytedance.awemeopen.infra.base.player.a r100) {
        this.f198923g = r100;
    }

    @Override // r64.f
    public final void seekTo(long r100) {
        k().seekTo((int) r100, new com.bytedance.awemeopen.infra.plugs.ttvideoengine.a());
    }

    @Override // r64.f
    public final void setIsMute(boolean r100) {
        k().setIsMute(r100);
    }

    @Override // r64.f
    public final void b(List r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "preloadList");
        Intrinsics.checkNotNullParameter(r111, "sceneId");
        StringBuilder r100 = new StringBuilder("AoTTVideoEnginePlayer preload: ");
        r64.b r101 = (r64.b) CollectionsKt.firstOrNull(r110);
        if (r101 == null) goto L5;
        String r102 = r101.f536335b;
    L6:
        r100.append(r102);
        g.b(r100.toString());
        Iterator r103 = r110.iterator();
    L8:
        if (r103.hasNext() == false) goto L42;
        r64.b r104 = (r64.b) r103.next();
        List<r64.a> r105 = r104.f536336c;
        boolean r106 = true;
        if (r105 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L8;
        List<r64.a> r108 = r104.f536336c;
        if (r108 == null) goto L8;
        r64.a r109 = (r64.a) ListProtector.get(r108, 0);
        if (r109 == null) goto L8;
        List<String> r112 = r109.f536333c;
        if (r112 != null) goto L25;
    L27:
        r106 = false;
    L28:
        if (r106 == true) goto L29;
        String r113 = r104.f536339f;
        if (r113 == null) goto L8;
        VideoRef r114 = new VideoRef();
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L39
        r114.extractFields(new JSONObject(r113));     // Catch: Throwable -> L39
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        VideoModel r116 = new VideoModel();
        r116.setVideoRef(r114);
        PreloaderVideoModelItem r117 = new PreloaderVideoModelItem(r116, Resolution.Standard, LynxResourceModule.DEFAULT_MEDIA_SIZE, false);
        r117.setCallBackListener(new e());
        TTVideoEngine.addTask(r117);
    L39:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L41
    L29:
        long r119 = RangesKt.coerceAtMost(r109.f536331a, 819200);
        String r120 = r109.f536332b;
        List<String> r121 = r109.f536333c;
        if (r121 == null) goto L32;
        String[] r122 = (String[]) r121.toArray(new String[0]);
    L33:
        PreloaderURLItem r123 = new PreloaderURLItem(r120, null, r119, r122);
        r123.setPriorityLevel(0);
        r123.setCallBackListener(new d());
        TTVideoEngine.addTask(r123);
        goto L8
    L32:
        r122 = null;
        goto L33
    L25:
        if ((!r112.isEmpty()) != true) goto L27;
    L12:
        if (r105.isEmpty() == true) goto L15;
        r107 = false;
        goto L16
    L42:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
