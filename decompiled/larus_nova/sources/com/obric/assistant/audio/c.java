package com.obric.assistant.audio;

import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f385639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f385640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f385641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f385642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f385643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f385644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f385645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f385646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f385647i;

    public static final class a {
    }

    public static final class b extends AudioManager.AudioPlaybackCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f385648a;

        public b(c r100) {
            this.f385648a = r100;
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public final void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> r110) {
            FLogger r100 = FLogger.f375446a;
            StringBuilder r101 = new StringBuilder("onPlaybackConfigChanged configs: ");
            if (r110 == null) goto L5;
            Integer r102 = Integer.valueOf(r110.size());
        L6:
            r101.append(r102);
            r101.append(", isBaiduMapPlaying: ");
            r101.append(this.f385648a.f385644f);
            r100.i("BaiduMapTtsManager", r101.toString());
            this.f385648a.getClass();
            boolean r103 = false;
            Integer r104 = Integer.valueOf(AppHost.f326268a.getApplication().getPackageManager().getApplicationInfo(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP, 0).uid);     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L83
        L12:
            if (r104 == null) goto L97;
            int r105 = r104.intValue();
            if (r110 != null) goto L16;
            return;
        L16:
            List<AudioPlaybackConfiguration> r111 = r110;
            c r106 = this.f385648a;
            if ((r111 instanceof Collection) == true) goto L19;
        L21:
            Iterator<T> r112 = r111.iterator();
        L23:
            if (r112.hasNext() == false) goto L71;
            AudioPlaybackConfiguration r107 = (AudioPlaybackConfiguration) r112.next();
            r106.getClass();
            Method r108 = r106.f385640b;     // Catch: Throwable -> L33
            if (r108 == null) goto L28;
            Object r109 = r108.invoke(r107, new Object[0]);     // Catch: Throwable -> L33
        L30:
            if ((r109 instanceof Integer) == false) goto L35;
            Integer r113 = (Integer) r109;     // Catch: Throwable -> L33
        L37:
            if (r113 != null) goto L40;
        L68:
            boolean r114 = false;
        L69:
            if (r114 == false) goto L23;
            r103 = true;
            goto L71
        L40:
            if (r113.intValue() != r105) goto L68;
            Method r115 = r106.f385641c;     // Catch: Throwable -> L49
            if (r115 == null) goto L44;
            Object r116 = r115.invoke(r107, new Object[0]);     // Catch: Throwable -> L49
        L46:
            if ((r116 instanceof Boolean) == false) goto L51;
            Boolean r117 = (Boolean) r116;     // Catch: Throwable -> L49
        L53:
            if (Intrinsics.areEqual(r117, Boolean.TRUE) == false) goto L68;
            Method r118 = r106.f385642d;     // Catch: Throwable -> L62
            if (r118 == null) goto L57;
            Object r119 = r118.invoke(r107, new Object[0]);     // Catch: Throwable -> L62
        L59:
            if ((r119 instanceof Boolean) == false) goto L64;
            Boolean r120 = (Boolean) r119;     // Catch: Throwable -> L62
        L66:
            if (Intrinsics.areEqual(r120, Boolean.TRUE) == false) goto L68;
            r114 = true;
        L64:
            r120 = null;
            goto L66
        L57:
            r119 = null;
        L62:
            th = move-exception;
            FLogger.f375446a.e("BaiduMapTtsManager", "reflect isPlaying failed: " + th);
        L51:
            r117 = null;
            goto L53
        L44:
            r116 = null;
        L49:
            th = move-exception;
            FLogger.f375446a.e("BaiduMapTtsManager", "reflect isActive failed: " + th);
        L35:
            r113 = null;
            goto L37
        L28:
            r109 = null;
        L33:
            th = move-exception;
            FLogger.f375446a.e("BaiduMapTtsManager", "reflect getClientUid failed: " + th);
        L71:
            c r121 = this.f385648a;
            if (r103 != r121.f385644f) goto L74;
            return;
        L74:
            r121.f385644f = r103;
            FLogger r122 = FLogger.f375446a;
            r122.i("BaiduMapTtsManager", "onPlaybackConfigChanged baiduMap playing changed -> " + r103);
            if (r103 == false) goto L79;
            r122.i("BaiduMapTtsManager", "[TTS] BaiduMap navi START, invoke pauseTtsCallback");
            Function0<Unit> r123 = this.f385648a.f385645g;
            if (r123 == null) goto L98;
            r123.invoke();
            return;
        L98:
            return;
        L79:
            r122.i("BaiduMapTtsManager", "[TTS] BaiduMap navi END, invoke resumeTtsCallback");
            Function0<Unit> r124 = this.f385648a.f385646h;
            if (r124 == null) goto L100;
            r124.invoke();
            return;
        L100:
            return;
        L19:
            if (r111.isEmpty() == false) goto L21;
        L97:
            return;
        L9:
            th = move-exception;
            FLogger.f375446a.e("BaiduMapTtsManager", "getBaiduMapUid failed: " + th);
        L11:
            r104 = null;
            goto L12
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    public c() {
        this.f385639a = LazyKt.lazy(new com.obric.assistant.audio.a());
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(AudioPlaybackConfiguration.class.getMethod("getClientUid", new Class[0]));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L10;
        FLogger.f375446a.e("BaiduMapTtsManager", "reflect getMethod(getClientUid) failed", r102);
    L10:
        Object r103 = null;
        if (Result.m9455isFailureimpl(r101) == false) goto L13;
        r101 = null;
    L13:
        this.f385640b = (Method) r101;
        Object r104 = Result.m9449constructorimpl(AudioPlaybackConfiguration.class.getMethod("isActive", new Class[0]));     // Catch: Throwable -> L16
    L18:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L22;
        FLogger.f375446a.e("BaiduMapTtsManager", "reflect getMethod(isActive) failed", r105);
    L22:
        if (Result.m9455isFailureimpl(r104) == false) goto L24;
        r104 = null;
    L24:
        this.f385641c = (Method) r104;
        Object r106 = Result.m9449constructorimpl(AudioPlaybackConfiguration.class.getMethod("isPlaying", new Class[0]));     // Catch: Throwable -> L27
    L29:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L33;
        FLogger.f375446a.e("BaiduMapTtsManager", "reflect getMethod(isPlaying) failed", r107);
    L33:
        if (Result.m9455isFailureimpl(r106) == true) goto L36;
        r103 = r106;
    L36:
        this.f385642d = (Method) r103;
        this.f385643e = new Handler(Looper.getMainLooper());
        this.f385647i = LazyKt.lazy(new com.obric.assistant.audio.b(this));
        return;
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
