package com.larus.audio.realtimecall;

import android.os.Bundle;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import wc9.e;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RealtimeCallStrategyDelegate", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IRealtimeCallStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RealtimeCallStrategyDelegate f289776a = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0018\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096A¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/larus/audio/realtimecall/IRealtimeCallStrategy$RealtimeCallStrategyDelegate;", "Lcom/larus/audio/realtimecall/IRealtimeCallStrategy;", "<init>", "()V", "realtimeCallAutoHelloParam", "Landroid/os/Bundle;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "lastMsg", "Lcom/larus/im/bean/message/Message;", "realtimeCallAutoHelloParamByCvsId", "cvsId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RealtimeCallStrategyDelegate implements IRealtimeCallStrategy {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ RealtimeCallStrategyDelegate f289777c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRealtimeCallStrategy f289778b;

        static {
            f289777c = new RealtimeCallStrategyDelegate();
        }

        @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
        public final Bundle a(e r100, Message r101) {
            return this.f289778b.a(r100, r101);
        }

        @Override // com.larus.audio.realtimecall.IRealtimeCallStrategy
        public final Object b(String r100, Continuation<? super Bundle> r101) {
            return this.f289778b.b(r100, r101);
        }

        private RealtimeCallStrategyDelegate() {
            IRealtimeCallStrategy r100 = (IRealtimeCallStrategy) ServiceManager.get().getService(IRealtimeCallStrategy.class);
            if (r100 != null) goto L5;
            r100 = new RealtimeCallStrategyNoop();
        L5:
            this.f289778b = r100;
        }
    }

    static {
        f289776a = RealtimeCallStrategyDelegate.f289777c;
    }

    Bundle a(e r100, Message r101);

    Object b(String r100, Continuation<? super Bundle> r101);
}
