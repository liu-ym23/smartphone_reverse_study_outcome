package com.bytedance.ee.bear.drive.services;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.contract.drive.DriveOfflineDoc;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public interface w {

    public interface a {
    }

    public interface b {
    }

    void C0(String r100);

    Flowable<Boolean> D(int r100, ArrayList<DriveOfflineDoc> r101);

    void D0(Activity r100, String r101, String r102, String r103);

    void E(Activity r100, String r101, String r102, Bundle r103, int r104);

    void G(ArrayList<String> r100);

    void G0(Bundle r100);

    void J0(String r100, String r101, Bundle r102, int r103);

    void R0(d0 r100);

    void W(Context r100, String r101, boolean r102);

    void b();

    void i9(String r100, ArrayList<PreviewAction> r101);

    void kb(boolean r100, pw4.d r101, h85.u r102);

    IPlayer l8(Context r100);

    void m(String r100, String r101, rf5.e r102);

    void m0(ImportFileEntity r100);

    Flowable<Boolean> n7();

    void onLoginStatusChangedEvent(int r100);

    void r(rf5.e r100);

    void r0(String r100, String r101, Bundle r102, int r103);

    void u(Activity r100, String r101, String r102, Bundle r103, int r104);
}
