package zt5;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.apply.NoPermission;
import sbb.e;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void F0(FragmentActivity r100, String r101, int r102, String r103, String r104, String r105);

    au5.a P7(FragmentManager r100, int r101, String r102, e r103, String r104, boolean r105, boolean r106, String r107, boolean r108, boolean r110, String r111, String r112, boolean r113, int r114, boolean r115, BearUrl r116);

    void Q0(FragmentActivity r100, String r101, e r102, String r103, String r104, boolean r105, String r106, boolean r107, int r108);

    au5.a Q2(FragmentManager r100, int r101, int r102, boolean r103, int r104, boolean r105, String r106, int r107, String r108, boolean r110, boolean r111, String r112, String r113, String r114, boolean r115, boolean r116, boolean r117, int r118);

    DialogFragment Ud(FragmentActivity r100, String r101, int r102, boolean r103, Runnable r104);

    au5.a Xd(FragmentManager r100, NoPermission r101);

    Fragment d6(FragmentManager r100, String r101, int r102, int r103, boolean r104, Runnable r105);

    void onDestroy();
}
