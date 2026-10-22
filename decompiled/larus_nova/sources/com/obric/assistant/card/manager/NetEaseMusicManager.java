package com.obric.assistant.card.manager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes32.dex */
public final class NetEaseMusicManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetEaseMusicManager f386504a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f386505b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f386506c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f386507d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, List<WeakReference<a>>> f386508e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Bundle f386509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f386510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f386511h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f386512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final NetEaseMusicManager$musicStateListener$1 f386513j = null;

    public interface a {
        void onMusicStateChanged(Bundle r100);
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            long r100 = NetEaseMusicManager.f386509f.getLong("id", 0);
            if (r100 != 0) goto L5;
            NetEaseMusicManager r101 = NetEaseMusicManager.f386504a;
            Bundle r102 = NetEaseMusicManager.f386509f;
            r101.getClass();
            NetEaseMusicManager.e(null, r102);
        L7:
            if (NetEaseMusicManager.f386508e.isEmpty() == false) goto L17;
            NetEaseMusicManager.f386504a.getClass();
            NetEaseMusicManager.f386510g = true;
            NetEaseMusicManager.f386506c.removeCallbacks(NetEaseMusicManager.f386511h);
            if (NetEaseMusicManager.f386512i == false) goto L22;
            NetEaseMusicManager.f386512i = false;
            ILogDepend.f384986a.d("NetEaseMusicManager", "removeMusicStateListener");
            IAgentAppIntentIDL r103 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
            if (r103 == null) goto L14;
            r103.unregisterMusicStateListener(NetEaseMusicManager.f386513j);
        L14:
            Bundle r104 = new Bundle();
            NetEaseMusicManager.f386509f = r104;
            NetEaseMusicManager.e(null, r104);
            return;
        L22:
            return;
        L17:
            if (NetEaseMusicManager.f386509f.getBoolean("isPlaying", false) == true) goto L20;
            NetEaseMusicManager.f386504a.getClass();
            NetEaseMusicManager.f386510g = true;
            NetEaseMusicManager.f386506c.removeCallbacks(NetEaseMusicManager.f386511h);
            return;
        L20:
            NetEaseMusicManager.f386506c.postDelayed(this, 1000);
            return;
        L5:
            NetEaseMusicManager r105 = NetEaseMusicManager.f386504a;
            String r106 = String.valueOf(r100);
            Bundle r107 = NetEaseMusicManager.f386509f;
            r105.getClass();
            NetEaseMusicManager.e(r106, r107);
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public NetEaseMusicManager() {
    }

    static {
        f386504a = new NetEaseMusicManager();
        f386505b = new String[]{"music.126.net", "music.163.com"};
        f386506c = new Handler(Looper.getMainLooper());
        f386507d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f386508e = new LinkedHashMap();
        f386509f = new Bundle();
        f386510g = true;
        f386511h = new b();
        f386513j = new NetEaseMusicManager$musicStateListener$1();
    }

    public static void a() {
        if (f386512i == false) goto L5;
        return;
    L5:
        IAgentAppIntentIDL r100 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r100 == null) goto L9;
        f386512i = true;
        ILogDepend.f384986a.d("NetEaseMusicManager", "ensureMusicStateListener");
        r100.registerMusicStateListener(f386513j);
        return;
    }

    public static boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r100.getPackageManager().getApplicationInfo("com.netease.cloudmusic", 0));     // Catch: Throwable -> L5
    L8:
        return Result.m9456isSuccessimpl(r102);
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static boolean d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "musicId");
        String r102 = f386509f.getString("local_message");
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100, r102) == true) goto L7;
        return false;
    L7:
        if (f386509f.getBoolean("isPlaying", false) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(String.valueOf(f386509f.getLong("id")), r101) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static void e(final String r100, final Bundle r101) {
        Iterator r102 = ((LinkedHashMap) f386508e).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        final Map.Entry r103 = (Map.Entry) r102.next();
        CollectionsKt.removeAll((List) r103.getValue(), new f(r100, r103, r101));
        if (((List) r103.getValue()).isEmpty() == false) goto L4;
        r102.remove();
        goto L4
    }

    public static void b(Bundle r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "traceInfo");
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE, "jump_to_app");
        if (r101 == false) goto L5;
        String r103 = "success";
    L6:
        r100.putString("click_music_result", r103);
        r100.putInt("item_position", r102 + 1);
        r100.putString("click_result", "click_to_redirect");
        if (r101 == false) goto L11;
        IAgentAppIntentIDL r104 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r104 == null) goto L11;
        r104.showMusicPage();
    L11:
        gda.a r105 = gda.a.f480986a;
        gda.b.a(r100);
        return;
    L5:
        r103 = "fail";
        goto L6
    }

    public static void f(String r110, MusicEntity[] r111, MusicEntity r112, Function1 r113) {
        Intrinsics.checkNotNullParameter(r113, "onResult");
        BuildersKt.launch$default(f386507d, null, null, new NetEaseMusicManager$playMusic$1(r110, r111, r112, r113, null), 3, null);
    }
}
