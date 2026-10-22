package com.bytedance.jedi.arch;

import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a\u0012\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0010\u001a\u00020\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"compareBy", "Lcom/bytedance/jedi/arch/SubscriptionConfig;", "R", "predicate", "Lkotlin/Function2;", "", "config", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "force", "observeOn", "scheduler", "Lio/reactivex/Scheduler;", "skipInitial", "uniqueOnly", "arch_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SubscriptionConfigKt {
    public static final <R> SubscriptionConfig<R> skipInitial() {
        SubscriptionConfig<R> r100 = new SubscriptionConfig();
        r100.setSkipInitial(true);
        return r100;
    }

    public static final <R> SubscriptionConfig<R> compareBy(Function2<? super R, ? super R, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        SubscriptionConfig<R> r101 = new SubscriptionConfig();
        r101.setCompareBy(r100);
        return r101;
    }

    public static final <R> SubscriptionConfig<R> config(Function1<? super SubscriptionConfig<R>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        SubscriptionConfig<R> r101 = new SubscriptionConfig();
        r100.invoke(r101);
        return r101;
    }

    public static final <R> SubscriptionConfig<R> force(boolean r100) {
        SubscriptionConfig<R> r101 = new SubscriptionConfig();
        r101.setForce(r100);
        return r101;
    }

    public static final <R> SubscriptionConfig<R> observeOn(Scheduler r100) {
        SubscriptionConfig<R> r101 = new SubscriptionConfig();
        r101.setObserveOn(r100);
        return r101;
    }

    public static final <R> SubscriptionConfig<R> uniqueOnly(boolean r100) {
        SubscriptionConfig<R> r101 = new SubscriptionConfig();
        r101.setUniqueOnly(r100);
        return r101;
    }

    public static /* synthetic */ SubscriptionConfig force$default(boolean r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = true;
    L6:
        return force(r100);
    }
}
