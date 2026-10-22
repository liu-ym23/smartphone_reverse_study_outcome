package fh5;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.GetUserGroupResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.Flowable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements fh5.a {
    public final dh5.b a;

    public static final class a {
    }

    static {
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // fh5.a
    public final ArrayList<UserInfo> e() {
        return this.a.getSelected();
    }

    @Override // fh5.a
    public final Flowable<GetUserGroupResult> g7() {
        NetService.f r0 = new NetService.f("/space/api/suite/platform/visible_group/");
        r0.b("scene_type", "1");
        if (c.a.a.g("ccm.permission.web.user_group") == false) goto L6;
        r0.b("group_type", "0");
    L6:
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new hh5.a()).a(r0);
    }

    public b(dh5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        this.a = r2;
    }

    @Override // fh5.a
    public final void registerChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }
}
