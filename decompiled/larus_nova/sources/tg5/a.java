package tg5;

import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh5.b f545850a;

    /* JADX INFO: renamed from: tg5.a$a, reason: collision with other inner class name */
    public static final class C7722a {
    }

    static {
    }

    @Override // tg5.o
    public void D1(boolean r100, String r101, EscapeRuleBean r102, vg5.d r103) {
        Intrinsics.checkNotNullParameter(r101, "notes");
        Intrinsics.checkNotNullParameter(r102, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r103, "callback");
    }

    @Override // tg5.o
    public final boolean r0() {
        boolean r100 = ay4.b.d("permission", 6).getBoolean("WikiContainerKey", true);
        tt5.a.h("BaseInviteMemberManagerModel", "isWikiContainerSelect isSelect=" + r100);
        return r100;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void create() {
        tt5.a.h("BaseInviteMemberManagerModel", "create()...");
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public void destroy() {
        tt5.a.h("BaseInviteMemberManagerModel", "destroy()...");
    }

    @Override // tg5.o
    public final ArrayList<UserInfo> e() {
        return this.f545850a.getSelected();
    }

    public a(dh5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserModel");
        this.f545850a = r100;
    }

    @Override // tg5.o
    public final void N(boolean r100) {
        ay4.b.d("permission", 6).putBoolean("WikiContainerKey", r100);
    }

    @Override // tg5.o
    public final void m7(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f545850a.removeUser(r100);
    }
}
