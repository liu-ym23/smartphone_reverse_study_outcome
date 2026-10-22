package com.bytedance.android.shopping.slice;

import android.content.Context;
import com.bytedance.android.ec.core.slice.ectag.ECTagTemplatePreload;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/slice/SliceInit;", "", "()V", "init", "", "context", "Landroid/content/Context;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceInit {
    public static final SliceInit INSTANCE = null;

    private SliceInit() {
    }

    static {
        INSTANCE = new SliceInit();
    }

    @JvmStatic
    public static final void init(Context r1) {
        if (r1 == null) goto L10;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        PdpSliceRegister.b(r1);     // Catch: Throwable -> L5
        ECTagTemplatePreload.a(r1, false);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }
}
