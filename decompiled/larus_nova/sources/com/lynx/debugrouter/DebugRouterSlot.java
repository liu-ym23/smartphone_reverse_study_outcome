package com.lynx.debugrouter;

import android.view.View;
import com.lynx.debugrouter.log.LLog;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouterSlot {
    private static final String TAG = "DebugRouterSlot";
    private DebugRouterSlotDelegate mDelegate;
    private boolean mPlugged;
    private int mSessionId;
    private String mType;

    public void clearScreenCastCache() {
    }

    public String getTemplateUrl() {
        DebugRouterSlotDelegate r100 = this.mDelegate;
        if (r100 != null) goto L5;
        return "___UNKNOWN___";
    L5:
        if (r100.getTemplateUrl() != null) goto L7;
        return "___UNKNOWN___";
    L7:
        return this.mDelegate.getTemplateUrl();
    }

    public View getTemplateView() {
        DebugRouterSlotDelegate r100 = this.mDelegate;
        if (r100 == null) goto L11;
        return (View) r100.getClass().getMethod("getTemplateView", new Class[0]).invoke(this.mDelegate, new Object[0]);
    L6:
        LLog.e(TAG, "failed to invoke getTemplateView");
        return null;
    L11:
        return null;
    }

    public void pull() {
        if (this.mPlugged == false) goto L6;
        DebugRouter.getInstance().pull(this.mSessionId);
        this.mPlugged = false;
        return;
    }

    public void dispatchDocumentUpdated() {
        sendDataAsync("CDP", MessageAssembler.assembleDispatchDocumentUpdated());
    }

    public int plug() {
        pull();
        int r100 = DebugRouter.getInstance().plug(this);
        this.mSessionId = r100;
        this.mPlugged = true;
        return r100;
    }

    public String getType() {
        return this.mType;
    }

    public DebugRouterSlot(DebugRouterSlotDelegate r100) {
        this.mType = "";
        this.mDelegate = r100;
    }

    public void dispatchFrameNavigated(String r100) {
        sendDataAsync("CDP", MessageAssembler.assembleDispatchFrameNavigated(r100));
    }

    public void dispatchScreencastVisibilityChanged(boolean r100) {
        sendDataAsync("CDP", MessageAssembler.assembleDispatchScreencastVisibilityChanged(r100));
    }

    public void send(String r100) {
        DebugRouter.getInstance().send(r100);
    }

    public void sendAsync(String r100) {
        DebugRouter.getInstance().sendAsync(r100);
    }

    public void setType(String r100) {
        this.mType = r100;
    }

    public void onMessage(String r100, String r101) {
        DebugRouterSlotDelegate r102 = this.mDelegate;
        if (r102 == null) goto L6;
        r102.onMessage(r100, r101);
        return;
    }

    public void sendData(String r100, String r101) {
        DebugRouter.getInstance().sendData(r100, this.mSessionId, r101);
    }

    public void sendDataAsync(String r100, String r101) {
        DebugRouter.getInstance().sendDataAsync(r100, this.mSessionId, r101);
    }

    public void sendScreenCast(String r100, Map<String, Float> r101) {
        sendDataAsync("CDP", MessageAssembler.assembleScreenCastFrame(this.mSessionId, r100, r101));
    }

    public void sendData(String r100, String r101, int r102) {
        DebugRouter.getInstance().sendData(r100, this.mSessionId, r101, r102);
    }

    public void sendDataAsync(String r100, String r101, int r102) {
        DebugRouter.getInstance().sendDataAsync(r100, this.mSessionId, r101, r102);
    }
}
