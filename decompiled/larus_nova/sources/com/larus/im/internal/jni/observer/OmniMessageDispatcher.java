package com.larus.im.internal.jni.observer;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.im.internal.jni.bean.OmniMessage;
import ee9.a0;
import ee9.b0;
import ee9.c0;
import ee9.d0;
import ee9.e0;
import ee9.f0;
import ee9.g0;
import ee9.o;
import ee9.p;
import ee9.q;
import ee9.r;
import ee9.s;
import ee9.t;
import ee9.u;
import ee9.v;
import ee9.w;
import ee9.x;
import ee9.y;
import ee9.z;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\b\u0001\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fJ\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ,\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fJ\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017J*\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0017J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rJ(\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u0015J\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002J\u0016\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006'"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniMessageDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniMessageObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "onUpdateMessage", "", "cid", "msg", "Lcom/larus/im/internal/jni/bean/OmniMessage;", "ext", "", "onSendMessage", "onReceiveMessage", "onMessageInvisible", "onMessageListChanged", OnekeyLoginConstants.CU_KEY_OPERATOR, "", "msgList", "", "onMessageListReplaced", "oldMsgList", "newMsgList", "onRegenMessage", "onStreamingMessage", "local", "type", "onReportEvent", "queryLocalMsgId", "eventName", "param", "onReceiveEnd", "replyMsgId", "endMsg", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniMessageDispatcher extends ObserverContainer<String, OmniMessageObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniMessageDispatcher";
    private static final Lazy<OmniMessageDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniMessageDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniMessageDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniMessageDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniMessageDispatcher getInstance() {
            return (OmniMessageDispatcher) OmniMessageDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniMessageDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ Unit a(String r100, OmniMessage r101, OmniMessageObserver r102) {
        return onMessageInvisible$lambda$7(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(String r100, List r101, List r102, OmniMessageObserver r103) {
        return onMessageListReplaced$lambda$11(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit c(String r100, OmniMessage r101, OmniMessageObserver r102) {
        return onSendMessage$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ Unit d(String r100, OmniMessage r101, OmniMessageObserver r102) {
        return onRegenMessage$lambda$12(r100, r101, r102);
    }

    public static /* synthetic */ Unit e(String r100, String r101, OmniMessageObserver r102) {
        return onReceiveEnd$lambda$17(r100, r101, r102);
    }

    public static /* synthetic */ Unit f(String r100, OmniMessage r101, OmniMessageObserver r102) {
        return onMessageInvisible$lambda$6(r100, r101, r102);
    }

    public static /* synthetic */ Unit g(String r100, OmniMessage r101, OmniMessageObserver r102) {
        return onSendMessage$lambda$3(r100, r101, r102);
    }

    @JvmStatic
    public static final OmniMessageDispatcher getInst() {
        return Companion.getInst();
    }

    public static /* synthetic */ Unit h(String r100, OmniMessage r101, OmniMessage r102, int r103, OmniMessageObserver r104) {
        return onStreamingMessage$lambda$14(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit i(String r100, OmniMessage r101, OmniMessageObserver r102) {
        return onRegenMessage$lambda$13(r100, r101, r102);
    }

    public static /* synthetic */ Unit j(String r100, String r101, String r102, OmniMessageObserver r103) {
        return onReportEvent$lambda$16(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit k(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        return onUpdateMessage$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit l(String r100, List r101, List r102, OmniMessageObserver r103) {
        return onMessageListReplaced$lambda$10(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit m(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        return onReceiveMessage$lambda$4(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit n(String r100, OmniMessage r101, OmniMessage r102, int r103, OmniMessageObserver r104) {
        return onStreamingMessage$lambda$15(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit o(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        return onReceiveMessage$lambda$5(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit p(String r100, int r101, List r102, OmniMessageObserver r103) {
        return onMessageListChanged$lambda$9(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit q(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        return onUpdateMessage$lambda$0(r100, r101, r102, r103);
    }

    public static /* synthetic */ OmniMessageDispatcher r() {
        return instance_delegate$lambda$18();
    }

    public static /* synthetic */ Unit s(String r100, int r101, List r102, OmniMessageObserver r103) {
        return onMessageListChanged$lambda$8(r100, r101, r102, r103);
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new d0());
    }

    private static final OmniMessageDispatcher instance_delegate$lambda$18() {
        return new OmniMessageDispatcher();
    }

    private OmniMessageDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void onMessageInvisible(final String r100, final OmniMessage r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        notify("onMessageInvisible", r100, new b0(r100, r101));
        notifyAll("onMessageInvisible", new c0(r100, r101));
    }

    public final void onReceiveEnd(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "replyMsgId");
        Intrinsics.checkNotNullParameter(r101, "endMsg");
        notifyAll("onReceiveEnd", new s(r100, r101));
    }

    public final void onRegenMessage(final String r100, final OmniMessage r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        notify("onRegenMessage", r100, new o(r100, r101));
        notifyAll("onRegenMessage", new y(r100, r101));
    }

    public final void onSendMessage(final String r100, final OmniMessage r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        notify("onSendMessage", r100, new q(r100, r101));
        notifyAll("onSendMessage", new r(r100, r101));
    }

    private static final Unit onMessageInvisible$lambda$6(String r100, OmniMessage r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notify");
        r102.onMessageInvisible(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit onMessageInvisible$lambda$7(String r100, OmniMessage r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notifyAll");
        r102.onMessageInvisible(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit onReceiveEnd$lambda$17(String r100, String r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notifyAll");
        r102.onReceiveEnd(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit onRegenMessage$lambda$12(String r100, OmniMessage r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notify");
        r102.onRegenMessage(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit onRegenMessage$lambda$13(String r100, OmniMessage r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notifyAll");
        r102.onRegenMessage(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit onSendMessage$lambda$2(String r100, OmniMessage r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notify");
        r102.onSendMessage(r100, r101);
        return Unit.INSTANCE;
    }

    private static final Unit onSendMessage$lambda$3(String r100, OmniMessage r101, OmniMessageObserver r102) {
        Intrinsics.checkNotNullParameter(r102, "$this$notifyAll");
        r102.onSendMessage(r100, r101);
        return Unit.INSTANCE;
    }

    public final void onMessageListChanged(final String r100, final int r101, final List<OmniMessage> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r102, "msgList");
        notify("onMessageListChanged", r100, new u(r100, r101, r102));
        notifyAll("onMessageListChanged", new v(r100, r101, r102));
    }

    public final void onMessageListReplaced(final String r100, final List<OmniMessage> r101, final List<OmniMessage> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "oldMsgList");
        Intrinsics.checkNotNullParameter(r102, "newMsgList");
        notify("onMessageListReplaced", r100, new e0(r100, r101, r102));
        notifyAll("onMessageListReplaced", new f0(r100, r101, r102));
    }

    public final void onReceiveMessage(final String r100, final OmniMessage r101, final Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        notify("onReceiveMessage", r100, new g0(r100, r101, r102));
        notifyAll("onReceiveMessage", new p(r100, r101, r102));
    }

    public final void onReportEvent(final String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "queryLocalMsgId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "param");
        notifyAll("onReportEvent", new t(r100, r101, r102));
    }

    public final void onUpdateMessage(final String r100, final OmniMessage r101, final Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        notify("onUpdateMessage", r100, new z(r100, r101, r102));
        notifyAll("onUpdateMessage", new a0(r100, r101, r102));
    }

    private static final Unit onMessageListChanged$lambda$8(String r100, int r101, List r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notify");
        r103.onMessageListChanged(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onMessageListChanged$lambda$9(String r100, int r101, List r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onMessageListChanged(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onMessageListReplaced$lambda$10(String r100, List r101, List r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notify");
        r103.onMessageListReplaced(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onMessageListReplaced$lambda$11(String r100, List r101, List r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onMessageListReplaced(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onReceiveMessage$lambda$4(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notify");
        r103.onReceiveMessage(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onReceiveMessage$lambda$5(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onReceiveMessage(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onReportEvent$lambda$16(String r100, String r101, String r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onReportEvent(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onUpdateMessage$lambda$0(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notify");
        r103.onUpdateMessage(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit onUpdateMessage$lambda$1(String r100, OmniMessage r101, Map r102, OmniMessageObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.onUpdateMessage(r100, r101, r102);
        return Unit.INSTANCE;
    }

    public final void onStreamingMessage(final String r100, final OmniMessage r101, final OmniMessage r102, final int r103) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
        notify("onStreamingMessage", r100, new w(r100, r101, r102, r103));
        notifyAll("onStreamingMessage", new x(r100, r101, r102, r103));
    }

    private static final Unit onStreamingMessage$lambda$14(String r100, OmniMessage r101, OmniMessage r102, int r103, OmniMessageObserver r104) {
        Intrinsics.checkNotNullParameter(r104, "$this$notify");
        r104.onStreamingMessage(r100, r101, r102, r103);
        return Unit.INSTANCE;
    }

    private static final Unit onStreamingMessage$lambda$15(String r100, OmniMessage r101, OmniMessage r102, int r103, OmniMessageObserver r104) {
        Intrinsics.checkNotNullParameter(r104, "$this$notifyAll");
        r104.onStreamingMessage(r100, r101, r102, r103);
        return Unit.INSTANCE;
    }
}
