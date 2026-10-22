package com.ss.android.lark.storage.file.statistics;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.storage.monitor.MonitorEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends MonitorEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f441031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f441032e;

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final Map<String, Object> c() {
        Map<String, Object> r100 = super.c();
        HashMap r101 = (HashMap) r100;
        r101.put("open_dir", this.f441031d);
        r101.put("path_hash", this.f441032e);
        return r100;
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        Intrinsics.checkNotNullParameter(r101, "pathHash");
        super("infra_unistore_file_global_open", -1);
        this.f441031d = r100;
        this.f441032e = r101;
    }
}
