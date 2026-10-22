package ew4;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.integrator.ccm.dependency.di.a1;
import com.ss.android.lark.integrator.ccm.dependency.di.b1;
import com.ss.android.lark.integrator.ccm.dependency.di.z0;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.passportc.dwarf.UserScope;

/* JADX INFO: loaded from: classes16.dex */
@UserScope
public interface a0 extends IOfficeSDKProtocol {
    void I(Activity r100, String r101, z0.a r102);

    void J1(Context r100, double r101, double r102, z0.b r103);

    Fragment U1(FragmentActivity r100, String r101, a1 r102);

    Fragment V1(FragmentActivity r100, String r101, q r102);

    void b0(Context r100, String r101, String r102, b1 r103);

    void w1(Context r100, String r101, p r102);

    void x1(Activity r100, String r101, q r102);
}
