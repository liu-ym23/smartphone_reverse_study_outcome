package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;
import uc5.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class V1SpaceFolderMoreProvider extends BaseMoreProvider {
    public final Document m;
    public final String n;
    public final SpaceMoreItemFactory o;

    public static final class a {
    }

    public final class b extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.b> {
        public final /* synthetic */ V1SpaceFolderMoreProvider c;

        @Override // com.bytedance.ee.bear.more.protocol3.extension.u
        public final void a() {
            tt5.a.h("V1SpaceFolderMoreProvider", "create.");
            int r0 = t.a;
            V1SpaceFolderMoreProvider r1 = this.c;
            e(t.a(r1.m, r1.n, r1.o.p()));
            int r2 = this.c.m.L1;
            FolderVersion.Companion.getClass();
            if (r2 != 0) goto L8;
            ShareFolderUserPermission r3 = new ShareFolderUserPermission(0, null, null, false, null, 31, null);
            r3.setPermissions(2);
            oj5.b r4 = c();
            if (r4 == null) goto L7;
            r4.t = r3;
        L7:
            e(c());
        L9:
            Document r5 = this.c.m;
            b(t0.a(r5.d, r5.L1).subscribe(new w(this.c, this), new x(this)));
            if (NodeType.isShortcut(this.c.m.M1) == false) goto L13;
            b(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().c(this.c.m.c, 25).subscribe(new y(this), z.a));
            return;
        L13:
            return;
        L8:
            jg5.j r6 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
            String r7 = this.c.m.m;
            Document r8 = this.c.m;
            b(r6.f(r7, new FolderVersion(r8.L1, r8.T, r8.P1), this.c.m.n).subscribe(new u(this), v.a));
            goto L9
        }

        public b(V1SpaceFolderMoreProvider r1) {
            this.c = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new V1SpaceFolderMoreProvider$buildMoreItems$1(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        k(new b(this));
    }

    public V1SpaceFolderMoreProvider(Document r2, String r3, SpaceMoreItemFactory r4) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.m = r2;
        this.n = r3;
        this.o = r4;
    }
}
