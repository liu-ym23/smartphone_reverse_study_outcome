package hp9;

import com.larus.home.impl.sdk.w0;
import com.larus.permission.api.IPermissionX;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements IPermissionX.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPermissionX.a f486487a;

    @Override // com.larus.permission.api.IPermissionX.c
    public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
    }

    @Override // com.larus.permission.api.IPermissionX.a
    public final void onSettingPageReturn() {
        IPermissionX.a r100 = this.f486487a;
        if (r100 == null) goto L6;
        r100.onSettingPageReturn();
        return;
    }

    public h(w0.e r100) {
        this.f486487a = r100;
    }

    @Override // com.larus.permission.api.IPermissionX.a
    public final void b(String r100) {
        IPermissionX.a r101 = this.f486487a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.larus.permission.api.IPermissionX.a
    public final void a(boolean r100, String r101) {
        IPermissionX.a r102 = this.f486487a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
