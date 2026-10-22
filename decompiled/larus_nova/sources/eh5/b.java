package eh5;

import com.bytedance.ee.bear.share.export.UserInfo;
import dh5.c;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh5.b f472655a;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // eh5.a
    public final ArrayList<UserInfo> e() {
        return this.f472655a.getSelected();
    }

    public b(dh5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUserModel");
        this.f472655a = r100;
    }

    @Override // eh5.a
    public final void registerChangeListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f472655a.registerChangeListener(r100);
    }

    @Override // eh5.a
    public final void unregisterChangeListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f472655a.unregisterChangeListener(r100);
    }
}
