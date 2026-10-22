package hs2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f486951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f486952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f486953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486954d;

    public static final class a {
    }

    static {
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        this.f486954d = r100;
        this.f486951a = new ConcurrentHashMap();
    }
}
