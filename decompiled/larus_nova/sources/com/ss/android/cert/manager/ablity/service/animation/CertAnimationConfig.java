package com.ss.android.cert.manager.ablity.service.animation;

import android.graphics.Rect;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public class CertAnimationConfig {
    public static final CertAnimationConfig EMPTY = null;
    private final CertAnimationErrorListener errorListener;
    private final Object fallbackRes;
    private final CertAnimationListener lifecycleListener;
    private final Object res;
    private final ResMode resMode;
    private final boolean sync;
    private Rect targetBounds;

    /* JADX INFO: renamed from: com.ss.android.cert.manager.ablity.service.animation.CertAnimationConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private CertAnimationErrorListener errorListener;
        private Object fallbackRes;
        private CertAnimationListener lifecycleListener;
        private final Object res;
        private final ResMode resMode;
        private boolean sync;
        private Rect targetBounds;

        public CertAnimationConfig build() {
            return new CertAnimationConfig(this, null);
        }

        public static /* synthetic */ ResMode access$000(Builder r100) {
            return r100.resMode;
        }

        public static /* synthetic */ Object access$100(Builder r100) {
            return r100.res;
        }

        public static /* synthetic */ Object access$200(Builder r100) {
            return r100.fallbackRes;
        }

        public static /* synthetic */ boolean access$300(Builder r100) {
            return r100.sync;
        }

        public static /* synthetic */ CertAnimationListener access$400(Builder r100) {
            return r100.lifecycleListener;
        }

        public static /* synthetic */ CertAnimationErrorListener access$500(Builder r100) {
            return r100.errorListener;
        }

        public static /* synthetic */ Rect access$600(Builder r100) {
            return r100.targetBounds;
        }

        public Builder errorListener(CertAnimationErrorListener r100) {
            if (r100 != null) goto L4;
            r100 = CertAnimationErrorListener.EMPTY;
        L4:
            this.errorListener = r100;
            return this;
        }

        public Builder fallbackRes(Object r100) {
            this.fallbackRes = r100;
            return this;
        }

        public Builder lifecycleListener(CertAnimationListener r100) {
            if (r100 != null) goto L4;
            r100 = CertAnimationListener.EMPTY;
        L4:
            this.lifecycleListener = r100;
            return this;
        }

        public Builder sync(boolean r100) {
            this.sync = r100;
            return this;
        }

        public Builder targetBounds(Rect r100) {
            this.targetBounds = r100;
            return this;
        }

        public Builder(ResMode r100, Object r101) {
            this.lifecycleListener = CertAnimationListener.EMPTY;
            this.errorListener = CertAnimationErrorListener.EMPTY;
            if (r100 != null) goto L5;
            r100 = ResMode.EMPTY;
        L5:
            this.resMode = r100;
            if (r101 != null) goto L8;
            r101 = new Object();
        L8:
            this.res = r101;
        }
    }

    public static final enum ResMode extends Enum<ResMode> {
        private static final /* synthetic */ ResMode[] $VALUES = null;
        public static final ResMode ASSET = null;
        public static final ResMode EMPTY = null;
        public static final ResMode JSON_STREAM = null;
        public static final ResMode JSON_STRING = null;
        public static final ResMode RAW_RES = null;
        public static final ResMode URL = null;
        public static final ResMode ZIP_STREAM = null;

        static {
            ResMode r100 = new ResMode("URL", 0);
            URL = r100;
            ResMode r101 = new ResMode("ASSET", 1);
            ASSET = r101;
            ResMode r102 = new ResMode("RAW_RES", 2);
            RAW_RES = r102;
            ResMode r103 = new ResMode("JSON_STREAM", 3);
            JSON_STREAM = r103;
            ResMode r104 = new ResMode("JSON_STRING", 4);
            JSON_STRING = r104;
            ResMode r105 = new ResMode("ZIP_STREAM", 5);
            ZIP_STREAM = r105;
            ResMode r110 = new ResMode("EMPTY", 6);
            EMPTY = r110;
            $VALUES = new ResMode[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static ResMode[] values() {
            return (ResMode[]) $VALUES.clone();
        }

        public static ResMode valueOf(String r100) {
            return (ResMode) a.a(ResMode.class, r100);
        }

        private ResMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        EMPTY = new Builder(ResMode.EMPTY, new Object()).build();
    }

    public CertAnimationErrorListener getErrorListener() {
        return this.errorListener;
    }

    public Object getFallbackRes() {
        return this.fallbackRes;
    }

    public CertAnimationListener getLifecycleListener() {
        return this.lifecycleListener;
    }

    public Object getRes() {
        return this.res;
    }

    public ResMode getResMode() {
        return this.resMode;
    }

    public Rect getTargetBounds() {
        return this.targetBounds;
    }

    public boolean isSync() {
        return this.sync;
    }

    private CertAnimationConfig(Builder r100) {
        this.resMode = Builder.access$000(r100);
        this.res = Builder.access$100(r100);
        this.fallbackRes = Builder.access$200(r100);
        this.sync = Builder.access$300(r100);
        this.lifecycleListener = Builder.access$400(r100);
        this.errorListener = Builder.access$500(r100);
        this.targetBounds = Builder.access$600(r100);
    }

    public void setTargetBounds(Rect r100) {
        this.targetBounds = r100;
    }

    public /* synthetic */ CertAnimationConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
