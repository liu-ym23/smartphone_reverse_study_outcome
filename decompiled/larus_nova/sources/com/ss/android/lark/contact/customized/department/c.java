package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f419101a = null;

    static {
        f419101a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return GetDepartmentCombineChatResponse.ADAPTER.decode(r100);
    }
}
