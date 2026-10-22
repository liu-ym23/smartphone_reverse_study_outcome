package com.ss.lark.android.avatar.service;

import com.ss.android.lark.pb.chatters.PullUserLastAvatarResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes40.dex */
public final class b<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f456657a = null;

    static {
        f456657a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return PullUserLastAvatarResponse.ADAPTER.decode(r100);
    }
}
