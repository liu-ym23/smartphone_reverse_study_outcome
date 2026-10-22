package com.bytedance.upc.cache;

import android.content.Context;
import com.bytedance.upc.common.ICommonBusinessService;
import com.bytedance.upc.common.thread.ThreadPlus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class ApiHookRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f272434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f272435b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Calendar f272436c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ApiHookRecord f272437d = null;

    public ApiHookRecord() {
    }

    static {
        f272437d = new ApiHookRecord();
        f272434a = SetsKt.setOf(new String[]{"IMEI", "DEVICE_ID", "IMSI", "OAID", "MAC_ADDRESS", "ANDROID_ID"});
        Locale r100 = Locale.US;
        f272435b = new SimpleDateFormat("yyyyMMdd", r100);
        f272436c = Calendar.getInstance(r100);
    }

    public static final ApiMultiProcessSharedProvider.b a() {
        Context r100 = f272437d.getContext();     // Catch: Throwable -> L14
        String r101 = ApiMultiProcessSharedProvider.f272438e;     // Catch: Throwable -> L14
        monitor-enter(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L6:
        if (ApiMultiProcessSharedProvider.f272441h != null) goto L8;
        ApiMultiProcessSharedProvider.f272441h = new ApiMultiProcessSharedProvider.b(r100);     // Catch: Throwable -> L11
    L8:
        ApiMultiProcessSharedProvider.b r102 = ApiMultiProcessSharedProvider.f272441h;     // Catch: Throwable -> L11
        monitor-exit(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L14
        return r102;
    L14:
        return null;
    }

    private final Context getContext() {
        return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
    L4:
        return null;
    }

    public static final String b(String r100, String r101) {
        return "count#" + r100 + '#' + r101;
    }

    public static final String c(String r100, String r101) {
        return "value#" + r100 + '#' + r101;
    }

    public static void d(final int r100, final Function1 r101) {
        Lazy r102 = ThreadPlus.f272474a;
        ThreadPlus.a(ApiHookRecord$tryDeleteExpireData$1.INSTANCE);
        ThreadPlus.a(new ApiHookRecord$getApiRecord$1(r100, r101));
    }

    public static void e(final String r100, final String r101) {
        Lazy r102 = ThreadPlus.f272474a;
        ThreadPlus.a(ApiHookRecord$tryDeleteExpireData$1.INSTANCE);
        ThreadPlus.a(new ApiHookRecord$updateApiRecord$1(r100, r101));
    }
}
