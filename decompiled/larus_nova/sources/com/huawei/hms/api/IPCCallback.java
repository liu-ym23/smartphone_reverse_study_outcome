package com.huawei.hms.api;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class IPCCallback extends IAIDLCallback.Stub {
    private static final String TAG = "IPCCallback";
    private final DatagramTransport.a mCallback;
    private final Class<? extends IMessageEntity> mResponseClass;

    public IMessageEntity newResponseInstance() {
        Class<? extends IMessageEntity> r100 = this.mResponseClass;
        if (r100 == null) goto L14;
        return r100.newInstance();
    L8:
        e = move-exception;
        HMSLog.e(TAG, "In newResponseInstance, instancing exception." + e.getMessage());
        return null;
    L14:
        return null;
    }

    @Override // com.huawei.hms.core.aidl.IAIDLCallback
    public void call(DataBuffer r100) throws RemoteException {
        if (r100 != null) goto L4;
    L18:
        HMSLog.e(TAG, "In call, URI cannot be empty.");
        throw new RemoteException();
    L4:
        if (TextUtils.isEmpty(r100.URI) == true) goto L18;
        MessageCodec r101 = CodecLookup.find(r100.getProtocol());
        if (r100.getBodySize() <= 0) goto L10;
        IMessageEntity r102 = newResponseInstance();
        if (r102 == null) goto L11;
        r101.decode(r100.getBody(), r102);
    L11:
        DatagramTransport.a r103 = this.mCallback;
        if (r103 != null) goto L14;
        return;
    L14:
        if (r100.header == null) goto L16;
        ResponseHeader r104 = new ResponseHeader();
        r101.decode(r100.header, r104);
        this.mCallback.a(r104.getStatusCode(), r102);
        return;
    L16:
        r103.a(0, r102);
        return;
    L10:
        r102 = null;
        goto L11
    }

    public IPCCallback(Class<? extends IMessageEntity> r100, DatagramTransport.a r101) {
        this.mResponseClass = r100;
        this.mCallback = r101;
    }
}
