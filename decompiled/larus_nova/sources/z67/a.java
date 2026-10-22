package z67;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements b {
    public a() {
    }

    @Override // z67.b
    public final void onRequestSuccess(String r100, String r101, String r102, long r103) {
        com.bytedance.push.utils.f.i("DefaultCommonPushSdkMonitorServiceImpl", "onRequestSuccess");
    }

    @Override // z67.b
    public final void onRequestFailed(String r100, String r101, String r102, String r103, long r104) {
        com.bytedance.push.utils.f.i("DefaultCommonPushSdkMonitorServiceImpl", "onRequestFailed");
    }

    @Override // z67.b
    public final void onRequestSuccess(String r100, String r101, String r102, long r103, JSONObject r104) {
        com.bytedance.push.utils.f.i("DefaultCommonPushSdkMonitorServiceImpl", "onRequestSuccess v2");
    }

    @Override // z67.b
    public final void onRequestFailed(String r100, String r101, String r102, String r103, long r104, JSONObject r105) {
        com.bytedance.push.utils.f.i("DefaultCommonPushSdkMonitorServiceImpl", "onRequestFailed v2");
    }
}
