package n0c;

import com.ss.android.lark.permission.IGetPermissionCallback;
import com.ss.android.lark.permission.StoragePermissionUtils;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class b implements StoragePermissionUtils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetPermissionCallback f516637a;

    public /* synthetic */ b(IGetPermissionCallback r100) {
        this.f516637a = r100;
    }

    @Override // com.ss.android.lark.permission.StoragePermissionUtils.a
    public final void b(StoragePermissionUtils.c r100) {
        IGetPermissionCallback r101 = this.f516637a;
        if (r100.f438547d == false) goto L5;
        r101.onSuccess();
        return;
    L5:
        r101.onError();
    }
}
