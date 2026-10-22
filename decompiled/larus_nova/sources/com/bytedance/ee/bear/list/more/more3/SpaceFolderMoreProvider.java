package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;
import uc5.t0;

/* JADX INFO: loaded from: classes18.dex */
public final class SpaceFolderMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Document f228716m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f228717n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SpaceMoreItemFactory f228718o;

    public static final class a {
    }

    public final class b extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SpaceFolderMoreProvider f228719c;

        @Override // com.bytedance.ee.bear.more.protocol3.extension.u
        public final void a() {
            tt5.a.h("SpaceFolderMoreProvider", "create.");
            int r100 = t.f228796a;
            SpaceFolderMoreProvider r101 = this.f228719c;
            e(t.a(r101.f228716m, r101.f228717n, r101.f228718o.p()));
            jg5.j r102 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
            String r103 = this.f228719c.f228716m.f227873d;
            Document r104 = this.f228719c.f228716m;
            b(r102.f(r103, new FolderVersion(r104.L1, r104.T, r104.P1), this.f228719c.f228716m.f227889n).subscribe(new n(this), o.f228790a));
            Document r105 = this.f228719c.f228716m;
            b(t0.a(r105.f227873d, r105.L1).subscribe(new p(this.f228719c, this), new q(this)));
            if (NodeType.isShortcut(this.f228719c.f228716m.M1) == false) goto L6;
            b(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().c(this.f228719c.f228716m.f227872c, 25).subscribe(new r(this), s.f228795a));
            return;
        }

        public b(SpaceFolderMoreProvider r100) {
            this.f228719c = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new SpaceFolderMoreProvider$buildMoreItems$1(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        k(new b(this));
    }

    public SpaceFolderMoreProvider(Document r100, String r101, SpaceMoreItemFactory r102) {
        Intrinsics.checkNotNullParameter(r100, "document");
        Intrinsics.checkNotNullParameter(r102, "factory");
        this.f228716m = r100;
        this.f228717n = r101;
        this.f228718o = r102;
    }
}
