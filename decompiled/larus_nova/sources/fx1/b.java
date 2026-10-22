package fx1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f479097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f479098b;

    public b(c r100, Function0 r101) {
        this.f479097a = r100;
        this.f479098b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f479097a.d("首帧状态回调：" + r101, new Pair[0]);
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L6;
        this.f479098b.invoke();
        return;
    }
}
