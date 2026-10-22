package com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fB#\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u000eB-\b\u0016\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/Md5InvalidException;", "Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/BaseGetResourceException;", "", "mMd5", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;", "request", "md5", "<init>", "(Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;Ljava/lang/String;)V", "detailMessage", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;Ljava/lang/String;)V", "", LynxError.LYNX_THROWABLE, "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;Ljava/lang/String;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class Md5InvalidException extends BaseGetResourceException {
    private String mMd5;

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.BaseGetResourceException, java.lang.Throwable
    public String getMessage() {
        return StringsKt.trimIndent("\n            md5:" + this.mMd5 + "\n            " + super.getMessage() + "\n            ");
    }

    public Md5InvalidException(e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "md5");
        super(r100);
        this.mMd5 = r101;
    }

    public Md5InvalidException(String r100, e r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "md5");
        super(r100, r101);
        this.mMd5 = r102;
    }

    public Md5InvalidException(String r100, Throwable r101, e r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "request");
        Intrinsics.checkNotNullParameter(r103, "md5");
        super(r100, r101, r102);
        this.mMd5 = r103;
    }
}
