package np1;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner f520013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner<Boolean> f520014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner f520015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner<String> f520016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner f520017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner<Unit> f520018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner f520019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f520020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f520021k;

    @Override // np1.a
    public final d<? extends a> a() {
        return null;
    }

    @Override // np1.a
    public final c c() {
        return this.f520020j;
    }

    @Override // np1.a
    public int getType() {
        return this.f520012b;
    }

    public /* synthetic */ f(c r100, String r101, Boolean r102) {
        this(r100, r101, false, "", r102);
    }

    public f(c r100, String r101, boolean r102, String r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        Intrinsics.checkNotNullParameter(r101, "initTitle");
        this.f520020j = r100;
        this.f520021k = r102;
        this.f520012b = 1;
        this.f520013c = new PropertyOwner(r101);
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        PropertyOwner<Boolean> r106 = new PropertyOwner(Boolean.valueOf(r105));
        this.f520014d = r106;
        this.f520015e = r106;
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        PropertyOwner<String> r107 = new PropertyOwner(r103);
        this.f520016f = r107;
        this.f520017g = r107;
        PropertyOwner<Unit> r108 = new PropertyOwner(Unit.INSTANCE);
        this.f520018h = r108;
        this.f520019i = r108;
        return;
    L5:
        r105 = false;
        goto L6
    }
}
