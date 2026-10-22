package qj;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f533273e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f533275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f533276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f533277d;

    public static final class a {
    }

    static {
        new c(new LinkedHashMap(), new LinkedHashMap());
    }

    public c(Map r100, Map r101) {
        Intrinsics.checkNotNullParameter("", "cardName");
        Intrinsics.checkNotNullParameter("", "cardId");
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r101, "sliceData");
        this.f533274a = "";
        this.f533275b = "";
        this.f533276c = r100;
        this.f533277d = r101;
    }
}
