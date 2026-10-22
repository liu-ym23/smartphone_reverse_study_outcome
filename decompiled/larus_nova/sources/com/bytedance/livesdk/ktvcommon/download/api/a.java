package com.bytedance.livesdk.ktvcommon.download.api;

import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadState;
import com.bytedance.livesdk.ktvcommon.download.model.MusicType;
import java.util.List;

/* JADX INFO: loaded from: classes20.dex */
public interface a {
    void a(String r100, String r101, DownloadState r102, com.bytedance.livesdk.ktvcommon.download.model.d r103);

    void b(String r100, String r101, String r102, MusicType r103, int r104, DownloadPriority r105);

    void c(String r100, String r101, MusicType r102);

    void d(String r100, String r101, List<com.bytedance.livesdk.ktvcommon.download.model.d> r102, List<com.bytedance.livesdk.ktvcommon.download.model.d> r103);

    void e(String r100, int r101);
}
