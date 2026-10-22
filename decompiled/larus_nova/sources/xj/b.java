package xj;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.util.e;
import com.bytedance.android.ec.hybrid.card.util.f;
import com.bytedance.android.ec.hybrid.card.util.k;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements IECLynxCardLifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IECLynxCardLifeCycle f564031a;

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
        IECLynxCardLifeCycle r100 = this.f564031a;
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onFirstScreen() {
        IECLynxCardLifeCycle r100 = this.f564031a;
        if (r100 == null) goto L6;
        r100.onFirstScreen();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
        IECLynxCardLifeCycle r100 = this.f564031a;
        if (r100 == null) goto L6;
        r100.onLoadStart();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
        IECLynxCardLifeCycle r100 = this.f564031a;
        if (r100 == null) goto L6;
        r100.onLoadSuccess();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRuntimeReady() {
        IECLynxCardLifeCycle r100 = this.f564031a;
        if (r100 == null) goto L6;
        r100.onRuntimeReady();
        return;
    }

    public b(IECLynxCardLifeCycle r100) {
        this.f564031a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void createViewDuration(long r100) {
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.createViewDuration(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.onCreateKitViewEnd(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.onReceivedError(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r100) {
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.onTimingSetup(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetupPref(k r100) {
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.onTimingSetupPref(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingUpdatePref(k r100) {
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.onTimingUpdatePref(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        IECLynxCardLifeCycle r101 = this.f564031a;
        if (r101 == null) goto L6;
        r101.useCache(r100);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r100, long r101) {
        IECLynxCardLifeCycle r102 = this.f564031a;
        if (r102 == null) goto L6;
        r102.onTransDataTime(r100, r101);
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        IECLynxCardLifeCycle r103 = this.f564031a;
        if (r103 == null) goto L5;
        r103.onLoadFailed(r100, r101, r102);
    L5:
        int r104 = f.f46602a;
        Intrinsics.checkNotNullParameter(r100, "type");
        com.bytedance.android.ec.hybrid.card.util.a.a(new e(r100, r102));
    }
}
