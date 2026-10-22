package com.ss.android.ugc.effectmanager.common.utils;

import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.common.model.UrlModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class EffectUtils {
    private static final String TAG = "EffectUtils";

    public EffectUtils() {
    }

    public static boolean isUrlModelEmpty(UrlModel r100) {
        if (r100 != null) goto L4;
    L9:
        return true;
    L4:
        if (r100.getUrlList() == null) goto L9;
        if (r100.getUrlList().isEmpty() == true) goto L9;
        return false;
    }

    public static void setEffectField(String r100, String r101, List<Effect> r102) {
        setEffectField(r100, r101, "", r102);
    }

    public static void setEffectField(String r100, String r101, String r102, List<Effect> r103) {
        if (r103 != null) goto L4;
        return;
    L4:
        Iterator<Effect> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Effect r105 = r104.next();
        StringBuilder r106 = new StringBuilder();
        r106.append(r100);
        String r107 = File.separator;
        r106.append(r107);
        r106.append(r105.getId());
        r106.append(".zip");
        r105.setZipPath(r106.toString());
        r105.setUnzipPath(r100 + r107 + r105.getId());
        r105.setPanel(r101);
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r105.setRecId(r102);
        goto L6
    }
}
