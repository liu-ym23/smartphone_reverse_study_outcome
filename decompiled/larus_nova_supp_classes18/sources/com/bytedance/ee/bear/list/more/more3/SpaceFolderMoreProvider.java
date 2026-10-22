package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;
import uc5.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceFolderMoreProvider extends BaseMoreProvider {
    public final Document m;
    public final String n;
    public final SpaceMoreItemFactory o;

    public static final class a {
    }

    public final class b extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.b> {
        public final /* synthetic */ SpaceFolderMoreProvider c;

        @Override // com.bytedance.ee.bear.more.protocol3.extension.u
        public final void a() {
            tt5.a.h("SpaceFolderMoreProvider", "create.");
            int r0 = t.a;
            SpaceFolderMoreProvider r1 = this.c;
            e(t.a(r1.m, r1.n, r1.o.p()));
            jg5.j r2 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
            String r3 = this.c.m.d;
            Document r5 = this.c.m;
            b(r2.f(r3, new FolderVersion(r5.L1, r5.T, r5.P1), this.c.m.n).subscribe(new n(this), o.a));
            Document r4 = this.c.m;
            b(t0.a(r4.d, r4.L1).subscribe(new p(this.c, this), new q(this)));
            if (NodeType.isShortcut(this.c.m.M1) == false) goto L6;
            b(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().c(this.c.m.c, 25).subscribe(new r(this), s.a));
            return;
        }

        public b(SpaceFolderMoreProvider r1) {
            this.c = r1;
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

    public SpaceFolderMoreProvider(Document r2, String r3, SpaceMoreItemFactory r4) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.m = r2;
        this.n = r3;
        this.o = r4;
    }
}
