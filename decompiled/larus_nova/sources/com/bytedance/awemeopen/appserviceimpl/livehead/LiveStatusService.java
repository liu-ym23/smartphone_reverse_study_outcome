package com.bytedance.awemeopen.appserviceimpl.livehead;

import a24.b;
import a34.a;
import android.os.Looper;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.domain.live.LiveStatusDomain;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class LiveStatusService implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198133a;

    @Override // k24.a
    public final void x0() {
    }

    public LiveStatusService() {
        this.f198133a = LazyKt.lazy(LiveStatusService$liveStatusDomain$2.INSTANCE);
    }

    @Override // a34.a
    public final void A2(List<a24.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "detectItems");
        LiveStatusDomain r101 = (LiveStatusDomain) this.f198133a.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "detectItems");
        if (AoLive.b() == true) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L43;
        ((Number) r101.f198414b.getValue()).longValue();
        AoLiveService r102 = r101.f198413a;
        if (r102 != null) goto L12;
        r102 = (AoLiveService) j64.a.a(AoLiveService.class);
        r101.f198413a = r102;
    L12:
        if (r102 == null) goto L14;
        r102.A1();
    L14:
        List<a24.a> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L16:
        if (r105.hasNext() == false) goto L31;
        a24.a r106 = (a24.a) r105.next();
        Intrinsics.checkNotNullParameter(r106.f1410a, "openId");
        if (AoLive.b() == false) goto L27;
        AoLiveService r107 = r101.f198413a;
        if (r107 != null) goto L24;
        r107 = (AoLiveService) j64.a.a(AoLiveService.class);
        r101.f198413a = r107;
    L24:
        if (r107 == null) goto L27;
        r107.r1();
    L27:
        if (Intrinsics.areEqual("_000hnYM5zOuj8mWQ9jtyaFLi9GMXfkjwOXs", r106.f1410a) == false) goto L29;
        n64.a r108 = new n64.a(r106.f1410a, r106.f1411b);
    L30:
        r104.add(r108);
        goto L16
    L29:
        r108 = new n64.a(r106.f1410a, r106.f1411b);
        goto L30
    L31:
        AoLogger.g("LiveStatusService", new Object[]{"detectLiveStatus: " + r104});
        AoLiveService r109 = r101.f198413a;
        if (r109 != null) goto L35;
        r109 = (AoLiveService) j64.a.a(AoLiveService.class);
        r101.f198413a = r109;
    L35:
        if (r109 == null) goto L41;
        r109.v1();
        return;
    L41:
        return;
    }

    @Override // a34.a
    public final void O2(Observer<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        LiveStatusDomain r101 = (LiveStatusDomain) this.f198133a.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        AoLogger.h("LiveStatusService", new Object[]{"addLiveStatusChangeObserver must be called on UI Thread."});
    L5:
        ((ArrayList) r101.f198415c).add(r100);
    }

    @Override // a34.a
    public final void r0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        LiveStatusDomain r101 = (LiveStatusDomain) this.f198133a.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "openId");
        if (AoLive.b() == false) goto L13;
        AoLiveService r102 = r101.f198413a;
        if (r102 != null) goto L9;
        r102 = (AoLiveService) j64.a.a(AoLiveService.class);
        r101.f198413a = r102;
    L9:
        if (r102 == null) goto L12;
        r102.r1();
        return;
    L12:
        return;
    }

    @Override // a34.a
    public final void s1(Observer<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        LiveStatusDomain r101 = (LiveStatusDomain) this.f198133a.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        AoLogger.h("LiveStatusService", new Object[]{"addLiveStatusChangeObserver must be called on UI Thread."});
    L5:
        ((ArrayList) r101.f198415c).remove(r100);
    }
}
