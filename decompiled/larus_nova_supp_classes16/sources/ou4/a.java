package ou4;

import ax4.e;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.h;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends tg5.a {
    public final dh5.b b;
    public final BitableSharePermSetInfo c;
    public Disposable d;

    /* JADX INFO: renamed from: ou4.a$a, reason: collision with other inner class name */
    public static final class C0268a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e<InviteResult> a;

        public b(e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.h("BitableShareInviteMemberManagerModel", "inviteUsers()...succeed");
            e<InviteResult> r0 = this.a;
            r0.onSuccess((InviteResult) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ e<InviteResult> a;

        public c(e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.h("BitableShareInviteMemberManagerModel", "inviteUsers()...error = " + r4.getMessage());
            this.a.onFailed(r4);
        }
    }

    static {
    }

    public final void create() {
        super.create();
        Iterator r0 = this.b.getSelected().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((UserInfo) r0.next()).setPermission(4);
        goto L4
    }

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

    public final void F1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "notificationId");
        tt5.a.h("BitableShareInviteMemberManagerModel", "sendNotifyRequest()...");
    }

    public a(dh5.b r2, BitableSharePermSetInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "info");
        super(r2);
        this.b = r2;
        this.c = r3;
    }

    public final void c7(boolean r7, boolean r8, String r9, e<InviteResult> r10) {
        Intrinsics.checkNotNullParameter(r9, "notes");
        Intrinsics.checkNotNullParameter(r10, "callback");
        ArrayList r0 = this.b.getSelected();
        tt5.a.h("BitableShareInviteMemberManagerModel", "inviteUsers()...size = " + r0.size() + ", notify = " + r7);
        if (hu5.a.d(r0) == false) goto L6;
        tt5.a.k("BitableShareInviteMemberManagerModel", "inviteUser()...users is empty");
        r10.onFailed(new Throwable("empty users"));
        return;
    L6:
        String r1 = this.c.d.getShareToken();
        int r2 = pu4.a.a;
        Intrinsics.checkNotNullParameter(r1, "shareToken");
        Intrinsics.checkNotNullParameter(r0, "selectedUsers");
        Intrinsics.checkNotNullParameter(r9, "notes");
        NetService.f r11 = new NetService.f("/space/api/bitable/share/permission/members/create");
        JSONObject r12 = new JSONObject();
        r12.put("shareToken", r1);
        JSONArray r3 = new JSONArray();
        Iterator r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        UserInfo r5 = (UserInfo) r4.next();
        JSONObject r6 = new JSONObject();
        r6.put("memberId", r5.getId());
        r6.put("memberType", Integer.valueOf(r5.getOwnerType()));
        r6.put("permission", Integer.valueOf(r5.getPermission()));
        r3.add(r6);
        goto L8
    L10:
        r12.put("members", r3);
        r12.put("notifyLark", Integer.valueOf(r7 ? 1 : 0));
        r11.c = 1;
        r11.j = r12.toJSONString();
        this.d = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new h()).a(r11).subscribe(new b(r10), new c(r10));
    }
}
