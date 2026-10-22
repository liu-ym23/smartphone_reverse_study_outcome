package xq2;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import cy0.i;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ld.f;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cy0.c f564796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cy0.b f564797b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        cy0.b r100 = this.f564797b;
        Intrinsics.checkNotNullParameter(r100, "livePlayScopeInstance");
        m.f163449e.getClass();
        i r101 = new i(m.f163448d);
        Intrinsics.checkNotNullParameter(r101, "scope");
        cy0.d r102 = new cy0.d();
        f r103 = r100.f465757a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f465758a = r103;
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "value");
        r101.f465764e = r102;
        if (r102 != k.f470908a) goto L8;
        String r105 = "linkDataScopeInstance";
    L9:
        if (r105 != null) goto L13;
        l.a(r101);
        this.f564796a = r101;
        return;
    L13:
        throw new UninitializedPropertyAccessException(r105);
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        cy0.c r100 = this.f564796a;
        if (r100 == null) goto L5;
        l.c(r100);
    L5:
        this.f564796a = null;
    }

    @Override // xq2.a
    public final cy0.c c0() {
        return this.f564796a;
    }

    public d(cy0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "livePlayScopeInstance");
        this.f564797b = r100;
    }
}
