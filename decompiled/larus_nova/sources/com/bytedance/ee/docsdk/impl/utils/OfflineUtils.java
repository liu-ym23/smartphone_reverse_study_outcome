package com.bytedance.ee.docsdk.impl.utils;

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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/OfflineUtils;", "", "()V", "TAG", "", "closeSafe", "", "closeable", "Ljava/io/Closeable;", "convertString", "inputStream", "Ljava/io/InputStream;", "onJsCallback", "resultModel", "Lcom/bytedance/ee/docsdk/impl/document/plugins/offline/storage/OfflineResultModel;", "callBackFunction", "Lcom/ss/android/lark/chameleon/bridge/CallBackFunction;", "onJsFailCallback", "errorMsg", "data", "onJsSuccessCallback", "callback", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfflineUtils {
    public static final OfflineUtils INSTANCE = null;
    private static final String TAG = "OfflineUtils";

    static {
        INSTANCE = new OfflineUtils();
    }

    private OfflineUtils() {
    }

    public final void closeSafe(Closeable r100) {
        if (r100 == null) goto L13;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r101 = e.getMessage();
        if (r101 != null) goto L9;
        r101 = "Unknown error";
    L9:
        Log.e(TAG, r101, e);
        return;
    }

    public final String convertString(InputStream r100) {
        StringBuffer r101 = new StringBuffer();
        Closeable r102 = null;
        if (r100 != null) goto L34;
    L18:
        Log.e(TAG, "convertString()... steam is invalid");     // Catch: Throwable -> L14 IOException -> L16
        String r103 = r101.toString();     // Catch: Throwable -> L14 IOException -> L16
        closeSafe(r100);
        closeSafe(null);
        return r103;
    L34:
    L16:
        e = move-exception;
        BufferedReader r104 = null;
        IOException e100 = e;
    L21:
        String r105 = e100.getMessage();     // Catch: Throwable -> L27
        if (r105 != null) goto L24;
        r105 = "Unknown error";
    L24:
        Log.e(TAG, r105, e100);     // Catch: Throwable -> L27
    L25:
        closeSafe(r100);
        closeSafe(r104);
        return r101.toString();
    L27:
        th = th;
        r102 = r104;
    L29:
        closeSafe(r100);
        closeSafe(r102);
        throw th;
    L14:
        th = th;
        goto L29
    L5:
        if (r100.available() <= 0) goto L18;
        r104 = new BufferedReader(new InputStreamReader(r100));     // Catch: Throwable -> L14 IOException -> L16
    L31:
        String r106 = r104.readLine();     // Catch: IOException -> L12 Throwable -> L27
        if (r106 == null) goto L25;
        r101.append(r106 + System.getProperty("line.separator"));     // Catch: IOException -> L12 Throwable -> L27
    L12:
        e100 = e;
        goto L21
    }

    public final void onJsCallback(OfflineResultModel r110, CallBackFunction r111) {
        Intrinsics.checkNotNullParameter(r110, "resultModel");
        if (r111 != null) goto L6;
        Log.e(TAG, "Callback function is null");
        return;
    L6:
        long r100 = System.currentTimeMillis();
        String r112 = r110.toString();     // Catch: OutOfMemoryError -> L11
        int r101 = r112.length();     // Catch: OutOfMemoryError -> L16
        Log.i(TAG, "resultModelString length: " + r101 + "  cost: " + (System.currentTimeMillis() - r100));     // Catch: OutOfMemoryError -> L15
        r111.onCallBack(r112);     // Catch: OutOfMemoryError -> L15
        Log.i(TAG, "resultModelString done");     // Catch: OutOfMemoryError -> L15
        return;
    L13:
        r111.onCallBack(new OfflineResultModel(false, "", "").toString());
        Log.i(TAG, "onJsCallback out of memory and data: " + r112.substring(0, (int) Math.min(1000.0d, r101)));
        return;
    L12:
        r101 = 0;
    L11:
        r112 = "";
        goto L12
    }

    public final void onJsSuccessCallback(String r100, CallBackFunction r101) {
        Log.d(TAG, "onJsSuccessCallback()...");
        onJsCallback(new OfflineResultModel(true, "", r100), r101);
    }

    public final void onJsFailCallback(String r100, String r101, CallBackFunction r102) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Log.d(TAG, "onJsFailCallback()... errorMsg = " + r100);
        onJsCallback(new OfflineResultModel(false, r100, r101), r102);
    }
}
