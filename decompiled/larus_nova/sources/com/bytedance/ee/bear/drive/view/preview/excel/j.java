package com.bytedance.ee.bear.drive.view.preview.excel;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f224853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f224854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y75.b f224855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExcelMeta f224856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f224857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DriveFilePath f224858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q75.a f224859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f224860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ExcelCacheHelper f224861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a95.a f224862j;

    public interface a {
        void a(y75.b r100);
    }

    public j(t r100, Context r101, a r102, a95.a r103) {
        this.f224853a = r100;
        this.f224862j = r103;
        this.f224857e = r102;
        Biz r104 = Biz.DRIVE;
        Intrinsics.checkNotNullParameter(r104, "biz");
        Intrinsics.checkNotNullParameter("excelOffline", "relativePath");
        this.f224858f = new DriveFilePath(r104, "excelOffline", "", false);
        this.f224859g = o75.b.a().getDriveConfig();
        this.f224860h = r101;
        this.f224861i = new ExcelCacheHelper();
    }
}
