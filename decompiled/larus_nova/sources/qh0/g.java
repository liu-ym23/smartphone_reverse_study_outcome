package qh0;

import com.bytedance.android.live.liveinteract.plantform.permission.ILinkPermissionCheckerFactoryService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {
    public static final c a(OperateType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "operateType");
        return ((ILinkPermissionCheckerFactoryService) jc1.k.n(ILinkPermissionCheckerFactoryService.class)).createDyliteChecker(r100, r101);
    }
}
