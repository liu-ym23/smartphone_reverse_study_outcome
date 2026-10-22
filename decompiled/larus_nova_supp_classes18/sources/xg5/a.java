package xg5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends tg5.a {
    public final dh5.b b;
    public final FolderPermSetInfo c;
    public Disposable d;

    /* JADX INFO: renamed from: xg5.a$a, reason: collision with other inner class name */
    public static final class C0332a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public b(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.h("FolderInviteMemberManagerModel", "inviteUsers()...succeed");
            ax4.e<InviteResult> r0 = this.a;
            r0.onSuccess((InviteResult) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public c(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.h("FolderInviteMemberManagerModel", "inviteUsers()...error = " + r4.getMessage());
            this.a.onFailed(r4);
        }
    }

    static {
    }

    @Override // tg5.o
    public final void F1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "notificationId");
    }

    @Override // tg5.a
    public final void create() {
        super.create();
        Iterator<T> r0 = this.b.getSelected().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((UserInfo) r0.next()).setPermission(1);
        goto L4
    }

    @Override // tg5.a
    public final void destroy() {
        super.destroy();
        Disposable r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        Disposable r2 = this.d;
        if (r2 == null) goto L13;
        r2.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L7
    }

    public a(dh5.b r2, FolderPermSetInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "permSetInfo");
        super(r2);
        this.b = r2;
        this.c = r3;
    }

    @Override // tg5.o
    public final void c7(boolean r7, boolean r8, String r9, ax4.e<InviteResult> r10) {
        Intrinsics.checkNotNullParameter(r9, "notes");
        Intrinsics.checkNotNullParameter(r10, "callback");
        ArrayList<UserInfo> r1 = this.b.getSelected();
        tt5.a.h("FolderInviteMemberManagerModel", "inviteUsers()...size = " + r1.size() + "}, notify = " + r7);
        if (hu5.a.d(r1) == false) goto L6;
        tt5.a.k("FolderInviteMemberManagerModel", "inviteUser()...users is empty");
        r10.onFailed(new Throwable("empty users"));
        return;
    L6:
        NetService r11 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        boolean r12 = this.c.l.isShareFolderV2();
        int r0 = xh5.c.a;
        if (r12 == false) goto L9;
        si5.b r13 = xh5.a.a;
    L10:
        si5.b r2 = r13;
        FolderPermSetInfo r14 = this.c;
        this.d = r2.d(r1, r7, r9, r14.c, r14.k).subscribe(new b(r10), new c(r10));
        return;
    L9:
        r13 = xh5.d.a;
        goto L10
    }
}
