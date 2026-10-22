package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniThread;
import ee9.n0;
import ee9.o0;
import ee9.p0;
import ee9.q0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\fR\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniThreadDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniThreadObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyChanged", "", "thread", "Lcom/larus/im/internal/jni/bean/OmniThread;", "notifyReplace", "localThreadId", "localThread", "remote", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniThreadDispatcher extends ObserverContainer<String, OmniThreadObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniThreadDispatcher";
    private static final Lazy<OmniThreadDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniThreadDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniThreadDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniThreadDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniThreadDispatcher getInstance() {
            return (OmniThreadDispatcher) OmniThreadDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniThreadDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ OmniThreadDispatcher a() {
        return instance_delegate$lambda$3();
    }

    public static /* synthetic */ Unit b(String r100, OmniThread r101, OmniThread r102, OmniThreadObserver r103) {
        return notifyReplace$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit c(String r100, OmniThread r101, OmniThread r102, OmniThreadObserver r103) {
        return notifyReplace$lambda$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit d(OmniThread r100, OmniThreadObserver r101) {
        return notifyChanged$lambda$0(r100, r101);
    }

    @JvmStatic
    public static final OmniThreadDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new n0());
    }

    private static final OmniThreadDispatcher instance_delegate$lambda$3() {
        return new OmniThreadDispatcher();
    }

    private OmniThreadDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyChanged(final OmniThread r100) {
        Intrinsics.checkNotNullParameter(r100, "thread");
        String r101 = r100.threadId;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        notify("notifyChanged", r101, new o0(r100));
    }

    private static final Unit notifyChanged$lambda$0(OmniThread r100, OmniThreadObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notify");
        r101.onChanged(r100);
        return Unit.INSTANCE;
    }

    public final void notifyReplace(final String r100, final OmniThread r101, final OmniThread r102) {
        Intrinsics.checkNotNullParameter(r100, "localThreadId");
        Intrinsics.checkNotNullParameter(r102, "remote");
        notify("notifyReplace", r100, new p0(r100, r101, r102));
        notifyAll("notifyReplace", new q0(r100, r101, r102));
    }

    private static final Unit notifyReplace$lambda$1(String r100, OmniThread r101, OmniThread r102, OmniThreadObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notify");
        r103.onReplace(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit notifyReplace$lambda$2(String r100, OmniThread r101, OmniThread r102, OmniThreadObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onReplace(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
