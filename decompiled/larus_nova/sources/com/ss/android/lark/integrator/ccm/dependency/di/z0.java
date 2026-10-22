package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class z0 implements com.bytedance.ee.bear.lark.dependency.r {

    public static final class a implements ew4.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.r.a f427874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f427875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z0 f427876c;

        public a(com.bytedance.ee.bear.lark.dependency.r.a r100, Activity r101, z0 r102) {
            this.f427874a = r100;
            this.f427875b = r101;
            this.f427876c = r102;
        }

        @Override // ew4.p
        public final void a(ew4.o r100) {
            com.bytedance.ee.bear.lark.dependency.r.a r101 = this.f427874a;
            if (r101 == null) goto L10;
            Activity r102 = this.f427875b;
            if (r100 == null) goto L7;
            POIInfo r103 = z0.i(this.f427876c, r100);
        L8:
            r101.a(r102, r103);
            return;
        L7:
            r103 = null;
            goto L8
        }
    }

    public static final class b implements ew4.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.location.service.h.a f427877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z0 f427878b;

        public b(com.ss.android.lark.location.service.h.a r100, z0 r101) {
            this.f427877a = r100;
            this.f427878b = r101;
        }

        @Override // ew4.i
        public final void a(ew4.h r100) {
            if (r100 != null) goto L6;
            com.ss.android.lark.location.service.h.a r101 = this.f427877a;
            if (r101 == null) goto L10;
            r101.a(null);
            return;
        L10:
            return;
        L6:
            com.ss.android.lark.location.service.h.a r102 = this.f427877a;
            if (r102 == null) goto L12;
            POIInfo r103 = new POIInfo();
            this.f427878b.getClass();
            AddressComponent.a r104 = new AddressComponent.a();
            String r105 = r100.f474552a;
            Intrinsics.checkNotNullParameter(r105, DistrictSearchQuery.KEYWORDS_COUNTRY);
            r104.f431166a = r105;
            String r106 = r100.f474553b;
            Intrinsics.checkNotNullParameter(r106, "province");
            r104.f431167b = r106;
            String r107 = r100.f474554c;
            Intrinsics.checkNotNullParameter(r107, "city");
            r104.f431168c = r107;
            String r108 = r100.f474555d;
            Intrinsics.checkNotNullParameter(r108, DistrictSearchQuery.KEYWORDS_DISTRICT);
            r104.f431169d = r108;
            String r109 = r100.f474556e;
            Intrinsics.checkNotNullParameter(r109, "township");
            r104.f431170e = r109;
            String r110 = r100.f474557f;
            Intrinsics.checkNotNullParameter(r110, "neighborhood");
            r104.f431171f = r110;
            String r111 = r100.f474558g;
            Intrinsics.checkNotNullParameter(r111, LocationConstants$NameType.BUILDING);
            r104.f431172g = r111;
            String r112 = r100.f474559h;
            Intrinsics.checkNotNullParameter(r112, "address");
            r104.f431173h = r112;
            r103.setAddressComponent(r104.a());
            r102.a(r103);
            return;
        }
    }

    public static final class c implements ew4.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.location.service.g.a f427879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z0 f427880b;

        public c(com.ss.android.lark.location.service.g.a r100, z0 r101) {
            this.f427879a = r100;
            this.f427880b = r101;
        }

        @Override // ew4.p
        public final void a(ew4.o r100) {
            com.ss.android.lark.location.service.g.a r101 = this.f427879a;
            if (r101 == null) goto L9;
            if (r100 == null) goto L6;
            LarkLocation r102 = z0.h(this.f427880b, r100);
        L7:
            r101.a(r102);
            return;
        L6:
            r102 = null;
            goto L7
        }
    }

    @Inject
    public z0() {
    }

    public static ew4.a0 j() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Application r101 = LarkContext.getApplication();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
        UserSession r102 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r101, com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl((ew4.a0) e0c.k.b(((com.ss.android.lark.passportc.internal.v) e0c.k.a(r101, com.ss.android.lark.passportc.internal.v.class)).c(r102), ew4.a0.class));     // Catch: Throwable -> L4
    L6:
        ew4.u r104 = ew4.u.f474599a;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = r104;
    L10:
        return (ew4.a0) r103;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static String k(Token r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getIdentifier();
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    public static final LarkLocation h(z0 r100, ew4.o r101) {
        r100.getClass();
        LarkLocation r102 = new LarkLocation(new Location(""));
        r102.setLatitude(r101.f474582a);
        r102.setLongitude(r101.f474583b);
        r102.f431175a = r101.f474585d;
        r102.f431176b = r101.f474586e;
        r102.f431177c = r101.f474587f;
        r102.f431178d = r101.f474588g;
        r102.f431179e = r101.f474589h;
        r102.f431180f = r101.f474590i;
        int r103 = r101.f474591j;
        if (r103 != 2) goto L5;
        int r104 = 40100;
    L9:
        r102.f431181g = r104;
        r102.f431183i = r101.f474592k;
        return r102;
    L5:
        if (r103 == 3) goto L7;
        r104 = 0;
        goto L9
    L7:
        r104 = 40400;
        goto L9
    }

    public static final POIInfo i(z0 r100, ew4.o r101) {
        r100.getClass();
        POIInfo r102 = new POIInfo();
        r102.setLatitude(r101.f474582a);
        r102.setLongitude(r101.f474583b);
        r102.setLocationName(r101.f474584c);
        r102.setLocationAddress(r101.f474585d);
        int r103 = r101.f474591j;
        if (r103 != 2) goto L5;
        int r104 = 40100;
    L9:
        r102.setErrorCode(r104);
        r102.setErrorMsg(r101.f474592k);
        return r102;
    L5:
        if (r103 == 3) goto L7;
        r104 = 0;
        goto L9
    L7:
        r104 = 40400;
        goto L9
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final Fragment a(FragmentActivity r110, Token r111, wb5.c r112) {
        Intrinsics.checkNotNullParameter(r111, "token");
        return j().V1(r110, k(r111), new ew4.q(r112.f558990a, r112.f558991b, r112.f558992c, r112.f558993d, r112.f558994e));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final void b(Context r100, Token r101, com.ss.android.lark.location.service.g.a r102) {
        Intrinsics.checkNotNullParameter(r101, "token");
        if (r100 != null) goto L6;
        r102.a(null);
        return;
    L6:
        j().w1(r100, k(r101), new c(r102, this));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final Fragment d(FragmentActivity r100, Token r101, vp4.h r102) {
        Intrinsics.checkNotNullParameter(r101, "token");
        if (r100 != null) goto L7;
        return null;
    L7:
        return j().U1(r100, k(r101), new a1(r102, r100, this));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final void e(Activity r110, Token r111, wb5.c r112) {
        Intrinsics.checkNotNullParameter(r111, "token");
        j().x1(r110, k(r111), new ew4.q(r112.f558990a, r112.f558991b, r112.f558992c, r112.f558993d, r112.f558994e));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final void f(Activity r100, Token r101, com.bytedance.ee.bear.lark.dependency.r.a r102) {
        Intrinsics.checkNotNullParameter(r101, "token");
        if (r100 != null) goto L5;
        return;
    L5:
        j().I(r100, k(r101), new a(r102, r100, this));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final void c(Context r100, double r101, double r110, com.ss.android.lark.location.service.h.a r111) {
        if (r100 != null) goto L5;
        r111.a(null);
        return;
    L5:
        j().J1(r100, r101, r110, new b(r111, this));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.r
    public final void g(Context r100, Token r101, String r102, LocationHelper.d.a r103) {
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.ACCURACY);
        if (r100 != null) goto L6;
        r103.a(null);
        return;
    L6:
        String r104 = "best";
        if (Intrinsics.areEqual(r102, "best") == true) goto L10;
        r104 = "high";
    L10:
        j().b0(r100, k(r101), r104, new b1(r103, this));
    }
}
