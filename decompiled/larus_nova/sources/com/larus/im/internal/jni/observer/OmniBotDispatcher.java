package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniBot;
import ee9.d;
import ee9.e;
import ee9.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniBotDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniBotObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyBotChange", "", "bot", "Lcom/larus/im/internal/jni/bean/OmniBot;", "type", "", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniBotDispatcher extends ObserverContainer<String, OmniBotObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniBotDispatcher";
    private static final Lazy<OmniBotDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniBotDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniBotDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniBotDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniBotDispatcher getInstance() {
            return (OmniBotDispatcher) OmniBotDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniBotDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ OmniBotDispatcher a() {
        return instance_delegate$lambda$2();
    }

    public static /* synthetic */ Unit b(OmniBot r100, int r101, OmniBotObserver r102) {
        return notifyBotChange$lambda$1(r100, r101, r102);
    }

    public static /* synthetic */ Unit c(OmniBot r100, int r101, OmniBotObserver r102) {
        return notifyBotChange$lambda$0(r100, r101, r102);
    }

    @JvmStatic
    public static final OmniBotDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new d());
    }

    private static final OmniBotDispatcher instance_delegate$lambda$2() {
        return new OmniBotDispatcher();
    }

    private OmniBotDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyBotChange(final OmniBot r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "bot");
        String r102 = r100.botId;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        notify("notifyBotChange", r102, new e(r100, r101));
        notifyAll("notifyBotChange", new f(r100, r101));
    }

    private static final Unit notifyBotChange$lambda$0(OmniBot r100, int r101, OmniBotObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notify");
        r102.notifyBotChange(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit notifyBotChange$lambda$1(OmniBot r100, int r101, OmniBotObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notifyAll");
        r102.notifyBotChange(r100, r101);
        return Unit.INSTANCE;
    }
}
