package gn8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.search.vm.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f481829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f481830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f481831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f481832d;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f481829a = r100;
        this.f481830b = LazyKt.lazy(new a());
        this.f481831c = LazyKt.lazy(new b(this));
    }
}
