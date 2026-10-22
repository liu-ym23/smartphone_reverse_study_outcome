package com.ss.lark.android.avatar.service;

import com.ss.android.lark.pb.users.PullUserUpdateFieldPermissionResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes40.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f456656a = null;

    static {
        f456656a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return PullUserUpdateFieldPermissionResponse.ADAPTER.decode(r100);
    }
}
