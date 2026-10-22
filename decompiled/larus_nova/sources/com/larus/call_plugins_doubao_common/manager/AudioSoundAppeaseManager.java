package com.larus.call_plugins_doubao_common.manager;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.plugins.q0;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class AudioSoundAppeaseManager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f321376i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.call_plugins_doubao_common.a f321377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f321378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f321379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f321380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f321381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f321382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f321383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f321384h;

    public interface a {
    }

    public static final class b {
    }

    static {
    }

    public final float c() {
        if (Intrinsics.areEqual(this.f321377a, com.larus.call_plugins_doubao_common.b.f321368b) == false) goto L6;
        return 1.0f;
    L6:
        return ((Keva) p68.g.f527930a.getValue()).getInt("appease_volume", 10) / 10.0f;
    }

    public final IVideoController d() {
        return (IVideoController) this.f321379c.getValue();
    }

    public final void f() {
        IVideoController r100 = d();
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        IVideoController r101 = d();
        if (r101 == null) goto L8;
        r101.l();
    L8:
        IVideoController r102 = d();
        if (r102 == null) goto L12;
        r102.release();
        return;
    }

    public AudioSoundAppeaseManager(com.larus.call_plugins_doubao_common.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f321377a = r100;
        this.f321379c = LazyKt.lazy(new i(this));
        this.f321380d = LazyKt.lazy(new j());
    }

    public final void g(final Context r100) {
        IVideoController r101 = d();
        if (r101 == null) goto L5;
        r101.t();
    L5:
        ValueAnimator r102 = this.f321381e;
        if (r102 == null) goto L10;
        boolean r103 = true;
        if (r102.isRunning() != true) goto L10;
    L11:
        if (r103 == false) goto L13;
        FLogger.f375446a.i("AudioSoundSoothingManager", "[playAudio] globalAnimator isRunning ");
        return;
    L13:
        this.f321383g = false;
        if (this.f321384h == false) goto L16;
        final float r104 = 0.3f;
    L17:
        ValueAnimator r105 = tk9.b.a(0.0f, r104, this.f321377a.f321365f, new e(this, r100), new f(this), new g(r104, this));
        ValueAnimator r106 = this.f321381e;
        this.f321381e = r105;
        t0.a(new h(r106, r105));
        return;
    L16:
        r104 = c();
    L10:
        r103 = false;
        goto L11
    }

    public final void i(final Function1<? super Boolean, Unit> r110) {
        FLogger.f375446a.i("AudioSoundSoothingManager", "stopAudioWithAnimal return isPlaying: " + this.f321382f);
        this.f321383g = true;
        this.f321384h = false;
        if (this.f321382f == true) goto L8;
        t0.a(new d(this.f321381e));
        if (r110 == null) goto L14;
        r110.invoke(Boolean.valueOf(this.f321382f));
        return;
    L14:
        return;
    L8:
        IVideoController r100 = d();
        if (r100 == null) goto L11;
        float r101 = r100.g();
    L12:
        ValueAnimator r111 = tk9.b.b(r101, 0.0f, this.f321377a.f321366g, null, new com.larus.call_plugins_doubao_common.manager.a(this), new c(this, r110), 8);
        ValueAnimator r102 = this.f321381e;
        this.f321381e = r111;
        t0.a(new h(r102, r111));
        return;
    L11:
        r101 = 1.0f;
        goto L12
    }

    public AudioSoundAppeaseManager(com.larus.call_plugins_doubao_common.a r100, q0 r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this(r100);
        this.f321378b = r101;
    }

    public final void h(boolean r110, Function1<? super Boolean, Unit> r111) {
        this.f321383g = true;     // Catch: Exception -> L31
        this.f321384h = false;     // Catch: Exception -> L31
        t0.a(new d(this.f321381e));     // Catch: Exception -> L31
        if (this.f321382f == true) goto L9;
        FLogger.f375446a.i("AudioSoundSoothingManager", "stopAudio return isPlaying: " + this.f321382f);     // Catch: Exception -> L31
        if (r111 == null) goto L37;
        r111.invoke(Boolean.valueOf(this.f321382f));     // Catch: Exception -> L31
        return;
    L37:
        return;
    L9:
        this.f321382f = false;     // Catch: Exception -> L31
        if (r110 == false) goto L12;
    L25:
        FLogger.f375446a.i("AudioSoundSoothingManager", "stopImmediately");     // Catch: Exception -> L31
        IVideoController r112 = d();     // Catch: Exception -> L31
        if (r112 == null) goto L28;
        r112.stop();     // Catch: Exception -> L31
    L28:
        if (r111 == null) goto L41;
        r111.invoke(Boolean.FALSE);     // Catch: Exception -> L31
        return;
    L41:
        return;
    L12:
        if (Intrinsics.areEqual(this.f321377a, com.larus.call_plugins_doubao_common.b.f321368b) == false) goto L25;
        IVideoController r113 = d();     // Catch: Exception -> L31
        if (r113 == null) goto L16;
        Number r114 = Integer.valueOf(r113.getWatchedDuration());     // Catch: Exception -> L31
    L17:
        Number r100 = r114;
        long r101 = AudioServiceDelegate.f288288a.w0();     // Catch: Exception -> L31
        FLogger r115 = FLogger.f375446a;     // Catch: Exception -> L31
        r115.i("AudioSoundSoothingManager", "stopAudio currentTime: " + r100 + ", minPlayingTime:" + r101);     // Catch: Exception -> L31
        if (r100.longValue() >= r101) goto L20;
        r115.i("AudioSoundSoothingManager", "stopAudio currentTime: " + r100);     // Catch: Exception -> L31
        BuildersKt.launch$default((CoroutineScope) this.f321380d.getValue(), null, null, new AudioSoundAppeaseManager$stopAudio$1(r101, r100, this, r111, null), 3, null);     // Catch: Exception -> L31
        return;
    L20:
        r115.i("AudioSoundSoothingManager", "stopImmediately currentTime: " + r100);     // Catch: Exception -> L31
        IVideoController r116 = d();     // Catch: Exception -> L31
        if (r116 == null) goto L23;
        r116.stop();     // Catch: Exception -> L31
    L23:
        if (r111 == null) goto L39;
        r111.invoke(Boolean.FALSE);     // Catch: Exception -> L31
        return;
    L39:
        return;
    L16:
        r114 = 0L;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        FLogger.f375446a.i("AudioSoundSoothingManager", "error: stopAudio: " + e);
        if (r111 == null) goto L42;
        r111.invoke(Boolean.valueOf(this.f321382f));
        return;
    }

    public static final Object a(AudioSoundAppeaseManager r100, Context r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof AudioSoundAppeaseManager$resolveAudioPath$1) == false) goto L7;
        AudioSoundAppeaseManager$resolveAudioPath$1 r101 = (AudioSoundAppeaseManager$resolveAudioPath$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AudioSoundAppeaseManager$resolveAudioPath$1 r103 = r101;
        Object r112 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        String r113 = (String) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L38:
        boolean r114 = ((Boolean) r112).booleanValue();
        if (r114 == false) goto L41;
        FLogger.f375446a.i("AudioSoundSoothingManager", "resolveAudioPath use local asset audio, fileName=" + r100.f321377a.f321360a);
    L41:
        if (r114 == false) goto L44;
        return r113;
    L44:
        return "";
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        Function0<String> r115 = r100.f321378b;
        PolarisFileWrapper r106 = null;
        if (r115 == null) goto L17;
        String r116 = r115.invoke();
    L18:
        if (r116 == null) goto L20;
        r106 = new PolarisFileWrapper(r116);
    L20:
        boolean r107 = false;
        if (r106 != null) goto L23;
    L25:
        boolean r108 = false;
    L26:
        if (r108 == false) goto L28;
        FLogger.f375446a.i("AudioSoundSoothingManager", "resolveAudioPath use preferred audio file, fileName=" + r100.f321377a.f321360a);
        return r106.getAbsolutePath();
    L28:
        if (r116 != null) goto L30;
    L31:
        r107 = true;
    L32:
        if (r107 == true) goto L34;
        FLogger.f375446a.i("AudioSoundSoothingManager", "resolveAudioPath preferred audio invalid, fallback to asset, fileName=" + r100.f321377a.f321360a);
    L34:
        String r117 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + File.separator + r100.f321377a.f321360a;
        com.larus.call_plugins_doubao_common.a r109 = r100.f321377a;
        String r118 = r109.f321360a;
        String r119 = r109.f321361b;
        r103.L$0 = r117;
        r103.label = 1;
        Object r120 = r100.e(r118, r117, r119, r110, r103);
        if (r120 == r104) goto L47;
        r112 = r120;
        r113 = r117;
        goto L38
    L47:
        return r104;
    L30:
        if (r116.length() != 0) goto L32;
    L23:
        if (r106.isFile() != true) goto L25;
        r108 = true;
        goto L26
    L17:
        r116 = null;
    L7:
        r101 = new AudioSoundAppeaseManager$resolveAudioPath$1(r100, r111);
        goto L8
    }

    public final void b(final float r110, long r111, final String r112) {
        if (this.f321382f == true) goto L6;
        FLogger.f375446a.i("AudioSoundSoothingManager", "[" + r112 + "] ignore volume change, isPlaying: " + this.f321382f);
        t0.a(new d(this.f321381e));
        return;
    L6:
        IVideoController r100 = d();
        if (r100 == null) goto L9;
        float r101 = r100.g();
    L10:
        ValueAnimator r113 = tk9.b.b(r101, r110, r111, null, new k(r112, this), new com.larus.call_plugins_doubao_common.manager.b(r112, r110, this), 8);
        ValueAnimator r114 = this.f321381e;
        this.f321381e = r113;
        t0.a(new h(r114, r113));
        return;
    L9:
        r101 = c();
        goto L10
    }

    public final Object e(String r100, String r101, String r102, Context r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AudioSoundAppeaseManager$initCheckFile$1) == false) goto L7;
        AudioSoundAppeaseManager$initCheckFile$1 r103 = (AudioSoundAppeaseManager$initCheckFile$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r112 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        String r107 = (String) r103.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L27
    L26:
        return r112;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        PolarisFileWrapper r113 = new PolarisFileWrapper(r101);     // Catch: Exception -> L27
        if (r113.exists() == true) goto L20;
    L23:
        CoroutineDispatcher r108 = Dispatchers.getIO();     // Catch: Exception -> L27
        AudioSoundAppeaseManager$initCheckFile$2 r109 = new AudioSoundAppeaseManager$initCheckFile$2(r113, r110, r100, null);     // Catch: Exception -> L27
        r103.L$0 = r100;     // Catch: Exception -> L27
        r103.label = 1;     // Catch: Exception -> L27
        r112 = BuildersKt.withContext(r108, r109, r103);     // Catch: Exception -> L27
        if (r112 != r105) goto L26;
        return r105;
    L20:
        if (TextUtils.equals(r102, dx8.a.a(r113)) == false) goto L23;
        FLogger.f375446a.i("AudioSoundSoothingManager", "initCheckFile local cache valid, assetName=" + r100);     // Catch: Exception -> L27
        return Boxing.boxBoolean(true);
    L27:
        e = move-exception;
        FLogger.f375446a.e("AudioSoundSoothingManager", "initCheckFile error, assetName=" + r100 + ", type=" + e.getClass().getSimpleName());
        return Boxing.boxBoolean(false);
    L7:
        r103 = new AudioSoundAppeaseManager$initCheckFile$1(this, r111);
        goto L8
    }
}
