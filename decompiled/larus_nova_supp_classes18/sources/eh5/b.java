package eh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import dh5.c;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements a {
    public final dh5.b a;

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // eh5.a
    public final ArrayList<UserInfo> e() {
        return this.a.getSelected();
    }

    public b(dh5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        this.a = r2;
    }

    @Override // eh5.a
    public final void registerChangeListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }

    @Override // eh5.a
    public final void unregisterChangeListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterChangeListener(r2);
    }
}
