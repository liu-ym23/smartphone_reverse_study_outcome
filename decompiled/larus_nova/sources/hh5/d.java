package hh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh5.b f485178a;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // hh5.b
    public final ArrayList<UserInfo> e() {
        return this.f485178a.getSelected();
    }

    public d(dh5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserModel");
        this.f485178a = r100;
    }

    @Override // hh5.b
    public final void registerChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f485178a.registerChangeListener(r100);
    }

    @Override // hh5.b
    public final void unregisterChangeListener(dh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f485178a.unregisterChangeListener(r100);
    }
}
