package com.larus.music.qq;

import android.app.Application;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.tencent.qqmusic.third.api.contract.IQQMusicApi;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class QQMusicApiUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final QQMusicApiUtils f359493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f359494b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<Unit> f359495c;

    public QQMusicApiUtils() {
    }

    static {
        f359493a = new QQMusicApiUtils();
        f359494b = new Gson();
    }

    public static boolean a(ServiceConnection r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_CONNECTION);
        Application r101 = AppHost.f326268a.getApplication();
        Intent r102 = new Intent("com.tencent.qqmusic.third.api.QQMusicApiService");
        r102.setPackage("com.tencent.qqmusic");
        return r101.bindService(r102, r100, 1);
    }

    public static void f(int r100) {
        if (r100 == 0) goto L5;
        GlobalAudioObserver.f289772a.f(GlobalAudioSceneEnum.QQ_MUSIC, Integer.valueOf(r100), null);
        return;
    }

    public static Pair e(IQQMusicApi r100, String r110, Bundle r111) {
        if (r100 != null) goto L26;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeSyncFunWithReturn-----api is null funName:".concat(r110));
        return new Pair(-2, null);
    L26:
        Bundle r112 = r100.execute(r110, r111);     // Catch: Exception -> L17 DeadObjectException -> L20
        FLogger r101 = FLogger.f375446a;     // Catch: Exception -> L17 DeadObjectException -> L20
        StringBuilder r102 = new StringBuilder("executeSyncFunWithReturn---funName:");     // Catch: Exception -> L17 DeadObjectException -> L20
        r102.append(r110);     // Catch: Exception -> L17 DeadObjectException -> L20
        r102.append("--api");     // Catch: Exception -> L17 DeadObjectException -> L20
        r102.append(r100);     // Catch: Exception -> L17 DeadObjectException -> L20
        r102.append("---result:");     // Catch: Exception -> L17 DeadObjectException -> L20
        r102.append(r112);     // Catch: Exception -> L17 DeadObjectException -> L20
        r102.append("--errcode:");     // Catch: Exception -> L17 DeadObjectException -> L20
        if (r112 == null) goto L10;
        Integer r103 = Integer.valueOf(rl9.a.b(r112));     // Catch: Exception -> L17 DeadObjectException -> L20
    L11:
        r102.append(r103);     // Catch: Exception -> L17 DeadObjectException -> L20
        r101.d("QQMusicManager_APIUtils", r102.toString());     // Catch: Exception -> L17 DeadObjectException -> L20
        if (r112 == null) goto L14;
        int r104 = rl9.a.a(rl9.a.b(r112));     // Catch: Exception -> L17 DeadObjectException -> L20
    L15:
        return new Pair(Integer.valueOf(r104), r112);
    L14:
        r104 = -1;
        goto L15
    L10:
        r103 = null;
    L20:
        e = move-exception;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeSyncFunWithReturn---funName:" + r110 + "----api" + r100 + "---DeadObjectException:" + e.getMessage() + "----" + e.getCause() + "----" + e + "---");
        Function0<Unit> r105 = f359495c;
        if (r105 == null) goto L25;
        r105.invoke();
    L25:
        return new Pair(-2, null);
    L17:
        e = move-exception;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeSyncFunWithReturn---funName:" + r110 + "---normal Exception:" + e + "------" + e.getMessage() + "---" + e.getCause() + '-');
        return new Pair(-1, null);
    }

    public static void b(IQQMusicApi r100, final String r101, Bundle r102, final Function3 r103) {
        if (r100 != null) goto L16;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeAsyncFun-----api is null funName:".concat(r101));
        r103.invoke(-2, null, null);
        return;
    L16:
        r100.executeAsync(r101, r102, new QQMusicApiUtils$executeAsyncFun$1(r101, r103));     // Catch: Exception -> L8 DeadObjectException -> L10
    L19:
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeAsyncFun----- funName:" + r101 + "---api:" + r100 + "----DeadObjectException：" + e + "---" + e.getMessage() + "---" + e.getCause());
        Function0<Unit> r104 = f359495c;
        if (r104 == null) goto L14;
        r104.invoke();
    L14:
        r103.invoke(-2, null, null);
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeAsyncFun----- funName:" + r101 + "-----noraml Exception：" + e + "--e.message:" + e.getMessage() + "---e.cause:" + e.getCause());
        r103.invoke(-1, null, null);
    }

    /* JADX WARN: Type inference failed for: r5v15, types: [com.larus.music.qq.s] */
    /* JADX WARN: Type inference failed for: r5v19, types: [com.larus.music.qq.m] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.music.qq.b] */
    public final int c(String r100, IQQMusicApi r101, Bundle r102, final Function3<? super Integer, ? super Integer, Object, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "playEvent");
        GlobalAudioObserver.f289772a.e(GlobalAudioSceneEnum.QQ_MUSIC, "", null);
        switch(r100.hashCode()) {
            case -1894100143: goto L24;
            case -1660702351: goto L19;
            case -347763648: goto L15;
            case -95598088: goto L11;
            case 189124205: goto L6;
            default: goto L31;
        };
    L31:
        return -1;
    L6:
        if (r100.equals("skipToNext") == false) goto L32;
        int r104 = ((Number) e(r101, "skipToNext", null).getFirst()).intValue();
        f(r104);
        return r104;
    L32:
        return -1;
    L11:
        if (r100.equals("resumeMusic") == false) goto L33;
        final ?? r105 = new m(r103);
        d(r101, "resumeMusic", null, true, new x(r105));
        return -1;
    L33:
        return -1;
    L15:
        if (r100.equals("playSongMidAtIndex") == false) goto L34;
        final ?? r106 = new s(r103);
        b(r101, "playSongMidAtIndex", r102, new u(r106));
        return -1;
    L34:
        return -1;
    L19:
        if (r100.equals("skipToPrevious") == false) goto L35;
        int r107 = ((Number) e(r101, "getCurrentSong", null).getFirst()).intValue();
        f(r107);
        return r107;
    L35:
        return -1;
    L24:
        if (r100.equals("playMusic") == false) goto L30;
        final ?? r108 = new b(r103);
        d(r101, "playMusic", null, true, new v(r108));
        return -1;
    L30:
        return -1;
    }

    public static void d(IQQMusicApi r100, String r101, Bundle r102, boolean r103, Function3 r110) {
        int r104 = -2;
        if (r100 != null) goto L31;
        if (r103 == false) goto L6;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeSyncFunWithReturn-----api is null funName:".concat(r101));
    L6:
        r110.invoke(-2, null, null);
        return;
    L31:
        Bundle r105 = r100.execute(r101, r102);     // Catch: Exception -> L23 DeadObjectException -> L25
        if (r103 == false) goto L15;
        FLogger r106 = FLogger.f375446a;     // Catch: Exception -> L23 DeadObjectException -> L25
        StringBuilder r107 = new StringBuilder("executeSyncFunWithReturn-----funName:");     // Catch: Exception -> L23 DeadObjectException -> L25
        r107.append(r101);     // Catch: Exception -> L23 DeadObjectException -> L25
        r107.append("-----errcode：");     // Catch: Exception -> L23 DeadObjectException -> L25
        if (r105 == null) goto L13;
        Integer r108 = Integer.valueOf(rl9.a.b(r105));     // Catch: Exception -> L23 DeadObjectException -> L25
    L14:
        r107.append(r108);     // Catch: Exception -> L23 DeadObjectException -> L25
        r107.append("---result:");     // Catch: Exception -> L23 DeadObjectException -> L25
        r107.append(r105);     // Catch: Exception -> L23 DeadObjectException -> L25
        r106.d("QQMusicManager_APIUtils", r107.toString());     // Catch: Exception -> L23 DeadObjectException -> L25
        goto L15
    L13:
        r108 = null;
    L15:
        if (r105 == null) goto L17;
        r104 = rl9.a.a(rl9.a.b(r105));     // Catch: Exception -> L23 DeadObjectException -> L25
    L17:
        Integer r109 = Integer.valueOf(r104);     // Catch: Exception -> L23 DeadObjectException -> L25
        if (r105 == null) goto L20;
        Integer r111 = Integer.valueOf(rl9.a.b(r105));     // Catch: Exception -> L23 DeadObjectException -> L25
    L21:
        r110.invoke(r109, r111, r105);     // Catch: Exception -> L23 DeadObjectException -> L25
    L34:
        return;
    L20:
        r111 = null;
    L25:
        e = move-exception;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeSyncFunWithReturn-----funName:" + r101 + "----DeadObjectException--" + e);
        Function0<Unit> r112 = f359495c;
        if (r112 == null) goto L29;
        r112.invoke();
    L29:
        r110.invoke(-2, null, null);
        return;
    L23:
        e = move-exception;
        FLogger.f375446a.d("QQMusicManager_APIUtils", "executeSyncFunWithReturn-----funName:" + r101 + "----normal Exception--" + e);
        r110.invoke(-1, null, null);
    }
}
