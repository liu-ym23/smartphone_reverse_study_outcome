package com.bytedance.locallife.cube.experiments;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/cube/experiments/CubeFontFamily;", "", "()V", "assetFonts", "", "", "getAssetFonts", "()[Ljava/lang/String;", "[Ljava/lang/String;", "fileFonts", "getFileFonts", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeFontFamily {

    @SerializedName("assetFont")
    private final String[] assetFonts;

    @SerializedName("fileFont")
    private final String[] fileFonts;

    public CubeFontFamily() {
    }

    public final String[] getAssetFonts() {
        return this.assetFonts;
    }

    public final String[] getFileFonts() {
        return this.fileFonts;
    }
}
