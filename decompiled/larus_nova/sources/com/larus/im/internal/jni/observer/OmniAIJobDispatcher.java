package com.larus.im.internal.jni.observer;

import ee9.a;
import ee9.b;
import ee9.c;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fJ&\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniAIJobDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniAIJobObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyJobsChanged", "", "changedIds", "", "deletedIds", "notifyRequestStateChanged", "requestType", "", "status", "errorCode", "errorMessage", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAIJobDispatcher extends ObserverContainer<String, OmniAIJobObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniAIJobDispatcher";
    private static final Lazy<OmniAIJobDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniAIJobDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniAIJobDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniAIJobDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniAIJobDispatcher getInstance() {
            return (OmniAIJobDispatcher) OmniAIJobDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniAIJobDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ Unit a(List r100, List r101, OmniAIJobObserver r102) {
        return notifyJobsChanged$lambda$0(r100, r101, r102);
    }

    public static /* synthetic */ OmniAIJobDispatcher b() {
        return instance_delegate$lambda$2();
    }

    public static /* synthetic */ Unit c(int r100, int r101, int r102, String r103, OmniAIJobObserver r104) {
        return notifyRequestStateChanged$lambda$1(r100, r101, r102, r103, r104);
    }

    @JvmStatic
    public static final OmniAIJobDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new c());
    }

    private static final OmniAIJobDispatcher instance_delegate$lambda$2() {
        return new OmniAIJobDispatcher();
    }

    private OmniAIJobDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyJobsChanged(final List<String> r100, final List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "changedIds");
        Intrinsics.checkNotNullParameter(r101, "deletedIds");
        notifyAll("notifyJobsChanged", new a(r100, r101));
    }

    private static final Unit notifyJobsChanged$lambda$0(List r100, List r101, OmniAIJobObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notifyAll");
        r102.onJobsChanged(r100, r101);
        return Unit.INSTANCE;
    }

    public final void notifyRequestStateChanged(final int r100, final int r101, final int r102, final String r103) {
        Intrinsics.checkNotNullParameter(r103, "errorMessage");
        notifyAll("notifyRequestStateChanged", new b(r100, r101, r102, r103));
    }

    private static final Unit notifyRequestStateChanged$lambda$1(int r100, int r101, int r102, String r103, OmniAIJobObserver r104) {
        Intrinsics.checkNotNullParameter(r104, "$this$notifyAll");
        r104.onRequestStateChanged(r100, r101, r102, r103);
        return Unit.INSTANCE;
    }
}
