package com.bytedance.ugc.glue.app;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ugc.ugcwidget.UGCSafeList;
import com.bytedance.ugc.ugcwidget.UGCServiceManager;

/* JADX INFO: loaded from: classes22.dex */
public abstract class UGCRouter {

    public static class Manager {
        public Manager() {
        }

        public boolean openUrl(String r100, Bundle r101) {
            return false;
        }
    }

    public static class UGCRoutersHolder {
        protected final UGCSafeList<UGCRouter> routers;

        public UGCRoutersHolder() {
            this.routers = new UGCSafeList();
        }

        public UGCSafeList<UGCRouter> getRouters() {
            return this.routers;
        }
    }

    public UGCRouter() {
    }

    public abstract boolean openUri(Uri r100, Bundle r101);

    public static void register(UGCRouter r100) {
        ((UGCRoutersHolder) UGCServiceManager.getService(UGCRoutersHolder.class)).routers.add(r100);
    }

    public static boolean handleUri(Uri r100, Bundle r101) {
        return ((Manager) UGCServiceManager.getService(Manager.class)).openUrl(r100.toString(), r101);
    }

    public static boolean handleUrl(String r100, Bundle r101) {
        return ((Manager) UGCServiceManager.getService(Manager.class)).openUrl(r100, r101);
    }
}
