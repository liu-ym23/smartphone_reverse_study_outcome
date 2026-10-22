package com.larus.disk.impl;

import androidx.camera.video.AudioStats;
import com.bytedance.keva.KevaImpl;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f330643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f330644b = null;

    public static final long a(long r100, long r101) {
        if ((Long.MAX_VALUE - r100) >= r101) goto L6;
        return Long.MAX_VALUE;
    L6:
        return r100 + r101;
    }

    static {
        f330643a = SetsKt.setOf(new String[]{"app_assets", "app_gift_resource", "app_hws_webview", "app_lib", "app_librarian", "app_textures", "bbox_acc", "cache", "code_cache", "databases", KevaImpl.PrivateConstants.FILES_DIR_NAME, "lib", "no_backup", "oat", "share", "shared_prefs", "small_emoji_res", "srpatch"});
        f330644b = SetsKt.setOf(new String[]{"cache", KevaImpl.PrivateConstants.FILES_DIR_NAME});
    }

    public static final double b(long r100, long r110) {
        if (r110 > 0) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return RangesKt.coerceIn(r100, 0, r110) / r110;
    }
}
