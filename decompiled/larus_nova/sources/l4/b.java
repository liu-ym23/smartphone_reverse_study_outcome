package l4;

import com.bytedance.ai.bridge.service.OnPermissionCallback;
import com.bytedance.ai.bridge.service.PermissionState;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f507308a;

    public b(a r100) {
        this.f507308a = r100;
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionCallback
    public final void onResult(boolean r100, Map<String, ? extends PermissionState> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f507308a.invoke(Boolean.valueOf(r100));
    }
}
