package ek8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.computerusetool.view.ComputerUseToolResultView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f472947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f472948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ComputerUseToolResultView f472949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oj8.c f472950d;

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f472947a = r100;
        this.f472948b = LazyKt.lazy(new a());
    }
}
