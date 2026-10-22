package com.larus.office.base.watermark.common;

import androidx.exifinterface.media.ExifInterface;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
public final class WatermarkLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361235a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/office/base/watermark/common/WatermarkLogger$Path;", "", "<init>", "(Ljava/lang/String;I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B_LOCAL", "B_FILE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Path extends Enum<Path> {
        public static final Path A = null;
        public static final Path B_FILE = null;
        public static final Path B_LOCAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Path[] f361236a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f361237b = null;

        public static EnumEntries<Path> getEntries() {
            return f361237b;
        }

        static {
            Path r100 = new Path(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0);
            A = r100;
            Path r101 = new Path("B_LOCAL", 1);
            B_LOCAL = r101;
            Path r102 = new Path("B_FILE", 2);
            B_FILE = r102;
            Path[] r103 = {r100, r101, r102};
            f361236a = r103;
            f361237b = EnumEntriesKt.enumEntries(r103);
        }

        public static Path[] values() {
            return (Path[]) f361236a.clone();
        }

        public static Path valueOf(String r100) {
            return (Path) a.a(Path.class, r100);
        }

        public Path(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/base/watermark/common/WatermarkLogger$Result;", "", "<init>", "(Ljava/lang/String;I)V", "READY", "DEGRADED", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result DEGRADED = null;
        public static final Result READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f361238a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f361239b = null;

        public static EnumEntries<Result> getEntries() {
            return f361239b;
        }

        static {
            Result r100 = new Result("READY", 0);
            READY = r100;
            Result r101 = new Result("DEGRADED", 1);
            DEGRADED = r101;
            Result[] r102 = {r100, r101};
            f361238a = r102;
            f361239b = EnumEntriesKt.enumEntries(r102);
        }

        public static Result[] values() {
            return (Result[]) f361238a.clone();
        }

        public static Result valueOf(String r100) {
            return (Result) a.a(Result.class, r100);
        }

        public Result(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public WatermarkLogger() {
    }

    public static void a(Path r100, DownloadWatermarkScene r101, Result r102, long r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "result");
        FLogger.f375446a.i("WatermarkLogger", "enterprise_download_watermark_event path=" + r100 + " scene=" + r101.getScene() + " sub_scene=" + r101.getSubScene() + " result=" + r102 + " reason=" + r104 + " duration_ms=" + r103 + " task_id=" + r105);
    }

    public static /* synthetic */ void b(Path r100, DownloadWatermarkScene r110, Result r111, long r112, String r113, String r114, int r115) {
        if ((r115 & 16) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r115 & 32) == 0) goto L9;
        String r102 = null;
    L10:
        a(r100, r110, r111, r112, r101, r102);
        return;
    L9:
        r102 = r114;
        goto L10
    L5:
        r101 = r113;
        goto L7
    }
}
