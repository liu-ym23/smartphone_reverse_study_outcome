package com.bytedance.ee.bear;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.DriveManualResponseEntity;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface h {

    public interface a {
        void a(DriveManualResponseEntity r100);
    }

    void C0(String r100);

    Flowable<Boolean> D(int r100, ArrayList<DriveOfflineDoc> r101);

    void D0(Activity r100, String r101, String r102, String r103);

    void E(Activity r100, String r101, String r102, Bundle r103, int r104);

    void G(ArrayList<String> r100);

    void G0(Bundle r100);

    void J0(String r100, String r101, Bundle r102, int r103);

    Flowable<Long> P5(String r100, String r101);

    void W(Context r100, String r101, boolean r102);

    void b();

    void g4(FragmentActivity r100, SpaceThirdPartyOpenEntity r101, Long r102);

    boolean h8(int r100);

    Flowable hc(FragmentActivity r100, SpaceThirdPartyOpenEntity r101, Long r102);

    void j0(List<LocalSaveEntity> r100);

    void j3(boolean r100, pw4.d r101, a r102);

    void m(String r100, String r101, rf5.e r102);

    void m0(ImportFileEntity r100);

    void r(rf5.e r100);

    void r0(String r100, String r101, Bundle r102, int r103);

    void u(Activity r100, String r101, String r102, Bundle r103, int r104);

    boolean z(String r100);
}
