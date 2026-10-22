package com.bytedance.live.livelink.kmp.api.core.mixer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class RTCWaterMarkRegion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f255235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f255236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f255237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f255238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f255239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f255240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TranscoderImageRenderMode f255241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f255242h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/core/mixer/RTCWaterMarkRegion$TranscoderImageRenderMode;", "", "", "value", "I", "getValue", "()I", "RENDER_UNKNOWN", "RENDER_HIDDEN", "RENDER_FIT", "RENDER_ADAPTIVE", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TranscoderImageRenderMode extends Enum<TranscoderImageRenderMode> {
        public static final TranscoderImageRenderMode RENDER_ADAPTIVE = null;
        public static final TranscoderImageRenderMode RENDER_FIT = null;
        public static final TranscoderImageRenderMode RENDER_HIDDEN = null;
        public static final TranscoderImageRenderMode RENDER_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TranscoderImageRenderMode[] f255243a = null;
        private final int value;

        static {
            TranscoderImageRenderMode r100 = new TranscoderImageRenderMode("RENDER_UNKNOWN", 0, 0);
            RENDER_UNKNOWN = r100;
            TranscoderImageRenderMode r101 = new TranscoderImageRenderMode("RENDER_HIDDEN", 1, 1);
            RENDER_HIDDEN = r101;
            TranscoderImageRenderMode r102 = new TranscoderImageRenderMode("RENDER_FIT", 2, 2);
            RENDER_FIT = r102;
            TranscoderImageRenderMode r103 = new TranscoderImageRenderMode("RENDER_ADAPTIVE", 3, 3);
            RENDER_ADAPTIVE = r103;
            f255243a = new TranscoderImageRenderMode[]{r100, r101, r102, r103};
        }

        public static TranscoderImageRenderMode valueOf(String r100) {
            return (TranscoderImageRenderMode) a.a(TranscoderImageRenderMode.class, r100);
        }

        public static TranscoderImageRenderMode[] values() {
            return (TranscoderImageRenderMode[]) f255243a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public TranscoderImageRenderMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final String toString() {
        return "RTCWaterMarkRegion{x=" + this.f255235a + ", y=" + this.f255236b + ", w=" + this.f255237c + ", h=" + this.f255238d + ", zOrder=" + this.f255239e + ", alpha=" + this.f255240f + ", renderMode=" + this.f255241g + '}';
    }

    public RTCWaterMarkRegion() {
        this.f255240f = 1.0f;
        TranscoderImageRenderMode r100 = TranscoderImageRenderMode.RENDER_FIT;
        this.f255235a = 0.0f;
        this.f255236b = 0.0f;
        this.f255237c = 0.0f;
        this.f255238d = 0.0f;
        this.f255239e = 0;
        this.f255240f = 1.0f;
        this.f255241g = r100;
        this.f255242h = null;
    }
}
