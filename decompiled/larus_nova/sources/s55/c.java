package s55;

import com.bytedance.ee.bear.drive.biz.preview.more.l;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements gj5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f540736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f540737b;

    @Override // gj5.a
    public final void a(gj5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Toast.cancelLoading();
        PermissionResponse.Companion.getClass();
        PermissionResponse r101 = PermissionResponse.a.a();
        a r102 = a.f540731a;
        e r103 = this.f540736a;
        a.n(r100, r103.f540740c, a.d(r103.f540739b, r103), this.f540736a);
        r101.setAllow(r100.f481503a);
        this.f540737b.a(r101);
    }

    public c(e r100, l r101) {
        this.f540736a = r100;
        this.f540737b = r101;
    }
}
