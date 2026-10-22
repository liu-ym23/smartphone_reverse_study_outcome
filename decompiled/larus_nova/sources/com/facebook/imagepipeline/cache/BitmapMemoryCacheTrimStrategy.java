package com.facebook.imagepipeline.cache;

import androidx.camera.video.AudioStats;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapMemoryCacheTrimStrategy implements CountingMemoryCache.CacheTrimStrategy {
    private static final String TAG = "BitmapMemoryCacheTrimStrategy";

    /* JADX INFO: renamed from: com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$common$memory$MemoryTrimType = null;

        static {
            int[] r100 = new int[MemoryTrimType.values().length];
            $SwitchMap$com$facebook$common$memory$MemoryTrimType = r100;
            r100[MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemMemoryCriticallyLowWhileAppInForeground.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public BitmapMemoryCacheTrimStrategy() {
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache.CacheTrimStrategy
    public double getTrimRatio(MemoryTrimType r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$facebook$common$memory$MemoryTrimType[r100.ordinal()];
        if (r101 == 1) goto L17;
        if (r101 != 2) goto L7;
        return 1.0d;
    L7:
        if (r101 != 3) goto L9;
        return 1.0d;
    L9:
        if (r101 != 4) goto L11;
        return 1.0d;
    L11:
        if (r101 == 5) goto L20;
        FLog.wtf(TAG, "unknown trim type: %s", new Object[]{r100});
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L20:
        return 1.0d;
    L17:
        return MemoryTrimType.OnCloseToDalvikHeapLimit.getSuggestedTrimRatio();
    }
}
