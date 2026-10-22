package com.bytedance.ee.bear.doc.follow.impl;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebRNFollowImpl extends BaseFollowImpl implements NonProguard {
    private static final String TAG = "WebRNFollowImpl";
    private vv4.k web;

    public class a implements tb5.i<String> {
        public final /* synthetic */ WebRNFollowImpl a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(WebRNFollowImpl r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            WebRNFollowImpl r3 = this.a;
            r3.parseVCFollowCallback((String) r1);
        }
    }

    public /* bridge */ /* synthetic */ void registerPerfMonitor(py4.d.b r1) {
    }

    public /* bridge */ /* synthetic */ void unregisterPerfMonitor(py4.d.b r1) {
    }

    private void bindJSHandler() {
        this.web.h("biz.vcfollow.sendToNative", new a(this));
    }

    @Override // com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl, py4.d
    public void setAudioMute(boolean r4) {
        super.setAudioMute(r4);
        tt5.a.h(TAG, "setAudioMute: " + r4);
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L5
        r0.put("isMuted", r4);     // Catch: Exception -> L5
        invoke("setAudioMuted", r0.toString(), null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e(TAG, "setAudioMute", e, false);
    }

    public WebRNFollowImpl(Fragment r2, vv4.k r3, String r4, int r5) {
        super(r2, r4, r5, new w(r3));
        this.web = r3;
        bindJSHandler();
    }
}
