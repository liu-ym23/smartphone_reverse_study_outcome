package com.bytedance.ies.argus.base;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f245943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends JSONObject> f245944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArgusReportPlatform f245945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f245947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f245948f;

    public e(int r100) {
        ArgusReportPlatform r101 = ArgusReportPlatform.ONLY_SLARDAR;
        Intrinsics.checkNotNullParameter(r101, "reportPlatform");
        this.f245943a = false;
        this.f245944b = null;
        this.f245945c = r101;
        this.f245946d = null;
        this.f245947e = null;
    }

    public final void a(ArgusReportPlatform r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f245945c = r100;
    }
}
