package ub3;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f549349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f549350b;

    /* JADX INFO: renamed from: ub3.a$a, reason: collision with other inner class name */
    public static final class C7855a {
    }

    static {
    }

    public final Context getContext() {
        return this.f549350b;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f549350b = r100;
        com.bytedance.android.shopping.extensions.b.f(Integer.valueOf(eh.b.b(r100))).toString();
        this.f549349a = new LinkedHashMap();
    }
}
