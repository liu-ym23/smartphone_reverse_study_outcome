package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniConversation;
import ee9.g;
import ee9.h;
import ee9.i;
import ee9.j;
import ee9.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\rR\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniConversationDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniConversationObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyChange", "", "conversations", "", "Lcom/larus/im/internal/jni/bean/OmniConversation;", "notifyReplace", "localCvsId", "localCvs", "remote", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniConversationDispatcher extends ObserverContainer<String, OmniConversationObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniConversationDispatcher";
    private static final Lazy<OmniConversationDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniConversationDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniConversationDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniConversationDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final OmniConversationDispatcher getInstance() {
            return (OmniConversationDispatcher) OmniConversationDispatcher.access$getInstance$delegate$cp().getValue();
        }

        @JvmStatic
        public final OmniConversationDispatcher getInst() {
            return getInstance();
        }
    }

    public static /* synthetic */ Unit a(String r100, OmniConversation r101, OmniConversation r102, OmniConversationObserver r103) {
        return notifyReplace$lambda$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit b(String r100, OmniConversation r101, OmniConversation r102, OmniConversationObserver r103) {
        return notifyReplace$lambda$3(r100, r101, r102, r103);
    }

    public static /* synthetic */ OmniConversationDispatcher c() {
        return instance_delegate$lambda$4();
    }

    public static /* synthetic */ Unit d(List r100, OmniConversationObserver r101) {
        return notifyChange$lambda$1(r100, r101);
    }

    public static /* synthetic */ Unit e(List r100, OmniConversationObserver r101) {
        return notifyChange$lambda$0(r100, r101);
    }

    @JvmStatic
    public static final OmniConversationDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new g());
    }

    private static final OmniConversationDispatcher instance_delegate$lambda$4() {
        return new OmniConversationDispatcher();
    }

    private OmniConversationDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyChange(final List<OmniConversation> r100) {
        Intrinsics.checkNotNullParameter(r100, "conversations");
        Iterator<OmniConversation> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next().conversationId;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        notify("notifyChange", r102, new h(r100));
        goto L4
    L9:
        notifyAll("notifyChange", new i(r100));
    }

    private static final Unit notifyChange$lambda$0(List r100, OmniConversationObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notify");
        r101.notifyChange(r100);
        return Unit.INSTANCE;
    }

    private static final Unit notifyChange$lambda$1(List r100, OmniConversationObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notifyAll");
        r101.notifyChange(r100);
        return Unit.INSTANCE;
    }

    public final void notifyReplace(final String r100, final OmniConversation r101, final OmniConversation r102) {
        Intrinsics.checkNotNullParameter(r100, "localCvsId");
        Intrinsics.checkNotNullParameter(r102, "remote");
        notify("notifyReplace", r100, new j(r100, r101, r102));
        notifyAll("notifyReplace", new k(r100, r101, r102));
    }

    private static final Unit notifyReplace$lambda$2(String r100, OmniConversation r101, OmniConversation r102, OmniConversationObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notify");
        r103.notifyReplace(r100, r101, r102);
        return Unit.INSTANCE;
    }

    private static final Unit notifyReplace$lambda$3(String r100, OmniConversation r101, OmniConversation r102, OmniConversationObserver r103) {
        Intrinsics.checkNotNullParameter(r103, "$this$notifyAll");
        r103.notifyReplace(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
