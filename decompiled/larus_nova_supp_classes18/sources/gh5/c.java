package gh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements a {
    public final dh5.b a;

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // gh5.a
    public final ArrayList<UserInfo> C1() {
        return this.a.getSelected();
    }

    public c(dh5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        this.a = r2;
    }

    @Override // gh5.a
    public final void i(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.removeUser(r2);
    }

    @Override // gh5.a
    public final void registerChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }

    @Override // gh5.a
    public final void unregisterChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterChangeListener(r2);
    }
}
