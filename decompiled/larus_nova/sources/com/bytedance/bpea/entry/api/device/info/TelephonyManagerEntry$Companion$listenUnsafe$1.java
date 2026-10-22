package com.bytedance.bpea.entry.api.device.info;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class TelephonyManagerEntry$Companion$listenUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $events;
    final /* synthetic */ PhoneStateListener $listener;
    final /* synthetic */ TelephonyManager $this_listenUnsafe;

    public TelephonyManagerEntry$Companion$listenUnsafe$1(TelephonyManager r100, PhoneStateListener r101, int r102) {
        this.$this_listenUnsafe = r100;
        this.$listener = r101;
        this.$events = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_listenUnsafe.listen(this.$listener, this.$events);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
