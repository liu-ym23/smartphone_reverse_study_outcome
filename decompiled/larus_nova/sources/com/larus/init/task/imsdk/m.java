package com.larus.init.task.imsdk;

import com.larus.audio.AudioServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class m implements gd9.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f351386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f351387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f351388c = null;

    public m() {
    }

    static {
        f351386a = new m();
        f351387b = LazyKt.lazy(new k());
        f351388c = LazyKt.lazy(new l());
    }

    @Override // gd9.s
    public final boolean a() {
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        if (r100.getAudioConfig().c() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getAudioConfig().a() == false) goto L7;
        return true;
    }

    @Override // gd9.s
    public final boolean c() {
        if (z2.f365865a.continueTalkV2Config().d() == false) goto L5;
    L8:
        return true;
    L5:
        if (VoiceCallServiceDelegate.f377087a.i() == true) goto L8;
        return false;
    }

    @Override // gd9.s
    public final int d() {
        return AudioServiceDelegate.f288288a.getAudioConfig().A();
    }

    @Override // gd9.s
    public final boolean e() {
        boolean r100 = c78.a.f22657a;
        return c78.a.f22659c;
    }

    @Override // gd9.s
    public final boolean f() {
        return !AppHost.f326268a.isOversea();
    }

    @Override // gd9.s
    public final boolean g() {
        return VoiceCallServiceDelegate.f377087a.p();
    }

    @Override // gd9.s
    public final boolean i() {
        boolean r100 = AudioServiceDelegate.f288288a.getAudioConfig().z();
        AppHost.Companion r101 = AppHost.f326268a;
        if (r101.isTestChannel() == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        if (r100 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L5:
        if (CollectionsKt.listOf(new String[]{"inhouse", "auto_test"}).contains(r101.getBuildChannel()) == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // gd9.s
    public final boolean j() {
        return z2.f365865a.realtimeCallAllSceneMixEnable();
    }

    @Override // gd9.s
    public final Map<String, String> k() {
        return VoiceCallServiceDelegate.f377087a.c();
    }

    @Override // gd9.s
    public final boolean l() {
        return VoiceCallServiceDelegate.f377087a.D();
    }

    @Override // gd9.s
    public final boolean m() {
        return z2.f365865a.H2();
    }

    @Override // gd9.s
    public final String n() {
        return AudioServiceDelegate.f288288a.getAudioConfig().C();
    }

    public final boolean q() {
        return AppHost.f326268a.isOversea();
    }

    @Override // gd9.s
    public final boolean shareScreenEnableDualAec() {
        return z2.f365865a.shareScreenEnableDualAec();
    }

    @Override // gd9.s
    public final boolean shareScreenUseSoftAec() {
        return z2.f365865a.shareScreenUseSoftAec();
    }

    @Override // gd9.s
    public final String speechAecForceMicSelect() {
        return z2.f365865a.speechAecForceMicSelect();
    }

    @Override // gd9.s
    public final String h() {
        boolean r100 = i();
        JSONObject r101 = new JSONObject();
        boolean r102 = AppHost.f326268a.isOversea();
        if (r100 == false) goto L9;
        JSONArray r103 = new JSONArray();
        if (r102 == false) goto L7;
        r103.put("rtc-access-mya-test.bytevcloud.com");
    L8:
        Unit r104 = Unit.INSTANCE;
        r101.put("access_hosts", r103);
        goto L9
    L7:
        r103.put("rtc-access-test.bytedance.com");
    L9:
        JSONObject r105 = new JSONObject();
        r105.put("isMediaOversea", r102);
        r105.put("isDataOversea", r102);
        Unit r106 = Unit.INSTANCE;
        r101.put("rtc.is_oversea", r105);
        q.f351394a.i("FlowImRTCDependImpl", "rtc test domain " + r100 + '.');
        return r101.toString();
    }

    public static String r(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        Reader r102 = new InputStreamReader(AppHost.f326268a.getApplication().getAssets().open(r100), Charsets.UTF_8);     // Catch: Throwable -> L16
        if ((r102 instanceof BufferedReader) == false) goto L6;
        BufferedReader r103 = (BufferedReader) r102;     // Catch: Throwable -> L16
    L23:
        String r104 = TextStreamsKt.readText(r103);     // Catch: Throwable -> L11
    L9:
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L16
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = "";
    L22:
        return (String) r105;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L6:
        r103 = new BufferedReader(r102, 8192);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // gd9.s
    public final boolean b(boolean r100) {
        return VoiceCallServiceDelegate.f377087a.b(r100);
    }

    public final String o(boolean r100) {
        if (AppHost.f326268a.isOversea() == false) goto L8;
        if (r100 == false) goto L6;
        return "frontier100-mmt-normal-mya.dola.com";
    L6:
        return "frontier-mmt-normal.dola.com";
    L8:
        if (r100 == false) goto L10;
        return "frontier100-mmt-normal-lf.doubao.com";
    L10:
        return "frontier-mmt-normal.doubao.com";
    }

    public final String p(boolean r100) {
        if (r100 == false) goto L5;
        return (String) f351388c.getValue();
    L5:
        return (String) f351387b.getValue();
    }
}
