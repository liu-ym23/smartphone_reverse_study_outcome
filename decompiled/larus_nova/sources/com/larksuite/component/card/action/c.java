package com.larksuite.component.card.action;

import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponse;
import com.bytedance.lark.pb.openplatform.v1.PutUniversalCardActionResponseInner;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes24.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f283190a = null;

    static {
        f283190a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r110) {
        if (r110 == null) goto L15;
        PutUniversalCardActionResponse r111 = PutUniversalCardActionResponse.ADAPTER.decode(r110);
        dz7.c.b r100 = new dz7.c.b();
        PutUniversalCardActionResponseInner.Toast r101 = r111.inner.toast;
        if (r101 == null) goto L6;
        r100.f470614a = r101.code.getValue();
        r100.f470615b = r101.error_code;
        r100.f470616c = r101.content;
    L6:
        dz7.c.a r102 = new dz7.c.a();
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
        return new dz7.c(r100, r113, r102, "requestFinished", 48);
    L15:
        return new dz7.c(null, "", null, null, 56);
    }
}
