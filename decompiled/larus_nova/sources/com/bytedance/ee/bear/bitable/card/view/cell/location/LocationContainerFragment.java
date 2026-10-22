package com.bytedance.ee.bear.bitable.card.view.cell.location;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import vp4.h;

/* JADX INFO: loaded from: classes15.dex */
public class LocationContainerFragment extends BaseFragment implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BitableLocationViewModel f207886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f207887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f207888g;

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        tt5.a.h("LocationContainerFM", "onBackPressed");
        ActivityResultCaller r100 = this.f207887f;
        if ((r100 instanceof dqb.b) == true) goto L5;
    L7:
        this.f207886e.updateActive(false);
        return true;
    L5:
        if (((dqb.b) r100).i5() == false) goto L7;
        return true;
    }

    public LocationContainerFragment() {
        this.f207887f = null;
        this.f207888g = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        BitableLocationViewModel r101 = (BitableLocationViewModel) q.a(this, BitableLocationViewModel.class);
        this.f207886e = r101;
        r101.updateActive(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [vp4.h] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        super.onViewCreated(r110, r111);
        Bundle r112 = getArguments();
        if (r112 != null) goto L6;
        tt5.a.h("LocationContainerFM", "bundle == null");
        onBackPressed();
        return;
    L6:
        this.f207888g = r112.getBoolean(BytedCertConstant.IntentKey.VIEW_TYPE);
        String r113 = r112.getString("location_key");
        if ("showLocation".equals(r113) == false) goto L32;
        PoiInfo r114 = this.f207886e.getPoiInfo().getValue();
        if (r114 != null) goto L12;
        onBackPressed();
        tt5.a.h("LocationContainerFM", "showLocation info == null");
        return;
    L12:
        if (TextUtils.isEmpty(r114.getName()) == false) goto L14;
        String r100 = r114.getFullAddress();
    L15:
        String r101 = r100;
        if (TextUtils.isEmpty(r114.getAddress()) == false) goto L18;
        String r102 = r114.getFullAddress();
    L19:
        String r103 = r102;
        if (this.f207888g == false) goto L22;
        String r104 = "LARK-PSDA-bitable_form_location_cell_showAddress";
    L23:
        Token r105 = new Token(r104);
        wb5.c r115 = new wb5.c(r101, r103, r114.getLatitude(), r114.getLongitude());
        Fragment r116 = ((r) org.koin.java.a.a(r.class)).a(getActivity(), r105, r115);
        if (r116 != null) goto L26;
        tt5.a.h("LocationContainerFM", "showLocation fragment == null");
        onBackPressed();
        return;
    L26:
        this.f207887f = r116;
        FragmentTransaction r117 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r117, r116, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.location_container) == true) goto L30;
        r117 = r117.replace(R.id.location_container, r116);
    L30:
        r117.commit();
        this.f207886e.updatePoiInfo(null);
        return;
    L22:
        r104 = "LARK-PSDA-bitable_card_location_cell_showAddress";
        goto L23
    L18:
        r102 = r114.getAddress();
        goto L19
    L14:
        r100 = r114.getName();
        goto L15
    L32:
        if ("mapGetLocation".equals(r113) == true) goto L34;
        tt5.a.h("LocationContainerFM", "type is illegal");
        return;
    L34:
        if (this.f207888g == false) goto L36;
        String r106 = "LARK-PSDA-bitable_form_map_location_cell";
    L37:
        Token r118 = new Token(r106);
        Fragment r119 = ((r) org.koin.java.a.a(r.class)).d(getActivity(), r118, new h(this));
        if (r119 != null) goto L40;
        tt5.a.h("LocationContainerFM", "mapGetLocation fragment == null");
        onBackPressed();
        return;
    L40:
        this.f207887f = r119;
        FragmentTransaction r120 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r120, r119, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.location_container) == true) goto L44;
        r120 = r120.replace(R.id.location_container, r119);
    L44:
        r120.commit();
        return;
    L36:
        r106 = "LARK-PSDA-bitable_card_map_location_cell";
        goto L37
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.bitable_location_container_fragment, r101, false);
    }
}
