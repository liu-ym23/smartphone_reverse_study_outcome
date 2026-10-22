package com.bytedance.ee.bear.drive.view.preview.excel;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j {
    public final t a;
    public z b;
    public y75.b c;
    public ExcelMeta d;
    public final a e;
    public final DriveFilePath f;
    public final q75.a g;
    public final Context h;
    public final ExcelCacheHelper i;
    public final a95.a j;

    public interface a {
        void a(y75.b r1);
    }

    public j(t r3, Context r4, a r5, a95.a r6) {
        this.a = r3;
        this.j = r6;
        this.e = r5;
        Biz r7 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r7, "biz");
        Intrinsics.checkNotNullParameter("excelOffline", "relativePath");
        this.f = new DriveFilePath(r7, "excelOffline", "", false);
        this.g = o75.b.a().getDriveConfig();
        this.h = r4;
        this.i = new ExcelCacheHelper();
    }
}
