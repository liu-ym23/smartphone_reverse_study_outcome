package com.bytedance.ee.docsdk.impl.utils;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.OfflineResultModel;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import com.ss.android.lark.chameleon.idependency.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/OfflineUtils;", "", "()V", "TAG", "", "closeSafe", "", "closeable", "Ljava/io/Closeable;", "convertString", "inputStream", "Ljava/io/InputStream;", "onJsCallback", "resultModel", "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/OfflineResultModel;", "callBackFunction", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "onJsFailCallback", "errorMsg", WikiFolderPushPlugin.DATA, "onJsSuccessCallback", "callback", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfflineUtils {
    public static final OfflineUtils INSTANCE = null;
    private static final String TAG = "OfflineUtils";

    static {
        INSTANCE = new OfflineUtils();
    }

    private OfflineUtils() {
    }

    public final void closeSafe(Closeable r3) {
        if (r3 == null) goto L13;
        r3.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r0 = e.getMessage();
        if (r0 != null) goto L9;
        r0 = "Unknown error";
    L9:
        Log.e(TAG, r0, e);
        return;
    }

    public final String convertString(InputStream r7) {
        StringBuffer r0 = new StringBuffer();
        Closeable r2 = null;
        if (r7 != null) goto L34;
    L18:
        Log.e(TAG, "convertString()... steam is invalid");     // Catch: Throwable -> L14 IOException -> L16
        String r1 = r0.toString();     // Catch: Throwable -> L14 IOException -> L16
        closeSafe(r7);
        closeSafe(null);
        return r1;
    L34:
    L16:
        e = move-exception;
        BufferedReader r3 = null;
        IOException e = e;
    L21:
        String r4 = e.getMessage();     // Catch: Throwable -> L27
        if (r4 != null) goto L24;
        r4 = "Unknown error";
    L24:
        Log.e(TAG, r4, e);     // Catch: Throwable -> L27
    L25:
        closeSafe(r7);
        closeSafe(r3);
        return r0.toString();
    L27:
        th = th;
        r2 = r3;
    L29:
        closeSafe(r7);
        closeSafe(r2);
        throw th;
    L14:
        th = th;
        goto L29
    L5:
        if (r7.available() <= 0) goto L18;
        r3 = new BufferedReader(new InputStreamReader(r7));     // Catch: Throwable -> L14 IOException -> L16
    L31:
        String r5 = r3.readLine();     // Catch: IOException -> L12 Throwable -> L27
        if (r5 == null) goto L25;
        r0.append(r5 + System.getProperty("line.separator"));     // Catch: IOException -> L12 Throwable -> L27
    L12:
        e = e;
        goto L21
    }

    public final void onJsCallback(OfflineResultModel r11, CallBackFunction r12) {
        Intrinsics.checkNotNullParameter(r11, "resultModel");
        if (r12 != null) goto L6;
        Log.e(TAG, "Callback function is null");
        return;
    L6:
        long r3 = System.currentTimeMillis();
        String r13 = r11.toString();     // Catch: OutOfMemoryError -> L11
        int r6 = r13.length();     // Catch: OutOfMemoryError -> L16
        Log.i(TAG, "resultModelString length: " + r6 + "  cost: " + (System.currentTimeMillis() - r3));     // Catch: OutOfMemoryError -> L15
        r12.onCallBack(r13);     // Catch: OutOfMemoryError -> L15
        Log.i(TAG, "resultModelString done");     // Catch: OutOfMemoryError -> L15
        return;
    L13:
        r12.onCallBack(new OfflineResultModel(false, "", "").toString());
        Log.i(TAG, "onJsCallback out of memory and data: " + r13.substring(0, (int) Math.min(1000.0d, r6)));
        return;
    L12:
        r6 = 0;
    L11:
        r13 = "";
        goto L12
    }

    public final void onJsSuccessCallback(String r4, CallBackFunction r5) {
        Log.d(TAG, "onJsSuccessCallback()...");
        onJsCallback(new OfflineResultModel(true, "", r4), r5);
    }

    public final void onJsFailCallback(String r3, String r4, CallBackFunction r5) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        Log.d(TAG, "onJsFailCallback()... errorMsg = " + r3);
        onJsCallback(new OfflineResultModel(false, r3, r4), r5);
    }
}
