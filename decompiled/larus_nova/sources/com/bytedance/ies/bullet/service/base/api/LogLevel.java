package com.bytedance.ies.bullet.service.base.api;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/LogLevel;", "", "D", "V", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel D = null;
    public static final LogLevel E = null;
    public static final LogLevel I = null;
    public static final LogLevel V = null;
    public static final LogLevel W = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f247779a = null;

    public static LogLevel valueOf(String r100) {
        return (LogLevel) a.a(LogLevel.class, r100);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f247779a.clone();
    }

    static {
        LogLevel r100 = new LogLevel("D", 0);
        D = r100;
        LogLevel r101 = new LogLevel("V", 1);
        V = r101;
        LogLevel r102 = new LogLevel("I", 2);
        I = r102;
        LogLevel r103 = new LogLevel(ExifInterface.LONGITUDE_WEST, 3);
        W = r103;
        LogLevel r104 = new LogLevel(ExifInterface.LONGITUDE_EAST, 4);
        E = r104;
        f247779a = new LogLevel[]{r100, r101, r102, r103, r104};
    }

    public LogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
