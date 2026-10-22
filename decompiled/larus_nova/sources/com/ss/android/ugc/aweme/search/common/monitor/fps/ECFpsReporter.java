package com.ss.android.ugc.aweme.search.common.monitor.fps;

import androidx.camera.video.AudioStats;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECFpsReporter;", "", "Companion", "DropFrameInfo", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class ECFpsReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends Map<String, String>> f451788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Object> f451789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, Object> f451790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f451791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f451792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f451793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f451794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f451795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f451796i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECFpsReporter$Companion;", "", "()V", "BLOCK_THRESHOLD_FRAMES", "", "EVENT_UI_SAMPLE_REPORT", "", "FRAME_INTERVAL_MILLIS", "KEY_ALL_FRAME", "KEY_APP_TIME", "KEY_APP_USE_TIME", "KEY_BLOCK_DURATION", "KEY_DROP_MAX", "KEY_DROP_X_COUNT", "KEY_DURATION", "KEY_FPS", "KEY_LEVEL_1", "KEY_LEVEL_2", "KEY_LEVEL_3", "KEY_LEVEL_4", "KEY_REAL_FPS", "KEY_RENDER_FPS", "KEY_SCENE", "KEY_UI_STALL_RATE", "KEY_VIRTUAL_PROPERTY", "LEVEL_2", "LEVEL_3", "LEVEL_4", "MAX_FPS", "", "MAX_VIRTUAL_PROPERTY_COUNT", "WEIGHT_1", "WEIGHT_2", "WEIGHT_3", "WEIGHT_4", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECFpsReporter$DropFrameInfo;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DropFrameInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f451797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f451798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f451799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f451800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f451801e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f451802f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f451803g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f451804h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final double f451805i;

        public DropFrameInfo() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof DropFrameInfo) == false) goto L24;
            DropFrameInfo r101 = (DropFrameInfo) r100;
            if (this.f451797a == r101.f451797a) goto L8;
            return false;
        L8:
            if (this.f451798b == r101.f451798b) goto L10;
            return false;
        L10:
            if (Float.compare(this.f451799c, r101.f451799c) == 0) goto L12;
            return false;
        L12:
            if (this.f451800d == r101.f451800d) goto L14;
            return false;
        L14:
            if (this.f451801e == r101.f451801e) goto L16;
            return false;
        L16:
            if (this.f451802f == r101.f451802f) goto L18;
            return false;
        L18:
            if (this.f451803g == r101.f451803g) goto L20;
            return false;
        L20:
            if (this.f451804h == r101.f451804h) goto L22;
            return false;
        L22:
            if (Double.compare(this.f451805i, r101.f451805i) == 0) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            int r100 = ((((((((((((((this.f451797a * 31) + this.f451798b) * 31) + Float.floatToIntBits(this.f451799c)) * 31) + this.f451800d) * 31) + this.f451801e) * 31) + this.f451802f) * 31) + this.f451803g) * 31) + this.f451804h) * 31;
            long r101 = Double.doubleToLongBits(this.f451805i);
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DropFrameInfo(allFrame=" + this.f451797a + ", dropMax=" + this.f451798b + ", dropXCount=" + this.f451799c + ", level1=" + this.f451800d + ", level2=" + this.f451801e + ", level3=" + this.f451802f + ", level4=" + this.f451803g + ", blockDuration=" + this.f451804h + ", uiStallRate=" + this.f451805i + ")";
        }

        public /* synthetic */ DropFrameInfo(int r110) {
            this(0, 0, 0.0f, 0, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        public DropFrameInfo(int r100, int r101, float r102, int r103, int r104, int r105, int r106, int r107, double r108) {
            this.f451797a = r100;
            this.f451798b = r101;
            this.f451799c = r102;
            this.f451800d = r103;
            this.f451801e = r104;
            this.f451802f = r105;
            this.f451803g = r106;
            this.f451804h = r107;
            this.f451805i = r108;
        }
    }

    static {
        new Companion(0);
    }

    public ECFpsReporter(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f451796i = r100;
        this.f451789b = new HashMap();
        this.f451790c = new LinkedHashMap();
        this.f451791d = -1.0d;
        this.f451793f = -1;
        this.f451794g = -1;
        this.f451795h = -1;
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if ((!StringsKt.isBlank(r100)) == false) goto L9;
        HashMap<String, Object> r102 = this.f451789b;
        if (r101 != null) goto L7;
        r101 = "null";
    L7:
        r102.put(r100, r101);
        return;
    }
}
