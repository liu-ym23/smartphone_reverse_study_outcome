package com.bytedance.locallife.biz.prefetch.newsdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f256941a = 0;

    public static final class a {
        public static String a(Map r100, String r101, Set r102) {
            Intrinsics.checkNotNullParameter(r100, "requestParams");
            Intrinsics.checkNotNullParameter(r101, "matchMod");
            Intrinsics.checkNotNullParameter(r102, "matchRule");
            StringBuilder r103 = new StringBuilder();
            if (Intrinsics.areEqual(r101, "EXCLUDE_MATCHES") == false) goto L12;
            TreeMap r104 = (TreeMap) r100;
            Iterator r105 = r104.keySet().iterator();
        L6:
            if (r105.hasNext() == false) goto L32;
            String r106 = (String) r105.next();
            if (r102.contains(r106) == true) goto L6;
            r103.append(r106 + com.alipay.sdk.m.n.a.f25612h + r104.get(r106));
            goto L6
        L32:
            return r103.toString();
        L12:
            if (Intrinsics.areEqual(r101, "PARTIAL_MATCHES") == false) goto L21;
            TreeMap r107 = (TreeMap) r100;
            Iterator r108 = r107.keySet().iterator();
        L15:
            if (r108.hasNext() == false) goto L33;
            String r109 = (String) r108.next();
            if (r102.contains(r109) == false) goto L15;
            r103.append(r109 + com.alipay.sdk.m.n.a.f25612h + r107.get(r109));
            goto L15
        L33:
            return r103.toString();
        L21:
            return r100.toString();
        }
    }

    static {
    }
}
