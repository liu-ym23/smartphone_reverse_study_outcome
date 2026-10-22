package com.volcengine.zeus.activity;

import android.content.Intent;
import android.os.Bundle;
import com.volcengine.zeus.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public class IntentUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Long, WeakReference<Bundle>> f462659a = null;

    public IntentUtils() {
    }

    static {
        f462659a = new HashMap();
    }

    public static void setUseMemory(Intent r100) {
        r100.putExtra("zeus_use_memory", System.currentTimeMillis());
    }

    public static void a(Intent r100, String r101) {
        long r102 = r100.getLongExtra("zeus_use_memory", 0);
        if (Zeus.getPlugin(r101).mUseMemoryForActivityIntent == false) goto L8;
        if (r102 != 0) goto L8;
        r102 = System.currentTimeMillis();
    L8:
        if (r102 == 0) goto L11;
        Bundle r103 = r100.getExtras();
        r100.replaceExtras(null);
        f462659a.put(Long.valueOf(r102), new WeakReference(r103));
        r100.putExtra("zeus_use_memory", r102);
        return;
    }
}
