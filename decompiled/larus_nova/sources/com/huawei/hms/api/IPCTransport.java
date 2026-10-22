package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class IPCTransport implements DatagramTransport {
    private static final String TAG = "IPCTransport";
    private int apiLevel;
    private final IMessageEntity mEntity;
    private final Class<? extends IMessageEntity> mResponseClass;
    private final String mURI;

    private int syncCall(ApiClient r100, IAIDLCallback r110) {
        if ((r100 instanceof InnerApiClient) == false) goto L15;
        DataBuffer r101 = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
        MessageCodec r102 = CodecLookup.find(r101.getProtocol());
        r101.addBody(r102.encode(this.mEntity, new Bundle()));
        RequestHeader r103 = new RequestHeader();
        r103.setAppID(r100.getAppID());
        r103.setPackageName(r100.getPackageName());
        r103.setSdkVersion(61300301);
        r103.setApiNameList(((AidlApiClient) r100).getApiNameList());
        r103.setSessionId(r100.getSessionId());
        r103.setApiLevel(this.apiLevel);
        r101.header = r102.encode(r103, new Bundle());
        AidlApiClient r104 = (AidlApiClient) r100;     // Catch: Exception -> L11
        if (r104.getService() != null) goto L9;
        HMSLog.e(TAG, "HuaweiApiClient is not binded to service yet.");     // Catch: Exception -> L11
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    L9:
        r104.getService().asyncCall(r101, r110);     // Catch: Exception -> L11
        return 0;
    L11:
        e = move-exception;
        HMSLog.e(TAG, "sync call ex:" + e);
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    L15:
        if ((r100 instanceof AidlApiClient) == false) goto L21;
        AidlApiClient r105 = (AidlApiClient) r100;
        DataBuffer r106 = new DataBuffer(this.mURI, ProtocolNegotiate.getInstance().getVersion());
        r106.addBody(CodecLookup.find(r106.getProtocol()).encode(this.mEntity, new Bundle()));
        r105.getService().asyncCall(r106, r110);     // Catch: Exception -> L19
        return 0;
    L19:
        e = move-exception;
        HMSLog.e(TAG, "sync call ex:" + e);
    L21:
        return CommonCode.ErrorCode.INTERNAL_ERROR;
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void post(ApiClient r100, DatagramTransport.a r101) {
        send(r100, r101);
    }

    @Override // com.huawei.hms.support.api.transport.DatagramTransport
    public final void send(ApiClient r100, DatagramTransport.a r101) {
        int r102 = syncCall(r100, new IPCCallback(this.mResponseClass, r101));
        if (r102 == 0) goto L7;
        if (r101 == null) goto L8;
        r101.a(r102, null);
        return;
    L8:
        return;
    }

    public IPCTransport(String r100, IMessageEntity r101, Class<? extends IMessageEntity> r102) {
        this.mURI = r100;
        this.mEntity = r101;
        this.mResponseClass = r102;
    }

    public IPCTransport(String r100, IMessageEntity r101, Class<? extends IMessageEntity> r102, int r103) {
        this.mURI = r100;
        this.mEntity = r101;
        this.mResponseClass = r102;
        this.apiLevel = r103;
    }
}
