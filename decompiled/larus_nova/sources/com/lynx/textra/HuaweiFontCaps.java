package com.lynx.textra;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes32.dex */
class HuaweiFontCaps implements PlatformFontCaps {
    private final Context mContext;

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r100) {
        return PlatformFontCaps.CC.$default$clamp(this, r100);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    public HuaweiFontCaps(Context r100) {
        this.mContext = r100;
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r100) {
        return clamp((int) (Settings.System.getFloat(this.mContext.getContentResolver(), "font_weight_scale", 1.0f) * r100));
    }
}
