package com.bytedance.livesdk.ktvcommon.download;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import java.util.List;

/* JADX INFO: loaded from: classes20.dex */
public interface c {
    void a(String r100, com.bytedance.livesdk.ktvimpl.base.download.a.C3640a r101);

    void b(String r100, com.bytedance.livesdk.ktvcommon.download.api.a r101);

    List c(String r100, DownloadPriority r101, List r102);

    void d(String r100);

    void release();
}
