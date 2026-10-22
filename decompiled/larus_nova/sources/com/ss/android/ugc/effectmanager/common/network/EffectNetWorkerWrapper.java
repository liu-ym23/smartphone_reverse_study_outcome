package com.ss.android.ugc.effectmanager.common.network;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;
import com.ss.android.ugc.effectmanager.common.exception.StatusCodeException;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.android.ugc.effectmanager.common.logger.EPLog;
import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.common.utils.CloseUtil;
import com.ss.ugc.effectplatform.util.l;
import java.io.InputStream;
import org.json.JSONException;

/* JADX INFO: loaded from: classes40.dex */
public class EffectNetWorkerWrapper {
    private static final String TAG = "EffectNetWorker";
    private Context mContext;
    private IEffectNetWorker mIEffectNetWorker;

    public Context getContext() {
        return this.mContext;
    }

    public IEffectNetWorker getIEffectNetWorker() {
        return this.mIEffectNetWorker;
    }

    private void logRequestedUrl(EffectRequest r100) {
        EPLog.d(TAG, "request url: " + r100.getUrl().replaceAll("&?device_info=[^&]*", ""));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        EPLog.e(TAG, "error in print url", e);
    }

    public InputStream execute(EffectRequest r100) throws Exception {
        logRequestedUrl(r100);
        InputStream r101 = this.mIEffectNetWorker.execute(r100);
        if (r101 != null) goto L14;
        int r102 = l.f458042a;
        if (l.a(this.mContext) == false) goto L13;
        if (TextUtils.isEmpty(r100.getErrorMsg()) == false) goto L11;
        throw new RuntimeException(ErrorConstants.EXCEPTION_DOWNLOAD_ERROR);
    L11:
        throw new RuntimeException(r100.getErrorMsg());
    L13:
        throw new RuntimeException("network unavailable");
    L14:
        return r101;
    }

    public void setIEffectNetWorker(IEffectNetWorker r100) {
        this.mIEffectNetWorker = r100;
    }

    public EffectNetWorkerWrapper(IEffectNetWorker r100, Context r101) {
        this.mIEffectNetWorker = r100;
        this.mContext = r101;
    }

    public <T extends BaseNetResponse> T execute(EffectRequest r100, IJsonConverter r101, Class<T> r102) throws Exception {
        logRequestedUrl(r100);
        InputStream r103 = this.mIEffectNetWorker.execute(r100);
        if (r103 != null) goto L14;
        int r104 = l.f458042a;
        if (l.a(this.mContext) == false) goto L13;
        if (TextUtils.isEmpty(r100.getErrorMsg()) == false) goto L11;
        throw new NetworkErrorException(ErrorConstants.EXCEPTION_DOWNLOAD_ERROR);
    L11:
        throw new NetworkErrorException(r100.getErrorMsg());
    L13:
        throw new Exception("network unavailable");
    L14:
        T r105 = (T) r101.convertJsonToObj(r103, r102);
        CloseUtil.close(r103);
        if (r105 == null) goto L22;
        int r106 = r105.getStatus_code();
        if (r106 != 0) goto L20;
        return r105;
    L20:
        throw new StatusCodeException(r106, r105.getMessage());
    L22:
        throw new JSONException(ErrorConstants.EXCEPTION_JSON_CONVERT);
    }

    public <T extends BaseNetResponse> T parse(EffectRequest r100, InputStream r101, IJsonConverter r102, Class<T> r103) throws Exception {
        T r104 = (T) r102.convertJsonToObj(r101, r103);
        if (r104 == null) goto L10;
        int r105 = r104.getStatus_code();
        if (r105 != 0) goto L8;
        return r104;
    L8:
        throw new StatusCodeException(r105, r104.getMessage());
    L10:
        throw new JSONException(ErrorConstants.EXCEPTION_JSON_CONVERT);
    }
}
