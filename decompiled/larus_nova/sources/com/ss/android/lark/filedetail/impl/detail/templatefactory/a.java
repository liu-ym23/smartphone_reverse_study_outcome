package com.ss.android.lark.filedetail.impl.detail.templatefactory;

import com.bytedance.lark.pb.im.v1.ShareAsMessageResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f421645a = null;

    static {
        f421645a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return ShareAsMessageResponse.ADAPTER.decode(r100);
    }
}
