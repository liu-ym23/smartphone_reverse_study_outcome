package gh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh5.b f481280a;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // gh5.a
    public final ArrayList<UserInfo> C1() {
        return this.f481280a.getSelected();
    }

    public c(dh5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserModel");
        this.f481280a = r100;
    }

    @Override // gh5.a
    public final void i(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        this.f481280a.removeUser(r100);
    }

    @Override // gh5.a
    public final void registerChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f481280a.registerChangeListener(r100);
    }

    @Override // gh5.a
    public final void unregisterChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f481280a.unregisterChangeListener(r100);
    }
}
