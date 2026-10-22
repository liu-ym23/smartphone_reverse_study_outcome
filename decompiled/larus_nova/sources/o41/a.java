package o41;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import cy0.c;
import cy0.f;
import dy0.d;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import o11.b;
import yz0.g;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f521943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xq2.b f521944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f521945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f521946d;

    /* JADX INFO: renamed from: o41.a$a, reason: collision with other inner class name */
    public static final class C7010a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        jy0.b.d("LinkScopeProvideService", "onStart, create link scope");
        jy0.b.d("LinkScopeProvideService", "roomDataService = " + this.f521946d.hashCode() + ", roomId = " + IRoomKtKt.getId(this.f521946d.getRoom()));
        c r100 = this.f521944b.c0();
        if (r100 != null) goto L5;
        return;
    L5:
        f r101 = this.f521945c;
        Intrinsics.checkNotNullParameter(r101, "instanceScope");
        String r102 = "linkDataScope";
        Intrinsics.checkNotNullParameter(r100, "linkDataScope");
        b r103 = new b(r101);
        Intrinsics.checkNotNullParameter(r103, "scope");
        Intrinsics.checkNotNullParameter(r100, "value");
        r103.f521691e = r100;
        Object r104 = k.f470908a;
        if (r100 != r104) goto L9;
    L18:
        if (r102 != null) goto L22;
        l.a(r103);
        this.f521943a = r103;
        return;
    L22:
        throw new UninitializedPropertyAccessException(r102);
    L9:
        if (r103.f521692f != r104) goto L12;
        r102 = "revenueInstance";
        goto L18
    L12:
        if (r103.f521693g != r104) goto L15;
        r102 = "revenueInstanceExt";
        goto L18
    L15:
        if (r103.f521694h != r104) goto L17;
        r102 = "roomInstance";
        goto L18
    L17:
        r102 = null;
        goto L18
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        jy0.b.d("LinkScopeProvideService", "onStop, leave link scope");
        jy0.b.d("LinkScopeProvideService", "roomDataService = " + this.f521946d.hashCode() + ", roomId = " + IRoomKtKt.getId(this.f521946d.getRoom()));
        this.f521943a = null;
    }

    public a(xq2.b r100, f r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "revenueDataScopeProviderService");
        Intrinsics.checkNotNullParameter(r101, "instanceScope");
        Intrinsics.checkNotNullParameter(r102, "roomDataService");
        this.f521944b = r100;
        this.f521945c = r101;
        this.f521946d = r102;
    }
}
