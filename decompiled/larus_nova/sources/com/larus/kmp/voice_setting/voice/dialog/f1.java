package com.larus.kmp.voice_setting.voice.dialog;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f1 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f352788a = null;

        static {
            int[] r100 = new int[UgcVoiceOptimizeCloneStatus.values().length];
            r100[UgcVoiceOptimizeCloneStatus.IN_PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[UgcVoiceOptimizeCloneStatus.AVAILABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[UgcVoiceOptimizeCloneStatus.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f352788a = r100;
        }
    }

    public static final UgcVoiceInfoOptimizeBannerMode a(UgcVoiceOptimizeCloneStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f352788a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return UgcVoiceInfoOptimizeBannerMode.ERROR;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return UgcVoiceInfoOptimizeBannerMode.PLAY;
    L13:
        return UgcVoiceInfoOptimizeBannerMode.PROGRESS;
    }
}
