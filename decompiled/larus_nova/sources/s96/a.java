package s96;

import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.kmp.ec.yata.common.error.d;
import com.bytedance.kmp.ec.yata.common.init.PackYataSdkConfig;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements com.bytedance.kmp.ec.yata.common.error.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EventChain f541118a;

    @Override // com.bytedance.kmp.ec.yata.common.error.a
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    public a(EventChain r100) {
        this.f541118a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.common.error.a
    public final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        boolean r101 = this.f541118a.f251261g;
        r100.getClass();
        r100.m(MapMonitorConst.IS_DESTROYED, String.valueOf(r101));
    }

    @Override // com.bytedance.kmp.ec.yata.common.error.a
    public final void c(Map r100) {
        Intrinsics.checkNotNullParameter("yata_client_sdk_error", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        EventChain r101 = this.f541118a;
        if (r101.f251256b.f251427c == false) goto L5;
        r101.f251255a.f().a("yata_client_sdk_error", r100);
        return;
    L5:
        PackYataSdkConfig r102 = com.bytedance.kmp.ec.yata.common.init.b.a();
        if (r102 == null) goto L10;
        r102.a("yata_client_sdk_error", r100);
        return;
    }
}
