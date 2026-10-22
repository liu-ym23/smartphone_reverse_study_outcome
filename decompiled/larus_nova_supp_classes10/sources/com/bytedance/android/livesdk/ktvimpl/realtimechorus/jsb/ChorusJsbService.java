package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.ConcertTuner;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.dialog.RealTimeChrousCellularDialog;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.ChorusStreamMixService;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import fd2.d;
import fd2.e;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ChorusJsbService implements e {
    public static final /* synthetic */ int l = 0;
    public final WeakReference<Context> a;
    public final WeakReference<j1> b;
    public final ChorusStreamMixService c;
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.e d;
    public final CompositeDisposable e;
    public ld2.a f;
    public ld2.b g;
    public d h;
    public final Map<String, Function1<JsonObject, JsonObject>> i;
    public final Map<String, Function1<JsonObject, JsonObject>> j;
    public final DataCenter k;

    public static final class a {
    }

    static {
    }

    public final void o1() {
        this.f = null;
        this.h = null;
        this.g = null;
    }

    private final Context getContext() {
        return this.a.get();
    }

    public final j1 e() {
        return this.b.get();
    }

    public final void f() {
        Pair r0 = com.bytedance.live.datacontext.d.a(ChorusJsbService$initJsbDataContext$pair$1.INSTANCE);
        ChorusJsbDataContext r1 = (ChorusJsbDataContext) r0.getFirst();
        r1.getService().d(this);
        com.bytedance.live.datacontext.b.a(r1, ChorusJsbDataContext.class);
        this.e.add((Disposable) r0.getSecond());
    }

    public final ei6.a d() {
        j1 r0 = e();
        if (r0 == null) goto L9;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L9;
        g r2 = r1.getRtcManager();
        if (r2 == null) goto L9;
        return r2.V0();
    L9:
        return null;
    }

    public final void release() {
        o1();
        this.a.clear();
        this.b.clear();
        this.e.dispose();
    }

    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.e m1() {
        return this.d;
    }

    public static final JsonObject a(ChorusJsbService r4) {
        FragmentActivity r5 = ContextUtil.contextToFragmentActivity(r4.getContext());
        if (r5 == null) goto L11;
        RealTimeChrousCellularDialog r0 = new RealTimeChrousCellularDialog();
        FragmentManager r6 = r5.getSupportFragmentManager();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "RealTimeChrousCellularDialog", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r0, r1) == false) goto L13;
    L9:
        com.bytedance.android.livesdk.sharedpref.e r7 = c.O;
        f.d(r7, Long.valueOf(((Long) r7.getValue()).longValue() + 1));
        com.bytedance.android.livesdk.sharedpref.e r8 = c.P;
        Long r2 = Long.valueOf(System.currentTimeMillis());
        r8.getClass();
        f.d(r8, r2);
        goto L11
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L8:
        r0.show(r6, "RealTimeChrousCellularDialog");
    L11:
        return new JsonObject();
    }

    public static void g(String r2) {
        Intrinsics.checkNotNullParameter("ChorusJsbService", LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r2, "msg");
        ALogger.i("ttlive_ktv_chorus_dynamic_log", "tag , ChorusJsbService ; msg, " + r2);
    }

    public final JsonObject c(JsonObject r3) {
        if (r3 == null) goto L7;
        JsonElement r4 = r3.get("source");
        if (r4 == null) goto L7;
        String r5 = r4.getAsString();
        if (r5 == null) goto L7;
    L8:
        Context r0 = getContext();
        if (r0 == null) goto L14;
        d r1 = this.h;
        if (r1 == null) goto L14;
        r1.c(r0, r5);
    L14:
        return new JsonObject();
    L7:
        r5 = "";
        goto L8
    }

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
        Function1<JsonObject, JsonObject> r3 = this.i.get(r2);
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

    public final JsonObject handleDynamicJsbUpdateAction(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "extraData");
        JsonElement r0 = r4.get("act_type");
        if (r0 == null) goto L15;
        String r1 = r0.getAsString();
        if (r1 == null) goto L16;
        JsonElement r5 = r4.get("params");
        if ((r5 instanceof JsonObject) == true) goto L9;
        r5 = null;
    L9:
        JsonObject r6 = (JsonObject) r5;
        if (r6 == null) goto L17;
        Function1<JsonObject, JsonObject> r2 = this.j.get(r1);
        if (r2 != null) goto L14;
        return null;
    L14:
        return (JsonObject) r2.invoke(r6);
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    public final void n1(d r2) {
        Intrinsics.checkNotNullParameter(r2, "bizProxy");
        this.h = r2;
    }

    public final void p1(ConcertTuner r2) {
        Intrinsics.checkNotNullParameter(r2, "tuner");
        this.f = r2;
    }

    public final void q1(ld2.b r2) {
        Intrinsics.checkNotNullParameter(r2, "chorusVolumeController");
        this.g = r2;
    }

    public static final JsonObject b(ChorusJsbService r4, JsonObject r5) {
        r4.getClass();
        JsonElement r0 = r5.get("source");
        if (r0 == null) goto L6;
        String r1 = r0.getAsString();
        if (r1 == null) goto L6;
    L7:
        JsonElement r2 = r5.get("role");
        boolean r3 = false;
        if (r2 == null) goto L10;
        int r6 = r2.getAsInt();
    L11:
        JsonElement r7 = r5.get("is_cdn_singer");
        if (r7 != null) goto L14;
    L16:
        g("showKtvTuningView, source: " + r1 + ", role: " + r6 + ", isCdn: " + r3);
        d r8 = r4.h;
        if (r8 == null) goto L20;
        r8.b(r1, r6, r3, r4.getContext());
    L20:
        return new JsonObject();
    L14:
        if (r7.getAsBoolean() != true) goto L16;
        r3 = true;
        goto L16
    L10:
        r6 = 0;
    L6:
        r1 = "";
        goto L7
    }

    public ChorusJsbService(Context r9, DataCenter r10, j1 r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        this.k = r10;
        this.a = new WeakReference(r9);
        WeakReference<j1> r12 = new WeakReference(r11);
        this.b = r12;
        this.c = new ChorusStreamMixService(r12);
        this.d = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.e();
        this.e = new CompositeDisposable();
        this.i = MapsKt.mapOf(new Pair[]{TuplesKt.to("getVoiceLoudness", new ChorusJsbService$actionGetHandlers$1(this)), TuplesKt.to("getVoiceSimilarScore", new ChorusJsbService$actionGetHandlers$2(this)), TuplesKt.to("getAudioDeviceModuleStats", new ChorusJsbService$actionGetHandlers$3(this)), TuplesKt.to("getAudioRoute", new ChorusJsbService$actionGetHandlers$4(this)), TuplesKt.to("getNtpTime", new ChorusJsbService$actionGetHandlers$5(this)), TuplesKt.to("getOtherPeopleStoreVolume", new ChorusJsbService$actionGetHandlers$6(this)), TuplesKt.to("getCellularEnhancementSwitchStatus", new ChorusJsbService$actionGetHandlers$7(this))});
        this.j = MapsKt.mapOf(new Pair[]{TuplesKt.to("setViceSingerRefTimeMode", new ChorusJsbService$actionUpdateHandlers$1(this)), TuplesKt.to("setPlayBackVolume", new ChorusJsbService$actionUpdateHandlers$2(this)), TuplesKt.to("setRemoteUserDefaultPlaybackVolume", new ChorusJsbService$actionUpdateHandlers$3(this)), TuplesKt.to("setRemoteUserPlaybackVolume", new ChorusJsbService$actionUpdateHandlers$4(this)), TuplesKt.to("initLiveClient", new ChorusJsbService$actionUpdateHandlers$5(this)), TuplesKt.to("releaseLiveClient", new ChorusJsbService$actionUpdateHandlers$6(this)), TuplesKt.to("setAudioSelect", new ChorusJsbService$actionUpdateHandlers$7(this)), TuplesKt.to("setJitterBuffer", new ChorusJsbService$actionUpdateHandlers$8(this)), TuplesKt.to("openVoiceSimilarScore", new ChorusJsbService$actionUpdateHandlers$9(this)), TuplesKt.to("closeVoiceSimilarScore", new ChorusJsbService$actionUpdateHandlers$10(this)), TuplesKt.to("closeCDNStreamPlay", new ChorusJsbService$actionUpdateHandlers$11(this)), TuplesKt.to("intiTuningInfo", new ChorusJsbService$actionUpdateHandlers$12(this)), TuplesKt.to("showKtvTuningView", new ChorusJsbService$actionUpdateHandlers$13(this)), TuplesKt.to("enableNetworkDetection", new ChorusJsbService$actionUpdateHandlers$14(this)), TuplesKt.to("setRuntimeParameters", new ChorusJsbService$actionUpdateHandlers$15(this)), TuplesKt.to("initRTCAndLiveClient", new ChorusJsbService$actionUpdateHandlers$16(this)), TuplesKt.to("startRtcEngine", new ChorusJsbService$actionUpdateHandlers$17(this)), TuplesKt.to("checkAudioPermission", new ChorusJsbService$actionUpdateHandlers$18(this)), TuplesKt.to("initChorusEncodeConfig", new ChorusJsbService$actionUpdateHandlers$19(this)), TuplesKt.to("muteLocalAudio", new ChorusJsbService$actionUpdateHandlers$20(this)), TuplesKt.to("setRemoteVideoConfig", new ChorusJsbService$actionUpdateHandlers$21(this)), TuplesKt.to("startAudioCapture", new ChorusJsbService$actionUpdateHandlers$22(this)), TuplesKt.to("updateJoinStatus", new ChorusJsbService$actionUpdateHandlers$23(this)), TuplesKt.to("setVoiceVolume", new ChorusJsbService$actionUpdateHandlers$24(this)), TuplesKt.to("setDefaultMixStreamVolume", new ChorusJsbService$actionUpdateHandlers$25(this)), TuplesKt.to("setUserMixStreamVolume", new ChorusJsbService$actionUpdateHandlers$26(this)), TuplesKt.to("removeUserMixStreamVolume", new ChorusJsbService$actionUpdateHandlers$27(this)), TuplesKt.to("startExtraStreamMixTask", new ChorusJsbService$actionUpdateHandlers$28(this)), TuplesKt.to("stopExtraStreamMixTask", new ChorusJsbService$actionUpdateHandlers$29(this)), TuplesKt.to("updateMixedStreamConfig", new ChorusJsbService$actionUpdateHandlers$30(this)), TuplesKt.to("updateMixStreamConfigForPcChorus", new ChorusJsbService$actionUpdateHandlers$31(this)), TuplesKt.to("updateMixedChorusRole", new ChorusJsbService$actionUpdateHandlers$32(this)), TuplesKt.to("setCellularEnhancement", new ChorusJsbService$actionUpdateHandlers$33(this)), TuplesKt.to("handleJoinChorusPermission", new ChorusJsbService$actionUpdateHandlers$34(this)), TuplesKt.to("setAudioAlignment", new ChorusJsbService$actionUpdateHandlers$35(this)), TuplesKt.to("switchCDNStream", new ChorusJsbService$actionUpdateHandlers$36(this)), TuplesKt.to("updateCdnStreamVolume", new ChorusJsbService$actionUpdateHandlers$37(this)), TuplesKt.to("showCellularDialog", new ChorusJsbService$actionUpdateHandlers$38(this)), TuplesKt.to("setAudioEffectType", new ChorusJsbService$actionUpdateHandlers$39(this)), TuplesKt.to("enableLocalAudio", new ChorusJsbService$actionUpdateHandlers$40(this)), TuplesKt.to("enableChorusSpatialAudio", new ChorusJsbService$actionUpdateHandlers$41(this)), TuplesKt.to("showGroupLiveChorusInvitePage", new ChorusJsbService$actionUpdateHandlers$42(this)), TuplesKt.to("setRuntimeParametersOnLink", new ChorusJsbService$actionUpdateHandlers$43(this)), TuplesKt.to("updateChorusPlayModeStatus", new ChorusJsbService$actionUpdateHandlers$44(this)), TuplesKt.to("updateUserSubscribeVideoStreamIndex", new ChorusJsbService$actionUpdateHandlers$45(this)), TuplesKt.to("muteAllRemoteAudioStreams", new ChorusJsbService$actionUpdateHandlers$46(this))});
    }
}
