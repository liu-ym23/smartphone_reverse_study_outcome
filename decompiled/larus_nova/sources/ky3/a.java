package ky3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<o14.a> f506624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<o14.a> f506625b;

    public a() {
    }

    public final void c() {
        if (this.f506624a != null) goto L6;
        this.f506624a = new CopyOnWriteArrayList();
    L6:
        if (this.f506625b != null) goto L9;
        this.f506625b = new ArrayList();
        return;
    }

    @Override // ky3.c
    public final List<o14.a> a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "commentReplyButton");
        CopyOnWriteArrayList<o14.a> r101 = this.f506624a;
        if (r101 == null) goto L18;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((o14.a) r103).cid, r100.f506626d) == false) goto L6;
    L11:
        o14.a r104 = (o14.a) r103;
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.replyComments;
    L10:
        r103 = null;
        goto L11
    L18:
        return null;
    }

    public final void b(List<? extends o14.a> r110) {
        Intrinsics.checkNotNullParameter(r110, "comments");
        CopyOnWriteArrayList<o14.a> r100 = this.f506624a;
        if (r100 != null) goto L5;
        return;
    L5:
        List<o14.a> r101 = this.f506625b;
        if (r101 != null) goto L8;
        return;
    L8:
        Iterator<? extends o14.a> r111 = r110.iterator();
    L10:
        if (r111.hasNext() == false) goto L23;
        o14.a r102 = r111.next();
        r102.f521700a = 1;
        if (r100.contains(r102) == true) goto L10;
        r100.add(r102);
        ArrayList r103 = (ArrayList) r101;
        r103.add(r102);
        List<o14.a> r104 = r102.replyComments;
        if (r104 != null) goto L16;
        r104 = CollectionsKt.emptyList();
    L16:
        Iterator<o14.a> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L21;
        o14.a r106 = r105.next();
        r106.f521700a = 2;
        r103.add(r106);
        goto L18
    L21:
        if ((r102.replyCommentTotal - ((long) r104.size())) <= 0) goto L10;
        r103.add(new b(r102));
        goto L10
    }

    public final Pair<Integer, Integer> d(b r110) {
        List<o14.a> r100 = this.f506625b;
        boolean r101 = false;
        int r102 = -1;
        if (r100 == null) goto L20;
        Iterator<T> r103 = r100.iterator();
        int r104 = -1;
        int r105 = 0;
    L6:
        if (r103.hasNext() == false) goto L21;
        Object r106 = r103.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        o14.a r108 = (o14.a) r106;
        if (r102 < 0) goto L13;
    L15:
        if (r104 >= 0) goto L19;
        if (Intrinsics.areEqual(r108.cid, r110.cid) == false) goto L19;
        r104 = r105;
    L19:
        r105 = r107;
        goto L6
    L13:
        if (Intrinsics.areEqual(r108.cid, r110.f506626d) == false) goto L15;
        r102 = r105;
    L21:
        if (r102 < 0) goto L24;
        if (r102 >= r104) goto L24;
        r101 = true;
    L24:
        if (r101 == true) goto L32;
        return null;
    L32:
        return new Pair(Integer.valueOf(r102), Integer.valueOf(r104));
    L20:
        r104 = -1;
        goto L21
    }
}
