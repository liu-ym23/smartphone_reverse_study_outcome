package com.bytedance.bmf_mods_api;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public interface SharpPotentialAPI {

    /* JADX INFO: renamed from: com.bytedance.bmf_mods_api.SharpPotentialAPI$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$DownloadModel(SharpPotentialAPI r100, Context r101, Map r102) {
        }

        public static void $default$Free(SharpPotentialAPI r100) {
        }

        public static int $default$Init(SharpPotentialAPI r100, int r101, int r102, String r103) {
            return -1;
        }

        public static int $default$Init(SharpPotentialAPI r100, int r101, int r102, String r103, int r104) {
            return -1;
        }

        public static int $default$ProcessAsync(SharpPotentialAPI r100, int r101, int r102, int r103, long r104) {
            return -1;
        }

        public static int $default$ProcessOesAsync(SharpPotentialAPI r100, int r101, int r102, int r103, float[] r104, long r105) {
            return -1;
        }

        public static float $default$ProcessOesTexture(SharpPotentialAPI r100, int r101, int r102, int r103, float[] r104) {
            return -1.0f;
        }

        public static float $default$ProcessTexture(SharpPotentialAPI r100, int r101, int r102, int r103) {
            return -1.0f;
        }

        public static void $default$SetDownloadCallback(SharpPotentialAPI r100, SharpPotentialDownloadCallback r101) {
        }

        public static void $default$SetProcessCallback(SharpPotentialAPI r100, SharpPotentialProcessCallback r101) {
        }
    }

    void DownloadModel(Context r100, Map<String, String> r101);

    void Free();

    int Init(int r100, int r101, String r102);

    int Init(int r100, int r101, String r102, int r103);

    int ProcessAsync(int r100, int r101, int r102, long r103);

    int ProcessOesAsync(int r100, int r101, int r102, float[] r103, long r104);

    float ProcessOesTexture(int r100, int r101, int r102, float[] r103);

    float ProcessTexture(int r100, int r101, int r102);

    void SetDownloadCallback(SharpPotentialDownloadCallback r100);

    void SetProcessCallback(SharpPotentialProcessCallback r100);
}
