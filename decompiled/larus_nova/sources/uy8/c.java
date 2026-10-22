package uy8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f552157a = null;

    static {
        new JSONArray();
        new JSONArray();
        f552157a = SetsKt.setOf(new String[]{"attachment_panel", "camera_album"});
    }

    public static final Set<String> a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length();
        ArrayList r102 = new ArrayList(r101);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102.add(r100.opt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        Intrinsics.checkNotNullParameter(r102, "values");
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if ((r106 instanceof String) == false) goto L7;
        r104.add(r106);
        goto L7
    L12:
        return CollectionsKt.toSet(CollectionsKt.toCollection(r104, new LinkedHashSet()));
    }
}
