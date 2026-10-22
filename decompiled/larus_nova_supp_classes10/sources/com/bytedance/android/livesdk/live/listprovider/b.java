package com.bytedance.android.livesdk.live.listprovider;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ String a;

    public b(String r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Logger.d("DrawRoomListProvider", "tryUploadUnreadRoomByPull Collecting unread room result, extra: " + this.a + ", statusCode: " + ((BaseResponse) ((Response) r3)).statusCode + '.');
    }
}
