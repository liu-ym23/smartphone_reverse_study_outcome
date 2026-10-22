package com.ss.android.lark.storage.file.statistics;

import com.larus.dora.impl.ota.g2.j0;
import com.ss.android.lark.storage.monitor.MonitorEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends MonitorEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f441023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f441024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f441025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f441026g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f441027h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f441028i;

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final boolean b() {
        long r100 = this.f441096b;
        if (1 <= r100) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L16:
        return false;
    L10:
        if (this.f441025f > 0) goto L16;
        if (this.f441026g > 0) goto L16;
        if (this.f441027h >= j0.G2_OTA_SPACE_CHECK_BYTES) goto L16;
        return true;
    L5:
        if (r100 >= 3001) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.ss.android.lark.storage.monitor.MonitorEvent
    public final Map<String, Object> c() {
        Map<String, Object> r100 = super.c();
        HashMap r101 = (HashMap) r100;
        r101.put("file_dir", this.f441028i);
        r101.put("file_api", this.f441023d);
        long r102 = this.f441024e;
        if (r102 <= 0) goto L5;
        r101.put("cost_cipher", Long.valueOf(r102));
    L5:
        long r103 = this.f441025f;
        if (r103 <= 0) goto L8;
        r101.put("cost_migration", Long.valueOf(r103));
    L8:
        long r104 = this.f441024e;
        if (r104 <= 0) goto L11;
        r101.put("cost_cipher", Long.valueOf(r104));
    L11:
        r101.put("cipher_error_code", Integer.valueOf(this.f441026g));
        r101.put("file_size", Long.valueOf(this.f441027h));
        return r100;
    }

    public a(String r100, long r101, long r102, long r103, int r104, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "fileApi");
        Intrinsics.checkNotNullParameter(r111, "fileDir");
        super("infra_unistore_file_access_dev", r101);
        this.f441023d = r100;
        this.f441024e = r102;
        this.f441025f = r103;
        this.f441026g = r104;
        this.f441027h = r110;
        this.f441028i = r111;
    }
}
