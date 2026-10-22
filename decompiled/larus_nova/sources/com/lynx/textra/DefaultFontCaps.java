package com.lynx.textra;

/* JADX INFO: loaded from: classes32.dex */
class DefaultFontCaps implements PlatformFontCaps {
    public DefaultFontCaps() {
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public short adjust(short r100) {
        return r100;
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public final /* synthetic */ short clamp(int r100) {
        return PlatformFontCaps.CC.$default$clamp(this, r100);
    }

    @Override // com.lynx.textra.PlatformFontCaps
    public String defaultFamilyName() {
        return PlatformFontCaps.DEFAULT_FAMILY_NAME;
    }
}
