package vo;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.window.base.dynamicview.common.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<V extends View> implements vo.a<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Context, V> f556478a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super Context, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "maker");
        this.f556478a = r100;
    }

    public final V a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r101 = System.currentTimeMillis();
        V r102 = this.f556478a.invoke(r100);
        boolean r103 = c.f49250a;
        if (c.f49250a == true) goto L6;
        StringBuilder r104 = new StringBuilder("make view by ");
        r104.append(this.f556478a);
        r104.append(", cost ");
        r104.append(System.currentTimeMillis() - r101);
    L6:
        return r102;
    }

    @Override // vo.a
    public final /* bridge */ /* synthetic */ Object c(Context r100) {
        return a(r100);
    }
}
