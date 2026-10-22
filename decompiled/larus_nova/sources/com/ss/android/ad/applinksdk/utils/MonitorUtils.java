package com.ss.android.ad.applinksdk.utils;

import com.ss.android.ad.applinksdk.core.d;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class MonitorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406394a = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ad/applinksdk/utils/MonitorUtils$MonitorException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "cause", "", "(Ljava/lang/Throwable;)V", "applinksdk_release"}, k = 1, mv = {1, 1, 16})
    public static final class MonitorException extends RuntimeException {
        public MonitorException(Throwable r100) {
            super(r100);
        }
    }

    static {
    }

    public static void a(String r100) {
        Throwable r101 = new Throwable();
        JSONObject r102 = new JSONObject();
        r102.put("msg", r100);
        r102.put("stack", r101.toString());
        d.f406360e.getClass();
        d.b().getClass();
    }

    public static void b(Throwable r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("msg", r101);
        r102.put("stack", r100.toString());
        d.f406360e.getClass();
        d.b().getClass();
    }
}
