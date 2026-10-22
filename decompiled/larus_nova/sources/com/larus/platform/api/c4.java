package com.larus.platform.api;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes31.dex */
public interface c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f364880a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f364881a = null;

        static {
            f364881a = new a();
        }

        public a() {
        }

        public static String a() {
            String r100 = AppHost.f326268a.getApplication().getCacheDir().getPath() + "/vesdk";
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
            if (r101.exists() == true) goto L5;
            r101.mkdirs();
        L5:
            return r100;
        }
    }

    public interface b {
        void onError(String r100);

        void onSuccess(boolean r100);
    }

    public interface c {
        void a(int r100, String r101);

        void onCompileDone();

        void onCompileProgress(float r100);
    }

    static {
        f364880a = a.f364881a;
    }

    void a(Integer r100, long r101);
}
