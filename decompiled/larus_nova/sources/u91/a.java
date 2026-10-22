package u91;

import com.bytedance.android.livesdk.message.model.t;
import com.bytedance.android.livesdk.model.b1;
import kotlin.jvm.internal.Intrinsics;
import o91.b;
import tlc.d;
import w91.e;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f549198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f549199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f549200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b1 f549201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f549202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f549203f;

    /* JADX INFO: renamed from: u91.a$a, reason: collision with other inner class name */
    public static final class C7849a {
    }

    static {
    }

    public final int hashCode() {
        return this.f549203f.hashCode();
    }

    public final String toString() {
        return "UserInfoTabModel(tabType=" + this.f549203f + ", renderType=" + this.f549198a + ", isAnchor=" + this.f549199b + ", tabLine=" + this.f549200c + ')';
    }

    @Override // w91.e
    public final b getTabType() {
        return this.f549203f;
    }

    public a(b.n r100) {
        Intrinsics.checkNotNullParameter(r100, "tabType");
        this.f549203f = r100;
        this.f549200c = 1;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Long r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L34;
        a r103 = (a) r100;
        if ((!Intrinsics.areEqual(this.f549203f, r103.f549203f)) == false) goto L16;
        return false;
    L16:
        d r104 = this.f549202e;
        if ((r104 instanceof t) == true) goto L19;
        r104 = null;
    L19:
        t r105 = (t) r104;
        if (r105 == null) goto L22;
        Long r106 = Long.valueOf(r105.bizType);
    L23:
        d r107 = r103.f549202e;
        if ((r107 instanceof t) == true) goto L26;
        r107 = null;
    L26:
        t r108 = (t) r107;
        if (r108 == null) goto L30;
        r101 = Long.valueOf(r108.bizType);
    L30:
        if ((!Intrinsics.areEqual(r106, r101)) == false) goto L32;
        return false;
    L32:
        return true;
    L22:
        r106 = null;
        goto L23
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo_p.flipper.business.model.UserInfoTabModel");
    L8:
        r102 = null;
        goto L10
    }
}
