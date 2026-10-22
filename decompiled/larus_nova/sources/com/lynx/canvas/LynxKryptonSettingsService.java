package com.lynx.canvas;

/* JADX INFO: loaded from: classes32.dex */
public class LynxKryptonSettingsService extends KryptonSettingsService {
    private static final String TAG = "LynxKryptonSettingsService";

    public LynxKryptonSettingsService() {
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public boolean booleanValueForKey(String r100, boolean r101) {
        return LynxSettingsUtils.booleanValueForKey(r100, r101);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public double doubleValueForKey(String r100, double r101) {
        return LynxSettingsUtils.doubleValueForKey(r100, r101);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public int integerValueForKey(String r100, int r101) {
        return LynxSettingsUtils.integerValueForKey(r100, r101);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public Object objectValueForKey(String r100, Object r101) {
        return LynxSettingsUtils.objectValueForKey(r100, r101);
    }

    @Override // com.lynx.canvas.KryptonSettingsService
    public String stringValueForKey(String r100, String r101) {
        return LynxSettingsUtils.stringValueForKey(r100, r101);
    }
}
