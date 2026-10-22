package com.lynx.tasm.behavior.ui.scroll;

import androidx.camera.video.AudioStats;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.i;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f382933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f382934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f382935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f382936d;

    public interface a {
    }

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.ui.scroll.b$b, reason: collision with other inner class name */
    public static final class C4567b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f382937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f382939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f382940d;

        public C4567b(c r100, int r101, int r102, int r103) {
            this.f382937a = r100;
            this.f382938b = r101;
            this.f382939c = r102;
            this.f382940d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f382941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f382943c;

        public c(int r100, int r101, int r102) {
            this.f382941a = r100;
            this.f382942b = r101;
            this.f382943c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f382944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382945b;

        public d(int r100, int r101) {
            this.f382944a = r100;
            this.f382945b = r101;
        }
    }

    public b(ReadableMap r110, com.lynx.tasm.behavior.ui.scroll.d r111) {
        double r100 = r110.getDouble("factor");
        int r101 = r110.getInt("offset", 0);
        int r102 = 1;
        int r112 = r110.getInt("maxSnapCount", 1);
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L6:
        r100 = 0.0d;
    L7:
        if (r112 < 1) goto L10;
        r102 = r112;
    L10:
        this.f382933a = r100;
        this.f382934b = (int) i.b(r101, 0.0f);
        this.f382935c = r102;
        this.f382936d = r111;
        return;
    L5:
        if (r100 <= 1.0d) goto L7;
        goto L6
    }
}
