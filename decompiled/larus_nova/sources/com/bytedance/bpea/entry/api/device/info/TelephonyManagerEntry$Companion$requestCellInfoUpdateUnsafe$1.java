package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$requestCellInfoUpdateUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TelephonyManager.CellInfoCallback $callback;
    final /* synthetic */ Executor $executor;
    final /* synthetic */ TelephonyManager $this_requestCellInfoUpdateUnsafe;

    public TelephonyManagerEntry$Companion$requestCellInfoUpdateUnsafe$1(TelephonyManager r100, Executor r101, TelephonyManager.CellInfoCallback r102) {
        this.$this_requestCellInfoUpdateUnsafe = r100;
        this.$executor = r101;
        this.$callback = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_requestCellInfoUpdateUnsafe.requestCellInfoUpdate(this.$executor, this.$callback);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
