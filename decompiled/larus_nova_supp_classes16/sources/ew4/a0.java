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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public interface a0 extends IOfficeSDKProtocol {
    void I(Activity r1, String r2, z0.a r3);

    void J1(Context r1, double r2, double r4, z0.b r6);

    Fragment U1(FragmentActivity r1, String r2, a1 r3);

    Fragment V1(FragmentActivity r1, String r2, q r3);

    void b0(Context r1, String r2, String r3, b1 r4);

    void w1(Context r1, String r2, p r3);

    void x1(Activity r1, String r2, q r3);
}
