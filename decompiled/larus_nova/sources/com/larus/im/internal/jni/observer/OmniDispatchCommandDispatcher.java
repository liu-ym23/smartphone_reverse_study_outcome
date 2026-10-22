package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.internal.jni.bean.OmniIMError;
import ee9.l;
import ee9.m;
import ee9.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniDispatchCommandDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniDispatchCommandObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyReceiveDispatchCommand", "", "response", "Lcom/larus/im/internal/jni/bean/OmniDispatchCommandResponse;", "notifySendDispatchCommandFailed", "targetDeviceId", "commandId", "error", "Lcom/larus/im/internal/jni/bean/OmniIMError;", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniDispatchCommandDispatcher extends ObserverContainer<String, OmniDispatchCommandObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniDispatchCommandDispatcher";
    private static final Lazy<OmniDispatchCommandDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniDispatchCommandDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniDispatchCommandDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniDispatchCommandDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniDispatchCommandDispatcher getInstance() {
            return (OmniDispatchCommandDispatcher) OmniDispatchCommandDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniDispatchCommandDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ OmniDispatchCommandDispatcher a() {
        return instance_delegate$lambda$2();
    }

    public static /* synthetic */ Unit b(String r100, String r101, OmniIMError r102, OmniDispatchCommandObserver r103) {
        return notifySendDispatchCommandFailed$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit c(OmniDispatchCommandResponse r100, OmniDispatchCommandObserver r101) {
        return notifyReceiveDispatchCommand$lambda$0(r100, r101);
    }

    @JvmStatic
    public static final OmniDispatchCommandDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new l());
    }

    private static final OmniDispatchCommandDispatcher instance_delegate$lambda$2() {
        return new OmniDispatchCommandDispatcher();
    }

    private OmniDispatchCommandDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyReceiveDispatchCommand(final OmniDispatchCommandResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        notifyAll("notifyReceiveDispatchCommand", new n(r100));
    }

    private static final Unit notifyReceiveDispatchCommand$lambda$0(OmniDispatchCommandResponse r100, OmniDispatchCommandObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notifyAll");
        r101.onReceiveDispatchCommand(r100);
        return Unit.INSTANCE;
    }

    public final void notifySendDispatchCommandFailed(final String r100, final String r101, final OmniIMError r102) {
        Intrinsics.checkNotNullParameter(r100, "targetDeviceId");
        Intrinsics.checkNotNullParameter(r101, "commandId");
        Intrinsics.checkNotNullParameter(r102, "error");
        notifyAll("notifySendDispatchCommandFailed", new m(r100, r101, r102));
    }

    private static final Unit notifySendDispatchCommandFailed$lambda$1(String r100, String r101, OmniIMError r102, OmniDispatchCommandObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onSendDispatchCommandFailed(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
