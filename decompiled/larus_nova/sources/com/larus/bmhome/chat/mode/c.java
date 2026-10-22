package com.larus.bmhome.chat.mode;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f307371a = 0;

    static {
    }

    public static String a(ModelItemIdentity r100, List r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L16;
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((b2) r104).b(), r100) == false) goto L8;
    L13:
        b2 r105 = (b2) r104;
        if (r105 == null) goto L16;
        List<String> r106 = r105.f295010q;
    L17:
        List<String> r107 = r106;
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == false) goto L26;
        return null;
    L26:
        if (r102 == null) goto L31;
        if (r106.contains(r102) == false) goto L31;
        return null;
    L31:
        return (String) CollectionsKt.firstOrNull(r106);
    L20:
        if (r107.isEmpty() == true) goto L23;
        r108 = false;
        goto L24
    L12:
        r104 = null;
    L16:
        r106 = null;
        goto L17
    }
}
