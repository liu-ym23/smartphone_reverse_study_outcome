package com.bytedance.component.lyric;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import jg4.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jg4.e f202988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f202989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jg4.b f202990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jg4.f f202991d;

    public a(Context r100, jg4.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        c r102 = new c(r100);
        d r103 = new d();
        b r104 = new b();
        Intrinsics.checkNotNullParameter(r102, DBDefinition.DOWNLOAD_TABLE_NAME);
        Intrinsics.checkNotNullParameter(r103, "parser");
        Intrinsics.checkNotNullParameter(r104, "drawNodeFactory");
        this.f202988a = r102;
        this.f202989b = r103;
        this.f202990c = r104;
        this.f202991d = r101;
    }
}
