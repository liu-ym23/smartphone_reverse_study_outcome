package com.bytedance.ies.tools.prefetch;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\n\u001a\u00020\u0005\"\u0012\b\u0000\u0010\u0003*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/f0$a;", "Lcom/bytedance/ies/tools/prefetch/f0;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", OnekeyLoginConstants.CU_KEY_TOKEN_EXPIRES, AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryConvertWithLog"}, k = 3, mv = {1, 4, 0})
final class ProcessManager$toSpecifiedType$1 extends Lambda implements Function2<String, Function1<? super String, ? extends Object>, Object> {
    public static final ProcessManager$toSpecifiedType$1 INSTANCE = null;

    static {
        INSTANCE = new ProcessManager$toSpecifiedType$1();
    }

    public ProcessManager$toSpecifiedType$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Function1<? super String, ? extends Object> r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r101.invoke(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L10;
        k r104 = p.f248826a;
        p.c("Failed to parse param value [" + r100 + "], keeping as String.", null);
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        return r100;
    L13:
        return r103;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Function1<? super String, ? extends Object> r101) {
        return invoke2(r100, r101);
    }
}
