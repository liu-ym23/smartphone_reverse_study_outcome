package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class HmsClient extends BaseHmsClient implements AnyClient {

    public static class a implements BaseAdapter.BaseCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnyClient.CallBack f277102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference<HmsClient> f277103b;

        private void a(String r100) {
            HmsClient r101 = this.f277103b.get();
            if (r101 == null) goto L6;
            r101.updateSessionId(r100);
            return;
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(String r100) {
            if (this.f277102a != null) goto L5;
            return;
        L5:
            ResponseWrap r101 = new ResponseWrap(new ResponseHeader());
            if (r101.fromJson(r100) == false) goto L8;
            HMSLog.i("HmsClient", "receive msg " + r101);
            ResponseHeader r102 = r101.getResponseHeader();
            a(r102.getSessionId());
            this.f277102a.onCallback(r102, r101.getBody());
            return;
        L8:
            this.f277102a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
        }

        public a(HmsClient r100, AnyClient.CallBack r101) {
            this.f277102a = r101;
            this.f277103b = new WeakReference(r100);
        }

        private void a(String r100, String r101) {
            if (this.f277102a != null) goto L5;
            return;
        L5:
            ResponseHeader r102 = new ResponseHeader();
            if (r102.fromJson(r100) == false) goto L8;
            HMSLog.i("HmsClient", "receive msg " + r102);
            a(r102.getSessionId());
            this.f277102a.onCallback(r102, r101);
            return;
        L8:
            this.f277102a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
        }

        private void a(String r100, String r101, Parcelable r102) {
            if (this.f277102a != null) goto L5;
            return;
        L5:
            ResponseHeader r103 = new ResponseHeader();
            if (r103.fromJson(r100) == false) goto L8;
            r103.setParcelable(r102);
            HMSLog.i("HmsClient", "receive msg " + r103);
            a(r103.getSessionId());
            this.f277102a.onCallback(r103, r101);
            return;
        L8:
            this.f277102a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(String r100, String r101, Parcelable r102) {
            if (r102 != null) goto L4;
            a(r100, r101);
            return;
        L4:
            a(r100, r101, r102);
        }
    }

    public void updateSessionId(String r100) {
        if (TextUtils.isEmpty(this.sessionId) == false) goto L6;
        this.sessionId = r100;
        return;
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(IMessageEntity r100, String r101, AnyClient.CallBack r102) {
        if (r102 != null) goto L6;
        HMSLog.e("HmsClient", "callback is invalid, discard.");
        return;
    L6:
        boolean r103 = true;
        if ((r100 instanceof RequestHeader) == false) goto L28;
        if (r101 == null) goto L28;
        if (isConnected() == true) goto L17;
        HMSLog.i("HmsClient", "No connection now, the connection status:" + getConnectionStatus());
        if (getConnectionStatus() == 6) goto L16;
        HMSLog.e("HmsClient", "post failed for not connected.");
        r102.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new JSONObject().toString());
        return;
    L16:
        HMSLog.i("HmsClient", "in timeout-disconnect status, need to bind again.");
        a();
    L17:
        RequestHeader r104 = (RequestHeader) r100;
        HMSLog.i("HmsClient", "post msg " + r104);
        Activity r105 = getClientSettings().getCpActivity();
        if (r105 == null) goto L21;
        r103 = false;
    L21:
        if (r103 == false) goto L23;
        HMSLog.i("HmsClient", "Activity is null for " + getClientSettings().getAppID());
    L23:
        if (r103 == false) goto L25;
        BaseAdapter r106 = new BaseAdapter(this);
    L26:
        r106.baseRequest(r104.toJson(), r101, r104.getParcelable(), new a(this, r102));
        return;
    L25:
        r106 = new BaseAdapter(this, r105);
    L28:
        HMSLog.e("HmsClient", "arguments is invalid.");
        r102.onCallback(new ResponseHeader(1, 907135000, "Args is invalid"), new JSONObject().toString());
    }

    public HmsClient(Context r100, ClientSettings r101, BaseHmsClient.OnConnectionFailedListener r102, BaseHmsClient.ConnectionCallbacks r103) {
        super(r100, r101, r102, r103);
    }
}
