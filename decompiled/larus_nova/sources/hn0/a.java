package hn0;

import bn0.c;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements o, bn0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f486062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u60.a f486063b;

    /* JADX INFO: renamed from: hn0.a$a, reason: collision with other inner class name */
    public static final class C6173a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f486062a = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        String r100 = null;
        jy0.b.c("MultiLinkScopeProvider", "onStart: ", null, 4);
        c r101 = new c(this.f486063b);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Object r102 = k.f470908a;
        if (r101.f19700e != r102) goto L5;
        r100 = "roomInstance";
    L5:
        if (r100 != null) goto L9;
        l.a(r101);
        Unit r103 = Unit.INSTANCE;
        this.f486062a = r101;
        return;
    L9:
        throw new UninitializedPropertyAccessException(r100);
    }

    @Override // bn0.a
    public final bn0.b getMultiLinkRoomScope() {
        return this.f486062a;
    }

    public a(u60.a r100) {
        Intrinsics.checkNotNullParameter(r100, "instScope");
        this.f486063b = r100;
    }
}
