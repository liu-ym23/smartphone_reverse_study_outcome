package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public final class ConnectService {

    public class a extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        @Override // com.huawei.hms.support.api.PendingResultImpl
        public boolean checkApiClient(ApiClient r100) {
            if (r100 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public ResolveResult<ConnectResp> a(ConnectResp r100) {
            ResolveResult<ConnectResp> r101 = new ResolveResult(r100);
            r101.setStatus(Status.SUCCESS);
            HMSLog.d("connectservice", "connect - onComplete: success");
            return r101;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* bridge */ /* synthetic */ Result onComplete(IMessageEntity r100) {
            return a((ConnectResp) r100);
        }

        public a(ApiClient r100, String r101, IMessageEntity r102) {
            super(r100, r101, r102);
        }
    }

    public class b extends PendingResultImpl<ResolveResult<ConnectResp>, ConnectResp> {
        @Override // com.huawei.hms.support.api.PendingResultImpl
        public boolean checkApiClient(ApiClient r100) {
            if (r100 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public ResolveResult<ConnectResp> a(ConnectResp r100) {
            ResolveResult<ConnectResp> r101 = new ResolveResult(r100);
            r101.setStatus(Status.SUCCESS);
            HMSLog.d("connectservice", "forceConnect - onComplete: success");
            return r101;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* bridge */ /* synthetic */ Result onComplete(IMessageEntity r100) {
            return a((ConnectResp) r100);
        }

        public b(ApiClient r100, String r101, IMessageEntity r102) {
            super(r100, r101, r102);
        }
    }

    public class c extends PendingResultImpl<ResolveResult<JosGetNoticeResp>, JosGetNoticeResp> {
        public ResolveResult<JosGetNoticeResp> a(JosGetNoticeResp r100) {
            if (r100 != null) goto L6;
            HMSLog.e("connectservice", "JosNoticeResp is null");
            return null;
        L6:
            HMSLog.i("connectservice", "josNoticeResp status code :" + r100.getStatusCode());
            ResolveResult<JosGetNoticeResp> r101 = new ResolveResult(r100);
            r101.setStatus(Status.SUCCESS);
            return r101;
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        public /* bridge */ /* synthetic */ Result onComplete(IMessageEntity r100) {
            return a((JosGetNoticeResp) r100);
        }

        public c(ApiClient r100, String r101, IMessageEntity r102) {
            super(r100, r101, r102);
        }
    }

    private ConnectService() {
    }

    public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient r100, CheckConnectInfo r101) {
        return ResolvePendingResult.build(r100, CoreNaming.CHECKCONNECT, r101, CheckConnectResp.class);
    }

    public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient r100, ConnectInfo r101) {
        return new a(r100, CoreNaming.CONNECT, r101);
    }

    public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient r100, DisconnectInfo r101) {
        return ResolvePendingResult.build(r100, CoreNaming.DISCONNECT, r101, DisconnectResp.class);
    }

    public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient r100, ConnectInfo r101) {
        return new b(r100, CoreNaming.FORECONNECT, r101);
    }

    public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient r100, int r101, String r102) {
        JosGetNoticeReq r103 = new JosGetNoticeReq();
        r103.setNoticeType(r101);
        r103.setHmsSdkVersionName(r102);
        if (r100 == null) goto L8;
        if (TextUtils.isEmpty(r100.getCpID()) == true) goto L8;
        r103.setCpID(r100.getCpID());
    L8:
        return new c(r100, CoreNaming.GETNOTICE, r103);
    }
}
