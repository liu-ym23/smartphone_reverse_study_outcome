package com.obric.sva.sdk.upload;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.assistant.voice.l;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/sva/sdk/upload/XttTokenProvider;", "", "<init>", "()V", "TAG", "", "PROVIDER_REFRESH_RETRY_INTERVAL_MS", "", "lastProviderRefreshAttemptElapsedMs", "getFreshSnapshot", "Lcom/obric/assistant/common/utils/upload/XttTokenSnapshot$Snapshot;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "refreshFromMainProcess", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XttTokenProvider {
    public static final XttTokenProvider INSTANCE = null;
    private static final long PROVIDER_REFRESH_RETRY_INTERVAL_MS = 60000;
    private static final String TAG = "XttTokenProvider";
    private static volatile long lastProviderRefreshAttemptElapsedMs;

    private XttTokenProvider() {
    }

    static {
        INSTANCE = new XttTokenProvider();
        lastProviderRefreshAttemptElapsedMs = -60000;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v4 */
    private final tda.b.a refreshFromMainProcess(ContentProviderClient r110) {
        String r100 = "refreshFromMainProcess empty token/userId tokenEmpty=";
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - lastProviderRefreshAttemptElapsedMs) >= 60000) goto L6;
        LogUtils.i(TAG, "refreshFromMainProcess skipped: retry interval", new Object[0]);
        return new tda.b.a(0);
    L6:
        lastProviderRefreshAttemptElapsedMs = r101;
        Unit r102 = null;
        ContentProviderClient r111 = com_obric_sva_sdk_upload_XttTokenProvider_android_content_ContentResolver_acquireUnstableContentProviderClient(r110.getContentResolver(), l.f394381a);     // Catch: Throwable -> L58 Exception -> L60
        if (r111 != null) goto L15;
        LogUtils.w(TAG, "refreshFromMainProcess skipped: provider client null", new Object[0]);     // Catch: Exception -> L56 Throwable -> L71
        tda.b.a r103 = new tda.b.a(0);     // Catch: Exception -> L56 Throwable -> L71
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L12
    L14:
        return r103;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L15:
        Bundle r105 = r111.call("x-tt-token", null, null);     // Catch: Exception -> L56 Throwable -> L71
        String r106 = "";
        if (r105 == null) goto L19;
        String r107 = r105.getString("data", "");     // Catch: Exception -> L56 Throwable -> L71
    L20:
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        if (r105 == null) goto L24;
        String r108 = r105.getString("uid", "");     // Catch: Exception -> L56 Throwable -> L71
    L25:
        if (r108 == null) goto L28;
        r106 = r108;
    L28:
        boolean r109 = true;
        if (r107.length() != 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L34;
    L42:
        StringBuilder r113 = new StringBuilder("refreshFromMainProcess empty token/userId tokenEmpty=");     // Catch: Exception -> L56 Throwable -> L71
        if (r107.length() != 0) goto L45;
        boolean r114 = true;
    L46:
        r113.append(r114);     // Catch: Exception -> L56 Throwable -> L71
        r113.append(" userIdEmpty=");     // Catch: Exception -> L56 Throwable -> L71
        if (r106.length() == 0) goto L50;
        r109 = false;
    L50:
        r113.append(r109);     // Catch: Exception -> L56 Throwable -> L71
        LogUtils.w(TAG, r113.toString(), new Object[0]);     // Catch: Exception -> L56 Throwable -> L71
        tda.b.a r115 = new tda.b.a(0);     // Catch: Exception -> L56 Throwable -> L71
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L53
        r111.close();     // Catch: Throwable -> L53
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        return r115;
    L53:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L45:
        r114 = false;
        goto L46
    L34:
        if (r106.length() != 0) goto L36;
        boolean r118 = true;
    L37:
        if (r118 == true) goto L42;
        tda.b.b(r107, r106);     // Catch: Exception -> L56 Throwable -> L71
        tda.b.a r119 = tda.b.a();     // Catch: Exception -> L56 Throwable -> L71
        LogUtils.i(TAG, "refreshFromMainProcess success tokenLen=" + r107.length() + " userIdLen=" + r106.length(), new Object[0]);     // Catch: Exception -> L56 Throwable -> L71
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L68
        r111.close();     // Catch: Throwable -> L68
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L68
        tda.b.a r121 = r119;
    L70:
        return r121;
    L36:
        r118 = false;
        goto L37
    L31:
        r112 = false;
        goto L32
    L24:
        r108 = null;
        goto L25
    L19:
        r107 = null;
    L56:
        Exception e100 = e;
    L62:
        LogUtils.e(TAG, "refreshFromMainProcess failed: " + e100.getMessage(), new Object[0]);     // Catch: Throwable -> L71
        tda.b.a r122 = new tda.b.a(0);     // Catch: Throwable -> L71
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L68
        if (r111 == null) goto L66;
        r111.close();     // Catch: Throwable -> L68
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L68
    L66:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L68
        r121 = r122;
        goto L70
    L71:
        Throwable th10 = th;
    L80:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L77
        if (r110 == 0) goto L75;
        r110.close();     // Catch: Throwable -> L77
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L77
    L75:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L77
    L79:
        throw th10;
    L77:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L60:
        e = move-exception;
        e100 = e;
        r111 = null;
    L58:
        th = move-exception;
        th10 = th;
        r110 = 0;
    L68:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r121 = r100;
        goto L70
    }

    public final tda.b.a getFreshSnapshot(Context r110) {
        tda.b.a r100 = tda.b.a();
        long r101 = System.currentTimeMillis();
        boolean r102 = true;
        if (r100.f545533a.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L20;
        return r100;
    L20:
        StringBuilder r105 = new StringBuilder("getFreshSnapshot refresh needed tokenEmpty=");
        if (r100.f545533a.length() != 0) goto L23;
        boolean r106 = true;
    L24:
        r105.append(r106);
        r105.append(" userIdEmpty=");
        if (r100.f545535c.length() == 0) goto L28;
        r102 = false;
    L28:
        r105.append(r102);
        r105.append(" updatedAt=");
        r105.append(r100.f545534b);
        LogUtils.i(TAG, r105.toString(), new Object[0]);
        if (r110 == null) goto L36;
        Context r111 = r110.getApplicationContext();
        if (r111 == null) goto L36;
        return refreshFromMainProcess(r111);
    L36:
        return new tda.b.a(0);
    L23:
        r106 = false;
        goto L24
    L8:
        if (r100.f545535c.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L17;
        long r108 = r100.f545534b;
        if (r108 <= 0) goto L17;
        if ((r101 - r108) > 21600000) goto L17;
        r104 = true;
        goto L18
    L10:
        r107 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    private static ContentProviderClient com_obric_sva_sdk_upload_XttTokenProvider_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
