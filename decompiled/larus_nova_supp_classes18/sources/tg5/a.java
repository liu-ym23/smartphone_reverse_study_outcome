package tg5;

import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements o {
    public final dh5.b a;

    /* JADX INFO: renamed from: tg5.a$a, reason: collision with other inner class name */
    public static final class C0309a {
    }

    static {
    }

    @Override // tg5.o
    public void D1(boolean r1, String r2, EscapeRuleBean r3, vg5.d r4) {
        Intrinsics.checkNotNullParameter(r2, "notes");
        Intrinsics.checkNotNullParameter(r3, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    @Override // tg5.o
    public final boolean r0() {
        boolean r0 = ay4.b.d("permission", 6).getBoolean("WikiContainerKey", true);
        tt5.a.h("BaseInviteMemberManagerModel", "isWikiContainerSelect isSelect=" + r0);
        return r0;
    }

    public void create() {
        tt5.a.h("BaseInviteMemberManagerModel", "create()...");
    }

    public void destroy() {
        tt5.a.h("BaseInviteMemberManagerModel", "destroy()...");
    }

    @Override // tg5.o
    public final ArrayList<UserInfo> e() {
        return this.a.getSelected();
    }

    public a(dh5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        this.a = r2;
    }

    @Override // tg5.o
    public final void N(boolean r3) {
        ay4.b.d("permission", 6).putBoolean("WikiContainerKey", r3);
    }

    @Override // tg5.o
    public final void m7(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.removeUser(r2);
    }
}
