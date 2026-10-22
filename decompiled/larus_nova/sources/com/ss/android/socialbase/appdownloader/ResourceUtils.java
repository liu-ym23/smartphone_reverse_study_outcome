package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* JADX INFO: loaded from: classes38.dex */
public class ResourceUtils {
    public ResourceUtils() {
    }

    public static int getArrayId(String r100) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, "array", DownloadComponentManager.getAppContext().getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getColorId(String r100) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, "color", DownloadComponentManager.getAppContext().getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getDrawableId(String r100) {
        return getDrawableId(r100, DownloadComponentManager.getAppContext().getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getId(String r100) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, "id", DownloadComponentManager.getAppContext().getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getLayoutId(String r100) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, "layout", DownloadComponentManager.getAppContext().getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getStringId(String r100) {
        return getStringId(DownloadComponentManager.getAppContext(), r100);
    }

    public static int getStyleId(String r100) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, "style", DownloadComponentManager.getAppContext().getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getAttrId(String r100, String r101) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, SlcElement.KEY_ATTR, r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getDrawableId(String r100, String r101) {
        return DownloadComponentManager.getAppContext().getResources().getIdentifier(r100, "drawable", r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getStringId(Context r100, String r101) {
        return r100.getResources().getIdentifier(r101, "string", r100.getPackageName());
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static int getAttrId(Context r100, String r101) {
        getAttrId(r101, r100.getPackageName());     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }
}
