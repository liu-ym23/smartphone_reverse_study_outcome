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
public final class c implements o, dy0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f564794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f564795b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.android.livesdk.revenue.service.room.c r100 = this.f564795b;
        Intrinsics.checkNotNullParameter(r100, "roomService");
        m.f163449e.getClass();
        i r101 = new i(m.f163448d);
        Intrinsics.checkNotNullParameter(r101, "scope");
        cy0.d r102 = new cy0.d();
        f r103 = new f(r100.getDataCenter());
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f465758a = r103;
        Unit r104 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "value");
        r101.f465764e = r102;
        if (r102 != k.f470908a) goto L5;
        String r105 = "linkDataScopeInstance";
    L6:
        if (r105 != null) goto L10;
        l.a(r101);
        this.f564794a = r101;
        return;
    L10:
        throw new UninitializedPropertyAccessException(r105);
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        i r100 = this.f564794a;
        if (r100 == null) goto L5;
        l.c(r100);
    L5:
        this.f564794a = null;
    }

    public c(com.bytedance.android.livesdk.revenue.service.room.c r100) {
        Intrinsics.checkNotNullParameter(r100, "roomService");
        this.f564795b = r100;
    }
}
