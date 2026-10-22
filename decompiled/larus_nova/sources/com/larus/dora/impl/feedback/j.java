package com.larus.dora.impl.feedback;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements qk4.n.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<String> f335638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f335639b;

    @Override // qk4.n.c
    public final void a(IOException r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getMessage();
        if (r101 == null) goto L6;
    L7:
        String r102 = "Failed to fetch logs: ".concat(r101);
        pk4.j.c("DoraGFeedbackViewModel", r102, r100);
        kotlinx.coroutines.i<String> r103 = this.f335638a;
        Result.Companion r104 = Result.Companion;
        if (r100 != null) goto L10;
        r100 = new IOException(r102);
    L10:
        r103.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));
        return;
    L6:
        r101 = "Unknown error";
        goto L7
    }

    @Override // qk4.n.c
    public final void onSuccess(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L38;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L14;
        pk4.j.b("DoraGFeedbackViewModel", "Log file path is null or empty");     // Catch: Exception -> L8
        kotlinx.coroutines.i<String> r102 = this.f335638a;     // Catch: Exception -> L8
        Result.Companion r103 = Result.Companion;     // Catch: Exception -> L8
        r102.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Log file path is null or empty"))));     // Catch: Exception -> L8
        return;
    L14:
        pk4.j.d("DoraGFeedbackViewModel", "Temporary log file directory: " + r110);     // Catch: Exception -> L8
        PolarisFileWrapper r104 = new PolarisFileWrapper(r110);     // Catch: Exception -> L8
        if (r104.exists() == true) goto L18;
        String r111 = "Source log file does not exist: " + r110;     // Catch: Exception -> L8
        pk4.j.b("DoraGFeedbackViewModel", r111);     // Catch: Exception -> L8
        kotlinx.coroutines.i<String> r105 = this.f335638a;     // Catch: Exception -> L8
        Result.Companion r106 = Result.Companion;     // Catch: Exception -> L8
        r105.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new FileNotFoundException(r111))));     // Catch: Exception -> L8
        return;
    L18:
        String r112 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());     // Catch: Exception -> L8
        DoraDevice r107 = kj4.a.g().c();     // Catch: Exception -> L8
        if (r107 == null) goto L29;
        String r108 = r107.getSerialNumber();     // Catch: Exception -> L8
        if (r108 == null) goto L29;
        if (r108.length() <= 0) goto L25;
        r100 = true;
    L25:
        if (r100 == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L29;
    L30:
        this.f335639b.f335647e = "DoraG_" + r112 + '_' + r108 + ".zip";     // Catch: Exception -> L8
        PolarisFileWrapper r113 = new PolarisFileWrapper(r104.getParentFile(), this.f335639b.f335647e);     // Catch: Exception -> L8
        if (r104.renameTo(r113) == true) goto L34;
        String r114 = "Failed to rename log file from " + r104.getName() + " to " + this.f335639b.f335647e;     // Catch: Exception -> L8
        pk4.j.b("DoraGFeedbackViewModel", r114);     // Catch: Exception -> L8
        kotlinx.coroutines.i<String> r109 = this.f335638a;     // Catch: Exception -> L8
        Result.Companion r115 = Result.Companion;     // Catch: Exception -> L8
        r109.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(new IOException(r114))));     // Catch: Exception -> L8
        return;
    L34:
        String r116 = r113.getAbsolutePath();     // Catch: Exception -> L8
        pk4.j.d("DoraGFeedbackViewModel", "Log file processed successfully. Path: " + r116);     // Catch: Exception -> L8
        this.f335638a.resumeWith(Result.m9449constructorimpl(r116));     // Catch: Exception -> L8
        return;
    L29:
        r108 = "unknown_sn";
        goto L30
    L38:
    L8:
        e = move-exception;
        pk4.j.c("DoraGFeedbackViewModel", "Error processing log file", e);
        kotlinx.coroutines.i<String> r117 = this.f335638a;
        Result.Companion r118 = Result.Companion;
        r117.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(e)));
        return;
    L5:
        if (r110.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    public j(kotlinx.coroutines.j r100, l r101) {
        this.f335638a = r100;
        this.f335639b = r101;
    }
}
