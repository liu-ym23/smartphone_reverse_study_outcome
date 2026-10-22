package com.larus.im.internal.core.conversation;

import com.larus.im.internal.core.conversation.receiver.ConversationDispatcher;
import com.larus.im.service.b0;
import com.larus.im.service.d0;
import com.larus.im.service.q;
import com.larus.im.service.z;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/core/conversation/ConversationReceiverServiceImpl;", "Lcom/larus/im/service/IConversationReceiverService;", "<init>", "()V", "registerConversationChangeListener", "", "listener", "Lcom/larus/im/service/OnChangeListener;", "", "Lcom/larus/im/bean/conversation/Conversation;", "unRegisterConversationChangeListener", "conversationId", "", "Lcom/larus/im/service/OnReplaceListener;", "registerLocalConversationReplaceListener", "Lcom/larus/im/service/OnLocalConversationReplaceListener;", "unRegisterLocalConversationReplaceListener", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationReceiverServiceImpl implements q {
    public static final Companion Companion = null;
    private static final Lazy<ConversationReceiverServiceImpl> instance$delegate = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0005R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/larus/im/internal/core/conversation/ConversationReceiverServiceImpl$Companion;", "", "<init>", "()V", "instance", "Lcom/larus/im/internal/core/conversation/ConversationReceiverServiceImpl;", "getInstance", "()Lcom/larus/im/internal/core/conversation/ConversationReceiverServiceImpl;", "instance$delegate", "Lkotlin/Lazy;", MonitorConstants.CONNECT_TYPE_GET, "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final ConversationReceiverServiceImpl getInstance() {
            return (ConversationReceiverServiceImpl) ConversationReceiverServiceImpl.access$getInstance$delegate$cp().getValue();
        }

        public final ConversationReceiverServiceImpl get() {
            return getInstance();
        }
    }

    public ConversationReceiverServiceImpl() {
    }

    public static /* synthetic */ ConversationReceiverServiceImpl a() {
        return instance_delegate$lambda$0();
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(new a());
    }

    private static final ConversationReceiverServiceImpl instance_delegate$lambda$0() {
        return new ConversationReceiverServiceImpl();
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    @Override // com.larus.im.service.q
    public void registerConversationChangeListener(z<List<e>> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<z<List<e>>> r101 = ConversationDispatcher.f347638a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<z<List<e>>> r102 = ConversationDispatcher.f347638a;
        if (r102.contains(r100) == true) goto L6;
        r102.add(r100);
        return;
    }

    public void registerLocalConversationReplaceListener(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<z<List<e>>> r101 = ConversationDispatcher.f347638a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<b0> r102 = ConversationDispatcher.f347640c;
        if (r102.contains(r100) == true) goto L6;
        r102.add(r100);
        return;
    }

    @Override // com.larus.im.service.q
    public void unRegisterConversationChangeListener(z<List<e>> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<z<List<e>>> r101 = ConversationDispatcher.f347638a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<z<List<e>>> r102 = ConversationDispatcher.f347638a;
        if (r102.contains(r100) == false) goto L6;
        r102.remove(r100);
        return;
    }

    public void unRegisterLocalConversationReplaceListener(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<z<List<e>>> r101 = ConversationDispatcher.f347638a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<b0> r102 = ConversationDispatcher.f347640c;
        if (r102.contains(r100) == false) goto L6;
        r102.remove(r100);
        return;
    }

    @Override // com.larus.im.service.q
    public void registerConversationChangeListener(String r100, d0<e> r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        CopyOnWriteArrayList<z<List<e>>> r102 = ConversationDispatcher.f347638a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        vt7.a<String, CopyOnWriteArrayList<d0<e>>> r103 = ConversationDispatcher.f347639b;
        CopyOnWriteArrayList<d0<e>> r104 = r103.get(r100);
        if (r104 != null) goto L5;
        r104 = new CopyOnWriteArrayList();
        r103.put(r100, r104);
    L5:
        r104.add(r101);
    }

    @Override // com.larus.im.service.q
    public void unRegisterConversationChangeListener(String r100, d0<e> r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        CopyOnWriteArrayList<z<List<e>>> r102 = ConversationDispatcher.f347638a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "listener");
        vt7.a<String, CopyOnWriteArrayList<d0<e>>> r103 = ConversationDispatcher.f347639b;
        if (r103.containsKey(r100) == false) goto L8;
        CopyOnWriteArrayList<d0<e>> r104 = r103.get(r100);
        if (r104 == null) goto L9;
        r104.remove(r101);
        return;
    L9:
        return;
    }
}
