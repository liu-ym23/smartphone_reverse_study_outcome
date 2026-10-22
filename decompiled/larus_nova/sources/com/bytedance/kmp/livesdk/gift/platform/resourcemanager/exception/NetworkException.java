package com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.lynx.tasm.LynxError;
import dd6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013B+\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0015B5\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0018R$\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/NetworkException;", "Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/BaseGetResourceException;", "", "<set-?>", "errorCode", "I", "getErrorCode", "()I", "Ldd6/a;", "mDownloadRequest", "Ldd6/a;", "", "getMessage", "()Ljava/lang/String;", "message", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;", "request", "r", "<init>", "(Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;ILdd6/a;)V", "detailMessage", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;ILdd6/a;)V", "", LynxError.LYNX_THROWABLE, "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;ILdd6/a;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NetworkException extends BaseGetResourceException {
    private int errorCode;
    private a mDownloadRequest;

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        return this.mDownloadRequest.toString() + "\n" + super.getMessage();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public NetworkException(e r100, int r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r102, "r");
        super(r100);
        this.errorCode = r101;
        this.mDownloadRequest = r102;
    }

    public NetworkException(String r100, e r101, int r102, a r103) {
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r103, "r");
        super(r100, r101);
        this.errorCode = r102;
        this.mDownloadRequest = r103;
    }

    public NetworkException(String r100, Throwable r101, e r102, int r103, a r104) {
        Intrinsics.checkNotNullParameter(r102, "request");
        Intrinsics.checkNotNullParameter(r104, "r");
        super(r100, r101, r102);
        this.errorCode = r103;
        this.mDownloadRequest = r104;
    }
}
