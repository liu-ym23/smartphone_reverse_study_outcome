package com.bytedance.jedi.arch;

import io.reactivex.Scheduler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010)\u001a\u00020*2\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010JT\u0010,\u001a\u00020*2L\u0010+\u001aH\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001f0\u0018j\b\u0012\u0004\u0012\u00020\u001a` J\u0018\u0010-\u001a\u00020*2\u0010\u0010+\u001a\f\u0012\u0004\u0012\u00020%0\u000ej\u0002`&R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R$\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012RZ\u0010\u0017\u001aH\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001f0\u0018j\b\u0012\u0004\u0012\u00020\u001a` 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"RT\u0010#\u001aH\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001f0\u0018j\b\u0012\u0004\u0012\u00020\u001a` X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\f\u0012\u0004\u0012\u00020%0\u000ej\u0002`&8F¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u0018\u0010(\u001a\f\u0012\u0004\u0012\u00020%0\u000ej\u0002`&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/jedi/arch/JediArchPlugins;", "", "()V", "isDebug", "", "()Z", "setDebug", "(Z)V", "isLoggable", "setLoggable", "isTest", "isTest$arch_release", "setTest$arch_release", "serialWorkerInternal", "Lkotlin/Function0;", "Ljava/util/concurrent/Executor;", "Lcom/bytedance/jedi/arch/ExecutorFactory;", "getSerialWorkerInternal$arch_release", "()Lkotlin/jvm/functions/Function0;", "setSerialWorkerInternal$arch_release", "(Lkotlin/jvm/functions/Function0;)V", "storeExecutorFactory", "getStoreExecutorFactory", "storeFactory", "Lkotlin/Function2;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/jedi/arch/State;", "Lkotlin/ParameterName;", "name", "vm", "state", "Lcom/bytedance/jedi/arch/Store;", "Lcom/bytedance/jedi/arch/StoreFactory;", "getStoreFactory$arch_release", "()Lkotlin/jvm/functions/Function2;", "storeFactoryInternal", "storeSchedulerFactory", "Lio/reactivex/Scheduler;", "Lcom/bytedance/jedi/arch/SchedulerFactory;", "getStoreSchedulerFactory", "storeSchedulerInternal", "setGlobalStoreExecutorFactory", "", "factory", "setGlobalStoreFactory", "setGlobalStoreSchedulerFactory", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JediArchPlugins {
    public static final JediArchPlugins INSTANCE = null;
    private static boolean isDebug;
    private static boolean isLoggable;
    private static boolean isTest;
    private static Function0<? extends Executor> serialWorkerInternal;
    private static final Function0<Executor> storeExecutorFactory = null;
    private static Function2<? super JediViewModel<State>, ? super State, ? extends Store<State>> storeFactoryInternal;
    private static Function0<? extends Scheduler> storeSchedulerInternal;

    private JediArchPlugins() {
    }

    static {
        INSTANCE = new JediArchPlugins();
        storeFactoryInternal = JediArchPlugins$storeFactoryInternal$1.INSTANCE;
        storeExecutorFactory = JediArchPlugins$storeExecutorFactory$1.INSTANCE;
        storeSchedulerInternal = JediArchPlugins$storeSchedulerInternal$1.INSTANCE;
        serialWorkerInternal = JediArchPlugins$serialWorkerInternal$1.INSTANCE;
    }

    public final Function0<Executor> getSerialWorkerInternal$arch_release() {
        return serialWorkerInternal;
    }

    public final Function0<Executor> getStoreExecutorFactory() {
        return storeExecutorFactory;
    }

    public final Function2<JediViewModel<State>, State, Store<State>> getStoreFactory$arch_release() {
        return storeFactoryInternal;
    }

    public final Function0<Scheduler> getStoreSchedulerFactory() {
        return storeSchedulerInternal;
    }

    public final boolean isDebug() {
        return isDebug;
    }

    public final boolean isLoggable() {
        return isLoggable;
    }

    public final boolean isTest$arch_release() {
        return isTest;
    }

    public final void setDebug(boolean r100) {
        isDebug = r100;
    }

    public final void setGlobalStoreExecutorFactory(Function0<? extends Executor> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        serialWorkerInternal = r100;
    }

    public final void setGlobalStoreFactory(Function2<? super JediViewModel<State>, ? super State, ? extends Store<State>> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        storeFactoryInternal = r100;
    }

    public final void setGlobalStoreSchedulerFactory(Function0<? extends Scheduler> r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        storeSchedulerInternal = r100;
    }

    public final void setLoggable(boolean r100) {
        isLoggable = r100;
    }

    public final void setSerialWorkerInternal$arch_release(Function0<? extends Executor> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        serialWorkerInternal = r100;
    }

    public final void setTest$arch_release(boolean r100) {
        isTest = r100;
    }
}
