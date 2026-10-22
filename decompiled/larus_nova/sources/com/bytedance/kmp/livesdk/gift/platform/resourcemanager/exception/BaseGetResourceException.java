package com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception;

import android.os.Environment;
import android.os.StatFs;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import com.lynx.tasm.LynxError;
import gd6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0016B%\b\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/resourcemanager/exception/BaseGetResourceException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "toString", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;", "mRequest", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;", "", "getId", "()J", "id", "getResourceRequest", "()Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;", "resourceRequest", "getMessage", "()Ljava/lang/String;", "message", "request", "<init>", "(Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;)V", "detailMessage", "(Ljava/lang/String;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;)V", "", LynxError.LYNX_THROWABLE, "(Ljava/lang/String;Ljava/lang/Throwable;Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/e;)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseGetResourceException extends RuntimeException {
    private e mRequest;

    public final long getId() {
        return this.mRequest.f129099i;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r100 = new StringBuilder();
        StringBuilder r101 = new StringBuilder();
        r101.append(this.mRequest.toString());
        r101.append("\navailable disk space:");
        int r102 = a.f480944a;
        StatFs r103 = new StatFs(Environment.getDataDirectory().getPath());
        long r104 = r103.getBlockSizeLong();
        r101.append((r103.getAvailableBlocksLong() * r104) / ((long) 1024));
        r100.append(r101.toString().toString());
        r100.append("KB\n");
        String r105 = super.getMessage();
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r100.append(r105);
        return r100.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        String r100 = super.toString();
        Throwable r101 = getCause();
        if (r101 == null) goto L7;
        if (r101 != this) goto L6;
        return r100;
    L6:
        return StringsKt.trimIndent("\n     " + r100 + "\n     " + r101 + "\n     ");
    L7:
        return r100;
    }

    public final e getResourceRequest() {
        return this.mRequest;
    }

    public BaseGetResourceException(e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.mRequest = r100;
    }

    public BaseGetResourceException(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "request");
        super(r100);
        this.mRequest = r101;
    }

    public BaseGetResourceException(String r100, Throwable r101, e r102) {
        Intrinsics.checkNotNullParameter(r102, "request");
        super(r100, r101);
        this.mRequest = r102;
    }
}
