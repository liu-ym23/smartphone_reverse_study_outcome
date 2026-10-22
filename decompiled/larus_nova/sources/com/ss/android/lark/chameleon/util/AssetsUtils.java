package com.ss.android.lark.chameleon.util;

import android.content.Context;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleon/util/AssetsUtils;", "", "()V", "TAG", "", "readAssetsConfig", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "assetsName", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AssetsUtils {
    public static final AssetsUtils INSTANCE = null;
    private static final String TAG = "AssetsUtils";

    static {
        INSTANCE = new AssetsUtils();
    }

    private AssetsUtils() {
    }

    public final String readAssetsConfig(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "assetsName");
        Context r102 = r100.getApplicationContext();
        if (r102 != null) goto L23;
        Log.e(TAG, "readAssetsConfig fail, context is null");
        return "";
    L23:
        InputStream r103 = r102.getAssets().open(r101);     // Catch: Exception -> L16
        String r104 = TextStreamsKt.readText(new InputStreamReader(r103, StandardCharsets.UTF_8));     // Catch: Throwable -> L11
    L9:
        CloseableKt.closeFinally(r103, null);     // Catch: Exception -> L16
        return r104;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Exception -> L16
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.e(TAG, "readAssetsConfig fail, assetsName is " + r101, e);
        return "";
    }
}
