package com.larus.cdm.impl;

import android.os.Build;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.keva.Keva;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import oy8.a;
import oy8.b;
import py8.h;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0012\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002J\u0012\u0010#\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'H\u0016J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0018\u0010+\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0015H\u0002J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u0004\u0018\u00010\u000fJ\u001d\u00102\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0015H\u0000¢\u0006\u0002\b4R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/cdm/impl/FlowCompanionDeviceManagerDelegate;", "Lcom/larus/cdm/IFlowCompanionDeviceManager;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/cdm/FlowCompanionDeviceAppearListener;", "observingRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "flowCdmCompat", "Lcom/larus/cdm/impl/FlowCDMCompat;", "KEY_BOUND_SNS", "", "deviceInfoProvider", "Lcom/larus/cdm/DeviceInfoProviderInterface;", "config", "", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/cdm/FlowCompanionDeviceConfigProvider;", "companionDeviceSupport", "", "createAssociator", "Lcom/larus/cdm/IFlowCompanionDeviceAssociator;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/activity/ComponentActivity;", "hasAssociated", "macAddress", "isDeviceBound", "sn", "addBoundSn", "getBoundSns", "", "removeBoundSn", "removeAllBoundSn", "disassociate", "getAssociatedDevices", "", "hasObservedPresence", "startObservingPresence", "stopObservingPresence", "saveObservingState", "state", "addGlobalAppearListener", "listener", "removeGlobalAppearListener", "setDeviceInfoProvider", "getDeviceInfoProvider", "notifyDeviceStateChange", "isAppeared", "notifyDeviceStateChange$impl_release", "impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCompanionDeviceManagerDelegate implements IFlowCompanionDeviceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowCompanionDeviceManagerDelegate f323894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f323895b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Keva f323896c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final py8.b f323897d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f323898e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f323899f;

    private FlowCompanionDeviceManagerDelegate() {
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void h(DoraServiceImpl.h r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
    }

    static {
        f323894a = new FlowCompanionDeviceManagerDelegate();
        f323895b = new CopyOnWriteArrayList();
        f323896c = Keva.getRepo("flow_cdm_manager_observing");
        f323897d = h.a(AppHost.f326268a.getApplication());
        f323898e = "bound_device_sns";
    }

    public static Set p() {
        Set<String> r100 = f323896c.getStringSet(f323898e, new LinkedHashSet());
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new LinkedHashSet();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final List<String> l() {
        return f323897d.e();
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean n() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void f() {
        Set<String> r100 = p();
        r100.clear();
        f323896c.storeStringSet(f323898e, r100);
        FLogger.f375446a.i("flow_cdm", "SN Saved locally: set: " + r100 + ' ');
    }

    public static void o(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        Set<String> r102 = p();
        r102.add(r100);
        f323896c.storeStringSet(f323898e, r102);
        FLogger.f375446a.i("flow_cdm", "SN Saved locally: " + r100);
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        f323897d.a(r100);
        if (b(r100) == true) goto L6;
        f323896c.storeBoolean(r100, false);
        return;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        if (Build.VERSION.SDK_INT >= 31) goto L6;
        FLogger.f375446a.i("flow_cdm", "[hasAssociated] api level not support");
        return false;
    L6:
        boolean r101 = f323897d.b(r100);
        FLogger.f375446a.d("flow_cdm", "[hasAssociated] " + r101 + ' ');
        return r101;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean c(String r100) {
        boolean r101 = CollectionsKt.contains(p(), r100);
        FLogger.f375446a.d("flow_cdm", "[isDeviceBound] SN:" + r100 + " -> " + r101);
        return r101;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        FLogger r101 = FLogger.f375446a;
        r101.i("flow_cdm", "stopObservingPresence " + r100.substring(0, RangesKt.coerceAtMost(8, r100.length())));
        if (Build.VERSION.SDK_INT >= 31) goto L13;
        r101.i("flow_cdm", "[stopObservingPresence] no cdm");
        return;
    L13:
        f323897d.d(r100);     // Catch: Throwable -> L8
        boolean r102 = true;
    L10:
        if (r102 == false) goto L15;
        f323896c.storeBoolean(r100, false);
        return;
    L15:
        return;
    L8:
        th = move-exception;
        FLogger.f375446a.i("flow_cdm", "stopObservingDevicePresence failed: " + th);
        r102 = false;
        goto L10
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void e(DoraServiceImpl.i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f323895b.add(r100);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("startObservingPresence ");
        boolean r103 = false;
        r102.append(r100.substring(0, RangesKt.coerceAtMost(8, r100.length())));
        r101.i("flow_cdm", r102.toString());
        if (Build.VERSION.SDK_INT >= 31) goto L14;
        r101.i("flow_cdm", "[startObservingPresence] no cdm");
        return;
    L14:
        f323897d.f(r100);     // Catch: Throwable -> L9
        r101.i("flow_cdm", "startObservingDevicePresence -> " + b(r100));     // Catch: Throwable -> L9
        r103 = true;
    L11:
        if (r103 == false) goto L16;
        f323896c.storeBoolean(r100, true);
        return;
    L16:
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.i("flow_cdm", "startObservingDevicePresence failed: " + th);
        goto L11
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void i(DoraServiceImpl.f r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        f323899f = r100;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final FlowCompanionDeviceAssociatorImpl j(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        return new FlowCompanionDeviceAssociatorImpl(r100);
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final void k(String r100) {
        Set<String> r101 = p();
        if (CollectionsKt.contains(r101, r100) == false) goto L6;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);
        f323896c.storeStringSet(f323898e, r101);
        FLogger.f375446a.i("flow_cdm", "SN Removed locally: " + r100);
        return;
    }

    @Override // com.larus.cdm.IFlowCompanionDeviceManager
    public final boolean m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        return f323896c.getBoolean(r100, false);
    }

    public static void q(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "macAddress");
        Iterator<b> r102 = f323895b.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        b r103 = r102.next();
        if (r101 == false) goto L8;
        r103.a(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        FLogger.f375446a.i("flow_cdm", "notifyDeviceStateChange failed: " + th);
        goto L4
    L8:
        r103.b(r100);     // Catch: Throwable -> L10
        goto L4
    }
}
