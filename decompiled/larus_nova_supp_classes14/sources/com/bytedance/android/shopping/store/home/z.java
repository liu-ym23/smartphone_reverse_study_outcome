package com.bytedance.android.shopping.store.home;

import android.graphics.Rect;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z extends mn.d {

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Rect r4 = ((ln.c) r2).r();
            int r0 = Integer.MIN_VALUE;
            if (r4 == null) goto L5;
            int r5 = r4.top;
        L6:
            Integer r6 = Integer.valueOf(r5);
            Rect r7 = ((ln.c) r3).r();
            if (r7 == null) goto L10;
            r0 = r7.top;
        L10:
            return ComparisonsKt.compareValues(r6, Integer.valueOf(r0));
        L5:
            r5 = Integer.MIN_VALUE;
            goto L6
        }
    }

    public z() {
    }

    public static ln.c e(List r4) {
        Intrinsics.checkNotNullParameter(r4, "items");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Object r0 = r5.next();
        ln.c r1 = (ln.c) r0;
        Intrinsics.checkNotNullParameter(r1, "$this$isImageOrVideo");
        if (r1.P() != PlayAbleType.MAIN_IMAGE) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L4;
    L16:
        return (ln.c) r0;
    L8:
        if (r1.P() == PlayAbleType.VIDEO) goto L11;
        r2 = false;
        goto L12
    L14:
        r0 = null;
        goto L16
    }

    public final void d(List<ln.c> r9, com.bytedance.android.ec.store.utils.playable.controller.a r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r9, "itemsToPlay");
        Intrinsics.checkNotNullParameter(r10, "mgr");
        Intrinsics.checkNotNullParameter(r11, "area");
        if (e(r9) != null) goto L10;
        ln.c r12 = mn.d.c(r11, r10);
        if (r12 == null) goto L10;
        if (r9.contains(r12) == false) goto L10;
        r9.remove(r12);
        ListProtector.add(r9, 0, r12);
    L10:
        if (r9.size() <= 1) goto L12;
        CollectionsKt.sortWith(r9, new a());
    L12:
        ln.c r13 = e(r9);
        List r2 = r10.a();
        Intrinsics.checkNotNullParameter(r2, "items");
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L29;
        Object r4 = r3.next();
        ln.c r5 = (ln.c) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$isImageOrVideo");
        if (r5.P() != PlayAbleType.MAIN_IMAGE) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == true) goto L24;
    L26:
        boolean r7 = false;
    L27:
        if (r7 == false) goto L14;
    L30:
        List r1 = CollectionsKt.emptyList();
        if ((true ^ Intrinsics.areEqual(r13, (ln.c) r4)) == true) goto L40;
        if (r13 == null) goto L40;
        if (r13.isPlaying() == true) goto L38;
        r13 = null;
    L38:
        if (r13 == null) goto L41;
        r1 = CollectionsKt.listOf(r13);
    L41:
        dm.a.a("测试播放范围").a("itemsToPlay个数:" + r9.size() + ",选择一个开始播放");
        r10.e(r9, r1);
        return;
    L40:
        dm.a.a("测试播放范围").a("当前在播的卡与接下来需要播的第一个卡不是同一个,停止当前播放");
        r10.f();
        goto L41
    L24:
        if (r5.isPlaying() == false) goto L26;
        r7 = true;
        goto L27
    L18:
        if (r5.P() == PlayAbleType.VIDEO) goto L21;
        r6 = false;
        goto L22
    L29:
        r4 = null;
        goto L30
    }
}
