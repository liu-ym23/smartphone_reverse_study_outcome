package p59;

import com.larus.common_ui.dialog.u;
import com.larus.permission.api.IPermissionX;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPermissionX.c f527861a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        IPermissionX.c r100 = this.f527861a;
        if (r100 == null) goto L6;
        r100.a(false, null);
        return;
    }

    public d(b.C7154b r100) {
        this.f527861a = r100;
    }
}
