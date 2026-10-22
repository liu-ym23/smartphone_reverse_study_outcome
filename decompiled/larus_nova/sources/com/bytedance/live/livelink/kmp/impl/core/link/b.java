package com.bytedance.live.livelink.kmp.impl.core.link;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final void a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_IS_CERT);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r101 = ILiveWrappedLivePusher.a.b();
        if (r101 == null) goto L6;
        r101.getPrivacyCertManager();
        return;
    }
}
