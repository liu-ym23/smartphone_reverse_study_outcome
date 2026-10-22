package com.larus.bmhome.music.save_video;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f313140d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f313141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f313142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f313143c;

    public static final class a {
    }

    static {
        f313140d = r.class.getSimpleName();
    }

    public r(Context r110, q r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "config");
        File r100 = r111.f313129a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "file");
        this.f313141a = r110;
        this.f313142b = r100;
        this.f313143c = new q(r100, 0, 0, null, 0, 0.0f, 0, 0, 1022);
        this.f313143c = r111;
    }
}
