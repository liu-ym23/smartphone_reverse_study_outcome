package wj;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.common.utility.Logger;
import com.bytedance.lynx.service.model.b;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements IECLynxCardLifeCycle {
    public a() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void createViewDuration(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(b r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRuntimeReady() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetupPref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingUpdatePref(k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r100, long r101) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onFirstScreen() {
        Logger.d("ECLynxCardDebugActivity", "lynx scheme first screen");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
        Logger.d("ECLynxCardDebugActivity", "lynx card load success");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
        Logger.d("ECLynxCardDebugActivity", "lynx card load failed: " + r102);
    }
}
