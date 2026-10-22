package com.bytedance.bdp.appbase.network.request;

import android.content.Context;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.network.BdpNetRequest;
import com.bytedance.bdp.appbase.network.BdpRequestHelper;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpRequestModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, a> f200906a = null;

    static {
        f200906a = new ConcurrentHashMap();
    }

    public static void a(final Context r100, final String r101) {
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        BdpPool.runOnAsyncIfMain(new BdpRequestModule$clean$1(r100, r101));
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static int b(Context r100, BdpNetRequest r101, BdpRequestCallback r102) {
        final int r103 = BdpRequestHelper.INSTANCE.generateRequestId();
        final a r104 = new a(r103, r100, r101, r102);
        f200906a.put(Integer.valueOf(r103), r104);
        BdpPool.execute(BdpTask.TaskType.IO, new BdpRequestModule$queue$1(r104, r103));
        return r103;
    }
}
