package ni5;

import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.share.newshare.extension.a<ShareFolderInfo> {
    public final ShareParams c;
    public final ShareFolderInfo d;

    /* JADX INFO: renamed from: ni5.a$a, reason: collision with other inner class name */
    public static final class C0274a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final Object apply(Object r13) {
            ShareFolderPermission r9 = (ShareFolderPermission) r13;
            Intrinsics.checkNotNullParameter(r9, "it");
            a r14 = this.a;
            r14.getClass();
            return new ShareFolderInfo(r14.c.getType(), r14.c.getUrl(), r14.c.getToken(), r14.c.getOwnerUid(), r14.c.getCreateTime(), r14.c.getSpaceId(), r14.c.getOwnerTenantId(), r14.c.getFolderVersion(), r9, 512);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            ShareFolderInfo r5 = (ShareFolderInfo) r4;
            ShareFolderInfo r0 = this.a.b();
            if (r0 == null) goto L5;
            String r2 = this.a.c.getUrl();
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.b = r2;
        L5:
            ShareFolderInfo r1 = this.a.b();
            if (r1 == null) goto L8;
            String r3 = this.a.c.getToken();
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r1.c = r3;
        L8:
            ShareFolderInfo r6 = this.a.b();
            if (r6 == null) goto L11;
            String r7 = this.a.c.getOwnerUid();
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r6.d = r7;
        L11:
            ShareFolderInfo r8 = this.a.b();
            if (r8 == null) goto L14;
            String r9 = this.a.c.getCreateTime();
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r8.e = r9;
        L14:
            ShareFolderInfo r10 = this.a.b();
            if (r10 == null) goto L17;
            String r11 = this.a.c.getSpaceId();
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r10.f = r11;
        L17:
            ShareFolderInfo r12 = this.a.b();
            if (r12 == null) goto L20;
            String r13 = this.a.c.getOwnerTenantId();
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            r12.g = r13;
        L20:
            ShareFolderInfo r14 = this.a.b();
            if (r14 == null) goto L23;
            FolderVersion r15 = this.a.c.getFolderVersion();
            Intrinsics.checkNotNullParameter(r15, "<set-?>");
            r14.h = r15;
        L23:
            ShareFolderInfo r16 = this.a.b();
            if (r16 == null) goto L26;
            ShareFolderPermission r17 = r5.i;
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            r16.i = r17;
        L26:
            ShareFolderInfo r18 = this.a.b();
            if (r18 == null) goto L29;
            r18.j = false;
        L29:
            a r19 = this.a;
            r19.c(r19.b());
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.f("FolderShareInfoBehavior", (Throwable) r3, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.extension.a
    public final void a() {
        tt5.a.h("FolderShareInfoBehavior", "create");
        c(this.d);
    }

    public final void d() {
        if (this.c.getFolderVersion().isShareFolderV2() == false) goto L5;
        String r0 = this.c.getToken();
    L6:
        Disposable r1 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().e(r0, this.c.getFolderVersion(), this.c.isShareRoot()).map(new b(this)).observeOn(fo5.d.d()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullParameter(r1, "<this>");
        this.b.add(r1);
        return;
    L5:
        r0 = this.c.getSpaceId();
        goto L6
    }

    public a(ShareParams r2, ShareFolderInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "initState");
        this.c = r2;
        this.d = r3;
    }
}
