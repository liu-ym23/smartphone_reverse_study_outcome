package jyb;

import com.ss.android.lark.optrace.core.b;
import com.ss.android.lark.optrace.impl.TracingSpanImpl;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes37.dex */
@Deprecated(message = "this is deprecated,use OPTraceService")
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f501069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f501070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static TracingSpanImpl f501071c;

    public a() {
        f501071c = new TracingSpanImpl(null);
        f501070b = new b();
    }
}
