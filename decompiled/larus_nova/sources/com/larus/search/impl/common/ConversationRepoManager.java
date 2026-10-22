package com.larus.search.impl.common;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class ConversationRepoManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConversationRepoManager f367620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IConversationRepoService f367621b = null;

    public ConversationRepoManager() {
    }

    static {
        f367620a = new ConversationRepoManager();
        f367621b = RepoDispatcherDelegate.f307737b.f();
    }

    public static Object a(RecommendBot r110, Continuation r111) {
        IConversationRepoService r100 = f367621b;
        String r112 = r110.o();
        if (r112 != null) goto L5;
        r112 = "";
    L5:
        Object r113 = IConversationRepoService.a.a(r100, r112, 2, null, null, false, null, null, null, null, r111, 508);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r113;
    L9:
        return Unit.INSTANCE;
    }

    public static Object c(String r100, ContinuationImpl r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ConversationRepoManager$findChatConversationByBot$2(r100, null), r101);
    }

    public static Object d(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getMain(), new ConversationRepoManager$findConversationByBot$2(r100, null), r101);
    }

    public static Object f(RecommendBot r100, Continuation r101) {
        IConversationRepoService r102 = f367621b;
        String r103 = r100.E();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Object r104 = r102.s(r103, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r104;
    L9:
        return Unit.INSTANCE;
    }

    public final Object b(RecommendBot r100, Continuation<? super String> r101) {
        if ((r101 instanceof ConversationRepoManager$createLocalConversation$1) == false) goto L7;
        ConversationRepoManager$createLocalConversation$1 r102 = (ConversationRepoManager$createLocalConversation$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L23:
        String r107 = (String) r104;
        if (r107 != null) goto L27;
        return "";
    L27:
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100.j0() == true) goto L17;
    L19:
        Map<String, String> r108 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
    L20:
        IConversationRepoService r109 = f367621b;
        r102.label = 1;
        r104 = r109.u(r100, r108, r102);
        if (r104 != r105) goto L23;
        return r105;
    L17:
        if (r100.o0() == true) goto L19;
        r108 = MapsKt.emptyMap();
    L7:
        r102 = new ConversationRepoManager$createLocalConversation$1(this, r101);
        goto L8
    }

    public static Object e(String r100, String r101, Continuation r102) {
        Object r103 = f367621b.l(r100, ConversationDeleteMode.DeleteMode_RealDelete, r101, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public static Object g(String r100, RecommendBot r101, ContinuationImpl r102) {
        Object r103 = BuildersKt.withContext(Dispatchers.getIO(), new ConversationRepoManager$updateLocalConversationFirstMet$2(r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }
}
