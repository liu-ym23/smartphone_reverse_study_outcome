package com.lynx.debugrouter;

/* JADX INFO: loaded from: classes32.dex */
public class NativeSlotDelegate {
    private DebugRouterSlot slot;
    private String type;
    private String url;

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public NativeSlotDelegate(DebugRouterSlot r100) {
        this.slot = r100;
        this.url = r100.getTemplateUrl();
        this.type = r100.getType();
    }

    public void onMessage(String r100, String r101) {
        DebugRouterSlot r102 = this.slot;
        if (r102 == null) goto L6;
        r102.onMessage(r100, r101);
        return;
    }
}
