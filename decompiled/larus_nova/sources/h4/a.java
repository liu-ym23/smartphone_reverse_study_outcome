package h4;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.ShowActionSheetListener;
import com.bytedance.ai.bridge.system.ui.AbsShowActionSheetMethodIDL;
import com.bytedance.ai.utils.g;
import f3.h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements ShowActionSheetListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f483739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h<AbsShowActionSheetMethodIDL.b> f483740b;

    @Override // com.bytedance.ai.bridge.service.ShowActionSheetListener
    public final void onDismiss() {
        if (this.f483739a.compareAndSet(false, true) == false) goto L6;
        g r100 = g.f37637a;
        StringBuilder r101 = new StringBuilder("call failed, errNo=");
        f3.a r102 = f3.a.f475274o;
        r101.append(r102.f475285a);
        r101.append(", msg=cancel");
        r100.e("AISDK_JSB_ShowActionSheetMethod", r101.toString());
        h.a.a(this.f483740b, "cancel", r102, null, 10);
        return;
    }

    @Override // com.bytedance.ai.bridge.service.ShowActionSheetListener
    public final void onSelect(int r100) {
        if (this.f483739a.compareAndSet(false, true) == false) goto L6;
        g.f37637a.i("AISDK_JSB_ShowActionSheetMethod", "call success, tapIndex=" + r100);
        h<AbsShowActionSheetMethodIDL.b> r101 = this.f483740b;
        Intrinsics.checkNotNullParameter(AbsShowActionSheetMethodIDL.b.class, "<this>");
        BaseModel r102 = k3.c.a(AbsShowActionSheetMethodIDL.b.class);
        ((AbsShowActionSheetMethodIDL.b) r102).setTapIndex(r100);
        h.a.b(r101, (ResultModel) r102);
        return;
    }

    public a(AtomicBoolean r100, h<AbsShowActionSheetMethodIDL.b> r101) {
        this.f483739a = r100;
        this.f483740b = r101;
    }
}
