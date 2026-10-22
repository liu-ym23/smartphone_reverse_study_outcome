package o1c;

import com.ss.android.lark.preload.v2.condition.ConditionSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<?, ?> f521753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f521754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f521755c;

    public final c<?, ?> a() {
        c<?, ?> r100 = this.f521753a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("task");
        r100 = null;
    L6:
        Object r101 = this.f521754b;
        boolean r102 = this.f521755c;
        Intrinsics.checkNotNullParameter(r100, "task");
        ConditionSet r103 = new ConditionSet();
        r103.a(new j1c.a());
        r103.a(new j1c.c());
        r103.a(new j1c.b());
        r100.L(r103);
        r100.N0(r102);
        if (r102 == false) goto L9;
        ConditionSet r104 = new ConditionSet();
        r104.a(new h1c.b());
        r100.o0(r104);
    L10:
        r100.e1(new ConditionSet());
        r100.b0(null);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.task.ITask<kotlin.Any?, kotlin.Any?>");
        r100.h1(r101);
        r100.y0(0);
        return r100;
    L9:
        r100.o0(new ConditionSet());
        goto L10
    }

    public e() {
        this.f521755c = true;
    }
}
