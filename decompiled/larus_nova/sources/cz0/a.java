package cz0;

import android.view.View;
import bz0.j;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.CompositeListenerUpTo6Args;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.b;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f466013a;

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        this.f466013a.f21841o.b();
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        this.f466013a.f21843q.b();
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        this.f466013a.f21839m.b();
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        this.f466013a.f21828b.b();
    }

    @Override // b7.a, b7.b
    public final void onCardLoadStart() {
        this.f466013a.f21845s.b();
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        this.f466013a.f21830d.b();
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        this.f466013a.f21829c.b();
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadEnd() {
        this.f466013a.f21847u.b();
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadStart() {
        this.f466013a.f21846t.b();
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        this.f466013a.f21842p.b();
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        this.f466013a.f21844r.b();
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        this.f466013a.f21840n.b();
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        this.f466013a.f21838l.b();
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        this.f466013a.f21836j.b();
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        this.f466013a.f21835i.b();
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        this.f466013a.f21832f.b();
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        this.f466013a.f21849w.b();
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        this.f466013a.E.b();
    }

    public a(j r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f466013a = r100;
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        this.f466013a.f21833g.c(new Object[]{r100});
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r100) {
        this.f466013a.f21837k.c(new Object[]{Boolean.valueOf(r100)});
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
        this.f466013a.f21827a.b();
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        this.f466013a.B.c(new Object[]{r100});
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        this.f466013a.f21834h.c(new Object[]{r100, r101});
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        CompositeListenerUpTo6Args<Boolean, Function2<Integer, String, Boolean>> r102 = this.f466013a.D;
        if (r102.f91478a.size() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L23;
        Sequence<Boolean> r104 = r102.d(new Object[]{Integer.valueOf(r100), r101});
        if (r104 == null) goto L25;
        Iterator<Boolean> r105 = r104.iterator();
        if (r105.hasNext() == false) goto L22;
        Boolean r106 = r105.next();
    L16:
        if (r105.hasNext() == false) goto L18;
        boolean r107 = r105.next().booleanValue();
        r106.booleanValue();
        r106 = Boolean.valueOf(r107);
        goto L16
    L18:
        Boolean r108 = r106;
        if (r108 != null) goto L27;
        return false;
    L27:
        return r108.booleanValue();
    L22:
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    L25:
        return false;
    L23:
        return false;
    L5:
        r103 = false;
        goto L6
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f466013a.A.c(new Object[]{Integer.valueOf(r100), r101});
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        this.f466013a.f21852z.c(new Object[]{r100, Boolean.valueOf(r101)});
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "resFrom");
        this.f466013a.f21850x.c(new Object[]{Boolean.valueOf(r100), r101});
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        this.f466013a.f21848v.c(new Object[]{r100, b.a(r101), r102});
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f466013a.f21851y.c(new Object[]{r100, Integer.valueOf(r101), r102});
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        this.f466013a.C.c(new Object[]{r100, r101, r102});
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        this.f466013a.f21831e.c(new Object[]{r100, r101, Boolean.valueOf(r102)});
    }

    @Override // b7.a, b7.b
    public final void onBeforeLoadRequest(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "resType");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f466013a.F.c(new Object[]{r100, r101, b.a(r102), r103});
    }
}
