package xn7;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements c {
    public b() {
    }

    @Override // xn7.c
    public final boolean a(Context r100, IWXAPI r101, ShareContent r102, SendMessageToWX.Req r103) {
        return r101.sendReq(r103);
    }
}
