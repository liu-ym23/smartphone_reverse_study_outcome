package com.larus.im.internal.core.message;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.im.internal.protocol.bean.SendMessageUplinkBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f347908a = null;

    static {
        f347908a = new y();
    }

    public y() {
    }

    @Override // com.larus.im.internal.core.message.x
    public final SendMessageUplinkBody a(SendMessageUplinkBody r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        return r100;
    }
}
