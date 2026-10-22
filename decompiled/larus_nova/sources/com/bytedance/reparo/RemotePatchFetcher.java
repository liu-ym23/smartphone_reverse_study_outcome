package com.bytedance.reparo;

import android.app.Application;
import android.text.TextUtils;
import com.byted.cast.common.source.ISendResultListener;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.model.Response;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class RemotePatchFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IReparoConfig f267294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f267295b;

    public class ResponseNullException extends PatchException {
        final /* synthetic */ RemotePatchFetcher this$0;

        public ResponseNullException(RemotePatchFetcher r100, String r101) {
            this.this$0 = r100;
            super(r101, 0);
        }
    }

    public final List<PatchFetchInfo> a(String r100) throws IllegalAccessException {
        if (TextUtils.isEmpty(r100) == true) goto L13;
        Response r101 = (Response) GsonProtectorUtils.fromJson(new Gson(), r100, Response.class);
        if (TextUtils.equals("success", r101.message) == false) goto L11;
        List<PatchFetchInfo> r102 = r101.data.patch;
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new ArrayList();
    L11:
        throw new IllegalAccessException(String.format("an error occurred on this interface, response is %s", new Object[]{r100}));
    L13:
        throw new ResponseNullException(this, ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL);
    }

    public RemotePatchFetcher(Application r100, com.bytedance.reparo.secondary.b r101) {
        this.f267295b = r100;
        this.f267294a = r101;
    }
}
