package g0c;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.impl.v2.action.g;
import com.ss.android.lark.passportc.internal.g0;
import com.ss.android.lark.passportc.internal.y;
import com.ss.android.lark.passportc.task.d;
import com.ss.android.lark.passportc.task.j;
import e0c.l;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f479527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.task.g f479528b;

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final List<j0c.b> f() {
        return this.f479528b.f();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final List<j0c.b> g() {
        return this.f479528b.g();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final void a(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f479527a.a(r100);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final Set<com.ss.android.lark.passportc.task.c> b(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        l r101 = this.f479527a.g(r100);
        if (r101 == null) goto L7;
        Set<com.ss.android.lark.passportc.task.c> r102 = ((j) r101).g();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final Set<d> c(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        l r101 = this.f479527a.g(r100);
        if (r101 == null) goto L7;
        Set<d> r102 = ((j) r101).R();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return SetsKt.emptySet();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.action.m
    public final void e(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "userDelegate");
        this.f479527a.i(r100);
    }

    @Inject
    public a(y r100, com.ss.android.lark.passportc.task.g r101) {
        Intrinsics.checkNotNullParameter(r100, "userComponentManager");
        Intrinsics.checkNotNullParameter(r101, "taskOrder");
        this.f479527a = r100;
        this.f479528b = r101;
    }
}
