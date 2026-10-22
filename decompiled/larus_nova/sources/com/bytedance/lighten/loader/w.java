package com.bytedance.lighten.loader;

import android.util.SparseIntArray;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import com.facebook.imagepipeline.memory.DefaultBitmapPoolParams;
import com.facebook.imagepipeline.memory.DefaultByteArrayPoolParams;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.imagepipeline.memory.DefaultNativeMemoryChunkPoolParams;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolParams;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes20.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f254783a = 0;

    static {
    }

    public static SparseIntArray c(com.bytedance.lighten.core.config.b r100) {
        List<Integer> r101 = r100.f254681l;
        List<Integer> r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return null;
    L12:
        if (r101.size() == 1) goto L14;
    L16:
        SparseIntArray r104 = new SparseIntArray(r101.size() / 2);
        IntProgression r105 = RangesKt.step(CollectionsKt.getIndices(r101), 2);
        int r106 = r105.getFirst();
        int r107 = r105.getLast();
        int r108 = r105.getStep();
        if (r108 < 0) goto L20;
        if (r106 <= r107) goto L21;
    L25:
        return r104;
    L21:
        r104.put(((Number) ListProtector.get(r101, r106)).intValue(), ((Number) ListProtector.get(r101, r106 + 1)).intValue());
        if (r106 == r107) goto L25;
        r106 = r106 + r108;
        goto L21
    L20:
        if (r106 < r107) goto L25;
    L14:
        if (((Number) ListProtector.get(r101, 0)).intValue() != 0) goto L16;
        return new SparseIntArray(0);
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    public static PoolConfig.Builder d(com.bytedance.lighten.core.config.b r110) {
        int r100 = r110.f254671b;     // Catch: Throwable -> L83
        PoolConfig.Builder r101 = PoolConfig.newBuilder();     // Catch: Throwable -> L83
        if (r100 != 0) goto L7;
        String r102 = "legacy";
    L15:
        if (r102 == null) goto L17;
        r101.setBitmapPoolType(r102);     // Catch: Throwable -> L83
    L17:
        PoolParams r103 = DefaultBitmapPoolParams.get();     // Catch: Throwable -> L83
        boolean r104 = Intrinsics.areEqual(r102, "legacy");     // Catch: Throwable -> L83
        double r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r104 == false) goto L20;
    L21:
        long r112 = Integer.MAX_VALUE;
        int r105 = (int) Math.min(Runtime.getRuntime().maxMemory(), r112);     // Catch: Throwable -> L83
        if (r105 <= 16777216) goto L24;
        int r106 = (r105 / 4) * 3;     // Catch: Throwable -> L83
    L25:
        double r107 = r110.f254672c;     // Catch: Throwable -> L83
        if (r107 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L29;
        int r108 = 0;
    L32:
        double r109 = r110.f254673d;     // Catch: Throwable -> L83
        if (r109 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
    L39:
        if (r108 <= 0) goto L42;
        if (r106 >= r108) goto L42;
        long r113 = r108;
        r106 = (int) RangesKt.coerceAtMost(RangesKt.coerceAtLeast((4 * r113) / 3, r113), r112);     // Catch: Throwable -> L83
    L42:
        r101.setBitmapPoolParams(new PoolParams(r108, r106, c(r110)));     // Catch: Throwable -> L83
    L43:
        int r114 = a(r110.f254672c, r103.maxSizeHardCap);     // Catch: Throwable -> L83
        int r115 = a(r110.f254673d, 4194304);     // Catch: Throwable -> L83
        if (Intrinsics.areEqual(r102, BitmapPoolType.EXPERIMENTAL) == false) goto L49;
        if (r114 <= 0) goto L47;
        r101.setBitmapPoolMaxPoolSize(r114);     // Catch: Throwable -> L83
    L47:
        if (r115 <= 0) goto L49;
        r101.setBitmapPoolMaxBitmapSize(r115);     // Catch: Throwable -> L83
    L49:
        PoolParams r116 = DefaultNativeMemoryChunkPoolParams.get();     // Catch: Throwable -> L83
        int r117 = r116.maxSizeSoftCap;     // Catch: Throwable -> L83
        int r118 = r116.maxSizeHardCap;     // Catch: Throwable -> L83
        double r119 = r110.f254674e;     // Catch: Throwable -> L83
        if (r119 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L53;
        r119 = r119 * ((double) 1048576);     // Catch: Throwable -> L83
    L56:
        int r120 = a(r119, r117);     // Catch: Throwable -> L83
        double r121 = r110.f254675f;     // Catch: Throwable -> L83
        if (r121 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L60;
        r111 = r121 * ((double) 1048576);     // Catch: Throwable -> L83
    L62:
        int r122 = a(r111, r118);     // Catch: Throwable -> L83
        if (r120 <= 0) goto L67;
        if (r122 <= 0) goto L67;
        if (r122 < r120) goto L67;
        r101.setNativeMemoryChunkPoolParams(new PoolParams(r120, r122, r116.bucketSizes));     // Catch: Throwable -> L83
    L67:
        PoolParams r123 = DefaultFlexByteArrayPoolParams.get();     // Catch: Throwable -> L83
        int r124 = r123.minBucketSize;     // Catch: Throwable -> L83
        int r125 = r123.maxBucketSize;     // Catch: Throwable -> L83
        int r126 = r110.f254678i;     // Catch: Throwable -> L83
        if (r126 > 0) goto L71;
        r126 = DefaultFlexByteArrayPoolParams.DEFAULT_MAX_NUM_THREADS;     // Catch: Throwable -> L83
    L71:
        int r127 = r126;
        int r128 = b(r110.f254676g, r124);     // Catch: Throwable -> L83
        int r129 = b(r110.f254677h, r125);     // Catch: Throwable -> L83
        if (r128 <= 0) goto L76;
        if (r129 <= 0) goto L76;
        if (r129 < r128) goto L76;
        r101.setFlexByteArrayPoolParams(new PoolParams(r129, r127 * r129, DefaultFlexByteArrayPoolParams.generateBuckets(r128, r129, r127), r128, r129, r127));     // Catch: Throwable -> L83
    L76:
        PoolParams r130 = DefaultByteArrayPoolParams.get();     // Catch: Throwable -> L83
        int r131 = r130.maxSizeSoftCap;     // Catch: Throwable -> L83
        int r132 = r130.maxSizeHardCap;     // Catch: Throwable -> L83
        int r133 = b(r110.f254679j, r131);     // Catch: Throwable -> L83
        int r134 = b(r110.f254680k, r132);     // Catch: Throwable -> L83
        if (r133 <= 0) goto L82;
        if (r134 <= 0) goto L82;
        if (r134 < r133) goto L82;
        r101.setSmallByteArrayPoolParams(new PoolParams(r133, r134, r130.bucketSizes));     // Catch: Throwable -> L83
    L82:
        return r101;
    L60:
        if (r121 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L62;
        r111 = r121;
        goto L62
    L53:
        if (r119 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L56;
        r119 = 0.0d;
        goto L56
    L36:
        if (r109 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L38;
        r106 = e(r109);     // Catch: Throwable -> L83
        goto L39
    L38:
        r106 = e(r106 * Math.abs(r109));     // Catch: Throwable -> L83
        goto L39
    L29:
        if (r107 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L31;
        r108 = e(r107);     // Catch: Throwable -> L83
        goto L32
    L31:
        r108 = e(r106 * Math.abs(r107));     // Catch: Throwable -> L83
        goto L32
    L24:
        r106 = r105 / 2;     // Catch: Throwable -> L83
        goto L25
    L20:
        if (Intrinsics.areEqual(r102, BitmapPoolType.LEGACY_DEFAULT_PARAMS) == false) goto L43;
    L7:
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L12;
        if (r100 == 3) goto L11;
        r102 = null;
        goto L15
    L11:
        r102 = BitmapPoolType.LEGACY_DEFAULT_PARAMS;
        goto L15
    L12:
        r102 = BitmapPoolType.DUMMY;
        goto L15
    L13:
        r102 = BitmapPoolType.EXPERIMENTAL;
    L86:
        return null;
    }

    public static int e(double r100) {
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return 0;
    L7:
        return (int) Math.min(r100, Integer.MAX_VALUE);
    }

    public static int a(double r100, int r101) {
        if (r100 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return r101;
    L6:
        if (r100 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        r100 = Math.abs(r100) * ((double) r101);
    L10:
        return (int) Math.min(r100, Integer.MAX_VALUE);
    }

    public static int b(double r100, int r101) {
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r100 = r100 * ((double) 1024);
    L10:
        return a(r100, r101);
    L6:
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L10;
        r100 = 0.0d;
        goto L10
    }
}
