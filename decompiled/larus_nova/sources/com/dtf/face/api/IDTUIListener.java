package com.dtf.face.api;

import android.app.Activity;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDTUIListener {
    String onAlertCancelButton(String r100);

    String onAlertMessage(String r100);

    String onAlertOKButton(String r100);

    String onAlertTitle(String r100);

    boolean onIsPageScanCloseImageLeft();

    int onPageScanCloseImage();

    boolean onPermissionRequest(Activity r100, List<String> r101, String r102);
}
