package com.larus.bmhome.chat.thinkmode;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/IThinkModeMemoryReportService;", "", "report", "", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "behaviorSource", "Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;", "conversationSource", "Lcom/larus/bmhome/chat/thinkmode/ConversationSource;", "agentMode", "", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;Lcom/larus/bmhome/chat/thinkmode/ConversationSource;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IThinkModeMemoryReportService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f309973a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f309974a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<IThinkModeMemoryReportService> f309975b = null;

        public Companion() {
        }

        static {
            f309974a = new Companion();
            f309975b = LazyKt.lazy(new a());
        }

        public final Object a(ReplyOption r100, BehaviorSource r110, ConversationSource r111, Integer r112, Continuation<? super Boolean> r113) {
            if ((r113 instanceof IThinkModeMemoryReportService$Companion$report$1) == false) goto L7;
            IThinkModeMemoryReportService$Companion$report$1 r101 = (IThinkModeMemoryReportService$Companion$report$1) r113;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            IThinkModeMemoryReportService$Companion$report$1 r103 = r101;
            Object r114 = r103.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r103.label;
            if (r105 == 0) goto L18;
            if (r105 != 1) goto L17;
            r111 = (ConversationSource) r103.L$1;
            r110 = (BehaviorSource) r103.L$0;
            ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L14
        L28:
            boolean r106 = ((Boolean) r114).booleanValue();     // Catch: Throwable -> L14
        L30:
            Object r107 = Result.m9449constructorimpl(Boxing.boxBoolean(r106));     // Catch: Throwable -> L14
        L33:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r107);
            if (r115 == null) goto L36;
            FLogger.f375446a.w("ThinkModeMemoryReport", "think mode memory report failed, source=" + r110 + ", conversationSource=" + r111, r115);
        L36:
            Boolean r116 = Boxing.boxBoolean(false);
            if (Result.m9455isFailureimpl(r107) == true) goto L39;
            return r107;
        L39:
            return r116;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r114);
            if (r110 == BehaviorSource.UNKNOWN) goto L41;
            if (r111 == ConversationSource.UNKNOWN) goto L41;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L14
            IThinkModeMemoryReportService r108 = f309975b.getValue();     // Catch: Throwable -> L14
            if (r108 == null) goto L29;
            r103.L$0 = r110;     // Catch: Throwable -> L14
            r103.L$1 = r111;     // Catch: Throwable -> L14
            r103.label = 1;     // Catch: Throwable -> L14
            r114 = r108.a(r100, r110, r111, r112, r103);     // Catch: Throwable -> L14
            if (r114 != r104) goto L28;
            return r104;
        L29:
            r106 = false;
        L41:
            return Boxing.boxBoolean(false);
        L14:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L7:
            r101 = new IThinkModeMemoryReportService$Companion$report$1(this, r113);
            goto L8
        }
    }

    static {
        f309973a = Companion.f309974a;
    }

    Object a(ReplyOption r100, BehaviorSource r101, ConversationSource r102, Integer r103, Continuation<? super Boolean> r104);
}
