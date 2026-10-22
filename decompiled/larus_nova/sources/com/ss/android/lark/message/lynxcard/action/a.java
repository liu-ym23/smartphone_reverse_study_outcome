package com.ss.android.lark.message.lynxcard.action;

import com.bytedance.lark.pb.im.v2.PutActionResponse;
import com.ss.android.lark.sdk.SdkSender;
import dz7.c;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f432120a = null;

    static {
        f432120a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r110) {
        if (r110 == null) goto L12;
        PutActionResponse r111 = PutActionResponse.ADAPTER.decode(r110);
        c.b r100 = new c.b();
        PutActionResponse.Toast r101 = r111.toast;
        if (r101 == null) goto L6;
        r100.f470614a = r101.code.intValue();
        r100.f470615b = r101.error_code;
        r100.f470616c = r101.content;
    L6:
        String r102 = r111.app_cli_id;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        String r103 = r102;
        return new mrb.b(r111.method.getValue(), r100, r103, r111.timestamp_detail, r111.time_cost);
    L12:
        return new mrb.b(0, null, "", new HashMap(), new HashMap());
    }
}
