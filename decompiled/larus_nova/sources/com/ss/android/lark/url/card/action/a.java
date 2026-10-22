package com.ss.android.lark.url.card.action;

import com.bytedance.lark.pb.openplatform.v1.PutRenderRouterCardActionResponse;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponseInner;
import com.ss.android.lark.sdk.SdkSender;
import dz7.c;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f444610a = null;

    static {
        f444610a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r110) {
        if (r110 == null) goto L15;
        PutRenderRouterCardActionResponse r111 = PutRenderRouterCardActionResponse.ADAPTER.decode(r110);
        c.b r100 = new c.b();
        PutUniversalCardActionResponseInner.Toast r101 = r111.inner.toast;
        if (r101 == null) goto L6;
        r100.f470614a = r101.code.getValue();
        r100.f470615b = r101.error_code;
        r100.f470616c = r101.content;
    L6:
        c.a r102 = new c.a();
        PutUniversalCardActionResponseInner r112 = r111.inner;
        PutUniversalCardActionResponseInner.URL r103 = r112.url;
        if (r103 == null) goto L9;
        r102.f470613b = r103.android_url;
        r102.f470612a = r103.url;
    L9:
        String r113 = r112.app_cli_id;
        if (r113 != null) goto L16;
        r113 = "";
    L16:
        return new c(r100, r113, r102, "requestFinished", 48);
    L15:
        return new c(null, "", null, null, 56);
    }
}
