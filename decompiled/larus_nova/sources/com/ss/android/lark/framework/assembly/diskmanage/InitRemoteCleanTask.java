package com.ss.android.lark.framework.assembly.diskmanage;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.o0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class InitRemoteCleanTask extends AsyncLaunchTask {
    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final int c() {
        return 20;
    }

    public InitRemoteCleanTask() {
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [com.ss.android.lark.framework.assembly.diskmanage.DiskManageProvider$performRemoteClean$1, java.lang.Object] */
    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r110) {
        AtomicBoolean r100 = c.f425632a;
        c.b.f425633a.getClass();
        if (c.f425632a.get() == true) goto L5;
        c.a();
    L5:
        cbb.d r101 = c.b();
        if (o0.a(LarkContext.getApplication()) == false) goto L8;
        final String r102 = "key_disk_main_remote_clean_date";
    L9:
        Log.i("DiskManageProvider", "try perform remote clean");
        final long r103 = System.currentTimeMillis();
        long r104 = r101.f23126a.f23120a * ((long) 1000);
        long r111 = eac.a.a().getLong(r102, 0);
        if (r111 != 0) goto L13;
        eac.a.a().putLong(r102, r103);
        Log.i("DiskManageProvider", "first launch, clean skipped");
    L16:
        if (eac.a.a().getBoolean("has_deleted_old_cache_file", false) == true) goto L23;
        eac.a.a().putBoolean("has_deleted_old_cache_file", true);
        ArrayList r105 = new ArrayList();
        r105.add(new PolarisFileWrapper(l.b(r110) + "/log/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/crashLog/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/nativeCrash/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/zip/"));
        r105.add(new PolarisFileWrapper(l.a(r110) + "/rich_text/"));
        r105.add(new PolarisFileWrapper(com.ss.android.lark.diskmanage.storage.d.k(r110) + "/docs/"));
        r105.add(new PolarisFileWrapper(l.a(r110) + "/video_thumb_cache/"));
        r105.add(new PolarisFileWrapper(l.c(r110) + "/so_decompressed/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/picture/rust/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/MediaCover/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/download/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/audio/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/update/"));
        r105.add(new PolarisFileWrapper(l.c(r110) + "/zip/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/share_temp/"));
        r105.add(new PolarisFileWrapper(l.b(r110) + "/span"));
        Iterator r112 = r105.iterator();
    L19:
        if (r112.hasNext() == false) goto L29;
        File r106 = (File) r112.next();
        if (r106.exists() == false) goto L19;
        fbb.a.a(r106);
        goto L19
    L29:
        return;
    L23:
        return;
    L13:
        if ((Math.abs(r103 - r111) - r104) <= 0) goto L16;
        Log.i("DiskManageProvider", "startRemoteClean, key: " + r102 + ", lastTime: " + r111);
        int r107 = ebb.b.f471973c;
        ebb.b r108 = ebb.b.C5764b.f471976a;
        ?? r109 = new DiskManageProvider$performRemoteClean$1(r102, r103);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r101, "remoteConfig");
        Intrinsics.checkNotNullParameter(r109, "callback");
        r108.f471975b.execute(new ebb.c(r108, r101, r109));
        goto L16
    L8:
        r102 = "";
        goto L9
    }
}
