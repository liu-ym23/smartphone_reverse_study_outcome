package com.bytedance.ee.bear.bitable.celleditor.editor.location;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.Location;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends com.bytedance.ee.bear.bitable.celleditor.editor.c<LocationEditorModel> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final hr4.a f209412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f209413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f209414f;

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final Class<LocationEditorModel> c() {
        return LocationEditorModel.class;
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b e() {
        return this.f209413e;
    }

    public c(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        super(r100);
        this.f209412d = r100;
        a r101 = new a();
        this.f209413e = r101;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.celleditor.editor.location.LocationEditorActionHandler");
        this.f209414f = new e(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final com.bytedance.ee.bear.bitable.celleditor.editor.g d(CommonEditorModel r100) {
        Intrinsics.checkNotNullParameter((LocationEditorModel) r100, "data");
        return new d(this.f209414f);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.c
    public final void f(String r110, CommonEditorModel r111) {
        LocationEditorModel r112 = (LocationEditorModel) r111;
        Intrinsics.checkNotNullParameter(r112, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (Intrinsics.areEqual(r110, "NativeLocationViewMap") == false) goto L32;
        e r113 = this.f209414f;
        boolean r100 = r112.isInForm();
        Location r114 = r112.getValue();
        r113.getClass();
        if (r114 != null) goto L7;
    L13:
        PoiInfo r115 = null;
    L14:
        if (r115 == null) goto L44;
        if (r100 == false) goto L18;
        Token r101 = e.f209424h;
    L20:
        if (e.a(r115.getLatitude(), r115.getLongitude()) == true) goto L23;
        UDToast.show(r113.f209426a.getContext(), R.string.Bitable_Field_UnableToOpenMap);
        return;
    L23:
        if (TextUtils.isEmpty(r115.getName()) == false) goto L25;
        String r102 = r115.getFullAddress();
    L26:
        String r103 = r102;
        if (TextUtils.isEmpty(r115.getAddress()) == false) goto L29;
        String r104 = r115.getFullAddress();
    L30:
        ((r) org.koin.java.a.c(r.class, null, null, 6)).e(r113.f209426a.f486859a, r101, new wb5.c(r103, r104, r115.getLatitude(), r115.getLongitude(), 0));
        return;
    L29:
        r104 = r115.getAddress();
        goto L30
    L25:
        r102 = r115.getName();
        goto L26
    L18:
        r101 = e.f209425i;
        goto L20
    L44:
        return;
    L7:
        if (hu5.a.d(r114.locations) == true) goto L13;
        Location.LocationItem r116 = (Location.LocationItem) ListProtector.get(r114.locations, 0);
        if (r116 == null) goto L13;
        r115 = r116.getPoiInfo();
        if (r115 == null) goto L14;
        r115.parseLocation();
        goto L14
    L32:
        if (Intrinsics.areEqual(r110, "NativeLocationRelocate") == false) goto L42;
        a r117 = this.f209413e;
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.celleditor.editor.location.LocationEditorActionHandler");
        r117.f(r112.getLocation(), true);
        e r118 = this.f209414f;
        boolean r105 = r112.isInForm();
        b r106 = new b(this, r112);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r106, "callback");
        g r119 = new g(r105, r118, r106);
        Context r107 = r118.f209426a.getContext();
        int r108 = ContextCompat.checkSelfPermission(r107, "android.permission.ACCESS_FINE_LOCATION");
        if (ContextCompat.checkSelfPermission(r107, "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L38;
        if (r108 == 0) goto L38;
        com.ss.android.lark.utils.h.c(r118.f209426a.f486859a, e.f209419c, new f(r119), "android.permission.ACCESS_FINE_LOCATION", m.a(R.string.Bitable_Field_LocationPermissionPopupTitle, R.string.Bitable_Field_LocationPermissionPopupContentAndroid), true, 0, 0);
        return;
    L38:
        r119.onReceiveValue(Boolean.TRUE);
        return;
    }
}
