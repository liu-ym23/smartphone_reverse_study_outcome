package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.ies.xelement.common.PlayerType;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.common.PlayModel;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.LoadingState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.PlaybackState;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine.g;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine.i;
import com.bytedance.ies.xelement.defaultimpl.player.engine.impl.player.engine.l;
import com.google.gson.JsonObject;
import com.ss.ttvideoengine.Resolution;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l76.d;
import o76.c;
import o76.h;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public final class MusicPlayerImpl implements o76.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f249887i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f249888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f249889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l76.a f249890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f249891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ResourcesType f249892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f249893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f249894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f249895h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xelement/defaultimpl/player/engine/impl/player/MusicPlayerImpl$ResourcesType;", "", "", "priority", "I", "getPriority", "()I", "AFD", "LOCAL_FILE", "PRELOAD_CACHE", "VIDEO_MODEL", "PLAY_URL", ErrorCode.INIT, "x-element-audio_release"}, k = 1, mv = {1, 6, 0})
    public static final enum ResourcesType extends Enum<ResourcesType> {
        public static final ResourcesType AFD = null;
        public static final ResourcesType INIT = null;
        public static final ResourcesType LOCAL_FILE = null;
        public static final ResourcesType PLAY_URL = null;
        public static final ResourcesType PRELOAD_CACHE = null;
        public static final ResourcesType VIDEO_MODEL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourcesType[] f249896a = null;
        private final int priority;

        public static ResourcesType valueOf(String r100) {
            return (ResourcesType) r27.a.a(ResourcesType.class, r100);
        }

        public static ResourcesType[] values() {
            return (ResourcesType[]) f249896a.clone();
        }

        static {
            ResourcesType r100 = new ResourcesType("AFD", 0, 3000);
            AFD = r100;
            ResourcesType r101 = new ResourcesType("LOCAL_FILE", 1, 2000);
            LOCAL_FILE = r101;
            ResourcesType r102 = new ResourcesType("PRELOAD_CACHE", 2, 1000);
            PRELOAD_CACHE = r102;
            ResourcesType r103 = new ResourcesType("VIDEO_MODEL", 3, 500);
            VIDEO_MODEL = r103;
            ResourcesType r104 = new ResourcesType("PLAY_URL", 4, 0);
            PLAY_URL = r104;
            ResourcesType r105 = new ResourcesType(ErrorCode.INIT, 5, -1);
            INIT = r105;
            f249896a = new ResourcesType[]{r100, r101, r102, r103, r104, r105};
        }

        public final int getPriority() {
            return this.priority;
        }

        public ResourcesType(String r100, int r101, int r102) {
            super(r100, r101);
            this.priority = r102;
        }
    }

    public final class a implements o76.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MusicPlayerImpl f249897a;

        public a(MusicPlayerImpl r100) {
            this.f249897a = r100;
        }

        @Override // o76.a
        public final void h(com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode r100) {
            Intrinsics.checkNotNullParameter(r100, "errorCode");
            d.f507797a.c(MusicPlayerImpl.f249887i, "Playable: " + this.f249897a.f249893f + ", occurred an error " + r100.getMsg());
            this.f249897a.c(r100);
            PlayerType r101 = PlayerType.DEFAULT;
            if ((this.f249897a.b() instanceof g) == false) goto L5;
            r101 = PlayerType.LIGHT;
        L5:
            l76.a r102 = this.f249897a.f249890c;
            String r103 = r101.getDesc();
            StringBuilder r104 = new StringBuilder("play error and to switchResources, currentPlayable: ");
            k r105 = this.f249897a.f249893f;
            if (r105 == null) goto L8;
            String r106 = r105.toString();
        L9:
            r104.append(r106);
            String r107 = r104.toString();
            k r108 = this.f249897a.f249893f;
            if (r108 == null) goto L12;
            String r109 = r108.toString();
        L13:
            r102.c(-1, r103, false, r107, r109, -1);
            return;
        L12:
            r109 = null;
            goto L13
        L8:
            r106 = null;
            goto L9
        }

        @Override // o76.a
        public final void i(o76.g r100) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            this.f249897a.f249889b.onCompletion();
        }

        @Override // o76.a
        public final void l(o76.g r100) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            this.f249897a.f249889b.onPrepare();
        }

        @Override // o76.a
        public final void m(i r100) {
            Intrinsics.checkNotNullParameter(r100, "engine");
        }

        @Override // o76.a
        public final void n(i r100) {
            Intrinsics.checkNotNullParameter(r100, "engine");
        }

        @Override // o76.a
        public final void q(o76.g r100) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            this.f249897a.f249889b.onPrepared();
        }

        @Override // o76.a
        public final void r(i r100) {
            Intrinsics.checkNotNullParameter(r100, "engine");
        }

        @Override // o76.a
        public final void j(i r100, LoadingState r101) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            Intrinsics.checkNotNullParameter(r101, "loadingState");
            this.f249897a.f249889b.e(r101);
        }

        @Override // o76.a
        public final void k(o76.g r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            this.f249897a.f249889b.s(r101);
        }

        @Override // o76.a
        public final void o(o76.g r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            this.f249897a.f249889b.i(r101);
        }

        @Override // o76.a
        public final void p(o76.g r100, PlaybackState r101) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            Intrinsics.checkNotNullParameter(r101, "playbackState");
            this.f249897a.f249889b.p(r101);
        }
    }

    public static final class b {
    }

    static {
        f249887i = MusicPlayerImpl.class.getSimpleName();
    }

    public final o76.g b() {
        return (o76.g) this.f249891d.getValue();
    }

    public final boolean a(ResourcesType r100) {
        ResourcesType r101 = this.f249892e;
        if (r101 != ResourcesType.INIT) goto L6;
        this.f249892e = r100;
        return true;
    L6:
        if (r101.getPriority() <= r100.getPriority()) goto L8;
        this.f249892e = r100;
        return true;
    L8:
        return false;
    }

    public final void c(com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode r100) {
        k r101 = this.f249893f;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r101.f522277d == null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
    L15:
        String r104 = r101.f522275b;
        if (r104 != null) goto L18;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == true) goto L26;
    L28:
        String r106 = r101.f522276c;
        if (r106 != null) goto L31;
    L36:
        boolean r107 = false;
    L37:
        if (r107 == false) goto L48;
        String r108 = r101.f522274a;
        if (r108 != null) goto L41;
    L44:
        boolean r109 = true;
    L46:
        if ((!r109) == false) goto L48;
        boolean r110 = true;
    L49:
        if (r110 == true) goto L51;
    L53:
        PlayModel r111 = r101.f522278e;
        if (r111 == null) goto L56;
        JsonObject r112 = r111.getVideoModelJsonObj();
    L57:
        if (r112 == null) goto L59;
        boolean r113 = true;
    L60:
        if (r113 == true) goto L62;
    L66:
        String r114 = r101.f522274a;
        if (r114 != null) goto L69;
    L70:
        r102 = true;
    L72:
        if ((!r102) == true) goto L74;
    L76:
        this.f249892e = ResourcesType.INIT;
        this.f249889b.h(r100);
        return;
    L74:
        if (a(ResourcesType.PLAY_URL) == false) goto L76;
        b().setDirectURL(r101.f522274a);
        return;
    L69:
        if (r114.length() != 0) goto L72;
    L62:
        if (a(ResourcesType.VIDEO_MODEL) == false) goto L66;
        PlayModel r115 = r101.f522278e;
        if (r115 == null) goto L82;
        o76.g r116 = b();
        Resolution r117 = r115.getResolution();
        r115.getEncryptType();
        r116.d(r117, r115.getVideoModel());
        return;
    L82:
        return;
    L59:
        r113 = false;
        goto L60
    L56:
        r112 = null;
        goto L57
    L51:
        if (a(ResourcesType.PRELOAD_CACHE) == false) goto L53;
        b().setDirectUrlUseDataLoader(r101.f522274a, r101.f522276c);
        return;
    L41:
        if (r108.length() == 0) goto L44;
        r109 = false;
    L48:
        r110 = false;
        goto L49
    L31:
        if (r106.length() <= 0) goto L33;
        boolean r118 = true;
    L34:
        if (r118 != true) goto L36;
        r107 = true;
        goto L37
    L33:
        r118 = false;
        goto L34
    L26:
        if (a(ResourcesType.LOCAL_FILE) == false) goto L28;
        b().setLocalURL(r101.f522275b);
        return;
    L18:
        if (r104.length() <= 0) goto L20;
        boolean r119 = true;
    L21:
        if (r119 != true) goto L23;
        r105 = true;
        goto L24
    L20:
        r119 = false;
        goto L21
    L11:
        if (a(ResourcesType.AFD) == false) goto L15;
        AssetFileDescriptor r120 = r101.f522277d;
        if (r120 == null) goto L78;
        b().setDataSource(r120.getFileDescriptor(), r120.getStartOffset(), r120.getDeclaredLength());
        return;
    L78:
        return;
    L8:
        r103 = false;
        goto L9
    }

    @Override // o76.a
    public final void h(com.bytedance.ies.xelement.defaultimpl.player.engine.api.player.ErrorCode r100) {
        Intrinsics.checkNotNullParameter(r100, "errorCode");
    }

    @Override // o76.a
    public final void i(o76.g r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void l(o76.g r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void m(i r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void n(i r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void q(o76.g r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void r(i r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void j(i r100, LoadingState r101) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        Intrinsics.checkNotNullParameter(r101, "loadingState");
    }

    @Override // o76.a
    public final void k(o76.g r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void o(o76.g r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "engine");
    }

    @Override // o76.a
    public final void p(o76.g r100, PlaybackState r101) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        Intrinsics.checkNotNullParameter(r101, "playbackState");
    }

    public MusicPlayerImpl(Context r100, AudioPlayerListenerDispatcher r101, l76.a r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mListener");
        Intrinsics.checkNotNullParameter(r102, "mAudioErrorMonitor");
        this.f249888a = r100;
        this.f249889b = r101;
        this.f249890c = r102;
        this.f249891d = LazyKt.lazy(new MusicPlayerImpl$mEngine$2(this));
        this.f249892e = ResourcesType.INIT;
        this.f249895h = new l();
    }
}
