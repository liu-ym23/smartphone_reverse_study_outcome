package com.ss.android.lark.message.lynxcard.action;

import com.bytedance.lark.pb.openplatform.v1.UpdateMessageCardLocalDataResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.lynxcard.plugin.MsgCardUpdateLocalDataResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class b<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f432121a = null;

    static {
        f432121a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 == null) goto L4;
        UpdateMessageCardLocalDataResponse r101 = UpdateMessageCardLocalDataResponse.ADAPTER.decode(r100);
        MsgCardUpdateLocalDataResponse r102 = new MsgCardUpdateLocalDataResponse();
        r102.setCardVersion(r101.version);
        r102.setData(r101.json_data);
        return r102;
    L4:
        Log.w("LynxCardActionClient", "updateLocalData data is null");
        return new MsgCardUpdateLocalDataResponse();
    }
}
