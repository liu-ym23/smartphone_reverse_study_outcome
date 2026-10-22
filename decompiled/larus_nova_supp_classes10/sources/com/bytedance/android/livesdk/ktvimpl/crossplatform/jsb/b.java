package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusPlayerProxy;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a {
    public static final /* synthetic */ int g = 0;
    public final Lazy a;
    public final CompositeDisposable b;
    public final Map<String, Function1<JsonObject, JsonObject>> c;
    public final Map<String, Function1<JsonObject, JsonObject>> d;
    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c e;
    public final j1 f;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.live.pushstream.d b() {
        j1 r0 = this.f;
        if (r0 == null) goto L11;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L11;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L11;
        ec6.b r3 = r2.R();
        if (r3 == null) goto L11;
        return gc6.b.a(r3);
    L11:
        return null;
    }

    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b c() {
        return this.e.k();
    }

    public final void a() {
        com.bytedance.android.live.pushstream.d r0 = b();
        if (r0 == null) goto L6;
        r0.u();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a
    public final JsonObject handleDynamicJsbGetAction(JsonObject r4) {
        if (r4 == null) goto L17;
        JsonElement r1 = r4.get("act_type");
        if (r1 == null) goto L18;
        String r2 = r1.getAsString();
        if (r2 == null) goto L19;
        JsonElement r5 = r4.get("params");
        if ((r5 instanceof JsonObject) == true) goto L11;
        r5 = null;
    L11:
        JsonObject r6 = (JsonObject) r5;
        if (r6 == null) goto L20;
        Function1<JsonObject, JsonObject> r3 = this.c.get(r2);
        if (r3 != null) goto L16;
        return null;
    L16:
        return (JsonObject) r3.invoke(r6);
    L20:
        return null;
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb.a
    public final JsonObject handleDynamicJsbUpdateAction(JsonObject r4) {
        if (r4 == null) goto L17;
        JsonElement r1 = r4.get("act_type");
        if (r1 == null) goto L18;
        String r2 = r1.getAsString();
        if (r2 == null) goto L19;
        JsonElement r5 = r4.get("params");
        if ((r5 instanceof JsonObject) == true) goto L11;
        r5 = null;
    L11:
        JsonObject r6 = (JsonObject) r5;
        if (r6 == null) goto L20;
        Function1<JsonObject, JsonObject> r3 = this.d.get(r2);
        if (r3 != null) goto L16;
        return null;
    L16:
        return (JsonObject) r3.invoke(r6);
    L20:
        return null;
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    }

    public b(VideoChorusPlayerProxy r13, j1 r14) {
        Intrinsics.checkNotNullParameter(r13, "ktvPlayerProxy");
        this.e = r13;
        this.f = r14;
        this.a = LazyKt.lazy(KtvJsbHandler$callDurationMax$2.INSTANCE);
        this.b = new CompositeDisposable();
        this.c = MapsKt.mapOf(new Pair[]{TuplesKt.to("isOriginState", new KtvJsbHandler$actionGetHandlers$1(this)), TuplesKt.to("isMusicAvailable", new KtvJsbHandler$actionGetHandlers$2(this)), TuplesKt.to("getOrederedSongList", new KtvJsbHandler$actionGetHandlers$3(this)), TuplesKt.to("getMidiAverageScore", new KtvJsbHandler$actionGetHandlers$4(this)), TuplesKt.to("getMidiScoreInfo", new KtvJsbHandler$actionGetHandlers$5(this)), TuplesKt.to("isSupportEarMonitor", new KtvJsbHandler$actionGetHandlers$6(this)), TuplesKt.to("getPitchShift", new KtvJsbHandler$actionGetHandlers$7(this)), TuplesKt.to("isEnableLoudNorm", new KtvJsbHandler$actionGetHandlers$8(this)), TuplesKt.to("getHeadSetState", new KtvJsbHandler$actionGetHandlers$9(this)), TuplesKt.to("getPlayerVolume", new KtvJsbHandler$actionGetHandlers$10(this))});
        this.d = MapsKt.mapOf(new Pair[]{TuplesKt.to("playMusic", new KtvJsbHandler$actionUpdateHandlers$1(this)), TuplesKt.to("pauseMusic", new KtvJsbHandler$actionUpdateHandlers$2(this)), TuplesKt.to("createMusicPlayer", new KtvJsbHandler$actionUpdateHandlers$3(this)), TuplesKt.to("destroyMusicPlayer", new KtvJsbHandler$actionUpdateHandlers$4(this)), TuplesKt.to("seekMusic", new KtvJsbHandler$actionUpdateHandlers$5(this)), TuplesKt.to("setOriginEnable", new KtvJsbHandler$actionUpdateHandlers$6(this)), TuplesKt.to("setOnlyMixWithRTC", new KtvJsbHandler$actionUpdateHandlers$7(this)), TuplesKt.to("setMixerEnable", new KtvJsbHandler$actionUpdateHandlers$8(this)), TuplesKt.to("downloadMusic", new KtvJsbHandler$actionUpdateHandlers$9(this)), TuplesKt.to("sendSei", new KtvJsbHandler$actionUpdateHandlers$10(this)), TuplesKt.to("setEchoMode", new KtvJsbHandler$actionUpdateHandlers$11(this)), TuplesKt.to("setEarMonitorVolume", new KtvJsbHandler$actionUpdateHandlers$12(this)), TuplesKt.to("setPitchShift", new KtvJsbHandler$actionUpdateHandlers$13(this)), TuplesKt.to("setLoudNormParams", new KtvJsbHandler$actionUpdateHandlers$14(this)), TuplesKt.to("setEnableLoudNorm", new KtvJsbHandler$actionUpdateHandlers$15(this)), TuplesKt.to("setKtvEffect", new KtvJsbHandler$actionUpdateHandlers$16(this)), TuplesKt.to("downloadTuningEffect", new KtvJsbHandler$actionUpdateHandlers$17(this)), TuplesKt.to("setVoiceVolume", new KtvJsbHandler$actionUpdateHandlers$18(this)), TuplesKt.to("setOthersVolume", new KtvJsbHandler$actionUpdateHandlers$19(this)), TuplesKt.to("setPlayerVolume", new KtvJsbHandler$actionUpdateHandlers$20(this)), TuplesKt.to("setBgmPlayerVolume", new KtvJsbHandler$actionUpdateHandlers$21(this)), TuplesKt.to("setBGMPushVolume", new KtvJsbHandler$actionUpdateHandlers$22(this)), TuplesKt.to("notifySingStateChanged", new KtvJsbHandler$actionUpdateHandlers$23(this)), TuplesKt.to("openOrderSongPanel", new KtvJsbHandler$actionUpdateHandlers$24(this))});
    }
}
