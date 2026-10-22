package jqc;

import android.view.LayoutInflater;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class b {
    public static void a(LayoutInflater r100) {
        FieldUtils.writeField(r100, "mFactory", null);     // Catch: Throwable -> L5
    L10:
        FieldUtils.writeField(r100, "mFactory2", null);     // Catch: Throwable -> L8
        return;
    L8:
        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        return;
    L5:
        ZeusLogger.w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        goto L10
    }
}
