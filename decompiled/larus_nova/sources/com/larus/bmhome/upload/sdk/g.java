package com.larus.bmhome.upload.sdk;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import mr9.j;
import mr9.l;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, j> f314834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, gs8.b> f314835b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, l> f314836c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f314837d = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314838a = null;

        static {
            int[] r100 = new int[UploadScene.values().length];
            r100[UploadScene.O_SERVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[UploadScene.O_MOBILE_TMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f314838a = r100;
        }
    }

    static {
        f314834a = new ConcurrentHashMap();
        f314835b = new ConcurrentHashMap();
        f314836c = new ConcurrentHashMap();
        f314837d = new ConcurrentHashMap();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        f314834a.remove(r100);
        f314835b.remove(r100);
        f314836c.remove(r100);
        f314837d.remove(r100);
    }
}
