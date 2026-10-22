package com.ss.android.ugc.bytex.pthread.base.convergence.executor;

import android.os.Handler;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/InstrumentationLogger;", "", "instrumentations", "", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/executor/Instrumentation;", VideoThumbInfo.KEY_INTERVAL, "", "summarize", "Lkotlin/Function0;", "", "(Ljava/util/List;JLkotlin/jvm/functions/Function0;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "start", "", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class InstrumentationLogger {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy handler$delegate;
    private final List<Instrumentation> instrumentations;
    private final long interval;
    private final Function0<String> summarize;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InstrumentationLogger.class), "handler", "getHandler()Landroid/os/Handler;"))};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InstrumentationLogger(List<? extends Instrumentation> r100, long r101, Function0<String> r102) {
        this.instrumentations = r100;
        this.interval = r101;
        this.summarize = r102;
        this.handler$delegate = LazyKt.lazy(InstrumentationLogger$handler$2.INSTANCE);
    }

    public /* synthetic */ InstrumentationLogger(List r100, long r101, Function0 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 2000;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }

    public static final /* synthetic */ Handler access$getHandler$p(InstrumentationLogger r100) {
        return r100.getHandler();
    }

    public static final /* synthetic */ List access$getInstrumentations$p(InstrumentationLogger r100) {
        return r100.instrumentations;
    }

    public static final /* synthetic */ long access$getInterval$p(InstrumentationLogger r100) {
        return r100.interval;
    }

    public static final /* synthetic */ Function0 access$getSummarize$p(InstrumentationLogger r100) {
        return r100.summarize;
    }

    private final Handler getHandler() {
        Lazy r100 = this.handler$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (Handler) r100.getValue();
    }

    public final void start() {
        getHandler().postDelayed(new AnonymousClass1(this), this.interval);
    }
}
