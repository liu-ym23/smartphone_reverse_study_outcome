package rj;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.api.e;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.ec.hybrid.list.util.d;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.b;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a implements IECLynxCardLifeCycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d.a.C0825a f537950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f537951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537952c;

    public a() {
        this(null, 3);
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public void createViewDuration(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
        this.f537951b = null;
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onDestroy");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
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
    public void onFirstScreen() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onFirstScreen");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onLoadStart");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public void onLoadSuccess() {
        e r100 = this.f537951b;
        if (r100 == null) goto L5;
        r100.onLoadSuccess();
    L5:
        Lazy r101 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onLoadSuccess");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public void onRuntimeReady() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onRuntimeReady");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public void onReceivedError(com.bytedance.lynx.service.model.b r100) {
        Lazy r101 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onReceivedError");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public void onTimingSetup(Map<String, ? extends Object> r100) {
        Lazy r101 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(b.d.f47458b, this.f537952c + " onTimingSetup");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        switch(r100.hashCode()) {
            case -1673922063: goto L15;
            case -1655491983: goto L12;
            case -1574764756: goto L9;
            case 1069173657: goto L6;
            default: goto L25;
        };
    L25:
        return;
    L6:
        if (r100.equals(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE) == false) goto L18;
        this.f537950a.f47309b++;
        return;
    L18:
        return;
    L9:
        if (r100.equals(IECLynxCardLifeCycle.ECLynxCardCacheType.GECKO_CACHE) == false) goto L20;
        this.f537950a.f47310c++;
        return;
    L20:
        return;
    L12:
        if (r100.equals(IECLynxCardLifeCycle.ECLynxCardCacheType.KIT_VIEW_CACHE) == false) goto L22;
        this.f537950a.f47308a++;
        return;
    L22:
        return;
    L15:
        if (r100.equals(IECLynxCardLifeCycle.ECLynxCardCacheType.DECODE_CACHE) == false) goto L24;
        this.f537950a.f47311d++;
        return;
    }

    public a(e r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f537951b = r100;
        this.f537952c = r101;
        this.f537950a = new d.a.C0825a(0);
    }

    public /* synthetic */ a(String r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = "ec_lynx_card";
    L5:
        this(null, r100);
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
        e r103 = this.f537951b;
        if (r103 == null) goto L5;
        r103.a(r102);
    L5:
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.b(b.d.f47458b, this.f537952c + " onLoadFailed, type:" + r100 + " code:" + r101 + " msg:" + r102);
    }
}
