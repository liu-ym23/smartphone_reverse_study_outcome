package com.lynx.textra;

/* JADX INFO: loaded from: classes32.dex */
class VivoFontCaps implements PlatformFontCaps {
    public VivoFontCaps() {
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r100) {
        return PlatformFontCaps.CC.$default$clamp(this, r100);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r100) {
        int r101 = TTTextUtils.nativeGetSystemPropInt("persist.system.vivo.fontsize");
        if (r101 > 0) goto L6;
        r101 = 550;
    L6:
        return clamp((int) ((r101 / 550.0f) * r100));
    }
}
