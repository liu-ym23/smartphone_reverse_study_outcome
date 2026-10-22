package com.bytedance.android.livesdk.live.rerank;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final List<Room> a;
    public final List<Bundle> b;
    public final List<FeedItem> c;
    public FeedExtra d;

    public a() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public static List a(a r5) {
        r5.getClass();
        if (LiveInnerReRankUtils.b() == false) goto L30;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        ArrayList r1 = (ArrayList) r5.a;     // Catch: Throwable -> L19
        if (r1.size() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L22;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));     // Catch: Throwable -> L19
        Iterator r4 = r1.iterator();     // Catch: Throwable -> L19
    L15:
        if (r4.hasNext() == false) goto L17;
        r3.add(Long.valueOf(((Room) r4.next()).id));     // Catch: Throwable -> L19
        goto L15
    L17:
        ((ArrayList) r5.a).clear();     // Catch: Throwable -> L19
        ((ArrayList) r5.b).clear();     // Catch: Throwable -> L19
        ((ArrayList) r5.c).clear();     // Catch: Throwable -> L19
        LiveInnerReRankUtils.e("LiveInnerHideBucketCache getHideRoomIdList idList " + r3 + ' ');     // Catch: Throwable -> L19
        return r3;
    L22:
        return null;
    L8:
        r2 = false;
    L19:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L24;
        return null;
    L24:
        throw new KotlinNothingValueException();
    L30:
        return null;
    }

    public final void b(long r8) {
        if (LiveInnerReRankUtils.b() == true) goto L6;
        return;
    L6:
        if (((ArrayList) this.a).isEmpty() == false) goto L8;
        return;
    L8:
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r1 = -1;
        int r2 = 0;
    L10:
        if (r0.hasNext() == false) goto L18;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        if (r8 != ((Room) r3).id) goto L17;
        r1 = r2;
    L17:
        r2 = r4;
        goto L10
    L18:
        if (r1 < 0) goto L38;
        LiveInnerReRankUtils.e("LiveInnerHideBucketCache hitHideBucketDuplicateRemove roomId " + r8);
        List<Room> r9 = this.a;
        if (r1 < 0) goto L24;
        ArrayList r10 = (ArrayList) r9;
        if (r1 >= r10.size()) goto L24;
        ListProtector.remove(r10, r1);
    L24:
        List<Bundle> r11 = this.b;
        if (r1 < 0) goto L29;
        ArrayList r12 = (ArrayList) r11;
        if (r1 >= r12.size()) goto L29;
        ListProtector.remove(r12, r1);
    L29:
        List<FeedItem> r13 = this.c;
        if (r1 < 0) goto L39;
        ArrayList r14 = (ArrayList) r13;
        if (r1 >= r14.size()) goto L40;
        ListProtector.remove(r14, r1);
        return;
    L40:
        return;
    L39:
        return;
    }
}
