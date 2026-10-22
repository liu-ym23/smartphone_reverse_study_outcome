package fqb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location_ui.picklocation.LocationActivity;
import com.ss.android.lark.location_ui.picklocation.LocationFragment;
import com.ss.android.lark.location_ui.picklocation.LocationResponsiveActivity;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f478475a = null;

    static {
        f478475a = new AtomicInteger();
    }

    public static LocationFragment a(POIConfig r100, Token r101, Scene r102, gqb.a r103, boolean r104) {
        LocationFragment r105 = new LocationFragment();
        Bundle r106 = new Bundle();
        String r107 = "location_key_unique" + f478475a.getAndIncrement();
        r106.putBoolean("only_fragment", true);
        r106.putString("location_unique_key", r107);
        r106.putParcelable("location_token", r101);
        r106.putSerializable("scene", r102);
        r106.putBoolean("is_office_sdk", r104);
        hqb.a.a(r107).f486834a = r103;
        r106.putSerializable("location_request_config", r100);
        r105.setArguments(r106);
        return r105;
    }

    public static Intent b(Context r100, POIConfig r101, Token r102, Scene r103, gqb.a r104, boolean r105) {
        Bundle r106 = new Bundle();
        String r107 = "location_key_unique" + f478475a.getAndIncrement();
        r106.putString("location_unique_key", r107);
        hqb.a.a(r107).f486834a = r104;
        r106.putSerializable("location_request_config", r101);
        r106.putParcelable("location_token", r102);
        r106.putSerializable("scene", r103);
        r106.putBoolean("is_office_sdk", r105);
        Intent r108 = new Intent(r100, LocationActivity.class);
        if (ForsetiFGHelpers.d() == false) goto L5;
        r108 = new Intent(r100, LocationResponsiveActivity.class);
    L5:
        r108.putExtras(r106);
        if ((r100 instanceof Activity) == true) goto L8;
        r108.addFlags(268435456);
    L8:
        return r108;
    }

    public static void c(Activity r100, Integer r101, POIConfig r102, Token r103, Scene r110, gqb.a r111, boolean r112, boolean r113) {
        if (r101 != null) goto L4;
        r100.startActivity(b(r100, r102, r103, r110, r111, r113));
        return;
    L4:
        r100.startActivityForResult(b(r100, r102, r103, r110, r111, r113), r101.intValue());
    }
}
