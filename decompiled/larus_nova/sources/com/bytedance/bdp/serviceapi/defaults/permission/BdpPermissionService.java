package com.bytedance.bdp.serviceapi.defaults.permission;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpPermissionService extends IBdpService {
    boolean hasPermission(Context r100, String r101);

    void requestPermissions(Activity r100, LinkedHashSet<String> r101, b r102);

    void requestPermissions(Activity r100, LinkedHashSet<String> r101, b r102, String r103);

    void requestPermissions(Activity r100, String[] r101, b r102);

    void requestPermissions(Activity r100, String[] r101, b r102, String r103);

    void requestPermissions(Fragment r100, LinkedHashSet<String> r101, b r102);

    void requestPermissions(Fragment r100, LinkedHashSet<String> r101, b r102, String r103);

    void requestPermissions(Fragment r100, String[] r101, b r102);

    void requestPermissions(Fragment r100, String[] r101, b r102, String r103);
}
