package com.bytedance.mira.modifyres;

import android.text.TextUtils;
import com.bytedance.mira.modifyres.apkidentity.V1SignatureIdentity;
import com.bytedance.mira.modifyres.apkidentity.V2V3SignatureIdentity;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ApkIdentityUtils {
    public ApkIdentityUtils() {
    }

    public static String[] getApkIdentitySpeed(File r100) {
        String[] r101 = V2V3SignatureIdentity.getIdentity(r100);
        if (TextUtils.isEmpty(r101[0]) == true) goto L5;
        return r101;
    L5:
        return V1SignatureIdentity.getIdentity(r100);
    }
}
