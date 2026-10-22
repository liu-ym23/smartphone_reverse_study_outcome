package com.larus.bmhome.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes26.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f315096a = 0;

    static {
    }

    public static int b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Regex r101 = new Regex("\\s|[一-鿿。、《》【】「」]");
        ArrayList r102 = new ArrayList();
        Iterator r103 = Regex.findAll$default(r101, r100, 0, 2, null).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L13;
        MatchResult r105 = (MatchResult) r103.next();
        String r106 = r100.substring(r104, r105.getRange().getFirst());
        if (r106.length() <= 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L11;
        a(r102, r106);
    L11:
        a(r102, r105.getValue());
        r104 = r105.getRange().getLast() + 1;
        goto L4
    L8:
        r107 = false;
        goto L9
    L13:
        if (r104 >= r100.length()) goto L16;
        a(r102, r100.substring(r104));
    L16:
        return r102.size();
    }

    public static void a(List r100, String r101) {
        if (new Regex("\\s|——").matches(r101) == true) goto L6;
        ((ArrayList) r100).add(r101);
        return;
    }
}
