package wj5;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f560013a;

    public v(l r100) {
        this.f560013a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IDocUserPermission r101 = (IDocUserPermission) r100;
        tt5.a.h("DocShortcutMoreInfoBehavior", "shortcutUserPermissionFlow ok. ");
        oj5.a r102 = this.f560013a.c();
        if (r102 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "shortcutPermission");
        r102.f523548s = r101;
    L5:
        l r103 = this.f560013a;
        r103.e(r103.c());
    }
}
