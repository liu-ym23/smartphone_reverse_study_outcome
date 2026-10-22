package g4;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionCallback;
import com.bytedance.ai.bridge.service.PermissionState;
import com.bytedance.ai.bridge.system.permission.AbsRequestPermissionMethodIDL;
import f3.h;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements OnPermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h<AbsRequestPermissionMethodIDL.b> f479942a;

    public d(h<AbsRequestPermissionMethodIDL.b> r100) {
        this.f479942a = r100;
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionCallback
    public final void onResult(boolean r100, Map<String, ? extends PermissionState> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        h<AbsRequestPermissionMethodIDL.b> r102 = this.f479942a;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.b.class, "<this>");
        BaseModel r103 = k3.c.a(AbsRequestPermissionMethodIDL.b.class);
        AbsRequestPermissionMethodIDL.b r104 = (AbsRequestPermissionMethodIDL.b) r103;
        if (r100 == false) goto L5;
        AbsRequestPermissionMethodIDL.PermissionStatus r105 = AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED;
    L15:
        r104.setStatus(r105);
        h.a.b(r102, (ResultModel) r103);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r101, "result");
        Iterator<T> r106 = r101.values().iterator();
    L7:
        if (r106.hasNext() == false) goto L11;
        if (((PermissionState) r106.next()) != PermissionState.REJECTED) goto L7;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L14;
        r105 = AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
        goto L15
    L14:
        r105 = AbsRequestPermissionMethodIDL.PermissionStatus.DENIED;
        goto L15
    L11:
        r107 = false;
        goto L12
    }
}
