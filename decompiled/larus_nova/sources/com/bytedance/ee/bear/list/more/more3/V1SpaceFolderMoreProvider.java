package com.bytedance.ee.bear.list.more.more3;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;
import uc5.t0;

/* JADX INFO: loaded from: classes18.dex */
public final class V1SpaceFolderMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Document f228743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f228744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SpaceMoreItemFactory f228745o;

    public static final class a {
    }

    public final class b extends com.bytedance.ee.bear.more.protocol3.extension.u<oj5.b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ V1SpaceFolderMoreProvider f228746c;

        @Override // com.bytedance.ee.bear.more.protocol3.extension.u
        public final void a() {
            tt5.a.h("V1SpaceFolderMoreProvider", "create.");
            int r100 = t.f228796a;
            V1SpaceFolderMoreProvider r101 = this.f228746c;
            e(t.a(r101.f228743m, r101.f228744n, r101.f228745o.p()));
            int r102 = this.f228746c.f228743m.L1;
            FolderVersion.Companion.getClass();
            if (r102 != 0) goto L8;
            ShareFolderUserPermission r103 = new ShareFolderUserPermission(0, null, null, false, null, 31, null);
            r103.setPermissions(2);
            oj5.b r104 = c();
            if (r104 == null) goto L7;
            r104.f523575t = r103;
        L7:
            e(c());
        L9:
            Document r105 = this.f228746c.f228743m;
            b(t0.a(r105.f227873d, r105.L1).subscribe(new w(this.f228746c, this), new x(this)));
            if (NodeType.isShortcut(this.f228746c.f228743m.M1) == false) goto L13;
            b(((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().c(this.f228746c.f228743m.f227872c, 25).subscribe(new y(this), z.f228803a));
            return;
        L13:
            return;
        L8:
            jg5.j r106 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
            String r107 = this.f228746c.f228743m.f227888m;
            Document r108 = this.f228746c.f228743m;
            b(r106.f(r107, new FolderVersion(r108.L1, r108.T, r108.P1), this.f228746c.f228743m.f227889n).subscribe(new u(this), v.f228798a));
            goto L9
        }

        public b(V1SpaceFolderMoreProvider r100) {
            this.f228746c = r100;
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

    public V1SpaceFolderMoreProvider(Document r100, String r101, SpaceMoreItemFactory r102) {
        Intrinsics.checkNotNullParameter(r100, "document");
        Intrinsics.checkNotNullParameter(r102, "factory");
        this.f228743m = r100;
        this.f228744n = r101;
        this.f228745o = r102;
    }
}
