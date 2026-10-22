package ky3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements c {
    public CopyOnWriteArrayList<o14.a> a;
    public List<o14.a> b;

    public a() {
    }

    public final void c() {
        if (this.a != null) goto L6;
        this.a = new CopyOnWriteArrayList();
    L6:
        if (this.b != null) goto L9;
        this.b = new ArrayList();
        return;
    }

    @Override // ky3.c
    public final List<o14.a> a(b r6) {
        Intrinsics.checkNotNullParameter(r6, "commentReplyButton");
        CopyOnWriteArrayList<o14.a> r0 = this.a;
        if (r0 == null) goto L18;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((o14.a) r2).cid, r6.d) == false) goto L6;
    L11:
        o14.a r3 = (o14.a) r2;
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.replyComments;
    L10:
        r2 = null;
        goto L11
    L18:
        return null;
    }

    public final void b(List<? extends o14.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "comments");
        CopyOnWriteArrayList<o14.a> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        List<o14.a> r1 = this.b;
        if (r1 != null) goto L8;
        return;
    L8:
        Iterator<? extends o14.a> r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L23;
        o14.a r2 = r11.next();
        r2.a = 1;
        if (r0.contains(r2) == true) goto L10;
        r0.add(r2);
        ArrayList r3 = (ArrayList) r1;
        r3.add(r2);
        List r4 = r2.replyComments;
        if (r4 != null) goto L16;
        r4 = CollectionsKt.emptyList();
    L16:
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L21;
        o14.a r6 = (o14.a) r5.next();
        r6.a = 2;
        r3.add(r6);
        goto L18
    L21:
        if ((r2.replyCommentTotal - ((long) r4.size())) <= 0) goto L10;
        r3.add(new b(r2));
        goto L10
    }

    public final Pair<Integer, Integer> d(b r10) {
        List<o14.a> r0 = this.b;
        boolean r1 = false;
        int r2 = -1;
        if (r0 == null) goto L20;
        Iterator<T> r3 = r0.iterator();
        int r4 = -1;
        int r5 = 0;
    L6:
        if (r3.hasNext() == false) goto L21;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        o14.a r8 = (o14.a) r6;
        if (r2 < 0) goto L13;
    L15:
        if (r4 >= 0) goto L19;
        if (Intrinsics.areEqual(r8.cid, ((o14.a) r10).cid) == false) goto L19;
        r4 = r5;
    L19:
        r5 = r7;
        goto L6
    L13:
        if (Intrinsics.areEqual(r8.cid, r10.d) == false) goto L15;
        r2 = r5;
    L21:
        if (r2 < 0) goto L24;
        if (r2 >= r4) goto L24;
        r1 = true;
    L24:
        if (r1 == true) goto L32;
        return null;
    L32:
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r4));
    L20:
        r4 = -1;
        goto L21
    }
}
