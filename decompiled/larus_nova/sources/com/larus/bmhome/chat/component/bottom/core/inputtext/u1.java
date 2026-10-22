package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f299238a = 0;

    static {
    }

    public static List a(String r100, String r101) {
        List r102 = CollectionsKt.createListBuilder();
        int r103 = StringsKt.indexOf$default(r100, r101, 0, true, 2, null);
    L3:
        if (r103 < 0) goto L6;
        int r104 = r101.length() + r103;
        r102.add(new n1(r103, r104));
        r103 = StringsKt.indexOf(r100, r101, r104, true);
        goto L3
    L6:
        return CollectionsKt.build(r102);
    }

    public static List c(p1 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "index");
        Intrinsics.checkNotNullParameter(r101, "query");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        List r103 = a(r100.f299016a, r101);
        if ((true ^ r103.isEmpty()) == false) goto L12;
        return r103;
    L12:
        String r104 = r101.toLowerCase(Locale.ROOT);
        List r105 = b(r100.f299017b, r104, r100.f299018c);
        if (((ArrayList) r105).isEmpty() == true) goto L15;
        return r105;
    L15:
        return b(r100.f299019d, r104, r100.f299020e);
    L8:
        return CollectionsKt.emptyList();
    L5:
        r102 = false;
        goto L6
    }

    public static List b(String r100, String r101, List r102) {
        ArrayList r103 = new ArrayList();
        Iterator r104 = a(r100, r101).iterator();
    L4:
        if (r104.hasNext() == false) goto L14;
        n1 r105 = (n1) r104.next();
        int r106 = r105.f299006a;
        int r107 = r105.f299007b;
    L6:
        if (r106 >= r107) goto L4;
        n1 r108 = (n1) ListProtector.get(r102, r106);
        n1 r109 = (n1) CollectionsKt.lastOrNull(r103);
        if (r109 != null) goto L10;
    L12:
        r103.add(r108);
    L13:
        r106 = r106 + 1;
        goto L6
    L10:
        if (r108.f299006a > r109.f299007b) goto L12;
        int r110 = CollectionsKt.getLastIndex(r103);
        int r111 = Math.max(r109.f299007b, r108.f299007b);
        ListProtector.set(r103, r110, new n1(r109.f299006a, r111));
        goto L13
    L14:
        return r103;
    }
}
