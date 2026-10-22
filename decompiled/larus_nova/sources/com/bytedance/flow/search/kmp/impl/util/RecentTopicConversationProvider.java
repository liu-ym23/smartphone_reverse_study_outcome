package com.bytedance.flow.search.kmp.impl.util;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.platform.spi.IAIChatConversationService;
import ic8.n;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class RecentTopicConversationProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RecentTopicConversationProvider f243662a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((gr9.b) r101).f482404c), Long.valueOf(((gr9.b) r100).f482404c));
        }
    }

    static {
        f243662a = new RecentTopicConversationProvider();
    }

    public RecentTopicConversationProvider() {
    }

    public final Object a(Continuation<? super List<gr9.b>> r100) {
        if ((r100 instanceof RecentTopicConversationProvider$fetchSubConversationList$1) == false) goto L7;
        RecentTopicConversationProvider$fetchSubConversationList$1 r101 = (RecentTopicConversationProvider$fetchSubConversationList$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        List r106 = (List) r103;
        if (r106 == null) goto L22;
        return r106;
    L22:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IAIChatConversationService.Companion r107 = IAIChatConversationService.f365892a;
        List<gr9.b> r108 = r107.d();
        if (r108 != null) goto L23;
        r101.label = 1;
        r103 = r107.c(r101);
        if (r103 != r104) goto L19;
        return r104;
    L23:
        return r108;
    L7:
        r101 = new RecentTopicConversationProvider$fetchSubConversationList$1(this, r100);
        goto L8
    }

    public final Object b(String r110, Continuation<? super List<e>> r111) {
        if ((r111 instanceof RecentTopicConversationProvider$getMainBotSubConversations$1) == false) goto L7;
        RecentTopicConversationProvider$getMainBotSubConversations$1 r100 = (RecentTopicConversationProvider$getMainBotSubConversations$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L26:
        ArrayList r104 = new ArrayList();
        Iterator r113 = ((List) r112).iterator();
    L28:
        if (r113.hasNext() == false) goto L32;
        Object r105 = r113.next();
        if ((!Intrinsics.areEqual(((gr9.b) r105).f482402a, r110)) == false) goto L28;
        r104.add(r105);
        goto L28
    L32:
        List r114 = CollectionsKt.sortedWith(r104, new a());
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
    L34:
        if (r116.hasNext() == false) goto L36;
        gr9.b r106 = (gr9.b) r116.next();
        r115.add(new e(r106.f482402a, r106.f482403b, r106.f482404c, RangesKt.coerceAtLeast(r106.f482406e - r106.f482407f, 0)));
        goto L34
    L36:
        return r115;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L20:
        if (n.v((wc9.e) r112) == false) goto L22;
        r100.L$0 = r110;
        r100.label = 2;
        r112 = a(r100);
        if (r112 != r102) goto L26;
        return r102;
    L22:
        return CollectionsKt.emptyList();
    L16:
        ResultKt.throwOnFailure(r112);
        IConversationRepoService r107 = RepoDispatcherDelegate.f307737b.f();
        r100.L$0 = r110;
        r100.label = 1;
        r112 = IConversationRepoService.a.c(r107, r110, false, null, r100, 6);
        if (r112 != r102) goto L20;
        return r102;
    L7:
        r100 = new RecentTopicConversationProvider$getMainBotSubConversations$1(this, r111);
        goto L8
    }
}
