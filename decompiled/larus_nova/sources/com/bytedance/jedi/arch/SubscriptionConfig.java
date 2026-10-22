package com.bytedance.jedi.arch;

import com.bytedance.jedi.arch.internal.SmartHandlerSchedulerKt;
import io.reactivex.Scheduler;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.functions.ObjectHelper;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0001¢\u0006\u0002\u0010\u0003RH\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00058G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u001a8G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R$\u0010)\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010/\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016¨\u00062"}, d2 = {"Lcom/bytedance/jedi/arch/SubscriptionConfig;", "R", "", "()V", "value", "Lkotlin/Function2;", "", "compareBy", "getCompareBy", "()Lkotlin/jvm/functions/Function2;", "setCompareBy", "(Lkotlin/jvm/functions/Function2;)V", "compareByInternal", "Lio/reactivex/functions/BiPredicate;", "getCompareByInternal$arch_release", "()Lio/reactivex/functions/BiPredicate;", "setCompareByInternal$arch_release", "(Lio/reactivex/functions/BiPredicate;)V", "force", "getForce", "()Z", "setForce", "(Z)V", "forceInternal", "getForceInternal$arch_release", "setForceInternal$arch_release", "Lio/reactivex/Scheduler;", "observeOn", "getObserveOn", "()Lio/reactivex/Scheduler;", "setObserveOn", "(Lio/reactivex/Scheduler;)V", "observeOnInternal", "getObserveOnInternal$arch_release", "setObserveOnInternal$arch_release", "skipInitial", "getSkipInitial", "setSkipInitial", "skipInitialInternal", "getSkipInitialInternal$arch_release", "setSkipInitialInternal$arch_release", "uniqueOnly", "getUniqueOnly", "setUniqueOnly", "uniqueOnlyAssigned", "getUniqueOnlyAssigned$arch_release", "setUniqueOnlyAssigned$arch_release", "uniqueOnlyInternal", "getUniqueOnlyInternal$arch_release", "setUniqueOnlyInternal$arch_release", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SubscriptionConfig<R> {
    private BiPredicate<R, R> compareByInternal;
    private boolean forceInternal;
    private Scheduler observeOnInternal;
    private boolean skipInitialInternal;
    private boolean uniqueOnlyAssigned;
    private boolean uniqueOnlyInternal;

    public static /* synthetic */ boolean a(Function2 r100, Object r101, Object r102) {
        return _set_compareBy_$lambda$0(r100, r101, r102);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "no getter")
    public final Function2<R, R, Boolean> getCompareBy() {
        throw new IllegalStateException("no getter".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "no getter")
    public final boolean getForce() {
        throw new IllegalStateException("no getter".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "no getter")
    public final Scheduler getObserveOn() {
        throw new IllegalStateException("no getter".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "no getter")
    public final boolean getSkipInitial() {
        throw new IllegalStateException("no getter".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "no getter")
    public final boolean getUniqueOnly() {
        throw new IllegalStateException("no getter".toString());
    }

    public SubscriptionConfig() {
        this.compareByInternal = ObjectHelper.equalsPredicate();
        this.uniqueOnlyInternal = true;
        this.observeOnInternal = SmartHandlerSchedulerKt.getSMART_MAIN();
    }

    public final BiPredicate<R, R> getCompareByInternal$arch_release() {
        return this.compareByInternal;
    }

    public final boolean getForceInternal$arch_release() {
        return this.forceInternal;
    }

    public final Scheduler getObserveOnInternal$arch_release() {
        return this.observeOnInternal;
    }

    public final boolean getSkipInitialInternal$arch_release() {
        return this.skipInitialInternal;
    }

    public final boolean getUniqueOnlyAssigned$arch_release() {
        return this.uniqueOnlyAssigned;
    }

    public final boolean getUniqueOnlyInternal$arch_release() {
        return this.uniqueOnlyInternal;
    }

    public final void setCompareBy(final Function2<? super R, ? super R, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.compareByInternal = new k(r100);
    }

    public final void setCompareByInternal$arch_release(BiPredicate<R, R> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.compareByInternal = r100;
    }

    public final void setForce(boolean r100) {
        this.forceInternal = r100;
    }

    public final void setForceInternal$arch_release(boolean r100) {
        this.forceInternal = r100;
    }

    public final void setObserveOn(Scheduler r100) {
        this.observeOnInternal = r100;
    }

    public final void setObserveOnInternal$arch_release(Scheduler r100) {
        this.observeOnInternal = r100;
    }

    public final void setSkipInitial(boolean r100) {
        this.skipInitialInternal = r100;
    }

    public final void setSkipInitialInternal$arch_release(boolean r100) {
        this.skipInitialInternal = r100;
    }

    public final void setUniqueOnly(boolean r100) {
        this.uniqueOnlyInternal = r100;
        this.uniqueOnlyAssigned = true;
    }

    public final void setUniqueOnlyAssigned$arch_release(boolean r100) {
        this.uniqueOnlyAssigned = r100;
    }

    public final void setUniqueOnlyInternal$arch_release(boolean r100) {
        this.uniqueOnlyInternal = r100;
    }

    private static final boolean _set_compareBy_$lambda$0(Function2 r100, Object r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return ((Boolean) r100.invoke(r101, r102)).booleanValue();
    }
}
