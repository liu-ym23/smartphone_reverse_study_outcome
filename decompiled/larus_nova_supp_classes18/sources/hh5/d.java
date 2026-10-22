package hh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements b {
    public final dh5.b a;

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // hh5.b
    public final ArrayList<UserInfo> e() {
        return this.a.getSelected();
    }

    public d(dh5.b r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedUserModel");
        this.a = r2;
    }

    @Override // hh5.b
    public final void registerChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.registerChangeListener(r2);
    }

    @Override // hh5.b
    public final void unregisterChangeListener(dh5.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.unregisterChangeListener(r2);
    }
}
