package lr;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.android.ec.host.api.core.api.IECBulletService;
import com.bytedance.android.ecom.service_annotation.ServiceDefaultImpl;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@ServiceDefaultImpl
public final class h implements IECBulletService {
    public h() {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final void closeBulletPanel(String r100) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final ti.d createLiveAnnieComponent(Context r100, String r101, ti.e r102) {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final ti.l createLiveHybridComponent(Context r100, String r101, Map<String, ?> r102, ViewGroup r103, ti.k r104, boolean r105) {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final String getBid() {
        return "";
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final ti.h getBridgeProvider() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final Object getCoreProvider() {
        return null;
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final void injectExternalBridges(Object r100) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final void openSchema(Context r100, String r101, Bundle r102) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final void openWithRifle(Context r100, String r101, Bundle r102) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final void showBulletPanel(Context r100, String r101, JSONObject r102, int r103, int r104, boolean r105, int r106, String r107, boolean r108, boolean r110, JSONObject r111, JSONObject r112, boolean r113, boolean r114, String r115, Function1<? super String, Unit> r116, Function1<? super String, Unit> r117) {
    }

    @Override // com.bytedance.android.ec.host.api.core.api.IECBulletService
    public final ti.c createAnnieCardComponentAndRegisterCrashMonitor(Context r100, ViewGroup r101, String r102, boolean r103, Map<String, ?> r104, ti.b r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(null, "callback");
        return null;
    }
}
