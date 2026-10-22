package com.larksuite.component.blockit;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.sync.BlockSync;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.base.container.api.entity.OPContainerBundle;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.larksuite.component.blockit.a f282973a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f282974a = null;

        static {
            f282974a = new b();
        }
    }

    public b() {
    }

    public final void b() {
        if (this.f282973a != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f282973a != null) goto L8;
        com.larksuite.component.blockit.a r100 = (com.larksuite.component.blockit.a) ClaymoreServiceLoader.loadFirst(com.larksuite.component.blockit.a.class);     // Catch: Throwable -> L10
        Log.i("BlockitInstance", "init block: " + r100);     // Catch: Throwable -> L10
        this.f282973a = r100;     // Catch: Throwable -> L10
        this.f282973a.a();     // Catch: Throwable -> L10
        ry7.a.f539909a = r100;     // Catch: Throwable -> L10
        d r101 = (d) ApiUtils.getApi(d.class);     // Catch: Throwable -> L10
        int r102 = BlockSync.a.f283164a;     // Catch: Throwable -> L10
        r101.g();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    }

    public static OPMonitor a(ncb.b r100, OPContainerBundle r101, BlockEntity r102) {
        OPMonitor r103 = new OPMonitor("op_blockit_event", r100);
        if (r101 == null) goto L14;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r101.f437583a != null) goto L8;
        r101.f437583a = gyb.a.a();     // Catch: Throwable -> L11
    L8:
        OPTrace r104 = r101.f437583a;     // Catch: Throwable -> L11
        monitor-exit(r101);
        r103.tracing(r104).addCategoryValue("host", null).addCategoryValue("container_id", null).addCategoryValue("app_type", "block");
    L14:
        if (r102 == null) goto L16;
        r103.addCategoryValue("app_id", r102.getAppID()).addCategoryValue("application_id", r102.getAppID()).addCategoryValue(BitableResourceData.KEY_BLOCK_ID, r102.getBlockID()).addCategoryValue("block_type_id", r102.getBlockTypeID());
    L16:
        return r103;
    }
}
