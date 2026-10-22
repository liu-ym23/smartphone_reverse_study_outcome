package com.larus.dora.impl.log.g;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.util.t0;
import java.io.File;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes27.dex */
public final class f extends t0 {
    public f() {
    }

    @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r110, int r111, int r112) {
        super.onDoraLinkStateChanged(r110, r111, r112);
        g49.d.d("DoraGLogManager", "onDoraLinkStateChanged device " + r110 + ", prevState " + r111 + ", state " + r112);
        if (r110 != null) goto L6;
        return;
    L6:
        if (r112 == 0) goto L12;
        if (r112 == 1) goto L12;
        if (r112 == 3) goto L12;
        return;
    L12:
        if (r112 != 0) goto L26;
        DoraGLogManager r113 = DoraGLogManager.f336103a;
        long r100 = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7);
        File[] r114 = new PolarisFileWrapper(r113.o()).listFiles();
        if (r114 == null) goto L26;
        int r101 = r114.length;
        int r102 = 0;
    L16:
        if (r102 >= r101) goto L26;
        File r103 = r114[r102];
        if (r103.isFile() == false) goto L25;
        if (r103.lastModified() >= r100) goto L25;
        if (r103.delete() == false) goto L24;
        g49.d.d("DoraGLogManager", "delete log file " + r103.getAbsolutePath() + " success");
        goto L25
    L24:
        g49.d.b("DoraGLogManager", "delete log file " + r103.getAbsolutePath() + " failed");
    L25:
        r102 = r102 + 1;
    L26:
        DoraGLogManager.f336103a.v(false);
        DoraGLogManager.f336104b = 0;
        ScheduledFuture<?> r115 = DoraGLogManager.f336115m;
        if (r115 == null) goto L35;
        r115.cancel(true);
        return;
    }
}
