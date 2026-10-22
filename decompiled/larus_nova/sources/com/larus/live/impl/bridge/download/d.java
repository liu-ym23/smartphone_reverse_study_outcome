package com.larus.live.impl.bridge.download;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d extends i66.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f355769e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f355770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f355771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f355772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f355773d;

    public static final class a {
        @JvmStatic
        public static Map a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r101 = new LinkedHashMap();
            Integer r102 = r100.f355770a;
            if (r102 == null) goto L5;
            r101.put("httpCode", Integer.valueOf(r102.intValue()));
        L5:
            String r103 = r100.f355773d;
            if (r103 == null) goto L8;
            r101.put("filePath", r103);
        L8:
            Map<String, ? extends Object> r104 = r100.f355772c;
            if (r104 == null) goto L11;
            r101.put("header", r104);
        L11:
            Integer r105 = r100.f355771b;
            if (r105 == null) goto L14;
            r101.put("clientCode", Integer.valueOf(r105.intValue()));
        L14:
            return r101;
        }
    }

    static {
    }

    public d() {
    }
}
