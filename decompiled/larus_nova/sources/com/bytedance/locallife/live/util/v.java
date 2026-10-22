package com.bytedance.locallife.live.util;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.frame.FrameScheduler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class v implements FrameScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f260733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f260734b;

    public static final class a {
    }

    public static final class b implements AnimationInformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnimationInformation f260735a;

        @Override // com.facebook.fresco.animation.backend.AnimationInformation
        public final int getLoopCount() {
            return 1;
        }

        @Override // com.facebook.fresco.animation.backend.AnimationInformation
        public final int getFrameCount() {
            return this.f260735a.getFrameCount();
        }

        public b(AnimationBackend r100) {
            Intrinsics.checkNotNullParameter(r100, "mInfo");
            this.f260735a = r100;
        }

        @Override // com.facebook.fresco.animation.backend.AnimationInformation
        public final int getFrameDurationMs(int r100) {
            return this.f260735a.getFrameDurationMs(r100);
        }
    }

    static {
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final FrameScheduler forNewFrameScheduler(FrameScheduler r100) {
        Intrinsics.checkNotNullParameter(r100, "scheduler");
        return null;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final void setStartTime(long r100) {
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getLoopDurationMs() {
        long r100 = this.f260734b;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        this.f260734b = 0;
        int r101 = this.f260733a.getFrameCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L9;
        this.f260734b += (long) this.f260733a.getFrameDurationMs(r102);
        r102 = r102 + 1;
        goto L6
    L9:
        return this.f260734b;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final boolean isInfiniteAnimation() {
        this.f260733a.getClass();
        return false;
    }

    public v(AnimationBackend r100) {
        Intrinsics.checkNotNullParameter(r100, "animationInformation");
        this.f260734b = -1;
        this.f260733a = new b(r100);
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getTargetRenderTimeForNextFrameMs(long r110) {
        long r100 = this.f260734b;
        long r101 = 0;
        if (r100 == 0) goto L5;
        isInfiniteAnimation();
        long r102 = r110 / getLoopDurationMs();
        this.f260733a.getClass();
        if (r102 >= 1) goto L9;
        long r103 = r110 % r100;
        int r104 = this.f260733a.getFrameCount();
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L16;
        if (r101 > r103) goto L16;
        r101 = r101 + ((long) this.f260733a.getFrameDurationMs(r105));
        r105 = r105 + 1;
    L16:
        return r110 + (r101 - r103);
    L9:
        return -1;
    L5:
        return -1;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final long getTargetRenderTimeMs(int r100) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101 = r101 + ((long) this.f260733a.getFrameDurationMs(r100));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.facebook.fresco.animation.frame.FrameScheduler
    public final int getFrameNumberToRender(long r100, long r101) {
        isInfiniteAnimation();
        long r102 = r100 / this.f260734b;
        this.f260733a.getClass();
        if (r102 < 1) goto L5;
        return -1;
    L5:
        long r103 = r100 % this.f260734b;
        int r104 = 0;
        long r105 = 0;
    L6:
        r105 = r105 + ((long) this.f260733a.getFrameDurationMs(r104));
        r104 = r104 + 1;
        if (r103 >= r105) goto L6;
        return r104 - 1;
    }
}
