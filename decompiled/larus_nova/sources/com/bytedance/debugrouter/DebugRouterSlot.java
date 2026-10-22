package com.bytedance.debugrouter;

import android.view.View;
import com.lynx.debugrouter.log.LLog;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class DebugRouterSlot {
    private com.lynx.debugrouter.DebugRouterSlot mDebugRouterSlot;
    private DebugRouterSlotDelegate mExternalDebugRouterSlotDelegate;

    public void dispatchDocumentUpdated() {
        this.mDebugRouterSlot.dispatchDocumentUpdated();
    }

    public String getTemplateUrl() {
        return this.mDebugRouterSlot.getTemplateUrl();
    }

    public View getTemplateView() {
        return getDelegateTemplateView(this.mExternalDebugRouterSlotDelegate);
    }

    public String getType() {
        return this.mDebugRouterSlot.getType();
    }

    public int plug() {
        return this.mDebugRouterSlot.plug();
    }

    public void pull() {
        this.mDebugRouterSlot.pull();
    }

    public DebugRouterSlot(final DebugRouterSlotDelegate r100) {
        this.mExternalDebugRouterSlotDelegate = r100;
        this.mDebugRouterSlot = new com.lynx.debugrouter.DebugRouterSlot(new AnonymousClass1(this, r100));
    }

    private View getDelegateTemplateView(DebugRouterSlotDelegate r100) {
        if (r100 == null) goto L10;
        return (View) r100.getClass().getMethod("getTemplateView", new Class[0]).invoke(r100, new Object[0]);
    L5:
        LLog.e("DebugRouterSlot", "failed to invoke getTemplateView");
        return null;
    L10:
        return null;
    }

    public void dispatchFrameNavigated(String r100) {
        this.mDebugRouterSlot.dispatchFrameNavigated(r100);
    }

    public void dispatchScreencastVisibilityChanged(boolean r100) {
        this.mDebugRouterSlot.dispatchScreencastVisibilityChanged(r100);
    }

    public void send(String r100) {
        this.mDebugRouterSlot.send(r100);
    }

    public void sendAsync(String r100) {
        this.mDebugRouterSlot.sendAsync(r100);
    }

    public void setType(String r100) {
        this.mDebugRouterSlot.setType(r100);
    }

    public static /* synthetic */ View access$000(DebugRouterSlot r100, DebugRouterSlotDelegate r101) {
        return r100.getDelegateTemplateView(r101);
    }

    public void sendData(String r100, String r101) {
        this.mDebugRouterSlot.sendData(r100, r101);
    }

    public void sendDataAsync(String r100, String r101) {
        this.mDebugRouterSlot.sendDataAsync(r100, r101);
    }

    public void sendScreenCast(String r100, Map<String, Float> r101) {
        this.mDebugRouterSlot.sendScreenCast(r100, r101);
    }

    public void sendDataAsync(String r100, String r101, int r102) {
        this.mDebugRouterSlot.sendDataAsync(r100, r101, r102);
    }
}
