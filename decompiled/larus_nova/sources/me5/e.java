package me5;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends i66.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f513487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f513488b;

    public static final class a {
        @JvmStatic
        public static Map a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            LinkedHashMap r101 = new LinkedHashMap();
            Boolean r102 = r100.f513487a;
            if (r102 == null) goto L5;
            r101.put("isConnected", Boolean.valueOf(r102.booleanValue()));
        L5:
            Integer r103 = r100.getType();
            if (r103 == null) goto L8;
            r101.put("type", Integer.valueOf(r103.intValue()));
        L8:
            return r101;
        }
    }

    static {
    }

    public e() {
    }

    public final Integer getType() {
        return this.f513488b;
    }
}
