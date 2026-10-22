package ij2;

import android.content.Context;
import android.util.LruCache;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends b> f490052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, a> f490053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f490054c;

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490054c = r100;
        this.f490052a = CollectionsKt.emptyList();
        this.f490053b = new LruCache(4);
    }
}
