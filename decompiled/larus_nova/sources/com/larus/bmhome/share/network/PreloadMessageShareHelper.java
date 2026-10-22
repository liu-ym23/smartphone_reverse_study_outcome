package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class PreloadMessageShareHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BizResponse<SaveMessageShareInfo> f313835a;

    public static final class a {
    }

    static {
    }

    public PreloadMessageShareHelper() {
    }

    public final void a(CoroutineScope r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "request");
        this.f313835a = null;
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new PreloadMessageShareHelper$preloadShareMessage$1(r101, this, null), 2, null);
    }

    public final Object b(f r100, Continuation<? super BizResponse<SaveMessageShareInfo>> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PreloadMessageShareHelper$requestShareMessage$2(this, r100, null), r101);
    }
}
