package com.lynx.animax.ability;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.animax.audio.AudioAsset;
import com.lynx.animax.audio.AudioPlayer;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.player.IVideoPlayer;
import com.lynx.animax.player.VideoPlayerType;
import com.lynx.animax.player.g;
import com.lynx.animax.player.h;
import com.lynx.animax.service.IAnimaXVideoService;
import com.lynx.animax.util.AnimaXLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import q4a.b;
import t4a.c;
import t4a.f;
import w4a.d;
import w4a.e;

/* JADX INFO: loaded from: classes32.dex */
public class BaseAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f380237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<b> f380238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f380239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f380240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v4a.d f380241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f380242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f380243g;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f380244a = null;

        static {
            int[] r100 = new int[Event.values().length];
            f380244a = r100;
            r100[Event.COMPLETION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f380244a[Event.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f380244a[Event.REPEAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f380244a[Event.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f380244a[Event.READY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f380244a[Event.ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f380244a[Event.UPDATE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f380244a[Event.FPS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f380244a[Event.COMPOSITION_READY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f380244a[Event.TAP_LAYERS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f380244a[Event.FIRST_FRAME.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f380244a[Event.WARNING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public String h(String r100) {
        return r100;
    }

    public boolean disableByteVC1Decoder() {
        return y4a.a.e(y4a.a.b("ANIMAX_DISABLE_BYTEVC1_DECODER", this));
    }

    public BaseAbility() {
        this.f380237a = new CopyOnWriteArrayList();
        d r100 = new d(f());
        this.f380239c = r100;
        this.f380240d = new g(r100);
        this.f380241e = new v4a.d(r100);
        this.f380242f = false;
    }

    public e f() {
        return e.f558281b;
    }

    public AudioPlayer createAudioPlayer(AudioAsset r100) {
        if (r100.a() == false) goto L11;
        ByteBuffer r101 = r100.f380248c;
        if (r101 == null) goto L11;
        return new AudioPlayer(r100.f380247b, r101);
    L9:
        e = move-exception;
        AnimaXLog.a("AudioPlayer", "Failed to create AudioPlayer: " + e.getMessage());
        return null;
    L11:
        AnimaXLog.a("AudioPlayer", "Failed to create AudioPlayer: asset is not ready");
        return null;
    }

    public IVideoPlayer createVideoPlayer(long r100) {
        g r101 = this.f380240d;
        String r102 = y4a.a.b("ANIMAX_VIDEO_SURFACE_DESTROY_TIMEOUT", this);
        long r103 = 0;
    L8:
        e = move-exception;
        AnimaXLog.a("DeviceUtil", "getVideoSurfaceDestroyTimeout fail, message" + e.getMessage());
    L10:
        r101.f380370d = r103;
        g r104 = this.f380240d;
        if (r104.f380368b != VideoPlayerType.CUSTOM) goto L17;
        IAnimaXVideoService r105 = (IAnimaXVideoService) r104.f380367a.a(IAnimaXVideoService.class);
        if (r105 != null) goto L20;
        AnimaXLog.a("VideoPlayerFactory", "IAnimaXVideoService not found, use default player");
        goto L17
    L20:
        return r105.createVideoPlayer(r100, r104);
    L17:
        return new h(r100, r104);
    L4:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r103 = CastLongProtector.parseLong(r102);     // Catch: NumberFormatException -> L8
        goto L10
    }

    public void sendEvent(int r100, ReadableMap r101) {
        o4a.a r102 = new o4a.a(this, r100, r101.asHashMap());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r102.run();
        return;
    L8:
        y4a.d.a().post(r102);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
