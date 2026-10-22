package com.ss.android.common.app.permission;

import android.Manifest;
import com.larus.nova.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f407995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f407996c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f407997a;

    static {
        f407995b = null;
        HashMap r100 = new HashMap();
        f407996c = r100;
        r100.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_LOCATION_INFO));
        r100.put("android.permission.RECORD_AUDIO", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_RECORD_AUDIO));
        r100.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_READ_PHONE_STATE));
        r100.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_LOCATION_INFO));
        r100.put("android.permission.READ_SMS", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_SMS));
        r100.put("android.permission.READ_CONTACTS", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_CONTACT));
        r100.put("android.permission.CAMERA", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_CAMERA));
        r100.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_EXTERNAL_STORAGE));
        r100.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.REQUEST_PERMISSION_DESCRIPT_EXTERNAL_STORAGE));
    }

    public d() {
        new HashSet(1);
        this.f407997a = new HashSet(1);
        new ArrayList(1);
        new ArrayList(1);
        new ArrayList();
        monitor-enter(this);
        Field[] r100 = Manifest.permission.class.getFields();     // Catch: Throwable -> L14
        int r101 = r100.length;     // Catch: Throwable -> L14
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L12;
        String r103 = (String) r100[r102].get("");     // Catch: IllegalAccessException -> L9 Throwable -> L14
    L10:
        this.f407997a.add(r103);     // Catch: Throwable -> L14
        r102 = r102 + 1;
    L9:
        r103 = null;
        goto L10
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
