package com.ss.lark.android.avatar.plugin;

import androidx.core.util.Pair;
import com.bytedance.lark.pb.contact.v1.GetDefaultAvatarResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f456647a = null;

    static {
        f456647a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        GetDefaultAvatarResponse r101 = GetDefaultAvatarResponse.ADAPTER.decode(r100);
        String r102 = r101.default_avatar_key;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r104 = r101.reset_token;
        if (r104 == null) goto L10;
        r103 = r104;
    L10:
        return new Pair(r102, r103);
    }
}
