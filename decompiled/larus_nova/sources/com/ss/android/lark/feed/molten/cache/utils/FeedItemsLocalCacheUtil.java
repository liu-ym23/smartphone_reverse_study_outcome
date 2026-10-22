package com.ss.android.lark.feed.molten.cache.utils;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedItemsLocalCacheUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421056a = 0;

    static {
    }

    public static List a(List r110) {
        Intrinsics.checkNotNullParameter(r110, "latestItems");
        List r111 = SequencesKt.toList(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(r110), FeedItemsLocalCacheUtil$normalizeHumanSidebarSnapshot$distinctItems$1.INSTANCE), FeedItemsLocalCacheUtil$normalizeHumanSidebarSnapshot$distinctItems$2.INSTANCE));
        ArrayList r100 = new ArrayList();
        Iterator r101 = r111.iterator();
    L3:
        boolean r102 = true;
        if (r101.hasNext() == false) goto L11;
        Object r103 = r101.next();
        if (((UIFeedCard) r103).getOnTopRankTime() > 0) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L3;
        r100.add(r103);
        goto L3
    L11:
        ArrayList r104 = new ArrayList();
        Iterator r112 = r111.iterator();
    L13:
        if (r112.hasNext() == false) goto L21;
        Object r105 = r112.next();
        if (((UIFeedCard) r105).getOnTopRankTime() > 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L13;
        r104.add(r105);
        goto L13
    L17:
        r106 = false;
        goto L18
    L21:
        return CollectionsKt.plus(r100, CollectionsKt.take(r104, RangesKt.coerceAtLeast(20, 0)));
    }

    public static List b(List r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "latestItems");
        return SequencesKt.toList(SequencesKt.take(SequencesKt.distinctBy(SequencesKt.filter(CollectionsKt.asSequence(r100), FeedItemsLocalCacheUtil$normalizeSnapshot$1.INSTANCE), FeedItemsLocalCacheUtil$normalizeSnapshot$2.INSTANCE), r101));
    }
}
