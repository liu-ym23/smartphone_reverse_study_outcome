package com.lynx.devtoolwrapper;

import android.app.Dialog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public interface OverlayService {
    ArrayList<Integer> getAllVisibleOverlaySign();

    ArrayList<Dialog> getGlobalOverlayView();
}
