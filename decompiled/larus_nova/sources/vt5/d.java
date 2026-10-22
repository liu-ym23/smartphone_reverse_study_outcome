package vt5;

import com.bytedance.ee.permission.AbsPermissionApiExecutor;
import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi$Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends AbsPermissionApiExecutor<c, UpdatePublicPermissionApi$Result> {
    public d(c r100, ut5.a<UpdatePublicPermissionApi$Result> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        super("UpdatePublicPermissionExecutor", r100, UpdatePublicPermissionApi$Result.class, r101);
    }
}
