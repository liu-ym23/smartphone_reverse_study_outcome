package com.larus.im.internal.jni.observer;

import com.larus.im.internal.jni.bean.OmniParticipant;
import ee9.h0;
import ee9.i0;
import ee9.j0;
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
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010\u0006\u001a\u00020\u0002X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniParticipantDispatcher;", "Lcom/larus/im/internal/jni/observer/ObserverContainer;", "", "Lcom/larus/im/internal/jni/observer/OmniParticipantObserver;", "<init>", "()V", "subTag", "getSubTag", "()Ljava/lang/String;", "notifyChange", "", "participants", "", "Lcom/larus/im/internal/jni/bean/OmniParticipant;", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniParticipantDispatcher extends ObserverContainer<String, OmniParticipantObserver> {
    public static final Companion Companion = null;
    private static final String TAG = "OmniParticipantDispatcher";
    private static final Lazy<OmniParticipantDispatcher> instance$delegate = null;
    private final String subTag;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniParticipantDispatcher$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/larus/im/internal/jni/observer/OmniParticipantDispatcher;", "getInstance", "()Lcom/larus/im/internal/jni/observer/OmniParticipantDispatcher;", "instance$delegate", "Lkotlin/Lazy;", "getInst", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final OmniParticipantDispatcher getInst() {
            return getInstance();
        }

        public final OmniParticipantDispatcher getInstance() {
            return (OmniParticipantDispatcher) OmniParticipantDispatcher.access$getInstance$delegate$cp().getValue();
        }
    }

    public static /* synthetic */ OmniParticipantDispatcher a() {
        return instance_delegate$lambda$2();
    }

    public static /* synthetic */ Unit b(List r100, OmniParticipantObserver r101) {
        return notifyChange$lambda$1(r100, r101);
    }

    public static /* synthetic */ Unit c(List r100, OmniParticipantObserver r101) {
        return notifyChange$lambda$0(r100, r101);
    }

    @JvmStatic
    public static final OmniParticipantDispatcher getInst() {
        return Companion.getInst();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new h0());
    }

    private static final OmniParticipantDispatcher instance_delegate$lambda$2() {
        return new OmniParticipantDispatcher();
    }

    private OmniParticipantDispatcher() {
        this.subTag = TAG;
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.internal.jni.observer.ObserverContainer
    public String getSubTag() {
        return this.subTag;
    }

    public final void notifyChange(final List<OmniParticipant> r100) {
        Intrinsics.checkNotNullParameter(r100, "participants");
        Iterator<OmniParticipant> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next().conversationId;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        notify("notifyChange", r102, new i0(r100));
        goto L4
    L9:
        notifyAll("notifyChange", new j0(r100));
    }

    private static final Unit notifyChange$lambda$0(List r100, OmniParticipantObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notify");
        r101.notifyChange(r100);
        return Unit.INSTANCE;
    }

    private static final Unit notifyChange$lambda$1(List r100, OmniParticipantObserver r101) {
        Intrinsics.checkNotNullParameter(r101, "$this$notifyAll");
        r101.notifyChange(r100);
        return Unit.INSTANCE;
    }
}
