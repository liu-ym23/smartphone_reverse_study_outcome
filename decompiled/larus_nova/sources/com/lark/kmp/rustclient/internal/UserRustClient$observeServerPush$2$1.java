package com.lark.kmp.rustclient.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class UserRustClient$observeServerPush$2$1 extends Lambda implements Function0<byte[]> {
    final /* synthetic */ rpc.c.a $serverPush;

    public UserRustClient$observeServerPush$2$1(rpc.c.a r100) {
        this.$serverPush = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final byte[] invoke2() {
        ByteString r100 = this.$serverPush.f538910b.getPayload();
        if (r100 != null) goto L6;
        r100 = ByteString.EMPTY;
    L6:
        return r100.toByteArray();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ byte[] invoke() {
        return invoke2();
    }
}
