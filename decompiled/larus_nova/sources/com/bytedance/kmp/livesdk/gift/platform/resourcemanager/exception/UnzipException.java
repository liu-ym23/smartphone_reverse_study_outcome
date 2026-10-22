package com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/UnzipException;", "Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/BaseGetResourceException;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;", "request", "<init>", "(Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;)V", "", "detailMessage", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;)V", "", LynxError.LYNX_THROWABLE, "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UnzipException extends BaseGetResourceException {
    public UnzipException(e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super(r100);
    }

    public UnzipException(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "request");
        super(r100, r101);
    }

    public UnzipException(String r100, Throwable r101, e r102) {
        Intrinsics.checkNotNullParameter(r102, "request");
        super(r100, r101, r102);
    }
}
