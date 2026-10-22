package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.FileNotFoundException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PushProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    public PushProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.toString().endsWith(".xml") == false) goto L9;
        return "xml";
    L9:
        return null;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r100, String r101) throws FileNotFoundException {
        HMSLog.i("PushProvider", "use sdk PushProvider openFile");
        if ("xml".equals(getType(r100)) == true) goto L5;
        HMSLog.w("PushProvider", "Incorrect file uri");
        throw new FileNotFoundException(r100.getPath());
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        StringBuilder r102 = new StringBuilder();
        Context r103 = getContext();
        Objects.requireNonNull(r103);
        r102.append(r103.createDeviceProtectedStorageContext().getDataDir());
        r102.append("/shared_prefs/push_notify_flag.xml");
        PolarisFileWrapper r104 = new PolarisFileWrapper(r102.toString());
        if (r104.exists() == true) goto L9;
        PolarisFileWrapper r105 = new PolarisFileWrapper(getContext().getDataDir() + "/shared_prefs/push_notify_flag.xml");
        if (r105.exists() == false) goto L21;
        return ParcelFileDescriptor.open(r105, 268435456);
    L21:
        throw new FileNotFoundException(r100.getPath());
    L9:
        return ParcelFileDescriptor.open(r104, 268435456);
    L14:
        String r106 = getContext().getFilesDir() + "";
        if (TextUtils.isEmpty(r106) == true) goto L21;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106.substring(0, r106.length() - 6) + "/shared_prefs/push_notify_flag.xml");
        if (r107.exists() == false) goto L21;
        return ParcelFileDescriptor.open(r107, 268435456);
    }
}
