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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface w {

    public interface a {
    }

    public interface b {
    }

    void C0(String r1);

    Flowable<Boolean> D(int r1, ArrayList<DriveOfflineDoc> r2);

    void D0(Activity r1, String r2, String r3, String r4);

    void E(Activity r1, String r2, String r3, Bundle r4, int r5);

    void G(ArrayList<String> r1);

    void G0(Bundle r1);

    void J0(String r1, String r2, Bundle r3, int r4);

    void R0(d0 r1);

    void W(Context r1, String r2, boolean r3);

    void b();

    void i9(String r1, ArrayList<PreviewAction> r2);

    void kb(boolean r1, pw4.d r2, h85.u r3);

    IPlayer l8(Context r1);

    void m(String r1, String r2, rf5.e r3);

    void m0(ImportFileEntity r1);

    Flowable<Boolean> n7();

    void onLoginStatusChangedEvent(int r1);

    void r(rf5.e r1);

    void r0(String r1, String r2, Bundle r3, int r4);

    void u(Activity r1, String r2, String r3, Bundle r4, int r5);
}
